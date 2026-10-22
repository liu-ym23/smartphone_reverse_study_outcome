package com.bytedance.apm6.consumer.slardar.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface SlardarHandlerConfigService {
    SlardarHandlerConfig getConfig();

    void setOutsideConfig(JSONObject r1);
}
