package okhttp3.internal.http2;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import hc.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio.f;
import okio.f0;
import okio.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final mc.a[] f11843b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<ByteString, Integer> f11844c = null;

    /* JADX INFO: renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    public static final class C0261a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<mc.a> f11847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final f f11848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @JvmField
        public mc.a[] f11849e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11850f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public int f11851g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @JvmField
        public int f11852h;

        @JvmOverloads
        public C0261a(f0 r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "source");
            this.f11845a = r11;
            this.f11846b = r12;
            this.f11847c = new ArrayList();
            this.f11848d = t.b(r10);
            mc.a[] r13 = new mc.a[8];
            this.f11849e = r13;
            this.f11850f = r13.length - 1;
        }

        public /* synthetic */ C0261a(f0 r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            r12 = r11;
        L5:
            this(r10, r11, r12);
        }

        private final void a() {
            int r10 = this.f11846b;
            int r11 = this.f11852h;
            if (r10 >= r11) goto L8;
            if (r10 != 0) goto L6;
            b();
            return;
        L6:
            d(r11 - r10);
            return;
        }

        private final void b() {
            ArraysKt.fill$default(this.f11849e, null, 0, 0, 6, null);
            this.f11850f = this.f11849e.length - 1;
            this.f11851g = 0;
            this.f11852h = 0;
        }

        private final int c(int r10) {
            return (this.f11850f + 1) + r10;
        }

        private final int d(int r10) {
            int r11 = 0;
            if (r10 <= 0) goto L10;
            int r12 = this.f11849e.length;
        L5:
            r12 = r12 - 1;
            int r13 = this.f11850f;
            if (r12 < r13) goto L9;
            if (r10 <= 0) goto L9;
            mc.a r14 = this.f11849e[r12];
            Intrinsics.checkNotNull(r14);
            int r15 = r14.f11102c;
            r10 = r10 - r15;
            this.f11852h -= r15;
            this.f11851g--;
            r11 = r11 + 1;
        L9:
            mc.a[] r16 = this.f11849e;
            System.arraycopy(r16, r13 + 1, r16, (r13 + 1) + r11, this.f11851g);
            this.f11850f += r11;
        L10:
            return r11;
        }

        private final ByteString f(int r10) {
            if (h(r10) == false) goto L6;
            mc.a r11 = a.f11842a.c()[r10];
        L11:
            return r11.f11100a;
        L6:
            int r12 = c(r10 - a.f11842a.c().length);
            if (r12 < 0) goto L13;
            mc.a[] r13 = this.f11849e;
            if (r12 >= r13.length) goto L13;
            r11 = r13[r12];
            Intrinsics.checkNotNull(r11);
        L13:
            throw new IOException("Header index too large " + (r10 + 1));
        }

        private final void g(int r10, mc.a r11) {
            this.f11847c.add(r11);
            int r12 = r11.f11102c;
            if (r10 == (-1)) goto L5;
            mc.a r13 = this.f11849e[c(r10)];
            Intrinsics.checkNotNull(r13);
            r12 = r12 - r13.f11102c;
        L5:
            int r14 = this.f11846b;
            if (r12 <= r14) goto L9;
            b();
            return;
        L9:
            int r15 = d((this.f11852h + r12) - r14);
            if (r10 != (-1)) goto L15;
            int r16 = this.f11851g + 1;
            mc.a[] r17 = this.f11849e;
            if (r16 <= r17.length) goto L14;
            mc.a[] r18 = new mc.a[r17.length * 2];
            System.arraycopy(r17, 0, r18, r17.length, r17.length);
            this.f11850f = this.f11849e.length - 1;
            this.f11849e = r18;
        L14:
            int r19 = this.f11850f;
            this.f11850f = r19 - 1;
            this.f11849e[r19] = r11;
            this.f11851g++;
        L16:
            this.f11852h += r12;
            return;
        L15:
            this.f11849e[r10 + (c(r10) + r15)] = r11;
            goto L16
        }

        private final boolean h(int r10) {
            if (r10 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r10 > (a.f11842a.c().length - 1)) goto L7;
            return true;
        }

        private final int i() {
            return e.d(this.f11848d.readByte(), 255);
        }

        private final void l(int r10) {
            if (h(r10) == false) goto L5;
            this.f11847c.add(a.f11842a.c()[r10]);
            return;
        L5:
            int r11 = c(r10 - a.f11842a.c().length);
            if (r11 < 0) goto L12;
            mc.a[] r12 = this.f11849e;
            if (r11 >= r12.length) goto L12;
            List<mc.a> r13 = this.f11847c;
            mc.a r14 = r12[r11];
            Intrinsics.checkNotNull(r14);
            r13.add(r14);
            return;
        L12:
            throw new IOException("Header index too large " + (r10 + 1));
        }

        private final void n(int r10) {
            g(-1, new mc.a(f(r10), j()));
        }

        private final void o() {
            g(-1, new mc.a(a.f11842a.a(j()), j()));
        }

        private final void p(int r10) {
            ByteString r11 = f(r10);
            ByteString r12 = j();
            this.f11847c.add(new mc.a(r11, r12));
        }

        private final void q() {
            ByteString r10 = a.f11842a.a(j());
            ByteString r11 = j();
            this.f11847c.add(new mc.a(r10, r11));
        }

        public final List<mc.a> e() {
            List<mc.a> r10 = CollectionsKt.toList(this.f11847c);
            this.f11847c.clear();
            return r10;
        }

        public final ByteString j() {
            int r10 = i();
            if ((r10 & 128) != 128) goto L5;
            boolean r11 = true;
        L6:
            long r12 = m(r10, 127);
            if (r11 == false) goto L10;
            okio.d r13 = new okio.d();
            mc.e.f11143a.b(this.f11848d, r12, r13);
            return r13.D();
        L10:
            return this.f11848d.g(r12);
        L5:
            r11 = false;
            goto L6
        }

        public final void k() {
        L3:
            if (this.f11848d.n() == true) goto L32;
            int r10 = e.d(this.f11848d.readByte(), 255);
            if (r10 == 128) goto L31;
            if ((r10 & 128) == 128) goto L8;
            if (r10 == 64) goto L11;
            if ((r10 & 64) == 64) goto L14;
            if ((r10 & 32) == 32) goto L17;
            if (r10 == 16) goto L29;
            if (r10 == 0) goto L29;
            p(m(r10, 15) - 1);
        L29:
            q();
            goto L3
        L17:
            int r11 = m(r10, 31);
            this.f11846b = r11;
            if (r11 < 0) goto L23;
            if (r11 > this.f11845a) goto L23;
            a();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.f11846b);
        L14:
            n(m(r10, 63) - 1);
            goto L3
        L11:
            o();
            goto L3
        L8:
            l(m(r10, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        public final int m(int r10, int r11) {
            int r12 = r10 & r11;
            if (r12 >= r11) goto L5;
            return r12;
        L5:
            int r13 = 0;
        L6:
            int r14 = i();
            if ((r14 & 128) == 0) goto L10;
            r11 = r11 + ((r14 & 127) << r13);
            r13 = r13 + 7;
            goto L6
        L10:
            return r11 + (r14 << r13);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public int f11853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okio.d f11855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @JvmField
        public int f11858f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public mc.a[] f11859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f11860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @JvmField
        public int f11861i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @JvmField
        public int f11862j;

        @JvmOverloads
        public b(int r10, boolean r11, okio.d r12) {
            Intrinsics.checkNotNullParameter(r12, "out");
            this.f11853a = r10;
            this.f11854b = r11;
            this.f11855c = r12;
            this.f11856d = Integer.MAX_VALUE;
            this.f11858f = r10;
            mc.a[] r13 = new mc.a[8];
            this.f11859g = r13;
            this.f11860h = r13.length - 1;
        }

        public /* synthetic */ b(int r10, boolean r11, okio.d r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = 4096;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r11 = true;
        L8:
            this(r10, r11, r12);
        }

        private final void a() {
            int r10 = this.f11858f;
            int r11 = this.f11862j;
            if (r10 >= r11) goto L8;
            if (r10 != 0) goto L6;
            b();
            return;
        L6:
            c(r11 - r10);
            return;
        }

        private final void b() {
            ArraysKt.fill$default(this.f11859g, null, 0, 0, 6, null);
            this.f11860h = this.f11859g.length - 1;
            this.f11861i = 0;
            this.f11862j = 0;
        }

        private final int c(int r10) {
            int r11 = 0;
            if (r10 <= 0) goto L10;
            int r12 = this.f11859g.length;
        L5:
            r12 = r12 - 1;
            int r13 = this.f11860h;
            if (r12 < r13) goto L9;
            if (r10 <= 0) goto L9;
            mc.a r14 = this.f11859g[r12];
            Intrinsics.checkNotNull(r14);
            r10 = r10 - r14.f11102c;
            int r15 = this.f11862j;
            mc.a r16 = this.f11859g[r12];
            Intrinsics.checkNotNull(r16);
            this.f11862j = r15 - r16.f11102c;
            this.f11861i--;
            r11 = r11 + 1;
        L9:
            mc.a[] r17 = this.f11859g;
            System.arraycopy(r17, r13 + 1, r17, (r13 + 1) + r11, this.f11861i);
            mc.a[] r18 = this.f11859g;
            int r19 = this.f11860h;
            Arrays.fill(r18, r19 + 1, (r19 + 1) + r11, null);
            this.f11860h += r11;
        L10:
            return r11;
        }

        private final void d(mc.a r10) {
            int r11 = r10.f11102c;
            int r12 = this.f11858f;
            if (r11 <= r12) goto L6;
            b();
            return;
        L6:
            c((this.f11862j + r11) - r12);
            int r13 = this.f11861i + 1;
            mc.a[] r14 = this.f11859g;
            if (r13 <= r14.length) goto L9;
            mc.a[] r15 = new mc.a[r14.length * 2];
            System.arraycopy(r14, 0, r15, r14.length, r14.length);
            this.f11860h = this.f11859g.length - 1;
            this.f11859g = r15;
        L9:
            int r16 = this.f11860h;
            this.f11860h = r16 - 1;
            this.f11859g[r16] = r10;
            this.f11861i++;
            this.f11862j += r11;
        }

        public final void e(int r10) {
            this.f11853a = r10;
            int r11 = Math.min(r10, 16384);
            int r12 = this.f11858f;
            if (r12 != r11) goto L5;
            return;
        L5:
            if (r11 >= r12) goto L7;
            this.f11856d = Math.min(this.f11856d, r11);
        L7:
            this.f11857e = true;
            this.f11858f = r11;
            a();
        }

        public final void f(ByteString r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            if (this.f11854b == false) goto L7;
            mc.e r11 = mc.e.f11143a;
            if (r11.d(r10) >= r10.size()) goto L7;
            okio.d r12 = new okio.d();
            r11.c(r10, r12);
            r10 = r12.D();
            int r13 = r10.size();
            int r14 = 128;
        L8:
            h(r13, 127, r14);
            this.f11855c.V(r10);
            return;
        L7:
            r13 = r10.size();
            r14 = 0;
            goto L8
        }

        public final void g(List<mc.a> r14) {
            Intrinsics.checkNotNullParameter(r14, "headerBlock");
            if (this.f11857e == false) goto L8;
            int r10 = this.f11856d;
            if (r10 >= this.f11858f) goto L7;
            h(r10, 31, 32);
        L7:
            this.f11857e = false;
            this.f11856d = Integer.MAX_VALUE;
            h(this.f11858f, 31, 32);
        L8:
            int r11 = r14.size();
            int r12 = 0;
        L9:
            if (r12 >= r11) goto L51;
            mc.a r13 = r14.get(r12);
            ByteString r15 = r13.f11100a.toAsciiLowercase();
            ByteString r16 = r13.f11101b;
            a r17 = a.f11842a;
            Integer r18 = r17.b().get(r15);
            if (r18 == null) goto L26;
            int r19 = r18.intValue() + 1;
            if (2 <= r19) goto L15;
        L17:
            boolean r110 = false;
        L18:
            if (r110 == true) goto L20;
        L25:
            int r20 = r19;
            r19 = -1;
        L27:
            if (r19 != (-1)) goto L38;
            int r111 = this.f11860h + 1;
            int r21 = this.f11859g.length;
        L29:
            if (r111 >= r21) goto L38;
            mc.a r112 = this.f11859g[r111];
            Intrinsics.checkNotNull(r112);
            if (Intrinsics.areEqual(r112.f11100a, r15) == false) goto L37;
            mc.a r113 = this.f11859g[r111];
            Intrinsics.checkNotNull(r113);
            if (Intrinsics.areEqual(r113.f11101b, r16) == true) goto L34;
            if (r20 != (-1)) goto L37;
            r20 = (r111 - this.f11860h) + a.f11842a.c().length;
            goto L37
        L34:
            r19 = a.f11842a.c().length + (r111 - this.f11860h);
        L37:
            r111 = r111 + 1;
        L38:
            if (r19 == (-1)) goto L41;
            h(r19, 127, 128);
        L50:
            r12 = r12 + 1;
            goto L9
        L41:
            if (r20 != (-1)) goto L45;
            this.f11855c.c0(64);
            f(r15);
        L43:
            f(r16);
            d(r13);
            goto L50
        L45:
            if (r15.startsWith(mc.a.f11094d) == true) goto L47;
        L49:
            h(r20, 63, 64);
            goto L43
        L47:
            if (Intrinsics.areEqual(mc.a.f11099i, r15) == true) goto L49;
            h(r20, 15, 0);
            f(r16);
            goto L50
        L20:
            if (Intrinsics.areEqual(r17.c()[r19 - 1].f11101b, r16) == false) goto L23;
            r20 = r19;
            goto L27
        L23:
            if (Intrinsics.areEqual(r17.c()[r19].f11101b, r16) == false) goto L25;
            r19 = r19 + 1;
            r20 = r19;
            goto L27
        L15:
            if (r19 >= 8) goto L17;
            r110 = true;
            goto L18
        L26:
            r20 = -1;
            r19 = -1;
            goto L27
        }

        public final void h(int r10, int r11, int r12) {
            if (r10 >= r11) goto L6;
            okio.d r13 = this.f11855c;
            int r14 = r10 | r12;
        L4:
            r13.c0(r14);
            return;
        L6:
            this.f11855c.c0(r12 | r11);
            r14 = r10 - r11;
        L8:
            if (r14 < 128) goto L10;
            this.f11855c.c0(128 | (r14 & 127));
            r14 = r14 >>> 7;
            goto L8
        L10:
            r13 = this.f11855c;
            goto L4
        }
    }

    static {
        a r10 = new a();
        f11842a = r10;
        ByteString r11 = mc.a.f11096f;
        ByteString r12 = mc.a.f11097g;
        ByteString r13 = mc.a.f11098h;
        ByteString r14 = mc.a.f11095e;
        f11843b = new mc.a[]{new mc.a(mc.a.f11099i, ""), new mc.a(r11, "GET"), new mc.a(r11, CloudConfig.REQUEST_TYPE_POST), new mc.a(r12, "/"), new mc.a(r12, "/index.html"), new mc.a(r13, "http"), new mc.a(r13, "https"), new mc.a(r14, "200"), new mc.a(r14, "204"), new mc.a(r14, "206"), new mc.a(r14, "304"), new mc.a(r14, "400"), new mc.a(r14, "404"), new mc.a(r14, "500"), new mc.a("accept-charset", ""), new mc.a("accept-encoding", "gzip, deflate"), new mc.a("accept-language", ""), new mc.a("accept-ranges", ""), new mc.a("accept", ""), new mc.a("access-control-allow-origin", ""), new mc.a("age", ""), new mc.a("allow", ""), new mc.a("authorization", ""), new mc.a("cache-control", ""), new mc.a("content-disposition", ""), new mc.a("content-encoding", ""), new mc.a("content-language", ""), new mc.a("content-length", ""), new mc.a("content-location", ""), new mc.a("content-range", ""), new mc.a("content-type", ""), new mc.a("cookie", ""), new mc.a("date", ""), new mc.a(URLDispatch.KEY_ETAG, ""), new mc.a("expect", ""), new mc.a("expires", ""), new mc.a("from", ""), new mc.a("host", ""), new mc.a("if-match", ""), new mc.a("if-modified-since", ""), new mc.a("if-none-match", ""), new mc.a("if-range", ""), new mc.a("if-unmodified-since", ""), new mc.a("last-modified", ""), new mc.a("link", ""), new mc.a("location", ""), new mc.a("max-forwards", ""), new mc.a("proxy-authenticate", ""), new mc.a("proxy-authorization", ""), new mc.a("range", ""), new mc.a("referer", ""), new mc.a("refresh", ""), new mc.a("retry-after", ""), new mc.a("server", ""), new mc.a("set-cookie", ""), new mc.a("strict-transport-security", ""), new mc.a("transfer-encoding", ""), new mc.a("user-agent", ""), new mc.a("vary", ""), new mc.a("via", ""), new mc.a("www-authenticate", "")};
        f11844c = r10.d();
    }

    private a() {
    }

    private final Map<ByteString, Integer> d() {
        mc.a[] r10 = f11843b;
        LinkedHashMap r11 = new LinkedHashMap(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        mc.a[] r14 = f11843b;
        if (r11.containsKey(r14[r13].f11100a) == true) goto L7;
        Integer r15 = Integer.valueOf(r13);
        r11.put(r14[r13].f11100a, r15);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        Map<ByteString, Integer> r16 = Collections.unmodifiableMap(r11);
        Intrinsics.checkNotNullExpressionValue(r16, "unmodifiableMap(result)");
        return r16;
    }

    public final ByteString a(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        byte r13 = r10.getByte(r12);
        if (65 <= r13) goto L7;
    L9:
        boolean r14 = false;
    L10:
        if (r14 == true) goto L13;
        r12 = r12 + 1;
        goto L3
    L13:
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r10.utf8());
    L7:
        if (r13 >= 91) goto L9;
        r14 = true;
        goto L10
    L14:
        return r10;
    }

    public final Map<ByteString, Integer> b() {
        return f11844c;
    }

    public final mc.a[] c() {
        return f11843b;
    }
}
