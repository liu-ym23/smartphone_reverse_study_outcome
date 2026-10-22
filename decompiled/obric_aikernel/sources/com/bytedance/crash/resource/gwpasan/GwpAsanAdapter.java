package com.bytedance.crash.resource.gwpasan;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GwpAsanAdapter extends ResourceMonitorAdapter {
    private static final String GWP_ASAN_ALLOC_LIB = "gwp_asan_allocated_lib";
    private static final String GWP_ASAN_APP = "gwp_asan_app";
    private static final String GWP_ASAN_FATAL_LIB = "gwp_asan_fatal_lib";
    private static final String GWP_ASAN_FREE_LIB = "gwp_asan_deallocated_lib";
    private static final String GWP_ASAN_TYPE = "gwp_asan_type";
    private static final String HAS_GWP_ASAN = "has_gwp_asan";
    private static final String TAG = "NPTH_XASAN: ";
    private static GwpAsanAdapter mInstance = null;
    private static final String mLocalTestConfig = "1#1#40960#2000#0#all#all#0#";
    private GwpAsanConfig mConfig;

    static class GwpAsanUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        protected GwpAsanUploader(AppMonitor r10, @NonNull File r11) {
            super(r10, r11);
        }

        private static String cutSubString(String r10, String r11, String r12) {
            int r13 = r10.indexOf(r11);
            int r14 = r10.indexOf(r12);
            if (r13 >= 0) goto L5;
            return "null";
        L5:
            if (r14 >= 0) goto L8;
            return "null";
        L8:
            return r10.substring(r13, r14).substring(r11.length());
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected void packFilterData(Map<String, String> r10, ResourceMonitorAdapter.UploaderData r11) {
            super.packFilterData(r10, r11);
            if (r11.mNativeStack.isEmpty() == true) goto L5;
            String r12 = "true";
        L6:
            r10.put(GwpAsanAdapter.HAS_GWP_ASAN, r12);
            r10.put(GwpAsanAdapter.GWP_ASAN_APP, Global.getContext().getPackageName());
            return;
        L5:
            r12 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File r20, ResourceMonitorAdapter.UploaderData r21) {
            String r10 = "Use After Free";
            String r11 = GwpAsanAdapter.TAG;
            File r12 = new File(r20, "tombstone.txt");
            if (r12.exists() == true) goto L158;
            return false;
        L158:
            JSONArray r13 = FileUtils.readFileArray(r12.getAbsolutePath());     // Catch: Throwable -> L152
            if (r13 != null) goto L9;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  native stack is null");     // Catch: Throwable -> L152
            return false;
        L9:
            int r14 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, 0, "pid:");     // Catch: Throwable -> L152
            if (r14 >= 0) goto L13;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  pid index err");     // Catch: Throwable -> L152
            return false;
        L13:
            String[] r15 = r13.optString(r14, null).trim().split("\\s");     // Catch: Throwable -> L152
            int r16 = 0;
        L15:
            if (r16 >= r15.length) goto L26;
            String r17 = r15[r16];     // Catch: Throwable -> L152
            if ("pid:".equals(r17) == false) goto L20;
            int r18 = r16 + 1;     // Catch: Throwable -> L152
            r21.mPid = Long.decode(r15[r18].substring(0, r15[r18].length() - 1)).intValue();     // Catch: Throwable -> L152
        L25:
            r16 = r16 + 1;     // Catch: Throwable -> L152
            goto L15
        L20:
            if ("tid:".equals(r17) == false) goto L23;
            int r19 = r16 + 1;     // Catch: Throwable -> L152
            r21.mTid = Long.decode(r15[r19].substring(0, r15[r19].length() - 1)).intValue();     // Catch: Throwable -> L152
            goto L25
        L23:
            if ("name:".equals(r17) == false) goto L25;
            int r110 = r16 + 1;     // Catch: Throwable -> L152
            r21.mThreadName = r15[r110].substring(0, r15[r110].length() - 1);     // Catch: Throwable -> L152
            goto L25
        L26:
            r21.mProcessName = r15[r15.length - 2];     // Catch: Throwable -> L152
            StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L152
            int r23 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r14 + 1, "Signal ");     // Catch: Throwable -> L152
            if (r23 >= 0) goto L30;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  signal index err");     // Catch: Throwable -> L152
            return false;
        L30:
            r22.append(r13.optString(r23, null));     // Catch: Throwable -> L152
            r22.append('\n');     // Catch: Throwable -> L152
            int r24 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r23 + 1, "GWP-ASan message:");     // Catch: Throwable -> L152
            if (r24 >= 0) goto L34;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport abort msg index err");     // Catch: Throwable -> L152
            return false;
        L34:
            String r25 = r13.optString(r24, null).replace("GWP-ASan message:", "abort message:");     // Catch: Throwable -> L152
            r22.append(r25);     // Catch: Throwable -> L152
            r22.append('\n');     // Catch: Throwable -> L152
            String r111 = "Double Free";
            if (r25.contains("Use After Free") == false) goto L39;
        L51:
            int r26 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r24 + 1, "backtrace:");     // Catch: Throwable -> L152 Throwable -> L152
            if (r26 >= 0) goto L55;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport backtrace index err");     // Catch: Throwable -> L152 Throwable -> L152
            return false;
        L55:
            String r27 = "    #00";
            int r28 = r26 + 1;
            String r112 = "None";
            String r113 = "None";
        L58:
            String r114 = r27;
            String r29 = "==/lib/";
            String r115 = r112;
            if (r28 >= r13.length()) goto L86;
            String r116 = r13.optString(r28, null);     // Catch: Throwable -> L152 Throwable -> L152
            if (r116.startsWith("    #") == false) goto L86;
            r22.append(r116.trim());     // Catch: Throwable -> L152 Throwable -> L152
            r22.append('\n');     // Catch: Throwable -> L152 Throwable -> L152
            if (r111.equals(r10) == false) goto L66;
            r114 = "    #03";
        L66:
            String r117 = r114;
            String r118 = r111;
            if (r116.endsWith("libc.so") == true) goto L79;
            if (r116.endsWith("libc++_shared.so") == true) goto L79;
            if (r116.startsWith(r117) == false) goto L85;
            String[] r30 = cutSubString(r116, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152 Throwable -> L152
            if (r30 == null) goto L85;
            int r31 = 1;
            if (r30.length <= 1) goto L85;
            String r32 = r30[1];     // Catch: Throwable -> L152 Throwable -> L152
            int r33 = r30[1].lastIndexOf(47);     // Catch: Throwable -> L152 Throwable -> L152
        L77:
            r113 = r32.substring(r33 + r31);     // Catch: Throwable -> L152 Throwable -> L152
        L85:
            r28 = r28 + 1;     // Catch: Throwable -> L152 Throwable -> L152
            r27 = r117;
            r111 = r118;
            r112 = r115;
        L79:
            if (r116.startsWith("    #01") == false) goto L85;
            String[] r34 = cutSubString(r116, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152 Throwable -> L152
            if (r34 == null) goto L85;
            r31 = 1;
            if (r34.length <= 1) goto L85;
            r32 = r34[1];     // Catch: Throwable -> L152 Throwable -> L152
            r33 = r34[1].lastIndexOf(47);     // Catch: Throwable -> L152 Throwable -> L152
        L86:
            r21.mNativeStack = r22.toString();     // Catch: Throwable -> L152 Throwable -> L152
            int r35 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r28, "deallocated by thread") + 1;     // Catch: Throwable -> L152 Throwable -> L152
            String r36 = r115;
        L89:
            if (r35 >= r13.length()) goto L112;
            String r119 = r36;
            String r37 = r13.optString(r35, null);     // Catch: Throwable -> L152 Throwable -> L152
            if (r37.startsWith("    #01") == true) goto L96;
            if (r37.startsWith("    #02") == true) goto L96;
        L109:
            String r120 = r11;
        L110:
            r36 = r119;
        L156:
            r35 = r35 + 1;     // Catch: Throwable -> L150
            r11 = r120;
        L150:
            e = e;
        L154:
            NpthLog.e(r120, "parseReport :" + e);
            return false;
        L96:
            if (r37.endsWith("libnpth_xasan.so") == true) goto L109;
            if (r37.endsWith("libc++_shared.so") == true) goto L109;
            String[] r38 = cutSubString(r37, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152 Throwable -> L152
            if (r38 == null) goto L109;
            r120 = r11;
            if (r38.length <= 1) goto L110;
            r36 = r38[1].substring(r38[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L150
            if (r36.length() < 1) goto L156;
            if (r36.isEmpty() == true) goto L156;
        L113:
            int r39 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r35, "allocated by thread") + 1;     // Catch: Throwable -> L150
        L115:
            if (r39 >= r13.length()) goto L135;
            String r121 = r13.optString(r39, null);     // Catch: Throwable -> L150
            if (r121.startsWith("    #01") == true) goto L121;
            if (r121.startsWith("    #02") == true) goto L121;
        L133:
            String r122 = r29;
        L134:
            r39 = r39 + 1;     // Catch: Throwable -> L150
            r29 = r122;
        L121:
            if (r121.endsWith("libnpth_xasan.so") == true) goto L133;
            if (r121.endsWith("libc++_shared.so") == true) goto L133;
            String[] r40 = cutSubString(r121, r29, ".so").trim().split("/");     // Catch: Throwable -> L150
            if (r40 == null) goto L133;
            r122 = r29;
            if (r40.length <= 1) goto L134;
            r115 = r40[1].substring(r40[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L150
            if (r115.length() < 1) goto L134;
            if (r115.isEmpty() == true) goto L134;
        L135:
            String r41 = r115;
            int r42 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r13, r39, "build id:");     // Catch: Throwable -> L150
            if (r42 <= 0) goto L147;
            int r43 = r42 + 1;     // Catch: Throwable -> L150
        L139:
            if (r43 >= r13.length()) goto L147;
            String r44 = r13.optString(r43, null);     // Catch: Throwable -> L150
            if (r44.startsWith("    /") == false) goto L146;
            String[] r45 = r44.trim().split("\\s");     // Catch: Throwable -> L150
            if (r45.length < 3) goto L146;
            r21.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, r45[0].substring(r45[0].lastIndexOf(47) + 1)).put(CrashBody.LIB_UUID, ResourceMonitorAdapter.ResourceMonitorUploader.buildIDToUUID(r45[r45.length - 1].substring(0, r45[r45.length - 1].length() - 1))));     // Catch: Throwable -> L150
        L146:
            r43 = r43 + 1;     // Catch: Throwable -> L150
        L147:
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_TYPE, r10);     // Catch: Throwable -> L150
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_FATAL_LIB, r113);     // Catch: Throwable -> L150
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_FREE_LIB, r36);     // Catch: Throwable -> L150
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_ALLOC_LIB, r41);     // Catch: Throwable -> L150
            return true;
        L112:
            r120 = r11;
            goto L113
        L39:
            if (r25.contains("Double Free") == false) goto L42;
            r10 = "Double Free";
            goto L51
        L42:
            if (r25.contains("Buffer Overflow") == false) goto L45;
            r10 = "Buffer Overflow";
            goto L51
        L45:
            if (r25.contains("Buffer Underflow") == false) goto L48;
            r10 = "Buffer Underflow";
            goto L51
        L48:
            if (r25.contains("Invalid Free") == false) goto L50;
            r10 = "Invalid Free";
            goto L51
        L50:
            r10 = "Unknown";
        L152:
            e = e;
            r120 = GwpAsanAdapter.TAG;
            goto L154
        }
    }

    static {
    }

    public GwpAsanAdapter() {
    }

    public static void GwpAsanInit() {
    L22:
        e = move-exception;
        NpthLog.e(TAG, "GwpAsanStart err:" + e);
        return;
    L3:
        if (NativeBridge.is64BitRuntime() == true) goto L6;
        NpthLog.d("xasan 32bit app Not supported");     // Catch: IOException -> L22
        return;
    L6:
        GwpAsanAdapter r10 = get();     // Catch: IOException -> L22
        if (r10.mHasInited == false) goto L10;
        NpthLog.d("xasan has init");     // Catch: IOException -> L22
        return;
    L10:
        int r11 = Build.VERSION.SDK_INT;     // Catch: IOException -> L22
        if (r11 >= 21) goto L13;
        return;
    L13:
        if (r11 > 34) goto L27;
        String r12 = LogPath.getGwpAsanLogPath().getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();     // Catch: IOException -> L22
        if (LogPath.getGwpAsanLogPath().exists() == true) goto L17;
        LogPath.getGwpAsanLogPath().mkdirs();     // Catch: IOException -> L22
    L17:
        String r13 = Global.getConfigDir();     // Catch: IOException -> L22
        File r14 = new File(r13, "xasan.config");     // Catch: IOException -> L22
        if (r14.exists() == true) goto L20;
        r14.createNewFile();     // Catch: IOException -> L22
    L20:
        FileUtils.writeFile(r14, new GwpAsanConfig(AppMonitorConfigService.getGwpAsanConfig()).toString(), false);     // Catch: IOException -> L22
        NativeResourceMonitor.StartXasanInit(r11, r12, r13);     // Catch: IOException -> L22
        r10.mHasInited = true;     // Catch: IOException -> L22
        return;
    }

    @NonNull
    public static GwpAsanAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(GwpAsanAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new GwpAsanAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(GwpAsanAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static void updateConfig(GwpAsanConfig r10) {
        GwpAsanAdapter r11 = get();
        r11.mConfig = r10;
        r11.startMonitor(r10);
    }

    public static void upload(AppMonitor r10) {
        new GwpAsanUploader(r10, LogPath.getGwpAsanLogPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }
}
