package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/reach/api/ReachClickTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "BUTTON", "CLOSE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachClickTarget extends Enum<ReachClickTarget> {
    public static final ReachClickTarget BUTTON = null;
    public static final ReachClickTarget CARD = null;
    public static final ReachClickTarget CLOSE = null;
    public static final /* synthetic */ ReachClickTarget[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachClickTarget> getEntries() {
        return b;
    }

    static {
        ReachClickTarget r0 = new ReachClickTarget("CARD", 0);
        CARD = r0;
        ReachClickTarget r1 = new ReachClickTarget("BUTTON", 1);
        BUTTON = r1;
        ReachClickTarget r3 = new ReachClickTarget("CLOSE", 2);
        CLOSE = r3;
        ReachClickTarget[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ReachClickTarget[] values() {
        return (ReachClickTarget[]) a.clone();
    }

    public static ReachClickTarget valueOf(String r1) {
        return (ReachClickTarget) a.a(ReachClickTarget.class, r1);
    }

    public ReachClickTarget(String r1, int r2) {
        super(r1, r2);
    }
}
