package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.style.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0015R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bgPaint", "Landroid/graphics/Paint;", "cornerRadius", "getCornerRadius", "setCornerRadius", "drawSelf", "", "fixedContentWidthPx", "getFixedContentWidthPx", "()Ljava/lang/Integer;", "setFixedContentWidthPx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDrawBackground", "draw", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f13930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f13931b;
    private boolean c;
    private int d;
    private Integer e;
    private int f;

    public IndicatorGroupLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public IndicatorGroupLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public IndicatorGroupLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f13930a = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.FILL);
        this.f13931b = r8;
        setBackgroundColor(0);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public final int getBgColor() {
        return this.f;
    }

    public final int getCornerRadius() {
        return this.d;
    }

    public final Integer getFixedContentWidthPx() {
        return this.e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.c == false) goto L5;
        this.f13930a.set(0.0f, 0.0f, getWidth(), getHeight());
        m.a(r5, this.f13930a, this.d * 1.0f, this.f13931b);
    L5:
        super.onDraw(r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        Integer r4 = this.e;
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.intValue();
        int r6 = LinearLayout.resolveSize((getPaddingLeft() + r5) + getPaddingRight(), r2);
        if (getMeasuredWidth() == r6) goto L9;
        setMeasuredDimension(r6, getMeasuredHeight());
        return;
    }

    public final void setBgColor(int r2) {
        if (this.f == r2) goto L5;
        this.f = r2;
    L5:
        this.f13931b.setColor(r2);
    }

    public final void setCornerRadius(int r1) {
        this.d = r1;
    }

    public final void setDrawBackground(boolean r1) {
        this.c = r1;
        invalidate();
    }

    public final void setFixedContentWidthPx(Integer r2) {
        if (Intrinsics.areEqual(this.e, r2) == true) goto L6;
        this.e = r2;
        requestLayout();
        invalidate();
        return;
    }
}
