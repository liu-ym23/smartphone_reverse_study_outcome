package com.obric.aiagent.plugin_api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.util.MethodUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PluginService$2 implements ServiceConnection {
    public PluginService$2() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        MethodUtils.invokeMethod(r3, "play", new Object[0]);     // Catch: Throwable -> L4
        return;
    }
}
