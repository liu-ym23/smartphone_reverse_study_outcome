package android.aimedia;

import android.os.BadParcelableException;
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
        this.valueType = 0;
        this.longValue = 0;
        this.doubleValue = 0.0d;
        this.boolValue = false;
        this.privacyLevel = 0;
        this.redactionMask = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L87;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.key = r8.readString();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.valueType = r8.readInt();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.stringValue = r8.readString();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.longValue = r8.readLong();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.doubleValue = r8.readDouble();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.boolValue = r8.readBoolean();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.bytesValue = r8.createByteArray();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L84
        if ((r8.dataPosition() - r0) >= r1) goto L73;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L84
        if (r0 > (Integer.MAX_VALUE - r1)) goto L83;
        r8.setDataPosition(r0 + r1);
        return;
    L83:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L73:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L76;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L76:
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
    L87:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L91;
        r8.setDataPosition(r0 + r1);
        throw th;
    L91:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeString(this.key);
        r3.writeInt(this.valueType);
        r3.writeString(this.stringValue);
        r3.writeLong(this.longValue);
        r3.writeDouble(this.doubleValue);
        r3.writeBoolean(this.boolValue);
        r3.writeByteArray(this.bytesValue);
        r3.writeInt(this.privacyLevel);
        r3.writeLong(this.redactionMask);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
