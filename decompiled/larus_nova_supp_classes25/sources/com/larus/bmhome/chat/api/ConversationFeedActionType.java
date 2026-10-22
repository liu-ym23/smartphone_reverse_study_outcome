package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "", "<init>", "(Ljava/lang/String;I)V", "REFRESH_RECOMMEND_BOT", "PIN", "UNPIN", "HIDE", "EDIT_NAME", "MOVE_TO_PROJECT", "REMOVE_FROM_PROJECT", "DELETE", "SHARE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ConversationFeedActionType extends Enum<ConversationFeedActionType> {
    public static final ConversationFeedActionType DELETE = null;
    public static final ConversationFeedActionType EDIT_NAME = null;
    public static final ConversationFeedActionType HIDE = null;
    public static final ConversationFeedActionType MOVE_TO_PROJECT = null;
    public static final ConversationFeedActionType PIN = null;
    public static final ConversationFeedActionType REFRESH_RECOMMEND_BOT = null;
    public static final ConversationFeedActionType REMOVE_FROM_PROJECT = null;
    public static final ConversationFeedActionType SHARE = null;
    public static final ConversationFeedActionType UNPIN = null;
    public static final /* synthetic */ ConversationFeedActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ConversationFeedActionType> getEntries() {
        return b;
    }

    static {
        ConversationFeedActionType r0 = new ConversationFeedActionType("REFRESH_RECOMMEND_BOT", 0);
        REFRESH_RECOMMEND_BOT = r0;
        ConversationFeedActionType r1 = new ConversationFeedActionType("PIN", 1);
        PIN = r1;
        ConversationFeedActionType r3 = new ConversationFeedActionType("UNPIN", 2);
        UNPIN = r3;
        ConversationFeedActionType r5 = new ConversationFeedActionType("HIDE", 3);
        HIDE = r5;
        ConversationFeedActionType r7 = new ConversationFeedActionType("EDIT_NAME", 4);
        EDIT_NAME = r7;
        ConversationFeedActionType r9 = new ConversationFeedActionType("MOVE_TO_PROJECT", 5);
        MOVE_TO_PROJECT = r9;
        ConversationFeedActionType r11 = new ConversationFeedActionType("REMOVE_FROM_PROJECT", 6);
        REMOVE_FROM_PROJECT = r11;
        ConversationFeedActionType r13 = new ConversationFeedActionType("DELETE", 7);
        DELETE = r13;
        ConversationFeedActionType r15 = new ConversationFeedActionType("SHARE", 8);
        SHARE = r15;
        ConversationFeedActionType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ConversationFeedActionType[] values() {
        return (ConversationFeedActionType[]) a.clone();
    }

    public static ConversationFeedActionType valueOf(String r1) {
        return (ConversationFeedActionType) a.a(ConversationFeedActionType.class, r1);
    }

    public ConversationFeedActionType(String r1, int r2) {
        super(r1, r2);
    }
}
