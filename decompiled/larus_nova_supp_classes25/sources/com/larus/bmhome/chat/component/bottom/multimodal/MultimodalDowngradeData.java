package com.larus.bmhome.chat.component.bottom.multimodal;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "", "fileDowngrade", "", "videoDowngrade", "uploadRetryTimeout", "uploadRetryCount", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFileDowngrade", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoDowngrade", "getUploadRetryTimeout", "getUploadRetryCount", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MultimodalDowngradeData {

    @SerializedName("file_dg")
    private final Integer fileDowngrade;

    @SerializedName("up_retry_cnt")
    private final Integer uploadRetryCount;

    @SerializedName("up_retry_tmo")
    private final Integer uploadRetryTimeout;

    @SerializedName("video_dg")
    private final Integer videoDowngrade;

    public MultimodalDowngradeData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MultimodalDowngradeData copy$default(MultimodalDowngradeData r0, Integer r1, Integer r2, Integer r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.fileDowngrade;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.videoDowngrade;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.uploadRetryTimeout;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.uploadRetryCount;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.fileDowngrade;
    }

    public final Integer component2() {
        return this.videoDowngrade;
    }

    public final Integer component3() {
        return this.uploadRetryTimeout;
    }

    public final Integer component4() {
        return this.uploadRetryCount;
    }

    public final MultimodalDowngradeData copy(Integer r2, Integer r3, Integer r4, Integer r5) {
        return new MultimodalDowngradeData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultimodalDowngradeData) == true) goto L8;
        return false;
    L8:
        MultimodalDowngradeData r6 = (MultimodalDowngradeData) r5;
        if (Intrinsics.areEqual(this.fileDowngrade, r6.fileDowngrade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoDowngrade, r6.videoDowngrade) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadRetryTimeout, r6.uploadRetryTimeout) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadRetryCount, r6.uploadRetryCount) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.fileDowngrade;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.videoDowngrade;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.uploadRetryTimeout;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.uploadRetryCount;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MultimodalDowngradeData(fileDowngrade=" + this.fileDowngrade + ", videoDowngrade=" + this.videoDowngrade + ", uploadRetryTimeout=" + this.uploadRetryTimeout + ", uploadRetryCount=" + this.uploadRetryCount + ')';
    }

    public final Integer getFileDowngrade() {
        return this.fileDowngrade;
    }

    public final Integer getUploadRetryCount() {
        return this.uploadRetryCount;
    }

    public final Integer getUploadRetryTimeout() {
        return this.uploadRetryTimeout;
    }

    public final Integer getVideoDowngrade() {
        return this.videoDowngrade;
    }

    public MultimodalDowngradeData(Integer r1, Integer r2, Integer r3, Integer r4) {
        this.fileDowngrade = r1;
        this.videoDowngrade = r2;
        this.uploadRetryTimeout = r3;
        this.uploadRetryCount = r4;
    }

    public /* synthetic */ MultimodalDowngradeData(Integer r2, Integer r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = -1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = -1;
    L14:
        this(r2, r3, r4, r5);
    }
}
