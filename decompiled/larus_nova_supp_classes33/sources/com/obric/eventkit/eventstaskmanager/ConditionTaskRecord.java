package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0016\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "", "component2", "component3", "component4", "component5", "id", "taskId", "triggerTime", "sourceFrom", WindowEvent.Params.RESULT, "copy", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getTriggerTime", "getSourceFrom", "I", "getResult", "()I", "<init>", "(JLjava/lang/String;JLjava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTaskRecord implements Parcelable {
    public static final a CREATOR = null;
    public static final int RESULT_NO_LOCATION_PERMISSION = 2;
    public static final int RESULT_SKIPPED = 3;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<ConditionTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskRecord createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            ConditionTaskRecord r1 = new ConditionTaskRecord(r6);
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
        public final ConditionTaskRecord[] newArray(int r1) {
            return new ConditionTaskRecord[r1];
        }
    }

    public ConditionTaskRecord(long r1, String r3, long r4, String r6, int r7) {
        this.id = r1;
        this.taskId = r3;
        this.triggerTime = r4;
        this.sourceFrom = r6;
        this.result = r7;
    }

    public ConditionTaskRecord(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(r10.readLong(), TimerTaskKt.a(r10), r10.readLong(), TimerTaskKt.a(r10), r10.readInt());
    }

    public static /* synthetic */ ConditionTaskRecord copy$default(ConditionTaskRecord r8, long r9, String r11, long r12, String r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.id;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.taskId;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r4 = r8.triggerTime;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r6 = r8.sourceFrom;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r7 = r8.result;
    L23:
        return r8.copy(r1, r3, r4, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final int component5() {
        return this.result;
    }

    public final ConditionTaskRecord copy(long r10, String r12, long r13, String r15, int r16) {
        return new ConditionTaskRecord(r10, r12, r13, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ConditionTaskRecord) == true) goto L8;
        return false;
    L8:
        ConditionTaskRecord r9 = (ConditionTaskRecord) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r9.triggerTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceFrom, r9.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (this.result == r9.result) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getId() {
        return this.id;
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.taskId;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        long r5 = this.triggerTime;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.sourceFrom;
        if (r7 == null) goto L11;
        r3 = r7.hashCode();
    L11:
        return ((r6 + r3) * 31) + this.result;
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskRecord(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", sourceFrom=" + this.sourceFrom + ", result=" + this.result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeLong(this.id);
        r3.writeString(this.taskId);
        r3.writeLong(this.triggerTime);
        r3.writeString(this.sourceFrom);
        r3.writeInt(this.result);
    }

    static {
        CREATOR = new a();
    }
}
