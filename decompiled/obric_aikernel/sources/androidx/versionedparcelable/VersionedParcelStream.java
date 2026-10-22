package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenu;
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

    private static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        FieldBuffer(int r10, DataOutputStream r11) {
            ByteArrayOutputStream r12 = new ByteArrayOutputStream();
            this.mOutput = r12;
            this.mDataStream = new DataOutputStream(r12);
            this.mFieldId = r10;
            this.mTarget = r11;
        }

        void flushField() {
            this.mDataStream.flush();
            int r10 = this.mOutput.size();
            int r11 = this.mFieldId << 16;
            if (r10 < 65535) goto L5;
            int r12 = 65535;
        L6:
            this.mTarget.writeInt(r11 | r12);
            if (r10 < 65535) goto L9;
            this.mTarget.writeInt(r10);
        L9:
            this.mOutput.writeTo(this.mTarget);
            return;
        L5:
            r12 = r10;
            goto L6
        }
    }

    static {
        UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream r10, OutputStream r11) {
        this(r10, r11, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelStream(final InputStream r10, OutputStream r11, ArrayMap<String, Method> r12, ArrayMap<String, Method> r13, ArrayMap<String, Class> r14) {
        super(r12, r13, r14);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream r15 = null;
        if (r10 == null) goto L5;
        DataInputStream r16 = new DataInputStream(new AnonymousClass1(this, r10));
    L6:
        this.mMasterInput = r16;
        if (r11 == null) goto L9;
        r15 = new DataOutputStream(r11);
    L9:
        this.mMasterOutput = r15;
        this.mCurrentInput = r16;
        this.mCurrentOutput = r15;
        return;
    L5:
        r16 = null;
        goto L6
    }

    private void readObject(int r10, String r11, Bundle r12) {
        switch(r10) {
            case 0: goto L18;
            case 1: goto L17;
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
        r12.putFloatArray(r11, readFloatArray());
        return;
    L6:
        r12.putFloat(r11, readFloat());
        return;
    L7:
        r12.putLongArray(r11, readLongArray());
        return;
    L8:
        r12.putLong(r11, readLong());
        return;
    L9:
        r12.putIntArray(r11, readIntArray());
        return;
    L10:
        r12.putInt(r11, readInt());
        return;
    L11:
        r12.putDoubleArray(r11, readDoubleArray());
        return;
    L12:
        r12.putDouble(r11, readDouble());
        return;
    L13:
        r12.putBooleanArray(r11, readBooleanArray());
        return;
    L14:
        r12.putBoolean(r11, readBoolean());
        return;
    L15:
        r12.putStringArray(r11, (String[]) readArray(new String[0]));
        return;
    L16:
        r12.putString(r11, readString());
        return;
    L17:
        r12.putBundle(r11, readBundle());
        return;
    L18:
        r12.putParcelable(r11, null);
        return;
    L4:
        throw new RuntimeException("Unknown type " + r10);
    }

    private void writeObject(Object r10) {
        if (r10 != null) goto L6;
        int r11 = 0;
    L4:
        writeInt(r11);
        return;
    L6:
        if ((r10 instanceof Bundle) == false) goto L9;
        writeInt(1);
        writeBundle((Bundle) r10);
        return;
    L9:
        if ((r10 instanceof String) == false) goto L12;
        writeInt(3);
        writeString((String) r10);
        return;
    L12:
        if ((r10 instanceof String[]) == false) goto L15;
        writeInt(4);
        writeArray((String[]) r10);
        return;
    L15:
        if ((r10 instanceof Boolean) == false) goto L18;
        writeInt(5);
        writeBoolean(((Boolean) r10).booleanValue());
        return;
    L18:
        if ((r10 instanceof boolean[]) == false) goto L21;
        writeInt(6);
        writeBooleanArray((boolean[]) r10);
        return;
    L21:
        if ((r10 instanceof Double) == false) goto L24;
        writeInt(7);
        writeDouble(((Double) r10).doubleValue());
        return;
    L24:
        if ((r10 instanceof double[]) == false) goto L27;
        writeInt(8);
        writeDoubleArray((double[]) r10);
        return;
    L27:
        if ((r10 instanceof Integer) == false) goto L30;
        writeInt(9);
        r11 = ((Integer) r10).intValue();
        goto L4
    L30:
        if ((r10 instanceof int[]) == false) goto L33;
        writeInt(10);
        writeIntArray((int[]) r10);
        return;
    L33:
        if ((r10 instanceof Long) == false) goto L36;
        writeInt(11);
        writeLong(((Long) r10).longValue());
        return;
    L36:
        if ((r10 instanceof long[]) == false) goto L39;
        writeInt(12);
        writeLongArray((long[]) r10);
        return;
    L39:
        if ((r10 instanceof Float) == false) goto L42;
        writeInt(13);
        writeFloat(((Float) r10).floatValue());
        return;
    L42:
        if ((r10 instanceof float[]) == false) goto L46;
        writeInt(14);
        writeFloatArray((float[]) r10);
        return;
    L46:
        throw new IllegalArgumentException("Unsupported type " + r10.getClass());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer r10 = this.mFieldBuffer;
        if (r10 != null) goto L12;
        return;
    L12:
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    L5:
        if (r10.mOutput.size() == 0) goto L7;
        this.mFieldBuffer.flushField();     // Catch: IOException -> L8
    L7:
        this.mFieldBuffer = null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
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
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        Bundle r11 = new Bundle();
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        String r13 = readString();
        readObject(readInt(), r13, r11);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r10 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r10 <= 0) goto L6;
        byte[] r11 = new byte[r10];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r11);     // Catch: IOException -> L8
        return r11;
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
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
    public boolean readField(int r10) {
    L19:
        int r11 = this.mFieldId;     // Catch: IOException -> L18
        if (r11 == r10) goto L5;
        if (String.valueOf(r11).compareTo(String.valueOf(r10)) > 0) goto L9;
        int r12 = this.mCount;     // Catch: IOException -> L18
        int r13 = this.mFieldSize;     // Catch: IOException -> L18
        if (r12 >= r13) goto L13;
        this.mMasterInput.skip(r13 - r12);     // Catch: IOException -> L18
    L13:
        this.mFieldSize = -1;     // Catch: IOException -> L18
        int r14 = this.mMasterInput.readInt();     // Catch: IOException -> L18
        this.mCount = 0;     // Catch: IOException -> L18
        int r15 = r14 & SupportMenu.USER_MASK;     // Catch: IOException -> L18
        if (r15 != 65535) goto L16;
        r15 = this.mMasterInput.readInt();     // Catch: IOException -> L18
    L16:
        this.mFieldId = (r14 >> 16) & SupportMenu.USER_MASK;     // Catch: IOException -> L18
        this.mFieldSize = r15;     // Catch: IOException -> L18
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
        int r10 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r10 <= 0) goto L6;
        byte[] r11 = new byte[r10];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r11);     // Catch: IOException -> L8
        return new String(r11, UTF_16);
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r10) {
        closeField();
        FieldBuffer r11 = new FieldBuffer(r10, this.mMasterOutput);
        this.mFieldBuffer = r11;
        this.mCurrentOutput = r11.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean r10, boolean r11) {
        if (r10 == false) goto L6;
        this.mIgnoreParcelables = r11;
        return;
    L6:
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r10) {
        this.mCurrentOutput.writeBoolean(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r10) {
        if (r10 == null) goto L7;
        Set<String> r11 = r10.keySet();     // Catch: IOException -> L9
        this.mCurrentOutput.writeInt(r11.size());     // Catch: IOException -> L9
        Iterator<String> r12 = r11.iterator();     // Catch: IOException -> L9
    L5:
        if (r12.hasNext() == false) goto L14;
        String r13 = r12.next();     // Catch: IOException -> L9
        writeString(r13);     // Catch: IOException -> L9
        writeObject(r10.get(r13));     // Catch: IOException -> L9
        goto L5
    L14:
        return;
    L7:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r10) {
        if (r10 == null) goto L4;
        this.mCurrentOutput.writeInt(r10.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r10);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L4;
        this.mCurrentOutput.writeInt(r12);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r10, r11, r12);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence r10) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r10) {
        this.mCurrentOutput.writeDouble(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r10) {
        this.mCurrentOutput.writeFloat(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r10) {
        this.mCurrentOutput.writeInt(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r10) {
        this.mCurrentOutput.writeLong(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r10) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r10) {
        if (r10 == null) goto L4;
        byte[] r11 = r10.getBytes(UTF_16);     // Catch: IOException -> L6
        this.mCurrentOutput.writeInt(r11.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r11);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r10) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r10) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
}
