package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/prompt/PromptBizType;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_MET", "WELCOME_BACK", "SUGGEST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PromptBizType extends Enum<PromptBizType> {
    public static final PromptBizType FIRST_MET = null;
    public static final PromptBizType SUGGEST = null;
    public static final PromptBizType WELCOME_BACK = null;
    public static final /* synthetic */ PromptBizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PromptBizType> getEntries() {
        return b;
    }

    static {
        PromptBizType r0 = new PromptBizType("FIRST_MET", 0);
        FIRST_MET = r0;
        PromptBizType r1 = new PromptBizType("WELCOME_BACK", 1);
        WELCOME_BACK = r1;
        PromptBizType r3 = new PromptBizType("SUGGEST", 2);
        SUGGEST = r3;
        PromptBizType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PromptBizType[] values() {
        return (PromptBizType[]) a.clone();
    }

    public static PromptBizType valueOf(String r1) {
        return (PromptBizType) r27.a.a(PromptBizType.class, r1);
    }

    public PromptBizType(String r1, int r2) {
        super(r1, r2);
    }
}
