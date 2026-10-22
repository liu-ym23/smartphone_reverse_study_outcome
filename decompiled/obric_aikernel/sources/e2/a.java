package e2;

/* JADX INFO: loaded from: classes.dex */
public class a implements c2.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8556b;

    /* JADX INFO: renamed from: e2.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0159a {
    }

    private static class b extends a {
        private b() {
            super(-1, 5000);
        }

        /* synthetic */ b(C0159a r10) {
            this();
        }
    }

    public a() {
    }

    public a(long r10, long r11) {
        this.f8555a = r10;
        this.f8556b = r11;
    }

    public long a() {
        return this.f8555a;
    }

    public long b() {
        return this.f8556b;
    }

    public a c() {
        return new b(null);
    }
}
