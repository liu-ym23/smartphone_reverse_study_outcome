package j1;

/* JADX INFO: loaded from: classes.dex */
public final class j extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f8511c = null;

    static {
        f8511c = new j();
    }

    public j() {
        super(6, 7);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("\n    CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress`\n    BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
    }
}
