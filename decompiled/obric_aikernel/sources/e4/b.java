package e4;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import f4.g;
import f4.i;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.news.common.settings.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f4.b f8579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f8580c;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: e4.b$b, reason: collision with other inner class name */
    public static class C0161b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f8581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f8582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f4.b f8583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Executor f8584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f8585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f8586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private g f8587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private f4.e f8588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f8589i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f8590j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f8591k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f8592l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f8593m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private f4.a f8594n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private RequestV3Service f8595o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f8596p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private f4.f f8597q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f8598r;

        public C0161b() {
            this.f8585e = -1;
            this.f8586f = -1;
            this.f8589i = true;
            this.f8590j = true;
            this.f8594n = null;
        }

        public b a() {
            if (this.f8581a == null) goto L27;
            if (this.f8583c == null) goto L25;
            if (this.f8582b != null) goto L10;
            this.f8582b = new j4.c();
        L10:
            if (this.f8584d != null) goto L13;
            this.f8584d = Executors.newCachedThreadPool();
        L13:
            if (this.f8585e >= 0) goto L16;
            this.f8585e = 3600000;
        L16:
            if (this.f8586f >= 0) goto L18;
            this.f8586f = AnrManager.ANR_MIN_INTERVAL;
        L18:
            a r10 = null;
            c r11 = new c(r10);
            r11.f8600b = this.f8582b;
            r11.f8601c = this.f8584d;
            r11.f8602d = this.f8585e;
            r11.f8603e = this.f8586f;
            r11.f8604f = this.f8587g;
            r11.f8605g = this.f8588h;
            r11.f8606h = this.f8589i;
            r11.f8607i = this.f8590j;
            r11.f8608j = this.f8591k;
            f4.a r12 = this.f8594n;
            r11.f8611m = r12;
            r11.f8609k = this.f8592l;
            r11.f8610l = this.f8593m;
            r11.f8611m = r12;
            r11.f8613o = this.f8595o;
            r11.f8614p = this.f8596p;
            r11.f8615q = this.f8597q;
            r11.f8616r = this.f8598r;
            Context r13 = this.f8581a;
            if ((r13 instanceof Application) == false) goto L23;
            return new b(r13, this.f8583c, r11, r10);
        L23:
            return new b(r13.getApplicationContext(), this.f8583c, r11, r10);
        L25:
            throw new IllegalArgumentException("requestService不能为空");
        L27:
            throw new IllegalArgumentException("context不能为空");
        }

        public C0161b b(Context r10) {
            this.f8581a = r10;
            return this;
        }

        public C0161b c(boolean r10) {
            this.f8589i = r10;
            return this;
        }

        public C0161b d(boolean r10) {
            this.f8593m = r10;
            return this;
        }

        public C0161b e(f4.b r10) {
            this.f8583c = r10;
            return this;
        }

        public C0161b f(boolean r10) {
            this.f8590j = r10;
            return this;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f8600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f8601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f8604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f4.e f8605g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8606h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8607i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8608j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f8609k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f8610l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public f4.a f8611m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public i4.a f8612n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public RequestV3Service f8613o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f8614p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public f4.f f8615q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f8616r;

        private c() {
            this.f8606h = true;
            this.f8607i = true;
        }

        /* synthetic */ c(a r10) {
            this();
        }
    }

    private b(Context r10, f4.b r11, c r12) {
        this.f8578a = r10;
        this.f8579b = r11;
        this.f8580c = r12;
    }

    /* synthetic */ b(Context r10, f4.b r11, c r12, a r13) {
        this(r10, r11, r12);
    }

    @Override // com.bytedance.news.common.settings.internal.c
    @Nullable
    public f4.f a() {
        return this.f8580c.f8615q;
    }

    public Context b() {
        return this.f8578a;
    }

    @Nullable
    public f4.a c() {
        return this.f8580c.f8611m;
    }

    public Executor d() {
        return this.f8580c.f8601c;
    }

    public String e() {
        return this.f8580c.f8599a;
    }

    public int f() {
        return this.f8580c.f8609k;
    }

    @Nullable
    public i4.a g() {
        return this.f8580c.f8612n;
    }

    public f4.b h() {
        return this.f8579b;
    }

    @Nullable
    public RequestV3Service i() {
        return this.f8580c.f8613o;
    }

    public long j() {
        return this.f8580c.f8603e;
    }

    @Nullable
    public f4.e k() {
        return this.f8580c.f8605g;
    }

    @Nullable
    public SharedPreferences l(Context r10, String r11, int r12, boolean r13) {
        g r14 = this.f8580c.f8604f;
        if (r14 != null) goto L7;
        return null;
    L7:
        return r14.a(r10, r11, r12, r13);
    }

    public i m() {
        return this.f8580c.f8600b;
    }

    public long n() {
        return this.f8580c.f8602d;
    }

    public boolean o() {
        return this.f8580c.f8614p;
    }

    public boolean p() {
        return this.f8580c.f8606h;
    }

    public boolean q() {
        return this.f8580c.f8616r;
    }

    public boolean r() {
        return this.f8580c.f8610l;
    }

    void s(String r10) {
        this.f8580c.f8599a = r10;
    }

    public boolean t() {
        return this.f8580c.f8608j;
    }

    public boolean u() {
        return this.f8580c.f8607i;
    }
}
