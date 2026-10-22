package com.bytedance.android.monitorV2.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/monitorV2/event/HybridEvent$TerminateType", "", "Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum HybridEvent$TerminateType extends Enum<HybridEvent$TerminateType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HybridEvent$TerminateType f3540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HybridEvent$TerminateType f3541b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HybridEvent$TerminateType f3542c = null;
    public static final HybridEvent$TerminateType d = null;
    public static final HybridEvent$TerminateType e = null;
    public static final HybridEvent$TerminateType f = null;
    public static final HybridEvent$TerminateType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ HybridEvent$TerminateType[] f3543h = null;

    static {
        HybridEvent$TerminateType r5 = new HybridEvent$TerminateType("SWITCH_OFF", 0);
        f3540a = r5;
        HybridEvent$TerminateType r10 = new HybridEvent$TerminateType("PARAM_EXCEPTION", 1);
        f3541b = r10;
        HybridEvent$TerminateType r11 = new HybridEvent$TerminateType("CATCH_EXCEPTION", 2);
        f3542c = r11;
        HybridEvent$TerminateType r12 = new HybridEvent$TerminateType("EVENT_REPEATED", 3);
        d = r12;
        HybridEvent$TerminateType r13 = new HybridEvent$TerminateType("INVALID_CASE", 4);
        e = r13;
        HybridEvent$TerminateType r14 = new HybridEvent$TerminateType("HOST_VIEW_DESTROYED", 5);
        f = r14;
        HybridEvent$TerminateType r15 = new HybridEvent$TerminateType("BLOCK_LIST", 6);
        g = r15;
        f3543h = new HybridEvent$TerminateType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public HybridEvent$TerminateType(String r5, int r10) {
        super(r5, r10);
    }

    public static HybridEvent$TerminateType valueOf(String r5) {
        return (HybridEvent$TerminateType) Enum.valueOf(HybridEvent$TerminateType.class, r5);
    }

    public static HybridEvent$TerminateType[] values() {
        return (HybridEvent$TerminateType[]) f3543h.clone();
    }
}
