package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/InputValueNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "ClickComment", "DialogPopup", "ClickSend", "SendChat", "SendAudio", "SendPrivilegeDanmaku", "SendAdminDanmaku", "SendChatSuccess", "SendAudioSuccess", "SendAdminDanmakuSuccess", "SendPrivilegeDanmakuSuccess", "PortraitClickSendCount", "PortraitChatApiTriggerCount", "PortraitChatApiSuccessCount", "PortraitSelfChatShowCount", "LandscapeClickSendCount", "LandscapeChatApiTriggerCount", "LandscapeChatApiSuccessCount", "LandscapeSelfChatShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputValueNode extends Enum<InputValueNode> {
    public static final InputValueNode ClickComment = null;
    public static final InputValueNode ClickSend = null;
    public static final InputValueNode DialogPopup = null;
    public static final InputValueNode LandscapeChatApiSuccessCount = null;
    public static final InputValueNode LandscapeChatApiTriggerCount = null;
    public static final InputValueNode LandscapeClickSendCount = null;
    public static final InputValueNode LandscapeSelfChatShowCount = null;
    public static final InputValueNode PortraitChatApiSuccessCount = null;
    public static final InputValueNode PortraitChatApiTriggerCount = null;
    public static final InputValueNode PortraitClickSendCount = null;
    public static final InputValueNode PortraitSelfChatShowCount = null;
    public static final InputValueNode SendAdminDanmaku = null;
    public static final InputValueNode SendAdminDanmakuSuccess = null;
    public static final InputValueNode SendAudio = null;
    public static final InputValueNode SendAudioSuccess = null;
    public static final InputValueNode SendChat = null;
    public static final InputValueNode SendChatSuccess = null;
    public static final InputValueNode SendPrivilegeDanmaku = null;
    public static final InputValueNode SendPrivilegeDanmakuSuccess = null;
    public static final /* synthetic */ InputValueNode[] a = null;
    private final String valueNodeName;

    public static InputValueNode valueOf(String r1) {
        return (InputValueNode) a.a(InputValueNode.class, r1);
    }

    public static InputValueNode[] values() {
        return (InputValueNode[]) a.clone();
    }

    static {
        InputValueNode r1 = new InputValueNode("ClickComment", 0, "click_comment");
        ClickComment = r1;
        InputValueNode r2 = new InputValueNode("DialogPopup", 1, "dialog_popup");
        DialogPopup = r2;
        InputValueNode r3 = new InputValueNode("ClickSend", 2, "click_send");
        ClickSend = r3;
        InputValueNode r4 = new InputValueNode("SendChat", 3, "send_chat");
        SendChat = r4;
        InputValueNode r5 = new InputValueNode("SendAudio", 4, "send_audio");
        SendAudio = r5;
        InputValueNode r6 = new InputValueNode("SendPrivilegeDanmaku", 5, "send_privilege_danmaku");
        SendPrivilegeDanmaku = r6;
        InputValueNode r7 = new InputValueNode("SendAdminDanmaku", 6, "send_admin_danmaku");
        SendAdminDanmaku = r7;
        InputValueNode r8 = new InputValueNode("SendChatSuccess", 7, "send_chat_success");
        SendChatSuccess = r8;
        InputValueNode r9 = new InputValueNode("SendAudioSuccess", 8, "send_audio_success");
        SendAudioSuccess = r9;
        InputValueNode r10 = new InputValueNode("SendAdminDanmakuSuccess", 9, "send_admin_danmaku_success");
        SendAdminDanmakuSuccess = r10;
        InputValueNode r11 = new InputValueNode("SendPrivilegeDanmakuSuccess", 10, "send_privilege_danmaku_success");
        SendPrivilegeDanmakuSuccess = r11;
        InputValueNode r13 = new InputValueNode("PortraitClickSendCount", 11, "portrait_click_send_count");
        PortraitClickSendCount = r13;
        InputValueNode r14 = new InputValueNode("PortraitChatApiTriggerCount", 12, "portrait_chat_api_trigger_count");
        PortraitChatApiTriggerCount = r14;
        InputValueNode r15 = new InputValueNode("PortraitChatApiSuccessCount", 13, "portrait_chat_api_success_count");
        PortraitChatApiSuccessCount = r15;
        InputValueNode r16 = new InputValueNode("PortraitSelfChatShowCount", 14, "portrait_self_chat_show_count");
        PortraitSelfChatShowCount = r16;
        InputValueNode r17 = new InputValueNode("LandscapeClickSendCount", 15, "landscape_click_send_count");
        LandscapeClickSendCount = r17;
        InputValueNode r18 = new InputValueNode("LandscapeChatApiTriggerCount", 16, "landscape_chat_api_trigger_count");
        LandscapeChatApiTriggerCount = r18;
        InputValueNode r19 = new InputValueNode("LandscapeChatApiSuccessCount", 17, "landscape_chat_api_success_count");
        LandscapeChatApiSuccessCount = r19;
        InputValueNode r20 = new InputValueNode("LandscapeSelfChatShowCount", 18, "landscape_self_chat_show_count");
        LandscapeSelfChatShowCount = r20;
        a = new InputValueNode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20};
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public InputValueNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.valueNodeName = r3;
    }
}
