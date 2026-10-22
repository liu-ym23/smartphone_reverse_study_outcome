package com.larus.suggest.impl.wcb.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbInitialRenderDecorator implements r {
    public final r a;
    public final g b;
    public final hx9.l c;

    @Override // com.larus.suggest.impl.wcb.render.r
    public final q a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new WcbInitialRenderDecorator$begin$1(this.a.a(r2), this);
    }

    public WcbInitialRenderDecorator(ImSdkWcbRenderer r2, g r3, hx9.a r4) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "displayState");
        Intrinsics.checkNotNullParameter(r4, "runtimeContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
