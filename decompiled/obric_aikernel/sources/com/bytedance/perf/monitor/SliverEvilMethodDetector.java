package com.bytedance.perf.monitor;

import androidx.annotation.Keep;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SliverEvilMethodDetector {
    private static final String TAG = "EvilMethod_Detector";
    private static a mPluginInfoCallBack;
    private static JSONArray pluginInfo;

    public interface a {
    }

    static {
    }

    public SliverEvilMethodDetector() {
    }

    public static void setPluginInfo(JSONArray r10) {
        pluginInfo = r10;
    }

    public static void setPluginInfoCallback(a r10) {
        mPluginInfoCallBack = r10;
    }
}
