package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.common.Ext;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H'J$\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J3\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H&¨\u0006$"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/INetworkBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "send", "", "requestJson", "Lorg/json/JSONObject;", "sendRequest", "Lcom/obric/memorydata/middleware/api/bridge/Response;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/middleware/api/bridge/HttpRequest;", "uploadImageX", "uri", "sourcePackage", "bizName", "resize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "uploadAuditoryWavImageX", "taskId", "accountScope", "getImageBase64", "entityId", "imageUri", "startSSE", "readSSENext", "streamId", "timeoutMs", "abortSSE", "abortSSEByTaskId", "beginSSETaskInvocation", "", "invocationId", "", "endSSETaskInvocation", "abortSSEByTaskInvocationTimeout", "abortSSEByTaskTimeout", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface INetworkBridgeAPI extends IService {
    String abortSSE(String r1);

    String abortSSEByTaskId(String r1);

    String abortSSEByTaskInvocationTimeout(String r1, long r2);

    String abortSSEByTaskTimeout(String r1);

    void beginSSETaskInvocation(String r1, long r2);

    void endSSETaskInvocation(String r1, long r2);

    String getImageBase64(String r1, String r2);

    String readSSENext(String r1, int r2);

    String send(JSONObject r1);

    Response sendRequest(HttpRequest r1);

    String startSSE(JSONObject r1);

    String startSSE(JSONObject r1, String r2);

    String uploadAuditoryWavImageX(String r1, String r2);

    @Deprecated(message = "兼容老的算法包，后续删掉")
    String uploadImageX(String r1, String r2);

    String uploadImageX(String r1, String r2, String r3);

    String uploadImageX(String r1, String r2, String r3, Integer r4);
}
