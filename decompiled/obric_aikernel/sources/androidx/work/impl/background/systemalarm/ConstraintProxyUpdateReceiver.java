package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");
    }

    public ConstraintProxyUpdateReceiver() {
    }

    @NonNull
    public static Intent newConstraintProxyUpdateIntent(@NonNull Context r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        Intent r15 = new Intent(ACTION);
        r15.setComponent(new ComponentName(r10, ConstraintProxyUpdateReceiver.class));
        r15.putExtra(KEY_BATTERY_NOT_LOW_PROXY_ENABLED, r11).putExtra(KEY_BATTERY_CHARGING_PROXY_ENABLED, r12).putExtra(KEY_STORAGE_NOT_LOW_PROXY_ENABLED, r13).putExtra(KEY_NETWORK_STATE_PROXY_ENABLED, r14);
        return r15;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull final Context r10, @Nullable final Intent r11) {
        if (r11 == null) goto L4;
        String r12 = r11.getAction();
    L6:
        if (ACTION.equals(r12) == true) goto L8;
        Logger.get().debug(TAG, "Ignoring unknown action " + r12);
        return;
    L8:
        final BroadcastReceiver.PendingResult r13 = goAsync();
        WorkManagerImpl.getInstance(r10).getWorkTaskExecutor().executeOnTaskThread(new AnonymousClass1(this, r11, r10, r13));
        return;
    L4:
        r12 = null;
        goto L6
    }
}
