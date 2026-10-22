package com.larus.bmhome.chat.quickreply;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/quickreply/MoaGrantingDecision;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "REFUSE", "UNSUPPORTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MoaGrantingDecision extends Enum<MoaGrantingDecision> {
    public static final MoaGrantingDecision ALLOW = null;
    public static final MoaGrantingDecision REFUSE = null;
    public static final MoaGrantingDecision UNSUPPORTED = null;
    public static final /* synthetic */ MoaGrantingDecision[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MoaGrantingDecision> getEntries() {
        return b;
    }

    static {
        MoaGrantingDecision r0 = new MoaGrantingDecision("ALLOW", 0);
        ALLOW = r0;
        MoaGrantingDecision r1 = new MoaGrantingDecision("REFUSE", 1);
        REFUSE = r1;
        MoaGrantingDecision r3 = new MoaGrantingDecision("UNSUPPORTED", 2);
        UNSUPPORTED = r3;
        MoaGrantingDecision[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MoaGrantingDecision[] values() {
        return (MoaGrantingDecision[]) a.clone();
    }

    public static MoaGrantingDecision valueOf(String r1) {
        return (MoaGrantingDecision) a.a(MoaGrantingDecision.class, r1);
    }

    public MoaGrantingDecision(String r1, int r2) {
        super(r1, r2);
    }
}
