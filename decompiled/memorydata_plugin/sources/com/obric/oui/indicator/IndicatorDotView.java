package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.style.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006-"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/IndicatorIcon;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgRectF", "Landroid/graphics/RectF;", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", EventBody.KEY_VALUE, "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "dotPaint", "Landroid/graphics/Paint;", "strokeColor", "getStrokeColor", "setStrokeColor", "strokePaint", "strokeRectF", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setEndMargin", "margin", "setHorizontalMargin", "horizontalMargin", "setStartMargin", "setWidth", "width", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorDotView extends View implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f13928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f13929b;
    private final Paint c;
    private final Paint d;
    private int e;
    private int f;
    private float g;
    private float h;

    public IndicatorDotView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public IndicatorDotView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public IndicatorDotView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f13928a = new RectF();
        this.f13929b = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.FILL);
        this.c = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.STROKE);
        this.d = r9;
        this.e = -7829368;
    }

    public /* synthetic */ IndicatorDotView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public float getCornerRadius() {
        return this.h;
    }

    public int getDotColor() {
        return this.e;
    }

    public int getStrokeColor() {
        return this.f;
    }

    public float getStrokeWidth() {
        return this.g;
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        this.f13928a.set(0.0f, 0.0f, getWidth(), getHeight());
        m.a(r8, this.f13928a, getCornerRadius(), this.c);
        if (getStrokeWidth() <= 0.0f) goto L6;
        float r2 = 2;
        this.f13929b.set(getStrokeWidth() / r2, getStrokeWidth() / r2, getWidth() - (getStrokeWidth() / r2), getHeight() - (getStrokeWidth() / r2));
        m.a(r8, this.f13929b, getCornerRadius(), this.d);
        return;
    }

    @Override // com.obric.oui.indicator.b
    public void setCornerRadius(float r1) {
        this.h = r1;
    }

    @Override // com.obric.oui.indicator.b
    public void setDotColor(int r2) {
        if (this.e == r2) goto L5;
        this.e = r2;
    L5:
        this.c.setColor(r2);
    }

    public void setEndMargin(int r5) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginEnd(r5);
        requestLayout();
        r3 = r1;
    L9:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void setHorizontalMargin(int r3) {
        a.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public void setStartMargin(int r5) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r5);
        requestLayout();
        r3 = r1;
    L9:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.b
    public void setStrokeColor(int r2) {
        if (this.f == r2) goto L5;
        this.f = r2;
    L5:
        this.d.setColor(r2);
    }

    @Override // com.obric.oui.indicator.b
    public void setStrokeWidth(float r2) {
        if (this.g != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        this.g = r2;
    L8:
        this.d.setStrokeWidth(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setWidth(int r3) {
        a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }
}
