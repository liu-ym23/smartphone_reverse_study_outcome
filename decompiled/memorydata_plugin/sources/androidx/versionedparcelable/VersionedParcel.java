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
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        public ParcelException(Throwable r1) {
            super(r1);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> r1, ArrayMap<String, Method> r2, ArrayMap<String, Class> r3) {
        this.mReadCache = r1;
        this.mWriteCache = r2;
        this.mParcelizerCache = r3;
    }

    private Exception createException(int r3, String r4) {
        switch(r3) {
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
        return new RuntimeException("Unknown exception code: " + r3 + " msg " + r4);
    L6:
        return new SecurityException(r4);
    L8:
        return new BadParcelableException(r4);
    L10:
        return new IllegalArgumentException(r4);
    L12:
        return new NullPointerException(r4);
    L14:
        return new IllegalStateException(r4);
    L16:
        return new NetworkOnMainThreadException();
    L18:
        return new UnsupportedOperationException(r4);
    L20:
        return (Exception) ZeusTransformUtils.preCheckCast(readParcelable(), Exception.class, "com.obric.memorydata.plugin");
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> r5) {
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(this.mParcelizerCache.get(r5.getName()), Class.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Class<?> r1 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r5.getPackage().getName(), r5.getSimpleName()}), false, r5.getClassLoader());
        this.mParcelizerCache.put(r5.getName(), r1);
        return r1;
    L6:
        return r0;
    }

    private Method getReadMethod(String r5) {
        Method r1 = (Method) ZeusTransformUtils.preCheckCast(this.mReadCache.get(r5), Method.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        System.currentTimeMillis();
        Method r2 = Class.forName(r5, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.mReadCache.put(r5, r2);
        return r2;
    L6:
        return r1;
    }

    public static Throwable getRootCause(Throwable r1) {
    L3:
        if (r1.getCause() == null) goto L5;
        r1 = r1.getCause();
        goto L3
    L5:
        return r1;
    }

    private <T> int getType(T r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return 4;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == false) goto L11;
        return 2;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, VersionedParcelable.class) == false) goto L15;
        return 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, Serializable.class) == false) goto L19;
        return 3;
    L19:
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L23;
        return 5;
    L23:
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L27;
        return 7;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r2.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class r5) {
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(this.mWriteCache.get(r5.getName()), Method.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Class r1 = findParcelClass(r5);
        System.currentTimeMillis();
        Method r2 = r1.getDeclaredMethod("write", new Class[]{r5, VersionedParcel.class});
        this.mWriteCache.put(r5.getName(), r2);
        return r2;
    L6:
        return r0;
    }

    private <T, S extends Collection<T>> S readCollection(S r4) {
        S r5 = (S) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        int r0 = readInt();
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (r0 == 0) goto L30;
        int r2 = readInt();
        if (r0 >= 0) goto L10;
        return null;
    L10:
        if (r2 != 1) goto L12;
    L28:
        if (r0 <= 0) goto L30;
        r5.add(readVersionedParcelable());
        r0 = r0 - 1;
        goto L28
    L12:
        if (r2 != 2) goto L14;
    L26:
        if (r0 <= 0) goto L30;
        r5.add(readParcelable());
        r0 = r0 - 1;
        goto L26
    L14:
        if (r2 != 3) goto L16;
    L24:
        if (r0 <= 0) goto L30;
        r5.add(readSerializable());
        r0 = r0 - 1;
        goto L24
    L16:
        if (r2 != 4) goto L18;
    L22:
        if (r0 <= 0) goto L30;
        r5.add(readString());
        r0 = r0 - 1;
        goto L22
    L18:
        if (r2 != 5) goto L30;
    L20:
        if (r0 <= 0) goto L30;
        r5.add(readStrongBinder());
        r0 = r0 - 1;
    L30:
        return r5;
    }

    private Exception readException(int r1, String r2) {
        return createException(r1, r2);
    }

    private int readExceptionCode() {
        return readInt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void writeCollection(Collection<T> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r0 = r5.size();
        writeInt(r0);
        if (r0 <= 0) goto L39;
        int r1 = getType(r5.iterator().next());
        writeInt(r1);
        switch(r1) {
            case 1: goto L35;
            case 2: goto L31;
            case 3: goto L27;
            case 4: goto L23;
            case 5: goto L19;
            case 6: goto L47;
            case 7: goto L15;
            case 8: goto L11;
            default: goto L47;
        };
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L48;
        writeFloat(((Float) ZeusTransformUtils.preCheckCast(r6.next(), Float.class, "com.obric.memorydata.plugin")).floatValue());
        goto L13
    L48:
        return;
    L15:
        Iterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L49;
        writeInt(((Integer) ZeusTransformUtils.preCheckCast(r7.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L17
    L49:
        return;
    L19:
        Iterator r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L50;
        writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r8.next(), IBinder.class, "com.obric.memorydata.plugin"));
        goto L21
    L50:
        return;
    L23:
        Iterator r9 = r5.iterator();
    L25:
        if (r9.hasNext() == false) goto L51;
        writeString((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
        goto L25
    L51:
        return;
    L27:
        Iterator r10 = r5.iterator();
    L29:
        if (r10.hasNext() == false) goto L52;
        writeSerializable((Serializable) ZeusTransformUtils.preCheckCast(r10.next(), Serializable.class, "com.obric.memorydata.plugin"));
        goto L29
    L52:
        return;
    L31:
        Iterator r11 = r5.iterator();
    L33:
        if (r11.hasNext() == false) goto L53;
        writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r11.next(), Parcelable.class, "com.obric.memorydata.plugin"));
        goto L33
    L53:
        return;
    L35:
        Iterator r12 = r5.iterator();
    L37:
        if (r12.hasNext() == false) goto L54;
        writeVersionedParcelable((VersionedParcelable) ZeusTransformUtils.preCheckCast(r12.next(), VersionedParcelable.class, "com.obric.memorydata.plugin"));
        goto L37
    L54:
        return;
    L47:
        return;
    }

    private <T> void writeCollection(Collection<T> r3, int r4) {
        Collection<T> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeCollection(r5);
    }

    private void writeSerializable(Serializable r4) {
        Serializable r5 = (Serializable) ZeusTransformUtils.wrapperContextForParams(r4, Serializable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        writeString(null);
        return;
    L6:
        String r0 = r5.getClass().getName();
        writeString(r0);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ObjectOutputStream r2 = new ObjectOutputStream(r1);     // Catch: IOException -> L9
        r2.writeObject(r5);     // Catch: IOException -> L9
        r2.close();     // Catch: IOException -> L9
        writeByteArray(r1.toByteArray());     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + r0 + ")", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable r3) {
        VersionedParcelable r4 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r3, VersionedParcelable.class, "com.obric.memorydata.plugin");
        writeString(findParcelClass(r4.getClass()).getName());
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(r4.getClass().getSimpleName() + " does not have a Parcelizer", e);
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] r5) {
        int r0 = readInt();
        if (r0 >= 0) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList(r0);
        if (r0 == 0) goto L32;
        int r3 = readInt();
        if (r0 >= 0) goto L11;
        return null;
    L11:
        if (r3 != 1) goto L13;
    L29:
        if (r0 <= 0) goto L32;
        r2.add(readVersionedParcelable());
        r0 = r0 - 1;
        goto L29
    L13:
        if (r3 != 2) goto L15;
    L27:
        if (r0 <= 0) goto L32;
        r2.add(readParcelable());
        r0 = r0 - 1;
        goto L27
    L15:
        if (r3 != 3) goto L17;
    L25:
        if (r0 <= 0) goto L32;
        r2.add(readSerializable());
        r0 = r0 - 1;
        goto L25
    L17:
        if (r3 != 4) goto L19;
    L23:
        if (r0 <= 0) goto L32;
        r2.add(readString());
        r0 = r0 - 1;
        goto L23
    L19:
        if (r3 != 5) goto L32;
    L21:
        if (r0 <= 0) goto L32;
        r2.add(readStrongBinder());
        r0 = r0 - 1;
    L32:
        return (T[]) r2.toArray(r5);
    }

    public <T> T[] readArray(T[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (T[]) readArray(r1);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBoolean();
    }

    public boolean[] readBooleanArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        boolean[] r1 = new boolean[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L13;
        if (readInt() == 0) goto L11;
        boolean r4 = true;
    L12:
        r1[r3] = r4;
        r3 = r3 + 1;
        goto L7
    L11:
        r4 = false;
        goto L12
    L13:
        return r1;
    }

    public boolean[] readBooleanArray(boolean[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBundle();
    }

    public byte readByte(byte r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readByteArray();
    }

    public char[] readCharArray(char[] r3, int r4) {
        if (readField(r4) == true) goto L5;
        return r3;
    L5:
        int r5 = readInt();
        if (r5 >= 0) goto L9;
        return null;
    L9:
        char[] r6 = new char[r5];
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L12;
        r6[r0] = (char) readInt();
        r0 = r0 + 1;
        goto L10
    L12:
        return r6;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double r1, int r3) {
        if (readField(r3) == true) goto L6;
        return r1;
    L6:
        return readDouble();
    }

    public double[] readDoubleArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        double[] r1 = new double[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readDouble();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public double[] readDoubleArray(double[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readDoubleArray();
    }

    public Exception readException(Exception r1, int r2) {
        if (readField(r2) == true) goto L5;
        return r1;
    L5:
        int r3 = readExceptionCode();
        if (r3 != 0) goto L8;
        return r1;
    L8:
        return readException(r3, readString());
    }

    public abstract boolean readField(int r1);

    public abstract float readFloat();

    public float readFloat(float r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readFloat();
    }

    public float[] readFloatArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        float[] r1 = new float[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readFloat();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public float[] readFloatArray(float[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String r4, VersionedParcel r5) {
        return (T) ZeusTransformUtils.preCheckCast(getReadMethod(r4).invoke(null, new Object[]{r5}), VersionedParcelable.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L18:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == false) goto L17;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.memorydata.plugin"));
    L17:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public abstract int readInt();

    public int readInt(int r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readInt();
    }

    public int[] readIntArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        int[] r1 = new int[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readInt();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public int[] readIntArray(int[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readIntArray();
    }

    public <T> List<T> readList(List<T> r3, int r4) {
        List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return (List) ZeusTransformUtils.preCheckCast(readCollection(new ArrayList()), List.class, "com.obric.memorydata.plugin");
    }

    public abstract long readLong();

    public long readLong(long r1, int r3) {
        if (readField(r3) == true) goto L6;
        return r1;
    L6:
        return readLong();
    }

    public long[] readLongArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        long[] r1 = new long[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readLong();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public long[] readLongArray(long[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> r5, int r6) {
        Map<K, V> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (readField(r6) == true) goto L5;
        return r7;
    L5:
        int r8 = readInt();
        if (r8 >= 0) goto L9;
        return null;
    L9:
        ArrayMap r9 = new ArrayMap();
        if (r8 != 0) goto L12;
        return r9;
    L12:
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        readCollection(r0);
        readCollection(r1);
        int r4 = 0;
    L13:
        if (r4 >= r8) goto L15;
        r9.put(r0.get(r4), r1.get(r4));
        r4 = r4 + 1;
        goto L13
    L15:
        return r9;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T r3, int r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return (T) readParcelable();
    }

    public Serializable readSerializable() {
        String r1 = readString();
        if (r1 != null) goto L6;
        return null;
    L6:
        final ByteArrayInputStream r3 = new ByteArrayInputStream(readByteArray());
        return (Serializable) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r3).readObject(), Serializable.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + r1 + ")", e);
    L9:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + r1 + ")", e);
    }

    public <T> Set<T> readSet(Set<T> r3, int r4) {
        Set<T> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return (Set) ZeusTransformUtils.preCheckCast(readCollection(new ArraySet()), Set.class, "com.obric.memorydata.plugin");
    }

    public Size readSize(Size r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new Size(readInt(), readInt());
    }

    public SizeF readSizeF(SizeF r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new SizeF(readFloat(), readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray r4, int r5) {
        if (readField(r5) == true) goto L5;
        return r4;
    L5:
        int r6 = readInt();
        if (r6 >= 0) goto L9;
        return null;
    L9:
        SparseBooleanArray r7 = new SparseBooleanArray(r6);
        int r0 = 0;
    L10:
        if (r0 >= r6) goto L12;
        r7.put(readInt(), readBoolean());
        r0 = r0 + 1;
        goto L10
    L12:
        return r7;
    }

    public abstract String readString();

    public String readString(String r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder r3, int r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String r0 = readString();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) readFromParcel(r0, createSubParcel());
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T r3, int r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, VersionedParcelable.class, "com.obric.memorydata.plugin");
        if (readField(r4) == true) goto L6;
        return r5;
    L6:
        return (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int r1);

    public void setSerializationFlags(boolean r1, boolean r2) {
    }

    public <T> void writeArray(T[] r6) {
        if (r6 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r0 = r6.length;
        writeInt(r0);
        if (r0 <= 0) goto L28;
        int r1 = 0;
        int r2 = getType(r6[0]);
        writeInt(r2);
        if (r2 != 1) goto L10;
    L26:
        if (r1 >= r0) goto L39;
        writeVersionedParcelable((VersionedParcelable) ZeusTransformUtils.preCheckCast(r6[r1], VersionedParcelable.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L26
    L39:
        return;
    L10:
        if (r2 != 2) goto L12;
    L24:
        if (r1 >= r0) goto L38;
        writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6[r1], Parcelable.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L24
    L38:
        return;
    L12:
        if (r2 != 3) goto L14;
    L22:
        if (r1 >= r0) goto L37;
        writeSerializable((Serializable) ZeusTransformUtils.preCheckCast(r6[r1], Serializable.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L22
    L37:
        return;
    L14:
        if (r2 != 4) goto L16;
    L20:
        if (r1 >= r0) goto L36;
        writeString((String) ZeusTransformUtils.preCheckCast(r6[r1], String.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L20
    L36:
        return;
    L16:
        if (r2 != 5) goto L34;
    L18:
        if (r1 >= r0) goto L35;
        writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r6[r1], IBinder.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    public <T> void writeArray(T[] r1, int r2) {
        setOutputField(r2);
        writeArray(r1);
    }

    public abstract void writeBoolean(boolean r1);

    public void writeBoolean(boolean r1, int r2) {
        setOutputField(r2);
        writeBoolean(r1);
    }

    public void writeBooleanArray(boolean[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeInt(r4[r1] ? 1 : 0);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeBooleanArray(boolean[] r1, int r2) {
        setOutputField(r2);
        writeBooleanArray(r1);
    }

    public abstract void writeBundle(Bundle r1);

    public void writeBundle(Bundle r1, int r2) {
        setOutputField(r2);
        writeBundle(r1);
    }

    public void writeByte(byte r1, int r2) {
        setOutputField(r2);
        writeInt(r1);
    }

    public abstract void writeByteArray(byte[] r1);

    public void writeByteArray(byte[] r1, int r2) {
        setOutputField(r2);
        writeByteArray(r1);
    }

    public abstract void writeByteArray(byte[] r1, int r2, int r3);

    public void writeByteArray(byte[] r1, int r2, int r3, int r4) {
        setOutputField(r4);
        writeByteArray(r1, r2, r3);
    }

    public void writeCharArray(char[] r3, int r4) {
        setOutputField(r4);
        if (r3 == null) goto L7;
        int r5 = r3.length;
        writeInt(r5);
        int r0 = 0;
    L5:
        if (r0 >= r5) goto L10;
        writeInt(r3[r0]);
        r0 = r0 + 1;
        goto L5
    L10:
        return;
    L7:
        writeInt(-1);
    }

    public abstract void writeCharSequence(CharSequence r1);

    public void writeCharSequence(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeCharSequence(r5);
    }

    public abstract void writeDouble(double r1);

    public void writeDouble(double r1, int r3) {
        setOutputField(r3);
        writeDouble(r1);
    }

    public void writeDoubleArray(double[] r5) {
        if (r5 == null) goto L6;
        int r0 = r5.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeDouble(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeDoubleArray(double[] r1, int r2) {
        setOutputField(r2);
        writeDoubleArray(r1);
    }

    public void writeException(Exception r4, int r5) {
        setOutputField(r5);
        if (r4 != null) goto L6;
        writeNoException();
        return;
    L6:
        int r6 = 0;
        if (ZeusTransformUtils.instanceOf(r4, Parcelable.class) == false) goto L12;
        if (r4.getClass().getClassLoader() != Parcelable.class.getClassLoader()) goto L12;
        r6 = -9;
    L32:
        writeInt(r6);
        if (r6 == 0) goto L35;
        writeString(r4.getMessage());
        if (r6 != (-9)) goto L45;
        writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        return;
    L45:
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r4, RuntimeException.class) == false) goto L39;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r4, RuntimeException.class, "com.obric.memorydata.plugin"));
    L39:
        throw new RuntimeException(r4);
    L12:
        if (ZeusTransformUtils.instanceOf(r4, SecurityException.class) == false) goto L15;
        r6 = -1;
        goto L32
    L15:
        if (ZeusTransformUtils.instanceOf(r4, BadParcelableException.class) == false) goto L18;
        r6 = -2;
        goto L32
    L18:
        if (ZeusTransformUtils.instanceOf(r4, IllegalArgumentException.class) == false) goto L21;
        r6 = -3;
        goto L32
    L21:
        if (ZeusTransformUtils.instanceOf(r4, NullPointerException.class) == false) goto L24;
        r6 = -4;
        goto L32
    L24:
        if (ZeusTransformUtils.instanceOf(r4, IllegalStateException.class) == false) goto L27;
        r6 = -5;
        goto L32
    L27:
        if (ZeusTransformUtils.instanceOf(r4, NetworkOnMainThreadException.class) == false) goto L30;
        r6 = -6;
        goto L32
    L30:
        if (ZeusTransformUtils.instanceOf(r4, UnsupportedOperationException.class) == false) goto L32;
        r6 = -7;
        goto L32
    }

    public abstract void writeFloat(float r1);

    public void writeFloat(float r1, int r2) {
        setOutputField(r2);
        writeFloat(r1);
    }

    public void writeFloatArray(float[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeFloat(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeFloatArray(float[] r1, int r2) {
        setOutputField(r2);
        writeFloatArray(r1);
    }

    public abstract void writeInt(int r1);

    public void writeInt(int r1, int r2) {
        setOutputField(r2);
        writeInt(r1);
    }

    public void writeIntArray(int[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeInt(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeIntArray(int[] r1, int r2) {
        setOutputField(r2);
        writeIntArray(r1);
    }

    public <T> void writeList(List<T> r3, int r4) {
        writeCollection((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    public abstract void writeLong(long r1);

    public void writeLong(long r1, int r3) {
        setOutputField(r3);
        writeLong(r1);
    }

    public void writeLongArray(long[] r5) {
        if (r5 == null) goto L6;
        int r0 = r5.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeLong(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeLongArray(long[] r1, int r2) {
        setOutputField(r2);
        writeLongArray(r1);
    }

    public <K, V> void writeMap(Map<K, V> r5, int r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        setOutputField(r6);
        if (r7 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r8 = r7.size();
        writeInt(r8);
        if (r8 != 0) goto L9;
        return;
    L9:
        ArrayList r9 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<K, V>> r10 = r7.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r9.add(r2.getKey());
        r0.add(r2.getValue());
        goto L11
    L13:
        writeCollection(r9);
        writeCollection(r0);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable r1);

    public void writeParcelable(Parcelable r3, int r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeParcelable(r5);
    }

    public void writeSerializable(Serializable r3, int r4) {
        Serializable r5 = (Serializable) ZeusTransformUtils.wrapperContextForParams(r3, Serializable.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeSerializable(r5);
    }

    public <T> void writeSet(Set<T> r3, int r4) {
        writeCollection((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), r4);
    }

    public void writeSize(Size r1, int r2) {
        setOutputField(r2);
        if (r1 == null) goto L5;
        boolean r3 = true;
    L6:
        writeBoolean(r3);
        if (r1 == null) goto L10;
        writeInt(r1.getWidth());
        writeInt(r1.getHeight());
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void writeSizeF(SizeF r1, int r2) {
        setOutputField(r2);
        if (r1 == null) goto L5;
        boolean r3 = true;
    L6:
        writeBoolean(r3);
        if (r1 == null) goto L10;
        writeFloat(r1.getWidth());
        writeFloat(r1.getHeight());
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void writeSparseBooleanArray(SparseBooleanArray r3, int r4) {
        setOutputField(r4);
        if (r3 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r5 = r3.size();
        writeInt(r5);
        int r0 = 0;
    L7:
        if (r0 >= r5) goto L9;
        writeInt(r3.keyAt(r0));
        writeBoolean(r3.valueAt(r0));
        r0 = r0 + 1;
        goto L7
    }

    public abstract void writeString(String r1);

    public void writeString(String r1, int r2) {
        setOutputField(r2);
        writeString(r1);
    }

    public abstract void writeStrongBinder(IBinder r1);

    public void writeStrongBinder(IBinder r3, int r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeStrongBinder(r5);
    }

    public abstract void writeStrongInterface(IInterface r1);

    public void writeStrongInterface(IInterface r3, int r4) {
        IInterface r5 = (IInterface) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeStrongInterface(r5);
    }

    public <T extends VersionedParcelable> void writeToParcel(T r5, VersionedParcel r6) {
        VersionedParcelable r7 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r5, VersionedParcelable.class, "com.obric.memorydata.plugin");
        getWriteMethod(r7.getClass()).invoke(null, new Object[]{r7, r6});     // Catch: ClassNotFoundException -> L5 NoSuchMethodException -> L8 InvocationTargetException -> L11 IllegalAccessException -> L18
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L18:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == false) goto L17;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.memorydata.plugin"));
    L17:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public void writeVersionedParcelable(VersionedParcelable r3) {
        VersionedParcelable r4 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r3, VersionedParcelable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        writeString(null);
        return;
    L6:
        writeVersionedParcelableCreator(r4);
        VersionedParcel r0 = createSubParcel();
        writeToParcel(r4, r0);
        r0.closeField();
    }

    public void writeVersionedParcelable(VersionedParcelable r3, int r4) {
        VersionedParcelable r5 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r3, VersionedParcelable.class, "com.obric.memorydata.plugin");
        setOutputField(r4);
        writeVersionedParcelable(r5);
    }
}
