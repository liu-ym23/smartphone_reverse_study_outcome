package com.ss.alive.monitor;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ServiceProvider;
import com.bytedance.android.service.manager.alive.monitor.AliveMonitorService;
import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;
import mqa.c;
import mqa.d;
import mqa.i;
import org.json.JSONObject;
import tqa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ServiceProvider
public class AliveMonitorServiceProvider implements AliveMonitorService {
    public AliveMonitorServiceProvider() {
    }

    public void onUserActive() {
        ((a) a.c()).a().onUserActive();
    }

    public boolean curProcessIsFirstProcess(Context r1) {
        return d.a(r1).c;
    }

    public JSONObject getProcessStartInfoObject(Context r4) {
        d r5 = d.a(r4);
        if (r5.d != null) goto L5;
        r5.d = new c(r5.b, r5.a);
    L5:
        i r6 = r5.d.g;
        if (r6 != null) goto L9;
        return null;
    L9:
        return r6.a();
    }

    public boolean hasHookActivityManagerSuccess(Context r2) {
        return ((rqa.a) ((a) a.c()).b(r2)).h;
    }

    public boolean hasHookActivityTaskManagerSuccess(Context r2) {
        return ((rqa.a) ((a) a.c()).b(r2)).i;
    }

    public void monitorAssociationStart(Context r2) {
        ((rqa.a) ((a) a.c()).b(r2)).i();
    }

    public void startDetectProcessLaunchReason(Context r5) {
        d r6 = d.a(r5);
        Application r0 = r6.b;
        if (oqa.a.b == null) goto L5;
    L14:
        oqa.a r1 = oqa.a.b;
        if (r6.d != null) goto L17;
        r6.d = new c(r6.b, r6.a);
    L17:
        r1.a = r6.d;
        g77.d.f().a(r1);
        return;
    L5:
        monitor-enter(oqa.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (oqa.a.b != null) goto L9;
        oqa.a.b = new oqa.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(oqa.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void monitorAssociationStart(Context r3, IMonitorCallback r4) {
        rqa.a r5 = (rqa.a) ((a) a.c()).b(r3);
        r5.k = r4;
        if (r5.h == false) goto L6;
        r4.onHookActivityManagerResult(true);
    L6:
        if (r5.i == false) goto L8;
        r5.k.onHookActivityTaskManagerResult(true);
    L8:
        r5.i();
    }
}
