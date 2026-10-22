package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/api/ReachButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "PLAIN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachButtonStyle extends Enum<ReachButtonStyle> {
    public static final ReachButtonStyle PLAIN = null;
    public static final ReachButtonStyle PRIMARY = null;
    public static final /* synthetic */ ReachButtonStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReachButtonStyle> getEntries() {
        return b;
    }

    static {
        ReachButtonStyle r0 = new ReachButtonStyle("PRIMARY", 0);
        PRIMARY = r0;
        ReachButtonStyle r1 = new ReachButtonStyle("PLAIN", 1);
        PLAIN = r1;
        ReachButtonStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReachButtonStyle[] values() {
        return (ReachButtonStyle[]) a.clone();
    }

    public static ReachButtonStyle valueOf(String r1) {
        return (ReachButtonStyle) a.a(ReachButtonStyle.class, r1);
    }

    public ReachButtonStyle(String r1, int r2) {
        super(r1, r2);
    }
}
