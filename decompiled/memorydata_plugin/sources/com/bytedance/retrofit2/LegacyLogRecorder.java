package com.bytedance.retrofit2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface LegacyLogRecorder {
    @Deprecated
    void generateOldFormatLog(JSONObject r1);

    @Deprecated
    void setAccountRetryCallbackDuration(long r1);

    @Deprecated
    void setBdTuringCallbackDuration(long r1);

    @Deprecated
    void setKernelDns(long r1);

    @Deprecated
    void setKernelPush(long r1);

    @Deprecated
    void setKernelReceiveBody(long r1);

    @Deprecated
    void setKernelSend(long r1);

    @Deprecated
    void setKernelTCPConnect(long r1);

    @Deprecated
    void setKernelTTFB(long r1);

    @Deprecated
    void setKernelTls(long r1);

    @Deprecated
    void setKernelTotal(long r1);

    @Deprecated
    void setNetworkKernelRawRequestLog(String r1);

    @Deprecated
    void setRequestEnd(long r1);

    @Deprecated
    void setRequestEndAppResumeState(long r1);
}
