package com.obric.memorydata.middleware.impl.bdtracker;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/ReportEventRejectHelper;", "", "<init>", "()V", "reportEventRejectedHandlerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "reportEventRejectedJsonMap", "Lorg/json/JSONObject;", "ENQUEUE_TIME_STAMP", "TAG", "hasHandler", "", "eventName", "registerReportEventRejectedHandler", "", "event", "handler", "onEventReject", "eventParams", "limitRateMs", "", "reportEvent", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.memorydata.middleware.api.bdtracker.b> f11708b = null;
    private static final ConcurrentHashMap<String, JSONObject> c = null;

    static {
        f11707a = new d();
        f11708b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    private d() {
    }

    private final synchronized void b(String r6) {
        monitor-enter(this);
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(c.remove(r6), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.remove("enqueue_time_stamp");     // Catch: Throwable -> L24
        if (r0.length() <= 0) goto L22;
        com.obric.memorydata.middleware.api.bdtracker.b r1 = (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.preCheckCast(f11708b.get(r6), com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        List<JSONObject> r2 = r1.a(r6, r0);     // Catch: Throwable -> L24
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L24
    L17:
        if (r3.hasNext() == false) goto L22;
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r3.next(), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r4.length() <= 0) goto L17;
        TrackerImpl.INSTANCE.reportEvent$middleware_impl_obricRelease(r6, r4, true);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private static final void c(String r1) {
        f11707a.b(r1);
    }

    public static /* synthetic */ void lambda$8m4WixnNboEaXiMmDIf7GwDoDPA(String r0) {
        c(r0);
    }

    public final void a(String r3, com.obric.memorydata.middleware.api.bdtracker.b r4) {
        com.obric.memorydata.middleware.api.bdtracker.b r2 = (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r2, "handler");
        ((Map) ZeusTransformUtils.preCheckCast(f11708b, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }

    public final synchronized void a(final String r9, JSONObject r10, long r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "eventName");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r10, "eventParams");     // Catch: Throwable -> L25
        if (r11 > 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        com.obric.memorydata.middleware.api.bdtracker.b r2 = (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.preCheckCast(f11708b.get(r9), com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r2 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        ConcurrentHashMap<String, JSONObject> r3 = c;     // Catch: Throwable -> L25
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r3.get(r9), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        boolean r5 = false;
        if (r4 != null) goto L15;
        r4 = new JSONObject();     // Catch: Throwable -> L25
        r4.put("enqueue_time_stamp", System.currentTimeMillis());     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r9, r4);     // Catch: Throwable -> L25
        r5 = true;
    L15:
        r2.a(r9, r10, r4);     // Catch: Throwable -> L25
        if (r5 == false) goto L18;
        GlobalHandlerUtil.Companion.getInstance().postDelay(r11, new $$Lambda$d$8m4WixnNboEaXiMmDIf7GwDoDPA(r9));     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L18:
        long r6 = r4.optLong("enqueue_time_stamp");     // Catch: Throwable -> L25
        if (r6 <= 0) goto L23;
        if (Math.abs(r6 - System.currentTimeMillis()) < (r11 * ((long) 2))) goto L23;
        RunLog.INSTANCE.debug("ReportEventRejectHelper", "reportEvent " + r9 + " after 2 times limitRateMs");     // Catch: Throwable -> L25
        b(r9);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        return f11708b.containsKey(r1);
    }
}
