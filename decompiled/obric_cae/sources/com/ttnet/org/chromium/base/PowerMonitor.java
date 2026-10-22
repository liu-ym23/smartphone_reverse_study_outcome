package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class PowerMonitor implements LifeCycleMonitor.AppStateListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String CRONET_ACTION_BACK = null;
    private static String CRONET_ACTION_FORE = null;
    private static final String TAG = "PowerMonitor";
    private static final long TIME_TO_ENTER_SAME_STATE = 10000;
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static LifeCycleMonitor mLifeCycleMonitor;
    private static boolean mListenAppStateIndependently;
    private static long receive_back_action;
    private static long receive_fore_action;
    private static AppStateReceiver receiver;
    private static PowerMonitor sInstance;
    private static String sPackageName;
    private boolean mIsBatteryPower;

    public static class AppStateReceiver extends BroadcastReceiver {
        public AppStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            long r11 = System.currentTimeMillis();
            String r12 = r10.getAction();
            if (r12.equals(PowerMonitor.access$000()) == false) goto L5;
        L14:
            long r13 = r11 - PowerMonitor.access$200();
            PowerMonitor.access$202(r11);
            if (r13 <= 10000) goto L21;
            PowerMonitor.access$300();
            return;
        L21:
            return;
        L5:
            if (r12.equals(PowerMonitor.access$100()) == true) goto L14;
            if (r12.equals(PowerMonitor.access$400()) == false) goto L10;
        L11:
            long r14 = r11 - PowerMonitor.access$600();
            PowerMonitor.access$602(r11);
            if (r14 <= 10000) goto L19;
            PowerMonitor.access$700();
            return;
        L19:
            return;
        L10:
            if (r12.equals(PowerMonitor.access$500()) == true) goto L11;
        }
    }

    static {
        mLifeCycleMonitor = new LifeCycleMonitor();
    }

    private PowerMonitor() {
    }

    public static /* synthetic */ String access$000() {
        return CRONET_ACTION_FORE;
    }

    public static /* synthetic */ String access$100() {
        return WSCHANNEL_ACTION_FORE;
    }

    public static /* synthetic */ long access$200() {
        return receive_fore_action;
    }

    public static /* synthetic */ long access$202(long r8) {
        receive_fore_action = r8;
        return r8;
    }

    public static /* synthetic */ void access$300() {
        nativeOnResume();
    }

    public static /* synthetic */ String access$400() {
        return CRONET_ACTION_BACK;
    }

    public static /* synthetic */ String access$500() {
        return WSCHANNEL_ACTION_BACK;
    }

    public static /* synthetic */ long access$600() {
        return receive_back_action;
    }

    public static /* synthetic */ long access$602(long r8) {
        receive_back_action = r8;
        return r8;
    }

    public static /* synthetic */ void access$700() {
        nativeOnSuspend();
    }

    public static /* synthetic */ void access$800(Intent r8) {
        onBatteryChargingChanged(r8);
    }

    public static void create() {
        if (sInstance == null) goto L5;
        return;
    L5:
        Context r8 = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent r10 = r8.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r10 == null) goto L8;
        onBatteryChargingChanged(r10);
    L8:
        sPackageName = r8.getPackageName();
        CRONET_ACTION_BACK = android.aimedia.a.i(new StringBuilder(), sPackageName, ".cronet.APP_BACKGROUND");
        CRONET_ACTION_FORE = android.aimedia.a.i(new StringBuilder(), sPackageName, ".cronet.APP_FOREGROUND");
        WSCHANNEL_ACTION_BACK = android.aimedia.a.i(new StringBuilder(), sPackageName, ".wschannel.APP_BACKGROUND");
        WSCHANNEL_ACTION_FORE = android.aimedia.a.i(new StringBuilder(), sPackageName, ".wschannel.APP_FOREGROUND");
        IntentFilter r11 = defpackage.a.c("android.intent.action.ACTION_POWER_CONNECTED", "android.intent.action.ACTION_POWER_DISCONNECTED");
        r8.registerReceiver(new AnonymousClass1(), r11);
        if (ProcessUtils.isMainProcess(r8) == true) goto L15;
        if (mListenAppStateIndependently == true) goto L15;
        receiver = new AppStateReceiver();
        IntentFilter r12 = new IntentFilter();
        r12.addAction(CRONET_ACTION_BACK);
        r12.addAction(CRONET_ACTION_FORE);
        r12.addAction(WSCHANNEL_ACTION_BACK);
        r12.addAction(WSCHANNEL_ACTION_FORE);
        r8.registerReceiver(receiver, r12);
        return;
    L15:
        if ((r8 instanceof Application) == false) goto L19;
        mLifeCycleMonitor.setAppStateChangedListener(sInstance);
        ((Application) r8).registerActivityLifecycleCallbacks(mLifeCycleMonitor);
        return;
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    @CalledByNative
    private static boolean isBatteryPower() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return sInstance.mIsBatteryPower;
    }

    private static native void nativeOnBatteryChargingChanged();

    private static native void nativeOnInstantResume();

    private static native void nativeOnInstantSuspend();

    private static native void nativeOnResume();

    private static native void nativeOnSuspend();

    private static void onBatteryChargingChanged(Intent r8) {
        int r10 = r8.getIntExtra("plugged", -1);
        PowerMonitor r11 = sInstance;
        if (r10 == 2) goto L7;
        boolean r12 = true;
        if (r10 == 1) goto L7;
    L8:
        r11.mIsBatteryPower = r12;
        nativeOnBatteryChargingChanged();
        return;
    L7:
        r12 = false;
        goto L8
    }

    public static void setListenAppStateIndependently(boolean r8) {
        mListenAppStateIndependently = r8;
    }

    @Override // com.ttnet.org.chromium.base.LifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
        Context r8 = ContextUtils.getApplicationContext();
        if (ProcessUtils.isMainProcess(r8) == false) goto L8;
        Intent r10 = new Intent();
        r10.setAction(CRONET_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
        r10.setPackage(sPackageName);
    L7:
        r8.sendBroadcast(r10);
    L8:
        nativeOnSuspend();
    }

    @Override // com.ttnet.org.chromium.base.LifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        Context r8 = ContextUtils.getApplicationContext();
        if (ProcessUtils.isMainProcess(r8) == false) goto L8;
        Intent r10 = new Intent();
        r10.setAction(CRONET_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
        r10.setPackage(sPackageName);
    L7:
        r8.sendBroadcast(r10);
    L8:
        nativeOnResume();
    }

    @Override // com.ttnet.org.chromium.base.LifeCycleMonitor.AppStateListener
    public void onInstantEnterToBackground() {
        nativeOnInstantSuspend();
    }

    @Override // com.ttnet.org.chromium.base.LifeCycleMonitor.AppStateListener
    public void onInstantEnterToForeground() {
        nativeOnInstantResume();
    }
}
