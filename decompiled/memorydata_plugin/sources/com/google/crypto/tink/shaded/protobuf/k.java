package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    private static volatile int e = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5023b;
    int c;
    l d;
    private boolean f;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a extends k {
        private final byte[] e;
        private final boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private int m;

        private a(byte[] r2, int r3, int r4, boolean r5) {
            super(null);
            this.m = Integer.MAX_VALUE;
            this.e = r2;
            this.g = r4 + r3;
            this.i = r3;
            this.j = r3;
            this.f = r5;
        }

        /* synthetic */ a(byte[] r1, int r2, int r3, boolean r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        private void B() {
            if ((this.g - this.i) < 10) goto L5;
            C();
            return;
        L5:
            D();
        }

        private void C() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            byte[] r1 = this.e;
            int r2 = this.i;
            this.i = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void D() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (A() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void E() {
            int r0 = this.g + this.h;
            this.g = r0;
            int r1 = r0 - this.j;
            int r2 = this.m;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.h = r3;
            this.g = r0 - r3;
            return;
        L5:
            this.h = 0;
        }

        public byte A() {
            int r0 = this.i;
            if (r0 == this.g) goto L7;
            byte[] r1 = this.e;
            this.i = r0 + 1;
            return r1[r0];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int a() {
            if (t() == false) goto L6;
            this.k = 0;
            return 0;
        L6:
            int r0 = w();
            this.k = r0;
            if (WireFormat.b(r0) == 0) goto L11;
            return this.k;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void a(int r1) {
            if (this.k != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public double b() {
            return Double.longBitsToDouble(z());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean b(int r5) {
            int r0 = WireFormat.a(r5);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            g(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            g(w());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            g(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            v();
            a(WireFormat.a(WireFormat.b(r5), 4));
            return true;
        L24:
            B();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public float c() {
            return Float.intBitsToFloat(y());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int c(int r2) {
            if (r2 < 0) goto L14;
            int r3 = r2 + u();
            if (r3 < 0) goto L12;
            int r0 = this.m;
            if (r3 > r0) goto L10;
            this.m = r3;
            E();
            return r0;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long d() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void d(int r1) {
            this.m = r1;
            E();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long e() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int f() {
            return w();
        }

        public byte[] f(int r3) {
            if (r3 <= 0) goto L7;
            int r0 = this.g;
            int r1 = this.i;
            if (r3 > (r0 - r1)) goto L7;
            int r4 = r3 + r1;
            this.i = r4;
            return Arrays.copyOfRange(this.e, r1, r4);
        L7:
            if (r3 > 0) goto L14;
            if (r3 != 0) goto L12;
            return ab.d;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long g() {
            return z();
        }

        public void g(int r3) {
            if (r3 < 0) goto L7;
            int r0 = this.g;
            int r1 = this.i;
            if (r3 > (r0 - r1)) goto L7;
            this.i = r1 + r3;
            return;
        L7:
            if (r3 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int h() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean i() {
            if (x() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String j() {
            int r0 = w();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > (this.g - this.i)) goto L8;
            String r1 = new String(this.e, this.i, r0, ab.f4938b);
            this.i += r0;
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String k() {
            int r0 = w();
            if (r0 <= 0) goto L8;
            int r1 = this.g;
            int r2 = this.i;
            if (r0 > (r1 - r2)) goto L8;
            String r3 = Utf8.b(this.e, r2, r0);
            this.i += r0;
            return r3;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public ByteString l() {
            int r0 = w();
            if (r0 <= 0) goto L14;
            int r1 = this.g;
            int r2 = this.i;
            if (r0 > (r1 - r2)) goto L14;
            if (this.f == true) goto L9;
        L11:
            ByteString r3 = ByteString.copyFrom(this.e, r2, r0);
        L12:
            this.i += r0;
            return r3;
        L9:
            if (this.l == false) goto L11;
            r3 = ByteString.wrap(this.e, r2, r0);
        L14:
            if (r0 != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(f(r0));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int m() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int n() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int o() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long p() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int q() {
            return e(w());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long r() {
            return a(x());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        long s() {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = A();
            r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean t() {
            if (this.i != this.g) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int u() {
            return this.i - this.j;
        }

        public void v() {
        L2:
            int r0 = a();
            if (r0 == 0) goto L6;
            if (b(r0) == true) goto L2;
            return;
        }

        public int w() {
            int r0 = this.i;
            int r1 = this.g;
            if (r1 == r0) goto L35;
            byte[] r2 = this.e;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.i = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L35;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L15;
            int r7 = r6 ^ (-128);
        L36:
            this.i = r5;
            return r7;
        L15:
            int r8 = r5 + 1;
            int r9 = r6 ^ (r2[r5] << 14);
            if (r9 < 0) goto L19;
            r7 = r9 ^ 16256;
        L18:
            r5 = r8;
            goto L36
        L19:
            r5 = r8 + 1;
            int r10 = r9 ^ (r2[r8] << 21);
            if (r10 >= 0) goto L22;
            r7 = r10 ^ (-2080896);
            goto L36
        L22:
            r8 = r5 + 1;
            byte r11 = r2[r5];
            r7 = (r10 ^ (r11 << 28)) ^ 266354560;
            if (r11 >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
        L35:
            return (int) s();
        }

        public long x() {
            int r0 = this.i;
            int r1 = this.g;
            if (r1 == r0) goto L41;
            byte[] r2 = this.e;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.i = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L41;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L16;
            int r7 = r6 ^ (-128);
        L15:
            long r8 = r7;
        L44:
            this.i = r5;
            return r8;
        L16:
            int r9 = r5 + 1;
            int r10 = r6 ^ (r2[r5] << 14);
            if (r10 < 0) goto L19;
            r5 = r9;
            r8 = r10 ^ 16256;
            goto L44
        L19:
            r5 = r9 + 1;
            int r11 = r10 ^ (r2[r9] << 21);
            if (r11 >= 0) goto L22;
            r7 = r11 ^ (-2080896);
            goto L15
        L22:
            long r12 = r11;
            int r13 = r5 + 1;
            long r14 = r12 ^ (((long) r2[r5]) << 28);
            if (r14 < 0) goto L26;
            long r15 = 266354560;
        L25:
            r8 = r14 ^ r15;
            r5 = r13;
            goto L44
        L26:
            r5 = r13 + 1;
            long r16 = r14 ^ (((long) r2[r13]) << 35);
            if (r16 >= 0) goto L30;
            long r17 = -34093383808L;
        L29:
            r8 = r16 ^ r17;
            goto L44
        L30:
            r13 = r5 + 1;
            r14 = r16 ^ (((long) r2[r5]) << 42);
            if (r14 < 0) goto L33;
            r15 = 4363953127296L;
            goto L25
        L33:
            r5 = r13 + 1;
            r16 = r14 ^ (((long) r2[r13]) << 49);
            if (r16 >= 0) goto L36;
            r17 = -558586000294016L;
            goto L29
        L36:
            int r18 = r5 + 1;
            long r19 = (r16 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
            if (r19 >= 0) goto L42;
            r5 = r18 + 1;
            if (r2[r18] < 0) goto L41;
        L43:
            r8 = r19;
            goto L44
        L42:
            r5 = r18;
        L41:
            return s();
        }

        public int y() {
            int r0 = this.i;
            if ((this.g - r0) < 4) goto L7;
            byte[] r1 = this.e;
            this.i = r0 + 4;
            return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long z() {
            int r0 = this.i;
            if ((this.g - r0) < 8) goto L7;
            byte[] r1 = this.e;
            this.i = r0 + 8;
            long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
            return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class b extends k {
        private final Iterable<ByteBuffer> e;
        private final Iterator<ByteBuffer> f;
        private ByteBuffer g;
        private final boolean h;
        private boolean i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private long p;
        private long q;
        private long r;
        private long s;

        private b(Iterable<ByteBuffer> r3, int r4, boolean r5) {
            Iterable<ByteBuffer> r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            super(null);
            this.l = Integer.MAX_VALUE;
            this.j = r4;
            this.e = r6;
            this.f = r6.iterator();
            this.h = r5;
            this.n = 0;
            this.o = 0;
            if (r4 != 0) goto L5;
            this.g = ab.e;
            this.p = 0;
            this.q = 0;
            this.s = 0;
            this.r = 0;
            return;
        L5:
            C();
        }

        /* synthetic */ b(Iterable r2, int r3, boolean r4, AnonymousClass1 r5) {
            this((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        private void B() {
            if (this.f.hasNext() == false) goto L7;
            C();
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void C() {
            ByteBuffer r0 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this.f.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
            this.g = r0;
            this.n += (int) (this.p - this.q);
            long r1 = r0.position();
            this.p = r1;
            this.q = r1;
            this.s = this.g.limit();
            long r2 = bx.a(this.g);
            this.r = r2;
            this.p += r2;
            this.q += r2;
            this.s += r2;
        }

        private void D() {
            int r0 = this.j + this.k;
            this.j = r0;
            int r1 = r0 - this.o;
            int r2 = this.l;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.k = r3;
            this.j = r0 - r3;
            return;
        L5:
            this.k = 0;
        }

        private void E() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (A() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int F() {
            return (int) ((((long) (this.j - this.n)) - this.p) + this.q);
        }

        private long G() {
            return this.s - this.p;
        }

        private ByteBuffer a(int r4, int r5) {
            int r0 = this.g.position();
            int r1 = this.g.limit();
            ByteBuffer r2 = this.g;
            r2.position(r4);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.limit(r5);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.g.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.position(r0);
            r2.limit(r1);
            return r3;
        L6:
            th = move-exception;
            r2.position(r0);
            r2.limit(r1);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }

        private void b(byte[] r12, int r13, int r14) {
            if (r14 >= 0) goto L4;
        L12:
            if (r14 > 0) goto L18;
            if (r14 != 0) goto L16;
            return;
        L16:
            throw InvalidProtocolBufferException.negativeSize();
        L18:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r14 > F()) goto L12;
            int r0 = r14;
        L6:
            if (r0 <= 0) goto L11;
            if (G() != 0) goto L10;
            B();
        L10:
            int r1 = Math.min(r0, (int) G());
            long r9 = r1;
            bx.a(this.p, r12, (r14 - r0) + r13, r9);
            r0 = r0 - r1;
            this.p += r9;
            goto L6
        }

        public byte A() {
            if (G() != 0) goto L5;
            B();
        L5:
            long r0 = this.p;
            this.p = 1 + r0;
            return bx.a(r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int a() {
            if (t() == false) goto L6;
            this.m = 0;
            return 0;
        L6:
            int r0 = w();
            this.m = r0;
            if (WireFormat.b(r0) == 0) goto L11;
            return this.m;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void a(int r1) {
            if (this.m != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public double b() {
            return Double.longBitsToDouble(z());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean b(int r5) {
            int r0 = WireFormat.a(r5);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            f(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            f(w());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            f(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            v();
            a(WireFormat.a(WireFormat.b(r5), 4));
            return true;
        L24:
            E();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public float c() {
            return Float.intBitsToFloat(y());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int c(int r2) {
            if (r2 < 0) goto L10;
            int r3 = r2 + u();
            int r0 = this.l;
            if (r3 > r0) goto L8;
            this.l = r3;
            D();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long d() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void d(int r1) {
            this.l = r1;
            D();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long e() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int f() {
            return w();
        }

        public void f(int r7) {
            if (r7 >= 0) goto L4;
        L11:
            if (r7 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r7 > ((((long) (this.j - this.n)) - this.p) + this.q)) goto L11;
        L5:
            if (r7 <= 0) goto L10;
            if (G() != 0) goto L9;
            B();
        L9:
            int r0 = Math.min(r7, (int) G());
            r7 = r7 - r0;
            this.p += (long) r0;
            goto L5
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long g() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int h() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean i() {
            if (x() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String j() {
            int r0 = w();
            if (r0 <= 0) goto L8;
            long r8 = r0;
            long r1 = this.s;
            long r3 = this.p;
            if (r8 > (r1 - r3)) goto L8;
            byte[] r2 = new byte[r0];
            bx.a(r3, r2, 0, r8);
            String r4 = new String(r2, ab.f4938b);
            this.p += r8;
            return r4;
        L8:
            if (r0 > 0) goto L10;
        L13:
            if (r0 != 0) goto L16;
            return "";
        L16:
            if (r0 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r0 > F()) goto L13;
            byte[] r5 = new byte[r0];
            b(r5, 0, r0);
            return new String(r5, ab.f4938b);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String k() {
            int r0 = w();
            if (r0 <= 0) goto L8;
            long r1 = r0;
            long r3 = this.s;
            long r5 = this.p;
            if (r1 > (r3 - r5)) goto L8;
            String r2 = Utf8.a(this.g, (int) (r5 - this.q), r0);
            this.p += r1;
            return r2;
        L8:
            if (r0 >= 0) goto L10;
        L13:
            if (r0 != 0) goto L16;
            return "";
        L16:
            if (r0 > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r0 > F()) goto L13;
            byte[] r4 = new byte[r0];
            b(r4, 0, r0);
            return Utf8.b(r4, 0, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public ByteString l() {
            int r0 = w();
            if (r0 <= 0) goto L14;
            long r8 = r0;
            long r1 = this.s;
            long r3 = this.p;
            if (r8 > (r1 - r3)) goto L14;
            if (this.h == true) goto L9;
        L12:
            byte[] r2 = new byte[r0];
            bx.a(r3, r2, 0, r8);
            this.p += r8;
            return ByteString.wrap(r2);
        L9:
            if (this.i == false) goto L12;
            int r4 = (int) (r3 - this.r);
            ByteString r5 = ByteString.wrap(a(r4, r0 + r4));
            this.p += r8;
            return r5;
        L14:
            if (r0 > 0) goto L16;
        L31:
            if (r0 == 0) goto L33;
            if (r0 >= 0) goto L38;
            throw InvalidProtocolBufferException.negativeSize();
        L38:
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            return ByteString.EMPTY;
        L16:
            if (r0 > F()) goto L31;
            if (this.h == true) goto L20;
        L29:
            byte[] r6 = new byte[r0];
            b(r6, 0, r0);
            return ByteString.wrap(r6);
        L20:
            if (this.i == false) goto L29;
            ArrayList r7 = new ArrayList();
        L22:
            if (r0 <= 0) goto L28;
            if (G() != 0) goto L26;
            B();
        L26:
            int r9 = Math.min(r0, (int) G());
            int r10 = (int) (this.p - this.r);
            r7.add(ByteString.wrap(a(r10, r10 + r9)));
            r0 = r0 - r9;
            this.p += (long) r9;
            goto L22
        L28:
            return ByteString.copyFrom(r7);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int m() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int n() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int o() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long p() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int q() {
            return e(w());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long r() {
            return a(x());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        long s() {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = A();
            r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean t() {
            if (((((long) this.n) + this.p) - this.q) != this.j) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int u() {
            return (int) ((((long) (this.n - this.o)) + this.p) - this.q);
        }

        public void v() {
        L2:
            int r0 = a();
            if (r0 == 0) goto L6;
            if (b(r0) == true) goto L2;
            return;
        }

        public int w() {
            long r0 = this.p;
            if (this.s == r0) goto L35;
            long r4 = r0 + 1;
            byte r1 = bx.a(r0);
            if (r1 < 0) goto L10;
            this.p++;
            return r1;
        L10:
            if ((this.s - this.p) < 10) goto L35;
            long r6 = r4 + 1;
            int r2 = r1 ^ (bx.a(r4) << 7);
            if (r2 >= 0) goto L15;
            int r3 = r2 ^ (-128);
        L36:
            this.p = r6;
            return r3;
        L15:
            long r5 = r6 + 1;
            int r7 = r2 ^ (bx.a(r6) << 14);
            if (r7 < 0) goto L19;
            r3 = r7 ^ 16256;
        L18:
            r6 = r5;
            goto L36
        L19:
            r6 = r5 + 1;
            int r8 = r7 ^ (bx.a(r5) << 21);
            if (r8 >= 0) goto L22;
            r3 = r8 ^ (-2080896);
            goto L36
        L22:
            r5 = r6 + 1;
            byte r9 = bx.a(r6);
            r3 = (r8 ^ (r9 << 28)) ^ 266354560;
            if (r9 >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (bx.a(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (bx.a(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
        L35:
            return (int) s();
        }

        public long x() {
            long r0 = this.p;
            if (this.s == r0) goto L42;
            long r4 = r0 + 1;
            byte r1 = bx.a(r0);
            if (r1 < 0) goto L10;
            this.p++;
            return r1;
        L10:
            if ((this.s - this.p) < 10) goto L42;
            long r6 = r4 + 1;
            int r2 = r1 ^ (bx.a(r4) << 7);
            if (r2 >= 0) goto L16;
            int r3 = r2 ^ (-128);
        L15:
            long r5 = r3;
        L44:
            this.p = r6;
            return r5;
        L16:
            long r7 = r6 + 1;
            int r8 = r2 ^ (bx.a(r6) << 14);
            if (r8 < 0) goto L20;
            r5 = r8 ^ 16256;
        L19:
            r6 = r7;
            goto L44
        L20:
            r6 = r7 + 1;
            int r9 = r8 ^ (bx.a(r7) << 21);
            if (r9 >= 0) goto L23;
            r3 = r9 ^ (-2080896);
            goto L15
        L23:
            r7 = r6 + 1;
            long r10 = ((long) r9) ^ (((long) bx.a(r6)) << 28);
            if (r10 < 0) goto L27;
            long r11 = 266354560;
        L26:
            r5 = r10 ^ r11;
            goto L19
        L27:
            long r12 = r7 + 1;
            long r13 = r10 ^ (((long) bx.a(r7)) << 35);
            if (r13 >= 0) goto L31;
            long r14 = -34093383808L;
        L30:
            r5 = r13 ^ r14;
            r6 = r12;
            goto L44
        L31:
            r7 = r12 + 1;
            r10 = r13 ^ (((long) bx.a(r12)) << 42);
            if (r10 < 0) goto L34;
            r11 = 4363953127296L;
            goto L26
        L34:
            r12 = r7 + 1;
            r13 = r10 ^ (((long) bx.a(r7)) << 49);
            if (r13 >= 0) goto L37;
            r14 = -558586000294016L;
            goto L30
        L37:
            r7 = r12 + 1;
            r5 = (r13 ^ (((long) bx.a(r12)) << 56)) ^ 71499008037633920L;
            if (r5 >= 0) goto L19;
            long r15 = 1 + r7;
            if (bx.a(r7) < 0) goto L42;
            r6 = r15;
        L42:
            return s();
        }

        public int y() {
            if (G() < 4) goto L6;
            long r0 = this.p;
            this.p = 4 + r0;
            return (((bx.a(r0) & 255) | ((bx.a(1 + r0) & 255) << 8)) | ((bx.a(2 + r0) & 255) << 16)) | ((bx.a(r0 + 3) & 255) << 24);
        L6:
            int r1 = ((A() & 255) | ((A() & 255) << 8)) | ((A() & 255) << 16);
            return ((A() & 255) << 24) | r1;
        }

        public long z() {
            if (G() < 8) goto L6;
            long r13 = this.p;
            this.p = 8 + r13;
            return (((((((((long) bx.a(r13)) & 255) | ((((long) bx.a(1 + r13)) & 255) << 8)) | ((((long) bx.a(2 + r13)) & 255) << 16)) | ((((long) bx.a(3 + r13)) & 255) << 24)) | ((((long) bx.a(4 + r13)) & 255) << 32)) | ((((long) bx.a(5 + r13)) & 255) << 40)) | ((((long) bx.a(6 + r13)) & 255) << 48)) | ((((long) bx.a(r13 + 7)) & 255) << 56);
        L6:
            long r3 = ((((((((long) A()) & 255) | ((((long) A()) & 255) << 8)) | ((((long) A()) & 255) << 16)) | ((((long) A()) & 255) << 24)) | ((((long) A()) & 255) << 32)) | ((((long) A()) & 255) << 40)) | ((((long) A()) & 255) << 48);
            return ((((long) A()) & 255) << 56) | r3;
        }
    }

    private static final class c extends k {
        private final InputStream e;
        private final byte[] f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private a m;

        private interface a {
            void a();
        }

        private c(InputStream r3, int r4) {
            super(null);
            this.l = Integer.MAX_VALUE;
            this.m = null;
            ab.a(r3, "input");
            this.e = r3;
            this.f = new byte[r4];
            this.g = 0;
            this.i = 0;
            this.k = 0;
        }

        /* synthetic */ c(InputStream r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void B() {
            if ((this.g - this.i) < 10) goto L5;
            C();
            return;
        L5:
            D();
        }

        private void C() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            byte[] r1 = this.f;
            int r2 = this.i;
            this.i = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void D() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (A() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void E() {
            int r0 = this.g + this.h;
            this.g = r0;
            int r1 = this.k + r0;
            int r2 = this.l;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.h = r3;
            this.g = r0 - r3;
            return;
        L5:
            this.h = 0;
        }

        private static int a(InputStream r0, byte[] r1, int r2, int r3) {
            return r0.read(r1, r2, r3);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static long a(InputStream r0, long r1) {
            return r0.skip(r1);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private byte[] a(int r6, boolean r7) {
            byte[] r1 = i(r6);
            if (r1 == null) goto L7;
            if (r7 == true) goto L6;
            return r1;
        L6:
            return (byte[]) ZeusTransformUtils.preCheckCast(r1.clone(), byte[].class, "com.obric.memorydata.plugin");
        L7:
            int r8 = this.i;
            int r2 = this.g;
            int r3 = r2 - r8;
            this.k += r2;
            this.i = 0;
            this.g = 0;
            List<byte[]> r4 = j(r6 - r3);
            byte[] r9 = new byte[r6];
            System.arraycopy(this.f, r8, r9, 0, r3);
            Iterator<byte[]> r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L11;
            byte[] r10 = (byte[]) ZeusTransformUtils.preCheckCast(r5.next(), byte[].class, "com.obric.memorydata.plugin");
            System.arraycopy(r10, 0, r9, r3, r10.length);
            r3 = r3 + r10.length;
            goto L9
        L11:
            return r9;
        }

        private static int b(InputStream r0) {
            return r0.available();
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private void g(int r3) {
            if (h(r3) == false) goto L5;
            return;
        L5:
            if (r3 <= ((this.c - this.k) - this.i)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean h(int r8) {
            if ((this.i + r8) <= this.g) goto L35;
            int r0 = this.c;
            int r1 = this.k;
            int r2 = this.i;
            if (r8 <= ((r0 - r1) - r2)) goto L8;
            return false;
        L8:
            if (((r1 + r2) + r8) <= this.l) goto L10;
            return false;
        L10:
            a r3 = this.m;
            if (r3 == null) goto L13;
            r3.a();
        L13:
            int r4 = this.i;
            if (r4 <= 0) goto L19;
            int r5 = this.g;
            if (r5 <= r4) goto L18;
            byte[] r6 = this.f;
            System.arraycopy(r6, r4, r6, 0, r5 - r4);
        L18:
            this.k += r4;
            this.g -= r4;
            this.i = 0;
        L19:
            InputStream r7 = this.e;
            byte[] r9 = this.f;
            int r10 = this.g;
            int r11 = a(r7, r9, r10, Math.min(r9.length - r10, (this.c - this.k) - this.g));
            if (r11 == 0) goto L33;
            if (r11 < (-1)) goto L33;
            if (r11 > this.f.length) goto L33;
            if (r11 <= 0) goto L31;
            this.g += r11;
            E();
            if (this.g < r8) goto L30;
            return true;
        L30:
            return h(r8);
        L31:
            return false;
        L33:
            throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + r11 + "\nThe InputStream implementation is buggy.");
        L35:
            throw new IllegalStateException("refillBuffer() called when " + r8 + " bytes were already available in buffer");
        }

        private byte[] i(int r6) {
            if (r6 == 0) goto L4;
            if (r6 < 0) goto L30;
            int r0 = (this.k + this.i) + r6;
            if ((r0 - this.c) > 0) goto L28;
            int r1 = this.l;
            if (r0 > r1) goto L25;
            int r2 = this.g - this.i;
            int r3 = r6 - r2;
            if (r3 >= 4096) goto L13;
        L17:
            byte[] r4 = new byte[r6];
            System.arraycopy(this.f, this.i, r4, 0, r2);
            this.k += this.g;
            this.i = 0;
            this.g = 0;
        L18:
            if (r2 >= r6) goto L24;
            int r5 = a(this.e, r4, r2, r6 - r2);
            if (r5 == (-1)) goto L23;
            this.k += r5;
            r2 = r2 + r5;
            goto L18
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L24:
            return r4;
        L13:
            if (r3 <= b(this.e)) goto L17;
            return null;
        L25:
            f((r1 - this.k) - this.i);
            throw InvalidProtocolBufferException.truncatedMessage();
        L28:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L30:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return ab.d;
        }

        private List<byte[]> j(int r7) {
            ArrayList r0 = new ArrayList();
        L3:
            if (r7 <= 0) goto L12;
            int r1 = Math.min(r7, 4096);
            byte[] r2 = new byte[r1];
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L11;
            int r4 = this.e.read(r2, r3, r1 - r3);
            if (r4 == (-1)) goto L10;
            this.k += r4;
            r3 = r3 + r4;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            r7 = r7 - r1;
            r0.add(r2);
            goto L3
        L12:
            return r0;
        }

        private ByteString k(int r6) {
            byte[] r0 = i(r6);
            if (r0 != null) goto L5;
            int r1 = this.i;
            int r2 = this.g;
            int r3 = r2 - r1;
            this.k += r2;
            this.i = 0;
            this.g = 0;
            List<byte[]> r4 = j(r6 - r3);
            byte[] r7 = new byte[r6];
            System.arraycopy(this.f, r1, r7, 0, r3);
            Iterator<byte[]> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L11;
            byte[] r8 = (byte[]) ZeusTransformUtils.preCheckCast(r5.next(), byte[].class, "com.obric.memorydata.plugin");
            System.arraycopy(r8, 0, r7, r3, r8.length);
            r3 = r3 + r8.length;
            goto L8
        L11:
            return ByteString.wrap(r7);
        L5:
            return ByteString.copyFrom(r0);
        }

        private void l(int r9) {
            if (r9 < 0) goto L33;
            int r0 = this.k;
            int r1 = this.i;
            int r2 = (r0 + r1) + r9;
            int r3 = this.l;
            if (r2 > r3) goto L30;
            int r4 = 0;
            if (this.m != null) goto L23;
            this.k = r0 + r1;
            int r5 = this.g - r1;
            this.g = 0;
            this.i = 0;
            r4 = r5;
        L8:
            if (r4 >= r9) goto L22;
            long r6 = r9 - r4;
            long r7 = a(this.e, r6);     // Catch: Throwable -> L19
            if (r7 < 0) goto L18;
            if (r7 > r6) goto L18;
            if (r7 == 0) goto L22;
            r4 = r4 + ((int) r7);     // Catch: Throwable -> L19
        L18:
            throw new IllegalStateException(this.e.getClass() + "#skip returned invalid result: " + r7 + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.k += r4;
            E();
            throw th;
        L22:
            this.k += r4;
            E();
        L23:
            if (r4 >= r9) goto L41;
            int r8 = this.g;
            int r10 = r8 - this.i;
            this.i = r8;
        L25:
            g(1);
            int r11 = r9 - r10;
            int r12 = this.g;
            if (r11 <= r12) goto L28;
            r10 = r10 + r12;
            this.i = r12;
            goto L25
        L28:
            this.i = r11;
            return;
        L41:
            return;
        L30:
            f((r3 - r0) - r1);
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            throw InvalidProtocolBufferException.negativeSize();
        }

        public byte A() {
            if (this.i != this.g) goto L5;
            g(1);
        L5:
            byte[] r0 = this.f;
            int r1 = this.i;
            this.i = r1 + 1;
            return r0[r1];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int a() {
            if (t() == false) goto L6;
            this.j = 0;
            return 0;
        L6:
            int r0 = w();
            this.j = r0;
            if (WireFormat.b(r0) == 0) goto L11;
            return this.j;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void a(int r1) {
            if (this.j != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public double b() {
            return Double.longBitsToDouble(z());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean b(int r5) {
            int r0 = WireFormat.a(r5);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            f(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            f(w());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            f(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            v();
            a(WireFormat.a(WireFormat.b(r5), 4));
            return true;
        L24:
            B();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public float c() {
            return Float.intBitsToFloat(y());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int c(int r3) {
            if (r3 < 0) goto L10;
            int r4 = r3 + (this.k + this.i);
            int r0 = this.l;
            if (r4 > r0) goto L8;
            this.l = r4;
            E();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long d() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void d(int r1) {
            this.l = r1;
            E();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long e() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int f() {
            return w();
        }

        public void f(int r3) {
            int r0 = this.g;
            int r1 = this.i;
            if (r3 > (r0 - r1)) goto L6;
            if (r3 < 0) goto L6;
            this.i = r1 + r3;
            return;
        L6:
            l(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long g() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int h() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean i() {
            if (x() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String j() {
            int r0 = w();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L12;
            return "";
        L12:
            if (r0 > this.g) goto L16;
            g(r0);
            String r1 = new String(this.f, this.i, r0, ab.f4938b);
            this.i += r0;
            return r1;
        L16:
            return new String(a(r0, false), ab.f4938b);
        L5:
            if (r0 > (this.g - this.i)) goto L8;
            String r2 = new String(this.f, this.i, r0, ab.f4938b);
            this.i += r0;
            return r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String k() {
            int r0 = w();
            int r1 = this.i;
            int r2 = this.g;
            if (r0 > (r2 - r1)) goto L6;
            if (r0 <= 0) goto L6;
            byte[] r3 = this.f;
            this.i = r1 + r0;
        L14:
            return Utf8.b(r3, r1, r0);
        L6:
            if (r0 != 0) goto L9;
            return "";
        L9:
            if (r0 > r2) goto L11;
            g(r0);
            r3 = this.f;
            this.i = r0 + 0;
        L12:
            r1 = 0;
            goto L14
        L11:
            r3 = a(r0, false);
            goto L12
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public ByteString l() {
            int r0 = w();
            int r1 = this.g;
            int r2 = this.i;
            if (r0 > (r1 - r2)) goto L7;
            if (r0 <= 0) goto L7;
            ByteString r3 = ByteString.copyFrom(this.f, r2, r0);
            this.i += r0;
            return r3;
        L7:
            if (r0 != 0) goto L11;
            return ByteString.EMPTY;
        L11:
            return k(r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int m() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int n() {
            return w();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int o() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long p() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int q() {
            return e(w());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long r() {
            return a(x());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        long s() {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = A();
            r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean t() {
            if (this.i == this.g) goto L5;
        L7:
            return false;
        L5:
            if (h(1) == true) goto L7;
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int u() {
            return this.k + this.i;
        }

        public void v() {
        L2:
            int r0 = a();
            if (r0 == 0) goto L6;
            if (b(r0) == true) goto L2;
            return;
        }

        public int w() {
            int r0 = this.i;
            int r1 = this.g;
            if (r1 == r0) goto L35;
            byte[] r2 = this.f;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.i = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L35;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L15;
            int r7 = r6 ^ (-128);
        L36:
            this.i = r5;
            return r7;
        L15:
            int r8 = r5 + 1;
            int r9 = r6 ^ (r2[r5] << 14);
            if (r9 < 0) goto L19;
            r7 = r9 ^ 16256;
        L18:
            r5 = r8;
            goto L36
        L19:
            r5 = r8 + 1;
            int r10 = r9 ^ (r2[r8] << 21);
            if (r10 >= 0) goto L22;
            r7 = r10 ^ (-2080896);
            goto L36
        L22:
            r8 = r5 + 1;
            byte r11 = r2[r5];
            r7 = (r10 ^ (r11 << 28)) ^ 266354560;
            if (r11 >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
        L35:
            return (int) s();
        }

        public long x() {
            int r0 = this.i;
            int r1 = this.g;
            if (r1 == r0) goto L41;
            byte[] r2 = this.f;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.i = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L41;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L16;
            int r7 = r6 ^ (-128);
        L15:
            long r8 = r7;
        L44:
            this.i = r5;
            return r8;
        L16:
            int r9 = r5 + 1;
            int r10 = r6 ^ (r2[r5] << 14);
            if (r10 < 0) goto L19;
            r5 = r9;
            r8 = r10 ^ 16256;
            goto L44
        L19:
            r5 = r9 + 1;
            int r11 = r10 ^ (r2[r9] << 21);
            if (r11 >= 0) goto L22;
            r7 = r11 ^ (-2080896);
            goto L15
        L22:
            long r12 = r11;
            int r13 = r5 + 1;
            long r14 = r12 ^ (((long) r2[r5]) << 28);
            if (r14 < 0) goto L26;
            long r15 = 266354560;
        L25:
            r8 = r14 ^ r15;
            r5 = r13;
            goto L44
        L26:
            r5 = r13 + 1;
            long r16 = r14 ^ (((long) r2[r13]) << 35);
            if (r16 >= 0) goto L30;
            long r17 = -34093383808L;
        L29:
            r8 = r16 ^ r17;
            goto L44
        L30:
            r13 = r5 + 1;
            r14 = r16 ^ (((long) r2[r5]) << 42);
            if (r14 < 0) goto L33;
            r15 = 4363953127296L;
            goto L25
        L33:
            r5 = r13 + 1;
            r16 = r14 ^ (((long) r2[r13]) << 49);
            if (r16 >= 0) goto L36;
            r17 = -558586000294016L;
            goto L29
        L36:
            int r18 = r5 + 1;
            long r19 = (r16 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
            if (r19 >= 0) goto L42;
            r5 = r18 + 1;
            if (r2[r18] < 0) goto L41;
        L43:
            r8 = r19;
            goto L44
        L42:
            r5 = r18;
        L41:
            return s();
        }

        public int y() {
            int r0 = this.i;
            if ((this.g - r0) >= 4) goto L5;
            g(4);
            r0 = this.i;
        L5:
            byte[] r1 = this.f;
            this.i = r0 + 4;
            return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
        }

        public long z() {
            int r0 = this.i;
            if ((this.g - r0) >= 8) goto L5;
            g(8);
            r0 = this.i;
        L5:
            byte[] r1 = this.f;
            this.i = r0 + 8;
            long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
            return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
        }
    }

    private static final class d extends k {
        private final ByteBuffer e;
        private final boolean f;
        private final long g;
        private long h;
        private long i;
        private long j;
        private int k;
        private int l;
        private boolean m;
        private int n;

        private d(ByteBuffer r5, boolean r6) {
            super(null);
            this.n = Integer.MAX_VALUE;
            this.e = r5;
            long r0 = bx.a(r5);
            this.g = r0;
            this.h = ((long) r5.limit()) + r0;
            long r1 = r0 + ((long) r5.position());
            this.i = r1;
            this.j = r1;
            this.f = r6;
        }

        /* synthetic */ d(ByteBuffer r1, boolean r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void C() {
            if (G() < 10) goto L5;
            D();
            return;
        L5:
            E();
        }

        private void D() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            long r1 = this.i;
            this.i = 1 + r1;
            if (bx.a(r1) >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void E() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (B() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void F() {
            long r0 = this.h + ((long) this.k);
            this.h = r0;
            int r2 = (int) (r0 - this.j);
            int r3 = this.n;
            if (r2 <= r3) goto L5;
            int r4 = r2 - r3;
            this.k = r4;
            this.h = r0 - ((long) r4);
            return;
        L5:
            this.k = 0;
        }

        private int G() {
            return (int) (this.h - this.i);
        }

        private ByteBuffer a(long r4, long r6) {
            int r0 = this.e.position();
            int r1 = this.e.limit();
            ByteBuffer r2 = this.e;
            r2.position(b(r4));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.limit(b(r6));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.e.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.position(r0);
            r2.limit(r1);
            return r3;
        L8:
            e = move-exception;
            InvalidProtocolBufferException r5 = InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
            r5.initCause(e);     // Catch: Throwable -> L6
            throw r5;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            r2.position(r0);
            r2.limit(r1);
            throw th;
        }

        private int b(long r3) {
            return (int) (r3 - this.g);
        }

        static boolean v() {
            return bx.b();
        }

        public long A() {
            long r0 = this.i;
            if ((this.h - r0) < 8) goto L7;
            this.i = 8 + r0;
            long r2 = ((((((((long) bx.a(r0)) & 255) | ((((long) bx.a(1 + r0)) & 255) << 8)) | ((((long) bx.a(2 + r0)) & 255) << 16)) | ((((long) bx.a(3 + r0)) & 255) << 24)) | ((((long) bx.a(4 + r0)) & 255) << 32)) | ((((long) bx.a(5 + r0)) & 255) << 40)) | ((((long) bx.a(6 + r0)) & 255) << 48);
            return ((((long) bx.a(r0 + 7)) & 255) << 56) | r2;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte B() {
            long r0 = this.i;
            if (r0 == this.h) goto L7;
            this.i = 1 + r0;
            return bx.a(r0);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int a() {
            if (t() == false) goto L6;
            this.l = 0;
            return 0;
        L6:
            int r0 = x();
            this.l = r0;
            if (WireFormat.b(r0) == 0) goto L11;
            return this.l;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void a(int r1) {
            if (this.l != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public double b() {
            return Double.longBitsToDouble(A());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean b(int r5) {
            int r0 = WireFormat.a(r5);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            f(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            f(x());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            f(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            w();
            a(WireFormat.a(WireFormat.b(r5), 4));
            return true;
        L24:
            C();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public float c() {
            return Float.intBitsToFloat(z());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int c(int r2) {
            if (r2 < 0) goto L10;
            int r3 = r2 + u();
            int r0 = this.n;
            if (r3 > r0) goto L8;
            this.n = r3;
            F();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long d() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public void d(int r1) {
            this.n = r1;
            F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long e() {
            return y();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int f() {
            return x();
        }

        public void f(int r5) {
            if (r5 >= 0) goto L4;
        L7:
            if (r5 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r5 > G()) goto L7;
            this.i += (long) r5;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long g() {
            return A();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int h() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean i() {
            if (y() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String j() {
            int r0 = x();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > G()) goto L8;
            byte[] r1 = new byte[r0];
            long r9 = r0;
            bx.a(this.i, r1, 0, r9);
            String r2 = new String(r1, ab.f4938b);
            this.i += r9;
            return r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public String k() {
            int r0 = x();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > G()) goto L8;
            String r1 = Utf8.a(this.e, b(this.i), r0);
            this.i += (long) r0;
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public ByteString l() {
            int r0 = x();
            if (r0 > 0) goto L5;
        L14:
            if (r0 == 0) goto L16;
            if (r0 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (r0 > G()) goto L14;
            if (this.f == true) goto L9;
        L12:
            byte[] r7 = new byte[r0];
            long r8 = r0;
            bx.a(this.i, r7, 0, r8);
            this.i += r8;
            return ByteString.wrap(r7);
        L9:
            if (this.m == false) goto L12;
            long r1 = this.i;
            long r3 = r0;
            ByteBuffer r2 = a(r1, r1 + r3);
            this.i += r3;
            return ByteString.wrap(r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int m() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int n() {
            return x();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int o() {
            return z();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long p() {
            return A();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int q() {
            return e(x());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public long r() {
            return a(y());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        long s() {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = B();
            r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public boolean t() {
            if (this.i != this.h) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.k
        public int u() {
            return (int) (this.i - this.j);
        }

        public void w() {
        L2:
            int r0 = a();
            if (r0 == 0) goto L6;
            if (b(r0) == true) goto L2;
            return;
        }

        public int x() {
            long r0 = this.i;
            if (this.h == r0) goto L35;
            long r4 = r0 + 1;
            byte r1 = bx.a(r0);
            if (r1 < 0) goto L10;
            this.i = r4;
            return r1;
        L10:
            if ((this.h - r4) < 9) goto L35;
            long r6 = r4 + 1;
            int r2 = r1 ^ (bx.a(r4) << 7);
            if (r2 >= 0) goto L15;
            int r3 = r2 ^ (-128);
        L36:
            this.i = r6;
            return r3;
        L15:
            long r5 = r6 + 1;
            int r7 = r2 ^ (bx.a(r6) << 14);
            if (r7 < 0) goto L19;
            r3 = r7 ^ 16256;
        L18:
            r6 = r5;
            goto L36
        L19:
            r6 = r5 + 1;
            int r8 = r7 ^ (bx.a(r5) << 21);
            if (r8 >= 0) goto L22;
            r3 = r8 ^ (-2080896);
            goto L36
        L22:
            r5 = r6 + 1;
            byte r9 = bx.a(r6);
            r3 = (r8 ^ (r9 << 28)) ^ 266354560;
            if (r9 >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (bx.a(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (bx.a(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (bx.a(r5) >= 0) goto L36;
        L35:
            return (int) s();
        }

        public long y() {
            long r0 = this.i;
            if (this.h == r0) goto L42;
            long r4 = r0 + 1;
            byte r1 = bx.a(r0);
            if (r1 < 0) goto L10;
            this.i = r4;
            return r1;
        L10:
            if ((this.h - r4) < 9) goto L42;
            long r6 = r4 + 1;
            int r2 = r1 ^ (bx.a(r4) << 7);
            if (r2 >= 0) goto L16;
            int r3 = r2 ^ (-128);
        L15:
            long r5 = r3;
        L44:
            this.i = r6;
            return r5;
        L16:
            long r7 = r6 + 1;
            int r8 = r2 ^ (bx.a(r6) << 14);
            if (r8 < 0) goto L20;
            r5 = r8 ^ 16256;
        L19:
            r6 = r7;
            goto L44
        L20:
            r6 = r7 + 1;
            int r9 = r8 ^ (bx.a(r7) << 21);
            if (r9 >= 0) goto L23;
            r3 = r9 ^ (-2080896);
            goto L15
        L23:
            r7 = r6 + 1;
            long r10 = ((long) r9) ^ (((long) bx.a(r6)) << 28);
            if (r10 < 0) goto L27;
            long r11 = 266354560;
        L26:
            r5 = r10 ^ r11;
            goto L19
        L27:
            long r12 = r7 + 1;
            long r13 = r10 ^ (((long) bx.a(r7)) << 35);
            if (r13 >= 0) goto L31;
            long r14 = -34093383808L;
        L30:
            r5 = r13 ^ r14;
            r6 = r12;
            goto L44
        L31:
            r7 = r12 + 1;
            r10 = r13 ^ (((long) bx.a(r12)) << 42);
            if (r10 < 0) goto L34;
            r11 = 4363953127296L;
            goto L26
        L34:
            r12 = r7 + 1;
            r13 = r10 ^ (((long) bx.a(r7)) << 49);
            if (r13 >= 0) goto L37;
            r14 = -558586000294016L;
            goto L30
        L37:
            r7 = r12 + 1;
            r5 = (r13 ^ (((long) bx.a(r12)) << 56)) ^ 71499008037633920L;
            if (r5 >= 0) goto L19;
            long r15 = 1 + r7;
            if (bx.a(r7) < 0) goto L42;
            r6 = r15;
        L42:
            return s();
        }

        public int z() {
            long r0 = this.i;
            if ((this.h - r0) < 4) goto L7;
            this.i = 4 + r0;
            return (((bx.a(r0) & 255) | ((bx.a(1 + r0) & 255) << 8)) | ((bx.a(2 + r0) & 255) << 16)) | ((bx.a(r0 + 3) & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    static {
    }

    private k() {
        this.f5023b = e;
        this.c = Integer.MAX_VALUE;
        this.f = false;
    }

    /* synthetic */ k(AnonymousClass1 r1) {
        this();
    }

    public static int a(int r3, InputStream r4) {
        if ((r3 & 128) != 0) goto L5;
        return r3;
    L5:
        int r5 = r3 & 127;
        int r0 = 7;
    L7:
        if (r0 >= 32) goto L17;
        int r1 = r4.read();
        if (r1 == (-1)) goto L15;
        r5 = r5 | ((r1 & 127) << r0);
        if ((r1 & 128) == 0) goto L12;
        r0 = r0 + 7;
        goto L7
    L12:
        return r5;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r0 >= 64) goto L27;
        int r2 = r4.read();
        if (r2 == (-1)) goto L25;
        if ((r2 & 128) == 0) goto L22;
        r0 = r0 + 7;
        goto L17
    L22:
        return r5;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public static long a(long r4) {
        long r0 = r4 >>> 1;
        return (-(r4 & 1)) ^ r0;
    }

    public static k a(InputStream r1) {
        return a(r1, 4096);
    }

    public static k a(InputStream r2, int r3) {
        if (r3 <= 0) goto L9;
        if (r2 != null) goto L7;
        return a(ab.d);
    L7:
        return new c(r2, r3, null);
    L9:
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    static k a(Iterable<ByteBuffer> r6, boolean r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Iterator r0 = r8.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        ByteBuffer r4 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r0.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
        r3 = r3 + r4.remaining();
        if (r4.hasArray() == true) goto L7;
        if (r4.isDirect() == true) goto L10;
        r2 = r2 | 4;
        goto L4
    L10:
        r2 = r2 | 2;
        goto L4
    L7:
        r2 = r2 | 1;
        goto L4
    L13:
        if (r2 != 2) goto L17;
        return new b(r8, r3, r7, null);
    L17:
        return a(new ac(r8));
    }

    public static k a(ByteBuffer r1) {
        return a(r1, false);
    }

    static k a(ByteBuffer r3, boolean r4) {
        if (r3.hasArray() == false) goto L7;
        return a(r3.array(), r3.arrayOffset() + r3.position(), r3.remaining(), r4);
    L7:
        if (r3.isDirect() == true) goto L9;
    L12:
        int r5 = r3.remaining();
        byte[] r0 = new byte[r5];
        r3.duplicate().get(r0);
        return a(r0, 0, r5, true);
    L9:
        if (d.v() == false) goto L12;
        return new d(r3, r4, null);
    }

    public static k a(byte[] r2) {
        return a(r2, 0, r2.length);
    }

    public static k a(byte[] r1, int r2, int r3) {
        return a(r1, r2, r3, false);
    }

    static k a(byte[] r7, int r8, int r9, boolean r10) {
        a r6 = new a(r7, r8, r9, r10, null);
        r6.c(r9);     // Catch: InvalidProtocolBufferException -> L5
        return r6;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static int e(int r1) {
        int r0 = r1 >>> 1;
        return (-(r1 & 1)) ^ r0;
    }

    public abstract int a();

    public abstract void a(int r1);

    public abstract double b();

    public abstract boolean b(int r1);

    public abstract float c();

    public abstract int c(int r1);

    public abstract long d();

    public abstract void d(int r1);

    public abstract long e();

    public abstract int f();

    public abstract long g();

    public abstract int h();

    public abstract boolean i();

    public abstract String j();

    public abstract String k();

    public abstract ByteString l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    abstract long s();

    public abstract boolean t();

    public abstract int u();
}
