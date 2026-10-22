package com.larus.bmhome.chat.trace.appreciable;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.trace.imspan.IMSpanManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageResultTrace {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageResultTrace$ReceiveRecord;", "", "sendMsgId", "", "receiveContentType", "", "status", "duration", "", "durationInternal", "generalAgent", "isAsyncTask", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getSendMsgId", "()Ljava/lang/String;", "setSendMsgId", "(Ljava/lang/String;)V", "getReceiveContentType", "()Ljava/lang/Integer;", "setReceiveContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "setStatus", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationInternal", "setDurationInternal", "getGeneralAgent", "setGeneralAgent", "setAsyncTask", "report", "", "endTime", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReceiveRecord {

        @SerializedName("duration")
        private Long duration;

        @SerializedName("duration_internal")
        private Long durationInternal;

        @SerializedName("general_agent")
        private String generalAgent;

        @SerializedName("is_async_task")
        private String isAsyncTask;

        @SerializedName("content_type")
        private Integer receiveContentType;

        @SerializedName("reply_id")
        private String sendMsgId;

        @SerializedName("status")
        private Integer status;

        public ReceiveRecord() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getDurationInternal() {
            return this.durationInternal;
        }

        public final String getGeneralAgent() {
            return this.generalAgent;
        }

        public final Integer getReceiveContentType() {
            return this.receiveContentType;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final String isAsyncTask() {
            return this.isAsyncTask;
        }

        public final void setAsyncTask(String r1) {
            this.isAsyncTask = r1;
        }

        public final void setDuration(Long r1) {
            this.duration = r1;
        }

        public final void setDurationInternal(Long r1) {
            this.durationInternal = r1;
        }

        public final void setGeneralAgent(String r1) {
            this.generalAgent = r1;
        }

        public final void setReceiveContentType(Integer r1) {
            this.receiveContentType = r1;
        }

        public final void setSendMsgId(String r1) {
            this.sendMsgId = r1;
        }

        public final void setStatus(Integer r1) {
            this.status = r1;
        }

        public final void report(String r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "sendMsgId");
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r5);
            String r1 = null;
            if (r0 == null) goto L10;
            Long r2 = r0.getSendStartTime();
            if (r2 == null) goto L7;
            this.duration = Long.valueOf(r6 - r2.longValue());
        L7:
            Long r3 = r0.getSendLoadingHideTime();
            if (r3 == null) goto L11;
            this.durationInternal = Long.valueOf(r6 - r3.longValue());
        L11:
            String r7 = TriggerSendLoading.NO_LOADING;
            if (r0 == null) goto L15;
            String r8 = r0.getGeneralAgent();
            if (r8 == null) goto L15;
        L16:
            this.generalAgent = r8;
            if (r0 == null) goto L22;
            String r9 = r0.isAsyncTask();
            if (r9 == null) goto L22;
            r7 = r9;
        L22:
            this.isAsyncTask = r7;
            this.sendMsgId = r5;
            JSONObject r10 = a.b(r0, this);
            q.a(r10, r0);
            if (r0 == null) goto L29;
            Boolean r11 = r0.getLeavedChatPage();
            if (r11 == null) goto L29;
            boolean r12 = r11.booleanValue();
            if (r10 == null) goto L29;
            r10.put("has_leaved_page", r12 ? 1 : 0);
        L29:
            FLogger.a.i("ChatMessageResultTrace", "reportEvent, event=message_receive_result, param=" + r10);
            if (r10 == null) goto L32;
            com.larus.platform.service.o.a.reportEvent("message_receive_result", r10);
            com.larus.bmhome.utils.c.a("message_receive_result", r10, true);
        L32:
            LruCache<String, String> r13 = IMSpanManager.a;
            if (r0 == null) goto L35;
            r1 = r0.getLocalSendMsgId();
        L35:
            if (r1 != null) goto L37;
            r1 = "";
        L37:
            IMSpanManager.b(r1, "message_receive_result", r10);
            return;
        L15:
            r8 = TriggerSendLoading.NO_LOADING;
            goto L16
        L10:
            r0 = null;
            goto L11
        }

        public ReceiveRecord(String r1, Integer r2, Integer r3, Long r4, Long r5, String r6, String r7) {
            this.sendMsgId = r1;
            this.receiveContentType = r2;
            this.status = r3;
            this.duration = r4;
            this.durationInternal = r5;
            this.generalAgent = r6;
            this.isAsyncTask = r7;
        }

        public /* synthetic */ ReceiveRecord(String r7, Integer r8, Integer r9, Long r10, Long r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            Integer r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            Integer r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            Long r3 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            Long r4 = null;
        L23:
            if ((r14 & 32) == 0) goto L25;
            String r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            String r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b)\u0010\u0018R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0016\"\u0004\b,\u0010\u0018R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatMessageResultTrace$SendRecord;", "", "messageId", "", "sendContentType", "", "status", "duration", "", "durationInternal", "springGuideCardId", "isSpringGuide", "commonVenueGuideCardId", "isCommonVenueGuide", "delayRequestIntervalMs", "errorCode", "imSdkErrCode", "imSdkErrTips", "imExpMsg", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "getSendContentType", "()Ljava/lang/Integer;", "setSendContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "setStatus", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationInternal", "setDurationInternal", "getSpringGuideCardId", "setSpringGuideCardId", "setSpringGuide", "getCommonVenueGuideCardId", "setCommonVenueGuideCardId", "setCommonVenueGuide", "getDelayRequestIntervalMs", "setDelayRequestIntervalMs", "getErrorCode", "setErrorCode", "getImSdkErrCode", "setImSdkErrCode", "getImSdkErrTips", "setImSdkErrTips", "getImExpMsg", "setImExpMsg", "report", "", "sendMsgId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendRecord {

        @SerializedName("common_venue_guide_card_id")
        private String commonVenueGuideCardId;

        @SerializedName("delay_request_interval_ms")
        private String delayRequestIntervalMs;

        @SerializedName("duration")
        private Long duration;

        @SerializedName("duration_internal")
        private Long durationInternal;

        @SerializedName("error_code")
        private Integer errorCode;

        @SerializedName("im_sdk_exp_msg")
        private String imExpMsg;

        @SerializedName("im_sdk_err_code")
        private Integer imSdkErrCode;

        @SerializedName("im_sdk_err_tips")
        private String imSdkErrTips;

        @SerializedName("is_common_venue_guide")
        private String isCommonVenueGuide;

        @SerializedName("is_spring_guide")
        private String isSpringGuide;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageId;

        @SerializedName("content_type")
        private Integer sendContentType;

        @SerializedName("spring_guide_card_id")
        private String springGuideCardId;

        @SerializedName("status")
        private Integer status;

        public SendRecord() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public final String getCommonVenueGuideCardId() {
            return this.commonVenueGuideCardId;
        }

        public final String getDelayRequestIntervalMs() {
            return this.delayRequestIntervalMs;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getDurationInternal() {
            return this.durationInternal;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getImExpMsg() {
            return this.imExpMsg;
        }

        public final Integer getImSdkErrCode() {
            return this.imSdkErrCode;
        }

        public final String getImSdkErrTips() {
            return this.imSdkErrTips;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final Integer getSendContentType() {
            return this.sendContentType;
        }

        public final String getSpringGuideCardId() {
            return this.springGuideCardId;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final String isCommonVenueGuide() {
            return this.isCommonVenueGuide;
        }

        public final String isSpringGuide() {
            return this.isSpringGuide;
        }

        public final void report(String r9) {
            Intrinsics.checkNotNullParameter(r9, "sendMsgId");
            CommonParamManager.CommonParam r0 = CommonParamManager.c(r9);
            if (r0 == null) goto L7;
            Long r1 = r0.getSendStartTime();
            if (r1 == null) goto L7;
            Long r2 = Long.valueOf(SystemClock.elapsedRealtime() - r1.longValue());
            this.duration = r2;
            this.durationInternal = r2;
        L7:
            this.messageId = r9;
            JSONObject r3 = a.b(r0, this);
            q.a(r3, r0);
            FLogger.a.i("ChatMessageResultTrace", "reportEvent, event=message_send_result, param=" + r3);
            String r4 = "";
            if (r3 == null) goto L29;
            Integer r5 = this.status;
            if (r5 != null) goto L13;
        L14:
            Lazy r6 = y.a;
            Integer r7 = this.status;
            if (r7 == null) goto L17;
            int r8 = r7.intValue();
        L18:
            Intrinsics.checkNotNullParameter(r9, "localMsgId");
            Lazy r10 = y.d;
            ((Queue) r10.getValue()).add(r9);
            Integer r11 = Integer.valueOf(r8);
            Lazy r12 = y.e;
            ((Map) r12.getValue()).put(r9, r11);
            if (((Queue) r10.getValue()).size() <= 50) goto L28;
            String r13 = (String) ((Queue) r10.getValue()).poll();
            if (r13 != null) goto L24;
            r13 = "";
        L24:
            if (o0.d(r13) == false) goto L28;
            if (((Map) r12.getValue()).containsKey(r13) == false) goto L28;
            ((Map) r12.getValue()).remove(r13);
        L28:
            com.larus.platform.service.o.a.reportEvent("message_send_result", r3);
            com.larus.bmhome.utils.c.a("message_send_result", r3, true);
            goto L29
        L17:
            r8 = -1;
            goto L18
        L13:
            if (r5.intValue() == 0) goto L28;
        L29:
            LruCache<String, String> r14 = IMSpanManager.a;
            if (r0 == null) goto L32;
            String r15 = r0.getLocalSendMsgId();
        L33:
            if (r15 == null) goto L36;
            r4 = r15;
        L36:
            IMSpanManager.b(r4, "message_send_result", r3);
            return;
        L32:
            r15 = null;
            goto L33
        }

        public final void setCommonVenueGuide(String r1) {
            this.isCommonVenueGuide = r1;
        }

        public final void setCommonVenueGuideCardId(String r1) {
            this.commonVenueGuideCardId = r1;
        }

        public final void setDelayRequestIntervalMs(String r1) {
            this.delayRequestIntervalMs = r1;
        }

        public final void setDuration(Long r1) {
            this.duration = r1;
        }

        public final void setDurationInternal(Long r1) {
            this.durationInternal = r1;
        }

        public final void setErrorCode(Integer r1) {
            this.errorCode = r1;
        }

        public final void setImExpMsg(String r1) {
            this.imExpMsg = r1;
        }

        public final void setImSdkErrCode(Integer r1) {
            this.imSdkErrCode = r1;
        }

        public final void setImSdkErrTips(String r1) {
            this.imSdkErrTips = r1;
        }

        public final void setMessageId(String r1) {
            this.messageId = r1;
        }

        public final void setSendContentType(Integer r1) {
            this.sendContentType = r1;
        }

        public final void setSpringGuide(String r1) {
            this.isSpringGuide = r1;
        }

        public final void setSpringGuideCardId(String r1) {
            this.springGuideCardId = r1;
        }

        public final void setStatus(Integer r1) {
            this.status = r1;
        }

        public SendRecord(String r1, Integer r2, Integer r3, Long r4, Long r5, String r6, String r7, String r8, String r9, String r10, Integer r11, Integer r12, String r13, String r14) {
            this.messageId = r1;
            this.sendContentType = r2;
            this.status = r3;
            this.duration = r4;
            this.durationInternal = r5;
            this.springGuideCardId = r6;
            this.isSpringGuide = r7;
            this.commonVenueGuideCardId = r8;
            this.isCommonVenueGuide = r9;
            this.delayRequestIntervalMs = r10;
            this.errorCode = r11;
            this.imSdkErrCode = r12;
            this.imSdkErrTips = r13;
            this.imExpMsg = r14;
        }

        public /* synthetic */ SendRecord(String r16, Integer r17, Integer r18, Long r19, Long r20, String r21, String r22, String r23, String r24, String r25, Integer r26, Integer r27, String r28, String r29, int r30, DefaultConstructorMarker r31) {
            String r2 = null;
            if ((r30 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r30 & 2) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r30 & 4) == 0) goto L13;
            Integer r4 = null;
        L15:
            if ((r30 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r30 & 16) == 0) goto L21;
            Long r6 = null;
        L23:
            if ((r30 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r30 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r30 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r30 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r30 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            Integer r12 = null;
        L47:
            if ((r30 & 2048) == 0) goto L49;
            Integer r13 = null;
        L51:
            if ((r30 & 4096) == 0) goto L53;
            String r14 = null;
        L55:
            if ((r30 & 8192) != 0) goto L58;
            r2 = r29;
        L58:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
            return;
        L53:
            r14 = r28;
            goto L55
        L49:
            r13 = r27;
            goto L51
        L45:
            r12 = r26;
            goto L47
        L41:
            r11 = r25;
            goto L43
        L37:
            r10 = r24;
            goto L39
        L33:
            r9 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r1 = r16;
            goto L7
        }
    }

    static {
    }
}
