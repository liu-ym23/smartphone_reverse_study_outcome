package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/reach/api/ReachPresentationCapability;", "", "<init>", "(Ljava/lang/String;I)V", "APPLICATION_OVERLAY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachPresentationCapability extends Enum<ReachPresentationCapability> {
    public static final ReachPresentationCapability APPLICATION_OVERLAY = null;
    public static final /* synthetic */ ReachPresentationCapability[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachPresentationCapability> getEntries() {
        return b;
    }

    static {
        ReachPresentationCapability r0 = new ReachPresentationCapability();
        APPLICATION_OVERLAY = r0;
        ReachPresentationCapability[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public ReachPresentationCapability() {
        super("APPLICATION_OVERLAY", 0);
    }

    public static ReachPresentationCapability[] values() {
        return (ReachPresentationCapability[]) a.clone();
    }

    public static ReachPresentationCapability valueOf(String r1) {
        return (ReachPresentationCapability) a.a(ReachPresentationCapability.class, r1);
    }
}
