package com.ss.android.lark.contact.base.common_ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class IndexBar extends View {
    public float a;
    public b b;
    public List<String> c;
    public int d;
    public Paint e;
    public Paint f;
    public float g;

    public class a implements b {
        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void a(String r1) {
        }

        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void b() {
        }

        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void c(String r1) {
        }

        public a() {
        }
    }

    public interface b {
        void a(String r1);

        void b();

        void c(String r1);
    }

    private b getDummyListener() {
        return new a();
    }

    private int getSuggestedMinWidth() {
        Iterator<String> r0 = this.c.iterator();
        String r1 = BuildConfig.FLAVOR;
    L4:
        if (r0.hasNext() == false) goto L9;
        String r2 = r0.next();
        if (r1.length() >= r2.length()) goto L4;
        r1 = r2;
        goto L4
    L9:
        return (int) (((double) this.e.measureText(r1)) + 0.5d);
    }

    public IndexBar(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        float r0 = r6.getY();
        int r1 = this.d;
        b r2 = this.b;
        int r3 = (int) ((r0 / getHeight()) * this.c.size());
        if (r3 < this.c.size()) goto L5;
        r3 = this.c.size() - 1;
    L7:
        int r7 = r6.getAction();
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L11;
    L13:
        invalidate();
        String r8 = (String) ListProtector.get(this.c, r3);
        r2.b();
    L20:
        return true;
    L11:
        if (r7 == 3) goto L13;
    L15:
        if (r1 == r3) goto L20;
        if (r3 < 0) goto L20;
        if (r3 >= this.c.size()) goto L20;
        r2.c((String) ListProtector.get(this.c, r3));
        this.d = r3;
        invalidate();
        goto L20
    L14:
        r2.a((String) ListProtector.get(this.c, r3));
        goto L15
    L5:
        if (r3 >= 0) goto L7;
        r3 = 0;
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        int r0 = getHeight();
        int r1 = getWidth();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r2 = r0 / this.c.size();
        int r3 = 0;
    L7:
        if (r3 >= this.c.size()) goto L13;
        float r4 = (r1 / 2) - (this.e.measureText((String) ListProtector.get(this.c, r3)) / 2.0f);
        int r5 = r3 + 1;
        float r6 = r2 * r5;
        if (r3 != this.d) goto L11;
        r8.drawText((String) ListProtector.get(this.c, r3), r4, r6 - this.g, this.f);
    L12:
        r3 = r5;
        goto L7
    L11:
        r8.drawText((String) ListProtector.get(this.c, r3), r4, r6 - this.g, this.e);
        goto L12
    }

    public void setFocusIndex(int r1) {
        this.d = r1;
        invalidate();
    }

    public void setNavigators(List<String> r1) {
        this.c = r1;
        invalidate();
        requestLayout();
    }

    public void setOnTouchingLetterChangedListener(b r1) {
        this.b = r1;
    }

    public IndexBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1, r2);
    }

    public final void a(Context r7, AttributeSet r8) {
        this.b = getDummyListener();
        this.c = new ArrayList(0);
        this.d = 0;
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130969027, 2130970115, 2130972525, 2130972526, 2130972527});
        float r0 = r9.getDimension(3, 8.0f);
        int r2 = r9.getColor(2, ContextCompat.getColor(getContext(), R.color.white));
        this.a = r9.getFloat(4, 1.4f);
        int r3 = r9.getColor(1, ContextCompat.getColor(getContext(), R.color.white));
        boolean r1 = r9.getBoolean(0, true);
        r9.recycle();
        if (r1 == false) goto L5;
        Typeface r10 = h18.e.b(r7, 1);
    L6:
        Paint r11 = new Paint();
        this.e = r11;
        r11.setTypeface(r10);
        this.e.setAntiAlias(true);
        this.e.setColor(r2);
        this.e.setTextSize(r0);
        Paint r12 = new Paint();
        this.f = r12;
        r12.setTypeface(r10);
        this.f.setAntiAlias(true);
        this.f.setFakeBoldText(true);
        this.f.setTextSize(r0);
        this.f.setColor(r3);
        return;
    L5:
        r10 = h18.e.a(r7);
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        int r0 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        if (r0 == 1073741824) goto L9;
        int r3 = getSuggestedMinWidth();
        if (r0 != Integer.MIN_VALUE) goto L8;
        r8 = Math.min(r3, r8);
        goto L9
    L8:
        r8 = r3;
    L9:
        int r1 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        if (r1 == 1073741824) goto L16;
        Paint.FontMetrics r2 = this.e.getFontMetrics();
        float r4 = r2.bottom;
        float r5 = r4 - r2.top;
        this.g = r4 * this.a;
        int r10 = (int) ((this.c.size() * r5) * this.a);
        if (r1 != Integer.MIN_VALUE) goto L15;
        r9 = Math.min(r10, r9);
        goto L16
    L15:
        r9 = r10;
    L16:
        setMeasuredDimension(r8, r9);
    }

    public IndexBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1, r2);
    }
}
