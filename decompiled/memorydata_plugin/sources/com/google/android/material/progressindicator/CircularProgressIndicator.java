package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicator extends b<CircularProgressIndicatorSpec> {
    public static final int d = 0;

    static {
        d = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_CircularProgressIndicator, "style", "Widget_MaterialComponents_CircularProgressIndicator");
    }

    public CircularProgressIndicator(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public CircularProgressIndicator(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.circularProgressIndicatorStyle, "attr", "circularProgressIndicatorStyle"));
    }

    public CircularProgressIndicator(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, d);
        c();
    }

    private void c() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.google.android.material.progressindicator.b
    /* synthetic */ c a(Context r3, AttributeSet r4) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    CircularProgressIndicatorSpec b(Context r2, AttributeSet r3) {
        return new CircularProgressIndicatorSpec((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g;
    }

    public void setIndicatorDirection(int r4) {
        ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).i = r4;
        invalidate();
    }

    public void setIndicatorInset(int r4) {
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h == r4) goto L6;
        ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h = r4;
        invalidate();
        return;
    }

    public void setIndicatorSize(int r4) {
        int r5 = Math.max(r4, getTrackThickness() * 2);
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g == r5) goto L6;
        ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g = r5;
        ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).c();
        invalidate();
        return;
    }

    @Override // com.google.android.material.progressindicator.b
    public void setTrackThickness(int r2) {
        super.setTrackThickness(r2);
        ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4008b, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).c();
    }
}
