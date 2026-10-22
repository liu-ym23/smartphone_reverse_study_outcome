package com.obric.memorydata.middleware.api.bridge;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!H\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J\t\u0010'\u001a\u00020\u001bH\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001J\t\u0010)\u001a\u00020\tH\u0096\u0001J\t\u0010*\u001a\u00020\tH\u0096\u0001J\t\u0010+\u001a\u00020\tH\u0096\u0001J\t\u0010,\u001a\u00020\tH\u0096\u0001J\t\u0010-\u001a\u00020\tH\u0096\u0001J\u0011\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020!H\u0096\u0001J\u0011\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0005H\u0096\u0001J\u0011\u00102\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0005H\u0096\u0001J'\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010605H\u0096\u0001J\u0011\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0005H\u0096\u0001J'\u00109\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010605H\u0096\u0001¨\u0006:"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/CoreBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ICoreBridgeAPI;", "<init>", "()V", "callBizAsFlow", "", "modelName", Params.CONTENT, "useCloud", "", "callPackage", "Lorg/json/JSONObject;", "bizName", "input", "deleteFile", Params.FILE_PATH, "enqueueTask", "", "taskInfo", "functionCall", "apiName", TrackerImpl.PARAMS, "getAppName", ObricMemoryConstants.KEY_PACKAGE_NAME, "getDeviceModel", "getImageDimensions", "", "", "uri", "getInstalledAppList", "getLocation", "", "effectiveTimeInterval", "", "getRomReleaseRegion", "getSetting", "table", "key", "getSystemLocale", "getTemperatureState", "getUid", "isAIKernelAvailable", "isDebug", "isObricOsDevice", "isSupportVLM", "isUTDataCollectEnabled", "isWorkDay", "ts", "removeTask", ActivityLifecycle.NAME, "removeTaskIncludingScheduled", "reportDevelopEvent", "event", "", "", "reportError", NotificationCompat.CATEGORY_MESSAGE, "reportEvent", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoreBridgeAPI implements ICoreBridgeAPI {
    public static final CoreBridgeAPI INSTANCE = null;
    private final /* synthetic */ ICoreBridgeAPI $$delegate_0;

    static {
        INSTANCE = new CoreBridgeAPI();
    }

    private CoreBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ICoreBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ICoreBridgeAPI) ZeusTransformUtils.preCheckCast(r0, ICoreBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String callBizAsFlow(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "modelName");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        return this.$$delegate_0.callBizAsFlow(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public JSONObject callPackage(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "input");
        return this.$$delegate_0.callPackage(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean deleteFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, Params.FILE_PATH);
        return this.$$delegate_0.deleteFile(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void enqueueTask(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "taskInfo");
        this.$$delegate_0.enqueueTask(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String functionCall(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "apiName");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        return this.$$delegate_0.functionCall(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getAppName(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.getAppName(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getDeviceModel() {
        return this.$$delegate_0.getDeviceModel();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public List<Integer> getImageDimensions(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.$$delegate_0.getImageDimensions(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public JSONObject getInstalledAppList() {
        return this.$$delegate_0.getInstalledAppList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public List<Double> getLocation(long r1) {
        return this.$$delegate_0.getLocation(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getRomReleaseRegion() {
        return this.$$delegate_0.getRomReleaseRegion();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getSetting(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getSetting(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getSystemLocale() {
        return this.$$delegate_0.getSystemLocale();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public int getTemperatureState() {
        return this.$$delegate_0.getTemperatureState();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getUid() {
        return this.$$delegate_0.getUid();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isAIKernelAvailable() {
        return this.$$delegate_0.isAIKernelAvailable();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isObricOsDevice() {
        return this.$$delegate_0.isObricOsDevice();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isSupportVLM() {
        return this.$$delegate_0.isSupportVLM();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isUTDataCollectEnabled() {
        return this.$$delegate_0.isUTDataCollectEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isWorkDay(long r1) {
        return this.$$delegate_0.isWorkDay(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void removeTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.$$delegate_0.removeTask(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void removeTaskIncludingScheduled(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.$$delegate_0.removeTaskIncludingScheduled(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportDevelopEvent(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        this.$$delegate_0.reportDevelopEvent(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportError(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.reportError(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportEvent(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        this.$$delegate_0.reportEvent(r3, r5);
    }
}
