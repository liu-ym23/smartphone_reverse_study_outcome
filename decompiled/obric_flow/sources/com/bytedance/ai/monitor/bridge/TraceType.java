package com.bytedance.ai.monitor.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/TraceType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TraceType extends Enum<TraceType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TraceType f2390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TraceType f2391b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TraceType f2392c = null;
    public static final TraceType d = null;
    public static final /* synthetic */ TraceType[] e = null;

    static {
        TraceType r5 = new TraceType("FE_CALL_FE", 0);
        f2390a = r5;
        TraceType r10 = new TraceType("FE_CALL_NATIVE", 1);
        f2391b = r10;
        TraceType r11 = new TraceType("NATIVE_EVENT", 2);
        f2392c = r11;
        TraceType r12 = new TraceType("NONE", 3);
        d = r12;
        TraceType[] r13 = {r5, r10, r11, r12};
        e = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public TraceType(String r5, int r10) {
        super(r5, r10);
    }

    public static TraceType valueOf(String r5) {
        return (TraceType) Enum.valueOf(TraceType.class, r5);
    }

    public static TraceType[] values() {
        return (TraceType[]) e.clone();
    }
}
