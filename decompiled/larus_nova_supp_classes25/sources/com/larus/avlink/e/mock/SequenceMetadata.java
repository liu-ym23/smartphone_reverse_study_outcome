package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JR\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/avlink/e/mock/SequenceMetadata;", "", "mode", "", "dataSetId", "imageUUID", "recordTime", "", "callbackSequence", "", "Lcom/larus/avlink/e/mock/CallbackSequenceItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDataSetId", "getImageUUID", "getRecordTime", "()Ljava/lang/String;", "getCallbackSequence", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/larus/avlink/e/mock/SequenceMetadata;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SequenceMetadata {
    public static final int $stable = 8;

    @SerializedName("callbackSequence")
    private final List<CallbackSequenceItem> callbackSequence;

    @SerializedName("dataSetId")
    private final Integer dataSetId;

    @SerializedName("imageUUID")
    private final Integer imageUUID;

    @SerializedName("mode")
    private final Integer mode;

    @SerializedName("recordTime")
    private final String recordTime;

    public SequenceMetadata() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SequenceMetadata copy$default(SequenceMetadata r3, Integer r4, Integer r5, Integer r6, String r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.mode;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.dataSetId;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.imageUUID;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.recordTime;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.callbackSequence;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Integer component1() {
        return this.mode;
    }

    public final Integer component2() {
        return this.dataSetId;
    }

    public final Integer component3() {
        return this.imageUUID;
    }

    public final String component4() {
        return this.recordTime;
    }

    public final List<CallbackSequenceItem> component5() {
        return this.callbackSequence;
    }

    public final SequenceMetadata copy(Integer r8, Integer r9, Integer r10, String r11, List<CallbackSequenceItem> r12) {
        return new SequenceMetadata(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SequenceMetadata) == true) goto L8;
        return false;
    L8:
        SequenceMetadata r6 = (SequenceMetadata) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dataSetId, r6.dataSetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUUID, r6.imageUUID) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recordTime, r6.recordTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.callbackSequence, r6.callbackSequence) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.mode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.dataSetId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.imageUUID;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.recordTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<CallbackSequenceItem> r13 = this.callbackSequence;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "SequenceMetadata(mode=" + this.mode + ", dataSetId=" + this.dataSetId + ", imageUUID=" + this.imageUUID + ", recordTime=" + this.recordTime + ", callbackSequence=" + this.callbackSequence + ')';
    }

    public final List<CallbackSequenceItem> getCallbackSequence() {
        return this.callbackSequence;
    }

    public final Integer getDataSetId() {
        return this.dataSetId;
    }

    public final Integer getImageUUID() {
        return this.imageUUID;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final String getRecordTime() {
        return this.recordTime;
    }

    public SequenceMetadata(Integer r1, Integer r2, Integer r3, String r4, List<CallbackSequenceItem> r5) {
        this.mode = r1;
        this.dataSetId = r2;
        this.imageUUID = r3;
        this.recordTime = r4;
        this.callbackSequence = r5;
    }

    public /* synthetic */ SequenceMetadata(Integer r4, Integer r5, Integer r6, String r7, List r8, int r9, DefaultConstructorMarker r10) {
        Integer r0 = 0;
        if ((r9 & 1) == 0) goto L5;
        Integer r11 = r0;
    L7:
        if ((r9 & 2) == 0) goto L9;
        Integer r1 = r0;
    L11:
        if ((r9 & 4) != 0) goto L15;
        r0 = r6;
    L15:
        if ((r9 & 8) == 0) goto L17;
        String r2 = null;
    L19:
        if ((r9 & 16) == 0) goto L21;
        List r12 = null;
    L22:
        this(r11, r1, r0, r2, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L17:
        r2 = r7;
        goto L19
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
