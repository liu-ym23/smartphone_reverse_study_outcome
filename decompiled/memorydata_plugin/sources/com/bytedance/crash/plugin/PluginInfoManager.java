package com.bytedance.crash.plugin;

import android.os.Process;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.mira.NpthMira;
import com.bytedance.crash.mira.NpthMiraApi;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.JSONWriter;
import com.example.npth_morpheus.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PluginInfoManager {
    private static final long DELAY_MILLIS = 1000;
    private static final String DIRECTORY = "plugin";
    public static final String MIRA_INIT = "mira_init";
    private static final String SUFFIX = ".json";
    private static File sCurrentFile;
    private static File sDirectory;
    private static final Pattern sFileNamePattern = null;
    private static long sLastUpdatedTime;

    static {
        sFileNamePattern = Pattern.compile("^(\\d+)-(\\d+)\\.json");
    }

    public PluginInfoManager() {
    }

    static /* synthetic */ void access$000() {
        postUpdate();
    }

    static /* synthetic */ void access$100() {
        clean();
    }

    static /* synthetic */ void access$200() {
        update();
    }

    private static void clean() {
        File r0 = getDirectory();
        if (r0 != null) goto L5;
        return;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.length == 0) goto L69;
        long r2 = System.currentTimeMillis();
        ArrayList r3 = new ArrayList();
        File[] r4 = new File("/proc").listFiles();
        int r5 = 0;
        if (r4 != null) goto L13;
    L20:
        ArrayList r6 = new ArrayList();
        File r7 = CrashManager.getRootDirectory();
        if (r7 == null) goto L29;
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L29;
        if (r8.length == 0) goto L29;
        int r9 = r8.length;
        int r10 = 0;
    L27:
        if (r10 >= r9) goto L29;
        r6.add(r8[r10].getName() + SUFFIX);
        r10 = r10 + 1;
    L29:
        File[] r11 = new File(Global.getRootDirectory(), AnrManager.ANR_ROOT_DIR).listFiles();
        if (r11 != null) goto L32;
    L36:
        int r12 = r1.length;
    L37:
        if (r5 >= r12) goto L70;
        File r13 = r1[r5];
        String r14 = r13.getName();
        if (r6.contains(r14) == true) goto L56;
        Matcher r15 = sFileNamePattern.matcher(r14);
        if (r15.find() == true) goto L44;
    L55:
        FileSystemUtils.deleteAll(r13);
        goto L56
    L44:
        if (r15.groupCount() != 2) goto L55;
        String r16 = r15.group(1);
        long r17 = 0;
        if (r16 == null) goto L48;
        r17 = Long.parseLong(r16);
    L48:
        String r18 = r15.group(2);
        if (r17 == Global.getAppStartTime()) goto L56;
        if (r17 > r2) goto L56;
        if (r3.contains(r18) == false) goto L55;
    L56:
        r5 = r5 + 1;
        goto L37
    L70:
        return;
    L32:
        if (r11.length == 0) goto L36;
        int r19 = r11.length;
        int r20 = 0;
    L34:
        if (r20 >= r19) goto L36;
        r6.add(r11[r20].getName() + SUFFIX);
        r20 = r20 + 1;
        goto L34
    L13:
        if (r4.length == 0) goto L20;
        int r21 = r4.length;
        int r22 = 0;
    L15:
        if (r22 >= r21) goto L20;
        File r23 = r4[r22];
        if (isNumeric(r23.getName()) == false) goto L19;
        r3.add(r23.getName());
    L19:
        r22 = r22 + 1;
        goto L15
    }

    private static File getDirectory() {
        if (sDirectory != null) goto L8;
        File r0 = Global.getRootDirectory();
        if (r0 == null) goto L8;
        sDirectory = FileSystemUtils.createDirectory(r0, "plugin");
    L8:
        return sDirectory;
    }

    private static File getFile() {
        if (sCurrentFile != null) goto L8;
        long r0 = Global.getAppStartTime();
        int r2 = Process.myPid();
        File r3 = getDirectory();
        if (r3 == null) goto L8;
        sCurrentFile = new File(r3, r0 + "-" + r2 + SUFFIX);
    L8:
        return sCurrentFile;
    }

    public static JSONArray getPluginInfo() {
        return NpthMiraApi.getPluginInfo();
    }

    private static File getSavedFile(String r3) {
        File r0 = getDirectory();
        if (r0 != null) goto L5;
        return null;
    L5:
        return new File(r0, r3 + SUFFIX);
    }

    public static void init() {
        a.a();     // Catch: Throwable -> L6
    L10:
        NpthMira.init();     // Catch: Throwable -> L7
    L4:
        NpthMiraApi.registerMiraCallback(new AnonymousClass1());
        DefaultWorkThread.postDelayed(new AnonymousClass2(), 1000);
    }

    private static boolean isNumeric(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L12;
        char r2 = r4.charAt(r1);
        if (r2 < '0') goto L11;
        if (r2 > '9') goto L11;
        r1 = r1 + 1;
    L11:
        return false;
    L12:
        return true;
    }

    private static void postUpdate() {
        long r0 = System.currentTimeMillis();
        long r2 = sLastUpdatedTime;
        if (r2 != 0) goto L5;
    L6:
        sLastUpdatedTime = r0;
        DefaultWorkThread.postDelayed(new AnonymousClass3(), 1000);
        return;
    L5:
        if ((r0 - r2) > 1000) goto L6;
    }

    public static void pushTo(JSONObject r4) {
        if (NpthMiraApi.miraInited() == true) goto L6;
        JSONUtils.put(r4, MIRA_INIT, false);
        return;
    L6:
        JSONArray r0 = NpthMiraApi.getPluginInfo();
        if (r0 != null) goto L9;
    L12:
        JSONUtils.put(r4, MIRA_INIT, false);
        return;
    L9:
        if (r0.length() == 0) goto L12;
        JSONUtils.put(r4, "plugin_info", r0);     // Catch: Throwable -> L14
        JSONUtils.put(r4, MIRA_INIT, true);     // Catch: Throwable -> L14
    }

    public static void pushTo(JSONObject r1, File r2) {
        File r3 = getSavedFile(r2.getName());
        if (r3 != null) goto L5;
    L12:
        JSONUtils.put(r1, MIRA_INIT, false);
        return;
    L5:
        if (r3.exists() == false) goto L12;
        String r4 = FileSystemUtils.readUtf8File(r3);
        if (r4 == null) goto L12;
        JSONUtils.combineJson(r1, new JSONObject(r4));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        NpthMonitor.reportInnerException("pushTo", th);
        goto L12
    }

    private static void update() {
        if (NpthMiraApi.miraInited() == true) goto L5;
        return;
    L5:
        JSONArray r0 = NpthMiraApi.getPluginInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length() == 0) goto L21;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(getFile(), false));     // Catch: Throwable -> L15
        JSONObject r2 = new JSONObject();
        r2.put("plugin_info", r0);     // Catch: Throwable -> L14
        r2.put(MIRA_INIT, true);     // Catch: Throwable -> L14
        JSONWriter.writeTo(r2, r1);     // Catch: Throwable -> L14
    L12:
        FileSystemUtils.close(r1);
        return;
    L22:
        return;
    }
}
