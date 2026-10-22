package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
import r2.g;
import r2.h;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetClient {
    public static final String KEY_BYPASS_API_REPORT = "bypass_api_report";
    public static final String KEY_CONNECT_TIME = "connect_time";
    public static final String KEY_DNS_TIME = "dns_time";
    public static final String KEY_POST_TASK_START = "post_task_start";
    public static final String KEY_PRE_SAMPLING_REPORTABLE = "pre_sampling_reportable";
    public static final String KEY_PUSH_TIME = "push_time";
    public static final String KEY_RECEIVED_BYTE_COUNT = "received_byte_count";
    public static final String KEY_RECEIVE_TIME = "receive_time";
    public static final String KEY_REMOTE_IP = "remote_ip";
    public static final String KEY_REQUEST_HEADERS = "request_headers";
    public static final String KEY_REQUEST_LOG = "request_log";
    public static final String KEY_REQUEST_START = "request_start";
    public static final String KEY_REQ_COOKIE_SOURCE_TYPE = "req_cookie_source_type";
    public static final String KEY_RESPONSE_HEADERS = "response_headers";
    public static final String KEY_RETRY_ATTEMPTS = "retry_attempts";
    public static final String KEY_SEND_BYTE_COUNT = "send_byte_count";
    public static final String KEY_SEND_TIME = "send_time";
    public static final String KEY_SOCKET_REUSED = "socket_reused";
    public static final String KEY_SSL_TIME = "ssl_time";
    public static final String KEY_TOTAL_TIME = "total_time";
    public static final String KEY_TTFB = "ttfb";
    public static final String KEY_UPPER_ADD_COOKIE_US = "upper_add_cookie_us";
    public static final String KEY_UPPER_SAVE_COOKIE_US = "upper_save_cookie_us";
    public static final String KEY_WAIT_CONTEXT = "wait_ctx";

    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    void addClientOpaqueData(String[] r10, byte[] r11, byte[] r12, long r13, long r14);

    void bindBigCore(TTNetThreadConfig.ThreadType r10);

    void bindLittleCore(TTNetThreadConfig.ThreadType r10);

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15);

    int getCronetInternalErrorCode(HttpURLConnection r10);

    String getCronetVersion();

    int getEffectiveConnectionType();

    int getEffectiveHttpRttMs();

    int getEffectiveRxThroughputKbps();

    int getEffectiveTransportRttMs();

    Map<String, g> getGroupRttEstimates();

    void getMappingRequestState(String r10);

    g getNetworkQuality();

    int getNetworkQualityLevel();

    h getPacketLossRateMetrics(int r10);

    Map<String, Object> getRequestMetricsMap(HttpURLConnection r10);

    boolean isCronetHttpURLConnection(HttpURLConnection r10);

    void notifyStoreRegionUpdated(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110);

    boolean notifySwitchToMultiNetwork(boolean r10);

    void notifyTNCConfigUpdated(String r10, String r11, String r12, String r13, String r14, String r15);

    HttpURLConnection openConnection(Context r10, String r11, boolean r12, String r13, boolean r14, Executor r15, ICronetAppProvider r16);

    void preconnectUrl(String r10, Map<String, String> r11);

    void removeClientOpaqueData(String r10);

    void reportNetDiagnosisUserLog(String r10);

    void resetCoreBind(TTNetThreadConfig.ThreadType r10);

    void runInBackGround(boolean r10);

    void setAlogFuncAddr(long r10);

    void setBestHostWithRouteSelectionName(String r10, String r11);

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider r10);

    void setHostResolverRules(String r10);

    void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12);

    void setProxy(String r10);

    void setSlaSamplingSetting(JSONObject r10);

    void setZstdFuncAddr(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r17);

    void startThrottle(String[] r10, int r11, long r12);

    void stopThrottle(String[] r10, int r11);

    void triggerGetDomain(boolean r10);

    void triggerSwitchingToCellular();

    void tryCreateCronetEngine(Context r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, Executor r16, boolean r17, ICronetAppProvider r18);

    void tryStartNetDetect(String[] r10, int r11, int r12);

    void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13);

    TTDispatchResult ttUrlDispatch(String r10, int r11, boolean r12);
}
