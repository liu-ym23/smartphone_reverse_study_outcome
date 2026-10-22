package ff;

import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import jf.k;
import jf.n;
import jf.p;
import jf.r;
import jf.x;
import xe.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f7426e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f7427f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f7428g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f7429h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f7430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f7431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f7432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f7433d;

    static {
        f7426e = new byte[]{42};
        f7427f = new String[0];
        f7428g = new String[]{"*"};
        f7429h = new a();
    }

    public a() {
        this.f7430a = new AtomicBoolean(false);
        this.f7431b = new CountDownLatch(1);
    }

    public static String a(byte[] r17, byte[][] r18, int r19) {
        int r8 = r17.length;
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L43;
        int r11 = (r10 + r8) / 2;
    L6:
        if (r11 <= (-1)) goto L10;
        if (r17[r11] == 10) goto L10;
        r11 = r11 - 1;
    L10:
        int r12 = r11 + 1;
        int r13 = 1;
    L11:
        int r14 = r12 + r13;
        if (r17[r14] == 10) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        int r15 = r14 - r12;
        int r16 = r19;
        boolean r20 = false;
        int r110 = 0;
        int r111 = 0;
    L15:
        if (r20 == false) goto L17;
        int r21 = 46;
        boolean r112 = false;
    L18:
        int r22 = r21 - (r17[r12 + r111] & 255);
        if (r22 != 0) goto L28;
        r111 = r111 + 1;
        r110 = r110 + 1;
        if (r111 == r15) goto L28;
        if (r18[r16].length == r110) goto L27;
        r20 = r112;
        goto L15
    L27:
        if (r16 == (r18.length - 1)) goto L28;
        r16 = r16 + 1;
        r110 = -1;
        r20 = true;
    L28:
        if (r22 < 0) goto L37;
        if (r22 > 0) goto L39;
        int r23 = r15 - r111;
        int r24 = r18[r16].length - r110;
    L33:
        r16 = r16 + 1;
        if (r16 >= r18.length) goto L36;
        r24 = r24 + r18[r16].length;
        goto L33
    L36:
        if (r24 < r23) goto L37;
        if (r24 > r23) goto L39;
        return new String(r17, r12, r15, c.f13888i);
    L39:
        r10 = r14 + 1;
    L37:
        r8 = r12 - 1;
        goto L3
    L17:
        r112 = r20;
        r21 = r18[r16][r110] & 255;
        goto L18
    L43:
        return null;
    }

    public final void b() {
        InputStream r8 = a.class.getResourceAsStream("publicsuffixes.gz");
        if (r8 != null) goto L5;
        return;
    L5:
        Logger r10 = p.f8861a;
        r r11 = new r(new k(new n(r8, new x())));
        byte[] r12 = new byte[r11.readInt()];     // Catch: Throwable -> L16
        r11.readFully(r12);     // Catch: Throwable -> L16
        byte[] r13 = new byte[r11.readInt()];     // Catch: Throwable -> L16
        r11.readFully(r13);     // Catch: Throwable -> L16
        c.f(r11);
        monitor-enter(this);
        this.f7432c = r12;     // Catch: Throwable -> L13
        this.f7433d = r13;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.f7431b.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        c.f(r11);
        throw th;
    }
}
