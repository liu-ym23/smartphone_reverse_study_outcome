package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GiftMVIVerticalListView$addManualOnPageChangeListener$1$onPageSelected$1 extends MutablePropertyReference0Impl {
    public GiftMVIVerticalListView$addManualOnPageChangeListener$1$onPageSelected$1(GiftMVIVerticalListView r7) {
        super(r7, GiftMVIVerticalListView.class, "lazyPagerAdapter", "getLazyPagerAdapter()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/LazyMVIViewPagerAdapter;", 0);
    }

    public Object get() {
        return GiftMVIVerticalListView.s((GiftMVIVerticalListView) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r3 = (LazyMVIViewPagerAdapter) r2;
        ((GiftMVIVerticalListView) ((CallableReference) this).receiver).p = r3;
    }
}
