package com.bytedance.a;

import android.text.TextUtils;
import com.obric.aikernel.sdk.ext.Params;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f999a = "c";

    static {
    }

    public c() {
    }

    private String a(int r1) {
        if (r1 != 1) goto L6;
        return "3059301306072a8648ce3d020106082a8648ce3d0301070342000407bac82c4f40ab707042df7dee42e4219f1f1ac5213509df1e9004d3fa8965ab285d7b0e693a042369846e0c03191f95777dc52a9e772880d45c1564ff3858f7";
    L6:
        return "";
    }

    private int b(String r9, int r10) {
        String r0 = f999a;
        b.b(r0, "Verify policy file:" + r9);
        if (new File(r9).exists() == true) goto L60;
        b.c(r0, "file not exist:" + r9);
        return 2;
    L60:
        FileReader r2 = new FileReader(r9);     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55
        char[] r11 = new char[1024];     // Catch: Throwable -> L38
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L38
        int r5 = 0;
    L10:
        int r6 = r2.read(r11);     // Catch: Throwable -> L38
        if (r6 <= 0) goto L18;
        r5 = r5 + r6;     // Catch: Throwable -> L38
        if (r5 > 104857600) goto L14;
        r3.append(r11, 0, r6);     // Catch: Throwable -> L38
        goto L10
    L14:
        b.c(f999a, "Policy file is too large, size:" + r5);     // Catch: Throwable -> L38
        r2.close();     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
        return 4;
    L18:
        JSONObject r12 = new JSONObject(r3.toString());     // Catch: Throwable -> L38
        String r4 = r12.getString(Params.CONTENT);     // Catch: Throwable -> L38
        String r13 = r12.getString("signature");     // Catch: Throwable -> L38
        byte[] r7 = d.a(r13);     // Catch: Throwable -> L38
        if (r7 != null) goto L21;
    L35:
        b.c(f999a, "Signature parse error! signHash:" + r13);     // Catch: Throwable -> L38
        r2.close();     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
        return 4;
    L21:
        if (r7.length == 0) goto L35;
        if (r7.length <= 2048) goto L28;
        b.c(f999a, "Signature is too large, size:" + r7.length);     // Catch: Throwable -> L38
        r2.close();     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
        return 4;
    L28:
        Signature r14 = Signature.getInstance("SHA256withECDSA");     // Catch: Throwable -> L38
        r14.initVerify(d.c(d.a(a(r10))));     // Catch: Throwable -> L38
        r14.update(r4.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L38
        boolean r8 = r14.verify(r7);     // Catch: Throwable -> L38
        String r15 = f999a;     // Catch: Throwable -> L38
        b.a(r15, "Policy file signature verify result:" + r8);     // Catch: Throwable -> L38
        if (r8 == false) goto L32;
        r2.close();     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
        return 0;
    L32:
        b.c(r15, "Policy file signature verify failed!!");     // Catch: Throwable -> L38
        r2.close();     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
        return 5;
    L38:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L41
    L43:
        throw th;     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L44 InvalidKeyException -> L46 SignatureException -> L48 NoSuchAlgorithmException -> L51 Throwable -> L55 Throwable -> L55
    L55:
        e = move-exception;
        b.c(f999a, "IOException or JSONException error:" + e.getMessage());
        return 4;
    L46:
        e = move-exception;
        String r16 = f999a;
        StringBuilder r17 = new StringBuilder().append("InvalidKeyException error:");
        String r18 = e.getMessage();
    L53:
        b.c(r16, r17.append(r18).toString());
        return 1000;
    L51:
        e = move-exception;
        r16 = f999a;
        r17 = new StringBuilder().append("NoSuchAlgorithmException error:");
        r18 = e.getMessage();
    L48:
        e = move-exception;
        b.c(f999a, "SignatureException error:" + e.getMessage());
        return 5;
    L44:
        e = move-exception;
        r16 = f999a;
        r17 = new StringBuilder().append("Exception error:");
        r18 = e.getMessage();
        goto L53
    }

    public int a(String r3, int r4) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        String r2 = f999a;
        String r5 = "Input policy file is invalid!!";
    L5:
        b.c(r2, r5);
        return 1;
    L7:
        if (r4 == 1) goto L10;
        r2 = f999a;
        r5 = "Not supported vendor type!!";
        goto L5
    L10:
        return b(r3, r4);
    }

    public int a(byte[] r4, byte[] r5, int r6) {
        if (r4 != null) goto L5;
    L33:
        String r3 = f999a;
        String r7 = "Input file data is empty!!";
    L11:
        b.c(r3, r7);
        return 1;
    L5:
        if (r4.length == 0) goto L33;
        if (r4.length <= 104857600) goto L13;
        r3 = f999a;
        StringBuilder r8 = new StringBuilder().append("Input file data is too large!! size:").append(r4.length);
    L10:
        r7 = r8.toString();
        goto L11
    L13:
        if (r5 != null) goto L15;
    L32:
        r3 = f999a;
        r7 = "Input sign data is empty!!";
        goto L11
    L15:
        if (r5.length == 0) goto L32;
        if (r5.length <= 2048) goto L20;
        r3 = f999a;
        r8 = new StringBuilder().append("Input sign data is too large!! size:").append(r5.length);
        goto L10
    L20:
        if (r6 == 1) goto L34;
        r3 = f999a;
        r7 = "Not supported vendor type!!";
        goto L11
    L34:
        Signature r0 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L29
        r0.initVerify(d.c(d.a(a(r6))));     // Catch: Exception -> L29
        r0.update(r4);     // Catch: Exception -> L29
        boolean r9 = r0.verify(r5);     // Catch: Exception -> L29
        String r10 = f999a;     // Catch: Exception -> L29
        b.a(r10, "verify data result:" + r9);     // Catch: Exception -> L29
        if (r9 == false) goto L26;
        return 0;
    L26:
        b.c(r10, "verify data failed!!");     // Catch: Exception -> L29
        return 5;
    L29:
        e = move-exception;
        b.c(f999a, "Signature verify failed, error:" + e.getMessage());
        return 1000;
    }
}
