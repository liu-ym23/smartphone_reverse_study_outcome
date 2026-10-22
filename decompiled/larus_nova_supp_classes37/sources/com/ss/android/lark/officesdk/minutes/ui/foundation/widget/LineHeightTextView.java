package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class LineHeightTextView extends AppCompatTextView {
    public static final a d = null;
    public b a;
    public float b;
    public TextView.BufferType c;

    public class a extends SparseIntArray {
        public a() {
            put(26, 34);
            put(24, 32);
            put(20, 28);
            put(17, 24);
            put(16, 22);
            put(14, 20);
            put(12, 18);
            put(10, 14);
        }
    }

    public static class b extends SpannableStringBuilder {
        public c a;

        public b() {
        }
    }

    public static class c implements LineHeightSpan {
        public int a;

        public c(float r3) {
            this.a = (int) Math.ceil(r3);
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r3, int r4, int r5, int r6, int r7, Paint.FontMetricsInt r8) {
            int r9 = r8.descent;
            int r10 = this.a;
            if (r9 <= r10) goto L5;
            int r11 = Math.min(r10, r9);
            r8.descent = r11;
            r8.bottom = r11;
            r8.ascent = 0;
            r8.top = 0;
            return;
        L5:
            int r12 = r8.ascent;
            if (((-r12) + r9) <= r10) goto L8;
            r8.bottom = r9;
            int r13 = (-r10) + r9;
            r8.ascent = r13;
            r8.top = r13;
            return;
        L8:
            int r14 = r8.bottom;
            if (((-r12) + r14) <= r10) goto L11;
            r8.top = r12;
            r8.bottom = r12 + r10;
            return;
        L11:
            int r15 = r8.top;
            if (((-r15) + r14) <= r10) goto L14;
            r8.top = r14 - r10;
            return;
        L14:
            double r16 = r15;
            double r17 = (r10 - ((-r15) + r14)) / 2.0f;
            r8.top = (int) (r16 - Math.ceil(r17));
            int r18 = (int) (((double) r8.bottom) + Math.floor(r17));
            r8.bottom = r18;
            r8.ascent = r8.top;
            r8.descent = r18;
        }
    }

    static {
        d = new a();
    }

    private b getBuilder() {
        if (this.a != null) goto L6;
        this.a = new b();
    L6:
        return this.a;
    }

    public LineHeightTextView(Context r1) {
        super(r1);
        this.b = -1.0f;
        this.c = TextView.BufferType.NORMAL;
    }

    public void setUXLineHeight(float r2) {
        this.b = r2;
        setText(getText(), this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setUXLineHeightInDp(float r3) {
        Resources r0 = getContext().getResources();
        setUXLineHeight(WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
    }

    public LineHeightTextView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.b = -1.0f;
        this.c = TextView.BufferType.NORMAL;
        x(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r6, TextView.BufferType r7) {
        if (r6 != null) goto L4;
        r6 = "";
    L4:
        this.c = r7;
        if (this.b > 1.0f) goto L7;
        super/*android.widget.TextView*/.setText(r6, r7);
        return;
    L7:
        b r0 = getBuilder();
        float r1 = this.b;
        r0.clear();
        r0.clearSpans();
        c r2 = r0.a;
        if (r2 != null) goto L10;
        r0.a = new c(r1);
    L11:
        r0.append(r6);
        r0.setSpan(r0.a, 0, r6.length(), 17);
        super/*android.widget.TextView*/.setText(r0, r7);
        return;
    L10:
        r2.a = (int) Math.ceil(r1);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(Context r4, AttributeSet r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130975013});
        int r0 = r6.getDimensionPixelSize(0, -1);
        if (r0 >= 0) goto L7;
        Resources r1 = getResources();
        float r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        r0 = (int) (d.get((int) (getTextSize() / r2), -1) * r2);
    L7:
        setUXLineHeight(r0);
        r6.recycle();
    }

    public LineHeightTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = -1.0f;
        this.c = TextView.BufferType.NORMAL;
        x(r1, r2);
    }
}
