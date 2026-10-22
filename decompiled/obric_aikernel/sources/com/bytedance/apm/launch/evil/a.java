package com.bytedance.apm.launch.evil;

import com.bytedance.apm.d;
import com.bytedance.apm.util.u;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.apm.launch.evil.a$a, reason: collision with other inner class name */
    static class RunnableC0037a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StackTraceElement[] f1004c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1005g;

        RunnableC0037a(StackTraceElement[] r10, long r11) {
            this.f1004c = r10;
            this.f1005g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = u.c(this.f1004c);     // Catch: JSONException -> L10
            if (this.f1005g != 0) goto L6;
            return;
        L6:
            if (r10.isEmpty() == true) goto L16;
            JSONObject r11 = new JSONObject();     // Catch: JSONException -> L10
            r11.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L10
            r11.put("crash_time", System.currentTimeMillis());     // Catch: JSONException -> L10
            r11.put("is_main_process", d.I());     // Catch: JSONException -> L10
            r11.put("process_name", d.h());     // Catch: JSONException -> L10
            r11.put("block_duration", this.f1005g);     // Catch: JSONException -> L10
            r11.put("stack", r10);     // Catch: JSONException -> L10
            r11.put(Constants.EVENT_TYPE, "lag");     // Catch: JSONException -> L10
            JSONObject r12 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L10
            r12.put("block_stack_type", "stack");     // Catch: JSONException -> L10
            r12.put("is_launch_binder", "true");     // Catch: JSONException -> L10
            r11.put("filters", r12);     // Catch: JSONException -> L10
            c0.a.b().d("binder report json: " + r11);     // Catch: JSONException -> L10
            x.a.p().e(new y.d(LogTypeName.MONITOR_TYPE_BLOCK, r11));     // Catch: JSONException -> L10
            return;
        L16:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static long a() {
        long r10 = 0;
        if (c0.a.b().c().a() == true) goto L5;
    L15:
        return r10;
    L5:
        if (com.bytedance.apm.internal.a.d(2) == false) goto L15;
        List<BinderMonitor.a> r11 = k.n().d();
        if (r11 != null) goto L9;
    L14:
        c0.a.b().d("binder cost when launch: " + r10);
        goto L15
    L9:
        if (r11.isEmpty() == true) goto L14;
        Iterator<BinderMonitor.a> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        BinderMonitor.a r13 = r12.next();
        long r14 = r13.c() - r13.a();
        r10 = r10 + r14;
        c(r14, b(r13.b()));
        goto L12
    }

    private static StackTraceElement[] b(StackTraceElement[] r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.length == 0) goto L21;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        if ("saveBinderInfo".equals(r10[r12].getMethodName()) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        r11 = r12;
    L13:
        int r13 = r11 + 1;
        if (r13 <= r10.length) goto L16;
        return r10;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r10, r13, r10.length);
    L21:
        return r10;
    }

    private static void c(long r10, StackTraceElement[] r11) {
        q0.b.f().i(new RunnableC0037a(r11, r10));
    }
}
