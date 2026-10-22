package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/ConfigType;", "", "Normal", "Dialog", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum ConfigType extends Enum<ConfigType> {
    public static final ConfigType Dialog = null;
    public static final ConfigType Normal = null;
    public static final /* synthetic */ ConfigType[] a = null;

    static {
        ConfigType r1 = new ConfigType("Normal", 0);
        Normal = r1;
        ConfigType r10 = new ConfigType("Dialog", 1);
        Dialog = r10;
        a = new ConfigType[]{r1, r10};
    }

    public static ConfigType valueOf(String r1) {
        return (ConfigType) r27.a.a(ConfigType.class, r1);
    }

    public static ConfigType[] values() {
        return (ConfigType[]) a.clone();
    }

    public ConfigType(String r1, int r10) {
        super(r1, r10);
    }
}
