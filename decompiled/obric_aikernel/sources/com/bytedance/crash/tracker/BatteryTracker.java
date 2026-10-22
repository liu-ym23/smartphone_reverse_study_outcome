package com.bytedance.crash.tracker;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.crash.Global;

/* JADX INFO: loaded from: classes.dex */
public class BatteryTracker {
    private static volatile BatteryTracker sInstance;
    private int mBatterLevel;

    public BatteryTracker() {
    }

    static /* synthetic */ int access$002(BatteryTracker r10, int r11) {
        r10.mBatterLevel = r11;
        return r11;
    }

    public static int getBatteryLevel() {
        return instance().mBatterLevel;
    }

    static BatteryTracker instance() {
        if (sInstance != null) goto L15;
        monitor-enter(BatteryTracker.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BatteryTracker();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BatteryTracker.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void registerReceiver() {
        Context r10 = Global.getContext();
        if (r10 != null) goto L8;
        return;
    L8:
        r10.registerReceiver(new AnonymousClass1(this), new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L7
        return;
    }

    public static void start() {
        instance().registerReceiver();
    }
}
