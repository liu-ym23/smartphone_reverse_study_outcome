package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.NotImplementedError;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements EnvManagerApi {
    @Override // com.bytedance.env.api.EnvManagerApi
    public final void addOnEnvConfigChangeListener(f r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final b getEnvConfig() {
        return new b(null, null, 15);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final String getEnvLane() {
        return getEnvConfig().b();
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final int getEnvType() {
        EnvType r5 = getEnvConfig().a();
        Iterator r10 = d.f4196a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) r10.next();
        int r12 = ((Number) r11.getKey()).intValue();
        if (((EnvType) r11.getValue()) != r5) goto L4;
        return r12;
    L8:
        return 0;
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final e getGeckoConfig() {
        return new e(0);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void init(Context r5) {
        Log.d("env_platform_sdk", "DefaultEnvManagerApi init");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void initEnvConfig(b r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void initGeckoConfig(e r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final boolean isFloatingWindowVisible() {
        return true;
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void openDialog(Activity r5) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void reboot() {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void removeOnEnvConfigChangeListener(f r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setAutoRebootEnable(boolean r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvConfig(b r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvWindowEnable(boolean r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setFloatingWindowRemovable(boolean r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setFloatingWindowVisible(boolean r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setGeckoConfig(e r5) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvConfig(int r5, String r10) {
        EnvType r11 = (EnvType) d.f4196a.get(Integer.valueOf(r5));
        if (r11 == null) goto L6;
        new b(r11, r10, 12);
        return;
    }
}
