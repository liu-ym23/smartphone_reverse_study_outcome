package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    VersionedParcelParcel(Parcel r10) {
        this(r10, r10.dataPosition(), r10.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelParcel(Parcel r10, int r11, int r12, String r13, ArrayMap<String, Method> r14, ArrayMap<String, Method> r15, ArrayMap<String, Class> r16) {
        super(r14, r15, r16);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mFieldId = -1;
        this.mParcel = r10;
        this.mOffset = r11;
        this.mEnd = r12;
        this.mNextRead = r11;
        this.mPrefix = r13;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int r10 = this.mCurrentField;
        if (r10 < 0) goto L6;
        int r11 = this.mPositionLookup.get(r10);
        int r12 = this.mParcel.dataPosition();
        int r13 = r12 - r11;
        this.mParcel.setDataPosition(r11);
        this.mParcel.writeInt(r13);
        this.mParcel.setDataPosition(r12);
        return;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
        Parcel r10 = this.mParcel;
        int r11 = r10.dataPosition();
        int r12 = this.mNextRead;
        if (r12 != this.mOffset) goto L6;
        r12 = this.mEnd;
    L6:
        return new VersionedParcelParcel(r10, r11, r12, this.mPrefix + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        if (this.mParcel.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r10 = this.mParcel.readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        byte[] r11 = new byte[r10];
        this.mParcel.readByteArray(r11);
        return r11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r10) {
    L3:
        if (this.mNextRead >= this.mEnd) goto L12;
        int r11 = this.mFieldId;
        if (r11 == r10) goto L6;
        if (String.valueOf(r11).compareTo(String.valueOf(r10)) > 0) goto L9;
        this.mParcel.setDataPosition(this.mNextRead);
        int r12 = this.mParcel.readInt();
        this.mFieldId = this.mParcel.readInt();
        this.mNextRead += r12;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.mFieldId != r10) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r10) {
        closeField();
        this.mCurrentField = r10;
        this.mPositionLookup.put(r10, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r10) {
        this.mParcel.writeInt(r10 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r10) {
        this.mParcel.writeBundle(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r10) {
        if (r10 == null) goto L4;
        this.mParcel.writeInt(r10.length);
        this.mParcel.writeByteArray(r10);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L4;
        this.mParcel.writeInt(r10.length);
        this.mParcel.writeByteArray(r10, r11, r12);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence r10) {
        TextUtils.writeToParcel(r10, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r10) {
        this.mParcel.writeDouble(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r10) {
        this.mParcel.writeFloat(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r10) {
        this.mParcel.writeInt(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r10) {
        this.mParcel.writeLong(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r10) {
        this.mParcel.writeParcelable(r10, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r10) {
        this.mParcel.writeString(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r10) {
        this.mParcel.writeStrongBinder(r10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r10) {
        this.mParcel.writeStrongInterface(r10);
    }
}
