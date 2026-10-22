package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.ValueAnimator;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.obric.oui.titlebar.OUnitedTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11665c;
    public final /* synthetic */ KeyEvent.Callback d;

    public /* synthetic */ i(Object r5, KeyEvent.Callback r10, Object r11, int r12) {
        this.f11663a = r12;
        this.f11665c = r5;
        this.d = r10;
        this.f11664b = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        switch(this.f11663a) {
            case 0: goto L19;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        OUnitedTitleBar.Behavior r5 = (OUnitedTitleBar.Behavior) this.f11665c;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "animation");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L9;
        r5.setHeaderTopBottomOffset((CoordinatorLayout) this.d, (OUnitedTitleBar) this.f11664b, ((Integer) r11).intValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L10:
        Window r12 = (Window) this.f11665c;
        Intrinsics.checkNotNullParameter(r12, "$w");
        com.obric.oui.dialog.base.d r13 = (com.obric.oui.dialog.base.d) this.d;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        if (r12.getDecorView().isAttachedToWindow() == false) goto L17;
        Object r14 = r10.getAnimatedValue();
        if (r14 == null) goto L16;
        Integer r15 = (Integer) r14;
        int r16 = r15.intValue();
        r13.f13112n = r15;
        WindowManager.LayoutParams r17 = r12.getAttributes();
        r17.y = r16;
        r12.setAttributes(r17);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L17:
        ((ValueAnimator) this.f11664b).cancel();
        return;
    L19:
        p r18 = (p) this.f11665c;
        Intrinsics.checkNotNullParameter(r18, "this$0");
        View r19 = (View) this.d;
        Intrinsics.checkNotNullParameter(r19, "$targetView");
        float r20 = r10.getCurrentPlayTime();
        com.obric.oui.orecyclerview.base.e r21 = r18.f11693m;
        float r22 = r20 / 1000.0f;
        float r23 = ((r21.f13713b * r22) + r21.f13712a) * ((float) Math.exp((-r21.f13714c) * r22));
        float r24 = r21.f13713b;
        float r25 = r21.f13714c;
        float r26 = (r24 - (((r24 * r22) + r21.f13712a) * r25)) * ((float) Math.exp((-r25) * r22));
        if (Math.abs(r23) < 0.5f) goto L22;
    L24:
        jq.c r27 = new jq.c(r23, false);
    L25:
        r19.setX(r27.f18421a);
        if (r27.f18422b == false) goto L30;
        ((ValueAnimator) this.f11664b).cancel();
        r19.setX(0.0f);
        return;
    L30:
        return;
    L22:
        if ((Math.abs(r26) / 1000.0f) >= 0.05f) goto L24;
        r27 = new jq.c(0.0f, true);
        goto L25
    }
}
