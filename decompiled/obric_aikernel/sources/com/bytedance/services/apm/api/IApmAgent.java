package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import t4.b;

/* JADX INFO: loaded from: classes.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r10, JSONObject r11);

    @Deprecated
    void monitorDuration(String r10, JSONObject r11, JSONObject r12);

    void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13);

    void monitorEvent(b r10);

    void monitorExceptionLog(String r10, JSONObject r11);

    @Deprecated
    void monitorLog(String r10, JSONObject r11);

    @Deprecated
    void monitorStatusAndDuration(String r10, int r11, JSONObject r12, JSONObject r13);

    @Deprecated
    void monitorStatusRate(String r10, int r11, JSONObject r12);

    void reportLegacyMonitorLog(Context r10, long r11, long r12, boolean r13);
}
