package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class MobileWifiSwitchMonitor extends AbsMonitor {
    private boolean cellularToWifiResult;
    private String errorMsg;
    private long finishSwitchCellularTime;
    private long releaseCellularTime;
    private long startSwitchCellularTime;
    private String uuid;
    private boolean wifiToCellularResult;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.wifiToCellularResult = false;
        this.cellularToWifiResult = false;
        this.startSwitchCellularTime = 0;
        this.finishSwitchCellularTime = 0;
        this.releaseCellularTime = 0;
        this.errorMsg = "";
        this.uuid = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_WIFI_SWITCH;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r0 = new JSONObject();
        r0.put("wifi_to_cellular_result", this.wifiToCellularResult);
        r0.put("cellular_to_wifi_result", this.cellularToWifiResult);
        r0.put(Constants.Keys.ERROR, this.errorMsg);
        r0.put("start_switch_cellular_timestamp", this.startSwitchCellularTime);
        r0.put("finish_switch_cellular_timestamp", this.finishSwitchCellularTime);
        r0.put("release_cellular_timestamp", this.releaseCellularTime);
        long r1 = this.finishSwitchCellularTime;
        long r3 = this.startSwitchCellularTime;
        long r5 = r1 - r3;
        long r7 = this.releaseCellularTime;
        long r4 = r7 - r3;
        long r8 = r7 - r1;
        if (r5 >= 0) goto L6;
        r5 = -1;
    L6:
        r0.put("wifi_switch_cellular_duration", r5);
        if (r8 >= 0) goto L10;
        r8 = -1;
    L10:
        r0.put("network_duration", r8);
        if (r4 >= 0) goto L14;
        r4 = -1;
    L14:
        r0.put(Constants.Keys.duration, r4);
        r0.put("cdid", this.uuid);
        return r0;
    }

    public void setFinishTime() {
        this.finishSwitchCellularTime = System.currentTimeMillis();
    }

    public void setReleaseCellularTime() {
        this.releaseCellularTime = System.currentTimeMillis();
    }

    public void setStartTime() {
        this.startSwitchCellularTime = System.currentTimeMillis();
    }

    public MobileWifiSwitchMonitor() {
    }

    public void setCellularToWifiResult(boolean r1) {
        this.cellularToWifiResult = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setUUID(String r1) {
        this.uuid = r1;
    }

    public void setWifiToCellularResult(boolean r1) {
        this.wifiToCellularResult = r1;
    }
}
