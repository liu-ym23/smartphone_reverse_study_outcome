package com.bytedance.ug.cloud;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f3335b;
    int c;
    String d;
    String e;
    int f;
    String g;
    JSONObject h;

    b(int r1) {
        this.c = r1;
    }

    boolean a() {
        if (this.f == 0) goto L5;
        return true;
    L5:
        return false;
    }

    JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("launch_sequence", this.c);     // Catch: JSONException -> L5
        r0.put("sdk_name", this.f3334a);     // Catch: JSONException -> L5
        r0.put("sdk_version", this.f3335b);     // Catch: JSONException -> L5
        r0.put(Ext.KEY_ACTION_ID, this.d);     // Catch: JSONException -> L5
        r0.put("message", this.e);     // Catch: JSONException -> L5
        r0.put("result", this.f);     // Catch: JSONException -> L5
        r0.put("timestamp", this.g);     // Catch: JSONException -> L5
        r0.put(WsConstants.KEY_EXTRA, this.h);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "Action{sdkName='" + this.f3334a + "', sdkVersion='" + this.f3335b + "', launchSequence=" + this.c + ", actionId='" + this.d + "', message='" + this.e + "', result=" + this.f + ", timeStamp='" + this.g + "', extra=" + this.h + '}';
    }
}
