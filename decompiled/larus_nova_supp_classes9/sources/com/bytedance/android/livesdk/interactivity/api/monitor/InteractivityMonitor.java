package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bG\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bR¨\u0006S"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/InteractivityMonitor$Event;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", BuildConfig.FLAVOR, "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "PublicScreenMessage", "PublicScreenShowStatus", "PublicScreenHeightError", "PublicScreenRenderError", "PublicScreenMessageActionTypeUnexpected", "PublicScreenRoomExposureError", "PublicScreenRealtimeExposureError", "PublicScreenFirstShowError", "PublicScreenNoMessageShowError", "HighLevelNoMessageShowError", "CommentUserSend", "CommentUserSendSelfShow", "CommentDisable", "CommentIntercept", "AudioTransferError", "DiggDisable", "ProfileDiggDisable", "PinControlStatus", "PinShowStatus", "PinRequest", "PinReview", "IMFirstMessageEmpty", "FirstHistoryMessageEmpty", "FirstRealtimeMessageEmpty", "DanmakuShowLatency", "ChatChannelCreate", "ChatChannelInvite", "ChatChannelJoin", "ChatChannelQuit", "ChatChannelDissolve", "ChatChannelComment", "ChatChannelSettingSet", "ChatChannelSettingUpdate", "ChatChannelCreateShowCost", "ChatChannelInviteShowCost", "SpeechEngineInstallPlugin", "SpeechEngineLoadPlugin", "SpeechEngineInit", "SpeechEngineStart", "SpeechEngineError", "AnchorAsrInterrupted", "AnchorAsrMatch", "AnchorAsrSendComment", "ImageRecognition", "ImageRecognitionRequest", "Degrade", "ReceiveOpenCommentPanelEvent", "InputPanelRequestShow", "InputPanelShow", "InputPanelKeyboardLog", "CostConfirmWindowShow", "CostConfirmWindowClick", "DanmakuSwitchClick", "PublicScreenVisibilityChange", "AICloneInit", "AICloneInitFailed", "AIAutoReplyMessageReceive", "AIAutoReplyMessageShowStatus", "AIAutoReplyTrackReport", "AIBootMessageReceive", "AIBootMessageShowFailed", "PersonalizedStrategyResult", "PersonalizedChannelUplinkNotify", "PersonalizedChannelChange", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event AIAutoReplyMessageReceive = null;
        public static final Event AIAutoReplyMessageShowStatus = null;
        public static final Event AIAutoReplyTrackReport = null;
        public static final Event AIBootMessageReceive = null;
        public static final Event AIBootMessageShowFailed = null;
        public static final Event AICloneInit = null;
        public static final Event AICloneInitFailed = null;
        public static final Event AnchorAsrInterrupted = null;
        public static final Event AnchorAsrMatch = null;
        public static final Event AnchorAsrSendComment = null;
        public static final Event AudioTransferError = null;
        public static final Event ChatChannelComment = null;
        public static final Event ChatChannelCreate = null;
        public static final Event ChatChannelCreateShowCost = null;
        public static final Event ChatChannelDissolve = null;
        public static final Event ChatChannelInvite = null;
        public static final Event ChatChannelInviteShowCost = null;
        public static final Event ChatChannelJoin = null;
        public static final Event ChatChannelQuit = null;
        public static final Event ChatChannelSettingSet = null;
        public static final Event ChatChannelSettingUpdate = null;
        public static final Event CommentDisable = null;
        public static final Event CommentIntercept = null;
        public static final Event CommentUserSend = null;
        public static final Event CommentUserSendSelfShow = null;
        public static final Event CostConfirmWindowClick = null;
        public static final Event CostConfirmWindowShow = null;
        public static final Event DanmakuShowLatency = null;
        public static final Event DanmakuSwitchClick = null;
        public static final Event Degrade = null;
        public static final Event DiggDisable = null;
        public static final Event FirstHistoryMessageEmpty = null;
        public static final Event FirstRealtimeMessageEmpty = null;
        public static final Event HighLevelNoMessageShowError = null;
        public static final Event IMFirstMessageEmpty = null;
        public static final Event ImageRecognition = null;
        public static final Event ImageRecognitionRequest = null;
        public static final Event InputPanelKeyboardLog = null;
        public static final Event InputPanelRequestShow = null;
        public static final Event InputPanelShow = null;
        public static final Event PersonalizedChannelChange = null;
        public static final Event PersonalizedChannelUplinkNotify = null;
        public static final Event PersonalizedStrategyResult = null;
        public static final Event PinControlStatus = null;
        public static final Event PinRequest = null;
        public static final Event PinReview = null;
        public static final Event PinShowStatus = null;
        public static final Event ProfileDiggDisable = null;
        public static final Event PublicScreenFirstShowError = null;
        public static final Event PublicScreenHeightError = null;
        public static final Event PublicScreenMessage = null;
        public static final Event PublicScreenMessageActionTypeUnexpected = null;
        public static final Event PublicScreenNoMessageShowError = null;
        public static final Event PublicScreenRealtimeExposureError = null;
        public static final Event PublicScreenRenderError = null;
        public static final Event PublicScreenRoomExposureError = null;
        public static final Event PublicScreenShowStatus = null;
        public static final Event PublicScreenVisibilityChange = null;
        public static final Event ReceiveOpenCommentPanelEvent = null;
        public static final Event SpeechEngineError = null;
        public static final Event SpeechEngineInit = null;
        public static final Event SpeechEngineInstallPlugin = null;
        public static final Event SpeechEngineLoadPlugin = null;
        public static final Event SpeechEngineStart = null;
        public static final /* synthetic */ Event[] a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        public static Event valueOf(String r1) {
            return (Event) r27.a.a(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        static {
            LiveTracingMonitor.EventModule r18 = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
            Event r8 = new Event("PublicScreenMessage", 0, "ttlive_text_message_apm", r18, true, false);
            PublicScreenMessage = r8;
            boolean r15 = false;
            int r16 = 8;
            DefaultConstructorMarker r17 = null;
            Event r1 = new Event("PublicScreenShowStatus", 1, "ttlive_public_screen_show_status", r18, true, r15, r16, r17);
            PublicScreenShowStatus = r1;
            boolean r14 = false;
            Event r2 = new Event("PublicScreenHeightError", 2, "ttlive_public_screen_height_error", r18, r14, r15, r16, r17);
            PublicScreenHeightError = r2;
            Event r3 = new Event("PublicScreenRenderError", 3, "ttlive_public_screen_render_error", r18, r14, r15, r16, r17);
            PublicScreenRenderError = r3;
            Event r4 = new Event("PublicScreenMessageActionTypeUnexpected", 4, "ttlive_public_screen_message_action_unexpected", r18, r14, r15, r16, r17);
            PublicScreenMessageActionTypeUnexpected = r4;
            boolean r19 = true;
            Event r5 = new Event("PublicScreenRoomExposureError", 5, "ttlive_public_screen_room_exposure_error", r18, r19, r15, r16, r17);
            PublicScreenRoomExposureError = r5;
            Event r6 = new Event("PublicScreenRealtimeExposureError", 6, "ttlive_public_screen_realtime_exposure_error", r18, r19, r15, r16, r17);
            PublicScreenRealtimeExposureError = r6;
            Event r7 = new Event("PublicScreenFirstShowError", 7, "ttlive_public_screen_first_show_error", r18, r19, r15, r16, r17);
            PublicScreenFirstShowError = r7;
            Event r9 = new Event("PublicScreenNoMessageShowError", 8, "ttlive_public_screen_no_message_show_error", r18, r19, r15, r16, r17);
            PublicScreenNoMessageShowError = r9;
            Event r10 = new Event("HighLevelNoMessageShowError", 9, "ttlive_high_level_no_message_show_error", r18, r19, r15, r16, r17);
            HighLevelNoMessageShowError = r10;
            boolean r11 = false;
            boolean r13 = false;
            int r110 = 8;
            DefaultConstructorMarker r111 = null;
            Event r20 = new Event("CommentUserSend", 10, "ttlive_comment_user_send_all", LiveTracingMonitor.EventModule.ROOM_APM, r11, r13, r110, r111);
            CommentUserSend = r20;
            LiveTracingMonitor.EventModule r21 = LiveTracingMonitor.EventModule.COMMENT;
            Event r23 = new Event("CommentUserSendSelfShow", 11, "ttlive_comment_user_send_self_show", r21, r11, r13, r110, r111);
            CommentUserSendSelfShow = r23;
            boolean r112 = true;
            boolean r113 = false;
            int r114 = 8;
            DefaultConstructorMarker r115 = null;
            Event r24 = new Event("CommentDisable", 12, "ttlive_comment_disable", r21, r112, r113, r114, r115);
            CommentDisable = r24;
            Event r25 = new Event("CommentIntercept", 13, "ttlive_comment_intercept", r21, r112, r113, r114, r115);
            CommentIntercept = r25;
            boolean r26 = true;
            boolean r27 = false;
            int r116 = 8;
            DefaultConstructorMarker r117 = null;
            Event r28 = new Event("AudioTransferError", 14, "ttlive_audio_transfer_error", LiveTracingMonitor.EventModule.AUDIO, r26, r27, r116, r117);
            AudioTransferError = r28;
            LiveTracingMonitor.EventModule r29 = LiveTracingMonitor.EventModule.DIGG;
            Event r30 = new Event("DiggDisable", 15, "ttlive_digg_disable", r29, r26, r27, r116, r117);
            DiggDisable = r30;
            Event r31 = new Event("ProfileDiggDisable", 16, "ttlive_profile_digg_disable", r29, r112, r113, r114, r115);
            ProfileDiggDisable = r31;
            LiveTracingMonitor.EventModule r33 = LiveTracingMonitor.EventModule.PIN_COMMENT;
            Event r34 = new Event("PinControlStatus", 17, "ttlive_pin_control_status", r33, false, false, 8, null);
            PinControlStatus = r34;
            boolean r118 = false;
            Event r35 = new Event("PinShowStatus", 18, "ttlive_pin_show_status", r33, r118, r113, r114, r115);
            PinShowStatus = r35;
            Event r36 = new Event("PinRequest", 19, "ttlive_pin_request", r33, r118, r113, r114, r115);
            PinRequest = r36;
            Event r37 = new Event("PinReview", 20, "ttlive_pin_review", r33, r118, r113, r114, r115);
            PinReview = r37;
            LiveTracingMonitor.EventModule r38 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
            Event r39 = new Event("IMFirstMessageEmpty", 21, "ttlive_im_first_message_empty", r38, true, false, 8, null);
            IMFirstMessageEmpty = r39;
            boolean r119 = true;
            Event r40 = new Event("FirstHistoryMessageEmpty", 22, "ttlive_first_history_message_empty", r38, r119, r113, r114, r115);
            FirstHistoryMessageEmpty = r40;
            Event r41 = new Event("FirstRealtimeMessageEmpty", 23, "ttlive_first_realtime_message_empty", r38, r119, r113, r114, r115);
            FirstRealtimeMessageEmpty = r41;
            Event r43 = new Event("DanmakuShowLatency", 24, "ttlive_danmaku_show_latency", LiveTracingMonitor.EventModule.DANMAKU, false, false, 8, null);
            DanmakuShowLatency = r43;
            LiveTracingMonitor.EventModule r44 = LiveTracingMonitor.EventModule.CHAT_CHANNEL;
            Event r45 = new Event("ChatChannelCreate", 25, "ttlive_chat_channel_create", r44, true, true);
            ChatChannelCreate = r45;
            Event r46 = new Event("ChatChannelInvite", 26, "ttlive_chat_channel_invite", r44, true, true);
            ChatChannelInvite = r46;
            Event r47 = new Event("ChatChannelJoin", 27, "ttlive_chat_channel_join", r44, true, true);
            ChatChannelJoin = r47;
            Event r48 = new Event("ChatChannelQuit", 28, "ttlive_chat_channel_quit", r44, true, true);
            ChatChannelQuit = r48;
            Event r49 = new Event("ChatChannelDissolve", 29, "ttlive_chat_channel_dissolve", r44, true, true);
            ChatChannelDissolve = r49;
            Event r50 = new Event("ChatChannelComment", 30, "ttlive_chat_channel_comment", r44, true, true);
            ChatChannelComment = r50;
            Event r51 = new Event("ChatChannelSettingSet", 31, "ttlive_chat_channel_setting_set", r44, true, true);
            ChatChannelSettingSet = r51;
            Event r53 = new Event("ChatChannelSettingUpdate", 32, "ttlive_chat_channel_setting_update", r44, true, true);
            ChatChannelSettingUpdate = r53;
            Event r54 = new Event("ChatChannelCreateShowCost", 33, "ttlive_chat_channel_create_show", r44, true, true);
            ChatChannelCreateShowCost = r54;
            Event r55 = new Event("ChatChannelInviteShowCost", 34, "ttlive_chat_channel_invite_show", r44, true, true);
            ChatChannelInviteShowCost = r55;
            LiveTracingMonitor.EventModule r56 = LiveTracingMonitor.EventModule.ANCHOR_ASR;
            Event r57 = new Event("SpeechEngineInstallPlugin", 35, "ttlive_speech_engine_install_plugin", r56, true, true);
            SpeechEngineInstallPlugin = r57;
            Event r58 = new Event("SpeechEngineLoadPlugin", 36, "ttlive_speech_engine_load_plugin", r56, true, true);
            SpeechEngineLoadPlugin = r58;
            Event r59 = new Event("SpeechEngineInit", 37, "ttlive_speech_engine_init", r56, true, true);
            SpeechEngineInit = r59;
            Event r60 = new Event("SpeechEngineStart", 38, "ttlive_speech_engine_start", r56, true, true);
            SpeechEngineStart = r60;
            Event r61 = new Event("SpeechEngineError", 39, "ttlive_speech_engine_error", r56, true, true);
            SpeechEngineError = r61;
            Event r63 = new Event("AnchorAsrInterrupted", 40, "ttlive_anchor_asr_interrupted", r56, true, true);
            AnchorAsrInterrupted = r63;
            Event r64 = new Event("AnchorAsrMatch", 41, "ttlive_anchor_asr_match", r56, true, true);
            AnchorAsrMatch = r64;
            Event r65 = new Event("AnchorAsrSendComment", 42, "ttlive_anchor_asr_send_comment", r56, true, true);
            AnchorAsrSendComment = r65;
            LiveTracingMonitor.EventModule r120 = LiveTracingMonitor.EventModule.IMAGE_RECOGNITION;
            Event r66 = new Event("ImageRecognition", 43, "ttlive_image_recognition", r120, true, true);
            ImageRecognition = r66;
            Event r67 = new Event("ImageRecognitionRequest", 44, "ttlive_image_recognition_request", r120, true, true);
            ImageRecognitionRequest = r67;
            Event r68 = new Event("Degrade", 45, "ttlive_interactivity_degrade_happen", LiveTracingMonitor.EventModule.INTERACTIVITY_DEGRADE, true, true);
            Degrade = r68;
            LiveTracingMonitor.EventModule r69 = LiveTracingMonitor.EventModule.INPUT_PANEL;
            Event r70 = new Event("ReceiveOpenCommentPanelEvent", 46, "ttlive_input_panel_receive_lottery_jsb_event", r69, true, true);
            ReceiveOpenCommentPanelEvent = r70;
            Event r71 = new Event("InputPanelRequestShow", 47, "ttlive_input_panel_request_show_event", r69, true, true);
            InputPanelRequestShow = r71;
            Event r73 = new Event("InputPanelShow", 48, "ttlive_input_panel_show", r69, true, true);
            InputPanelShow = r73;
            Event r74 = new Event("InputPanelKeyboardLog", 49, "ttlive_input_panel_keyboard_log", r69, true, true);
            InputPanelKeyboardLog = r74;
            Event r75 = new Event("CostConfirmWindowShow", 50, "ttlive_input_panel_danmaku_cost_tip_show", r69, true, true);
            CostConfirmWindowShow = r75;
            Event r76 = new Event("CostConfirmWindowClick", 51, "ttlive_input_panel_danmaku_cost_tip_click", r69, true, true);
            CostConfirmWindowClick = r76;
            Event r77 = new Event("DanmakuSwitchClick", 52, "ttlive_input_panel_danmaku_switch_click", r69, true, true);
            DanmakuSwitchClick = r77;
            Event r78 = new Event("PublicScreenVisibilityChange", 53, "ttlive_public_screen_visibility_change", r18, true, true);
            PublicScreenVisibilityChange = r78;
            LiveTracingMonitor.EventModule r79 = LiveTracingMonitor.EventModule.AI_CLONE;
            Event r80 = new Event("AICloneInit", 54, "ttlive_ai_clone_init", r79, true, true);
            AICloneInit = r80;
            Event r81 = new Event("AICloneInitFailed", 55, "ttlive_ai_clone_init_failed", r79, true, true);
            AICloneInitFailed = r81;
            Event r83 = new Event("AIAutoReplyMessageReceive", 56, "ttlive_ai_auto_reply_message_receive", r79, true, true);
            AIAutoReplyMessageReceive = r83;
            Event r84 = new Event("AIAutoReplyMessageShowStatus", 57, "ttlive_ai_auto_reply_message_show_status", r79, true, true);
            AIAutoReplyMessageShowStatus = r84;
            Event r85 = new Event("AIAutoReplyTrackReport", 58, "ttlive_ai_auto_reply_message_track_report", r79, true, true);
            AIAutoReplyTrackReport = r85;
            Event r86 = new Event("AIBootMessageReceive", 59, "ttlive_ai_boot_message_receive", r79, true, true);
            AIBootMessageReceive = r86;
            Event r87 = new Event("AIBootMessageShowFailed", 60, "ttlive_ai_boot_message_show_failed", r79, true, true);
            AIBootMessageShowFailed = r87;
            LiveTracingMonitor.EventModule r88 = LiveTracingMonitor.EventModule.PERSONALIZED_CHANNEL;
            Event r89 = new Event("PersonalizedStrategyResult", 61, "ttlive_personalized_strategy_change", r88, true, true);
            PersonalizedStrategyResult = r89;
            Event r90 = new Event("PersonalizedChannelUplinkNotify", 62, "ttlive_personalized_channel_uplink_notify", r88, true, true);
            PersonalizedChannelUplinkNotify = r90;
            Event r91 = new Event("PersonalizedChannelChange", 63, "ttlive_personalized_channel_change", r88, true, true);
            PersonalizedChannelChange = r91;
            a = new Event[]{r8, r1, r2, r3, r4, r5, r6, r7, r9, r10, r20, r23, r24, r25, r28, r30, r31, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r57, r58, r59, r60, r61, r63, r64, r65, r66, r67, r68, r70, r71, r73, r74, r75, r76, r77, r78, r80, r81, r83, r84, r85, r86, r87, r89, r90, r91};
        }

        public final LiveTracingMonitor.EventModule getEventModule() {
            return this.eventModule;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final boolean getExtraALog() {
            return this.extraALog;
        }

        public final boolean getReportInLocalTest() {
            return this.reportInLocalTest;
        }

        public Event(String r1, int r2, String r3, LiveTracingMonitor.EventModule r4, boolean r5, boolean r6) {
            super(r1, r2);
            this.eventName = r3;
            this.eventModule = r4;
            this.extraALog = r5;
            this.reportInLocalTest = r6;
        }

        public /* synthetic */ Event(String r8, int r9, String r10, LiveTracingMonitor.EventModule r11, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r15 & 8) == 0) goto L9;
            boolean r6 = true;
        L10:
            this(r8, r9, r10, r11, r5, r6);
            return;
        L9:
            r6 = r14;
            goto L10
        L5:
            r5 = r13;
            goto L7
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(Event r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        c(r3, r4, 1, null, 24);
    }

    @JvmStatic
    public static final LiveMonitor.a a(Event r6, IRoom r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "event");
        LiveMonitor.a r0 = new LiveMonitor.a(r6.getEventName(), r6.getEventModule());
        if (r7 == null) goto L33;
        LiveMode r1 = r7.getStreamType();
        int r2 = h1.a;
        r0.e("category_1", i1.a(r1));
        String r3 = r7.getOwnerUserIdString();
        boolean r4 = false;
        if (r3 == null) goto L29;
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L29;
        com.bytedance.android.livesdk.user.e r9 = r5.user();
        if (r9 == null) goto L29;
        String r10 = r9.n();
        if (r10 == null) goto L29;
        if (r3.length() <= 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L29;
        if (r10.length() <= 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L29;
        if ((!Intrinsics.areEqual("0", r10)) == false) goto L29;
        if (Intrinsics.areEqual(r3, r10) == false) goto L29;
        r4 = true;
        goto L29
    L22:
        r13 = false;
        goto L23
    L17:
        r11 = false;
    L29:
        if (r4 == false) goto L31;
        String r14 = "anchor";
    L32:
        r0.e("category_2", r14);
        r0.i("room_id", String.valueOf(r7.getRoomId()));
        r0.i("anchor_id", r7.getOwnerUserIdString());
        goto L33
    L31:
        r14 = "audience";
    L33:
        if (r8 == null) goto L35;
        r0.i("biz_id", r8);
    L35:
        r0.f = r6.getExtraALog();
        r0.h = r6.getReportInLocalTest();
        return r0;
    }

    public static void c(Event r1, IRoom r2, Integer r3, String r4, int r5) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "event");
        LiveMonitor.a r6 = a(r1, r2, null);
        if (r3 == null) goto L8;
        r3.intValue();
        r6.l(r3.intValue());
    L8:
        if (r4 == null) goto L10;
        r6.e("status", r4);
    L10:
        r6.a().report();
    }
}
