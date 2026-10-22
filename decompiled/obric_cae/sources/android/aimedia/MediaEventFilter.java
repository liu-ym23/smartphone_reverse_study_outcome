package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaEventFilter implements Parcelable {
    public static final Parcelable.Creator<MediaEventFilter> CREATOR = null;
    public long endTimeMs;
    public List<String> eventNames;
    public List<String> eventTypes;
    public boolean includeMirroredEvents;
    public List<String> mediaTypes;
    public long minSequenceNumber;
    public List<String> origins;
    public List<String> sessionIds;
    public List<String> sources;
    public long startTimeMs;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaEventFilter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L43;
        return;
    L43:
        this.origins = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.sources = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.mediaTypes = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventTypes = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventNames = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.sessionIds = r8.createStringArrayList();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.startTimeMs = r8.readLong();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.endTimeMs = r8.readLong();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.minSequenceNumber = r8.readLong();     // Catch: Throwable -> L40
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L37;
        boolean r12 = true;
    L38:
        this.includeMirroredEvents = r12;     // Catch: Throwable -> L40
        int r13 = r8.dataPosition() - r10;
        goto L8
    L37:
        r12 = false;
    L40:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeStringList(this.origins);
        r8.writeStringList(this.sources);
        r8.writeStringList(this.mediaTypes);
        r8.writeStringList(this.eventTypes);
        r8.writeStringList(this.eventNames);
        r8.writeStringList(this.sessionIds);
        r8.writeLong(this.startTimeMs);
        r8.writeLong(this.endTimeMs);
        r8.writeLong(this.minSequenceNumber);
        r8.writeInt(this.includeMirroredEvents ? 1 : 0);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
