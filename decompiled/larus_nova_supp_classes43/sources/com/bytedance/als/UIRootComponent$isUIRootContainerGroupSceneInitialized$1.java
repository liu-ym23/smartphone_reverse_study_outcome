package com.bytedance.als;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class UIRootComponent$isUIRootContainerGroupSceneInitialized$1 extends MutablePropertyReference0Impl {
    public UIRootComponent$isUIRootContainerGroupSceneInitialized$1(UIRootComponent r10) {
        super(r10, UIRootComponent.class, "scene", "getScene()Lcom/bytedance/als/UIRootContainerGroupScene;", 0);
    }

    public Object get() {
        UIRootContainerGroupScene r0 = ((UIRootComponent) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
    L5:
        return r0;
    }

    public void set(Object r10) {
        UIRootComponent r0 = (UIRootComponent) ((CallableReference) this).receiver;
        UIRootContainerGroupScene r11 = (UIRootContainerGroupScene) r10;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.c = r11;
    }
}
