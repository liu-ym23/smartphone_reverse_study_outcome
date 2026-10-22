package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\"\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\tH\u0016J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0015\u0010(\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006-"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", OaidModel.KEY_ID, "", "taskId", "", "triggerTime", "sourceFrom", "result", "", "parcel", "Landroid/os/Parcel;", "(JLjava/lang/String;JLjava/lang/String;ILandroid/os/Parcel;)V", "(JLjava/lang/String;JLjava/lang/String;I)V", "getId", "()J", "getResult", "()I", "getSourceFrom", "()Ljava/lang/String;", "getTaskId", "getTriggerTime", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "toString", "writeSubClassExtensionFieldToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutTaskRecord extends EventTaskRecord {
    public static final Parcelable.Creator<ShortcutTaskRecord> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "FIELD_VERSION", "", "RESULT_SUCCESS", "RESULT_UNKNOWN_ERROR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/ShortcutTaskRecord$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<ShortcutTaskRecord> {
        public b() {
        }

        public ShortcutTaskRecord a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            EventTaskRecord r1 = EventTaskRecord.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskRecord");
            return (ShortcutTaskRecord) ZeusTransformUtils.preCheckCast(r1, ShortcutTaskRecord.class, "com.obric.memorydata.plugin");
        }

        public ShortcutTaskRecord[] a(int r1) {
            return new ShortcutTaskRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public ShortcutTaskRecord(long r11, String r13, long r14, String r16, int r17) {
        super(3, r11, r13, r14, r16, r17);
        this.id = r11;
        this.taskId = r13;
        this.triggerTime = r14;
        this.sourceFrom = r16;
        this.result = r17;
    }

    public ShortcutTaskRecord(long r2, String r4, long r5, String r7, int r8, Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(r2, r4, r5, r7, r8);
        readExtensionFieldFromParcel$eventstaskkit_release(r9);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r9, 0);
    }

    public static /* synthetic */ ShortcutTaskRecord copy$default(ShortcutTaskRecord r7, long r8, String r10, long r11, String r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L5;
        long r0 = r7.getId();
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r2 = r7.getTaskId();
    L11:
        if ((r15 & 4) == 0) goto L13;
        long r3 = r7.getTriggerTime();
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r5 = r7.getSourceFrom();
    L19:
        if ((r15 & 16) == 0) goto L21;
        int r6 = r7.getResult();
    L23:
        return r7.copy(r0, r2, r3, r5, r6);
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public final long component1() {
        return getId();
    }

    public final String component2() {
        return getTaskId();
    }

    public final long component3() {
        return getTriggerTime();
    }

    public final String component4() {
        return getSourceFrom();
    }

    public final int component5() {
        return getResult();
    }

    public final ShortcutTaskRecord copy(long r9, String r11, long r12, String r14, int r15) {
        return new ShortcutTaskRecord(r9, r11, r12, r14, r15);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ShortcutTaskRecord.class) == true) goto L8;
        return false;
    L8:
        ShortcutTaskRecord r10 = (ShortcutTaskRecord) ZeusTransformUtils.preCheckCast(r9, ShortcutTaskRecord.class, "com.obric.memorydata.plugin");
        if (getId() == r10.getId()) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTaskId(), r10.getTaskId()) == true) goto L15;
        return false;
    L15:
        if (getTriggerTime() == r10.getTriggerTime()) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getSourceFrom(), r10.getSourceFrom()) == true) goto L21;
        return false;
    L21:
        if (getResult() == r10.getResult()) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public int getResult() {
        return this.result;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getTaskId() {
        return this.taskId;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r0 = Long.hashCode(getId()) * 31;
        int r2 = 0;
        if (getTaskId() != null) goto L5;
        int r1 = 0;
    L6:
        int r3 = (((r0 + r1) * 31) + Long.hashCode(getTriggerTime())) * 31;
        if (getSourceFrom() == null) goto L11;
        r2 = getSourceFrom().hashCode();
    L11:
        return ((r3 + r2) * 31) + Integer.hashCode(getResult());
    L5:
        r1 = getTaskId().hashCode();
        goto L6
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public String toString() {
        return "ShortcutTaskRecord(id=" + getId() + ", taskId=" + getTaskId() + ", triggerTime=" + getTriggerTime() + ", sourceFrom=" + getSourceFrom() + ", result=" + getResult() + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
