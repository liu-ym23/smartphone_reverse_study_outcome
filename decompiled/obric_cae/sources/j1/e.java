package j1;

/* JADX INFO: loaded from: classes.dex */
public final class e extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f8469c = null;

    static {
        f8469c = new e();
    }

    public e() {
        super(12, 13);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        r8.e("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
