package android.aimedia;

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
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L28;
        return;
    L28:
        this.startSequenceNumber = r8.readLong();     // Catch: Throwable -> L25
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.minIntervalMs = r8.readLong();     // Catch: Throwable -> L25
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxBatchSize = r8.readInt();     // Catch: Throwable -> L25
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxPendingEvents = r8.readInt();     // Catch: Throwable -> L25
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L22;
        boolean r12 = true;
    L23:
        this.deliverCurrentSnapshot = r12;     // Catch: Throwable -> L25
        int r13 = r8.dataPosition() - r10;
        goto L8
    L22:
        r12 = false;
    L25:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeLong(this.startSequenceNumber);
        r8.writeLong(this.minIntervalMs);
        r8.writeInt(this.maxBatchSize);
        r8.writeInt(this.maxPendingEvents);
        r8.writeInt(this.deliverCurrentSnapshot ? 1 : 0);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
