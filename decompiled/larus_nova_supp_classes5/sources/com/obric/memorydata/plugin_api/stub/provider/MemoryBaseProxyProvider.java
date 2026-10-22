package com.obric.memorydata.plugin_api.stub.provider;

import android.os.Bundle;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.obric.memorydata.plugin_api.MemoryPluginActiveState;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MemoryBaseProxyProvider extends BaseProxyProvider {
    public final String getPluginName() {
        return MemoryPlugin.PLUGIN_PKG_NAME;
    }

    public MemoryBaseProxyProvider() {
    }

    public Bundle call(String r1, String r2, Bundle r3) {
        MemoryPluginActiveState.onEnter();
        Bundle r4 = super.call(r1, r2, r3);     // Catch: Throwable -> L6
        MemoryPluginActiveState.onExit();
        return r4;
    L6:
        th = move-exception;
        MemoryPluginActiveState.onExit();
        throw th;
    }

    public Bundle call(String r1, String r2, String r3, Bundle r4) {
        MemoryPluginActiveState.onEnter();
        Bundle r5 = super.call(r1, r2, r3, r4);     // Catch: Throwable -> L6
        MemoryPluginActiveState.onExit();
        return r5;
    L6:
        th = move-exception;
        MemoryPluginActiveState.onExit();
        throw th;
    }
}
