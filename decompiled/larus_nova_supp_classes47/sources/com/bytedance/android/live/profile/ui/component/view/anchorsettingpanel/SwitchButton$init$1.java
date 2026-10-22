package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SwitchButton$init$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public SwitchButton$init$1(SwitchButton r8) {
        super(1, r8, SwitchButton.class, "onClick", "onClick(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r3) {
        SwitchButton r4 = (SwitchButton) ((CallableReference) this).receiver;
        boolean r0 = !r4.c;
        r4.c = r0;
        r4.a(r0);
        r4.b(r4.c, true);
        Function1<? super Boolean, Unit> r1 = r4.d;
        if (r1 == null) goto L6;
        Unit r5 = (Unit) r1.invoke(Boolean.valueOf(r4.c));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
