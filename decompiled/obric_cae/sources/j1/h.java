package j1;

/* JADX INFO: loaded from: classes.dex */
public final class h extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f8482c = null;

    static {
        f8482c = new h();
    }

    public h() {
        super(3, 4);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
    }
}
