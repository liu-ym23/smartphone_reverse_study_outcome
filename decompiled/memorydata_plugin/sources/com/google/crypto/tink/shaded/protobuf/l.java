package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class l implements bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f5024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5025b;
    private int c;
    private int d;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5026a = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f5026a = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            f5026a[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            f5026a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            f5026a[WireFormat.FieldType.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            f5026a[WireFormat.FieldType.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            f5026a[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            f5026a[WireFormat.FieldType.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            f5026a[WireFormat.FieldType.INT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            f5026a[WireFormat.FieldType.INT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            f5026a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            f5026a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            f5026a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            f5026a[WireFormat.FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            f5026a[WireFormat.FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            f5026a[WireFormat.FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            f5026a[WireFormat.FieldType.UINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            f5026a[WireFormat.FieldType.UINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    private l(k r3) {
        this.d = 0;
        k r4 = (k) ZeusTransformUtils.preCheckCast(ab.a(r3, "input"), k.class, "com.obric.memorydata.plugin");
        this.f5024a = r4;
        r4.d = this;
    }

    public static l a(k r1) {
        if (r1.d == null) goto L7;
        return r1.d;
    L7:
        return new l(r1);
    }

    private Object a(WireFormat.FieldType r2, Class<?> r3, q r4) {
        switch(AnonymousClass1.f5026a[r2.ordinal()]) {
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            case 13: goto L15;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L9;
            case 17: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("unsupported field type.");
    L7:
        return Long.valueOf(f());
    L9:
        return Integer.valueOf(o());
    L11:
        return m();
    L13:
        return Long.valueOf(t());
    L15:
        return Integer.valueOf(s());
    L17:
        return Long.valueOf(r());
    L19:
        return Integer.valueOf(q());
    L21:
        return a(r3, r4);
    L23:
        return Long.valueOf(g());
    L25:
        return Integer.valueOf(h());
    L27:
        return Float.valueOf(e());
    L29:
        return Long.valueOf(i());
    L31:
        return Integer.valueOf(j());
    L33:
        return Integer.valueOf(p());
    L35:
        return Double.valueOf(d());
    L37:
        return n();
    L39:
        return Boolean.valueOf(k());
    }

    private <T> T a(bl<T> r3, q r4) {
        bl<T> r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        T r0 = r5.a();
        c(r0, r5, r4);
        r5.d(r0);
        return r0;
    }

    private void a(int r1) {
        if (WireFormat.a(this.f5025b) != r1) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    private <T> T b(bl<T> r3, q r4) {
        bl<T> r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        T r0 = r5.a();
        d(r0, r5, r4);
        r5.d(r0);
        return r0;
    }

    private void b(int r1) {
        if ((r1 & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void c(int r1) {
        if ((r1 & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private <T> void c(T r4, bl<T> r5, q r6) {
        bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        int r0 = this.f5024a.m();
        if (this.f5024a.f5022a >= this.f5024a.f5023b) goto L7;
        int r1 = this.f5024a.c(r0);
        this.f5024a.f5022a++;
        r7.a(r4, this, r6);
        this.f5024a.a(0);
        this.f5024a.f5022a--;
        this.f5024a.d(r1);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private void d(int r1) {
        if (this.f5024a.u() != r1) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private <T> void d(T r4, bl<T> r5, q r6) {
        bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        int r0 = this.c;
        this.c = WireFormat.a(WireFormat.b(this.f5025b), 4);
        r7.a(r4, this, r6);     // Catch: Throwable -> L9
        if (this.f5025b != this.c) goto L8;
        this.c = r0;
        return;
    L8:
        throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.c = r0;
        throw th;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int a() {
        int r0 = this.d;
        if (r0 == 0) goto L5;
        this.f5025b = r0;
        this.d = 0;
    L6:
        int r1 = this.f5025b;
        if (r1 != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r1 != this.c) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.b(r1);
    L5:
        this.f5025b = this.f5024a.a();
        goto L6
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public <T> T a(Class<T> r2, q r3) {
        a(2);
        return (T) a(bg.a().a(r2), r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public <T> void a(T r3, bl<T> r4, q r5) {
        bl<T> r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        a(2);
        c(r3, r6, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void a(List<Double> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, n.class) == false) goto L20;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        b(r8);
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.b());
        if (this.f5024a.u() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.b());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.f5024a.m();
        b(r3);
        int r4 = this.f5024a.u() + r3;
    L24:
        r6.add(Double.valueOf(this.f5024a.b()));
        if (this.f5024a.u() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Double.valueOf(this.f5024a.b()));
        if (this.f5024a.t() == true) goto L31;
        int r10 = this.f5024a.a();
        if (r10 == this.f5025b) goto L29;
        this.d = r10;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public <T> void a(List<T> r3, bl<T> r4, q r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        bl<T> r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        if (WireFormat.a(this.f5025b) != 2) goto L15;
        int r0 = this.f5025b;
    L5:
        r6.add(a(r7, r5));
        if (this.f5024a.t() == true) goto L20;
        if (this.d != 0) goto L21;
        int r1 = this.f5024a.a();
        if (r1 == r0) goto L5;
        this.d = r1;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void a(List<String> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (WireFormat.a(this.f5025b) != 2) goto L26;
        if (ZeusTransformUtils.instanceOf(r6, ah.class) == false) goto L15;
        if (r5 == true) goto L15;
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(r6, ah.class, "com.obric.memorydata.plugin");
    L8:
        r0.a(n());
        if (this.f5024a.t() == true) goto L10;
        int r7 = this.f5024a.a();
        if (r7 == this.f5025b) goto L8;
        this.d = r7;
        return;
    L10:
        return;
    L15:
        if (r5 == false) goto L17;
        String r1 = m();
    L18:
        r6.add(r1);
        if (this.f5024a.t() == true) goto L20;
        int r2 = this.f5024a.a();
        if (r2 == this.f5025b) goto L15;
        this.d = r2;
        return;
    L20:
        return;
    L17:
        r1 = l();
        goto L18
    L26:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public <K, V> void a(Map<K, V> r8, an.a<K, V> r9, q r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        a(2);
        int r1 = this.f5024a.m();
        int r2 = this.f5024a.c(r1);
        Object r3 = r9.f4961b;
        Object r4 = r9.d;
    L32:
        int r5 = a();     // Catch: Throwable -> L27
        if (r5 == Integer.MAX_VALUE) goto L24;
        if (this.f5024a.t() == true) goto L24;
        if (r5 != 1) goto L10;
        r3 = a(r9.f4960a, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
        goto L32
    L10:
        if (r5 == 2) goto L16;
        if (c() == true) goto L32;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
    L20:
        if (c() == true) goto L32;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L27
    L16:
        r4 = a(r9.c, r9.d.getClass(), r10);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
    L24:
        r11.put(r3, r4);     // Catch: Throwable -> L27
        this.f5024a.d(r2);
        return;
    L27:
        th = move-exception;
        this.f5024a.d(r2);
        throw th;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int b() {
        return this.f5025b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    @Deprecated
    public <T> T b(Class<T> r2, q r3) {
        a(3);
        return (T) b(bg.a().a(r2), r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public <T> void b(T r3, bl<T> r4, q r5) {
        bl<T> r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        a(3);
        d(r3, r6, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void b(List<Float> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, x.class) == false) goto L20;
        x r0 = (x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.a(this.f5024a.c());
        if (this.f5024a.t() == true) goto L9;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L7;
        this.d = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.f5024a.m();
        c(r9);
        int r1 = this.f5024a.u() + r9;
    L17:
        r0.a(this.f5024a.c());
        if (this.f5024a.u() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Float.valueOf(this.f5024a.c()));
        if (this.f5024a.t() == true) goto L25;
        int r3 = this.f5024a.a();
        if (r3 == this.f5025b) goto L23;
        this.d = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.f5024a.m();
        c(r4);
        int r10 = this.f5024a.u() + r4;
    L33:
        r6.add(Float.valueOf(this.f5024a.c()));
        if (this.f5024a.u() < r10) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    @Deprecated
    public <T> void b(List<T> r3, bl<T> r4, q r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        bl<T> r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        if (WireFormat.a(this.f5025b) != 3) goto L15;
        int r0 = this.f5025b;
    L5:
        r6.add(b(r7, r5));
        if (this.f5024a.t() == true) goto L20;
        if (this.d != 0) goto L21;
        int r1 = this.f5024a.a();
        if (r1 == r0) goto L5;
        this.d = r1;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void c(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, al.class) == false) goto L20;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r6, al.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.d());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.d());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r6.add(Long.valueOf(this.f5024a.d()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.f5024a.d()));
        if (this.f5024a.t() == true) goto L32;
        int r4 = this.f5024a.a();
        if (r4 == this.f5025b) goto L30;
        this.d = r4;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public boolean c() {
        if (this.f5024a.t() == true) goto L9;
        int r0 = this.f5025b;
        if (r0 != this.c) goto L8;
        return false;
    L8:
        return this.f5024a.b(r0);
    L9:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public double d() {
        a(1);
        return this.f5024a.b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void d(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, al.class) == false) goto L20;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r6, al.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.e());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.e());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r6.add(Long.valueOf(this.f5024a.e()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.f5024a.e()));
        if (this.f5024a.t() == true) goto L32;
        int r4 = this.f5024a.a();
        if (r4 == this.f5025b) goto L30;
        this.d = r4;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public float e() {
        a(5);
        return this.f5024a.c();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void e(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.a(this.f5025b);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.f5024a.m();
        int r1 = this.f5024a.u() + r7;
    L8:
        r0.d(this.f5024a.f());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.d(this.f5024a.f());
        if (this.f5024a.t() == true) goto L15;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L13;
        this.d = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r5.add(Integer.valueOf(this.f5024a.f()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.f5024a.f()));
        if (this.f5024a.t() == true) goto L32;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L30;
        this.d = r9;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public long f() {
        a(0);
        return this.f5024a.d();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void f(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, al.class) == false) goto L20;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r6, al.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        b(r8);
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.g());
        if (this.f5024a.u() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.g());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.f5024a.m();
        b(r3);
        int r4 = this.f5024a.u() + r3;
    L24:
        r6.add(Long.valueOf(this.f5024a.g()));
        if (this.f5024a.u() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Long.valueOf(this.f5024a.g()));
        if (this.f5024a.t() == true) goto L31;
        int r10 = this.f5024a.a();
        if (r10 == this.f5025b) goto L29;
        this.d = r10;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public long g() {
        a(0);
        return this.f5024a.e();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void g(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r6, aa.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.d(this.f5024a.h());
        if (this.f5024a.t() == true) goto L9;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L7;
        this.d = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.f5024a.m();
        c(r9);
        int r1 = this.f5024a.u() + r9;
    L17:
        r0.d(this.f5024a.h());
        if (this.f5024a.u() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Integer.valueOf(this.f5024a.h()));
        if (this.f5024a.t() == true) goto L25;
        int r3 = this.f5024a.a();
        if (r3 == this.f5025b) goto L23;
        this.d = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.f5024a.m();
        c(r4);
        int r10 = this.f5024a.u() + r4;
    L33:
        r6.add(Integer.valueOf(this.f5024a.h()));
        if (this.f5024a.u() < r10) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int h() {
        a(0);
        return this.f5024a.f();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void h(List<Boolean> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L20;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.a(this.f5025b);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.f5024a.m();
        int r1 = this.f5024a.u() + r7;
    L8:
        r0.a(this.f5024a.i());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.i());
        if (this.f5024a.t() == true) goto L15;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L13;
        this.d = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r5.add(Boolean.valueOf(this.f5024a.i()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Boolean.valueOf(this.f5024a.i()));
        if (this.f5024a.t() == true) goto L32;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L30;
        this.d = r9;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public long i() {
        a(1);
        return this.f5024a.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void i(List<String> r3) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int j() {
        a(5);
        return this.f5024a.h();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void j(List<String> r3) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void k(List<ByteString> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (WireFormat.a(this.f5025b) != 2) goto L12;
    L4:
        r4.add(n());
        if (this.f5024a.t() == true) goto L6;
        int r0 = this.f5024a.a();
        if (r0 == this.f5025b) goto L4;
        this.d = r0;
        return;
    L6:
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public boolean k() {
        a(0);
        return this.f5024a.i();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public String l() {
        a(2);
        return this.f5024a.j();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void l(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.a(this.f5025b);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.f5024a.m();
        int r1 = this.f5024a.u() + r7;
    L8:
        r0.d(this.f5024a.m());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.d(this.f5024a.m());
        if (this.f5024a.t() == true) goto L15;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L13;
        this.d = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r5.add(Integer.valueOf(this.f5024a.m()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.f5024a.m()));
        if (this.f5024a.t() == true) goto L32;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L30;
        this.d = r9;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public String m() {
        a(2);
        return this.f5024a.k();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void m(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.a(this.f5025b);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.f5024a.m();
        int r1 = this.f5024a.u() + r7;
    L8:
        r0.d(this.f5024a.n());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.d(this.f5024a.n());
        if (this.f5024a.t() == true) goto L15;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L13;
        this.d = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r5.add(Integer.valueOf(this.f5024a.n()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.f5024a.n()));
        if (this.f5024a.t() == true) goto L32;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L30;
        this.d = r9;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public ByteString n() {
        a(2);
        return this.f5024a.l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void n(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r6, aa.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.d(this.f5024a.o());
        if (this.f5024a.t() == true) goto L9;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L7;
        this.d = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.f5024a.m();
        c(r9);
        int r1 = this.f5024a.u() + r9;
    L17:
        r0.d(this.f5024a.o());
        if (this.f5024a.u() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Integer.valueOf(this.f5024a.o()));
        if (this.f5024a.t() == true) goto L25;
        int r3 = this.f5024a.a();
        if (r3 == this.f5025b) goto L23;
        this.d = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.f5024a.m();
        c(r4);
        int r10 = this.f5024a.u() + r4;
    L33:
        r6.add(Integer.valueOf(this.f5024a.o()));
        if (this.f5024a.u() < r10) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int o() {
        a(0);
        return this.f5024a.m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void o(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, al.class) == false) goto L20;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r6, al.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        b(r8);
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.p());
        if (this.f5024a.u() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.p());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.f5024a.m();
        b(r3);
        int r4 = this.f5024a.u() + r3;
    L24:
        r6.add(Long.valueOf(this.f5024a.p()));
        if (this.f5024a.u() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Long.valueOf(this.f5024a.p()));
        if (this.f5024a.t() == true) goto L31;
        int r10 = this.f5024a.a();
        if (r10 == this.f5025b) goto L29;
        this.d = r10;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int p() {
        a(0);
        return this.f5024a.n();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void p(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == false) goto L20;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.a(this.f5025b);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.f5024a.m();
        int r1 = this.f5024a.u() + r7;
    L8:
        r0.d(this.f5024a.q());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.d(this.f5024a.q());
        if (this.f5024a.t() == true) goto L15;
        int r8 = this.f5024a.a();
        if (r8 == this.f5025b) goto L13;
        this.d = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r5.add(Integer.valueOf(this.f5024a.q()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.f5024a.q()));
        if (this.f5024a.t() == true) goto L32;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L30;
        this.d = r9;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int q() {
        a(5);
        return this.f5024a.o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public void q(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, al.class) == false) goto L20;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r6, al.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.a(this.f5025b);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.f5024a.m();
        int r1 = this.f5024a.u() + r8;
    L8:
        r0.a(this.f5024a.r());
        if (this.f5024a.u() < r1) goto L8;
    L26:
        d(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.a(this.f5024a.r());
        if (this.f5024a.t() == true) goto L15;
        int r9 = this.f5024a.a();
        if (r9 == this.f5025b) goto L13;
        this.d = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.a(this.f5025b);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.f5024a.m();
        r1 = this.f5024a.u() + r3;
    L24:
        r6.add(Long.valueOf(this.f5024a.r()));
        if (this.f5024a.u() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.f5024a.r()));
        if (this.f5024a.t() == true) goto L32;
        int r4 = this.f5024a.a();
        if (r4 == this.f5025b) goto L30;
        this.d = r4;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public long r() {
        a(1);
        return this.f5024a.p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public int s() {
        a(0);
        return this.f5024a.q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bk
    public long t() {
        a(0);
        return this.f5024a.r();
    }
}
