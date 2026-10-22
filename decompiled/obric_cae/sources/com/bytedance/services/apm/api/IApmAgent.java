package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import u8.a;

/* JADX INFO: loaded from: classes.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r8, JSONObject r10);

    @Deprecated
    void monitorDuration(String r8, JSONObject r10, JSONObject r11);

    void monitorEvent(String r8, JSONObject r10, JSONObject r11, JSONObject r12);

    void monitorEvent(a r8);

    void monitorExceptionLog(String r8, JSONObject r10);

    @Deprecated
    void monitorLog(String r8, JSONObject r10);

    @Deprecated
    void monitorStatusAndDuration(String r8, int r10, JSONObject r11, JSONObject r12);

    @Deprecated
    void monitorStatusRate(String r8, int r10, JSONObject r11);

    void reportLegacyMonitorLog(Context r8, long r10, long r11, boolean r12);
}
