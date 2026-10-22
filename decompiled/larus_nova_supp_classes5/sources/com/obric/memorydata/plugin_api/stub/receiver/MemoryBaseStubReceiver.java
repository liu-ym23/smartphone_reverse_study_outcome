package com.obric.memorydata.plugin_api.stub.receiver;

import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.volcengine.zeus.receiver.BaseProxyStaticReceiver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MemoryBaseStubReceiver extends BaseProxyStaticReceiver {
    public final String getPluginPkgName() {
        return MemoryPlugin.PLUGIN_PKG_NAME;
    }

    public MemoryBaseStubReceiver() {
    }
}
