package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.bdinstall.util.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VerifyMonitor extends Monitor {
    private int decryptCode;
    private int mRetryCount;
    private int success;
    private Map<String, Long> timestampMap;

    public VerifyMonitor() {
        this.decryptCode = 0;
        this.mRetryCount = 0;
        this.success = 0;
    }

    public int getDecryptCode() {
        return this.decryptCode;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject r6 = new JSONObject();
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_INIT), Long.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_GET_TICKET), Long.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_HANDLE_RESPONSE), Long.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_DECRYPT), Long.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_CONSUMER_TICKET), Long.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        r6.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r6.put("result", getSuccess());     // Catch: JSONException -> L5
        r6.put("retry_count", getRetryCount());     // Catch: JSONException -> L5
        r6.put("decrypt_code", getDecryptCode());     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_INIT, r7);     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_GET_TICKET, r8);     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_HANDLE_RESPONSE, r9);     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_DECRYPT, r10);     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_CONSUMER_TICKET, r5);     // Catch: JSONException -> L5
        r6.put(Constants.TicketEvents.KEY_TICKET_TOTAL_TIME, (((r7.longValue() + r8.longValue()) + r9.longValue()) + r10.longValue()) + r5.longValue());     // Catch: JSONException -> L5
    L7:
        return r6;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public int getSuccess() {
        return this.success;
    }

    public Map<String, Long> getTimestampMap() {
        return this.timestampMap;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public void reset() {
        this.decryptCode = 0;
        this.mRetryCount = 0;
        this.success = 0;
        this.timestampMap = null;
    }

    public void setDecryptCode(int r1) {
        this.decryptCode = r1;
    }

    public void setFailCount(int r1) {
        this.mRetryCount = r1;
    }

    public void setSuccess(int r1) {
        this.success = r1;
    }

    public void setTimestampMap(Map<String, Long> r3) {
        this.timestampMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }
}
