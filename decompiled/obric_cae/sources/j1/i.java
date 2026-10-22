package j1;

/* JADX INFO: loaded from: classes.dex */
public final class i extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f8485c = null;

    static {
        f8485c = new i();
    }

    public i() {
        super(4, 5);
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        r8.e("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
        r8.e("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
    }
}
