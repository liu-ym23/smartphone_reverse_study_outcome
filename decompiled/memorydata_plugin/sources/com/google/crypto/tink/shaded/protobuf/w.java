package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.w.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class w<T extends a<T>> {
    private static final w d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bo<T, Object> f5042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5043b;
    private boolean c;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5044a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5045b = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f5045b = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            f5045b[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            f5045b[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            f5045b[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            f5045b[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            f5045b[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            f5045b[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            f5045b[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            f5045b[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            f5045b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            f5045b[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            f5045b[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            f5045b[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            f5045b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            f5045b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            f5045b[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            f5045b[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            f5045b[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r9 = new int[WireFormat.JavaType.values().length];
            f5044a = r9;
            r9[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            f5044a[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            f5044a[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            f5044a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            f5044a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            f5044a[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            f5044a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            f5044a[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            f5044a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public interface a<T extends a<T>> extends Comparable<T> {
        int a();

        at.a a(at.a r1, at r2);

        WireFormat.FieldType b();

        WireFormat.JavaType c();

        boolean d();

        boolean e();
    }

    static {
        d = new w(true);
    }

    private w() {
        this.f5042a = bo.a(16);
    }

    private w(bo<T, Object> r1) {
        this.f5042a = r1;
        d();
    }

    private w(boolean r1) {
        this(bo.a(0));
        d();
    }

    static int a(WireFormat.FieldType r1, int r2, Object r3) {
        int r4 = CodedOutputStream.h(r2);
        if (r1 != WireFormat.FieldType.GROUP) goto L6;
        r4 = r4 * 2;
    L6:
        return r4 + a(r1, r3);
    }

    static int a(WireFormat.FieldType r1, Object r2) {
        switch(AnonymousClass1.f5045b[r1.ordinal()]) {
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L47;
            case 7: goto L45;
            case 8: goto L43;
            case 9: goto L41;
            case 10: goto L35;
            case 11: goto L29;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ab.c.class) == false) goto L11;
        return CodedOutputStream.n(((ab.c) ZeusTransformUtils.preCheckCast(r2, ab.c.class, "com.obric.memorydata.plugin")).getNumber());
    L11:
        return CodedOutputStream.n(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L13:
        return CodedOutputStream.h(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L15:
        return CodedOutputStream.k(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L17:
        return CodedOutputStream.j(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L19:
        return CodedOutputStream.m(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L21:
        return CodedOutputStream.j(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L23:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L27;
        return CodedOutputStream.b((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
    L27:
        return CodedOutputStream.c((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    L29:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L33;
        return CodedOutputStream.b((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
    L33:
        return CodedOutputStream.b((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L35:
        if (ZeusTransformUtils.instanceOf(r2, ae.class) == false) goto L39;
        return CodedOutputStream.a((ae) ZeusTransformUtils.preCheckCast(r2, ae.class, "com.obric.memorydata.plugin"));
    L39:
        return CodedOutputStream.b((at) ZeusTransformUtils.preCheckCast(r2, at.class, "com.obric.memorydata.plugin"));
    L41:
        return CodedOutputStream.d((at) ZeusTransformUtils.preCheckCast(r2, at.class, "com.obric.memorydata.plugin"));
    L43:
        return CodedOutputStream.b(((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L45:
        return CodedOutputStream.l(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L47:
        return CodedOutputStream.i(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L49:
        return CodedOutputStream.i(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L51:
        return CodedOutputStream.g(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L53:
        return CodedOutputStream.f(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L55:
        return CodedOutputStream.b(((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L57:
        return CodedOutputStream.b(((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    }

    static int a(WireFormat.FieldType r0, boolean r1) {
        if (r1 == false) goto L6;
        return 2;
    L6:
        return r0.getWireType();
    }

    public static <T extends a<T>> w<T> a() {
        return new w();
    }

    static void a(CodedOutputStream r1, WireFormat.FieldType r2, int r3, Object r4) {
        if (r2 != WireFormat.FieldType.GROUP) goto L5;
        r1.d(r3, (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1.a(r3, a(r2, false));
        a(r1, r2, r4);
    }

    static void a(CodedOutputStream r1, WireFormat.FieldType r2, Object r3) {
        switch(AnonymousClass1.f5045b[r2.ordinal()]) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L20;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L6;
            default: goto L52;
        };
    L10:
        r1.c(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L11:
        r1.d(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L12:
        r1.e(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L13:
        r1.f(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L14:
        r1.c(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L23:
        r1.a((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin"));
        return;
    L24:
        r1.c((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin"));
        return;
    L25:
        r1.a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L26:
        r1.e(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L27:
        r1.d(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L28:
        r1.b(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L29:
        r1.b(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L30:
        r1.a(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L31:
        r1.a(((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L32:
        r1.a(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L52:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ab.c.class) == false) goto L8;
        int r4 = ((ab.c) ZeusTransformUtils.preCheckCast(r3, ab.c.class, "com.obric.memorydata.plugin")).getNumber();
    L9:
        r1.g(r4);
        return;
    L8:
        r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L9
    L16:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == true) goto L21;
        r1.b((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        return;
    L21:
        r1.a((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == true) goto L21;
        r1.a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    private static boolean a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, au.class) == false) goto L7;
        return ((au) ZeusTransformUtils.preCheckCast(r2, au.class, "com.obric.memorydata.plugin")).isInitialized();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ae.class) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static <T extends a<T>> boolean a(Map.Entry<T, Object> r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5.getKey(), a.class, "com.obric.memorydata.plugin");
        if (r0.c() != WireFormat.JavaType.MESSAGE) goto L15;
        boolean r1 = r0.d();
        Object r6 = r5.getValue();
        if (r1 == false) goto L14;
        Iterator r7 = ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r7.hasNext() == false) goto L20;
        if (a(r7.next()) == true) goto L8;
        return false;
    L20:
        return true;
    L14:
        return a(r6);
    L15:
        return true;
    }

    public static <T extends a<T>> w<T> b() {
        return d;
    }

    private static Object b(Object r3) {
        if ((r3 instanceof byte[]) == false) goto L6;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[r4.length];
        System.arraycopy(r4, 0, r0, 0, r4.length);
        return r0;
    L6:
        return r3;
    }

    private void b(Map.Entry<T, Object> r6) {
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.memorydata.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7.getKey(), a.class, "com.obric.memorydata.plugin");
        Object r8 = r7.getValue();
        if (ZeusTransformUtils.instanceOf(r8, ae.class) == false) goto L6;
        r8 = ((ae) ZeusTransformUtils.preCheckCast(r8, ae.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (r0.d() == false) goto L16;
        Object r2 = a(r0);
        if (r2 != null) goto L10;
        r2 = new ArrayList();
    L10:
        Iterator r9 = ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Object r3 = r9.next();
        ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).add(b(r3));
        goto L12
    L14:
        this.f5042a.a(r0, r2);
        return;
    L16:
        if (r0.c() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r4 = a(r0);
        if (r4 == null) goto L21;
        Object r10 = r0.a(((at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin")).toBuilder(), (at) ZeusTransformUtils.preCheckCast(r8, at.class, "com.obric.memorydata.plugin")).c();
        bo<T, Object> r5 = this.f5042a;
    L22:
        r5.a(r0, r10);
        return;
    L21:
        r5 = this.f5042a;
        r10 = b(r8);
        goto L22
    }

    private static boolean b(WireFormat.FieldType r2, Object r3) {
        ab.a(r3);
        switch(AnonymousClass1.f5044a[r2.getJavaType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L26;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L26:
        Class r4 = String.class;
    L28:
        return ZeusTransformUtils.instanceOf(r3, r4);
    L29:
        r4 = Boolean.class;
        goto L28
    L30:
        r4 = Double.class;
        goto L28
    L31:
        r4 = Float.class;
        goto L28
    L32:
        r4 = Long.class;
        goto L28
    L33:
        r4 = Integer.class;
        goto L28
    L6:
        if (ZeusTransformUtils.instanceOf(r3, at.class) == false) goto L8;
        return true;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, ae.class) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, ab.c.class) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == false) goto L22;
        return true;
    L22:
        if ((r3 instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public static int c(a<?> r4, Object r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        WireFormat.FieldType r0 = r6.b();
        int r2 = r6.a();
        if (r6.d() == false) goto L21;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r6.e() == true) goto L7;
        Iterator r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        r1 = r1 + a(r0, r2, r8.next());
        goto L17
    L19:
        return r1;
    L7:
        if (r7.isEmpty() == false) goto L9;
        return 0;
    L9:
        Iterator r9 = r7.iterator();
    L11:
        if (r9.hasNext() == false) goto L14;
        r1 = r1 + a(r0, r9.next());
        goto L11
    L14:
        return (CodedOutputStream.h(r2) + r1) + CodedOutputStream.j(r1);
    L21:
        return a(r0, r2, r5);
    }

    private int c(Map.Entry<T, Object> r5) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        a r6 = (a) ZeusTransformUtils.preCheckCast(r4.getKey(), a.class, "com.obric.memorydata.plugin");
        Object r1 = r4.getValue();
        if (r6.c() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r6.d() == true) goto L15;
        if (r6.e() == true) goto L15;
        boolean r7 = ZeusTransformUtils.instanceOf(r1, ae.class);
        Object r8 = r4.getKey();
        if (r7 == false) goto L13;
        return CodedOutputStream.b(((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin")).a(), (ae) ZeusTransformUtils.preCheckCast(r1, ae.class, "com.obric.memorydata.plugin"));
    L13:
        return CodedOutputStream.c(((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin")).a(), (at) ZeusTransformUtils.preCheckCast(r1, at.class, "com.obric.memorydata.plugin"));
    L15:
        return c(r6, r1);
    }

    private void d(T r4, Object r5) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (b(r3.b(), r5) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r3.a()), r3.b().getJavaType(), r5.getClass().getName()}));
    }

    public Object a(T r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r2 = this.f5042a.get(r4);
        if (ZeusTransformUtils.instanceOf(r2, ae.class) == true) goto L5;
        return r2;
    L5:
        return ((ae) ZeusTransformUtils.preCheckCast(r2, ae.class, "com.obric.memorydata.plugin")).a();
    }

    public void a(T r4, Object r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r6.d() == true) goto L5;
        d(r6, r5);
    L15:
        if (ZeusTransformUtils.instanceOf(r5, ae.class) == false) goto L17;
        this.c = true;
    L17:
        this.f5042a.a(r6, r5);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.addAll((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
        Iterator r7 = r0.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        d(r6, r7.next());
        goto L8
    L10:
        r5 = r0;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void a(w<T> r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.f5042a.c()) goto L6;
        b(r4.f5042a.b(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r5 = r4.f5042a.e().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        b((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    public void b(T r3, Object r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (r5.d() == false) goto L11;
        d(r5, r4);
        Object r0 = a(r5);
        if (r0 != null) goto L7;
        List r1 = new ArrayList();
        this.f5042a.a(r5, r1);
    L8:
        r1.add(r4);
        return;
    L7:
        r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    boolean c() {
        return this.f5042a.isEmpty();
    }

    public /* synthetic */ Object clone() {
        return f();
    }

    public void d() {
        if (this.f5043b == false) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.f5042a.c()) goto L12;
        Map.Entry<K, Object> r1 = this.f5042a.b(r0);
        if (ZeusTransformUtils.instanceOf(r1.getValue(), GeneratedMessageLite.class) == false) goto L11;
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r1.getValue(), GeneratedMessageLite.class, "com.obric.memorydata.plugin")).makeImmutable();
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        this.f5042a.a();
        this.f5043b = true;
    }

    public boolean e() {
        return this.f5043b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, w.class) == true) goto L10;
        return false;
    L10:
        w r4 = (w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin");
        return this.f5042a.equals(r4.f5042a);
    }

    public w<T> f() {
        w<T> r0 = a();
        int r1 = 0;
    L4:
        if (r1 >= this.f5042a.c()) goto L6;
        Map.Entry<K, Object> r2 = this.f5042a.b(r1);
        r0.a((a) ZeusTransformUtils.preCheckCast(r2.getKey(), a.class, "com.obric.memorydata.plugin"), r2.getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r3 = this.f5042a.e().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a((a) ZeusTransformUtils.preCheckCast(r4.getKey(), a.class, "com.obric.memorydata.plugin"), r4.getValue());
        goto L8
    L10:
        r0.c = this.c;
        return r0;
    }

    public Iterator<Map.Entry<T, Object>> g() {
        if (this.c == false) goto L7;
        return new ae.b(this.f5042a.entrySet().iterator());
    L7:
        return this.f5042a.entrySet().iterator();
    }

    Iterator<Map.Entry<T, Object>> h() {
        if (this.c == false) goto L7;
        return new ae.b(this.f5042a.f().iterator());
    L7:
        return this.f5042a.f().iterator();
    }

    public int hashCode() {
        return this.f5042a.hashCode();
    }

    public boolean i() {
        int r1 = 0;
    L4:
        if (r1 >= this.f5042a.c()) goto L9;
        if (a(this.f5042a.b(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r4 = this.f5042a.e().iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        if (a((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")) == true) goto L11;
        return false;
    L15:
        return true;
    }

    public int j() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.f5042a.c()) goto L6;
        Map.Entry<K, Object> r2 = this.f5042a.b(r0);
        r1 = r1 + c((a) ZeusTransformUtils.preCheckCast(r2.getKey(), a.class, "com.obric.memorydata.plugin"), r2.getValue());
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r6 = this.f5042a.e().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1 = r1 + c((a) ZeusTransformUtils.preCheckCast(r3.getKey(), a.class, "com.obric.memorydata.plugin"), r3.getValue());
        goto L8
    L10:
        return r1;
    }

    public int k() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.f5042a.c()) goto L6;
        r1 = r1 + c(this.f5042a.b(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r2 = this.f5042a.e().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1 = r1 + c((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return r1;
    }
}
