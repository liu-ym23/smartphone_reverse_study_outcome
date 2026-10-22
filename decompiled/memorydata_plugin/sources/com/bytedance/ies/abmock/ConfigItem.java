package com.bytedance.ies.abmock;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigItem {
    public Object defaultValue;
    public boolean isAB;
    public boolean isHybrid;
    public boolean isLaunch;
    public SaveConfigType.ConfigType type;

    public ConfigItem(SaveConfigType.ConfigType r1, Object r2, boolean r3) {
        this.type = r1;
        this.defaultValue = r2;
        this.isAB = r3;
    }

    public ConfigItem(SaveConfigType.ConfigType r1, Object r2, boolean r3, boolean r4) {
        this.type = r1;
        this.defaultValue = r2;
        this.isAB = r3;
        this.isHybrid = r4;
    }

    public ConfigItem(SaveConfigType.ConfigType r1, Object r2, boolean r3, boolean r4, boolean r5) {
        this.type = r1;
        this.defaultValue = r2;
        this.isAB = r3;
        this.isLaunch = r4;
        this.isHybrid = r5;
    }
}
