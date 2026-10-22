package com.ss.android.lark.opmonitor.model;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OPMonitorCode {
    private static final String TAG = "OPMonitorCode";
    public String ID;
    public int code;
    public String domain;
    public OPMonitorLevel level;
    public String message;
    private int version;

    private String generateID() {
        return this.version + "-" + this.domain + "-" + this.code;
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    public static OPMonitorCode fromJson(String r5) {
        JSONObject r0 = new JSONObject(r5);     // Catch: JSONException -> L4
        return new OPMonitorCode(JSONObjectProtectorUtils.getString(r0, "domain"), JSONObjectProtectorUtils.getInt(r0, "code"), OPMonitorLevel.forNumber(JSONObjectProtectorUtils.getInt(r0, "level")), JSONObjectProtectorUtils.getString(r0, "message"));
    L4:
        e = move-exception;
        Log.e(TAG, "fromJson is exception", e);
        return null;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof OPMonitorCode) == true) goto L10;
        return false;
    L10:
        return this.ID.equals(((OPMonitorCode) r2).ID);
    }

    public OPMonitorCode(String r2, int r3, OPMonitorLevel r4, String r5) {
        this.version = 1;
        this.domain = r2;
        this.code = r3;
        this.level = r4;
        this.message = r5;
        this.ID = generateID();
    }
}
