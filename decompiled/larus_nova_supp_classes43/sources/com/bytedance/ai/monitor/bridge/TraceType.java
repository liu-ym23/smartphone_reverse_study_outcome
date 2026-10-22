package com.bytedance.ai.monitor.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/TraceType;", "", "<init>", "(Ljava/lang/String;I)V", "FE_CALL_FE", "FE_CALL_NATIVE", "NATIVE_EVENT", "NONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TraceType extends Enum<TraceType> {
    public static final TraceType FE_CALL_FE = null;
    public static final TraceType FE_CALL_NATIVE = null;
    public static final TraceType NATIVE_EVENT = null;
    public static final TraceType NONE = null;
    public static final /* synthetic */ TraceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TraceType> getEntries() {
        return b;
    }

    static {
        TraceType r0 = new TraceType("FE_CALL_FE", 0);
        FE_CALL_FE = r0;
        TraceType r1 = new TraceType("FE_CALL_NATIVE", 1);
        FE_CALL_NATIVE = r1;
        TraceType r10 = new TraceType("NATIVE_EVENT", 2);
        NATIVE_EVENT = r10;
        TraceType r11 = new TraceType("NONE", 3);
        NONE = r11;
        TraceType[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static TraceType[] values() {
        return (TraceType[]) a.clone();
    }

    public static TraceType valueOf(String r1) {
        return (TraceType) a.a(TraceType.class, r1);
    }

    public TraceType(String r1, int r10) {
        super(r1, r10);
    }
}
