package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.ActivityUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Flavor {
    public static final boolean isTob = false;

    public static class Tob {
        public Tob() {
        }

        public static boolean ensureEnable(String r0) {
            return false;
        }

        public static void onUpload(File r0, CrashType r1, JSONObject r2) {
        }

        public static void putSpecialCrashBody(JSONObject r0, File r1, CrashType r2) {
        }

        public static JSONArray saveAllData(CrashType r0, StackTraceElement[] r1, File r2) {
            return null;
        }

        public static JSONArray saveAllData(String r0, File r1) {
            return null;
        }
    }

    public Flavor() {
    }

    public static void dumpAppLog(File r0) {
        AlogManager.flushData();
    }

    public static void setActivityImpl() {
        ActivityUtils.setActivityImpl(new AnonymousClass3());     // Catch: Throwable -> L4
        return;
    }

    public static void startAppMonitor(Context r2, final CrashListener r3) {
        NpthCore.initForCrashMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), Global.getRootDirectory());
        DefaultWorkThread.post(new AnonymousClass1(r3));
    }

    public static void startEventMonitor(Context r2, final CrashListener r3) {
        NpthCore.initForCrashMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), Global.getRootDirectory());
        DefaultWorkThread.post(new AnonymousClass2(r3));
    }
}
