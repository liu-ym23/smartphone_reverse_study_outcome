package com.bytedance.android.accessibilityLib_Core.config.remote.repo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/repo/ConfigFileProviderMode;", "", "LOCAL", "REMOTE_RELEASE", "REMOTE_DEVELOP", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum ConfigFileProviderMode extends Enum<ConfigFileProviderMode> {
    public static final ConfigFileProviderMode LOCAL = null;
    public static final ConfigFileProviderMode REMOTE_DEVELOP = null;
    public static final ConfigFileProviderMode REMOTE_RELEASE = null;
    public static final /* synthetic */ ConfigFileProviderMode[] a = null;

    static {
        ConfigFileProviderMode r1 = new ConfigFileProviderMode("LOCAL", 0);
        LOCAL = r1;
        ConfigFileProviderMode r10 = new ConfigFileProviderMode("REMOTE_RELEASE", 1);
        REMOTE_RELEASE = r10;
        ConfigFileProviderMode r11 = new ConfigFileProviderMode("REMOTE_DEVELOP", 2);
        REMOTE_DEVELOP = r11;
        a = new ConfigFileProviderMode[]{r1, r10, r11};
    }

    public static ConfigFileProviderMode valueOf(String r1) {
        return (ConfigFileProviderMode) a.a(ConfigFileProviderMode.class, r1);
    }

    public static ConfigFileProviderMode[] values() {
        return (ConfigFileProviderMode[]) a.clone();
    }

    public ConfigFileProviderMode(String r1, int r10) {
        super(r1, r10);
    }
}
