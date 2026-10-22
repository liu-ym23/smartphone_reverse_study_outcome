package com.larus.bmhome.chat.markdown.code;

import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements rj8.b {
    public final /* synthetic */ q0 a;

    public final void a() {
        SoftReference r0 = com.larus.utils.y.a;
        final q0 r1 = this.a;
        Runnable r2 = new o0(r1);
        Intrinsics.checkNotNullParameter(r2, "action");
        com.larus.utils.y.c(r2);
    }

    public p0(q0 r1) {
        this.a = r1;
    }
}
