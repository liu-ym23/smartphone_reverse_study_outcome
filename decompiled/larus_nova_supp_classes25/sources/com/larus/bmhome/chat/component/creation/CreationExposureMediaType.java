package com.larus.bmhome.chat.component.creation;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/component/creation/CreationExposureMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", SuggestActionType.VIDEO, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CreationExposureMediaType extends Enum<CreationExposureMediaType> {
    public static final CreationExposureMediaType IMAGE = null;
    public static final CreationExposureMediaType VIDEO = null;
    public static final /* synthetic */ CreationExposureMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationExposureMediaType> getEntries() {
        return b;
    }

    static {
        CreationExposureMediaType r0 = new CreationExposureMediaType("IMAGE", 0);
        IMAGE = r0;
        CreationExposureMediaType r1 = new CreationExposureMediaType(SuggestActionType.VIDEO, 1);
        VIDEO = r1;
        CreationExposureMediaType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CreationExposureMediaType[] values() {
        return (CreationExposureMediaType[]) a.clone();
    }

    public static CreationExposureMediaType valueOf(String r1) {
        return (CreationExposureMediaType) a.a(CreationExposureMediaType.class, r1);
    }

    public CreationExposureMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
