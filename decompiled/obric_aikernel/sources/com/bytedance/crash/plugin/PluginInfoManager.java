package com.bytedance.crash.plugin;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o5.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        File r10 = getDirectory();
        if (r10 != null) goto L5;
        return;
    L5:
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length == 0) goto L69;
        long r12 = System.currentTimeMillis();
        ArrayList r13 = new ArrayList();
        File[] r14 = new File("/proc").listFiles();
        int r15 = 0;
        if (r14 != null) goto L13;
    L20:
        ArrayList r16 = new ArrayList();
        File r17 = CrashManager.getRootDirectory();
        if (r17 == null) goto L29;
        File[] r18 = r17.listFiles();
        if (r18 == null) goto L29;
        if (r18.length == 0) goto L29;
        int r19 = r18.length;
        int r20 = 0;
    L27:
        if (r20 >= r19) goto L29;
        r16.add(r18[r20].getName() + SUFFIX);
        r20 = r20 + 1;
    L29:
        File[] r21 = new File(Global.getRootDirectory(), AnrManager.ANR_ROOT_DIR).listFiles();
        if (r21 != null) goto L32;
    L36:
        int r22 = r11.length;
    L37:
        if (r15 >= r22) goto L70;
        File r23 = r11[r15];
        String r24 = r23.getName();
        if (r16.contains(r24) == true) goto L56;
        Matcher r25 = sFileNamePattern.matcher(r24);
        if (r25.find() == true) goto L44;
    L55:
        FileSystemUtils.deleteAll(r23);
        goto L56
    L44:
        if (r25.groupCount() != 2) goto L55;
        String r26 = r25.group(1);
        long r110 = 0;
        if (r26 == null) goto L48;
        r110 = Long.parseLong(r26);
    L48:
        String r27 = r25.group(2);
        if (r110 == Global.getAppStartTime()) goto L56;
        if (r110 > r12) goto L56;
        if (r13.contains(r27) == false) goto L55;
    L56:
        r15 = r15 + 1;
        goto L37
    L70:
        return;
    L32:
        if (r21.length == 0) goto L36;
        int r28 = r21.length;
        int r29 = 0;
    L34:
        if (r29 >= r28) goto L36;
        r16.add(r21[r29].getName() + SUFFIX);
        r29 = r29 + 1;
        goto L34
    L13:
        if (r14.length == 0) goto L20;
        int r30 = r14.length;
        int r31 = 0;
    L15:
        if (r31 >= r30) goto L20;
        File r32 = r14[r31];
        if (isNumeric(r32.getName()) == false) goto L19;
        r13.add(r32.getName());
    L19:
        r31 = r31 + 1;
        goto L15
    }

    @Nullable
    private static File getDirectory() {
        if (sDirectory != null) goto L8;
        File r10 = Global.getRootDirectory();
        if (r10 == null) goto L8;
        sDirectory = FileSystemUtils.createDirectory(r10, DIRECTORY);
    L8:
        return sDirectory;
    }

    @Nullable
    private static File getFile() {
        if (sCurrentFile != null) goto L8;
        long r10 = Global.getAppStartTime();
        int r11 = Process.myPid();
        File r12 = getDirectory();
        if (r12 == null) goto L8;
        sCurrentFile = new File(r12, r10 + "-" + r11 + SUFFIX);
    L8:
        return sCurrentFile;
    }

    public static JSONArray getPluginInfo() {
        return NpthMiraApi.getPluginInfo();
    }

    @Nullable
    private static File getSavedFile(String r10) {
        File r11 = getDirectory();
        if (r11 != null) goto L5;
        return null;
    L5:
        return new File(r11, r10 + SUFFIX);
    }

    public static void init() {
        a.a();     // Catch: Throwable -> L6
    L10:
        NpthMira.init();     // Catch: Throwable -> L7
    L4:
        NpthMiraApi.registerMiraCallback(new AnonymousClass1());
        DefaultWorkThread.postDelayed(new AnonymousClass2(), 1000);
    }

    private static boolean isNumeric(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L12;
        char r12 = r10.charAt(r11);
        if (r12 < '0') goto L11;
        if (r12 > '9') goto L11;
        r11 = r11 + 1;
    L11:
        return false;
    L12:
        return true;
    }

    private static void postUpdate() {
        long r10 = System.currentTimeMillis();
        long r11 = sLastUpdatedTime;
        if (r11 != 0) goto L5;
    L6:
        sLastUpdatedTime = r10;
        DefaultWorkThread.postDelayed(new AnonymousClass3(), 1000);
        return;
    L5:
        if ((r10 - r11) > 1000) goto L6;
    }

    public static void pushTo(@NonNull JSONObject r10) {
        if (NpthMiraApi.miraInited() == true) goto L6;
    L4:
        JSONUtils.put(r10, MIRA_INIT, Boolean.FALSE);
        return;
    L6:
        JSONArray r11 = NpthMiraApi.getPluginInfo();
        if (r11 == null) goto L4;
        if (r11.length() == 0) goto L4;
        JSONUtils.put(r10, "plugin_info", r11);     // Catch: Throwable -> L12
        JSONUtils.put(r10, MIRA_INIT, Boolean.TRUE);     // Catch: Throwable -> L12
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        File r12 = getSavedFile(r11.getName());
        if (r12 != null) goto L5;
    L12:
        JSONUtils.put(r10, MIRA_INIT, Boolean.FALSE);
        return;
    L5:
        if (r12.exists() == false) goto L12;
        String r13 = FileSystemUtils.readUtf8File(r12);
        if (r13 == null) goto L12;
        JSONUtils.combineJson(r10, new JSONObject(r13));     // Catch: Throwable -> L10
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
        JSONArray r10 = NpthMiraApi.getPluginInfo();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length() == 0) goto L21;
        BufferedWriter r11 = new BufferedWriter(new FileWriter(getFile(), false));     // Catch: Throwable -> L15
        JSONObject r12 = new JSONObject();
        r12.put("plugin_info", r10);     // Catch: Throwable -> L14
        r12.put(MIRA_INIT, true);     // Catch: Throwable -> L14
        JSONWriter.writeTo(r12, r11);     // Catch: Throwable -> L14
    L12:
        FileSystemUtils.close(r11);
        return;
    L22:
        return;
    }
}
