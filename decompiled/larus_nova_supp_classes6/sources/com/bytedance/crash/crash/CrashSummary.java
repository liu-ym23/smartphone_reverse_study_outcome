package com.bytedance.crash.crash;

import android.text.TextUtils;
import ch4.c;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m;
import com.bytedance.crash.m0;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.d;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IApmAgent;
import eh4.a;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class CrashSummary implements Comparable {
    protected static final String SUFFIX = ".summary";
    private static final String UPLOAD_STATE = "upload_state.inf";
    protected final long mCrashTime;
    protected final CrashType mCrashType;
    protected final File mDirectory;
    protected final int mPid;
    protected final String mProcessName;
    protected String mStackTrace;
    protected final long mStartTime;
    protected final String mThreadName;
    protected final int mTid;
    protected final long sAppStartUpTime;

    public abstract void appendSpecialFilter(JSONObject r1);

    public abstract void assemblySpecialCrashBody(a r1, Header r2);

    public JSONObject getOriginalBody(JSONObject r1) {
        return r1;
    }

    public abstract String loadStackTrace();

    private void deleteDirectory() {
        p.d("delete directory=" + this.mDirectory.getAbsolutePath());
        g.e(this.mDirectory);
        if (this.mDirectory.exists() == false) goto L6;
        g.d(this.mDirectory, UPLOAD_STATE);
        return;
    }

    public boolean checkIfNeedUpload() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.mDirectory, UPLOAD_STATE);
        int r3 = 0;
        if (r0.exists() == true) goto L24;
    L22:
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Exception -> L19
        r1.write(r3);     // Catch: Exception -> L19
        r1.close();     // Catch: Exception -> L19
    L18:
        return true;
    L24:
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r0);     // Catch: Exception -> L8
        int r4 = r2.read();     // Catch: Exception -> L8
        r2.close();     // Catch: Exception -> L7
    L10:
        if (r4 < 0) goto L14;
        if (r4 >= 2) goto L14;
        r3 = r4 + 1;
    L14:
        if (r4 < 2) goto L16;
        c.b("upload failed, retry count is" + r4 + ".", new Exception());
    L16:
        return false;
    L8:
        r4 = 0;
        goto L10
    }

    public List<File> getAttachmentFileList() {
        ArrayList r0 = new ArrayList();
        File[] r1 = this.mDirectory.listFiles();
        if (r1 == null) goto L15;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L15;
        File r4 = r1[r3];
        String r5 = r4.getName();
        if (r5.endsWith(SUFFIX) == true) goto L14;
        if (r5.endsWith(".json") == true) goto L14;
        if (r5.endsWith(".inf") == true) goto L14;
        r0.add(r4);
    L14:
        r3 = r3 + 1;
    L15:
        return r0;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public int getTid() {
        return this.mTid;
    }

    public static CrashSummary loadFromDirectory(File r7) {
        File[] r8 = r7.listFiles(new c());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L15;
        File r5 = r8[r4];
        NativeCrashSummary r6 = NativeCrashSummary.load(r5);
        if (r6 == null) goto L10;
        r1.add(r6);
    L10:
        e r9 = e.a(r5);
        if (r9 == null) goto L13;
        r1.add(r9);
    L13:
        r4 = r4 + 1;
        goto L6
    L15:
        if (r1.isEmpty() == false) goto L17;
        return null;
    L17:
        Collections.sort(r1, new d());
        return (CrashSummary) ListProtector.get(r1, 0);
    }

    private void setInnerAid(JSONObject r4) {
        JSONObject r0 = r4.optJSONObject("header");
        JSONObject r5 = r4.optJSONObject("filters");
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.opt("aid"));
    L6:
        j.h(r5, "aid", r2);
        j.h(r0, "aid", 2010);
        return;
    L5:
        r2 = "";
        goto L6
    }

    public a assemblyCrashBody(com.bytedance.crash.monitor.a r10) {
        Header r11 = Header.a(r10, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        a r1 = new a();
        r1.a("pid", Integer.valueOf(this.mPid));     // Catch: Throwable -> L11
        r1.a("tid", Integer.valueOf(this.mTid));     // Catch: Throwable -> L11
        r1.a("crash_time", Long.valueOf(this.mCrashTime));     // Catch: Throwable -> L11
        r1.a("crash_thread_name", this.mThreadName);     // Catch: Throwable -> L11
        r1.a("process_name", this.mProcessName);     // Catch: Throwable -> L11
        r1.a("app_start_time", Long.valueOf(this.mStartTime));     // Catch: Throwable -> L11
        r1.a("app_start_up_time", Long.valueOf(this.sAppStartUpTime));     // Catch: Throwable -> L11
        r1.a("jiffy", Long.valueOf(r11.b));     // Catch: Throwable -> L11
        r1.a("has_dump", "true");     // Catch: Throwable -> L11
        j.h(r1.a, "business", i.h);     // Catch: Throwable -> L11
        r1.a("data", this.mStackTrace);     // Catch: Throwable -> L11
        r1.a("crash_md5", d.a(this.mStackTrace));     // Catch: Throwable -> L11
        int r3 = bi4.a.j;     // Catch: Throwable -> L11
        if (r3 == 1) goto L6;
    L9:
        r1.a("launch_mode", Integer.valueOf(r3));     // Catch: Throwable -> L11
        r1.a("launch_time", Long.valueOf(bi4.a.k));     // Catch: Throwable -> L11
        r1.a("session_id", r11.a.opt("session_id"));     // Catch: Throwable -> L11
        loadCrashInfo(r1.a, r11.a, this.mDirectory);     // Catch: Throwable -> L11
        eh4.b.a(r11.a, r1.a, this.mDirectory);     // Catch: Throwable -> L11
        assemblyCrashBodyAfterFilter(r1.a, this.mDirectory);     // Catch: Throwable -> L11
        assemblySpecialCrashBody(r1, r11);     // Catch: Throwable -> L11
        appendSpecialFilter(r1.a);     // Catch: Throwable -> L11
    L13:
        r1.a("header", r11.a);
        r1.b = r11;
        return r1;
    L6:
        if (bi4.a.n == false) goto L8;
        r3 = 2;
        goto L9
    L8:
        r3 = 1;
    L11:
        th = move-exception;
        p.d(th);
        c.c(th);
        goto L13
    }

    public Header assemblyCrashHeader(com.bytedance.crash.monitor.a r9) {
        return Header.a(r9, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r5) {
        long r0 = this.mCrashTime - ((CrashSummary) r5).mCrashTime;
        if (r0 <= 0) goto L5;
        return -1;
    L5:
        if (r0 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    private static void assemblyCrashBodyAfterFilter(JSONObject r10, File r11) {
        NativeBridge.M(r11.getAbsolutePath());
        PolarisFileWrapper r1 = new PolarisFileWrapper(r11, "maps_size.txt");
        if (r1.exists() == true) goto L25;
    L22:
        j.h(r10, "leak_so_list", rh4.a.b.l(new PolarisFileWrapper(r11, "ht_so_list.txt")));
        return;
    L25:
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper(r1));     // Catch: Throwable -> L24
        String r3 = r2.readLine();     // Catch: Throwable -> L24
        if (r3 == null) goto L22;
        String[] r4 = r3.trim().split(" ");     // Catch: Throwable -> L24
        if (r4.length < 2) goto L22;
        JSONArray r5 = new JSONArray();     // Catch: Throwable -> L24
    L11:
        String r6 = r2.readLine();     // Catch: Throwable -> L24
        if (r6 == null) goto L20;
        String[] r7 = r6.trim().split(" ");     // Catch: Throwable -> L24
        if (r7.length != r4.length) goto L11;
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L24
        int r9 = 0;
    L17:
        if (r9 >= r4.length) goto L19;
        r8.put(r4[r9], r7[r9]);     // Catch: Throwable -> L24
        r9 = r9 + 1;     // Catch: Throwable -> L24
        goto L17
    L19:
        r5.put(r8);     // Catch: Throwable -> L24
        goto L11
    L20:
        r2.close();     // Catch: Throwable -> L24
        r10.put("tagged_maps_size", r5);     // Catch: Throwable -> L24
    L21:
        h.b(r1);
        goto L22
    }

    private boolean beforeUpload(com.bytedance.crash.monitor.a r18, JSONObject r19) {
        m0 r4 = ((f) r18).c;
        CrashType r5 = this.mCrashType;
        r4.getClass();
        if (r4.h(r5, r19) == false) goto L7;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        return true;
    L17:
        JSONObject r7 = getOriginalBody(r19);
        CrashType r8 = this.mCrashType;
        long r9 = this.mCrashTime;
        CrashType r10 = CrashType.ANR;
        if (r8 != r10) goto L20;
        boolean r11 = !TextUtils.isEmpty(r7.optString("anr_info"));
    L21:
        boolean r12 = bi4.a.i;
        JSONObject r13 = r7.optJSONObject("activity_trace");
        if (r13 == null) goto L26;
        JSONObject r14 = r13.optJSONObject(bi4.a.o[2]);
        if (r14 == null) goto L26;
        String r15 = r14.optString("name");
    L143:
        IApmAgent r16 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Exception -> L37
        if (r16 == null) goto L38;
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L37
        r17.put("app_exit_metrics", r8.getName());     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r15) == true) goto L33;
        r17.put("scene", r15);     // Catch: Exception -> L37
    L33:
        if (r8 != r10) goto L35;
        r17.put("has_anr_info", r11);     // Catch: Exception -> L37
    L35:
        r17.put("crash_time", r9);     // Catch: Exception -> L37
        r16.monitorEvent("hmd_app_exit_reason", r17, null, null);     // Catch: Exception -> L37
    L38:
        JSONObject r1 = r19.optJSONObject("header");
        CrashType r20 = this.mCrashType;
        File r21 = this.mDirectory;
        JSONObject r22 = new JSONObject();
        j.h(r22, "crash_type", r20.getName());
        if (r21 != null) goto L42;
    L113:
        g.b(r7.opt("miniapp_info"), "miniapp_info", r22);
        g.b(r7.opt("plugin_info"), "plugin_info", r22);
        g.b(r7.opt("process_name"), "process_name", r22);
        g.b(r7.opt(Scraps.BATTERY), Scraps.BATTERY, r22);
        g.b(r7.opt("logcat"), "logcat", r22);
        g.b(r7.opt("crash_time"), "crash_time", r22);
        g.b(r7.opt(Scraps.STORAGE), Scraps.STORAGE, r22);
        g.b(r7.opt("filters"), "filters", r22);
        g.b(r7.opt("patch_info"), "patch_info", r22);
        g.b(r7.opt("pid"), "pid", r22);
        g.b(r7.opt("is_background"), "is_background", r22);
        g.b(r7.opt("activity_trace"), "activity_trace", r22);
        g.b(r7.opt("custom_long"), "custom_long", r22);
        g.b(r7.opt("custom"), "custom", r22);
        if (r7.optJSONObject("custom_long") == null) goto L117;
        g.b(r7.optJSONObject("custom_long").opt("activity_track"), "activity_track", r22);
    L117:
        if (r7.opt("filters") == null) goto L119;
        g.b(r7.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", r22);
        g.b(r7.optJSONObject("filters").opt("sdk_version_name"), "filters:sdk_version_name", r22);
        g.b(r7.optJSONObject("filters").opt("is_root"), "filters:is_root", r22);
        g.b(r7.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r22);
        g.b(r7.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r22);
        g.b(r7.optJSONObject("filters").opt("kernel_version"), "filters:kernel_version", r22);
    L119:
        if (r1 == null) goto L128;
        g.a(r1.optString("sdk_version_name"), "sdk_version_name", r22);
        g.a(r1.optString("sdk_version"), "sdk_version", r22);
        String r2 = r1.optString("os");
        if ("Android" != r2) goto L124;
    L127:
        g.a(r1.optString("os_version"), "os_version", r22);
        g.a(r1.optString("os_api"), "os_api", r22);
        g.a(r1.optString("device_model"), "device_model", r22);
        g.a(r1.optString("device_brand"), "device_brand", r22);
        g.a(r1.optString("device_manufacturer"), "device_manufacturer", r22);
        g.a(r1.optString("cpu_abi"), "cpu_abi", r22);
        g.a(r1.optString("unique_key"), "unique_key", r22);
        goto L128
    L124:
        if ("Android".equals(r2) == true) goto L127;
        r22.put("err_os_not_Android", 1);     // Catch: JSONException -> L130
    L128:
        new c.b(r22).a();
        return false;
    L42:
        if (new PolarisFileWrapper(r21, "logcat.txt").exists() == true) goto L48;
        r22.put("has_logcat_file_false", 1);     // Catch: JSONException -> L46
    L48:
        if (new PolarisFileWrapper(r21, "maps.txt").exists() == true) goto L54;
        r22.put("has_maps_file_false", 1);     // Catch: JSONException -> L52
    L54:
        if (new PolarisFileWrapper(r21, "threads.txt").exists() == true) goto L60;
        r22.put("has_threads_file_false", 1);     // Catch: JSONException -> L58
    L60:
        if (new PolarisFileWrapper(r21, "fds.txt").exists() == true) goto L66;
        r22.put("has_fds_file_false", 1);     // Catch: JSONException -> L64
    L66:
        if (new PolarisFileWrapper(r21, "meminfo.txt").exists() == true) goto L72;
        r22.put("has_meminfo_file_false", 1);     // Catch: JSONException -> L70
    L72:
        if (new PolarisFileWrapper(r21, "viewTree.txt").exists() == true) goto L78;
        r22.put("has_view_tree_false", 1);     // Catch: JSONException -> L76
    L78:
        if (new PolarisFileWrapper(r21, "pthread_key_info.txt").exists() == true) goto L84;
        r22.put("has_pthread_key_file_false", 1);     // Catch: JSONException -> L82
    L84:
        if (new PolarisFileWrapper(r21, "pthread_key_map.txt").exists() == true) goto L90;
        r22.put("has_pthread_key_map_file_false", 1);     // Catch: JSONException -> L88
    L90:
        if (new PolarisFileWrapper(r21, "malloc.txt").exists() == true) goto L96;
        r22.put("has_malloc_file_false", 1);     // Catch: JSONException -> L94
    L96:
        if (new PolarisFileWrapper(r21, "pthreads.txt").exists() == true) goto L102;
        r22.put("has_pthreads_file_false", 1);     // Catch: JSONException -> L100
    L102:
        if (new PolarisFileWrapper(r21, "setpriority.txt").exists() == true) goto L108;
        r22.put("has_setpriority_file_false", 1);     // Catch: JSONException -> L106
    L108:
        if (new PolarisFileWrapper(r21, "leak_heap.txt").exists() == true) goto L113;
        r22.put("has_heaptrack_file_false", 1);     // Catch: JSONException -> L112
    L26:
        r15 = null;
        goto L143
    L20:
        r11 = false;
        goto L21
    L7:
        if (r5 != CrashType.ANR) goto L14;
        r19.optLong("app_start_time");     // Catch: Throwable -> L13
        r19.optLong("crash_time");     // Catch: Throwable -> L13
        r19.optString("process_name");     // Catch: Throwable -> L13
        Iterator r23 = ((CopyOnWriteArrayList) r4.m).iterator();     // Catch: Throwable -> L13
    L10:
        if (r23.hasNext() == false) goto L14;
        ((m) r23.next()).a();     // Catch: Throwable -> L13
    L14:
        r6 = false;
        goto L15
    }

    public static CrashSummary loadFromDirectory(File r6, boolean r7) {
        File[] r8 = r6.listFiles(new a());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L17;
        File r5 = r8[r4];
        if (r7 == false) goto L12;
        NativeCrashSummary r9 = NativeCrashSummary.load(r5);
        if (r9 == null) goto L15;
        r1.add(r9);
    L15:
        r4 = r4 + 1;
        goto L6
    L12:
        e r10 = e.a(r5);
        if (r10 == null) goto L15;
        r1.add(r10);
        goto L15
    L17:
        if (r1.isEmpty() == false) goto L19;
        return null;
    L19:
        Collections.sort(r1, new b());
        return (CrashSummary) ListProtector.get(r1, 0);
    }

    public boolean upload(com.bytedance.crash.monitor.a r9, JSONObject r10) {
        boolean r2 = false;
        if (checkIfNeedUpload() == true) goto L6;
        deleteDirectory();
        return false;
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.mDirectory, "upload.json");
        String r3 = g.f(r1);
        JSONObject r5 = null;
        if (r3 != null) goto L42;
        JSONObject r4 = null;
    L14:
        if (r5 == null) goto L40;
        if (r4 == null) goto L40;
        boolean r11 = false;
    L22:
        boolean r12 = beforeUpload(r9, r5);     // Catch: Throwable -> L31
        if (r12 == false) goto L46;
    L34:
        afterUpload(r5, r2, r12);
        p.d("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + r2);
        return r2;
    L46:
        String r6 = r5.toString();     // Catch: Throwable -> L29
        if (r11 == true) goto L38;
    L27:
        String r13 = n.f(this.mCrashType, r4);     // Catch: Throwable -> L29
        p.d("uploadOne: " + this.mCrashType + " :" + r13);     // Catch: Throwable -> L29
        r2 = CrashUploader.g(this.mCrashType.getName(), r13, r6, getAttachmentFileList()).a();     // Catch: Throwable -> L29
        goto L34
    L38:
        h.h(r1, r6, false);     // Catch: Exception -> L37 Throwable -> L29
    L29:
        th = move-exception;
        boolean r14 = r12;
        th = th;
    L33:
        boolean r0 = zg4.i.c;
        c.b("upload exception", th);
        r12 = r14;
    L31:
        th = th;
        r14 = false;
    L40:
        r5 = assemblyCrashBody(r9).a;     // Catch: Throwable -> L31
        r4 = r5.optJSONObject("header");     // Catch: Throwable -> L31
        JSONObject r7 = j.e(r5, "filters");     // Catch: Throwable -> L31
        if (r10 == null) goto L21;
        j.d(r7, r10);     // Catch: Throwable -> L31
    L21:
        r11 = true;
        goto L22
    L42:
        JSONObject r8 = new JSONObject(r3);     // Catch: JSONException -> L11
        r5 = r8.optJSONObject("header");     // Catch: JSONException -> L36
    L12:
        r4 = r5;
        r5 = r8;
    L11:
        r8 = null;
        goto L12
    }

    private void afterUpload(JSONObject r7, boolean r8, boolean r9) {
        if (r8 == true) goto L19;
    L11:
        if (r8 == true) goto L13;
        if (r9 == true) goto L13;
        return;
    L13:
        deleteDirectory();     // Catch: Throwable -> L18
        PolarisFileWrapper r10 = ah4.b.i;     // Catch: Throwable -> L18
        if (r10 == null) goto L27;
        h.b(r10);     // Catch: Throwable -> L18
        return;
    L28:
        return;
    L27:
        return;
    L19:
        wg4.a.b(this.mProcessName, this.mStartTime, this.mCrashTime, this.mCrashType);     // Catch: Throwable -> L18
        com.bytedance.crash.upload.a.a r11 = new com.bytedance.crash.upload.a.a();     // Catch: Throwable -> L18
        com.bytedance.crash.upload.a.b.add(r11);     // Catch: Throwable -> L18
        ConcurrentLinkedQueue r12 = com.bytedance.crash.upload.a.a;     // Catch: Throwable -> L18
        if (r12.isEmpty() == true) goto L11;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L18
    L7:
        if (r13.hasNext() == false) goto L11;
        ((com.bytedance.crash.upload.a) r13.next()).a();     // Catch: Throwable -> L17
        goto L7
    }

    public void loadCrashInfo(JSONObject r3, JSONObject r4, File r5) {
        MemoryInfo.b(r3, r5);
        ih4.c.d(r3, r5);
        mh4.d.f(r3, r5);
        String r0 = g.f(new PolarisFileWrapper(r5, "sdk_info.json"));
        if (r0 != null) goto L26;
    L8:
        k.h(r3, r5);
        bi4.a.g(r3, r5);
        String r1 = g.f(new PolarisFileWrapper(r5, "all_thread_stacks.json"));
        if (r1 != null) goto L28;
    L13:
        Scraps.pushTo(r3, r5);
        com.bytedance.crash.monitor.a r2 = com.bytedance.crash.monitor.j.a;
        if (r2 == null) goto L19;
        com.bytedance.crash.dumper.j r6 = ((f) r2).l;
        if (r6 == null) goto L19;
        r6.d(r3, r4, r5);
    L19:
        String r7 = g.f(new PolarisFileWrapper(r5, "custom.json"));
        if (r7 == null) goto L30;
        j.d(r3, new JSONObject(r7));     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L28:
        j.d(r3, new JSONObject(r1));     // Catch: Throwable -> L12
        goto L13
    L26:
        j.d(r3, new JSONObject(r0));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        p.d(e);
        goto L8
    }

    public CrashSummary(File r1, CrashType r2, long r3, long r5, long r7, String r9, String r10, int r11, int r12) {
        this.mDirectory = r1;
        this.mCrashType = r2;
        this.mStartTime = r3;
        this.sAppStartUpTime = r5;
        this.mCrashTime = r7;
        this.mProcessName = r9;
        this.mThreadName = r10;
        this.mPid = r11;
        this.mTid = r12;
    }
}
