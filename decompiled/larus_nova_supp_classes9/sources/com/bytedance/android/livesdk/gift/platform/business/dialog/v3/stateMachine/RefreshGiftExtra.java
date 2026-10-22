package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftExtra;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "giftIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "needMarketingAnim", BuildConfig.FLAVOR, "(Ljava/util/List;Z)V", "getGiftIds", "()Ljava/util/List;", "getNeedMarketingAnim", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshGiftExtra extends GiftRepoAction {

    @TraceExclude
    private final List<Long> giftIds;
    private final boolean needMarketingAnim;

    public final List<Long> getGiftIds() {
        return this.giftIds;
    }

    public final boolean getNeedMarketingAnim() {
        return this.needMarketingAnim;
    }

    public RefreshGiftExtra(List<Long> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        super("RefreshGiftExtra");
        this.giftIds = r2;
        this.needMarketingAnim = r3;
    }

    public /* synthetic */ RefreshGiftExtra(List r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }
}
