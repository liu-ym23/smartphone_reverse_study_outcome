package j1;

/* JADX INFO: loaded from: classes.dex */
public final class g extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f8479c = null;

    static {
        f8479c = new g();
    }

    public g() {
        super(1, 2);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("\n    CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id`\n    INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
        r8.e("\n    INSERT INTO SystemIdInfo(work_spec_id, system_id)\n    SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo\n    ");
        r8.e("DROP TABLE IF EXISTS alarmInfo");
        r8.e("\n                INSERT OR IGNORE INTO worktag(tag, work_spec_id)\n                SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec\n                ");
    }
}
