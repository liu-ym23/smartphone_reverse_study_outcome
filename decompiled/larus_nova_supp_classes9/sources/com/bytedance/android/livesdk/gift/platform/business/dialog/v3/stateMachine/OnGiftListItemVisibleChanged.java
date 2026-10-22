package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@TraceExclude
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftListItemVisibleChanged;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", BuildConfig.FLAVOR, "currentShowRange", "Lkotlin/ranges/IntRange;", "topicPagerPosition", "firstScroll", BuildConfig.FLAVOR, "(ILkotlin/ranges/IntRange;IZ)V", "getCurrentShowRange", "()Lkotlin/ranges/IntRange;", "getFirstScroll", "()Z", "getPagerPosition", "()I", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftListItemVisibleChanged extends GiftUIAction {
    private final IntRange currentShowRange;
    private final boolean firstScroll;
    private final int pagerPosition;
    private final int topicPagerPosition;

    public final IntRange getCurrentShowRange() {
        return this.currentShowRange;
    }

    public final boolean getFirstScroll() {
        return this.firstScroll;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public OnGiftListItemVisibleChanged(int r5, IntRange r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "currentShowRange");
        super(false, "OnGiftListItemVisibleChanged", 1, null);
        this.pagerPosition = r5;
        this.currentShowRange = r6;
        this.topicPagerPosition = r7;
        this.firstScroll = r8;
    }

    public /* synthetic */ OnGiftListItemVisibleChanged(int r1, IntRange r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        this(r1, r2, r3, r4);
    }
}
