package com.larus.bmhome.chat.service.action;

import android.view.View;
import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ Ref.ObjectRef<Balloon> a;
    public final /* synthetic */ Ref.ObjectRef<View> b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Balloon r0 = (Balloon) this.a.element;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        View r1 = (View) this.b.element;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        r3.removeOnAttachStateChangeListener(this);
    }

    public g0(Ref.ObjectRef<Balloon> r1, Ref.ObjectRef<View> r2) {
        this.a = r1;
        this.b = r2;
    }
}
