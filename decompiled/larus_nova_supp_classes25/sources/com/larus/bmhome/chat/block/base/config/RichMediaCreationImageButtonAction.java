package com.larus.bmhome.chat.block.base.config;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "SHARE", "IMAGE_EDIT", "VIDEO_EDIT", "CITE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RichMediaCreationImageButtonAction extends Enum<RichMediaCreationImageButtonAction> {
    public static final RichMediaCreationImageButtonAction CITE = null;
    public static final RichMediaCreationImageButtonAction DOWNLOAD = null;
    public static final RichMediaCreationImageButtonAction IMAGE_EDIT = null;
    public static final RichMediaCreationImageButtonAction SHARE = null;
    public static final RichMediaCreationImageButtonAction VIDEO_EDIT = null;
    public static final /* synthetic */ RichMediaCreationImageButtonAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RichMediaCreationImageButtonAction> getEntries() {
        return b;
    }

    static {
        RichMediaCreationImageButtonAction r0 = new RichMediaCreationImageButtonAction("DOWNLOAD", 0);
        DOWNLOAD = r0;
        RichMediaCreationImageButtonAction r1 = new RichMediaCreationImageButtonAction("SHARE", 1);
        SHARE = r1;
        RichMediaCreationImageButtonAction r3 = new RichMediaCreationImageButtonAction("IMAGE_EDIT", 2);
        IMAGE_EDIT = r3;
        RichMediaCreationImageButtonAction r5 = new RichMediaCreationImageButtonAction("VIDEO_EDIT", 3);
        VIDEO_EDIT = r5;
        RichMediaCreationImageButtonAction r7 = new RichMediaCreationImageButtonAction("CITE", 4);
        CITE = r7;
        RichMediaCreationImageButtonAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static RichMediaCreationImageButtonAction[] values() {
        return (RichMediaCreationImageButtonAction[]) a.clone();
    }

    public static RichMediaCreationImageButtonAction valueOf(String r1) {
        return (RichMediaCreationImageButtonAction) a.a(RichMediaCreationImageButtonAction.class, r1);
    }

    public RichMediaCreationImageButtonAction(String r1, int r2) {
        super(r1, r2);
    }
}
