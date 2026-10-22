package androidx.versionedparcelable;

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
        public ParcelException(Throwable r10) {
            super(r10);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> r10, ArrayMap<String, Method> r11, ArrayMap<String, Class> r12) {
        this.mReadCache = r10;
        this.mWriteCache = r11;
        this.mParcelizerCache = r12;
    }

    private Exception createException(int r10, String r11) {
        switch(r10) {
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
        return new RuntimeException("Unknown exception code: " + r10 + " msg " + r11);
    L6:
        return new SecurityException(r11);
    L8:
        return new BadParcelableException(r11);
    L10:
        return new IllegalArgumentException(r11);
    L12:
        return new NullPointerException(r11);
    L14:
        return new IllegalStateException(r11);
    L16:
        return new NetworkOnMainThreadException();
    L18:
        return new UnsupportedOperationException(r11);
    L20:
        return (Exception) readParcelable();
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> r10) {
        Class r11 = this.mParcelizerCache.get(r10.getName());
        if (r11 != null) goto L6;
        Class<?> r12 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r10.getPackage().getName(), r10.getSimpleName()}), false, r10.getClassLoader());
        this.mParcelizerCache.put(r10.getName(), r12);
        return r12;
    L6:
        return r11;
    }

    private Method getReadMethod(String r10) {
        Method r11 = this.mReadCache.get(r10);
        if (r11 != null) goto L6;
        System.currentTimeMillis();
        Method r12 = Class.forName(r10, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.mReadCache.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable r10) {
    L3:
        if (r10.getCause() == null) goto L5;
        r10 = r10.getCause();
        goto L3
    L5:
        return r10;
    }

    private <T> int getType(T r10) {
        if ((r10 instanceof String) == false) goto L7;
        return 4;
    L7:
        if ((r10 instanceof Parcelable) == false) goto L11;
        return 2;
    L11:
        if ((r10 instanceof VersionedParcelable) == false) goto L15;
        return 1;
    L15:
        if ((r10 instanceof Serializable) == false) goto L19;
        return 3;
    L19:
        if ((r10 instanceof IBinder) == false) goto L23;
        return 5;
    L23:
        if ((r10 instanceof Integer) == false) goto L27;
        return 7;
    L27:
        if ((r10 instanceof Float) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r10.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class r10) {
        Method r11 = this.mWriteCache.get(r10.getName());
        if (r11 != null) goto L6;
        Class r12 = findParcelClass(r10);
        System.currentTimeMillis();
        Method r13 = r12.getDeclaredMethod("write", new Class[]{r10, VersionedParcel.class});
        this.mWriteCache.put(r10.getName(), r13);
        return r13;
    L6:
        return r11;
    }

    private <T, S extends Collection<T>> S readCollection(S r10) {
        int r11 = readInt();
        if (r11 >= 0) goto L5;
        return null;
    L5:
        if (r11 == 0) goto L30;
        int r12 = readInt();
        if (r11 >= 0) goto L10;
        return null;
    L10:
        if (r12 != 1) goto L12;
    L28:
        if (r11 <= 0) goto L30;
        r10.add(readVersionedParcelable());
        r11 = r11 - 1;
        goto L28
    L12:
        if (r12 != 2) goto L14;
    L26:
        if (r11 <= 0) goto L30;
        r10.add(readParcelable());
        r11 = r11 - 1;
        goto L26
    L14:
        if (r12 != 3) goto L16;
    L24:
        if (r11 <= 0) goto L30;
        r10.add(readSerializable());
        r11 = r11 - 1;
        goto L24
    L16:
        if (r12 != 4) goto L18;
    L22:
        if (r11 <= 0) goto L30;
        r10.add(readString());
        r11 = r11 - 1;
        goto L22
    L18:
        if (r12 != 5) goto L30;
    L20:
        if (r11 <= 0) goto L30;
        r10.add(readStrongBinder());
        r11 = r11 - 1;
    L30:
        return r10;
    }

    private Exception readException(int r10, String r11) {
        return createException(r10, r11);
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> r10) {
        if (r10 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r11 = r10.size();
        writeInt(r11);
        if (r11 <= 0) goto L38;
        int r12 = getType(r10.iterator().next());
        writeInt(r12);
        switch(r12) {
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
        Iterator<T> r13 = r10.iterator();
    L12:
        if (r13.hasNext() == false) goto L47;
        writeFloat(((Float) r13.next()).floatValue());
        goto L12
    L47:
        return;
    L14:
        Iterator<T> r14 = r10.iterator();
    L16:
        if (r14.hasNext() == false) goto L48;
        writeInt(((Integer) r14.next()).intValue());
        goto L16
    L48:
        return;
    L18:
        Iterator<T> r15 = r10.iterator();
    L20:
        if (r15.hasNext() == false) goto L49;
        writeStrongBinder((IBinder) r15.next());
        goto L20
    L49:
        return;
    L22:
        Iterator<T> r16 = r10.iterator();
    L24:
        if (r16.hasNext() == false) goto L50;
        writeString((String) r16.next());
        goto L24
    L50:
        return;
    L26:
        Iterator<T> r17 = r10.iterator();
    L28:
        if (r17.hasNext() == false) goto L51;
        writeSerializable((Serializable) r17.next());
        goto L28
    L51:
        return;
    L30:
        Iterator<T> r18 = r10.iterator();
    L32:
        if (r18.hasNext() == false) goto L52;
        writeParcelable((Parcelable) r18.next());
        goto L32
    L52:
        return;
    L34:
        Iterator<T> r19 = r10.iterator();
    L36:
        if (r19.hasNext() == false) goto L53;
        writeVersionedParcelable((VersionedParcelable) r19.next());
        goto L36
    L53:
        return;
    L46:
        return;
    }

    private <T> void writeCollection(Collection<T> r10, int r11) {
        setOutputField(r11);
        writeCollection(r10);
    }

    private void writeSerializable(Serializable r10) {
        if (r10 != null) goto L5;
        writeString(null);
        return;
    L5:
        String r11 = r10.getClass().getName();
        writeString(r11);
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        ObjectOutputStream r13 = new ObjectOutputStream(r12);     // Catch: IOException -> L8
        r13.writeObject(r10);     // Catch: IOException -> L8
        r13.close();     // Catch: IOException -> L8
        writeByteArray(r12.toByteArray());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + r11 + ")", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable r10) {
        writeString(findParcelClass(r10.getClass()).getName());
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r10.getClass().getSimpleName() + " does not have a Parcelizer", e);
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    protected <T> T[] readArray(T[] r10) {
        int r11 = readInt();
        if (r11 >= 0) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList(r11);
        if (r11 == 0) goto L32;
        int r13 = readInt();
        if (r11 >= 0) goto L11;
        return null;
    L11:
        if (r13 != 1) goto L13;
    L29:
        if (r11 <= 0) goto L32;
        r12.add(readVersionedParcelable());
        r11 = r11 - 1;
        goto L29
    L13:
        if (r13 != 2) goto L15;
    L27:
        if (r11 <= 0) goto L32;
        r12.add(readParcelable());
        r11 = r11 - 1;
        goto L27
    L15:
        if (r13 != 3) goto L17;
    L25:
        if (r11 <= 0) goto L32;
        r12.add(readSerializable());
        r11 = r11 - 1;
        goto L25
    L17:
        if (r13 != 4) goto L19;
    L23:
        if (r11 <= 0) goto L32;
        r12.add(readString());
        r11 = r11 - 1;
        goto L23
    L19:
        if (r13 != 5) goto L32;
    L21:
        if (r11 <= 0) goto L32;
        r12.add(readStrongBinder());
        r11 = r11 - 1;
    L32:
        return (T[]) r12.toArray(r10);
    }

    public <T> T[] readArray(T[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (T[]) readArray(r10);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readBoolean();
    }

    protected boolean[] readBooleanArray() {
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        boolean[] r11 = new boolean[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L13;
        if (readInt() == 0) goto L11;
        boolean r13 = true;
    L12:
        r11[r12] = r13;
        r12 = r12 + 1;
        goto L7
    L11:
        r13 = false;
        goto L12
    L13:
        return r11;
    }

    public boolean[] readBooleanArray(boolean[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readBundle();
    }

    public byte readByte(byte r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (byte) (readInt() & 255);
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readByteArray();
    }

    public char[] readCharArray(char[] r10, int r11) {
        if (readField(r11) == true) goto L5;
        return r10;
    L5:
        int r12 = readInt();
        if (r12 >= 0) goto L9;
        return null;
    L9:
        char[] r13 = new char[r12];
        int r14 = 0;
    L10:
        if (r14 >= r12) goto L12;
        r13[r14] = (char) readInt();
        r14 = r14 + 1;
        goto L10
    L12:
        return r13;
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readCharSequence();
    }

    protected abstract double readDouble();

    public double readDouble(double r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readDouble();
    }

    protected double[] readDoubleArray() {
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        double[] r11 = new double[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r11[r12] = readDouble();
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public double[] readDoubleArray(double[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readDoubleArray();
    }

    public Exception readException(Exception r10, int r11) {
        if (readField(r11) == true) goto L5;
        return r10;
    L5:
        int r12 = readExceptionCode();
        if (r12 != 0) goto L8;
        return r10;
    L8:
        return readException(r12, readString());
    }

    protected abstract boolean readField(int r10);

    protected abstract float readFloat();

    public float readFloat(float r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readFloat();
    }

    protected float[] readFloatArray() {
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        float[] r11 = new float[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r11[r12] = readFloat();
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public float[] readFloatArray(float[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readFloatArray();
    }

    protected <T extends VersionedParcelable> T readFromParcel(String r10, VersionedParcel r11) {
        return (T) getReadMethod(r10).invoke(null, new Object[]{r11});
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    protected abstract int readInt();

    public int readInt(int r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readInt();
    }

    protected int[] readIntArray() {
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        int[] r11 = new int[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r11[r12] = readInt();
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public int[] readIntArray(int[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readIntArray();
    }

    public <T> List<T> readList(List<T> r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (List) readCollection(new ArrayList());
    }

    protected abstract long readLong();

    public long readLong(long r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readLong();
    }

    protected long[] readLongArray() {
        int r10 = readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        long[] r11 = new long[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r11[r12] = readLong();
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public long[] readLongArray(long[] r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> r10, int r11) {
        if (readField(r11) == true) goto L5;
        return r10;
    L5:
        int r12 = readInt();
        if (r12 >= 0) goto L9;
        return null;
    L9:
        ArrayMap r13 = new ArrayMap();
        if (r12 != 0) goto L12;
        return r13;
    L12:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        readCollection(r14);
        readCollection(r15);
        int r16 = 0;
    L13:
        if (r16 >= r12) goto L15;
        r13.put(r14.get(r16), r15.get(r16));
        r16 = r16 + 1;
        goto L13
    L15:
        return r13;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (T) readParcelable();
    }

    protected Serializable readSerializable() {
        String r10 = readString();
        if (r10 != null) goto L6;
        return null;
    L6:
        final ByteArrayInputStream r11 = new ByteArrayInputStream(readByteArray());
        return (Serializable) new AnonymousClass1(this, r11).readObject();
    L12:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + r10 + ")", e);
    L9:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + r10 + ")", e);
    }

    public <T> Set<T> readSet(Set<T> r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new Size(readInt(), readInt());
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new SizeF(readFloat(), readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray r10, int r11) {
        if (readField(r11) == true) goto L5;
        return r10;
    L5:
        int r12 = readInt();
        if (r12 >= 0) goto L9;
        return null;
    L9:
        SparseBooleanArray r13 = new SparseBooleanArray(r12);
        int r14 = 0;
    L10:
        if (r14 >= r12) goto L12;
        r13.put(readInt(), readBoolean());
        r14 = r14 + 1;
        goto L10
    L12:
        return r13;
    }

    protected abstract String readString();

    public String readString(String r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return readStrongBinder();
    }

    protected <T extends VersionedParcelable> T readVersionedParcelable() {
        String r10 = readString();
        if (r10 != null) goto L7;
        return null;
    L7:
        return (T) readFromParcel(r10, createSubParcel());
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T r10, int r11) {
        if (readField(r11) == true) goto L6;
        return r10;
    L6:
        return (T) readVersionedParcelable();
    }

    protected abstract void setOutputField(int r10);

    public void setSerializationFlags(boolean r10, boolean r11) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void writeArray(T[] r10) {
        if (r10 != 0) goto L5;
        writeInt(-1);
        return;
    L5:
        int r11 = r10.length;
        writeInt(r11);
        if (r11 <= 0) goto L28;
        int r12 = 0;
        int r13 = getType(r10[0]);
        writeInt(r13);
        if (r13 != 1) goto L10;
    L26:
        if (r12 >= r11) goto L39;
        writeVersionedParcelable((VersionedParcelable) r10[r12]);
        r12 = r12 + 1;
        goto L26
    L39:
        return;
    L10:
        if (r13 != 2) goto L12;
    L24:
        if (r12 >= r11) goto L38;
        writeParcelable((Parcelable) r10[r12]);
        r12 = r12 + 1;
        goto L24
    L38:
        return;
    L12:
        if (r13 != 3) goto L14;
    L22:
        if (r12 >= r11) goto L37;
        writeSerializable((Serializable) r10[r12]);
        r12 = r12 + 1;
        goto L22
    L37:
        return;
    L14:
        if (r13 != 4) goto L16;
    L20:
        if (r12 >= r11) goto L36;
        writeString((String) r10[r12]);
        r12 = r12 + 1;
        goto L20
    L36:
        return;
    L16:
        if (r13 != 5) goto L34;
    L18:
        if (r12 >= r11) goto L35;
        writeStrongBinder((IBinder) r10[r12]);
        r12 = r12 + 1;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    public <T> void writeArray(T[] r10, int r11) {
        setOutputField(r11);
        writeArray(r10);
    }

    protected abstract void writeBoolean(boolean r10);

    public void writeBoolean(boolean r10, int r11) {
        setOutputField(r11);
        writeBoolean(r10);
    }

    protected void writeBooleanArray(boolean[] r10) {
        if (r10 == null) goto L6;
        int r11 = r10.length;
        writeInt(r11);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        writeInt(r10[r12] ? 1 : 0);
        r12 = r12 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeBooleanArray(boolean[] r10, int r11) {
        setOutputField(r11);
        writeBooleanArray(r10);
    }

    protected abstract void writeBundle(Bundle r10);

    public void writeBundle(Bundle r10, int r11) {
        setOutputField(r11);
        writeBundle(r10);
    }

    public void writeByte(byte r10, int r11) {
        setOutputField(r11);
        writeInt(r10);
    }

    protected abstract void writeByteArray(byte[] r10);

    public void writeByteArray(byte[] r10, int r11) {
        setOutputField(r11);
        writeByteArray(r10);
    }

    protected abstract void writeByteArray(byte[] r10, int r11, int r12);

    public void writeByteArray(byte[] r10, int r11, int r12, int r13) {
        setOutputField(r13);
        writeByteArray(r10, r11, r12);
    }

    public void writeCharArray(char[] r10, int r11) {
        setOutputField(r11);
        if (r10 == null) goto L7;
        int r12 = r10.length;
        writeInt(r12);
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        writeInt(r10[r13]);
        r13 = r13 + 1;
        goto L5
    L10:
        return;
    L7:
        writeInt(-1);
    }

    protected abstract void writeCharSequence(CharSequence r10);

    public void writeCharSequence(CharSequence r10, int r11) {
        setOutputField(r11);
        writeCharSequence(r10);
    }

    protected abstract void writeDouble(double r10);

    public void writeDouble(double r10, int r11) {
        setOutputField(r11);
        writeDouble(r10);
    }

    protected void writeDoubleArray(double[] r10) {
        if (r10 == null) goto L6;
        int r11 = r10.length;
        writeInt(r11);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        writeDouble(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeDoubleArray(double[] r10, int r11) {
        setOutputField(r11);
        writeDoubleArray(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception r10, int r11) {
        setOutputField(r11);
        if (r10 != 0) goto L6;
        writeNoException();
        return;
    L6:
        int r12 = 0;
        if ((r10 instanceof Parcelable) == false) goto L12;
        if (r10.getClass().getClassLoader() != Parcelable.class.getClassLoader()) goto L12;
        r12 = -9;
    L32:
        writeInt(r12);
        if (r12 == 0) goto L35;
        writeString(r10.getMessage());
        if (r12 != (-9)) goto L45;
        writeParcelable((Parcelable) r10);
        return;
    L45:
        return;
    L35:
        if ((r10 instanceof RuntimeException) == false) goto L39;
        throw ((RuntimeException) r10);
    L39:
        throw new RuntimeException(r10);
    L12:
        if ((r10 instanceof SecurityException) == false) goto L15;
        r12 = -1;
        goto L32
    L15:
        if ((r10 instanceof BadParcelableException) == false) goto L18;
        r12 = -2;
        goto L32
    L18:
        if ((r10 instanceof IllegalArgumentException) == false) goto L21;
        r12 = -3;
        goto L32
    L21:
        if ((r10 instanceof NullPointerException) == false) goto L24;
        r12 = -4;
        goto L32
    L24:
        if ((r10 instanceof IllegalStateException) == false) goto L27;
        r12 = -5;
        goto L32
    L27:
        if ((r10 instanceof NetworkOnMainThreadException) == false) goto L30;
        r12 = -6;
        goto L32
    L30:
        if ((r10 instanceof UnsupportedOperationException) == false) goto L32;
        r12 = -7;
        goto L32
    }

    protected abstract void writeFloat(float r10);

    public void writeFloat(float r10, int r11) {
        setOutputField(r11);
        writeFloat(r10);
    }

    protected void writeFloatArray(float[] r10) {
        if (r10 == null) goto L6;
        int r11 = r10.length;
        writeInt(r11);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        writeFloat(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeFloatArray(float[] r10, int r11) {
        setOutputField(r11);
        writeFloatArray(r10);
    }

    protected abstract void writeInt(int r10);

    public void writeInt(int r10, int r11) {
        setOutputField(r11);
        writeInt(r10);
    }

    protected void writeIntArray(int[] r10) {
        if (r10 == null) goto L6;
        int r11 = r10.length;
        writeInt(r11);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        writeInt(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeIntArray(int[] r10, int r11) {
        setOutputField(r11);
        writeIntArray(r10);
    }

    public <T> void writeList(List<T> r10, int r11) {
        writeCollection(r10, r11);
    }

    protected abstract void writeLong(long r10);

    public void writeLong(long r10, int r11) {
        setOutputField(r11);
        writeLong(r10);
    }

    protected void writeLongArray(long[] r10) {
        if (r10 == null) goto L6;
        int r11 = r10.length;
        writeInt(r11);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        writeLong(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeLongArray(long[] r10, int r11) {
        setOutputField(r11);
        writeLongArray(r10);
    }

    public <K, V> void writeMap(Map<K, V> r10, int r11) {
        setOutputField(r11);
        if (r10 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r12 = r10.size();
        writeInt(r12);
        if (r12 != 0) goto L9;
        return;
    L9:
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<Map.Entry<K, V>> r15 = r10.entrySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L13;
        Map.Entry<K, V> r16 = r15.next();
        r13.add(r16.getKey());
        r14.add(r16.getValue());
        goto L11
    L13:
        writeCollection(r13);
        writeCollection(r14);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable r10);

    public void writeParcelable(Parcelable r10, int r11) {
        setOutputField(r11);
        writeParcelable(r10);
    }

    public void writeSerializable(Serializable r10, int r11) {
        setOutputField(r11);
        writeSerializable(r10);
    }

    public <T> void writeSet(Set<T> r10, int r11) {
        writeCollection(r10, r11);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size r10, int r11) {
        setOutputField(r11);
        if (r10 == null) goto L5;
        boolean r12 = true;
    L6:
        writeBoolean(r12);
        if (r10 == null) goto L10;
        writeInt(r10.getWidth());
        writeInt(r10.getHeight());
        return;
    L10:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF r10, int r11) {
        setOutputField(r11);
        if (r10 == null) goto L5;
        boolean r12 = true;
    L6:
        writeBoolean(r12);
        if (r10 == null) goto L10;
        writeFloat(r10.getWidth());
        writeFloat(r10.getHeight());
        return;
    L10:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void writeSparseBooleanArray(SparseBooleanArray r10, int r11) {
        setOutputField(r11);
        if (r10 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r12 = r10.size();
        writeInt(r12);
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        writeInt(r10.keyAt(r13));
        writeBoolean(r10.valueAt(r13));
        r13 = r13 + 1;
        goto L7
    }

    protected abstract void writeString(String r10);

    public void writeString(String r10, int r11) {
        setOutputField(r11);
        writeString(r10);
    }

    protected abstract void writeStrongBinder(IBinder r10);

    public void writeStrongBinder(IBinder r10, int r11) {
        setOutputField(r11);
        writeStrongBinder(r10);
    }

    protected abstract void writeStrongInterface(IInterface r10);

    public void writeStrongInterface(IInterface r10, int r11) {
        setOutputField(r11);
        writeStrongInterface(r10);
    }

    protected <T extends VersionedParcelable> void writeToParcel(T r10, VersionedParcel r11) {
        getWriteMethod(r10.getClass()).invoke(null, new Object[]{r10, r11});     // Catch: ClassNotFoundException -> L4 NoSuchMethodException -> L7 InvocationTargetException -> L10 IllegalAccessException -> L17
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    protected void writeVersionedParcelable(VersionedParcelable r10) {
        if (r10 != null) goto L5;
        writeString(null);
        return;
    L5:
        writeVersionedParcelableCreator(r10);
        VersionedParcel r11 = createSubParcel();
        writeToParcel(r10, r11);
        r11.closeField();
    }

    public void writeVersionedParcelable(VersionedParcelable r10, int r11) {
        setOutputField(r11);
        writeVersionedParcelable(r10);
    }
}
