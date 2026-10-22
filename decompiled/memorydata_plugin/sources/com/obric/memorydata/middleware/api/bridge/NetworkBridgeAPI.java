package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\u001d\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0097\u0001J%\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J4\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/NetworkBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/INetworkBridgeAPI;", "<init>", "()V", "abortSSE", "", "streamId", "abortSSEByTaskId", "taskId", "abortSSEByTaskInvocationTimeout", "invocationId", "", "abortSSEByTaskTimeout", "beginSSETaskInvocation", "", "endSSETaskInvocation", "getImageBase64", "entityId", "imageUri", "readSSENext", "timeoutMs", "", "send", "requestJson", "Lorg/json/JSONObject;", "sendRequest", "Lcom/obric/memorydata/middleware/api/bridge/Response;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/middleware/api/bridge/HttpRequest;", "startSSE", "uploadAuditoryWavImageX", "accountScope", "uploadImageX", "uri", "sourcePackage", "bizName", "resize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkBridgeAPI implements INetworkBridgeAPI {
    public static final NetworkBridgeAPI INSTANCE = null;
    private final /* synthetic */ INetworkBridgeAPI $$delegate_0;

    static {
        INSTANCE = new NetworkBridgeAPI();
    }

    private NetworkBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(INetworkBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (INetworkBridgeAPI) ZeusTransformUtils.preCheckCast(r0, INetworkBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSE(String r2) {
        Intrinsics.checkNotNullParameter(r2, "streamId");
        return this.$$delegate_0.abortSSE(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.$$delegate_0.abortSSEByTaskId(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskInvocationTimeout(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.$$delegate_0.abortSSEByTaskInvocationTimeout(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String abortSSEByTaskTimeout(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.$$delegate_0.abortSSEByTaskTimeout(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public void beginSSETaskInvocation(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.$$delegate_0.beginSSETaskInvocation(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public void endSSETaskInvocation(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.$$delegate_0.endSSETaskInvocation(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String getImageBase64(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, "imageUri");
        return this.$$delegate_0.getImageBase64(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String readSSENext(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "streamId");
        return this.$$delegate_0.readSSENext(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String send(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        return this.$$delegate_0.send(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public Response sendRequest(HttpRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return this.$$delegate_0.sendRequest(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String startSSE(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        return this.$$delegate_0.startSSE(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String startSSE(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        return this.$$delegate_0.startSSE(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadAuditoryWavImageX(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        return this.$$delegate_0.uploadAuditoryWavImageX(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    @Deprecated(message = "兼容老的算法包，后续删掉")
    public String uploadImageX(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.$$delegate_0.uploadImageX(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadImageX(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return this.$$delegate_0.uploadImageX(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.INetworkBridgeAPI
    public String uploadImageX(String r2, String r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return this.$$delegate_0.uploadImageX(r2, r3, r4, r5);
    }
}
