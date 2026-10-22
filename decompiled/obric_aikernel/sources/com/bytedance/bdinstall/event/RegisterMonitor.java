package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RegisterMonitor extends Monitor {
    private boolean isDidChanged;
    private boolean isNewUser;
    private int isNewUserMode;
    private int mRegisterFailCount;
    private boolean result;
    private long sRegisterRequestFinish;
    private long sRegisterRequestStart;
    private int scene;

    public RegisterMonitor() {
        this.sRegisterRequestStart = 0;
        this.sRegisterRequestFinish = 0;
        this.mRegisterFailCount = 0;
        this.isDidChanged = false;
        this.isNewUser = false;
        this.isNewUserMode = 0;
        this.scene = 0;
        this.result = false;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject r10 = new JSONObject();
        r10.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r10.put("duration", getRegisterRequestTime());     // Catch: JSONException -> L5
        r10.put("retry_count", getRegisterFailCount());     // Catch: JSONException -> L5
        r10.put("is_first", isNewUser());     // Catch: JSONException -> L5
        r10.put("did_change", isDidChanged());     // Catch: JSONException -> L5
        r10.put("is_new_user_mode", isNewUserMode());     // Catch: JSONException -> L5
        r10.put("scene", getScene());     // Catch: JSONException -> L5
        r10.put("result", isResult());     // Catch: JSONException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public long getRegisterFailCount() {
        return this.mRegisterFailCount;
    }

    public long getRegisterRequestTime() {
        return this.sRegisterRequestFinish - this.sRegisterRequestStart;
    }

    public int getScene() {
        return this.scene;
    }

    public boolean isDidChanged() {
        return this.isDidChanged;
    }

    public boolean isNewUser() {
        return this.isNewUser;
    }

    public int isNewUserMode() {
        return this.isNewUserMode;
    }

    public boolean isResult() {
        return this.result;
    }

    public void onRegisterRequestFinish() {
        if (this.sRegisterRequestFinish <= 0) goto L5;
        return;
    L5:
        this.sRegisterRequestFinish = System.currentTimeMillis();
    }

    public void onRegisterRequestStart() {
        if (this.sRegisterRequestStart <= 0) goto L5;
        return;
    L5:
        this.sRegisterRequestStart = System.currentTimeMillis();
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected void reset() {
        this.sRegisterRequestStart = 0;
        this.sRegisterRequestFinish = 0;
        this.mRegisterFailCount = 0;
        this.isDidChanged = false;
        this.isNewUser = false;
        this.result = false;
    }

    public void setDidChanged(boolean r10) {
        this.isDidChanged = r10;
    }

    public void setNewUser(boolean r10) {
        this.isNewUser = r10;
    }

    public void setNewUserMode(int r10) {
        this.isNewUserMode = r10;
    }

    public void setRegisterFailCount(int r10) {
        this.mRegisterFailCount = r10;
    }

    public void setResult(boolean r10) {
        this.result = r10;
    }

    public void setScene(int r10) {
        this.scene = r10;
    }
}
