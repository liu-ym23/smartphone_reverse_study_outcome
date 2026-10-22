package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityTraceMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b)\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/InteractivityTraceMonitor$Event;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "businessType", "getBusinessType", "productId", "getProductId", BuildConfig.FLAVOR, "needRoomCommonParams", "Z", "getNeedRoomCommonParams", "()Z", "ChatChannelCreate", "ChatChannelDelete", "ChatChannelInvite", "ChatChannelJoin", "ChatChannelTryCreate", "ChatChannelQuit", "ChatChannelDissolve", "ChatChannelComment", "ChatChannelSettingSet", "ChatChannelSettingUpdate", "ChatChannelCreateMessage", "ChatChannelSecretMessageSend", "ReceiveOpenCommentPanelEvent", "InputPanelRequestShow", "InputPanelShow", "InputPanelKeyboardLog", "CostConfirmWindowShow", "CostConfirmWindowClick", "DanmakuSwitchClick", "SendIntercept", "InputAIParamLog", "RichContentEngineError", "PublicScreenContextEmpty", "FirstMessageShowDelay", "PublicScreenVisibilityChange", "PublicScreenAdjustLayout", "PublicScreenAudioPlayEvent", "PublicScreenMaskEvent", "PublicScreenTopMsgEvent", "PublicScreenHistoryMsgFailEvent", "PublicScreenLiftUpEvent", "PublicScreenSelfGiftEvent", "PrivilegeDanmakuShow", "CarnivalModelDownload", "CarnivalOpenContour", "CarnivalReceiveSei", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event CarnivalModelDownload = null;
        public static final Event CarnivalOpenContour = null;
        public static final Event CarnivalReceiveSei = null;
        public static final Event ChatChannelComment = null;
        public static final Event ChatChannelCreate = null;
        public static final Event ChatChannelCreateMessage = null;
        public static final Event ChatChannelDelete = null;
        public static final Event ChatChannelDissolve = null;
        public static final Event ChatChannelInvite = null;
        public static final Event ChatChannelJoin = null;
        public static final Event ChatChannelQuit = null;
        public static final Event ChatChannelSecretMessageSend = null;
        public static final Event ChatChannelSettingSet = null;
        public static final Event ChatChannelSettingUpdate = null;
        public static final Event ChatChannelTryCreate = null;
        public static final Event CostConfirmWindowClick = null;
        public static final Event CostConfirmWindowShow = null;
        public static final Event DanmakuSwitchClick = null;
        public static final Event FirstMessageShowDelay = null;
        public static final Event InputAIParamLog = null;
        public static final Event InputPanelKeyboardLog = null;
        public static final Event InputPanelRequestShow = null;
        public static final Event InputPanelShow = null;
        public static final Event PrivilegeDanmakuShow = null;
        public static final Event PublicScreenAdjustLayout = null;
        public static final Event PublicScreenAudioPlayEvent = null;
        public static final Event PublicScreenContextEmpty = null;
        public static final Event PublicScreenHistoryMsgFailEvent = null;
        public static final Event PublicScreenLiftUpEvent = null;
        public static final Event PublicScreenMaskEvent = null;
        public static final Event PublicScreenSelfGiftEvent = null;
        public static final Event PublicScreenTopMsgEvent = null;
        public static final Event PublicScreenVisibilityChange = null;
        public static final Event ReceiveOpenCommentPanelEvent = null;
        public static final Event RichContentEngineError = null;
        public static final Event SendIntercept = null;
        public static final /* synthetic */ Event[] a = null;
        private final String businessType;
        private final String eventType;
        private final boolean needRoomCommonParams;
        private final String productId;

        public static Event valueOf(String r1) {
            return (Event) r27.a.a(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        static {
            Event r8 = new Event("ChatChannelCreate", 0, "ttlive_chat_channel_create", "chat_channel", "webcast_client_community", true);
            ChatChannelCreate = r8;
            Event r1 = new Event("ChatChannelDelete", 1, "ttlive_chat_channel_delete", "chat_channel", "webcast_client_community", true);
            ChatChannelDelete = r1;
            Event r2 = new Event("ChatChannelInvite", 2, "ttlive_chat_channel_invite", "chat_channel", "webcast_client_community", true);
            ChatChannelInvite = r2;
            Event r3 = new Event("ChatChannelJoin", 3, "ttlive_chat_channel_join", "chat_channel", "webcast_client_community", true);
            ChatChannelJoin = r3;
            Event r4 = new Event("ChatChannelTryCreate", 4, "ttlive_chat_channel_try_create", "chat_channel", "webcast_client_community", true);
            ChatChannelTryCreate = r4;
            Event r5 = new Event("ChatChannelQuit", 5, "ttlive_chat_channel_quit", "chat_channel", "webcast_client_community", true);
            ChatChannelQuit = r5;
            Event r6 = new Event("ChatChannelDissolve", 6, "ttlive_chat_channel_dissolve", "chat_channel", "webcast_client_community", true);
            ChatChannelDissolve = r6;
            Event r7 = new Event("ChatChannelComment", 7, "ttlive_chat_channel_comment", "chat_channel", "webcast_client_community", true);
            ChatChannelComment = r7;
            Event r9 = new Event("ChatChannelSettingSet", 8, "ttlive_chat_channel_setting_set", "chat_channel", "webcast_client_community", true);
            ChatChannelSettingSet = r9;
            Event r10 = new Event("ChatChannelSettingUpdate", 9, "ttlive_chat_channel_setting_update", "chat_channel", "webcast_client_community", true);
            ChatChannelSettingUpdate = r10;
            Event r11 = new Event("ChatChannelCreateMessage", 10, "ttlive_chat_channel_receive_create_message", "chat_channel", "webcast_client_community", true);
            ChatChannelCreateMessage = r11;
            Event r13 = new Event("ChatChannelSecretMessageSend", 11, "ttlive_chat_channel_secret_message_send", "chat_channel", "webcast_client_community", true);
            ChatChannelSecretMessageSend = r13;
            Event r14 = new Event("ReceiveOpenCommentPanelEvent", 12, "ttlive_input_panel_receive_lottery_jsb_event", "input_panel", "webcast_client_community", true);
            ReceiveOpenCommentPanelEvent = r14;
            Event r15 = new Event("InputPanelRequestShow", 13, "ttlive_input_panel_request_show_event", "input_panel", "webcast_client_community", true);
            InputPanelRequestShow = r15;
            Event r16 = new Event("InputPanelShow", 14, "ttlive_input_panel_show", "input_panel", "webcast_client_community", true);
            InputPanelShow = r16;
            Event r17 = new Event("InputPanelKeyboardLog", 15, "ttlive_input_panel_keyboard_log", "input_panel", "webcast_client_community", true);
            InputPanelKeyboardLog = r17;
            Event r18 = new Event("CostConfirmWindowShow", 16, "ttlive_input_panel_danmaku_cost_tip_show", "input_panel", "webcast_client_community", true);
            CostConfirmWindowShow = r18;
            Event r19 = new Event("CostConfirmWindowClick", 17, "ttlive_input_panel_danmaku_cost_tip_click", "input_panel", "webcast_client_community", true);
            CostConfirmWindowClick = r19;
            Event r20 = new Event("DanmakuSwitchClick", 18, "ttlive_input_panel_danmaku_switch_click", "input_panel", "webcast_client_community", true);
            DanmakuSwitchClick = r20;
            Event r21 = new Event("SendIntercept", 19, "ttlive_input_panel_send_intercept", "input_panel", "webcast_client_community", true);
            SendIntercept = r21;
            Event r23 = new Event("InputAIParamLog", 20, "ttlive_input_panel_ai_param_log", "input_panel", "webcast_client_community", true);
            InputAIParamLog = r23;
            Event r24 = new Event("RichContentEngineError", 21, "ttlive_public_screen_rich_content_engine_error", "public_screen", "webcast_client_community", true);
            RichContentEngineError = r24;
            Event r25 = new Event("PublicScreenContextEmpty", 22, "ttlive_public_screen_context_empty_error", "public_screen", "webcast_client_community", true);
            PublicScreenContextEmpty = r25;
            Event r26 = new Event("FirstMessageShowDelay", 23, "ttlive_public_screen_first_message_show_delay", "public_screen", "webcast_client_community", true);
            FirstMessageShowDelay = r26;
            Event r27 = new Event("PublicScreenVisibilityChange", 24, "ttlive_public_screen_visibility_change", "public_screen", "webcast_client_community", true);
            PublicScreenVisibilityChange = r27;
            Event r28 = new Event("PublicScreenAdjustLayout", 25, "ttlive_public_screen_adjust_layout", "public_screen", "webcast_client_community", true);
            PublicScreenAdjustLayout = r28;
            Event r29 = new Event("PublicScreenAudioPlayEvent", 26, "ttlive_public_screen_audio_comment_play", "public_screen", "webcast_client_community", true);
            PublicScreenAudioPlayEvent = r29;
            Event r30 = new Event("PublicScreenMaskEvent", 27, "ttlive_public_screen_mask_event_record", "public_screen", "webcast_client_community", true);
            PublicScreenMaskEvent = r30;
            Event r31 = new Event("PublicScreenTopMsgEvent", 28, "ttlive_public_screen_top_msg_backend_event", "public_screen", "webcast_client_community", true);
            PublicScreenTopMsgEvent = r31;
            Event r33 = new Event("PublicScreenHistoryMsgFailEvent", 29, "ttlive_public_screen_history_msg_fetch_error", "public_screen", "webcast_client_community", true);
            PublicScreenHistoryMsgFailEvent = r33;
            Event r34 = new Event("PublicScreenLiftUpEvent", 30, "ttlive_public_screen_lift_up_event", "public_screen", "webcast_client_community", true);
            PublicScreenLiftUpEvent = r34;
            Event r35 = new Event("PublicScreenSelfGiftEvent", 31, "ttlive_public_screen_self_gift_event_receive", "public_screen", "webcast_client_community", true);
            PublicScreenSelfGiftEvent = r35;
            Event r36 = new Event("PrivilegeDanmakuShow", 32, "ttlive_danmaku_privilege_message_summary", "danmaku", "webcast_client_community", true);
            PrivilegeDanmakuShow = r36;
            Event r37 = new Event("CarnivalModelDownload", 33, "ttlive_danmaku_carnival_model_download", "danmaku", "webcast_client_community", true);
            CarnivalModelDownload = r37;
            Event r38 = new Event("CarnivalOpenContour", 34, "ttlive_danmaku_carnival_open_contour", "danmaku", "webcast_client_community", true);
            CarnivalOpenContour = r38;
            Event r39 = new Event("CarnivalReceiveSei", 35, "ttlive_danmaku_carnival_receive_sei", "danmaku", "webcast_client_community", true);
            CarnivalReceiveSei = r39;
            a = new Event[]{r8, r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34, r35, r36, r37, r38, r39};
        }

        public final String getBusinessType() {
            return this.businessType;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final boolean getNeedRoomCommonParams() {
            return this.needRoomCommonParams;
        }

        public final String getProductId() {
            return this.productId;
        }

        public Event(String r1, int r2, String r3, String r4, String r5, boolean r6) {
            super(r1, r2);
            this.eventType = r3;
            this.businessType = r4;
            this.productId = r5;
            this.needRoomCommonParams = r6;
        }

        public /* synthetic */ Event(String r8, int r9, String r10, String r11, String r13, boolean r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 8) == 0) goto L5;
            boolean r6 = true;
        L6:
            this(r8, r9, r10, r11, r13, r6);
            return;
        L5:
            r6 = r14;
            goto L6
        }
    }

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
    }
}
