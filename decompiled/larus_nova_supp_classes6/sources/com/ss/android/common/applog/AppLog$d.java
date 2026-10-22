package com.ss.android.common.applog;

import com.bytedance.applog.log.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.LinkedList;
import jta.g;
import jta.g$a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AppLog$d extends PthreadThreadV2 implements g$a {
    public boolean v;
    public final /* synthetic */ AppLog w;

    public final void l() {
        g.b(this);
        if (AppLog.d(this.w) == true) goto L6;
        ita.j.c("AppLog can not setup LogReaper", null);
        return;
    L6:
        this.w.k();
        this.w.f();
    L7:
        LinkedList r0 = this.w.g;
        monitor-enter(r0);
        boolean r2 = AppLog.L;     // Catch: Throwable -> L30
        if (this.w.g.isEmpty() == true) goto L33;
        AppLog$c r3 = (AppLog$c) this.w.g.poll();     // Catch: Throwable -> L30
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L30
        if (r3 == null) goto L25;
        this.w.I(r3);
        this.v = true;
    L27:
        this.w.L(true, false, false);
        goto L7
    L25:
        if (this.v == false) goto L27;
        this.v = false;
        this.w.f();
        goto L27
    L33:
        if (this.v == false) goto L14;
        AppLog r4 = this.w;     // Catch: InterruptedException -> L32 Throwable -> L30
        r4.g.wait(r4.s);     // Catch: InterruptedException -> L32 Throwable -> L30
        goto L15
    L14:
        this.w.g.wait();     // Catch: InterruptedException -> L32 Throwable -> L30
    L15:
        boolean r5 = AppLog.L;     // Catch: Throwable -> L30
        if (this.w.g.isEmpty() == true) goto L18;
        r3 = (AppLog$c) this.w.g.poll();     // Catch: Throwable -> L30
        goto L20
    L18:
        r3 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AppLog$d(AppLog r1) {
        this.w = r1;
        super("ActionReaper");
        this.v = false;
    }

    @Override // jta.g$a
    public final void onDidLoadLocally(boolean r2) {
        monitor-enter(AppLog.class);
        AppLog.N0 = true;     // Catch: Throwable -> L13
        if (AppLog.O0 == false) goto L8;
        AppLog.c(this.w.l);     // Catch: Throwable -> L13
    L8:
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        if (m.b() == true) goto L18;
        m.c("local_did_load", new b());
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // jta.g$a
    public final void onDeviceRegistrationInfoChanged(String r4, String r5) {
        AppLog$c r0 = new AppLog$c(AppLog$ActionQueueType.DEVICE_ID_UPDATE);
        JSONObject r1 = new JSONObject();
        r1.put("device_id", r4);     // Catch: JSONException -> L5
        r1.put("install_id", r5);     // Catch: JSONException -> L5
        r0.b = r1;     // Catch: JSONException -> L5
    L7:
        this.w.i(r0);
        this.w.c = true;
        if (m.b() == true) goto L13;
        m.c("device_register_end", new a(r4, r5));
        return;
    L13:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // jta.g$a
    public final void onRemoteConfigUpdate(boolean r4, boolean r5) {
        AppLog r0 = this.w;
        if (r0.c == false) goto L6;
        r0.c = false;
        return;
    L6:
        if (r4 == true) goto L8;
        return;
    L8:
        if (AppLog.E0 == false) goto L12;
        this.w.L(false, true, r5);
        return;
    }
}
