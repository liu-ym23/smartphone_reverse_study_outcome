package com.lynx.debugrouter.base.report;

import com.lynx.debugrouter.base.service.IRouterServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IDebugRouterReportService extends IRouterServiceProvider {
    void init(DebugRouterMetaInfo r1);

    void report(String r1, JSONObject r2, JSONObject r3, JSONObject r4);
}
