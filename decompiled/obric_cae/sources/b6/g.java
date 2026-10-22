package b6;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.util.Random;
import jf.v;
import jf.x;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f3117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.e f3118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jf.d f3119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final jf.d f3121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f3122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f3124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jf.d.c f3125j;

    public final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3127b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f3128m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f3129n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ g f3130o;

        public a(g r8) {
            this.f3130o = r8;
        }

        @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f3129n == true) goto L7;
            g r8 = this.f3130o;
            r8.d(this.f3126a, r8.f3121f.f8830b, this.f3128m, true);
            this.f3129n = true;
            this.f3130o.f3123h = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // jf.v, java.io.Flushable
        public final void flush() {
            if (this.f3129n == true) goto L7;
            g r8 = this.f3130o;
            r8.d(this.f3126a, r8.f3121f.f8830b, this.f3128m, false);
            this.f3128m = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // jf.v
        public final x timeout() {
            return this.f3130o.f3118c.timeout();
        }

        @Override // jf.v
        public final void write(jf.d r8, long r10) {
            if (this.f3129n == true) goto L18;
            g r11 = this.f3130o;
            r11.f3121f.write(r8, r10);
            boolean r12 = this.f3128m;
            jf.d r13 = r11.f3121f;
            if (r12 == false) goto L11;
            long r14 = this.f3127b;
            if (r14 == (-1)) goto L11;
            if (r13.f8830b <= (r14 - 8192)) goto L11;
            boolean r15 = true;
        L12:
            long r16 = r13.i();
            if (r16 <= 0) goto L19;
            if (r15 == true) goto L20;
            this.f3130o.d(this.f3126a, r16, this.f3128m, false);
            this.f3128m = false;
            return;
        L20:
            return;
        L19:
            return;
        L11:
            r15 = false;
            goto L12
        L18:
            throw new IOException("closed");
        }
    }

    public g(boolean r8, jf.e r10, Random r11) {
        this.f3121f = new jf.d();
        this.f3122g = new a(this);
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        this.f3116a = r8;
        this.f3118c = r10;
        this.f3119d = r10.b();
        this.f3117b = r11;
        jf.d.c r12 = null;
        if (r8 == false) goto L8;
        byte[] r13 = new byte[4];
    L9:
        this.f3124i = r13;
        if (r8 == false) goto L12;
        r12 = new jf.d.c();
    L12:
        this.f3125j = r12;
        return;
    L8:
        r13 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    public final a a(int r8, long r10) {
        if (this.f3123h == true) goto L7;
        this.f3123h = true;
        a r11 = this.f3122g;
        r11.f3126a = r8;
        r11.f3127b = r10;
        r11.f3128m = true;
        r11.f3129n = false;
        return r11;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public final void b(int r8, jf.g r10) {
        jf.g r11 = jf.g.f8841o;
        if (r8 != 0) goto L5;
        if (r10 != null) goto L5;
    L22:
        c(8, r11);     // Catch: Throwable -> L19
        this.f3120e = true;
        return;
    L19:
        th = move-exception;
        this.f3120e = true;
        throw th;
    L5:
        if (r8 == 0) goto L11;
        String r12 = e.a(r8);
        if (r12 == null) goto L11;
        throw new IllegalArgumentException(r12);
    L11:
        jf.d r13 = new jf.d();
        r13.V(r8);
        if (r10 == null) goto L14;
        r13.E(r10);
    L14:
        r11 = r13.x();
        goto L22
    }

    public final void c(int r8, jf.g r10) {
        if (this.f3120e == true) goto L17;
        int r11 = r10.l();
        if (r11 > 125) goto L15;
        jf.d r12 = this.f3119d;
        r12.G(r8 | 128);
        if (this.f3116a == false) goto L11;
        r12.G(r11 | 128);
        Random r13 = this.f3117b;
        byte[] r14 = this.f3124i;
        r13.nextBytes(r14);
        r12.m15write(r14);
        if (r11 <= 0) goto L12;
        long r15 = r12.f8830b;
        r12.E(r10);
        jf.d.c r16 = this.f3125j;
        r12.v(r16);
        r16.a(r15);
        e.b(r16, r14);
        r16.close();
    L12:
        this.f3118c.flush();
        return;
    L11:
        r12.G(r11);
        r12.E(r10);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    public final void d(int r8, long r10, boolean r11, boolean r12) {
        if (this.f3120e == true) goto L29;
        int r13 = 0;
        if (r11 == true) goto L8;
        r8 = 0;
    L8:
        if (r12 == false) goto L10;
        r8 = r8 | 128;
    L10:
        jf.d r14 = this.f3119d;
        r14.G(r8);
        boolean r15 = this.f3116a;
        if (r15 == false) goto L14;
        r13 = 128;
    L14:
        if (r10 > 125) goto L17;
        r14.G(((int) r10) | r13);
    L20:
        jf.d r16 = this.f3121f;
        if (r15 == false) goto L25;
        Random r17 = this.f3117b;
        byte[] r18 = this.f3124i;
        r17.nextBytes(r18);
        r14.m15write(r18);
        if (r10 <= 0) goto L26;
        long r19 = r14.f8830b;
        r14.write(r16, r10);
        jf.d.c r20 = this.f3125j;
        r14.v(r20);
        r20.a(r19);
        e.b(r20, r18);
        r20.close();
    L26:
        this.f3118c.f();
        return;
    L25:
        r14.write(r16, r10);
        goto L26
    L17:
        if (r10 > 65535) goto L19;
        r14.G(r13 | 126);
        r14.V((int) r10);
        goto L20
    L19:
        r14.G(r13 | QesdkUtils.LIMITS.INT_8_UPPER);
        r14.K(r10);
        goto L20
    L29:
        throw new IOException("closed");
    }

    public final void e(jf.g r8) {
        c(10, r8);
    }
}
