package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintProxy extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2843a = null;

    public static class BatteryChargingProxy extends ConstraintProxy {
        public BatteryChargingProxy() {
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public BatteryNotLowProxy() {
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public NetworkStateProxy() {
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public StorageNotLowProxy() {
        }
    }

    static {
        f2843a = m.f("ConstraintProxy");
    }

    public ConstraintProxy() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        m.d().a(f2843a, "onReceive : " + r10);
        String r11 = a.f2852o;
        Intent r12 = new Intent(r8, SystemAlarmService.class);
        r12.setAction("ACTION_CONSTRAINTS_CHANGED");
        r8.startService(r12);
    }
}
