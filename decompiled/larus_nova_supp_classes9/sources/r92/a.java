package r92;

import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BasePerformanceStrategyTask {
    public final boolean onTriggerEnhance(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        return false;
    }

    public a() {
    }

    public final void onTriggerOrigin(Map<String, String> r3, IPerformanceStrategyMonitor r4) {
        HashMap r5 = new HashMap();
        r5.put("scene", "public_screen");
        r4.updatePerformanceNotifyMonitor(r5, 0);
        TextMessageWidget.V0 = false;
        r4.updatePerformanceExecuteMonitor(r5, 0);
    }

    public final boolean onTriggerDegrade(int r3, Map<String, String> r4, IPerformanceStrategyMonitor r5) {
        HashMap r6 = new HashMap();
        r6.put("scene", "public_screen");
        r5.updatePerformanceNotifyMonitor(r6, r3);
        TextMessageWidget.V0 = true;
        r5.updatePerformanceExecuteMonitor(r6, r3);
        return false;
    }
}
