package com.bytedance.applog.monitor.exception;

import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f1672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1673b;
    private a c;
    private c d;
    private d e;

    static {
        f1672a = new b();
    }

    public b() {
        this.f1673b = false;
    }

    public static b a() {
        return f1672a;
    }

    public void a(ExceptionScene r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(r8, ExceptionType.InterruptionTouristMode, ExceptionLevel.Notice, "report interrupted due to tourist mode.", null);
    }

    public void a(ExceptionScene r7, ExceptionType r8, ExceptionLevel r9, String r10, Map<String, ?> r11) {
        Map<String, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L5;
        return;
    L5:
        a r0 = this.c;
        if (r0 != null) goto L13;
        return;
    L13:
        r0.a(r7, r8, r9, r10, r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        q.a().a("AppLogExceptionHandler onException failed, ", th, new Object[0]);
    }

    public void a(ExceptionType r8, String r9) {
        if (b() == true) goto L5;
        return;
    L5:
        a(ExceptionScene.DataCollection, r8, ExceptionLevel.Notice, r9, null);
    }

    public void a(StageEventType r9, String r10, long r11, long r13) {
        if (b() == true) goto L5;
        return;
    L5:
        c r0 = this.d;
        if (r0 == null) goto L9;
        r0.a(r9, r10, r11);     // Catch: Throwable -> L15
    L9:
        if (r13 <= 0) goto L21;
        d r1 = this.e;
        if (r1 != null) goto L19;
        return;
    L19:
        r1.a(r9, r10, r11, r13);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    }

    public void a(StageEventType r4, String r5, String r6, long r7) {
        if (b() == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put(LocationMonitorConst.TAG, r5);
        r0.put(TrackerImpl.PARAMS, r6);
        a(ExceptionScene.DataCollection, ExceptionType.OutOfDataBoundary, ExceptionLevel.Fatal, r4 + " out of data boundary, event limit length: " + r7, r0);
    }

    public void a(String r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(ExceptionScene.DataCollection, ExceptionType.CacheOverflow, ExceptionLevel.Fatal, r8, null);
    }

    public void a(String r8, Throwable r9) {
        if (b() == true) goto L5;
        return;
    L5:
        HashMap r6 = new HashMap();
        r6.put("throwable", r9);
        a(ExceptionScene.Common, ExceptionType.CommonError, ExceptionLevel.Fatal, r8, r6);
    }

    public void b(ExceptionScene r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(r8, ExceptionType.InterruptionInvalidDid, ExceptionLevel.Notice, "report interrupted due to invalid did.", null);
    }

    public boolean b() {
        return this.f1673b;
    }
}
