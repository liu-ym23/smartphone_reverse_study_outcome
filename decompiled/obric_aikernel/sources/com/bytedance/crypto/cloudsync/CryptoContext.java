package com.bytedance.crypto.cloudsync;

import android.content.Context;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class CryptoContext {
    public static final String TAG = "CryptoContext";
    private String mAppId;
    private Context mContext;
    private SecretKey mFileEncryptKey;
    private byte[] mFileKeyCipher;
    private String mFilePath;

    public CryptoContext(Context r10, String r11, String r12) {
        this.mContext = r10;
        this.mFilePath = r11;
        this.mAppId = r12;
    }

    private static SecretKey constructChaCha20Key(byte[] r10) {
        return new SecretKeySpec(r10, CryptoConst.ALGORITHM_CHACHA20);
    }

    public void deinitFileKey() {
        this.mFileEncryptKey = null;
        this.mFileKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public SecretKey getFileEncryptKey() {
        return this.mFileEncryptKey;
    }

    public byte[] getFileKeyCipher() {
        return this.mFileKeyCipher;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean initFileDecryptKey(byte[] r10) {
        if (this.mContext != null) goto L7;
        LogUtils.e(TAG, "Context is null!!");
        String r11 = this.mAppId;
        int r12 = -2;
        int r13 = 3;
        long r14 = 0;
        int r15 = 0;
        String r16 = "";
    L5:
        EventTrace.eventTrace(r12, r13, r16, r11, r14, r15);
        return false;
    L7:
        String r17 = TAG;
        LogUtils.i(r17, "file key cipher len:" + r10.length);
        byte[] r18 = SyncKeyManager.getInstance().decryptByKeyManager(this.mContext, this.mAppId, r10, CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r18 != null) goto L10;
    L14:
        LogUtils.e(r17, "File key decrypt failed!! key cipher len:" + r10.length);
        r16 = this.mContext.getPackageName();
        r11 = this.mAppId;
        r12 = -4;
        r13 = 3;
        r14 = 0;
        r15 = 0;
        goto L5
    L10:
        if (r18.length == 0) goto L14;
        this.mFileEncryptKey = constructChaCha20Key(r18);
        EventTrace.eventTrace(0, 3, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }

    public boolean initFileEncryptKey() {
        if (this.mContext != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        EventTrace.eventTrace(-2, 2, "", this.mAppId, 0, 0);
        return false;
    L6:
        SecretKey r10 = CryptoUtils.generateSymmetricKey(CryptoConst.ALGORITHM_CHACHA20, 32);
        if (r10 != null) goto L10;
        LogUtils.e(TAG, "Generate file encrypt key failed!!");
        EventTrace.eventTrace(-100, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L10:
        String r11 = TAG;
        LogUtils.d(r11, "file key len:" + r10.getEncoded().length);
        byte[] r12 = SyncKeyManager.getInstance().encryptByKeyManager(this.mContext, this.mAppId, r10.getEncoded(), CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r12 != null) goto L13;
    L17:
        LogUtils.e(r11, "File key encrypt failed!!");
        EventTrace.eventTrace(-4, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L13:
        if (r12.length == 0) goto L17;
        byte[] r13 = new byte[r12.length];
        this.mFileKeyCipher = r13;
        System.arraycopy(r12, 0, r13, 0, r12.length);
        this.mFileEncryptKey = r10;
        EventTrace.eventTrace(0, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }
}
