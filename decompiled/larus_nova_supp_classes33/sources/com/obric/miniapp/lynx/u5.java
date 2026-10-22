package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u5 extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ Function1<LynxContext, LynxUI<?>> a;

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return (LynxUI) this.a.invoke(r2);
    }

    public u5(String r1, Function1<? super LynxContext, ? extends LynxUI<?>> r2) {
        this.a = r2;
        super(r1, false);
    }
}
