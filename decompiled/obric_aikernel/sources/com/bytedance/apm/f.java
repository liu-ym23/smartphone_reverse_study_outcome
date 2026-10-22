package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f implements t4.i, u4.a, t4.d, q0.b.e {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    public f() {
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    @WorkerThread
    public void destroy() {
        ensureUnregisterForSafety();
    }

    public boolean getConfigBool(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r11 = this.mConfigData;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.optBoolean(r10);
    L9:
        return false;
    }

    public int getConfigInt(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r12 = this.mConfigData;
        if (r12 == null) goto L9;
        return r12.optInt(r10, r11);
    L9:
        return r11;
    }

    @Nullable
    public JSONObject getConfigJSON(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r11 = this.mConfigData;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.optJSONObject(r10);
    L9:
        return null;
    }

    public boolean getLogTypeSwitch(String r10) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getMetricTypeSwitch(String r10) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getServiceSwitch(String r10) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public String getTag() {
        return "base";
    }

    @Override // t4.i
    @WorkerThread
    public void init(Context r10) {
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    protected boolean isFront() {
        return this.mIsFront;
    }

    @Override // t4.i
    public abstract boolean isOnlyMainProcess();

    @Override // t4.d
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // t4.d
    public void onActivityPause(Activity r10) {
    }

    @Override // t4.d
    public void onActivityResume(Activity r10) {
    }

    @Override // t4.d
    public void onActivityStarted(Activity r10) {
    }

    @Override // t4.d
    public void onBackground(Activity r10) {
        this.mIsFront = false;
    }

    @Override // t4.d
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // t4.d
    public void onFront(Activity r10) {
        this.mIsFront = true;
    }

    @Override // u4.a
    public void onReady() {
        this.mConfigReady = true;
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        this.mConfigData = r10;
        JSONObject r12 = r10.optJSONObject("custom_event_settings");
        if (r12 == null) goto L6;
        this.mAllowLogType = r12.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        this.mMetricType = r12.optJSONObject("allow_metric_type");
        this.mAllowService = r12.optJSONObject("allow_service_name");
        return;
    }

    @Override // q0.b.e
    public void onTimeEvent(long r10) {
    }

    protected final boolean registerAppLifeCycle() {
        IActivityLifeManager r10 = (IActivityLifeManager) c4.d.a(IActivityLifeManager.class);
        if (r10 == null) goto L6;
        r10.register(this);
        return true;
    L6:
        return false;
    }

    protected final boolean registerConfigService() {
        IConfigManager r10 = (IConfigManager) c4.d.a(IConfigManager.class);
        if (r10 == null) goto L6;
        r10.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final void registerTimerTask() {
        q0.b.f().c(this);
    }

    @Override // t4.i
    @WorkerThread
    public void start() {
    }

    @WorkerThread
    public void stop() {
    }

    protected final boolean unregisterAppLifeCycle() {
        IActivityLifeManager r10 = (IActivityLifeManager) c4.d.a(IActivityLifeManager.class);
        if (r10 == null) goto L6;
        r10.unregister(this);
        return true;
    L6:
        return false;
    }

    protected final boolean unregisterConfigService() {
        IConfigManager r10 = (IConfigManager) c4.d.a(IConfigManager.class);
        if (r10 == null) goto L6;
        r10.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    protected final void unregisterTimerTask() {
        q0.b.f().m(this);
    }
}
