package com.larus.business.floatchat.impl.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 implements View.OnTouchListener {
    public Float a;
    public Integer b;
    public final /* synthetic */ AIFloatChatFoldHandlerComponent c;

    public c0(AIFloatChatFoldHandlerComponent r1) {
        this.c = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r9, MotionEvent r10) {
        FrameLayout.LayoutParams r11 = null;
        Integer r12 = null;
        if (r10 == null) goto L5;
        Integer r0 = Integer.valueOf(r10.getAction());
    L7:
        if (r0 != null) goto L10;
    L15:
        boolean r2 = false;
        if (r0 != null) goto L19;
    L38:
        if (r0 != null) goto L41;
    L74:
        return false;
    L41:
        if (r0.intValue() != 1) goto L74;
        Integer r13 = this.b;
        if (r13 == null) goto L73;
        AIFloatChatFoldHandlerComponent r1 = this.c;
        int r14 = r13.intValue();
        View r3 = r1.y;
        if (r3 == null) goto L47;
        int r4 = r3.getHeight();
    L48:
        if (r4 == 0) goto L73;
        int r15 = r4 - r14;
        int r5 = c7.b(50);
        FLogger.a.i("AIFloatChatFoldHandlerComponent", "dealExpandOrFold, deltaHeight = " + r15 + ", threshold = " + r5);
        if (r15 <= 0) goto L55;
        if (r15 <= r5) goto L53;
        r1.m3().toNineSplitScreen(true, "expand");
        goto L73
    L53:
        r1.m3().toHalfScreen(true, "dealExpandOrFold_up");
        goto L73
    L55:
        if (r15 >= (-r5)) goto L70;
        if (r4 <= r1.p3()) goto L68;
        va8.n r16 = (va8.n) r1.q.getValue();
        if (r16 != null) goto L61;
    L63:
        if (r2 == false) goto L67;
        va8.n r17 = (va8.n) r1.q.getValue();
        if (r17 == null) goto L67;
        r17.hideKeyboard();
    L67:
        r1.m3().toHalfScreen(true, "dealExpandOrFold_down");
        goto L73
    L61:
        if (r16.w() != true) goto L63;
        r2 = true;
        goto L63
    L68:
        r1.m3().foldFloatChat(false, "dealExpandOrFold_down");
        goto L73
    L70:
        if (r4 <= r1.p3()) goto L72;
        r1.m3().toNineSplitScreen(true, "rollback");
        goto L73
    L72:
        r1.m3().toHalfScreen(true, "dealExpandOrFold_reset");
        goto L73
    L47:
        r4 = 0;
    L73:
        this.b = null;
        return true;
    L19:
        if (r0.intValue() != 2) goto L38;
        Float r6 = this.a;
        if (r6 == null) goto L74;
        AIFloatChatFoldHandlerComponent r7 = this.c;
        float r8 = r6.floatValue() - r10.getRawY();
        this.a = Float.valueOf(r10.getRawY());
        View r18 = r7.y;
        if (r18 == null) goto L25;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
    L27:
        if ((r19 instanceof FrameLayout.LayoutParams) == false) goto L29;
        r11 = (FrameLayout.LayoutParams) r19;
    L29:
        if (r11 == null) goto L35;
        float r110 = r11.height + r8;
        if (r110 < ((Number) r7.H.getValue()).intValue()) goto L35;
        if (r110 > r7.p3()) goto L35;
        r11.height = (int) r110;
        r7.m3().setDragging();
    L35:
        View r111 = r7.y;
        if (r111 == null) goto L77;
        r111.setLayoutParams(r11);
        return true;
    L77:
        return true;
    L25:
        r19 = null;
        goto L27
    L10:
        if (r0.intValue() != 0) goto L15;
        this.a = Float.valueOf(r10.getRawY());
        View r112 = this.c.y;
        if (r112 == null) goto L14;
        r12 = Integer.valueOf(r112.getHeight());
    L14:
        this.b = r12;
        return true;
    L5:
        r0 = null;
        goto L7
    }
}
