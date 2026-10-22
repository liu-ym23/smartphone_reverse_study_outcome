package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncErrorX529049160a731337;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p0 {
    public static final p0 a = null;

    static {
        a = new p0();
    }

    public p0() {
    }

    public final Object a(RustBuffer.ByValue r10) {
        Intrinsics.checkNotNullParameter(r10, "error_buf");
        RustBuffer.Companion.getClass();
        byte[] r11 = RustBuffer.a.b(r10);
        lark_bitable.proto.ModelError r12 = ((FuncErrorX529049160a731337) FuncErrorX529049160a731337.ADAPTER.decode(r11)).err;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return new ModelError(r12.code.longValue(), r12.msg);
    }
}
