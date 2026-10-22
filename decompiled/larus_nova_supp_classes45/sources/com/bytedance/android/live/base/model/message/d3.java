package com.bytedance.android.live.base.model.message;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface d3 extends tlc.d, xlc.b {
    long getConsumeTime();

    long getDecodeEndTime();

    long getDecodeStartTime();

    long getEnqueueDispatchTime();

    long getHttpSendTime();

    byte[] getRawPayload();

    long getReceiveTime();

    boolean isTimeCostCanUse();

    void setCommonMessageData(m0 r1);

    void setGeneralMessageType(int r1);

    void setMessageExtra(Map<String, String> r1);

    void setMessageFrom(int r1);

    void setRawPayload(byte[] r1);

    void setTimestamp(long r1);
}
