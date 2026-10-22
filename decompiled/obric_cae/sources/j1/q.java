package j1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class q extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8539c;

    public q(Context r8, int r10, int r11) {
        super(r10, r11);
        this.f8539c = r8;
    }

    @Override // x0.a
    public final void a(b1.c r8) {
        if (this.f13365b < 10) goto L5;
        r8.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
        return;
    L5:
        this.f8539c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
    }
}
