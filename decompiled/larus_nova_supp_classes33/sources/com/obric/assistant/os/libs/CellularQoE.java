package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/os/libs/CellularQoE;", "", "slotId", "", "errBitMap", "", "timestamp", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getSlotId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrBitMap", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/assistant/os/libs/CellularQoE;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CellularQoE {

    @SerializedName("errBitMap")
    private final Long errBitMap;

    @SerializedName("slotId")
    private final Integer slotId;

    @SerializedName("timestamp")
    private final Long timestamp;

    public CellularQoE() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CellularQoE copy$default(CellularQoE r0, Integer r1, Long r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.slotId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.errBitMap;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.timestamp;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.slotId;
    }

    public final Long component2() {
        return this.errBitMap;
    }

    public final Long component3() {
        return this.timestamp;
    }

    public final CellularQoE copy(Integer r2, Long r3, Long r4) {
        return new CellularQoE(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CellularQoE) == true) goto L8;
        return false;
    L8:
        CellularQoE r6 = (CellularQoE) r5;
        if (Intrinsics.areEqual(this.slotId, r6.slotId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errBitMap, r6.errBitMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.slotId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.errBitMap;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.timestamp;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CellularQoE(slotId=" + this.slotId + ", errBitMap=" + this.errBitMap + ", timestamp=" + this.timestamp + ')';
    }

    public final Long getErrBitMap() {
        return this.errBitMap;
    }

    public final Integer getSlotId() {
        return this.slotId;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public CellularQoE(Integer r1, Long r2, Long r3) {
        this.slotId = r1;
        this.errBitMap = r2;
        this.timestamp = r3;
    }

    public /* synthetic */ CellularQoE(Integer r2, Long r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
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
