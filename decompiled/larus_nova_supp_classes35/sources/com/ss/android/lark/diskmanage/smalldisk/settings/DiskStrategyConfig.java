package com.ss.android.lark.diskmanage.smalldisk.settings;

import android.os.Environment;
import com.alibaba.fastjson.JSON;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.diskmanage.NonProguard;
import com.ss.android.lark.framework.assembly.diskmange.DiskManageModuleDependencyInitor;
import com.ss.android.lark.log.Log;
import dbb.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DiskStrategyConfig implements NonProguard {
    private float cleanThresholdFactor;
    private float diskCacheFactor;
    private long diskThreshold;
    private boolean strategySwitch;
    private float timeoutFactor;

    public String toString() {
        return "DiskStrategyConfig{strategySwitch=" + this.strategySwitch + ", diskThreshold=" + this.diskThreshold + ", cleanThresholdFactor=" + this.cleanThresholdFactor + ", diskCacheFactor=" + this.diskCacheFactor + ", timeoutFactor=" + this.timeoutFactor + '}';
    }

    public DiskStrategyConfig() {
        this.strategySwitch = false;
        this.diskThreshold = 0;
        this.cleanThresholdFactor = 0.7f;
        this.diskCacheFactor = 0.7f;
        this.timeoutFactor = 0.5f;
    }

    public float getCleanThresholdFactor() {
        return this.cleanThresholdFactor;
    }

    public float getDiskCacheFactor() {
        return this.diskCacheFactor;
    }

    public long getDiskThreshold() {
        return this.diskThreshold;
    }

    public boolean getStrategySwitch() {
        return this.strategySwitch;
    }

    public float getTimeoutFactor() {
        return this.timeoutFactor;
    }

    public static DiskStrategyConfig parse(String r10) {
        DiskManageModuleDependencyInitor.a r3 = a.b();
        DiskStrategyConfig r11 = (DiskStrategyConfig) JSON.parseObject(JSONObjectProtectorUtils.getString(new JSONObject(r10), "DiskStrategyConfig"), DiskStrategyConfig.class);     // Catch: Exception -> L11
        if (r11.strategySwitch == true) goto L6;
    L8:
        boolean r5 = false;
    L9:
        r3.getClass();     // Catch: Exception -> L11
        eac.a.a().putBoolean("small_disk_on", r5);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_factor", r11.diskCacheFactor);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_clean_factor", r11.cleanThresholdFactor);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_timeout_factor", r11.timeoutFactor);     // Catch: Exception -> L11
        Log.i("DiskStrategyConfig", "inSmallDiskMode =" + r5 + ", diskCacheFactor = " + r11.diskCacheFactor + ", cleanThresholdFactor = " + r11.cleanThresholdFactor + ", timeoutFactor = " + r11.timeoutFactor);     // Catch: Exception -> L11
        return r11;
    L6:
        if (Environment.getDataDirectory().getFreeSpace() >= r11.diskThreshold) goto L8;
        r5 = true;
    L11:
        e = move-exception;
        Log.e("DiskStrategyConfig", "parse fail. ", e);
        if (r3 == null) goto L16;
        eac.a.a().putBoolean("small_disk_on", false);
    L16:
        return new DiskStrategyConfig();
    }

    public void setCleanThresholdFactor(float r1) {
        this.cleanThresholdFactor = r1;
    }

    public void setDiskCacheFactor(float r1) {
        this.diskCacheFactor = r1;
    }

    public void setDiskThreshold(long r1) {
        this.diskThreshold = r1;
    }

    public void setStrategySwitch(boolean r1) {
        this.strategySwitch = r1;
    }

    public void setTimeoutFactor(float r1) {
        this.timeoutFactor = r1;
    }
}
