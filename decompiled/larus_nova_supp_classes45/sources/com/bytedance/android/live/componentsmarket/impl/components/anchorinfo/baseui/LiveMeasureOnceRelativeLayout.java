package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.baseui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import androidx.core.util.Pools;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j40.h2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@RemoteViews.RemoteView
public class LiveMeasureOnceRelativeLayout extends RelativeLayout {
    public static final int[] l = null;
    public static final int[] m = null;
    public View a;
    public final Rect b;
    public final Rect c;
    public boolean d;
    public View[] e;
    public View[] f;
    public final a g;
    public final Map<View, Integer> h;
    public boolean i;
    public boolean j;
    public boolean k;

    public static class LayoutParams extends RelativeLayout.LayoutParams {
        public int a;
        public int b;
        public int c;
        public int d;

        public LayoutParams() {
            super(-2, -2);
        }

        @Override // android.widget.RelativeLayout.LayoutParams
        public final int[] getRules() {
            super.resolveLayoutDirection(getLayoutDirection());
            return super.getRules();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        @Override // android.widget.RelativeLayout.LayoutParams
        public final String debug(String r2) {
            return r2 + "ViewGroup.LayoutParams={ width=" + ((RelativeLayout.LayoutParams) this).width + ", height=" + ((RelativeLayout.LayoutParams) this).height + " }";
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public LayoutParams(RelativeLayout.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public final ArrayList<C0135a> a;
        public final SparseArray<C0135a> b;
        public final ArrayDeque<C0135a> c;

        /* JADX INFO: renamed from: com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.baseui.LiveMeasureOnceRelativeLayout$a$a, reason: collision with other inner class name */
        public static class C0135a {
            public static final Pools.SynchronizedPool<C0135a> d = null;
            public View a;
            public final ArrayMap<C0135a, a> b;
            public final SparseArray<C0135a> c;

            static {
                d = new Pools.SynchronizedPool(100);
            }

            public C0135a() {
                this.b = new ArrayMap();
                this.c = new SparseArray();
            }
        }

        public a() {
            this.a = new ArrayList();
            this.b = new SparseArray();
            this.c = new ArrayDeque();
        }

        public final void a(boolean r17, Map<View, Integer> r18, int r19, View[] r21, int... r22) {
            SparseArray<C0135a> r3 = this.b;
            ArrayList<C0135a> r4 = this.a;
            int r5 = r4.size();
            int r7 = 0;
        L3:
            if (r7 >= r5) goto L5;
            C0135a r8 = (C0135a) ListProtector.get(r4, r7);
            r8.b.clear();
            r8.c.clear();
            r7 = r7 + 1;
            goto L3
        L5:
            int r9 = 0;
        L7:
            if (r9 >= r5) goto L28;
            C0135a r11 = (C0135a) ListProtector.get(r4, r9);
            int[] r12 = ((LayoutParams) r11.a.getLayoutParams()).getRules();
            int r13 = r22.length;
            int r14 = 0;
        L9:
            if (r14 >= r13) goto L27;
            int r15 = r12[r22[r14]];
            if (r15 > 0) goto L21;
            int[] r16 = LiveMeasureOnceRelativeLayout.l;
            if (r15 != (-1)) goto L15;
        L19:
            boolean r110 = false;
        L20:
            if (r110 == true) goto L21;
        L26:
            r14 = r14 + 1;
            goto L9
        L15:
            if (((-16777216) & r15) == 0) goto L19;
            if ((16711680 & r15) == 0) goto L19;
            r110 = true;
        L21:
            C0135a r111 = r3.get(r15);
            if (r111 == null) goto L26;
            if (r111 == r11) goto L26;
            r111.b.put(r11, this);
            r11.c.put(r15, r111);
            goto L26
        L27:
            r9 = r9 + 1;
            goto L7
        L28:
            ArrayDeque<C0135a> r2 = this.c;
            r2.clear();
            int r6 = 0;
        L29:
            if (r6 >= r5) goto L34;
            C0135a r23 = (C0135a) ListProtector.get(r4, r6);
            if (r23.c.size() != 0) goto L33;
            r2.addLast(r23);
        L33:
            r6 = r6 + 1;
            goto L29
        L34:
            int r24 = 0;
        L35:
            C0135a r25 = r2.pollLast();
            if (r25 == null) goto L53;
            View r26 = r25.a;
            int r27 = r26.getId();
            int r28 = r24 + 1;
            r21[r24] = r26;
            ArrayMap<C0135a, a> r29 = r25.b;
            int r31 = r29.size();
            int r112 = 0;
        L38:
            if (r112 >= r31) goto L43;
            C0135a r113 = r29.keyAt(r112);
            SparseArray<C0135a> r114 = r113.c;
            r114.remove(r27);
            if (r114.size() != 0) goto L42;
            r2.add(r113);
        L42:
            r112 = r112 + 1;
            goto L38
        L43:
            if (r17 == false) goto L51;
            if (r31 != 0) goto L46;
            int r32 = 0;
        L47:
            int r33 = r32 * r19;
            HashMap r34 = (HashMap) r18;
            if (r34.containsKey(r26) == false) goto L50;
            r34.put(r26, Integer.valueOf(((Integer) r34.get(r26)).intValue() + r33));
            goto L51
        L50:
            r34.put(r26, Integer.valueOf(r33));
            goto L51
        L46:
            r32 = 1;
        L51:
            r24 = r28;
            goto L35
        L53:
            if (r24 < r21.length) goto L56;
            return;
        L56:
            throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
        }
    }

    static {
        l = new int[]{2, 3, 4, 6, 8};
        m = new int[]{0, 1, 5, 7, 16, 17, 18, 19};
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.k == false) goto L7;
        return new LayoutParams();
    L7:
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return LiveMeasureOnceRelativeLayout.class.getName();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public int getBaseline() {
        if (this.k == false) goto L10;
        View r0 = this.a;
        if (r0 == null) goto L8;
        return r0.getBaseline();
    L8:
        return super.getBaseline();
    L10:
        return super.getBaseline();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.d = true;
    }

    public LiveMeasureOnceRelativeLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3) {
        if (this.k == false) goto L12;
        if (r3 == null) goto L12;
        if (r3.getLayoutParams() == null) goto L12;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof LayoutParams) == true) goto L12;
        if ((r0 instanceof RelativeLayout.LayoutParams) == false) goto L12;
        r3.setLayoutParams(new LayoutParams((RelativeLayout.LayoutParams) r0));
    L12:
        super.addView(r3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if (this.k == false) goto L7;
        return r2 instanceof LayoutParams;
    L7:
        return super.checkLayoutParams(r2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if (this.k == false) goto L19;
        if ((r2 instanceof LayoutParams) == false) goto L9;
        return new LayoutParams((LayoutParams) r2);
    L9:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        return new LayoutParams((RelativeLayout.LayoutParams) r2);
    L13:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L17:
        return new LayoutParams(r2);
    L19:
        return super.generateLayoutParams(r2);
    }

    public void setEnableOptimize(boolean r1) {
        this.k = r1;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final RelativeLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        if (this.k == false) goto L7;
        return new LayoutParams(getContext(), r3);
    L7:
        return super.generateLayoutParams(r3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public LiveMeasureOnceRelativeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        if (this.k == false) goto L11;
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        if ((r3 instanceof LayoutParams) == true) goto L11;
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        r3 = new LayoutParams((RelativeLayout.LayoutParams) r3);
    L11:
        super.addView(r2, r3);
    }

    public final View d(int[] r4, int r5) {
        int r6 = r4[r5];
        if (r6 == 0) goto L18;
        a.C0135a r7 = this.g.b.get(r6);
        if (r7 != null) goto L7;
        return null;
    L7:
        View r8 = r7.a;
    L9:
        if (r8.getVisibility() != 8) goto L17;
        int[] r1 = ((LayoutParams) r8.getLayoutParams()).getRules();
        a.C0135a r2 = this.g.b.get(r1[r5]);
        if (r2 == null) goto L16;
        View r3 = r2.a;
        if (r8 == r3) goto L16;
        r8 = r3;
    L16:
        return null;
    L17:
        return r8;
    L18:
        return null;
    }

    public final LayoutParams e(int[] r1, int r2) {
        View r3 = d(r1, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((r3.getLayoutParams() instanceof LayoutParams) == true) goto L7;
        return null;
    L7:
        return (LayoutParams) r3.getLayoutParams();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r35, int r36) {
        if (this.k == true) goto L7;
        super.onMeasure(r35, r36);
        return;
    L7:
        if (this.d == false) goto L34;
        this.d = false;
        Map<View, Integer> r0 = this.h;
        if (r0 == null) goto L11;
        ((HashMap) r0).clear();
    L11:
        int r1 = getChildCount();
        View[] r2 = this.f;
        if (r2 != null) goto L14;
    L15:
        this.f = new View[r1];
    L16:
        View[] r3 = this.e;
        if (r3 != null) goto L19;
    L20:
        this.e = new View[r1];
    L21:
        a r4 = this.g;
        ArrayList<a.C0135a> r5 = r4.a;
        int r6 = r5.size();
        int r7 = 0;
    L22:
        if (r7 >= r6) goto L24;
        a.C0135a r8 = (a.C0135a) ListProtector.get(r5, r7);
        r8.a = null;
        r8.b.clear();
        r8.c.clear();
        a.C0135a.d.release(r8);
        r7 = r7 + 1;
        goto L22
    L24:
        r5.clear();
        r4.b.clear();
        r4.c.clear();
        int r9 = 0;
    L25:
        if (r9 >= r1) goto L33;
        View r11 = getChildAt(r9);
        int r12 = r11.getId();
        a.C0135a r13 = (a.C0135a) a.C0135a.d.acquire();
        if (r13 != null) goto L29;
        r13 = new a.C0135a();
    L29:
        r13.a = r11;
        if (r12 == (-1)) goto L32;
        r4.b.put(r12, r13);
    L32:
        r4.a.add(r13);
        r9 = r9 + 1;
        goto L25
    L33:
        r4.a(this.k, this.h, 2, this.f, l);
        r4.a(this.k, this.h, 1, this.e, m);
        goto L34
    L19:
        if (r3.length == r1) goto L21;
    L14:
        if (r2.length == r1) goto L16;
    L34:
        int r14 = View.MeasureSpec.getMode(r35);
        int r15 = View.MeasureSpec.getMode(r36);
        int r16 = View.MeasureSpec.getSize(r35);
        int r17 = View.MeasureSpec.getSize(r36);
        if (r14 == 0) goto L37;
        int r18 = r16;
    L38:
        if (r15 == 0) goto L40;
        int r19 = r17;
    L42:
        if (r14 != 1073741824) goto L44;
        int r110 = r18;
    L45:
        if (r15 != 1073741824) goto L47;
        int r111 = r19;
    L48:
        int r112 = getGravity();
        int r21 = r112 & 8388615;
        if (r21 == 8388611) goto L52;
        if (r21 == 0) goto L52;
        boolean r22 = true;
    L53:
        int r23 = r112 & 112;
        if (r23 == 48) goto L57;
        if (r23 == 0) goto L57;
        boolean r24 = true;
    L59:
        if (Build.VERSION.SDK_INT < 29) goto L61;
        int r25 = getIgnoreGravity();
    L62:
        if (r22 == true) goto L64;
        if (r24 == true) goto L64;
    L66:
        View r26 = null;
    L67:
        if (r14 == 1073741824) goto L69;
        boolean r27 = true;
    L70:
        if (r15 == 1073741824) goto L72;
        boolean r28 = true;
    L73:
        int r29 = getLayoutDirection();
        View[] r31 = this.e;
        int r32 = r31.length;
        int r33 = 0;
        boolean r210 = false;
        boolean r211 = false;
    L74:
        int r34 = 8;
        if (r33 >= r32) goto L137;
        View r37 = r31[r33];
        if (r37.getVisibility() == 8) goto L135;
        LayoutParams r38 = (LayoutParams) r37.getLayoutParams();
        int[] r39 = r38.getRules();
        if (this.k == true) goto L81;
    L85:
        boolean r113 = false;
    L87:
        if (this.k == false) goto L92;
        if (r113 == false) goto L92;
        if ((((Integer) ((HashMap) this.h).get(r37)).intValue() % 2) != 0) goto L92;
        boolean r114 = true;
    L94:
        if (this.k == false) goto L99;
        if (r113 == false) goto L99;
        if (((((Integer) ((HashMap) this.h).get(r37)).intValue() >> 1) % 2) != 0) goto L99;
        boolean r115 = true;
    L100:
        if (r114 == true) goto L123;
        if (r115 == true) goto L123;
        a(r38, r18, r39);
        int r310 = r33;
        View[] r311 = r31;
        boolean r116 = r28;
        boolean r117 = r27;
        int r212 = r32;
        View r118 = r26;
        int r41 = c(r38.a, r38.c, ((RelativeLayout.LayoutParams) r38).width, ((RelativeLayout.LayoutParams) r38).leftMargin, ((RelativeLayout.LayoutParams) r38).rightMargin, getPaddingLeft(), getPaddingRight(), r18);
        if (r19 < 0) goto L105;
    L111:
        LayoutParams r42 = r38;
        if (this.j == false) goto L114;
        int r43 = Math.max(0, (((r19 - getPaddingTop()) - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r42).topMargin) - ((RelativeLayout.LayoutParams) r42).bottomMargin);
    L116:
        if (((RelativeLayout.LayoutParams) r42).height != (-1)) goto L118;
        int r44 = 1073741824;
    L119:
        int r45 = View.MeasureSpec.makeMeasureSpec(r43, r44);
    L120:
        r37.measure(r41, r45);
        boolean r46 = r117;
        if (g(r37, r42, r18, r117) == false) goto L136;
        r210 = true;
    L136:
        r33 = r310 + 1;
        r27 = r46;
        r26 = r118;
        r28 = r116;
        r32 = r212;
        r31 = r311;
        goto L74
    L118:
        r44 = Integer.MIN_VALUE;
        goto L119
    L114:
        r43 = Math.max(0, r19);
        goto L116
    L105:
        if (this.i == true) goto L111;
        r42 = r38;
        int r47 = ((RelativeLayout.LayoutParams) r42).height;
        if (r47 < 0) goto L109;
        r45 = View.MeasureSpec.makeMeasureSpec(r47, 1073741824);
        goto L120
    L109:
        r45 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L123:
        r310 = r33;
        r212 = r32;
        r311 = r31;
        r116 = r28;
        r46 = r27;
        r118 = r26;
        if (r114 == false) goto L127;
        if (r115 == true) goto L127;
        a(r38, r18, r39);
    L127:
        if (r114 == true) goto L136;
        if (r115 == false) goto L136;
        a(r38, r18, r39);
        b(r38, r19, r37.getBaseline());
        f(r37, r38, r18, r19);
        if (g(r37, r38, r18, r46) == false) goto L133;
        r210 = true;
    L133:
        if (h(r37, r38, r19, r116) == false) goto L136;
        r211 = true;
    L99:
        r115 = false;
    L92:
        r114 = false;
        goto L94
    L81:
        if (((HashMap) this.h).containsKey(r37) == false) goto L85;
        if (((HashMap) this.h).get(r37) == null) goto L85;
        r113 = true;
        goto L87
    L135:
        r310 = r33;
        r212 = r32;
        r311 = r31;
        r116 = r28;
        r46 = r27;
        r118 = r26;
        goto L136
    L137:
        boolean r119 = r28;
        boolean r48 = r27;
        View r120 = r26;
        View[] r49 = this.f;
        int r121 = r49.length;
        int r51 = getContext().getApplicationInfo().targetSdkVersion;
        int r52 = r110;
        int r53 = r111;
        int r54 = 0;
        int r55 = Integer.MAX_VALUE;
        int r56 = Integer.MIN_VALUE;
        int r122 = Integer.MAX_VALUE;
        int r312 = Integer.MIN_VALUE;
    L138:
        if (r54 >= r121) goto L206;
        int r123 = r121;
        View r124 = r49[r54];
        View[] r125 = r49;
        if (r124.getVisibility() == r34) goto L204;
        LayoutParams r57 = (LayoutParams) r124.getLayoutParams();
        if (this.k == true) goto L144;
    L148:
        boolean r58 = false;
    L150:
        if (this.k == false) goto L155;
        if (r58 == false) goto L155;
        if ((((Integer) ((HashMap) this.h).get(r124)).intValue() % 2) != 0) goto L155;
        boolean r59 = true;
    L157:
        if (this.k == false) goto L162;
        if (r58 == false) goto L162;
        if (((((Integer) ((HashMap) this.h).get(r124)).intValue() >> 1) % 2) != 0) goto L162;
        boolean r61 = true;
    L163:
        if (r59 == true) goto L168;
        if (r61 == true) goto L168;
        b(r57, r19, r124.getBaseline());
        f(r124, r57, r18, r19);
        if (h(r124, r57, r19, r119) == false) goto L188;
    L186:
        r211 = true;
    L188:
        if (r48 == false) goto L192;
        if (r51 >= 19) goto L191;
        r52 = Math.max(r52, r57.c);
        goto L192
    L191:
        r52 = Math.max(r52, r57.c + ((RelativeLayout.LayoutParams) r57).rightMargin);
    L192:
        if (r119 == false) goto L196;
        if (r51 >= 19) goto L195;
        r53 = Math.max(r53, r57.d);
        goto L196
    L195:
        r53 = Math.max(r53, r57.d + ((RelativeLayout.LayoutParams) r57).bottomMargin);
    L196:
        if (r124 != r120) goto L198;
        if (r24 == true) goto L198;
    L199:
        if (r124 != r120) goto L203;
        if (r22 == true) goto L203;
        r56 = r56;
    L205:
        r54 = r54 + 1;
        r121 = r123;
        r49 = r125;
        r34 = 8;
    L203:
        int r62 = Math.max(r56, r57.c + ((RelativeLayout.LayoutParams) r57).rightMargin);
        r56 = r62;
        r312 = Math.max(r312, r57.d + ((RelativeLayout.LayoutParams) r57).bottomMargin);
    L198:
        r55 = Math.min(r55, r57.a - ((RelativeLayout.LayoutParams) r57).leftMargin);
        r122 = Math.min(r122, r57.b - ((RelativeLayout.LayoutParams) r57).topMargin);
    L168:
        if (r59 == false) goto L176;
        if (r61 == true) goto L176;
        b(r57, r19, r124.getBaseline());
        f(r124, r57, r18, r19);
        if (g(r124, r57, r18, r48) == false) goto L174;
        r210 = true;
    L174:
        if (h(r124, r57, r19, r119) == false) goto L188;
    L176:
        if (r59 == true) goto L179;
        if (r61 == true) goto L188;
    L179:
        if (r61 == false) goto L188;
        if (r59 == false) goto L188;
        a(r57, r18, r57.getRules());
        b(r57, r19, r124.getBaseline());
        f(r124, r57, r18, r19);
        if (g(r124, r57, r18, r48) == false) goto L185;
        r210 = true;
    L185:
        if (h(r124, r57, r19, r119) == false) goto L188;
    L162:
        r61 = false;
    L155:
        r59 = false;
        goto L157
    L144:
        if (((HashMap) this.h).containsKey(r124) == false) goto L148;
        if (((HashMap) this.h).get(r124) == null) goto L148;
        r58 = true;
        goto L150
    L204:
        r54 = r54;
        goto L205
    L206:
        View[] r126 = r49;
        int r63 = r56;
        int r64 = r312;
        int r65 = r121;
        LayoutParams r66 = null;
        int r67 = 0;
        View r127 = null;
    L207:
        if (r67 >= r65) goto L222;
        View r128 = r126[r67];
        View r129 = r120;
        if (r128.getVisibility() == 8) goto L221;
        LayoutParams r130 = (LayoutParams) r128.getLayoutParams();
        if (r127 == null) goto L220;
        if (r66 == null) goto L220;
        int r131 = r130.b - r66.b;
        if (r131 != 0) goto L217;
        r131 = r130.a - r66.a;
    L217:
        if (r131 >= 0) goto L221;
    L220:
        r66 = r130;
        r127 = r128;
    L221:
        r67 = r67 + 1;
        r120 = r129;
        goto L207
    L222:
        View r132 = r120;
        this.a = r127;
        if (r48 == false) goto L245;
        int r68 = r52 + getPaddingRight();
        if (getLayoutParams() != null) goto L227;
    L229:
        r52 = RelativeLayout.resolveSize(Math.max(r68, getSuggestedMinimumWidth()), r35);
        if (r210 == false) goto L245;
        int r69 = 0;
    L232:
        if (r69 >= r65) goto L245;
        View r71 = r126[r69];
        if (r71.getVisibility() == 8) goto L244;
        LayoutParams r133 = (LayoutParams) r71.getLayoutParams();
        int[] r134 = r133.getRules();
        if (r134[13] == 0) goto L238;
    L243:
        int r72 = r71.getMeasuredWidth();
        int r135 = (r52 - r72) / 2;
        r133.a = r135;
        r133.c = r135 + r72;
        goto L244
    L238:
        if (r134[14] != 0) goto L243;
        if (r134[11] == 0) goto L244;
        int r73 = r71.getMeasuredWidth();
        int r136 = (r52 - getPaddingRight()) - r73;
        r133.a = r136;
        r133.c = r136 + r73;
    L244:
        r69 = r69 + 1;
        goto L232
    L227:
        if (getLayoutParams().width < 0) goto L229;
        r68 = Math.max(r68, getLayoutParams().width);
    L245:
        int r137 = r52;
        if (r119 == false) goto L268;
        int r74 = r53 + getPaddingBottom();
        if (getLayoutParams() != null) goto L250;
    L252:
        r53 = RelativeLayout.resolveSize(Math.max(r74, getSuggestedMinimumHeight()), r36);
        if (r211 == false) goto L268;
        int r75 = 0;
    L255:
        if (r75 >= r65) goto L268;
        View r76 = r126[r75];
        if (r76.getVisibility() == 8) goto L267;
        LayoutParams r77 = (LayoutParams) r76.getLayoutParams();
        int[] r138 = r77.getRules();
        if (r138[13] == 0) goto L261;
    L266:
        int r78 = r76.getMeasuredHeight();
        int r139 = (r53 - r78) / 2;
        r77.b = r139;
        r77.d = r139 + r78;
        goto L267
    L261:
        if (r138[15] != 0) goto L266;
        if (r138[12] == 0) goto L267;
        int r79 = r76.getMeasuredHeight();
        int r140 = (r53 - getPaddingBottom()) - r79;
        r77.b = r140;
        r77.d = r140 + r79;
    L267:
        r75 = r75 + 1;
        goto L255
    L250:
        if (getLayoutParams().height < 0) goto L252;
        r74 = Math.max(r74, getLayoutParams().height);
    L268:
        int r81 = r53;
        if (r22 == true) goto L271;
        if (r24 == true) goto L271;
    L287:
        setMeasuredDimension(r137, r81);
        return;
    L271:
        Rect r82 = this.c;
        r82.set(getPaddingLeft(), getPaddingTop(), r137 - getPaddingRight(), r81 - getPaddingBottom());
        Rect r141 = this.b;
        Gravity.apply(r112, r63 - r55, r64 - r122, r82, r141, r29);
        int r83 = r141.left - r55;
        int r84 = r141.top - r122;
        if (r83 != 0) goto L274;
        if (r84 == 0) goto L287;
    L274:
        int r142 = 0;
    L275:
        if (r142 >= r65) goto L287;
        View r85 = r126[r142];
        if (r85.getVisibility() == 8) goto L285;
        View r86 = r132;
        if (r85 == r86) goto L286;
        LayoutParams r87 = (LayoutParams) r85.getLayoutParams();
        if (r22 == false) goto L283;
        r87.a += r83;
        r87.c += r83;
    L283:
        if (r24 == false) goto L286;
        r87.b += r84;
        r87.d += r84;
    L286:
        r142 = r142 + 1;
        r132 = r86;
        goto L275
    L285:
        r86 = r132;
        goto L286
    L72:
        r28 = false;
        goto L73
    L69:
        r27 = false;
    L64:
        if (r25 == (-1)) goto L66;
        r26 = findViewById(r25);
        goto L67
    L61:
        r25 = 0;
    L57:
        r24 = false;
    L52:
        r22 = false;
        goto L53
    L47:
        r111 = 0;
        goto L48
    L44:
        r110 = 0;
        goto L45
    L40:
        r19 = -1;
        goto L42
    L37:
        r18 = -1;
        goto L38
    }

    public void onSetLayoutParams(View r2, ViewGroup.LayoutParams r3) {
        if (this.k == true) goto L5;
    L7:
        requestLayout();
        return;
    L5:
        if ((r3 instanceof LayoutParams) == true) goto L7;
        r2.setLayoutParams(generateLayoutParams(r3));
    }

    public LiveMeasureOnceRelativeLayout(Context r2, AttributeSet r3, int r4) {
        boolean r0 = false;
        super(r2, r3, r4, 0);
        this.a = null;
        this.b = new Rect();
        this.c = new Rect();
        this.g = new a();
        this.h = new HashMap();
        this.i = false;
        this.j = false;
        this.k = h2.a.getValue().booleanValue();
        int r5 = r2.getApplicationInfo().targetSdkVersion;
        if (r5 > 17) goto L5;
        boolean r6 = true;
    L6:
        this.i = r6;
        if (r5 < 18) goto L9;
        r0 = true;
    L9:
        this.j = r0;
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void a(LayoutParams r4, int r5, int[] r6) {
        r4.a = Integer.MIN_VALUE;
        r4.c = Integer.MIN_VALUE;
        LayoutParams r1 = e(r6, 0);
        if (r1 == null) goto L6;
        r4.c = r1.a - (((RelativeLayout.LayoutParams) r1).leftMargin + ((RelativeLayout.LayoutParams) r4).rightMargin);
    L11:
        LayoutParams r2 = e(r6, 1);
        if (r2 == null) goto L15;
        r4.a = r2.c + (((RelativeLayout.LayoutParams) r2).rightMargin + ((RelativeLayout.LayoutParams) r4).leftMargin);
    L19:
        LayoutParams r3 = e(r6, 5);
        if (r3 == null) goto L23;
        r4.a = r3.a + ((RelativeLayout.LayoutParams) r4).leftMargin;
    L27:
        LayoutParams r7 = e(r6, 7);
        if (r7 == null) goto L31;
        r4.c = r7.c - ((RelativeLayout.LayoutParams) r4).rightMargin;
    L37:
        if (r6[9] == 0) goto L40;
        r4.a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r4).leftMargin;
    L40:
        if (r6[11] == 0) goto L44;
        if (r5 < 0) goto L45;
        r4.c = (r5 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r4).rightMargin;
        return;
    L45:
        return;
    L44:
        return;
    L31:
        if (((RelativeLayout.LayoutParams) r4).alignWithParent == false) goto L37;
        if (r6[7] == 0) goto L37;
        if (r5 < 0) goto L37;
        r4.c = (r5 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r4).rightMargin;
        goto L37
    L23:
        if (((RelativeLayout.LayoutParams) r4).alignWithParent == false) goto L27;
        if (r6[5] == 0) goto L27;
        r4.a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r4).leftMargin;
        goto L27
    L15:
        if (((RelativeLayout.LayoutParams) r4).alignWithParent == false) goto L19;
        if (r6[1] == 0) goto L19;
        r4.a = getPaddingLeft() + ((RelativeLayout.LayoutParams) r4).leftMargin;
        goto L19
    L6:
        if (((RelativeLayout.LayoutParams) r4).alignWithParent == false) goto L11;
        if (r6[0] == 0) goto L11;
        if (r5 < 0) goto L11;
        r4.c = (r5 - getPaddingRight()) - ((RelativeLayout.LayoutParams) r4).rightMargin;
        goto L11
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (this.k == false) goto L11;
        if (r2 == null) goto L11;
        if (r4 == null) goto L11;
        if ((r4 instanceof LayoutParams) == true) goto L11;
        if ((r4 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        r4 = new LayoutParams((RelativeLayout.LayoutParams) r4);
    L11:
        super.addView(r2, r3, r4);
    }

    public final void b(LayoutParams r6, int r7, int r8) {
        int[] r0 = r6.getRules();
        View r1 = d(r0, 4);
        if (r1 == null) goto L9;
        int r3 = r1.getBaseline();
        if (r3 == (-1)) goto L9;
        if ((r1.getLayoutParams() instanceof LayoutParams) == false) goto L9;
        int r2 = ((LayoutParams) r1.getLayoutParams()).b + r3;
    L11:
        if (r2 == (-1)) goto L16;
        if (r8 == (-1)) goto L14;
        r2 = r2 - r8;
    L14:
        r6.b = r2;
        r6.d = Integer.MIN_VALUE;
        return;
    L16:
        r6.b = Integer.MIN_VALUE;
        r6.d = Integer.MIN_VALUE;
        LayoutParams r4 = e(r0, 2);
        if (r4 == null) goto L20;
        r6.d = r4.b - (((RelativeLayout.LayoutParams) r4).topMargin + ((RelativeLayout.LayoutParams) r6).bottomMargin);
    L25:
        LayoutParams r5 = e(r0, 3);
        if (r5 == null) goto L29;
        r6.b = r5.d + (((RelativeLayout.LayoutParams) r5).bottomMargin + ((RelativeLayout.LayoutParams) r6).topMargin);
    L33:
        LayoutParams r9 = e(r0, 6);
        if (r9 == null) goto L37;
        r6.b = r9.b + ((RelativeLayout.LayoutParams) r6).topMargin;
    L41:
        LayoutParams r11 = e(r0, 8);
        if (r11 == null) goto L45;
        r6.d = r11.d - ((RelativeLayout.LayoutParams) r6).bottomMargin;
    L51:
        if (r0[10] == 0) goto L54;
        r6.b = getPaddingTop() + ((RelativeLayout.LayoutParams) r6).topMargin;
    L54:
        if (r0[12] == 0) goto L58;
        if (r7 < 0) goto L59;
        r6.d = (r7 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r6).bottomMargin;
        return;
    L59:
        return;
    L58:
        return;
    L45:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent == false) goto L51;
        if (r0[8] == 0) goto L51;
        if (r7 < 0) goto L51;
        r6.d = (r7 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r6).bottomMargin;
        goto L51
    L37:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent == false) goto L41;
        if (r0[6] == 0) goto L41;
        r6.b = getPaddingTop() + ((RelativeLayout.LayoutParams) r6).topMargin;
        goto L41
    L29:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent == false) goto L33;
        if (r0[3] == 0) goto L33;
        r6.b = getPaddingTop() + ((RelativeLayout.LayoutParams) r6).topMargin;
        goto L33
    L20:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent == false) goto L25;
        if (r0[2] == 0) goto L25;
        if (r7 < 0) goto L25;
        r6.d = (r7 - getPaddingBottom()) - ((RelativeLayout.LayoutParams) r6).bottomMargin;
    L9:
        r2 = -1;
        goto L11
    }

    public final void f(View r11, LayoutParams r12, int r13, int r14) {
        r11.measure(c(r12.a, r12.c, ((RelativeLayout.LayoutParams) r12).width, ((RelativeLayout.LayoutParams) r12).leftMargin, ((RelativeLayout.LayoutParams) r12).rightMargin, getPaddingLeft(), getPaddingRight(), r13), c(r12.b, r12.d, ((RelativeLayout.LayoutParams) r12).height, ((RelativeLayout.LayoutParams) r12).topMargin, ((RelativeLayout.LayoutParams) r12).bottomMargin, getPaddingTop(), getPaddingBottom(), r14));
    }

    public final boolean g(View r6, LayoutParams r7, int r8, boolean r9) {
        getLayoutDirection();
        int[] r0 = r7.getRules();
        int r1 = r7.a;
        if (r1 != Integer.MIN_VALUE) goto L7;
        int r4 = r7.c;
        if (r4 == Integer.MIN_VALUE) goto L7;
        r7.a = r4 - r6.getMeasuredWidth();
    L25:
        if (r0[21] != 0) goto L29;
        return false;
    L29:
        return true;
    L7:
        if (r1 != Integer.MIN_VALUE) goto L9;
    L11:
        if (r1 != Integer.MIN_VALUE) goto L25;
        if (r7.c != Integer.MIN_VALUE) goto L25;
        if (r0[13] == 0) goto L17;
    L20:
        if (r9 == true) goto L22;
        int r11 = r6.getMeasuredWidth();
        int r12 = (r8 - r11) / 2;
        r7.a = r12;
        r7.c = r12 + r11;
    L23:
        return true;
    L22:
        int r13 = getPaddingLeft() + ((RelativeLayout.LayoutParams) r7).leftMargin;
        r7.a = r13;
        r7.c = r13 + r6.getMeasuredWidth();
        goto L23
    L17:
        if (r0[14] != 0) goto L20;
        int r14 = getPaddingLeft() + ((RelativeLayout.LayoutParams) r7).leftMargin;
        r7.a = r14;
        r7.c = r14 + r6.getMeasuredWidth();
        goto L25
    L9:
        if (r7.c != Integer.MIN_VALUE) goto L11;
        r7.c = r1 + r6.getMeasuredWidth();
        goto L25
    }

    public final boolean h(View r6, LayoutParams r7, int r8, boolean r9) {
        int[] r0 = r7.getRules();
        int r1 = r7.b;
        if (r1 != Integer.MIN_VALUE) goto L7;
        int r4 = r7.d;
        if (r4 == Integer.MIN_VALUE) goto L7;
        r7.b = r4 - r6.getMeasuredHeight();
    L25:
        if (r0[12] != 0) goto L29;
        return false;
    L29:
        return true;
    L7:
        if (r1 != Integer.MIN_VALUE) goto L9;
    L11:
        if (r1 != Integer.MIN_VALUE) goto L25;
        if (r7.d != Integer.MIN_VALUE) goto L25;
        if (r0[13] == 0) goto L17;
    L20:
        if (r9 == true) goto L22;
        int r11 = r6.getMeasuredHeight();
        int r12 = (r8 - r11) / 2;
        r7.b = r12;
        r7.d = r12 + r11;
    L23:
        return true;
    L22:
        int r13 = getPaddingTop() + ((RelativeLayout.LayoutParams) r7).topMargin;
        r7.b = r13;
        r7.d = r13 + r6.getMeasuredHeight();
        goto L23
    L17:
        if (r0[15] != 0) goto L20;
        int r14 = getPaddingTop() + ((RelativeLayout.LayoutParams) r7).topMargin;
        r7.b = r14;
        r7.d = r14 + r6.getMeasuredHeight();
        goto L25
    L9:
        if (r7.d != Integer.MIN_VALUE) goto L11;
        r7.d = r1 + r6.getMeasuredHeight();
        goto L25
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (this.k == true) goto L6;
        super.onLayout(r3, r4, r5, r6, r7);
        return;
    L6:
        int r8 = getChildCount();
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L12;
        View r11 = getChildAt(r9);
        if (r11.getVisibility() == 8) goto L11;
        LayoutParams r12 = (LayoutParams) r11.getLayoutParams();
        r11.layout(r12.a, r12.b, r12.c, r12.d);
    L11:
        r9 = r9 + 1;
        goto L7
    }

    public final int c(int r6, int r7, int r8, int r9, int r11, int r12, int r13, int r14) {
        int r0 = 0;
        if (r14 >= 0) goto L5;
        boolean r1 = true;
    L6:
        int r2 = 1073741824;
        if (r1 == true) goto L9;
    L18:
        if (r6 != Integer.MIN_VALUE) goto L20;
        int r15 = r12 + r9;
    L21:
        if (r7 != Integer.MIN_VALUE) goto L23;
        int r16 = (r14 - r13) - r11;
    L24:
        int r17 = r16 - r15;
        if (r6 == Integer.MIN_VALUE) goto L31;
        if (r7 == Integer.MIN_VALUE) goto L31;
        if (r1 == false) goto L29;
        r2 = 0;
    L29:
        r8 = Math.max(0, r17);
    L30:
        r0 = r2;
    L46:
        return View.MeasureSpec.makeMeasureSpec(r8, r0);
    L31:
        if (r8 < 0) goto L36;
        if (r17 < 0) goto L34;
        r8 = Math.min(r17, r8);
    L34:
        r0 = 1073741824;
        goto L46
    L36:
        if (r8 != (-1)) goto L41;
        if (r1 == false) goto L39;
        r2 = 0;
    L39:
        r8 = Math.max(0, r17);
        goto L30
    L41:
        if (r8 != (-2)) goto L44;
        if (r17 < 0) goto L44;
        r8 = r17;
        r0 = Integer.MIN_VALUE;
    L44:
        r8 = 0;
        goto L46
    L23:
        r16 = r7;
        goto L24
    L20:
        r15 = r6;
        goto L21
    L9:
        if (this.i == true) goto L18;
        if (r6 == Integer.MIN_VALUE) goto L13;
        if (r7 == Integer.MIN_VALUE) goto L13;
        r8 = Math.max(0, r7 - r6);
    L14:
        r0 = 1073741824;
    L17:
        return View.MeasureSpec.makeMeasureSpec(r8, r0);
    L13:
        if (r8 >= 0) goto L14;
        r8 = 0;
        goto L17
    L5:
        r1 = false;
        goto L6
    }
}
