package com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0014J\"\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/FixedAspectRatioConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "radiusHeightRatio", "getRadiusHeightRatio", "setRadiusHeightRatio", "layoutHeight", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "initAttrs", "setupRadius", "height", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FixedAspectRatioConstraintLayout extends ConstraintLayout {
    public float a;
    public float b;
    public int c;

    public final float getAspectRatio() {
        return this.a;
    }

    public final int getLayoutHeight() {
        return this.c;
    }

    public final float getRadiusHeightRatio() {
        return this.b;
    }

    public FixedAspectRatioConstraintLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        R5(r3, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupRadius(int r3) {
        float r0 = this.b;
        if (r0 <= 0.0f) goto L6;
        w0.e(this, (int) ((r0 * r3) + 0.5f));
        return;
    }

    public final void setAspectRatio(float r1) {
        this.a = r1;
    }

    public final void setLayoutHeight(int r1) {
        this.c = r1;
    }

    public final void setRadiusHeightRatio(float r1) {
        this.b = r1;
    }

    public FixedAspectRatioConstraintLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3, 0);
    }

    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r4);
        this.c = r0;
        setupRadius(r0);
        float r1 = this.a;
        if (r1 <= 0.0f) goto L5;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) ((this.c * r1) + 0.5f), 1073741824), r4);
        return;
    L5:
        super.onMeasure(r3, r4);
    }

    public FixedAspectRatioConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3, r4);
    }

    public final void R5(Context r2, AttributeSet r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970507, 2130972152}, r4, r4);
        this.a = r5.getFloat(0, this.a);
        this.b = r5.getFloat(1, this.b);
        r5.recycle();
    }
}
