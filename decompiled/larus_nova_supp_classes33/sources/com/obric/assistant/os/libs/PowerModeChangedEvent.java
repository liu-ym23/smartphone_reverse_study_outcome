package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/os/libs/PowerModeChangedEvent;", "", "mode", "", "timestamp", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;)Lcom/obric/assistant/os/libs/PowerModeChangedEvent;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PowerModeChangedEvent {

    @SerializedName("mode")
    private final Integer mode;

    @SerializedName("timestamp")
    private final Long timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public PowerModeChangedEvent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PowerModeChangedEvent copy$default(PowerModeChangedEvent r0, Integer r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.mode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.mode;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final PowerModeChangedEvent copy(Integer r2, Long r3) {
        return new PowerModeChangedEvent(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PowerModeChangedEvent) == true) goto L8;
        return false;
    L8:
        PowerModeChangedEvent r6 = (PowerModeChangedEvent) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.mode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timestamp;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PowerModeChangedEvent(mode=" + this.mode + ", timestamp=" + this.timestamp + ')';
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public PowerModeChangedEvent(Integer r1, Long r2) {
        this.mode = r1;
        this.timestamp = r2;
    }

    public /* synthetic */ PowerModeChangedEvent(Integer r2, Long r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
