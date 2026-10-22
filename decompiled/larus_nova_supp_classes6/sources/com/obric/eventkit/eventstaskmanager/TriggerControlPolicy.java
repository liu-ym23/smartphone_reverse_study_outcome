package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "Landroid/os/Parcelable;", "enable", "", "minTriggerInterval", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinTriggerInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TriggerControlPolicy implements Parcelable {
    public static final Parcelable.Creator<TriggerControlPolicy> CREATOR = null;
    private final Boolean enable;
    private final Long minTriggerInterval;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerControlPolicy() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public TriggerControlPolicy(Boolean r1, Long r2) {
        this.enable = r1;
        this.minTriggerInterval = r2;
    }

    public /* synthetic */ TriggerControlPolicy(Boolean r1, Long r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Long.valueOf(600000);
    L8:
        this(r1, r2);
    }

    public static /* synthetic */ TriggerControlPolicy copy$default(TriggerControlPolicy r0, Boolean r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.minTriggerInterval;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final Long component2() {
        return this.minTriggerInterval;
    }

    public final TriggerControlPolicy copy(Boolean r2, Long r3) {
        return new TriggerControlPolicy(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TriggerControlPolicy) == true) goto L8;
        return false;
    L8:
        TriggerControlPolicy r6 = (TriggerControlPolicy) r5;
        if (Intrinsics.areEqual(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minTriggerInterval, r6.minTriggerInterval) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Long getMinTriggerInterval() {
        return this.minTriggerInterval;
    }

    public int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.minTriggerInterval;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TriggerControlPolicy(enable=" + this.enable + ", minTriggerInterval=" + this.minTriggerInterval + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        Boolean r0 = this.enable;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Long r1 = this.minTriggerInterval;
        if (r1 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeLong(r1.longValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }
}
