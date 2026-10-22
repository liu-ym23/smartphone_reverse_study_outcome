package com.bytedance.android.live.messagewindow.business.card;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class TopRightCommonCard$onDestroy$1 extends MutablePropertyReference0Impl {
    public TopRightCommonCard$onDestroy$1(e r7) {
        super(r7, e.class, "presenter", "getPresenter()Lcom/bytedance/android/live/messagewindow/business/presenter/TopRightCommonCardPresenter;", 0);
    }

    public Object get() {
        com.bytedance.android.live.messagewindow.business.presenter.e r0 = ((e) ((CallableReference) this).receiver).n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        return r0;
    }

    public void set(Object r2) {
        com.bytedance.android.live.messagewindow.business.presenter.e r3 = (com.bytedance.android.live.messagewindow.business.presenter.e) r2;
        ((e) ((CallableReference) this).receiver).n = r3;
    }
}
