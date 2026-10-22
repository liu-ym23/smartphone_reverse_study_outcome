package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/ReplyType;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH", "ANSWER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType ANSWER = null;
    public static final ReplyType FINISH = null;
    public static final /* synthetic */ ReplyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReplyType> getEntries() {
        return b;
    }

    static {
        ReplyType r0 = new ReplyType("FINISH", 0);
        FINISH = r0;
        ReplyType r1 = new ReplyType("ANSWER", 1);
        ANSWER = r1;
        ReplyType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) a.clone();
    }

    public static ReplyType valueOf(String r1) {
        return (ReplyType) r27.a.a(ReplyType.class, r1);
    }

    public ReplyType(String r1, int r2) {
        super(r1, r2);
    }
}
