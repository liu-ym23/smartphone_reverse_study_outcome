package android.aimedia;

import android.os.BadParcelableException;
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
        this.startTimeMs = 0;
        this.endTimeMs = 0;
        this.minSequenceNumber = 0;
        this.includeMirroredEvents = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L95;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.origins = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.sources = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.mediaTypes = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.eventTypes = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.eventNames = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.sessionIds = r8.createStringArrayList();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.startTimeMs = r8.readLong();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.endTimeMs = r8.readLong();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L73;
        this.minSequenceNumber = r8.readLong();     // Catch: Throwable -> L92
        if ((r8.dataPosition() - r0) >= r1) goto L81;
        this.includeMirroredEvents = r8.readBoolean();     // Catch: Throwable -> L92
        if (r0 > (Integer.MAX_VALUE - r1)) goto L91;
        r8.setDataPosition(r0 + r1);
        return;
    L91:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L81:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L84;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L84:
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
    L95:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L99;
        r8.setDataPosition(r0 + r1);
        throw th;
    L99:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeStringList(this.origins);
        r3.writeStringList(this.sources);
        r3.writeStringList(this.mediaTypes);
        r3.writeStringList(this.eventTypes);
        r3.writeStringList(this.eventNames);
        r3.writeStringList(this.sessionIds);
        r3.writeLong(this.startTimeMs);
        r3.writeLong(this.endTimeMs);
        r3.writeLong(this.minSequenceNumber);
        r3.writeBoolean(this.includeMirroredEvents);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
