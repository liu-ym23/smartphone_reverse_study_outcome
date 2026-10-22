package com.bytedance.crash.resource.refmonitor;

import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class RefMonitorAdapter extends ResourceMonitorAdapter {
    private static final String TAG = "RefMonitorAdapter: ";
    private static final int kGlobal = 2;
    private static final int kLocal = 1;
    private static final int kWeakGlobal = 3;
    private static RefMonitorAdapter mInstance;
    private RefMonitorConfig mConfig;

    static class RefMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        static final String SIGNAL_LINE_STR = "Signal 6(SIGABRT), Code -12(SI_REF_LEAK)\n";

        public RefMonitorUploader(AppMonitor r10, @NonNull File r11) {
            super(r10, r11);
        }

        private static void createStackFile(File r10, String r11, String r12) {
            if (r12 != null) goto L4;
            return;
        L4:
            if ("".equals(r12) == true) goto L16;
            File r13 = new File(r10, r11);
            if (r13.exists() == true) goto L10;
            r13.createNewFile();     // Catch: Throwable -> L12
        L10:
            FileUtils.writeFile(r13, r12, false);     // Catch: Throwable -> L12
            return;
        L17:
            return;
        }

        private static String getCountRange(int r10) {
            if (r10 > 100) goto L7;
            return "[0, 100]";
        L7:
            if (r10 > 200) goto L11;
            return "(100, 200]";
        L11:
            if (r10 > 500) goto L15;
            return "(200, 500]";
        L15:
            if (r10 > 1000) goto L19;
            return "(500, 1000]";
        L19:
            if (r10 > 5000) goto L23;
            return "(1000, 5000]";
        L23:
            if (r10 > 10000) goto L26;
            return "(5000, 10000]";
        L26:
            int r11 = r10 / 10000;
            return "(" + r11 + "0000, " + (r11 + 1) + "0000]";
        }

        String getRefNumRange(String r10) {
            return getCountRange(Integer.parseInt(r10));
        L5:
            return NetConst.NOT_ENCRYPT_VERISON_CODE;
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected void packFilterData(Map<String, String> r10, ResourceMonitorAdapter.UploaderData r11) {
            super.packFilterData(r10, r11);
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r12 = "true";
        L6:
            r10.put("is_root", r12);
            return;
        L5:
            r12 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File r23, ResourceMonitorAdapter.UploaderData r24) {
            String r10 = SIGNAL_LINE_STR;
            File r11 = new File(r23, "ref_table.txt");
            if (r11.exists() == true) goto L5;
            return false;
        L5:
            String r12 = null;
            if (FileUtils.readFileArray(r11.getAbsolutePath()) != null) goto L10;
            NpthLog.i(RefMonitorAdapter.TAG, "refContent is null");     // Catch: Throwable -> L88
            return false;
        L10:
            BufferedReader r13 = new BufferedReader(new FileReader(r11));     // Catch: Throwable -> L88
            StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L88
            StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L88
            String r16 = "";
            char r17 = 0;
            boolean r18 = false;
            String r19 = "";
            String r110 = r19;
            String r111 = r110;
            String r112 = r111;
            String r113 = r112;
        L97:
            String r20 = r13.readLine();     // Catch: Throwable -> L87
            r13 = r13;
            if (r20 == null) goto L83;
            if (r16.equals(r20) == true) goto L16;
            String r114 = r16;
            char r21 = r20.charAt(0);     // Catch: Throwable -> L82
            String r22 = r20.trim();     // Catch: Throwable -> L87
            if (r22.length() == 0) goto L21;
            String r25 = r10;
            if (r21 >= 'a') goto L25;
        L37:
            String r26 = r112;
            if (r17 != 1) goto L55;
            if (r21 < '0') goto L51;
            if (r21 > '9') goto L51;
            String[] r27 = r20.split("\\s+");     // Catch: Throwable -> L87
            if (r27.length != 2) goto L44;
            r112 = r27[0];     // Catch: Throwable -> L31
            r111 = r27[1];     // Catch: Throwable -> L87
        L53:
            r17 = 2;
        L81:
            r16 = r114;
            r10 = r25;
            goto L97
        L44:
            NpthLog.d("something is wrong with ref info title");     // Catch: Throwable -> L87
        L84:
            String r28 = r14.toString();     // Catch: Throwable -> L87
            r24.mJavaStack = r15.toString();     // Catch: Throwable -> L87
            StringBuilder r29 = new StringBuilder();     // Catch: Throwable -> L87
            String r30 = r25;
            r29.append(r30);     // Catch: Throwable -> L87
            r29.append(r28);     // Catch: Throwable -> L87
            r24.mNativeStack = r29.toString();     // Catch: Throwable -> L87
            createStackFile(r23, "tombstone.txt", ("pid: 1234, tid: " + r24.mTid + ", ThreadName: " + r24.mThreadName + "  >>> " + Global.getContext().getPackageName() + " <<<\n") + r30 + ("abort message: " + r12 + " ref leak type: " + r19 + "(count: " + r110 + "), backtrace type: " + r111 + "(count: " + r26 + ")\n") + "backtrace: \n" + r28);     // Catch: Throwable -> L87
            createStackFile(r23, "javastack.txt", r24.mJavaStack);     // Catch: Throwable -> L87
            r24.filterData.put("has_ref_leak_log", "true");     // Catch: Throwable -> L87
            r24.filterData.put("ref_leak_type", r12);     // Catch: Throwable -> L87
            r24.filterData.put(r12 + "_ref_range", getRefNumRange(r113));     // Catch: Throwable -> L87
            r24.filterData.put(r12 + "_ref_top_type", r19);     // Catch: Throwable -> L87
            return true;
        L51:
            if (r22.startsWith("Summary") == false) goto L80;
            r112 = r26;
        L80:
            r112 = r26;
            goto L81
        L55:
            if (r17 != 2) goto L80;
            if (r22.startsWith("#") == false) goto L61;
            r14.append(r20);     // Catch: Throwable -> L87
            r14.append("\n");     // Catch: Throwable -> L87
            goto L80
        L61:
            if (r22.startsWith("at") == false) goto L65;
            r15.append(r20);     // Catch: Throwable -> L87
            r15.append("\n");     // Catch: Throwable -> L87
            if (r18 == true) goto L80;
            r112 = r26;
            r18 = true;
            goto L81
        L65:
            if (r18 == true) goto L84;
            char r31 = r22.charAt(0);     // Catch: Throwable -> L88
            if (r31 <= '0') goto L80;
            if (r31 > '9') goto L80;
            String[] r32 = r22.split("\\s+");     // Catch: Throwable -> L87
            if (r32.length >= 3) goto L76;
        L79:
            r112 = r26;
            r17 = 0;
            goto L81
        L76:
            r110 = r32[0];     // Catch: Throwable -> L31
            r19 = r32[2];     // Catch: Throwable -> L87
            goto L79
        L25:
            if (r21 > 'z') goto L37;
            if (r12 != null) goto L95;
            r12 = r20.split(" ")[0];     // Catch: Throwable -> L31
        L36:
            r17 = 1;
        L109:
            return false;
        L95:
            Matcher r33 = Pattern.compile("^.*:\\s+(\\S+),.*:\\s+(.*),.*:\\s+(\\S+).*$").matcher(r20);     // Catch: Throwable -> L90
            if (r33.find() == false) goto L36;
            r113 = r33.group(1);     // Catch: Throwable -> L90
            String r34 = r33.group(2);     // Catch: Throwable -> L90
            Objects.requireNonNull(r34);     // Catch: Throwable -> L90
            r24.mTid = Long.decode(r34).longValue();     // Catch: Throwable -> L90
            r24.mThreadName = r33.group(3);     // Catch: Throwable -> L90
        L21:
            r16 = r114;
        L110:
            return false;
        L16:
            r114 = r16;
            goto L21
        L83:
            r25 = r10;
            r26 = r112;
        L87:
            return false;
        L89:
            return false;
        }
    }

    public RefMonitorAdapter() {
    }

    @NonNull
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

    public static void updateConfig(RefMonitorConfig r10) {
        RefMonitorAdapter r11 = get();
        r11.mConfig = r10;
        r11.startMonitor(r10);
    }

    public static void upload(AppMonitor r10) {
        new RefMonitorUploader(r10, LogPath.getRefMonitorPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }
}
