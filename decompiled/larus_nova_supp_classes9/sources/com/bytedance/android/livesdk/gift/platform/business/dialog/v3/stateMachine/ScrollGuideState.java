package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideState;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", "component1", "Lcom/bytedance/android/livesdk/gift/model/o2;", "component2", BuildConfig.FLAVOR, "component3", "()Ljava/lang/Long;", "status", "scrollGuideInfo", "endTime", "copy", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;Lcom/bytedance/android/livesdk/gift/model/o2;Ljava/lang/Long;)Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideState;", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", "other", BuildConfig.FLAVOR, "equals", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", "getStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", "Lcom/bytedance/android/livesdk/gift/model/o2;", "getScrollGuideInfo", "()Lcom/bytedance/android/livesdk/gift/model/o2;", "Ljava/lang/Long;", "getEndTime", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;Lcom/bytedance/android/livesdk/gift/model/o2;Ljava/lang/Long;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollGuideState {
    private final Long endTime;
    private final o2 scrollGuideInfo;
    private final ScrollGuideStatus status;

    public ScrollGuideState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ScrollGuideState copy$default(ScrollGuideState r0, ScrollGuideStatus r1, o2 r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.scrollGuideInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.endTime;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ScrollGuideStatus component1() {
        return this.status;
    }

    public final o2 component2() {
        return this.scrollGuideInfo;
    }

    public final Long component3() {
        return this.endTime;
    }

    public final ScrollGuideState copy(ScrollGuideStatus r2, o2 r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        return new ScrollGuideState(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScrollGuideState) == false) goto L12;
        ScrollGuideState r4 = (ScrollGuideState) r3;
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scrollGuideInfo, r4.scrollGuideInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.endTime, r4.endTime) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        ScrollGuideStatus r0 = this.status;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        o2 r4 = this.scrollGuideInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.endTime;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ScrollGuideState(status=" + this.status + ", scrollGuideInfo=" + this.scrollGuideInfo + ", endTime=" + this.endTime + ")";
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final o2 getScrollGuideInfo() {
        return this.scrollGuideInfo;
    }

    public final ScrollGuideStatus getStatus() {
        return this.status;
    }

    public ScrollGuideState(ScrollGuideStatus r2, o2 r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.status = r2;
        this.scrollGuideInfo = r3;
        this.endTime = r4;
    }

    public /* synthetic */ ScrollGuideState(ScrollGuideStatus r2, o2 r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = ScrollGuideStatus.IDLE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
