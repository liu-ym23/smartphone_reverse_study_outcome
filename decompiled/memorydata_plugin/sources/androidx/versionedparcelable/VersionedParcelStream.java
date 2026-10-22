package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        FieldBuffer(int r3, DataOutputStream r4) {
            ByteArrayOutputStream r0 = new ByteArrayOutputStream();
            this.mOutput = r0;
            this.mDataStream = new DataOutputStream(r0);
            this.mFieldId = r3;
            this.mTarget = r4;
        }

        void flushField() {
            this.mDataStream.flush();
            int r0 = this.mOutput.size();
            int r1 = this.mFieldId << 16;
            if (r0 < 65535) goto L5;
            int r3 = 65535;
        L6:
            this.mTarget.writeInt(r1 | r3);
            if (r0 < 65535) goto L9;
            this.mTarget.writeInt(r0);
        L9:
            this.mOutput.writeTo(this.mTarget);
            return;
        L5:
            r3 = r0;
            goto L6
        }
    }

    static {
        UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream r7, OutputStream r8) {
        this(r7, r8, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelStream(final InputStream r1, OutputStream r2, ArrayMap<String, Method> r3, ArrayMap<String, Method> r4, ArrayMap<String, Class> r5) {
        super(r3, r4, r5);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream r6 = null;
        if (r1 == null) goto L5;
        DataInputStream r7 = new DataInputStream(new AnonymousClass1(this, r1));
    L6:
        this.mMasterInput = r7;
        if (r2 == null) goto L9;
        r6 = new DataOutputStream(r2);
    L9:
        this.mMasterOutput = r6;
        this.mCurrentInput = r7;
        this.mCurrentOutput = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }

    private void readObject(int r2, String r3, Bundle r4) {
        switch(r2) {
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
        r4.putFloatArray(r3, readFloatArray());
        return;
    L6:
        r4.putFloat(r3, readFloat());
        return;
    L7:
        r4.putLongArray(r3, readLongArray());
        return;
    L8:
        r4.putLong(r3, readLong());
        return;
    L9:
        r4.putIntArray(r3, readIntArray());
        return;
    L10:
        r4.putInt(r3, readInt());
        return;
    L11:
        r4.putDoubleArray(r3, readDoubleArray());
        return;
    L12:
        r4.putDouble(r3, readDouble());
        return;
    L13:
        r4.putBooleanArray(r3, readBooleanArray());
        return;
    L14:
        r4.putBoolean(r3, readBoolean());
        return;
    L15:
        r4.putStringArray(r3, (String[]) ZeusTransformUtils.preCheckCast(readArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
        return;
    L16:
        r4.putString(r3, readString());
        return;
    L17:
        r4.putBundle(r3, readBundle());
        return;
    L18:
        r4.putParcelable(r3, null);
        return;
    L4:
        throw new RuntimeException("Unknown type " + r2);
    }

    private void writeObject(Object r8) {
        if (r8 != null) goto L7;
        int r9 = 0;
    L5:
        writeInt(r9);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r8, Bundle.class) == false) goto L10;
        writeInt(1);
        writeBundle((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L13;
        writeInt(3);
        writeString((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        if ((r8 instanceof String[]) == false) goto L16;
        writeInt(4);
        writeArray((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r8, String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L19;
        writeInt(5);
        writeBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L19:
        if ((r8 instanceof boolean[]) == false) goto L22;
        writeInt(6);
        writeBooleanArray((boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.memorydata.plugin"), boolean[].class, "com.obric.memorydata.plugin"));
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L25;
        writeInt(7);
        writeDouble(((Double) ZeusTransformUtils.preCheckCast(r8, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L25:
        if ((r8 instanceof double[]) == false) goto L28;
        writeInt(8);
        writeDoubleArray((double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.memorydata.plugin"), double[].class, "com.obric.memorydata.plugin"));
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L31;
        writeInt(9);
        r9 = ((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L5
    L31:
        if ((r8 instanceof int[]) == false) goto L34;
        writeInt(10);
        writeIntArray((int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin"));
        return;
    L34:
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L37;
        writeInt(11);
        writeLong(((Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L37:
        if ((r8 instanceof long[]) == false) goto L40;
        writeInt(12);
        writeLongArray((long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.memorydata.plugin"), long[].class, "com.obric.memorydata.plugin"));
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L43;
        writeInt(13);
        writeFloat(((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L43:
        if ((r8 instanceof float[]) == false) goto L47;
        writeInt(14);
        writeFloatArray((float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin"), float[].class, "com.obric.memorydata.plugin"));
        return;
    L47:
        throw new IllegalArgumentException("Unsupported type " + r8.getClass());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer r0 = this.mFieldBuffer;
        if (r0 != null) goto L12;
        return;
    L12:
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    L5:
        if (r0.mOutput.size() == 0) goto L7;
        this.mFieldBuffer.flushField();     // Catch: IOException -> L8
    L7:
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
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        Bundle r1 = new Bundle();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        String r3 = readString();
        readObject(readInt(), r3, r1);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r0 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r0 <= 0) goto L6;
        byte[] r1 = new byte[r0];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r1);     // Catch: IOException -> L8
        return r1;
    L6:
        return null;
    L8:
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
        int r1 = this.mFieldId;     // Catch: IOException -> L18
        if (r1 == r5) goto L5;
        if (String.valueOf(r1).compareTo(String.valueOf(r5)) > 0) goto L9;
        int r2 = this.mCount;     // Catch: IOException -> L18
        int r3 = this.mFieldSize;     // Catch: IOException -> L18
        if (r2 >= r3) goto L13;
        this.mMasterInput.skip(r3 - r2);     // Catch: IOException -> L18
    L13:
        this.mFieldSize = -1;     // Catch: IOException -> L18
        int r4 = this.mMasterInput.readInt();     // Catch: IOException -> L18
        this.mCount = 0;     // Catch: IOException -> L18
        int r6 = r4 & 65535;     // Catch: IOException -> L18
        if (r6 != 65535) goto L16;
        r6 = this.mMasterInput.readInt();     // Catch: IOException -> L18
    L16:
        this.mFieldId = (r4 >> 16) & 65535;     // Catch: IOException -> L18
        this.mFieldSize = r6;     // Catch: IOException -> L18
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
        int r0 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r0 <= 0) goto L6;
        byte[] r1 = new byte[r0];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r1);     // Catch: IOException -> L8
        return new String(r1, UTF_16);
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
    public void setOutputField(int r3) {
        closeField();
        FieldBuffer r0 = new FieldBuffer(r3, this.mMasterOutput);
        this.mFieldBuffer = r0;
        this.mCurrentOutput = r0.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        this.mIgnoreParcelables = r2;
        return;
    L6:
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r1) {
        this.mCurrentOutput.writeBoolean(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r5) {
        if (r5 == null) goto L7;
        Set<String> r0 = r5.keySet();     // Catch: IOException -> L9
        this.mCurrentOutput.writeInt(r0.size());     // Catch: IOException -> L9
        Iterator<String> r1 = r0.iterator();     // Catch: IOException -> L9
    L5:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L9
        writeString(r2);     // Catch: IOException -> L9
        writeObject(r5.get(r2));     // Catch: IOException -> L9
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
    public void writeByteArray(byte[] r3) {
        if (r3 == null) goto L4;
        this.mCurrentOutput.writeInt(r3.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r3);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r2, int r3, int r4) {
        if (r2 == null) goto L4;
        this.mCurrentOutput.writeInt(r4);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r2, r3, r4);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r1) {
        this.mCurrentOutput.writeDouble(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r1) {
        this.mCurrentOutput.writeFloat(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r1) {
        this.mCurrentOutput.writeInt(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r1) {
        this.mCurrentOutput.writeLong(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r3) {
        if (r3 == null) goto L4;
        byte[] r4 = r3.getBytes(UTF_16);     // Catch: IOException -> L6
        this.mCurrentOutput.writeInt(r4.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r4);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r3) {
        IInterface r4 = (IInterface) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.memorydata.plugin");
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
}
