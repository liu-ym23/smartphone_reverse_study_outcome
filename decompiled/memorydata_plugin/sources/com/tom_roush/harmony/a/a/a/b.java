package com.tom_roush.harmony.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements com.tom_roush.harmony.a.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ByteOrder f16037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f16038b;
    protected long c;
    protected int d;
    private boolean e;
    private final a f;
    private final a g;
    private final byte[] h;

    /* JADX INFO: renamed from: com.tom_roush.harmony.a.a.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long[] f16039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16040b;

        private a() {
            this.f16039a = new long[10];
            this.f16040b = 0;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public b() {
        this.f16037a = ByteOrder.BIG_ENDIAN;
        this.f16038b = 0;
        this.c = 0;
        this.d = 0;
        this.e = false;
        AnonymousClass1 r1 = null;
        this.f = new a(r1);
        this.g = new a(r1);
        this.h = new byte[8];
    }

    public abstract int a(byte[] r1, int r2, int r3);

    public long a(int r6) {
        a();
        if (r6 < 0) goto L11;
        if (r6 > 64) goto L11;
        long r0 = 0;
        int r2 = 0;
    L7:
        if (r2 >= r6) goto L9;
        r0 = (r0 << 1) | ((long) e());
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    L11:
        throw new IllegalArgumentException();
    }

    public long a(long r3) {
        b(d() + r3);
        return r3;
    }

    public final void a() {
        if (this.e == true) goto L6;
        return;
    L6:
        throw new IOException("stream is closed");
    }

    public void a(ByteOrder r1) {
        this.f16037a = r1;
    }

    public ByteOrder b() {
        return this.f16037a;
    }

    public void b(long r3) {
        a();
        if (r3 < f()) goto L7;
        this.d = 0;
        this.f16038b = r3;
        return;
    L7:
        throw new IllegalArgumentException("trying to seek before flushed pos");
    }

    public abstract int c();

    public long d() {
        a();
        return this.f16038b;
    }

    public int e() {
        a();
        int r0 = this.d;
        int r1 = c();
        if (r1 == (-1)) goto L10;
        int r2 = (r0 + 1) & 7;
        if (r2 == 0) goto L7;
        r1 = r1 >> (8 - r2);
        b(d() - 1);
    L7:
        this.d = r2;
        return r1 & 1;
    L10:
        throw new EOFException();
    }

    public long f() {
        return this.c;
    }

    public void finalize() {
        if (this.e == false) goto L10;
        return;
    L10:
        g();     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public void g() {
        a();
        this.e = true;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        int r1 = c();
        if (r1 < 0) goto L9;
        if (r1 == 0) goto L6;
        return true;
    L6:
        return false;
    L9:
        throw new EOFException("EOF reached");
    }

    @Override // java.io.DataInput
    public byte readByte() {
        int r1 = c();
        if (r1 < 0) goto L7;
        return (byte) r1;
    L7:
        throw new EOFException("EOF reached");
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r3) {
        readFully(r3, 0, r3.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L14;
        if (r5 < 0) goto L14;
        if ((r4 + r5) > r3.length) goto L14;
    L6:
        if (r5 <= 0) goto L12;
        int r0 = a(r3, r4, r5);
        if (r0 == (-1)) goto L11;
        r4 = r4 + r0;
        r5 = r5 - r0;
        goto L6
    L11:
        throw new EOFException();
    L12:
        return;
    L14:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.DataInput
    public int readInt() {
        if (a(this.h, 0, 4) < 0) goto L11;
        ByteOrder r0 = this.f16037a;
        ByteOrder r2 = ByteOrder.BIG_ENDIAN;
        byte[] r6 = this.h;
        if (r0 != r2) goto L7;
        int r1 = (((r6[0] & 255) << 24) | ((r6[1] & 255) << 16)) | ((r6[2] & 255) << 8);
        byte r7 = r6[3];
    L9:
        return (r7 & 255) | r1;
    L7:
        r1 = (((r6[3] & 255) << 24) | ((r6[2] & 255) << 16)) | ((r6[1] & 255) << 8);
        r7 = r6[0];
        goto L9
    L11:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readLine() {
        StringBuilder r0 = new StringBuilder(80);
        boolean r1 = true;
    L3:
        int r2 = c();
        if (r2 == (-1)) goto L15;
        r1 = false;
        if (r2 == 10) goto L15;
        if (r2 == 13) goto L10;
        r0.append((char) r2);
        goto L3
    L10:
        int r3 = c();
        if (r3 == 10) goto L15;
        if (r3 == (-1)) goto L15;
        b(d() - 1);
    L15:
        if (r1 == false) goto L18;
        return null;
    L18:
        return r0.toString();
    }

    @Override // java.io.DataInput
    public long readLong() {
        if (a(this.h, 0, 8) < 0) goto L11;
        ByteOrder r0 = this.f16037a;
        ByteOrder r3 = ByteOrder.BIG_ENDIAN;
        byte[] r14 = this.h;
        if (r0 != r3) goto L8;
        int r1 = ((((r14[0] & 255) << 24) | ((r14[1] & 255) << 16)) | ((r14[2] & 255) << 8)) | (r14[3] & 255);
        int r2 = (((r14[4] & 255) << 24) | ((r14[5] & 255) << 16)) | ((r14[6] & 255) << 8);
        return ((((long) r1) & 4294967295L) << 32) | (((long) ((r14[7] & 255) | r2)) & 4294967295L);
    L8:
        int r4 = ((((r14[3] & 255) << 24) | ((r14[2] & 255) << 16)) | ((r14[1] & 255) << 8)) | (r14[0] & 255);
        int r5 = (((r14[7] & 255) << 24) | ((r14[6] & 255) << 16)) | ((r14[5] & 255) << 8);
        return ((((long) ((r14[4] & 255) | r5)) & 4294967295L) << 32) | (((long) r4) & 4294967295L);
    L11:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public short readShort() {
        if (a(this.h, 0, 2) < 0) goto L11;
        ByteOrder r0 = this.f16037a;
        ByteOrder r2 = ByteOrder.BIG_ENDIAN;
        byte[] r4 = this.h;
        if (r0 != r2) goto L7;
        int r1 = r4[0] << 8;
        byte r5 = r4[1];
    L9:
        return (short) ((r5 & 255) | r1);
    L7:
        r1 = r4[1] << 8;
        r5 = r4[0];
        goto L9
    L11:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        ByteOrder r0 = b();
        a(ByteOrder.BIG_ENDIAN);
        int r1 = readUnsignedShort();
        char[] r3 = new char[r1];
        readFully(new byte[r1], 0, r1);
        a(r0);
        return new DataInputStream(new ByteArrayInputStream(this.h)).readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        int r1 = c();
        if (r1 < 0) goto L6;
        return r1;
    L6:
        throw new EOFException("EOF reached");
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    @Override // java.io.DataInput
    public int skipBytes(int r3) {
        return (int) a(r3);
    }
}
