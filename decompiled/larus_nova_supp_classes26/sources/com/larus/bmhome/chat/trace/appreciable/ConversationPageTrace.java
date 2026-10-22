package com.larus.bmhome.chat.trace.appreciable;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.z1;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ConversationPageTrace {
    public static ConversationPageRecord a;
    public static boolean b;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b7\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u0004\u0018\u00010KR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b\f\u0010-\"\u0004\b1\u0010/R\"\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b\r\u0010-\"\u0004\b2\u0010/R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b\u000e\u0010-\"\u0004\b3\u0010/R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b\u000f\u0010-\"\u0004\b4\u0010/R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010\u001e¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ConversationPageTrace$ConversationPageRecord;", "", "totalDuration", "", "resumeToBindDuration", "viewCreatedToBindDuration", "createToBindDuration", "resumeToDataLoadedDuration", "attachToAppStartDuration", "chatBotToBindDuration", "chatWithTab", "", "isLandingToCvsList", "isLazyMainComponentEnable", "isLogin", "isFromDb", "dataSize", "", "onAttachTime", "onCreateTime", "onViewCreatedTime", "onResumeTime", "onDataLoadedTime", "onDataBindTime", "onLeaveChatBotTime", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getTotalDuration", "()Ljava/lang/Long;", "setTotalDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getResumeToBindDuration", "setResumeToBindDuration", "getViewCreatedToBindDuration", "setViewCreatedToBindDuration", "getCreateToBindDuration", "setCreateToBindDuration", "getResumeToDataLoadedDuration", "setResumeToDataLoadedDuration", "getAttachToAppStartDuration", "setAttachToAppStartDuration", "getChatBotToBindDuration", "setChatBotToBindDuration", "getChatWithTab", "()Ljava/lang/Boolean;", "setChatWithTab", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLandingToCvsList", "setLazyMainComponentEnable", "setLogin", "setFromDb", "getDataSize", "()Ljava/lang/Integer;", "setDataSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOnAttachTime", "setOnAttachTime", "getOnCreateTime", "setOnCreateTime", "getOnViewCreatedTime", "setOnViewCreatedTime", "getOnResumeTime", "setOnResumeTime", "getOnDataLoadedTime", "setOnDataLoadedTime", "getOnDataBindTime", "setOnDataBindTime", "getOnLeaveChatBotTime", "setOnLeaveChatBotTime", "report", "", "toJSONObject", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConversationPageRecord {

        @SerializedName("attach_to_app_start_duration")
        private Long attachToAppStartDuration;

        @SerializedName("chat_bot_to_conv_duration")
        private Long chatBotToBindDuration;

        @SerializedName("chat_with_tab")
        private Boolean chatWithTab;

        @SerializedName("create_to_bind_duration")
        private Long createToBindDuration;

        @SerializedName("data_size")
        private Integer dataSize;

        @SerializedName("is_from_db")
        private Boolean isFromDb;

        @SerializedName("is_landing_to_cvs_list")
        private Boolean isLandingToCvsList;

        @SerializedName("is_lazy_main_component_enable")
        private Boolean isLazyMainComponentEnable;

        @SerializedName("is_login")
        private Boolean isLogin;
        private transient Long onAttachTime;
        private transient Long onCreateTime;
        private transient Long onDataBindTime;
        private transient Long onDataLoadedTime;
        private transient Long onLeaveChatBotTime;
        private transient Long onResumeTime;
        private transient Long onViewCreatedTime;

        @SerializedName("resume_to_bind_duration")
        private Long resumeToBindDuration;

        @SerializedName("wait_data_loaded_duration")
        private Long resumeToDataLoadedDuration;

        @SerializedName("total_duration")
        private Long totalDuration;

        @SerializedName("view_created_to_bind_duration")
        private Long viewCreatedToBindDuration;

        public ConversationPageRecord() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
        }

        public final void report() {
            Long r0 = this.onAttachTime;
            Long r1 = this.onCreateTime;
            Long r2 = this.onViewCreatedTime;
            Long r3 = this.onResumeTime;
            Long r4 = this.onDataBindTime;
            Long r5 = this.onDataLoadedTime;
            Long r6 = this.onLeaveChatBotTime;
            if (r0 == null) goto L21;
            if (r1 == null) goto L22;
            if (r2 == null) goto L23;
            if (r3 == null) goto L24;
            if (r4 == null) goto L25;
            if (r5 == null) goto L26;
            this.totalDuration = Long.valueOf(r4.longValue() - r0.longValue());
            this.resumeToBindDuration = Long.valueOf(r4.longValue() - r3.longValue());
            this.viewCreatedToBindDuration = Long.valueOf(r4.longValue() - r2.longValue());
            this.createToBindDuration = Long.valueOf(r4.longValue() - r1.longValue());
            if ((r5.longValue() - r3.longValue()) <= 0) goto L12;
            long r7 = Long.valueOf(r5.longValue() - r3.longValue());
        L13:
            this.resumeToDataLoadedDuration = r7;
            if (r6 == null) goto L16;
            long r8 = Long.valueOf(r4.longValue() - r6.longValue());
        L17:
            this.chatBotToBindDuration = r8;
            this.chatWithTab = Boolean.valueOf(z2.a.enableChatWithTab());
            this.isLogin = Boolean.valueOf(z1.a.isLogin());
            JSONObject r9 = toJSONObject();
            FLogger.a.d("ConversationPageTrace", "reportEvent, param = " + r9);
            if (r9 == null) goto L27;
            com.larus.platform.service.o.a.reportEvent("page_conversation_first_paint", r9);
            com.larus.bmhome.utils.c.a("page_conversation_first_paint", r9, true);
            return;
        L27:
            return;
        L16:
            r8 = 0L;
            goto L17
        L12:
            r7 = 0L;
            goto L13
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        public final JSONObject toJSONObject() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r1 = Result.constructor-impl(new JSONObject(new Gson().toJson(this)));     // Catch: Throwable -> L4
        L7:
            if (Result.isFailure-impl(r1) == false) goto L10;
            r1 = null;
        L10:
            return (JSONObject) r1;
        L4:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public final Long getAttachToAppStartDuration() {
            return this.attachToAppStartDuration;
        }

        public final Long getChatBotToBindDuration() {
            return this.chatBotToBindDuration;
        }

        public final Boolean getChatWithTab() {
            return this.chatWithTab;
        }

        public final Long getCreateToBindDuration() {
            return this.createToBindDuration;
        }

        public final Integer getDataSize() {
            return this.dataSize;
        }

        public final Long getOnAttachTime() {
            return this.onAttachTime;
        }

        public final Long getOnCreateTime() {
            return this.onCreateTime;
        }

        public final Long getOnDataBindTime() {
            return this.onDataBindTime;
        }

        public final Long getOnDataLoadedTime() {
            return this.onDataLoadedTime;
        }

        public final Long getOnLeaveChatBotTime() {
            return this.onLeaveChatBotTime;
        }

        public final Long getOnResumeTime() {
            return this.onResumeTime;
        }

        public final Long getOnViewCreatedTime() {
            return this.onViewCreatedTime;
        }

        public final Long getResumeToBindDuration() {
            return this.resumeToBindDuration;
        }

        public final Long getResumeToDataLoadedDuration() {
            return this.resumeToDataLoadedDuration;
        }

        public final Long getTotalDuration() {
            return this.totalDuration;
        }

        public final Long getViewCreatedToBindDuration() {
            return this.viewCreatedToBindDuration;
        }

        public final Boolean isFromDb() {
            return this.isFromDb;
        }

        public final Boolean isLandingToCvsList() {
            return this.isLandingToCvsList;
        }

        public final Boolean isLazyMainComponentEnable() {
            return this.isLazyMainComponentEnable;
        }

        public final Boolean isLogin() {
            return this.isLogin;
        }

        public final void setAttachToAppStartDuration(Long r1) {
            this.attachToAppStartDuration = r1;
        }

        public final void setChatBotToBindDuration(Long r1) {
            this.chatBotToBindDuration = r1;
        }

        public final void setChatWithTab(Boolean r1) {
            this.chatWithTab = r1;
        }

        public final void setCreateToBindDuration(Long r1) {
            this.createToBindDuration = r1;
        }

        public final void setDataSize(Integer r1) {
            this.dataSize = r1;
        }

        public final void setFromDb(Boolean r1) {
            this.isFromDb = r1;
        }

        public final void setLandingToCvsList(Boolean r1) {
            this.isLandingToCvsList = r1;
        }

        public final void setLazyMainComponentEnable(Boolean r1) {
            this.isLazyMainComponentEnable = r1;
        }

        public final void setLogin(Boolean r1) {
            this.isLogin = r1;
        }

        public final void setOnAttachTime(Long r1) {
            this.onAttachTime = r1;
        }

        public final void setOnCreateTime(Long r1) {
            this.onCreateTime = r1;
        }

        public final void setOnDataBindTime(Long r1) {
            this.onDataBindTime = r1;
        }

        public final void setOnDataLoadedTime(Long r1) {
            this.onDataLoadedTime = r1;
        }

        public final void setOnLeaveChatBotTime(Long r1) {
            this.onLeaveChatBotTime = r1;
        }

        public final void setOnResumeTime(Long r1) {
            this.onResumeTime = r1;
        }

        public final void setOnViewCreatedTime(Long r1) {
            this.onViewCreatedTime = r1;
        }

        public final void setResumeToBindDuration(Long r1) {
            this.resumeToBindDuration = r1;
        }

        public final void setResumeToDataLoadedDuration(Long r1) {
            this.resumeToDataLoadedDuration = r1;
        }

        public final void setTotalDuration(Long r1) {
            this.totalDuration = r1;
        }

        public final void setViewCreatedToBindDuration(Long r1) {
            this.viewCreatedToBindDuration = r1;
        }

        public ConversationPageRecord(Long r3, Long r4, Long r5, Long r6, Long r7, Long r8, Long r9, Boolean r10, Boolean r11, Boolean r12, Boolean r13, Boolean r14, Integer r15, Long r16, Long r17, Long r18, Long r19, Long r20, Long r21, Long r22) {
            this.totalDuration = r3;
            this.resumeToBindDuration = r4;
            this.viewCreatedToBindDuration = r5;
            this.createToBindDuration = r6;
            this.resumeToDataLoadedDuration = r7;
            this.attachToAppStartDuration = r8;
            this.chatBotToBindDuration = r9;
            this.chatWithTab = r10;
            this.isLandingToCvsList = r11;
            this.isLazyMainComponentEnable = r12;
            this.isLogin = r13;
            this.isFromDb = r14;
            this.dataSize = r15;
            this.onAttachTime = r16;
            this.onCreateTime = r17;
            this.onViewCreatedTime = r18;
            this.onResumeTime = r19;
            this.onDataLoadedTime = r20;
            this.onDataBindTime = r21;
            this.onLeaveChatBotTime = r22;
        }

        public /* synthetic */ ConversationPageRecord(Long r22, Long r23, Long r24, Long r25, Long r26, Long r27, Long r28, Boolean r29, Boolean r30, Boolean r31, Boolean r32, Boolean r33, Integer r34, Long r35, Long r36, Long r37, Long r38, Long r39, Long r40, Long r41, int r42, DefaultConstructorMarker r43) {
            if ((r42 & 1) == 0) goto L5;
            Long r1 = null;
        L7:
            if ((r42 & 2) == 0) goto L9;
            Long r3 = null;
        L11:
            if ((r42 & 4) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r42 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r42 & 16) == 0) goto L21;
            Long r6 = null;
        L23:
            if ((r42 & 32) == 0) goto L25;
            Long r7 = null;
        L27:
            if ((r42 & 64) == 0) goto L29;
            Long r8 = null;
        L31:
            if ((r42 & 128) == 0) goto L33;
            Boolean r9 = null;
        L35:
            if ((r42 & 256) == 0) goto L37;
            Boolean r10 = null;
        L39:
            if ((r42 & 512) == 0) goto L41;
            Boolean r11 = null;
        L43:
            if ((r42 & 1024) == 0) goto L45;
            Boolean r12 = null;
        L47:
            if ((r42 & 2048) == 0) goto L49;
            Boolean r13 = null;
        L51:
            if ((r42 & 4096) == 0) goto L53;
            Integer r14 = null;
        L55:
            if ((r42 & 8192) == 0) goto L57;
            Long r15 = null;
        L59:
            if ((r42 & 16384) == 0) goto L61;
            Long r2 = null;
        L63:
            if ((r42 & 32768) == 0) goto L65;
            Long r16 = null;
        L67:
            if ((r42 & 65536) == 0) goto L69;
            Long r17 = null;
        L71:
            if ((r42 & 131072) == 0) goto L73;
            Long r18 = null;
        L75:
            if ((r42 & 262144) == 0) goto L77;
            Long r19 = null;
        L79:
            if ((r42 & 524288) == 0) goto L81;
            Long r0 = null;
        L82:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r0);
            return;
        L81:
            r0 = r41;
            goto L82
        L77:
            r19 = r40;
            goto L79
        L73:
            r18 = r39;
            goto L75
        L69:
            r17 = r38;
            goto L71
        L65:
            r16 = r37;
            goto L67
        L61:
            r2 = r36;
            goto L63
        L57:
            r15 = r35;
            goto L59
        L53:
            r14 = r34;
            goto L55
        L49:
            r13 = r33;
            goto L51
        L45:
            r12 = r32;
            goto L47
        L41:
            r11 = r31;
            goto L43
        L37:
            r10 = r30;
            goto L39
        L33:
            r9 = r29;
            goto L35
        L29:
            r8 = r28;
            goto L31
        L25:
            r7 = r27;
            goto L27
        L21:
            r6 = r26;
            goto L23
        L17:
            r5 = r25;
            goto L19
        L13:
            r4 = r24;
            goto L15
        L9:
            r3 = r23;
            goto L11
        L5:
            r1 = r22;
            goto L7
        }
    }

    static {
    }

    public static void a() {
        FLogger.a.d("ConversationPageTrace", "onAttach");
        if (a != null) goto L5;
        a = new ConversationPageRecord(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    L5:
        ConversationPageRecord r0 = a;
        if (r0 == null) goto L9;
        r0.setAttachToAppStartDuration(Long.valueOf(SystemClock.elapsedRealtime() - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue()));
        r0.setOnAttachTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    public static void b() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onCreated, cache is null? ");
        if (a != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.d("ConversationPageTrace", r1.toString());
        ConversationPageRecord r3 = a;
        if (r3 == null) goto L10;
        r3.setOnCreateTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void d() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onLeaveChatBot, cache is null? ");
        if (a != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.d("ConversationPageTrace", r1.toString());
        ConversationPageRecord r3 = a;
        if (r3 == null) goto L10;
        r3.setOnLeaveChatBotTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void f() {
        ConversationPageRecord r0 = a;
        if (r0 == null) goto L5;
        FLogger.a.d("ConversationPageTrace", "onViewBind");
        r0.setOnDataBindTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r0.report();
    L5:
        a = null;
        b = true;
    }

    public static void g() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onViewCreated, cache is null? ");
        if (a != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.d("ConversationPageTrace", r1.toString());
        ConversationPageRecord r3 = a;
        if (r3 == null) goto L10;
        r3.setOnViewCreatedTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void c(boolean r27, int r28) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDataLoaded, isFromDb = ");
        r1.append(r27);
        r1.append(", dataSize = ");
        r1.append(r28);
        r1.append(", cache is null? ");
        if (a != null) goto L5;
        boolean r4 = true;
    L6:
        r1.append(r4);
        r0.d("ConversationPageTrace", r1.toString());
        if (b == false) goto L9;
    L11:
        ConversationPageRecord r2 = a;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.getOnDataLoadedTime() != null) goto L18;
        r2.setOnDataLoadedTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r2.setFromDb(Boolean.valueOf(r27));
        r2.setDataSize(Integer.valueOf(r28));
        return;
    L18:
        return;
    L9:
        if (a != null) goto L11;
        a = new ConversationPageRecord(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public static void e(boolean r3, boolean r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onResume, cache is null? ");
        if (a != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.d("ConversationPageTrace", r1.toString());
        ConversationPageRecord r5 = a;
        if (r5 == null) goto L10;
        r5.setOnResumeTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r5.setLandingToCvsList(Boolean.valueOf(r3));
        r5.setLazyMainComponentEnable(Boolean.valueOf(r4));
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
