package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/util/RetryTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "BACKOFF", "NETWORK_RECOVERY", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RetryTrigger extends Enum<RetryTrigger> {
    public static final RetryTrigger BACKOFF = null;
    public static final RetryTrigger INITIAL = null;
    public static final RetryTrigger NETWORK_RECOVERY = null;
    public static final /* synthetic */ RetryTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RetryTrigger> getEntries() {
        return b;
    }

    static {
        RetryTrigger r0 = new RetryTrigger("INITIAL", 0);
        INITIAL = r0;
        RetryTrigger r1 = new RetryTrigger("BACKOFF", 1);
        BACKOFF = r1;
        RetryTrigger r3 = new RetryTrigger("NETWORK_RECOVERY", 2);
        NETWORK_RECOVERY = r3;
        RetryTrigger[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static RetryTrigger[] values() {
        return (RetryTrigger[]) a.clone();
    }

    public static RetryTrigger valueOf(String r1) {
        return (RetryTrigger) r27.a.a(RetryTrigger.class, r1);
    }

    public RetryTrigger(String r1, int r2) {
        super(r1, r2);
    }
}
