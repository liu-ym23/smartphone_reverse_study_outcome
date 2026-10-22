package com.bytedance.crash.resource.gwpasan;

import android.content.Context;
import android.os.Build;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        public GwpAsanUploader(AppMonitor r1, File r2) {
            super(r1, r2);
        }

        private static String cutSubString(String r2, String r3, String r4) {
            int r0 = r2.indexOf(r3);
            int r5 = r2.indexOf(r4);
            if (r0 >= 0) goto L5;
            return "null";
        L5:
            if (r5 >= 0) goto L8;
            return "null";
        L8:
            return r2.substring(r0, r5).substring(r3.length());
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> r3, ResourceMonitorAdapter.UploaderData r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            super.packFilterData(r5, r4);
            if (r4.mNativeStack.isEmpty() == true) goto L5;
            String r2 = "true";
        L6:
            r5.put(GwpAsanAdapter.HAS_GWP_ASAN, r2);
            r5.put(GwpAsanAdapter.GWP_ASAN_APP, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName());
            return;
        L5:
            r2 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public boolean parseReport(File r20, ResourceMonitorAdapter.UploaderData r21) {
            String r1 = "Use After Free";
            String r5 = GwpAsanAdapter.TAG;
            File r6 = new File(r20, "tombstone.txt");
            if (r6.exists() == true) goto L161;
            return false;
        L161:
            JSONArray r7 = FileUtils.readFileArray(r6.getAbsolutePath());     // Catch: Throwable -> L155
            if (r7 != null) goto L9;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  native stack is null");     // Catch: Throwable -> L155
            return false;
        L9:
            int r8 = getLineIndex(r7, 0, "pid:");     // Catch: Throwable -> L155
            if (r8 >= 0) goto L13;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  pid index err");     // Catch: Throwable -> L155
            return false;
        L13:
            String[] r10 = r7.optString(r8, null).trim().split("\\s");     // Catch: Throwable -> L155
            int r11 = 0;
        L15:
            if (r11 >= r10.length) goto L26;
            String r12 = r10[r11];     // Catch: Throwable -> L155
            if ("pid:".equals(r12) == false) goto L20;
            int r13 = r11 + 1;     // Catch: Throwable -> L155
            r21.mPid = Long.decode(r10[r13].substring(0, r10[r13].length() - 1)).intValue();     // Catch: Throwable -> L155
        L25:
            r11 = r11 + 1;     // Catch: Throwable -> L155
            goto L15
        L20:
            if ("tid:".equals(r12) == false) goto L23;
            int r14 = r11 + 1;     // Catch: Throwable -> L155
            r21.mTid = Long.decode(r10[r14].substring(0, r10[r14].length() - 1)).intValue();     // Catch: Throwable -> L155
            goto L25
        L23:
            if ("name:".equals(r12) == false) goto L25;
            int r15 = r11 + 1;     // Catch: Throwable -> L155
            r21.mThreadName = r10[r15].substring(0, r10[r15].length() - 1);     // Catch: Throwable -> L155
            goto L25
        L26:
            r21.mProcessName = r10[r10.length - 2];     // Catch: Throwable -> L155
            StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L155
            int r9 = getLineIndex(r7, r8 + 1, "Signal ");     // Catch: Throwable -> L155
            if (r9 >= 0) goto L30;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport  signal index err");     // Catch: Throwable -> L155
            return false;
        L30:
            r4.append(r7.optString(r9, null)).append('\n');     // Catch: Throwable -> L155
            int r16 = getLineIndex(r7, r9 + 1, "GWP-ASan message:");     // Catch: Throwable -> L155
            if (r16 >= 0) goto L34;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport abort msg index err");     // Catch: Throwable -> L155
            return false;
        L34:
            String r2 = r7.optString(r16, null).replace("GWP-ASan message:", "abort message:");     // Catch: Throwable -> L155
            r4.append(r2).append('\n');     // Catch: Throwable -> L155
            if (r2.contains("Use After Free") == false) goto L39;
        L51:
            int r3 = getLineIndex(r7, r16 + 1, "backtrace:");     // Catch: Throwable -> L155 Throwable -> L155
            if (r3 >= 0) goto L55;
            NpthLog.e(GwpAsanAdapter.TAG, "parseReport backtrace index err");     // Catch: Throwable -> L155 Throwable -> L155
            return false;
        L55:
            String r17 = "    #00";
            int r18 = r3 + 1;
            String r19 = "None";
            String r110 = "None";
        L58:
            String r111 = r17;
            String r22 = "==/lib/";
            String r112 = r19;
            if (r18 >= r7.length()) goto L89;
            String r113 = r7.optString(r18, null);     // Catch: Throwable -> L155 Throwable -> L155
            if (r113.startsWith("    #") == false) goto L89;
            String r114 = r5;
            r4.append(r113.trim()).append('\n');     // Catch: Throwable -> L153
            if ("Double Free".equals(r1) == false) goto L68;
            String r115 = "    #03";
        L70:
            if (r113.endsWith("libc.so") == true) goto L82;
            if (r113.endsWith("libc++_shared.so") == true) goto L82;
            if (r113.startsWith(r115) == false) goto L88;
            String[] r23 = cutSubString(r113, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L153
            if (r23 == null) goto L88;
            int r24 = 1;
            if (r23.length <= 1) goto L88;
            String r25 = r23[1];     // Catch: Throwable -> L153
            int r26 = r23[1].lastIndexOf(47);     // Catch: Throwable -> L153
        L80:
            r110 = r25.substring(r26 + r24);     // Catch: Throwable -> L153
        L88:
            r18 = r18 + 1;     // Catch: Throwable -> L153
            r17 = r115;
            r19 = r112;
            r5 = r114;
        L82:
            if (r113.startsWith("    #01") == false) goto L88;
            String[] r27 = cutSubString(r113, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L153
            if (r27 == null) goto L88;
            r24 = 1;
            if (r27.length <= 1) goto L88;
            r25 = r27[1];     // Catch: Throwable -> L153
            r26 = r27[1].lastIndexOf(47);     // Catch: Throwable -> L153
            goto L80
        L68:
            r115 = r111;
        L153:
            e = e;
        L157:
            NpthLog.e(r114, "parseReport :" + e);
            return false;
        L89:
            r114 = r5;
            r21.mNativeStack = r4.toString();     // Catch: Throwable -> L153
            int r28 = getLineIndex(r7, r18, "deallocated by thread") + 1;     // Catch: Throwable -> L153
            String r29 = r112;
        L92:
            if (r28 >= r7.length()) goto L116;
            String r116 = r7.optString(r28, null);     // Catch: Throwable -> L153 Throwable -> L153
            if (r116.startsWith("    #01") == true) goto L99;
            if (r116.startsWith("    #02") == true) goto L99;
        L113:
            r29 = r29;
        L114:
            r28 = r28 + 1;     // Catch: Throwable -> L153 Throwable -> L153
        L99:
            if (r116.endsWith("libnpth_xasan.so") == true) goto L113;
            if (r116.endsWith("libc++_shared.so") == true) goto L113;
            String[] r30 = cutSubString(r116, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L153 Throwable -> L153
            if (r30 == null) goto L113;
            if (r30.length <= 1) goto L113;
            String r31 = r30[1].substring(r30[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L153 Throwable -> L153
            if (r31.length() >= 1) goto L109;
        L111:
            r29 = r31;
            goto L114
        L109:
            if (r31.isEmpty() == true) goto L111;
            r29 = r31;
        L116:
            int r32 = getLineIndex(r7, r28, "allocated by thread") + 1;     // Catch: Throwable -> L153 Throwable -> L153
        L118:
            if (r32 >= r7.length()) goto L138;
            String r117 = r7.optString(r32, null);     // Catch: Throwable -> L153 Throwable -> L153
            if (r117.startsWith("    #01") == true) goto L124;
            if (r117.startsWith("    #02") == true) goto L124;
        L136:
            String r118 = r22;
        L137:
            r32 = r32 + 1;     // Catch: Throwable -> L153 Throwable -> L153
            r22 = r118;
        L124:
            if (r117.endsWith("libnpth_xasan.so") == true) goto L136;
            if (r117.endsWith("libc++_shared.so") == true) goto L136;
            String[] r33 = cutSubString(r117, r22, ".so").trim().split("/");     // Catch: Throwable -> L153 Throwable -> L153
            if (r33 == null) goto L136;
            r118 = r22;
            if (r33.length <= 1) goto L137;
            r112 = r33[1].substring(r33[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L153 Throwable -> L153
            if (r112.length() < 1) goto L137;
            if (r112.isEmpty() == true) goto L137;
        L138:
            String r34 = r112;
            int r35 = getLineIndex(r7, r32, "build id:");     // Catch: Throwable -> L153 Throwable -> L153
            if (r35 <= 0) goto L150;
            int r36 = r35 + 1;     // Catch: Throwable -> L153 Throwable -> L153
        L142:
            if (r36 >= r7.length()) goto L150;
            String r37 = r7.optString(r36, null);     // Catch: Throwable -> L153 Throwable -> L153
            if (r37.startsWith("    /") == false) goto L149;
            String[] r38 = r37.trim().split("\\s");     // Catch: Throwable -> L153 Throwable -> L153
            if (r38.length < 3) goto L149;
            r21.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, r38[0].substring(r38[0].lastIndexOf(47) + 1)).put(CrashBody.LIB_UUID, buildIDToUUID(r38[r38.length - 1].substring(0, r38[r38.length - 1].length() - 1))));     // Catch: Throwable -> L153 Throwable -> L153
        L149:
            r36 = r36 + 1;     // Catch: Throwable -> L153 Throwable -> L153
        L150:
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_TYPE, r1);     // Catch: Throwable -> L153 Throwable -> L153
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_FATAL_LIB, r110);     // Catch: Throwable -> L153 Throwable -> L153
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_FREE_LIB, r29);     // Catch: Throwable -> L153 Throwable -> L153
            r21.filterData.put(GwpAsanAdapter.GWP_ASAN_ALLOC_LIB, r34);     // Catch: Throwable -> L153 Throwable -> L153
            return true;
        L39:
            if (r2.contains("Double Free") == false) goto L42;
            r1 = "Double Free";
            goto L51
        L42:
            if (r2.contains("Buffer Overflow") == false) goto L45;
            r1 = "Buffer Overflow";
            goto L51
        L45:
            if (r2.contains("Buffer Underflow") == false) goto L48;
            r1 = "Buffer Underflow";
            goto L51
        L48:
            if (r2.contains("Invalid Free") == false) goto L50;
            r1 = "Invalid Free";
            goto L51
        L50:
            r1 = "Unknown";
        L155:
            e = e;
            r114 = GwpAsanAdapter.TAG;
            goto L157
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
        GwpAsanAdapter r0 = get();     // Catch: IOException -> L22
        if (r0.mHasInited == false) goto L11;
        NpthLog.d("xasan has init");     // Catch: IOException -> L22
        return;
    L11:
        if (Build.VERSION.SDK_INT >= 21) goto L13;
        return;
    L13:
        if (Build.VERSION.SDK_INT > 34) goto L27;
        String r1 = LogPath.getGwpAsanLogPath().getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();     // Catch: IOException -> L22
        if (LogPath.getGwpAsanLogPath().exists() == true) goto L17;
        LogPath.getGwpAsanLogPath().mkdirs();     // Catch: IOException -> L22
    L17:
        String r2 = Global.getConfigDir();     // Catch: IOException -> L22
        File r3 = new File(r2, "xasan.config");     // Catch: IOException -> L22
        if (r3.exists() == true) goto L20;
        r3.createNewFile();     // Catch: IOException -> L22
    L20:
        FileUtils.writeFile(r3, new GwpAsanConfig(AppMonitorConfigService.getGwpAsanConfig()).toString(), false);     // Catch: IOException -> L22
        NativeResourceMonitor.StartXasanInit(Build.VERSION.SDK_INT, r1, r2);     // Catch: IOException -> L22
        r0.mHasInited = true;     // Catch: IOException -> L22
        return;
    }

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

    public static void updateConfig(GwpAsanConfig r1) {
        GwpAsanAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }

    public static void upload(AppMonitor r2) {
        new GwpAsanUploader(r2, LogPath.getGwpAsanLogPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public void executeMonitor() {
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }
}
