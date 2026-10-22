package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/api/OpenPushReminderScene;", "", "sceneId", "", "mobString", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getSceneId", "()Ljava/lang/String;", "getMobString", "LikeMsgForMainBot", "CopyMsgFromMainBot", "LikeBot", "ChatWithBot", "CreateBot", "CreateVideo", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum OpenPushReminderScene extends Enum<OpenPushReminderScene> {
    public static final OpenPushReminderScene ChatWithBot = null;
    public static final OpenPushReminderScene CopyMsgFromMainBot = null;
    public static final OpenPushReminderScene CreateBot = null;
    public static final OpenPushReminderScene CreateVideo = null;
    public static final OpenPushReminderScene LikeBot = null;
    public static final OpenPushReminderScene LikeMsgForMainBot = null;
    public static final /* synthetic */ OpenPushReminderScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String mobString;
    private final String sceneId;

    public static EnumEntries<OpenPushReminderScene> getEntries() {
        return b;
    }

    static {
        OpenPushReminderScene r0 = new OpenPushReminderScene("LikeMsgForMainBot", 0, "scene_like_msg_for_main_bot", "like_message");
        LikeMsgForMainBot = r0;
        OpenPushReminderScene r1 = new OpenPushReminderScene("CopyMsgFromMainBot", 1, "scene_cp_msg_from_main_bot", "copy_message");
        CopyMsgFromMainBot = r1;
        OpenPushReminderScene r2 = new OpenPushReminderScene("LikeBot", 2, "scene_like_bot", "like_bot");
        LikeBot = r2;
        OpenPushReminderScene r3 = new OpenPushReminderScene("ChatWithBot", 3, "scene_chat_with_bot", "bot_chat");
        ChatWithBot = r3;
        OpenPushReminderScene r5 = new OpenPushReminderScene("CreateBot", 4, "scene_create_bot", "create_bot");
        CreateBot = r5;
        OpenPushReminderScene r7 = new OpenPushReminderScene("CreateVideo", 5, "scene_create_video", "video_create");
        CreateVideo = r7;
        OpenPushReminderScene[] r9 = {r0, r1, r2, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OpenPushReminderScene[] values() {
        return (OpenPushReminderScene[]) a.clone();
    }

    public final String getMobString() {
        return this.mobString;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public static OpenPushReminderScene valueOf(String r1) {
        return (OpenPushReminderScene) r27.a.a(OpenPushReminderScene.class, r1);
    }

    public OpenPushReminderScene(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.sceneId = r3;
        this.mobString = r4;
    }
}
