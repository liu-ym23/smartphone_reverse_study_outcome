package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class MobileReportMonitor extends AbsMonitor {
    private String data;
    private String errorMsg;
    private long finishTime;
    private String logId;
    private boolean result;
    private long startTime;
    private String uuid;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_REPORT;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.data = "";
        this.result = false;
        this.startTime = 0;
        this.finishTime = 0;
        this.errorMsg = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r0 = new JSONObject();
        long r1 = this.finishTime - this.startTime;
        if (r1 >= 0) goto L6;
        r1 = -1;
    L6:
        r0.put(Constants.Keys.duration, r1);
        r0.put("result", this.result);
        r0.put(Constants.Keys.ERROR, this.errorMsg);
        r0.put(Constants.Keys.DATA, this.data);
        r0.put("logId", this.logId);
        return r0;
    }

    public void setFinishTime() {
        this.finishTime = System.currentTimeMillis();
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public MobileReportMonitor() {
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setLogId(String r1) {
        this.logId = r1;
    }

    public void setResult(boolean r1) {
        this.result = r1;
    }

    public void setUUID(String r1) {
        this.uuid = r1;
    }
}
