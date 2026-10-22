package g64;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements o64.a {
    public final SDKMonitor a;

    /* JADX INFO: renamed from: g64.a$a, reason: collision with other inner class name */
    public class C0213a implements SDKMonitor.IGetExtendParams {
        public final Map<String, String> getCommonParams() {
            return null;
        }

        public final String getSessionId() {
            return null;
        }

        public C0213a() {
        }
    }

    public a(Context r2, String r3, JSONObject r4, List<String> r5) {
        SDKMonitorUtils.setConfigUrl(r3, r5);
        ArrayList r6 = new ArrayList();
        r6.add("https://mon.snssdk.com/monitor/collect/");
        SDKMonitorUtils.setDefaultReportUrl(r3, r6);
        SDKMonitorUtils.initMonitor(r2, r3, r4, new C0213a());
        this.a = SDKMonitorUtils.getInstance(r3);
    }
}
