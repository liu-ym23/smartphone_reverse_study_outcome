package com.bytedance.ies.abmock.datacenter.plugin;

import com.bytedance.ies.abmock.ConfigItem;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseConfigPlugin {
    protected Map<String, ConfigItem> configMap;

    public BaseConfigPlugin() {
        this.configMap = new HashMap();
        addConfigStub();
    }

    public void addConfigStub() {
    }

    public Map<String, ConfigItem> getConfigMap() {
        return this.configMap;
    }
}
