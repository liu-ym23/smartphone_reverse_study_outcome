package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010 \u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u0007R\"\u0010$\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010(\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/message/g3;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getMsgType", "()I", "setMsgType", "(I)V", "getMsgType$annotations", "()V", "msgType", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "content", "", "getCount", "()J", "setCount", "(J)V", "getCount$annotations", "count", "getSequenceId", "setSequenceId", "getSequenceId$annotations", "sequenceId", "getGroup", "setGroup", "getGroup$annotations", "group", "getIconIndex", "setIconIndex", "getIconIndex$annotations", "iconIndex", "getTriggerTimestamp", "setTriggerTimestamp", "getTriggerTimestamp$annotations", "triggerTimestamp", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g3 extends vh7.c<g3>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "count")
    long getCount();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "group")
    int getGroup();

    /* synthetic */ long getHttpSendTime();

    @FieldName(name = "IconIndex")
    long getIconIndex();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "msg_type")
    int getMsgType();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "sequence_id")
    long getSequenceId();

    /* synthetic */ long getTimestamp();

    @FieldName(name = "TriggerTimestamp")
    long getTriggerTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    @FieldName(name = "content#setter")
    void setContent(String r1);

    @FieldName(name = "count#setter")
    void setCount(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    @FieldName(name = "group#setter")
    void setGroup(int r1);

    /* synthetic */ void setHttpSendTime(long r1);

    @FieldName(name = "IconIndex#setter")
    void setIconIndex(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    @FieldName(name = "msg_type#setter")
    void setMsgType(int r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "sequence_id#setter")
    void setSequenceId(long r1);

    /* synthetic */ void setTimestamp(long r1);

    @FieldName(name = "TriggerTimestamp#setter")
    void setTriggerTimestamp(long r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
