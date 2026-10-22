package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static IOException a(String r1, Throwable r2) {
        IOException r0 = new IOException(r1);
        a(r0, r2);
        return r0;
    }

    public static void a() {
        a(null);
    }

    public static void a(String r3) {
        if (r3 != null) goto L5;
        r3 = "[no description]";
    L5:
        throw new RuntimeException("Internal error: " + r3);
    }

    public static void a(Throwable r3) {
        b(r3);
        throw new RuntimeException("[was " + r3.getClass() + "] " + r3.getMessage(), r3);
    }

    public static void a(Throwable r1, Throwable r2) {
        if (r1.getCause() != null) goto L6;
        r1.initCause(r2);
        return;
    }

    public static void b(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, RuntimeException.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, Error.class) == true) goto L8;
        return;
    L8:
        throw ((Error) ZeusTransformUtils.preCheckCast(r2, Error.class, "com.obric.memorydata.plugin"));
    L10:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r2, RuntimeException.class, "com.obric.memorydata.plugin"));
    }
}
