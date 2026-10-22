package com.larus.dora.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0007H\u0003J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0015J \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010A\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0016J(\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0016J\u000e\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u0012J\u0016\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/larus/dora/impl/view/DoraQueryTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "text", "", "startImage", "Landroid/graphics/drawable/Drawable;", "imageWidth", "imageHeight", "imageTextSpacing", "isImageVisible", "", "fontWeight", "textColor", "textSize", "", "baseTypeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "lineSpacingMultiplier", "lineSpacingExtra", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "textPaint", "Landroid/text/TextPaint;", "staticLayout", "Landroid/text/StaticLayout;", "imageRect", "Landroid/graphics/Rect;", "firstLineText", "remainingText", "textLineHeight", "firstLineWidth", "configTextPaint", "", "splitTextIntoLines", "availableWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "calculateFinalWidth", "parentMode", "parentSize", "calculateFinalHeight", "availableHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFirstLine", "drawRemainingLines", "setText", "setTextSize", "dp", "", "setTextColor", "color", "setTextFontWeight", "setLineSpacing", "extra", "multiplier", "setPadding", "left", "top", "right", "bottom", "setStartImage", "resId", "setImageVisible", "visible", "setImageSize", "width", "height", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraQueryTextView extends View {
    public String a;
    public Drawable b;
    public int c;
    public int d;
    public final int e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public final Typeface j;
    public final float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final TextPaint p;
    public StaticLayout q;
    public final Rect r;
    public String s;
    public String t;
    public float u;
    public float v;

    public DoraQueryTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraQueryTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        TextPaint r0 = this.p;
        r0.setColor(this.h);
        r0.setTextSize(this.i);
        r0.setTextAlign(Paint.Align.LEFT);
        r0.setTypeface(this.j);
        boolean r1 = true;
        r0.setAntiAlias(true);
        this.u = r0.descent() - r0.ascent();
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r0.setTypeface(Typeface.create(this.j, this.g, false));
        return;
    L6:
        if (this.g >= 500) goto L9;
        r1 = false;
    L9:
        r0.setFakeBoldText(r1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        boolean r1 = true;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (this.f == true) goto L11;
    L13:
        float r2 = this.v;
    L14:
        float r3 = getWidth() - r2;
        float r4 = 2;
        int r5 = (int) (r3 / r4);
        float r6 = Math.max(this.d, this.u);
        float r7 = this.m;
        float r8 = (r6 / r4) + r7;
        float r9 = r7 - this.p.ascent();
        if (this.f == true) goto L17;
    L24:
        int r10 = this.l;
        if (this.f == true) goto L27;
    L29:
        int r12 = 0;
    L30:
        r11.drawText(this.s, (r10 + r12) + r5, r9, this.p);
        if (this.t.length() == 0) goto L34;
        r1 = false;
    L34:
        if (r1 == false) goto L36;
        return;
    L36:
        if (this.q == null) goto L50;
        float r13 = this.m + RangesKt.coerceAtLeast(this.d, this.u * this.k);
        float r14 = this.l;
        int r15 = r11.save();
        r11.translate(r14, r13);
        StaticLayout r16 = this.q;     // Catch: Throwable -> L43
        if (r16 == null) goto L42;
        r16.draw(r11);     // Catch: Throwable -> L43
    L42:
        r11.restoreToCount(r15);
        return;
    L43:
        th = move-exception;
        r11.restoreToCount(r15);
        throw th;
    L50:
        return;
    L27:
        if (this.b == null) goto L29;
        r12 = this.c + this.e;
        goto L30
    L17:
        if (this.b == null) goto L24;
        int r17 = this.d;
        int r18 = (int) (r8 - (r17 / 2));
        Rect r20 = this.r;
        int r21 = this.l;
        r20.set(r21 + r5, r18, (r21 + this.c) + r5, r17 + r18);
        Drawable r22 = this.b;
        if (r22 == null) goto L21;
        r22.setBounds(this.r);
    L21:
        Drawable r23 = this.b;
        if (r23 == null) goto L24;
        r23.draw(r11);
        goto L24
    L11:
        if (this.b == null) goto L13;
        r2 = (this.c + this.e) + this.v;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public final void setImageVisible(boolean r1) {
        this.f = r1;
        invalidate();
        requestLayout();
    }

    public final void setStartImage(int r4) {
        Drawable r5 = AppCompatResources.getDrawable(getContext(), r4);
        this.b = r5;
        if (r5 == null) goto L5;
        r5.setBounds(0, 0, this.c, this.d);
    L5:
        invalidate();
        requestLayout();
    }

    public final void setText(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.a = r1;
        invalidate();
        requestLayout();
    }

    public final void setTextColor(int r1) {
        this.h = r1;
        a();
        invalidate();
    }

    public final void setTextFontWeight(int r3) {
        this.g = RangesKt.coerceIn(r3, 100, 900);
        a();
        invalidate();
    }

    public final void setTextSize(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "dp");
        this.i = c7.c(r2);
        a();
        invalidate();
        requestLayout();
    }

    public final void b(int r3, int r4) {
        this.c = RangesKt.coerceAtLeast(r3, 0);
        this.d = RangesKt.coerceAtLeast(r4, 0);
        Drawable r1 = this.b;
        if (r1 == null) goto L5;
        r1.setBounds(0, 0, r3, r4);
    L5:
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r9, int r10) {
        super.onMeasure(r9, r10);
        int r11 = View.MeasureSpec.getSize(r9);
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = (r11 - this.l) - this.n;
        int r14 = (r12 - this.m) - this.o;
        boolean r1 = true;
        int r2 = 0;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        float r3 = 0.0f;
        String r4 = "";
        if (r0 == false) goto L10;
        this.s = "";
        this.t = "";
        this.v = 0.0f;
    L31:
        if (this.f == true) goto L33;
    L35:
        float r5 = this.v;
    L36:
        StaticLayout r6 = this.q;
        if (r6 == null) goto L39;
        r3 = r6.getWidth();
    L39:
        int r15 = RangesKt.coerceAtMost((int) RangesKt.coerceAtLeast(r5, r3), r13);
        if (this.f == true) goto L42;
    L44:
        float r7 = this.u * this.k;
    L45:
        int r8 = (int) r7;
        StaticLayout r16 = this.q;
        if (r16 == null) goto L48;
        r2 = r16.getHeight();
    L48:
        setMeasuredDimension((r15 + this.l) + this.n, (RangesKt.coerceAtMost(r8 + r2, r14) + this.m) + this.o);
        return;
    L42:
        if (this.b == null) goto L44;
        r7 = RangesKt.coerceAtLeast(this.d, this.u * this.k);
        goto L45
    L33:
        if (this.b == null) goto L35;
        r5 = (this.c + this.e) + this.v;
        goto L36
    L10:
        if (this.f == true) goto L12;
    L14:
        int r17 = 0;
    L15:
        String r18 = this.a;
        StaticLayout r20 = StaticLayout.Builder.obtain(r18, 0, r18.length(), this.p, r13 - r17).setLineSpacing(0.0f, this.k).setIncludePad(false).build();
        if (r20.getLineCount() <= 0) goto L18;
        int r21 = r20.getLineEnd(0);
    L19:
        this.s = this.a.substring(0, r21);
        if (r21 >= this.a.length()) goto L22;
        r4 = this.a.substring(r21);
    L22:
        this.t = r4;
        this.v = this.p.measureText(this.s);
        if (this.t.length() > 0) goto L26;
        r1 = false;
    L26:
        if (r1 == false) goto L28;
        String r22 = this.t;
        StaticLayout r23 = StaticLayout.Builder.obtain(r22, 0, r22.length(), this.p, r13).setLineSpacing(0.0f, this.k).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).build();
    L29:
        this.q = r23;
        goto L31
    L28:
        r23 = null;
        goto L29
    L18:
        r21 = 0;
        goto L19
    L12:
        if (this.b == null) goto L14;
        r17 = this.c + this.e;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    public DoraQueryTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "";
        this.e = c7.b(3);
        this.f = true;
        this.g = 400;
        this.h = -16777216;
        this.i = c7.c(17);
        this.j = Typeface.create("PingFang SC", 0);
        this.k = 1.2f;
        this.p = new TextPaint(1);
        this.r = new Rect();
        this.s = "";
        this.t = "";
        a();
    }

    public /* synthetic */ DoraQueryTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        this.l = r1;
        this.m = r2;
        this.n = r3;
        this.o = r4;
        invalidate();
        requestLayout();
    }
}
