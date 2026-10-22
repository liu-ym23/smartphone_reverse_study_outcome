package com.bytedance.android.live.effect.beauty.smallitem;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.sticker.ui.StickerSlideTabItemView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveBeautySecLevelSlidingTab extends HorizontalScrollView {
    public static final int[] D = null;
    public final List<String> A;
    public b B;
    public int C;
    public final LinearLayout.LayoutParams a;
    public final LinearLayout.LayoutParams b;
    public ViewPager.OnPageChangeListener c;
    public final LinearLayout d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public ColorStateList s;
    public final int t;
    public int u;
    public final Locale v;
    public final SparseArray<Pair<Integer, Integer>> w;
    public final SparseArray<String> x;
    public final SparseArray<String> y;
    public final SparseArray<String> z;

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

    public static class a {
        public TextView a;
        public View b;
        public View c;

        public a() {
        }
    }

    public interface b {
        void a(int r1);
    }

    static {
        D = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final void c() {
        int r1 = 0;
    L4:
        if (r1 >= this.e) goto L11;
        View r2 = this.d.getChildAt(r1);
        r2.setBackgroundResource(this.u);
        Object r3 = r2.getTag();
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        r4.a.setTextSize(0, this.r);
        r4.a.setTypeface(null, this.t);
        r4.a.setTextColor(this.s);
        if (this.l == false) goto L10;
        r4.a.setAllCaps(true);
    L10:
        r1 = r1 + 1;
        goto L4
    }

    public void setIconResId(int r1) {
    }

    public void setIndicatorBottomMargin(int r1) {
    }

    public final void a() {
        this.d.removeAllViews();
        this.e = ((ArrayList) this.A).size();
        final int r1 = 0;
    L4:
        if (r1 >= this.e) goto L13;
        CharSequence r2 = (CharSequence) ListProtector.get(this.A, r1);
        if (r2 == null) goto L12;
        String r3 = r2.toString();
        a r4 = new a();
        StickerSlideTabItemView r5 = new StickerSlideTabItemView(getContext());
        View r6 = r5.findViewById(2131388015);
        r4.b = r6;
        r6.setVisibility(8);
        View r7 = r5.findViewById(2131374718);
        r4.c = r7;
        r7.setVisibility(8);
        TextView r8 = (TextView) r5.findViewById(2131388367);
        r4.a = r8;
        r8.setText(r3);
        r4.a.setGravity(17);
        r4.a.setSingleLine();
        r5.setTag(r4);
        r5.setFocusable(true);
        r5.setOnClickListener(new h(this, r1));
        if (this.k == false) goto L10;
        LinearLayout.LayoutParams r9 = this.b;
    L11:
        int r11 = this.q;
        r5.setPadding(r11, 0, r11, 0);
        this.d.addView(r5, r1, r9);
        goto L12
    L10:
        r9 = this.a;
    L12:
        r1 = r1 + 1;
        goto L4
    L13:
        c();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.f;
        return r1;
    }

    public int getCurrentPosition() {
        return this.f;
    }

    public List<String> getDatas() {
        return this.A;
    }

    public int getDividerColor() {
        return this.j;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getIndicatorColor() {
        return this.h;
    }

    public int getIndicatorHeight() {
        return this.n;
    }

    public int getIndicatorWidth() {
        return this.g;
    }

    public int getScrollOffset() {
        return this.m;
    }

    public boolean getShouldExpand() {
        return this.k;
    }

    public int getTabBackground() {
        return this.u;
    }

    public int getTabPaddingLeftRight() {
        return this.q;
    }

    public ColorStateList getTextColor() {
        return this.s;
    }

    public int getTextSize() {
        return this.r;
    }

    public int getUnderlineColor() {
        return this.i;
    }

    public int getUnderlineHeight() {
        return this.o;
    }

    public LiveBeautySecLevelSlidingTab(Context r2) {
        this(r2, null);
    }

    public final void b(int r3) {
        d(this.f, false);
        this.f = r3;
        d(r3, true);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
        isInEditMode();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.f = r3.a;
        requestLayout();
    }

    public void setAllCaps(boolean r1) {
        this.l = r1;
    }

    public void setDividerColor(int r1) {
        this.j = r1;
        invalidate();
    }

    public void setDividerColorResource(int r2) {
        this.j = getResources().getColor(r2);
        invalidate();
    }

    public void setDividerPadding(int r1) {
        this.p = r1;
        invalidate();
    }

    public void setIndicatorColor(int r1) {
        this.h = r1;
        invalidate();
    }

    public void setIndicatorColorResource(int r2) {
        this.h = getResources().getColor(r2);
        invalidate();
    }

    public void setIndicatorHeight(int r1) {
        this.n = r1;
        invalidate();
    }

    public void setIndicatorRadius(int r1) {
        c();
    }

    public void setIndicatorWidth(int r1) {
        this.g = r1;
        c();
    }

    public void setOnClickItemListener(b r1) {
        this.B = r1;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.c = r1;
    }

    public void setScrollOffset(int r1) {
        this.m = r1;
        invalidate();
    }

    public void setShouldExpand(boolean r1) {
        this.k = r1;
        requestLayout();
    }

    public void setTabBackground(int r1) {
        this.u = r1;
    }

    public void setTabPaddingLeftRight(int r1) {
        this.q = r1;
        c();
    }

    public void setTextColor(int r1) {
        this.s = ColorStateList.valueOf(r1);
        c();
    }

    public void setTextColorResource(int r2) {
        this.s = getResources().getColorStateList(r2);
        c();
    }

    public void setTextSelectedStyle(int r1) {
        this.C = r1;
    }

    public void setTextSize(int r1) {
        this.r = r1;
        c();
    }

    public void setUnderlineColor(int r1) {
        this.i = r1;
        invalidate();
    }

    public void setUnderlineColorResource(int r2) {
        this.i = getResources().getColor(r2);
        invalidate();
    }

    public void setUnderlineHeight(int r1) {
        this.o = r1;
        invalidate();
    }

    public LiveBeautySecLevelSlidingTab(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void d(int r6, boolean r7) {
        int r0 = this.d.getChildCount();
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r6 < 0) goto L39;
        if (r6 >= r0) goto L46;
        View r1 = this.d.getChildAt(r6);
        r1.setSelected(r7);
        Object r2 = r1.getTag();
        if ((r2 instanceof a) == false) goto L32;
        a r3 = (a) r2;
        if (r7 == false) goto L20;
        String r4 = this.x.get(r6);
        if (TextUtils.isEmpty(r4) == true) goto L18;
        View r5 = r3.c;
        if ((r5 instanceof SimpleDraweeView) == false) goto L18;
        r5.setVisibility(0);
        ImageLoader.bindImage(r3.c, r4);
    L18:
        if (TextUtils.isEmpty(this.z.get(r6)) == true) goto L27;
        r3.a.setTextColor(s1.i(this.z.get(r6), this.h));
    L27:
        if (this.C != 1) goto L40;
        if (r7 == false) goto L30;
        r3.a.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L30:
        r3.a.setTypeface(Typeface.DEFAULT);
        return;
    L40:
        return;
    L20:
        String r8 = this.y.get(r6);
        if (TextUtils.isEmpty(r8) == true) goto L25;
        View r9 = r3.c;
        if ((r9 instanceof SimpleDraweeView) == false) goto L25;
        r9.setVisibility(0);
        ImageLoader.bindImage(r3.c, r8);
    L25:
        r3.a.setTextColor(this.s);
        goto L27
    L32:
        if ((r1 instanceof ImageButton) == false) goto L43;
        Pair<Integer, Integer> r11 = this.w.get(r6);
        if (r11 == null) goto L44;
        if (r7 == false) goto L37;
        ((ImageButton) r1).setImageResource(((Integer) r11.second).intValue());
        return;
    L37:
        ((ImageButton) r1).setImageResource(((Integer) r11.first).intValue());
        return;
    L44:
        return;
    L43:
        return;
    L46:
        return;
    }

    public LiveBeautySecLevelSlidingTab(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.f = 0;
        this.g = 0;
        this.h = 16737894;
        this.i = 436207616;
        this.j = 436207616;
        this.k = false;
        this.l = true;
        this.m = 52;
        this.n = 8;
        this.o = 2;
        this.p = 12;
        this.q = 24;
        this.r = 12;
        this.s = ColorStateList.valueOf(16737894);
        this.t = 1;
        this.u = 2131250392;
        this.w = new SparseArray();
        this.x = new SparseArray();
        this.y = new SparseArray();
        this.z = new SparseArray();
        this.A = new ArrayList();
        this.C = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r5 = new LinearLayout(r11);
        this.d = r5;
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r5);
        Resources r6 = getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        this.m = (int) TypedValue.applyDimension(1, this.m, r7);
        this.n = (int) TypedValue.applyDimension(1, this.n, r7);
        this.o = (int) TypedValue.applyDimension(1, this.o, r7);
        this.p = (int) TypedValue.applyDimension(1, this.p, r7);
        this.q = (int) TypedValue.applyDimension(1, this.q, r7);
        int r8 = (int) TypedValue.applyDimension(1, 1, r7);
        this.r = (int) TypedValue.applyDimension(1, this.r, r7);
        this.g = (int) TypedValue.applyDimension(1, this.g, r7);
        TypedArray r9 = r11.obtainStyledAttributes(r12, D);
        this.r = r9.getDimensionPixelSize(0, this.r);
        this.s = r9.getColorStateList(1);
        r9.recycle();
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130974730, 2130974731, 2130974732, 2130974733, 2130974734, 2130974735, 2130974736, 2130974737, 2130974738, 2130974739, 2130974740, 2130974741, 2130974742, 2130974743, 2130974744, 2130974745, 2130974746, 2130974747, 2130974748});
        this.h = r14.getColor(6, this.h);
        this.i = r14.getColor(17, this.i);
        this.j = r14.getColor(2, this.j);
        this.n = r14.getDimensionPixelSize(7, this.n);
        this.o = r14.getDimensionPixelSize(18, this.o);
        this.p = r14.getDimensionPixelSize(3, this.p);
        this.q = r14.getDimensionPixelSize(10, this.q);
        this.u = r14.getResourceId(0, this.u);
        this.k = r14.getBoolean(12, this.k);
        this.m = r14.getDimensionPixelSize(11, this.m);
        this.l = r14.getBoolean(13, this.l);
        this.r = r14.getDimensionPixelSize(15, this.r);
        this.s = r14.getColorStateList(14);
        this.g = r14.getDimensionPixelSize(9, this.g);
        r14.getDimensionPixelSize(8, 0);
        this.t = r14.getInt(16, 1);
        r14.recycle();
        Paint r15 = new Paint();
        r15.setAntiAlias(true);
        r15.setStyle(Paint.Style.FILL);
        Paint r16 = new Paint();
        r16.setAntiAlias(true);
        r16.setStrokeWidth(r8);
        this.a = new LinearLayout.LayoutParams(-2, -1);
        this.b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.v != null) goto L6;
        this.v = getResources().getConfiguration().locale;
    L6:
        if (this.s != null) goto L9;
        this.s = ColorStateList.valueOf(16737894);
        return;
    }
}
