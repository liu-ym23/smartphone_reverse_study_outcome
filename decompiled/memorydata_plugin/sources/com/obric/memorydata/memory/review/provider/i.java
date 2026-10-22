package com.obric.memorydata.memory.review.provider;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"utf8Size", "", "", "utf8SizeLong", "", "sha256", EventBody.KEY_VALUE, "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {
    public static final /* synthetic */ int a(int r0) {
        return b(r0);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String a(String r0) {
        return f(r0);
    }

    private static final int b(int r3) {
        if (r3 > 127) goto L6;
        return 1;
    L6:
        if (r3 > 2047) goto L8;
        return 2;
    L8:
        boolean r2 = false;
        if (55296 <= r3) goto L11;
    L13:
        if (r2 == false) goto L16;
        return 1;
    L16:
        if (r3 > 65535) goto L18;
        return 3;
    L18:
        return 4;
    L11:
        if (r3 >= 57344) goto L13;
        r2 = true;
        goto L13
    }

    public static final /* synthetic */ long b(String r2) {
        return e(r2);
    }

    public static final /* synthetic */ int c(String r0) {
        return d(r0);
    }

    private static final int d(String r2) {
        Charset r0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r0, "UTF_8");
        byte[] r3 = r2.getBytes(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
        return r3.length;
    }

    private static final long e(String r8) {
        int r0 = 0;
        long r1 = 0;
    L4:
        if (r0 >= r8.length()) goto L24;
        char r3 = r8.charAt(r0);
        if (r3 <= 127) goto L7;
        if (r3 <= 2047) goto L11;
        if (Character.isHighSurrogate(r3) == false) goto L21;
        int r4 = r0 + 1;
        if (r4 >= r8.length()) goto L21;
        if (Character.isLowSurrogate(r8.charAt(r4)) == false) goto L21;
        r1 = r1 + 4;
        r0 = r0 + 2;
    L21:
        if (CharsKt.isSurrogate(r3) == true) goto L7;
        long r5 = 3;
    L12:
        r1 = r1 + r5;
    L8:
        r0 = r0 + 1;
        goto L4
    L11:
        r5 = 2;
    L7:
        r1 = r1 + 1;
        goto L8
    L24:
        return r1;
    }

    private static final String f(String r11) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        Charset r1 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r1, "UTF_8");
        byte[] r12 = r11.getBytes(r1);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        byte[] r2 = r0.digest(r12);
        Intrinsics.checkNotNullExpressionValue(r2, "digest(...)");
        return ArraysKt.joinToString$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$i$QZhfYbB7DXgRBZ8dSKicOKw9Xk.INSTANCE, 30, null);
    }

    /* JADX INFO: renamed from: lambda$QZ-hfYbB7DXgRBZ8dSKicOKw9Xk, reason: not valid java name */
    public static /* synthetic */ CharSequence m751lambda$QZhfYbB7DXgRBZ8dSKicOKw9Xk(byte r0) {
        return a(r0);
    }
}
