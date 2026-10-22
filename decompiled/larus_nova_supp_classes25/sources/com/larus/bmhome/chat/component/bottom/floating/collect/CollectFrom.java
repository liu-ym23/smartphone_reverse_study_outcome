package com.larus.bmhome.chat.component.bottom.floating.collect;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/collect/CollectFrom;", "", "<init>", "(Ljava/lang/String;I)V", "COPY", "LIKE", "COLLECT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CollectFrom extends Enum<CollectFrom> {
    public static final CollectFrom COLLECT = null;
    public static final CollectFrom COPY = null;
    public static final CollectFrom LIKE = null;
    public static final /* synthetic */ CollectFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CollectFrom> getEntries() {
        return b;
    }

    static {
        CollectFrom r0 = new CollectFrom("COPY", 0);
        COPY = r0;
        CollectFrom r1 = new CollectFrom("LIKE", 1);
        LIKE = r1;
        CollectFrom r3 = new CollectFrom("COLLECT", 2);
        COLLECT = r3;
        CollectFrom[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CollectFrom[] values() {
        return (CollectFrom[]) a.clone();
    }

    public static CollectFrom valueOf(String r1) {
        return (CollectFrom) a.a(CollectFrom.class, r1);
    }

    public CollectFrom(String r1, int r2) {
        super(r1, r2);
    }
}
