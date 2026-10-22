package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 extends v0 {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.v0
    public final void a() {
        Lazy<Long> r0 = MoltenFfiLibLarkBizFeed.a;     // Catch: RuntimeException -> L4
        MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_free(MoltenFfiLibLarkBizFeed.a.b(), this.a, -4712087089494097920L);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        if (e.getMessage() == null) goto L9;
        int r1 = h.a;
        String r2 = e.getMessage();
        Intrinsics.checkNotNull(r2);
        UnhandledException r3 = new UnhandledException(r2);
        Intrinsics.checkNotNullParameter(r3, "e");
        throw r3;
    L9:
        int r4 = h.a;
        UnhandledException r5 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r5, "e");
        throw r5;
    }

    public h0(long r1) {
        super(r1);
    }
}
