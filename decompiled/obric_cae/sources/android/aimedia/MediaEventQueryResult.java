package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaEventQueryResult implements Parcelable {
    public static final Parcelable.Creator<MediaEventQueryResult> CREATOR = null;
    public int droppedCount;
    public List<MediaEventEnvelope> events;
    public boolean hasMore;
    public String nextPageToken;
    public long nextSequenceNumber;
    public int statusCode;
    public long storeNewestSequenceNumber;
    public long storeOldestSequenceNumber;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaEventQueryResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L37;
        return;
    L37:
        this.statusCode = r8.readInt();     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.events = r8.createTypedArrayList(MediaEventEnvelope.CREATOR);     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.nextSequenceNumber = r8.readLong();     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.nextPageToken = r8.readString();     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L22;
        boolean r12 = true;
    L23:
        this.hasMore = r12;     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.droppedCount = r8.readInt();     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.storeOldestSequenceNumber = r8.readLong();     // Catch: Throwable -> L34
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.storeNewestSequenceNumber = r8.readLong();     // Catch: Throwable -> L34
        int r13 = r8.dataPosition() - r10;
        goto L8
    L22:
        r12 = false;
    L34:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.statusCode);
        r8.writeTypedList(this.events);
        r8.writeLong(this.nextSequenceNumber);
        r8.writeString(this.nextPageToken);
        r8.writeInt(this.hasMore ? 1 : 0);
        r8.writeInt(this.droppedCount);
        r8.writeLong(this.storeOldestSequenceNumber);
        r8.writeLong(this.storeNewestSequenceNumber);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
