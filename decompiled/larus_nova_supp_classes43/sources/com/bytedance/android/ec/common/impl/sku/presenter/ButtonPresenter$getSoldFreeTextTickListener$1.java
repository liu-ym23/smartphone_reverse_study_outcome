package com.bytedance.android.ec.common.impl.sku.presenter;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ButtonPresenter$getSoldFreeTextTickListener$1 extends MutablePropertyReference0Impl {
    public ButtonPresenter$getSoldFreeTextTickListener$1(ButtonPresenter r10) {
        super(r10, ButtonPresenter.class, "soldFreeTextTickListener", "getSoldFreeTextTickListener()Lcom/bytedance/android/shopping/api/common/TickListener;", 0);
    }

    public Object get() {
        q83.a r0 = ((ButtonPresenter) ((CallableReference) this).receiver).h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("soldFreeTextTickListener");
    L5:
        return r0;
    }

    public void set(Object r10) {
        q83.a r11 = (q83.a) r10;
        ((ButtonPresenter) ((CallableReference) this).receiver).h = r11;
    }
}
