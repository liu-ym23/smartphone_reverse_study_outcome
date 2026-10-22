package r5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class d extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r10.getAction()) == false) goto L5;
    L8:
        e.f11502a = e.d(r8);
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r10.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r10.getAction()) == true) goto L8;
    }
}
