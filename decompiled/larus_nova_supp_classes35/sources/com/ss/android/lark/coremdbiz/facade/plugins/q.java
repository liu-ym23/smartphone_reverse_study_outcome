package com.ss.android.lark.coremdbiz.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements com.ss.android.lark.widget.span.v.b {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.o<v7b.l> a;
    public final /* synthetic */ com.ss.android.lark.widget.span.v b;

    public final void a() {
        com.ss.android.lark.coremd.base.parse.m r0 = this.a.d();
        com.ss.android.lark.widget.span.v r1 = this.b;
        Intrinsics.checkNotNull(r1);
        r0.a(r1, false);
    }

    public final void onLoadFailed() {
        com.ss.android.lark.coremd.base.parse.m r0 = this.a.d();
        com.ss.android.lark.widget.span.v r1 = this.b;
        Intrinsics.checkNotNull(r1);
        r0.a(r1, false);
    }

    public q(com.ss.android.lark.coremd.impl.parse.i r1, com.ss.android.lark.widget.span.v r2) {
        this.a = r1;
        this.b = r2;
    }
}
