package com.bytedance.crash.resource.refmonitor;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class RefMonitorAdapter extends ResourceMonitorAdapter {
    private static final String TAG = "RefMonitorAdapter: ";
    private static final int kGlobal = 2;
    private static final int kLocal = 1;
    private static final int kWeakGlobal = 3;
    private static RefMonitorAdapter mInstance;
    private RefMonitorConfig mConfig;

    static class RefMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        static final String SIGNAL_LINE_STR = "Signal 6(SIGABRT), Code -12(SI_REF_LEAK)\n";

        public RefMonitorUploader(AppMonitor r1, File r2) {
            super(r1, r2);
        }

        private static void createStackFile(File r1, String r2, String r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if ("".equals(r3) == true) goto L16;
            File r0 = new File(r1, r2);
            if (r0.exists() == true) goto L10;
            r0.createNewFile();     // Catch: Throwable -> L12
        L10:
            FileUtils.writeFile(r0, r3, false);     // Catch: Throwable -> L12
            return;
        L17:
            return;
        }

        private static String getCountRange(int r2) {
            if (r2 > 100) goto L7;
            return "[0, 100]";
        L7:
            if (r2 > 200) goto L11;
            return "(100, 200]";
        L11:
            if (r2 > 500) goto L15;
            return "(200, 500]";
        L15:
            if (r2 > 1000) goto L19;
            return "(500, 1000]";
        L19:
            if (r2 > 5000) goto L23;
            return "(1000, 5000]";
        L23:
            if (r2 > 10000) goto L26;
            return "(5000, 10000]";
        L26:
            int r3 = r2 / 10000;
            return "(" + r3 + "0000, " + (r3 + 1) + "0000]";
        }

        String getRefNumRange(String r1) {
            return getCountRange(Integer.parseInt(r1));
        L5:
            return "0";
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> r3, ResourceMonitorAdapter.UploaderData r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            super.packFilterData(r5, r4);
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r2 = "true";
        L6:
            r5.put("is_root", r2);
            return;
        L5:
            r2 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public boolean parseReport(File r24, ResourceMonitorAdapter.UploaderData r25) {
            String r2 = SIGNAL_LINE_STR;
            File r4 = new File(r24, "ref_table.txt");
            if (r4.exists() == true) goto L5;
            return false;
        L5:
            String r5 = null;
            if (FileUtils.readFileArray(r4.getAbsolutePath()) != null) goto L10;
            NpthLog.i(RefMonitorAdapter.TAG, "refContent is null");     // Catch: Throwable -> L85
            return false;
        L10:
            BufferedReader r7 = new BufferedReader(new FileReader(r4));     // Catch: Throwable -> L85
            StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L85
            StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L85
            String r9 = "";
            char r10 = 0;
            boolean r11 = false;
            String r12 = "";
            String r13 = r12;
            String r14 = r13;
            String r15 = r14;
            String r16 = r15;
        L91:
            String r17 = r7.readLine();     // Catch: Throwable -> L84
            r7 = r7;
            if (r17 == null) goto L81;
            if (r9.equals(r17) == true) goto L17;
            String r19 = r9;
            char r18 = r17.charAt(0);     // Catch: Throwable -> L88
            String r0 = r17.trim();     // Catch: Throwable -> L84
            if (r0.length() == 0) goto L22;
            String r20 = r2;
            String r21 = r15;
            if (r18 >= 'a') goto L26;
        L38:
            String r22 = r14;
            if (r10 != 1) goto L56;
            if (r18 < '0') goto L52;
            if (r18 > '9') goto L52;
            String[] r1 = r17.split("\\s+");     // Catch: Throwable -> L84
            if (r1.length != 2) goto L45;
            r15 = r1[0];     // Catch: Throwable -> L32
            r14 = r1[1];     // Catch: Throwable -> L84
        L54:
            r10 = 2;
        L80:
            r9 = r19;
            r2 = r20;
            goto L91
        L45:
            NpthLog.d("something is wrong with ref info title");     // Catch: Throwable -> L84
        L82:
            String r3 = r6.toString();     // Catch: Throwable -> L84
            r25.mJavaStack = r8.toString();     // Catch: Throwable -> L84
            String r23 = r20;
            r25.mNativeStack = r23 + r3;     // Catch: Throwable -> L84
            createStackFile(r24, "tombstone.txt", ("pid: 1234, tid: " + r25.mTid + ", ThreadName: " + r25.mThreadName + "  >>> " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName() + " <<<\n") + r23 + ("abort message: " + r5 + " ref leak type: " + r12 + "(count: " + r13 + "), backtrace type: " + r22 + "(count: " + r21 + ")\n") + "backtrace: \n" + r3);     // Catch: Throwable -> L84
            createStackFile(r24, "javastack.txt", r25.mJavaStack);     // Catch: Throwable -> L84
            r25.filterData.put("has_ref_leak_log", "true");     // Catch: Throwable -> L84
            r25.filterData.put("ref_leak_type", r5);     // Catch: Throwable -> L84
            r25.filterData.put(r5 + "_ref_range", getRefNumRange(r16));     // Catch: Throwable -> L84
            r25.filterData.put(r5 + "_ref_top_type", r12);     // Catch: Throwable -> L84
            return true;
        L52:
            if (r0.startsWith("Summary") == false) goto L79;
            r15 = r21;
            r14 = r22;
        L79:
            r15 = r21;
            r14 = r22;
            goto L80
        L56:
            if (r10 != 2) goto L79;
            if (r0.startsWith("#") == false) goto L62;
            r6.append(r17);     // Catch: Throwable -> L84
            r6.append("\n");     // Catch: Throwable -> L84
            goto L79
        L62:
            if (r0.startsWith("at") == false) goto L66;
            r8.append(r17);     // Catch: Throwable -> L84
            r8.append("\n");     // Catch: Throwable -> L84
            if (r11 == true) goto L79;
            r15 = r21;
            r14 = r22;
            r11 = true;
            goto L80
        L66:
            if (r11 == true) goto L82;
            char r26 = r0.charAt(0);     // Catch: Throwable -> L85
            if (r26 <= '0') goto L79;
            if (r26 > '9') goto L79;
            String[] r27 = r0.split("\\s+");     // Catch: Throwable -> L85
            if (r27.length < 3) goto L78;
            r13 = r27[0];     // Catch: Throwable -> L85
            r12 = r27[2];     // Catch: Throwable -> L84
        L78:
            r15 = r21;
            r14 = r22;
            r10 = 0;
            goto L80
        L26:
            if (r18 > 'z') goto L38;
            if (r5 != null) goto L89;
            r5 = r17.split(" ")[0];     // Catch: Throwable -> L32
        L37:
            r15 = r21;
            r10 = 1;
        L107:
            return false;
        L89:
            Matcher r28 = Pattern.compile("^.*:\\s+(\\S+),.*:\\s+(.*),.*:\\s+(\\S+).*$").matcher(r17);     // Catch: Throwable -> L87
            if (r28.find() == false) goto L37;
            r16 = r28.group(1);     // Catch: Throwable -> L87
            r25.mTid = Long.decode((String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r28.group(2)), String.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L87
            r25.mThreadName = r28.group(3);     // Catch: Throwable -> L87
        L22:
            r9 = r19;
        L109:
            return false;
        L17:
            r19 = r9;
            goto L22
        L81:
            r20 = r2;
            r22 = r14;
            r21 = r15;
        L84:
            return false;
        L86:
            return false;
        }
    }

    public RefMonitorAdapter() {
    }

    public static RefMonitorAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(RefMonitorAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new RefMonitorAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RefMonitorAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static void updateConfig(RefMonitorConfig r1) {
        RefMonitorAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }

    public static void upload(AppMonitor r2) {
        new RefMonitorUploader(r2, LogPath.getRefMonitorPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }
}
