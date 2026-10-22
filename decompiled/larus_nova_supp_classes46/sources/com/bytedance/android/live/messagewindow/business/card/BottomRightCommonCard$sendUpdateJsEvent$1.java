package com.bytedance.android.live.messagewindow.business.card;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BottomRightCommonCard$sendUpdateJsEvent$1 extends MutablePropertyReference0Impl {
    public BottomRightCommonCard$sendUpdateJsEvent$1(BottomRightCommonCard r7) {
        super(r7, BottomRightCommonCard.class, "presenter", "getPresenter()Lcom/bytedance/android/live/messagewindow/business/presenter/BottomRightCommonCardPresenter;", 0);
    }

    public Object get() {
        com.bytedance.android.live.messagewindow.business.presenter.b r0 = ((BottomRightCommonCard) ((CallableReference) this).receiver).x;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        return r0;
    }

    public void set(Object r2) {
        com.bytedance.android.live.messagewindow.business.presenter.b r3 = (com.bytedance.android.live.messagewindow.business.presenter.b) r2;
        ((BottomRightCommonCard) ((CallableReference) this).receiver).x = r3;
    }
}
