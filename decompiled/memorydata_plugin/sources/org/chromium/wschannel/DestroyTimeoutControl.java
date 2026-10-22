package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class DestroyTimeoutControl {
    private static final String DESTROY_TIME_OUT_MILLS = "destroy_timeout_millis";
    private static final String FALLBACK_TIMEOUT_MILLS = "fallback_timeout_mills";
    private static final int FALL_BACK_SECONDS = 10;
    private static final long MIN_TIMEOUT_MILLS = 1000;
    private static final String PP_ERROR_MSG = "\\\"internal_error\\\":67";
    private static final String PP_QUIC_ERROR_CODE = "\"error_code\":-356";
    private static final String PP_TLS_ERROR_CODE = "\"error_code\":-193";
    private static final String TAG = "CronetFrontierConnection";
    private static final String WS_ERROR_CODE = "\\\"net_error\\\":-7";
    private static final String WS_ERROR_MSG = "WebSocket opening handshake timed out";
    private static long sDestroyDeltaMillis = 100;
    private static volatile boolean sEnabled;
    private volatile boolean mFallbackToWebsocket;
    private long mPrivateProtocolTimeout;
    private long mWebsocketTimeout;

    static {
    }

    public DestroyTimeoutControl(Map<String, Object> r12, boolean r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        this.mFallbackToWebsocket = true;
        if (f.m() <= 0) goto L5;
        sDestroyDeltaMillis = f.m();
        long r5 = getConfigTimeoutMilliSeconds(r14, DESTROY_TIME_OUT_MILLS, 0);
        if (r5 < 1000) goto L11;
        sEnabled = true;
        if (r13 == false) goto L20;
        this.mWebsocketTimeout = r5 - sDestroyDeltaMillis;
        if (Logger.debug() == false) goto L39;
        Logger.d(TAG, "Destroy ws timeout: " + this.mWebsocketTimeout);
        return;
    L39:
        return;
    L20:
        long r15 = getConfigTimeoutMilliSeconds(r14, FALLBACK_TIMEOUT_MILLS, 10000);
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "fallback timeout:" + r15 + " destroy timeout:" + r5);
    L24:
        if (r15 < r5) goto L30;
        this.mFallbackToWebsocket = false;
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.mPrivateProtocolTimeout = r5 - sDestroyDeltaMillis;
        return;
    L30:
        long r7 = sDestroyDeltaMillis;
        this.mPrivateProtocolTimeout = r15 - r7;
        long r6 = (r5 - r15) - r7;
        this.mWebsocketTimeout = r6;
        if (r6 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "Disable fallback to websocket, timeout <= 0:" + this.mWebsocketTimeout);
    L35:
        this.mFallbackToWebsocket = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Destroy timeout disable: " + r5);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Destroy delta disable: " + f.m());
        return;
    }

    private static long getConfigTimeoutMilliSeconds(Map<String, Object> r2, String r3, long r4) {
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get(WsConstants.KEY_HEADERS), Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return r4;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r5.containsKey(r3) == true) goto L10;
        return r4;
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(r3), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L18;
        return r4;
    L18:
        int r7 = Integer.valueOf(r6).intValue();     // Catch: Exception -> L17
        if (r7 > 0) goto L16;
        return r4;
    L16:
        return r7;
    L23:
        return r4;
    }

    public static boolean isConnectionTimeout(String r2, boolean r3) {
        if (sEnabled == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r3 == false) goto L16;
        if (r2.contains(WS_ERROR_CODE) == true) goto L12;
        return false;
    L12:
        if (r2.contains(WS_ERROR_MSG) == true) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (r2.contains(PP_TLS_ERROR_CODE) == true) goto L22;
        if (r2.contains(PP_QUIC_ERROR_CODE) == true) goto L20;
        return false;
    L20:
        if (r2.contains(PP_ERROR_MSG) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public long getPrivateProtocolTimeout() {
        if (sEnabled == true) goto L7;
        return 0;
    L7:
        return this.mPrivateProtocolTimeout;
    }

    public long getWebsocketTimeout() {
        if (sEnabled == true) goto L7;
        return 0;
    L7:
        return this.mWebsocketTimeout;
    }

    public boolean shouldFallbackToWebSocket() {
        if (sEnabled == true) goto L7;
        return true;
    L7:
        return this.mFallbackToWebsocket;
    }
}
