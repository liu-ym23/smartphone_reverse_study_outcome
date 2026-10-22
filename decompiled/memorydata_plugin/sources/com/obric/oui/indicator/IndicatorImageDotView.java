package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000fH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r¨\u0006&"}, d2 = {"Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/indicator/IndicatorIcon;", "context", "Landroid/content/Context;", "initialDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", EventBody.KEY_VALUE, "", "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "setDotTintList", "", "tint", "Landroid/content/res/ColorStateList;", "setEndMargin", "margin", "setHorizontalMargin", "horizontalMargin", "setStartMargin", "setWidth", "width", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorImageDotView extends AppCompatImageView implements b {
    private float cornerRadius;
    private int dotColor;
    private int strokeColor;
    private float strokeWidth;

    public IndicatorImageDotView(Context r3, Drawable r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.dotColor = -7829368;
        setImageDrawable(r4);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public int getDotColor() {
        return this.dotColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.obric.oui.indicator.b
    public void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    @Override // com.obric.oui.indicator.b
    public void setDotColor(int r2) {
        this.dotColor = r2;
        if (getImageTintList() != null) goto L6;
        setColorFilter(r2);
        return;
    }

    public final void setDotTintList(ColorStateList r1) {
        setImageTintList(r1);
        if (r1 == null) goto L5;
        clearColorFilter();
        return;
    L5:
        setColorFilter(getDotColor());
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
        a.b((View) ZeusTransformUtils.preCheckCast((AppCompatImageView) ZeusTransformUtils.preCheckCast(this, AppCompatImageView.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin"), r3);
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
    public void setStrokeColor(int r1) {
        this.strokeColor = r1;
    }

    @Override // com.obric.oui.indicator.b
    public void setStrokeWidth(float r1) {
        this.strokeWidth = r1;
    }

    public void setWidth(int r3) {
        a.a((View) ZeusTransformUtils.preCheckCast((AppCompatImageView) ZeusTransformUtils.preCheckCast(this, AppCompatImageView.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin"), r3);
    }
}
