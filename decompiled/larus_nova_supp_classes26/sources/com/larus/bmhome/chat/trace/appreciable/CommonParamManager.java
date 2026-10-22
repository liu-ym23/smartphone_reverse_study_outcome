package com.larus.bmhome.chat.trace.appreciable;

import androidx.collection.LruCache;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.MessageTrackContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CommonParamManager {
    public static final LruCache<String, CommonParam> a = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\ba\b\u0007\u0018\u00002\u00020\u0001B÷\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'\u0012\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b.\u0010/J\t\u0010\u0087\u0001\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b=\u00107\"\u0004\b>\u00109R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b?\u00107\"\u0004\b@\u00109R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00101\"\u0004\bB\u00103R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bN\u00107\"\u0004\bO\u00109R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00101\"\u0004\bP\u00103R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00101\"\u0004\bR\u00103R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bW\u00107\"\u0004\bX\u00109R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bY\u00107\"\u0004\bZ\u00109R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00101\"\u0004\b\\\u00103R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u00101\"\u0004\b]\u00103R\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u00103R \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00101\"\u0004\bh\u00103R \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00101\"\u0004\bj\u00103R \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00101\"\u0004\bl\u00103R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00101\"\u0004\bn\u00103R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00101\"\u0004\bp\u00103R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00101\"\u0004\br\u00103R\"\u0010#\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\bs\u0010_\"\u0004\bt\u0010aR\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010T\"\u0004\bz\u0010VR\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060'¢\u0006\b\n\u0000\u001a\u0004\b}\u0010|R \u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00101\"\u0004\b\u007f\u00103R!\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b*\u00101\"\u0005\b\u0080\u0001\u00103R\"\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u00101\"\u0005\b\u0082\u0001\u00103R\"\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u00101\"\u0005\b\u0084\u0001\u00103R\"\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00101\"\u0005\b\u0086\u0001\u00103¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/CommonParamManager$CommonParam;", "", "localSendMsgId", "", "sendMsgId", "sendStartTime", "", "sendStartEpochMs", "ackTime", "sendLoadingHideTime", "endReceiveMsgId", "leavedChatPage", "", "sendMsgOnBusinessTime", "sendMsgOnSDKInternalTime", "sdkReceiveTime", "sdkTotalTimeFromSendToReceive", "isFromCache", "intention", "intentionMap", "", "businessReceiveMsgCallbackTime", "sendToSdkTimeDuration", "generalAgent", "isAsyncTask", "sendMsgContentType", "", "sendFuncChannel", "scene", "cvsId", "botId", "chatType", "convType", "traceId", "cTraceId", "agentMode", "hasEnterBackground", "messageTrackCommonTags", "latestPerfMarkRenderTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "perfMarkDurations", "springGuideCardId", "isSpringGuide", "delayRequestIntervalMs", "intervalMs", "entryToSendMsgCost", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/util/Map;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalSendMsgId", "()Ljava/lang/String;", "setLocalSendMsgId", "(Ljava/lang/String;)V", "getSendMsgId", "setSendMsgId", "getSendStartTime", "()Ljava/lang/Long;", "setSendStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSendStartEpochMs", "setSendStartEpochMs", "getAckTime", "setAckTime", "getSendLoadingHideTime", "setSendLoadingHideTime", "getEndReceiveMsgId", "setEndReceiveMsgId", "getLeavedChatPage", "()Ljava/lang/Boolean;", "setLeavedChatPage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSendMsgOnBusinessTime", "setSendMsgOnBusinessTime", "getSendMsgOnSDKInternalTime", "setSendMsgOnSDKInternalTime", "getSdkReceiveTime", "setSdkReceiveTime", "getSdkTotalTimeFromSendToReceive", "setSdkTotalTimeFromSendToReceive", "setFromCache", "getIntention", "setIntention", "getIntentionMap", "()Ljava/util/Map;", "setIntentionMap", "(Ljava/util/Map;)V", "getBusinessReceiveMsgCallbackTime", "setBusinessReceiveMsgCallbackTime", "getSendToSdkTimeDuration", "setSendToSdkTimeDuration", "getGeneralAgent", "setGeneralAgent", "setAsyncTask", "getSendMsgContentType", "()Ljava/lang/Integer;", "setSendMsgContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSendFuncChannel", "setSendFuncChannel", "getScene", "setScene", "getCvsId", "setCvsId", "getBotId", "setBotId", "getChatType", "setChatType", "getConvType", "setConvType", "getTraceId", "setTraceId", "getCTraceId", "setCTraceId", "getAgentMode", "setAgentMode", "getHasEnterBackground", "()Z", "setHasEnterBackground", "(Z)V", "getMessageTrackCommonTags", "setMessageTrackCommonTags", "getLatestPerfMarkRenderTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPerfMarkDurations", "getSpringGuideCardId", "setSpringGuideCardId", "setSpringGuide", "getDelayRequestIntervalMs", "setDelayRequestIntervalMs", "getIntervalMs", "setIntervalMs", "getEntryToSendMsgCost", "setEntryToSendMsgCost", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommonParam {
        private transient Long ackTime;

        @SerializedName("agent_mode")
        private Integer agentMode;

        @SerializedName("bot_id")
        private String botId;
        private transient Long businessReceiveMsgCallbackTime;

        @SerializedName("c_trace_id")
        private String cTraceId;

        @SerializedName("chat_type")
        private String chatType;

        @SerializedName("conv_type")
        private String convType;

        @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
        private String cvsId;

        @SerializedName("delay_request_interval_ms")
        private String delayRequestIntervalMs;
        private transient String endReceiveMsgId;

        @SerializedName("entry_to_send_msg_ms")
        private String entryToSendMsgCost;

        @SerializedName("general_agent")
        private String generalAgent;
        private transient boolean hasEnterBackground;
        private transient String intention;
        private transient Map<String, String> intentionMap;

        @SerializedName("interval_ms")
        private String intervalMs;

        @SerializedName("is_async_task")
        private String isAsyncTask;
        private transient String isFromCache;

        @SerializedName("is_spring_guide")
        private String isSpringGuide;
        private final transient ConcurrentHashMap<String, String> latestPerfMarkRenderTokens;
        private transient Boolean leavedChatPage;

        @SerializedName("local_message_id")
        private String localSendMsgId;
        private transient Map<String, String> messageTrackCommonTags;
        private final transient ConcurrentHashMap<String, Long> perfMarkDurations;

        @SerializedName("scene")
        private String scene;
        private transient Long sdkReceiveTime;
        private transient Long sdkTotalTimeFromSendToReceive;

        @SerializedName("send_func_channel")
        private String sendFuncChannel;
        private transient Long sendLoadingHideTime;

        @SerializedName("send_msg_content_type")
        private Integer sendMsgContentType;
        private transient String sendMsgId;
        private transient Long sendMsgOnBusinessTime;
        private transient Long sendMsgOnSDKInternalTime;
        private transient Long sendStartEpochMs;
        private transient Long sendStartTime;
        private transient Long sendToSdkTimeDuration;

        @SerializedName("spring_guide_card_id")
        private String springGuideCardId;

        @SerializedName("trace_id")
        private String traceId;

        public CommonParam() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, -1, 63, null);
        }

        public String toString() {
            return "scene=" + this.scene + ", localSendMsgId=" + this.localSendMsgId + ", cvsId=" + this.cvsId + ", botId=" + this.botId + ", chatType=" + this.chatType;
        }

        public final Long getAckTime() {
            return this.ackTime;
        }

        public final Integer getAgentMode() {
            return this.agentMode;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final Long getBusinessReceiveMsgCallbackTime() {
            return this.businessReceiveMsgCallbackTime;
        }

        public final String getCTraceId() {
            return this.cTraceId;
        }

        public final String getChatType() {
            return this.chatType;
        }

        public final String getConvType() {
            return this.convType;
        }

        public final String getCvsId() {
            return this.cvsId;
        }

        public final String getDelayRequestIntervalMs() {
            return this.delayRequestIntervalMs;
        }

        public final String getEndReceiveMsgId() {
            return this.endReceiveMsgId;
        }

        public final String getEntryToSendMsgCost() {
            return this.entryToSendMsgCost;
        }

        public final String getGeneralAgent() {
            return this.generalAgent;
        }

        public final boolean getHasEnterBackground() {
            return this.hasEnterBackground;
        }

        public final String getIntention() {
            return this.intention;
        }

        public final Map<String, String> getIntentionMap() {
            return this.intentionMap;
        }

        public final String getIntervalMs() {
            return this.intervalMs;
        }

        public final ConcurrentHashMap<String, String> getLatestPerfMarkRenderTokens() {
            return this.latestPerfMarkRenderTokens;
        }

        public final Boolean getLeavedChatPage() {
            return this.leavedChatPage;
        }

        public final String getLocalSendMsgId() {
            return this.localSendMsgId;
        }

        public final Map<String, String> getMessageTrackCommonTags() {
            return this.messageTrackCommonTags;
        }

        public final ConcurrentHashMap<String, Long> getPerfMarkDurations() {
            return this.perfMarkDurations;
        }

        public final String getScene() {
            return this.scene;
        }

        public final Long getSdkReceiveTime() {
            return this.sdkReceiveTime;
        }

        public final Long getSdkTotalTimeFromSendToReceive() {
            return this.sdkTotalTimeFromSendToReceive;
        }

        public final String getSendFuncChannel() {
            return this.sendFuncChannel;
        }

        public final Long getSendLoadingHideTime() {
            return this.sendLoadingHideTime;
        }

        public final Integer getSendMsgContentType() {
            return this.sendMsgContentType;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getSendMsgOnBusinessTime() {
            return this.sendMsgOnBusinessTime;
        }

        public final Long getSendMsgOnSDKInternalTime() {
            return this.sendMsgOnSDKInternalTime;
        }

        public final Long getSendStartEpochMs() {
            return this.sendStartEpochMs;
        }

        public final Long getSendStartTime() {
            return this.sendStartTime;
        }

        public final Long getSendToSdkTimeDuration() {
            return this.sendToSdkTimeDuration;
        }

        public final String getSpringGuideCardId() {
            return this.springGuideCardId;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final String isAsyncTask() {
            return this.isAsyncTask;
        }

        public final String isFromCache() {
            return this.isFromCache;
        }

        public final String isSpringGuide() {
            return this.isSpringGuide;
        }

        public final void setAckTime(Long r1) {
            this.ackTime = r1;
        }

        public final void setAgentMode(Integer r1) {
            this.agentMode = r1;
        }

        public final void setAsyncTask(String r1) {
            this.isAsyncTask = r1;
        }

        public final void setBotId(String r1) {
            this.botId = r1;
        }

        public final void setBusinessReceiveMsgCallbackTime(Long r1) {
            this.businessReceiveMsgCallbackTime = r1;
        }

        public final void setCTraceId(String r1) {
            this.cTraceId = r1;
        }

        public final void setChatType(String r1) {
            this.chatType = r1;
        }

        public final void setConvType(String r1) {
            this.convType = r1;
        }

        public final void setCvsId(String r1) {
            this.cvsId = r1;
        }

        public final void setDelayRequestIntervalMs(String r1) {
            this.delayRequestIntervalMs = r1;
        }

        public final void setEndReceiveMsgId(String r1) {
            this.endReceiveMsgId = r1;
        }

        public final void setEntryToSendMsgCost(String r1) {
            this.entryToSendMsgCost = r1;
        }

        public final void setFromCache(String r1) {
            this.isFromCache = r1;
        }

        public final void setGeneralAgent(String r1) {
            this.generalAgent = r1;
        }

        public final void setHasEnterBackground(boolean r1) {
            this.hasEnterBackground = r1;
        }

        public final void setIntention(String r1) {
            this.intention = r1;
        }

        public final void setIntentionMap(Map<String, String> r1) {
            this.intentionMap = r1;
        }

        public final void setIntervalMs(String r1) {
            this.intervalMs = r1;
        }

        public final void setLeavedChatPage(Boolean r1) {
            this.leavedChatPage = r1;
        }

        public final void setLocalSendMsgId(String r1) {
            this.localSendMsgId = r1;
        }

        public final void setMessageTrackCommonTags(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.messageTrackCommonTags = r2;
        }

        public final void setScene(String r1) {
            this.scene = r1;
        }

        public final void setSdkReceiveTime(Long r1) {
            this.sdkReceiveTime = r1;
        }

        public final void setSdkTotalTimeFromSendToReceive(Long r1) {
            this.sdkTotalTimeFromSendToReceive = r1;
        }

        public final void setSendFuncChannel(String r1) {
            this.sendFuncChannel = r1;
        }

        public final void setSendLoadingHideTime(Long r1) {
            this.sendLoadingHideTime = r1;
        }

        public final void setSendMsgContentType(Integer r1) {
            this.sendMsgContentType = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setSendMsgOnBusinessTime(Long r1) {
            this.sendMsgOnBusinessTime = r1;
        }

        public final void setSendMsgOnSDKInternalTime(Long r1) {
            this.sendMsgOnSDKInternalTime = r1;
        }

        public final void setSendStartEpochMs(Long r1) {
            this.sendStartEpochMs = r1;
        }

        public final void setSendStartTime(Long r1) {
            this.sendStartTime = r1;
        }

        public final void setSendToSdkTimeDuration(Long r1) {
            this.sendToSdkTimeDuration = r1;
        }

        public final void setSpringGuide(String r1) {
            this.isSpringGuide = r1;
        }

        public final void setSpringGuideCardId(String r1) {
            this.springGuideCardId = r1;
        }

        public final void setTraceId(String r1) {
            this.traceId = r1;
        }

        public CommonParam(String r6, String r7, Long r8, Long r9, Long r10, Long r11, String r12, Boolean r13, Long r14, Long r15, Long r16, Long r17, String r18, String r19, Map<String, String> r20, Long r21, Long r22, String r23, String r24, Integer r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, Integer r34, boolean r35, Map<String, String> r36, ConcurrentHashMap<String, String> r37, ConcurrentHashMap<String, Long> r38, String r39, String r40, String r41, String r42, String r43) {
            Intrinsics.checkNotNullParameter(r36, "messageTrackCommonTags");
            Intrinsics.checkNotNullParameter(r37, "latestPerfMarkRenderTokens");
            Intrinsics.checkNotNullParameter(r38, "perfMarkDurations");
            this.localSendMsgId = r6;
            this.sendMsgId = r7;
            this.sendStartTime = r8;
            this.sendStartEpochMs = r9;
            this.ackTime = r10;
            this.sendLoadingHideTime = r11;
            this.endReceiveMsgId = r12;
            this.leavedChatPage = r13;
            this.sendMsgOnBusinessTime = r14;
            this.sendMsgOnSDKInternalTime = r15;
            this.sdkReceiveTime = r16;
            this.sdkTotalTimeFromSendToReceive = r17;
            this.isFromCache = r18;
            this.intention = r19;
            this.intentionMap = r20;
            this.businessReceiveMsgCallbackTime = r21;
            this.sendToSdkTimeDuration = r22;
            this.generalAgent = r23;
            this.isAsyncTask = r24;
            this.sendMsgContentType = r25;
            this.sendFuncChannel = r26;
            this.scene = r27;
            this.cvsId = r28;
            this.botId = r29;
            this.chatType = r30;
            this.convType = r31;
            this.traceId = r32;
            this.cTraceId = r33;
            this.agentMode = r34;
            this.hasEnterBackground = r35;
            this.messageTrackCommonTags = r36;
            this.latestPerfMarkRenderTokens = r37;
            this.perfMarkDurations = r38;
            this.springGuideCardId = r39;
            this.isSpringGuide = r40;
            this.delayRequestIntervalMs = r41;
            this.intervalMs = r42;
            this.entryToSendMsgCost = r43;
        }

        public /* synthetic */ CommonParam(String r39, String r40, Long r41, Long r42, Long r43, Long r44, String r45, Boolean r46, Long r47, Long r48, Long r49, Long r50, String r51, String r52, Map r53, Long r54, Long r55, String r56, String r57, Integer r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, Integer r67, boolean r68, Map r69, ConcurrentHashMap r70, ConcurrentHashMap r71, String r72, String r73, String r74, String r75, String r76, int r77, int r78, DefaultConstructorMarker r79) {
            if ((r77 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r77 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r77 & 4) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r77 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r77 & 16) == 0) goto L21;
            Long r6 = null;
        L23:
            if ((r77 & 32) == 0) goto L25;
            Long r7 = null;
        L27:
            if ((r77 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r77 & 128) == 0) goto L33;
            Boolean r9 = null;
        L35:
            if ((r77 & 256) == 0) goto L37;
            Long r10 = null;
        L39:
            if ((r77 & 512) == 0) goto L41;
            Long r11 = null;
        L43:
            if ((r77 & 1024) == 0) goto L45;
            Long r12 = null;
        L47:
            if ((r77 & 2048) == 0) goto L49;
            Long r13 = null;
        L51:
            if ((r77 & 4096) == 0) goto L53;
            String r14 = null;
        L55:
            if ((r77 & 8192) == 0) goto L57;
            String r15 = null;
        L59:
            if ((r77 & 16384) == 0) goto L61;
            Map r2 = null;
        L63:
            if ((r77 & 32768) == 0) goto L65;
            Long r16 = null;
        L67:
            if ((r77 & 65536) == 0) goto L69;
            Long r17 = null;
        L71:
            if ((r77 & 131072) == 0) goto L73;
            String r18 = null;
        L75:
            if ((r77 & 262144) == 0) goto L77;
            String r19 = null;
        L79:
            if ((r77 & 524288) == 0) goto L81;
            Integer r20 = null;
        L83:
            if ((r77 & 1048576) == 0) goto L85;
            String r21 = null;
        L87:
            if ((r77 & 2097152) == 0) goto L89;
            String r22 = null;
        L91:
            if ((r77 & 4194304) == 0) goto L93;
            String r23 = null;
        L95:
            if ((r77 & 8388608) == 0) goto L97;
            String r24 = null;
        L99:
            if ((r77 & 16777216) == 0) goto L101;
            String r25 = null;
        L103:
            if ((r77 & 33554432) == 0) goto L105;
            String r26 = null;
        L107:
            if ((r77 & 67108864) == 0) goto L109;
            String r27 = null;
        L111:
            if ((r77 & 134217728) == 0) goto L113;
            String r28 = null;
        L115:
            if ((r77 & 268435456) == 0) goto L117;
            Integer r29 = null;
        L119:
            if ((r77 & 536870912) == 0) goto L121;
            boolean r30 = false;
        L123:
            if ((r77 & 1073741824) == 0) goto L125;
            Map r31 = MapsKt.emptyMap();
        L127:
            if ((r77 & Integer.MIN_VALUE) == 0) goto L129;
            ConcurrentHashMap r0 = new ConcurrentHashMap();
        L131:
            if ((r78 & 1) == 0) goto L133;
            ConcurrentHashMap r32 = new ConcurrentHashMap();
        L135:
            if ((r78 & 2) == 0) goto L137;
            String r33 = null;
        L139:
            if ((r78 & 4) == 0) goto L141;
            String r34 = null;
        L143:
            if ((r78 & 8) == 0) goto L145;
            String r35 = null;
        L147:
            if ((r78 & 16) == 0) goto L149;
            String r36 = null;
        L151:
            if ((r78 & 32) == 0) goto L153;
            String r37 = null;
        L154:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r0, r32, r33, r34, r35, r36, r37);
            return;
        L153:
            r37 = r76;
            goto L154
        L149:
            r36 = r75;
            goto L151
        L145:
            r35 = r74;
            goto L147
        L141:
            r34 = r73;
            goto L143
        L137:
            r33 = r72;
            goto L139
        L133:
            r32 = r71;
            goto L135
        L129:
            r0 = r70;
            goto L131
        L125:
            r31 = r69;
            goto L127
        L121:
            r30 = r68;
            goto L123
        L117:
            r29 = r67;
            goto L119
        L113:
            r28 = r66;
            goto L115
        L109:
            r27 = r65;
            goto L111
        L105:
            r26 = r64;
            goto L107
        L101:
            r25 = r63;
            goto L103
        L97:
            r24 = r62;
            goto L99
        L93:
            r23 = r61;
            goto L95
        L89:
            r22 = r60;
            goto L91
        L85:
            r21 = r59;
            goto L87
        L81:
            r20 = r58;
            goto L83
        L77:
            r19 = r57;
            goto L79
        L73:
            r18 = r56;
            goto L75
        L69:
            r17 = r55;
            goto L71
        L65:
            r16 = r54;
            goto L67
        L61:
            r2 = r53;
            goto L63
        L57:
            r15 = r52;
            goto L59
        L53:
            r14 = r51;
            goto L55
        L49:
            r13 = r50;
            goto L51
        L45:
            r12 = r49;
            goto L47
        L41:
            r11 = r48;
            goto L43
        L37:
            r10 = r47;
            goto L39
        L33:
            r9 = r46;
            goto L35
        L29:
            r8 = r45;
            goto L31
        L25:
            r7 = r44;
            goto L27
        L21:
            r6 = r43;
            goto L23
        L17:
            r5 = r42;
            goto L19
        L13:
            r4 = r41;
            goto L15
        L9:
            r3 = r40;
            goto L11
        L5:
            r1 = r39;
            goto L7
        }
    }

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            Iterator r0 = CommonParamManager.a.snapshot().values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((CommonParam) r0.next()).setHasEnterBackground(true);
            goto L4
        }
    }

    static {
        a = new LruCache(10);
        AppHost.a.a().j(new a());
    }

    public static String b() {
    L2:
        long r0 = Random.Default.nextLong() >>> 1;
        if (r0 == 0) goto L2;
    L4:
        long r5 = Random.Default.nextLong() >>> 1;
        if (r5 == 0) goto L4;
        return StringsKt.padStart(Long.toString(r0, CharsKt.checkRadix(16)), 16, '0') + StringsKt.padStart(Long.toString(r5, CharsKt.checkRadix(16)), 16, '0');
    }

    public static CommonParam c(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (CommonParam) a.get(r1);
    }

    public static MessageTrackContext a(List r9, Integer r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "localMessageIds");
        List r12 = CollectionsKt.distinct(r9);
        ArrayList r0 = new ArrayList();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        CommonParam r1 = c((String) r13.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        CommonParam r14 = (CommonParam) CollectionsKt.firstOrNull(r0);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Long r4 = ((CommonParam) r3.next()).getSendStartEpochMs();
        if (r4 == null) goto L10;
        r2.add(r4);
        goto L10
    L14:
        Long r5 = (Long) CollectionsKt.firstOrNull(r2);
        String r6 = null;
        if (r5 == null) goto L60;
        long r7 = r5.longValue();
        boolean r8 = false;
        if (r14 == null) goto L28;
        String r15 = r14.getCTraceId();
        if (r15 == null) goto L28;
        if (r15.length() <= 0) goto L23;
        boolean r16 = true;
    L24:
        if (r16 == true) goto L27;
        r15 = null;
    L27:
        if (r15 == null) goto L28;
    L29:
        if (r10 != null) goto L33;
        if (r14 == null) goto L32;
        r10 = r14.getAgentMode();
        goto L33
    L32:
        r10 = null;
    L33:
        if (r14 == null) goto L35;
        Map<String, String> r17 = r14.getMessageTrackCommonTags();
    L36:
        if (r17 != null) goto L38;
        r17 = MapsKt.emptyMap();
    L38:
        Map r18 = MapsKt.toMutableMap(r17);
        r18.put("c_trace_id", r15);
        if (r14 == null) goto L44;
        String r19 = r14.getScene();
        if (r19 == null) goto L44;
        r11 = r19;
    L44:
        if (r11 != null) goto L46;
    L52:
        if (r10 == null) goto L54;
        r18.put("agent_mode", String.valueOf(r10.intValue()));
    L54:
        Iterator r20 = r0.iterator();
    L56:
        if (r20.hasNext() == false) goto L59;
        CommonParam r110 = (CommonParam) r20.next();
        r110.setCTraceId(r15);
        r110.setAgentMode(r10);
        r110.setMessageTrackCommonTags(MapsKt.toMap(r18));
        goto L56
    L59:
        return new MessageTrackContext(r7, r18);
    L46:
        if (r11.length() <= 0) goto L48;
        r8 = true;
    L48:
        if (r8 == false) goto L50;
        r6 = r11;
    L50:
        if (r6 == null) goto L52;
        String r21 = (String) r18.put("scene", r6);
        goto L52
    L35:
        r17 = null;
        goto L36
    L23:
        r16 = false;
    L28:
        r15 = b();
        goto L29
    L60:
        return null;
    }
}
