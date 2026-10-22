package u;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f13090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f13091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f13092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13093f;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f13096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f13097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f13098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f13099f;

        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }

        static /* synthetic */ String a(b r10) {
            return r10.f13094a;
        }

        static /* synthetic */ int b(b r10) {
            return r10.f13095b;
        }

        static /* synthetic */ JSONObject c(b r10) {
            return r10.f13096c;
        }

        static /* synthetic */ JSONObject d(b r10) {
            return r10.f13097d;
        }

        static /* synthetic */ JSONObject e(b r10) {
            return r10.f13098e;
        }

        static /* synthetic */ boolean f(b r10) {
            return r10.f13099f;
        }

        public d g() {
            return new d(this);
        }

        public b h(boolean r10) {
            this.f13099f = r10;
            return this;
        }

        public b i(JSONObject r10) {
            this.f13096c = r10;
            return this;
        }

        public b j(JSONObject r10) {
            this.f13098e = r10;
            return this;
        }

        public b k(JSONObject r10) {
            this.f13097d = r10;
            return this;
        }

        public b l(String r10) {
            this.f13094a = r10;
            return this;
        }

        public b m(int r10) {
            this.f13095b = r10;
            return this;
        }
    }

    public d(b r10) {
        this.f13088a = b.a(r10);
        this.f13089b = b.b(r10);
        this.f13090c = b.c(r10);
        this.f13091d = b.d(r10);
        this.f13092e = b.e(r10);
        this.f13093f = b.f(r10);
    }

    public static b a() {
        return new b(null);
    }

    public JSONObject b() {
        return this.f13090c;
    }

    public JSONObject c() {
        return this.f13092e;
    }

    public JSONObject d() {
        return this.f13091d;
    }

    public String e() {
        return this.f13088a;
    }

    public int f() {
        return this.f13089b;
    }

    public boolean g() {
        return this.f13093f;
    }
}
