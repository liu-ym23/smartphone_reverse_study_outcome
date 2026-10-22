package com.bytedance.bdinstall.dtrait.model;

import android.util.Log;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExtraLoaderInfo {
    private String data;
    private long duration;
    private String errorMsg;
    private int index;
    private String name;
    private final JSONObject result;

    public ExtraLoaderInfo() {
        this.result = new JSONObject();
    }

    public String getData() {
        return this.data;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public JSONObject getResult() {
        return this.result;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setDuration(long r1) {
        this.duration = r1;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void toJSON() {
        this.result.putOpt("duration", Long.valueOf(this.duration));     // Catch: JSONException -> L13
        if (DTraitConstant.D_I0.equals(this.name) == false) goto L6;
    L10:
        JSONObject r0 = this.result;     // Catch: JSONException -> L13
        Object r2 = new JSONObject(this.data);     // Catch: JSONException -> L13
    L9:
        r0.putOpt("data", r2);     // Catch: JSONException -> L13
        this.result.putOpt(DTraitConstant.ERROR, this.errorMsg);     // Catch: JSONException -> L13
        return;
    L6:
        if (DTraitConstant.D_A0.equals(this.name) == true) goto L10;
        r0 = this.result;     // Catch: JSONException -> L13
        r2 = this.data;     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        DTLog.d("[dt]  json error " + Log.getStackTraceString(e));
    }

    public String toString() {
        return "FingerInfo{name='" + this.name + "', duration=" + this.duration + ", data='" + this.data + "', error='" + this.errorMsg + "'}";
    }
}
