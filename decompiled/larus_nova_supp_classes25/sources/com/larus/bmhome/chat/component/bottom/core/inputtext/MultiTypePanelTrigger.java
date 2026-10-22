package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/MultiTypePanelTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "MENTION", "SLASH", "EXTERNAL_SKILL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MultiTypePanelTrigger extends Enum<MultiTypePanelTrigger> {
    public static final MultiTypePanelTrigger EXTERNAL_SKILL = null;
    public static final MultiTypePanelTrigger MENTION = null;
    public static final MultiTypePanelTrigger SLASH = null;
    public static final /* synthetic */ MultiTypePanelTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MultiTypePanelTrigger> getEntries() {
        return b;
    }

    static {
        MultiTypePanelTrigger r0 = new MultiTypePanelTrigger("MENTION", 0);
        MENTION = r0;
        MultiTypePanelTrigger r1 = new MultiTypePanelTrigger("SLASH", 1);
        SLASH = r1;
        MultiTypePanelTrigger r3 = new MultiTypePanelTrigger("EXTERNAL_SKILL", 2);
        EXTERNAL_SKILL = r3;
        MultiTypePanelTrigger[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MultiTypePanelTrigger[] values() {
        return (MultiTypePanelTrigger[]) a.clone();
    }

    public static MultiTypePanelTrigger valueOf(String r1) {
        return (MultiTypePanelTrigger) r27.a.a(MultiTypePanelTrigger.class, r1);
    }

    public MultiTypePanelTrigger(String r1, int r2) {
        super(r1, r2);
    }
}
