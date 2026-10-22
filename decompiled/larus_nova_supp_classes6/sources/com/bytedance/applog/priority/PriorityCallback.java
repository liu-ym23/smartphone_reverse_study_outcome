package com.bytedance.applog.priority;

import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface PriorityCallback {
    boolean allowIsolateReport(String r1, String r2);

    PriorityHttpResponse doHttpPost(String r1, byte[] r2, Pair<String, String> r3);

    String getHeaderJson();

    Object getOpaquePayloadJson();

    boolean isMonitorEnabled();

    boolean isNetworkAvailable();

    boolean isStageEnabled();

    String isolateKey();

    void monitorError(String r1, String r2);

    void monitorIncreaseStats(String r1, int r2);

    void monitorLatency(int r1, int r2, int r3);

    void monitorStage(String r1, String r2, int r3, int r4, String r5, String r6, long r7);

    void printLog(int r1, String r2);
}
