package com.obric.cae.smartNetwork;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.IProcessObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.emoji2.text.g;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class SmartNetworkPolicyManager {
    private static final String CAED_ONLINE_GAME_UDP = "udp";
    private static final int ENABLE_LOW_LATENCY_BATTERY_THRESHOLD = 20;
    private static final String STREAMING_PACKAGE_NAME = "com.picovr.picostreamassistant";
    private static final String TAG = "SmartNetworkPolicyManager";
    private static final int UNKNOW_UID_FOR_CLEAN_NEFI_MODE = -1;
    private final IActivityManager mActivityManager;
    private final Set<Integer> mAppliedPriorityUids;
    private float mBatteryPct;
    private Context mContext;
    private ConcurrentHashMap<String, Integer> mForegroundPackages;
    private boolean mIsCharging;
    private boolean mIsPowerSaveMode;
    private boolean mIsScreenOn;
    private LowlatencyInterface mLowlatencyInterface;
    private NefidInterface mNefidInterface;
    private PackageManager mPackageManager;
    private final IProcessObserver.Stub mProcessObserver;
    private volatile Handler mWorkerHandler;
    private final Object mWorkerLock;
    private volatile HandlerThread mWorkerThread;
    private boolean mlastSetAccVoForNefidMode;
    private boolean mlastSetNefidMode;

    public class BatteryInfoReceiver extends BroadcastReceiver {
        final /* synthetic */ SmartNetworkPolicyManager this$0;

        public BatteryInfoReceiver(SmartNetworkPolicyManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(BatteryInfoReceiver r8, String r10, Intent r11) {
            r8.lambda$onReceive$0(r10, r11);
        }

        private /* synthetic */ void lambda$onReceive$0(String r8, Intent r10) {
            if ("android.intent.action.BATTERY_CHANGED".equals(r8) == false) goto L6;
            SmartNetworkPolicyManager.access$500(this.this$0, r10);
            return;
        L6:
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(r8) == false) goto L9;
            SmartNetworkPolicyManager.access$600(this.this$0);
            return;
        L9:
            if ("android.intent.action.SCREEN_ON".equals(r8) == false) goto L13;
            SmartNetworkPolicyManager r11 = this.this$0;
            boolean r12 = true;
        L11:
            SmartNetworkPolicyManager.access$700(r11, r12);
            return;
        L13:
            if ("android.intent.action.SCREEN_OFF".equals(r8) == false) goto L18;
            r11 = this.this$0;
            r12 = false;
            goto L11
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            String r11 = r10.getAction();
            if (r11 != null) goto L7;
            return;
        L7:
            Intent r12 = new Intent(r10);
            SmartNetworkPolicyManager.access$400(this.this$0).post(new g(this, r11, r12, 3));
        }
    }

    public SmartNetworkPolicyManager(Context r8) {
        this.mForegroundPackages = new ConcurrentHashMap();
        this.mAppliedPriorityUids = new CopyOnWriteArraySet();
        this.mlastSetNefidMode = false;
        this.mlastSetAccVoForNefidMode = false;
        this.mWorkerLock = new Object();
        IProcessObserver.Stub r10 = new AnonymousClass1(this);
        this.mProcessObserver = r10;
        this.mContext = r8;
        LowlatencyInterface r11 = LowlatencyInterface.getInstance(r8);
        this.mLowlatencyInterface = r11;
        r11.clearAccPriority();
        this.mNefidInterface = NefidInterface.getInstance(r8);
        this.mPackageManager = this.mContext.getPackageManager();
        IActivityManager r12 = ActivityManager.getService();
        this.mActivityManager = r12;
        r12.registerProcessObserver(r10);     // Catch: RemoteException -> L5
    L7:
        IntentFilter r13 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        r13.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        r13.addAction("android.intent.action.SCREEN_ON");
        r13.addAction("android.intent.action.SCREEN_OFF");
        r8.registerReceiver(new BatteryInfoReceiver(this), r13);
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Cannot register activity monitoring", e);
        goto L7
    }

    public static /* synthetic */ Context access$000(SmartNetworkPolicyManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ ConcurrentHashMap access$100(SmartNetworkPolicyManager r8) {
        return r8.mForegroundPackages;
    }

    public static /* synthetic */ NefidInterface access$200(SmartNetworkPolicyManager r8) {
        return r8.mNefidInterface;
    }

    public static /* synthetic */ void access$300(SmartNetworkPolicyManager r8) {
        r8.handleActivityAndBatteryStateChanged();
    }

    public static /* synthetic */ Handler access$400(SmartNetworkPolicyManager r8) {
        return r8.getWorkerHandler();
    }

    public static /* synthetic */ void access$500(SmartNetworkPolicyManager r8, Intent r10) {
        r8.handleBatteryStateChanged(r10);
    }

    public static /* synthetic */ void access$600(SmartNetworkPolicyManager r8) {
        r8.handlePowerSaveModeChanged();
    }

    public static /* synthetic */ void access$700(SmartNetworkPolicyManager r8, boolean r10) {
        r8.handleScreenStateChanged(r10);
    }

    private void clearAppliedAccPriority() {
        CaeLog.i(TAG, "clearAppliedAccPriority mAppliedPriorityUids size " + this.mAppliedPriorityUids.size());
        Iterator<Integer> r8 = this.mAppliedPriorityUids.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        this.mLowlatencyInterface.removeAccPriority(r8.next().intValue());
        goto L4
    L6:
        this.mAppliedPriorityUids.clear();
    }

    private int getUidFromPackageName(String r8) {
        return this.mContext.getPackageManager().getApplicationInfo(r8, 0).uid;
    L5:
        e = move-exception;
        Log.e(TAG, "Package not found: " + r8);
        e.printStackTrace();
        return 0;
    }

    private Handler getWorkerHandler() {
        Handler r8 = this.mWorkerHandler;
        if (r8 == null) goto L5;
        return r8;
    L5:
        Object r10 = this.mWorkerLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mWorkerHandler == null) goto L12;
        Handler r11 = this.mWorkerHandler;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r11;
    L12:
        this.mWorkerThread = new HandlerThread("SmartNetworkPolicyManager-Worker");     // Catch: Throwable -> L15
        this.mWorkerThread.start();     // Catch: Throwable -> L15
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());     // Catch: Throwable -> L15
        Handler r12 = this.mWorkerHandler;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r12;
    }

    private void handleActivityAndBatteryStateChanged() {
        clearAppliedAccPriority();
        Iterator<Map.Entry<String, Integer>> r8 = this.mForegroundPackages.entrySet().iterator();
        boolean r10 = false;
    L4:
        if (r8.hasNext() == false) goto L41;
        Map.Entry<String, Integer> r11 = r8.next();
        String r12 = CloudConfigParseAndSave.getLowlatencyWhitelist(this.mContext, r11.getKey());
        if (TextUtils.isEmpty(r12) == true) goto L4;
        if (r12.contains(CloudConfigParseAndSave.LOW_LATENCY_ALWAYS_ACTIVE) == true) goto L11;
    L19:
        String[] r13 = r12.split(",");
        int r14 = r13.length;
        int r15 = 0;
    L20:
        if (r15 >= r14) goto L4;
        String r16 = r13[r15];
        if (r16.contains(CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY) == false) goto L40;
        if (CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY_BG.equals(r16) == false) goto L28;
        this.mLowlatencyInterface.setAccPriorityEnabled(r11.getValue().intValue(), 1);
    L26:
        this.mAppliedPriorityUids.add(r11.getValue());
        goto L40
    L28:
        if (CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY_BE.equals(r16) == false) goto L32;
        LowlatencyInterface r17 = this.mLowlatencyInterface;
        int r18 = r11.getValue().intValue();
        int r19 = 2;
    L30:
        r17.setAccPriorityEnabled(r18, r19);
        goto L26
    L32:
        if (CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY_VI.equals(r16) == false) goto L35;
        r17 = this.mLowlatencyInterface;
        r18 = r11.getValue().intValue();
        r19 = 3;
        goto L30
    L35:
        if (CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY_VO.equals(r16) == false) goto L38;
    L36:
        this.mLowlatencyInterface.setAccPriorityEnabled(r11.getValue().intValue(), 4);
        goto L26
    L38:
        if (CloudConfigParseAndSave.LOW_LATENCY_AC_PRIORITY.equals(r16) == true) goto L36;
    L40:
        r15 = r15 + 1;
        goto L20
    L11:
        if (this.mIsPowerSaveMode == true) goto L17;
        if (this.mIsScreenOn == false) goto L17;
        if (this.mBatteryPct < 20.0f) goto L17;
    L18:
        r10 = true;
    L17:
        if (this.mIsCharging == false) goto L19;
    L41:
        LowlatencyInterface r20 = this.mLowlatencyInterface;
        if (r10 == false) goto L44;
        r20.setAlwaysActiveMode(true);
    L45:
        handleNefidModeChanged();
        return;
    L44:
        r20.setAlwaysActiveMode(false);
        goto L45
    }

    private void handleBatteryStateChanged(Intent r8) {
        int r10 = r8.getIntExtra("level", -1);
        int r11 = r8.getIntExtra("scale", -1);
        boolean r12 = this.mIsCharging;
        float r13 = this.mBatteryPct;
        this.mBatteryPct = (r10 * 100) / r11;
        int r14 = r8.getIntExtra("status", -1);
        if (r14 != 2) goto L5;
    L8:
        boolean r15 = true;
    L9:
        this.mIsCharging = r15;
        if (r12 == this.mIsCharging) goto L12;
    L20:
        handleActivityAndBatteryStateChanged();
        return;
    L12:
        if (r13 >= 20.0f) goto L16;
        if (this.mBatteryPct >= 20.0f) goto L16;
        return;
    L16:
        if (r13 < 20.0f) goto L20;
        if (this.mBatteryPct < 20.0f) goto L20;
        return;
    L5:
        if (r14 == 5) goto L8;
        r15 = false;
        goto L9
    }

    private void handleNefidModeChanged() {
        Iterator<Map.Entry<String, Integer>> r8 = this.mForegroundPackages.entrySet().iterator();
        boolean r10 = false;
    L4:
        if (r8.hasNext() == false) goto L31;
        Map.Entry<String, Integer> r11 = r8.next();
        String r12 = CloudConfigParseAndSave.getNefidModeWhitelist(this.mContext, r11.getKey());
        if (TextUtils.isEmpty(r12) == true) goto L4;
        int r13 = getUidFromPackageName(r11.getKey());
        String[] r14 = r12.split(",");
        int r15 = r14.length;
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L4;
        String r17 = r14[r16];
        if (r17.contains(CloudConfigParseAndSave.NEFID_MODE) == false) goto L30;
        if (CloudConfigParseAndSave.NEFID_MODE_GENERAL.equals(r17) == false) goto L17;
        NefidInterface r18 = this.mNefidInterface;
        int r19 = NefidInterface.NEFI_SCENARIO_GENERAL;
    L15:
        r18.setNefidLowLatencyMode(r19, r13);
    L29:
        this.mlastSetNefidMode = true;
        r10 = true;
        goto L30
    L17:
        if (CloudConfigParseAndSave.NEFID_MODE_ONLINE_GAME.equals(r17) == false) goto L21;
        this.mNefidInterface.setNefidLowLatencyMode(NefidInterface.NEFI_SCENARIO_ONLINE_GAME, r13);
        this.mLowlatencyInterface.setAccPriorityEnabledForProtocol(r11.getValue().intValue(), 4, CAED_ONLINE_GAME_UDP);
    L19:
        this.mlastSetAccVoForNefidMode = true;
        this.mAppliedPriorityUids.add(r11.getValue());
        goto L29
    L21:
        if (CloudConfigParseAndSave.NEFID_MODE_HIGH_TX_THPUT.equals(r17) == false) goto L24;
        r18 = this.mNefidInterface;
        r19 = NefidInterface.NEFI_SCENARIO_HIGH_TX_THPUT;
        goto L15
    L24:
        if (CloudConfigParseAndSave.NEFID_MODE_TICKETS.equals(r17) == false) goto L27;
        CaeLog.i(TAG, r11.getKey() + " network acc priority for NEFID_MODE_TICKETS");
        this.mNefidInterface.setNefidLowLatencyMode(NefidInterface.NEFI_SCENARIO_ONLINE_GAME, r13);
        this.mLowlatencyInterface.setAccPriorityEnabled(r11.getValue().intValue(), 4);
        goto L19
    L27:
        if (CloudConfigParseAndSave.NEFID_MODE_MAX.equals(r17) == false) goto L29;
        r18 = this.mNefidInterface;
        r19 = NefidInterface.NEFI_SCENARIO_MAX;
    L30:
        r16 = r16 + 1;
        goto L9
    L31:
        if (r10 == false) goto L33;
        return;
    L33:
        if (this.mlastSetNefidMode == false) goto L46;
        this.mNefidInterface.setNefidLowLatencyMode(NefidInterface.NEFI_SCENARIO_GENERAL, -1);
        this.mlastSetNefidMode = false;
        if (this.mlastSetAccVoForNefidMode == false) goto L47;
        clearAppliedAccPriority();
        this.mlastSetAccVoForNefidMode = false;
        return;
    L47:
        return;
    }

    private void handlePowerSaveModeChanged() {
        CaeLog.i(TAG, "handle power save mode changed");
        boolean r8 = ((PowerManager) this.mContext.getSystemService("power")).isPowerSaveMode();
        this.mIsPowerSaveMode = r8;
        if (r8 == true) goto L5;
        return;
    L5:
        if (this.mLowlatencyInterface.getAlwaysActiveMode() == true) goto L7;
        return;
    L7:
        if (this.mIsCharging == true) goto L12;
        this.mLowlatencyInterface.setAlwaysActiveMode(false);
        return;
    }

    private void handleScreenStateChanged(boolean r8) {
        CaeLog.i(TAG, "handle screen state changed: " + r8);
        this.mIsScreenOn = r8;
        if (r8 == false) goto L5;
        return;
    L5:
        if (this.mLowlatencyInterface.getAlwaysActiveMode() == true) goto L7;
        return;
    L7:
        if (this.mIsCharging == true) goto L12;
        this.mLowlatencyInterface.setAlwaysActiveMode(false);
        return;
    }
}
