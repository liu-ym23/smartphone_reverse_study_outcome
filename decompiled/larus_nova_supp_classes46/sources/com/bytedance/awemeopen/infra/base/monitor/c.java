package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Function0 {
    public final /* synthetic */ AoMonitor.MonitorType a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ String f;
    public final /* synthetic */ JSONObject g;
    public final /* synthetic */ JSONObject h;

    public final Object invoke() {
        AoMonitor.MonitorType r1 = this.a;
        String r2 = this.b;
        int r3 = this.c;
        JSONObject r4 = this.d;
        JSONObject r5 = this.e;
        String r6 = this.f;
        JSONObject r7 = this.g;
        JSONObject r8 = this.h;
        monitor-enter(AoMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (AoMonitor.b == null) goto L7;
        AoMonitor.b.add(new AoMonitor.b(r1, r2, r3, r4, r5, r6, r7, r8));     // Catch: Throwable -> L11
    L8:
        monitor-exit(AoMonitor.class);
        return null;
    L7:
        AoLogger.c("AoAppMonitor", new Object[]{"queueCacheItem error"});     // Catch: Throwable -> L11
        goto L8
    }

    public c(AoMonitor.MonitorType r1, String r2, int r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.e = r4;
        this.f = null;
        this.g = r5;
        this.h = r6;
    }
}
