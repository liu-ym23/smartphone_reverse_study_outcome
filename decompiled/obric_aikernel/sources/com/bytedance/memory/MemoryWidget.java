package com.bytedance.memory;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.bytedance.apm.f;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.memory.model.MemoryWidgetConfig;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import p3.c;
import p3.d;
import t4.l;

/* JADX INFO: loaded from: classes.dex */
public class MemoryWidget extends f {
    public static final String KEY_CLIENT_ANALYZE = "client_analyze";
    public static final String KEY_COMBINE_DUMP_AND_UPLOAD = "combine_dump_and_upload";
    public static final String KEY_ENABLE_WIDGET_MEMORY = "enable_widget_memory";
    public static final String KEY_MAX_CAPACITY_ANALYSE = "max_capacity_analyse";
    public static final String KEY_MEMORY_RATE = "rate_memory_occupied";
    public static final String KEY_RUN_STRATEGY = "memory_strategy";
    boolean isApmMemoryUploadProcess;
    private Context mAppContext;
    private volatile boolean mCheckedFolder;
    private boolean mClientAnalyze;
    private boolean mCombineDumpAndUpload;
    private boolean mEnable;
    private volatile boolean mInitEd;
    private boolean mIsDebug;
    private MemoryWidgetConfig mMemoryWidgetConfig;
    private volatile boolean mNeedStop;
    private v3.b mResultListener;
    private JSONObject memory;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MemoryWidget f2150c;

        a(MemoryWidget r10) {
            this.f2150c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            o3.a.j().q(this.f2150c.isApmMemoryUploadProcess);
        }
    }

    class b implements Runnable {
        b(MemoryWidget r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            q3.a.d().b();
        }
    }

    public MemoryWidget(@NonNull MemoryWidgetConfig r10) {
        this.mClientAnalyze = false;
        this.isApmMemoryUploadProcess = false;
        this.mMemoryWidgetConfig = r10;
    }

    public MemoryWidget(@NonNull MemoryWidgetConfig r10, @Nullable v3.b r11) {
        this.mClientAnalyze = false;
        this.isApmMemoryUploadProcess = false;
        this.mMemoryWidgetConfig = r10;
        this.mResultListener = r11;
    }

    private boolean ableToInit() {
        if (this.mEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsDebug == true) goto L8;
        return false;
    }

    private List<String> convertHost(List<String> r10, String r11) {
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        return Collections.emptyList();
    L3:
        if (j.b(r10) == true) goto L16;
        ArrayList r12 = new ArrayList(2);     // Catch: Exception -> L13
        int r13 = r10.size();     // Catch: Exception -> L13
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L12;
        String r15 = new URL(r10.get(r14)).getHost();     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r15) == true) goto L11;
        if (r15.indexOf(46) <= 0) goto L11;
        r12.add(ReportConsts.HTTPS + r15 + r11);     // Catch: Exception -> L13
    L11:
        r14 = r14 + 1;
        goto L5
    L12:
        return r12;
    }

    private boolean inited() {
        if (this.mInitEd == true) goto L5;
    L7:
        return false;
    L5:
        if (ableToInit() == false) goto L7;
        return true;
    }

    private void parseConfig(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r11 == null) goto L11;
        JSONObject r12 = r11.optJSONObject(SlardarSettingsConstants.PERF_KEY_MEMORY);
        this.memory = r12;
        if (r12 == null) goto L12;
        boolean r13 = false;
        if (r12.optInt(KEY_ENABLE_WIDGET_MEMORY, 0) != 1) goto L9;
        r13 = true;
    L9:
        this.mEnable = r13;
        return;
    L12:
        return;
    }

    public MemoryWidgetConfig getMemoryWidgetConfig() {
        return this.mMemoryWidgetConfig;
    }

    @Override // com.bytedance.apm.f, t4.i
    public void init(Context r10) {
        super.init(r10);
        this.mAppContext = r10;
        this.isApmMemoryUploadProcess = d.e(r10);
        registerConfigService();
        o3.a.j().o(this.mAppContext);
        o3.a r11 = o3.a.j();
        MemoryWidgetConfig r12 = this.mMemoryWidgetConfig;
        if (r12 == null) goto L5;
        String r13 = r12.getFilePath();
    L6:
        r11.p(r13);
        q3.b.e();     // Catch: Exception -> L9
        return;
    L9:
        this.mNeedStop = true;
        return;
    L5:
        r13 = "";
        goto L6
    }

    @Override // com.bytedance.apm.f, t4.i
    public boolean isOnlyMainProcess() {
        return false;
    }

    @Override // t4.i
    public void notifyParams(l r10) {
        if (r10 == null) goto L23;
        List<String> r11 = r10.a();
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.size() <= 0) goto L25;
        List<String> r12 = convertHost(r11, "/monitor/collect/c/memory_upload_check?aid=%d&os=android");
        if (r12 != null) goto L10;
    L12:
        List<String> r13 = convertHost(r11, "/monitor/collect/c/mom_dump_collect");
        if (r13 != null) goto L15;
    L17:
        List<String> r14 = convertHost(r11, "/monitor/collect/c/exception");
        if (r14 != null) goto L20;
        return;
    L20:
        if (r14.size() <= 0) goto L27;
        com.bytedance.memory.upload.a.f2202c = r14;
        return;
    L27:
        return;
    L15:
        if (r13.size() <= 0) goto L17;
        com.bytedance.memory.upload.a.f2201b = r13;
        goto L17
    L10:
        if (r12.size() <= 0) goto L12;
        com.bytedance.memory.upload.a.f2200a = r12;
        goto L12
    L25:
        return;
    }

    @Override // com.bytedance.apm.f, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.getRunStrategy() != 2) goto L9;
        v3.a.i().l();
        return;
    }

    @Override // com.bytedance.apm.f, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.getRunStrategy() != 2) goto L9;
        c.c("onFront", new Object[0]);
        o3.a.j().q(this.isApmMemoryUploadProcess);
        return;
    }

    @Override // com.bytedance.apm.f, u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        super.onRefresh(r10, r11);
        if (this.mNeedStop == false) goto L5;
        return;
    L5:
        this.mIsDebug = this.mMemoryWidgetConfig.isDebug();
        parseConfig(r10);
        if (ableToInit() == true) goto L8;
    L41:
        c.c("onRefresh run", new Object[0]);
        if (r3.a.d("npth_hprof_close") == true) goto L45;
        s3.b.e().f();
    L45:
        if (this.mCheckedFolder == false) goto L47;
        return;
    L47:
        this.mCheckedFolder = true;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), WorkRequest.MIN_BACKOFF_MILLIS);
        return;
    L8:
        if (this.mInitEd == true) goto L33;
        registerAppLifeCycle();
        int r12 = this.mMemoryWidgetConfig.getMemoryRate();
        JSONObject r13 = this.memory;
        if (r13 == null) goto L21;
        this.mMemoryWidgetConfig.setRunStrategy(r13.optInt(KEY_RUN_STRATEGY, this.mMemoryWidgetConfig.getRunStrategy()));
        r12 = this.memory.optInt(KEY_MEMORY_RATE, this.mMemoryWidgetConfig.getMemoryRate());
        if (this.memory.optInt(KEY_CLIENT_ANALYZE, 0) != 1) goto L14;
        boolean r14 = true;
    L15:
        this.mClientAnalyze = r14;
        this.mMemoryWidgetConfig.setClientAnalyse(r14);
        if (this.memory.optInt(KEY_COMBINE_DUMP_AND_UPLOAD, 1) != 1) goto L18;
        boolean r15 = true;
    L19:
        this.mCombineDumpAndUpload = r15;
        this.mMemoryWidgetConfig.setCombineDumpAndUpload(r15);
        goto L21
    L18:
        r15 = false;
        goto L19
    L14:
        r14 = false;
    L21:
        if (this.mMemoryWidgetConfig.getRunStrategy() != 2) goto L23;
        c.c("reach top mode", new Object[0]);
        this.mMemoryWidgetConfig.setMemoryRate(r12);
        MemoryWidgetConfig r16 = this.mMemoryWidgetConfig;
        r16.setNumAnalyse(getConfigInt(KEY_MAX_CAPACITY_ANALYSE, r16.getNumAnalyse()));
    L23:
        o3.a.j().m(this.mAppContext, this.mMemoryWidgetConfig, this.mResultListener);
        if (this.isApmMemoryUploadProcess == true) goto L32;
        int r17 = q3.c.m().n();
        c.c("HeapDumper.getInstance().getOOMDumpCost() " + r17, new Object[0]);
        if (r17 <= 0) goto L29;
        HashMap<String, Object> r18 = new HashMap();
        r18.put("oom_dump_cost", Integer.valueOf(r17));
        u3.a.b().c("oom_dump_cost", r18);
        q3.c.m().e();
    L29:
        int r19 = com.bytedance.memory.upload.a.f();
        c.c("MemoryNetApi.getUploadDumpCost() " + r19, new Object[0]);
        if (r19 <= 0) goto L32;
        HashMap<String, Object> r20 = new HashMap();
        r20.put("upload_dump_cost", Integer.valueOf(r19));
        u3.a.b().c("upload_dump_cost", r20);
        com.bytedance.memory.upload.a.c();
    L32:
        c.c("memorywidget is inited", new Object[0]);
        c.c(this.mMemoryWidgetConfig.toString(), new Object[0]);
        this.mInitEd = true;
    L33:
        Handler r21 = new Handler(Looper.getMainLooper());
        a r22 = new a(this);
        if (o3.a.j().h() == false) goto L36;
    L39:
        long r23 = 5000;
    L40:
        r21.postDelayed(r22, r23);
        goto L41
    L36:
        if (this.isApmMemoryUploadProcess == true) goto L39;
        r23 = 20000;
        goto L40
    }

    @Override // com.bytedance.apm.f, t4.i
    public void start() {
        super.start();
    }
}
