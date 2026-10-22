package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/trace/RealTimeNavEndReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARRIVE", "JSB", "STATUS_ERROR", "NEW_NAV", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum RealTimeNavEndReason extends Enum<RealTimeNavEndReason> {
    public static final RealTimeNavEndReason ARRIVE = null;
    public static final RealTimeNavEndReason JSB = null;
    public static final RealTimeNavEndReason NEW_NAV = null;
    public static final RealTimeNavEndReason STATUS_ERROR = null;
    public static final /* synthetic */ RealTimeNavEndReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<RealTimeNavEndReason> getEntries() {
        return b;
    }

    static {
        RealTimeNavEndReason r0 = new RealTimeNavEndReason("ARRIVE", 0, "arrive");
        ARRIVE = r0;
        RealTimeNavEndReason r1 = new RealTimeNavEndReason("JSB", 1, "jsb");
        JSB = r1;
        RealTimeNavEndReason r2 = new RealTimeNavEndReason("STATUS_ERROR", 2, "status_error");
        STATUS_ERROR = r2;
        RealTimeNavEndReason r4 = new RealTimeNavEndReason("NEW_NAV", 3, "new_nav");
        NEW_NAV = r4;
        RealTimeNavEndReason[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static RealTimeNavEndReason[] values() {
        return (RealTimeNavEndReason[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavEndReason valueOf(String r1) {
        return (RealTimeNavEndReason) a.a(RealTimeNavEndReason.class, r1);
    }

    public RealTimeNavEndReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
