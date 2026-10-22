package com.bytedance.crash.repair;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.crash.npth_repair.nativeCrash.MTKBufferOpt;
import com.bytedance.crash.npth_repair.nativeCrash.ScudoVmaLeakFixer;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RepairAdapter {
    public static final int BIT_FIX_DUMP_NATIVE_STACK = 0;
    public static final int BIT_MAX = 3;
    public static final int BIT_SIGNAL_MONITOR = 2;
    public static final int BIT_SUSPEND_TIME_OPT_4_4 = 1;
    private static final String TAG = "NpthRepairAdapter";
    private static final FixExecutor artDumpNativeStackFixer = null;
    private static final FixExecutor dvmSuspendTimeOpt = null;
    private static boolean enableFixDumpStack = false;
    private static RepairConfig repairConfig = null;
    private static final FixExecutor signalMonitor = null;
    private static boolean useConfig = true;
    private boolean mDebuggable;
    private int mDelayedTime;
    private ArrayList<FixExecutor> mExecutorList;
    private boolean mHasInited;
    private int mInitErrno;
    private int mRepairType;

    private static final class AdapterHolder {
        static final RepairAdapter adapter = null;

        static {
            adapter = new RepairAdapter(null);
        }

        private AdapterHolder() {
        }
    }

    interface FixExecutor {
        int startFix(int r1);
    }

    static {
        artDumpNativeStackFixer = new AnonymousClass1();
        dvmSuspendTimeOpt = new AnonymousClass2();
        signalMonitor = new AnonymousClass3();
    }

    private RepairAdapter() {
        this.mHasInited = false;
        this.mInitErrno = -1;
    }

    /* synthetic */ RepairAdapter(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$000() {
        return enableFixDumpStack;
    }

    static /* synthetic */ boolean access$100() {
        return useConfig;
    }

    static /* synthetic */ boolean access$200(int r0, int r1) {
        return checkBit(r0, r1);
    }

    static /* synthetic */ RepairConfig access$300() {
        return repairConfig;
    }

    static /* synthetic */ ArrayList access$500(RepairAdapter r0) {
        return r0.mExecutorList;
    }

    static /* synthetic */ int access$600(RepairAdapter r0) {
        return r0.mRepairType;
    }

    private static boolean checkBit(int r1, int r2) {
        if ((r1 & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static synchronized int dumpRepairInfo(int r2, String r3) {
        monitor-enter(RepairAdapter.class);
        int r4 = get().dumpRepairInfoInner(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(RepairAdapter.class);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public static int fixScudoVmaLeak() {
        int r0 = initNpthRepair(false);
        if (r0 != 0) goto L8;
        r0 = ScudoVmaLeakFixer.doFixCrash();
        AppMonitor r1 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        r1.addTag("fix_scudo", String.valueOf(r0));     // Catch: Throwable -> L9
    L8:
        return r0;
    }

    private static RepairAdapter get() {
        return AdapterHolder.adapter;
    }

    private static int initNpthRepair(boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return -7;
    L5:
        return NpthRepair.init(r0, r3);
    }

    private void registerRepairExecutor(FixExecutor r3) {
        FixExecutor r4 = (FixExecutor) ZeusTransformUtils.wrapperContextForParams(r3, FixExecutor.class, "com.obric.memorydata.plugin");
        ArrayList<FixExecutor> r2 = this.mExecutorList;
        if (r2 == null) goto L6;
        r2.add(r4);
        return;
    }

    private boolean repairInit() {
        if (this.mHasInited == true) goto L5;
        this.mHasInited = true;
        int r0 = initNpthRepair(this.mDebuggable);
        this.mInitErrno = r0;
        if (r0 == 0) goto L11;
        return false;
    L11:
        ArrayList<FixExecutor> r1 = new ArrayList();
        this.mExecutorList = r1;
        r1.add(artDumpNativeStackFixer);
        this.mExecutorList.add(dvmSuspendTimeOpt);
        this.mExecutorList.add(signalMonitor);
        return true;
    L5:
        if (this.mInitErrno == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setFixDumpStack(boolean r0) {
        enableFixDumpStack = r0;
        useConfig = false;
    }

    public static void startFixProcessMangerException() {
        DefaultWorkThread.post(new AnonymousClass5());
    }

    public static synchronized int startOptMtkBuffer(int r2) {
        monitor-enter(RepairAdapter.class);
        int r1 = initNpthRepair(false);     // Catch: Throwable -> L12
        if (r1 != 0) goto L10;
        int r3 = MTKBufferOpt.doOpt(r2);     // Catch: Throwable -> L12
        monitor-exit(RepairAdapter.class);
        return r3;
    L10:
        monitor-exit(RepairAdapter.class);
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    private void startRepair() {
        this.mRepairType = repairConfig.getRepairType();
        this.mDelayedTime = repairConfig.getDelayedTime();
        this.mDebuggable = repairConfig.getDebuggable();
        NpthLog.i(TAG, "type: " + this.mRepairType + " debug: " + this.mDebuggable + " delayedTime: " + this.mDelayedTime);
        if (repairInit() == false) goto L6;
        DefaultWorkThread.postDelayed(new AnonymousClass4(this), this.mDelayedTime);
        return;
    }

    public static synchronized void updateConfig(RepairConfig r1) {
        monitor-enter(RepairAdapter.class);
        if (r1 != null) goto L13;
        monitor-exit(RepairAdapter.class);
        return;
    L13:
        repairConfig = r1;     // Catch: Throwable -> L10
        get().startRepair();     // Catch: Throwable -> L10
        monitor-exit(RepairAdapter.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int dumpRepairInfoInner(int r1, String r2) {
        if (checkBit(this.mRepairType, r1) == true) goto L7;
        return -1;
    L7:
        if (r1 == 2) goto L9;
        return -2;
    L9:
        return SignalMonitor.getInstance().dumpSignalMonitor(r2);
    }
}
