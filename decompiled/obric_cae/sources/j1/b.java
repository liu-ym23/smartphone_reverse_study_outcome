package j1;

/* JADX INFO: loaded from: classes.dex */
public final class b extends androidx.room.r.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8447a = null;

    static {
        f8447a = new b();
    }

    @Override // androidx.room.r.b
    public final void a(a1.b r8) {
        he.i.f(r8, "db");
        r8.c();
        r8.e("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + (System.currentTimeMillis() - w.f8553a) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");     // Catch: Throwable -> L6
        r8.m();     // Catch: Throwable -> L6
        r8.t();
        return;
    L6:
        th = move-exception;
        r8.t();
        throw th;
    }
}
