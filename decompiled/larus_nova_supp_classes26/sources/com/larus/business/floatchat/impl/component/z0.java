package com.larus.business.floatchat.impl.component;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.utils.logger.FLogger;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z0 implements View.OnTouchListener {
    public float a;
    public int b;
    public FloatChatWindowState c;
    public final /* synthetic */ AIFloatChatWindowStateComponent d;
    public final /* synthetic */ int e;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ AIFloatChatWindowStateComponent a;

        public a(AIFloatChatWindowStateComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            AIFloatChatWindowStateComponent r10 = this.a;
            int r11 = AIFloatChatWindowStateComponent.S1;
            va8.p r12 = (va8.p) r10.m.getValue();
            if (r12 == null) goto L6;
            r12.n2();
            return;
        }
    }

    public z0(AIFloatChatWindowStateComponent r1, int r2) {
        this.d = r1;
        this.e = r2;
        this.c = FloatChatWindowState.Collapsed;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r14, MotionEvent r15) {
        boolean r16 = false;
        if (r15 != null) goto L5;
        return false;
    L5:
        int r0 = r15.getAction();
        if (r0 == 0) goto L105;
        if (r0 != 1) goto L9;
    L14:
        float r1 = this.a - r15.getRawY();
        int r4 = this.d.x;
        if (r15.getActionMasked() == 1) goto L17;
    L23:
        AIFloatChatWindowStateComponent r17 = this.d;
        if (r17.getWindowState() == FloatChatWindowState.Collapsed) goto L26;
    L54:
        boolean r18 = false;
    L55:
        if (r18 == false) goto L80;
        AIFloatChatWindowStateComponent r19 = this.d;
        r19.getClass();
        FLogger r2 = FLogger.a;
        StringBuilder r5 = new StringBuilder("closeInputPanelByCollapsedDragDown, imePadding=");
        r5.append(r19.X);
        r5.append(", bottomMenu=");
        r5.append(r19.W);
        r5.append(", coreIme=");
        va8.n r6 = (va8.n) r19.n.getValue();
        Boolean r7 = null;
        if (r6 == null) goto L59;
        Boolean r8 = Boolean.valueOf(r6.w());
    L60:
        r5.append(r8);
        r5.append(", coreMenu=");
        ICoreInputAbility r9 = (ICoreInputAbility) r19.o.getValue();
        if (r9 == null) goto L63;
        r7 = Boolean.valueOf(r9.E50());
    L63:
        r5.append(r7);
        r2.i("AIFloatChatWindowStateComponent", r5.toString());
        r19.hn(new va8.f(FloatChatWindowEventType.ManualDragDown, null, null, null, null, true, 30));
        r19.g();
        if (r19.W > 0) goto L74;
        ICoreInputAbility r3 = (ICoreInputAbility) r19.o.getValue();
        if (r3 != null) goto L68;
    L70:
        boolean r10 = false;
    L71:
        if (r10 == true) goto L74;
        boolean r11 = false;
    L75:
        if (r11 == false) goto L86;
        ICoreInputAbility r110 = (ICoreInputAbility) r19.o.getValue();
        if (r110 == null) goto L86;
        r110.C1(false, true, "ai_float_chat_drag_down");
    L86:
        AIFloatChatWindowStateComponent r111 = this.d;
        if (r111.h1 == false) goto L93;
        r111.h1 = false;
        if (r111.getWindowState() != FloatChatWindowState.Collapsed) goto L92;
        r111.h3(0);
        goto L93
    L92:
        r111.E3();
        r111.W4(255);
    L93:
        ValueAnimator r112 = this.d.V0;
        if (r112 != null) goto L96;
    L98:
        boolean r113 = false;
    L99:
        if (r113 == true) goto L101;
        AIFloatChatWindowStateComponent.B3(this.d);
    L101:
        AIFloatChatWindowStateComponent r114 = this.d;
        if (r114.getWindowState() == FloatChatWindowState.Expanded) goto L104;
        r16 = true;
    L104:
        r114.m3(r16);
    L132:
        return true;
    L96:
        if (r112.isRunning() != true) goto L98;
        r113 = true;
        goto L99
    L68:
        if (r3.E50() != true) goto L70;
        r10 = true;
    L74:
        r11 = true;
        goto L75
    L59:
        r8 = null;
        goto L60
    L80:
        if (r1 <= r4) goto L83;
        this.d.hn(new va8.f(FloatChatWindowEventType.ManualDragUp, null, null, null, null, true, 30));
        goto L86
    L83:
        if (r1 >= (-r4)) goto L85;
        this.d.hn(new va8.f(FloatChatWindowEventType.ManualDragDown, null, null, null, null, true, 30));
        goto L86
    L85:
        this.d.hn(new va8.f(FloatChatWindowEventType.Rebound, null, null, null, null, true, 30));
        goto L86
    L26:
        if (r1 >= (-r4)) goto L54;
        if (r17.X > 0) goto L38;
        va8.n r12 = (va8.n) r17.n.getValue();
        if (r12 != null) goto L32;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == true) goto L38;
        boolean r20 = false;
    L39:
        if (r20 == false) goto L41;
    L53:
        r18 = true;
        goto L55
    L41:
        if (r17.W > 0) goto L51;
        ICoreInputAbility r115 = (ICoreInputAbility) r17.o.getValue();
        if (r115 != null) goto L45;
    L47:
        boolean r116 = false;
    L48:
        if (r116 == true) goto L51;
        boolean r117 = false;
    L52:
        if (r117 == false) goto L54;
    L45:
        if (r115.E50() != true) goto L47;
        r116 = true;
    L51:
        r117 = true;
        goto L52
    L32:
        if (r12.w() != true) goto L34;
        r13 = true;
    L38:
        r20 = true;
        goto L39
    L17:
        if (Math.abs(r1) > this.e) goto L23;
        FloatChatWindowState r118 = this.c;
        if (r118 != FloatChatWindowState.Collapsed) goto L21;
    L22:
        this.d.hn(new va8.f(FloatChatWindowEventType.ManualDragUp, null, null, null, null, true, 30));
        goto L86
    L21:
        if (r118 != FloatChatWindowState.Preview) goto L23;
    L9:
        if (r0 != 2) goto L11;
        int r119 = MathKt.roundToInt(this.a - r15.getRawY());
        AIFloatChatWindowStateComponent r120 = this.d;
        int r21 = AIFloatChatWindowStateComponent.S1;
        int r121 = r120.Z3();
        int r122 = RangesKt.coerceIn(this.b + r119, r121, RangesKt.coerceAtLeast(this.d.a4(), r121));
        this.d.d5(r122);
        AIFloatChatWindowStateComponent.Y2(this.d, r122);
        goto L132
    L11:
        if (r0 == 3) goto L14;
        return false;
    L105:
        AIFloatChatWindowStateComponent r22 = this.d;
        int r23 = AIFloatChatWindowStateComponent.S1;
        IChatMessageShareAbility r24 = (IChatMessageShareAbility) r22.t.getValue();
        if (r24 != null) goto L108;
    L110:
        boolean r25 = false;
    L111:
        if (r25 == false) goto L114;
        FLogger.a.i("AIFloatChatWindowStateComponent", "ignore top handle drag in message select mode");
        return false;
    L114:
        FloatChatWindowState r123 = this.d.getWindowState();
        FloatChatWindowState r26 = FloatChatWindowState.Collapsed;
        if (r123 != r26) goto L127;
        FLogger.a.i("AIFloatChatWindowStateComponent", "request scrollToLatestOnNextLayout for drag expand");
        AIFloatChatWindowStateComponent r124 = this.d;
        RecyclerView r27 = r124.K;
        if (r27 == null) goto L119;
        r27.addOnLayoutChangeListener(new a(r124));
    L119:
        AIFloatChatWindowStateComponent r125 = this.d;
        if (r125.i4() == false) goto L127;
        if (r125.getWindowState() != r26) goto L127;
        if (r125.rN() >= (r125.QK() + r125.A)) goto L127;
        r125.h1 = true;
        r125.h3(255);
    L127:
        this.d.d4().updateDraggingState(true);
        this.d.j4();
        this.c = this.d.getWindowState();
        this.a = r15.getRawY();
        AIFloatChatWindowStateComponent r126 = this.d;
        View r127 = r126.F;
        if (r127 == null) goto L130;
        int r128 = r127.getHeight();
    L131:
        this.b = r128;
        AIFloatChatWindowStateComponent.Y2(this.d, r128);
        this.d.m3(true);
        goto L132
    L130:
        FloatChatWindowState r129 = r126.getWindowState();
        r128 = r126.Q3(r129, AIFloatChatWindowStateComponent.W3(r126, r129));
        goto L131
    L108:
        if (r24.H1() != true) goto L110;
        r25 = true;
        goto L111
    }
}
