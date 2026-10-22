package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00013B9\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b/\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\nHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003JN\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0014\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R$\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010,R\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b-\u0010%R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b.\u0010\"¨\u00064"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "component1", "", "component2", "", "component3", "component4", "()Ljava/lang/Long;", "component5", "component6", "id", "taskId", "triggerTime", "realActionTime", "sourceFrom", "taskStatus", "copy", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "I", "getId", "()I", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "J", "getTriggerTime", "()J", "Ljava/lang/Long;", "getRealActionTime", "setRealActionTime", "(Ljava/lang/Long;)V", "getSourceFrom", "getTaskStatus", "<init>", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskRecord implements Parcelable {
    public static final a CREATOR = null;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    private final int id;
    private Long realActionTime;
    private final String sourceFrom;
    private final String taskId;
    private final int taskStatus;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<TimerTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskRecord createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new TimerTaskRecord(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskRecord[] newArray(int r1) {
            return new TimerTaskRecord[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimerTaskRecord(int r2, String r3, long r4, Long r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r7, "sourceFrom");
        this.id = r2;
        this.taskId = r3;
        this.triggerTime = r4;
        this.realActionTime = r6;
        this.sourceFrom = r7;
        this.taskStatus = r8;
    }

    public TimerTaskRecord(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(r10.readInt(), String.valueOf(r10.readInt()), r10.readLong(), Long.valueOf(r10.readLong()), TimerTaskKt.a(r10), r10.readInt());
        Long r11 = this.realActionTime;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.longValue() != (-1)) goto L9;
        this.realActionTime = null;
        return;
    }

    public static /* synthetic */ TimerTaskRecord copy$default(TimerTaskRecord r5, int r6, String r7, long r8, Long r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.taskId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.triggerTime;
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.realActionTime;
    L14:
        Long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.sourceFrom;
    L17:
        String r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.taskStatus;
    L20:
        int r9 = r6;
        return r5.copy(r9, r15, r0, r2, r3, r12);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final Long component4() {
        return this.realActionTime;
    }

    public final String component5() {
        return this.sourceFrom;
    }

    public final int component6() {
        return this.taskStatus;
    }

    public final TimerTaskRecord copy(int r10, String r11, long r12, Long r14, String r15, int r16) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r15, "sourceFrom");
        return new TimerTaskRecord(r10, r11, r12, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TimerTaskRecord) == true) goto L8;
        return false;
    L8:
        TimerTaskRecord r9 = (TimerTaskRecord) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r9.triggerTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.realActionTime, r9.realActionTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceFrom, r9.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (this.taskStatus == r9.taskStatus) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getId() {
        return this.id;
    }

    public final Long getRealActionTime() {
        return this.realActionTime;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r0 = ((this.id * 31) + this.taskId.hashCode()) * 31;
        long r1 = this.triggerTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.realActionTime;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((((r2 + r4) * 31) + this.sourceFrom.hashCode()) * 31) + this.taskStatus;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final void setRealActionTime(Long r1) {
        this.realActionTime = r1;
    }

    public String toString() {
        return "TimerTaskRecord(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", realActionTime=" + this.realActionTime + ", sourceFrom=" + this.sourceFrom + ", taskStatus=" + this.taskStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.id);
        Integer r5 = StringsKt.toIntOrNull(this.taskId);
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        r3.writeInt(r6);
        r3.writeLong(this.triggerTime);
        Long r7 = this.realActionTime;
        if (r7 == null) goto L9;
        long r0 = r7.longValue();
    L10:
        r3.writeLong(r0);
        r3.writeString(this.sourceFrom);
        r3.writeInt(this.taskStatus);
        return;
    L9:
        r0 = -1;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
