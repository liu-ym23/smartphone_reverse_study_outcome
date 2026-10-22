package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionData;", "", "touchPositionsStr", "", "needShowTopDetail", "", "privilegeEntranceInfo", "Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "(Ljava/lang/String;ZLcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;)V", "getNeedShowTopDetail", "()Z", "getPrivilegeEntranceInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "getTouchPositionsStr", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchPositionData {
    private final boolean needShowTopDetail;
    private final PrivilegeEntranceInfo privilegeEntranceInfo;
    private final String touchPositionsStr;

    public TouchPositionData() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ TouchPositionData copy$default(TouchPositionData r0, String r1, boolean r2, PrivilegeEntranceInfo r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.touchPositionsStr;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.needShowTopDetail;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.privilegeEntranceInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.touchPositionsStr;
    }

    public final boolean component2() {
        return this.needShowTopDetail;
    }

    public final PrivilegeEntranceInfo component3() {
        return this.privilegeEntranceInfo;
    }

    public final TouchPositionData copy(String r2, boolean r3, PrivilegeEntranceInfo r4) {
        return new TouchPositionData(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TouchPositionData) == false) goto L12;
        TouchPositionData r4 = (TouchPositionData) r3;
        if (Intrinsics.areEqual(this.touchPositionsStr, r4.touchPositionsStr) == true) goto L8;
        return false;
    L8:
        if (this.needShowTopDetail == r4.needShowTopDetail) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.privilegeEntranceInfo, r4.privilegeEntranceInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String r0 = this.touchPositionsStr;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.needShowTopDetail;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        PrivilegeEntranceInfo r7 = this.privilegeEntranceInfo;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TouchPositionData(touchPositionsStr=" + this.touchPositionsStr + ", needShowTopDetail=" + this.needShowTopDetail + ", privilegeEntranceInfo=" + this.privilegeEntranceInfo + ")";
    }

    public final boolean getNeedShowTopDetail() {
        return this.needShowTopDetail;
    }

    public final PrivilegeEntranceInfo getPrivilegeEntranceInfo() {
        return this.privilegeEntranceInfo;
    }

    public final String getTouchPositionsStr() {
        return this.touchPositionsStr;
    }

    public TouchPositionData(String r1, boolean r2, PrivilegeEntranceInfo r3) {
        this.touchPositionsStr = r1;
        this.needShowTopDetail = r2;
        this.privilegeEntranceInfo = r3;
    }

    public /* synthetic */ TouchPositionData(String r2, boolean r3, PrivilegeEntranceInfo r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
