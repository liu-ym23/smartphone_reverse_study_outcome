package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/trace/RealTimeNavStartFailReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CODE_ERROR", "AUTH_ERROR", "PARAMS_ERROR", "GET_ORIGIN_ERROR", "ROUTE_ERROR", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum RealTimeNavStartFailReason extends Enum<RealTimeNavStartFailReason> {
    public static final RealTimeNavStartFailReason AUTH_ERROR = null;
    public static final RealTimeNavStartFailReason CODE_ERROR = null;
    public static final RealTimeNavStartFailReason GET_ORIGIN_ERROR = null;
    public static final RealTimeNavStartFailReason PARAMS_ERROR = null;
    public static final RealTimeNavStartFailReason ROUTE_ERROR = null;
    public static final /* synthetic */ RealTimeNavStartFailReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<RealTimeNavStartFailReason> getEntries() {
        return b;
    }

    static {
        RealTimeNavStartFailReason r0 = new RealTimeNavStartFailReason("CODE_ERROR", 0, "code_error");
        CODE_ERROR = r0;
        RealTimeNavStartFailReason r1 = new RealTimeNavStartFailReason("AUTH_ERROR", 1, "auth_error");
        AUTH_ERROR = r1;
        RealTimeNavStartFailReason r2 = new RealTimeNavStartFailReason("PARAMS_ERROR", 2, "params_error");
        PARAMS_ERROR = r2;
        RealTimeNavStartFailReason r4 = new RealTimeNavStartFailReason("GET_ORIGIN_ERROR", 3, "get_origin_error");
        GET_ORIGIN_ERROR = r4;
        RealTimeNavStartFailReason r6 = new RealTimeNavStartFailReason("ROUTE_ERROR", 4, "route_error");
        ROUTE_ERROR = r6;
        RealTimeNavStartFailReason[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static RealTimeNavStartFailReason[] values() {
        return (RealTimeNavStartFailReason[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavStartFailReason valueOf(String r1) {
        return (RealTimeNavStartFailReason) a.a(RealTimeNavStartFailReason.class, r1);
    }

    public RealTimeNavStartFailReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
