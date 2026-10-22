package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface ICronetClient {
    public static final String KEY_CONNECT_TIME = "connect_time";
    public static final String KEY_DNS_TIME = "dns_time";
    public static final String KEY_POST_TASK_START = "post_task_start";
    public static final String KEY_PUSH_TIME = "push_time";
    public static final String KEY_RECEIVED_BYTE_COUNT = "received_byte_count";
    public static final String KEY_RECEIVE_TIME = "receive_time";
    public static final String KEY_REMOTE_IP = "remote_ip";
    public static final String KEY_REQUEST_HEADERS = "request_headers";
    public static final String KEY_REQUEST_START = "request_start";
    public static final String KEY_RESPONSE_HEADERS = "response_headers";
    public static final String KEY_RETRY_ATTEMPTS = "retry_attempts";
    public static final String KEY_SEND_BYTE_COUNT = "send_byte_count";
    public static final String KEY_SEND_TIME = "send_time";
    public static final String KEY_SOCKET_REUSED = "socket_reused";
    public static final String KEY_SSL_TIME = "ssl_time";
    public static final String KEY_TOTAL_TIME = "total_time";
    public static final String KEY_TTFB = "ttfb";
    public static final String KEY_WAIT_CONTEXT = "wait_ctx";

    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    int getCronetInternalErrorCode(HttpURLConnection r5);

    String getCronetVersion();

    void getRequestMetrics(HttpURLConnection r5, Map<String, Object> r10);

    boolean isCronetHttpURLConnection(HttpURLConnection r5);

    HttpURLConnection openConnection(Context r5, String r10, boolean r11, String r12, Executor r13) throws IOException;

    void setCronetBootFailureChecker(ICronetBootFailureChecker r5);

    void setCronetEngine(Context r5, boolean r10, boolean r11, boolean r12, boolean r13, String r14, Executor r15, boolean r16);
}
