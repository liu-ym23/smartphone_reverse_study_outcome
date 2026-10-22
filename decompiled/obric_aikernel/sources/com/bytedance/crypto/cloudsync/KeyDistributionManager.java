package com.bytedance.crypto.cloudsync;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.bridge.IAccountBridge;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.bridge.ITeaBridge;
import com.bytedance.crypto.cloudsync.account.AccountApi;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.cloudsync.network.NetworkManager;
import com.bytedance.crypto.cloudsync.network.NetworkRequest;
import com.bytedance.crypto.cloudsync.network.NetworkResponse;
import com.bytedance.crypto.cloudsync.network.SyncKeyData;
import com.bytedance.crypto.keymanager.AttestKeyManager;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.monitor.NormalEvent;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.crypto.utils.TeaTracker;
import java.security.KeyPair;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyDistributionManager {
    public static final String TAG = "KeyDistributionManager";
    private static volatile KeyDistributionManager keyDistributionManager;

    public KeyDistributionManager() {
    }

    private void broadcastRegister(Context r10) {
        CloudSyncBroadcastReceiver r11 = new CloudSyncBroadcastReceiver();
        IntentFilter r12 = new IntentFilter();
        r12.addAction(CloudSyncBroadcastReceiver.WHITELIST_ACTION);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r10.registerReceiver(r11, r12, CloudSyncBroadcastReceiver.PERMISSION, null, 2);
        return;
    L5:
        r10.registerReceiver(r11, r12, CloudSyncBroadcastReceiver.PERMISSION, null);
    }

    public static KeyDistributionManager getInstance() {
        if (keyDistributionManager != null) goto L15;
        monitor-enter(KeyDistributionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyDistributionManager != null) goto L9;
        keyDistributionManager = new KeyDistributionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(KeyDistributionManager.class);     // Catch: Throwable -> L11
    L15:
        return keyDistributionManager;
    }

    private String getSystemProperty(String r10) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, "unknown"});
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    private int handleKeyDistribution(Context r10, String r11) {
        NetworkRequest r12 = new NetworkRequest();
        r12.setRequestType(CloudConfig.REQUEST_TYPE_POST);
        r12.setRequestUrl(CloudConfig.getGetSyncKeyUrl());
        r12.setRootKeyName(CloudConfig.ROOT_NAME_CLOUD_SYNC);
        ArrayList r13 = new ArrayList();
        r13.add(r11);
        r12.setAppList(r13);
        Bundle r14 = new Bundle();
        r14.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r14.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r14.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY());
        List<Certificate> r15 = AttestKeyManager.getInstance().getAttestCertChain(r10, r11, "", false, r14);
        int r16 = 0;
        if (r15 != null) goto L5;
    L24:
        String r17 = TAG;
        String r18 = "Get attest cert chain failed!!";
    L25:
        LogUtils.e(r17, r18);
    L26:
        r16 = -100;
    L27:
        AttestKeyManager.getInstance().deleteAttestKey(r10, r11);
        LogUtils.i(TAG, "KeyManager import key end, result:" + r16);
        return r16;
    L5:
        if (r15.size() == 0) goto L24;
        r12.setCertChain(CertUtils.certsToPemString(r15, 3));     // Catch: Exception -> L22
        NetworkResponse r19 = NetworkManager.getInstance().callApi(r12, false);
        String r20 = TAG;
        LogUtils.d(r20, "response code:" + r19.getCode());
        LogUtils.d(r20, "response msg:" + r19.getMessage());
        LogUtils.d(r20, "response serverPubKey:" + r19.getServerPubKey());
        Iterator<SyncKeyData> r21 = r19.getKeyDataList().iterator();
    L11:
        if (r21.hasNext() == false) goto L14;
        SyncKeyData r22 = r21.next();
        String r23 = TAG;
        LogUtils.d(r23, "response key app:" + r22.getAppId());
        LogUtils.d(r23, "response key cipher:" + r22.getSyncKeyCipher());
        LogUtils.d(r23, "response key version:" + r22.getKeyVersion());
        goto L11
    L14:
        if (r19.getCode() >= 200) goto L16;
    L21:
        LogUtils.e(TAG, "Network request failed, error code:" + r19.getCode());
        r16 = -21;
        goto L27
    L16:
        if (r19.getCode() >= 300) goto L21;
        if (SyncKeyManager.getInstance().importSyncKey(r10, r19.getKeyDataList(), r19.getServerPubKey(), r11) == true) goto L27;
        r17 = TAG;
        r18 = "KeyManager import key failed!!";
    L22:
        e = move-exception;
        LogUtils.e(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        goto L26
    }

    private int handleKeyDistributionLegacy(Context r10, String r11) {
        NetworkRequest r12 = new NetworkRequest();
        r12.setRequestType(CloudConfig.REQUEST_TYPE_POST);
        r12.setRequestUrl(CloudConfig.getGetSyncKeyUrlLegacy());
        r12.setRootKeyName(CloudConfig.ROOT_NAME_CLOUD_SYNC);
        ArrayList r13 = new ArrayList();
        r13.add(r11);
        r12.setAppList(r13);
        KeyPair r14 = CryptoUtils.generateECCKeyPair();     // Catch: Exception -> L21
        byte[] r15 = CryptoUtils.parseECCPublicKey(r14.getPublic().getEncoded());     // Catch: Exception -> L21
        String r16 = TAG;     // Catch: Exception -> L21
        LogUtils.d(r16, "pubKey len:" + r15.length);     // Catch: Exception -> L21
        LogUtils.d(r16, "pubKey:" + CryptoUtils.byteArrayToHexString(r15));     // Catch: Exception -> L21
        byte[] r17 = CryptoUtils.parseEccPrivateKey(r14.getPrivate().getEncoded());     // Catch: Exception -> L21
        LogUtils.d(r16, "privKey len:" + r17.length);     // Catch: Exception -> L21
        LogUtils.d(r16, "privKey:" + CryptoUtils.byteArrayToHexString(r17));     // Catch: Exception -> L21
        r12.setPublicKey(CryptoUtils.byteArrayToHexString(r15));
        NetworkResponse r18 = NetworkManager.getInstance().callApi(r12, true);
        LogUtils.d(r16, "response code:" + r18.getCode());
        LogUtils.d(r16, "response msg:" + r18.getMessage());
        LogUtils.d(r16, "response serverPubKey:" + r18.getServerPubKey());
        Iterator<SyncKeyData> r19 = r18.getKeyDataList().iterator();
    L6:
        if (r19.hasNext() == false) goto L9;
        SyncKeyData r20 = r19.next();
        String r21 = TAG;
        LogUtils.d(r21, "legacy response key app:" + r20.getAppId());
        LogUtils.d(r21, "response key cipher:" + r20.getSyncKeyCipher());
        LogUtils.d(r21, "legacy response key version:" + r20.getKeyVersion());
        goto L6
    L9:
        if (r18.getCode() >= 200) goto L11;
    L19:
        LogUtils.e(TAG, "Network request failed, legacy error code:" + r18.getCode());
        return -21;
    L11:
        if (r18.getCode() >= 300) goto L19;
        if (SyncKeyManager.getInstance().importSyncKeyLegacy(r10, r18.getKeyDataList(), r18.getServerPubKey(), CryptoUtils.byteArrayToHexString(r17)) == true) goto L17;
        LogUtils.e(TAG, "KeyManager import key failed!! legacy.");
        return -100;
    L17:
        LogUtils.i(TAG, "KeyManager import key succeed!! legacy.");
        return 0;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "Generate or parse ecc keypair failed!! legacy error:" + e.getMessage());
        return -100;
    }

    public int deleteCloudSyncKey(Context r10, String r11) {
        if (r10 != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        return -2;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L8;
    L16:
        LogUtils.e(TAG, "Not white list app!! appId:" + r11);
        return -1;
    L8:
        if (CloudConfig.getInstance().isWhiteListApp(r11) == false) goto L16;
        long r12 = System.currentTimeMillis();
        int r13 = SyncKeyManager.getInstance().deleteSyncKey(r10, r11);
        EventTrace.eventTrace(r13, 1, r10.getPackageName(), r11, System.currentTimeMillis() - r12, 0);
        if (r13 == 0) goto L14;
        LogUtils.e(TAG, "Delete sync key failed!! result:" + r13);
        return r13;
    L14:
        LogUtils.i(TAG, "KeyManager delete key succeed!!");
        return 0;
    }

    public void init(Context r10, IAccountBridge r11, IEnvBridge r12, ITeaBridge r13) {
        AccountApi.init(r11);
        TeaTracker.init(r13);
        CloudConfig.getInstance().init(r10);
        NetworkConfig.getInstance().init(r12);
        NormalEvent.getInstance().init();
        broadcastRegister(r10);
    }

    public int initCloudSyncKey(Context r10, String r11) {
        if (r10 != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        return -2;
    L6:
        if (CloudConfig.getInstance().isWhiteListApp(r11) == true) goto L9;
        LogUtils.e(TAG, "Not white list app!! appId:" + r11);
        return -1;
    L9:
        long r12 = System.currentTimeMillis();
        String r13 = getSystemProperty("vendor.km.devcert.status");
        LogUtils.i(TAG, "Init cloud sync key, app:" + r10.getPackageName() + " appid:" + r11 + " keyStatus:" + r13);
        if (TextUtils.equals(r13, "ok") == false) goto L12;
        int r14 = handleKeyDistribution(r10, r11);
    L13:
        int r15 = r14;
        EventTrace.eventTrace(r15, 0, r10.getPackageName(), r11, System.currentTimeMillis() - r12, 0);
        return r14;
    L12:
        r14 = handleKeyDistributionLegacy(r10, r11);
        goto L13
    }
}
