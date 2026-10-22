package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttestKeyManager {
    private static final HashMap<String, String> APP_ID_LIST = null;
    public static final String TAG = "AttestKeyManager";
    private static volatile AttestKeyManager keyManager;

    static {
        APP_ID_LIST = new AnonymousClass1();
    }

    public AttestKeyManager() {
    }

    private List<Certificate> attestKey(Context r10, String r11, String r12, String r13, boolean r14) {
        Bundle r15 = new Bundle();
        if (r14 == false) goto L11;
        r15.putBoolean(FrameworkSecurityCompat.KeyManagerConst.DEVICE_HEALTH_STATUS_REQUIRED(), true);
        if (r12 != null) goto L7;
    L10:
        String r16 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        r13 = r13 + "::" + APP_ID_LIST.getOrDefault(r10.getPackageName(), "");
    L12:
        r15.putString(r16, r13);
    L13:
        FrameworkSecurityCompat.KmResult r17 = FrameworkSecurityCompat.keyAttestation(r10, r11, r15);
        if (r17.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L17;
        LogUtils.e(TAG, "Attest key failed! ret:" + r17.getResultCode());
        return new ArrayList();
    L17:
        List<Certificate> r18 = r17.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r18.size());
        return r18;
    L7:
        if (r12.isEmpty() == true) goto L10;
        r15.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r13 + "::" + r12);
        goto L13
    L11:
        r16 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        goto L12
    }

    private int generateKeyPair(Context r10, String r11, Bundle r12) {
        int r13 = FrameworkSecurityCompat.generateKeyPair(r10, r11, r12);
        if (r13 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r13);
        return r13;
    L7:
        return FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS();
    }

    public static AttestKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(AttestKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new AttestKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AttestKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    public void deleteAttestKey(Context r10, String r11) {
        int r12 = FrameworkSecurityCompat.deleteKey(r10, r11, new Bundle());
        LogUtils.i(TAG, "Delete attest key! keyAlias:" + r11 + " ret:" + r12);
    }

    public List<Certificate> getAttestCertChain(Context r10, String r11, String r12, boolean r13, Bundle r14) {
        String r15 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r15) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r16 = TAG;
        LogUtils.d(r16, "Request challenge succeed! challenge:" + r15);
        int r17 = generateKeyPair(r10, r11, r14);
        if (r17 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L11;
        LogUtils.e(r16, "Generate attestation key pair failed! ret:" + r17);
        return new ArrayList();
    L11:
        return attestKey(r10, r11, r12, r15, r13);
    }
}
