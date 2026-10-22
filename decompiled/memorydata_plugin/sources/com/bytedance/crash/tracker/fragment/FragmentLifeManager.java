package com.bytedance.crash.tracker.fragment;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentLifeManager {
    public FragmentLifeManager() {
    }

    public static void dump(File r0) {
    }

    public static void load(JSONObject r0, File r1) {
    }

    public static void register(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public static void unregister(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
