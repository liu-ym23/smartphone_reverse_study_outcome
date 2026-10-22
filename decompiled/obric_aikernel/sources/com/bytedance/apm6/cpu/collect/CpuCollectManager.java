package com.bytedance.apm6.cpu.collect;

import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.d;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.CgroupFetcher;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import g5.b;
import g5.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class CpuCollectManager {
    private static final long PROC_CHECK_TIME = 300000;
    private static final String SPILT = ",";
    private static final String SP_CPU_FRONT = "apm_cpu_front";
    private static final String VALUE_IS_FRONT = "true";
    private c assistStat;
    private ApmCpuManager.ICpuDataListener dataListener;
    private ActivityLifecycleService lifecycleService;
    private CpuDataAssembler mDataAssembler;
    private CpuDataCollector mDataCollector;
    private AtomicBoolean mIsInit;
    private SharedPreferences mSp;

    private static final class SingletonHolder {
        private static final CpuCollectManager instance = null;

        static {
            instance = new CpuCollectManager(null);
        }

        private SingletonHolder() {
        }

        static /* synthetic */ CpuCollectManager access$100() {
            return instance;
        }
    }

    private CpuCollectManager() {
        this.mIsInit = new AtomicBoolean(false);
        this.assistStat = b.a(d.g());     // Catch: Throwable -> L6
    L4:
        CpuDataAssembler r10 = new CpuDataAssembler(this.assistStat);
        this.mDataAssembler = r10;
        this.mDataCollector = new CpuDataCollector(r10, this.assistStat);
    }

    /* synthetic */ CpuCollectManager(AnonymousClass1 r10) {
        this();
    }

    static /* synthetic */ void access$200(CpuCollectManager r10) {
        r10.checkProcessState();
    }

    static /* synthetic */ SharedPreferences access$300(CpuCollectManager r10) {
        return r10.mSp;
    }

    private void checkProcessState() {
        Map<String, ?> r10 = this.mSp.getAll();
        if (r10 == null) goto L23;
        Iterator<Map.Entry<String, ?>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L38;
        Map.Entry<String, ?> r12 = r11.next();
        String r13 = r12.getKey();     // Catch: Throwable -> L24
        File r14 = new File("/proc/" + ((String) r12.getValue()).split(SPILT)[0] + "/stat");     // Catch: Throwable -> L24
        BufferedReader r15 = null;
        String r16 = "";
        BufferedReader r17 = new BufferedReader(new FileReader(r14.getPath()), 100);     // Catch: Throwable -> L25
        r16 = r17.readLine();     // Catch: Throwable -> L12
        r17.close();     // Catch: Throwable -> L24
    L16:
        if (r16.isEmpty() == true) goto L17;
        String r18 = r16.split(" ")[1];     // Catch: Throwable -> L24
        if (r13.endsWith(r18.substring(1, r18.length() - 1)) == true) goto L6;
        SharedPreferences.Editor r19 = this.mSp.edit();     // Catch: Throwable -> L24
    L18:
        r19.remove(r13).apply();     // Catch: Throwable -> L24
        goto L6
    L17:
        r19 = this.mSp.edit();     // Catch: Throwable -> L24
    L12:
        r15 = r17;
    L13:
        if (r15 == null) goto L16;
        r15.close();     // Catch: Throwable -> L24
        goto L16
    L38:
        return;
    }

    public static CpuCollectManager getInstance() {
        return SingletonHolder.access$100();
    }

    public ApmCpuManager.ICpuDataListener getDataListener() {
        return this.dataListener;
    }

    public void init() {
        if (this.mIsInit.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.lifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        this.mSp = MonitorSharedPreferences.getSharedPreferences(ApmBaseContext.getContext(), SP_CPU_FRONT);
        if (ApmContext.isMainProcess() == false) goto L8;
        checkProcessState();
        final long r10 = 300000;
        final long r11 = 300000;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AnonymousClass1(this, r10, r11));
    L8:
        this.mSp.edit().putString(ApmContext.getCurrentProcessName(), Process.myPid() + SPILT + this.lifecycleService.isForeground()).apply();
        this.lifecycleService.register(new AnonymousClass2(this));
        ServiceManager.getService(CpuConfigService.class);
    }

    public boolean isFront() {
        if (this.lifecycleService.isForeground() == false) goto L6;
        this.mSp.edit().putString(ApmContext.getCurrentProcessName(), Process.myPid() + SPILT + this.lifecycleService.isForeground()).apply();
        return true;
    L6:
        Map<String, ?> r10 = this.mSp.getAll();
        if (r10 == null) goto L15;
        Iterator<Map.Entry<String, ?>> r11 = r10.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L15;
        if (((String) r11.next().getValue()).split(SPILT)[1].equals(VALUE_IS_FRONT) == false) goto L10;
        boolean r12 = true;
    L16:
        CgroupFetcher.CGROUP_LEVEL r13 = CgroupFetcher.getGroupLevel();
        if (r12 == false) goto L19;
        return true;
    L19:
        if (this.lifecycleService.isForeground() == false) goto L21;
        return true;
    L21:
        if (r13 != CgroupFetcher.CGROUP_LEVEL.TOP_APP) goto L23;
        return true;
    L23:
        if (r13 != CgroupFetcher.CGROUP_LEVEL.FOREGROUND) goto L26;
        return true;
    L26:
        return false;
    L15:
        r12 = false;
        goto L16
    }

    public void pause() {
        this.mDataCollector.stop();
        this.mDataAssembler.stop();
    }

    public void resume() {
        this.mDataCollector.resume();
        this.mDataAssembler.resume();
    }

    public void setDataListener(ApmCpuManager.ICpuDataListener r10) {
        this.dataListener = r10;
    }

    public void updateConfig(CpuConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        InitiativeCpuCollectManager.onConfigReady();
        Log.i(Constants.TAG, "config: " + r10);
        if (d.I() == true) goto L10;
        if (r10.isCollectAllProcess() == true) goto L10;
        return;
    L10:
        if (r10.isEnableUpload() == false) goto L13;
        this.mDataCollector.start(r10);
        this.mDataAssembler.start(r10);
        return;
    }
}
