package com.bytedance.ies.abmock;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Class> f2741a;

    static {
        f2741a = new HashMap();
        a();
    }

    private static void a() {
        f2741a.put("abmock_download_monitor_sample_2", com.bytedance.ies.abmock.fetch.d.class);
        f2741a.put("ttk_abmock_fetch_data_optimized_experiment_3", com.bytedance.ies.experiment.a.class);
    }

    public static boolean a(String r1) {
        return f2741a.containsKey(r1);
    }
}
