package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicator extends b<LinearProgressIndicatorSpec> {
    public static final int d = 0;

    static {
        d = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_LinearProgressIndicator, "style", "Widget_MaterialComponents_LinearProgressIndicator");
    }

    public LinearProgressIndicator(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public LinearProgressIndicator(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.linearProgressIndicatorStyle, "attr", "linearProgressIndicatorStyle"));
    }

    public LinearProgressIndicator(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, d);
        c();
    }

    private void c() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.google.android.material.progressindicator.b
    /* synthetic */ c a(Context r3, AttributeSet r4) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.progressindicator.b
    public void a(int r4, boolean r5) {
        if (this.f4008b != 0) goto L5;
    L9:
        super.a(r4, r5);
        return;
    L5:
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }

    LinearProgressIndicatorSpec b(Context r2, AttributeSet r3) {
        return new LinearProgressIndicatorSpec((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h;
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        LinearProgressIndicatorSpec r6 = (LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h != 1) goto L5;
    L14:
        r6.i = r7;
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r7 = false;
        goto L14
    L11:
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        int r5 = r1 - (getPaddingLeft() + getPaddingRight());
        int r6 = r2 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable r7 = getIndeterminateDrawable();
        if (r7 == null) goto L5;
        r7.setBounds(0, 0, r5, r6);
    L5:
        DeterminateDrawable r0 = getProgressDrawable();
        if (r0 == null) goto L9;
        r0.setBounds(0, 0, r5, r6);
        return;
    }

    public void setIndeterminateAnimationType(int r6) {
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g != r6) goto L6;
        return;
    L6:
        if (a() == true) goto L8;
    L12:
        ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g = r6;
        ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).c();
        if (r6 != 0) goto L15;
        IndeterminateDrawable r7 = getIndeterminateDrawable();
        g<ObjectAnimator> r0 = new i((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin"));
    L16:
        r7.setAnimatorDelegate(r0);
        invalidate();
        return;
    L15:
        r7 = getIndeterminateDrawable();
        r0 = new j((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin"));
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    @Override // com.google.android.material.progressindicator.b
    public void setIndicatorColor(int... r2) {
        super.setIndicatorColor(r2);
        ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).c();
    }

    public void setIndicatorDirection(int r6) {
        ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h = r6;
        LinearProgressIndicatorSpec r0 = (LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r6 != 1) goto L5;
    L14:
        r0.i = r1;
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r1 = false;
        goto L14
    L11:
        if (r6 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.b
    public void setTrackCornerRadius(int r3) {
        super.setTrackCornerRadius(r3);
        ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).c();
        invalidate();
    }
}
