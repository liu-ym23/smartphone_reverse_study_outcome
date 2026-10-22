package com.bumptech.glide.b;

import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f523b;
    private c c;
    private int d;

    public d() {
        this.f522a = new byte[256];
        this.d = 0;
    }

    private void a(int r6) {
        boolean r1 = false;
    L3:
        if (r1 == true) goto L38;
        if (o() == true) goto L63;
        if (this.c.c > r6) goto L64;
        int r2 = m();
        if (r2 != 33) goto L11;
        int r3 = m();
        if (r3 == 1) goto L37;
        if (r3 != 249) goto L25;
        this.c.d = new b();
        e();
        goto L3
    L25:
        if (r3 == 254) goto L37;
        if (r3 != 255) goto L37;
        l();
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
    L31:
        if (r5 >= 11) goto L34;
        r4.append((char) this.f522a[r5]);
        r5 = r5 + 1;
        goto L31
    L34:
        if (r4.toString().equals("NETSCAPE2.0") == false) goto L37;
        g();
    L37:
        k();
        goto L3
    L11:
        if (r2 != 44) goto L13;
        if (this.c.d != null) goto L19;
        this.c.d = new b();
    L19:
        f();
        goto L3
    L13:
        if (r2 != 59) goto L14;
        r1 = true;
        goto L3
    L14:
        this.c.f521b = 1;
        goto L3
    L64:
        return;
    L63:
        return;
    }

    private int[] b(int r10) {
        byte[] r0 = new byte[r10 * 3];
        int[] r1 = null;
        this.f523b.get(r0);     // Catch: BufferUnderflowException -> L7
        r1 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r10) goto L12;
        int r4 = r3 + 1;     // Catch: BufferUnderflowException -> L7
        int r5 = r0[r3] & 255;     // Catch: BufferUnderflowException -> L7
        int r6 = r4 + 1;     // Catch: BufferUnderflowException -> L7
        int r7 = r0[r4] & 255;     // Catch: BufferUnderflowException -> L7
        int r8 = r6 + 1;     // Catch: BufferUnderflowException -> L7
        int r9 = r2 + 1;     // Catch: BufferUnderflowException -> L7
        r1[r2] = (((r5 << 16) | ViewCompat.MEASURED_STATE_MASK) | (r7 << 8)) | (r0[r6] & 255);     // Catch: BufferUnderflowException -> L7
        r3 = r8;
        r2 = r9;
    L12:
        return r1;
    L7:
        e = move-exception;
        if (Log.isLoggable("GifHeaderParser", 3) == false) goto L11;
        Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
    L11:
        this.c.f521b = 1;
        goto L12
    }

    private void c() {
        this.f523b = null;
        Arrays.fill(this.f522a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int r0 = m();
        this.c.d.g = (r0 & 28) >> 2;
        boolean r2 = true;
        if (this.c.d.g != 0) goto L5;
        this.c.d.g = 1;
    L5:
        b r1 = this.c.d;
        if ((r0 & 1) != 0) goto L9;
        r2 = false;
    L9:
        r1.f = r2;
        int r3 = n();
        if (r3 >= 2) goto L12;
        r3 = 10;
    L12:
        this.c.d.i = r3 * 10;
        this.c.d.h = m();
        m();
    }

    private void f() {
        this.c.d.f518a = n();
        this.c.d.f519b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int r0 = m();
        boolean r2 = false;
        if ((r0 & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        int r4 = (int) Math.pow(2.0d, (r0 & 7) + 1);
        b r5 = this.c.d;
        if ((r0 & 64) == 0) goto L9;
        r2 = true;
    L9:
        r5.e = r2;
        b r3 = this.c.d;
        if (r1 == false) goto L12;
        r3.k = b(r4);
    L13:
        this.c.d.j = this.f523b.position();
        j();
        if (o() == false) goto L16;
        return;
    L16:
        this.c.c++;
        this.c.e.add(this.c.d);
        return;
    L12:
        r3.k = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private void g() {
    L2:
        l();
        byte[] r0 = this.f522a;
        if (r0[0] != 1) goto L6;
        int r1 = r0[1] & 255;
        int r2 = r0[2] & 255;
        int r3 = (r2 << 8) | r1;
        this.c.m = r3;
    L6:
        if (this.d <= 0) goto L9;
        if (o() == false) goto L2;
        return;
    }

    private void h() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L7;
        r0.append((char) m());
        r1 = r1 + 1;
        goto L4
    L7:
        if (r0.toString().startsWith("GIF") == true) goto L10;
        this.c.f521b = 1;
        return;
    L10:
        i();
        if (this.c.h == true) goto L13;
        return;
    L13:
        if (o() == true) goto L18;
        c r2 = this.c;
        r2.f520a = b(r2.i);
        c r3 = this.c;
        r3.l = r3.f520a[this.c.j];
        return;
    }

    private void i() {
        this.c.f = n();
        this.c.g = n();
        int r0 = m();
        c r1 = this.c;
        if ((r0 & 128) == 0) goto L5;
        boolean r2 = true;
    L6:
        r1.h = r2;
        this.c.i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.c.j = m();
        this.c.k = m();
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void j() {
        m();
        k();
    }

    private void k() {
    L2:
        int r0 = m();
        int r1 = Math.min(this.f523b.position() + r0, this.f523b.limit());
        this.f523b.position(r1);
        if (r0 > 0) goto L2;
    }

    private void l() {
        int r0 = m();
        this.d = r0;
        if (r0 <= 0) goto L18;
        int r1 = 0;
        int r2 = 0;
    L15:
        int r3 = this.d;     // Catch: Exception -> L9
        if (r1 >= r3) goto L19;
        r2 = r3 - r1;     // Catch: Exception -> L9
        this.f523b.get(this.f522a, r1, r2);     // Catch: Exception -> L9
        r1 = r1 + r2;
        goto L15
    L19:
        return;
    L9:
        e = move-exception;
        if (Log.isLoggable("GifHeaderParser", 3) == false) goto L13;
        Log.d("GifHeaderParser", "Error Reading Block n: " + r1 + " count: " + r2 + " blockSize: " + this.d, e);
    L13:
        this.c.f521b = 1;
        return;
    }

    private int m() {
        return this.f523b.get() & 255;
    L4:
        this.c.f521b = 1;
        return 0;
    }

    private int n() {
        return this.f523b.getShort();
    }

    private boolean o() {
        if (this.c.f521b == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public d a(ByteBuffer r2) {
        c();
        ByteBuffer r3 = r2.asReadOnlyBuffer();
        this.f523b = r3;
        r3.position(0);
        this.f523b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f523b = null;
        this.c = null;
    }

    public c b() {
        if (this.f523b == null) goto L16;
        if (o() == true) goto L7;
        h();
        if (o() == true) goto L14;
        d();
        if (this.c.c >= 0) goto L14;
        this.c.f521b = 1;
    L14:
        return this.c;
    L7:
        return this.c;
    L16:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
