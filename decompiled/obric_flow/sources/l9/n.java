package l9;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.MonitorCrash;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MonitorCrash f19579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19580b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f19581c;

    public static MonitorCrash a() {
        if (f19579a != null) goto L6;
        MonitorCrash r5 = MonitorCrash.initSDK(com.bytedance.crash.n.f4057a, "2010", 30107139, "3.1.7-rc.89", "");
        f19579a = r5;
        r5.config().setChannel("release");
    L6:
        return f19579a;
    }

    public static void b(String r12, JSONObject r13, JSONObject r14) {
        if (com.bytedance.crash.n.f4057a != null) goto L5;
        return;
    L5:
        if (r13 != null) goto L7;
        r13 = new JSONObject();
    L7:
        JSONObject r5 = r13;
        JSONObject r15 = new JSONObject[]{r5}[0];
        if (r15 != null) goto L18;
    L15:
        a().reportEvent(r12, 1, r5, r14, null);
        return;
    L18:
        Iterator r10 = i4.a.j(((ICommonParams) com.bytedance.crash.n.d().f17503c).getCommonParams(), new String[]{WsConstants.KEY_APP_ID, "4444", "update_version_code", "000000", LynxMonitorService.KEY_CHANNEL, "unknown", "app_version", "0.0.0"}).entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r10.hasNext() == false) goto L15;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L17
        r15.put((String) r11.getKey(), r11.getValue());     // Catch: Throwable -> L17
        goto L12
    }
}
