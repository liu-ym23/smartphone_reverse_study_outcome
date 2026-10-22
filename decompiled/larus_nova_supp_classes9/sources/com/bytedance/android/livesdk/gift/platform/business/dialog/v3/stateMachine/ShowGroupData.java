package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J/\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowGroupData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "component1", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h0;", "component2", BuildConfig.FLAVOR, "component3", "canShow", "giftGroupList", "giftId", "copy", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "hashCode", "other", "equals", "Z", "getCanShow", "()Z", "Ljava/util/List;", "getGiftGroupList", "()Ljava/util/List;", "J", "getGiftId", "()J", "<init>", "(ZLjava/util/List;J)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowGroupData {
    private final boolean canShow;
    private final List<h0> giftGroupList;
    private final long giftId;

    public ShowGroupData() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowGroupData copy$default(ShowGroupData r0, boolean r1, List r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.canShow;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.giftGroupList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.giftId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final List<h0> component2() {
        return this.giftGroupList;
    }

    public final long component3() {
        return this.giftId;
    }

    public final ShowGroupData copy(boolean r2, List<? extends h0> r3, long r4) {
        return new ShowGroupData(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof ShowGroupData) == false) goto L12;
        ShowGroupData r6 = (ShowGroupData) r5;
        if (this.canShow == r6.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.giftGroupList, r6.giftGroupList) == true) goto L10;
        return false;
    L10:
        if (this.giftId == r6.giftId) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.canShow;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<h0> r3 = this.giftGroupList;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L9:
        int r5 = (r2 + r4) * 31;
        long r6 = this.giftId;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L8:
        r4 = 0;
        goto L9
    }

    public String toString() {
        return "ShowGroupData(canShow=" + this.canShow + ", giftGroupList=" + this.giftGroupList + ", giftId=" + this.giftId + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final List<h0> getGiftGroupList() {
        return this.giftGroupList;
    }

    public final long getGiftId() {
        return this.giftId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShowGroupData(boolean r1, List<? extends h0> r2, long r3) {
        this.canShow = r1;
        this.giftGroupList = r2;
        this.giftId = r3;
    }

    public /* synthetic */ ShowGroupData(boolean r1, List r2, long r3, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r3 = 0;
    L11:
        this(r1, r2, r3);
    }
}
