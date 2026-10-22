package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CustomData;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/q3;", "component1", BuildConfig.FLAVOR, "component2", "subscribeGiftPackInfo", "lockStatus", "copy", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", "other", BuildConfig.FLAVOR, "equals", "Lcom/bytedance/android/livesdk/gift/model/q3;", "getSubscribeGiftPackInfo", "()Lcom/bytedance/android/livesdk/gift/model/q3;", "J", "getLockStatus", "()J", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/q3;J)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomData {
    private final long lockStatus;
    private final q3 subscribeGiftPackInfo;

    public CustomData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ CustomData copy$default(CustomData r0, q3 r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.subscribeGiftPackInfo;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.lockStatus;
    L9:
        return r0.copy(r1, r2);
    }

    public final q3 component1() {
        return this.subscribeGiftPackInfo;
    }

    public final long component2() {
        return this.lockStatus;
    }

    public final CustomData copy(q3 r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "subscribeGiftPackInfo");
        return new CustomData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof CustomData) == false) goto L10;
        CustomData r6 = (CustomData) r5;
        if (Intrinsics.areEqual(this.subscribeGiftPackInfo, r6.subscribeGiftPackInfo) == true) goto L8;
        return false;
    L8:
        if (this.lockStatus == r6.lockStatus) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        q3 r0 = this.subscribeGiftPackInfo;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.lockStatus;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "CustomData(subscribeGiftPackInfo=" + this.subscribeGiftPackInfo + ", lockStatus=" + this.lockStatus + ")";
    }

    public final long getLockStatus() {
        return this.lockStatus;
    }

    public final q3 getSubscribeGiftPackInfo() {
        return this.subscribeGiftPackInfo;
    }

    public CustomData(q3 r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "subscribeGiftPackInfo");
        this.subscribeGiftPackInfo = r2;
        this.lockStatus = r3;
    }

    public /* synthetic */ CustomData(q3 r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = (q3) f.c(q3.class);
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = k0.UNLOCKED;
    L8:
        this(r1, r2);
    }
}
