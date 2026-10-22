package com.bytedance.bdlocation.entity.bpea;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BPEACertCheckResult {
    private int code;
    private String msg;
    private JSONObject params;

    public BPEACertCheckResult() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public void setCode(int r8) {
        this.code = r8;
    }

    public void setMsg(String r8) {
        this.msg = r8;
    }

    public void setParams(JSONObject r8) {
        this.params = r8;
    }
}
