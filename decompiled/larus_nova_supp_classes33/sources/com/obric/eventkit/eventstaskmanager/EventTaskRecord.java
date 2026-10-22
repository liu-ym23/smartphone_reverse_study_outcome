package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0001-B;\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010$\u001a\u00020\u001a\u0012\b\u0010&\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001c\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019¨\u0006."}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "id", "J", "getId", "()J", "", "taskId", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "triggerTime", "getTriggerTime", "sourceFrom", "getSourceFrom", WindowEvent.Params.RESULT, "getResult", "<init>", "(IJLjava/lang/String;JLjava/lang/String;I)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTaskRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskRecord> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;
    private final int type;

    public static final class a implements Parcelable.Creator<EventTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskRecord createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            int r0 = r11.readInt();
            long r2 = r11.readLong();
            String r4 = r11.readString();
            long r5 = r11.readLong();
            String r7 = r11.readString();
            int r8 = r11.readInt();
            if (r0 == 2) goto L10;
            if (r0 != 3) goto L8;
            return new ShortcutTaskRecord(r2, r4, r5, r7, r8, r11);
        L8:
            throw new IllegalArgumentException("Unknown event task type: " + r0);
        L10:
            return new ConditionTaskRecordV2(r2, r4, r5, r7, r8, r11);
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskRecord[] newArray(int r1) {
            return new EventTaskRecord[r1];
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

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r0 = r5.readInt();
        ClassLoader r1 = EventTaskRecord.class.getClassLoader();
        if (r0 <= 0) goto L5;
        int r2 = 0;
    L6:
        int r3 = 1;
    L7:
        if (r3 > r2) goto L9;
        r3 = r3 + 1;
    L9:
        if (r3 > r0) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r5, r1);
        r3 = r3 + 1;
        goto L9
    L11:
        return;
    L5:
        r2 = r0;
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

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
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
