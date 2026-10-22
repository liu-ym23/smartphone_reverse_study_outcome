package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivateMonitor extends Monitor {
    private boolean isFirstActivate;
    private int isNewUserMode;
    private boolean result;
    private long sActivateFailCount;
    private long sActivateRequestFinish;
    private long sActivateRequestStart;
    private int scene;

    public ActivateMonitor() {
        this.sActivateRequestStart = 0;
        this.sActivateRequestFinish = 0;
        this.sActivateFailCount = 0;
        this.isFirstActivate = false;
        this.isNewUserMode = 0;
        this.scene = 0;
        this.result = false;
    }

    public long getActivateFailCount() {
        return this.sActivateFailCount;
    }

    public long getActivateRequestTime() {
        return this.sActivateRequestFinish - this.sActivateRequestStart;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject r0 = new JSONObject();
        r0.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r0.put("duration", getActivateRequestTime());     // Catch: JSONException -> L5
        r0.put("retry_count", getActivateFailCount());     // Catch: JSONException -> L5
        r0.put("is_first", isFirstActivate());     // Catch: JSONException -> L5
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

    public int getScene() {
        return this.scene;
    }

    public boolean isFirstActivate() {
        return this.isFirstActivate;
    }

    public int isNewUserMode() {
        return this.isNewUserMode;
    }

    public boolean isResult() {
        return this.result;
    }

    public void onActivateRequestFinish() {
        if (this.sActivateRequestFinish <= 0) goto L5;
        return;
    L5:
        this.sActivateRequestFinish = System.currentTimeMillis();
    }

    public void onActivateRequestStart() {
        if (this.sActivateRequestStart <= 0) goto L5;
        return;
    L5:
        this.sActivateRequestStart = System.currentTimeMillis();
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public void reset() {
        this.sActivateRequestStart = 0;
        this.sActivateRequestFinish = 0;
        this.sActivateFailCount = 0;
        this.isFirstActivate = false;
        this.result = false;
    }

    public void setActivateFailCount(long r1) {
        this.sActivateFailCount = r1;
    }

    public void setFirstActivate(boolean r1) {
        this.isFirstActivate = r1;
    }

    public void setNewUserMode(int r1) {
        this.isNewUserMode = r1;
    }

    public void setResult(boolean r1) {
        this.result = r1;
    }

    public void setScene(int r1) {
        this.scene = r1;
    }
}
