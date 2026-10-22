package com.bytedance.als.ui.group;

import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class UIGroupLogicComponent$show$1 extends MutablePropertyReference0Impl {
    public UIGroupLogicComponent$show$1(UIGroupLogicComponent r10) {
        super(r10, UIGroupLogicComponent.class, "childContainerGroupScene", "getChildContainerGroupScene()Lcom/bytedance/scene/group/GroupScene;", 0);
    }

    public Object get() {
        GroupScene r0 = ((UIGroupLogicComponent) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childContainerGroupScene");
    L5:
        return r0;
    }

    public void set(Object r10) {
        UIGroupLogicComponent r0 = (UIGroupLogicComponent) ((CallableReference) this).receiver;
        GroupScene r11 = (GroupScene) r10;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.c = r11;
    }
}
