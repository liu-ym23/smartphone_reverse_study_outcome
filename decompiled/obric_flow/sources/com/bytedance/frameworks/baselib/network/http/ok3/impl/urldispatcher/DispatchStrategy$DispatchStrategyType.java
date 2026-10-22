package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final enum DispatchStrategy$DispatchStrategyType extends Enum<DispatchStrategy$DispatchStrategyType> {
    public static final DispatchStrategy$DispatchStrategyType CONSERVATIVE_DISPATCH_STRATEGY = null;
    public static final DispatchStrategy$DispatchStrategyType DISPATCH_STRATEGY_SUPPORTED_LAST = null;
    public static final DispatchStrategy$DispatchStrategyType OPTIMIZED_DISPATCH_STRATEGY = null;
    public static final DispatchStrategy$DispatchStrategyType ROUTE_SELECTION_DISPATCH_STRATEGY = null;
    public static final DispatchStrategy$DispatchStrategyType STATIC_DISPATCH_STRATEGY = null;
    public static final DispatchStrategy$DispatchStrategyType UNKNOWN_DISPATCH_STRATEGY = null;
    public static final DispatchStrategy$DispatchStrategyType WRR_DISPATCH_STRATEGY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DispatchStrategy$DispatchStrategyType[] f4687a = null;

    static {
        DispatchStrategy$DispatchStrategyType r5 = new DispatchStrategy$DispatchStrategyType("UNKNOWN_DISPATCH_STRATEGY", 0);
        UNKNOWN_DISPATCH_STRATEGY = r5;
        DispatchStrategy$DispatchStrategyType r10 = new DispatchStrategy$DispatchStrategyType("STATIC_DISPATCH_STRATEGY", 1);
        STATIC_DISPATCH_STRATEGY = r10;
        DispatchStrategy$DispatchStrategyType r11 = new DispatchStrategy$DispatchStrategyType("WRR_DISPATCH_STRATEGY", 2);
        WRR_DISPATCH_STRATEGY = r11;
        DispatchStrategy$DispatchStrategyType r12 = new DispatchStrategy$DispatchStrategyType("CONSERVATIVE_DISPATCH_STRATEGY", 3);
        CONSERVATIVE_DISPATCH_STRATEGY = r12;
        DispatchStrategy$DispatchStrategyType r13 = new DispatchStrategy$DispatchStrategyType("OPTIMIZED_DISPATCH_STRATEGY", 4);
        OPTIMIZED_DISPATCH_STRATEGY = r13;
        DispatchStrategy$DispatchStrategyType r14 = new DispatchStrategy$DispatchStrategyType("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
        ROUTE_SELECTION_DISPATCH_STRATEGY = r14;
        DispatchStrategy$DispatchStrategyType r15 = new DispatchStrategy$DispatchStrategyType("DISPATCH_STRATEGY_SUPPORTED_LAST", 6);
        DISPATCH_STRATEGY_SUPPORTED_LAST = r15;
        f4687a = new DispatchStrategy$DispatchStrategyType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static DispatchStrategy$DispatchStrategyType valueOf(String r5) {
        return (DispatchStrategy$DispatchStrategyType) Enum.valueOf(DispatchStrategy$DispatchStrategyType.class, r5);
    }

    public static DispatchStrategy$DispatchStrategyType[] values() {
        return (DispatchStrategy$DispatchStrategyType[]) f4687a.clone();
    }
}
