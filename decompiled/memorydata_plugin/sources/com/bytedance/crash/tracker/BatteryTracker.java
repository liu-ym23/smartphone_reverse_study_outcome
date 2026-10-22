package com.bytedance.crash.tracker;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryTracker {
    private static volatile BatteryTracker sInstance;
    private int mBatterLevel;

    public BatteryTracker() {
    }

    static /* synthetic */ int access$002(BatteryTracker r0, int r1) {
        r0.mBatterLevel = r1;
        return r1;
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
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        ZeusTransformUtils.registerReceiver(r0, new AnonymousClass1(this), new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        return;
    }

    public static void start() {
        instance().registerReceiver();
    }
}
