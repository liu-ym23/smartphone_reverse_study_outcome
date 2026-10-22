package com.larus.bmhome.chat;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/ChatLandingChannel;", "", "channel", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "COLD_PURE_CHAT", "COLD_VIDEO_CHAT", "COLD_MULTI_CHAT", "CHAT_LIST", "PROFILE_INFO_VIEW", SuggestActionType.BOT_RECOMMEND, "HOME_SEARCH", "BOT_CREATE", "BOT_DISCOVER", "CHAT_BRIDGE", "CREATE_NEW_BOT", "PROFILE_BOT_LIST", "UGC_LANDING", "START_OTHER", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ChatLandingChannel extends Enum<ChatLandingChannel> {
    public static final ChatLandingChannel BOT_CREATE = null;
    public static final ChatLandingChannel BOT_DISCOVER = null;
    public static final ChatLandingChannel BOT_RECOMMEND = null;
    public static final ChatLandingChannel CHAT_BRIDGE = null;
    public static final ChatLandingChannel CHAT_LIST = null;
    public static final ChatLandingChannel COLD_MULTI_CHAT = null;
    public static final ChatLandingChannel COLD_PURE_CHAT = null;
    public static final ChatLandingChannel COLD_VIDEO_CHAT = null;
    public static final ChatLandingChannel CREATE_NEW_BOT = null;
    public static final ChatLandingChannel HOME_SEARCH = null;
    public static final ChatLandingChannel PROFILE_BOT_LIST = null;
    public static final ChatLandingChannel PROFILE_INFO_VIEW = null;
    public static final ChatLandingChannel START_OTHER = null;
    public static final ChatLandingChannel UGC_LANDING = null;
    public static final /* synthetic */ ChatLandingChannel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String channel;

    public static EnumEntries<ChatLandingChannel> getEntries() {
        return b;
    }

    static {
        ChatLandingChannel r0 = new ChatLandingChannel("COLD_PURE_CHAT", 0, "cold_pure_chat");
        COLD_PURE_CHAT = r0;
        ChatLandingChannel r1 = new ChatLandingChannel("COLD_VIDEO_CHAT", 1, "cold_video_chat");
        COLD_VIDEO_CHAT = r1;
        ChatLandingChannel r2 = new ChatLandingChannel("COLD_MULTI_CHAT", 2, "cold_multi_chat");
        COLD_MULTI_CHAT = r2;
        ChatLandingChannel r4 = new ChatLandingChannel("CHAT_LIST", 3, "chat_list");
        CHAT_LIST = r4;
        ChatLandingChannel r6 = new ChatLandingChannel("PROFILE_INFO_VIEW", 4, "profile");
        PROFILE_INFO_VIEW = r6;
        ChatLandingChannel r8 = new ChatLandingChannel(SuggestActionType.BOT_RECOMMEND, 5, "bot_recommend");
        BOT_RECOMMEND = r8;
        ChatLandingChannel r10 = new ChatLandingChannel("HOME_SEARCH", 6, "home_search");
        HOME_SEARCH = r10;
        ChatLandingChannel r12 = new ChatLandingChannel("BOT_CREATE", 7, "bot_create");
        BOT_CREATE = r12;
        ChatLandingChannel r14 = new ChatLandingChannel("BOT_DISCOVER", 8, "bot_discover");
        BOT_DISCOVER = r14;
        ChatLandingChannel r13 = new ChatLandingChannel("CHAT_BRIDGE", 9, "chat_bridge");
        CHAT_BRIDGE = r13;
        ChatLandingChannel r11 = new ChatLandingChannel("CREATE_NEW_BOT", 10, "create_new_bot");
        CREATE_NEW_BOT = r11;
        ChatLandingChannel r9 = new ChatLandingChannel("PROFILE_BOT_LIST", 11, "profile_bot_list");
        PROFILE_BOT_LIST = r9;
        ChatLandingChannel r7 = new ChatLandingChannel("UGC_LANDING", 12, "ugc_landing");
        UGC_LANDING = r7;
        ChatLandingChannel r5 = new ChatLandingChannel("START_OTHER", 13, "other");
        START_OTHER = r5;
        ChatLandingChannel[] r3 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatLandingChannel[] values() {
        return (ChatLandingChannel[]) a.clone();
    }

    public final String getChannel() {
        return this.channel;
    }

    public static ChatLandingChannel valueOf(String r1) {
        return (ChatLandingChannel) a.a(ChatLandingChannel.class, r1);
    }

    public ChatLandingChannel(String r1, int r2, String r3) {
        super(r1, r2);
        this.channel = r3;
    }
}
