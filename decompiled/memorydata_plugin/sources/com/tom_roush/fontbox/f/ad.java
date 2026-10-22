package com.tom_roush.fontbox.f;

import androidx.core.view.InputDeviceCompat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
abstract class ad implements Closeable {
    ad() {
    }

    public abstract int a(byte[] r1, int r2, int r3);

    public abstract long a();

    public String a(int r2) {
        return a(r2, com.tom_roush.fontbox.g.b.f16026a);
    }

    public String a(int r1, Charset r2) {
        return new String(d(r1), r2);
    }

    public abstract void a(long r1);

    public int[] b(int r4) {
        int[] r0 = new int[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = c();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public abstract int c();

    public int[] c(int r4) {
        int[] r0 = new int[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = d();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public abstract int d();

    public byte[] d(int r5) {
        byte[] r0 = new byte[r5];
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L7;
        int r2 = a(r0, r1, r5 - r1);
        if (r2 == (-1)) goto L7;
        r1 = r1 + r2;
    L7:
        if (r1 != r5) goto L10;
        return r0;
    L10:
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public abstract short e();

    public abstract long f();

    public abstract long g();

    public float h() {
        return e() + (d() / 65536.0f);
    }

    public int i() {
        int r1 = c();
        if (r1 > 127) goto L6;
        return r1;
    L6:
        return r1 + InputDeviceCompat.SOURCE_ANY;
    }

    public int j() {
        int r1 = c();
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        throw new EOFException("premature EOF");
    }

    public long k() {
        long r0 = c();
        long r2 = c();
        long r4 = c();
        long r6 = c();
        if (r6 < 0) goto L7;
        return (((r0 << 24) + (r2 << 16)) + (r4 << 8)) + r6;
    L7:
        throw new EOFException();
    }

    public Calendar l() {
        long r0 = a();
        Calendar r9 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        r9.set(1904, 0, 1, 0, 0, 0);
        r9.set(14, 0);
        r9.setTimeInMillis(r9.getTimeInMillis() + (r0 * 1000));
        return r9;
    }

    public String m() {
        return new String(d(4), com.tom_roush.fontbox.g.b.d);
    }
}
