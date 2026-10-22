package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.circularreveal.CircularRevealFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TransformationChildLayout extends CircularRevealFrameLayout {
    public TransformationChildLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public TransformationChildLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }
}
