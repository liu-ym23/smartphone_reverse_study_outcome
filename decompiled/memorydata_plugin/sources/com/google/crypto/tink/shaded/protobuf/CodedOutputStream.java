package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CodedOutputStream extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f4902b = null;
    private static final boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    m f4903a;
    private boolean d;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String r3) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r3);
        }

        OutOfSpaceException(String r3, Throwable r4) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r3, r4);
        }

        OutOfSpaceException(Throwable r2) {
            super(MESSAGE, r2);
        }
    }

    private static abstract class a extends CodedOutputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f4904b;
        final int c;
        int d;
        int e;

        a(int r2) {
            super(null);
            if (r2 < 0) goto L7;
            byte[] r3 = new byte[Math.max(r2, 20)];
            this.f4904b = r3;
            this.c = r3.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void b(byte r4) {
            byte[] r0 = this.f4904b;
            int r1 = this.d;
            this.d = r1 + 1;
            r0[r1] = r4;
            this.e++;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int c() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void l(long r12) {
            if (CodedOutputStream.e() == false) goto L11;
            long r6 = this.d;
        L6:
            if ((r12 & (-128)) == 0) goto L7;
            byte[] r0 = this.f4904b;
            int r8 = this.d;
            this.d = r8 + 1;
            bx.a(r0, r8, (byte) ((((int) r12) & 127) | 128));
            r12 = r12 >>> 7;
            goto L6
        L7:
            byte[] r1 = this.f4904b;
            int r2 = this.d;
            this.d = r2 + 1;
            bx.a(r1, r2, (byte) r12);
            this.e += (int) (((long) this.d) - r6);
            return;
        L11:
            if ((r12 & (-128)) == 0) goto L12;
            byte[] r3 = this.f4904b;
            int r7 = this.d;
            this.d = r7 + 1;
            r3[r7] = (byte) ((((int) r12) & 127) | 128);
            this.e++;
            r12 = r12 >>> 7;
            goto L11
        L12:
            byte[] r4 = this.f4904b;
            int r5 = this.d;
            this.d = r5 + 1;
            r4[r5] = (byte) r12;
            this.e++;
        }

        final void m(long r9) {
            byte[] r0 = this.f4904b;
            int r1 = this.d;
            int r2 = r1 + 1;
            this.d = r2;
            r0[r1] = (byte) (r9 & 255);
            int r3 = r2 + 1;
            this.d = r3;
            r0[r2] = (byte) ((r9 >> 8) & 255);
            int r4 = r3 + 1;
            this.d = r4;
            r0[r3] = (byte) ((r9 >> 16) & 255);
            int r5 = r4 + 1;
            this.d = r5;
            r0[r4] = (byte) (255 & (r9 >> 24));
            int r6 = r5 + 1;
            this.d = r6;
            r0[r5] = (byte) (((int) (r9 >> 32)) & 255);
            int r7 = r6 + 1;
            this.d = r7;
            r0[r6] = (byte) (((int) (r9 >> 40)) & 255);
            int r8 = r7 + 1;
            this.d = r8;
            r0[r7] = (byte) (((int) (r9 >> 48)) & 255);
            this.d = r8 + 1;
            r0[r8] = (byte) (((int) (r9 >> 56)) & 255);
            this.e += 8;
        }

        final void n(int r1, int r2) {
            r(WireFormat.a(r1, r2));
        }

        final void q(int r3) {
            if (r3 < 0) goto L4;
            r(r3);
            return;
        L4:
            l(r3);
        }

        final void r(int r7) {
            if (CodedOutputStream.e() == false) goto L11;
            long r0 = this.d;
        L6:
            if ((r7 & (-128)) == 0) goto L7;
            byte[] r2 = this.f4904b;
            int r3 = this.d;
            this.d = r3 + 1;
            bx.a(r2, r3, (byte) ((r7 & 127) | 128));
            r7 = r7 >>> 7;
            goto L6
        L7:
            byte[] r4 = this.f4904b;
            int r5 = this.d;
            this.d = r5 + 1;
            bx.a(r4, r5, (byte) r7);
            this.e += (int) (((long) this.d) - r0);
            return;
        L11:
            if ((r7 & (-128)) == 0) goto L12;
            byte[] r1 = this.f4904b;
            int r6 = this.d;
            this.d = r6 + 1;
            r1[r6] = (byte) ((r7 & 127) | 128);
            this.e++;
            r7 = r7 >>> 7;
            goto L11
        L12:
            byte[] r8 = this.f4904b;
            int r9 = this.d;
            this.d = r9 + 1;
            r8[r9] = (byte) r7;
            this.e++;
        }

        final void s(int r5) {
            byte[] r0 = this.f4904b;
            int r1 = this.d;
            int r2 = r1 + 1;
            this.d = r2;
            r0[r1] = (byte) (r5 & 255);
            int r3 = r2 + 1;
            this.d = r3;
            r0[r2] = (byte) ((r5 >> 8) & 255);
            int r4 = r3 + 1;
            this.d = r4;
            r0[r3] = (byte) ((r5 >> 16) & 255);
            this.d = r4 + 1;
            r0[r4] = (byte) ((r5 >> 24) & 255);
            this.e += 4;
        }
    }

    private static class b extends CodedOutputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f4905b;
        private final int c;
        private final int d;
        private int e;

        b(byte[] r4, int r5, int r6) {
            super(null);
            Objects.requireNonNull(r4, "buffer");
            int r2 = r5 + r6;
            if (((r5 | r6) | (r4.length - r2)) < 0) goto L7;
            this.f4905b = r4;
            this.c = r5;
            this.e = r5;
            this.d = r2;
            return;
        L7:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r4.length), Integer.valueOf(r5), Integer.valueOf(r6)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(byte r5) {
            byte[] r0 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.e;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = r5;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), 1}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(int r1, int r2) {
            c(WireFormat.a(r1, r2));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(int r2, ByteString r3) {
            a(r2, 2);
            a(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(int r4, at r5) {
            at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r5, at.class, "com.obric.memorydata.plugin");
            a(1, 3);
            c(2, r4);
            e(3, r6);
            a(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void a(int r3, at r4, bl r5) {
            at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
            bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
            a(r3, 2);
            c(((com.google.crypto.tink.shaded.protobuf.a) ZeusTransformUtils.preCheckCast(r6, com.google.crypto.tink.shaded.protobuf.a.class, "com.obric.memorydata.plugin")).getSerializedSize(r7));
            r7.a(r6, this.f4903a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(int r2, String r3) {
            a(r2, 2);
            a(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(int r2, boolean r3) {
            a(r2, 0);
            a(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(ByteString r2) {
            c(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(at r3) {
            at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            c(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void a(at r3, bl r4) {
            at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
            c(((com.google.crypto.tink.shaded.protobuf.a) ZeusTransformUtils.preCheckCast(r5, com.google.crypto.tink.shaded.protobuf.a.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.a(r5, this.f4903a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a(String r6) {
            int r0 = this.e;
            int r1 = j(r6.length() * 3);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r2 = j(r6.length());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            if (r2 != r1) goto L7;
            int r3 = r0 + r2;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.e = r3;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r4 = Utf8.a(r6, this.f4905b, r3, c());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.e = r0;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            c((r4 - r0) - r2);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L6:
            this.e = r4;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L17:
            return;
        L7:
            c(Utf8.a(r6));     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            r4 = Utf8.a(r6, this.f4905b, this.e, c());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L12:
            e = move-exception;
            this.e = r0;
            a(r6, e);
            return;
        L9:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.j
        public final void a(ByteBuffer r1) {
            b(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.j
        public final void a(byte[] r1, int r2, int r3) {
            d(r1, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b(int r3) {
            if (r3 < 0) goto L4;
            c(r3);
            return;
        L4:
            b(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b(int r2, int r3) {
            a(r2, 0);
            b(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b(int r2, long r3) {
            a(r2, 0);
            b(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b(int r4, ByteString r5) {
            a(1, 3);
            c(2, r4);
            a(3, r5);
            a(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b(long r10) {
            if (CodedOutputStream.e() == false) goto L12;
            if (c() < 10) goto L12;
        L7:
            if ((r10 & (-128)) == 0) goto L8;
            byte[] r0 = this.f4905b;
            int r6 = this.e;
            this.e = r6 + 1;
            bx.a(r0, r6, (byte) ((((int) r10) & 127) | 128));
            r10 = r10 >>> 7;
            goto L7
        L8:
            byte[] r1 = this.f4905b;
            int r2 = this.e;
            this.e = r2 + 1;
            bx.a(r1, r2, (byte) r10);
            return;
        L12:
            if ((r10 & (-128)) == 0) goto L13;
            byte[] r3 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L17
            int r7 = this.e;     // Catch: IndexOutOfBoundsException -> L17
            this.e = r7 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r3[r7] = (byte) ((((int) r10) & 127) | 128);     // Catch: IndexOutOfBoundsException -> L17
            r10 = r10 >>> 7;
        L17:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), 1}), e);
        L13:
            byte[] r4 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L17
            int r5 = this.e;     // Catch: IndexOutOfBoundsException -> L17
            this.e = r5 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r4[r5] = (byte) r10;     // Catch: IndexOutOfBoundsException -> L17
        }

        public final void b(ByteBuffer r6) {
            int r0 = r6.remaining();
            r6.get(this.f4905b, this.e, r0);     // Catch: IndexOutOfBoundsException -> L5
            this.e += r0;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(r0)}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int c() {
            return this.d - this.e;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void c(int r5) {
        L3:
            if ((r5 & (-128)) == 0) goto L4;
            byte[] r0 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L8
            int r1 = this.e;     // Catch: IndexOutOfBoundsException -> L8
            this.e = r1 + 1;     // Catch: IndexOutOfBoundsException -> L8
            r0[r1] = (byte) ((r5 & 127) | 128);     // Catch: IndexOutOfBoundsException -> L8
            r5 = r5 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), 1}), e);
        L4:
            byte[] r2 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L8
            int r3 = this.e;     // Catch: IndexOutOfBoundsException -> L8
            this.e = r3 + 1;     // Catch: IndexOutOfBoundsException -> L8
            r2[r3] = (byte) r5;     // Catch: IndexOutOfBoundsException -> L8
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void c(int r2, int r3) {
            a(r2, 0);
            c(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void c(byte[] r1, int r2, int r3) {
            c(r3);
            d(r1, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void d(int r2, long r3) {
            a(r2, 1);
            d(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void d(long r6) {
            byte[] r0 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.e;     // Catch: IndexOutOfBoundsException -> L4
            int r2 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r2;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (((int) r6) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r3 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r3;     // Catch: IndexOutOfBoundsException -> L4
            r0[r2] = (byte) (((int) (r6 >> 8)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r4 = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r4;     // Catch: IndexOutOfBoundsException -> L4
            r0[r3] = (byte) (((int) (r6 >> 16)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r5 = r4 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r5;     // Catch: IndexOutOfBoundsException -> L4
            r0[r4] = (byte) (((int) (r6 >> 24)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r7 = r5 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r7;     // Catch: IndexOutOfBoundsException -> L4
            r0[r5] = (byte) (((int) (r6 >> 32)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r8 = r7 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r8;     // Catch: IndexOutOfBoundsException -> L4
            r0[r7] = (byte) (((int) (r6 >> 40)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r9 = r8 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r9;     // Catch: IndexOutOfBoundsException -> L4
            r0[r8] = (byte) (((int) (r6 >> 48)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.e = r9 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r9] = (byte) (((int) (r6 >> 56)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), 1}), e);
        }

        public final void d(byte[] r4, int r5, int r6) {
            System.arraycopy(r4, r5, this.f4905b, this.e, r6);     // Catch: IndexOutOfBoundsException -> L4
            this.e += r6;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(r6)}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void e(int r5) {
            byte[] r0 = this.f4905b;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.e;     // Catch: IndexOutOfBoundsException -> L4
            int r2 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r2;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (r5 & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r3 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r3;     // Catch: IndexOutOfBoundsException -> L4
            r0[r2] = (byte) ((r5 >> 8) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r4 = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            this.e = r4;     // Catch: IndexOutOfBoundsException -> L4
            r0[r3] = (byte) ((r5 >> 16) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.e = r4 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r4] = (byte) ((r5 >> 24) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), 1}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void e(int r2, int r3) {
            a(r2, 5);
            e(r3);
        }

        public final void e(int r3, at r4) {
            at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
            a(r3, 2);
            a(r5);
        }
    }

    private static final class c extends a {
        private final OutputStream f;

        c(OutputStream r1, int r2) {
            super(r2);
            Objects.requireNonNull(r1, "out");
            this.f = r1;
        }

        private void f() {
            this.f.write(this.f4904b, 0, this.d);
            this.d = 0;
        }

        private void t(int r3) {
            if ((this.c - this.d) >= r3) goto L6;
            f();
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(byte r3) {
            if (this.d != this.c) goto L5;
            f();
        L5:
            b(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(int r1, int r2) {
            c(WireFormat.a(r1, r2));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(int r2, ByteString r3) {
            a(r2, 2);
            a(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(int r4, at r5) {
            at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r5, at.class, "com.obric.memorydata.plugin");
            a(1, 3);
            c(2, r4);
            e(3, r6);
            a(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void a(int r3, at r4, bl r5) {
            at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
            bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
            a(r3, 2);
            a(r6, r7);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(int r2, String r3) {
            a(r2, 2);
            a(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(int r2, boolean r3) {
            t(11);
            n(r2, 0);
            b(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(ByteString r2) {
            c(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(at r3) {
            at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            c(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void a(at r3, bl r4) {
            at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
            c(((com.google.crypto.tink.shaded.protobuf.a) ZeusTransformUtils.preCheckCast(r5, com.google.crypto.tink.shaded.protobuf.a.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.a(r5, this.f4903a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a(String r7) {
            int r0 = r7.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r1 = j(r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r2 = r1 + r0;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r2 <= this.c) goto L7;
            byte[] r3 = new byte[r0];     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r4 = Utf8.a(r7, r3, 0, r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            c(r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            a(r3, 0, r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            return;
        L7:
            if (r2 <= (this.c - this.d)) goto L9;
            f();     // Catch: Utf8.UnpairedSurrogateException -> L22
        L9:
            int r5 = j(r7.length());     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r6 = this.d;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r5 == r1) goto L12;
            int r8 = Utf8.a(r7);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            r(r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.d = Utf8.a(r7, this.f4904b, this.d, r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L14:
            this.e += r8;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L28:
            return;
        L12:
            this.d = r6 + r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r9 = Utf8.a(r7, this.f4904b, this.d, this.c - this.d);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.d = r6;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            r8 = (r9 - r6) - r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            r(r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.d = r9;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L19:
            e = move-exception;
            this.e -= this.d - r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            this.d = r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L22
        L16:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L22
        L22:
            e = move-exception;
            a(r7, e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.j
        public void a(ByteBuffer r1) {
            b(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.j
        public void a(byte[] r1, int r2, int r3) {
            d(r1, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b() {
            if (this.d <= 0) goto L6;
            f();
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b(int r3) {
            if (r3 < 0) goto L4;
            c(r3);
            return;
        L4:
            b(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b(int r2, int r3) {
            t(20);
            n(r2, 0);
            q(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b(int r2, long r3) {
            t(20);
            n(r2, 0);
            l(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b(int r4, ByteString r5) {
            a(1, 3);
            c(2, r4);
            a(3, r5);
            a(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b(long r2) {
            t(10);
            l(r2);
        }

        public void b(ByteBuffer r6) {
            int r0 = r6.remaining();
            if ((this.c - this.d) < r0) goto L6;
            r6.get(this.f4904b, this.d, r0);
            this.d += r0;
        L5:
            this.e += r0;
            return;
        L6:
            int r1 = this.c - this.d;
            r6.get(this.f4904b, this.d, r1);
            r0 = r0 - r1;
            this.d = this.c;
            this.e += r1;
            f();
        L8:
            if (r0 <= this.c) goto L10;
            r6.get(this.f4904b, 0, this.c);
            this.f.write(this.f4904b, 0, this.c);
            r0 = r0 - this.c;
            this.e += this.c;
            goto L8
        L10:
            r6.get(this.f4904b, 0, r0);
            this.d = r0;
            goto L5
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int r2) {
            t(5);
            r(r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int r2, int r3) {
            t(20);
            n(r2, 0);
            r(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(byte[] r1, int r2, int r3) {
            c(r3);
            d(r1, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void d(int r2, long r3) {
            t(18);
            n(r2, 1);
            m(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void d(long r2) {
            t(8);
            m(r2);
        }

        public void d(byte[] r4, int r5, int r6) {
            if ((this.c - this.d) < r6) goto L6;
            System.arraycopy(r4, r5, this.f4904b, this.d, r6);
            this.d += r6;
        L5:
            this.e += r6;
            return;
        L6:
            int r0 = this.c - this.d;
            System.arraycopy(r4, r5, this.f4904b, this.d, r0);
            int r7 = r5 + r0;
            r6 = r6 - r0;
            this.d = this.c;
            this.e += r0;
            f();
            if (r6 > this.c) goto L9;
            System.arraycopy(r4, r7, this.f4904b, 0, r6);
            this.d = r6;
            goto L5
        L9:
            this.f.write(r4, r7, r6);
            goto L5
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int r2) {
            t(4);
            s(r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int r2, int r3) {
            t(14);
            n(r2, 5);
            s(r3);
        }

        public void e(int r3, at r4) {
            at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
            a(r3, 2);
            a(r5);
        }
    }

    static {
        f4902b = Logger.getLogger(CodedOutputStream.class.getName());
        c = bx.a();
    }

    private CodedOutputStream() {
    }

    /* synthetic */ CodedOutputStream(AnonymousClass1 r1) {
        this();
    }

    static int a(int r1) {
        if (r1 <= 4096) goto L5;
        return 4096;
    L5:
        return r1;
    }

    public static int a(int r0, af r1) {
        return h(r0) + a(r1);
    }

    public static int a(af r0) {
        return o(r0.b());
    }

    public static CodedOutputStream a(OutputStream r1, int r2) {
        return new c(r1, r2);
    }

    public static CodedOutputStream a(byte[] r2) {
        return b(r2, 0, r2.length);
    }

    public static int b(double r0) {
        return 8;
    }

    public static int b(float r0) {
        return 4;
    }

    public static int b(int r0, double r1) {
        return h(r0) + b(r1);
    }

    public static int b(int r0, float r1) {
        return h(r0) + b(r1);
    }

    public static int b(int r2, af r3) {
        return ((h(1) * 2) + i(2, r2)) + a(3, r3);
    }

    public static int b(int r2, at r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        return h(r2) + b(r4);
    }

    static int b(int r2, at r3, bl r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        return h(r2) + b(r5, r6);
    }

    public static int b(int r0, String r1) {
        return h(r0) + b(r1);
    }

    public static int b(int r0, boolean r1) {
        return h(r0) + b(r1);
    }

    public static int b(ByteString r0) {
        return o(r0.size());
    }

    public static int b(at r2) {
        return o(((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin")).getSerializedSize());
    }

    static int b(at r2, bl r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        bl r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        return o(((com.google.crypto.tink.shaded.protobuf.a) ZeusTransformUtils.preCheckCast(r4, com.google.crypto.tink.shaded.protobuf.a.class, "com.obric.memorydata.plugin")).getSerializedSize(r5));
    }

    public static int b(String r1) {
        int r2 = Utf8.a(r1);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return o(r2);
    L4:
        r2 = r1.getBytes(ab.f4938b).length;
        goto L6
    }

    public static int b(boolean r0) {
        return 1;
    }

    public static CodedOutputStream b(byte[] r1, int r2, int r3) {
        return new b(r1, r2, r3);
    }

    public static int c(int r0, ByteString r1) {
        return h(r0) + b(r1);
    }

    public static int c(int r2, at r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        return ((h(1) * 2) + i(2, r2)) + b(3, r4);
    }

    public static int c(byte[] r0) {
        return o(r0.length);
    }

    public static int d(int r2, ByteString r3) {
        return ((h(1) * 2) + i(2, r2)) + c(3, r3);
    }

    @Deprecated
    static int d(int r2, at r3, bl r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        return (h(r2) * 2) + d(r5, r6);
    }

    @Deprecated
    public static int d(at r2) {
        return ((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin")).getSerializedSize();
    }

    @Deprecated
    static int d(at r2, bl r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        bl r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        return ((com.google.crypto.tink.shaded.protobuf.a) ZeusTransformUtils.preCheckCast(r4, com.google.crypto.tink.shaded.protobuf.a.class, "com.obric.memorydata.plugin")).getSerializedSize(r5);
    }

    static /* synthetic */ boolean e() {
        return c;
    }

    public static int f(int r0, long r1) {
        return h(r0) + f(r1);
    }

    public static int f(long r0) {
        return g(r0);
    }

    public static int g(int r0, long r1) {
        return h(r0) + g(r1);
    }

    public static int g(long r6) {
        if (((-128) & r6) != 0) goto L7;
        return 1;
    L7:
        if (r6 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r6) == 0) goto L13;
        int r0 = 6;
        r6 = r6 >>> 28;
    L15:
        if (((-2097152) & r6) == 0) goto L18;
        r0 = r0 + 2;
        r6 = r6 >>> 14;
    L18:
        if ((r6 & (-16384)) != 0) goto L20;
        return r0;
    L20:
        return r0 + 1;
    L13:
        r0 = 2;
        goto L15
    }

    public static int h(int r1) {
        return j(WireFormat.a(r1, 0));
    }

    public static int h(int r0, int r1) {
        return h(r0) + i(r1);
    }

    public static int h(int r0, long r1) {
        return h(r0) + h(r1);
    }

    public static int h(long r0) {
        return g(k(r0));
    }

    public static int i(int r0) {
        if (r0 >= 0) goto L4;
        return 10;
    L4:
        return j(r0);
    }

    public static int i(int r0, int r1) {
        return h(r0) + j(r1);
    }

    public static int i(int r0, long r1) {
        return h(r0) + i(r1);
    }

    public static int i(long r0) {
        return 8;
    }

    public static int j(int r1) {
        if ((r1 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r1) != 0) goto L15;
        return 3;
    L15:
        if ((r1 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int j(int r0, int r1) {
        return h(r0) + k(r1);
    }

    public static int j(int r0, long r1) {
        return h(r0) + j(r1);
    }

    public static int j(long r0) {
        return 8;
    }

    public static int k(int r0) {
        return j(p(r0));
    }

    public static int k(int r0, int r1) {
        return h(r0) + l(r1);
    }

    public static long k(long r3) {
        long r0 = r3 << 1;
        return (r3 >> 63) ^ r0;
    }

    public static int l(int r0) {
        return 4;
    }

    public static int l(int r0, int r1) {
        return h(r0) + m(r1);
    }

    public static int m(int r0) {
        return 4;
    }

    public static int m(int r0, int r1) {
        return h(r0) + n(r1);
    }

    public static int n(int r0) {
        return i(r0);
    }

    static int o(int r1) {
        return j(r1) + r1;
    }

    public static int p(int r1) {
        int r0 = r1 << 1;
        return (r1 >> 31) ^ r0;
    }

    public abstract void a(byte r1);

    public final void a(double r1) {
        d(Double.doubleToRawLongBits(r1));
    }

    public final void a(float r1) {
        e(Float.floatToRawIntBits(r1));
    }

    public final void a(int r1, double r2) {
        d(r1, Double.doubleToRawLongBits(r2));
    }

    public final void a(int r1, float r2) {
        e(r1, Float.floatToRawIntBits(r2));
    }

    public abstract void a(int r1, int r2);

    public final void a(int r1, long r2) {
        b(r1, r2);
    }

    public abstract void a(int r1, ByteString r2);

    public abstract void a(int r1, at r2);

    abstract void a(int r1, at r2, bl r3);

    public abstract void a(int r1, String r2);

    public abstract void a(int r1, boolean r2);

    public final void a(long r1) {
        b(r1);
    }

    public abstract void a(ByteString r1);

    public abstract void a(at r1);

    abstract void a(at r1, bl r2);

    public abstract void a(String r1);

    final void a(String r4, Utf8.UnpairedSurrogateException r5) {
        f4902b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", r5);
        byte[] r6 = r4.getBytes(ab.f4938b);
        c(r6.length);     // Catch: IndexOutOfBoundsException -> L5
        a(r6, 0, r6.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    public final void a(boolean r1) {
        a(r1 ? 1 : 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.j
    public abstract void a(byte[] r1, int r2, int r3);

    boolean a() {
        return this.d;
    }

    public abstract void b();

    public abstract void b(int r1);

    public abstract void b(int r1, int r2);

    public abstract void b(int r1, long r2);

    public abstract void b(int r1, ByteString r2);

    public abstract void b(long r1);

    public final void b(byte[] r3) {
        c(r3, 0, r3.length);
    }

    public abstract int c();

    public abstract void c(int r1);

    public abstract void c(int r1, int r2);

    public final void c(int r1, long r2) {
        b(r1, k(r2));
    }

    @Deprecated
    final void c(int r3, at r4, bl r5) {
        at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
        bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        a(r3, 3);
        c(r6, r7);
        a(r3, 4);
    }

    public final void c(long r1) {
        b(k(r1));
    }

    @Deprecated
    public final void c(at r3) {
        ((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin")).writeTo(this);
    }

    @Deprecated
    final void c(at r3, bl r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        ((bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin")).a(r5, this.f4903a);
    }

    abstract void c(byte[] r1, int r2, int r3);

    public final void d() {
        if (c() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final void d(int r1) {
        c(p(r1));
    }

    public final void d(int r1, int r2) {
        c(r1, p(r2));
    }

    public abstract void d(int r1, long r2);

    @Deprecated
    public final void d(int r3, at r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
        a(r3, 3);
        c(r5);
        a(r3, 4);
    }

    public abstract void d(long r1);

    public abstract void e(int r1);

    public abstract void e(int r1, int r2);

    public final void e(int r1, long r2) {
        d(r1, r2);
    }

    public final void e(long r1) {
        d(r1);
    }

    public final void f(int r1) {
        e(r1);
    }

    public final void f(int r1, int r2) {
        e(r1, r2);
    }

    public final void g(int r1) {
        b(r1);
    }

    public final void g(int r1, int r2) {
        b(r1, r2);
    }
}
