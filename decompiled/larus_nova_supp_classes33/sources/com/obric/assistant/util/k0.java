package com.obric.assistant.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.view.ObricSwipeGestureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k0 implements ObricSwipeGestureView.c {
    public final /* synthetic */ j0 a;

    public k0(j0 r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void E(float r4) {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = this.a.g();
        r0.getClass();
        if ((r1 instanceof vda.d) == false) goto L5;
        return;
    L5:
        if ((this.a.g() instanceof vda.b) == true) goto L17;
        j0 r2 = this.a;
        if (r2.k == false) goto L11;
        return;
    L11:
        if (r2.b.UR("onSwipe") == false) goto L14;
        this.a.h();
        return;
    L14:
        j0.a(this.a, r4, 0.0f, false);
        return;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void F4(PointF r13) {
        Intrinsics.checkNotNullParameter(r13, "pointF");
        j0 r0 = this.a;
        PointF r1 = new PointF(r13.x, r13.y);
        r0.getClass();
        FLogger.a.i("AutoIncreaseUtils", "onClickTitleBar, downPoint = " + r1);
        ViewGroup r14 = r0.b.getTitleContainer();
        if (r14 != null) goto L5;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L50;
        ViewGroup r16 = r0.b.getTitleContainer();
        if (r16 == null) goto L43;
        int r2 = r16.getChildCount();
        int r5 = 0;
    L16:
        if (r5 >= r2) goto L51;
        View r6 = r16.getChildAt(r5);
        if (r6.getVisibility() != 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L42;
        if (r6.getAlpha() != 1.0f) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L42;
        float r9 = r6.getX();
        float r10 = r6.getX() + r6.getWidth();
        float r11 = r1.x;
        if (r9 <= r11) goto L30;
    L32:
        boolean r12 = false;
    L33:
        if (r12 == false) goto L42;
        float r17 = r6.getY();
        float r18 = r6.getY() + r6.getHeight();
        float r19 = r1.y;
        if (r17 <= r19) goto L37;
    L39:
        boolean r20 = false;
    L40:
        if (r20 == false) goto L42;
        r6.performClick();
        goto L42
    L37:
        if (r19 > r18) goto L39;
        r20 = true;
        goto L40
    L30:
        if (r11 > r10) goto L32;
        r12 = true;
        goto L33
    L25:
        r8 = false;
    L42:
        FLogger.a.i("AutoIncreaseUtils", "onClickTitleBar, it is " + r6 + ", \nrect is " + r6.getX() + ", " + r6.getY() + ", " + (r6.getX() + r6.getWidth()) + ", " + (r6.getY() + r6.getHeight()));
        r5 = r5 + 1;
        goto L16
    L20:
        r7 = false;
        goto L21
    L51:
        return;
    L43:
        return;
    L50:
        return;
    L5:
        if (r14.getVisibility() != 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 != true) goto L10;
        r15 = true;
        goto L11
    L7:
        r110 = false;
        goto L8
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        j0 r3 = this.a;
        r3.k = false;
        if (r3.b.G1() != this.a.g().getHeight()) goto L6;
        j0 r4 = this.a;
        r4.i = r4.b.G1();
        return;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void s5(float r3, float r4) {
        j0 r0 = this.a;
        if (r0.k == false) goto L6;
        return;
    L6:
        if (r0.b.UR("onSwipeFinish") == false) goto L9;
        this.a.h();
        return;
    L9:
        j0.a(this.a, r3, r4, true);
    }
}
