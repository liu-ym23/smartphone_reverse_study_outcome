package com.bytedance.apm.h;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1364a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1365b;
    private static int c;
    private static boolean e;
    private static boolean f;
    private long d;

    static {
        f1364a = Runtime.getRuntime().availableProcessors();
        f1365b = false;
        c = 300;
        e = false;
        f = false;
    }

    public g() {
        this.d = 600000;
        this.g = "thread";
    }

    static /* synthetic */ int a() {
        return c;
    }

    public static int a(final String r11, final boolean r12) {
        int r1 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return 0;
    L8:
        final ThreadGroup r7 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r7.getParent() == null) goto L12;
        r7 = r7.getParent();
        goto L10
    L12:
        final int[] r8 = {r7.activeCount()};
        final int r6 = r1;
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(r12, r8, r11, r6, r7));
        return (r1 << 16) + r8[0];
    L5:
        r1 = 0;
        goto L6
    }

    static /* synthetic */ JSONObject a(String r0, int r1, int r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    private static JSONObject b(String r2, int r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();
        if (r3 > 0) goto L16;
    L5:
        r0.put("java_thread_count", r4);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, r2);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put("thread_detail", r5);     // Catch: JSONException -> L13
    L11:
        r0.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.b.f());     // Catch: JSONException -> L13
        r0.put("cpu_count", f1364a);     // Catch: JSONException -> L13
        r0.put("process_name", com.bytedance.apm.b.e());     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r0.put("total_thread_count", r3);     // Catch: JSONException -> L13
        goto L5
    }

    static /* synthetic */ boolean g() {
        return f1365b;
    }

    private void h() {
        a(null, false);
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r5) {
        super.a(r5);
        boolean r1 = false;
        if (r5.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_THREAD_COLLECT, 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        e = r0;
        if (r5.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L9;
        r1 = true;
    L9:
        f = r1;
        c = r5.optInt("thread_count_threshold", 300);
        this.d = r5.optLong(SlardarSettingsConstants.PERF_KEY_COLLECT_INTERVAL, 10) * 60000;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return this.d;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        super.e();
        if (e == true) goto L5;
        return;
    L5:
        if (f == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - com.bytedance.apm.b.v()) <= WifiScanStateMachine.DEFAULT_GEO_SCANNING_DURATION_TRAINING) goto L12;
        h();
        return;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.slardar.config.a
    public void onReady() {
        super.onReady();
        f1365b = true;
    }
}
