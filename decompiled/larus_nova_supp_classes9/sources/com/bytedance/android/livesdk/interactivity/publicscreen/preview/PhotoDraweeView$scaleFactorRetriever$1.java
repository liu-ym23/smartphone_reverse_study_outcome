package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PhotoDraweeView$scaleFactorRetriever$1 extends MutablePropertyReference0Impl {
    public PhotoDraweeView$scaleFactorRetriever$1(PhotoDraweeView r7) {
        super(r7, PhotoDraweeView.class, "defaultGestureHandler", "getDefaultGestureHandler()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/gestures/DefaultGestureHandler;", 0);
    }

    public Object get() {
        ba2.a r0 = ((PhotoDraweeView) ((CallableReference) this).receiver).g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ba2.a r3 = (ba2.a) r2;
        ((PhotoDraweeView) ((CallableReference) this).receiver).g = r3;
    }
}
