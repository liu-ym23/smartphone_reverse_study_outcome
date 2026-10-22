package com.obric.aikernel.middleware.api.commonmonitor;

import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IApmManager extends IService {

    public static final class a {
        public static /* synthetic */ void a(IApmManager r10, String r11, boolean r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L6;
            r12 = false;
        L6:
            r10.endSpan(r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endSpan");
        }
    }

    void addExtendedParams(Map<String, String> r10);

    void endSpan(String r10, String r11, boolean r12);

    void endSpan(String r10, boolean r11);

    void endTrace();

    void markAsNewApp();

    void reportThreadCount(String r10);

    void setEnterFrom(String r10);

    void slardarMonitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13);

    void startSpan(String r10);

    void startSpan(String r10, String r11);

    void startTrace();
}
