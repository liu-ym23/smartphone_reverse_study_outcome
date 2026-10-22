package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CodeBlockWithLineNumberScrollableSpan extends ReplacementSpan implements LeadingMarginSpan, SpanWatcher, lw8.e {
    public final s a;
    public final c b;
    public final int c;
    public boolean d;
    public final GradientDrawable e;
    public final TextPaint f;
    public final TextPaint g;
    public final int h;
    public final TreeMap<Point, Layout> i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final int m;

    public final int b() {
        return ((Number) this.k.getValue()).intValue();
    }

    public final boolean c() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    public final int d() {
        return ((Number) this.j.getValue()).intValue();
    }

    @Override // lw8.e
    public final int a() {
        return this.m;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r1) {
        return ((Number) MarkdownDimensExtKt.d.getValue()).intValue();
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        this.a.a(r2);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        this.a.a(r2);
    }

    public CodeBlockWithLineNumberScrollableSpan(s r5, c r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "theme");
        Intrinsics.checkNotNullParameter(r6, "info");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        GradientDrawable r8 = new GradientDrawable();
        b r9 = r6.h;
        Integer r0 = null;
        if (r9 == null) goto L5;
        ctc.e r10 = r9.c;
    L7:
        if (r10 == null) goto L9;
        r8.setColor(r10.d);
        r8.setBounds(0, 0, r10.a, r10.b);
        r8.setCornerRadius(r10.b * 0.5f);
    L9:
        this.e = r8;
        TextPaint r11 = new TextPaint(1);
        r11.setTypeface(Typeface.MONOSPACE);
        Lazy r2 = MarkdownDimensExtKt.l;
        r11.setTextSize(((Number) r2.getValue()).intValue());
        b r3 = r6.h;
        if (r3 == null) goto L12;
        r11.setColor(r3.d);
    L12:
        this.f = r11;
        TextPaint r12 = new TextPaint(1);
        a r13 = r6.i;
        if (r13 == null) goto L15;
        r12.setTextSize(((Number) r2.getValue()).intValue());
        r12.setColor(r13.c);
        r12.setTypeface(Typeface.MONOSPACE);
        r12.setTextAlign(Paint.Align.RIGHT);
    L15:
        this.g = r12;
        a r14 = r6.i;
        if (r14 == null) goto L18;
        r0 = Integer.valueOf(r14.b);
    L18:
        this.h = (int) r12.measureText(String.valueOf(r0));
        final CodeBlockWithLineNumberScrollableSpan$layouts$1 r15 = CodeBlockWithLineNumberScrollableSpan$layouts$1.INSTANCE;
        this.i = new TreeMap(new e(r15));
        this.j = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$marginStart$2(this));
        this.k = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$codeBlockWidth$2(this));
        this.l = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$enableScroll$2(this));
        this.m = d() - getLeadingMargin(false);
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final Layout e(CharSequence r2, int r3, int r4) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r2, r3, r4);
        r0.removeSpan(this);
        CharSequence r5 = StringsKt.removeSuffix(r0, "\n");
        if (c() == false) goto L11;
        b r6 = this.b.h;
        if (r6 == null) goto L7;
        ctc.a r7 = r6.b;
    L8:
        if (r7 == null) goto L11;
        return f(r5, Integer.MAX_VALUE, 1);
    L7:
        r7 = null;
    L11:
        return f(r5, b(), Integer.MAX_VALUE);
    }

    public final Layout f(CharSequence r9, int r10, int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return StaticLayout.Builder.obtain(r9, 0, r9.length(), this.f, r10).setIncludePad(false).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setMaxLines(r11).build();
    L7:
        return new StaticLayout(r9, this.f, r10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
        if ((r2 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof UpdateLayout) == true) goto L9;
        this.d = true;
        return;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
        if ((r2 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof UpdateLayout) == true) goto L9;
        this.d = true;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r6, CharSequence r7, int r8, int r9, Paint.FontMetricsInt r10) {
        Intrinsics.checkNotNullParameter(r6, "paint");
        if (r7 != null) goto L5;
        return 0;
    L5:
        Layout r11 = e(r7, r8, r9);
        this.i.put(new Point(r8, r9), r11);
        b r12 = this.b.h;
        ctc.e r0 = null;
        if (r12 == null) goto L8;
        ctc.a r13 = r12.b;
    L9:
        float r1 = 0.0f;
        if (r13 != null) goto L12;
    L14:
        if (r10 == null) goto L34;
        Integer r2 = this.b.b;
        if (r2 != null) goto L19;
    L21:
        boolean r14 = false;
    L22:
        b r3 = this.b.h;
        if (r3 == null) goto L25;
        r0 = r3.c;
    L25:
        if (r14 == false) goto L30;
        if (r0 == null) goto L30;
        if (c() == false) goto L30;
        r1 = r0.b + r0.c;
    L30:
        int r4 = -r11.getHeight();
        r10.ascent = r4;
        if (r14 == false) goto L33;
        r10.ascent = r4 - MathKt.roundToInt(r1);
    L33:
        r10.descent = 0;
        r10.top = r10.ascent;
        r10.bottom = 0;
        this.d = false;
        goto L34
    L19:
        if (r9 != r2.intValue()) goto L21;
        r14 = true;
    L34:
        if (r13 == null) goto L39;
        if (c() == false) goto L39;
        return Math.min(b(), MathKt.roundToInt(r11.getLineWidth(0)));
    L39:
        return b();
    L12:
        if (c() == false) goto L14;
        r13.b = Math.max(0.0f, Math.max(r13.b, r11.getLineWidth(0) - b()));
        goto L14
    L8:
        r13 = null;
        goto L9
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
        if ((r2 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof UpdateLayout) == true) goto L9;
        this.d = true;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r3, CharSequence r4, int r5, int r6, float r7, int r8, int r9, int r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r11, "paint");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.d == false) goto L8;
        Layout r12 = e(r4, r5, r6);
        this.i.put(new Point(r5, r6), r12);
    L26:
        int r13 = r3.save();
    L41:
        th = move-exception;
        r3.restoreToCount(r13);
        throw th;
    L28:
        if (c() == false) goto L30;
        r3.clipRect((int) (r7 + this.h), r8, this.c, r10);     // Catch: Throwable -> L41
    L30:
        b r14 = this.b.h;     // Catch: Throwable -> L41
        if (r14 == null) goto L35;
        ctc.a r15 = r14.b;     // Catch: Throwable -> L41
        if (r15 == null) goto L35;
        float r16 = r15.a + d();     // Catch: Throwable -> L41
    L36:
        r3.translate(r16, r8);     // Catch: Throwable -> L41
        if (r12 == null) goto L39;
        r12.draw(r3);     // Catch: Throwable -> L41
    L39:
        r3.restoreToCount(r13);
        return;
    L35:
        r16 = d();     // Catch: Throwable -> L41
        goto L36
    L8:
        r12 = this.i.get(new Point(r5, r6));
        if (r12 != null) goto L26;
        Iterator<T> r17 = this.i.entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L21;
        Object r18 = r17.next();
        Map.Entry r0 = (Map.Entry) r18;
        if (((Point) r0.getKey()).x == r5) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L12;
    L22:
        Map.Entry r19 = (Map.Entry) r18;
        if (r19 == null) goto L25;
        r12 = (Layout) r19.getValue();
        goto L26
    L25:
        r12 = null;
        goto L26
    L16:
        if (((Point) r0.getKey()).y < r6) goto L18;
        r1 = true;
        goto L19
    L21:
        r18 = null;
        goto L22
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        Intrinsics.checkNotNullParameter(r1, "c");
        Intrinsics.checkNotNullParameter(r2, "p");
        Intrinsics.checkNotNullParameter(r8, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r12, "layout");
        a r13 = this.b.i;
        ctc.e r14 = null;
        if (r13 == null) goto L7;
        Map<Integer, Integer> r15 = r13.a;
        if (r15 == null) goto L7;
        Integer r16 = r15.get(Integer.valueOf(r9));
    L8:
        if (r16 == null) goto L10;
        r1.drawText(r16.toString(), (r3 + this.h) + getLeadingMargin(false), r5 + (this.g.descent() - this.g.ascent()), this.g);
    L10:
        Integer r17 = this.b.b;
        if (r17 != null) goto L14;
        return;
    L14:
        if (r10 != r17.intValue()) goto L31;
        b r18 = this.b.h;
        if (r18 == null) goto L18;
        ctc.a r19 = r18.b;
    L19:
        if (r18 == null) goto L21;
        r14 = r18.c;
    L21:
        if (r19 != null) goto L23;
        return;
    L23:
        if (c() == false) goto L35;
        if (r14 == null) goto L36;
        int r20 = r1.save();
        r1.translate((((-r19.a) / r19.b) * (b() - r14.a)) + d(), (r7 - r14.b) - r14.c);     // Catch: Throwable -> L28
        this.e.draw(r1);     // Catch: Throwable -> L28
        r1.restoreToCount(r20);
        return;
    L28:
        th = move-exception;
        r1.restoreToCount(r20);
        throw th;
    L36:
        return;
    L35:
        return;
    L18:
        r19 = null;
        goto L19
    L31:
        return;
    L7:
        r16 = null;
        goto L8
    }
}
