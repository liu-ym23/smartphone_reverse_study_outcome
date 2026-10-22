package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAISummaryLayoutData;", "Ljava/io/Serializable;", "meetingId", "", "timeStamp", "", "type", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAILayoutDataType;", "<init>", "(Ljava/lang/String;JLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAILayoutDataType;)V", "getMeetingId", "()Ljava/lang/String;", "getTimeStamp", "()J", "getType", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAILayoutDataType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAISummaryLayoutData implements Serializable {
    private final String meetingId;
    private final long timeStamp;
    private final MmAILayoutDataType type;

    public static /* synthetic */ MmAISummaryLayoutData copy$default(MmAISummaryLayoutData r0, String r1, long r2, MmAILayoutDataType r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.meetingId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.timeStamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.type;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.meetingId;
    }

    public final long component2() {
        return this.timeStamp;
    }

    public final MmAILayoutDataType component3() {
        return this.type;
    }

    public final MmAISummaryLayoutData copy(String r2, long r3, MmAILayoutDataType r5) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "type");
        return new MmAISummaryLayoutData(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmAISummaryLayoutData) == true) goto L8;
        return false;
    L8:
        MmAISummaryLayoutData r9 = (MmAISummaryLayoutData) r8;
        if (Intrinsics.areEqual(this.meetingId, r9.meetingId) == true) goto L12;
        return false;
    L12:
        if (this.timeStamp == r9.timeStamp) goto L15;
        return false;
    L15:
        if (this.type == r9.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.meetingId.hashCode() * 31;
        long r1 = this.timeStamp;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MmAISummaryLayoutData(meetingId=" + this.meetingId + ", timeStamp=" + this.timeStamp + ", type=" + this.type + ')';
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final MmAILayoutDataType getType() {
        return this.type;
    }

    public MmAISummaryLayoutData(String r2, long r3, MmAILayoutDataType r5) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.meetingId = r2;
        this.timeStamp = r3;
        this.type = r5;
    }
}
