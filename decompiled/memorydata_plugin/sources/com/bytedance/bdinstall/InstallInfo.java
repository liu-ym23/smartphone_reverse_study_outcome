package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InstallInfo implements Cloneable {
    private String clientUdid;
    private String did;
    private String eDid;
    private String eIid;
    private String egdi;
    private String iid;
    private String openUdid;
    private String ssid;

    public InstallInfo() {
        this.did = "";
        this.iid = "";
    }

    static InstallInfo parse(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L7
        InstallInfo r5 = new InstallInfo();     // Catch: JSONException -> L7
        r5.setDid(r1.optString("did", ""));     // Catch: JSONException -> L7
        r5.setIid(r1.optString("iid", ""));     // Catch: JSONException -> L7
        r5.setOpenUdid(r1.optString("openudid", ""));     // Catch: JSONException -> L7
        r5.setClientUdid(r1.optString("cliend_udid", ""));     // Catch: JSONException -> L7
        r5.setSsid(r1.optString(Api.KEY_SSID, ""));     // Catch: JSONException -> L7
        r5.setSsid(r1.optString("eDid", ""));     // Catch: JSONException -> L7
        r5.setSsid(r1.optString("eIid", ""));     // Catch: JSONException -> L7
        r5.setEgdi(r1.optString("egdi", ""));     // Catch: JSONException -> L7
        DrLog.d("aaa# parse install info " + r5);     // Catch: JSONException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public InstallInfo clone() {
        return (InstallInfo) ZeusTransformUtils.preCheckCast(super.clone(), InstallInfo.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        DrLog.e("clone error", e);
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m81clone() {
        return clone();
    }

    public String getClientUdid() {
        return this.clientUdid;
    }

    public String getDid() {
        return this.did;
    }

    public String getEDid() {
        return this.eDid;
    }

    public String getEIid() {
        return this.eIid;
    }

    public String getEgdi() {
        return this.egdi;
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

    public void setClientUdid(String r1) {
        this.clientUdid = r1;
    }

    public void setDid(String r1) {
        this.did = r1;
    }

    public void setEDid(String r1) {
        this.eDid = r1;
    }

    public void setEIid(String r1) {
        this.eIid = r1;
    }

    public void setEgdi(String r1) {
        this.egdi = r1;
    }

    public void setIid(String r1) {
        this.iid = r1;
    }

    public void setOpenUdid(String r1) {
        this.openUdid = r1;
    }

    public void setSsid(String r1) {
        this.ssid = r1;
    }

    JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put("did", this.did);     // Catch: JSONException -> L5
        r0.put("iid", this.iid);     // Catch: JSONException -> L5
        r0.put("openudid", this.openUdid);     // Catch: JSONException -> L5
        r0.put("cliend_udid", this.clientUdid);     // Catch: JSONException -> L5
        r0.put(Api.KEY_SSID, this.ssid);     // Catch: JSONException -> L5
        r0.put("eDid", this.eDid);     // Catch: JSONException -> L5
        r0.put("eIid", this.eIid);     // Catch: JSONException -> L5
        r0.put("egdi", this.egdi);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "{d='" + this.did + "', i='" + this.iid + "', o='" + this.openUdid + "', c='" + this.clientUdid + "', s='" + this.ssid + "', eDid='" + this.eDid + "', eIid='" + this.eIid + "', e='" + this.egdi + "'}";
    }
}
