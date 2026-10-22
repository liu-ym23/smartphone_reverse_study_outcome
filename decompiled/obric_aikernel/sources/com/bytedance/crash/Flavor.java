package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.ActivityUtils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Flavor {
    public static final boolean isTob = false;

    public static class Tob {
        public Tob() {
        }

        public static boolean ensureEnable(String r10) {
            return false;
        }

        public static void onUpload(File r10, CrashType r11, JSONObject r12) {
        }

        public static void putSpecialCrashBody(JSONObject r10, File r11, CrashType r12) {
        }

        public static JSONArray saveAllData(CrashType r10, StackTraceElement[] r11, File r12) {
            return null;
        }

        public static JSONArray saveAllData(String r10, File r11) {
            return null;
        }
    }

    public Flavor() {
    }

    public static void dumpAppLog(File r10) {
        AlogManager.flushData();
    }

    public static void setActivityImpl() {
        ActivityUtils.setActivityImpl(new AnonymousClass3());     // Catch: Throwable -> L4
        return;
    }

    public static void startAppMonitor(Context r10, final CrashListener r11) {
        NpthCore.initForCrashMonitor(r10, Global.getRootDirectory());
        DefaultWorkThread.post(new AnonymousClass1(r11));
    }

    public static void startEventMonitor(Context r10, final CrashListener r11) {
        NpthCore.initForCrashMonitor(r10, Global.getRootDirectory());
        DefaultWorkThread.post(new AnonymousClass2(r11));
    }
}
