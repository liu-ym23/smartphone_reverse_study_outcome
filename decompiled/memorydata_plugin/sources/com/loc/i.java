package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static PublicKey a(String r2) {
        byte[] r3 = e.a(r2);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(fx.c("EUlNB")).generatePublic(new X509EncodedKeySpec(r3));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }

    public static byte[] a(byte[] r2, PublicKey r3) {
        PublicKey r4 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        Cipher r0 = Cipher.getInstance(fx.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L5
        r0.init(1, r4);     // Catch: Throwable -> L5
        return r0.doFinal(r2);
    L5:
        return null;
    }
}
