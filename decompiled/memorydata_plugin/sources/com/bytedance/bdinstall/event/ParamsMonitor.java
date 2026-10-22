package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ParamsMonitor extends Monitor {
    private long duration;
    private int flag;
    private int state;
    private int type;

    public ParamsMonitor() {
        this.type = 0;
        this.state = 0;
        this.flag = 0;
        this.duration = 0;
    }

    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", getDuration());     // Catch: JSONException -> L5
        r0.put("type", getType());     // Catch: JSONException -> L5
        r0.put("state", getState());     // Catch: JSONException -> L5
        r0.put("flag", getFlag());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public int getFlag() {
        return this.flag;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public void reset() {
        this.type = 0;
        this.state = 0;
        this.flag = 0;
        this.duration = 0;
    }

    public void setDuration(long r1) {
        this.duration = r1;
    }

    public void setFlag(int r1) {
        this.flag = r1;
    }

    public void setState(int r1) {
        this.state = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
