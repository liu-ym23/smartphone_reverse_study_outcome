package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 &2\u00020\u0001:\u0001&B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001eJ\u001d\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0003H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b#J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "Landroid/os/Parcelable;", "type", "", OaidModel.KEY_ID, "", "taskId", "", "triggerTime", "sourceFrom", "result", "(IJLjava/lang/String;JLjava/lang/String;I)V", "getId", "()J", "getResult", "()I", "getSourceFrom", "()Ljava/lang/String;", "getTaskId", "getTriggerTime", "getType", "describeContents", "onReadSubClassExtensionField", "", "parcel", "Landroid/os/Parcel;", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class EventTaskRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskRecord> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/EventTaskRecord$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<EventTaskRecord> {
        public b() {
        }

        public EventTaskRecord a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            int r9 = r10.readInt();
            long r1 = r10.readLong();
            String r3 = r10.readString();
            long r4 = r10.readLong();
            String r6 = r10.readString();
            int r7 = r10.readInt();
            if (r9 == 2) goto L10;
            if (r9 != 3) goto L8;
            return new ShortcutTaskRecord(r1, r3, r4, r6, r7, r10);
        L8:
            throw new IllegalArgumentException("Unknown event task type: " + r9);
        L10:
            return new ConditionTaskRecordV2(r1, r3, r4, r6, r7, r10);
        }

        public EventTaskRecord[] a(int r1) {
            return new EventTaskRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public EventTaskRecord(int r1, long r2, String r4, long r5, String r7, int r8) {
        this.type = r1;
        this.id = r2;
        this.taskId = r4;
        this.triggerTime = r5;
        this.sourceFrom = r7;
        this.result = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.id;
    }

    public int getResult() {
        return this.result;
    }

    public String getSourceFrom() {
        return this.sourceFrom;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r3 = r4.readInt();
        ClassLoader r0 = EventTaskRecord.class.getClassLoader();
        if (r3 <= 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = 1;
    L7:
        if (r2 > r1) goto L9;
        r2 = r2 + 1;
    L9:
        if (r2 > r3) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r0);
        r2 = r2 + 1;
        goto L9
    L11:
        return;
    L5:
        r1 = r3;
        goto L6
    }

    public final void readSubClassExtensionFieldFromParcel$eventstaskkit_release(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r0 = r4.readInt();
        if (r0 > r5) goto L6;
        r5 = r0;
    L6:
        ClassLoader r1 = EventTaskRecord.class.getClassLoader();
        int r2 = 1;
    L7:
        if (r2 > r5) goto L9;
        onReadSubClassExtensionField(r4, r1, r2);
        r2 = r2 + 1;
    L9:
        if (r2 > r0) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r1);
        r2 = r2 + 1;
        goto L9
    }

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.type);
        r3.writeLong(getId());
        r3.writeString(getTaskId());
        r3.writeLong(getTriggerTime());
        r3.writeString(getSourceFrom());
        r3.writeInt(getResult());
    }
}
