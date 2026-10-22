package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeGiftMostlyUsedStatus;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "giftId", BuildConfig.FLAVOR, "pageType", BuildConfig.FLAVOR, "operateAction", "(JII)V", "getGiftId", "()J", "getOperateAction", "()I", "getPageType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChangeGiftMostlyUsedStatus extends GiftUIAction {
    private final long giftId;
    private final int operateAction;
    private final int pageType;

    public final long getGiftId() {
        return this.giftId;
    }

    public final int getOperateAction() {
        return this.operateAction;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public ChangeGiftMostlyUsedStatus(long r5, int r7, @MostlyUsedGiftOperateAction int r8) {
        super(false, "ChangeGiftMostlyUsedStatus", 1, null);
        this.giftId = r5;
        this.pageType = r7;
        this.operateAction = r8;
    }
}
