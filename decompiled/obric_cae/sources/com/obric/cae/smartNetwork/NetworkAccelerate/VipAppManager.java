package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.j;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import com.obric.cae.smartNetwork.LowlatencyInterface;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;
import defpackage.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class VipAppManager {
    private static final long OAUTO_RUNNING_TIMEOUT_MS = 4800000;
    public static final String PACKAGE_NAME_APPSTORE = "com.obric.appstore";
    public static final String PACKAGE_NAME_DOUBAO = "com.larus.nova";
    public static final String PACKAGE_NAME_DOWNLOADSERVER = "com.obric.downloadserver";
    private static final String TAG = "VipAppManager";
    private static volatile VipAppManager sInstance;
    private int mAppstoreUid;
    private final Context mContext;
    private int mDoubaoAppUid;
    private int mDownloadserverUid;
    private final AtomicBoolean mIsOAutoRunning;
    private final Handler mMainHandler;
    private final Runnable mOAutoTimeoutRunnable;
    private final CopyOnWriteArraySet<Integer> mVipUids;

    private VipAppManager(Context r8) {
        this.mIsOAutoRunning = new AtomicBoolean(false);
        this.mDoubaoAppUid = -1;
        this.mAppstoreUid = -1;
        this.mDownloadserverUid = -1;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mOAutoTimeoutRunnable = new j(this, 22);
        CaeLog.i(TAG, "VipAppManager constructor");
        this.mVipUids = new CopyOnWriteArraySet();
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        OAutoEvent.getInstance().registerOAutoEventCb(r8);
        this.mDoubaoAppUid = r10.getPackageManager().getApplicationInfo("com.larus.nova", 0).uid;     // Catch: PackageManager.NameNotFoundException -> L5
        this.mAppstoreUid = r10.getPackageManager().getApplicationInfo(PACKAGE_NAME_APPSTORE, 0).uid;     // Catch: PackageManager.NameNotFoundException -> L5
        this.mDownloadserverUid = r10.getPackageManager().getApplicationInfo(PACKAGE_NAME_DOWNLOADSERVER, 0).uid;     // Catch: PackageManager.NameNotFoundException -> L5
        return;
    L5:
        CaeLog.e(TAG, "com.larus.nova or com.obric.appstore or com.obric.downloadserver is not installed");
    }

    public static /* synthetic */ void a(VipAppManager r8) {
        r8.lambda$new$0();
    }

    private void checkAndSetDscpVoiceMarked(int r8) {
        Context r10 = this.mContext;
        if (r10 != null) goto L5;
        return;
    L5:
        String[] r11 = r10.getPackageManager().getPackagesForUid(r8);
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length <= 0) goto L12;
        LowlatencyInterface.getInstance(this.mContext).setAccPriorityEnabled(r8, 4);
        CaeLog.i(TAG, "Set dscp to " + r8 + " " + r11[0] + " success!");
        return;
    }

    private void clearDscpVoiceMarked(int r8) {
        Context r10 = this.mContext;
        if (r10 == null) goto L6;
        LowlatencyInterface.getInstance(r10).removeAccPriority(r8);
        CaeLog.i(TAG, "Clear dscp to " + r8 + " success!");
        return;
    }

    public static VipAppManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(VipAppManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new VipAppManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(VipAppManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ void lambda$new$0() {
        CaeLog.i(TAG, "OAuto running timeout (80 mins), auto reverting to false");
        setOAutoRunning(false);
    }

    private void removeVipUid(int r8) {
        if (this.mVipUids.remove(Integer.valueOf(r8)) == false) goto L6;
        clearDscpVoiceMarked(r8);
        return;
    }

    public void addVipUid(int r8) {
        if (r8 != this.mAppstoreUid) goto L5;
    L23:
        a.i("Ignore adding AppStore or DownloadServer to VIP apps, uid: ", r8, TAG);
        return;
    L5:
        if (r8 == this.mDownloadserverUid) goto L23;
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == true) goto L11;
        a.i("VipNetwork is disabled by cloud config, ignore adding VIP uid: ", r8, TAG);
        return;
    L11:
        ApplicationInfo r10 = CaeUtil.getAppInfoByUid(this.mContext, r8);
        if (r10 == null) goto L19;
        String r11 = L4NetEvaluateObserver.getInstance(this.mContext).getBlackList();
        if (r11 == null) goto L19;
        if (r11.contains("\"" + r10.packageName + "\"") == false) goto L19;
        CaeLog.e(TAG, "App " + r10.packageName + " (uid: " + r8 + ") is in VIP strategy blacklist, adding to VIP is denied.");
        return;
    L19:
        CaeLog.i(TAG, "uid " + r8 + " is added to VIP apps");
        if (this.mVipUids.add(Integer.valueOf(r8)) == false) goto L25;
        checkAndSetDscpVoiceMarked(r8);
        return;
    }

    public void clearVipUids() {
        Iterator<Integer> r8 = this.mVipUids.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        removeVipUid(r8.next().intValue());
        goto L4
    }

    public int getAppstoreUid() {
        return this.mAppstoreUid;
    }

    public int getDoubaoAppUid() {
        return this.mDoubaoAppUid;
    }

    public int getDownloadserverUid() {
        return this.mDownloadserverUid;
    }

    public boolean isEmpty() {
        return this.mVipUids.isEmpty();
    }

    public boolean isOAutoRunning() {
        return this.mIsOAutoRunning.get();
    }

    public boolean isOAutoRunningAndVipFeatureEnable() {
        if (this.mIsOAutoRunning.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == false) goto L7;
        return true;
    }

    public boolean isVipUid(int r8) {
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == true) goto L7;
        return false;
    L7:
        return this.mVipUids.contains(Integer.valueOf(r8));
    }

    public void setOAutoRunning(boolean r8) {
        this.mIsOAutoRunning.set(r8);
        CaeLog.i(TAG, "setOAutoRunning: " + r8);
        this.mMainHandler.removeCallbacks(this.mOAutoTimeoutRunnable);
        if (r8 == false) goto L6;
        this.mMainHandler.postDelayed(this.mOAutoTimeoutRunnable, OAUTO_RUNNING_TIMEOUT_MS);
    L6:
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == true) goto L10;
        CaeLog.i(TAG, "VipNetwork is disabled by cloud config, ignore wifi acceleration");
        return;
    L10:
        if (r8 == true) goto L12;
        Iterator<Integer> r10 = this.mVipUids.iterator();
    L17:
        if (r10.hasNext() == false) goto L22;
        Integer r11 = r10.next();
        if (r11.intValue() == this.mDoubaoAppUid) goto L17;
        removeVipUid(r11.intValue());
        CaeLog.i(TAG, "OAuto stopped, removed VIP uid: " + r11);
        goto L17
    L22:
        if (this.mDoubaoAppUid == (-1)) goto L31;
        NefidInterface.getInstance(this.mContext).setNefidLowLatencyMode(NefidInterface.NEFI_SCENARIO_GENERAL, this.mDoubaoAppUid);
        VipStrategyReport.getInstance().setWifiAccelEnabled(false);
        String r12 = "OAuto stopped, clear NEFI_SCENARIO_OAUTO for doubao";
    L14:
        CaeLog.i(TAG, r12);
        return;
    L31:
        return;
    L12:
        if (this.mDoubaoAppUid == (-1)) goto L24;
        NefidInterface.getInstance(this.mContext).setNefidLowLatencyMode(NefidInterface.NEFI_SCENARIO_OAUTO, this.mDoubaoAppUid);
        VipStrategyReport.getInstance().setWifiAccelEnabled(true);
        r12 = "OAuto running, set NEFI_SCENARIO_OAUTO for doubao";
        goto L14
    }
}
