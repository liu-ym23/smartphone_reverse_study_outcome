package d2;

/* JADX INFO: loaded from: classes.dex */
public class a implements d2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d2.b f8443a;

    /* JADX INFO: renamed from: d2.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0156a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f8444a = null;

        static {
            f8444a = new a(null);
        }

        static /* synthetic */ a a() {
            return f8444a;
        }
    }

    private a() {
    }

    /* synthetic */ a(C0156a r10) {
        this();
    }

    public static a c() {
        return b.a();
    }

    @Override // d2.b
    public void a() {
        d2.b r10 = this.f8443a;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // d2.b
    public void b(Throwable r10) {
        d2.b r11 = this.f8443a;
        if (r11 == null) goto L6;
        r11.b(r10);
        return;
    }
}
