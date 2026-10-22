package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/ITracker;", "Lcom/bytedance/news/common/service/manager/IService;", "reportEvent", "", "event", "", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "reportEventAccepted", "", "reportDevEvent", "data", "reportWithSystemId", "", "", "registerDailyReportCallback", "callback", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "unregisterDailyReportCallback", "startDailyReport", "registerReportEventRejectedHandler", "handler", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ITracker extends IService {
    void registerDailyReportCallback(a r1);

    void registerReportEventRejectedHandler(String r1, b r2);

    void reportDevEvent(String r1, JSONObject r2);

    void reportEvent(String r1, JSONObject r2);

    boolean reportEventAccepted(String r1, JSONObject r2);

    void reportWithSystemId(String r1, Map<String, ? extends Object> r2);

    void startDailyReport();

    void unregisterDailyReportCallback(a r1);
}
