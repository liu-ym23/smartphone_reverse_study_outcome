package com.ttnet.org.chromium.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class PowerMonitor$AppStateReceiver extends BroadcastReceiver {
    public PowerMonitor$AppStateReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r5, Intent r6) {
        long r0 = System.currentTimeMillis();
        String r7 = r6.getAction();
        if (r7.equals(PowerMonitor.access$000()) == false) goto L6;
        PowerMonitorJni.get().onInstantResume();
        return;
    L6:
        if (r7.equals(PowerMonitor.access$100()) == false) goto L9;
        PowerMonitorJni.get().onInstantSuspend();
        return;
    L9:
        if (r7.equals(PowerMonitor.access$200()) == false) goto L11;
    L20:
        long r8 = r0 - PowerMonitor.access$400();
        PowerMonitor.access$402(r0);
        if (r8 <= 10000) goto L29;
        PowerMonitorJni.get().onResume();
        return;
    L29:
        return;
    L11:
        if (r7.equals(PowerMonitor.access$300()) == true) goto L20;
        if (r7.equals(PowerMonitor.access$500()) == false) goto L16;
    L17:
        long r9 = r0 - PowerMonitor.access$700();
        PowerMonitor.access$702(r0);
        if (r9 <= 10000) goto L27;
        PowerMonitorJni.get().onSuspend();
        return;
    L27:
        return;
    L16:
        if (r7.equals(PowerMonitor.access$600()) == true) goto L17;
    }
}
