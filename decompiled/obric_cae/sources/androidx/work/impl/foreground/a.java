package androidx.work.impl.foreground;

import android.content.Context;
import android.content.Intent;
import androidx.work.h;
import androidx.work.m;
import j1.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n1.c;
import n1.d;
import r1.l;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c, j1.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2899t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f2900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1.a f2901b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f2902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f2903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashMap f2904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap f2905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashSet f2906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f2907r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public InterfaceC0024a f2908s;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    public interface InterfaceC0024a {
    }

    static {
        f2899t = m.f("SystemFgDispatcher");
    }

    public a(Context r8) {
        this.f2902m = new Object();
        b0 r10 = b0.f(r8);
        this.f2900a = r10;
        this.f2901b = r10.f8454d;
        this.f2903n = null;
        this.f2904o = new LinkedHashMap();
        this.f2906q = new HashSet();
        this.f2905p = new HashMap();
        this.f2907r = new d(r10.f8460j, this);
        r10.f8456f.a(this);
    }

    public static Intent a(Context r8, l r10, h r11) {
        Intent r12 = new Intent(r8, SystemForegroundService.class);
        r12.setAction("ACTION_NOTIFY");
        r12.putExtra("KEY_NOTIFICATION_ID", r11.f2832a);
        r12.putExtra("KEY_FOREGROUND_SERVICE_TYPE", r11.f2833b);
        r12.putExtra("KEY_NOTIFICATION", r11.f2834c);
        r12.putExtra("KEY_WORKSPEC_ID", r10.f11324a);
        r12.putExtra("KEY_GENERATION", r10.f11325b);
        return r12;
    }

    public static Intent b(Context r8, l r10, h r11) {
        Intent r12 = new Intent(r8, SystemForegroundService.class);
        r12.setAction("ACTION_START_FOREGROUND");
        r12.putExtra("KEY_WORKSPEC_ID", r10.f11324a);
        r12.putExtra("KEY_GENERATION", r10.f11325b);
        r12.putExtra("KEY_NOTIFICATION_ID", r11.f2832a);
        r12.putExtra("KEY_FOREGROUND_SERVICE_TYPE", r11.f2833b);
        r12.putExtra("KEY_NOTIFICATION", r11.f2834c);
        return r12;
    }

    @Override // n1.c
    public final void c(ArrayList r8) {
        if (r8.isEmpty() == true) goto L8;
        Iterator r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        t r11 = (t) r10.next();
        String r12 = r11.f11339a;
        m r13 = m.d();
        String r14 = defpackage.b.c("Constraints unmet for WorkSpec ", r12);
        r13.a(f2899t, r14);
        l r15 = l6.a.L(r11);
        b0 r16 = this.f2900a;
        r16.f8454d.a(new s1.t(r16, new j1.t(r15), true));
        goto L6
    L10:
        return;
    }

    @Override // n1.c
    public final void e(List<t> r8) {
    }

    @Override // j1.c
    public final void f(l r8, boolean r10) {
        Object r11 = this.f2902m;
        monitor-enter(r11);
        t r12 = (t) this.f2905p.remove(r8);     // Catch: Throwable -> L10
        if (r12 == null) goto L7;
        boolean r13 = this.f2906q.remove(r12);     // Catch: Throwable -> L10
    L8:
        if (r13 == false) goto L12;
        this.f2907r.d(this.f2906q);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        h r14 = (h) this.f2904o.remove(r8);
        if (r8.equals(this.f2903n) == true) goto L16;
    L24:
        InterfaceC0024a r15 = this.f2908s;
        if (r14 == null) goto L35;
        if (r15 == null) goto L36;
        m.d().a(f2899t, "Removing Notification (id: " + r14.f2832a + ", workSpecId: " + r8 + ", notificationType: " + r14.f2833b);
        SystemForegroundService r16 = (SystemForegroundService) r15;
        r16.f2895b.post(new q1.d(r16, r14.f2832a));
        return;
    L36:
        return;
    L35:
        return;
    L16:
        if (this.f2904o.size() <= 0) goto L24;
        Iterator r17 = this.f2904o.entrySet().iterator();
    L18:
        Map.Entry r18 = (Map.Entry) r17.next();
        if (r17.hasNext() == true) goto L18;
        this.f2903n = (l) r18.getKey();
        if (this.f2908s == null) goto L24;
        h r19 = (h) r18.getValue();
        InterfaceC0024a r20 = this.f2908s;
        int r21 = r19.f2832a;
        int r22 = r19.f2833b;
        SystemForegroundService r23 = (SystemForegroundService) r20;
        r23.f2895b.post(new b(r23, r21, r19.f2834c, r22));
        InterfaceC0024a r24 = this.f2908s;
        SystemForegroundService r25 = (SystemForegroundService) r24;
        r25.f2895b.post(new q1.d(r25, r19.f2832a));
        goto L24
    L7:
        r13 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
