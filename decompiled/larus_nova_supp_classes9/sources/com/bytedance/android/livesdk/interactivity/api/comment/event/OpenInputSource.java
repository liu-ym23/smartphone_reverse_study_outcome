package com.bytedance.android.livesdk.interactivity.api.comment.event;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/OpenInputSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "ClickCommentBox", "EmojiExpose", "LongPressMessage", "PSDialogReply", "AudiencePSDialogReply", "ProfileAt", "AnchorInteractivityPanel", "ChatChannel", "SecretChat", "ReplySecretChat", "ReplyHeartSecretChat", "AtUserEvent", "OpenPanelEvent", "OpenEmojiEvent", "InputActivityEmojiEvent", "InputFusionEmojiEvent", "OpenLiveEvent", "Preview", "BindMobilePhone", "Unknow", "GuideEvent", "PreviewEntryChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenInputSource extends Enum<OpenInputSource> {
    public static final OpenInputSource AnchorInteractivityPanel = null;
    public static final OpenInputSource AtUserEvent = null;
    public static final OpenInputSource AudiencePSDialogReply = null;
    public static final OpenInputSource BindMobilePhone = null;
    public static final OpenInputSource ChatChannel = null;
    public static final OpenInputSource ClickCommentBox = null;
    public static final OpenInputSource EmojiExpose = null;
    public static final OpenInputSource GuideEvent = null;
    public static final OpenInputSource InputActivityEmojiEvent = null;
    public static final OpenInputSource InputFusionEmojiEvent = null;
    public static final OpenInputSource LongPressMessage = null;
    public static final OpenInputSource OpenEmojiEvent = null;
    public static final OpenInputSource OpenLiveEvent = null;
    public static final OpenInputSource OpenPanelEvent = null;
    public static final OpenInputSource PSDialogReply = null;
    public static final OpenInputSource Preview = null;
    public static final OpenInputSource PreviewEntryChat = null;
    public static final OpenInputSource ProfileAt = null;
    public static final OpenInputSource ReplyHeartSecretChat = null;
    public static final OpenInputSource ReplySecretChat = null;
    public static final OpenInputSource SecretChat = null;
    public static final OpenInputSource Unknow = null;
    public static final /* synthetic */ OpenInputSource[] a = null;
    private final String source;

    public static OpenInputSource valueOf(String r1) {
        return (OpenInputSource) a.a(OpenInputSource.class, r1);
    }

    public static OpenInputSource[] values() {
        return (OpenInputSource[]) a.clone();
    }

    static {
        OpenInputSource r1 = new OpenInputSource("ClickCommentBox", 0, "click_comment_box");
        ClickCommentBox = r1;
        OpenInputSource r2 = new OpenInputSource("EmojiExpose", 1, "emojiExpose");
        EmojiExpose = r2;
        OpenInputSource r3 = new OpenInputSource("LongPressMessage", 2, "long_press_message");
        LongPressMessage = r3;
        OpenInputSource r4 = new OpenInputSource("PSDialogReply", 3, "ps_dialog_reply");
        PSDialogReply = r4;
        OpenInputSource r5 = new OpenInputSource("AudiencePSDialogReply", 4, "audience_ps_dialog_reply");
        AudiencePSDialogReply = r5;
        OpenInputSource r6 = new OpenInputSource("ProfileAt", 5, "profile_at");
        ProfileAt = r6;
        OpenInputSource r7 = new OpenInputSource("AnchorInteractivityPanel", 6, "anchor_interactivity_panel");
        AnchorInteractivityPanel = r7;
        OpenInputSource r8 = new OpenInputSource("ChatChannel", 7, "chat_channel");
        ChatChannel = r8;
        OpenInputSource r9 = new OpenInputSource("SecretChat", 8, "secret_chat");
        SecretChat = r9;
        OpenInputSource r10 = new OpenInputSource("ReplySecretChat", 9, "reply_secret_chat");
        ReplySecretChat = r10;
        OpenInputSource r11 = new OpenInputSource("ReplyHeartSecretChat", 10, "reply_heart_secret_chat");
        ReplyHeartSecretChat = r11;
        OpenInputSource r13 = new OpenInputSource("AtUserEvent", 11, "jsb_at_user");
        AtUserEvent = r13;
        OpenInputSource r14 = new OpenInputSource("OpenPanelEvent", 12, "jsb_open_panel");
        OpenPanelEvent = r14;
        OpenInputSource r15 = new OpenInputSource("OpenEmojiEvent", 13, "jsb_open_emoji");
        OpenEmojiEvent = r15;
        OpenInputSource r16 = new OpenInputSource("InputActivityEmojiEvent", 14, "jsb_input_activity_emoji");
        InputActivityEmojiEvent = r16;
        OpenInputSource r17 = new OpenInputSource("InputFusionEmojiEvent", 15, "jsb_input_fusion_emoji");
        InputFusionEmojiEvent = r17;
        OpenInputSource r18 = new OpenInputSource("OpenLiveEvent", 16, "jsb_open_live");
        OpenLiveEvent = r18;
        OpenInputSource r19 = new OpenInputSource("Preview", 17, "preview");
        Preview = r19;
        OpenInputSource r20 = new OpenInputSource("BindMobilePhone", 18, "bind_phone_number");
        BindMobilePhone = r20;
        OpenInputSource r21 = new OpenInputSource("Unknow", 19, "unknow");
        Unknow = r21;
        OpenInputSource r23 = new OpenInputSource("GuideEvent", 20, "guide_event");
        GuideEvent = r23;
        OpenInputSource r24 = new OpenInputSource("PreviewEntryChat", 21, "preview_entry_chat");
        PreviewEntryChat = r24;
        a = new OpenInputSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24};
    }

    public final String getSource() {
        return this.source;
    }

    public OpenInputSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
