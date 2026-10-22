package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaContextSnapshot implements Parcelable {
    public static final Parcelable.Creator<MediaContextSnapshot> CREATOR = null;
    public String activeSessionId;
    public List<MediaEventField> fields;
    public String mediaType;
    public int privacyLevel;
    public long redactionMask;
    public String source;
    public int statusCode;
    public long updateTimeMs;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaContextSnapshot() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L33;
        return;
    L33:
        this.statusCode = r8.readInt();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.activeSessionId = r8.readString();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.source = r8.readString();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.mediaType = r8.readString();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.updateTimeMs = r8.readLong();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L30
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.fields = r8.createTypedArrayList(MediaEventField.CREATOR);     // Catch: Throwable -> L30
        int r12 = r8.dataPosition() - r10;
    L30:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.statusCode);
        r8.writeString(this.activeSessionId);
        r8.writeString(this.source);
        r8.writeString(this.mediaType);
        r8.writeLong(this.updateTimeMs);
        r8.writeInt(this.privacyLevel);
        r8.writeLong(this.redactionMask);
        r8.writeTypedList(this.fields);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
