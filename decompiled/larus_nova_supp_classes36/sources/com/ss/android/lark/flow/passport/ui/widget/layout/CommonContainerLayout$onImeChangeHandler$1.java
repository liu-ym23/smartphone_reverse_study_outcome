package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class CommonContainerLayout$onImeChangeHandler$1 extends FunctionReferenceImpl implements Function3<View, Boolean, Integer, Unit> {
    public CommonContainerLayout$onImeChangeHandler$1(Object r8) {
        super(3, r8, CommonContainerLayout.class, "onImeChanged", "onImeChanged(Landroid/view/View;ZI)V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout] */
    public final void invoke(View r9, boolean r10, int r11) {
        ?? r0 = (CommonContainerLayout) ((CallableReference) this).receiver;
        r0.setContentScrollable(!r10);
        if (r10 == true) goto L5;
        r11 = 0;
    L26:
        ValueAnimator r3 = r0.d;
        if (r3 == null) goto L29;
        r3.cancel();
    L29:
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r0.getPaddingBottom(), r11});
        r0.d = r12;
        r12.setDuration(160);
        r12.addUpdateListener(new e(r0));
        r12.start();
        Intrinsics.checkNotNull(r12);
        r12.addUpdateListener(new a(r9, r0));
        r12.addListener(new b(r0, r10));
        return;
    L5:
        LinearLayout r4 = r0.g;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        qyb.b r5 = new qyb.b(r4);
        Object r6 = null;
    L7:
        if (r5.hasNext() == false) goto L15;
        Object r7 = r5.next();
        if (((View) r7).getVisibility() != 8) goto L11;
        boolean r8 = true;
    L13:
        if ((!r8) == false) goto L7;
        r6 = r7;
        goto L7
    L11:
        r8 = false;
        goto L13
    L15:
        View r13 = (View) r6;
        if (r13 == null) goto L26;
        int r14 = r0.R5(r13);
        if (r14 >= ((r0.getHeight() - r11) - r0.h.getHeight())) goto L22;
        r0.m.c();
    L25:
        r11 = r11 + 0;
        goto L26
    L22:
        if (r14 >= (r0.getHeight() - r11)) goto L24;
        r11 = (r0.getHeight() - r14) - r0.h.getHeight();
        r0.m.b();
        goto L25
    L24:
        r11 = r11 - r0.h.getHeight();
        r0.m.a();
        goto L25
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((View) r1, ((Boolean) r2).booleanValue(), ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
