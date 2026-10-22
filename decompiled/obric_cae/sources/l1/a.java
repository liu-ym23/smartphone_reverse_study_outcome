package l1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.s;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.m;
import r1.i;
import r1.j;
import r1.l;
import s1.g;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9126a = null;

    /* JADX INFO: renamed from: l1.a$a, reason: collision with other inner class name */
    public static class C0110a {
        public static void a(AlarmManager r8, int r10, long r11, PendingIntent r12) {
            r8.setExact(r10, r11, r12);
        }
    }

    static {
        f9126a = m.f("Alarms");
    }

    public static void a(Context r8, l r10, int r11) {
        AlarmManager r12 = (AlarmManager) r8.getSystemService("alarm");
        String r13 = androidx.work.impl.background.systemalarm.a.f2852o;
        Intent r14 = new Intent(r8, SystemAlarmService.class);
        r14.setAction("ACTION_DELAY_MET");
        androidx.work.impl.background.systemalarm.a.c(r14, r10);
        PendingIntent r15 = PendingIntent.getService(r8, r11, r14, 603979776);
        if (r15 == null) goto L7;
        if (r12 == null) goto L8;
        m.d().a(f9126a, "Cancelling existing alarm with (workSpecId, systemId) (" + r10 + ", " + r11 + ")");
        r12.cancel(r15);
        return;
    L8:
        return;
    }

    public static void b(Context r8, WorkDatabase r10, l r11, long r12) {
        j r13 = r10.c();
        i r14 = r13.b(r11);
        if (r14 == null) goto L5;
        int r15 = r14.f11319c;
        a(r8, r11, r15);
    L6:
        c(r8, r11, r15, r12);
        return;
    L5:
        s r16 = new s(r10);
        Object r17 = ((WorkDatabase) r16.f2194b).runInTransaction(new g(r16, 0));
        he.i.e(r17, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        r15 = ((Number) r17).intValue();
        r13.a(new i(r11.f11324a, r11.f11325b, r15));
        goto L6
    }

    public static void c(Context r8, l r10, int r11, long r12) {
        AlarmManager r13 = (AlarmManager) r8.getSystemService("alarm");
        String r14 = androidx.work.impl.background.systemalarm.a.f2852o;
        Intent r15 = new Intent(r8, SystemAlarmService.class);
        r15.setAction("ACTION_DELAY_MET");
        androidx.work.impl.background.systemalarm.a.c(r15, r10);
        PendingIntent r16 = PendingIntent.getService(r8, r11, r15, 201326592);
        if (r13 == null) goto L6;
        C0110a.a(r13, 0, r12, r16);
        return;
    }
}
