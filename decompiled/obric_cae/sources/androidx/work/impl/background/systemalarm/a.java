package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.m;
import androidx.work.n;
import j1.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import r1.i;
import r1.j;
import r1.l;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements j1.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f2852o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2854b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f2855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r6.d f2856n;

    static {
        f2852o = m.f("CommandHandler");
    }

    public a(Context r8, r6.d r10) {
        this.f2853a = r8;
        this.f2856n = r10;
        this.f2854b = new HashMap();
        this.f2855m = new Object();
    }

    public static l b(Intent r8) {
        return new l(r8.getStringExtra("KEY_WORKSPEC_ID"), r8.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void c(Intent r8, l r10) {
        r8.putExtra("KEY_WORKSPEC_ID", r10.f11324a);
        r8.putExtra("KEY_WORKSPEC_GENERATION", r10.f11325b);
    }

    public final void a(int r10, Intent r11, d r12) {
        String r8 = r11.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r8) == false) goto L32;
        m.d().a(f2852o, "Handling constraints changed " + r11);
        b r13 = new b(this.f2853a, r10, r12);
        ArrayList r14 = r12.f2879o.f8453c.f().d();
        String r15 = ConstraintProxy.f2843a;
        Iterator r16 = r14.iterator();
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
        boolean r20 = false;
    L6:
        if (r16.hasNext() == false) goto L16;
        androidx.work.d r21 = ((t) r16.next()).f11348j;
        r17 = r17 | r21.f2811d;
        r18 = r18 | r21.f2809b;
        r19 = r19 | r21.f2812e;
        if (r21.f2808a == n.f2932a) goto L10;
        boolean r22 = true;
    L11:
        r20 = r20 | r22;
        if (r17 == false) goto L6;
        if (r18 == false) goto L6;
        if (r19 == false) goto L6;
        if (r20 == false) goto L6;
    L10:
        r22 = false;
    L16:
        String r23 = ConstraintProxyUpdateReceiver.f2844a;
        Intent r24 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        Context r25 = r13.f2858a;
        r24.setComponent(new ComponentName(r25, ConstraintProxyUpdateReceiver.class));
        r24.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", r17).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", r18).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", r19).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", r20);
        r25.sendBroadcast(r24);
        n1.d r26 = r13.f2860c;
        r26.d(r14);
        ArrayList r27 = new ArrayList(r14.size());
        long r28 = System.currentTimeMillis();
        Iterator r29 = r14.iterator();
    L18:
        if (r29.hasNext() == false) goto L26;
        t r30 = (t) r29.next();
        String r31 = r30.f11339a;
        if (r28 < r30.a()) goto L18;
        if (r30.e() == false) goto L25;
        if (r26.c(r31) == false) goto L18;
    L25:
        r27.add(r30);
        goto L18
    L26:
        Iterator r32 = r27.iterator();
    L28:
        if (r32.hasNext() == false) goto L30;
        t r33 = (t) r32.next();
        String r34 = r33.f11339a;
        l r35 = l6.a.L(r33);
        Intent r36 = new Intent(r25, SystemAlarmService.class);
        r36.setAction("ACTION_DELAY_MET");
        c(r36, r35);
        m.d().a(b.f2857d, defpackage.b.d("Creating a delay_met command for workSpec with id (", r34, ")"));
        ((u1.b) r12.f2876b).f12422c.execute(new d.b(r13.f2859b, r36, r12));
        goto L28
    L30:
        r26.e();
        return;
    L32:
        if ("ACTION_RESCHEDULE".equals(r8) == false) goto L34;
        m.d().a(f2852o, "Handling reschedule " + r11 + ", " + r10);
        r12.f2879o.k();
        return;
    L34:
        Bundle r37 = r11.getExtras();
        String[] r38 = {"KEY_WORKSPEC_ID"};
        if (r37 != null) goto L37;
    L43:
        boolean r39 = false;
    L44:
        if (r39 == true) goto L47;
        m.d().b(f2852o, "Invalid request for " + r8 + " , requires KEY_WORKSPEC_ID .");
        return;
    L47:
        if ("ACTION_SCHEDULE_WORK".equals(r8) == false) goto L69;
        l r110 = b(r11);
        String r40 = f2852o;
        m.d().a(r40, "Handling schedule work for " + r110);
        WorkDatabase r41 = r12.f2879o.f8453c;
        r41.beginTransaction();
        t r42 = r41.f().g(r110.f11324a);     // Catch: Throwable -> L65
        if (r42 != null) goto L55;
        m r43 = m.d();     // Catch: Throwable -> L65
        StringBuilder r44 = new StringBuilder("Skipping scheduling ");     // Catch: Throwable -> L65
        r44.append(r110);     // Catch: Throwable -> L65
        String r111 = " because it's no longer in the DB";
    L53:
        r44.append(r111);     // Catch: Throwable -> L65
        r43.g(r40, r44.toString());     // Catch: Throwable -> L65
    L64:
        r41.endTransaction();
        return;
    L55:
        if (r42.f11340b.a() == false) goto L58;
        r43 = m.d();     // Catch: Throwable -> L65
        r44 = new StringBuilder("Skipping scheduling ");     // Catch: Throwable -> L65
        r44.append(r110);     // Catch: Throwable -> L65
        r111 = "because it is finished.";
        goto L53
    L58:
        long r45 = r42.a();     // Catch: Throwable -> L65
        boolean r46 = r42.e();     // Catch: Throwable -> L65
        Context r47 = this.f2853a;
        if (r46 == true) goto L62;
        m.d().a(r40, "Setting up Alarms for " + r110 + "at " + r45);     // Catch: Throwable -> L65
        l1.a.b(r47, r41, r110, r45);     // Catch: Throwable -> L65
    L63:
        r41.setTransactionSuccessful();     // Catch: Throwable -> L65
        goto L64
    L62:
        m.d().a(r40, "Opportunistically setting an alarm for " + r110 + "at " + r45);     // Catch: Throwable -> L65
        l1.a.b(r47, r41, r110, r45);     // Catch: Throwable -> L65
        Intent r112 = new Intent(r47, SystemAlarmService.class);     // Catch: Throwable -> L65
        r112.setAction("ACTION_CONSTRAINTS_CHANGED");     // Catch: Throwable -> L65
        ((u1.b) r12.f2876b).f12422c.execute(new d.b(r10, r112, r12));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r41.endTransaction();
        throw th;
    L69:
        if ("ACTION_DELAY_MET".equals(r8) == false) goto L82;
        Object r48 = this.f2855m;
        monitor-enter(r48);
        l r113 = b(r11);     // Catch: Throwable -> L78
        m r49 = m.d();     // Catch: Throwable -> L78
        String r50 = f2852o;     // Catch: Throwable -> L78
        r49.a(r50, "Handing delay met for " + r113);     // Catch: Throwable -> L78
        if (this.f2854b.containsKey(r113) == true) goto L75;
        c r51 = new c(this.f2853a, r10, r12, this.f2856n.f(r113));     // Catch: Throwable -> L78
        this.f2854b.put(r113, r51);     // Catch: Throwable -> L78
        r51.f();     // Catch: Throwable -> L78
    L76:
        monitor-exit(r48);     // Catch: Throwable -> L78
        return;
    L75:
        m.d().a(r50, "WorkSpec " + r113 + " is is already being handled for ACTION_DELAY_MET");     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;
    L82:
        if ("ACTION_STOP_WORK".equals(r8) == false) goto L97;
        Bundle r52 = r11.getExtras();
        String r114 = r52.getString("KEY_WORKSPEC_ID");
        boolean r53 = r52.containsKey("KEY_WORKSPEC_GENERATION");
        r6.d r54 = this.f2856n;
        if (r53 == false) goto L88;
        int r55 = r52.getInt("KEY_WORKSPEC_GENERATION");
        ArrayList r56 = new ArrayList(1);
        j1.t r57 = r54.d(new l(r114, r55));
        List r58 = r56;
        if (r57 == null) goto L89;
        r56.add(r57);
        r58 = r56;
    L89:
        Iterator r59 = r58.iterator();
    L91:
        if (r59.hasNext() == false) goto L132;
        j1.t r60 = (j1.t) r59.next();
        m.d().a(f2852o, defpackage.b.c("Handing stopWork work for ", r114));
        b0 r61 = r12.f2879o;
        r61.f8454d.a(new s1.t(r61, r60, false));
        WorkDatabase r62 = r12.f2879o.f8453c;
        l r63 = r60.f8541a;
        String r64 = l1.a.f9126a;
        j r65 = r62.c();
        i r66 = r65.b(r63);
        if (r66 == null) goto L95;
        l1.a.a(this.f2853a, r63, r66.f11319c);
        m.d().a(l1.a.f9126a, "Removing SystemIdInfo for workSpecId (" + r63 + ")");
        r65.e(r63);
    L95:
        r12.f(r60.f8541a, false);
        goto L91
    L132:
        return;
    L88:
        r58 = r54.e(r114);
        goto L89
    L97:
        if ("ACTION_EXECUTION_COMPLETED".equals(r8) == false) goto L99;
        l r115 = b(r11);
        boolean r67 = r11.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        m.d().a(f2852o, "Handling onExecutionCompleted " + r11 + ", " + r10);
        f(r115, r67);
        return;
    L99:
        m.d().g(f2852o, "Ignoring intent " + r11);
        return;
    L37:
        if (r37.isEmpty() == true) goto L43;
        if (r37.get(r38[0]) == null) goto L43;
        r39 = true;
        goto L44
    }

    @Override // j1.c
    public final void f(l r8, boolean r10) {
        Object r11 = this.f2855m;
        monitor-enter(r11);
        c r12 = (c) this.f2854b.remove(r8);     // Catch: Throwable -> L9
        this.f2856n.d(r8);     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.g(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
