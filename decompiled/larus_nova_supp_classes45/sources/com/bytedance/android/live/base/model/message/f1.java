package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\"\u0010$\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R$\u0010/\u001a\u0004\u0018\u00010)8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\t\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00103\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\t\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR0\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\t\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010;8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\t\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/base/model/message/f1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitle$annotations", "()V", "title", "getContent", "setContent", "getContent$annotations", "content", "", "", "getNum", "()Ljava/util/List;", "setNum", "(Ljava/util/List;)V", "getNum$annotations", "num", "getDuration", "()J", "setDuration", "(J)V", "getDuration$annotations", "duration", "getShowDuration", "setShowDuration", "getShowDuration$annotations", "showDuration", "getSequenceId", "setSequenceId", "getSequenceId$annotations", "sequenceId", "getHotList", "setHotList", "getHotList$annotations", "hotList", "Lcom/bytedance/android/live/base/model/message/a5;", "getRtfContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "setRtfContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getRtfContent$annotations", "rtfContent", "getChatContentType", "setChatContentType", "getChatContentType$annotations", "chatContentType", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getExtra$annotations", "extra", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "getHighlightAreaPriorityConfig$annotations", "highlightAreaPriorityConfig", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f1 extends vh7.c<f1>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "chat_content_type")
    long getChatContentType();

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    @FieldName(name = "content")
    String getContent();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "duration")
    long getDuration();

    /* synthetic */ long getEnqueueDispatchTime();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "highlight_area_priority_config")
    HighlightAreaPriorityConfig getHighlightAreaPriorityConfig();

    @FieldName(name = "hot_list")
    List<String> getHotList();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "num")
    List<Long> getNum();

    /* synthetic */ int getPriority();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "rtf_content")
    a5 getRtfContent();

    @FieldName(name = "sequence_id")
    long getSequenceId();

    @FieldName(name = "show_duration")
    List<Long> getShowDuration();

    /* synthetic */ long getTimestamp();

    @FieldName(name = "title")
    String getTitle();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "chat_content_type#setter")
    void setChatContentType(long r1);

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    @FieldName(name = "content#setter")
    void setContent(String r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    @FieldName(name = "duration#setter")
    void setDuration(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    @FieldName(name = "extra#setter")
    void setExtra(Map<String, String> r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    @FieldName(name = "highlight_area_priority_config#setter")
    void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r1);

    @FieldName(name = "hot_list#setter")
    void setHotList(List<String> r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    @FieldName(name = "num#setter")
    void setNum(List<Long> r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "rtf_content#setter")
    void setRtfContent(a5 r1);

    @FieldName(name = "sequence_id#setter")
    void setSequenceId(long r1);

    @FieldName(name = "show_duration#setter")
    void setShowDuration(List<Long> r1);

    /* synthetic */ void setTimestamp(long r1);

    @FieldName(name = "title#setter")
    void setTitle(String r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
