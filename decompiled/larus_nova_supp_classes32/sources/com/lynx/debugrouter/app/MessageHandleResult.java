package com.lynx.debugrouter.app;

import com.lynx.debugrouter.log.LLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MessageHandleResult {
    public static final int CODE_HANDLE_FAILED = -1;
    public static final int CODE_HANDLE_SUCCESSFULLY = 0;
    public static final int CODE_NOT_IMPLEMENTED = -2;
    private static final String TAG = "Result";
    private final Map<String, Object> data;
    private int mCode;
    private String mMessage;

    public MessageHandleResult() {
        this(null);
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(LynxResourceModule.CODE_KEY, this.mCode).put("message", this.mMessage);     // Catch: JSONException -> L8
        Iterator<Map.Entry<String, Object>> r1 = this.data.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Object> r2 = r1.next();     // Catch: JSONException -> L8
        r0.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        LLog.e(TAG, "toJsonString error:" + e.getMessage());
        goto L10
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public MessageHandleResult(Map<String, Object> r3) {
        this(0, NameKeys.UnloadStrategy_No_Strategy, r3);
    }

    public MessageHandleResult(int r2, String r3) {
        this(r2, r3, null);
    }

    public MessageHandleResult(int r2, String r3, Map<String, Object> r4) {
        this.mCode = -2;
        this.mMessage = "not implemented";
        HashMap r0 = new HashMap();
        this.data = r0;
        this.mCode = r2;
        this.mMessage = r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.size() <= 0) goto L9;
        r0.putAll(r4);
        return;
    }
}
