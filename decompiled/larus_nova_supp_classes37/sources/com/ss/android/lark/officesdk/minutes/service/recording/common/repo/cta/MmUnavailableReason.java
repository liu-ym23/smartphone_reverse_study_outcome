package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "Ljava/io/Serializable;", "reasonCode", "", "windowLimitType", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getReasonCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWindowLimitType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmUnavailableReason implements Serializable {

    @SerializedName("reason_code")
    private final Integer reasonCode;

    @SerializedName("window_limit_type")
    private final String windowLimitType;

    /* JADX WARN: Multi-variable type inference failed */
    public MmUnavailableReason() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MmUnavailableReason copy$default(MmUnavailableReason r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.reasonCode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.windowLimitType;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.reasonCode;
    }

    public final String component2() {
        return this.windowLimitType;
    }

    public final MmUnavailableReason copy(Integer r2, String r3) {
        return new MmUnavailableReason(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmUnavailableReason) == true) goto L8;
        return false;
    L8:
        MmUnavailableReason r6 = (MmUnavailableReason) r5;
        if (Intrinsics.areEqual(this.reasonCode, r6.reasonCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitType, r6.windowLimitType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.reasonCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.windowLimitType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MmUnavailableReason(reasonCode=" + this.reasonCode + ", windowLimitType=" + this.windowLimitType + ')';
    }

    public final Integer getReasonCode() {
        return this.reasonCode;
    }

    public final String getWindowLimitType() {
        return this.windowLimitType;
    }

    public MmUnavailableReason(Integer r1, String r2) {
        this.reasonCode = r1;
        this.windowLimitType = r2;
    }

    public /* synthetic */ MmUnavailableReason(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
