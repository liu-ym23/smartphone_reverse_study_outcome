package com.larus.bmhome.floatchat.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y implements View.OnTouchListener {
    public Float a;
    public Integer b;
    public float c;
    public final /* synthetic */ FloatChatFoldHandlerComponent d;

    public y(FloatChatFoldHandlerComponent r1) {
        this.d = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r12, MotionEvent r13) {
        FrameLayout.LayoutParams r0 = null;
        Integer r1 = null;
        if (r13 == null) goto L5;
        Integer r2 = Integer.valueOf(r13.getAction());
    L7:
        if (r2 == null) goto L20;
        if (r2.intValue() != 0) goto L20;
        if (r12 == null) goto L15;
        ViewParent r14 = r12.getParent();
        if (r14 == null) goto L15;
        r14.requestDisallowInterceptTouchEvent(true);
    L15:
        this.a = Float.valueOf(r13.getRawY());
        View r15 = this.d.A;
        if (r15 == null) goto L18;
        r1 = Integer.valueOf(r15.getHeight());
    L18:
        this.b = r1;
        this.c = 0.0f;
        return true;
    L20:
        if (r2 != null) goto L23;
    L56:
        if (r2 != null) goto L59;
    L125:
        if (r2 != null) goto L128;
    L142:
        return false;
    L128:
        if (r2.intValue() != 3) goto L142;
        this.a = null;
        this.b = null;
        this.c = 0.0f;
        View r16 = this.d.A;
        if (r16 == null) goto L138;
        ViewPropertyAnimator r17 = r16.animate();
        if (r17 == null) goto L138;
        ViewPropertyAnimator r18 = r17.translationY(0.0f);
        if (r18 == null) goto L138;
        ViewPropertyAnimator r19 = r18.setDuration(this.d.D3());
        if (r19 == null) goto L138;
        r19.start();
    L138:
        if (r12 == null) goto L152;
        ViewParent r110 = r12.getParent();
        if (r110 == null) goto L153;
        r110.requestDisallowInterceptTouchEvent(false);
        return true;
    L153:
        return true;
    L152:
        return true;
    L59:
        if (r2.intValue() != 1) goto L125;
        Integer r111 = this.b;
        if (r111 == null) goto L120;
        FloatChatFoldHandlerComponent r3 = this.d;
        int r112 = r111.intValue();
        View r5 = r3.A;
        if (r5 == null) goto L65;
        int r6 = r5.getHeight();
    L66:
        if (r6 == 0) goto L120;
        int r7 = (int) this.c;
        int r8 = c7.b(50);
        FLogger.a.i("FloatChatFoldHandler", "dealExpandOrFold, deltaHeight = " + (r6 - r112) + ", gestureDeltaY = " + r7 + ", threshold = " + r8);
        if (r7 <= 0) goto L81;
        if (r7 <= r8) goto L77;
        if (r3.h4() == true) goto L73;
    L75:
        r3.G3().toNineSplitScreen(true, "expand");
        goto L120
    L73:
        if (r6 < (r3.V3() - r8)) goto L75;
        r3.eA();
        goto L120
    L77:
        if (r3.h4() == false) goto L79;
        r3.G3().toNineSplitScreen(true, "dealExpandOrFold_up");
        goto L120
    L79:
        r3.G3().toHalfScreen(true, "dealExpandOrFold_up");
        goto L120
    L81:
        if (r7 >= (-r8)) goto L100;
        if (r3.h4() == false) goto L86;
        r3.G3().foldFloatChat(false, "dealExpandOrFold_direct_down");
        goto L120
    L86:
        if (r6 <= r3.H3()) goto L98;
        va8.n r113 = (va8.n) r3.q.getValue();
        if (r113 != null) goto L90;
    L92:
        boolean r114 = false;
    L93:
        if (r114 == false) goto L97;
        va8.n r115 = (va8.n) r3.q.getValue();
        if (r115 == null) goto L97;
        r115.hideKeyboard();
    L97:
        r3.G3().toHalfScreen(true, "dealExpandOrFold_down");
        goto L120
    L90:
        if (r113.w() != true) goto L92;
        r114 = true;
        goto L93
    L98:
        r3.G3().foldFloatChat(false, "dealExpandOrFold_down");
        goto L120
    L100:
        if (r3.h4() == false) goto L117;
        View r116 = r3.A;
        if (r116 == null) goto L104;
        Float r117 = Float.valueOf(r116.getTranslationY());
    L106:
        if (Intrinsics.areEqual(r117, 0.0f) == true) goto L117;
        View r118 = r3.A;
        if (r118 == null) goto L120;
        ViewPropertyAnimator r119 = r118.animate();
        if (r119 == null) goto L120;
        ViewPropertyAnimator r120 = r119.translationY(0.0f);
        if (r120 == null) goto L120;
        ViewPropertyAnimator r121 = r120.setDuration(r3.D3());
        if (r121 == null) goto L120;
        r121.start();
        goto L120
    L104:
        r117 = null;
    L117:
        if (r6 <= r3.H3()) goto L119;
        r3.G3().toNineSplitScreen(true, "rollback");
        goto L120
    L119:
        r3.G3().toHalfScreen(true, "dealExpandOrFold_reset");
        goto L120
    L65:
        r6 = 0;
    L120:
        this.b = null;
        if (r12 == null) goto L149;
        ViewParent r122 = r12.getParent();
        if (r122 == null) goto L150;
        r122.requestDisallowInterceptTouchEvent(false);
        return true;
    L150:
        return true;
    L149:
        return true;
    L23:
        if (r2.intValue() != 2) goto L56;
        Float r123 = this.a;
        if (r123 == null) goto L142;
        FloatChatFoldHandlerComponent r4 = this.d;
        float r124 = r123.floatValue() - r13.getRawY();
        this.a = Float.valueOf(r13.getRawY());
        this.c += r124;
        int r125 = FloatChatFoldHandlerComponent.H1;
        if (r4.h4() == false) goto L33;
        float r126 = this.c;
        if (r126 >= 0.0f) goto L33;
        View r127 = r4.A;
        if (r127 == null) goto L145;
        r127.setTranslationY(-r126);
        return true;
    L145:
        return true;
    L33:
        View r128 = r4.A;
        if (r128 == null) goto L36;
        r128.setTranslationY(0.0f);
    L36:
        View r129 = r4.A;
        if (r129 == null) goto L39;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
    L41:
        if ((r130 instanceof FrameLayout.LayoutParams) == false) goto L43;
        r0 = (FrameLayout.LayoutParams) r130;
    L43:
        if (r0 != null) goto L45;
    L53:
        View r131 = r4.A;
        if (r131 == null) goto L147;
        r131.setLayoutParams(r0);
        return true;
    L147:
        return true;
    L45:
        if (r4.h4() == false) goto L47;
        int r132 = r4.C3();
    L48:
        float r9 = r0.height + r124;
        if (r9 < r4.Q3()) goto L53;
        if (r9 > r132) goto L53;
        r0.height = (int) r9;
        r4.G3().setDragging();
        goto L53
    L47:
        r132 = r4.V3();
        goto L48
    L39:
        r130 = null;
        goto L41
    L5:
        r2 = null;
        goto L7
    }
}
