package com.bytedance.crash.util;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityUtils {
    private static Callable<JSONArray> sActivityImpl;

    static {
    }

    public ActivityUtils() {
    }

    @Nullable
    public static JSONArray getActivityTrack() {
        Callable<JSONArray> r10 = sActivityImpl;
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.call();
    L11:
        return null;
    }

    public static void setActivityImpl(Callable<JSONArray> r10) {
        sActivityImpl = r10;
    }
}
