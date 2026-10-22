package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ActiveStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "INACTIVE", "ACTIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActiveStatus extends Enum<ActiveStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ActiveStatus[] $VALUES = null;
    public static final ActiveStatus ACTIVE = null;
    public static final ActiveStatus INACTIVE = null;
    private final int status;

    private static final /* synthetic */ ActiveStatus[] $values() {
        return new ActiveStatus[]{INACTIVE, ACTIVE};
    }

    public static EnumEntries<ActiveStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        INACTIVE = new ActiveStatus("INACTIVE", 0, 0);
        ACTIVE = new ActiveStatus("ACTIVE", 1, 1);
        ActiveStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ActiveStatus[] values() {
        return (ActiveStatus[]) $VALUES.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static ActiveStatus valueOf(String r1) {
        return (ActiveStatus) r27.a.a(ActiveStatus.class, r1);
    }

    private ActiveStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
