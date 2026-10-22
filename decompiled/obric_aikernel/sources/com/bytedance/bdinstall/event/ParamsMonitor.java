package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.common.wschannel.WsConstants;
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
        JSONObject r10 = new JSONObject();
        r10.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r10.put("duration", getDuration());     // Catch: JSONException -> L5
        r10.put(WsConstants.KEY_CONNECTION_TYPE, getType());     // Catch: JSONException -> L5
        r10.put("state", getState());     // Catch: JSONException -> L5
        r10.put("flag", getFlag());     // Catch: JSONException -> L5
    L7:
        return r10;
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
    protected void reset() {
        this.type = 0;
        this.state = 0;
        this.flag = 0;
        this.duration = 0;
    }

    public void setDuration(long r10) {
        this.duration = r10;
    }

    public void setFlag(int r10) {
        this.flag = r10;
    }

    public void setState(int r10) {
        this.state = r10;
    }

    public void setType(int r10) {
        this.type = r10;
    }
}
