package com.bytedance.perf.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void setPluginInfo(JSONArray r0) {
        pluginInfo = r0;
    }

    public static void setPluginInfoCallback(a r2) {
        mPluginInfoCallBack = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
    }
}
