package mc;

import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kc.i;
import kc.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.r;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.d0;
import okio.f0;
import okio.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements kc.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f11108g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f11109h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<String> f11110i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealConnection f11111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kc.g f11112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.internal.http2.b f11113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f11114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Protocol f11115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f11116f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final List<mc.a> a(x r10) {
            Intrinsics.checkNotNullParameter(r10, "request");
            r r11 = r10.e();
            ArrayList r12 = new ArrayList(r11.size() + 4);
            r12.add(new mc.a(mc.a.f11096f, r10.g()));
            r12.add(new mc.a(mc.a.f11097g, i.f10179a.c(r10.l())));
            String r13 = r10.d("Host");
            if (r13 == null) goto L5;
            r12.add(new mc.a(mc.a.f11099i, r13));
        L5:
            r12.add(new mc.a(mc.a.f11098h, r10.l().s()));
            int r14 = 0;
            int r15 = r11.size();
        L6:
            if (r14 >= r15) goto L15;
            String r16 = r11.c(r14);
            Locale r17 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r17, "US");
            String r18 = r16.toLowerCase(r17);
            Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String).toLowerCase(locale)");
            if (c.i().contains(r18) == true) goto L10;
        L13:
            r12.add(new mc.a(r18, r11.i(r14)));
        L14:
            r14 = r14 + 1;
            goto L6
        L10:
            if (Intrinsics.areEqual(r18, "te") == false) goto L14;
            if (Intrinsics.areEqual(r11.i(r14), "trailers") == false) goto L14;
        L15:
            return r12;
        }

        public final z.a b(r r10, Protocol r11) {
            Intrinsics.checkNotNullParameter(r10, "headerBlock");
            Intrinsics.checkNotNullParameter(r11, "protocol");
            r.a r12 = new r.a();
            int r13 = r10.size();
            k r14 = null;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L11;
            String r16 = r10.c(r15);
            String r17 = r10.i(r15);
            if (Intrinsics.areEqual(r16, ":status") == false) goto L8;
            r14 = k.f10188d.a("HTTP/1.1 " + r17);
        L10:
            r15 = r15 + 1;
            goto L3
        L8:
            if (c.j().contains(r16) == true) goto L10;
            r12.c(r16, r17);
            goto L10
        L11:
            if (r14 == null) goto L15;
            return new z.a().p(r11).g(r14.f10190b).m(r14.f10191c).k(r12.e());
        L15:
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    static {
        f11108g = new a(null);
        f11109h = hc.e.w(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
        f11110i = hc.e.w(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    }

    public c(w r10, RealConnection r11, kc.g r12, okhttp3.internal.http2.b r13) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
        Intrinsics.checkNotNullParameter(r12, "chain");
        Intrinsics.checkNotNullParameter(r13, "http2Connection");
        this.f11111a = r11;
        this.f11112b = r12;
        this.f11113c = r13;
        List<Protocol> r14 = r10.C();
        Protocol r15 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r14.contains(r15) == true) goto L6;
        r15 = Protocol.HTTP_2;
    L6:
        this.f11115e = r15;
    }

    public static final /* synthetic */ List i() {
        return f11109h;
    }

    public static final /* synthetic */ List j() {
        return f11110i;
    }

    @Override // kc.d
    public void a() {
        d r10 = this.f11114d;
        Intrinsics.checkNotNull(r10);
        r10.n().close();
    }

    @Override // kc.d
    public void b(x r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        if (this.f11114d == null) goto L6;
        return;
    L6:
        if (r10.a() == null) goto L8;
        boolean r11 = true;
    L9:
        this.f11114d = this.f11113c.h0(f11108g.a(r10), r11);
        if (this.f11116f == true) goto L13;
        d r12 = this.f11114d;
        Intrinsics.checkNotNull(r12);
        g0 r13 = r12.v();
        long r14 = this.f11112b.i();
        TimeUnit r15 = TimeUnit.MILLISECONDS;
        r13.g(r14, r15);
        d r16 = this.f11114d;
        Intrinsics.checkNotNull(r16);
        r16.E().g(this.f11112b.k(), r15);
        return;
    L13:
        d r17 = this.f11114d;
        Intrinsics.checkNotNull(r17);
        r17.f(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    L8:
        r11 = false;
        goto L9
    }

    @Override // kc.d
    public f0 c(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        d r11 = this.f11114d;
        Intrinsics.checkNotNull(r11);
        return r11.p();
    }

    @Override // kc.d
    public void cancel() {
        this.f11116f = true;
        d r10 = this.f11114d;
        if (r10 == null) goto L6;
        r10.f(ErrorCode.CANCEL);
        return;
    }

    @Override // kc.d
    public z.a d(boolean r10) {
        d r11 = this.f11114d;
        if (r11 == null) goto L11;
        r r12 = r11.C();
        z.a r13 = f11108g.b(r12, this.f11115e);
        if (r10 == true) goto L7;
        return r13;
    L7:
        if (r13.h() != 100) goto L13;
        return null;
    L13:
        return r13;
    L11:
        throw new IOException("stream wasn't created");
    }

    @Override // kc.d
    public RealConnection e() {
        return this.f11111a;
    }

    @Override // kc.d
    public void f() {
        this.f11113c.flush();
    }

    @Override // kc.d
    public long g(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (kc.e.b(r10) == true) goto L6;
        return 0;
    L6:
        return hc.e.v(r10);
    }

    @Override // kc.d
    public d0 h(x r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        d r12 = this.f11114d;
        Intrinsics.checkNotNull(r12);
        return r12.n();
    }
}
