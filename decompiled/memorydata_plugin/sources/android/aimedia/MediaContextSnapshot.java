package android.aimedia;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
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
        this.statusCode = 0;
        this.updateTimeMs = 0;
        this.privacyLevel = 0;
        this.redactionMask = 0;
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
        if (r1 < 4) goto L79;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.statusCode = r8.readInt();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.activeSessionId = r8.readString();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.source = r8.readString();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.mediaType = r8.readString();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.updateTimeMs = r8.readLong();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.privacyLevel = r8.readInt();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.redactionMask = r8.readLong();     // Catch: Throwable -> L76
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.fields = r8.createTypedArrayList(MediaEventField.CREATOR);     // Catch: Throwable -> L76
        if (r0 > (Integer.MAX_VALUE - r1)) goto L75;
        r8.setDataPosition(r0 + r1);
        return;
    L75:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L65:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L68;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L68:
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
    L79:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L83;
        r8.setDataPosition(r0 + r1);
        throw th;
    L83:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        int r0 = r4.dataPosition();
        r4.writeInt(0);
        r4.writeInt(this.statusCode);
        r4.writeString(this.activeSessionId);
        r4.writeString(this.source);
        r4.writeString(this.mediaType);
        r4.writeLong(this.updateTimeMs);
        r4.writeInt(this.privacyLevel);
        r4.writeLong(this.redactionMask);
        r4.writeTypedList(this.fields, r5);
        int r3 = r4.dataPosition();
        r4.setDataPosition(r0);
        r4.writeInt(r3 - r0);
        r4.setDataPosition(r3);
    }
}
