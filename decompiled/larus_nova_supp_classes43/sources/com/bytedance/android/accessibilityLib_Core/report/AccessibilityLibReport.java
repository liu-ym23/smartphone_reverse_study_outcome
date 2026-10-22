package com.bytedance.android.accessibilityLib_Core.report;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AccessibilityLibReport {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/report/AccessibilityLibReport$ConfigType;", "", "local", "dynamic", "xml", "remote", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
    public static final enum ConfigType extends Enum<ConfigType> {
        public static final /* synthetic */ ConfigType[] a = null;
        public static final ConfigType dynamic = null;
        public static final ConfigType local = null;
        public static final ConfigType remote = null;
        public static final ConfigType xml = null;

        static {
            ConfigType r1 = new ConfigType("local", 0);
            local = r1;
            ConfigType r10 = new ConfigType("dynamic", 1);
            dynamic = r10;
            ConfigType r11 = new ConfigType("xml", 2);
            xml = r11;
            ConfigType r12 = new ConfigType("remote", 3);
            remote = r12;
            a = new ConfigType[]{r1, r10, r11, r12};
        }

        public static ConfigType valueOf(String r1) {
            return (ConfigType) a.a(ConfigType.class, r1);
        }

        public static ConfigType[] values() {
            return (ConfigType[]) a.clone();
        }

        public ConfigType(String r1, int r10) {
            super(r1, r10);
        }
    }

    static {
    }
}
