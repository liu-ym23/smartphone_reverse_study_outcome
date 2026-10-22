package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;
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
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L103;
        return;
    L103:
        this.eventId = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.sequenceNumber = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.schemaVersion = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.payloadVersion = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.traceId = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.origin = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L28;
        boolean r12 = true;
    L29:
        this.mirroredFromLegacy = r12;     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.legacyRecordId = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.mirrorTimeMs = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.flags = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.source = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.mediaType = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventType = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventName = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.sessionId = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.priority = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventTimeMs = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.receiveTimeMs = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.callingUid = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.callingPid = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.reportedUid = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.reportedPid = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.userId = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.reportedPackage = r8.readString();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.ttlMs = r8.readLong();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.fields = r8.createTypedArrayList(MediaEventField.CREATOR);     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.payloadBytes = r8.createByteArray();     // Catch: Throwable -> L100
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.payloadEncoding = r8.readString();     // Catch: Throwable -> L100
        int r13 = r8.dataPosition() - r10;
        goto L8
    L28:
        r12 = false;
    L100:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.eventId);
        r8.writeLong(this.sequenceNumber);
        r8.writeInt(this.schemaVersion);
        r8.writeInt(this.payloadVersion);
        r8.writeString(this.traceId);
        r8.writeString(this.origin);
        r8.writeInt(this.mirroredFromLegacy ? 1 : 0);
        r8.writeString(this.legacyRecordId);
        r8.writeLong(this.mirrorTimeMs);
        r8.writeLong(this.flags);
        r8.writeString(this.source);
        r8.writeString(this.mediaType);
        r8.writeString(this.eventType);
        r8.writeString(this.eventName);
        r8.writeString(this.sessionId);
        r8.writeInt(this.priority);
        r8.writeLong(this.eventTimeMs);
        r8.writeLong(this.receiveTimeMs);
        r8.writeInt(this.callingUid);
        r8.writeInt(this.callingPid);
        r8.writeInt(this.reportedUid);
        r8.writeInt(this.reportedPid);
        r8.writeInt(this.userId);
        r8.writeString(this.reportedPackage);
        r8.writeInt(this.privacyLevel);
        r8.writeLong(this.redactionMask);
        r8.writeLong(this.ttlMs);
        r8.writeTypedList(this.fields);
        r8.writeByteArray(this.payloadBytes);
        r8.writeString(this.payloadEncoding);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
