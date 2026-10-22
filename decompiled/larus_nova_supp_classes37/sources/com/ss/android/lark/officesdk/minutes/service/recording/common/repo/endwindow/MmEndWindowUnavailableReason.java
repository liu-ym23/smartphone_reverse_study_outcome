package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "Ljava/io/Serializable;", "reasonCode", "", "windowLimitType", "", "<init>", "(ILjava/lang/String;)V", "getReasonCode", "()I", "getWindowLimitType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowUnavailableReason implements Serializable {
    private final int reasonCode;
    private final String windowLimitType;

    public MmEndWindowUnavailableReason() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ MmEndWindowUnavailableReason copy$default(MmEndWindowUnavailableReason r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.reasonCode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.windowLimitType;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.reasonCode;
    }

    public final String component2() {
        return this.windowLimitType;
    }

    public final MmEndWindowUnavailableReason copy(int r2, String r3) {
        return new MmEndWindowUnavailableReason(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmEndWindowUnavailableReason) == true) goto L8;
        return false;
    L8:
        MmEndWindowUnavailableReason r6 = (MmEndWindowUnavailableReason) r5;
        if (this.reasonCode == r6.reasonCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitType, r6.windowLimitType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.reasonCode * 31;
        String r1 = this.windowLimitType;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MmEndWindowUnavailableReason(reasonCode=" + this.reasonCode + ", windowLimitType=" + this.windowLimitType + ')';
    }

    public final int getReasonCode() {
        return this.reasonCode;
    }

    public final String getWindowLimitType() {
        return this.windowLimitType;
    }

    public MmEndWindowUnavailableReason(int r1, String r2) {
        this.reasonCode = r1;
        this.windowLimitType = r2;
    }

    public /* synthetic */ MmEndWindowUnavailableReason(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
