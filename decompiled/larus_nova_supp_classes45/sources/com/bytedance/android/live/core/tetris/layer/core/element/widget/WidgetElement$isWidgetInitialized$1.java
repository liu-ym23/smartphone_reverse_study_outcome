package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WidgetElement$isWidgetInitialized$1 extends MutablePropertyReference0Impl {
    public WidgetElement$isWidgetInitialized$1(WidgetElement r7) {
        super(r7, WidgetElement.class, "widget", "getWidget$tetris_saasRelease()Lcom/bytedance/ies/sdk/widgets/Widget;", 0);
    }

    public Object get() {
        Widget r0 = ((WidgetElement) ((CallableReference) this).receiver).m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r0;
    }

    public void set(Object r3) {
        WidgetElement r0 = (WidgetElement) ((CallableReference) this).receiver;
        Widget r4 = (Widget) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.m = r4;
    }
}
