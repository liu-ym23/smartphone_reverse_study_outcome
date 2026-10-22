package com.larus.avlink.simulInterpret.page.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/AREA;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum AREA extends Enum<AREA> {
    public static final AREA BOTTOM = null;
    public static final AREA TOP = null;
    public static final /* synthetic */ AREA[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AREA> getEntries() {
        return b;
    }

    static {
        AREA r0 = new AREA("TOP", 0);
        TOP = r0;
        AREA r1 = new AREA("BOTTOM", 1);
        BOTTOM = r1;
        AREA[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AREA[] values() {
        return (AREA[]) a.clone();
    }

    public static AREA valueOf(String r1) {
        return (AREA) r27.a.a(AREA.class, r1);
    }

    public AREA(String r1, int r2) {
        super(r1, r2);
    }
}
