package androidx.versionedparcelable;

import ai.j0;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.room.jarjarred.org.antlr.runtime.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable r5) {
            super(r5);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> r5, ArrayMap<String, Method> r10, ArrayMap<String, Class> r11) {
        this.mReadCache = r5;
        this.mWriteCache = r10;
        this.mParcelizerCache = r11;
    }

    private Exception createException(int r5, String r10) {
        switch(r5) {
            case -9: goto L20;
            case -8: goto L4;
            case -7: goto L18;
            case -6: goto L16;
            case -5: goto L14;
            case -4: goto L12;
            case -3: goto L10;
            case -2: goto L8;
            case -1: goto L6;
            default: goto L4;
        };
    L4:
        return new RuntimeException("Unknown exception code: " + r5 + " msg " + r10);
    L6:
        return new SecurityException(r10);
    L8:
        return new BadParcelableException(r10);
    L10:
        return new IllegalArgumentException(r10);
    L12:
        return new NullPointerException(r10);
    L14:
        return new IllegalStateException(r10);
    L16:
        return new NetworkOnMainThreadException();
    L18:
        return new UnsupportedOperationException(r10);
    L20:
        return (Exception) readParcelable();
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> r5) throws ClassNotFoundException {
        Class r10 = this.mParcelizerCache.get(r5.getName());
        if (r10 != null) goto L6;
        Class<?> r11 = Class.forName(a.q(r5.getPackage().getName(), ".", r5.getSimpleName(), "Parcelizer"), false, r5.getClassLoader());
        this.mParcelizerCache.put(r5.getName(), r11);
        return r11;
    L6:
        return r10;
    }

    private Method getReadMethod(String r5) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method r10 = this.mReadCache.get(r5);
        if (r10 != null) goto L6;
        System.currentTimeMillis();
        Method r11 = Class.forName(r5, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.mReadCache.put(r5, r11);
        return r11;
    L6:
        return r10;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable r5) {
    L3:
        if (r5.getCause() == null) goto L5;
        r5 = r5.getCause();
        goto L3
    L5:
        return r5;
    }

    private <T> int getType(T r5) {
        if ((r5 instanceof String) == false) goto L7;
        return 4;
    L7:
        if ((r5 instanceof Parcelable) == false) goto L11;
        return 2;
    L11:
        if ((r5 instanceof VersionedParcelable) == false) goto L15;
        return 1;
    L15:
        if ((r5 instanceof Serializable) == false) goto L19;
        return 3;
    L19:
        if ((r5 instanceof IBinder) == false) goto L23;
        return 5;
    L23:
        if ((r5 instanceof Integer) == false) goto L27;
        return 7;
    L27:
        if ((r5 instanceof Float) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r5.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    private Method getWriteMethod(Class r5) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method r10 = this.mWriteCache.get(r5.getName());
        if (r10 != null) goto L6;
        Class r11 = findParcelClass(r5);
        System.currentTimeMillis();
        Method r12 = r11.getDeclaredMethod("write", new Class[]{r5, VersionedParcel.class});
        this.mWriteCache.put(r5.getName(), r12);
        return r12;
    L6:
        return r10;
    }

    private <T, S extends Collection<T>> S readCollection(S r5) {
        int r10 = readInt();
        if (r10 >= 0) goto L5;
        return null;
    L5:
        if (r10 == 0) goto L30;
        int r11 = readInt();
        if (r10 >= 0) goto L10;
        return null;
    L10:
        if (r11 != 1) goto L12;
    L28:
        if (r10 <= 0) goto L30;
        r5.add(readVersionedParcelable());
        r10 = r10 - 1;
        goto L28
    L12:
        if (r11 != 2) goto L14;
    L26:
        if (r10 <= 0) goto L30;
        r5.add(readParcelable());
        r10 = r10 - 1;
        goto L26
    L14:
        if (r11 != 3) goto L16;
    L24:
        if (r10 <= 0) goto L30;
        r5.add(readSerializable());
        r10 = r10 - 1;
        goto L24
    L16:
        if (r11 != 4) goto L18;
    L22:
        if (r10 <= 0) goto L30;
        r5.add(readString());
        r10 = r10 - 1;
        goto L22
    L18:
        if (r11 != 5) goto L30;
    L20:
        if (r10 <= 0) goto L30;
        r5.add(readStrongBinder());
        r10 = r10 - 1;
    L30:
        return r5;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> r5, int r10) {
        setOutputField(r10);
        writeCollection(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable r5) {
        writeString(findParcelClass(r5.getClass()).getName());
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r5.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (T[]) readArray(r5);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readBundle();
    }

    public byte readByte(byte r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readByteArray();
    }

    public char[] readCharArray(char[] r5, int r10) {
        if (readField(r10) == true) goto L5;
        return r5;
    L5:
        int r11 = readInt();
        if (r11 >= 0) goto L9;
        return null;
    L9:
        char[] r12 = new char[r11];
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L12;
        r12[r13] = (char) readInt();
        r13 = r13 + 1;
        goto L10
    L12:
        return r12;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readDouble();
    }

    public double[] readDoubleArray(double[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readDoubleArray();
    }

    public Exception readException(Exception r5, int r10) {
        if (readField(r10) == true) goto L5;
        return r5;
    L5:
        int r11 = readExceptionCode();
        if (r11 != 0) goto L8;
        return r5;
    L8:
        return readException(r11, readString());
    }

    public abstract boolean readField(int r5);

    public abstract float readFloat();

    public float readFloat(float r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readFloat();
    }

    public float[] readFloatArray(float[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String r5, VersionedParcel r10) {
        return (T) getReadMethod(r5).invoke(null, new Object[]{r10});
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L10:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L6:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L8:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L21;
        throw ((RuntimeException) e.getCause());
    L21:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public abstract int readInt();

    public int readInt(int r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readInt();
    }

    public int[] readIntArray(int[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readIntArray();
    }

    public <T> List<T> readList(List<T> r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readLong();
    }

    public long[] readLongArray(long[] r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> r5, int r10) {
        if (readField(r10) == true) goto L5;
        return r5;
    L5:
        int r11 = readInt();
        if (r11 >= 0) goto L9;
        return null;
    L9:
        ArrayMap r12 = new ArrayMap();
        if (r11 != 0) goto L12;
        return r12;
    L12:
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        readCollection(r13);
        readCollection(r14);
        int r15 = 0;
    L13:
        if (r15 >= r11) goto L15;
        r12.put(r13.get(r15), r14.get(r15));
        r15 = r15 + 1;
        goto L13
    L15:
        return r12;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (T) readParcelable();
    }

    public Serializable readSerializable() {
        String r5 = readString();
        if (r5 != null) goto L6;
        return null;
    L6:
        final ByteArrayInputStream r10 = new ByteArrayInputStream(readByteArray());
        return (Serializable) new AnonymousClass1(this, r10).readObject();
    L11:
        e = move-exception;
        throw new RuntimeException(j0.k("VersionedParcelable encountered IOException reading a Serializable object (name = ", r5, ")"), e);
    L9:
        e = move-exception;
        throw new RuntimeException(j0.k("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", r5, ")"), e);
    }

    public <T> Set<T> readSet(Set<T> r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new Size(readInt(), readInt());
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new SizeF(readFloat(), readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray r5, int r10) {
        if (readField(r10) == true) goto L5;
        return r5;
    L5:
        int r11 = readInt();
        if (r11 >= 0) goto L9;
        return null;
    L9:
        SparseBooleanArray r12 = new SparseBooleanArray(r11);
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L12;
        r12.put(readInt(), readBoolean());
        r13 = r13 + 1;
        goto L10
    L12:
        return r12;
    }

    public abstract String readString();

    public String readString(String r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T r5, int r10) {
        if (readField(r10) == true) goto L6;
        return r5;
    L6:
        return (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int r5);

    public void setSerializationFlags(boolean r5, boolean r10) {
    }

    public <T> void writeArray(T[] r5, int r10) {
        setOutputField(r10);
        writeArray(r5);
    }

    public abstract void writeBoolean(boolean r5);

    public void writeBoolean(boolean r5, int r10) {
        setOutputField(r10);
        writeBoolean(r5);
    }

    public void writeBooleanArray(boolean[] r5, int r10) {
        setOutputField(r10);
        writeBooleanArray(r5);
    }

    public abstract void writeBundle(Bundle r5);

    public void writeBundle(Bundle r5, int r10) {
        setOutputField(r10);
        writeBundle(r5);
    }

    public void writeByte(byte r5, int r10) {
        setOutputField(r10);
        writeInt(r5);
    }

    public abstract void writeByteArray(byte[] r5);

    public void writeByteArray(byte[] r5, int r10) {
        setOutputField(r10);
        writeByteArray(r5);
    }

    public abstract void writeByteArray(byte[] r5, int r10, int r11);

    public void writeCharArray(char[] r5, int r10) {
        setOutputField(r10);
        if (r5 == null) goto L7;
        int r11 = r5.length;
        writeInt(r11);
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        writeInt(r5[r12]);
        r12 = r12 + 1;
        goto L5
    L10:
        return;
    L7:
        writeInt(-1);
    }

    public abstract void writeCharSequence(CharSequence r5);

    public void writeCharSequence(CharSequence r5, int r10) {
        setOutputField(r10);
        writeCharSequence(r5);
    }

    public abstract void writeDouble(double r5);

    public void writeDouble(double r5, int r10) {
        setOutputField(r10);
        writeDouble(r5);
    }

    public void writeDoubleArray(double[] r5, int r10) {
        setOutputField(r10);
        writeDoubleArray(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception r5, int r10) {
        setOutputField(r10);
        if (r5 != 0) goto L7;
        writeNoException();
        return;
    L7:
        if ((r5 instanceof Parcelable) == false) goto L12;
        if (r5.getClass().getClassLoader() != Parcelable.class.getClassLoader()) goto L12;
        int r11 = -9;
    L33:
        writeInt(r11);
        if (r11 == 0) goto L36;
        writeString(r5.getMessage());
        if (r11 != (-9)) goto L46;
        writeParcelable((Parcelable) r5);
        return;
    L46:
        return;
    L36:
        if ((r5 instanceof RuntimeException) == false) goto L40;
        throw ((RuntimeException) r5);
    L40:
        throw new RuntimeException(r5);
    L12:
        if ((r5 instanceof SecurityException) == false) goto L15;
        r11 = -1;
        goto L33
    L15:
        if ((r5 instanceof BadParcelableException) == false) goto L18;
        r11 = -2;
        goto L33
    L18:
        if ((r5 instanceof IllegalArgumentException) == false) goto L21;
        r11 = -3;
        goto L33
    L21:
        if ((r5 instanceof NullPointerException) == false) goto L24;
        r11 = -4;
        goto L33
    L24:
        if ((r5 instanceof IllegalStateException) == false) goto L27;
        r11 = -5;
        goto L33
    L27:
        if ((r5 instanceof NetworkOnMainThreadException) == false) goto L30;
        r11 = -6;
        goto L33
    L30:
        if ((r5 instanceof UnsupportedOperationException) == false) goto L32;
        r11 = -7;
        goto L33
    L32:
        r11 = 0;
        goto L33
    }

    public abstract void writeFloat(float r5);

    public void writeFloat(float r5, int r10) {
        setOutputField(r10);
        writeFloat(r5);
    }

    public void writeFloatArray(float[] r5, int r10) {
        setOutputField(r10);
        writeFloatArray(r5);
    }

    public abstract void writeInt(int r5);

    public void writeInt(int r5, int r10) {
        setOutputField(r10);
        writeInt(r5);
    }

    public void writeIntArray(int[] r5, int r10) {
        setOutputField(r10);
        writeIntArray(r5);
    }

    public <T> void writeList(List<T> r5, int r10) {
        writeCollection(r5, r10);
    }

    public abstract void writeLong(long r5);

    public void writeLong(long r5, int r10) {
        setOutputField(r10);
        writeLong(r5);
    }

    public void writeLongArray(long[] r5, int r10) {
        setOutputField(r10);
        writeLongArray(r5);
    }

    public <K, V> void writeMap(Map<K, V> r5, int r10) {
        setOutputField(r10);
        if (r5 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r11 = r5.size();
        writeInt(r11);
        if (r11 != 0) goto L9;
        return;
    L9:
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<Map.Entry<K, V>> r14 = r5.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry<K, V> r15 = r14.next();
        r12.add(r15.getKey());
        r13.add(r15.getValue());
        goto L11
    L13:
        writeCollection(r12);
        writeCollection(r13);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable r5);

    public void writeParcelable(Parcelable r5, int r10) {
        setOutputField(r10);
        writeParcelable(r5);
    }

    public void writeSerializable(Serializable r5, int r10) {
        setOutputField(r10);
        writeSerializable(r5);
    }

    public <T> void writeSet(Set<T> r5, int r10) {
        writeCollection(r5, r10);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size r5, int r10) {
        setOutputField(r10);
        if (r5 == null) goto L5;
        boolean r11 = true;
    L6:
        writeBoolean(r11);
        if (r5 == null) goto L10;
        writeInt(r5.getWidth());
        writeInt(r5.getHeight());
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF r5, int r10) {
        setOutputField(r10);
        if (r5 == null) goto L5;
        boolean r11 = true;
    L6:
        writeBoolean(r11);
        if (r5 == null) goto L10;
        writeFloat(r5.getWidth());
        writeFloat(r5.getHeight());
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void writeSparseBooleanArray(SparseBooleanArray r5, int r10) {
        setOutputField(r10);
        if (r5 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r11 = r5.size();
        writeInt(r11);
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        writeInt(r5.keyAt(r12));
        writeBoolean(r5.valueAt(r12));
        r12 = r12 + 1;
        goto L7
    }

    public abstract void writeString(String r5);

    public void writeString(String r5, int r10) {
        setOutputField(r10);
        writeString(r5);
    }

    public abstract void writeStrongBinder(IBinder r5);

    public void writeStrongBinder(IBinder r5, int r10) {
        setOutputField(r10);
        writeStrongBinder(r5);
    }

    public abstract void writeStrongInterface(IInterface r5);

    public void writeStrongInterface(IInterface r5, int r10) {
        setOutputField(r10);
        writeStrongInterface(r5);
    }

    public <T extends VersionedParcelable> void writeToParcel(T r5, VersionedParcel r10) {
        getWriteMethod(r5.getClass()).invoke(null, new Object[]{r5, r10});     // Catch: ClassNotFoundException -> L4 NoSuchMethodException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L10:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L6:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L8:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L21;
        throw ((RuntimeException) e.getCause());
    L21:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public void writeVersionedParcelable(VersionedParcelable r5, int r10) {
        setOutputField(r10);
        writeVersionedParcelable(r5);
    }

    private <T> void writeCollection(Collection<T> r5) {
        if (r5 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r10 = r5.size();
        writeInt(r10);
        if (r10 <= 0) goto L38;
        int r11 = getType(r5.iterator().next());
        writeInt(r11);
        switch(r11) {
            case 1: goto L34;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L46;
            case 7: goto L14;
            case 8: goto L10;
            default: goto L46;
        };
    L10:
        Iterator<T> r12 = r5.iterator();
    L12:
        if (r12.hasNext() == false) goto L47;
        writeFloat(((Float) r12.next()).floatValue());
        goto L12
    L47:
        return;
    L14:
        Iterator<T> r13 = r5.iterator();
    L16:
        if (r13.hasNext() == false) goto L48;
        writeInt(((Integer) r13.next()).intValue());
        goto L16
    L48:
        return;
    L18:
        Iterator<T> r14 = r5.iterator();
    L20:
        if (r14.hasNext() == false) goto L49;
        writeStrongBinder((IBinder) r14.next());
        goto L20
    L49:
        return;
    L22:
        Iterator<T> r15 = r5.iterator();
    L24:
        if (r15.hasNext() == false) goto L50;
        writeString((String) r15.next());
        goto L24
    L50:
        return;
    L26:
        Iterator<T> r16 = r5.iterator();
    L28:
        if (r16.hasNext() == false) goto L51;
        writeSerializable((Serializable) r16.next());
        goto L28
    L51:
        return;
    L30:
        Iterator<T> r17 = r5.iterator();
    L32:
        if (r17.hasNext() == false) goto L52;
        writeParcelable((Parcelable) r17.next());
        goto L32
    L52:
        return;
    L34:
        Iterator<T> r18 = r5.iterator();
    L36:
        if (r18.hasNext() == false) goto L53;
        writeVersionedParcelable((VersionedParcelable) r18.next());
        goto L36
    L53:
        return;
    L46:
        return;
    }

    private void writeSerializable(Serializable r5) {
        if (r5 != null) goto L5;
        writeString(null);
        return;
    L5:
        String r10 = r5.getClass().getName();
        writeString(r10);
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = new ObjectOutputStream(r11);     // Catch: IOException -> L8
        r12.writeObject(r5);     // Catch: IOException -> L8
        r12.close();     // Catch: IOException -> L8
        writeByteArray(r11.toByteArray());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(j0.k("VersionedParcelable encountered IOException writing serializable object (name = ", r10, ")"), e);
    }

    public <T> T[] readArray(T[] r5) {
        int r10 = readInt();
        if (r10 >= 0) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList(r10);
        if (r10 == 0) goto L32;
        int r12 = readInt();
        if (r10 >= 0) goto L11;
        return null;
    L11:
        if (r12 != 1) goto L13;
    L29:
        if (r10 <= 0) goto L32;
        r11.add(readVersionedParcelable());
        r10 = r10 - 1;
        goto L29
    L13:
        if (r12 != 2) goto L15;
    L27:
        if (r10 <= 0) goto L32;
        r11.add(readParcelable());
        r10 = r10 - 1;
        goto L27
    L15:
        if (r12 != 3) goto L17;
    L25:
        if (r10 <= 0) goto L32;
        r11.add(readSerializable());
        r10 = r10 - 1;
        goto L25
    L17:
        if (r12 != 4) goto L19;
    L23:
        if (r10 <= 0) goto L32;
        r11.add(readString());
        r10 = r10 - 1;
        goto L23
    L19:
        if (r12 != 5) goto L32;
    L21:
        if (r10 <= 0) goto L32;
        r11.add(readStrongBinder());
        r10 = r10 - 1;
    L32:
        return (T[]) r11.toArray(r5);
    }

    public boolean[] readBooleanArray() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        boolean[] r10 = new boolean[r5];
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L13;
        if (readInt() == 0) goto L11;
        boolean r12 = true;
    L12:
        r10[r11] = r12;
        r11 = r11 + 1;
        goto L7
    L11:
        r12 = false;
        goto L12
    L13:
        return r10;
    }

    public double[] readDoubleArray() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        double[] r10 = new double[r5];
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L9;
        r10[r11] = readDouble();
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public float[] readFloatArray() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        float[] r10 = new float[r5];
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L9;
        r10[r11] = readFloat();
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public int[] readIntArray() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        int[] r10 = new int[r5];
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L9;
        r10[r11] = readInt();
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public long[] readLongArray() {
        int r5 = readInt();
        if (r5 >= 0) goto L6;
        return null;
    L6:
        long[] r10 = new long[r5];
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L9;
        r10[r11] = readLong();
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String r5 = readString();
        if (r5 != null) goto L7;
        return null;
    L7:
        return (T) readFromParcel(r5, createSubParcel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] r5) {
        if (r5 != 0) goto L5;
        writeInt(-1);
        return;
    L5:
        int r10 = r5.length;
        writeInt(r10);
        if (r10 <= 0) goto L28;
        int r11 = 0;
        int r12 = getType(r5[0]);
        writeInt(r12);
        if (r12 != 1) goto L10;
    L26:
        if (r11 >= r10) goto L39;
        writeVersionedParcelable((VersionedParcelable) r5[r11]);
        r11 = r11 + 1;
        goto L26
    L39:
        return;
    L10:
        if (r12 != 2) goto L12;
    L24:
        if (r11 >= r10) goto L38;
        writeParcelable((Parcelable) r5[r11]);
        r11 = r11 + 1;
        goto L24
    L38:
        return;
    L12:
        if (r12 != 3) goto L14;
    L22:
        if (r11 >= r10) goto L37;
        writeSerializable((Serializable) r5[r11]);
        r11 = r11 + 1;
        goto L22
    L37:
        return;
    L14:
        if (r12 != 4) goto L16;
    L20:
        if (r11 >= r10) goto L36;
        writeString((String) r5[r11]);
        r11 = r11 + 1;
        goto L20
    L36:
        return;
    L16:
        if (r12 != 5) goto L34;
    L18:
        if (r11 >= r10) goto L35;
        writeStrongBinder((IBinder) r5[r11]);
        r11 = r11 + 1;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    public void writeBooleanArray(boolean[] r5) {
        if (r5 == null) goto L6;
        int r10 = r5.length;
        writeInt(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        writeInt(r5[r11] ? 1 : 0);
        r11 = r11 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeByteArray(byte[] r5, int r10, int r11, int r12) {
        setOutputField(r12);
        writeByteArray(r5, r10, r11);
    }

    public void writeDoubleArray(double[] r5) {
        if (r5 == null) goto L6;
        int r10 = r5.length;
        writeInt(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        writeDouble(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeFloatArray(float[] r5) {
        if (r5 == null) goto L6;
        int r10 = r5.length;
        writeInt(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        writeFloat(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeIntArray(int[] r5) {
        if (r5 == null) goto L6;
        int r10 = r5.length;
        writeInt(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        writeInt(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeLongArray(long[] r5) {
        if (r5 == null) goto L6;
        int r10 = r5.length;
        writeInt(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        writeLong(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeVersionedParcelable(VersionedParcelable r5) {
        if (r5 != null) goto L5;
        writeString(null);
        return;
    L5:
        writeVersionedParcelableCreator(r5);
        VersionedParcel r10 = createSubParcel();
        writeToParcel(r5, r10);
        r10.closeField();
    }

    private Exception readException(int r5, String r10) {
        return createException(r5, r10);
    }
}
