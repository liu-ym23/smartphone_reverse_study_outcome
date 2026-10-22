package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdatePropExpireTime;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "intervalSecond", BuildConfig.FLAVOR, "(J)V", "getIntervalSecond", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatePropExpireTime extends GiftRepoAction {
    private final long intervalSecond;

    public final long getIntervalSecond() {
        return this.intervalSecond;
    }

    public UpdatePropExpireTime(long r2) {
        super("UpdatePropExpireTime");
        this.intervalSecond = r2;
    }
}
