package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaEventField implements Parcelable {
    public static final Parcelable.Creator<MediaEventField> CREATOR = null;
    public boolean boolValue;
    public byte[] bytesValue;
    public double doubleValue;
    public String key;
    public long longValue;
    public int privacyLevel;
    public long redactionMask;
    public String stringValue;
    public int valueType;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaEventField() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L40;
        return;
    L40:
        this.key = r8.readString();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.valueType = r8.readInt();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.stringValue = r8.readString();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.longValue = r8.readLong();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.doubleValue = r8.readDouble();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L25;
        boolean r12 = true;
    L26:
        this.boolValue = r12;     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.bytesValue = r8.createByteArray();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L37
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L37
        int r13 = r8.dataPosition() - r10;
        goto L8
    L25:
        r12 = false;
    L37:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.key);
        r8.writeInt(this.valueType);
        r8.writeString(this.stringValue);
        r8.writeLong(this.longValue);
        r8.writeDouble(this.doubleValue);
        r8.writeInt(this.boolValue ? 1 : 0);
        r8.writeByteArray(this.bytesValue);
        r8.writeInt(this.privacyLevel);
        r8.writeLong(this.redactionMask);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
