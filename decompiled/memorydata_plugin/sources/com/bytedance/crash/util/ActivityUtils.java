package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityUtils {
    private static Callable<JSONArray> sActivityImpl;

    static {
    }

    public ActivityUtils() {
    }

    public static JSONArray getActivityTrack() {
        Callable<JSONArray> r0 = sActivityImpl;
        if (r0 != null) goto L9;
        return null;
    L9:
        return (JSONArray) ZeusTransformUtils.preCheckCast(r0.call(), JSONArray.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    public static void setActivityImpl(Callable<JSONArray> r2) {
        sActivityImpl = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
    }
}
