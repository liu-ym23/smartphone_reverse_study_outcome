package com.bytedance.bdinstall;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InstallInfo implements Cloneable {
    private String clientUdid;
    private String did;
    private String iid;
    private String openUdid;
    private String ssid;

    public InstallInfo() {
        this.did = "";
        this.iid = "";
    }

    static InstallInfo parse(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L7
        InstallInfo r12 = new InstallInfo();     // Catch: JSONException -> L7
        r12.setDid(r11.optString("did", ""));     // Catch: JSONException -> L7
        r12.setIid(r11.optString("iid", ""));     // Catch: JSONException -> L7
        r12.setOpenUdid(r11.optString("openudid", ""));     // Catch: JSONException -> L7
        r12.setClientUdid(r11.optString("cliend_udid", ""));     // Catch: JSONException -> L7
        r12.setSsid(r11.optString(Api.KEY_SSID, ""));     // Catch: JSONException -> L7
        return r12;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public InstallInfo clone() {
        return (InstallInfo) super.clone();
    L4:
        e = move-exception;
        DrLog.e("clone error", e);
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10clone() {
        return clone();
    }

    public String getClientUdid() {
        return this.clientUdid;
    }

    public String getDid() {
        return this.did;
    }

    public String getIid() {
        return this.iid;
    }

    public String getOpenUdid() {
        return this.openUdid;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setClientUdid(String r10) {
        this.clientUdid = r10;
    }

    public void setDid(String r10) {
        this.did = r10;
    }

    public void setIid(String r10) {
        this.iid = r10;
    }

    public void setOpenUdid(String r10) {
        this.openUdid = r10;
    }

    public void setSsid(String r10) {
        this.ssid = r10;
    }

    JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        r10.put("did", this.did);     // Catch: JSONException -> L5
        r10.put("iid", this.iid);     // Catch: JSONException -> L5
        r10.put("openudid", this.openUdid);     // Catch: JSONException -> L5
        r10.put("cliend_udid", this.clientUdid);     // Catch: JSONException -> L5
        r10.put(Api.KEY_SSID, this.ssid);     // Catch: JSONException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "{d='" + this.did + "', i='" + this.iid + "', o='" + this.openUdid + "', c='" + this.clientUdid + "', s='" + this.ssid + "'}";
    }
}
