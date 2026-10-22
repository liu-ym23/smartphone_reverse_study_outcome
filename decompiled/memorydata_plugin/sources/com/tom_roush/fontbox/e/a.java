package com.tom_roush.fontbox.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f15963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f15964b;
    private int[] c;

    static {
        f15963a = new int[]{1, 2, 1};
    }

    public a(InputStream r1) {
        a(a(r1));
    }

    public a(byte[] r1) {
        a(r1);
    }

    private void a(byte[] r6) {
        if (r6.length < 18) goto L34;
        ByteArrayInputStream r0 = new ByteArrayInputStream(r6);
        this.f15964b = new byte[r6.length - 18];
        this.c = new int[f15963a.length];
        int r7 = 0;
        int r1 = 0;
    L5:
        int[] r2 = f15963a;
        if (r7 >= r2.length) goto L32;
        if (r0.read() != 128) goto L31;
        if (r0.read() != r2[r7]) goto L29;
        int r3 = ((r0.read() + (r0.read() << 8)) + (r0.read() << 16)) + (r0.read() << 24);
        if (r3 < 0) goto L27;
        this.c[r7] = r3;
        byte[] r4 = this.f15964b;
        if (r1 >= r4.length) goto L25;
        if (r3 > (r4.length - r1)) goto L23;
        int r5 = r0.read(r4, r1, r3);
        if (r5 < 0) goto L21;
        r1 = r1 + r5;
        r7 = r7 + 1;
        goto L5
    L21:
        throw new EOFException();
    L23:
        throw new EOFException("attempted to read " + r3 + " bytes at position " + r1 + " into array of size " + this.f15964b.length + ", but only space for " + (this.f15964b.length - r1) + " bytes left");
    L25:
        throw new EOFException("attempted to read past EOF");
    L27:
        throw new IOException("PFB record size is negative: " + r3);
    L29:
        throw new IOException("Incorrect record type");
    L31:
        throw new IOException("Start marker missing");
    L32:
        return;
    L34:
        throw new IOException("PFB header missing");
    }

    private byte[] a(InputStream r4) {
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        byte[] r0 = new byte[65535];
    L3:
        int r1 = r4.read(r0);
        if (r1 == (-1)) goto L7;
        r3.write(r0, 0, r1);
        goto L3
    L7:
        return r3.toByteArray();
    }

    public byte[] a() {
        return Arrays.copyOfRange(this.f15964b, 0, this.c[0]);
    }

    public byte[] b() {
        byte[] r0 = this.f15964b;
        int[] r4 = this.c;
        return Arrays.copyOfRange(r0, r4[0], r4[0] + r4[1]);
    }
}
