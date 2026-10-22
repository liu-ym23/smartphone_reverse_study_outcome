package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/reach/api/ReachCustomClickResult;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_HANDLED", "LOCAL_HANDLED", "SCENE_HANDLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachCustomClickResult extends Enum<ReachCustomClickResult> {
    public static final ReachCustomClickResult LOCAL_HANDLED = null;
    public static final ReachCustomClickResult NOT_HANDLED = null;
    public static final ReachCustomClickResult SCENE_HANDLED = null;
    public static final /* synthetic */ ReachCustomClickResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachCustomClickResult> getEntries() {
        return b;
    }

    static {
        ReachCustomClickResult r0 = new ReachCustomClickResult("NOT_HANDLED", 0);
        NOT_HANDLED = r0;
        ReachCustomClickResult r1 = new ReachCustomClickResult("LOCAL_HANDLED", 1);
        LOCAL_HANDLED = r1;
        ReachCustomClickResult r3 = new ReachCustomClickResult("SCENE_HANDLED", 2);
        SCENE_HANDLED = r3;
        ReachCustomClickResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ReachCustomClickResult[] values() {
        return (ReachCustomClickResult[]) a.clone();
    }

    public static ReachCustomClickResult valueOf(String r1) {
        return (ReachCustomClickResult) a.a(ReachCustomClickResult.class, r1);
    }

    public ReachCustomClickResult(String r1, int r2) {
        super(r1, r2);
    }
}
