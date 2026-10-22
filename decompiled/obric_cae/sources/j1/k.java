package j1;

/* JADX INFO: loaded from: classes.dex */
public final class k extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f8512c = null;

    static {
        f8512c = new k();
    }

    public k() {
        super(7, 8);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("\n    CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec`(`period_start_time`)\n    ");
    }
}
