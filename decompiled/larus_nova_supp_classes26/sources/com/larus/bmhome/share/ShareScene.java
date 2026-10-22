package com.larus.bmhome.share;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b2\b\u0086\u0081\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00065"}, d2 = {"Lcom/larus/bmhome/share/ShareScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "SHARE_APP", "COMMON_BOT", "COMMON_BOT_WITH_SAVE", "NOTICE_LIST", "IMAGE_VIEWER", "WEBVIEW", "MESSAGES_LINK", "MESSAGES_LINK_SUB_CONV", "MESSAGES_LINK_IMAGE", "MUSIC_VIDEO", "VIDEO_VIEWER", "VIDEO_COMPREHEND", "CONVERSATION_GROUP", "CONVERSATION_GROUP_WITH_SAVE", "IMAGE_VIEWER_REPORT", "MUSIC_VIDEO_REPORT", "SHOW_LONG_IMAGE", "SHOW_LONG_ALBUM", "TABLE_FULL_SCREEN_PAGE", "CODE_FULL_SCREEN_PAGE", "SDK_VIDEO", "SIDEBAR_LONG_PRESS_CELL", "CASE", "DEEP_RESEARCH_EPISODE", "DOCUMENT", "DOCUMENT_CANNOT_EXPORT", "SLIDES", "SHEET", "BITABLE", "DRIVE", "MINI_ARTIFACT", "SINGLE_IMAGE", "SHARE_LINK", "SAAS_SHARE", "Z_SHARE_LINK_PLANB", "OFFICE_MY_QR_CODE", "OFFICE_SHARE_CHAT", "BOT_FILE_PREVIEW", "OFFICE_GROUP_QR_CODE", "OFFICE_SHARE_THREAD", "SOCIAL_IMAGE_SHARE", "SOCIAL_VIDEO_SHARE", "CONVERSATION_CCM", "UNKNOWN", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareScene extends Enum<ShareScene> {
    public static final ShareScene BITABLE = null;
    public static final ShareScene BOT_FILE_PREVIEW = null;
    public static final ShareScene CASE = null;
    public static final ShareScene CODE_FULL_SCREEN_PAGE = null;
    public static final ShareScene COMMON_BOT = null;
    public static final ShareScene COMMON_BOT_WITH_SAVE = null;
    public static final ShareScene CONVERSATION_CCM = null;
    public static final ShareScene CONVERSATION_GROUP = null;
    public static final ShareScene CONVERSATION_GROUP_WITH_SAVE = null;
    public static final a Companion = null;
    public static final ShareScene DEEP_RESEARCH_EPISODE = null;
    public static final ShareScene DOCUMENT = null;
    public static final ShareScene DOCUMENT_CANNOT_EXPORT = null;
    public static final ShareScene DRIVE = null;
    public static final ShareScene IMAGE_VIEWER = null;
    public static final ShareScene IMAGE_VIEWER_REPORT = null;
    public static final ShareScene MESSAGES_LINK = null;
    public static final ShareScene MESSAGES_LINK_IMAGE = null;
    public static final ShareScene MESSAGES_LINK_SUB_CONV = null;
    public static final ShareScene MINI_ARTIFACT = null;
    public static final ShareScene MUSIC_VIDEO = null;
    public static final ShareScene MUSIC_VIDEO_REPORT = null;
    public static final ShareScene NOTICE_LIST = null;
    public static final ShareScene OFFICE_GROUP_QR_CODE = null;
    public static final ShareScene OFFICE_MY_QR_CODE = null;
    public static final ShareScene OFFICE_SHARE_CHAT = null;
    public static final ShareScene OFFICE_SHARE_THREAD = null;
    public static final ShareScene SAAS_SHARE = null;
    public static final ShareScene SDK_VIDEO = null;
    public static final ShareScene SHARE_APP = null;
    public static final ShareScene SHARE_LINK = null;
    public static final ShareScene SHEET = null;
    public static final ShareScene SHOW_LONG_ALBUM = null;
    public static final ShareScene SHOW_LONG_IMAGE = null;
    public static final ShareScene SIDEBAR_LONG_PRESS_CELL = null;
    public static final ShareScene SINGLE_IMAGE = null;
    public static final ShareScene SLIDES = null;
    public static final ShareScene SOCIAL_IMAGE_SHARE = null;
    public static final ShareScene SOCIAL_VIDEO_SHARE = null;
    public static final ShareScene TABLE_FULL_SCREEN_PAGE = null;
    public static final ShareScene UNKNOWN = null;
    public static final ShareScene VIDEO_COMPREHEND = null;
    public static final ShareScene VIDEO_VIEWER = null;
    public static final ShareScene WEBVIEW = null;
    public static final ShareScene Z_SHARE_LINK_PLANB = null;
    public static final /* synthetic */ ShareScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;

    public static EnumEntries<ShareScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v45, types: [com.larus.bmhome.share.ShareScene$a] */
    static {
        ShareScene r0 = new ShareScene("SHARE_APP", 0, "share_app");
        SHARE_APP = r0;
        ShareScene r1 = new ShareScene("COMMON_BOT", 1, "common_bot");
        COMMON_BOT = r1;
        ShareScene r3 = new ShareScene("COMMON_BOT_WITH_SAVE", 2, "common_bot_with_save");
        COMMON_BOT_WITH_SAVE = r3;
        ShareScene r5 = new ShareScene("NOTICE_LIST", 3, "notice_list");
        NOTICE_LIST = r5;
        ShareScene r7 = new ShareScene("IMAGE_VIEWER", 4, "image_viewer");
        IMAGE_VIEWER = r7;
        ShareScene r9 = new ShareScene("WEBVIEW", 5, "webview");
        WEBVIEW = r9;
        ShareScene r11 = new ShareScene("MESSAGES_LINK", 6, "messages_link");
        MESSAGES_LINK = r11;
        ShareScene r13 = new ShareScene("MESSAGES_LINK_SUB_CONV", 7, "messages_link_sub_conv");
        MESSAGES_LINK_SUB_CONV = r13;
        ShareScene r12 = new ShareScene("MESSAGES_LINK_IMAGE", 8, "messages_link_image");
        MESSAGES_LINK_IMAGE = r12;
        ShareScene r10 = new ShareScene("MUSIC_VIDEO", 9, "music_video");
        MUSIC_VIDEO = r10;
        ShareScene r8 = new ShareScene("VIDEO_VIEWER", 10, "video_viewer");
        VIDEO_VIEWER = r8;
        ShareScene r6 = new ShareScene("VIDEO_COMPREHEND", 11, "share_video");
        VIDEO_COMPREHEND = r6;
        ShareScene r4 = new ShareScene("CONVERSATION_GROUP", 12, "conversation_group");
        CONVERSATION_GROUP = r4;
        ShareScene r2 = new ShareScene("CONVERSATION_GROUP_WITH_SAVE", 13, "conversation_group_with_save");
        CONVERSATION_GROUP_WITH_SAVE = r2;
        ShareScene r14 = new ShareScene("IMAGE_VIEWER_REPORT", 14, "image_viewer_report");
        IMAGE_VIEWER_REPORT = r14;
        ShareScene r15 = new ShareScene("MUSIC_VIDEO_REPORT", 15, "music_video_report");
        MUSIC_VIDEO_REPORT = r15;
        ShareScene r16 = new ShareScene("SHOW_LONG_IMAGE", 16, "show_long_image");
        SHOW_LONG_IMAGE = r16;
        ShareScene r17 = new ShareScene("SHOW_LONG_ALBUM", 17, "show_long_album");
        SHOW_LONG_ALBUM = r17;
        ShareScene r18 = new ShareScene("TABLE_FULL_SCREEN_PAGE", 18, "table_full_screen_page");
        TABLE_FULL_SCREEN_PAGE = r18;
        ShareScene r19 = new ShareScene("CODE_FULL_SCREEN_PAGE", 19, "code_full_screen_page");
        CODE_FULL_SCREEN_PAGE = r19;
        ShareScene r20 = new ShareScene("SDK_VIDEO", 20, "sdk_video");
        SDK_VIDEO = r20;
        ShareScene r21 = new ShareScene("SIDEBAR_LONG_PRESS_CELL", 21, "long_press_cell");
        SIDEBAR_LONG_PRESS_CELL = r21;
        ShareScene r22 = new ShareScene("CASE", 22, "user_case");
        CASE = r22;
        ShareScene r23 = new ShareScene("DEEP_RESEARCH_EPISODE", 23, "deep_research_episode");
        DEEP_RESEARCH_EPISODE = r23;
        ShareScene r24 = new ShareScene("DOCUMENT", 24, "document");
        DOCUMENT = r24;
        ShareScene r25 = new ShareScene("DOCUMENT_CANNOT_EXPORT", 25, "document_cannot_export");
        DOCUMENT_CANNOT_EXPORT = r25;
        ShareScene r26 = new ShareScene("SLIDES", 26, "aippt_new");
        SLIDES = r26;
        ShareScene r27 = new ShareScene("SHEET", 27, "aisheet");
        SHEET = r27;
        ShareScene r28 = new ShareScene("BITABLE", 28, "aibase");
        BITABLE = r28;
        ShareScene r29 = new ShareScene("DRIVE", 29, "ai_space");
        DRIVE = r29;
        ShareScene r30 = new ShareScene("MINI_ARTIFACT", 30, "mini_artifact");
        MINI_ARTIFACT = r30;
        ShareScene r31 = new ShareScene("SINGLE_IMAGE", 31, "single_image");
        SINGLE_IMAGE = r31;
        ShareScene r32 = new ShareScene("SHARE_LINK", 32, "share_link");
        SHARE_LINK = r32;
        ShareScene r33 = new ShareScene("SAAS_SHARE", 33, "saas_share");
        SAAS_SHARE = r33;
        ShareScene r34 = new ShareScene("Z_SHARE_LINK_PLANB", 34, "z_share_link_planb");
        Z_SHARE_LINK_PLANB = r34;
        ShareScene r35 = new ShareScene("OFFICE_MY_QR_CODE", 35, "office_my_qr_code");
        OFFICE_MY_QR_CODE = r35;
        ShareScene r36 = new ShareScene("OFFICE_SHARE_CHAT", 36, "office_share_chat");
        OFFICE_SHARE_CHAT = r36;
        ShareScene r37 = new ShareScene("BOT_FILE_PREVIEW", 37, "bot_file_preview");
        BOT_FILE_PREVIEW = r37;
        ShareScene r38 = new ShareScene("OFFICE_GROUP_QR_CODE", 38, "office_group_qr_code");
        OFFICE_GROUP_QR_CODE = r38;
        ShareScene r39 = new ShareScene("OFFICE_SHARE_THREAD", 39, "office_share_thread");
        OFFICE_SHARE_THREAD = r39;
        ShareScene r40 = new ShareScene("SOCIAL_IMAGE_SHARE", 40, "social_image_share");
        SOCIAL_IMAGE_SHARE = r40;
        ShareScene r41 = new ShareScene("SOCIAL_VIDEO_SHARE", 41, "social_video_share");
        SOCIAL_VIDEO_SHARE = r41;
        ShareScene r42 = new ShareScene("CONVERSATION_CCM", 42, "conversation_ccm");
        CONVERSATION_CCM = r42;
        ShareScene r43 = new ShareScene("UNKNOWN", 43, "unknown");
        UNKNOWN = r43;
        ShareScene[] r44 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43};
        a = r44;
        b = EnumEntriesKt.enumEntries(r44);
        Companion = new a();
    }

    public static ShareScene[] values() {
        return (ShareScene[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static ShareScene valueOf(String r1) {
        return (ShareScene) r27.a.a(ShareScene.class, r1);
    }

    public ShareScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
