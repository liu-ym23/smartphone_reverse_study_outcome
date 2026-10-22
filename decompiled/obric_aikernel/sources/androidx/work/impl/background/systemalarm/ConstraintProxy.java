package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String TAG = null;

    public static class BatteryChargingProxy extends ConstraintProxy {
        public BatteryChargingProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public BatteryNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public NetworkStateProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public StorageNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("ConstraintProxy");
    }

    ConstraintProxy() {
    }

    static void updateAll(Context r10, List<WorkSpec> r11) {
        Iterator<WorkSpec> r12 = r11.iterator();
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
    L4:
        if (r12.hasNext() == false) goto L14;
        Constraints r17 = r12.next().constraints;
        r13 = r13 | r17.requiresBatteryNotLow();
        r14 = r14 | r17.requiresCharging();
        r15 = r15 | r17.requiresStorageNotLow();
        if (r17.getRequiredNetworkType() == NetworkType.NOT_REQUIRED) goto L8;
        boolean r18 = true;
    L9:
        r16 = r16 | r18;
        if (r13 == false) goto L4;
        if (r14 == false) goto L4;
        if (r15 == false) goto L4;
        if (r16 == false) goto L4;
    L8:
        r18 = false;
    L14:
        r10.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(r10, r13, r14, r15, r16));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        Logger.get().debug(TAG, "onReceive : " + r11);
        r10.startService(CommandHandler.createConstraintsChangedIntent(r10));
    }
}
