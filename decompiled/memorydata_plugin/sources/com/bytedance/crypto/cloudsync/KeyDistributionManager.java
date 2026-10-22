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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyPair;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KeyDistributionManager {
    public static final String TAG = "KeyDistributionManager";
    private static volatile KeyDistributionManager keyDistributionManager;

    public KeyDistributionManager() {
    }

    private void broadcastRegister(Context r8) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        CloudSyncBroadcastReceiver r1 = new CloudSyncBroadcastReceiver();
        IntentFilter r2 = new IntentFilter();
        r2.addAction(CloudSyncBroadcastReceiver.WHITELIST_ACTION);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver(r0, r1, r2, CloudSyncBroadcastReceiver.PERMISSION, null, 2, "com.obric.memorydata.plugin");
        return;
    L5:
        ZeusTransformUtils.registerReceiver(r0, r1, r2, CloudSyncBroadcastReceiver.PERMISSION, null, "com.obric.memorydata.plugin");
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

    private String getSystemProperty(String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r9, "unknown"}), String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    private int handleKeyDistribution(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        NetworkRequest r11 = new NetworkRequest();
        r11.setRequestType("POST");
        r11.setRequestUrl(CloudConfig.getGetSyncKeyUrl());
        r11.setRootKeyName(CloudConfig.ROOT_NAME_CLOUD_SYNC);
        ArrayList r1 = new ArrayList();
        r1.add(r10);
        r11.setAppList(r1);
        Bundle r6 = new Bundle();
        r6.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r6.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r6.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY());
        List<Certificate> r2 = AttestKeyManager.getInstance().getAttestCertChain(r8, r10, "", false, r6);
        int r3 = 0;
        if (r2 != null) goto L5;
    L24:
        String r12 = TAG;
        String r0 = "Get attest cert chain failed!!";
    L25:
        LogUtils.e(r12, r0);
    L26:
        r3 = -100;
    L27:
        AttestKeyManager.getInstance().deleteAttestKey(r8, r10);
        LogUtils.i(TAG, "KeyManager import key end, result:" + r3);
        return r3;
    L5:
        if (r2.size() == 0) goto L24;
        r11.setCertChain(CertUtils.certsToPemString(r2, 3));     // Catch: Exception -> L22
        NetworkResponse r13 = NetworkManager.getInstance().callApi(r11, false);
        String r4 = TAG;
        LogUtils.d(r4, "response code:" + r13.getCode());
        LogUtils.d(r4, "response msg:" + r13.getMessage());
        LogUtils.d(r4, "response serverPubKey:" + r13.getServerPubKey());
        Iterator<SyncKeyData> r5 = r13.getKeyDataList().iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        SyncKeyData r7 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r5.next(), SyncKeyData.class, "com.obric.memorydata.plugin");
        String r14 = TAG;
        LogUtils.d(r14, "response key app:" + r7.getAppId());
        LogUtils.d(r14, "response key cipher:" + r7.getSyncKeyCipher());
        LogUtils.d(r14, "response key version:" + r7.getKeyVersion());
        goto L11
    L14:
        if (r13.getCode() >= 200) goto L16;
    L21:
        LogUtils.e(TAG, "Network request failed, error code:" + r13.getCode());
        r3 = -21;
        goto L27
    L16:
        if (r13.getCode() >= 300) goto L21;
        if (SyncKeyManager.getInstance().importSyncKey(r8, r13.getKeyDataList(), r13.getServerPubKey(), r10) == true) goto L27;
        r12 = TAG;
        r0 = "KeyManager import key failed!!";
    L22:
        e = move-exception;
        LogUtils.e(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        goto L26
    }

    private int handleKeyDistributionLegacy(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        NetworkRequest r10 = new NetworkRequest();
        r10.setRequestType("POST");
        r10.setRequestUrl(CloudConfig.getGetSyncKeyUrlLegacy());
        r10.setRootKeyName(CloudConfig.ROOT_NAME_CLOUD_SYNC);
        ArrayList r1 = new ArrayList();
        r1.add(r9);
        r10.setAppList(r1);
        KeyPair r2 = CryptoUtils.generateECCKeyPair();     // Catch: Exception -> L21
        byte[] r3 = CryptoUtils.parseECCPublicKey(r2.getPublic().getEncoded());     // Catch: Exception -> L21
        String r4 = TAG;     // Catch: Exception -> L21
        LogUtils.d(r4, "pubKey len:" + r3.length);     // Catch: Exception -> L21
        LogUtils.d(r4, "pubKey:" + CryptoUtils.byteArrayToHexString(r3));     // Catch: Exception -> L21
        byte[] r5 = CryptoUtils.parseEccPrivateKey(r2.getPrivate().getEncoded());     // Catch: Exception -> L21
        LogUtils.d(r4, "privKey len:" + r5.length);     // Catch: Exception -> L21
        LogUtils.d(r4, "privKey:" + CryptoUtils.byteArrayToHexString(r5));     // Catch: Exception -> L21
        r10.setPublicKey(CryptoUtils.byteArrayToHexString(r3));
        NetworkResponse r11 = NetworkManager.getInstance().callApi(r10, true);
        LogUtils.d(r4, "response code:" + r11.getCode());
        LogUtils.d(r4, "response msg:" + r11.getMessage());
        LogUtils.d(r4, "response serverPubKey:" + r11.getServerPubKey());
        Iterator<SyncKeyData> r6 = r11.getKeyDataList().iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        SyncKeyData r12 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r6.next(), SyncKeyData.class, "com.obric.memorydata.plugin");
        String r13 = TAG;
        LogUtils.d(r13, "legacy response key app:" + r12.getAppId());
        LogUtils.d(r13, "response key cipher:" + r12.getSyncKeyCipher());
        LogUtils.d(r13, "legacy response key version:" + r12.getKeyVersion());
        goto L6
    L9:
        if (r11.getCode() >= 200) goto L11;
    L19:
        LogUtils.e(TAG, "Network request failed, legacy error code:" + r11.getCode());
        return -21;
    L11:
        if (r11.getCode() >= 300) goto L19;
        if (SyncKeyManager.getInstance().importSyncKeyLegacy(r7, r11.getKeyDataList(), r11.getServerPubKey(), CryptoUtils.byteArrayToHexString(r5)) == true) goto L17;
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
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L7;
        LogUtils.e(TAG, "Context is null!!");
        return -2;
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L9;
    L17:
        LogUtils.e(TAG, "deleteCloudSyncKey Not white list app!! appId:" + r11);
        return -1;
    L9:
        if (CloudConfig.getInstance().isWhiteListApp(r11) == false) goto L17;
        long r0 = System.currentTimeMillis();
        int r12 = SyncKeyManager.getInstance().deleteSyncKey(r9, r11);
        EventTrace.eventTrace(r12, 1, r9.getPackageName(), r11, System.currentTimeMillis() - r0, 0);
        String r13 = TAG;
        if (r12 == 0) goto L15;
        LogUtils.e(r13, "Delete sync key failed!! result:" + r12);
        return r12;
    L15:
        LogUtils.i(r13, "KeyManager delete key succeed!!");
        return 0;
    }

    public void init(Context r3, IAccountBridge r4, IEnvBridge r5, ITeaBridge r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        IAccountBridge r8 = (IAccountBridge) ZeusTransformUtils.wrapperContextForParams(r4, IAccountBridge.class, "com.obric.memorydata.plugin");
        IEnvBridge r9 = (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r5, IEnvBridge.class, "com.obric.memorydata.plugin");
        ITeaBridge r10 = (ITeaBridge) ZeusTransformUtils.wrapperContextForParams(r6, ITeaBridge.class, "com.obric.memorydata.plugin");
        AccountApi.init(r8);
        TeaTracker.init(r10);
        CloudConfig.getInstance().init(r7);
        NetworkConfig.getInstance().init(r9);
        NormalEvent.getInstance().init();
        broadcastRegister(r7);
    }

    public int initCloudSyncKey(Context r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L7;
        LogUtils.e(TAG, "Context is null!!");
        return -2;
    L7:
        if (CloudConfig.getInstance().isWhiteListApp(r11) == true) goto L11;
        LogUtils.e(TAG, "initCloudSyncKey Not white list app!! appId:" + r11);
        return -1;
    L11:
        if (TextUtils.isEmpty(AccountApi.INSTANCE.getUserId()) == false) goto L14;
        LogUtils.e(TAG, "initCloudSyncKey no uid, appId:" + r11);
        return -20;
    L14:
        long r0 = System.currentTimeMillis();
        String r2 = getSystemProperty("vendor.km.devcert.status");
        LogUtils.i(TAG, "Init cloud sync key, app:" + r12.getPackageName() + " appid:" + r11 + " keyStatus:" + r2);
        if (TextUtils.equals(r2, "ok") == false) goto L17;
        int r9 = handleKeyDistribution(r12, r11);
    L18:
        int r3 = r9;
        EventTrace.eventTrace(r3, 0, r12.getPackageName(), r11, System.currentTimeMillis() - r0, 0);
        return r9;
    L17:
        r9 = handleKeyDistributionLegacy(r12, r11);
        goto L18
    }
}
