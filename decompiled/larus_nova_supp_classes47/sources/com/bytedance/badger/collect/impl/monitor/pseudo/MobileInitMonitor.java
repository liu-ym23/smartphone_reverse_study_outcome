package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class MobileInitMonitor extends AbsMonitor {
    private String networkType;
    private String operatorName;
    private String uuid;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_INIT;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.operatorName = "";
        this.networkType = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r0 = new JSONObject();
        r0.put("operatorName", this.operatorName);
        r0.put("networkType", this.networkType);
        r0.put("cdid", this.uuid);
        return r0;
    }

    public MobileInitMonitor() {
    }

    public void setNetworkType(String r1) {
        this.networkType = r1;
    }

    public void setOperatorName(String r1) {
        this.operatorName = r1;
    }

    public void setUUID(String r1) {
        this.uuid = r1;
    }
}
