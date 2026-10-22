package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "", "<init>", "(Ljava/lang/String;I)V", "LONG_PRESS_MENU", "LEFT_SWIPE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ConversationFeedActionScene extends Enum<ConversationFeedActionScene> {
    public static final ConversationFeedActionScene LEFT_SWIPE = null;
    public static final ConversationFeedActionScene LONG_PRESS_MENU = null;
    public static final /* synthetic */ ConversationFeedActionScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ConversationFeedActionScene> getEntries() {
        return b;
    }

    static {
        ConversationFeedActionScene r0 = new ConversationFeedActionScene("LONG_PRESS_MENU", 0);
        LONG_PRESS_MENU = r0;
        ConversationFeedActionScene r1 = new ConversationFeedActionScene("LEFT_SWIPE", 1);
        LEFT_SWIPE = r1;
        ConversationFeedActionScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ConversationFeedActionScene[] values() {
        return (ConversationFeedActionScene[]) a.clone();
    }

    public static ConversationFeedActionScene valueOf(String r1) {
        return (ConversationFeedActionScene) a.a(ConversationFeedActionScene.class, r1);
    }

    public ConversationFeedActionScene(String r1, int r2) {
        super(r1, r2);
    }
}
