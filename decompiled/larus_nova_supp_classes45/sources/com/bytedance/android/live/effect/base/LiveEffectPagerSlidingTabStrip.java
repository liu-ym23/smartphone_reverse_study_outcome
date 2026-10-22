package com.bytedance.android.live.effect.base;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.z;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerSelectDialogFactory;
import com.bytedance.android.live.effect.sticker.ui.StickerSlideTabItemView;
import com.bytedance.android.live.effect.sticker.ui.StickerSlideTabItemViewNew;
import com.bytedance.android.live.effect.sticker.ui.u;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveEffectPagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] Q = null;
    public final int A;
    public final boolean B;
    public int C;
    public ColorStateList D;
    public final int E;
    public int F;
    public int G;
    public final Locale H;
    public View I;
    public final SparseArray<u> J;
    public final SparseArray<String> K;
    public final SparseArray<String> L;
    public final SparseArray<String> M;
    public int N;
    public int O;
    public LiveEffectScene P;
    public final LinearLayout.LayoutParams a;
    public final LinearLayout.LayoutParams b;
    public final f c;
    public ViewPager.OnPageChangeListener d;
    public final LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public int j;
    public final double k;
    public final Paint l;
    public final Paint m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public final int z;

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

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ LiveEffectPagerSlidingTabStrip a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            LiveEffectPagerSlidingTabStrip r0 = this.a;
            r0.h = r0.f.getCurrentItem();
            LiveEffectPagerSlidingTabStrip r1 = this.a;
            LiveEffectPagerSlidingTabStrip.a(r1, r1.h, true);
            LiveEffectPagerSlidingTabStrip r2 = this.a;
            LiveEffectPagerSlidingTabStrip.b(r2, r2.h, 0);
        }

        public a(LiveEffectPagerSlidingTabStrip r1) {
            this.a = r1;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ LiveEffectPagerSlidingTabStrip b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r4 = LiveStickerSelectDialogFactory.a;
            LiveEffectScene r5 = this.b.P;
            Intrinsics.checkNotNullParameter(r5, "liveEffectScene");
            if (z.a(r5) == false) goto L5;
            m90.c<Boolean> r6 = m90.b.o;
        L6:
            r6.e(LiveEffectContextFactoryDelegate$Type.DEFAULT, Boolean.TRUE);
            this.b.f.setCurrentItem(this.a);
            return;
        L5:
            r6 = m90.b.n;
            goto L6
        }

        public b(LiveEffectPagerSlidingTabStrip r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface c {
        View a();
    }

    public interface d {
        int a();
    }

    public static class e {
        public TextView a;
        public View b;
        public View c;

        public e() {
        }
    }

    public class f implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ LiveEffectPagerSlidingTabStrip a;

        public f(LiveEffectPagerSlidingTabStrip r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r4) {
            if (r4 != 0) goto L4;
            LiveEffectPagerSlidingTabStrip r0 = this.a;
            LiveEffectPagerSlidingTabStrip.b(r0, r0.f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r1 = this.a.d;
            if (r1 == null) goto L8;
            r1.onPageScrollStateChanged(r4);
            return;
        }

        public final void onPageSelected(int r2) {
            ViewPager.OnPageChangeListener r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onPageSelected(r2);
            return;
        }

        public final void onPageScrolled(int r8, float r9, int r11) {
            LiveEffectPagerSlidingTabStrip r0 = this.a;
            int r1 = r0.j;
            if (r9 <= r0.k) goto L5;
            r0.j = r8 + 1;
        L7:
            if (r1 == r0.j) goto L9;
            LiveEffectPagerSlidingTabStrip.a(r0, r1, false);
            LiveEffectPagerSlidingTabStrip r2 = this.a;
            LiveEffectPagerSlidingTabStrip.a(r2, r2.j, true);
        L9:
            LiveEffectPagerSlidingTabStrip r3 = this.a;
            r3.h = r8;
            r3.i = r9;
            if (r3.e.getChildAt(r8) != null) goto L12;
            return;
        L12:
            LiveEffectPagerSlidingTabStrip r4 = this.a;
            LiveEffectPagerSlidingTabStrip.b(r4, r8, (int) (r4.e.getChildAt(r8).getWidth() * r9));
            this.a.invalidate();
            ViewPager.OnPageChangeListener r5 = this.a.d;
            if (r5 == null) goto L16;
            r5.onPageScrolled(r8, r9, r11);
            return;
        L16:
            return;
        L5:
            r0.j = r8;
            goto L7
        }
    }

    static {
        Q = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final void e() {
        int r1 = 0;
    L4:
        if (r1 >= this.g) goto L17;
        View r2 = this.e.getChildAt(r1);
        if (this.B == false) goto L10;
        View r3 = r2.findViewById(2131388008);
        if (r3 == null) goto L11;
        r3.setBackgroundResource(this.G);
    L11:
        Object r4 = r2.getTag();
        if ((r4 instanceof e) == false) goto L16;
        e r5 = (e) r4;
        r5.a.setTextSize(0, this.C);
        r5.a.setTypeface(null, this.E);
        r5.a.setTextColor(this.D);
        if (this.t == false) goto L16;
        r5.a.setAllCaps(true);
    L16:
        r1 = r1 + 1;
        goto L4
    L10:
        r2.setBackgroundResource(this.G);
        goto L11
    }

    public void setIconResId(int r1) {
    }

    public final void d() {
        if (LiveEffectSettings.LIVE_ANCHOR_PREVIEW_ENABLE_CAMPAIGN_EFFECT_INSERT.getValue().booleanValue() == false) goto L9;
        ViewPager r0 = this.f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getAdapter() != null) goto L9;
        return;
    L9:
        this.e.removeAllViews();
        this.g = this.f.getAdapter().getCount();
        int r1 = 0;
    L10:
        int r2 = this.g;
        if (r1 >= r2) goto L41;
        if ((this.f.getAdapter() instanceof c) == false) goto L16;
        c r3 = this.f.getAdapter();
        getContext();
        c(r1, r3.a());
    L40:
        r1 = r1 + 1;
        goto L10
    L16:
        if ((this.f.getAdapter() instanceof d) == false) goto L19;
        int r4 = this.f.getAdapter().a();
        ImageButton r5 = new ImageButton(getContext());
        r5.setImageResource(r4);
        c(r1, r5);
        goto L40
    L19:
        if (this.J.get(r1) == null) goto L21;
        int r6 = this.J.get(r1).a;
        ImageButton r7 = new ImageButton(getContext());
        r7.setImageResource(r6);
        c(r1, r7);
        goto L40
    L21:
        CharSequence r8 = this.f.getAdapter().getPageTitle(r1);
        if (r8 == null) goto L40;
        String r9 = r8.toString();
        e r11 = new e();
        if (this.B == false) goto L26;
        View r12 = new StickerSlideTabItemViewNew(getContext());
    L27:
        View r13 = r12.findViewById(2131388015);
        r11.b = r13;
        r13.setVisibility(8);
        View r14 = r12.findViewById(2131374718);
        r11.c = r14;
        r14.setVisibility(8);
        r11.a = (TextView) r12.findViewById(2131388367);
        if (this.B == false) goto L39;
        int r15 = this.A;
        if (r1 != 0) goto L32;
        int r16 = this.z + r15;
    L34:
        if (r1 != (this.g - 1)) goto L36;
        r15 = r15 + this.z;
    L36:
        View r17 = r12.findViewById(2131388008);
        if (r17 == null) goto L39;
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r17.getLayoutParams();
        r18.setMargins(r16, 0, r15, 0);
        r17.setLayoutParams(r18);
        goto L39
    L32:
        r16 = r15;
    L39:
        r11.a.setText(r9);
        r11.a.setGravity(17);
        r11.a.setSingleLine();
        r12.setTag(r11);
        c(r1, r12);
        goto L40
    L26:
        r12 = new StickerSlideTabItemView(getContext());
        goto L27
    L41:
        View r19 = this.I;
        if (r19 != null) goto L44;
    L54:
        e();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        return;
    L44:
        if (this.s == false) goto L46;
        LinearLayout.LayoutParams r21 = this.b;
    L48:
        if (this.B == false) goto L52;
        View r22 = r19.findViewById(2131388008);
        if (r22 == null) goto L53;
        int r23 = this.y;
        r22.setPadding(r23, 0, r23, 0);
    L53:
        this.e.addView(this.I, r2, r21);
        goto L54
    L52:
        int r24 = this.y;
        r19.setPadding(r24, 0, r24, 0);
        goto L53
    L46:
        r21 = this.a;
        goto L48
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.h;
        return r1;
    }

    public int getDividerColor() {
        return this.r;
    }

    public int getDividerPadding() {
        return this.x;
    }

    public int getIndicatorColor() {
        return this.p;
    }

    public int getIndicatorHeight() {
        return this.v;
    }

    public int getIndicatorWidth() {
        return this.n;
    }

    public ViewPager getPager() {
        return this.f;
    }

    public int getScrollOffset() {
        return this.u;
    }

    public boolean getShouldExpand() {
        return this.s;
    }

    public int getTabBackground() {
        return this.G;
    }

    public int getTabPaddingLeftRight() {
        return this.y;
    }

    public View getTailView() {
        return this.I;
    }

    public ColorStateList getTextColor() {
        return this.D;
    }

    public int getTextSize() {
        return this.C;
    }

    public int getUnderlineColor() {
        return this.q;
    }

    public int getUnderlineHeight() {
        return this.w;
    }

    public LiveEffectPagerSlidingTabStrip(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        super.onDraw(r12);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.g == 0) goto L36;
        int r0 = getHeight();
        if (TextUtils.isEmpty(this.M.get(this.h)) == true) goto L10;
        this.l.setColor(s1.i(this.M.get(this.h), this.p));
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
        r2 = (r6 * r8) + ((1.0f - r8) * r2);
        r3 = (r7 * r8) + ((1.0f - r8) * r3);
    L16:
        int r9 = this.n;
        if (r9 == 0) goto L19;
        float r11 = ((r3 - r2) - r9) / 2.0f;
        r2 = r2 + r11;
        r3 = r3 - r11;
    L19:
        float r13 = r3;
        float r14 = r2;
        int r15 = this.o;
        if (r15 > 0) goto L22;
    L24:
        int r16 = r0 - this.v;
        int r17 = this.N;
        r12.drawRect(r14, r16 - r17, r13, r0 - r17, this.l);
    L25:
        this.l.setColor(this.q);
        r12.drawRect(0.0f, r0 - this.w, this.e.getWidth(), r0, this.l);
        this.m.setColor(this.r);
        int r18 = 0;
    L27:
        if (r18 >= (this.g - 1)) goto L37;
        View r19 = this.e.getChildAt(r18);
        if (this.B == true) goto L31;
        int r21 = this.y;
        r19.setPadding(r21, 0, r21, 0);
    L31:
        r12.drawLine(r19.getRight(), this.x, r19.getRight(), r0 - this.x, this.m);
        r18 = r18 + 1;
        goto L27
    L37:
        return;
    L22:
        if (Build.VERSION.SDK_INT <= 21) goto L24;
        int r22 = r0 - this.v;
        int r23 = this.N;
        r12.drawRoundRect(r14, r22 - r23, r13, r0 - r23, r15, r15, this.l);
        goto L25
    L10:
        this.l.setColor(this.p);
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
        this.t = r1;
    }

    public void setDividerColor(int r1) {
        this.r = r1;
        invalidate();
    }

    public void setDividerColorResource(int r2) {
        this.r = getResources().getColor(r2);
        invalidate();
    }

    public void setDividerPadding(int r1) {
        this.x = r1;
        invalidate();
    }

    public void setIndicatorBottomMargin(int r1) {
        this.N = r1;
    }

    public void setIndicatorColor(int r1) {
        this.p = r1;
        invalidate();
    }

    public void setIndicatorColorResource(int r2) {
        this.p = getResources().getColor(r2);
        invalidate();
    }

    public void setIndicatorHeight(int r1) {
        this.v = r1;
        invalidate();
    }

    public void setIndicatorRadius(int r1) {
        this.o = r1;
        e();
    }

    public void setIndicatorWidth(int r1) {
        this.n = r1;
        e();
    }

    public void setLiveEffectScene(LiveEffectScene r1) {
        this.P = r1;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.d = r1;
    }

    public void setOnScrollListenerByTabStrip(View.OnScrollChangeListener r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        setOnScrollChangeListener(r3);
        return;
    }

    public void setScrollOffset(int r1) {
        this.u = r1;
        invalidate();
    }

    public void setShouldExpand(boolean r1) {
        this.s = r1;
        requestLayout();
    }

    public void setTabBackground(int r1) {
        this.G = r1;
    }

    public void setTabPaddingLeftRight(int r1) {
        this.y = r1;
        e();
    }

    public void setTailView(View r1) {
        this.I = r1;
    }

    public void setTextColor(int r1) {
        this.D = ColorStateList.valueOf(r1);
        e();
    }

    public void setTextColorResource(int r2) {
        this.D = getResources().getColorStateList(r2);
        e();
    }

    public void setTextSelectedStyle(int r1) {
        this.O = r1;
    }

    public void setTextSize(int r1) {
        this.C = r1;
        e();
    }

    public void setUnderlineColor(int r1) {
        this.q = r1;
        invalidate();
    }

    public void setUnderlineColorResource(int r2) {
        this.q = getResources().getColor(r2);
        invalidate();
    }

    public void setUnderlineHeight(int r1) {
        this.w = r1;
        invalidate();
    }

    public void setViewPager(ViewPager r2) {
        this.f = r2;
        if (r2.getAdapter() == null) goto L7;
        r2.setOnPageChangeListener(this.c);
        d();
        return;
    L7:
        throw new IllegalStateException("ViewPager does not have adapter INSTANCE.");
    }

    public LiveEffectPagerSlidingTabStrip(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void c(int r5, View r6) {
        r6.setFocusable(true);
        r6.setOnClickListener(new b(this, r5));
        if (this.s == false) goto L5;
        LinearLayout.LayoutParams r0 = this.b;
    L7:
        if (this.B == false) goto L11;
        View r1 = r6.findViewById(2131388008);
        if (r1 == null) goto L12;
        int r3 = this.y;
        r1.setPadding(r3, 0, r3, 0);
    L12:
        this.e.addView(r6, r5, r0);
        return;
    L11:
        int r2 = this.y;
        r6.setPadding(r2, 0, r2, 0);
        goto L12
    L5:
        r0 = this.a;
        goto L7
    }

    public LiveEffectPagerSlidingTabStrip(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.c = new f(this);
        this.h = 0;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0.5d;
        this.n = 0;
        this.o = 0;
        this.p = 16737894;
        this.q = 436207616;
        this.r = 436207616;
        this.s = false;
        this.t = true;
        this.u = 52;
        this.v = 8;
        this.w = 2;
        this.x = 12;
        this.y = 24;
        this.z = 0;
        this.A = 0;
        this.B = false;
        this.C = 12;
        this.D = ColorStateList.valueOf(16737894);
        this.E = 1;
        this.F = 0;
        this.G = 2131250392;
        this.J = new SparseArray();
        this.K = new SparseArray();
        this.L = new SparseArray();
        this.M = new SparseArray();
        this.N = 0;
        this.O = 0;
        this.P = LiveEffectScene.Live;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r5 = new LinearLayout(r11);
        this.e = r5;
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r5);
        Resources r6 = getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        this.u = (int) TypedValue.applyDimension(1, this.u, r7);
        this.v = (int) TypedValue.applyDimension(1, this.v, r7);
        this.w = (int) TypedValue.applyDimension(1, this.w, r7);
        this.x = (int) TypedValue.applyDimension(1, this.x, r7);
        this.y = (int) TypedValue.applyDimension(1, this.y, r7);
        int r8 = (int) TypedValue.applyDimension(1, 1, r7);
        this.C = (int) TypedValue.applyDimension(1, this.C, r7);
        this.n = (int) TypedValue.applyDimension(1, this.n, r7);
        TypedArray r9 = r11.obtainStyledAttributes(r12, Q);
        this.C = r9.getDimensionPixelSize(0, this.C);
        this.D = r9.getColorStateList(1);
        r9.recycle();
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130974730, 2130974731, 2130974732, 2130974733, 2130974734, 2130974735, 2130974736, 2130974737, 2130974738, 2130974739, 2130974740, 2130974741, 2130974742, 2130974743, 2130974744, 2130974745, 2130974746, 2130974747, 2130974748});
        this.p = r14.getColor(6, this.p);
        this.q = r14.getColor(17, this.q);
        this.r = r14.getColor(2, this.r);
        this.v = r14.getDimensionPixelSize(7, this.v);
        this.w = r14.getDimensionPixelSize(18, this.w);
        this.x = r14.getDimensionPixelSize(3, this.x);
        this.y = r14.getDimensionPixelSize(10, this.y);
        this.G = r14.getResourceId(0, this.G);
        this.s = r14.getBoolean(12, this.s);
        this.u = r14.getDimensionPixelSize(11, this.u);
        this.t = r14.getBoolean(13, this.t);
        this.C = r14.getDimensionPixelSize(15, this.C);
        this.D = r14.getColorStateList(14);
        this.n = r14.getDimensionPixelSize(9, this.n);
        this.o = r14.getDimensionPixelSize(8, 0);
        this.E = r14.getInt(16, 1);
        this.A = r14.getDimensionPixelSize(5, 0);
        this.z = r14.getDimensionPixelSize(1, 0);
        this.B = r14.getBoolean(4, false);
        r14.recycle();
        Paint r15 = new Paint();
        this.l = r15;
        r15.setAntiAlias(true);
        r15.setStyle(Paint.Style.FILL);
        Paint r16 = new Paint();
        this.m = r16;
        r16.setAntiAlias(true);
        r16.setStrokeWidth(r8);
        this.a = new LinearLayout.LayoutParams(-2, -1);
        this.b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.H != null) goto L6;
        this.H = getResources().getConfiguration().locale;
    L6:
        if (this.D != null) goto L9;
        this.D = ColorStateList.valueOf(16737894);
        return;
    }

    public static void a(LiveEffectPagerSlidingTabStrip r5, int r6, boolean r7) {
        int r0 = r5.e.getChildCount();
        if (r0 == 0) goto L46;
        if (r6 < 0) goto L40;
        if (r6 >= r0) goto L47;
        View r1 = r5.e.getChildAt(r6);
        r1.setSelected(r7);
        Object r2 = r1.getTag();
        if ((r2 instanceof e) == false) goto L32;
        e r3 = (e) r2;
        if (r7 == false) goto L20;
        String r4 = r5.K.get(r6);
        if (TextUtils.isEmpty(r4) == true) goto L18;
        View r8 = r3.c;
        if ((r8 instanceof SimpleDraweeView) == false) goto L18;
        r8.setVisibility(0);
        ImageLoader.bindImage(r3.c, r4);
    L18:
        if (TextUtils.isEmpty(r5.M.get(r6)) == true) goto L27;
        r3.a.setTextColor(s1.i(r5.M.get(r6), r5.p));
    L27:
        if (r5.O != 1) goto L41;
        if (r7 == false) goto L30;
        r3.a.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L30:
        r3.a.setTypeface(Typeface.DEFAULT);
        return;
    L41:
        return;
    L20:
        String r9 = r5.L.get(r6);
        if (TextUtils.isEmpty(r9) == true) goto L25;
        View r11 = r3.c;
        if ((r11 instanceof SimpleDraweeView) == false) goto L25;
        r11.setVisibility(0);
        ImageLoader.bindImage(r3.c, r9);
    L25:
        r3.a.setTextColor(r5.D);
        goto L27
    L32:
        if ((r1 instanceof ImageButton) == false) goto L44;
        u r12 = r5.J.get(r6);
        if (r12 == null) goto L45;
        if (r7 == false) goto L37;
        ((ImageButton) r1).setImageResource(r12.b);
    L38:
        r1.setContentDescription(s1.B(r12.c));
        return;
    L37:
        ((ImageButton) r1).setImageResource(r12.a);
        goto L38
    L45:
        return;
    L44:
        return;
    L47:
        return;
    L40:
        return;
    }

    public static void b(LiveEffectPagerSlidingTabStrip r1, int r2, int r3) {
        if (r1.g != 0) goto L6;
        return;
    L6:
        if (RTLUtil.isAppRTL(r1.getContext()) == false) goto L8;
        int r0 = r1.e.getChildAt(r2).getLeft() - r3;
    L9:
        if (r2 > 0) goto L11;
        if (r3 > 0) goto L11;
    L13:
        if (r0 == r1.F) goto L16;
        r1.F = r0;
        r1.scrollTo(r0, 0);
        return;
    L16:
        return;
    L11:
        r0 = r0 - r1.u;
        goto L13
    L8:
        r0 = r1.e.getChildAt(r2).getLeft() + r3;
        goto L9
    }
}
