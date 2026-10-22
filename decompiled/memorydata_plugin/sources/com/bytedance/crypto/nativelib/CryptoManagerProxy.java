package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
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

    public String chacha20BytesXcrypt(int r3, String r4, String r5) {
        LogUtils.d("CryptoManager", "mode: " + r3 + ", appId: " + r4);
        if (r3 != 1) goto L7;
        return Base64.getEncoder().encodeToString(LocalDataCrypto.getInstance().bytesXcrypt(r3, CryptoConst.ALGORITHM_CHACHA20, r4, r5.getBytes(StandardCharsets.UTF_8)));
    L7:
        return new String(LocalDataCrypto.getInstance().bytesXcrypt(r3, CryptoConst.ALGORITHM_CHACHA20, r4, Base64.getDecoder().decode(r5)), StandardCharsets.UTF_8);
    }

    public String cloudTransXcrypt(int r5, String r6, String r7) {
        LogUtils.d("CryptoManager", "mode: " + r5);
        init(this.mContext, this.mAppid, r6, this.mBridge);
        if (r5 != 1) goto L9;
        return Base64.getEncoder().encodeToString(this.mCloudTransCryptoManager.dataEncrypt(r7.getBytes(StandardCharsets.UTF_8)));
    L9:
        if (r5 != 2) goto L13;
        return new String(this.mCloudTransCryptoManager.dataDecrypt(Base64.getDecoder().decode(r7)), StandardCharsets.UTF_8);
    L13:
        throw new CloudTransException("mode is invalid");     // Catch: CloudTransException -> L6
    L6:
        e = move-exception;
        LogUtils.e("CryptoManager", "cloudTransXcrypt error: " + e.getMessage());
        throw e;
    }

    public void init(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        LocalDataCrypto.getInstance().init(r1);
    }

    public void init(Context r3, String r4, String r5, IEnvBridge r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        IEnvBridge r8 = (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r6, IEnvBridge.class, "com.obric.memorydata.plugin");
        LocalDataCrypto.getInstance().init(r7);
        CloudTransCryptoManager r0 = CloudTransCryptoManager.getInstance();
        this.mCloudTransCryptoManager = r0;
        r0.init(r7, r4, r5, r8);
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mBridge = r8;
        this.mAppid = r4;
    }
}
