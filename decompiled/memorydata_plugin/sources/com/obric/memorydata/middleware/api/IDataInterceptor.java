package com.obric.memorydata.middleware.api;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/api/IDataInterceptor;", "Lcom/bytedance/news/common/service/manager/IService;", "interceptLog", "", LocationMonitorConst.TAG, "", "level", "", NotificationCompat.CATEGORY_MESSAGE, "interceptTracker", "eventName", "jsonObject", "Lorg/json/JSONObject;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IDataInterceptor extends IService {
    boolean interceptLog(String r1, int r2, String r3);

    boolean interceptTracker(String r1, JSONObject r2);
}
