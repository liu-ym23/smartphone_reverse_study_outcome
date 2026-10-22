package okhttp3.internal.cache;

import hc.e;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.d;
import okhttp3.r;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11734c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f11735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f11736b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(z r10, x r11) {
            Intrinsics.checkNotNullParameter(r10, "response");
            Intrinsics.checkNotNullParameter(r11, "request");
            int r12 = r10.k();
            if (r12 == 200) goto L34;
            if (r12 == 410) goto L34;
            if (r12 == 414) goto L34;
            if (r12 == 501) goto L34;
            if (r12 == 203) goto L34;
            if (r12 == 204) goto L34;
            if (r12 == 307) goto L25;
            if (r12 == 308) goto L34;
            if (r12 == 404) goto L34;
            if (r12 == 405) goto L34;
            switch(r12) {
                case 300: goto L34;
                case 301: goto L34;
                case 302: goto L25;
                default: goto L23;
            };
        L23:
            return false;
        L25:
            if (z.s(r10, "Expires", null, 2, null) != null) goto L34;
            if (r10.c().c() != (-1)) goto L34;
            if (r10.c().b() == true) goto L34;
            if (r10.c().a() == true) goto L34;
            return false;
        L34:
            if (r10.c().h() == false) goto L36;
            return false;
        L36:
            if (r11.b().h() == true) goto L40;
            return true;
        L40:
            return false;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.b$b, reason: collision with other inner class name */
    public static final class C0260b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f11737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f11738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final z f11739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f11740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f11742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f11744h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f11745i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f11746j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f11747k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f11748l;

        public C0260b(long r10, x r11, z r12) {
            Intrinsics.checkNotNullParameter(r11, "request");
            this.f11737a = r10;
            this.f11738b = r11;
            this.f11739c = r12;
            this.f11748l = -1;
            if (r12 == null) goto L22;
            this.f11745i = r12.M();
            this.f11746j = r12.J();
            r r13 = r12.v();
            int r14 = 0;
            int r15 = r13.size();
        L5:
            if (r14 >= r15) goto L30;
            String r16 = r13.c(r14);
            String r17 = r13.i(r14);
            if (StringsKt.equals(r16, "Date", true) == false) goto L10;
            this.f11740d = kc.c.a(r17);
            this.f11741e = r17;
        L21:
            r14 = r14 + 1;
            goto L5
        L10:
            if (StringsKt.equals(r16, "Expires", true) == false) goto L13;
            this.f11744h = kc.c.a(r17);
            goto L21
        L13:
            if (StringsKt.equals(r16, "Last-Modified", true) == false) goto L16;
            this.f11742f = kc.c.a(r17);
            this.f11743g = r17;
            goto L21
        L16:
            if (StringsKt.equals(r16, "ETag", true) == false) goto L19;
            this.f11747k = r17;
            goto L21
        L19:
            if (StringsKt.equals(r16, "Age", true) == false) goto L21;
            this.f11748l = e.W(r17, -1);
            goto L21
        L30:
            return;
        }

        private final long a() {
            Date r10 = this.f11740d;
            long r11 = 0;
            if (r10 == null) goto L5;
            r11 = Math.max(0, this.f11746j - r10.getTime());
        L5:
            int r12 = this.f11748l;
            if (r12 == (-1)) goto L8;
            r11 = Math.max(r11, TimeUnit.SECONDS.toMillis(r12));
        L8:
            long r13 = this.f11746j;
            return (r11 + (r13 - this.f11745i)) + (this.f11737a - r13);
        }

        private final b c() {
            if (this.f11739c != null) goto L7;
            return new b(this.f11738b, null);
        L7:
            if (this.f11738b.f() == false) goto L13;
            if (this.f11739c.o() != null) goto L13;
            return new b(this.f11738b, null);
        L13:
            if (b.f11734c.a(this.f11739c, this.f11738b) == false) goto L15;
            d r10 = this.f11738b.b();
            if (r10.g() == true) goto L61;
            if (e(this.f11738b) == true) goto L61;
            d r11 = this.f11739c.c();
            long r12 = a();
            long r13 = d();
            if (r10.c() == (-1)) goto L24;
            r13 = Math.min(r13, TimeUnit.SECONDS.toMillis(r10.c()));
        L24:
            long r14 = 0;
            if (r10.e() == (-1)) goto L27;
            long r15 = TimeUnit.SECONDS.toMillis(r10.e());
        L29:
            if (r11.f() == true) goto L34;
            if (r10.d() == (-1)) goto L34;
            r14 = TimeUnit.SECONDS.toMillis(r10.d());
        L34:
            if (r11.g() == true) goto L47;
            long r16 = r15 + r12;
            if (r16 >= (r14 + r13)) goto L47;
            z.a r17 = this.f11739c.F();
            if (r16 < r13) goto L41;
            r17.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r12 <= 86400000) goto L46;
            if (f() == false) goto L46;
            r17.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new b(null, r17.c());
        L47:
            String r18 = this.f11747k;
            String r19 = "If-Modified-Since";
            if (r18 == null) goto L51;
            r19 = "If-None-Match";
        L56:
            r.a r20 = this.f11738b.e().e();
            Intrinsics.checkNotNull(r18);
            r20.c(r19, r18);
            return new b(this.f11738b.h().e(r20.e()).b(), this.f11739c);
        L51:
            if (this.f11742f == null) goto L54;
            r18 = this.f11743g;
            goto L56
        L54:
            if (this.f11740d == null) goto L59;
            r18 = this.f11741e;
            goto L56
        L59:
            return new b(this.f11738b, null);
        L27:
            r15 = 0;
        L61:
            return new b(this.f11738b, null);
        L15:
            return new b(this.f11738b, null);
        }

        private final long d() {
            z r10 = this.f11739c;
            Intrinsics.checkNotNull(r10);
            d r11 = r10.c();
            if (r11.c() != (-1)) goto L5;
            Date r12 = this.f11744h;
            if (r12 == null) goto L17;
            Date r13 = this.f11740d;
            if (r13 == null) goto L11;
            long r14 = r13.getTime();
        L12:
            long r15 = r12.getTime() - r14;
            if (r15 > 0) goto L15;
            return 0;
        L15:
            return r15;
        L11:
            r14 = this.f11746j;
            goto L12
        L17:
            if (this.f11742f != null) goto L19;
            return 0;
        L19:
            if (this.f11739c.K().l().o() != null) goto L30;
            Date r16 = this.f11740d;
            if (r16 == null) goto L23;
            long r17 = r16.getTime();
        L24:
            Date r18 = this.f11742f;
            Intrinsics.checkNotNull(r18);
            long r19 = r17 - r18.getTime();
            if (r19 > 0) goto L27;
            return 0;
        L27:
            return r19 / ((long) 10);
        L23:
            r17 = this.f11745i;
            goto L24
        L30:
            return 0;
        L5:
            return TimeUnit.SECONDS.toMillis(r11.c());
        }

        private final boolean e(x r10) {
            if (r10.d("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r10.d("If-None-Match") != null) goto L8;
            return false;
        }

        private final boolean f() {
            z r10 = this.f11739c;
            Intrinsics.checkNotNull(r10);
            if (r10.c().c() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.f11744h != null) goto L7;
            return true;
        }

        public final b b() {
            b r10 = c();
            if (r10.b() != null) goto L5;
        L8:
            return r10;
        L5:
            if (this.f11738b.b().i() == false) goto L8;
            return new b(null, null);
        }
    }

    static {
        f11734c = new a(null);
    }

    public b(x r10, z r11) {
        this.f11735a = r10;
        this.f11736b = r11;
    }

    public final z a() {
        return this.f11736b;
    }

    public final x b() {
        return this.f11735a;
    }
}
