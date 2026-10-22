package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RoundIndicatorView extends View {
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public Paint f;
    public int g;
    public float h;
    public float i;
    public int j;
    public ViewPager k;

    public class a implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ RoundIndicatorView a;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public a(RoundIndicatorView r1) {
            this.a = r1;
        }

        public final void onPageSelected(int r3) {
            RoundIndicatorView r0 = this.a;
            int r1 = r0.g;
            if (r1 <= 0) goto L9;
            int r4 = r3 % r1;
            if (r4 >= r1) goto L7;
            r0.setLocation(r4);
            return;
        L7:
            r0.setLocation(0);
            return;
        }
    }

    public RoundIndicatorView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        super.onDraw(r7);
        this.h = getPaddingLeft();
        this.i = getPaddingTop();
        this.f.setColor(this.b);
        float r0 = this.h;
        int r1 = 0;
    L4:
        if (r1 >= this.g) goto L10;
        if (this.j != r1) goto L8;
        this.f.setColor(this.a);
    L9:
        float r2 = this.e;
        r7.drawCircle(r0 + r2, this.i + r2, r2, this.f);
        r0 = r0 + (this.d + this.c);
        r1 = r1 + 1;
        goto L4
    L8:
        this.f.setColor(this.b);
        goto L9
    }

    public void setCount(int r1) {
        this.g = r1;
        measure(0, 0);
        invalidate();
    }

    public void setLocation(int r1) {
        this.j = r1;
        invalidate();
    }

    public void setSizeDp(float r2) {
        float r3 = s1.f(r2);
        this.d = r3;
        this.e = r3 / 2.0f;
        invalidate();
    }

    public void setSpaceDp(float r1) {
        this.c = s1.f(r1);
        invalidate();
    }

    public void setViewPager(ViewPager r2) {
        this.k = r2;
        if (r2 == null) goto L6;
        r2.addOnPageChangeListener(new a(this));
        return;
    }

    public RoundIndicatorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getMode(r8);
        int r1 = View.MeasureSpec.getMode(r9);
        int r10 = View.MeasureSpec.getSize(r8);
        int r11 = View.MeasureSpec.getSize(r9);
        if (r0 == 1073741824) goto L10;
        r10 = getPaddingLeft() + getPaddingRight();
        int r4 = this.g;
        if (r4 <= 0) goto L8;
        r10 = (int) (r10 + ((r4 * this.d) + ((r4 - 1) * this.c)));
    L8:
        if (r0 != Integer.MIN_VALUE) goto L10;
        r10 = Math.max(r10, getSuggestedMinimumWidth());
    L10:
        if (r1 == 1073741824) goto L17;
        r11 = getPaddingBottom() + getPaddingTop();
        if (this.g <= 0) goto L15;
        r11 = r11 + ((int) this.d);
    L15:
        if (r1 != Integer.MIN_VALUE) goto L17;
        r11 = Math.max(r11, getSuggestedMinimumHeight());
    L17:
        setMeasuredDimension(r10, r11);
    }

    public RoundIndicatorView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.g = 0;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130973757, 2130973758, 2130973759, 2130973760, 2130973761, 2130974777, 2130974778, 2130974779, 2130974780, 2130974781}, r5, 0);
        this.c = r6.getDimension(4, 0.0f);
        float r7 = r6.getDimension(3, 0.0f);
        this.d = r7;
        this.e = r7 / 2.0f;
        this.b = r6.getColor(1, -1726079458);
        this.a = r6.getColor(2, -10704);
        this.g = r6.getInt(0, 0);
        r6.recycle();
        Paint r8 = new Paint();
        this.f = r8;
        r8.setAntiAlias(true);
        this.j = 0;
    }
}
