package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.k;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends c {
    public int g;
    public int h;
    public int i;

    public CircularProgressIndicatorSpec(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.circularProgressIndicatorStyle, "attr", "circularProgressIndicatorStyle"));
    }

    public CircularProgressIndicatorSpec(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, CircularProgressIndicator.d);
    }

    public CircularProgressIndicatorSpec(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r13, r3, r11, r12);
        int r14 = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_progress_circular_size_medium, "dimen", "mtrl_progress_circular_size_medium"));
        int r0 = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_progress_circular_inset_medium, "dimen", "mtrl_progress_circular_inset_medium"));
        TypedArray r15 = k.a(r13, r3, R.styleable.CircularProgressIndicator, r11, r12, new int[0]);
        this.g = Math.max(com.google.android.material.resources.c.a(r13, r15, ZeusTransformUtils.mapRes(R.styleable.CircularProgressIndicator_indicatorSize, "styleable", "CircularProgressIndicator_indicatorSize"), r14), this.f4011a * 2);
        this.h = com.google.android.material.resources.c.a(r13, r15, ZeusTransformUtils.mapRes(R.styleable.CircularProgressIndicator_indicatorInset, "styleable", "CircularProgressIndicator_indicatorInset"), r0);
        this.i = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, "styleable", "CircularProgressIndicator_indicatorDirectionCircular"), 0);
        r15.recycle();
        c();
    }

    @Override // com.google.android.material.progressindicator.c
    void c() {
    }
}
