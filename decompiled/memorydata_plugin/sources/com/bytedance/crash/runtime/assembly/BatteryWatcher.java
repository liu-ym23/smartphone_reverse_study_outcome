package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.crash.runtime.NpthHandlerThread;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class BatteryWatcher {
    private int mBatterLevel;

    private class BatteryBroadcastReceiver extends PluginBroadcastReceiver {
        final /* synthetic */ BatteryWatcher this$0;

        private BatteryBroadcastReceiver(BatteryWatcher r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BatteryBroadcastReceiver(BatteryWatcher r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if ("android.intent.action.BATTERY_CHANGED".equals(r4.getAction()) == false) goto L10;
            int r6 = r4.getIntExtra("level", 0);     // Catch: Throwable -> L7
            BatteryWatcher.access$202(this.this$0, (int) ((r6 * 100.0f) / r4.getIntExtra("scale", 100)));     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }
    }

    BatteryWatcher(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        NpthHandlerThread.getDefaultHandler().post(new AnonymousClass1(this, r4));
    }

    static /* synthetic */ void access$000(BatteryWatcher r2, Context r3) {
        r2.initBatteryWatcher((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$202(BatteryWatcher r0, int r1) {
        r0.mBatterLevel = r1;
        return r1;
    }

    private void initBatteryWatcher(Context r4) {
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), new BatteryBroadcastReceiver(this, null), new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");
    }

    public int getBatterLevel() {
        return this.mBatterLevel;
    }
}
