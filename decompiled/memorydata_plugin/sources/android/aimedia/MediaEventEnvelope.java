package android.aimedia;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaEventEnvelope implements Parcelable {
    public static final Parcelable.Creator<MediaEventEnvelope> CREATOR = null;
    public int callingPid;
    public int callingUid;
    public String eventId;
    public String eventName;
    public long eventTimeMs;
    public String eventType;
    public List<MediaEventField> fields;
    public long flags;
    public String legacyRecordId;
    public String mediaType;
    public long mirrorTimeMs;
    public boolean mirroredFromLegacy;
    public String origin;
    public byte[] payloadBytes;
    public String payloadEncoding;
    public int payloadVersion;
    public int priority;
    public int privacyLevel;
    public long receiveTimeMs;
    public long redactionMask;
    public String reportedPackage;
    public int reportedPid;
    public int reportedUid;
    public int schemaVersion;
    public long sequenceNumber;
    public String sessionId;
    public String source;
    public String traceId;
    public long ttlMs;
    public int userId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaEventEnvelope() {
        this.sequenceNumber = 0;
        this.schemaVersion = 0;
        this.payloadVersion = 0;
        this.mirroredFromLegacy = false;
        this.mirrorTimeMs = 0;
        this.flags = 0;
        this.priority = 0;
        this.eventTimeMs = 0;
        this.receiveTimeMs = 0;
        this.callingUid = 0;
        this.callingPid = 0;
        this.reportedUid = 0;
        this.reportedPid = 0;
        this.userId = 0;
        this.privacyLevel = 0;
        this.redactionMask = 0;
        this.ttlMs = 0;
    }

    private int describeContents(Object r4) {
        int r0 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L13;
        Iterator r5 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r0 = r0 | describeContents(r5.next());
        goto L9
    L11:
        return r0;
    L13:
        if (ZeusTransformUtils.instanceOf(r4, Parcelable.class) == true) goto L15;
        return 0;
    L15:
        return ((Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin")).describeContents();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return describeContents(this.fields) | 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L255;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.eventId = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.sequenceNumber = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.schemaVersion = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.payloadVersion = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.traceId = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.origin = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.mirroredFromLegacy = r8.readBoolean();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.legacyRecordId = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L73;
        this.mirrorTimeMs = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L81;
        this.flags = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L89;
        this.source = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L97;
        this.mediaType = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L105;
        this.eventType = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L113;
        this.eventName = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L121;
        this.sessionId = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L129;
        this.priority = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L137;
        this.eventTimeMs = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L145;
        this.receiveTimeMs = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L153;
        this.callingUid = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L161;
        this.callingPid = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L169;
        this.reportedUid = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L177;
        this.reportedPid = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L185;
        this.userId = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L193;
        this.reportedPackage = r8.readString();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L201;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L209;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L217;
        this.ttlMs = r8.readLong();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L225;
        this.fields = r8.createTypedArrayList(MediaEventField.CREATOR);     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L233;
        this.payloadBytes = r8.createByteArray();     // Catch: Throwable -> L252
        if ((r8.dataPosition() - r0) >= r1) goto L241;
        this.payloadEncoding = r8.readString();     // Catch: Throwable -> L252
        if (r0 > (Integer.MAX_VALUE - r1)) goto L251;
        r8.setDataPosition(r0 + r1);
        return;
    L251:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L241:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L244;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L244:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L233:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L225:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L217:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L209:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L201:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L193:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L185:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L177:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L169:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L161:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L153:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L145:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L137:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L129:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L121:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L113:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L105:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L97:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L81:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L73:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L65:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L57:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L49:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L255:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L252
    L252:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L259;
        r8.setDataPosition(r0 + r1);
        throw th;
    L259:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        int r0 = r4.dataPosition();
        r4.writeInt(0);
        r4.writeString(this.eventId);
        r4.writeLong(this.sequenceNumber);
        r4.writeInt(this.schemaVersion);
        r4.writeInt(this.payloadVersion);
        r4.writeString(this.traceId);
        r4.writeString(this.origin);
        r4.writeBoolean(this.mirroredFromLegacy);
        r4.writeString(this.legacyRecordId);
        r4.writeLong(this.mirrorTimeMs);
        r4.writeLong(this.flags);
        r4.writeString(this.source);
        r4.writeString(this.mediaType);
        r4.writeString(this.eventType);
        r4.writeString(this.eventName);
        r4.writeString(this.sessionId);
        r4.writeInt(this.priority);
        r4.writeLong(this.eventTimeMs);
        r4.writeLong(this.receiveTimeMs);
        r4.writeInt(this.callingUid);
        r4.writeInt(this.callingPid);
        r4.writeInt(this.reportedUid);
        r4.writeInt(this.reportedPid);
        r4.writeInt(this.userId);
        r4.writeString(this.reportedPackage);
        r4.writeInt(this.privacyLevel);
        r4.writeLong(this.redactionMask);
        r4.writeLong(this.ttlMs);
        r4.writeTypedList(this.fields, r5);
        r4.writeByteArray(this.payloadBytes);
        r4.writeString(this.payloadEncoding);
        int r3 = r4.dataPosition();
        r4.setDataPosition(r0);
        r4.writeInt(r3 - r0);
        r4.setDataPosition(r3);
    }
}
