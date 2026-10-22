package com.bytedance.bdinstall.dtrait.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.Singleton;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.security.Sword.Sword;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PublicKey;
import java.util.Iterator;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final char[] HEX_ARRAY = null;
    private static final Singleton<SharedPreferences> sInstallSpref = null;

    static {
        sInstallSpref = new AnonymousClass1();
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    public Utils() {
    }

    public static String bytesToHex(byte[] r6) {
        char[] r0 = new char[r6.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        int r2 = r6[r1] & 255;
        int r3 = r1 * 2;
        char[] r4 = HEX_ARRAY;
        r0[r3] = r4[r2 >>> 4];
        r0[r3 + 1] = r4[r2 & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static void copy(JSONObject r5, JSONObject r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L21;
        return;
    L21:
        monitor-enter(Utils.class);     // Catch: Throwable -> L18
        Iterator<String> r1 = r6.keys();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r5.put(r2, r6.opt(r2));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(Utils.class);     // Catch: Throwable -> L14
        goto L24
    L17:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    }

    public static String encryptByBDSword(JSONObject r3) {
        byte[] r4 = r3.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Exception -> L8
        if (r4.length != 0) goto L6;
        return "";
    L6:
        return Sword.clientPackedBase64(r4, r4.length);
    L8:
        e = move-exception;
        DTLog.e("parseEncrypt#parse error: " + e.getMessage());
        return "";
    }

    public static SharedPreferences getCommonSp(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(sInstallSpref.get(new Object[]{r5}), SharedPreferences.class, "com.obric.memorydata.plugin");
    }

    public static String getEncryptBase64StrByRSA(byte[] r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        DTLog.e("encryptByRSA# error: publicKey is empty");
        return "";
    L6:
        PublicKey r4 = RSAUtils.parsePublicKey(new String(Base64.decode(r3, 0)));
        Cipher r0 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r0.init(1, r4);
        return Base64.encodeToString(r0.doFinal(r2), 2);
    }
}
