package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class CryptoManagerProxy {
    private static volatile CryptoManagerProxy cryptoManager;
    private String mAppid;
    private IEnvBridge mBridge;
    private CloudTransCryptoManager mCloudTransCryptoManager;
    private Context mContext;

    static {
        System.loadLibrary("cryptolib");
    }

    public CryptoManagerProxy() {
    }

    public static CryptoManagerProxy getInstance() {
        if (cryptoManager != null) goto L15;
        monitor-enter(CryptoManagerProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cryptoManager != null) goto L9;
        cryptoManager = new CryptoManagerProxy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CryptoManagerProxy.class);     // Catch: Throwable -> L11
    L15:
        return cryptoManager;
    }

    public String chacha20BytesXcrypt(int r10, String r11, String r12) {
        LogUtils.d("CryptoManager", "mode: " + r10 + ", appId: " + r11);
        if (r10 != 1) goto L7;
        return Base64.getEncoder().encodeToString(LocalDataCrypto.getInstance().bytesXcrypt(r10, CryptoConst.ALGORITHM_CHACHA20, r11, r12.getBytes(StandardCharsets.UTF_8)));
    L7:
        return new String(LocalDataCrypto.getInstance().bytesXcrypt(r10, CryptoConst.ALGORITHM_CHACHA20, r11, Base64.getDecoder().decode(r12)), StandardCharsets.UTF_8);
    }

    public String cloudTransXcrypt(int r10, String r11, String r12) {
        LogUtils.d("CryptoManager", "mode: " + r10);
        init(this.mContext, this.mAppid, r11, this.mBridge);
        if (r10 != 1) goto L9;
        return Base64.getEncoder().encodeToString(this.mCloudTransCryptoManager.dataEncrypt(r12.getBytes(StandardCharsets.UTF_8)));
    L9:
        if (r10 != 2) goto L13;
        return new String(this.mCloudTransCryptoManager.dataDecrypt(Base64.getDecoder().decode(r12)), StandardCharsets.UTF_8);
    L13:
        throw new CloudTransException("mode is invalid");     // Catch: CloudTransException -> L6
    L6:
        e = move-exception;
        LogUtils.e("CryptoManager", "cloudTransXcrypt error: " + e.getMessage());
        throw e;
    }

    public void init(Context r10) {
        LocalDataCrypto.getInstance().init(r10);
    }

    public void init(Context r10, String r11, String r12, IEnvBridge r13) {
        LocalDataCrypto.getInstance().init(r10);
        CloudTransCryptoManager r14 = CloudTransCryptoManager.getInstance();
        this.mCloudTransCryptoManager = r14;
        r14.init(r10, r11, r12, r13);
        this.mContext = r10;
        this.mBridge = r13;
        this.mAppid = r11;
    }
}
