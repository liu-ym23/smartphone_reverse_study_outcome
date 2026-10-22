package c0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f581d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f588g;

        public a() {
            this.f582a = false;
            this.f583b = false;
            this.f584c = false;
            this.f585d = false;
            this.f586e = false;
            this.f587f = -1;
            this.f588g = 1000;
        }

        public c a() {
            return new c(this.f582a, this.f583b, this.f584c, this.f587f, this.f585d, this.f588g, this.f586e);
        }

        public a b() {
            this.f585d = true;
            return this;
        }

        public a c() {
            this.f582a = true;
            return this;
        }

        public a d(long r10) {
            this.f587f = r10;
            return this;
        }
    }

    public c(boolean r10, boolean r11, boolean r12, long r13, boolean r14, long r15, boolean r16) {
        this.f578a = r10;
        this.f579b = r11;
        this.f581d = r13;
        this.f580c = r14;
    }

    public long a() {
        return this.f581d;
    }

    public boolean b() {
        return this.f580c;
    }

    public boolean c() {
        return this.f579b;
    }

    public boolean d() {
        return this.f578a;
    }
}
