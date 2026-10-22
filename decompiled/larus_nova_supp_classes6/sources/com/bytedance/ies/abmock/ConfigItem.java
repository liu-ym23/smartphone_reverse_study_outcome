package com.bytedance.ies.abmock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConfigItem {
    public Object defaultValue;
    public boolean isAB;
    public SaveConfigType$ConfigType type;

    public ConfigItem(SaveConfigType$ConfigType r1, Object r2, boolean r3) {
        this.type = r1;
        this.defaultValue = r2;
        this.isAB = r3;
    }
}
