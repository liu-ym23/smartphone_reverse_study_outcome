package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import oj.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String r5, String r10);

    void getLegacyLog(long r5, long r10, String r11, e r12);

    List<JSONObject> getRecentUiActionRecords();
}
