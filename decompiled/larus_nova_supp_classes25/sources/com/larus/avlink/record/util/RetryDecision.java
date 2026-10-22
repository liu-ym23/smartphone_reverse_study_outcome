package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/util/RetryDecision;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RETRY", "TERMINAL", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RetryDecision extends Enum<RetryDecision> {
    public static final RetryDecision RETRY = null;
    public static final RetryDecision SUCCESS = null;
    public static final RetryDecision TERMINAL = null;
    public static final /* synthetic */ RetryDecision[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RetryDecision> getEntries() {
        return b;
    }

    static {
        RetryDecision r0 = new RetryDecision("SUCCESS", 0);
        SUCCESS = r0;
        RetryDecision r1 = new RetryDecision("RETRY", 1);
        RETRY = r1;
        RetryDecision r3 = new RetryDecision("TERMINAL", 2);
        TERMINAL = r3;
        RetryDecision[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static RetryDecision[] values() {
        return (RetryDecision[]) a.clone();
    }

    public static RetryDecision valueOf(String r1) {
        return (RetryDecision) r27.a.a(RetryDecision.class, r1);
    }

    public RetryDecision(String r1, int r2) {
        super(r1, r2);
    }
}
