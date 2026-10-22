package androidx.work;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.room.TypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Data {
    public static final Data EMPTY = null;

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = null;
    Map<String, Object> mValues;

    public static final class Builder {
        private Map<String, Object> mValues;

        public Builder() {
            this.mValues = new HashMap();
        }

        @NonNull
        public Data build() {
            Data r10 = new Data(this.mValues);
            Data.toByteArrayInternal(r10);
            return r10;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder put(@NonNull String r10, @Nullable Object r11) {
            if (r11 != null) goto L4;
            this.mValues.put(r10, null);
        L54:
            return this;
        L4:
            Class<?> r12 = r11.getClass();
            if (r12 != Boolean.class) goto L7;
        L53:
            this.mValues.put(r10, r11);
            goto L54
        L7:
            if (r12 == Byte.class) goto L53;
            if (r12 == Integer.class) goto L53;
            if (r12 == Long.class) goto L53;
            if (r12 == Float.class) goto L53;
            if (r12 == Double.class) goto L53;
            if (r12 == String.class) goto L53;
            if (r12 == Boolean[].class) goto L53;
            if (r12 == Byte[].class) goto L53;
            if (r12 == Integer[].class) goto L53;
            if (r12 == Long[].class) goto L53;
            if (r12 == Float[].class) goto L53;
            if (r12 == Double[].class) goto L53;
            if (r12 == String[].class) goto L53;
            if (r12 != boolean[].class) goto L37;
            this.mValues.put(r10, Data.convertPrimitiveBooleanArray((boolean[]) r11));
            goto L54
        L37:
            if (r12 != byte[].class) goto L40;
            this.mValues.put(r10, Data.convertPrimitiveByteArray((byte[]) r11));
            goto L54
        L40:
            if (r12 != int[].class) goto L43;
            this.mValues.put(r10, Data.convertPrimitiveIntArray((int[]) r11));
            goto L54
        L43:
            if (r12 != long[].class) goto L46;
            this.mValues.put(r10, Data.convertPrimitiveLongArray((long[]) r11));
            goto L54
        L46:
            if (r12 != float[].class) goto L49;
            this.mValues.put(r10, Data.convertPrimitiveFloatArray((float[]) r11));
            goto L54
        L49:
            if (r12 != double[].class) goto L52;
            this.mValues.put(r10, Data.convertPrimitiveDoubleArray((double[]) r11));
            goto L54
        L52:
            throw new IllegalArgumentException("Key " + r10 + "has invalid type " + r12);
        }

        @NonNull
        public Builder putAll(@NonNull Data r10) {
            putAll(r10.mValues);
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> r10) {
            Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<String, Object> r12 = r11.next();
            put(r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }

        @NonNull
        public Builder putBoolean(@NonNull String r10, boolean r11) {
            this.mValues.put(r10, Boolean.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putBooleanArray(@NonNull String r10, @NonNull boolean[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveBooleanArray(r11));
            return this;
        }

        @NonNull
        public Builder putByte(@NonNull String r10, byte r11) {
            this.mValues.put(r10, Byte.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putByteArray(@NonNull String r10, @NonNull byte[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveByteArray(r11));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String r10, double r11) {
            this.mValues.put(r10, Double.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putDoubleArray(@NonNull String r10, @NonNull double[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveDoubleArray(r11));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String r10, float r11) {
            this.mValues.put(r10, Float.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putFloatArray(@NonNull String r10, @NonNull float[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveFloatArray(r11));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String r10, int r11) {
            this.mValues.put(r10, Integer.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putIntArray(@NonNull String r10, @NonNull int[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveIntArray(r11));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String r10, long r11) {
            this.mValues.put(r10, Long.valueOf(r11));
            return this;
        }

        @NonNull
        public Builder putLongArray(@NonNull String r10, @NonNull long[] r11) {
            this.mValues.put(r10, Data.convertPrimitiveLongArray(r11));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String r10, @Nullable String r11) {
            this.mValues.put(r10, r11);
            return this;
        }

        @NonNull
        public Builder putStringArray(@NonNull String r10, @NonNull String[] r11) {
            this.mValues.put(r10, r11);
            return this;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Data");
        EMPTY = new Builder().build();
    }

    Data() {
    }

    public Data(@NonNull Data r10) {
        this.mValues = new HashMap(r10.mValues);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Data(@NonNull Map<String, ?> r10) {
        this.mValues = new HashMap(r10);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Boolean[] convertPrimitiveBooleanArray(@NonNull boolean[] r10) {
        Boolean[] r11 = new Boolean[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Boolean.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Byte[] convertPrimitiveByteArray(@NonNull byte[] r10) {
        Byte[] r11 = new Byte[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Byte.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Double[] convertPrimitiveDoubleArray(@NonNull double[] r10) {
        Double[] r11 = new Double[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Double.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Float[] convertPrimitiveFloatArray(@NonNull float[] r10) {
        Float[] r11 = new Float[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Float.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Integer[] convertPrimitiveIntArray(@NonNull int[] r10) {
        Integer[] r11 = new Integer[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Integer.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Long[] convertPrimitiveLongArray(@NonNull long[] r10) {
        Long[] r11 = new Long[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Long.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static byte[] convertToPrimitiveArray(@NonNull Byte[] r10) {
        byte[] r11 = new byte[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].byteValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static double[] convertToPrimitiveArray(@NonNull Double[] r10) {
        double[] r11 = new double[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].doubleValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static float[] convertToPrimitiveArray(@NonNull Float[] r10) {
        float[] r11 = new float[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].floatValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int[] convertToPrimitiveArray(@NonNull Integer[] r10) {
        int[] r11 = new int[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static long[] convertToPrimitiveArray(@NonNull Long[] r10) {
        long[] r11 = new long[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].longValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean[] convertToPrimitiveArray(@NonNull Boolean[] r10) {
        boolean[] r11 = new boolean[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].booleanValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @TypeConverter
    public static Data fromByteArray(@NonNull byte[] r10) {
        if (r10.length > 10240) goto L46;
        HashMap r11 = new HashMap();
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);
        ObjectInputStream r13 = null;
        ObjectInputStream r14 = new ObjectInputStream(r12);     // Catch: Throwable -> L18 Throwable -> L20
        int r15 = r14.readInt();     // Catch: Throwable -> L16 Throwable -> L34
    L7:
        if (r15 <= 0) goto L53;
        r11.put(r14.readUTF(), r14.readObject());     // Catch: Throwable -> L16 Throwable -> L34
        r15 = r15 - 1;
        goto L7
    L53:
        r14.close();     // Catch: IOException -> L12
    L14:
        r12.close();     // Catch: IOException -> L30
    L47:
    L33:
        return new Data(r11);
    L12:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L16:
        Throwable e10 = e;
    L22:
        Log.e(TAG, "Error in Data#fromByteArray: ", e10);     // Catch: Throwable -> L34
        if (r14 != null) goto L57;
    L28:
        r12.close();     // Catch: IOException -> L30
        goto L47
    L57:
        r14.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
        goto L28
    L30:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L20:
        e = move-exception;
        r14 = null;
        e10 = e;
    L18:
        th = move-exception;
        th = th;
    L35:
        if (0 != 0) goto L59;
    L50:
        r12.close();     // Catch: IOException -> L42
        throw th;
    L42:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
        throw th;
    L59:
        r13.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L34:
        th = th;
        goto L35
    L46:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    @NonNull
    @TypeConverter
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static byte[] toByteArrayInternal(@NonNull Data r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = null;
        ObjectOutputStream r13 = new ObjectOutputStream(r11);     // Catch: Throwable -> L27 IOException -> L29
        r13.writeInt(r10.size());     // Catch: Throwable -> L23 IOException -> L25
        Iterator<Map.Entry<String, Object>> r14 = r10.mValues.entrySet().iterator();     // Catch: Throwable -> L23 IOException -> L25
    L6:
        if (r14.hasNext() == false) goto L57;
        Map.Entry<String, Object> r15 = r14.next();     // Catch: Throwable -> L23 IOException -> L25
        r13.writeUTF(r15.getKey());     // Catch: Throwable -> L23 IOException -> L25
        r13.writeObject(r15.getValue());     // Catch: Throwable -> L23 IOException -> L25
    L57:
        r13.close();     // Catch: IOException -> L11
    L51:
        r11.close();     // Catch: IOException -> L15
    L18:
        if (r11.size() > 10240) goto L22;
        return r11.toByteArray();
    L22:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    L15:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L11:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L25:
        e = e;
        r12 = r13;
    L30:
        Log.e(TAG, "Error in Data#toByteArray: ", e);     // Catch: Throwable -> L27
        byte[] r16 = r11.toByteArray();     // Catch: Throwable -> L27
        if (r12 != null) goto L63;
    L53:
        r11.close();     // Catch: IOException -> L38
    L40:
        return r16;
    L38:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
        goto L40
    L63:
        r12.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L23:
        th = th;
        r12 = r13;
    L41:
        if (r12 == null) goto L61;
        r12.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L61:
        r11.close();     // Catch: IOException -> L48
        throw th;
    L48:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
        throw th;
    L27:
        th = th;
    L29:
        e = e;
        goto L30
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L32:
        return false;
    L8:
        if (Data.class != r10.getClass()) goto L32;
        Data r11 = (Data) r10;
        Set<String> r12 = this.mValues.keySet();
        if (r12.equals(r11.mValues.keySet()) == true) goto L13;
        return false;
    L13:
        Iterator<String> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L31;
        String r14 = r13.next();
        Object r15 = this.mValues.get(r14);
        Object r16 = r11.mValues.get(r14);
        if (r15 == null) goto L26;
        if (r16 == null) goto L26;
        if ((r15 instanceof Object[]) == true) goto L23;
    L25:
        boolean r17 = r15.equals(r16);
    L29:
        if (r17 == true) goto L15;
        return false;
    L23:
        if ((r16 instanceof Object[]) == false) goto L25;
        r17 = Arrays.deepEquals((Object[]) r15, (Object[]) r16);
    L26:
        if (r15 != r16) goto L28;
        r17 = true;
        goto L29
    L28:
        r17 = false;
        goto L29
    L31:
        return true;
    }

    public boolean getBoolean(@NonNull String r10, boolean r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Boolean) == true) goto L5;
        return r11;
    L5:
        return ((Boolean) r12).booleanValue();
    }

    @Nullable
    public boolean[] getBooleanArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Boolean[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Boolean[]) r11);
    }

    public byte getByte(@NonNull String r10, byte r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Byte) == true) goto L5;
        return r11;
    L5:
        return ((Byte) r12).byteValue();
    }

    @Nullable
    public byte[] getByteArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Byte[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Byte[]) r11);
    }

    public double getDouble(@NonNull String r10, double r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Double) == true) goto L5;
        return r11;
    L5:
        return ((Double) r12).doubleValue();
    }

    @Nullable
    public double[] getDoubleArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Double[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Double[]) r11);
    }

    public float getFloat(@NonNull String r10, float r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Float) == true) goto L5;
        return r11;
    L5:
        return ((Float) r12).floatValue();
    }

    @Nullable
    public float[] getFloatArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Float[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Float[]) r11);
    }

    public int getInt(@NonNull String r10, int r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Integer) == true) goto L5;
        return r11;
    L5:
        return ((Integer) r12).intValue();
    }

    @Nullable
    public int[] getIntArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Integer[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Integer[]) r11);
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(@NonNull String r10, long r11) {
        Object r12 = this.mValues.get(r10);
        if ((r12 instanceof Long) == true) goto L5;
        return r11;
    L5:
        return ((Long) r12).longValue();
    }

    @Nullable
    public long[] getLongArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof Long[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Long[]) r11);
    }

    @Nullable
    public String getString(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r11;
    }

    @Nullable
    public String[] getStringArray(@NonNull String r10) {
        Object r11 = this.mValues.get(r10);
        if ((r11 instanceof String[]) == true) goto L5;
        return null;
    L5:
        return (String[]) r11;
    }

    public <T> boolean hasKeyWithValueOfType(@NonNull String r10, @NonNull Class<T> r11) {
        Object r12 = this.mValues.get(r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.isAssignableFrom(r12.getClass()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public int size() {
        return this.mValues.size();
    }

    @NonNull
    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder("Data {");
        if (this.mValues.isEmpty() == true) goto L12;
        Iterator<String> r11 = this.mValues.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();
        r10.append(r12);
        r10.append(" : ");
        Object r13 = this.mValues.get(r12);
        if ((r13 instanceof Object[]) == false) goto L10;
        r10.append(Arrays.toString((Object[]) r13));
    L11:
        r10.append(", ");
        goto L6
    L10:
        r10.append(r13);
    L12:
        r10.append("}");
        return r10.toString();
    }
}
