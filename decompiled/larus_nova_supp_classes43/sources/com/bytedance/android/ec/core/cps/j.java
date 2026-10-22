package com.bytedance.android.ec.core.cps;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.bouncycastle.crypto.digests.SHA3Digest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final String d(byte[] r10) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L6;
        byte r12 = r10[r11];
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        r0.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r12)}, 1)));
        r11 = r11 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static final String a(String r1, String r10) {
        MessageDigest r11 = MessageDigest.getInstance(r10);
        Charset r0 = Charsets.UTF_8;
        if (r1 == null) goto L7;
        return d(r11.digest(r1.getBytes(r0)));
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String b(String r10, int r11) {
        SHA3Digest r0 = new SHA3Digest(r11);
        Charset r12 = Charsets.UTF_8;
        if (r10 == null) goto L7;
        byte[] r13 = r10.getBytes(r12);
        r0.update(r13, 0, r13.length);
        byte[] r14 = new byte[r0.getDigestSize()];
        r0.doFinal(r14, 0);
        return d(r14);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String c(k r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$encode");
        Intrinsics.checkNotNullParameter(r11, "data");
        String r12 = r10.encode(r11);
        if (r12 != null) goto L5;
    L11:
        if (r12 != null) goto L16;
        return null;
    L16:
        return r12.substring(0, 32);
    L5:
        if (r12.length() >= 32) goto L11;
        StringBuilder r0 = new StringBuilder(r12);
    L8:
        if (r0.length() >= 32) goto L10;
        String r13 = String.valueOf(System.currentTimeMillis());
        r0.append(i.b.encode(r13));
        goto L8
    L10:
        r12 = r0.toString();
        goto L11
    }
}
