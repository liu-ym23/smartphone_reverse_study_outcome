package asb;

import android.os.BatteryManager;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.e;
import com.ss.android.lark.monitor.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends e {
    public final BatteryManager a;
    public final ConcurrentHashMap<String, a> b;

    public class a {
        public int a;
        public final long b;

        public a() {
            this.b = System.currentTimeMillis();
        }
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r1) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r1) {
    }

    public d(i r2) {
        super(r2);
        this.b = new ConcurrentHashMap();
        this.a = (BatteryManager) this.mMetricsConfig.a.getSystemService("batterymanager");
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(final String r3) {
        if (this.b.containsKey(r3) == false) goto L6;
        return;
    L6:
        if (this.a == null) goto L9;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r3));
        return;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(final String r3, final JSONObject r4) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new asb.a(this, r3, r4));
    }

    public static /* synthetic */ void a(d r8, a r9, String r10, long r11, JSONObject r13) {
        int r0 = r8.a.getIntProperty(4);
        int r12 = r9.a - r0;
        if (r12 > 0) goto L13;
    L11:
        Log.i("ScenePerfMonitor", "End Scene:" + r10 + ",current battery is " + r0 + " usedBattery:" + r12 + " Span:" + r11);
        return;
    L13:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L9
        r2.put("scene", r10);     // Catch: Throwable -> L9
        r2.put("battery", r12);     // Catch: Throwable -> L9
        r2.put("span", r11);     // Catch: Throwable -> L9
        double r3 = r12 / (r11 / 60.0f);     // Catch: Throwable -> L9
        if (r3 <= 0.4d) goto L7;
        r2.put("costException", true);     // Catch: Throwable -> L9
    L7:
        r2.put("batterySpeed", r3);     // Catch: Throwable -> L9
        r2.put("isCharging", ds3.a.c(r8.mMetricsConfig.a));     // Catch: Throwable -> L9
        r2.put("uiMode", r8.mMetricsConfig.a.getResources().getConfiguration().uiMode & 48);     // Catch: Throwable -> L9
        r2.put("remainBattery", r0);     // Catch: Throwable -> L9
        isb.a.a(r2, r13);     // Catch: Throwable -> L9
        isb.a.c("scene_battery_info", r2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e("ScenePerfMonitor", th);
        goto L11
    }
}
