package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "UN_KNOW", "SHARE", "COLLECT", "DELETE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum IChatMessageShareAbility$ActionType extends Enum<IChatMessageShareAbility$ActionType> {
    public static final IChatMessageShareAbility$ActionType COLLECT = null;
    public static final IChatMessageShareAbility$ActionType DELETE = null;
    public static final IChatMessageShareAbility$ActionType SHARE = null;
    public static final IChatMessageShareAbility$ActionType UN_KNOW = null;
    public static final /* synthetic */ IChatMessageShareAbility$ActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IChatMessageShareAbility$ActionType> getEntries() {
        return b;
    }

    static {
        IChatMessageShareAbility$ActionType r0 = new IChatMessageShareAbility$ActionType("UN_KNOW", 0);
        UN_KNOW = r0;
        IChatMessageShareAbility$ActionType r1 = new IChatMessageShareAbility$ActionType("SHARE", 1);
        SHARE = r1;
        IChatMessageShareAbility$ActionType r3 = new IChatMessageShareAbility$ActionType("COLLECT", 2);
        COLLECT = r3;
        IChatMessageShareAbility$ActionType r5 = new IChatMessageShareAbility$ActionType("DELETE", 3);
        DELETE = r5;
        IChatMessageShareAbility$ActionType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static IChatMessageShareAbility$ActionType[] values() {
        return (IChatMessageShareAbility$ActionType[]) a.clone();
    }

    public static IChatMessageShareAbility$ActionType valueOf(String r1) {
        return (IChatMessageShareAbility$ActionType) r27.a.a(IChatMessageShareAbility$ActionType.class, r1);
    }

    public IChatMessageShareAbility$ActionType(String r1, int r2) {
        super(r1, r2);
    }
}
