package com.obric.oui.popover;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class OPopover$getArrowHeight$1 extends MutablePropertyReference0Impl {
    OPopover$getArrowHeight$1(OPopover r10) {
        super(r10, OPopover.class, "mOBubbleLayout", "getMOBubbleLayout()Lcom/obric/oui/popover/OPopoverLayout;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return OPopover.b((OPopover) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r10) {
        OPopover.d((OPopover) this.receiver, (OPopoverLayout) r10);
    }
}
