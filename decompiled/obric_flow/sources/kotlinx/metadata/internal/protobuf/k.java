package kotlinx.metadata.internal.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f19180c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f19181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19182b;

    static {
        f19180c = new k(0);
    }

    public k() {
        this.f19181a = new g0(16);
    }

    public static int c(WireFormat$FieldType r5, Object r10) {
        switch(j.f19177b[r5.ordinal()]) {
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L55;
            case 10: goto L27;
            case 11: goto L25;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L18;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L5;
        };
    L12:
        int r11 = ((z) r10).getSerializedSize();
        return g.f(r11) + r11;
    L16:
        long r12 = ((Long) r10).longValue();
        long r13 = r12 << 1;
        return g.g((r12 >> 63) ^ r13);
    L18:
        int r14 = ((Integer) r10).intValue();
        int r15 = r14 << 1;
        return g.f((r14 >> 31) ^ r15);
    L20:
        ((Long) r10).getClass();
        return 8;
    L22:
        ((Integer) r10).getClass();
        return 4;
    L39:
        ((Boolean) r10).getClass();
        return 1;
    L41:
        ((Integer) r10).getClass();
        return 4;
    L43:
        ((Long) r10).getClass();
        return 8;
    L51:
        ((Float) r10).getClass();
        return 4;
    L53:
        ((Double) r10).getClass();
        return 8;
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((r10 instanceof r) == false) goto L11;
        return g.d(((r) r10).getNumber());
    L11:
        return g.d(((Integer) r10).intValue());
    L15:
        return ((z) r10).getSerializedSize();
    L25:
        return g.f(((Integer) r10).intValue());
    L27:
        if ((r10 instanceof e) == true) goto L29;
        byte[] r16 = (byte[]) r10;
        return g.f(r16.length) + r16.length;
    L29:
        return g.a((e) r10);
    L55:
        byte[] r17 = ((String) r10).getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L36
        return g.f(r17.length) + r17.length;
    L36:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    L46:
        return g.d(((Integer) r10).intValue());
    L48:
        return g.g(((Long) r10).longValue());
    L50:
        return g.g(((Long) r10).longValue());
    }

    public static int d(p r5, Object r10) {
        WireFormat$FieldType r11 = r5.f19201c;
        boolean r12 = r5.d;
        int r13 = r5.f19200b;
        if (r12 == false) goto L20;
        int r14 = 0;
        if (r5.e == false) goto L12;
        Iterator r15 = ((List) r10).iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14 = r14 + c(r11, r15.next());
        goto L8
    L10:
        int r16 = g.h(r13) + r14;
        return g.f(r14) + r16;
    L12:
        Iterator r17 = ((List) r10).iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        Object r18 = r17.next();
        int r19 = g.h(r13);
        if (r11 != WireFormat$FieldType.GROUP) goto L18;
        r19 = r19 * 2;
    L18:
        r14 = r14 + (c(r11, r18) + r19);
        goto L14
    L19:
        return r14;
    L20:
        int r20 = g.h(r13);
        if (r11 != WireFormat$FieldType.GROUP) goto L24;
        r20 = r20 * 2;
    L24:
        return c(r11, r10) + r20;
    }

    public static int e(Map.Entry r5) {
        p r10 = (p) r5.getKey();
        Object r11 = r5.getValue();
        if (r10.f19201c.getJavaType() != WireFormat$JavaType.MESSAGE) goto L11;
        if (r10.d == true) goto L11;
        if (r10.e == true) goto L11;
        int r12 = ((p) r5.getKey()).f19200b;
        int r13 = g.h(1) * 2;
        int r14 = g.h(2);
        int r15 = (g.f(r12) + r14) + r13;
        return g.e(3, (z) r11) + r15;
    L11:
        return d(r10, r11);
    }

    public static boolean f(Map.Entry r5) {
        p r10 = (p) r5.getKey();
        if (r10.f19201c.getJavaType() == WireFormat$JavaType.MESSAGE) goto L5;
        return true;
    L5:
        if (r10.d == false) goto L12;
        Iterator r11 = ((List) r5.getValue()).iterator();
    L8:
        if (r11.hasNext() == false) goto L25;
        if (((z) r11.next()).isInitialized() == true) goto L8;
        return false;
    L25:
        return true;
    L12:
        Object r12 = r5.getValue();
        if ((r12 instanceof z) == false) goto L18;
        if (((z) r12).isInitialized() == true) goto L24;
        return false;
    L24:
        return true;
    L18:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static Object i(f r5, WireFormat$FieldType r10) {
        boolean r11 = true;
        switch(j.f19177b[r10.ordinal()]) {
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L33;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L14;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L12:
        long r12 = r5.l();
        return Long.valueOf((-(r12 & 1)) ^ (r12 >>> 1));
    L14:
        int r13 = r5.k();
        return Integer.valueOf((-(r13 & 1)) ^ (r13 >>> 1));
    L24:
        int r14 = r5.k();
        int r15 = r5.f19159b;
        int r16 = r5.d;
        if (r14 > (r15 - r16)) goto L28;
        if (r14 <= 0) goto L28;
        String r17 = new String(r5.f19158a, r16, r14, "UTF-8");
        r5.d += r14;
        return r17;
    L28:
        if (r14 != 0) goto L31;
        return "";
    L31:
        return new String(r5.h(r14), "UTF-8");
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L17:
        return Long.valueOf(r5.j());
    L19:
        return Integer.valueOf(r5.i());
    L21:
        return Integer.valueOf(r5.k());
    L23:
        return r5.e();
    L33:
        if (r5.l() != 0) goto L37;
        r11 = false;
    L37:
        return Boolean.valueOf(r11);
    L39:
        return Integer.valueOf(r5.i());
    L41:
        return Long.valueOf(r5.j());
    L43:
        return Integer.valueOf(r5.k());
    L45:
        return Long.valueOf(r5.l());
    L47:
        return Long.valueOf(r5.l());
    L49:
        return Float.valueOf(Float.intBitsToFloat(r5.i()));
    L51:
        return Double.valueOf(Double.longBitsToDouble(r5.j()));
    }

    public static void k(WireFormat$FieldType r5, Object r10) {
        r10.getClass();
        boolean r11 = true;
        boolean r12 = false;
        switch(j.f19176a[r5.getJavaType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L14;
            case 8: goto L7;
            case 9: goto L5;
            default: goto L24;
        };
    L5:
        r12 = r10 instanceof z;
        goto L24
    L18:
        r12 = r10 instanceof String;
        goto L24
    L19:
        r12 = r10 instanceof Boolean;
        goto L24
    L20:
        r12 = r10 instanceof Double;
        goto L24
    L21:
        r12 = r10 instanceof Float;
        goto L24
    L22:
        r12 = r10 instanceof Long;
        goto L24
    L23:
        r12 = r10 instanceof Integer;
    L24:
        if (r12 == false) goto L27;
        return;
    L27:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L7:
        if ((r10 instanceof Integer) == false) goto L9;
    L12:
        r12 = r11;
        goto L24
    L9:
        if ((r10 instanceof r) == true) goto L12;
    L11:
        r11 = false;
        goto L12
    L14:
        if ((r10 instanceof e) == true) goto L12;
        if ((r10 instanceof byte[]) == false) goto L11;
        goto L11
    }

    public static void l(g r5, WireFormat$FieldType r10, Object r11) {
        switch(j.f19177b[r10.ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            default: goto L49;
        };
    L9:
        z r12 = (z) r11;
        r5.getClass();
        r5.v(r12.getSerializedSize());
        r12.writeTo(r5);
        return;
    L10:
        r5.getClass();
        ((z) r11).writeTo(r5);
        return;
    L11:
        long r13 = ((Long) r11).longValue();
        long r14 = r13 << 1;
        r5.w((r13 >> 63) ^ r14);
        return;
    L12:
        int r15 = ((Integer) r11).intValue();
        int r16 = r15 << 1;
        r5.v((r15 >> 31) ^ r16);
        return;
    L13:
        r5.u(((Long) r11).longValue());
        return;
    L14:
        r5.t(((Integer) r11).intValue());
        return;
    L15:
        r5.v(((Integer) r11).intValue());
        return;
    L20:
        r5.getClass();
        byte[] r17 = ((String) r11).getBytes("UTF-8");
        r5.v(r17.length);
        r5.s(r17);
        return;
    L21:
        r5.q(((Boolean) r11).booleanValue() ? 1 : 0);
        return;
    L22:
        r5.t(((Integer) r11).intValue());
        return;
    L23:
        r5.u(((Long) r11).longValue());
        return;
    L24:
        r5.o(((Integer) r11).intValue());
        return;
    L25:
        r5.w(((Long) r11).longValue());
        return;
    L26:
        r5.w(((Long) r11).longValue());
        return;
    L27:
        float r18 = ((Float) r11).floatValue();
        r5.getClass();
        r5.t(Float.floatToRawIntBits(r18));
        return;
    L28:
        double r19 = ((Double) r11).doubleValue();
        r5.getClass();
        r5.u(Double.doubleToRawLongBits(r19));
        return;
    L49:
        return;
    L6:
        if ((r11 instanceof r) == false) goto L8;
        r5.o(((r) r11).getNumber());
        return;
    L8:
        r5.o(((Integer) r11).intValue());
        return;
    L17:
        if ((r11 instanceof e) == false) goto L19;
        e r20 = (e) r11;
        r5.getClass();
        r5.v(r20.size());
        r5.r(r20);
        return;
    L19:
        byte[] r21 = (byte[]) r11;
        r5.getClass();
        r5.v(r21.length);
        r5.s(r21);
    }

    public final void a(p r5, Object r10) {
        if (r5.d == false) goto L11;
        k(r5.f19201c, r10);
        g0 r11 = this.f19181a;
        Object r12 = r11.get(r5);
        if (r12 != null) goto L7;
        List r13 = new ArrayList();
        r11.f(r5, r13);
    L8:
        r13.add(r10);
        return;
    L7:
        r13 = (List) r12;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public final k b() {
        k r5 = new k();
        int r10 = 0;
    L3:
        g0 r11 = this.f19181a;
        if (r10 >= r11.f19170b.size()) goto L6;
        Map.Entry r12 = r11.c(r10);
        r5.j((p) r12.getKey(), r12.getValue());
        r10 = r10 + 1;
        goto L3
    L6:
        Iterator r13 = r11.d().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r5.j((p) r14.getKey(), r14.getValue());
        goto L8
    L10:
        return r5;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void g() {
        if (this.f19182b == false) goto L5;
        return;
    L5:
        g0 r5 = this.f19181a;
        if (r5.d == true) goto L21;
        int r10 = 0;
    L9:
        if (r10 >= r5.f19170b.size()) goto L14;
        Map.Entry r11 = r5.c(r10);
        if (((p) r11.getKey()).d == false) goto L13;
        r11.setValue(Collections.unmodifiableList((List) r11.getValue()));
    L13:
        r10 = r10 + 1;
        goto L9
    L14:
        Iterator r12 = r5.d().iterator();
    L16:
        if (r12.hasNext() == false) goto L21;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((p) r13.getKey()).d == false) goto L16;
        r13.setValue(Collections.unmodifiableList((List) r13.getValue()));
    L21:
        if (r5.d == false) goto L23;
    L27:
        this.f19182b = true;
        return;
    L23:
        if (r5.f19171c.isEmpty() == false) goto L25;
        Map r14 = Collections.emptyMap();
    L26:
        r5.f19171c = r14;
        r5.d = true;
        goto L27
    L25:
        r14 = Collections.unmodifiableMap(r5.f19171c);
        goto L26
    }

    public final void h(Map.Entry r10) {
        p r5 = (p) r10.getKey();
        Object r11 = r10.getValue();
        boolean r12 = r5.d;
        g0 r13 = this.f19181a;
        if (r12 == false) goto L16;
        Object r14 = r13.get(r5);
        if (r14 != null) goto L7;
        r14 = new ArrayList();
    L7:
        Iterator r15 = ((List) r11).iterator();
    L9:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        List r17 = (List) r14;
        if ((r16 instanceof byte[]) == false) goto L13;
        byte[] r18 = (byte[]) r16;
        byte[] r19 = new byte[r18.length];
        System.arraycopy(r18, 0, r19, 0, r18.length);
        r16 = r19;
    L13:
        r17.add(r16);
        goto L9
    L14:
        r13.f(r5, r14);
        return;
    L16:
        if (r5.f19201c.getJavaType() != WireFormat$JavaType.MESSAGE) goto L25;
        Object r20 = r13.get(r5);
        if (r20 == null) goto L20;
        r13.f(r5, ((m) ((z) r20).toBuilder()).c((GeneratedMessageLite) ((z) r11)).build());
        return;
    L20:
        if ((r11 instanceof byte[]) == false) goto L22;
        byte[] r21 = (byte[]) r11;
        byte[] r22 = new byte[r21.length];
        System.arraycopy(r21, 0, r22, 0, r21.length);
        r11 = r22;
    L22:
        r13.f(r5, r11);
        return;
    L25:
        if ((r11 instanceof byte[]) == false) goto L27;
        byte[] r23 = (byte[]) r11;
        byte[] r24 = new byte[r23.length];
        System.arraycopy(r23, 0, r24, 0, r23.length);
        r11 = r24;
    L27:
        r13.f(r5, r11);
    }

    public final void j(p r5, Object r10) {
        boolean r11 = r5.d;
        WireFormat$FieldType r12 = r5.f19201c;
        if (r11 == true) goto L5;
        k(r12, r10);
    L14:
        this.f19181a.f(r5, r10);
        return;
    L5:
        if ((r10 instanceof List) == false) goto L12;
        ArrayList r13 = new ArrayList();
        r13.addAll((List) r10);
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        k(r12, r14.next());
        goto L8
    L10:
        r10 = r13;
        goto L14
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public k(int r5) {
        this.f19181a = new g0(0);
        g();
    }
}
