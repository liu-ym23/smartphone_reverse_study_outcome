package com.bytedance.crash.dumper;

import android.os.SystemClock;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.m0;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.y;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dh4.f;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static void b(File r11, CrashType r12, int r13) {
        f r6 = new f(r11.getAbsolutePath() + "/custom.json");
        r6.j();
        r6.h("custom");
        r6.j();
        com.bytedance.crash.monitor.a r14 = j.a;
        if (r14 == null) goto L25;
        List r7 = ((com.bytedance.crash.monitor.f) r14).c.d(r12);
        int r8 = 0;
        boolean r0 = true;
        if (r7 == null) goto L14;
        boolean r9 = true;
        int r10 = 0;
    L9:
        if (r10 >= r7.size()) goto L13;
        AttachUserData r1 = (AttachUserData) ListProtector.get(r7, r10);
        r9 = a(r6, r1.getUserData(r12), r1.getClass().getName(), SystemClock.uptimeMillis(), r9);     // Catch: Throwable -> L30
    L12:
        r10 = r10 + 1;
        goto L9
    L13:
        r0 = r9;
    L14:
        m0 r15 = ((com.bytedance.crash.monitor.f) r14).c;
        ListMap r2 = r15.k;
        monitor-enter(r2);
        List r16 = r15.k.getList(r12);     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        if (r16 == null) goto L25;
        com.bytedance.crash.util.j.h(new JSONObject(), "tid", Integer.valueOf(r13));
        boolean r17 = r0;
    L21:
        if (r8 >= r16.size()) goto L25;
        y r18 = (y) ListProtector.get(r16, r8);
        r17 = a(r6, r18.getCrashInfo(), r18.getClass().getName(), SystemClock.uptimeMillis(), r17);     // Catch: Throwable -> L31
    L24:
        r8 = r8 + 1;
    L27:
        th = move-exception;
        throw th;
    L25:
        r6.k();
        r6.k();
        r6.g();
    }

    public static boolean a(f r2, Map<? extends String, ? extends String> r3, String r4, long r5, boolean r7) {
        if (r3 != null) goto L4;
    L15:
        return r7;
    L4:
        if (r3.size() == 0) goto L15;
        StringBuilder r0 = new StringBuilder("zz_cost_");
        r0.append(r4);
        Iterator<Map.Entry<? extends String, ? extends String>> r6 = r3.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<? extends String, ? extends String> r8 = r6.next();
        if (r7 == false) goto L12;
        r7 = false;
    L13:
        r2.h(r8.getKey());
        r2.l(r8.getValue());
        r0.append("_");
        r0.append(r8.getKey());
        goto L8
    L12:
        r2.i();
        goto L13
    L14:
        r2.a(',');
        r2.h(r0.toString());
        r2.c(SystemClock.uptimeMillis() - r5);
        goto L15
    }
}
