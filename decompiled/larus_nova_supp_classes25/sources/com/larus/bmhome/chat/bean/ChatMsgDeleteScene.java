package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatMsgDeleteScene;", "", "<init>", "(Ljava/lang/String;I)V", "unknown", "longPressMenu", "bridgeMenu", "shareSheet", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ChatMsgDeleteScene extends Enum<ChatMsgDeleteScene> {
    public static final /* synthetic */ ChatMsgDeleteScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final ChatMsgDeleteScene bridgeMenu = null;
    public static final ChatMsgDeleteScene longPressMenu = null;
    public static final ChatMsgDeleteScene shareSheet = null;
    public static final ChatMsgDeleteScene unknown = null;

    public static EnumEntries<ChatMsgDeleteScene> getEntries() {
        return b;
    }

    static {
        ChatMsgDeleteScene r0 = new ChatMsgDeleteScene("unknown", 0);
        unknown = r0;
        ChatMsgDeleteScene r1 = new ChatMsgDeleteScene("longPressMenu", 1);
        longPressMenu = r1;
        ChatMsgDeleteScene r3 = new ChatMsgDeleteScene("bridgeMenu", 2);
        bridgeMenu = r3;
        ChatMsgDeleteScene r5 = new ChatMsgDeleteScene("shareSheet", 3);
        shareSheet = r5;
        ChatMsgDeleteScene[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ChatMsgDeleteScene[] values() {
        return (ChatMsgDeleteScene[]) a.clone();
    }

    public static ChatMsgDeleteScene valueOf(String r1) {
        return (ChatMsgDeleteScene) r27.a.a(ChatMsgDeleteScene.class, r1);
    }

    public ChatMsgDeleteScene(String r1, int r2) {
        super(r1, r2);
    }
}
