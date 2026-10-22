package com.bytedance.android.live.base.model.message;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface t extends tlc.d, xlc.b {
    boolean canText();

    boolean currUserIsAnchor();

    m0 getBaseMessage();

    long getConsumeTime();

    long getHttpSendTime();

    Map<String, String> getMessageExtra();

    byte[] getRawPayload();

    long getReceiveTime();

    long getTimestamp();

    boolean isCurrentRoom(long r1);

    boolean isFirstHistoryMessage();

    boolean isFromOtherIntercomRoom();

    boolean isInsert();

    boolean isTooMuchMsg();

    void setIsFirstHistoryMessage(boolean r1);

    void setTooMuchMsg(boolean r1);

    boolean supportDisplayText();
}
