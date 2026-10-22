package af;

import java.net.ProtocolException;
import jf.p;
import jf.q;
import we.a0;
import we.c0;
import we.s;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f356a;

    public static final class a extends jf.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f357a;

        @Override // jf.h, jf.v
        public final void write(jf.d r8, long r10) {
            super.write(r8, r10);
            this.f357a += r10;
        }
    }

    public b(boolean r8) {
        this.f356a = r8;
    }

    @Override // we.s
    public final a0 a(f r12) {
        c r8 = r12.d();
        ze.g r10 = r12.i();
        ze.d r11 = r12.b();
        y r13 = r12.h();
        long r14 = System.currentTimeMillis();
        r12.c().requestHeadersStart(r12.a());
        r8.b(r13);
        r12.c().requestHeadersEnd(r12.a(), r13);
        a0.a r15 = null;
        if (defpackage.c.b0(r13.d()) == true) goto L5;
    L14:
        r8.a();
        if (r15 != null) goto L17;
        r12.c().responseHeadersStart(r12.a());
        r15 = r8.e(false);
    L17:
        r15.f(r13);
        r15.d(r10.b().g());
        r15.g(r14);
        r15.e(System.currentTimeMillis());
        a0 r16 = r15.b();
        int r17 = r16.i();
        if (r17 != 100) goto L20;
        a0.a r18 = r8.e(false);
        r18.f(r13);
        r18.d(r10.b().g());
        r18.g(r14);
        r18.e(System.currentTimeMillis());
        r16 = r18.b();
        r17 = r16.i();
    L20:
        r12.c().responseHeadersEnd(r12.a(), r16);
        if (this.f356a == true) goto L23;
    L25:
        a0.a r19 = r16.v();
        c0 r110 = r8.c(r16);
    L26:
        r19.a(r110);
        a0 r111 = r19.b();
        if ("close".equalsIgnoreCase(r111.w().b("Connection")) == false) goto L29;
    L30:
        r10.f();
    L32:
        if (r17 == 204) goto L36;
        if (r17 == 205) goto L36;
    L37:
        return r111;
    L36:
        if (r111.a().a() <= 0) goto L37;
        StringBuilder r20 = defpackage.b.f("HTTP ", r17, " had non-zero Content-Length: ");
        r20.append(r111.a().a());
        throw new ProtocolException(r20.toString());
    L29:
        if ("close".equalsIgnoreCase(r111.k()) == false) goto L32;
    L23:
        if (r17 != 101) goto L25;
        r19 = r16.v();
        r110 = xe.c.f13882c;
        goto L26
    L5:
        if (r13.a() == null) goto L14;
        if ("100-continue".equalsIgnoreCase(r13.b("Expect")) == false) goto L9;
        r8.f();
        r12.c().responseHeadersStart(r12.a());
        r15 = r8.e(true);
    L9:
        if (r15 != null) goto L12;
        r12.c().requestBodyStart(r12.a());
        a r21 = new a(r8.d(r13, r13.a().contentLength()));
        q r22 = p.a(r21);
        r13.a().writeTo(r22);
        r22.close();
        r12.c().requestBodyEnd(r12.a(), r21.f357a);
        goto L14
    L12:
        if (r11.i() == true) goto L14;
        r10.f();
        goto L14
    }
}
