package j1;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends x0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8461c;

    public c0(Context r8) {
        super(9, 10);
        this.f8461c = r8;
    }

    @Override // x0.a
    public final void a(b1.c r13) {
        r13.e("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        Context r12 = this.f8461c;
        SharedPreferences r8 = r12.getSharedPreferences("androidx.work.util.preferences", 0);
        if (r8.contains("reschedule_needed") == false) goto L5;
    L6:
        long r10 = 0;
        long r11 = r8.getLong("last_cancel_all_time_ms", 0);
        if (r8.getBoolean("reschedule_needed", false) == false) goto L9;
        r10 = 1;
    L9:
        r13.c();
        r13.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(r11)});     // Catch: Throwable -> L23
        r13.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(r10)});     // Catch: Throwable -> L23
        r8.edit().clear().apply();     // Catch: Throwable -> L23
        r13.m();     // Catch: Throwable -> L23
        r13.t();
    L12:
        SharedPreferences r14 = r12.getSharedPreferences("androidx.work.util.id", 0);
        if (r14.contains("next_job_scheduler_id") == false) goto L15;
    L16:
        int r15 = r14.getInt("next_job_scheduler_id", 0);
        int r16 = r14.getInt("next_alarm_manager_id", 0);
        r13.c();
        r13.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(r15)});     // Catch: Throwable -> L20
        r13.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(r16)});     // Catch: Throwable -> L20
        r14.edit().clear().apply();     // Catch: Throwable -> L20
        r13.m();     // Catch: Throwable -> L20
        r13.t();
        return;
    L20:
        th = move-exception;
        r13.t();
        throw th;
    L15:
        if (r14.contains("next_job_scheduler_id") == true) goto L16;
        return;
    L23:
        th = move-exception;
        r13.t();
        throw th;
    L5:
        if (r8.contains("last_cancel_all_time_ms") == false) goto L12;
        goto L6
    }
}
