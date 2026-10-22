package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<? extends Object>[] f2120f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.savedstate.a.b f2125e;

    public static final class a {
        public static a0 a(Bundle r8, Bundle r10) {
            if (r8 != null) goto L11;
            if (r10 == null) goto L28;
            HashMap r11 = new HashMap();
            Iterator<String> r12 = r10.keySet().iterator();
        L7:
            if (r12.hasNext() == false) goto L10;
            String r13 = r12.next();
            he.i.e(r13, "key");
            r11.put(r13, r10.get(r13));
            goto L7
        L10:
            return new a0(r11);
        L28:
            return new a0();
        L11:
            ArrayList r14 = r8.getParcelableArrayList("keys");
            ArrayList r15 = r8.getParcelableArrayList("values");
            int r16 = 0;
            if (r14 == null) goto L17;
            if (r15 == null) goto L17;
            if (r14.size() != r15.size()) goto L17;
            boolean r17 = true;
        L18:
            if (r17 == false) goto L25;
            LinkedHashMap r18 = new LinkedHashMap();
            int r19 = r14.size();
        L20:
            if (r16 >= r19) goto L23;
            Object r20 = r14.get(r16);
            he.i.d(r20, "null cannot be cast to non-null type kotlin.String");
            r18.put((String) r20, r15.get(r16));
            r16 = r16 + 1;
            goto L20
        L23:
            return new a0(r18);
        L25:
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        L17:
            r17 = false;
            goto L18
        }
    }

    static {
        f2120f = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    }

    public a0() {
        this.f2121a = new LinkedHashMap();
        this.f2122b = new LinkedHashMap();
        this.f2123c = new LinkedHashMap();
        this.f2124d = new LinkedHashMap();
        this.f2125e = new z(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bundle a(a0 r11) {
        he.i.f(r11, "this$0");
        LinkedHashMap r8 = r11.f2122b;
        he.i.f(r8, "<this>");
        int r10 = r8.size();
        if (r10 == 0) goto L7;
        if (r10 == 1) goto L6;
        Map r12 = new LinkedHashMap(r8);
    L8:
        Iterator r13 = r12.entrySet().iterator();
    L9:
        boolean r14 = r13.hasNext();
        LinkedHashMap r15 = r11.f2121a;
        t r16 = null;
        int r17 = 0;
        if (r14 == false) goto L33;
        Map.Entry r18 = (Map.Entry) r13.next();
        String r19 = (String) r18.getKey();
        Bundle r20 = ((androidx.savedstate.a.b) r18.getValue()).a();
        he.i.f(r19, "key");
        if (r20 == null) goto L18;
        Class<? extends Object>[] r21 = f2120f;
        int r22 = r21.length;
        int r23 = 0;
    L15:
        if (r23 >= r22) goto L20;
        Class<? extends Object> r110 = r21[r23];
        he.i.c(r110);
        if (r110.isInstance(r20) == true) goto L18;
        r23 = r23 + 1;
    L20:
        if (r17 == 0) goto L31;
        Object r24 = r11.f2123c.get(r19);
        if ((r24 instanceof t) == false) goto L24;
        r16 = (t) r24;
    L24:
        if (r16 == null) goto L26;
        r16.i(r20);
    L27:
        se.f r25 = (se.f) r11.f2124d.get(r19);
        if (r25 == null) goto L9;
        r25.setValue(r20);
        goto L9
    L26:
        r15.put(r19, r20);
        goto L27
    L31:
        StringBuilder r26 = new StringBuilder("Can't put value with type ");
        he.i.c(r20);
        r26.append(r20.getClass());
        r26.append(" into saved state");
        throw new IllegalArgumentException(r26.toString());
    L18:
        r17 = 1;
        goto L20
    L33:
        Set r111 = r15.keySet();
        ArrayList r27 = new ArrayList(r111.size());
        ArrayList r28 = new ArrayList(r27.size());
        Iterator r112 = r111.iterator();
    L35:
        if (r112.hasNext() == false) goto L37;
        String r29 = (String) r112.next();
        r27.add(r29);
        r28.add(r15.get(r29));
        goto L35
    L37:
        xd.d[] r113 = {new xd.d("keys", r27), new xd.d("values", r28)};
        Bundle r30 = new Bundle(2);
    L38:
        if (r17 >= 2) goto L130;
        xd.d r31 = r113[r17];
        String r32 = (String) r31.f13867a;
        B r33 = r31.f13868b;
        if (r33 != 0) goto L43;
        r30.putString(r32, null);
    L127:
        r17 = r17 + 1;
        goto L38
    L43:
        if ((r33 instanceof Boolean) == false) goto L46;
        r30.putBoolean(r32, ((Boolean) r33).booleanValue());
        goto L127
    L46:
        if ((r33 instanceof Byte) == false) goto L49;
        r30.putByte(r32, ((Number) r33).byteValue());
        goto L127
    L49:
        if ((r33 instanceof Character) == false) goto L52;
        r30.putChar(r32, ((Character) r33).charValue());
        goto L127
    L52:
        if ((r33 instanceof Double) == false) goto L55;
        r30.putDouble(r32, ((Number) r33).doubleValue());
        goto L127
    L55:
        if ((r33 instanceof Float) == false) goto L58;
        r30.putFloat(r32, ((Number) r33).floatValue());
        goto L127
    L58:
        if ((r33 instanceof Integer) == false) goto L61;
        r30.putInt(r32, ((Number) r33).intValue());
        goto L127
    L61:
        if ((r33 instanceof Long) == false) goto L64;
        r30.putLong(r32, ((Number) r33).longValue());
        goto L127
    L64:
        if ((r33 instanceof Short) == false) goto L67;
        r30.putShort(r32, ((Number) r33).shortValue());
        goto L127
    L67:
        if ((r33 instanceof Bundle) == false) goto L70;
        r30.putBundle(r32, (Bundle) r33);
        goto L127
    L70:
        if ((r33 instanceof CharSequence) == false) goto L73;
        r30.putCharSequence(r32, (CharSequence) r33);
        goto L127
    L73:
        if ((r33 instanceof Parcelable) == false) goto L76;
        r30.putParcelable(r32, (Parcelable) r33);
        goto L127
    L76:
        if ((r33 instanceof boolean[]) == false) goto L79;
        r30.putBooleanArray(r32, (boolean[]) r33);
        goto L127
    L79:
        if ((r33 instanceof byte[]) == false) goto L82;
        r30.putByteArray(r32, (byte[]) r33);
        goto L127
    L82:
        if ((r33 instanceof char[]) == false) goto L85;
        r30.putCharArray(r32, (char[]) r33);
        goto L127
    L85:
        if ((r33 instanceof double[]) == false) goto L88;
        r30.putDoubleArray(r32, (double[]) r33);
        goto L127
    L88:
        if ((r33 instanceof float[]) == false) goto L91;
        r30.putFloatArray(r32, (float[]) r33);
        goto L127
    L91:
        if ((r33 instanceof int[]) == false) goto L94;
        r30.putIntArray(r32, (int[]) r33);
        goto L127
    L94:
        if ((r33 instanceof long[]) == false) goto L97;
        r30.putLongArray(r32, (long[]) r33);
        goto L127
    L97:
        if ((r33 instanceof short[]) == false) goto L100;
        r30.putShortArray(r32, (short[]) r33);
        goto L127
    L100:
        if ((r33 instanceof Object[]) == false) goto L116;
        Class<?> r34 = r33.getClass().getComponentType();
        he.i.c(r34);
        if (Parcelable.class.isAssignableFrom(r34) == false) goto L105;
        r30.putParcelableArray(r32, (Parcelable[]) r33);
        goto L127
    L105:
        if (String.class.isAssignableFrom(r34) == false) goto L108;
        r30.putStringArray(r32, (String[]) r33);
        goto L127
    L108:
        if (CharSequence.class.isAssignableFrom(r34) == false) goto L111;
        r30.putCharSequenceArray(r32, (CharSequence[]) r33);
        goto L127
    L111:
        if (Serializable.class.isAssignableFrom(r34) == false) goto L114;
    L117:
        r30.putSerializable(r32, (Serializable) r33);
        goto L127
    L114:
        throw new IllegalArgumentException("Illegal value array type " + r34.getCanonicalName() + " for key \"" + r32 + '\"');
    L116:
        if ((r33 instanceof Serializable) == true) goto L117;
        if ((r33 instanceof IBinder) == false) goto L122;
        f0.b.a(r30, r32, (IBinder) r33);
        goto L127
    L122:
        if ((r33 instanceof Size) == false) goto L125;
        f0.c.a(r30, r32, (Size) r33);
        goto L127
    L125:
        if ((r33 instanceof SizeF) == false) goto L129;
        f0.c.b(r30, r32, (SizeF) r33);
        goto L127
    L129:
        throw new IllegalArgumentException("Illegal value type " + r33.getClass().getCanonicalName() + " for key \"" + r32 + '\"');
    L130:
        return r30;
    L6:
        r12 = l6.a.Z0(r8);
        goto L8
    L7:
        r12 = yd.l.f14120a;
        goto L8
    }

    public a0(HashMap r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        this.f2121a = r10;
        this.f2122b = new LinkedHashMap();
        this.f2123c = new LinkedHashMap();
        this.f2124d = new LinkedHashMap();
        this.f2125e = new androidx.activity.f(this, 1);
        r10.putAll(r8);
    }
}
