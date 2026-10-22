package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import org.json.JSONObject;
import u8.d;

/* JADX INFO: loaded from: classes.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String r8, String r10);

    void getLegacyLog(long r8, long r10, String r11, d r12);

    List<JSONObject> getRecentUiActionRecords();
}
