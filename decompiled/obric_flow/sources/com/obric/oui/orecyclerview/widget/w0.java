package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13927c;
    public boolean d;
    public boolean e;
    public Object f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f13928h;

    public w0(en.l r5) {
        this.f13925a = 1;
        this.e = true;
        this.f13928h = new en.f();
        this.f = new WeakReference(r5);
        this.g = null;
        this.d = false;
    }

    public void a() {
        LynxLog.b(2, "UIList", "ListScroller stop");
        androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) ((WeakReference) this.f).get();
        this.d = false;
        if (r5 == null) goto L6;
        r5.removeOnItemTouchListener((en.f) this.f13928h);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13925a) {
            case 0: goto L100;
            default: goto L4;
        };
    L4:
        androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) ((WeakReference) this.f).get();
        if (r5 != null) goto L7;
    L98:
        a();
        return;
    L7:
        if (r5.getLayoutManager() == null) goto L98;
        if (r5.getChildCount() == 0) goto L98;
        boolean r10 = false;
        if (this.d == true) goto L14;
        ((Callback) this.g).invoke(new Object[]{0});
        a();
        return;
    L14:
        boolean r11 = true;
        int r12 = Math.min(this.f13926b, r5.getLayoutManager().getItemCount() - 1);
        this.f13926b = r12;
        this.f13926b = Math.max(r12, 0);
        if (r5.getChildCount() > 0) goto L96;
        androidx.recyclerview.widget.RecyclerView.LayoutManager r13 = r5.getLayoutManager();
        int r14 = r5.getChildCount();
        int r15 = r13.getItemCount();
        this.f13927c = r15;
        if (r14 > 0) goto L94;
        int r16 = this.f13926b;
        if (r15 <= r16) goto L21;
        int r17 = -1;
    L22:
        int r18 = 1 - r15;
        if (r17 != (-1)) goto L26;
        r16 = r15 - r16;
    L26:
        if (this.e == false) goto L28;
        int r19 = r5.getHeight();
    L29:
        int r20 = (r16 * r19) / r18;
        if (r16 > 30) goto L32;
    L38:
        int r21 = Math.min(r19, s6.c.e * r16) * r17;
        boolean r22 = this.e;
        if (r21 == 0) goto L88;
        if (r21 <= 0) goto L43;
        byte r23 = 1;
    L44:
        androidx.recyclerview.widget.RecyclerView.LayoutManager r24 = r5.getLayoutManager();
        int r25 = r5.getChildCount();
        if (r5.findViewHolderForLayoutPosition(0) == null) goto L47;
        boolean r110 = true;
    L49:
        if (r5.findViewHolderForLayoutPosition(r24.getItemCount() - 1) == null) goto L51;
        boolean r111 = true;
    L52:
        if (r110 == false) goto L54;
        if ((-1) != r23) goto L54;
    L56:
        int r112 = Integer.MAX_VALUE;
        int r113 = Integer.MIN_VALUE;
        int r114 = 0;
    L57:
        if (r114 >= r25) goto L68;
        View r115 = r5.getChildAt(r114);
        if (r22 == false) goto L62;
        int r26 = Math.min(r24.getDecoratedTop(r115), r112);
    L61:
        r112 = r26;
        if (r22 == false) goto L66;
        int r27 = Math.max(r24.getDecoratedBottom(r115), r113);
    L65:
        r113 = r27;
        r114 = r114 + 1;
        goto L57
    L66:
        r27 = Math.max(r24.getDecoratedRight(r115), r113);
        goto L65
    L62:
        r26 = Math.min(r24.getDecoratedLeft(r115), r112);
        goto L61
    L68:
        if (r22 == false) goto L70;
        int r28 = r24.getPaddingTop();
    L71:
        if (r22 == false) goto L74;
        int r29 = r24.getHeight();
        int r30 = r24.getPaddingBottom();
    L73:
        int r31 = r29 - r30;
        if (r110 == false) goto L79;
        if ((-1) != r23) goto L79;
        if (r112 < r28) goto L84;
    L83:
        r10 = false;
    L84:
        if (r22 == false) goto L86;
        r5.scrollBy(0, r21);
    L87:
        r10 = true;
        goto L88
    L86:
        r5.scrollBy(r21, 0);
    L79:
        if (r111 == false) goto L84;
        if (1 != r23) goto L84;
        if (r113 <= r31) goto L83;
    L74:
        r29 = r24.getWidth();
        r30 = r24.getPaddingRight();
        goto L73
    L70:
        r28 = r24.getPaddingLeft();
    L54:
        if (r111 == false) goto L84;
        if (1 != r23) goto L84;
    L51:
        r111 = false;
        goto L52
    L47:
        r110 = false;
        goto L49
    L43:
        r23 = -1;
    L88:
        if (r10 == true) goto L90;
        ((Callback) this.g).invoke(new Object[]{4, "can not scroll when come to border"});
    L90:
        r11 = r10;
    L91:
        if (r11 == false) goto L93;
        r5.post(this);
        return;
    L93:
        a();
        return;
    L32:
        if (r20 <= (r19 * 10)) goto L38;
        int r32 = this.f13927c;
        int r33 = this.f13926b;
        if (r32 > r33) goto L37;
        r32 = 0;
    L37:
        r5.scrollToPosition(ai.j0.c(r32, r33, 2, r33));
        goto L91
    L28:
        r19 = r5.getWidth();
        goto L29
    L21:
        r17 = 1;
        goto L22
    L94:
        r5.getChildAt(0).getClass();
        throw new ClassCastException();
    L96:
        r5.getChildAt(0).getClass();
        throw new ClassCastException();
    L100:
        RecyclerView r34 = (RecyclerView) this.f13928h;
        if (r34.f13743m != null) goto L106;
        r34.removeCallbacks(this);
        com.obric.oui.orecyclerview.base.f r35 = (com.obric.oui.orecyclerview.base.f) this.f;
        if (r35.f == false) goto L105;
        r35.c().abortAnimation();
        return;
    L105:
        r35.g = -1;
        return;
    L106:
        this.e = false;
        this.d = true;
        r34.n();
        com.obric.oui.orecyclerview.base.f r116 = (com.obric.oui.orecyclerview.base.f) this.f;
        if (r116.f == false) goto L110;
        boolean r36 = r116.c().computeScrollOffset();
    L113:
        if (r36 == false) goto L209;
        int r37 = r116.a();
        int r38 = r116.b();
        int r39 = r37 - this.f13926b;
        int r40 = r38 - this.f13927c;
        this.f13926b = r37;
        this.f13927c = r38;
        int r41 = r34.m(r39, r34.F);
        int r42 = r34.m(r40, r34.G);
        int[] r43 = r34.f13746n0;
        r43[0] = 0;
        r43[1] = 0;
        boolean r44 = r34.dispatchNestedPreScroll(r41, r42, r43, null, 1);
        int[] r117 = r34.f13746n0;
        if (r44 == false) goto L118;
        r41 = r41 - r117[0];
        r42 = r42 - r117[1];
    L118:
        if (r34.f13742l == null) goto L120;
        r117[0] = 0;
        r117[1] = 0;
        r34.U(r41, r42, r117);
        int r45 = r117[0];
        int r46 = r117[1];
        r34.f13743m.getClass();
        int r118 = r45;
        int r119 = r46;
        int r120 = r41 - r45;
        int r121 = r42 - r46;
    L122:
        if (r34.f13747o.isEmpty() == true) goto L124;
        r34.invalidate();
    L124:
        int[] r47 = r34.f13746n0;
        r47[0] = 0;
        r47[1] = 0;
        r34.dispatchNestedScroll(r118, r119, r120, r121, null, 1, r47);
        int r122 = r120 - r117[0];
        int r123 = r121 - r117[1];
        if (r118 != 0) goto L127;
        if (r119 != 0) goto L127;
    L129:
        if (RecyclerView.c(r34) == true) goto L131;
        r34.invalidate();
    L131:
        int r48 = r116.a();
        boolean r49 = r116.f;
        Lazy r50 = r116.d;
        if (r49 == false) goto L134;
        int r51 = r116.c().getFinalX();
    L135:
        if (r48 != r51) goto L137;
        boolean r52 = true;
    L138:
        int r53 = r116.b();
        boolean r54 = r116.f;
        Lazy r55 = r116.e;
        if (r54 == false) goto L141;
        int r56 = r116.c().getFinalY();
    L142:
        if (r53 != r56) goto L144;
        boolean r57 = true;
    L146:
        if (r116.d() == true) goto L153;
        if (r52 == true) goto L149;
        if (r122 != 0) goto L149;
    L152:
        boolean r58 = false;
    L154:
        r34.f13743m.getClass();
        if (r58 == false) goto L203;
        if (r34.getOverScrollMode() == 2) goto L197;
        if (r116.f == false) goto L161;
        float r59 = r116.c().getCurrVelocity();
    L162:
        int r60 = (int) r59;
        if (r122 >= 0) goto L165;
        int r61 = r60;
    L168:
        if (r123 < 0) goto L173;
        if (r123 <= 0) goto L172;
        r60 = -r60;
        goto L173
    L172:
        r60 = 0;
    L173:
        if (r61 != 0) goto L175;
    L183:
        if (r60 != 0) goto L185;
    L193:
        if (r61 != 0) goto L195;
        if (r60 == 0) goto L197;
    L195:
        ViewCompat.postInvalidateOnAnimation(r34);
        goto L197
    L185:
        if (r34.G != null) goto L188;
        com.obric.oui.orecyclerview.base.a r62 = new com.obric.oui.orecyclerview.base.a(r34.getContext());
        r34.G = r62;
        r62.f13701a = r34.getHeight() / r62.f13705i.density;
    L188:
        com.obric.oui.orecyclerview.base.a r63 = r34.G;
        if (r63.f13704h == false) goto L191;
    L192:
        r63.b(r60);
        goto L193
    L191:
        if (r34.f13750p0 == false) goto L193;
    L175:
        if (r34.F != null) goto L178;
        com.obric.oui.orecyclerview.base.a r64 = new com.obric.oui.orecyclerview.base.a(r34.getContext());
        r34.F = r64;
        r64.f13701a = r34.getWidth() / r64.f13705i.density;
    L178:
        com.obric.oui.orecyclerview.base.a r65 = r34.F;
        if (r65.f13704h == false) goto L181;
    L182:
        r65.b(r61);
        goto L183
    L181:
        if (r34.f13750p0 == false) goto L183;
    L165:
        if (r122 <= 0) goto L167;
        r61 = -r60;
        goto L168
    L167:
        r61 = 0;
        goto L168
    L161:
        r59 = ((float) Math.hypot(((com.obric.oui.orecyclerview.base.c) r50.getValue()).c(r116.f13718h).f13707b, ((com.obric.oui.orecyclerview.base.c) r55.getValue()).c(r116.f13718h).f13707b)) * 1000;
    L197:
        if (RecyclerView.C0 == false) goto L209;
        com.airbnb.lottie.parser.moshi.c r66 = r34.f13727a0;
        int[] r67 = (int[]) r66.d;
        if (r67 == null) goto L201;
        Arrays.fill(r67, -1);
    L201:
        r66.f1315c = 0;
        goto L209
    L203:
        if (this.d == false) goto L205;
        this.e = true;
    L206:
        o r68 = r34.W;
        if (r68 == null) goto L209;
        r68.a(r34, r118, r119);
        goto L209
    L205:
        r34.removeCallbacks(this);
        ViewCompat.postOnAnimation(r34, this);
    L149:
        if (r57 == true) goto L153;
        if (r123 == 0) goto L152;
    L153:
        r58 = true;
        goto L154
    L144:
        r57 = false;
        goto L146
    L141:
        r56 = (int) ((com.obric.oui.orecyclerview.base.c) r55.getValue()).a();
        goto L142
    L137:
        r52 = false;
        goto L138
    L134:
        r51 = (int) ((com.obric.oui.orecyclerview.base.c) r50.getValue()).a();
    L127:
        r34.s(r118, r119);
        goto L129
    L120:
        r120 = r41;
        r121 = r42;
        r118 = 0;
        r119 = 0;
    L209:
        r34.f13743m.getClass();
        this.d = false;
        if (this.e == false) goto L212;
        r34.removeCallbacks(this);
        ViewCompat.postOnAnimation(r34, this);
        return;
    L212:
        r34.setScrollState(0);
        r34.stopNestedScroll(1);
        return;
    L110:
        if (r116.g != (-1)) goto L112;
        r36 = false;
        goto L113
    L112:
        r116.f13718h = AnimationUtils.currentAnimationTimeMillis() - r116.g;
        r36 = !r116.d();
        goto L113
    }

    public w0(RecyclerView r5) {
        this.f13925a = 0;
        this.f13928h = r5;
        x r10 = RecyclerView.E0;
        this.g = r10;
        this.d = false;
        this.e = false;
        this.f = new com.obric.oui.orecyclerview.base.f(r5.getContext(), r10);
    }
}
