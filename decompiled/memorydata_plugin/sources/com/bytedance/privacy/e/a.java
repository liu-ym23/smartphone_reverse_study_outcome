package com.bytedance.privacy.e;

import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3013a = "a";

    static {
    }

    public a() {
    }

    public static String a(List<Certificate> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L26;
        if (r10.isEmpty() == true) goto L26;
        if (r9 <= 0) goto L26;
        if (r9 > r10.size()) goto L26;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        Iterator r11 = r10.iterator();
        int r3 = 0;
    L11:
        if (r11.hasNext() == false) goto L24;
        Certificate r4 = (Certificate) ZeusTransformUtils.preCheckCast(r11.next(), Certificate.class, "com.obric.memorydata.plugin");
        if (r3 >= r9) goto L24;
        if (r4 == null) goto L22;
        r0.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r5 = Base64.encodeToString(r4.getEncoded(), 2);
        int r6 = 0;
    L18:
        if (r6 >= r5.length()) goto L20;
        int r7 = r6 + 64;
        r0.write(r5.substring(r6, Math.min(r7, r5.length())).getBytes());
        r6 = r7;
        goto L18
    L20:
        r0.write("\\n".getBytes());
        r0.write("-----END CERTIFICATE-----\\n".getBytes());
        r3 = r3 + 1;
        goto L11
    L22:
        throw new IllegalArgumentException("Certificate is null at index " + r3);
    L24:
        return r0.toString();
    L26:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }
}
