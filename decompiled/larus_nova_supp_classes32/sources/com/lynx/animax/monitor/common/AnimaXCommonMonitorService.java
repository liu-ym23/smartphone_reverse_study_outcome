package com.lynx.animax.monitor.common;

import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.service.IAutoRegisterAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import v4a.a;
import v4a.c;
import w4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXCommonMonitorService implements IAnimaXMonitorService, IAutoRegisterAnimaXService {
    private static final String INTEGRATION_TYPE_DEFAULT = "default";
    private static final String TAG = "AnimaXCommonMonitorService";
    private String mCurrentUrl;

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public final /* synthetic */ e getAutoRegisterServiceScope() {
        return IAutoRegisterAnimaXService.CC.$default$getAutoRegisterServiceScope(this);
    }

    public AnimaXCommonMonitorService() {
        this.mCurrentUrl = "unknown";
    }

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public Class<? extends IAnimaXMonitorService> getServiceClass() {
        return IAnimaXMonitorService.class;
    }

    private void appendNativeCommonParams(Map<String, Object> r3) {
        r3.put("src_url", a.a(this.mCurrentUrl));
        r3.put("integration_type", "default");
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportError(t4a.a r4) {
        if (r4 != null) goto L6;
        AnimaXLog.a(TAG, "report failed, errorInfo is null.");
        return;
    L6:
        HashMap r1 = new HashMap();
        Map<String, Object> r5 = r4.a;
        if (r5 == null) goto L9;
        r1.putAll(r5);
    L9:
        appendNativeCommonParams(r1);
        JSONObject r6 = a.b(r1);
        AnimaXLog.b(TAG, "reportError: " + r6);
        AppLogNewUtils.onEventV3("animax_error", r6);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportPerformanceMetrics(c r5) {
        if (r5 != null) goto L7;
        AnimaXLog.a(TAG, "report failed, metrics is null.");
        return;
    L7:
        if ((!"unknown".equals(this.mCurrentUrl)) == true) goto L9;
        return;
    L9:
        HashMap r1 = new HashMap();
        r1.putAll(new HashMap(r5.b.asHashMap()));
        r1.putAll(new HashMap(r5.a.asHashMap()));
        appendNativeCommonParams(r1);
        JSONObject r6 = a.b(r1);
        AnimaXLog.b(TAG, "reportPerformance: " + r6);
        AppLogNewUtils.onEventV3("animax_performance", r6);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void setCurrentUrl(String r1) {
        this.mCurrentUrl = r1;
    }
}
