package f2;

import c2.k;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import o2.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        if (k.f3303g != (-1)) goto L6;
        s2.a.b("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r8 = t2.b.f12259s - t2.b.f12247g;     // Catch: JSONException -> L16
        if (r8 > 0) goto L9;
        return;
    L9:
        if (r8 > SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME) goto L20;
        JSONArray r10 = t2.b.i();     // Catch: JSONException -> L16
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L16
        r11.put(QesdkUtils.TAGS.JSON_TAG_NAME, "launch_stats");     // Catch: JSONException -> L16
        r11.put("start", t2.b.f12247g);     // Catch: JSONException -> L16
        r11.put("end", t2.b.f12259s);     // Catch: JSONException -> L16
        r11.put("spans", r10);     // Catch: JSONException -> L16
        r11.put("collect_from", 1);     // Catch: JSONException -> L16
        r11.put("page_name", t2.b.f12261u);     // Catch: JSONException -> L16
        r11.put("launch_mode", k.f3303g);     // Catch: JSONException -> L16
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L16
        r12.put("trace", r11);     // Catch: JSONException -> L16
        if (k.d() == false) goto L14;
        s2.a.b("auto span: " + r11);     // Catch: JSONException -> L16
    L14:
        n2.a.i().d(new e("start_trace", "", null, null, r12));     // Catch: JSONException -> L16
        return;
    L20:
        return;
    }
}
