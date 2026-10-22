package okhttp3;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lokhttp3/WebSocketListener;", "", "()V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", InfoRequestQPSOptTraceLogger.REASON, "", "onClosing", "onFailure", "t", "", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "onMessage", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "bytes", "Lokio/ByteString;", "onOpen", "okhttp"}, k = 1, mv = {1, 1, 15})
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public void onClosed(WebSocket r1, int r2, String r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r1, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r3, InfoRequestQPSOptTraceLogger.REASON);
    }

    public void onClosing(WebSocket r1, int r2, String r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r1, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r3, InfoRequestQPSOptTraceLogger.REASON);
    }

    public void onFailure(WebSocket r1, Throwable r2, Response r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r1, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r2, "t");
    }

    public void onMessage(WebSocket r2, String r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
    }

    public void onMessage(WebSocket r2, ByteString r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r3, "bytes");
    }

    public void onOpen(WebSocket r2, Response r3) {
        Intrinsics.checkParameterIsNotNull((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
        Intrinsics.checkParameterIsNotNull(r3, ChatMessage.TYPE_RESPONSE);
    }
}
