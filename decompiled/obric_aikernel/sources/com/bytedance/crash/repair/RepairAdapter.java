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
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
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
        int startFix(int r10);
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

    /* synthetic */ RepairAdapter(AnonymousClass1 r10) {
        this();
    }

    static /* synthetic */ boolean access$000() {
        return enableFixDumpStack;
    }

    static /* synthetic */ boolean access$100() {
        return useConfig;
    }

    static /* synthetic */ boolean access$200(int r10, int r11) {
        return checkBit(r10, r11);
    }

    static /* synthetic */ RepairConfig access$300() {
        return repairConfig;
    }

    static /* synthetic */ ArrayList access$500(RepairAdapter r10) {
        return r10.mExecutorList;
    }

    static /* synthetic */ int access$600(RepairAdapter r10) {
        return r10.mRepairType;
    }

    private static boolean checkBit(int r10, int r11) {
        if ((r10 & (1 << r11)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static synchronized int dumpRepairInfo(int r10, String r11) {
        monitor-enter(RepairAdapter.class);
        int r12 = get().dumpRepairInfoInner(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(RepairAdapter.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static int fixScudoVmaLeak() {
        int r10 = initNpthRepair(false);
        if (r10 != 0) goto L8;
        r10 = ScudoVmaLeakFixer.doFixCrash();
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L9
        if (r11 == null) goto L8;
        r11.addTag("fix_scudo", String.valueOf(r10));     // Catch: Throwable -> L9
    L8:
        return r10;
    }

    private static RepairAdapter get() {
        return AdapterHolder.adapter;
    }

    private static int initNpthRepair(boolean r10) {
        Context r11 = Global.getContext();
        if (r11 != null) goto L5;
        return -7;
    L5:
        return NpthRepair.init(r11, r10);
    }

    private void registerRepairExecutor(FixExecutor r10) {
        ArrayList<FixExecutor> r11 = this.mExecutorList;
        if (r11 == null) goto L6;
        r11.add(r10);
        return;
    }

    private boolean repairInit() {
        if (this.mHasInited == true) goto L5;
        this.mHasInited = true;
        int r10 = initNpthRepair(this.mDebuggable);
        this.mInitErrno = r10;
        if (r10 == 0) goto L11;
        return false;
    L11:
        ArrayList<FixExecutor> r11 = new ArrayList();
        this.mExecutorList = r11;
        r11.add(artDumpNativeStackFixer);
        this.mExecutorList.add(dvmSuspendTimeOpt);
        this.mExecutorList.add(signalMonitor);
        return true;
    L5:
        if (this.mInitErrno == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setFixDumpStack(boolean r10) {
        enableFixDumpStack = r10;
        useConfig = false;
    }

    public static void startFixProcessMangerException() {
        DefaultWorkThread.post(new AnonymousClass5());
    }

    public static synchronized int startOptMtkBuffer(int r10) {
        monitor-enter(RepairAdapter.class);
        int r11 = initNpthRepair(false);     // Catch: Throwable -> L12
        if (r11 != 0) goto L10;
        int r12 = MTKBufferOpt.doOpt(r10);     // Catch: Throwable -> L12
        monitor-exit(RepairAdapter.class);
        return r12;
    L10:
        monitor-exit(RepairAdapter.class);
        return r11;
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

    public static synchronized void updateConfig(RepairConfig r10) {
        monitor-enter(RepairAdapter.class);
        if (r10 != null) goto L13;
        monitor-exit(RepairAdapter.class);
        return;
    L13:
        repairConfig = r10;     // Catch: Throwable -> L10
        get().startRepair();     // Catch: Throwable -> L10
        monitor-exit(RepairAdapter.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int dumpRepairInfoInner(int r10, String r11) {
        if (checkBit(this.mRepairType, r10) == true) goto L7;
        return -1;
    L7:
        if (r10 == 2) goto L9;
        return -2;
    L9:
        return SignalMonitor.getInstance().dumpSignalMonitor(r11);
    }
}
