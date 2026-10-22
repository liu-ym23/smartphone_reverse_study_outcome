package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003JL\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0006H\u0016J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\bHÖ\u0001J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "taskId", "", "triggerTime", "", "realActionTime", "sourceFrom", "taskStatus", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)V", "getId", "()I", "getRealActionTime", "()Ljava/lang/Long;", "setRealActionTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSourceFrom", "()Ljava/lang/String;", "getTaskId", "getTaskStatus", "getTriggerTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "()V", "INVALID_INT_VALUE", "", "INVALID_LONG_VALUE", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TimerTaskRecord> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public TimerTaskRecord a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new TimerTaskRecord(r1);
        }

        public TimerTaskRecord[] a(int r1) {
            return new TimerTaskRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimerTaskRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimerTaskRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
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
        this(r10.readInt(), String.valueOf(r10.readInt()), r10.readLong(), Long.valueOf(r10.readLong()), j.a(r10), r10.readInt());
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

    public final TimerTaskRecord copy(int r9, String r10, long r11, Long r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r14, "sourceFrom");
        return new TimerTaskRecord(r9, r10, r11, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerTaskRecord.class) == true) goto L8;
        return false;
    L8:
        TimerTaskRecord r10 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r9, TimerTaskRecord.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r10.triggerTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.realActionTime, r10.realActionTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceFrom, r10.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (this.taskStatus == r10.taskStatus) goto L26;
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
        int r0 = ((((Integer.hashCode(this.id) * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.triggerTime)) * 31;
        Long r1 = this.realActionTime;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.sourceFrom.hashCode()) * 31) + Integer.hashCode(this.taskStatus);
    L5:
        r2 = r1.hashCode();
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
