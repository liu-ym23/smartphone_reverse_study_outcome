package com.larus.bmhome.chat.list.cell.loading;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/loading/LoadingType;", "", "<init>", "(Ljava/lang/String;I)V", "IN", "OUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum LoadingType extends Enum<LoadingType> {
    public static final LoadingType IN = null;
    public static final LoadingType OUT = null;
    public static final /* synthetic */ LoadingType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LoadingType> getEntries() {
        return b;
    }

    static {
        LoadingType r0 = new LoadingType("IN", 0);
        IN = r0;
        LoadingType r1 = new LoadingType("OUT", 1);
        OUT = r1;
        LoadingType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static LoadingType[] values() {
        return (LoadingType[]) a.clone();
    }

    public static LoadingType valueOf(String r1) {
        return (LoadingType) a.a(LoadingType.class, r1);
    }

    public LoadingType(String r1, int r2) {
        super(r1, r2);
    }
}
