package wm0;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    void ensureNotReachHere(Throwable r1, String r2);

    void monitorCommonLog(String r1, String r2, JSONObject r3);

    void monitorCommonLog(String r1, JSONObject r2);

    void monitorDirectOnTimer(String r1, String r2, float r3);

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4);

    void monitorStatusRate(String r1, int r2, JSONObject r3);
}
