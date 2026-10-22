package com.lynx.debugrouter;

import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.log.LLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MessageHandlerDelegate implements MessageHandler {
    private static final String TAG = "MessageHandlerDelegate";
    private MessageHandler handler;

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return this.handler.getName();
    }

    public MessageHandlerDelegate(MessageHandler r1) {
        this.handler = r1;
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r3) {
        LLog.i(TAG, "handle: " + r3);
        return this.handler.handle(r3);
    }

    public String handleAppAction(String r6) {
        HashMap r0 = new HashMap();
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L14
        Iterator<String> r2 = r1.keys();     // Catch: JSONException -> L14
    L5:
        if (r2.hasNext() == false) goto L8;
        String r3 = r2.next();     // Catch: JSONException -> L14
        r0.put(r3, r1.optString(r3));     // Catch: JSONException -> L14
        goto L5
    L8:
        MessageHandleResult r7 = handle(r0);
        if (r7 != null) goto L13;
        return new MessageHandleResult().toJsonString();
    L13:
        return r7.toJsonString();
    L14:
        LLog.e(TAG, "params resolve error:" + r6);
        return new MessageHandleResult(-1, "params resolve error").toJsonString();
    }
}
