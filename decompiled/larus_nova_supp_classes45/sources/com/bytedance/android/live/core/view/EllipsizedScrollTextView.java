package com.bytedance.android.live.core.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.util.Pair;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EllipsizedScrollTextView extends AppCompatTextView {
    public Scroller a;
    public int b;
    public boolean c;
    public final String d;
    public final String e;
    public String f;
    public int g;

    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Pair<String, Integer> getEllipsizedText() {
        TextPaint r0 = getPaint();
        int r1 = getWidth();
        if (r1 >= x(r0, getText().toString())) goto L5;
        int r5 = 1;
    L8:
        if (r5 >= getText().length()) goto L18;
        int r6 = x(r0, getText().subSequence(0, r5).toString() + this.e);
        if (r6 == r1) goto L12;
        if (r6 > r1) goto L14;
        r5 = r5 + 1;
        goto L8
    L14:
        StringBuilder r4 = new StringBuilder();
        int r7 = r5 - 1;
        r4.append(getText().subSequence(0, r7));
        r4.append(this.e);
        return new Pair(r4.toString(), Integer.valueOf(r1 - x(r0, getText().subSequence(0, r7).toString() + this.e)));
    L12:
        return new Pair(getText().subSequence(0, r5) + this.e, 0);
    L18:
        return new Pair(getText().toString(), 0);
    L5:
        return new Pair("", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.widget.TextView*/.computeScroll();
        Scroller r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isFinished() == false) goto L16;
        boolean r1 = this.c;
        if (r1 == true) goto L17;
        Scroller r2 = this.a;
        if (r2 == null) goto L18;
        if (r1 == true) goto L19;
        this.c = true;
        this.b = r2.getCurrX();
        this.a.abortAnimation();
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        setEllipsize(null);
        setTranslationX(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        setEllipsize(null);
        Scroller r1 = this.a;
        if (r1 == null) goto L5;
        r1.abortAnimation();
        this.a = null;
    L5:
        this.f = null;
        this.b = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        Pair<String, Integer> r0 = getEllipsizedText();
        this.f = (String) r0.first;
        this.g = ((Integer) r0.second).intValue();
        this.c = true;
        ALogger.i("EllipsizedScrollTextView", "getEllipsizedText; startScroll; mEllipsizedText=" + this.f + ", mEllipsizedTextGap=" + this.g);
        if (TextUtils.isEmpty(this.f) == false) goto L6;
        return;
    L6:
        if (this.c == false) goto L10;
        ALogger.i("EllipsizedScrollTextView", "resumeScroll");
        setText(getText() + this.d + this.f);
        setHorizontallyScrolling(true);
        Scroller r1 = new Scroller(getContext(), new LinearInterpolator());
        this.a = r1;
        setScroller(r1);
        int r5 = x(getPaint(), getText().toString()) - (x(getPaint(), this.f) + this.b);
        this.a.startScroll(this.b, 0, r5, 0, (int) ((r5 / x(getPaint(), "正")) * 307.69232f));
        invalidate();
        this.c = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EllipsizedScrollTextView(Context r2) {
        this(r2, null);
        setSingleLine();
        setEllipsize(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r1) {
        super/*android.widget.TextView*/.onDraw(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EllipsizedScrollTextView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textViewStyle);
        setSingleLine();
        setEllipsize(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.TextView*/.setText(r1, r2);
    }

    public final int x(TextPaint r4, String r5) {
        Rect r0 = new Rect();
        r4.getTextBounds(r5, 0, r5.length(), r0);
        return r0.width();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EllipsizedScrollTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = 0;
        this.c = true;
        this.d = "      ";
        this.e = "...  ";
        setSingleLine();
        setEllipsize(null);
    }
}
