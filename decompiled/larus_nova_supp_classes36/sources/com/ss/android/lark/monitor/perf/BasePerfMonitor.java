package com.ss.android.lark.monitor.perf;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BasePerfMonitor {

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlatformType {
        public static final int SLARDAR = 1;
        public static final int TEA = 2;
    }

    public interface a {
        void generateData(JSONObject r1, JSONObject r2, JSONObject r3);

        String getEventName(int r1);

        boolean isValid();

        boolean needReport(int r1);
    }

    public static abstract class b implements a {
        protected long costInMillis;

        public b() {
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean needReport(int r2) {
            if (r2 != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean isValid() {
            if (this.costInMillis <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void end() {
            this.costInMillis = SystemClock.elapsedRealtime() - this.costInMillis;
        }

        public void start() {
            this.costInMillis = SystemClock.elapsedRealtime();
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public void generateData(JSONObject r3, JSONObject r4, JSONObject r5) {
            r3.put("time", this.costInMillis);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public BasePerfMonitor() {
    }

    public static /* synthetic */ void a(a r0) {
        lambda$reportToTea$0(r0);
    }

    public static /* synthetic */ void b(a r0) {
        lambda$reportToSlardar$1(r0);
    }

    private static /* synthetic */ void lambda$reportToSlardar$1(a r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L4
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L4
        r4.generateData(r0, r1, r2);     // Catch: Exception -> L4
        ApmAgent.monitorEvent(r4.getEventName(1), r1, r0, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CommonPerfMonitor", "reportToSlardar error", e);
    }

    private static /* synthetic */ void lambda$reportToTea$0(a r2) {
        JSONObject r0 = new JSONObject();
        r2.generateData(r0, r0, r0);
        Statistics.sendEvent(r2.getEventName(2), r0);
    }

    public static void reportToSlardar(final a r2) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.monitor.perf.a(r2));
        Log.d("CommonPerfMonitor", "start reportToSlardar");
    }

    public static void reportToTea(final a r2) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.monitor.perf.b(r2));
        Log.d("CommonPerfMonitor", "start reportToTea");
    }
}
