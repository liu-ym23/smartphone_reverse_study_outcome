package com.bytedance.crash.util;

import com.bytedance.crash.dumper.BytestConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfoUtils {
    public AppInfoUtils() {
    }

    public static void expandFilters(JSONObject r0) {
        BytestConfig.expandFilters(r0);
    }

    public static String getBytraceId() {
        return BytestConfig.getBytraceId();
    }
}
