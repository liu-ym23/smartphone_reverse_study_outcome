package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final bu f5001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5002b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    static {
        f5001a = new bu(0, new int[0], new Object[0], false);
    }

    private bu() {
        this(0, new int[8], new Object[8], true);
    }

    private bu(int r2, int[] r3, Object[] r4, boolean r5) {
        this.e = -1;
        this.f5002b = r2;
        this.c = r3;
        this.d = r4;
        this.f = r5;
    }

    private static int a(int[] r3, int r4) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0 = (r0 * 31) + r3[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static int a(Object[] r3, int r4) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0 = (r0 * 31) + r3[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static bu a() {
        return f5001a;
    }

    static bu a(bu r6, bu r7) {
        int r0 = r6.f5002b + r7.f5002b;
        int[] r1 = Arrays.copyOf(r6.c, r0);
        System.arraycopy(r7.c, 0, r1, r6.f5002b, r7.f5002b);
        Object[] r2 = Arrays.copyOf(r6.d, r0);
        System.arraycopy(r7.d, 0, r2, r6.f5002b, r7.f5002b);
        return new bu(r0, r1, r2, true);
    }

    private bu a(k r2) {
    L2:
        int r0 = r2.a();
        if (r0 == 0) goto L6;
        if (a(r0, r2) == true) goto L2;
    L6:
        return this;
    }

    private void a(int r4) {
        int[] r0 = this.c;
        if (r4 <= r0.length) goto L13;
        int r1 = this.f5002b;
        int r2 = r1 + (r1 / 2);
        if (r2 < r4) goto L9;
        r4 = r2;
    L9:
        if (r4 >= 8) goto L11;
        r4 = 8;
    L11:
        this.c = Arrays.copyOf(r0, r4);
        this.d = Arrays.copyOf(this.d, r4);
        return;
    }

    private static void a(int r4, Object r5, Writer r6) {
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r6, Writer.class, "com.obric.memorydata.plugin");
        int r1 = WireFormat.b(r4);
        int r8 = WireFormat.a(r4);
        if (r8 != 0) goto L5;
        r7.a(r1, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L5:
        if (r8 != 1) goto L7;
        r7.d(r1, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L7:
        if (r8 != 2) goto L9;
        r7.a(r1, (ByteString) ZeusTransformUtils.preCheckCast(r5, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (r8 == 3) goto L16;
        if (r8 != 5) goto L14;
        r7.d(r1, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L14:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L16:
        if (r7.a() != Writer.FieldOrder.ASCENDING) goto L18;
        r7.a(r1);
        ((bu) ZeusTransformUtils.preCheckCast(r5, bu.class, "com.obric.memorydata.plugin")).b(r7);
        r7.b(r1);
        return;
    L18:
        r7.b(r1);
        ((bu) ZeusTransformUtils.preCheckCast(r5, bu.class, "com.obric.memorydata.plugin")).b(r7);
        r7.a(r1);
    }

    private static boolean a(int[] r4, int[] r5, int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        if (r4[r1] != r5[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean a(Object[] r4, Object[] r5, int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        if (r4[r1].equals(r5[r1]) == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    static bu b() {
        return new bu();
    }

    bu a(int r3, int r4) {
        d();
        if (r3 == 0) goto L7;
        a(WireFormat.a(r3, 0), Long.valueOf(r4));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    bu a(int r2, ByteString r3) {
        d();
        if (r2 == 0) goto L7;
        a(WireFormat.a(r2, 2), r3);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    bu a(bu r7) {
        if (r7.equals(a()) == false) goto L5;
        return this;
    L5:
        d();
        int r0 = this.f5002b + r7.f5002b;
        a(r0);
        System.arraycopy(r7.c, 0, this.c, this.f5002b, r7.f5002b);
        System.arraycopy(r7.d, 0, this.d, this.f5002b, r7.f5002b);
        this.f5002b = r0;
        return this;
    }

    void a(int r3, Object r4) {
        d();
        a(this.f5002b + 1);
        int[] r0 = this.c;
        int r1 = this.f5002b;
        r0[r1] = r3;
        this.d[r1] = r4;
        this.f5002b = r1 + 1;
    }

    void a(Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5.a() != Writer.FieldOrder.DESCENDING) goto L7;
        int r0 = this.f5002b - 1;
    L5:
        if (r0 < 0) goto L11;
        r5.a(WireFormat.b(this.c[r0]), this.d[r0]);
        r0 = r0 - 1;
        goto L5
    L11:
        return;
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.f5002b) goto L14;
        r5.a(WireFormat.b(this.c[r1]), this.d[r1]);
        r1 = r1 + 1;
        goto L9
    }

    final void a(StringBuilder r4, int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f5002b) goto L6;
        av.a(r4, r5, String.valueOf(WireFormat.b(this.c[r0])), this.d[r0]);
        r0 = r0 + 1;
        goto L4
    }

    boolean a(int r6, k r7) {
        d();
        int r0 = WireFormat.b(r6);
        int r1 = WireFormat.a(r6);
        if (r1 == 0) goto L24;
        if (r1 != 1) goto L6;
        a(r6, Long.valueOf(r7.g()));
        return true;
    L6:
        if (r1 != 2) goto L8;
        a(r6, r7.l());
        return true;
    L8:
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L11;
        return false;
    L11:
        if (r1 != 5) goto L15;
        a(r6, Integer.valueOf(r7.h()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        bu r2 = new bu();
        r2.a(r7);
        r7.a(WireFormat.a(r0, 4));
        a(r6, r2);
        return true;
    L24:
        a(r6, Long.valueOf(r7.e()));
        return true;
    }

    public void b(Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (this.f5002b != 0) goto L6;
        return;
    L6:
        if (r5.a() != Writer.FieldOrder.ASCENDING) goto L11;
        int r0 = 0;
    L9:
        if (r0 >= this.f5002b) goto L14;
        a(this.c[r0], this.d[r0], r5);
        r0 = r0 + 1;
        goto L9
    L14:
        return;
    L11:
        int r1 = this.f5002b - 1;
    L12:
        if (r1 < 0) goto L17;
        a(this.c[r1], this.d[r1], r5);
        r1 = r1 - 1;
        goto L12
    }

    public void c() {
        if (this.f == false) goto L6;
        this.f = false;
        return;
    }

    void d() {
        if (this.f == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public int e() {
        int r0 = this.e;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f5002b) goto L9;
        r2 = r2 + CodedOutputStream.d(WireFormat.b(this.c[r1]), (ByteString) ZeusTransformUtils.preCheckCast(this.d[r1], ByteString.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L7
    L9:
        this.e = r2;
        return r2;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, bu.class) == true) goto L11;
        return false;
    L11:
        bu r7 = (bu) ZeusTransformUtils.preCheckCast(r6, bu.class, "com.obric.memorydata.plugin");
        int r0 = this.f5002b;
        if (r0 == r7.f5002b) goto L14;
    L19:
        return false;
    L14:
        if (a(this.c, r7.c, r0) == false) goto L19;
        if (a(this.d, r7.d, this.f5002b) == false) goto L19;
        return true;
    }

    public int f() {
        int r0 = this.e;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f5002b) goto L26;
        int r3 = this.c[r1];
        int r4 = WireFormat.b(r3);
        int r5 = WireFormat.a(r3);
        if (r5 != 0) goto L11;
        int r6 = CodedOutputStream.g(r4, ((Long) ZeusTransformUtils.preCheckCast(this.d[r1], Long.class, "com.obric.memorydata.plugin")).longValue());
    L25:
        r2 = r2 + r6;
        r1 = r1 + 1;
        goto L7
    L11:
        if (r5 != 1) goto L13;
        r6 = CodedOutputStream.i(r4, ((Long) ZeusTransformUtils.preCheckCast(this.d[r1], Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L25
    L13:
        if (r5 != 2) goto L15;
        r6 = CodedOutputStream.c(r4, (ByteString) ZeusTransformUtils.preCheckCast(this.d[r1], ByteString.class, "com.obric.memorydata.plugin"));
        goto L25
    L15:
        if (r5 != 3) goto L17;
        r6 = (CodedOutputStream.h(r4) * 2) + ((bu) ZeusTransformUtils.preCheckCast(this.d[r1], bu.class, "com.obric.memorydata.plugin")).f();
        goto L25
    L17:
        if (r5 != 5) goto L20;
        r6 = CodedOutputStream.k(r4, ((Integer) ZeusTransformUtils.preCheckCast(this.d[r1], Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L26:
        this.e = r2;
        return r2;
    }

    public int hashCode() {
        int r0 = this.f5002b;
        return ((((527 + r0) * 31) + a(this.c, r0)) * 31) + a(this.d, this.f5002b);
    }
}
