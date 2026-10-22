package android.aimedia;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaEventSubscribeOptions implements Parcelable {
    public static final Parcelable.Creator<MediaEventSubscribeOptions> CREATOR = null;
    public boolean deliverCurrentSnapshot;
    public int maxBatchSize;
    public int maxPendingEvents;
    public long minIntervalMs;
    public long startSequenceNumber;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaEventSubscribeOptions() {
        this.startSequenceNumber = 0;
        this.minIntervalMs = 0;
        this.maxBatchSize = 0;
        this.maxPendingEvents = 0;
        this.deliverCurrentSnapshot = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L55;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.startSequenceNumber = r8.readLong();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.minIntervalMs = r8.readLong();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.maxBatchSize = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.maxPendingEvents = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.deliverCurrentSnapshot = r8.readBoolean();     // Catch: Throwable -> L52
        if (r0 > (Integer.MAX_VALUE - r1)) goto L51;
        r8.setDataPosition(r0 + r1);
        return;
    L51:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L44;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L44:
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
    L55:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L59;
        r8.setDataPosition(r0 + r1);
        throw th;
    L59:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeLong(this.startSequenceNumber);
        r3.writeLong(this.minIntervalMs);
        r3.writeInt(this.maxBatchSize);
        r3.writeInt(this.maxPendingEvents);
        r3.writeBoolean(this.deliverCurrentSnapshot);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
