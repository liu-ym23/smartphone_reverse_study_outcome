package t4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f12954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f12955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f12956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12957f;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: t4.b$b, reason: collision with other inner class name */
    public static final class C0297b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f12960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f12961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f12962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f12963f;

        private C0297b() {
        }

        /* synthetic */ C0297b(a r10) {
            this();
        }

        static /* synthetic */ String a(C0297b r10) {
            return r10.f12958a;
        }

        static /* synthetic */ int b(C0297b r10) {
            return r10.f12959b;
        }

        static /* synthetic */ JSONObject c(C0297b r10) {
            return r10.f12960c;
        }

        static /* synthetic */ JSONObject d(C0297b r10) {
            return r10.f12961d;
        }

        static /* synthetic */ JSONObject e(C0297b r10) {
            return r10.f12962e;
        }

        static /* synthetic */ boolean f(C0297b r10) {
            return r10.f12963f;
        }

        public b g() {
            return new b(this);
        }

        public C0297b h(boolean r10) {
            this.f12963f = r10;
            return this;
        }

        public C0297b i(JSONObject r10) {
            this.f12960c = r10;
            return this;
        }

        public C0297b j(String r10) {
            this.f12958a = r10;
            return this;
        }
    }

    public b(C0297b r10) {
        this.f12952a = C0297b.a(r10);
        this.f12953b = C0297b.b(r10);
        this.f12954c = C0297b.c(r10);
        this.f12955d = C0297b.d(r10);
        this.f12956e = C0297b.e(r10);
        this.f12957f = C0297b.f(r10);
    }

    public static C0297b a() {
        return new C0297b(null);
    }

    public JSONObject b() {
        return this.f12954c;
    }

    public JSONObject c() {
        return this.f12956e;
    }

    public JSONObject d() {
        return this.f12955d;
    }

    public String e() {
        return this.f12952a;
    }

    public int f() {
        return this.f12953b;
    }

    public boolean g() {
        return this.f12957f;
    }
}
