package kc2;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c implements t {
    private String WRDSSubKey;
    private long WRDSVersion;
    private m0 baseMessage;
    private long consumeTime;
    private final boolean currUserIsAnchor;
    private long decodeEndTime;
    private long decodeStartTime;
    private long enqueueDispatchTime;
    private int generalMessageType;
    private long httpSendTime;
    private boolean isFromFirstRequest;
    private boolean isInsert;
    private boolean isLocalInsertMsg;
    private boolean isTooMuchMsg;
    private boolean isWRDSMessage;
    private long localTimestamp;
    private Map<String, String> messageExtra;
    private int messageFrom;
    private String messageMethod;
    private long receiveTime;
    private transient long timestamp;

    public boolean canText() {
        return false;
    }

    public long getDelayDispatchMs() {
        return 0;
    }

    public final int getIntType() {
        return 0;
    }

    public int getPriority() {
        return 0;
    }

    public boolean isFirstHistoryMessage() {
        return false;
    }

    public boolean isFromOtherIntercomRoom() {
        return false;
    }

    public void setIsFirstHistoryMessage(boolean r1) {
    }

    public boolean supportDisplayText() {
        return false;
    }

    public long getMessageId() {
        m0 r0 = this.baseMessage;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getMessageId();
    }

    public long getRoomId() {
        m0 r0 = this.baseMessage;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRoomId();
    }

    public String getWRDSKey() {
        m0 r0 = this.baseMessage;
        if (r0 == null) goto L6;
        String r1 = r0.getMethod();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public boolean isGlobalMessage() {
        m0 r0 = this.baseMessage;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getRoomId() != (-1)) goto L7;
        return true;
    }

    public boolean needMonitor() {
        m0 r0 = this.baseMessage;
        if (r0 != null) goto L5;
    L6:
        m0 r1 = this.baseMessage;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.getMonitor() != 2) goto L11;
        return true;
    L5:
        if (r0.getMonitor() != 1) goto L6;
        return true;
    }

    public c() {
        this.messageMethod = BuildConfig.FLAVOR;
    }

    public boolean currUserIsAnchor() {
        return this.currUserIsAnchor;
    }

    public m0 getBaseMessage() {
        return this.baseMessage;
    }

    public long getConsumeTime() {
        return this.consumeTime;
    }

    public final boolean getCurrUserIsAnchor() {
        return this.currUserIsAnchor;
    }

    public int getGeneralMessageType() {
        return this.generalMessageType;
    }

    public long getHttpSendTime() {
        return this.httpSendTime;
    }

    public long getLocalTimestamp() {
        return this.localTimestamp;
    }

    public Map<String, String> getMessageExtra() {
        return this.messageExtra;
    }

    public int getMessageFrom() {
        return this.messageFrom;
    }

    public String getMessageMethod() {
        return this.messageMethod;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getWRDSSubKey() {
        return this.WRDSSubKey;
    }

    public long getWRDSVersion() {
        return this.WRDSVersion;
    }

    public boolean isFromFirstRequest() {
        return this.isFromFirstRequest;
    }

    public boolean isInsert() {
        return this.isInsert;
    }

    public boolean isTooMuchMsg() {
        return this.isTooMuchMsg;
    }

    public boolean isWRDSMessage() {
        return this.isWRDSMessage;
    }

    public boolean isCurrentRoom(long r6) {
        m0 r0 = this.baseMessage;
        if (r0 == null) goto L5;
        long r3 = r0.getRoomId();
    L7:
        if (r6 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r6 != r3) goto L11;
        return true;
    L5:
        r3 = 0;
        goto L7
    }

    public void setBaseMessage(m0 r1) {
        this.baseMessage = r1;
    }

    public void setConsumeTime(long r1) {
        this.consumeTime = r1;
    }

    public void setDecodeEndTime(long r1) {
        this.decodeEndTime = r1;
    }

    public void setDecodeStartTime(long r1) {
        this.decodeStartTime = r1;
    }

    public void setEnqueueDispatchTime(long r1) {
        this.enqueueDispatchTime = r1;
    }

    public void setHttpSendTime(long r1) {
        this.httpSendTime = r1;
    }

    public void setIsFromFirstRequest(boolean r1) {
        this.isFromFirstRequest = r1;
    }

    public void setIsInsert(boolean r1) {
        this.isInsert = r1;
    }

    public void setLocalInsertMsg(boolean r1) {
        this.isLocalInsertMsg = r1;
    }

    public void setMessageMethod(String r1) {
        if (r1 != null) goto L4;
        r1 = BuildConfig.FLAVOR;
    L4:
        this.messageMethod = r1;
    }

    public void setReceiveTime(long r1) {
        this.receiveTime = r1;
    }

    public final void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public void setTooMuchMsg(boolean r1) {
        this.isTooMuchMsg = r1;
    }

    public void setWRDSMessage(boolean r1) {
        this.isWRDSMessage = r1;
    }

    public void setWRDSSubKey(String r1) {
        this.WRDSSubKey = r1;
    }

    public void setWRDSVersion(long r1) {
        this.WRDSVersion = r1;
    }
}
