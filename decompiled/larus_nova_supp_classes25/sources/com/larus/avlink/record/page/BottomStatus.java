package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/page/BottomStatus;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING", "END_RECORDING", "OFFLINE_RECORDING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BottomStatus extends Enum<BottomStatus> {
    public static final BottomStatus END_RECORDING = null;
    public static final BottomStatus OFFLINE_RECORDING = null;
    public static final BottomStatus RECORDING = null;
    public static final /* synthetic */ BottomStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BottomStatus> getEntries() {
        return b;
    }

    static {
        BottomStatus r0 = new BottomStatus("RECORDING", 0);
        RECORDING = r0;
        BottomStatus r1 = new BottomStatus("END_RECORDING", 1);
        END_RECORDING = r1;
        BottomStatus r3 = new BottomStatus("OFFLINE_RECORDING", 2);
        OFFLINE_RECORDING = r3;
        BottomStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BottomStatus[] values() {
        return (BottomStatus[]) a.clone();
    }

    public static BottomStatus valueOf(String r1) {
        return (BottomStatus) r27.a.a(BottomStatus.class, r1);
    }

    public BottomStatus(String r1, int r2) {
        super(r1, r2);
    }
}
