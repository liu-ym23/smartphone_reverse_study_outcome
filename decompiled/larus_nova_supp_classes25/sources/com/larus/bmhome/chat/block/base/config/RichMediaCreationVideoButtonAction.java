package com.larus.bmhome.chat.block.base.config;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "CITE", "EXTEND", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RichMediaCreationVideoButtonAction extends Enum<RichMediaCreationVideoButtonAction> {
    public static final RichMediaCreationVideoButtonAction CITE = null;
    public static final RichMediaCreationVideoButtonAction DOWNLOAD = null;
    public static final RichMediaCreationVideoButtonAction EXTEND = null;
    public static final /* synthetic */ RichMediaCreationVideoButtonAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RichMediaCreationVideoButtonAction> getEntries() {
        return b;
    }

    static {
        RichMediaCreationVideoButtonAction r0 = new RichMediaCreationVideoButtonAction("DOWNLOAD", 0);
        DOWNLOAD = r0;
        RichMediaCreationVideoButtonAction r1 = new RichMediaCreationVideoButtonAction("CITE", 1);
        CITE = r1;
        RichMediaCreationVideoButtonAction r3 = new RichMediaCreationVideoButtonAction("EXTEND", 2);
        EXTEND = r3;
        RichMediaCreationVideoButtonAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static RichMediaCreationVideoButtonAction[] values() {
        return (RichMediaCreationVideoButtonAction[]) a.clone();
    }

    public static RichMediaCreationVideoButtonAction valueOf(String r1) {
        return (RichMediaCreationVideoButtonAction) a.a(RichMediaCreationVideoButtonAction.class, r1);
    }

    public RichMediaCreationVideoButtonAction(String r1, int r2) {
        super(r1, r2);
    }
}
