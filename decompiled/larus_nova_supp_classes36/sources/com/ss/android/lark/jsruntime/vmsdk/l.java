package com.ss.android.lark.jsruntime.vmsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements tnb.f {
    public final /* synthetic */ j a;

    public l(j r1) {
        this.a = r1;
    }

    @Override // tnb.f
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonString");
        e r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.prompt(r2);
        return;
    }

    @Override // tnb.f
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dataString");
        e r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.prompt(r2);
        return;
    }
}
