package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/reach/api/ReachRequestSource;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_CMD", "INAPP_PUSH_PULL", "CLIENT_BRIDGE", "LOCAL_SUBMIT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachRequestSource extends Enum<ReachRequestSource> {
    public static final ReachRequestSource CLIENT_BRIDGE = null;
    public static final ReachRequestSource INAPP_PUSH_PULL = null;
    public static final ReachRequestSource LOCAL_SUBMIT = null;
    public static final ReachRequestSource SERVER_CMD = null;
    public static final /* synthetic */ ReachRequestSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachRequestSource> getEntries() {
        return b;
    }

    static {
        ReachRequestSource r0 = new ReachRequestSource("SERVER_CMD", 0);
        SERVER_CMD = r0;
        ReachRequestSource r1 = new ReachRequestSource("INAPP_PUSH_PULL", 1);
        INAPP_PUSH_PULL = r1;
        ReachRequestSource r3 = new ReachRequestSource("CLIENT_BRIDGE", 2);
        CLIENT_BRIDGE = r3;
        ReachRequestSource r5 = new ReachRequestSource("LOCAL_SUBMIT", 3);
        LOCAL_SUBMIT = r5;
        ReachRequestSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ReachRequestSource[] values() {
        return (ReachRequestSource[]) a.clone();
    }

    public static ReachRequestSource valueOf(String r1) {
        return (ReachRequestSource) a.a(ReachRequestSource.class, r1);
    }

    public ReachRequestSource(String r1, int r2) {
        super(r1, r2);
    }
}
