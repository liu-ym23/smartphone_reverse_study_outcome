package com.larus.avlink.env;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/env/DoraEnvObserveState;", "", "<init>", "(Ljava/lang/String;I)V", "START", "END", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DoraEnvObserveState extends Enum<DoraEnvObserveState> {
    public static final DoraEnvObserveState END = null;
    public static final DoraEnvObserveState START = null;
    public static final /* synthetic */ DoraEnvObserveState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraEnvObserveState> getEntries() {
        return b;
    }

    static {
        DoraEnvObserveState r0 = new DoraEnvObserveState("START", 0);
        START = r0;
        DoraEnvObserveState r1 = new DoraEnvObserveState("END", 1);
        END = r1;
        DoraEnvObserveState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraEnvObserveState[] values() {
        return (DoraEnvObserveState[]) a.clone();
    }

    public static DoraEnvObserveState valueOf(String r1) {
        return (DoraEnvObserveState) a.a(DoraEnvObserveState.class, r1);
    }

    public DoraEnvObserveState(String r1, int r2) {
        super(r1, r2);
    }
}
