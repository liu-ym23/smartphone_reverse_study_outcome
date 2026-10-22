package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import oj.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r5, JSONObject r10);

    @Deprecated
    void monitorDuration(String r5, JSONObject r10, JSONObject r11);

    void monitorEvent(String r5, JSONObject r10, JSONObject r11, JSONObject r12);

    void monitorEvent(a r5);

    void monitorExceptionLog(String r5, JSONObject r10);

    @Deprecated
    void monitorLog(String r5, JSONObject r10);

    @Deprecated
    void monitorStatusAndDuration(String r5, int r10, JSONObject r11, JSONObject r12);

    @Deprecated
    void monitorStatusRate(String r5, int r10, JSONObject r11);

    void reportLegacyMonitorLog(Context r5, long r10, long r11, boolean r12);
}
