package com.lynx.debugrouter.app;

import com.lynx.debugrouter.DebugRouter;
import com.lynx.debugrouter.log.LLog;
import com.lynx.jsbridge.LynxResourceModule;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouterEventSender {
    private static final String TAG = "MessageHandleCallback.Sender";

    public DebugRouterEventSender() {
    }

    public static void send(String r2, MessageHandleResult r3) {
        JSONObject r0 = new JSONObject();
        r0.put("method", r2);     // Catch: JSONException -> L5
        r0.put(LynxResourceModule.PARAMS_KEY, r3.toJson());     // Catch: JSONException -> L5
        DebugRouter.getInstance().sendDataAsync("CDP", -1, r0.toString());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "send failed:" + e.getMessage());
    }
}
