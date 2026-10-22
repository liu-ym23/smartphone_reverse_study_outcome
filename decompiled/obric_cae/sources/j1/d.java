package j1;

/* JADX INFO: loaded from: classes.dex */
public final class d extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f8462c = null;

    static {
        f8462c = new d();
    }

    public d() {
        super(11, 12);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
    }
}
