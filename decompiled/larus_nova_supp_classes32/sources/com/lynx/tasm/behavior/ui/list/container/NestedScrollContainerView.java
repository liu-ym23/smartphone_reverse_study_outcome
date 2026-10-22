package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NestedScrollContainerView extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2, ScrollingView {
    public static final a x = null;
    public e7a.f a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final int[] l;
    public final int[] m;
    public final int[] n;
    public final int[] o;
    public final int[] p;
    public VelocityTracker q;
    public final f r;
    public final ArrayList<e> s;
    public final ArrayList<d> t;
    public final NestedScrollingParentHelper u;
    public final NestedScrollingChildHelper v;
    public boolean w;

    public static class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r3) {
            float r4 = r3 - 1.0f;
            return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
        }
    }

    public class b implements View.OnTouchListener {
        public final /* synthetic */ boolean a;

        public b(boolean r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return !this.a;
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a();
    }

    public interface d {
        void a();
    }

    public interface e {
        void o(int r1);
    }

    public class f implements Runnable {
        public int a;
        public int b;
        public int c;
        public int d;
        public final f7a.a e;
        public c f;
        public final /* synthetic */ NestedScrollContainerView g;

        public final void a() {
            f7a.a r1 = this.e;
            boolean r4 = false;
            if (r1.b() == false) goto L53;
            NestedScrollContainerView r5 = this.g;
            int[] r2 = r5.m;
            int r6 = r1.b.b;
            int r3 = r1.c.b;
            c r7 = this.f;
            if (r7 == null) goto L28;
            int[] r8 = r5.p;
            UIListContainer.a r9 = (UIListContainer.a) r7;
            UIListContainer r10 = r9.c;
            boolean r11 = r10.a;
            if (r11 == true) goto L9;
            int r12 = r6;
        L10:
            int r13 = r9.a;
            if (r13 == 0) goto L13;
            r12 = (int) (r12 * ((r10.D * 1.0f) / r13));
        L13:
            int r14 = r10.D;
            if (r14 <= 0) goto L21;
            boolean r15 = r9.b;
            if (r15 == false) goto L18;
            if (r12 <= r14) goto L18;
        L20:
            r12 = r14;
        L18:
            if (r15 == true) goto L21;
            if (r12 < r14) goto L20;
        L21:
            if (r11 == true) goto L24;
            r6 = r12;
        L24:
            r8[0] = r6;
            if (r11 == false) goto L27;
            r3 = r12;
        L27:
            r8[1] = r3;
        L29:
            int r16 = r6;
            int r17 = r16 - this.a;
            int r18 = r3 - this.b;
            if (r5.dispatchNestedPreScroll(r17, r18, r2, null, 1) == false) goto L32;
            r17 = r17 - r2[0];
            r18 = r18 - r2[1];
        L32:
            NestedScrollContainerView r19 = this.g;
            int[] r20 = r19.o;
            r20[0] = 0;
            r20[1] = 0;
            NestedScrollContainerView.a(r19, r17, r18, r20);
            NestedScrollContainerView r110 = this.g;
            int[] r21 = r110.o;
            int r111 = r21[0];
            int r112 = r21[1];
            int r22 = r17 - r111;
            int r23 = r18 - r112;
            r110.dispatchNestedScroll(r111, r112, r22, r23, null, 1);
            NestedScrollContainerView r24 = this.g;
            boolean r25 = r24.b;
            if (r25 == false) goto L38;
            if (r18 == 0) goto L37;
            if (r18 == 0) goto L38;
            if (r23 != 0) goto L38;
        L37:
            boolean r26 = true;
        L39:
            if (r25 == true) goto L44;
            if (r17 == 0) goto L43;
            if (r17 == 0) goto L44;
            if (r22 != 0) goto L44;
        L43:
            boolean r27 = true;
        L45:
            if (r27 == true) goto L47;
            if (r26 == true) goto L47;
        L48:
            if (r4 == false) goto L50;
        L52:
            this.a = this.g.getScrollX();
            int r28 = this.g.getScrollY();
            this.b = r28;
            this.c += r16 - this.a;
            this.d += r3 - r28;
            this.g.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.g, this);
            return;
        L50:
            if (r24.hasNestedScrollingParent(1) == true) goto L52;
            this.g.setScrollState(1);
        L47:
            r4 = true;
        L44:
            r27 = false;
        L38:
            r26 = false;
            goto L39
        L9:
            r12 = r3;
            goto L10
        L28:
            r6 = r6 - this.c;
            r3 = r3 - this.d;
            goto L29
        L53:
            this.g.setScrollState(1);
            if (this.g.hasNestedScrollingParent(1) == false) goto L56;
            this.g.stopNestedScroll(1);
        L56:
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            c r29 = this.f;
            if (r29 == null) goto L61;
            r29.a();
            return;
        }

        public final boolean b() {
            NestedScrollContainerView r0 = this.g;
            if (r0.a != null) goto L6;
            return false;
        L6:
            if (r0.j != 1) goto L8;
            return false;
        L8:
            r0.setScrollState(3);
            this.f = null;
            this.a = this.g.getScrollX();
            this.b = this.g.getScrollY();
            this.c = 0;
            this.d = 0;
            c(0, 0);
            this.g.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.g, this);
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(NestedScrollContainerView r3) {
            this.g = r3;
            this.e = new f7a.a(r3.getContext(), NestedScrollContainerView.x);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int r22, int r23) {
            NestedScrollContainerView r1 = this.g;
            e7a.f r2 = r1.a;
            boolean r3 = r1.b;
            boolean r4 = r1.e();
            r2.b = r3;
            r2.c = r4;
            int[] r5 = {0, 0};
            if (r3 == false) goto L6;
            if (r23 != 0) goto L7;
        L8:
            boolean r6 = false;
        L9:
            if (r6 == true) goto L11;
        L13:
            boolean r7 = false;
        L14:
            if (r7 == false) goto L83;
            if (r3 == false) goto L17;
            int r8 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getHeight();
        L18:
            if (r8 <= 0) goto L83;
            boolean r9 = r2.b;
            if (r9 == false) goto L23;
            int r11 = r23;
        L24:
            if (r9 == false) goto L26;
            int r10 = ((UIListContainer.d) r2.a).c();
        L28:
            if (r2.b == false) goto L32;
            if (r23 < 0) goto L31;
        L30:
            boolean r12 = true;
        L34:
            double r13 = r8;
            int r14 = (int) Math.round((r13 * Math.log1p(((double) Math.abs(r11)) / (2.0d * r13))) * 1.0d);
            if (r12 == true) goto L38;
            r14 = -r14;
        L38:
            int r15 = r14 + r10;
            ArrayList r16 = new ArrayList();
            int r17 = r2.b();
            int r18 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getLinearLayout().getChildCount();
            int r19 = Integer.MIN_VALUE;
            e7a.f.b r20 = null;
            e7a.f.b r110 = null;
            int r111 = 0;
            int r112 = Integer.MAX_VALUE;
        L39:
            if (r111 >= r18) goto L66;
            View r21 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getLinearLayout().getChildAt(r111);
            if (r21 != null) goto L43;
            int r113 = r18;
        L54:
            int r114 = r10;
        L65:
            r111 = r111 + 1;
            r18 = r113;
            r10 = r114;
            goto L39
        L43:
            int r115 = ((UIListContainer.d) r2.a).a(r21);
            r113 = r18;
            if (r115 == (-1)) goto L54;
            int r24 = r2.a(r21);
            int r116 = Math.max(0, Math.min(r24, r17));
            int r0 = r116 - r10;
            if (r12 == false) goto L49;
            if (r0 <= 0) goto L49;
        L51:
            boolean r117 = true;
        L53:
            if (r117 == false) goto L54;
            r114 = r10;
            e7a.f.b r25 = new e7a.f.b(r115, r116, r0);
            if (r24 > 0) goto L60;
            if (r20 == null) goto L59;
            if (r24 <= r19) goto L65;
        L59:
            r19 = r24;
            r20 = r25;
            goto L65
        L60:
            if (r24 < r17) goto L64;
            if (r110 == null) goto L63;
            if (r24 >= r112) goto L65;
        L63:
            r112 = r24;
            r110 = r25;
            goto L65
        L64:
            r16.add(r25);
        L49:
            if (r12 == true) goto L52;
            if (r0 < 0) goto L51;
        L52:
            r117 = false;
            goto L53
        L66:
            if (r20 == null) goto L68;
            r16.add(r20);
        L68:
            if (r110 == null) goto L71;
            r16.add(r110);
        L71:
            if (r16.isEmpty() == true) goto L83;
            Collections.sort(r16, new e7a.e());
            e7a.f.b r26 = (e7a.f.b) ListProtector.get(r16, 0);
            int r27 = Math.abs(r26.b - r15);
            Iterator r28 = r16.iterator();
            e7a.f.b r29 = r26;
        L75:
            if (r28.hasNext() == false) goto L82;
            e7a.f.b r30 = (e7a.f.b) r28.next();
            if ((Math.abs(r30.a - r26.a) + 1) > r2.f) goto L75;
            int r31 = Math.abs(r30.b - r15);
            if (r31 >= r27) goto L75;
            r29 = r30;
            r27 = r31;
            goto L75
        L82:
            int r118 = r29.a;
            int r32 = -1;
        L84:
            if (r118 != r32) goto L170;
            if (r2.b == false) goto L88;
            int r33 = ((UIListContainer.d) r2.a).c();
        L89:
            int r34 = r2.b();
            int r35 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getLinearLayout().getChildCount();
            int r36 = 0;
            View r37 = null;
            int r38 = Integer.MAX_VALUE;
            int r39 = Integer.MIN_VALUE;
            View r40 = null;
            View r119 = null;
            View r120 = null;
        L90:
            if (r36 >= r35) goto L119;
            View r121 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getLinearLayout().getChildAt(r36);
            if (r121 == null) goto L118;
            int r122 = r2.a(r121);
            if (r122 <= r34) goto L102;
            if (r119 != null) goto L98;
        L101:
            r122 = r34;
            r119 = r121;
        L110:
            int r123 = r122 - r33;
            if (r123 > 0) goto L114;
            if (r123 <= r39) goto L114;
            r40 = r119;
            r39 = r123;
        L114:
            if (r123 < 0) goto L117;
            if (r123 >= r38) goto L117;
            r37 = r119;
            r119 = r121;
            r38 = r123;
        L117:
            r119 = r121;
            goto L118
        L98:
            if (r122 < r2.a(r119)) goto L101;
            r122 = r34;
            r121 = r119;
            goto L110
        L102:
            if (r122 >= 0) goto L109;
            if (r120 != null) goto L105;
        L108:
            r120 = r121;
            r122 = 0;
            r121 = r119;
            r119 = r120;
            goto L110
        L105:
            if (r122 > r2.a(r120)) goto L108;
            r121 = r119;
            r119 = r120;
            r122 = 0;
            goto L110
        L109:
            r121 = r119;
            r119 = r121;
        L118:
            r36 = r36 + 1;
            goto L90
        L119:
            boolean r41 = r2.b;
            if (r41 == false) goto L124;
            if (r23 < 0) goto L123;
        L122:
            boolean r42 = true;
        L126:
            if (r41 == false) goto L129;
            if (r23 != 0) goto L130;
        L131:
            boolean r43 = false;
        L132:
            if (r43 == true) goto L143;
            if (r37 == null) goto L139;
            if (r40 == null) goto L139;
            if (Math.abs(r38) >= Math.abs(r39)) goto L138;
            int r44 = ((UIListContainer.d) r2.a).a(r37);
        L146:
            r118 = r44;
            int r45 = -1;
        L151:
            if (r118 != r45) goto L170;
            if (r42 == false) goto L155;
            r37 = r40;
        L155:
            if (r37 != null) goto L157;
            r118 = -1;
            goto L170
        L157:
            int r46 = ((UIListContainer.d) r2.a).a(r37);
            if (r2.b == false) goto L161;
        L165:
            if (r42 == true) goto L167;
            int r47 = -1;
        L168:
            r118 = r46 + r47;
            goto L170
        L167:
            r47 = 1;
            goto L168
        L161:
            if (r2.c == false) goto L165;
            if (r42 == true) goto L164;
            r42 = true;
            goto L165
        L164:
            r42 = false;
            goto L165
        L138:
            r44 = ((UIListContainer.d) r2.a).a(r40);
        L139:
            if (r37 == null) goto L141;
            r44 = ((UIListContainer.d) r2.a).a(r37);
            goto L146
        L141:
            if (r40 == null) goto L150;
            r44 = ((UIListContainer.d) r2.a).a(r40);
        L150:
            r45 = -1;
            r118 = -1;
            goto L151
        L143:
            if (r42 == false) goto L147;
            if (r37 == null) goto L147;
            r44 = ((UIListContainer.d) r2.a).a(r37);
        L147:
            if (r42 == true) goto L150;
            if (r40 == null) goto L150;
            r44 = ((UIListContainer.d) r2.a).a(r40);
        L130:
            r43 = true;
            goto L132
        L129:
            if (r22 == 0) goto L131;
        L123:
            r42 = false;
            goto L126
        L124:
            if (r22 < 0) goto L123;
        L88:
            r33 = ((UIListContainer.d) r2.a).b();
        L170:
            if (r2.b == false) goto L172;
            int r48 = ((UIListContainer.d) r2.a).c();
        L174:
            if (r118 == (-1)) goto L189;
            int r49 = Math.min(Math.max(r118, 0), ((UIListContainer.d) r2.a).a.c.size() - 1);
            if (r49 == (-1)) goto L188;
            UIListContainer.d r50 = (UIListContainer.d) r2.a;
            String r51 = (String) r50.a.c.get(r49);
            int r52 = 0;
        L179:
            if (r52 >= ((ListContainerView) UIListContainer.Q(r50.a)).getLinearLayout().getChildCount()) goto L184;
            View r53 = ((ListContainerView) UIListContainer.R(r50.a)).getLinearLayout().getChildAt(r52);
            if (r51.equals(((UIComponent) ((com.lynx.tasm.behavior.ui.view.b) r53).getDrawChildHook()).b) == true) goto L182;
            r52 = r52 + 1;
            goto L179
        L182:
            View r54 = r53;
        L185:
            if (r54 == null) goto L187;
            r48 = r2.a(r54);
            goto L188
        L187:
            int r55 = -1;
        L192:
            if (r2.b == false) goto L194;
            char r56 = 1;
            r5[1] = r48;
            char r57 = 0;
        L195:
            UIListContainer.d r58 = (UIListContainer.d) r2.a;
            r58.a.k0(r55, r58.b(), ((UIListContainer.d) r2.a).c(), r5[r57], r5[r56]);
            int r59 = r5[r57] - this.a;
            int r60 = r5[1] - this.b;
            if (this.g.b == false) goto L198;
            int r61 = r60;
        L199:
            int r62 = (int) (Math.ceil(Math.ceil(((double) Math.abs(r61)) * this.g.a.g)) / 0.3356d);
            if (r62 >= 100) goto L202;
            r62 = 100;
        L202:
            f7a.a r63 = this.e;
            int r64 = this.a;
            int r65 = this.b;
            r63.a = 0;
            f7a.a.C0091a r66 = r63.b;
            r66.l = false;
            r66.a = r64;
            r66.c = r64;
            r66.b = r64;
            r66.d = r64 + r59;
            r66.h = AnimationUtils.currentAnimationTimeMillis();
            r66.i = r62;
            r66.g = 0.0f;
            r66.e = 0;
            f7a.a.C0091a r67 = r63.c;
            r67.l = false;
            r67.a = r65;
            r67.c = r65;
            r67.b = r65;
            r67.d = r65 + r60;
            r67.h = AnimationUtils.currentAnimationTimeMillis();
            r67.i = r62;
            r67.g = 0.0f;
            r67.e = 0;
            return;
        L198:
            r61 = r59;
            goto L199
        L194:
            r56 = 1;
            r57 = 0;
            r5[0] = r48;
            goto L195
        L184:
            r54 = null;
        L188:
            int r124 = r49;
        L190:
            r55 = r124;
            goto L192
        L189:
            r124 = r118;
            goto L190
        L172:
            r48 = ((UIListContainer.d) r2.a).b();
        L31:
            r12 = false;
            goto L34
        L32:
            if (r22 < 0) goto L31;
        L26:
            r10 = ((UIListContainer.d) r2.a).b();
            goto L28
        L23:
            r11 = r22;
            goto L24
        L17:
            r8 = ((ListContainerView) ((UIListContainer.d) r2.a).a.getView()).getWidth();
        L83:
            r32 = -1;
            r118 = -1;
            goto L84
        L11:
            if (r2.f <= 1) goto L13;
            r7 = true;
        L7:
            r6 = true;
            goto L9
        L6:
            if (r22 == 0) goto L8;
            goto L7
        }
    }

    public boolean e() {
        return false;
    }

    public void f(boolean r1) {
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    static {
        x = new a();
    }

    private int getNestedScrollAxis() {
        if (this.b == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        if (this.b == false) goto L5;
        return 0;
    L5:
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        if (this.b == false) goto L5;
        return 0;
    L5:
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (getChildCount() > 0) goto L8;
        return r0;
    L8:
        if (getChildAt(0) == null) goto L14;
        View r1 = getChildAt(0);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L15;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        return (r1.getWidth() + r3.leftMargin) + r3.rightMargin;
    L15:
        return r0;
    L14:
        return r0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        if (this.b == true) goto L5;
        return 0;
    L5:
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        if (this.b == true) goto L5;
        return 0;
    L5:
        int r0 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (getChildCount() > 0) goto L8;
        return r0;
    L8:
        if (getChildAt(0) == null) goto L14;
        View r1 = getChildAt(0);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L15;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        return (r1.getHeight() + r3.topMargin) + r3.bottomMargin;
    L15:
        return r0;
    L14:
        return r0;
    }

    public c getCustomScrollHook() {
        f r0 = this.r;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.f;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.u.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.v.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int getScrollRange() {
        if (getChildCount() > 0) goto L5;
        return 0;
    L5:
        if (getChildAt(0) == null) goto L15;
        View r0 = getChildAt(0);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L16;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (this.b == false) goto L11;
        int r1 = (r0.getHeight() + r3.topMargin) + r3.bottomMargin;
        int r4 = getHeight() - getPaddingTop();
        int r5 = getPaddingBottom();
    L13:
        return Math.max(0, r1 - (r4 - r5));
    L11:
        r1 = (r0.getWidth() + r3.leftMargin) + r3.rightMargin;
        r4 = getWidth() - getPaddingLeft();
        r5 = getPaddingRight();
        goto L13
    L16:
        return 0;
    L15:
        return 0;
    }

    public NestedScrollContainerView(Context r2) {
        this(r2, null);
    }

    public final boolean b(int r5) {
        int r0 = getScrollX();
        if (this.b == false) goto L5;
        int r1 = 0;
    L6:
        int r2 = r0 + r1;
        int r3 = getScrollY();
        if (this.b == true) goto L10;
        r5 = 0;
    L10:
        int r4 = r3 + r5;
        int r6 = getScrollRange();
        if (this.b == false) goto L15;
        if (r4 <= 0) goto L19;
        if (r4 >= r6) goto L20;
    L17:
        return true;
    L20:
        return false;
    L19:
        return false;
    L15:
        if (r2 <= 0) goto L21;
        if (r2 < r6) goto L17;
        return false;
    L21:
        return false;
    L5:
        r1 = r5;
        goto L6
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r2) {
        if (this.b == false) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r2) {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    public final void g(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.k) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.k = r4.getPointerId(r1);
        int r2 = (int) (r4.getX(r1) + 0.5f);
        this.h = r2;
        this.f = r2;
        int r5 = (int) (r4.getY(r1) + 0.5f);
        this.i = r5;
        this.g = r5;
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.v.hasNestedScrollingParent(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r8) {
        if (this.q != null) goto L5;
        this.q = VelocityTracker.obtain();
    L5:
        this.q.addMovement(r8);
        int r0 = r8.getActionMasked();
        if (r0 == 0) goto L49;
        if (r0 == 1) goto L48;
        if (r0 == 2) goto L21;
        if (r0 != 3) goto L11;
        VelocityTracker r9 = this.q;
        if (r9 == null) goto L20;
        r9.clear();
    L20:
        stopNestedScroll(0);
        setScrollState(1);
    L59:
        if (this.j == 2) goto L63;
        return false;
    L63:
        return true;
    L11:
        if (r0 != 5) goto L13;
        int r1 = r8.getActionIndex();
        this.k = r8.getPointerId(r1);
        int r3 = (int) (r8.getX(r1) + 0.5f);
        this.h = r3;
        this.f = r3;
        int r10 = (int) (r8.getY(r1) + 0.5f);
        this.i = r10;
        this.g = r10;
        goto L59
    L13:
        if (r0 != 6) goto L59;
        g(r8);
        goto L59
    L21:
        int r2 = this.k;
        if (r2 == (-1)) goto L59;
        int r4 = r8.findPointerIndex(r2);
        if (r4 >= 0) goto L27;
        return false;
    L27:
        int r5 = (int) (r8.getX(r4) + 0.5f);
        int r11 = (int) (r8.getY(r4) + 0.5f);
        if (this.j == 2) goto L59;
        int r6 = r5 - this.f;
        int r7 = r11 - this.g;
        if (this.b == true) goto L32;
    L36:
        boolean r12 = false;
    L38:
        if (this.b == false) goto L40;
    L44:
        boolean r13 = false;
    L45:
        if (r12 == true) goto L47;
        if (r13 == false) goto L59;
    L47:
        this.h = r5;
        this.i = r11;
        setScrollState(2);
        goto L59
    L40:
        if (Math.abs(r6) <= this.c) goto L44;
        if ((getNestedScrollAxes() & 1) != 0) goto L44;
        r13 = true;
        goto L45
    L32:
        if (Math.abs(r7) <= this.c) goto L36;
        if ((getNestedScrollAxes() & 2) != 0) goto L36;
        r12 = true;
        goto L38
    L48:
        this.q.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        this.k = r8.getPointerId(0);
        int r14 = (int) (r8.getX() + 0.5f);
        this.h = r14;
        this.f = r14;
        int r15 = (int) (r8.getY() + 0.5f);
        this.i = r15;
        this.g = r15;
        int r16 = this.j;
        if (r16 != 3) goto L52;
    L53:
        f r17 = this.r;
        r17.e.b();
        if (r17.e.d() == true) goto L56;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(2);
    L57:
        int[] r18 = this.n;
        r18[1] = 0;
        r18[0] = 0;
        startNestedScroll(getNestedScrollAxis(), 0);
        goto L59
    L56:
        setScrollState(1);
        goto L57
    L52:
        if (r16 != 4) goto L57;
        goto L53
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r14) {
        if (this.q != null) goto L5;
        this.q = VelocityTracker.obtain();
    L5:
        MotionEvent r0 = MotionEvent.obtain(r14);
        int r1 = r14.getActionMasked();
        boolean r3 = false;
        if (r1 != 0) goto L8;
        int[] r4 = this.n;
        r4[1] = 0;
        r4[0] = 0;
    L8:
        int[] r5 = this.n;
        r0.offsetLocation(r5[0], r5[1]);
        if (r1 == 0) goto L89;
        if (r1 != 1) goto L12;
        this.q.addMovement(r0);
        this.q.computeCurrentVelocity(1000, this.e);
        float r2 = 0.0f;
        if (this.b == true) goto L76;
        float r15 = -this.q.getXVelocity(this.k);
    L78:
        if (this.b == false) goto L81;
        r2 = -this.q.getYVelocity(this.k);
    L81:
        if (c((int) r15, (int) r2) == false) goto L83;
    L85:
        VelocityTracker r16 = this.q;
        if (r16 == null) goto L88;
        r16.clear();
    L88:
        stopNestedScroll(0);
        r3 = true;
    L90:
        if (r3 == true) goto L92;
        this.q.addMovement(r0);
    L92:
        r0.recycle();
        return true;
    L83:
        if (this.r.b() == true) goto L85;
        setScrollState(1);
        goto L85
    L76:
        r15 = 0.0f;
        goto L78
    L12:
        if (r1 != 2) goto L14;
        int r6 = this.k;
        if (r6 == (-1)) goto L90;
        int r7 = r14.findPointerIndex(r6);
        if (r7 >= 0) goto L32;
        return false;
    L32:
        int r8 = (int) (r14.getX(r7) + 0.5f);
        int r17 = (int) (r14.getY(r7) + 0.5f);
        int r9 = this.h - r8;
        int r10 = this.i - r17;
        if (dispatchNestedPreScroll(r9, r10, this.m, this.l, 0) == false) goto L36;
        int[] r11 = this.m;
        r9 = r9 - r11[0];
        r10 = r10 - r11[1];
        int[] r12 = this.l;
        r0.offsetLocation(r12[0], r12[1]);
        int[] r13 = this.n;
        int r18 = r13[0];
        int[] r19 = this.l;
        r13[0] = r18 + r19[0];
        r13[1] = r13[1] + r19[1];
    L36:
        if (this.j == 2) goto L54;
        if (this.b == false) goto L46;
        int r20 = Math.abs(r10);
        int r21 = this.c;
        if (r20 <= r21) goto L46;
        if (r10 <= 0) goto L43;
        r10 = r10 - r21;
    L44:
        setScrollState(2);
        goto L54
    L43:
        r10 = r10 + r21;
    L46:
        if (this.b == true) goto L54;
        int r22 = Math.abs(r9);
        int r23 = this.c;
        if (r22 <= r23) goto L54;
        if (r9 <= 0) goto L51;
        r9 = r9 - r23;
    L52:
        setScrollState(2);
        goto L54
    L51:
        r9 = r9 + r23;
    L54:
        if (this.j != 2) goto L90;
        int[] r24 = this.l;
        this.h = r8 - r24[0];
        this.i = r17 - r24[1];
        boolean r110 = this.b;
        if (r110 == false) goto L58;
        r9 = 0;
    L58:
        if (r110 == true) goto L61;
        r10 = 0;
    L61:
        int[] r111 = this.o;
        r111[0] = 0;
        r111[1] = 0;
        h(r9, r10, r111);
        int[] r112 = this.o;
        int r25 = r112[0];
        int r26 = r112[1];
        if (dispatchNestedScroll(r25, r26, r9 - r25, r10 - r26, this.l, 0) == false) goto L64;
        int r113 = this.h;
        int[] r27 = this.l;
        int r28 = r27[0];
        this.h = r113 - r28;
        int r114 = this.i;
        int r29 = r27[1];
        this.i = r114 - r29;
        r0.offsetLocation(r28, r29);
        int[] r115 = this.n;
        int r30 = r115[0];
        int[] r31 = this.l;
        r115[0] = r30 + r31[0];
        r115[1] = r115[1] + r31[1];
    L64:
        int[] r116 = this.o;
        if (r116[0] == 0) goto L67;
    L70:
        boolean r117 = true;
    L71:
        if (r117 == false) goto L90;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L90
    L67:
        if (r116[1] != 0) goto L70;
        r117 = false;
        goto L71
    L14:
        if (r1 != 3) goto L16;
        VelocityTracker r118 = this.q;
        if (r118 == null) goto L25;
        r118.clear();
    L25:
        stopNestedScroll(0);
        setScrollState(1);
        goto L90
    L16:
        if (r1 != 5) goto L18;
        int r32 = r14.getActionIndex();
        this.k = r14.getPointerId(r32);
        int r33 = (int) (r14.getX(r32) + 0.5f);
        this.h = r33;
        this.f = r33;
        int r119 = (int) (r14.getY(r32) + 0.5f);
        this.i = r119;
        this.g = r119;
        goto L90
    L18:
        if (r1 != 6) goto L90;
        g(r14);
        goto L90
    L89:
        this.k = r14.getPointerId(0);
        int r34 = (int) (r14.getX() + 0.5f);
        this.h = r34;
        this.f = r34;
        int r120 = (int) (r14.getY() + 0.5f);
        this.i = r120;
        this.g = r120;
        startNestedScroll(getNestedScrollAxis(), 0);
        goto L90
    }

    public void setCustomScrollHook(c r2) {
        f r0 = this.r;
        if (r0 == null) goto L6;
        r0.f = r2;
        return;
    }

    public void setEnableScroll(boolean r2) {
        setOnTouchListener(new b(r2));
    }

    public void setIsVertical(boolean r1) {
        this.b = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.v.setNestedScrollingEnabled(r2);
    }

    public void setScrollState(int r3) {
        LLog.i("UIListContainer.NestedScrollContainerView", "setScrollState: " + this.j + " -> " + r3);
        if (r3 != this.j) goto L6;
        return;
    L6:
        if (this.w == true) goto L8;
    L10:
        this.j = r3;
        if (r3 != 3) goto L13;
    L17:
        Iterator<e> r0 = this.s.iterator();
    L19:
        if (r0.hasNext() == false) goto L21;
        r0.next().o(r3);
        goto L19
    L21:
        return;
    L13:
        if (r3 == 4) goto L17;
        f r1 = this.r;
        r1.g.removeCallbacks(r1);
        r1.e.a();
        c r2 = r1.f;
        if (r2 == null) goto L17;
        r2.a();
        r1.f = null;
        goto L17
    L8:
        if (r3 != 1) goto L10;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    public final void stopNestedScroll(int r2) {
        this.v.stopNestedScroll(r2);
    }

    public NestedScrollContainerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final boolean c(int r19, int r20) {
        if (this.b == false) goto L5;
    L8:
        int r1 = 0;
    L10:
        if (this.b == true) goto L12;
    L15:
        int r3 = 0;
    L16:
        if (r1 != 0) goto L19;
        if (r3 != 0) goto L19;
        return false;
    L19:
        float r4 = r1;
        float r5 = r3;
        if (dispatchNestedPreFling(r4, r5) == true) goto L27;
        dispatchNestedFling(r4, r5, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int r6 = this.e;
        int r10 = Math.max(-r6, Math.min(r1, r6));
        int r2 = this.e;
        int r11 = Math.max(-r2, Math.min(r3, r2));
        f r7 = this.r;
        r7.g.setScrollState(3);
        r7.f = null;
        r7.a = r7.g.getScrollX();
        int r8 = r7.g.getScrollY();
        r7.b = r8;
        r7.c = 0;
        r7.d = 0;
        NestedScrollContainerView r9 = r7.g;
        if (r9.a != null) goto L24;
        float[] r12 = r9.d(r7.a, r8);
        r7.e.c(r7.a, r7.b, r10, r11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, (int) r12[0], (int) r12[1]);
    L25:
        r7.g.removeCallbacks(r7);
        ViewCompat.postOnAnimation(r7.g, r7);
        return true;
    L24:
        r7.c(r10, r11);
        goto L25
    L27:
        return false;
    L12:
        if (Math.abs(r20) < this.d) goto L15;
        r3 = r20;
        goto L16
    L5:
        if (Math.abs(r19) < this.d) goto L8;
        r1 = r19;
        goto L10
    }

    public float[] d(int r1, int r2) {
        return new float[]{2.1474836E9f, 2.1474836E9f};
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.v.dispatchNestedPreFling(r2, r3);
    }

    public final void onStopNestedScroll(View r3, int r4) {
        this.u.onStopNestedScroll(r3, r4);
        if (r4 == 0) goto L5;
    L6:
        if (r4 == 1) goto L8;
    L14:
        stopNestedScroll(r4);
        return;
    L8:
        if (this.j != 3) goto L14;
    L10:
        if (this.a != null) goto L12;
    L13:
        setScrollState(1);
        goto L14
    L12:
        if (this.r.b() == true) goto L14;
    L5:
        if (this.j == 2) goto L10;
        goto L6
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.v.startNestedScroll(r2, r3);
    }

    public NestedScrollContainerView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = null;
        this.b = true;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.j = 1;
        this.k = -1;
        this.l = new int[2];
        this.m = new int[2];
        this.n = new int[2];
        this.o = new int[2];
        this.p = new int[2];
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.w = false;
        this.u = new NestedScrollingParentHelper(this);
        this.v = new NestedScrollingChildHelper(this);
        this.r = new f(this);
        setNestedScrollingEnabled(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r5 = ViewConfiguration.get(getContext());
        this.c = r5.getScaledTouchSlop();
        this.d = r5.getScaledMinimumFlingVelocity();
        this.e = r5.getScaledMaximumFlingVelocity();
    }

    private void h(int r8, int r9, int[] r10) {
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = getScrollRange();
        boolean r3 = this.b;
        if (r3 == false) goto L5;
        int r5 = 0;
    L6:
        int r6 = r0 + r8;
        if (r6 >= 0) goto L9;
        r8 = -r0;
    L11:
        if (r3 == true) goto L14;
        r2 = 0;
    L14:
        int r4 = r1 + r9;
        if (r4 >= 0) goto L17;
        r9 = -r1;
    L20:
        if (Math.abs(r8) <= 0) goto L22;
    L23:
        super.scrollTo(r0 + r8, r1 + r9);
    L24:
        if (r10 == null) goto L27;
        r10[0] = r8;
        r10[1] = r9;
        return;
    L27:
        return;
    L22:
        if (Math.abs(r9) <= 0) goto L24;
    L17:
        if (r4 <= r2) goto L20;
        r9 = r2 - r1;
        goto L20
    L9:
        if (r6 <= r5) goto L11;
        r8 = r5 - r0;
        goto L11
    L5:
        r5 = r2;
        goto L6
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.v.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r6, float r7, float r8) {
        boolean r0 = dispatchNestedPreFling(r7, r8);
        if (this.a == null) goto L23;
        if (r6 == null) goto L23;
        if (r0 == true) goto L23;
        boolean r1 = false;
        int r2 = -1;
        if (this.b == false) goto L15;
        if (r8 <= 0.0f) goto L12;
        r2 = 1;
    L12:
        if (r6.canScrollVertically(r2) == false) goto L19;
    L20:
        if (r1 == false) goto L22;
        c((int) r7, (int) r8);
    L22:
        return r1;
    L19:
        r1 = true;
        goto L20
    L15:
        if (r7 <= 0.0f) goto L18;
        r2 = 1;
    L18:
        if (r6.canScrollHorizontally(r2) == true) goto L20;
    L23:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    public static /* synthetic */ void a(NestedScrollContainerView r0, int r1, int r2, int[] r3) {
        r0.h(r1, r2, r3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        if (r4 == false) goto L4;
        return false;
    L4:
        return c((int) r2, (int) r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        this.u.onNestedScrollAccepted(r2, r3, r4, r5);
        if (this.b == false) goto L5;
        startNestedScroll(2, r5);
        return;
    L5:
        startNestedScroll(1, r5);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if (this.b == false) goto L9;
        if ((r3 & 2) == 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if ((r3 & 1) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        boolean r12 = this.v.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
        f(r12);
        return r12;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12) {
        return dispatchNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10, int r11) {
        dispatchNestedPreScroll(r8, r9, r10, null, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.v.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public void onNestedScroll(View r8, int r9, int r10, int r11, int r12, int r13) {
        if (this.a == null) goto L14;
        if (r13 != 1) goto L14;
        boolean r14 = this.b;
        if (r14 == false) goto L8;
        int r1 = 0;
    L9:
        if (r14 == false) goto L11;
        int r2 = r12;
    L12:
        dispatchNestedScroll(r1, r2, 0, 0, null, r13);
        return;
    L11:
        r2 = 0;
        goto L12
    L8:
        r1 = r11;
    L14:
        int r15 = getScrollRange();
        boolean r0 = this.b;
        if (r0 == false) goto L17;
        int r3 = r12;
    L18:
        if (r0 == false) goto L20;
        int r16 = getScrollY();
        scrollTo(getScrollX(), MathUtils.clamp(r12 + r16, 0, r15));
        int r17 = getScrollY() - r16;
    L21:
        int r18 = r3 - r17;
        if (r3 == 0) goto L28;
        if (r17 == 0) goto L28;
        if (r13 != 0) goto L26;
        setScrollState(2);
        goto L28
    L26:
        if (r13 != 1) goto L28;
        setScrollState(3);
    L28:
        boolean r19 = this.b;
        if (r19 == false) goto L31;
        int r4 = 0;
    L32:
        if (r19 == false) goto L34;
        int r5 = r17;
    L35:
        if (r19 == false) goto L37;
        int r6 = 0;
    L38:
        if (r19 == false) goto L40;
        int r7 = r18;
    L41:
        dispatchNestedScroll(r4, r5, r6, r7, null, r13);
        return;
    L40:
        r7 = 0;
        goto L41
    L37:
        r6 = r18;
        goto L38
    L34:
        r5 = 0;
        goto L35
    L31:
        r4 = r17;
        goto L32
    L20:
        int r110 = getScrollX();
        scrollTo(MathUtils.clamp(r11 + r110, 0, r15), getScrollY());
        r17 = getScrollX() - r110;
        goto L21
    L17:
        r3 = r11;
        goto L18
    }
}
