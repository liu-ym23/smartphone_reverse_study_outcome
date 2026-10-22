package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.b;
import f1.n;

/* JADX INFO: loaded from: classes.dex */
public class Collector extends BroadcastReceiver {
    public Collector() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        String[] r12 = r11.getStringArrayExtra("K_DATA");
        if (r12 != null) goto L5;
    L7:
        n.B().c("Collector onReceive empty", new Object[0]);
        return;
    L5:
        if (r12.length <= 0) goto L7;
        b.f(r12);
    }
}
