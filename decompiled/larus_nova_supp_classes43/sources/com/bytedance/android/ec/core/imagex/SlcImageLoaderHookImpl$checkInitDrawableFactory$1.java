package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.drawable.DrawableFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SlcImageLoaderHookImpl$checkInitDrawableFactory$1 extends MutablePropertyReference0Impl {
    public SlcImageLoaderHookImpl$checkInitDrawableFactory$1(SlcImageLoaderHookImpl r10) {
        super(r10, SlcImageLoaderHookImpl.class, "defaultDrawableFactory", "getDefaultDrawableFactory()Lcom/facebook/imagepipeline/drawable/DrawableFactory;", 0);
    }

    public Object get() {
        SlcImageLoaderHookImpl r0 = (SlcImageLoaderHookImpl) ((CallableReference) this).receiver;
        DrawableFactory r1 = SlcImageLoaderHookImpl.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultDrawableFactory");
    L5:
        return r1;
    }

    public void set(Object r10) {
        SlcImageLoaderHookImpl r0 = (SlcImageLoaderHookImpl) ((CallableReference) this).receiver;
        SlcImageLoaderHookImpl.a = (DrawableFactory) r10;
    }
}
