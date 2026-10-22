package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00012B3\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/B=\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b.\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u0004HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\u001a\u0010\u0017\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0019\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b)\u0010%R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\u001b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "", "component1", "", "component2", "component3", "component4", "component5", "id", "taskId", "triggerTime", "sourceFrom", WindowEvent.Params.RESULT, "copy", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getTriggerTime", "getSourceFrom", "I", "getResult", "()I", "<init>", "(JLjava/lang/String;JLjava/lang/String;I)V", "(JLjava/lang/String;JLjava/lang/String;ILandroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTaskRecord extends EventTaskRecord {
    public static final Parcelable.Creator<ShortcutTaskRecord> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<ShortcutTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskRecord createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            EventTaskRecord r3 = EventTaskRecord.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskRecord");
            return (ShortcutTaskRecord) r3;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskRecord[] newArray(int r1) {
            return new ShortcutTaskRecord[r1];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
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

    public final ShortcutTaskRecord copy(long r10, String r12, long r13, String r15, int r16) {
        return new ShortcutTaskRecord(r10, r12, r13, r15, r16);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ShortcutTaskRecord) == true) goto L8;
        return false;
    L8:
        ShortcutTaskRecord r9 = (ShortcutTaskRecord) r8;
        if (getId() == r9.getId()) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTaskId(), r9.getTaskId()) == true) goto L15;
        return false;
    L15:
        if (getTriggerTime() == r9.getTriggerTime()) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getSourceFrom(), r9.getSourceFrom()) == true) goto L21;
        return false;
    L21:
        if (getResult() == r9.getResult()) goto L23;
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
        long r0 = getId();
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r3 = 0;
        if (getTaskId() != null) goto L5;
        int r2 = 0;
    L6:
        long r4 = getTriggerTime();
        int r5 = (((r1 + r2) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (getSourceFrom() == null) goto L11;
        r3 = getSourceFrom().hashCode();
    L11:
        return ((r5 + r3) * 31) + getResult();
    L5:
        r2 = getTaskId().hashCode();
        goto L6
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public String toString() {
        return "ShortcutTaskRecord(id=" + getId() + ", taskId=" + getTaskId() + ", triggerTime=" + getTriggerTime() + ", sourceFrom=" + getSourceFrom() + ", result=" + getResult() + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
