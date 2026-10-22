package com.bytedance.applog.monitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.work.WorkRequest;
import com.bytedance.crash.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l1.f;
import l1.g;
import l1.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f1201c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private Monitor f1202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.c f1203b;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.a$a, reason: collision with other inner class name */
    class C0044a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1204a;

        C0044a(a r10) {
            this.f1204a = r10;
        }

        @Override // com.bytedance.applog.monitor.b
        public boolean a(List<c> r10) {
            if (r10 != null) goto L5;
        L18:
            return false;
        L5:
            if (r10.size() == 0) goto L18;
            Iterator<c> r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L17;
            c r12 = r11.next();
            if (r12 == null) goto L9;
            if (a.a(this.f1204a).b0() == false) goto L16;
            a.a(this.f1204a).P().o(a.b(), "[onUpload]: reportData.event:" + r12.f1205a + ",reportData.jsonObject: {}", new Object[]{r12.f1206b});
        L16:
            a.a(this.f1204a).a(r12.f1205a, r12.f1206b);
            goto L9
        L17:
            return true;
        }
    }

    static {
        f1201c = Collections.singletonList("AppLogMonitor");
    }

    public a(com.bytedance.applog.c r10) {
        this.f1203b = r10;
    }

    static /* synthetic */ com.bytedance.applog.c a(a r10) {
        return r10.f1203b;
    }

    static /* synthetic */ List b() {
        return f1201c;
    }

    public static String c(l1.a r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        if ((r10 instanceof l1.c) == false) goto L10;
        return ((l1.c) r10).A;
    L10:
        if ((r10 instanceof l1.e) == false) goto L14;
        return ((l1.e) r10).F();
    L14:
        if ((r10 instanceof l1.d) == false) goto L18;
        return ((l1.d) r10).E();
    L18:
        if ((r10 instanceof f) == false) goto L22;
        return Constants.LAUNCH_TAG;
    L22:
        if ((r10 instanceof i) == false) goto L26;
        return "terminate";
    L26:
        if ((r10 instanceof g) == false) goto L29;
        return "pack";
    L29:
        return "unknown_event_type";
    }

    private MonitorKey d(l1.a r10) {
        if (r10 != null) goto L6;
        return MonitorKey.monitor_default;
    L6:
        if ((r10 instanceof l1.c) == false) goto L10;
        return MonitorKey.event;
    L10:
        if ((r10 instanceof l1.e) == false) goto L14;
        return MonitorKey.event_v3;
    L14:
        if ((r10 instanceof l1.d) == false) goto L18;
        return MonitorKey.log_data;
    L18:
        if ((r10 instanceof f) == false) goto L22;
        return MonitorKey.launch;
    L22:
        if ((r10 instanceof i) == false) goto L26;
        return MonitorKey.terminate;
    L26:
        if ((r10 instanceof g) == false) goto L30;
        return MonitorKey.pack;
    L30:
        return MonitorKey.monitor_default;
    }

    private MonitorState e(g r10) {
        MonitorState r11 = MonitorState.f_net;
        int r12 = r10.B;
        if (r12 < 0) goto L41;
        if (r12 != 0) goto L8;
        return MonitorState.f_net_zero;
    L8:
        if (r12 != 10) goto L11;
        return MonitorState.f_net_10;
    L11:
        if (r12 != 11) goto L14;
        return MonitorState.f_net_11;
    L14:
        if (r12 != 12) goto L17;
        return MonitorState.f_net_12;
    L17:
        if (r12 != 13) goto L20;
        return MonitorState.f_net_13;
    L20:
        if (r12 != 14) goto L23;
        return MonitorState.f_net_14;
    L23:
        if (r12 != 15) goto L26;
        return MonitorState.f_net_15;
    L26:
        if (r12 >= 200) goto L29;
        return MonitorState.f_net_1xx;
    L29:
        if (r12 >= 300) goto L32;
        return MonitorState.f_net_2xx;
    L32:
        if (r12 >= 400) goto L35;
        return MonitorState.f_net_3xx;
    L35:
        if (r12 >= 500) goto L38;
        return MonitorState.f_net_4xx;
    L38:
        if (r12 < 600) goto L40;
        return r11;
    L40:
        return MonitorState.f_net_5xx;
    L41:
        return MonitorState.f_net_minus;
    }

    public synchronized void f(String r10, Context r11) {
        monitor-enter(this);
        Log.i("AppLogMonitor", "[init]: context:" + r11);     // Catch: Throwable -> L6
        g(r10, r11, Monitor.INTERVAL_REPORT);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void g(String r10, Context r11, long r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f1202a != null) goto L6;
        Monitor r13 = new Monitor(null, new C0044a(this), r10 + "@");     // Catch: Throwable -> L8
        this.f1202a = r13;     // Catch: Throwable -> L8
        r13.setContext(r11, WorkRequest.MIN_BACKOFF_MILLIS);     // Catch: Throwable -> L8
        this.f1202a.setReportInterval(r12);     // Catch: Throwable -> L8
        this.f1202a.setLogger(this.f1203b.P());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public void h(MonitorKey r10, MonitorState r11) {
        Monitor r12 = this.f1202a;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.record(r10.name(), r11.name());
    }

    public void i(l1.a r10, MonitorState r11) {
        Monitor r12 = this.f1202a;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.record(d(r10).name(), r11.name());
    }

    public void j(MonitorKey r10, MonitorState r11, int r12) {
        Monitor r13 = this.f1202a;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.recordCount(r10.name(), r11.name(), r12);
    }

    public void k(List<g> r10, MonitorState r11) {
        if (this.f1202a == null) goto L20;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.size() == 0) goto L29;
        this.f1202a.recordCount(MonitorKey.pack.name(), r11.name(), r10.size());
        Iterator<g> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L30;
        g r13 = r12.next();
        JSONObject r14 = new JSONObject(r13.I());     // Catch: Exception -> L18
        int r15 = r14.optInt("LAUNCH");     // Catch: Exception -> L18
        int r16 = r14.optInt("TERMINATE");     // Catch: Exception -> L18
        int r17 = r14.optInt("EVENT_V1");     // Catch: Exception -> L18
        int r18 = r14.optInt("EVENT_V3");     // Catch: Exception -> L18
        int r19 = r14.optInt("MISC");     // Catch: Exception -> L18
        int r20 = r14.optInt("IMPRESSION");     // Catch: Exception -> L18
        if (r11 != MonitorState.f_net) goto L15;
        MonitorState r21 = e(r13);     // Catch: Exception -> L18
    L16:
        String r22 = r21.name();     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.launch.name(), r22, r15);     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.terminate.name(), r22, r16);     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.event.name(), r22, r17);     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.event_v3.name(), r22, r18);     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.log_data.name(), r22, r19);     // Catch: Exception -> L18
        this.f1202a.recordCount(MonitorKey.item_impression.name(), r22, r20);     // Catch: Exception -> L18
        goto L10
    L15:
        r21 = r11;
    L18:
        e = move-exception;
        this.f1203b.P().u(f1201c, "recordCountInPack failed", e, new Object[0]);
        goto L10
    L30:
        return;
    L29:
        return;
    }

    public void l(g r10, MonitorState r11) {
        if (this.f1202a == null) goto L8;
        if (r10 == null) goto L9;
        ArrayList r12 = new ArrayList();
        r12.add(r10);
        k(r12, r11);
        return;
    L9:
        return;
    }

    public void m(MonitorKey r10, String r11) {
        Monitor r12 = this.f1202a;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.recordCustomState(r10.name(), r11);
    }

    public void n(List<g> r10, List<g> r11) {
        if (this.f1202a != null) goto L5;
        return;
    L5:
        k(r10, MonitorState.success);
        k(r11, MonitorState.f_net);
    }

    public void o(MonitorKey r10, MonitorState r11, long r12) {
        Monitor r13 = this.f1202a;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.recordTime(r10.name(), r11.name(), r12);
    }
}
