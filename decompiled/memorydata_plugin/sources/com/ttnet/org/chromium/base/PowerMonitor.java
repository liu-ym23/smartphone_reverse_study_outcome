package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public class PowerMonitor implements TTLifeCycleMonitor.AppStateListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String CRONET_ACTION_BACK = null;
    private static String CRONET_ACTION_FORE = null;
    private static final String TAG = "PowerMonitor";
    private static final long TIME_TO_ENTER_SAME_STATE = 10000;
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static TTLifeCycleMonitor mLifeCycleMonitor;
    private static boolean mListenAppStateIndependently;
    private static PowerMonitor sInstance;
    private static String sPackageName;
    private static long sReceiveBackAction;
    private static long sReceiveForeAction;
    private static AppStateReceiver sReceiver;
    private boolean mIsBatteryPower;

    public static class AppStateReceiver extends PluginBroadcastReceiver {
        public AppStateReceiver() {
        }

        public void onReceive(Context r6, Intent r7) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            long r8 = System.currentTimeMillis();
            String r9 = r7.getAction();
            if (r9.equals(PowerMonitor.access$000()) == false) goto L5;
        L14:
            long r3 = r8 - PowerMonitor.access$200();
            PowerMonitor.access$202(r8);
            if (r3 <= 10000) goto L21;
            PowerMonitorJni.get().onResume();
            return;
        L21:
            return;
        L5:
            if (r9.equals(PowerMonitor.access$100()) == true) goto L14;
            if (r9.equals(PowerMonitor.access$300()) == false) goto L10;
        L11:
            long r4 = r8 - PowerMonitor.access$500();
            PowerMonitor.access$502(r8);
            if (r4 <= 10000) goto L19;
            PowerMonitorJni.get().onSuspend();
            return;
        L19:
            return;
        L10:
            if (r9.equals(PowerMonitor.access$400()) == true) goto L11;
        }
    }

    interface Natives {
        void onBatteryChargingChanged();

        void onInstantResume();

        void onInstantSuspend();

        void onResume();

        void onSuspend();

        void onThermalStatusChanged(int r1);
    }

    static {
        mLifeCycleMonitor = new TTLifeCycleMonitor();
    }

    private PowerMonitor() {
    }

    static /* synthetic */ String access$000() {
        return CRONET_ACTION_FORE;
    }

    static /* synthetic */ String access$100() {
        return WSCHANNEL_ACTION_FORE;
    }

    static /* synthetic */ long access$200() {
        return sReceiveForeAction;
    }

    static /* synthetic */ long access$202(long r0) {
        sReceiveForeAction = r0;
        return r0;
    }

    static /* synthetic */ String access$300() {
        return CRONET_ACTION_BACK;
    }

    static /* synthetic */ String access$400() {
        return WSCHANNEL_ACTION_BACK;
    }

    static /* synthetic */ long access$500() {
        return sReceiveBackAction;
    }

    static /* synthetic */ long access$502(long r0) {
        sReceiveBackAction = r0;
        return r0;
    }

    static /* synthetic */ void access$600(boolean r0) {
        onBatteryChargingChanged(r0);
    }

    public static void create() {
        if (sInstance == null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        sInstance = new PowerMonitor();
        Intent r2 = ContextUtils.registerNonExportedBroadcastReceiver(r0, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r2 == null) goto L11;
        boolean r4 = false;
        if (r2.getIntExtra("plugged", 0) != 0) goto L10;
        r4 = true;
    L10:
        onBatteryChargingChanged(r4);
    L11:
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r3.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ContextUtils.registerNonExportedBroadcastReceiver(r0, new AnonymousClass1(), r3);
        sPackageName = r0.getPackageName();
        CRONET_ACTION_BACK = sPackageName + ".cronet.APP_BACKGROUND";
        CRONET_ACTION_FORE = sPackageName + ".cronet.APP_FOREGROUND";
        WSCHANNEL_ACTION_BACK = sPackageName + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = sPackageName + ".wschannel.APP_FOREGROUND";
        if (TTProcessUtils.isMainProcess(r0) == true) goto L18;
        if (mListenAppStateIndependently == true) goto L18;
        sReceiver = new AppStateReceiver();
        IntentFilter r1 = new IntentFilter();
        r1.addAction(CRONET_ACTION_BACK);
        r1.addAction(CRONET_ACTION_FORE);
        r1.addAction(WSCHANNEL_ACTION_BACK);
        r1.addAction(WSCHANNEL_ACTION_FORE);
        ContextUtils.registerNonExportedBroadcastReceiver(r0, sReceiver, r1);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, Application.class) == false) goto L22;
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(r0, Application.class, "com.obric.memorydata.plugin");
        mLifeCycleMonitor.setAppStateChangedListener(sInstance);
        r5.registerActivityLifecycleCallbacks(mLifeCycleMonitor);
        return;
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    private static int getCurrentThermalStatus() {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        return -1;
    L6:
        if (sInstance != null) goto L8;
        create();
    L8:
        PowerManager r0 = (PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        return -1;
    L12:
        return ApiHelperForQ.getCurrentThermalStatus(r0);
    }

    private static int getRemainingBatteryCapacity() {
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return 0;
    L7:
        if (sInstance != null) goto L10;
        create();
    L10:
        return getRemainingBatteryCapacityImpl();
    }

    private static int getRemainingBatteryCapacityImpl() {
        return ((BatteryManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.memorydata.plugin")).getIntProperty(1);
    }

    private static boolean isBatteryPower() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return sInstance.mIsBatteryPower;
    }

    public static void mockAppResumeForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onResume();
        return;
    }

    public static void mockAppSuspendForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onSuspend();
        return;
    }

    private static void onBatteryChargingChanged(boolean r1) {
        sInstance.mIsBatteryPower = r1;
        PowerMonitorJni.get().onBatteryChargingChanged();
    }

    public static void setListenAppStateIndependently(boolean r0) {
        mListenAppStateIndependently = r0;
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (TTProcessUtils.isMainProcess(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(CRONET_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (TTProcessUtils.isMainProcess(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(CRONET_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onResume();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToBackground() {
        PowerMonitorJni.get().onInstantSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToForeground() {
        PowerMonitorJni.get().onInstantResume();
    }
}
