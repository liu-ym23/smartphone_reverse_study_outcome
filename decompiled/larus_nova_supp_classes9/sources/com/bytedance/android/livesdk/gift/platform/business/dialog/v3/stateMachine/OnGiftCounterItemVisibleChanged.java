package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@TraceExclude
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftCounterItemVisibleChanged;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", BuildConfig.FLAVOR, "counterRangeMap", BuildConfig.FLAVOR, "Lkotlin/ranges/IntRange;", "(ILjava/util/Map;)V", "getCounterRangeMap", "()Ljava/util/Map;", "getPagerPosition", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftCounterItemVisibleChanged extends GiftUIAction {
    private final Map<Integer, IntRange> counterRangeMap;
    private final int pagerPosition;

    public final Map<Integer, IntRange> getCounterRangeMap() {
        return this.counterRangeMap;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public OnGiftCounterItemVisibleChanged(int r5, Map<Integer, IntRange> r6) {
        Intrinsics.checkNotNullParameter(r6, "counterRangeMap");
        super(false, "OnGiftCounterItemVisibleChanged", 1, null);
        this.pagerPosition = r5;
        this.counterRangeMap = r6;
    }
}
