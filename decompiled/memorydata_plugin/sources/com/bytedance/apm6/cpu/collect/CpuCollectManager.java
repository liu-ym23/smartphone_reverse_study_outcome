package com.bytedance.apm6.cpu.collect;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.core.e;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.CgroupFetcher;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.a.b;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        this.assistStat = b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
    L4:
        this.mDataAssembler = new CpuDataAssembler(this.assistStat);
        this.mDataCollector = new CpuDataCollector(this.mDataAssembler, this.assistStat);
    }

    /* synthetic */ CpuCollectManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void access$200(CpuCollectManager r0) {
        r0.checkProcessState();
    }

    static /* synthetic */ SharedPreferences access$300(CpuCollectManager r0) {
        return r0.mSp;
    }

    private void checkProcessState() {
        Map<String, ?> r0 = this.mSp.getAll();
        if (r0 == null) goto L23;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L38;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        File r4 = new File("/proc/" + ((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")).split(SPILT)[0] + "/stat");     // Catch: Throwable -> L24
        BufferedReader r5 = null;
        String r6 = "";
        BufferedReader r7 = new BufferedReader(new FileReader(r4.getPath()), 100);     // Catch: Throwable -> L25
        r6 = r7.readLine();     // Catch: Throwable -> L12
        r7.close();     // Catch: Throwable -> L24
    L16:
        if (r6.isEmpty() == true) goto L17;
        String r8 = r6.split(" ")[1];     // Catch: Throwable -> L24
        if (r3.endsWith(r8.substring(1, r8.length() - 1)) == true) goto L6;
        SharedPreferences.Editor r9 = this.mSp.edit();     // Catch: Throwable -> L24
    L18:
        r9.remove(r3).apply();     // Catch: Throwable -> L24
        goto L6
    L17:
        r9 = this.mSp.edit();     // Catch: Throwable -> L24
    L12:
        r5 = r7;
    L13:
        if (r5 == null) goto L16;
        r5.close();     // Catch: Throwable -> L24
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
        this.lifecycleService = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        this.mSp = e.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), SP_CPU_FRONT);
        if (ApmContext.isMainProcess() == false) goto L8;
        checkProcessState();
        final long r3 = 300000;
        final long r5 = 300000;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AnonymousClass1(this, r3, r5));
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
        Map<String, ?> r0 = this.mSp.getAll();
        if (r0 == null) goto L15;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        if (((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), String.class, "com.obric.memorydata.plugin")).split(SPILT)[1].equals(VALUE_IS_FRONT) == false) goto L10;
        boolean r2 = true;
    L16:
        CgroupFetcher.CGROUP_LEVEL r3 = CgroupFetcher.getGroupLevel();
        if (r2 == false) goto L19;
        return true;
    L19:
        if (this.lifecycleService.isForeground() == false) goto L21;
        return true;
    L21:
        if (r3 != CgroupFetcher.CGROUP_LEVEL.TOP_APP) goto L23;
        return true;
    L23:
        if (r3 != CgroupFetcher.CGROUP_LEVEL.FOREGROUND) goto L26;
        return true;
    L26:
        return false;
    L15:
        r2 = false;
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

    public void setDataListener(ApmCpuManager.ICpuDataListener r3) {
        this.dataListener = (ApmCpuManager.ICpuDataListener) ZeusTransformUtils.wrapperContextForParams(r3, ApmCpuManager.ICpuDataListener.class, "com.obric.memorydata.plugin");
    }

    public void updateConfig(CpuConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        InitiativeCpuCollectManager.onConfigReady();
        Log.i(Constants.TAG, "config: " + r3);
        if (com.bytedance.apm.b.f() == true) goto L10;
        if (r3.isCollectAllProcess() == true) goto L10;
        return;
    L10:
        if (r3.isEnableUpload() == false) goto L13;
        this.mDataCollector.start(r3);
        this.mDataAssembler.start(r3);
        return;
    }
}
