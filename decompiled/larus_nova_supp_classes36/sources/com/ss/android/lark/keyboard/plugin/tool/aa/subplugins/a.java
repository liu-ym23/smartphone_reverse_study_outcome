package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements TextStyleApplier.c, TextStyleApplier.b {
    public boolean a;
    public final TextStyleApplier b;

    @Override // com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.TextStyleApplier.c
    public final void b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
    }

    public a(TextStyleApplier.d<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "spanFactory");
        this.a = true;
        TextStyleApplier r0 = new TextStyleApplier(r2);
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.k = this;
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.l = this;
        this.b = r0;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.TextStyleApplier.b
    public final void a(boolean r1) {
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        throw null;
    }
}
