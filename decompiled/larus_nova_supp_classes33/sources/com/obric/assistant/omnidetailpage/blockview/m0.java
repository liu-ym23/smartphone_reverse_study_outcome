package com.obric.assistant.omnidetailpage.blockview;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ k0 a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public m0(k0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        r3.removeOnAttachStateChangeListener(this);
        final k0 r4 = this.a;
        r4.e.post(new l0(r4));
    }
}
