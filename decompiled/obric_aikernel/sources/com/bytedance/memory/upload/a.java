package com.bytedance.memory.upload;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.d;
import com.bytedance.apm.util.MultiProcessSharedPreferences;
import com.bytedance.apm.util.l;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f2200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f2201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<String> f2202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f2204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f2205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile SharedPreferences f2206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f2207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f2208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f2209j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static com.bytedance.memory.upload.b f2210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f2211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f2212m;

    /* JADX INFO: renamed from: com.bytedance.memory.upload.a$a, reason: collision with other inner class name */
    static class RunnableC0064a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2213c;

        RunnableC0064a(String r10) {
            this.f2213c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();
            JSONArray r11 = new JSONArray();
            JSONObject r12 = new JSONObject();
            r12.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L8
            r12.put(Constants.EVENT_TYPE, LogTypeName.MEMORY_OBJECT_MONITOR);     // Catch: Throwable -> L8
            r12.put("log_id", 464);     // Catch: Throwable -> L8
            r12.put("log_type", LogTypeName.MEMORY_OBJECT_MONITOR);     // Catch: Throwable -> L8
            r12.put("memory_object", new JSONObject(this.f2213c).optJSONObject("memory_object"));     // Catch: Throwable -> L8
            r12.put(com.bytedance.apm6.consumer.slardar.Constants.KEY_NET_TYPE, l.a(d.g()).getValue());     // Catch: Throwable -> L8
            String r13 = d.i().getSessionId();     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r13) == true) goto L6;
            r12.put("session_id", r13);     // Catch: Throwable -> L8
        L6:
            r12.put("sid", d.B());     // Catch: Throwable -> L8
            r12.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L8
            r11.put(r12);     // Catch: Throwable -> L8
            r10.put("data", r11);     // Catch: Throwable -> L8
            r10.put("header", d.k());     // Catch: Throwable -> L8
        L10:
            Iterator<String> r14 = a.f2202c.iterator();
        L12:
            if (r14.hasNext() == false) goto L22;
            String r15 = r14.next();
            t4.c r16 = d.d(r15, r10.toString().getBytes(), null);     // Catch: Exception -> L20
            if (r16 == null) goto L12;
            if (new JSONObject(new String(r16.b())).optInt(WsConstants.ERROR_CODE, -1) != 0) goto L12;
            p3.c.c("client analysis report success", new Object[0]);     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L12
        L22:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
            goto L10
        }
    }

    static class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            p3.c.c("setUploadDumpCost " + a.a(), new Object[0]);
            a.h(a.a());
            a.b();
        }
    }

    static {
        f2200a = new ArrayList();
        f2201b = new ArrayList();
        f2202c = new ArrayList();
        f2203d = "upload_when_not_wifi";
        f2204e = "hprof_force_upload";
        f2205f = "hprof_shrink_deep";
        f2207h = 1;
        f2208i = false;
        f2209j = new ThreadLocal();
        f2210k = new com.bytedance.memory.upload.b();
        f2212m = false;
    }

    public a() {
    }

    static /* synthetic */ int a() {
        return f2207h;
    }

    static /* synthetic */ int b() {
        int r10 = f2207h;
        f2207h = r10 + 1;
        return r10;
    }

    public static void c() {
        if (f2206g != null) goto L5;
        f2211l = q3.b.e().j() + "_upload_dump_cost";
        f2206g = MultiProcessSharedPreferences.i(o3.a.j().i());
    L5:
        f2206g.edit().remove(f2211l).commit();
    }

    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    static void d(String r20, String r21, int r22, long r23, List<String> r25, boolean r26) {
        p3.c.c("MemoryNetApi uploadFile begin", new Object[0]);     // Catch: Throwable -> L36
        u3.a.b().f("uploadFile_begin");     // Catch: Throwable -> L36
        r3.a.e("uploadFile_begin");     // Catch: Throwable -> L36
        JSONObject r10 = d.j();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r21) == true) goto L6;
        r10.put("update_version_code", r21);     // Catch: Throwable -> L36
    L6:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L36
        r11.put(Constants.EVENT_TYPE, LogTypeName.MEMORY_OBJECT_MONITOR);     // Catch: Throwable -> L36
        r11.put("hprof_type", r22);     // Catch: Throwable -> L36
        r11.put("timestamp", r23);     // Catch: Throwable -> L36
        r11.put("scene", "uploadFile");     // Catch: Throwable -> L36
        HashMap r12 = new HashMap(2);     // Catch: Throwable -> L36
        r12.put("header", r10.toString());     // Catch: Throwable -> L36
        r12.put("data", r11.toString());     // Catch: Throwable -> L36
        ?? r13 = 1;
        ArrayList r14 = new ArrayList(1);     // Catch: Throwable -> L36
        File r15 = new File(r20);     // Catch: Throwable -> L36
        r14.add(r15);     // Catch: Throwable -> L36
        u3.a.b().h(r15.length());     // Catch: Throwable -> L36
        r3.a.e("findFastestUrls");     // Catch: Throwable -> L36
        u3.a.b().f("findFastestUrls");     // Catch: Throwable -> L36
        List<String> r16 = c.a(r25);     // Catch: Throwable -> L36
        if (r16 != null) goto L9;
    L34:
        r3.a.e("error_dumpcollect_url_null");     // Catch: Throwable -> L36
        u3.a.b().f("error_dumpcollect_url_null");     // Catch: Throwable -> L36
        return;
    L9:
        if (r16.size() <= 0) goto L34;
        Iterator<String> r17 = r16.iterator();     // Catch: Throwable -> L36
        int r18 = 0;
    L12:
        if (r17.hasNext() == false) goto L31;
        String r19 = r17.next();     // Catch: Throwable -> L36
        int r110 = r18 + 1;     // Catch: Throwable -> L36
        u3.a.b().i(r19, r110);     // Catch: Throwable -> L36
        r3.a.e("upload_dump");     // Catch: Throwable -> L36
        u3.a.b().f("upload_dump");     // Catch: Throwable -> L36
        Timer r111 = new Timer("MemoryWidgetHeartbeat", r13);     // Catch: Throwable -> L36
        f2207h = r13;     // Catch: Throwable -> L36
        r111.schedule(new b(), 1000, 1000);     // Catch: Throwable -> L36
        MomDumpPartUploader r24 = new MomDumpPartUploader(r19, r15, r10, r11, null);     // Catch: Throwable -> L22
        MomDumpPartUploader.e r112 = r24.n();     // Catch: Throwable -> L22
        if (r112.a() == true) goto L24;
        boolean r27 = r24.p();     // Catch: Throwable -> L22
        if (r27 == false) goto L19;
        MomDumpPartUploader.State r113 = MomDumpPartUploader.State.SUCCESS;     // Catch: Throwable -> L22
    L20:
        r112 = new MomDumpPartUploader.e(r113, "", "uploadSingleFile", r27);     // Catch: Throwable -> L22
        goto L24
    L19:
        r113 = MomDumpPartUploader.State.FAILED;     // Catch: Throwable -> L22
    L24:
        r111.cancel();     // Catch: Throwable -> L36
        c();     // Catch: Throwable -> L36
        if (r112.a() == true) goto L26;
        r13 = 1;
        r3.a.e("uploadFile_error");     // Catch: Throwable -> L36
        u3.a.b().f("uploadFile_error");     // Catch: Throwable -> L36
        p3.c.c("MemoryNetApi uploadFile failed, state=" + r112.f2196a + ", message:" + r112.f2198c, new Object[0]);     // Catch: Throwable -> L36
        r18 = r110;
        goto L12
    L26:
        boolean r114 = true;
        p3.c.c("MemoryNetApi uploadFile succeed, state=%s, tosUrl=%s", new Object[]{r112.f2196a.name(), r112.f2197b});     // Catch: Throwable -> L36
        r3.a.e("upload_dump_success");     // Catch: Throwable -> L36
        u3.a.b().f("upload_dump_success");     // Catch: Throwable -> L36
        if (r26 == false) goto L29;
        v3.a.i().j(false);     // Catch: Throwable -> L36
    L29:
        com.bytedance.memory.heap.a.j().d();     // Catch: Throwable -> L36
    L32:
        if (r114 == true) goto L44;
        r3.a.e("error_uploadfile_failed");     // Catch: Throwable -> L36
        u3.a.b().f("error_uploadfile_failed");     // Catch: Throwable -> L36
        return;
    L44:
        return;
    L22:
        th = move-exception;
        p3.c.b(th, "MemoryNetApi mom dump upload error", new Object[0]);     // Catch: Throwable -> L36
        r112 = new MomDumpPartUploader.e(MomDumpPartUploader.State.FAILED, "", th.getMessage(), false);     // Catch: Throwable -> L36
        goto L24
    L31:
        r114 = false;
    L36:
        th = move-exception;
        e0.a.a("MemoryNetApi", th.toString());
        t4.a.c(th);
        r3.a.e("error_uploadfile_exception");
        p3.c.c("http_error_message " + th.getMessage(), new Object[0]);
        HashMap<String, Object> r28 = new HashMap();
        r28.put("http_error_message", th.getMessage());
        u3.a.b().c("error_uploadfile_exception", r28);
    }

    private static Context e() {
        return o3.a.j().i();
    L5:
        return d.g();
    }

    public static int f() {
        if (f2206g != null) goto L6;
        f2211l = q3.b.e().j() + "_upload_dump_cost";
        f2206g = MultiProcessSharedPreferences.i(o3.a.j().i());
    L6:
        return f2206g.getInt(f2211l, 0);
    }

    public static void g() {
        f2210k.a(o3.a.j().i());
    }

    public static void h(int r10) {
        if (f2206g != null) goto L5;
        f2211l = q3.b.e().j() + "_upload_dump_cost";
        f2206g = MultiProcessSharedPreferences.i(o3.a.j().i());
    L5:
        f2206g.edit().putInt(f2211l, r10).commit();
    }

    private static void i(String r10, List<String> r11, String r12, int r13, long r14) {
        Context r15 = e();
        if (r15 != null) goto L11;
        p3.c.c("MemoryNetApi startUploadInBackgroundProcess but context is null, fallback to current process upload", new Object[0]);
        d(r10, r12, r13, r14, r11, true);
        return;
    L11:
        r15.startService(MemoryUploadService.a(r15.getApplicationContext()));     // Catch: Throwable -> L9
        p3.c.c("MemoryNetApi start upload service in independent process", new Object[0]);     // Catch: Throwable -> L9
        return;
    L9:
        p3.c.c("MemoryNetApi start upload service failed, fallback to current process upload", new Object[0]);
        d(r10, r12, r13, r14, r11, true);
    }

    @WorkerThread
    public static synchronized void j() {
        monitor-enter(a.class);
    L64:
        th = move-exception;
        throw th;
    L5:
        if (f2212m == false) goto L7;
    L61:
        u3.a.b().f("exception_uploadCheck_running");     // Catch: Throwable -> L64
        monitor-exit(a.class);
        return;
    L7:
        if (f() > 0) goto L61;
        f2212m = true;     // Catch: Throwable -> L64
        if (q3.b.e().m() == true) goto L18;
        if (q3.b.e().g().exists() == false) goto L14;
        r3.a.e("error_corruppted_hprof");     // Catch: Throwable -> L64
        u3.a.b().f("error_corruppted_hprof");     // Catch: Throwable -> L64
    L14:
        com.bytedance.memory.heap.a.j().d();     // Catch: Throwable -> L64
        f2212m = false;     // Catch: Throwable -> L64
        monitor-exit(a.class);
        return;
    L18:
        if (m.c(o3.a.j().i()) == false) goto L20;
    L24:
        File r10 = q3.b.e().g();     // Catch: Throwable -> L64
        if (r10.exists() == false) goto L32;
        if (r10.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L32;
        r3.a.e("error_expired_heap_hprof");     // Catch: Throwable -> L64
        u3.a.b().f("error_expired_heap_hprof");     // Catch: Throwable -> L64
        com.bytedance.memory.heap.a.j().d();     // Catch: Throwable -> L64
        f2212m = false;     // Catch: Throwable -> L64
        monitor-exit(a.class);
        return;
    L32:
        if (TextUtils.isEmpty(com.bytedance.memory.heap.a.j().l()) == true) goto L41;
        File r11 = new File(com.bytedance.memory.heap.a.j().l());     // Catch: Throwable -> L64
        if (r11.exists() == false) goto L41;
        if (r11.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L41;
        r3.a.e("error_expired_zip_hprof");     // Catch: Throwable -> L64
        u3.a.b().f("error_expired_zip_hprof");     // Catch: Throwable -> L64
        com.bytedance.memory.heap.a.j().d();     // Catch: Throwable -> L64
        f2212m = false;     // Catch: Throwable -> L64
        monitor-exit(a.class);
        return;
    L41:
        if (r3.a.c(f2204e) == false) goto L67;
    L58:
        com.bytedance.memory.heap.a.j().z();     // Catch: Throwable -> L64
        f2212m = false;     // Catch: Throwable -> L64
        monitor-exit(a.class);
        return;
    L67:
        List<String> r12 = f2200a;     // Catch: Exception -> L56 Throwable -> L64
        if (r12 == null) goto L58;
        if (r12.size() <= 0) goto L58;
        Iterator<String> r13 = f2200a.iterator();     // Catch: Exception -> L56 Throwable -> L64
    L48:
        if (r13.hasNext() == false) goto L58;
        t4.c r14 = d.c(String.format(r13.next(), new Object[]{Integer.valueOf(d.j().optInt("aid", 0))}), null);     // Catch: Exception -> L56 Throwable -> L64
        if (r14 == null) goto L48;
        boolean r15 = new JSONObject(new String(r14.b())).optBoolean("should_upload");     // Catch: Exception -> L56 Throwable -> L64
        p3.c.c("uploadCheck with api: shouldUpload " + r15, new Object[0]);     // Catch: Exception -> L56 Throwable -> L64
        if (r15 == true) goto L58;
        r3.a.e("error_forbid_upload");     // Catch: Exception -> L56 Throwable -> L64
        u3.a.b().f("error_forbid_upload");     // Catch: Exception -> L56 Throwable -> L64
        f2212m = false;     // Catch: Exception -> L56 Throwable -> L64
        monitor-exit(a.class);
        return;
    L56:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L64
        goto L58
    L20:
        if (r3.a.c(f2203d) == true) goto L24;
        r3.a.e("error_not_wifi_in_uploadcheck");     // Catch: Throwable -> L64
        p3.c.c("not wifi, not upload", new Object[0]);     // Catch: Throwable -> L64
        u3.a.b().f("error_not_wifi_in_uploadcheck");     // Catch: Throwable -> L64
        g();     // Catch: Throwable -> L64
        f2212m = false;     // Catch: Throwable -> L64
        monitor-exit(a.class);
    }

    @WorkerThread
    public static void k() {
        r3.a.e("uploadCheck_background_process");
        u3.a.b().f("uploadCheck_background_process");
        ThreadLocal<Boolean> r10 = f2209j;
        r10.set(Boolean.TRUE);
        j();     // Catch: Throwable -> L6
        r10.remove();
        return;
    L6:
        th = move-exception;
        f2209j.remove();
        throw th;
    }

    public static void l(String r10) {
        p3.b.f12318a.a(new RunnableC0064a(r10), "uploadClientResult-MNA");
    }

    public static void m() {
        r3.a.e("uploadFile");
        u3.a.b().f("uploadFile");
        String r10 = com.bytedance.memory.heap.a.j().l();
        String r11 = com.bytedance.memory.heap.a.j().n();
        int r12 = com.bytedance.memory.heap.a.j().i();
        long r13 = com.bytedance.memory.heap.a.j().g();
        List<String> r14 = f2201b;
        monitor-enter(a.class);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (f2208i == false) goto L7;
    L27:
        r3.a.e("uploadFile_error_uploadingOrEmpty");     // Catch: Throwable -> L30
        u3.a.b().f("uploadFile_error_uploadingOrEmpty");     // Catch: Throwable -> L30
        f2208i = false;     // Catch: Throwable -> L30
        monitor-exit(a.class);     // Catch: Throwable -> L30
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        if (m.c(o3.a.j().i()) == false) goto L12;
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        if (Boolean.TRUE.equals(f2209j.get()) == true) goto L20;
        d(r10, r11, r12, r13, r14, true);     // Catch: Throwable -> L24
    L22:
        f2208i = false;
        return;
    L20:
        i(r10, r14, r11, r12, r13);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        f2208i = false;
        throw th;
    L12:
        if (r3.a.c(f2203d) == true) goto L16;
        r3.a.e("error_not_wifi_in_upload");     // Catch: Throwable -> L30
        u3.a.b().f("error_not_wifi_in_upload");     // Catch: Throwable -> L30
        g();     // Catch: Throwable -> L30
        p3.c.c("not wifi, not upload", new Object[0]);     // Catch: Throwable -> L30
        f2208i = false;     // Catch: Throwable -> L30
        monitor-exit(a.class);     // Catch: Throwable -> L30
    }
}
