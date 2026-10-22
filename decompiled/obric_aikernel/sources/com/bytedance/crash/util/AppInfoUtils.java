package com.bytedance.crash.util;

import com.bytedance.crash.dumper.BytestConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppInfoUtils {
    public AppInfoUtils() {
    }

    public static void expandFilters(JSONObject r10) {
        BytestConfig.expandFilters(r10);
    }

    public static String getBytraceId() {
        return BytestConfig.getBytraceId();
    }
}
