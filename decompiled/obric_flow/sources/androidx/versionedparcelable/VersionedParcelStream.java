package androidx.versionedparcelable;

import ai.j0;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = null;
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    public static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        public FieldBuffer(int r5, DataOutputStream r10) {
            ByteArrayOutputStream r11 = new ByteArrayOutputStream();
            this.mOutput = r11;
            this.mDataStream = new DataOutputStream(r11);
            this.mFieldId = r5;
            this.mTarget = r10;
        }

        public void flushField() throws IOException {
            this.mDataStream.flush();
            int r5 = this.mOutput.size();
            int r10 = this.mFieldId << 16;
            if (r5 < 65535) goto L5;
            int r11 = 65535;
        L6:
            this.mTarget.writeInt(r10 | r11);
            if (r5 < 65535) goto L9;
            this.mTarget.writeInt(r5);
        L9:
            this.mOutput.writeTo(this.mTarget);
            return;
        L5:
            r11 = r5;
            goto L6
        }
    }

    static {
        UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream r10, OutputStream r11) {
        this(r10, r11, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private void readObject(int r5, String r10, Bundle r11) {
        switch(r5) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
            default: goto L4;
        };
    L5:
        r11.putFloatArray(r10, readFloatArray());
        return;
    L6:
        r11.putFloat(r10, readFloat());
        return;
    L7:
        r11.putLongArray(r10, readLongArray());
        return;
    L8:
        r11.putLong(r10, readLong());
        return;
    L9:
        r11.putIntArray(r10, readIntArray());
        return;
    L10:
        r11.putInt(r10, readInt());
        return;
    L11:
        r11.putDoubleArray(r10, readDoubleArray());
        return;
    L12:
        r11.putDouble(r10, readDouble());
        return;
    L13:
        r11.putBooleanArray(r10, readBooleanArray());
        return;
    L14:
        r11.putBoolean(r10, readBoolean());
        return;
    L15:
        r11.putStringArray(r10, (String[]) readArray(new String[0]));
        return;
    L16:
        r11.putString(r10, readString());
        return;
    L17:
        r11.putBundle(r10, readBundle());
        return;
    L18:
        r11.putBundle(r10, readBundle());
        return;
    L19:
        r11.putParcelable(r10, null);
        return;
    L4:
        throw new RuntimeException(j0.g(r5, "Unknown type "));
    }

    private void writeObject(Object r5) {
        if (r5 != null) goto L5;
        writeInt(0);
        return;
    L5:
        if ((r5 instanceof Bundle) == false) goto L8;
        writeInt(1);
        writeBundle((Bundle) r5);
        return;
    L8:
        if ((r5 instanceof String) == false) goto L11;
        writeInt(3);
        writeString((String) r5);
        return;
    L11:
        if ((r5 instanceof String[]) == false) goto L14;
        writeInt(4);
        writeArray((String[]) r5);
        return;
    L14:
        if ((r5 instanceof Boolean) == false) goto L17;
        writeInt(5);
        writeBoolean(((Boolean) r5).booleanValue());
        return;
    L17:
        if ((r5 instanceof boolean[]) == false) goto L20;
        writeInt(6);
        writeBooleanArray((boolean[]) r5);
        return;
    L20:
        if ((r5 instanceof Double) == false) goto L23;
        writeInt(7);
        writeDouble(((Double) r5).doubleValue());
        return;
    L23:
        if ((r5 instanceof double[]) == false) goto L26;
        writeInt(8);
        writeDoubleArray((double[]) r5);
        return;
    L26:
        if ((r5 instanceof Integer) == false) goto L29;
        writeInt(9);
        writeInt(((Integer) r5).intValue());
        return;
    L29:
        if ((r5 instanceof int[]) == false) goto L32;
        writeInt(10);
        writeIntArray((int[]) r5);
        return;
    L32:
        if ((r5 instanceof Long) == false) goto L35;
        writeInt(11);
        writeLong(((Long) r5).longValue());
        return;
    L35:
        if ((r5 instanceof long[]) == false) goto L38;
        writeInt(12);
        writeLongArray((long[]) r5);
        return;
    L38:
        if ((r5 instanceof Float) == false) goto L41;
        writeInt(13);
        writeFloat(((Float) r5).floatValue());
        return;
    L41:
        if ((r5 instanceof float[]) == false) goto L45;
        writeInt(14);
        writeFloatArray((float[]) r5);
        return;
    L45:
        throw new IllegalArgumentException("Unsupported type " + r5.getClass());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer r5 = this.mFieldBuffer;
        if (r5 != null) goto L14;
        return;
    L14:
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    L5:
        if (r5.mOutput.size() == 0) goto L10;
        this.mFieldBuffer.flushField();     // Catch: IOException -> L8
    L10:
        this.mFieldBuffer = null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.mCurrentInput.readBoolean();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        Bundle r10 = new Bundle();
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L9;
        String r12 = readString();
        readObject(readInt(), r12, r10);
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r5 = this.mCurrentInput.readInt();     // Catch: IOException -> L6
        if (r5 <= 0) goto L8;
        byte[] r10 = new byte[r5];     // Catch: IOException -> L6
        this.mCurrentInput.readFully(r10);     // Catch: IOException -> L6
        return r10;
    L8:
        return null;
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mCurrentInput.readDouble();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r5) {
    L19:
        int r10 = this.mFieldId;     // Catch: IOException -> L18
        if (r10 == r5) goto L5;
        if (String.valueOf(r10).compareTo(String.valueOf(r5)) > 0) goto L9;
        int r11 = this.mCount;     // Catch: IOException -> L18
        int r12 = this.mFieldSize;     // Catch: IOException -> L18
        if (r11 >= r12) goto L13;
        this.mMasterInput.skip(r12 - r11);     // Catch: IOException -> L18
    L13:
        this.mFieldSize = -1;     // Catch: IOException -> L18
        int r13 = this.mMasterInput.readInt();     // Catch: IOException -> L18
        this.mCount = 0;     // Catch: IOException -> L18
        int r14 = r13 & 65535;     // Catch: IOException -> L18
        if (r14 != 65535) goto L16;
        r14 = this.mMasterInput.readInt();     // Catch: IOException -> L18
    L16:
        this.mFieldId = (r13 >> 16) & 65535;     // Catch: IOException -> L18
        this.mFieldSize = r14;     // Catch: IOException -> L18
        goto L19
    L9:
        return false;
    L5:
        return true;
    L18:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mCurrentInput.readFloat();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mCurrentInput.readInt();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mCurrentInput.readLong();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        int r5 = this.mCurrentInput.readInt();     // Catch: IOException -> L6
        if (r5 <= 0) goto L8;
        byte[] r10 = new byte[r5];     // Catch: IOException -> L6
        this.mCurrentInput.readFully(r10);     // Catch: IOException -> L6
        return new String(r10, UTF_16);
    L8:
        return null;
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r5) {
        closeField();
        FieldBuffer r10 = new FieldBuffer(r5, this.mMasterOutput);
        this.mFieldBuffer = r10;
        this.mCurrentOutput = r10.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean r5, boolean r10) {
        if (r5 == false) goto L6;
        this.mIgnoreParcelables = r10;
        return;
    L6:
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r5) {
        this.mCurrentOutput.writeBoolean(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r5) {
        if (r5 == null) goto L9;
        Set<String> r10 = r5.keySet();     // Catch: IOException -> L7
        this.mCurrentOutput.writeInt(r10.size());     // Catch: IOException -> L7
        Iterator<String> r11 = r10.iterator();     // Catch: IOException -> L7
    L5:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();     // Catch: IOException -> L7
        writeString(r12);     // Catch: IOException -> L7
        writeObject(r5.get(r12));     // Catch: IOException -> L7
        goto L5
    L15:
        return;
    L9:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r5) {
        if (r5 == null) goto L6;
        this.mCurrentOutput.writeInt(r5.length);     // Catch: IOException -> L4
        this.mCurrentOutput.write(r5);     // Catch: IOException -> L4
    L10:
        return;
    L6:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L4
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence r5) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r5) {
        this.mCurrentOutput.writeDouble(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r5) {
        this.mCurrentOutput.writeFloat(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r5) {
        this.mCurrentOutput.writeInt(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r5) {
        this.mCurrentOutput.writeLong(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r5) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r5) {
        if (r5 == null) goto L6;
        byte[] r10 = r5.getBytes(UTF_16);     // Catch: IOException -> L4
        this.mCurrentOutput.writeInt(r10.length);     // Catch: IOException -> L4
        this.mCurrentOutput.write(r10);     // Catch: IOException -> L4
    L10:
        return;
    L6:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L4
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r5) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r5) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    private VersionedParcelStream(final InputStream r5, OutputStream r10, ArrayMap<String, Method> r11, ArrayMap<String, Method> r12, ArrayMap<String, Class> r13) {
        super(r11, r12, r13);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream r14 = null;
        if (r5 == null) goto L5;
        DataInputStream r15 = new DataInputStream(new AnonymousClass1(this, r5));
    L6:
        this.mMasterInput = r15;
        if (r10 == null) goto L9;
        r14 = new DataOutputStream(r10);
    L9:
        this.mMasterOutput = r14;
        this.mCurrentInput = r15;
        this.mCurrentOutput = r14;
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r5, int r10, int r11) {
        if (r5 == null) goto L6;
        this.mCurrentOutput.writeInt(r11);     // Catch: IOException -> L4
        this.mCurrentOutput.write(r5, r10, r11);     // Catch: IOException -> L4
    L10:
        return;
    L6:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L4
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }
}
