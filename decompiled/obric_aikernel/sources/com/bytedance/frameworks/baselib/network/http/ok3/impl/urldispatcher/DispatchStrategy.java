package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class DispatchStrategy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1815b = "DispatchStrategy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DispatchStrategyType f1816a;

    public static final enum DispatchStrategyType extends Enum<DispatchStrategyType> {
        private static final /* synthetic */ DispatchStrategyType[] $VALUES = null;
        public static final DispatchStrategyType CONSERVATIVE_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType DISPATCH_STRATEGY_SUPPORTED_LAST = null;
        public static final DispatchStrategyType OPTIMIZED_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType REQUEST_HEADER_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType ROUTE_SELECTION_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType STATIC_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType UNKNOWN_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType WRR_DISPATCH_STRATEGY = null;

        static {
            DispatchStrategyType r10 = new DispatchStrategyType("UNKNOWN_DISPATCH_STRATEGY", 0);
            UNKNOWN_DISPATCH_STRATEGY = r10;
            DispatchStrategyType r11 = new DispatchStrategyType("STATIC_DISPATCH_STRATEGY", 1);
            STATIC_DISPATCH_STRATEGY = r11;
            DispatchStrategyType r12 = new DispatchStrategyType("WRR_DISPATCH_STRATEGY", 2);
            WRR_DISPATCH_STRATEGY = r12;
            DispatchStrategyType r13 = new DispatchStrategyType("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            CONSERVATIVE_DISPATCH_STRATEGY = r13;
            DispatchStrategyType r14 = new DispatchStrategyType("OPTIMIZED_DISPATCH_STRATEGY", 4);
            OPTIMIZED_DISPATCH_STRATEGY = r14;
            DispatchStrategyType r15 = new DispatchStrategyType("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            ROUTE_SELECTION_DISPATCH_STRATEGY = r15;
            DispatchStrategyType r16 = new DispatchStrategyType("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            REQUEST_HEADER_DISPATCH_STRATEGY = r16;
            DispatchStrategyType r17 = new DispatchStrategyType("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            DISPATCH_STRATEGY_SUPPORTED_LAST = r17;
            $VALUES = new DispatchStrategyType[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private DispatchStrategyType(String r10, int r11) {
            super(r10, r11);
        }

        public static DispatchStrategyType valueOf(String r10) {
            return (DispatchStrategyType) Enum.valueOf(DispatchStrategyType.class, r10);
        }

        public static DispatchStrategyType[] values() {
            return (DispatchStrategyType[]) $VALUES.clone();
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1817a = null;

        static {
            int[] r10 = new int[DispatchStrategyType.values().length];
            f1817a = r10;
            r10[DispatchStrategyType.STATIC_DISPATCH_STRATEGY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f1817a[DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
    }

    public DispatchStrategy(DispatchStrategyType r10) {
        this.f1816a = r10;
    }

    public static DispatchStrategy b(DispatchStrategyType r10, JSONObject r11, String r12, long r13, int r14) {
        int r15 = a.f1817a[r10.ordinal()];
        if (r15 == 1) goto L14;
        if (r15 == 2) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(f1815b, "dispatch strategy " + r10 + " is not supported, fallback to default strategy");
    L10:
        return new com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.a();
    L12:
        return new d(r11);
    L14:
        return new e(r11);
    }

    public abstract void a(y2.c r10);

    public DispatchStrategyType c() {
        return this.f1816a;
    }

    public abstract String d(Uri r10);

    public abstract boolean e();
}
