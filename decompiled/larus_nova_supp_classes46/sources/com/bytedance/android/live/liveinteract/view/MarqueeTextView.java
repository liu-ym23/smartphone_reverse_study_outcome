package com.bytedance.android.live.liveinteract.view;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.xb1;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MarqueeTextView extends AppCompatTextView {
    public Scroller a;
    public final String b;
    public String c;
    public final int d;
    public boolean e;
    public boolean f;

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        String r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = x(r0) - getWidth();
        ALogger.i("MarqueeTextView", "startScroll distance " + r1);
        if (r1 > 0) goto L8;
        return;
    L8:
        String r2 = (this.c + this.b) + this.c;
        int r6 = x(r2) - x(this.c);
        setText(r2);
        setHorizontallyScrolling(true);
        Scroller r3 = new Scroller(getContext(), new LinearInterpolator());
        this.a = r3;
        setScroller(r3);
        this.a.startScroll(0, 0, r6, 0, (1000 / s1.f(this.d)) * r6);
        invalidate();
        if (this.e == false) goto L12;
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(50);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.widget.TextView*/.computeScroll();
        Scroller r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.isFinished();
        if (this.f == true) goto L8;
        return;
    L8:
        if (this.a.isFinished() == true) goto L10;
        return;
    L10:
        if (this.a == null) goto L13;
        ALogger.i("MarqueeTextView", "resetScroll");
        this.a.abortAnimation();
        scrollTo(0, 0);
    L13:
        y();
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
        if (r1 == null) goto L6;
        r1.abortAnimation();
        this.a = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarqueeTextView(Context r2) {
        this(r2, null);
        setSingleLine();
        setEllipsize(null);
    }

    public void setFadingEdge(boolean r1) {
        this.e = r1;
    }

    public void setInfinite(boolean r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOriginText(CharSequence r2) {
        this.c = r2.toString();
        if (this.a == null) goto L7;
        ALogger.i("MarqueeTextView", "resetScroll");
        this.a.abortAnimation();
        scrollTo(0, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int x(String r5) {
        TextPaint r0 = getPaint();
        Rect r1 = new Rect();
        r0.getTextBounds(r5, 0, r5.length(), r1);
        return r1.width();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarqueeTextView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textViewStyle);
        setSingleLine();
        setEllipsize(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.TextView*/.setText(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarqueeTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = "              ";
        this.d = ((xb1) h.Z4.getValue(null, h.a[310(0x136, float:4.34E-43)])).a();
        this.e = false;
        this.f = false;
        setSingleLine();
        setEllipsize(null);
    }
}
