package bf;

import af.h;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import jf.j;
import jf.p;
import jf.w;
import jf.x;
import we.a0;
import we.q;
import we.r;
import we.v;
import we.y;
import ze.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements af.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f3173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.f f3175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jf.e f3176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3178f;

    /* JADX INFO: renamed from: bf.a$a, reason: collision with other inner class name */
    public abstract class AbstractC0037a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f3179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3180b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f3181m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ a f3182n;

        public AbstractC0037a(a r8) {
            this.f3182n = r8;
            this.f3179a = new j(r8.f3175c.timeout());
            this.f3181m = 0;
        }

        public final void a(IOException r8, boolean r10) {
            a r11 = this.f3182n;
            int r12 = r11.f3177e;
            if (r12 != 6) goto L6;
            return;
        L6:
            if (r12 != 5) goto L12;
            j r13 = this.f3179a;
            x r14 = r13.f8846e;
            r13.f8846e = x.f8881d;
            r14.a();
            r14.b();
            r11.f3177e = 6;
            g r15 = r11.f3174b;
            if (r15 == null) goto L13;
            r15.i(!r10, r11, this.f3181m, r8);
            return;
        L13:
            return;
        L12:
            throw new IllegalStateException("state: " + r11.f3177e);
        }

        @Override // jf.w
        public final x timeout() {
            return this.f3179a;
        }

        @Override // jf.w
        public long u(jf.d r8, long r10) {
            long r11 = this.f3182n.f3175c.u(r8, r10);     // Catch: IOException -> L6
            if (r11 <= 0) goto L5;
            this.f3181m += r11;     // Catch: IOException -> L6
        L5:
            return r11;
        L6:
            e = move-exception;
            a(e, false);
            throw e;
        }
    }

    public final class b implements jf.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f3183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3184b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ a f3185m;

        public b(a r8) {
            this.f3185m = r8;
            this.f3183a = new j(r8.f3176d.timeout());
        }

        @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f3184b == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f3184b = true;     // Catch: Throwable -> L11
            this.f3185m.f3176d.p("0\r\n\r\n");     // Catch: Throwable -> L11
            a r8 = this.f3185m;     // Catch: Throwable -> L11
            j r10 = this.f3183a;     // Catch: Throwable -> L11
            r8.getClass();     // Catch: Throwable -> L11
            x r11 = r10.f8846e;     // Catch: Throwable -> L11
            r10.f8846e = x.f8881d;     // Catch: Throwable -> L11
            r11.a();     // Catch: Throwable -> L11
            r11.b();     // Catch: Throwable -> L11
            this.f3185m.f3177e = 3;     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // jf.v, java.io.Flushable
        public final synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f3184b == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.f3185m.f3176d.flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // jf.v
        public final x timeout() {
            return this.f3183a;
        }

        @Override // jf.v
        public final void write(jf.d r8, long r10) {
            if (this.f3184b == true) goto L10;
            if (r10 != 0) goto L7;
            return;
        L7:
            a r11 = this.f3185m;
            r11.f3176d.d0(r10);
            jf.e r12 = r11.f3176d;
            r12.p("\r\n");
            r12.write(r8, r10);
            r12.p("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed");
        }
    }

    public class c extends AbstractC0037a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final r f3186o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f3187p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f3188q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ a f3189r;

        public c(a r8, r r10) {
            this.f3189r = r8;
            super(r8);
            this.f3187p = -1;
            this.f3188q = true;
            this.f3186o = r10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f3180b == false) goto L6;
            return;
        L6:
            if (this.f3188q == true) goto L8;
        L10:
            this.f3180b = true;
            return;
        L8:
            if (xe.c.l(this, TimeUnit.MILLISECONDS) == true) goto L10;
            a(null, false);
            goto L10
        }

        @Override // bf.a.AbstractC0037a, jf.w
        public final long u(jf.d r11, long r12) {
            if (r12 < 0) goto L42;
            if (this.f3180b == true) goto L40;
            if (this.f3188q == true) goto L9;
            return -1;
        L9:
            long r8 = this.f3187p;
            if (r8 != 0) goto L12;
        L13:
            a r10 = this.f3189r;
            if (r8 == (-1)) goto L43;
            r10.f3175c.y();
        L43:
            this.f3187p = r10.f3175c.o0();     // Catch: NumberFormatException -> L36
            String r13 = r10.f3175c.y().trim();     // Catch: NumberFormatException -> L36
            if (this.f3187p < 0) goto L35;
            if (r13.isEmpty() == true) goto L23;
            if (r13.startsWith(";") == false) goto L35;
        L23:
            if (this.f3187p != 0) goto L26;
            this.f3188q = false;
            af.e.d(r10.f3173a.f13285s, this.f3186o, r10.h());
            a(null, true);
        L26:
            if (this.f3188q == true) goto L28;
            return -1;
        L28:
            long r14 = super.u(r11, Math.min(r12, this.f3187p));
            if (r14 == (-1)) goto L32;
            this.f3187p -= r14;
            return r14;
        L32:
            ProtocolException r15 = new ProtocolException("unexpected end of stream");
            a(r15, false);
            throw r15;
        L35:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f3187p + r13 + "\"");     // Catch: NumberFormatException -> L36
        L36:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        L12:
            if (r8 != (-1)) goto L28;
        L40:
            throw new IllegalStateException("closed");
        L42:
            throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r12));
        }
    }

    public final class d implements jf.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f3190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3191b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f3192m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ a f3193n;

        public d(a r8, long r10) {
            this.f3193n = r8;
            this.f3190a = new j(r8.f3176d.timeout());
            this.f3192m = r10;
        }

        @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f3191b == false) goto L5;
            return;
        L5:
            this.f3191b = true;
            if (this.f3192m > 0) goto L10;
            a r8 = this.f3193n;
            r8.getClass();
            j r10 = this.f3190a;
            x r11 = r10.f8846e;
            r10.f8846e = x.f8881d;
            r11.a();
            r11.b();
            r8.f3177e = 3;
            return;
        L10:
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // jf.v, java.io.Flushable
        public final void flush() {
            if (this.f3191b == false) goto L5;
            return;
        L5:
            this.f3193n.f3176d.flush();
        }

        @Override // jf.v
        public final x timeout() {
            return this.f3190a;
        }

        @Override // jf.v
        public final void write(jf.d r8, long r10) {
            if (this.f3191b == true) goto L11;
            xe.c.e(r8.size(), 0, r10);
            if (r10 > this.f3192m) goto L9;
            this.f3193n.f3176d.write(r8, r10);
            this.f3192m -= r10;
            return;
        L9:
            throw new ProtocolException("expected " + this.f3192m + " bytes but received " + r10);
        L11:
            throw new IllegalStateException("closed");
        }
    }

    public class e extends AbstractC0037a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f3194o;

        public e(a r8, long r10) {
            super(r8);
            this.f3194o = r10;
            if (r10 != 0) goto L6;
            a(null, true);
            return;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f3180b == false) goto L6;
            return;
        L6:
            if (this.f3194o != 0) goto L8;
        L10:
            this.f3180b = true;
            return;
        L8:
            if (xe.c.l(this, TimeUnit.MILLISECONDS) == true) goto L10;
            a(null, false);
            goto L10
        }

        @Override // bf.a.AbstractC0037a, jf.w
        public final long u(jf.d r8, long r10) {
            if (r10 < 0) goto L20;
            if (this.f3180b == true) goto L18;
            long r11 = this.f3194o;
            if (r11 != 0) goto L9;
            return -1;
        L9:
            long r12 = super.u(r8, Math.min(r11, r10));
            if (r12 == (-1)) goto L15;
            long r13 = this.f3194o - r12;
            this.f3194o = r13;
            if (r13 != 0) goto L14;
            a(null, true);
        L14:
            return r12;
        L15:
            ProtocolException r14 = new ProtocolException("unexpected end of stream");
            a(r14, false);
            throw r14;
        L18:
            throw new IllegalStateException("closed");
        L20:
            throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
        }
    }

    public class f extends AbstractC0037a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f3195o;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f3180b == false) goto L6;
            return;
        L6:
            if (this.f3195o == true) goto L8;
            a(null, false);
        L8:
            this.f3180b = true;
        }

        @Override // bf.a.AbstractC0037a, jf.w
        public final long u(jf.d r8, long r10) {
            if (r10 < 0) goto L17;
            if (this.f3180b == true) goto L15;
            if (this.f3195o == false) goto L9;
            return -1;
        L9:
            long r11 = super.u(r8, r10);
            if (r11 != (-1)) goto L13;
            this.f3195o = true;
            a(null, true);
            return -1;
        L13:
            return r11;
        L15:
            throw new IllegalStateException("closed");
        L17:
            throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
        }
    }

    public a(v r8, g r10, jf.f r11, jf.e r12) {
        this.f3177e = 0;
        this.f3178f = 262144;
        this.f3173a = r8;
        this.f3174b = r10;
        this.f3175c = r11;
        this.f3176d = r12;
    }

    @Override // af.c
    public final void a() {
        this.f3176d.flush();
    }

    @Override // af.c
    public final void b(y r8) {
        Proxy.Type r10 = this.f3174b.b().f14374c.f13159b.type();
        StringBuilder r11 = new StringBuilder();
        r11.append(r8.f13339c);
        r11.append(' ');
        r r12 = r8.f13337a;
        if (r12.f13241a.equals(LocationInfoConst.HTTPS) == false) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        r11.append(r12);
    L11:
        r11.append(" HTTP/1.1");
        String r14 = r11.toString();
        i(r8.f13340d, r14);
        return;
    L10:
        r11.append(h.a(r12));
        goto L11
    L5:
        if (r10 != Proxy.Type.HTTP) goto L7;
        r13 = true;
        goto L8
    }

    @Override // af.c
    public final af.g c(a0 r11) {
        g r8 = this.f3174b;
        r8.f14405f.responseBodyStart(r8.f14404e);
        String r10 = r11.n("Content-Type");
        if (af.e.b(r11) == true) goto L7;
        e r12 = g(0);
        Logger r13 = p.f8861a;
        return new af.g(r10, 0, new jf.r(r12));
    L7:
        if ("chunked".equalsIgnoreCase(r11.n("Transfer-Encoding")) == false) goto L14;
        r r14 = r11.f13114a.f13337a;
        if (this.f3177e != 4) goto L13;
        this.f3177e = 5;
        c r15 = new c(this, r14);
        Logger r16 = p.f8861a;
        return new af.g(r10, -1, new jf.r(r15));
    L13:
        throw new IllegalStateException("state: " + this.f3177e);
    L14:
        long r17 = af.e.a(r11);
        if (r17 == (-1)) goto L19;
        e r18 = g(r17);
        Logger r19 = p.f8861a;
        return new af.g(r10, r17, new jf.r(r18));
    L19:
        if (this.f3177e != 4) goto L23;
        this.f3177e = 5;
        r8.f();
        f r20 = new f(this);
        Logger r110 = p.f8861a;
        return new af.g(r10, -1, new jf.r(r20));
    L23:
        throw new IllegalStateException("state: " + this.f3177e);
    }

    @Override // af.c
    public final void cancel() {
        ze.d r8 = this.f3174b.b();
        if (r8 == null) goto L6;
        xe.c.g(r8.f14375d);
        return;
    }

    @Override // af.c
    public final jf.v d(y r8, long r10) {
        if ("chunked".equalsIgnoreCase(r8.b("Transfer-Encoding")) == false) goto L11;
        if (this.f3177e != 1) goto L9;
        this.f3177e = 2;
        return new b(this);
    L9:
        throw new IllegalStateException("state: " + this.f3177e);
    L11:
        if (r10 == (-1)) goto L19;
        if (this.f3177e != 1) goto L17;
        this.f3177e = 2;
        return new d(this, r10);
    L17:
        throw new IllegalStateException("state: " + this.f3177e);
    L19:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // af.c
    public final a0.a e(boolean r8) {
        int r10 = this.f3177e;
        if (r10 == 1) goto L23;
        if (r10 == 3) goto L23;
        throw new IllegalStateException("state: " + this.f3177e);
    L23:
        String r11 = this.f3175c.l(this.f3178f);     // Catch: EOFException -> L20
        this.f3178f -= (long) r11.length();     // Catch: EOFException -> L20
        r3.e r12 = r3.e.a(r11);     // Catch: EOFException -> L20
        a0.a r13 = new a0.a();     // Catch: EOFException -> L20
        r13.f13127b = (we.w) r12.f11423c;     // Catch: EOFException -> L20
        r13.f13128c = r12.f11422b;     // Catch: EOFException -> L20
        r13.f13129d = (String) r12.f11424d;     // Catch: EOFException -> L20
        r13.f13131f = h().g();     // Catch: EOFException -> L20
        if (r8 == false) goto L15;
        if (r12.f11422b != 100) goto L15;
        return null;
    L15:
        if (r12.f11422b != 100) goto L18;
        this.f3177e = 3;     // Catch: EOFException -> L20
        return r13;
    L18:
        this.f3177e = 4;     // Catch: EOFException -> L20
        return r13;
    L20:
        e = move-exception;
        IOException r14 = new IOException("unexpected end of stream on " + this.f3174b);
        r14.initCause(e);
        throw r14;
    }

    @Override // af.c
    public final void f() {
        this.f3176d.flush();
    }

    public final e g(long r8) {
        if (this.f3177e != 4) goto L7;
        this.f3177e = 5;
        return new e(this, r8);
    L7:
        throw new IllegalStateException("state: " + this.f3177e);
    }

    public final q h() {
        q.a r8 = new q.a();
    L3:
        String r10 = this.f3175c.l(this.f3178f);
        this.f3178f -= (long) r10.length();
        if (r10.length() == 0) goto L14;
        xe.a.f13878a.getClass();
        int r11 = r10.indexOf(BdimCategoryConstants.SEPARATOR_COLON, 1);
        if (r11 == (-1)) goto L10;
        String r12 = r10.substring(0, r11);
        r10 = r10.substring(r11 + 1);
    L8:
        r8.b(r12, r10);
        goto L3
    L10:
        if (r10.startsWith(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L12;
        r10 = r10.substring(1);
    L12:
        r12 = "";
        goto L8
    L14:
        return new q(r8);
    }

    public final void i(q r8, String r10) {
        if (this.f3177e != 0) goto L10;
        jf.e r11 = this.f3176d;
        r11.p(r10).p("\r\n");
        int r12 = r8.f13238a.length / 2;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r11.p(r8.e(r13)).p(": ").p(r8.j(r13)).p("\r\n");
        r13 = r13 + 1;
        goto L5
    L7:
        r11.p("\r\n");
        this.f3177e = 1;
        return;
    L10:
        throw new IllegalStateException("state: " + this.f3177e);
    }
}
