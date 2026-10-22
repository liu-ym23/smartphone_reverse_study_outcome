package fyb;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.config.OPMonitorHeartBeatConfig;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static d h;
    public static boolean i;
    public OPMonitorHeartBeatConfig a;
    public OPMonitorCode b;
    public b c;
    public c d;
    public ScheduledExecutorService e;
    public final ConcurrentHashMap<String, OPMonitorHeartBeatMonitorData> f;
    public final ConcurrentHashMap<String, byb.a> g;

    public final synchronized void b() {
        monitor-enter(this);
        ScheduledExecutorService r0 = this.e;     // Catch: Throwable -> L18
        if (r0 != null) goto L6;
    L15:
        Log.i("OPMonitorHeartBeatManager", "reStartTimer fail, last timer not shutdown");     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L6:
        if (r0.isShutdown() == false) goto L15;
        OPMonitorHeartBeatConfig r1 = this.a;     // Catch: Throwable -> L18
        if (r1.a > 0) goto L10;
        r1.a = 30;     // Catch: Throwable -> L18
    L10:
        int r2 = r1.a;     // Catch: Throwable -> L18
        ScheduledExecutorService r3 = PThreadExecutorsUtils.newScheduledThreadPool(1, this.d);     // Catch: Throwable -> L18
        this.e = r3;     // Catch: Throwable -> L18
        long r7 = r2;
        r3.scheduleWithFixedDelay(this.c, r7, r7, TimeUnit.SECONDS);     // Catch: RejectedExecutionException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "scheduleWithFixedDelay is exception", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static d a() {
        if (h != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public d() {
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        if (i == true) goto L40;
        i = true;
        OPMonitorHeartBeatConfig r1 = new OPMonitorHeartBeatConfig();
        this.a = r1;
        int r2 = iyb.a.a;
        Intrinsics.checkNotNullParameter("ecosystem.monitor.heartbeat.enable", "fgKey");
        r1.b = false;
        Intrinsics.checkNotNullParameter("opmonitor_heartbeat_conifg", "configKey");     // Catch: Exception -> L8
        JSONObject r3 = new JSONObject("");     // Catch: Exception -> L8
        this.a.c = JSONObjectProtectorUtils.getInt(r3, "maxReportCount");     // Catch: Exception -> L8
        this.a.a = JSONObjectProtectorUtils.getInt(r3, "heartBeatInterval");     // Catch: Exception -> L8
    L11:
        if (this.a.b == true) goto L14;
        this.f.clear();
        this.g.clear();
        return;
    L14:
        if (e.b.a == null) goto L16;
        this.b = null;
    L17:
        this.c = new b(this);
        this.d = new c();
        monitor-enter(this);
        Log.i("OPMonitorHeartBeatManager", "startTimer");     // Catch: Throwable -> L30
        OPMonitorHeartBeatConfig r4 = this.a;     // Catch: Throwable -> L30
        if (r4.a > 0) goto L22;
        r4.a = 30;     // Catch: Throwable -> L30
    L22:
        int r5 = r4.a;     // Catch: Throwable -> L30
        ScheduledExecutorService r6 = PThreadExecutorsUtils.newScheduledThreadPool(1, this.d);     // Catch: Throwable -> L30
        this.e = r6;     // Catch: Throwable -> L30
        long r7 = r5;
        r6.scheduleWithFixedDelay(this.c, r7, r7, TimeUnit.SECONDS);     // Catch: RejectedExecutionException -> L25 Throwable -> L30
    L27:
        monitor-exit(this);
        Log.i("OPMonitorHeartBeatManager", "OPMonitorHeartBeatManager is done config" + this.a);
        Log.i("OPMonitorHeartBeatManager", "OPMonitorHeartBeatManager is done batchMonitorCode:" + this.b);
        return;
    L25:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "scheduleWithFixedDelay is exception", e);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L16:
        this.b = new OPMonitorCode("monitor.base.heartbeat", OPTrace.BATCH_CODE, OPMonitorLevel.NORMAL, "heartbeat_report");
    L8:
        e = move-exception;
        Log.e("OPMonitorHeartBeatManager", "heartbeat settings parse is exception", e);
        goto L11
    }
}
