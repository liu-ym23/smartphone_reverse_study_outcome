package tlc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d {
    long getDelayDispatchMs();

    int getGeneralMessageType();

    int getIntType();

    int getMessageFrom();

    long getMessageId();

    String getMessageMethod();

    long getRoomId();

    boolean isFromFirstRequest();

    boolean isGlobalMessage();

    boolean needMonitor();

    void setConsumeTime(long r1);

    void setDecodeEndTime(long r1);

    void setDecodeStartTime(long r1);

    void setEnqueueDispatchTime(long r1);

    void setHttpSendTime(long r1);

    void setIsFromFirstRequest(boolean r1);

    void setIsInsert(boolean r1);

    void setMessageMethod(String r1);

    void setReceiveTime(long r1);
}
