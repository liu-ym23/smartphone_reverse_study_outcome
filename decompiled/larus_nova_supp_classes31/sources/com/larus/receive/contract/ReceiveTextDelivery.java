package com.larus.receive.contract;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/receive/contract/ReceiveTextDelivery;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_SEND", "FILL_INPUT", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReceiveTextDelivery extends Enum<ReceiveTextDelivery> {
    public static final ReceiveTextDelivery AUTO_SEND = null;
    public static final ReceiveTextDelivery FILL_INPUT = null;
    public static final /* synthetic */ ReceiveTextDelivery[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReceiveTextDelivery> getEntries() {
        return b;
    }

    static {
        ReceiveTextDelivery r0 = new ReceiveTextDelivery("AUTO_SEND", 0);
        AUTO_SEND = r0;
        ReceiveTextDelivery r1 = new ReceiveTextDelivery("FILL_INPUT", 1);
        FILL_INPUT = r1;
        ReceiveTextDelivery[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReceiveTextDelivery[] values() {
        return (ReceiveTextDelivery[]) a.clone();
    }

    public static ReceiveTextDelivery valueOf(String r1) {
        return (ReceiveTextDelivery) r27.a.a(ReceiveTextDelivery.class, r1);
    }

    public ReceiveTextDelivery(String r1, int r2) {
        super(r1, r2);
    }
}
