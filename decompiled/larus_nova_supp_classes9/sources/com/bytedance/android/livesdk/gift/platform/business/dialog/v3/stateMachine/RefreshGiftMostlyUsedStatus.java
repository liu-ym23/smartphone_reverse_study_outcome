package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftMostlyUsedStatus;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "giftId", BuildConfig.FLAVOR, "operateAction", BuildConfig.FLAVOR, "originPageType", "success", BuildConfig.FLAVOR, "(JIIZ)V", "getGiftId", "()J", "getOperateAction", "()I", "getOriginPageType", "getSuccess", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshGiftMostlyUsedStatus extends GiftRepoAction {
    private final long giftId;
    private final int operateAction;
    private final int originPageType;
    private final boolean success;

    public final long getGiftId() {
        return this.giftId;
    }

    public final int getOperateAction() {
        return this.operateAction;
    }

    public final int getOriginPageType() {
        return this.originPageType;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public RefreshGiftMostlyUsedStatus(long r2, @MostlyUsedGiftOperateAction int r4, int r5, boolean r6) {
        super("RefreshGiftMostlyUsedStatus");
        this.giftId = r2;
        this.operateAction = r4;
        this.originPageType = r5;
        this.success = r6;
    }

    public /* synthetic */ RefreshGiftMostlyUsedStatus(long r7, int r9, int r10, boolean r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = true;
    L6:
        this(r7, r9, r10, r5);
        return;
    L5:
        r5 = r11;
        goto L6
    }
}
