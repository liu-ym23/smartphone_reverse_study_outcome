package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class OfficialInspectorWidget$onShowStart$4 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public OfficialInspectorWidget$onShowStart$4(OfficialInspectorWidget r8) {
        super(1, r8, OfficialInspectorWidget.class, "playClickViewAnimation", "playClickViewAnimation(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r3) {
        OfficialInspectorWidget r4 = (OfficialInspectorWidget) ((CallableReference) this).receiver;
        AnimatorSet r0 = r4.i;
        if (r0 != null) goto L5;
    L6:
        AnimatorSet r1 = r4.j;
        if (r1 == null) goto L11;
        if (r1.isRunning() != true) goto L11;
        return;
    L11:
        if (r4.e == true) goto L13;
        return;
    L13:
        if (r4.isViewValid() == false) goto L26;
        TextView r2 = r4.c;
        if (r2 == null) goto L18;
        r2.clearAnimation();
    L18:
        AnimatorSet r5 = r4.j;
        if (r5 == null) goto L25;
        r5.start();
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (r0.isRunning() != true) goto L6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
