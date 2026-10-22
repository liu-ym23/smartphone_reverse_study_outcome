package j1;

/* JADX INFO: loaded from: classes.dex */
public final class l extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f8513c = null;

    static {
        f8513c = new l();
    }

    public l() {
        super(8, 9);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
    }
}
