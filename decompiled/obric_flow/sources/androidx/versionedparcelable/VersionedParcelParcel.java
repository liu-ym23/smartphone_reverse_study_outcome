package androidx.versionedparcelable;

import ai.j0;
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

    public VersionedParcelParcel(Parcel r10) {
        this(r10, r10.dataPosition(), r10.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int r5 = this.mCurrentField;
        if (r5 < 0) goto L6;
        int r10 = this.mPositionLookup.get(r5);
        int r11 = this.mParcel.dataPosition();
        int r12 = r11 - r10;
        this.mParcel.setDataPosition(r10);
        this.mParcel.writeInt(r12);
        this.mParcel.setDataPosition(r11);
        return;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        Parcel r5 = this.mParcel;
        int r10 = r5.dataPosition();
        int r11 = this.mNextRead;
        if (r11 != this.mOffset) goto L6;
        r11 = this.mEnd;
    L6:
        return new VersionedParcelParcel(r5, r10, r11, j0.q(new StringBuilder(), this.mPrefix, "  "), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
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
        int r5 = this.mParcel.readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        byte[] r10 = new byte[r5];
        this.mParcel.readByteArray(r10);
        return r10;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r5) {
    L3:
        if (this.mNextRead >= this.mEnd) goto L12;
        int r10 = this.mFieldId;
        if (r10 == r5) goto L6;
        if (String.valueOf(r10).compareTo(String.valueOf(r5)) > 0) goto L9;
        this.mParcel.setDataPosition(this.mNextRead);
        int r11 = this.mParcel.readInt();
        this.mFieldId = this.mParcel.readInt();
        this.mNextRead += r11;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.mFieldId == r5) goto L14;
        return false;
    L14:
        return true;
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
    public void setOutputField(int r5) {
        closeField();
        this.mCurrentField = r5;
        this.mPositionLookup.put(r5, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r5) {
        this.mParcel.writeInt(r5 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r5) {
        this.mParcel.writeBundle(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r5) {
        if (r5 == null) goto L4;
        this.mParcel.writeInt(r5.length);
        this.mParcel.writeByteArray(r5);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence r5) {
        TextUtils.writeToParcel(r5, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r5) {
        this.mParcel.writeDouble(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r5) {
        this.mParcel.writeFloat(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r5) {
        this.mParcel.writeInt(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r5) {
        this.mParcel.writeLong(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r5) {
        this.mParcel.writeParcelable(r5, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r5) {
        this.mParcel.writeString(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r5) {
        this.mParcel.writeStrongBinder(r5);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r5) {
        this.mParcel.writeStrongInterface(r5);
    }

    private VersionedParcelParcel(Parcel r5, int r10, int r11, String r12, ArrayMap<String, Method> r13, ArrayMap<String, Method> r14, ArrayMap<String, Class> r15) {
        super(r13, r14, r15);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = r5;
        this.mOffset = r10;
        this.mEnd = r11;
        this.mNextRead = r10;
        this.mPrefix = r12;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r5, int r10, int r11) {
        if (r5 == null) goto L4;
        this.mParcel.writeInt(r5.length);
        this.mParcel.writeByteArray(r5, r10, r11);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }
}
