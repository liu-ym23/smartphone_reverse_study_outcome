package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimeCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "start", "", "end", "interval", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getEnd", "()Ljava/lang/String;", "getInterval", "()I", "setInterval", "(I)V", "getStart", "component1", "component2", "component3", "copy", "describeContents", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<TimeCondition> CREATOR = null;
    private final String end;
    private int interval;
    private final String start;

    public static final class a implements Parcelable.Creator<TimeCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimeCondition createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            TimeCondition r1 = new TimeCondition(r6.readString(), r6.readString(), r6.readInt());
            int r2 = Math.min(r0, 0);
            ClassLoader r3 = a.class.getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L5;
            r4 = r4 + 1;
        L5:
            if (r4 > r0) goto L7;
            joa.a.d(r6, r3);
            r4 = r4 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final TimeCondition[] newArray(int r1) {
            return new TimeCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimeCondition(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "start");
        this.start = r2;
        this.end = r3;
        this.interval = r4;
    }

    public /* synthetic */ TimeCondition(String r1, String r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ TimeCondition copy$default(TimeCondition r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.start;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.end;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.interval;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.start;
    }

    public final String component2() {
        return this.end;
    }

    public final int component3() {
        return this.interval;
    }

    public final TimeCondition copy(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "start");
        return new TimeCondition(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimeCondition) == true) goto L8;
        return false;
    L8:
        TimeCondition r6 = (TimeCondition) r5;
        if (Intrinsics.areEqual(this.start, r6.start) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end, r6.end) == true) goto L15;
        return false;
    L15:
        if (this.interval == r6.interval) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getEnd() {
        return this.end;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getStart() {
        return this.start;
    }

    public int hashCode() {
        int r0 = this.start.hashCode() * 31;
        String r1 = this.end;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.interval;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setInterval(int r1) {
        this.interval = r1;
    }

    public String toString() {
        return "TimeCondition(start=" + this.start + ", end=" + this.end + ", interval=" + this.interval + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.start);
        r1.writeString(this.end);
        r1.writeInt(this.interval);
    }
}
