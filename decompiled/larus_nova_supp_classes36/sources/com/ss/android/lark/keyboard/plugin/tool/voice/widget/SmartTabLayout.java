package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SmartTabLayout extends HorizontalScrollView {
    public final com.ss.android.lark.keyboard.plugin.tool.voice.widget.a a;
    public final int b;
    public final int c;
    public final boolean d;
    public ColorStateList e;
    public final float f;
    public final int g;
    public final int h;
    public ViewPager i;
    public ViewPager.OnPageChangeListener j;
    public g k;
    public final a l;
    public boolean m;

    public class a implements View.OnClickListener {
        public final /* synthetic */ SmartTabLayout a;

        public a(SmartTabLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.a.a.getChildCount()) goto L10;
            if (r3 == this.a.a.getChildAt(r0)) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            this.a.getClass();
            this.a.i.setCurrentItem(r0);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public int a;
        public final /* synthetic */ SmartTabLayout b;

        public b(SmartTabLayout r1) {
            this.b = r1;
        }

        public final void onPageScrollStateChanged(int r2) {
            this.a = r2;
            ViewPager.OnPageChangeListener r0 = this.b.j;
            if (r0 == null) goto L6;
            r0.onPageScrollStateChanged(r2);
            return;
        }

        public final void onPageSelected(int r6) {
            if (this.a != 0) goto L8;
            com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r0 = this.b.a;
            r0.u = r6;
            r0.v = 0.0f;
            if (r0.t == r6) goto L7;
            r0.t = r6;
        L7:
            r0.invalidate();
            this.b.a(r6, 0.0f);
        L8:
            int r1 = this.b.a.getChildCount();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L15;
            View r3 = this.b.a.getChildAt(r2);
            if (r6 != r2) goto L13;
            boolean r4 = true;
        L14:
            r3.setSelected(r4);
            r2 = r2 + 1;
            goto L9
        L13:
            r4 = false;
            goto L14
        L15:
            ViewPager.OnPageChangeListener r5 = this.b.j;
            if (r5 == null) goto L22;
            r5.onPageSelected(r6);
            return;
        }

        public final void onPageScrolled(int r3, float r4, int r5) {
            int r0 = this.b.a.getChildCount();
            if (r0 == 0) goto L16;
            if (r3 < 0) goto L17;
            if (r3 >= r0) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r1 = this.b.a;
            r1.u = r3;
            r1.v = r4;
            if (r4 == 0.0f) goto L10;
        L12:
            r1.invalidate();
            this.b.a(r3, r4);
            ViewPager.OnPageChangeListener r2 = this.b.j;
            if (r2 == null) goto L18;
            r2.onPageScrolled(r3, r4, r5);
            return;
        L18:
            return;
        L10:
            if (r1.t == r3) goto L12;
            r1.t = r3;
            goto L12
        L19:
            return;
        L17:
            return;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static class e implements g {
        public final LayoutInflater a;
        public final int b;
        public final int c;

        public e(Context r1, int r2, int r3) {
            this.a = LayoutInflater.from(r1);
            this.b = r2;
            this.c = r3;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.widget.SmartTabLayout.g
        public final View a(com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r6, int r7, PagerAdapter r8) {
            int r0 = this.b;
            TextView r1 = null;
            if (r0 == (-1)) goto L5;
            View r9 = this.a.inflate(r0, r6, false);
        L6:
            int r2 = this.c;
            if (r2 == (-1)) goto L10;
            if (r9 == null) goto L10;
            r1 = (TextView) r9.findViewById(r2);
        L10:
            if (r1 == null) goto L12;
        L14:
            if (r1 == null) goto L16;
            r1.setText(r8.getPageTitle(r7));
        L16:
            return r9;
        L12:
            if (TextView.class.isInstance(r9) == false) goto L14;
            r1 = (TextView) r9;
            goto L14
        L5:
            r9 = null;
            goto L6
        }
    }

    public interface f {
    }

    public interface g {
        View a(com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r1, int r2, PagerAdapter r3);
    }

    public void setOnScrollChangeListener(c r1) {
    }

    public void setOnTabClickListener(d r1) {
    }

    public List<View> getTabs() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.a.getChildCount()) goto L6;
        r0.add(this.a.getChildAt(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public SmartTabLayout(Context r2) {
        this(r2, null);
    }

    public void setCustomTabColorizer(f r2) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r0 = this.a;
        r0.x = r2;
        r0.invalidate();
    }

    public void setCustomTabView(g r1) {
        this.k = r1;
    }

    public void setDefaultTabTextColor(int r1) {
        this.e = ColorStateList.valueOf(r1);
    }

    public void setDistributeEvenly(boolean r1) {
        this.m = r1;
    }

    public void setDividerColors(int... r3) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r0 = this.a;
        r0.x = null;
        r0.r.b = r3;
        r0.invalidate();
    }

    public void setIndicationInterpolator(vob.c r2) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r0 = this.a;
        r0.w = r2;
        r0.invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.j = r1;
    }

    public void setSelectedIndicatorColors(int... r3) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r0 = this.a;
        r0.x = null;
        r0.r.a = r3;
        r0.invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setViewPager(ViewPager r8) {
        this.a.removeAllViews();
        this.i = r8;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getAdapter() == null) goto L37;
        r8.addOnPageChangeListener(new b(this));
        PagerAdapter r9 = this.i.getAdapter();
        int r1 = 0;
    L8:
        if (r1 >= r9.getCount()) goto L38;
        g r2 = this.k;
        if (r2 != null) goto L18;
        CharSequence r3 = r9.getPageTitle(r1);
        TextView r4 = new TextView(getContext());
        r4.setGravity(17);
        r4.setText(r3);
        r4.setTextColor(this.e);
        r4.setTextSize(0, a08.b.a(this.f, getContext()));
        r4.setTypeface(Typeface.DEFAULT_BOLD);
        r4.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        int r5 = this.c;
        if (r5 == (-1)) goto L14;
        r4.setBackgroundResource(r5);
    L15:
        r4.setAllCaps(this.d);
        int r6 = this.g;
        r4.setPadding(r6, 0, r6, 0);
        int r7 = this.h;
        View r10 = r4;
        if (r7 <= 0) goto L19;
        r4.setMinWidth(r7);
        r10 = r4;
    L19:
        if (r10 == null) goto L31;
        if (this.m == false) goto L23;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10.getLayoutParams();
        r11.width = 0;
        r11.weight = 1.0f;
    L23:
        a r12 = this.l;
        if (r12 == null) goto L26;
        r10.setOnClickListener(r12);
    L26:
        this.a.addView(r10);
        if (r1 != this.i.getCurrentItem()) goto L29;
        r10.setSelected(true);
    L29:
        r1 = r1 + 1;
        goto L8
    L31:
        throw new IllegalStateException("tabView is null.");
    L14:
        TypedValue r13 = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, r13, true);
        r4.setBackgroundResource(r13.resourceId);
        goto L15
    L18:
        r10 = r2.a(this.a, r1, r9);
        goto L19
    L38:
        return;
    }

    public void setDefaultTabTextColor(ColorStateList r1) {
        this.e = r1;
    }

    public SmartTabLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(int r11, float r12) {
        int r0 = this.a.getChildCount();
        if (r0 == 0) goto L65;
        if (r11 < 0) goto L66;
        if (r11 < r0) goto L8;
        return;
    L8:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        boolean r1 = true;
    L11:
        View r3 = this.a.getChildAt(r11);
        int r4 = vob.d.e(r3);
        if (r3 != null) goto L14;
        int r6 = 0;
    L15:
        int r5 = (int) ((r4 + r6) * r12);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r7 = this.a;
        if (r7.h == true) goto L18;
        int r8 = this.b;
        if (r8 == (-1)) goto L31;
        if (r1 == false) goto L53;
        if (r11 <= 0) goto L49;
    L52:
        int r13 = r8;
    L59:
        int r14 = vob.d.d(r3, false);
        int r2 = vob.d.c(r3);
        if (r1 == false) goto L62;
        int r15 = (((r14 + r2) - r5) - getWidth()) + (getPaddingLeft() + getPaddingRight());
    L63:
        scrollTo(r13 + r15, 0);
        return;
    L62:
        r15 = (r14 - r2) + r5;
        goto L63
    L49:
        if (r12 > 0.0f) goto L52;
        r8 = 0;
        goto L52
    L53:
        if (r11 <= 0) goto L55;
    L58:
        r13 = -r8;
        goto L59
    L55:
        if (r12 > 0.0f) goto L58;
        r13 = 0;
        goto L59
    L31:
        if (0.0f < r12) goto L33;
    L35:
        if (r1 == false) goto L41;
        int r16 = vob.d.e(r3);
        if (r3 != null) goto L39;
        int r17 = 0;
    L40:
        r13 = (((-(r16 + r17)) / 2) + (getWidth() / 2)) - ViewCompat.getPaddingStart(this);
        goto L59
    L39:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        r17 = MarginLayoutParamsCompat.getMarginEnd(r18) + MarginLayoutParamsCompat.getMarginStart(r18);
        goto L40
    L41:
        int r19 = vob.d.e(r3);
        if (r3 != null) goto L44;
        int r110 = 0;
    L45:
        r13 = (((r19 + r110) / 2) - (getWidth() / 2)) + ViewCompat.getPaddingStart(this);
        goto L59
    L44:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        r110 = MarginLayoutParamsCompat.getMarginEnd(r111) + MarginLayoutParamsCompat.getMarginStart(r111);
        goto L45
    L33:
        if (r12 >= 1.0f) goto L35;
        View r112 = r7.getChildAt(r11 + 1);
        r5 = Math.round(r12 * (((vob.d.e(r3) / 2) + vob.d.b(r3)) + ((vob.d.e(r112) / 2) + vob.d.c(r112))));
        goto L35
    L18:
        if (0.0f < r12) goto L20;
    L22:
        View r113 = this.a.getChildAt(0);
        if (r1 == false) goto L25;
        int r114 = vob.d.e(r113) + vob.d.b(r113);
        int r115 = vob.d.e(r3) + vob.d.b(r3);
        int r9 = (vob.d.a(r3, false) - vob.d.b(r3)) - r5;
        int r116 = (r114 - r115) / 2;
    L26:
        scrollTo(r9 - r116, 0);
        return;
    L25:
        int r117 = vob.d.e(r113) + vob.d.c(r113);
        int r118 = vob.d.e(r3) + vob.d.c(r3);
        r9 = (vob.d.d(r3, false) - vob.d.c(r3)) + r5;
        r116 = (r117 - r118) / 2;
        goto L26
    L20:
        if (r12 >= 1.0f) goto L22;
        View r119 = r7.getChildAt(r11 + 1);
        r5 = Math.round(r12 * (((vob.d.e(r3) / 2) + vob.d.b(r3)) + ((vob.d.e(r119) / 2) + vob.d.c(r119))));
        goto L22
    L14:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        r6 = MarginLayoutParamsCompat.getMarginStart(r10) + MarginLayoutParamsCompat.getMarginEnd(r10);
        goto L15
    L10:
        r1 = false;
        goto L11
    L66:
        return;
    }

    public SmartTabLayout(Context r17, AttributeSet r18, int r19) {
        super(r17, r18, r19);
        setHorizontalScrollBarEnabled(false);
        Resources r4 = getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        float r6 = r5.density;
        float r7 = TypedValue.applyDimension(2, 12.0f, r5);
        TypedArray r9 = r17.obtainStyledAttributes(r18, new int[]{2130974279, 2130974280, 2130974281, 2130974282, 2130974283, 2130974284, 2130974285, 2130974286, 2130974287, 2130974288, 2130974289, 2130974290, 2130974291, 2130974292, 2130974293, 2130974294, 2130974295, 2130974296, 2130974297, 2130974298, 2130974299, 2130974300, 2130974301, 2130974302, 2130974303, 2130974304, 2130974305, 2130974306, 2130974307}, r19, 0);
        int r10 = r9.getResourceId(3, -1);
        boolean r12 = r9.getBoolean(4, true);
        ColorStateList r14 = r9.getColorStateList(5);
        float r8 = r9.getDimension(8, r7);
        int r11 = r9.getDimensionPixelSize(6, (int) (16.0f * r6));
        int r13 = r9.getDimensionPixelSize(7, (int) (0.0f * r6));
        int r15 = r9.getResourceId(1, -1);
        int r16 = r9.getResourceId(2, -1);
        boolean r110 = r9.getBoolean(9, false);
        boolean r3 = r9.getBoolean(0, true);
        int r20 = r9.getLayoutDimension(26, (int) (r6 * 24.0f));
        r9.recycle();
        this.b = r20;
        this.c = r10;
        this.d = r12;
        if (r14 != null) goto L6;
        r14 = ColorStateList.valueOf(-67108864);
    L6:
        this.e = r14;
        this.f = r8;
        this.g = r11;
        this.h = r13;
        if (r3 == false) goto L9;
        a r21 = new a(this);
    L10:
        this.l = r21;
        this.m = r110;
        if (r15 == (-1)) goto L13;
        this.k = new e(getContext(), r15, r16);
    L13:
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r22 = new com.ss.android.lark.keyboard.plugin.tool.voice.widget.a(r17, r18);
        this.a = r22;
        if (r110 == true) goto L16;
    L20:
        setFillViewport(!r22.h);
        addView(r22, -1, -1);
        return;
    L16:
        if (r22.h == false) goto L20;
        throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
    L9:
        r21 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r6 = this.a;
        if (r6.h == true) goto L5;
        return;
    L5:
        if (r6.getChildCount() <= 0) goto L17;
        View r7 = this.a.getChildAt(0);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r8 = this.a;
        View r9 = r8.getChildAt(r8.getChildCount() - 1);
        if (r7 != null) goto L9;
        int r0 = 0;
    L10:
        int r1 = ((r2 - r0) / 2) - vob.d.c(r7);
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = ((r2 - r10) / 2) - vob.d.b(r9);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r12 = this.a;
        r12.setMinimumWidth(r12.getMeasuredWidth());
        ViewCompat.setPaddingRelative(this, r1, getPaddingTop(), r11, getPaddingBottom());
        setClipToPadding(false);
        return;
    L13:
        r10 = r9.getMeasuredWidth();
        goto L14
    L9:
        r0 = r7.getMeasuredWidth();
        goto L10
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L8;
        ViewPager r6 = this.i;
        if (r6 == null) goto L9;
        a(r6.getCurrentItem(), 0.0f);
        return;
    L9:
        return;
    }
}
