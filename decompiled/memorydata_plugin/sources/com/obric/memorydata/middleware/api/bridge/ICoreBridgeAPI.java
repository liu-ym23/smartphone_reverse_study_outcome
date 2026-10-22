package com.obric.memorydata.middleware.api.bridge;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H&J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H&J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\u001bH&J&\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u001bH&J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0017H&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010$\u001a\u00020\fH&J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0017H&J\b\u0010'\u001a\u00020\fH&J\u001a\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH&J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0006H&J\b\u0010-\u001a\u00020\u001bH&J\b\u0010.\u001a\u00020\u001bH&J\b\u0010/\u001a\u00020\u001bH&J\b\u00100\u001a\u00020\u001bH&J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\fH&J\b\u00103\u001a\u00020\fH&J\b\u00104\u001a\u00020\fH&J\b\u00105\u001a\u00020\fH&J\u001a\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fH&¨\u00068"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/ICoreBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "getLocation", "", "", "effectiveTimeInterval", "", "getTemperatureState", "", "removeTask", "", ActivityLifecycle.NAME, "", "removeTaskIncludingScheduled", "reportEvent", "event", TrackerImpl.PARAMS, "", "", "reportDevelopEvent", "getAppName", ObricMemoryConstants.KEY_PACKAGE_NAME, "getInstalledAppList", "Lorg/json/JSONObject;", "reportError", NotificationCompat.CATEGORY_MESSAGE, "isDebug", "", "callBizAsFlow", "modelName", Params.CONTENT, "useCloud", "callPackage", "bizName", "input", "getImageDimensions", "uri", "enqueueTask", "taskInfo", "getUid", "getSetting", "table", "key", "isWorkDay", "ts", "isAIKernelAvailable", "isSupportVLM", "isObricOsDevice", "isUTDataCollectEnabled", "deleteFile", Params.FILE_PATH, "getDeviceModel", "getRomReleaseRegion", "getSystemLocale", "functionCall", "apiName", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICoreBridgeAPI extends IService {
    String callBizAsFlow(String r1, String r2, boolean r3);

    JSONObject callPackage(String r1, JSONObject r2);

    boolean deleteFile(String r1);

    void enqueueTask(JSONObject r1);

    String functionCall(String r1, String r2);

    String getAppName(String r1);

    String getDeviceModel();

    List<Integer> getImageDimensions(String r1);

    JSONObject getInstalledAppList();

    List<Double> getLocation(long r1);

    String getRomReleaseRegion();

    String getSetting(String r1, String r2);

    String getSystemLocale();

    int getTemperatureState();

    String getUid();

    boolean isAIKernelAvailable();

    boolean isDebug();

    boolean isObricOsDevice();

    boolean isSupportVLM();

    boolean isUTDataCollectEnabled();

    boolean isWorkDay(long r1);

    void removeTask(String r1);

    void removeTaskIncludingScheduled(String r1);

    void reportDevelopEvent(String r1, Map<String, ? extends Object> r2);

    void reportError(String r1);

    void reportEvent(String r1, Map<String, ? extends Object> r2);
}
