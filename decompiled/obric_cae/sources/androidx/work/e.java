package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2822b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f2823c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2824a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f2825a;

        public a() {
            this.f2825a = new HashMap();
        }

        public final e a() {
            e r8 = new e(this.f2825a);
            e.e(r8);
            return r8;
        }

        public final void b(HashMap r10) {
            Iterator r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L82;
            Map.Entry r8 = (Map.Entry) r11.next();
            String r12 = (String) r8.getKey();
            Object r13 = r8.getValue();
            HashMap r14 = this.f2825a;
            if (r13 == null) goto L7;
            Class<?> r15 = r13.getClass();
            if (r15 == Boolean.class) goto L81;
            if (r15 == Byte.class) goto L81;
            if (r15 == Integer.class) goto L81;
            if (r15 == Long.class) goto L81;
            if (r15 == Float.class) goto L81;
            if (r15 == Double.class) goto L81;
            if (r15 == String.class) goto L81;
            if (r15 == Boolean[].class) goto L81;
            if (r15 == Byte[].class) goto L81;
            if (r15 == Integer[].class) goto L81;
            if (r15 == Long[].class) goto L81;
            if (r15 == Float[].class) goto L81;
            if (r15 == Double[].class) goto L81;
            if (r15 == String[].class) goto L81;
            int r16 = 0;
            if (r15 == boolean[].class) goto L39;
            if (r15 == byte[].class) goto L46;
            if (r15 == int[].class) goto L53;
            if (r15 == long[].class) goto L60;
            if (r15 == float[].class) goto L67;
            if (r15 != double[].class) goto L80;
            double[] r17 = (double[]) r13;
            String r18 = e.f2822b;
            Double[] r19 = new Double[r17.length];
        L76:
            if (r16 >= r17.length) goto L78;
            r19[r16] = Double.valueOf(r17[r16]);
            r16 = r16 + 1;
            goto L76
        L78:
            r14.put(r12, r19);
            goto L4
        L80:
            throw new IllegalArgumentException("Key " + r12 + "has invalid type " + r15);
        L67:
            float[] r20 = (float[]) r13;
            String r21 = e.f2822b;
            Float[] r22 = new Float[r20.length];
        L69:
            if (r16 >= r20.length) goto L71;
            r22[r16] = Float.valueOf(r20[r16]);
            r16 = r16 + 1;
            goto L69
        L71:
            r14.put(r12, r22);
            goto L4
        L60:
            long[] r23 = (long[]) r13;
            String r24 = e.f2822b;
            Long[] r25 = new Long[r23.length];
        L62:
            if (r16 >= r23.length) goto L64;
            r25[r16] = Long.valueOf(r23[r16]);
            r16 = r16 + 1;
            goto L62
        L64:
            r14.put(r12, r25);
            goto L4
        L53:
            int[] r26 = (int[]) r13;
            String r27 = e.f2822b;
            Integer[] r28 = new Integer[r26.length];
        L55:
            if (r16 >= r26.length) goto L57;
            r28[r16] = Integer.valueOf(r26[r16]);
            r16 = r16 + 1;
            goto L55
        L57:
            r14.put(r12, r28);
            goto L4
        L46:
            byte[] r29 = (byte[]) r13;
            String r30 = e.f2822b;
            Byte[] r31 = new Byte[r29.length];
        L48:
            if (r16 >= r29.length) goto L50;
            r31[r16] = Byte.valueOf(r29[r16]);
            r16 = r16 + 1;
            goto L48
        L50:
            r14.put(r12, r31);
            goto L4
        L39:
            boolean[] r32 = (boolean[]) r13;
            String r33 = e.f2822b;
            Boolean[] r34 = new Boolean[r32.length];
        L41:
            if (r16 >= r32.length) goto L43;
            r34[r16] = Boolean.valueOf(r32[r16]);
            r16 = r16 + 1;
            goto L41
        L43:
            r14.put(r12, r34);
        L81:
            r14.put(r12, r13);
            goto L4
        L7:
            r13 = null;
            goto L81
        }

        public final void c(String r8, String r10) {
            this.f2825a.put(r8, r10);
        }
    }

    static {
        f2822b = m.f("Data");
        f2823c = new a().a();
    }

    public e() {
    }

    public e(e r8) {
        this.f2824a = new HashMap(r8.f2824a);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005c: MOVE (r8 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:34:0x005b */
    public static e a(byte[] r8) {
        String r10 = f2822b;
        if (r8.length > 10240) goto L46;
        HashMap r11 = new HashMap();
        ByteArrayInputStream r12 = new ByteArrayInputStream(r8);
        ObjectInputStream r13 = null;
        ObjectInputStream r14 = new ObjectInputStream(r12);     // Catch: Throwable -> L18 Throwable -> L20
        int r15 = r14.readInt();     // Catch: Throwable -> L14 Throwable -> L16
    L7:
        if (r15 <= 0) goto L54;
        r11.put(r14.readUTF(), r14.readObject());     // Catch: Throwable -> L14 Throwable -> L16
        r15 = r15 - 1;
        goto L7
    L54:
        r14.close();     // Catch: IOException -> L12
    L52:
        r12.close();     // Catch: IOException -> L30
    L33:
        return new e(r11);
    L30:
        e = move-exception;
        Log.e(r10, "Error in Data#fromByteArray: ", e);
    L12:
        e = move-exception;
        Log.e(r10, "Error in Data#fromByteArray: ", e);
    L16:
        Throwable e10 = e;
    L22:
        Log.e(r10, "Error in Data#fromByteArray: ", e10);     // Catch: Throwable -> L14
        if (r14 == null) goto L52;
        r14.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        Log.e(r10, "Error in Data#fromByteArray: ", e);
        goto L52
    L14:
        th = move-exception;
        th = th;
        r13 = r4;
    L35:
        if (r13 == null) goto L58;
        r13.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        Log.e(r10, "Error in Data#fromByteArray: ", e);
    L58:
        r12.close();     // Catch: IOException -> L42
        throw th;
    L42:
        e = move-exception;
        Log.e(r10, "Error in Data#fromByteArray: ", e);
        throw th;
    L20:
        e = move-exception;
        r14 = null;
        e10 = e;
    L18:
        th = th;
        goto L35
    L46:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public static byte[] e(e r8) {
        String r10 = f2822b;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = null;
        ObjectOutputStream r13 = new ObjectOutputStream(r11);     // Catch: Throwable -> L27 IOException -> L29
        r13.writeInt(r8.f2824a.size());     // Catch: Throwable -> L23 IOException -> L25
        Iterator r14 = r8.f2824a.entrySet().iterator();     // Catch: Throwable -> L23 IOException -> L25
    L6:
        if (r14.hasNext() == false) goto L56;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L23 IOException -> L25
        r13.writeUTF((String) r15.getKey());     // Catch: Throwable -> L23 IOException -> L25
        r13.writeObject(r15.getValue());     // Catch: Throwable -> L23 IOException -> L25
    L56:
        r13.close();     // Catch: IOException -> L11
    L64:
        r11.close();     // Catch: IOException -> L15
    L18:
        if (r11.size() > 10240) goto L22;
        return r11.toByteArray();
    L22:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    L15:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
    L11:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
    L25:
        e = e;
        r12 = r13;
    L30:
        Log.e(r10, "Error in Data#toByteArray: ", e);     // Catch: Throwable -> L27
        byte[] r16 = r11.toByteArray();     // Catch: Throwable -> L27
        if (r12 == null) goto L58;
        r12.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
    L58:
        r11.close();     // Catch: IOException -> L38
    L40:
        return r16;
    L38:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
    L23:
        th = th;
    L42:
        if (r13 != null) goto L62;
    L54:
        r11.close();     // Catch: IOException -> L49
        throw th;
    L49:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
        throw th;
    L62:
        r13.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        Log.e(r10, "Error in Data#toByteArray: ", e);
    L27:
        th = th;
        r13 = r12;
    L29:
        e = e;
        goto L30
    }

    public final double b(String r8, double r10) {
        Object r11 = this.f2824a.get(r8);
        if ((r11 instanceof Double) == true) goto L5;
        return r10;
    L5:
        return ((Double) r11).doubleValue();
    }

    public final long c(String r8) {
        Object r10 = this.f2824a.get(r8);
        if ((r10 instanceof Long) == true) goto L5;
        return -1;
    L5:
        return ((Long) r10).longValue();
    }

    public final String d(String r8) {
        Object r10 = this.f2824a.get(r8);
        if ((r10 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L32:
        return false;
    L8:
        if (e.class != r8.getClass()) goto L32;
        e r10 = (e) r8;
        HashMap r11 = this.f2824a;
        Set r12 = r11.keySet();
        if (r12.equals(r10.f2824a.keySet()) == true) goto L13;
        return false;
    L13:
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L31;
        String r14 = (String) r13.next();
        Object r15 = r11.get(r14);
        Object r16 = r10.f2824a.get(r14);
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

    public final int hashCode() {
        return this.f2824a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Data {");
        HashMap r10 = this.f2824a;
        if (r10.isEmpty() == true) goto L12;
        Iterator r11 = r10.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        String r12 = (String) r11.next();
        r8.append(r12);
        r8.append(" : ");
        Object r13 = r10.get(r12);
        if ((r13 instanceof Object[]) == false) goto L10;
        r8.append(Arrays.toString((Object[]) r13));
    L11:
        r8.append(", ");
        goto L6
    L10:
        r8.append(r13);
    L12:
        r8.append("}");
        return r8.toString();
    }

    public e(HashMap r8) {
        this.f2824a = new HashMap(r8);
    }
}
