package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
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
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", getRegisterRequestTime());     // Catch: JSONException -> L5
        r0.put("retry_count", getRegisterFailCount());     // Catch: JSONException -> L5
        r0.put("is_first", isNewUser());     // Catch: JSONException -> L5
        r0.put("did_change", isDidChanged());     // Catch: JSONException -> L5
        r0.put("is_new_user_mode", isNewUserMode());     // Catch: JSONException -> L5
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, getScene());     // Catch: JSONException -> L5
        r0.put("result", isResult());     // Catch: JSONException -> L5
    L7:
        return r0;
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
    public void reset() {
        this.sRegisterRequestStart = 0;
        this.sRegisterRequestFinish = 0;
        this.mRegisterFailCount = 0;
        this.isDidChanged = false;
        this.isNewUser = false;
        this.result = false;
    }

    public void setDidChanged(boolean r1) {
        this.isDidChanged = r1;
    }

    public void setNewUser(boolean r1) {
        this.isNewUser = r1;
    }

    public void setNewUserMode(int r1) {
        this.isNewUserMode = r1;
    }

    public void setRegisterFailCount(int r1) {
        this.mRegisterFailCount = r1;
    }

    public void setResult(boolean r1) {
        this.result = r1;
    }

    public void setScene(int r1) {
        this.scene = r1;
    }
}
