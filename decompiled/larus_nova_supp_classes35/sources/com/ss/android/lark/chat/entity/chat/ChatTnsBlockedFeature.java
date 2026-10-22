package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTnsBlockedFeature;", BuildConfig.FLAVOR, "feature", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getFeature", "()I", "UNKNOWN_BLOCKED_FEATURE", "BLOCKED_ADD_MEMBER", "BLOCKED_REMOVE_MEMBER", "BLOCKED_CHAT_TAB", "BLOCKED_CHAT_MENU_TNS", "BLOCKED_MESSAGE_MENU", "BLOCKED_BOT_POST", "BLOCKED_MANAGE_BOT", "BLOCKED_GROUP_TASK", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatTnsBlockedFeature extends Enum<ChatTnsBlockedFeature> {
    public static final ChatTnsBlockedFeature BLOCKED_ADD_MEMBER = null;
    public static final ChatTnsBlockedFeature BLOCKED_BOT_POST = null;
    public static final ChatTnsBlockedFeature BLOCKED_CHAT_MENU_TNS = null;
    public static final ChatTnsBlockedFeature BLOCKED_CHAT_TAB = null;
    public static final ChatTnsBlockedFeature BLOCKED_GROUP_TASK = null;
    public static final ChatTnsBlockedFeature BLOCKED_MANAGE_BOT = null;
    public static final ChatTnsBlockedFeature BLOCKED_MESSAGE_MENU = null;
    public static final ChatTnsBlockedFeature BLOCKED_REMOVE_MEMBER = null;
    public static final a Companion = null;
    public static final ChatTnsBlockedFeature UNKNOWN_BLOCKED_FEATURE = null;
    public static final /* synthetic */ ChatTnsBlockedFeature[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int feature;

    public static EnumEntries<ChatTnsBlockedFeature> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.chat.entity.chat.ChatTnsBlockedFeature$a] */
    static {
        ChatTnsBlockedFeature r0 = new ChatTnsBlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r0;
        ChatTnsBlockedFeature r1 = new ChatTnsBlockedFeature("BLOCKED_ADD_MEMBER", 1, 1);
        BLOCKED_ADD_MEMBER = r1;
        ChatTnsBlockedFeature r3 = new ChatTnsBlockedFeature("BLOCKED_REMOVE_MEMBER", 2, 2);
        BLOCKED_REMOVE_MEMBER = r3;
        ChatTnsBlockedFeature r5 = new ChatTnsBlockedFeature("BLOCKED_CHAT_TAB", 3, 3);
        BLOCKED_CHAT_TAB = r5;
        ChatTnsBlockedFeature r7 = new ChatTnsBlockedFeature("BLOCKED_CHAT_MENU_TNS", 4, 4);
        BLOCKED_CHAT_MENU_TNS = r7;
        ChatTnsBlockedFeature r9 = new ChatTnsBlockedFeature("BLOCKED_MESSAGE_MENU", 5, 5);
        BLOCKED_MESSAGE_MENU = r9;
        ChatTnsBlockedFeature r11 = new ChatTnsBlockedFeature("BLOCKED_BOT_POST", 6, 6);
        BLOCKED_BOT_POST = r11;
        ChatTnsBlockedFeature r13 = new ChatTnsBlockedFeature("BLOCKED_MANAGE_BOT", 7, 7);
        BLOCKED_MANAGE_BOT = r13;
        ChatTnsBlockedFeature r15 = new ChatTnsBlockedFeature("BLOCKED_GROUP_TASK", 8, 8);
        BLOCKED_GROUP_TASK = r15;
        ChatTnsBlockedFeature[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new a();
    }

    public static ChatTnsBlockedFeature[] values() {
        return (ChatTnsBlockedFeature[]) a.clone();
    }

    public final int getFeature() {
        return this.feature;
    }

    public static ChatTnsBlockedFeature valueOf(String r1) {
        return (ChatTnsBlockedFeature) r27.a.a(ChatTnsBlockedFeature.class, r1);
    }

    public ChatTnsBlockedFeature(String r1, int r2, int r3) {
        super(r1, r2);
        this.feature = r3;
    }
}
