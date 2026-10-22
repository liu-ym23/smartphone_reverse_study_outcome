package com.ss.android.lark.myai.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/myai/view/MyAIShareActionView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textPaint", "Landroid/text/TextPaint;", "shareText", "", "shareIcon", "Landroid/graphics/drawable/Drawable;", "shareIconSize", "iconTextSpace", "expectedHeight", "horizontalPadding", "shareIconTop", "shareIconBottom", "showTextIconLeft", "showTextIconRight", "hideTextIconLeft", "hideTextIconRight", "showText", "", "textX", "", "textY", "expectedWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MyAIShareActionView extends View {
    public final TextPaint a;
    public final String b;
    public final Drawable c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public boolean k;
    public final float l;
    public final float m;
    public final int n;

    public MyAIShareActionView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MyAIShareActionView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.c.draw(r5);
        if (this.k == false) goto L6;
        r5.drawText(this.b, this.l, this.m, this.a);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        if (View.MeasureSpec.getMode(r5) != 0) goto L5;
        this.k = true;
        int r7 = this.n;
    L10:
        if (this.k == false) goto L12;
        this.c.setBounds(this.g, this.e, this.h, this.f);
    L13:
        setMeasuredDimension(r7, this.d);
        return;
    L12:
        this.c.setBounds(this.i, this.e, this.j, this.f);
        goto L13
    L5:
        int r8 = View.MeasureSpec.getSize(r5);
        int r9 = this.n;
        if (r8 < r9) goto L8;
        this.k = true;
        r7 = r9;
        goto L10
    L8:
        this.k = false;
        r7 = this.d;
        goto L10
    }

    public MyAIShareActionView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        TextPaint r12 = new TextPaint(1);
        this.a = r12;
        String r0 = r9.getString(2131892929);
        this.b = r0;
        this.c = UDIconUtils.getIconDrawable(r9, 2131254801, UDColorUtils.getColor(r9, 2131102419));
        int r1 = b.g(r9, 18);
        int r3 = b.g(r9, 2);
        int r4 = b.g(r9, 24);
        this.d = r4;
        int r5 = b.g(r9, 4);
        int r6 = (r4 - r1) / 2;
        this.e = r6;
        this.f = r6 + r1;
        this.g = r5;
        int r7 = r5 + r1;
        this.h = r7;
        int r8 = b.g(r9, 3);
        this.i = r8;
        this.j = r8 + r1;
        this.k = true;
        this.l = r7 + r3;
        r12.setColor(UDColorUtils.getColor(r9, 2131106607));
        r12.setTextSize(b.g(r9, 14));
        this.n = ((MathKt.roundToInt(r12.measureText(r0)) + (r5 * 2)) + r1) + r3;
        Paint.FontMetrics r13 = r12.getFontMetrics();
        float r14 = r13.bottom;
        this.m = ((r4 / 2) + ((r14 - r13.top) / 2)) - r14;
    }

    public /* synthetic */ MyAIShareActionView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
