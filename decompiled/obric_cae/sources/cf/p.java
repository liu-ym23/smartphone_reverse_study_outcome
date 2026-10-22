package cf;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Closeable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Logger f3587q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.e f3588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3589b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jf.d f3590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3591n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3592o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d.b f3593p;

    static {
        f3587q = Logger.getLogger(e.class.getName());
    }

    public p(jf.e r8, boolean r10) {
        this.f3588a = r8;
        this.f3589b = r10;
        jf.d r11 = new jf.d();
        this.f3590m = r11;
        this.f3593p = new d.b(r11);
        this.f3591n = 16384;
    }

    public final synchronized void a(p.f r8) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L32;
        int r10 = this.f3591n;     // Catch: Throwable -> L33
        int r11 = r8.f9887a;     // Catch: Throwable -> L33
        if ((r11 & 32) == 0) goto L8;
        r10 = ((int[]) r8.f9888b)[5];     // Catch: Throwable -> L33
    L8:
        this.f3591n = r10;     // Catch: Throwable -> L33
        if ((r11 & 2) == 0) goto L11;
        int r12 = ((int[]) r8.f9888b)[1];     // Catch: Throwable -> L33
    L13:
        if (r12 == (-1)) goto L28;
        d.b r13 = this.f3593p;     // Catch: Throwable -> L33
        if ((r11 & 2) == 0) goto L17;
        int r14 = ((int[]) r8.f9888b)[1];     // Catch: Throwable -> L33
    L18:
        r13.getClass();     // Catch: Throwable -> L33
        int r15 = Math.min(r14, 16384);     // Catch: Throwable -> L33
        int r16 = r13.f3480d;     // Catch: Throwable -> L33
        if (r16 == r15) goto L28;
        if (r15 >= r16) goto L23;
        r13.f3478b = Math.min(r13.f3478b, r15);     // Catch: Throwable -> L33
    L23:
        r13.f3479c = true;     // Catch: Throwable -> L33
        r13.f3480d = r15;     // Catch: Throwable -> L33
        int r17 = r13.f3484h;     // Catch: Throwable -> L33
        if (r15 >= r17) goto L28;
        if (r15 != 0) goto L27;
        Arrays.fill(r13.f3481e, null);     // Catch: Throwable -> L33
        r13.f3482f = r13.f3481e.length - 1;     // Catch: Throwable -> L33
        r13.f3483g = 0;     // Catch: Throwable -> L33
        r13.f3484h = 0;     // Catch: Throwable -> L33
        goto L28
    L27:
        r13.a(r17 - r15);     // Catch: Throwable -> L33
        goto L28
    L17:
        r14 = -1;
    L28:
        k(0, 0, (byte) 4, (byte) 1);     // Catch: Throwable -> L33
        this.f3588a.flush();     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L11:
        r12 = -1;
        goto L13
    L32:
        throw new IOException("closed");     // Catch: Throwable -> L33
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        this.f3592o = true;     // Catch: Throwable -> L7
        this.f3588a.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void i(boolean r8, int r10, jf.d r11, int r12) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L15;
        if (r8 == false) goto L8;
        byte r13 = (byte) 1;     // Catch: Throwable -> L16
    L9:
        k(r10, r12, (byte) 0, r13);     // Catch: Throwable -> L16
        if (r12 <= 0) goto L12;
        this.f3588a.write(r11, r12);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r13 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }

    public final void k(int r8, int r10, byte r11, byte r12) {
        Level r13 = Level.FINE;
        Logger r14 = f3587q;
        if (r14.isLoggable(r13) == false) goto L5;
        r14.fine(e.a(false, r8, r10, r11, r12));
    L5:
        int r15 = this.f3591n;
        if (r10 <= r15) goto L8;
        Object[] r16 = {Integer.valueOf(r15), Integer.valueOf(r10)};
        jf.g r17 = e.f3485a;
        throw new IllegalArgumentException(xe.c.n("FRAME_SIZE_ERROR length > %d: %d", r16));
    L8:
        if ((Integer.MIN_VALUE & r8) != 0) goto L11;
        jf.e r18 = this.f3588a;
        r18.writeByte((r10 >>> 16) & 255);
        r18.writeByte((r10 >>> 8) & 255);
        r18.writeByte(r10 & 255);
        r18.writeByte(r11 & 255);
        r18.writeByte(r12 & 255);
        r18.writeInt(r8 & Integer.MAX_VALUE);
        return;
    L11:
        Object[] r19 = {Integer.valueOf(r8)};
        jf.g r20 = e.f3485a;
        throw new IllegalArgumentException(xe.c.n("reserved bit set: %s", r19));
    }

    public final synchronized void n(int r8, b r10, byte[] r11) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L16;
        if (r10.f3457a == (-1)) goto L13;
        k(0, r11.length + 8, (byte) 7, (byte) 0);     // Catch: Throwable -> L17
        this.f3588a.writeInt(r8);     // Catch: Throwable -> L17
        this.f3588a.writeInt(r10.f3457a);     // Catch: Throwable -> L17
        if (r11.length <= 0) goto L10;
        this.f3588a.write(r11);     // Catch: Throwable -> L17
    L10:
        this.f3588a.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        jf.g r12 = e.f3485a;     // Catch: Throwable -> L17
        throw new IllegalArgumentException(xe.c.n("errorCode.httpCode == -1", new Object[0]));     // Catch: Throwable -> L17
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public final void r(int r8, ArrayList r10, boolean r11) {
        if (this.f3592o == true) goto L15;
        this.f3593p.d(r10);
        jf.d r12 = this.f3590m;
        long r13 = r12.size();
        int r14 = (int) Math.min(this.f3591n, r13);
        long r15 = r14;
        if (r13 != r15) goto L7;
        byte r16 = 4;
    L8:
        if (r11 == false) goto L10;
        r16 = (byte) (r16 | 1);
    L10:
        k(r8, r14, (byte) 1, r16);
        this.f3588a.write(r12, r15);
        if (r13 <= r15) goto L16;
        z(r8, r13 - r15);
        return;
    L16:
        return;
    L7:
        r16 = 0;
        goto L8
    L15:
        throw new IOException("closed");
    }

    public final synchronized void v(int r8, int r10, boolean r11) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L13;
        if (r11 == false) goto L8;
        byte r12 = 1;
    L9:
        k(0, 8, (byte) 6, r12);     // Catch: Throwable -> L14
        this.f3588a.writeInt(r8);     // Catch: Throwable -> L14
        this.f3588a.writeInt(r10);     // Catch: Throwable -> L14
        this.f3588a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r12 = 0;
        goto L9
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public final synchronized void w(int r8, b r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L13;
        if (r10.f3457a == (-1)) goto L11;
        k(r8, 4, (byte) 3, (byte) 0);     // Catch: Throwable -> L14
        this.f3588a.writeInt(r10.f3457a);     // Catch: Throwable -> L14
        this.f3588a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L14
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public final synchronized void x(int r8, long r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f3592o == true) goto L15;
        if (r10 != 0) goto L8;
    L12:
        Object[] r11 = {Long.valueOf(r10)};     // Catch: Throwable -> L16
        jf.g r12 = e.f3485a;     // Catch: Throwable -> L16
        throw new IllegalArgumentException(xe.c.n("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", r11));     // Catch: Throwable -> L16
    L8:
        if (r10 > 2147483647L) goto L12;
        k(r8, 4, (byte) 8, (byte) 0);     // Catch: Throwable -> L16
        this.f3588a.writeInt((int) r10);     // Catch: Throwable -> L16
        this.f3588a.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }

    public final void z(int r8, long r10) {
    L3:
        if (r10 <= 0) goto L9;
        int r11 = (int) Math.min(this.f3591n, r10);
        long r12 = r11;
        r10 = r10 - r12;
        if (r10 != 0) goto L7;
        byte r13 = 4;
    L8:
        k(r8, r11, (byte) 9, r13);
        this.f3588a.write(this.f3590m, r12);
        goto L3
    L7:
        r13 = 0;
        goto L8
    }
}
