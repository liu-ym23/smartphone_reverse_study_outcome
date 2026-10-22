package com.bytedance.crash.runtime.assembly;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.crash.runtime.NpthHandlerThread;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class BatteryWatcher {
    private int mBatterLevel;

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ BatteryWatcher this$0;

        private BatteryBroadcastReceiver(BatteryWatcher r10) {
            this.this$0 = r10;
        }

        /* synthetic */ BatteryBroadcastReceiver(BatteryWatcher r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if ("android.intent.action.BATTERY_CHANGED".equals(r11.getAction()) == false) goto L9;
            int r12 = r11.getIntExtra("level", 0);     // Catch: Throwable -> L6
            BatteryWatcher.access$202(this.this$0, (int) ((r12 * 100.0f) / r11.getIntExtra("scale", 100)));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    BatteryWatcher(final Context r10) {
        NpthHandlerThread.getDefaultHandler().post(new AnonymousClass1(this, r10));
    }

    static /* synthetic */ void access$000(BatteryWatcher r10, Context r11) {
        r10.initBatteryWatcher(r11);
    }

    static /* synthetic */ int access$202(BatteryWatcher r10, int r11) {
        r10.mBatterLevel = r11;
        return r11;
    }

    private void initBatteryWatcher(Context r10) {
        r10.registerReceiver(new BatteryBroadcastReceiver(this, null), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int getBatterLevel() {
        return this.mBatterLevel;
    }
}
