package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003JL\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "", "sequence", "", "timestamp", "", "callbackType", "", "params", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;)V", "getSequence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallbackType", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CameraCallbackRecord {
    public static final int $stable = 8;

    @SerializedName("callbackType")
    private final String callbackType;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("sequence")
    private final Integer sequence;

    @SerializedName("timestamp")
    private final Long timestamp;

    public CameraCallbackRecord() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraCallbackRecord copy$default(CameraCallbackRecord r0, Integer r1, Long r2, String r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.sequence;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.callbackType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.params;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.sequence;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.callbackType;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final CameraCallbackRecord copy(Integer r2, Long r3, String r4, Map<String, ? extends Object> r5) {
        return new CameraCallbackRecord(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraCallbackRecord) == true) goto L8;
        return false;
    L8:
        CameraCallbackRecord r6 = (CameraCallbackRecord) r5;
        if (Intrinsics.areEqual(this.sequence, r6.sequence) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbackType, r6.callbackType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.sequence;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.callbackType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.params;
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
        return "CameraCallbackRecord(sequence=" + this.sequence + ", timestamp=" + this.timestamp + ", callbackType=" + this.callbackType + ", params=" + this.params + ')';
    }

    public final String getCallbackType() {
        return this.callbackType;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Integer getSequence() {
        return this.sequence;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public CameraCallbackRecord(Integer r1, Long r2, String r3, Map<String, ? extends Object> r4) {
        this.sequence = r1;
        this.timestamp = r2;
        this.callbackType = r3;
        this.params = r4;
    }

    public /* synthetic */ CameraCallbackRecord(Integer r3, Long r4, String r5, Map r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0L;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = MapsKt.emptyMap();
    L14:
        this(r3, r4, r5, r6);
    }
}
