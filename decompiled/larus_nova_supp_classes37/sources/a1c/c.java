package a1c;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.log.VideoEventListener;
import com.ss.ttvideoengine.log.VideoEventManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements VideoEventListener {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final void onEvent() {
        JSONArray r1 = VideoEventManager.instance.popAllEvents();     // Catch: JSONException -> L11
        if (r1 == null) goto L19;
        int r2 = r1.length();     // Catch: JSONException -> L11
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L20;
        JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r1, r3);     // Catch: JSONException -> L11
        if (r4 == null) goto L10;
        Log.e("LarkVideoEventListener", "onEvent: " + r4);     // Catch: JSONException -> L11
        Statistics.recordMiscLog("video_playq", r4);     // Catch: JSONException -> L11
    L10:
        r3 = r3 + 1;
        goto L6
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Log.e("LarkVideoEventListener", "VideoEventManager, onEvent exception: " + e.getMessage());
    }

    public void onEventV2(String r8) {
        Intrinsics.checkNotNullParameter(r8, "monitor_name");
        JSONArray r1 = VideoEventManager.instance.popAllEventsV2();     // Catch: JSONException -> L13
        if (r1 == null) goto L22;
        int r2 = r1.length();     // Catch: JSONException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L23;
        JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r1, r3);     // Catch: JSONException -> L13
        if (r4 == null) goto L12;
        if (TextUtils.isEmpty(r8) == true) goto L12;
        r4.putOpt("params_for_special", "videoplayer_monitor");     // Catch: JSONException -> L13
        Log.e("LarkVideoEventListener", "onEventV2: " + r4);     // Catch: JSONException -> L13
        Statistics.sendEvent(r8, r4);     // Catch: JSONException -> L13
    L12:
        r3 = r3 + 1;
        goto L6
    L23:
        return;
    L22:
        return;
    L13:
        e = move-exception;
        Log.e("LarkVideoEventListener", "VideoEventManager, onEventV2 exception: " + e.getMessage());
    }
}
