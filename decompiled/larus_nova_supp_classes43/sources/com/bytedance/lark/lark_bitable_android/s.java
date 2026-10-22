package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final Object a(RustBuffer.ByValue r10) {
        Intrinsics.checkNotNullParameter(r10, "error_buf");
        RustBuffer.Companion.getClass();
        RustBuffer.a.c(r10);
        UnhandledException r11 = new UnhandledException("Unexpected CALL_ERROR");
        Intrinsics.checkNotNullParameter(r11, "e");
        return r11;
    }
}
