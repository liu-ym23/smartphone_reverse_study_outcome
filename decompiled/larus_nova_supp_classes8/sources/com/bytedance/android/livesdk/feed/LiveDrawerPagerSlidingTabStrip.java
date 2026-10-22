package com.bytedance.android.livesdk.feed;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDrawerPagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] N = null;
    public final ColorStateList A;
    public final int B;
    public int C;
    public int D;
    public final Locale E;
    public final SparseArray<String> F;
    public final SparseArray<String> G;
    public e H;
    public int I;
    public boolean J;
    public boolean K;
    public LiveDrawerTabScrollShadow L;
    public int M;
    public final LinearLayout.LayoutParams a;
    public final LinearLayout.LayoutParams b;
    public final f c;
    public ViewPager.OnPageChangeListener d;
    public final LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public final Paint j;
    public final Paint k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public ColorStateList y;
    public int z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r1) {
            super(r1);
            this.a = r1.readInt();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.a);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ LiveDrawerPagerSlidingTabStrip b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            e r3 = this.b.H;
            if (r3 == null) goto L5;
            r3.a(this.a);
        L5:
            this.b.f.setCurrentItem(this.a);
        }

        public a(LiveDrawerPagerSlidingTabStrip r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
        View a();
    }

    public interface c {
        int a();
    }

    public static class d {
        public TextView a;
        public View b;
        public View c;

        public d() {
        }
    }

    public interface e {
        void a(int r1);
    }

    public class f implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ LiveDrawerPagerSlidingTabStrip a;

        public f(LiveDrawerPagerSlidingTabStrip r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r4) {
            if (r4 != 0) goto L4;
            LiveDrawerPagerSlidingTabStrip r0 = this.a;
            LiveDrawerPagerSlidingTabStrip.a(r0, r0.f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r1 = this.a.d;
            if (r1 == null) goto L8;
            r1.onPageScrollStateChanged(r4);
            return;
        }

        public final void onPageSelected(int r2) {
            LiveDrawerPagerSlidingTabStrip r0 = this.a;
            r0.h = r2;
            ViewPager.OnPageChangeListener r1 = r0.d;
            if (r1 == null) goto L5;
            r1.onPageSelected(r2);
        L5:
            this.a.d();
        }

        public final void onPageScrolled(int r3, float r4, int r5) {
            LiveDrawerPagerSlidingTabStrip r0 = this.a;
            r0.i = r4;
            LiveDrawerPagerSlidingTabStrip.a(r0, r3, (int) (r0.e.getChildAt(r3).getWidth() * r4));
            this.a.invalidate();
            ViewPager.OnPageChangeListener r1 = this.a.d;
            if (r1 == null) goto L6;
            r1.onPageScrolled(r3, r4, r5);
            return;
        }
    }

    static {
        N = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final boolean c() {
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        int r2 = r1.getWidth();
        if (getWidth() >= ((r2 + getPaddingLeft()) + getPaddingRight())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public final void d() {
        int r1 = 0;
    L4:
        if (r1 >= this.g) goto L25;
        View r2 = this.e.getChildAt(r1);
        r2.setBackgroundResource(this.D);
        Object r3 = r2.getTag();
        if ((r3 instanceof d) == false) goto L24;
        d r4 = (d) r3;
        TextView r5 = r4.a;
        if (this.h != r1) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        int r7 = this.z;
    L14:
        r5.setTextSize(0, r7);
        r4.a.setTypeface(null, this.B);
        TextView r8 = r4.a;
        if (r1 != this.h) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L20;
        ColorStateList r10 = this.A;
    L21:
        r8.setTextColor(r10);
        if (this.r == false) goto L24;
        r4.a.setAllCaps(true);
        goto L24
    L20:
        r10 = this.y;
        goto L21
    L17:
        r9 = false;
        goto L18
    L13:
        r7 = this.x;
        goto L14
    L10:
        r6 = false;
    L24:
        r1 = r1 + 1;
        goto L4
    }

    public void setIconResId(int r1) {
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.h;
        return r1;
    }

    public int getDividerColor() {
        return this.p;
    }

    public int getDividerPadding() {
        return this.v;
    }

    public int getIndicatorColor() {
        return this.n;
    }

    public int getIndicatorHeight() {
        return this.t;
    }

    public int getIndicatorWidth() {
        return this.l;
    }

    public ViewPager getPager() {
        return this.f;
    }

    public int getScrollOffset() {
        return this.s;
    }

    public boolean getShouldExpand() {
        return this.q;
    }

    public int getTabBackground() {
        return this.D;
    }

    public int getTabPaddingLeftRight() {
        return this.w;
    }

    public ColorStateList getTextColor() {
        return this.y;
    }

    public int getTextSize() {
        return this.x;
    }

    public int getUnderlineColor() {
        return this.o;
    }

    public int getUnderlineHeight() {
        return this.u;
    }

    public LiveDrawerPagerSlidingTabStrip(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(true);
    L6:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        super.onDraw(r12);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.g == 0) goto L40;
        int r0 = getHeight();
        if (TextUtils.isEmpty(this.G.get(this.h)) == true) goto L10;
        this.j.setColor(s1.i(this.G.get(this.h), this.n));
    L11:
        View r1 = this.e.getChildAt(this.h);
        float r2 = r1.getLeft();
        float r3 = r1.getRight();
        if (this.i <= 0.0f) goto L16;
        int r4 = this.h;
        if (r4 >= (this.g - 1)) goto L16;
        View r5 = this.e.getChildAt(r4 + 1);
        float r6 = r5.getLeft();
        float r7 = r5.getRight();
        float r8 = this.i;
        float r9 = 1.0f - r8;
        r2 = (r2 * r9) + (r6 * r8);
        r3 = (r7 * r8) + (r9 * r3);
    L16:
        int r10 = this.l;
        if (r10 == 0) goto L19;
        float r11 = ((r3 - r2) - r10) / 2.0f;
        r2 = r2 + r11;
        r3 = r3 - r11;
    L19:
        float r13 = r3;
        float r14 = r2;
        int r15 = this.m;
        if (r15 > 0) goto L22;
    L24:
        int r16 = r0 - this.t;
        int r17 = this.I;
        r12.drawRect(r14, r16 - r17, r13, r0 - r17, this.j);
    L25:
        this.j.setColor(this.o);
        r12.drawRect(0.0f, r0 - this.u, this.e.getWidth(), r0, this.j);
        int r18 = 0;
        if (c() == true) goto L28;
        this.J = false;
    L34:
        this.k.setColor(this.p);
    L36:
        if (r18 >= (this.g - 1)) goto L41;
        View r19 = this.e.getChildAt(r18);
        r12.drawLine(r19.getRight(), this.v, r19.getRight(), r0 - this.v, this.k);
        r18 = r18 + 1;
        goto L36
    L41:
        return;
    L28:
        LiveDrawerTabScrollShadow r20 = this.L;
        if (r20 == null) goto L34;
        boolean r21 = this.J;
        boolean r22 = this.K;
        r20.d = r22;
        r20.e = r21;
        if (r22 == true) goto L33;
        if (r21 == false) goto L34;
    L33:
        r20.invalidate();
        goto L34
    L22:
        if (Build.VERSION.SDK_INT <= 21) goto L24;
        int r23 = r0 - this.t;
        int r24 = this.I;
        float r25 = r15;
        r12.drawRoundRect(r14, r23 - r24, r13, r0 - r24, r25, r25, this.j);
        goto L25
    L10:
        this.j.setColor(this.n);
        goto L11
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.h = r3.a;
        requestLayout();
    }

    public void setAllCaps(boolean r1) {
        this.r = r1;
    }

    public void setDividerColor(int r1) {
        this.p = r1;
        invalidate();
    }

    public void setDividerColorResource(int r2) {
        this.p = getResources().getColor(r2);
        invalidate();
    }

    public void setDividerPadding(int r1) {
        this.v = r1;
        invalidate();
    }

    public void setIndicatorBottomMargin(int r1) {
        this.I = r1;
    }

    public void setIndicatorColor(int r1) {
        this.n = r1;
        invalidate();
    }

    public void setIndicatorColorResource(int r2) {
        this.n = getResources().getColor(r2);
        invalidate();
    }

    public void setIndicatorHeight(int r1) {
        this.t = r1;
        invalidate();
    }

    public void setIndicatorRadius(int r1) {
        this.m = r1;
        d();
    }

    public void setIndicatorWidth(int r1) {
        this.l = r1;
        d();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.d = r1;
    }

    public void setOnTabClickListener(e r1) {
        this.H = r1;
    }

    public void setScrollOffset(int r1) {
        this.s = r1;
        invalidate();
    }

    public void setShadeView(LiveDrawerTabScrollShadow r1) {
        this.L = r1;
    }

    public void setShouldExpand(boolean r1) {
        this.q = r1;
        requestLayout();
    }

    public void setTabBackground(int r1) {
        this.D = r1;
    }

    public void setTabPaddingLeftRight(int r1) {
        this.w = r1;
        d();
    }

    public void setTabTextSelectSize(int r1) {
        this.z = r1;
        d();
    }

    public void setTextColor(int r1) {
        this.y = ColorStateList.valueOf(r1);
        d();
    }

    public void setTextColorResource(int r2) {
        this.y = getResources().getColorStateList(r2);
        d();
    }

    public void setTextSelectedStyle(int r1) {
        this.M = r1;
    }

    public void setTextSize(int r1) {
        this.x = r1;
        d();
    }

    public void setUnderlineColor(int r1) {
        this.o = r1;
        invalidate();
    }

    public void setUnderlineColorResource(int r2) {
        this.o = getResources().getColor(r2);
        invalidate();
    }

    public void setUnderlineHeight(int r1) {
        this.u = r1;
        invalidate();
    }

    public void setViewPager(ViewPager r7) {
        this.f = r7;
        if (r7.getAdapter() == null) goto L20;
        r7.setOnPageChangeListener(this.c);
        this.e.removeAllViews();
        this.g = this.f.getAdapter().getCount();
        int r0 = 0;
    L6:
        if (r0 >= this.g) goto L17;
        if ((this.f.getAdapter() instanceof b) == false) goto L11;
        b r1 = this.f.getAdapter();
        getContext();
        b(r0, r1.a());
    L16:
        r0 = r0 + 1;
        goto L6
    L11:
        if ((this.f.getAdapter() instanceof c) == false) goto L13;
        int r2 = this.f.getAdapter().a();
        ImageButton r3 = new ImageButton(getContext());
        r3.setImageResource(r2);
        b(r0, r3);
        goto L16
    L13:
        CharSequence r4 = this.f.getAdapter().getPageTitle(r0);
        if (r4 == null) goto L16;
        String r5 = r4.toString();
        d r6 = new d();
        View r8 = LayoutInflater.from(getContext()).inflate(2131566337, null, false);
        r6.a = (TextView) r8.findViewById(2131388367);
        View r9 = r8.findViewById(2131370082);
        r6.b = r9;
        r9.setVisibility(8);
        View r10 = r8.findViewById(2131374718);
        r6.c = r10;
        r10.setVisibility(8);
        r6.a.setText(r5);
        r6.a.setGravity(17);
        r6.a.setSingleLine();
        r8.setTag(r6);
        b(r0, r8);
        goto L16
    L17:
        d();
        getViewTreeObserver().addOnGlobalLayoutListener(new w0(this));
        return;
    L20:
        throw new IllegalStateException("ViewPager does not have adapter INSTANCE.");
    }

    public LiveDrawerPagerSlidingTabStrip(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void b(int r3, View r4) {
        r4.setFocusable(true);
        r4.setOnClickListener(new a(this, r3));
        int r0 = this.w;
        r4.setPadding(r0, 0, r0, 0);
        if (RTLUtil.isAppRTL(getContext()) == false) goto L5;
        int r1 = this.w;
        r4.setPaddingRelative(r1, 0, r1, 0);
    L5:
        LinearLayout r2 = this.e;
        if (this.q == false) goto L8;
        LinearLayout.LayoutParams r5 = this.b;
    L9:
        r2.addView(r4, r3, r5);
        return;
    L8:
        r5 = this.a;
        goto L9
    }

    public LiveDrawerPagerSlidingTabStrip(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.c = new f(this);
        this.h = 0;
        this.i = 0.0f;
        this.l = 0;
        this.m = 0;
        this.n = 16737894;
        this.o = 436207616;
        this.p = 436207616;
        this.q = false;
        this.r = true;
        this.s = 52;
        this.t = 8;
        this.u = 2;
        this.v = 12;
        this.w = 24;
        this.x = 12;
        this.y = ColorStateList.valueOf(16737894);
        this.z = 20;
        ColorStateList r4 = getResources().getColorStateList(2131107480);
        this.A = r4;
        this.B = 1;
        this.C = 0;
        this.D = 2131248707;
        this.F = new SparseArray();
        new SparseArray();
        this.G = new SparseArray();
        this.I = 0;
        this.J = false;
        this.K = false;
        this.L = null;
        this.M = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r5 = new LinearLayout(r10);
        this.e = r5;
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r5);
        Resources r6 = getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        this.s = (int) TypedValue.applyDimension(1, this.s, r7);
        this.t = (int) TypedValue.applyDimension(1, this.t, r7);
        this.u = (int) TypedValue.applyDimension(1, this.u, r7);
        this.v = (int) TypedValue.applyDimension(1, this.v, r7);
        this.w = (int) TypedValue.applyDimension(1, this.w, r7);
        int r8 = (int) TypedValue.applyDimension(1, 1, r7);
        this.x = (int) TypedValue.applyDimension(1, this.x, r7);
        this.z = (int) TypedValue.applyDimension(1, this.z, r7);
        this.l = (int) TypedValue.applyDimension(1, this.l, r7);
        TypedArray r9 = r10.obtainStyledAttributes(r11, N);
        this.x = r9.getDimensionPixelSize(0, this.x);
        this.y = r9.getColorStateList(1);
        r9.recycle();
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{2130974386, 2130974389, 2130974390, 2130974399, 2130974405, 2130974418, 2130974421, 2130974427, 2130974433, 2130974434, 2130974438, 2130974440, 2130974442, 2130974452, 2130974453, 2130974454, 2130974455, 2130974457, 2130974458, 2130974459, 2130974460});
        this.n = r13.getColor(4, this.n);
        this.o = r13.getColor(18, this.o);
        this.p = r13.getColor(1, this.p);
        this.t = r13.getDimensionPixelSize(5, this.t);
        this.u = r13.getDimensionPixelSize(19, this.u);
        this.v = r13.getDimensionPixelSize(2, this.v);
        this.w = r13.getDimensionPixelSize(10, this.w);
        this.D = r13.getResourceId(0, this.D);
        this.q = r13.getBoolean(12, this.q);
        this.s = r13.getDimensionPixelSize(11, this.s);
        this.r = r13.getBoolean(13, this.r);
        this.x = r13.getDimensionPixelSize(16, this.x);
        this.y = r13.getColorStateList(14);
        this.z = r13.getDimensionPixelSize(15, this.z);
        this.l = r13.getDimensionPixelSize(7, this.l);
        this.m = r13.getDimensionPixelSize(6, 0);
        this.B = r13.getInt(17, 1);
        r13.recycle();
        Paint r14 = new Paint();
        this.j = r14;
        r14.setAntiAlias(true);
        r14.setStyle(Paint.Style.FILL);
        Paint r15 = new Paint();
        this.k = r15;
        r15.setAntiAlias(true);
        r15.setStrokeWidth(r8);
        this.a = new LinearLayout.LayoutParams(-2, -1);
        this.b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.E != null) goto L6;
        this.E = getResources().getConfiguration().locale;
    L6:
        if (this.y != null) goto L8;
        this.y = ColorStateList.valueOf(16737894);
    L8:
        if (r4 != null) goto L11;
        this.A = this.y;
        return;
    }

    public static void a(LiveDrawerPagerSlidingTabStrip r2, int r3, int r4) {
        if (r2.g == 0) goto L20;
        View r0 = r2.e.getChildAt(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (RTLUtil.isAppRTL(r2.getContext()) == false) goto L11;
        int r1 = r0.getLeft() - r4;
    L12:
        if (r3 > 0) goto L14;
        if (r4 > 0) goto L14;
    L16:
        if (r1 == r2.C) goto L19;
        r2.C = r1;
        r2.scrollTo(r1, 0);
        return;
    L19:
        return;
    L14:
        r1 = r1 - r2.s;
        goto L16
    L11:
        r1 = r0.getLeft() + r4;
        goto L12
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        int r5 = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (c() == false) goto L6;
        this.K = true;
        this.J = true;
    L6:
        if (getScrollX() != 0) goto L9;
        this.K = false;
    L11:
        boolean r6 = this.J;
        if (r6 == false) goto L14;
    L15:
        LiveDrawerTabScrollShadow r7 = this.L;
        if (r7 == null) goto L23;
        boolean r8 = this.K;
        r7.d = r8;
        r7.e = r6;
        if (r8 == true) goto L20;
        if (r6 == true) goto L20;
        return;
    L20:
        r7.invalidate();
        return;
    L23:
        return;
    L14:
        if (this.K == true) goto L15;
        return;
    L9:
        if (getScrollX() != r5) goto L11;
        this.J = false;
        goto L11
    }
}
