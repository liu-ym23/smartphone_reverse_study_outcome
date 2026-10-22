package af;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import jf.p;
import we.a0;
import we.k;
import we.l;
import we.q;
import we.r;
import we.s;
import we.t;
import we.y;
import we.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f355a;

    public a(l r8) {
        this.f355a = r8;
    }

    @Override // we.s
    public final a0 a(f r17) {
        y r8 = r17.f364f;
        r8.getClass();
        y.a r10 = new y.a(r8);
        z r11 = r8.f13341e;
        if (r11 == null) goto L11;
        t r12 = r11.contentType();
        if (r12 == null) goto L7;
        r10.b("Content-Type", r12.f13260a);
    L7:
        long r13 = r11.contentLength();
        if (r13 == (-1)) goto L10;
        r10.b("Content-Length", Long.toString(r13));
        r10.d("Transfer-Encoding");
        goto L11
    L10:
        r10.b("Transfer-Encoding", "chunked");
        r10.d("Content-Length");
    L11:
        String r14 = r8.b("Host");
        int r15 = 0;
        r r16 = r8.f13337a;
        if (r14 != null) goto L15;
        r10.b("Host", xe.c.o(r16, false));
    L15:
        if (r8.b("Connection") != null) goto L18;
        r10.b("Connection", "Keep-Alive");
    L18:
        if (r8.b("Accept-Encoding") == null) goto L20;
    L22:
        boolean r18 = false;
    L23:
        l r19 = this.f355a;
        ((l.a) r19).getClass();
        List r110 = Collections.emptyList();
        if (r110.isEmpty() == true) goto L32;
        StringBuilder r111 = new StringBuilder();
        int r112 = r110.size();
    L26:
        if (r15 >= r112) goto L30;
        if (r15 <= 0) goto L29;
        r111.append("; ");
    L29:
        k r113 = (k) r110.get(r15);
        r111.append(r113.f13216a);
        r111.append('=');
        r111.append(r113.f13217b);
        r15 = r15 + 1;
        goto L26
    L30:
        r10.b("Cookie", r111.toString());
    L32:
        if (r8.b("User-Agent") != null) goto L34;
        r10.b("User-Agent", "okhttp/3.12.13.19");
    L34:
        a0 r20 = r17.e(r10.a());
        e.d(r19, r16, r20.f13119p);
        a0.a r21 = new a0.a(r20);
        r21.f13126a = r8;
        if (r18 == false) goto L42;
        if ("gzip".equalsIgnoreCase(r20.n("Content-Encoding")) == false) goto L42;
        if (e.b(r20) == false) goto L42;
        jf.k r22 = new jf.k(r20.f13120q.k());
        q.a r23 = r20.f13119p.g();
        r23.c("Content-Encoding");
        r23.c("Content-Length");
        r21.f13131f = new q(r23).g();
        String r24 = r20.n("Content-Type");
        Logger r25 = p.f8861a;
        r21.f13132g = new g(r24, -1, new jf.r(r22));
    L42:
        return r21.b();
    L20:
        if (r8.b("Range") != null) goto L22;
        r10.b("Accept-Encoding", "gzip");
        r18 = true;
        goto L23
    }
}
