package com.bytedance.ies.abmock;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, ConfigItem> f2661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, ConfigItem> f2662b;

    static {
        f2661a = new HashMap();
        f2662b = new HashMap();
        c();
    }

    public static Map<String, ConfigItem> a() {
        return f2661a;
    }

    public static Map<String, ConfigItem> b() {
        return f2662b;
    }

    private static void c() {
        f2661a.put("abmock_download_monitor_sample_2", new ConfigItem(SaveConfigType.ConfigType.INT, 50, false, false, false));
        f2661a.put("ttk_abmock_fetch_data_optimized_experiment_3", new ConfigItem(SaveConfigType.ConfigType.BOOLEAN, false, true, false, false));
    }
}
