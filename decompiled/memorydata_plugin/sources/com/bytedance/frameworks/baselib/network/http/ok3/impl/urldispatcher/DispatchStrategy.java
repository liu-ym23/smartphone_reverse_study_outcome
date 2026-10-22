package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DispatchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2508a = "DispatchStrategy";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DispatchStrategyType f2509b;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2510a = null;

        static {
            int[] r0 = new int[DispatchStrategyType.values().length];
            f2510a = r0;
            r0[DispatchStrategyType.STATIC_DISPATCH_STRATEGY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f2510a[DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

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
            DispatchStrategyType r0 = new DispatchStrategyType("UNKNOWN_DISPATCH_STRATEGY", 0);
            UNKNOWN_DISPATCH_STRATEGY = r0;
            DispatchStrategyType r1 = new DispatchStrategyType("STATIC_DISPATCH_STRATEGY", 1);
            STATIC_DISPATCH_STRATEGY = r1;
            DispatchStrategyType r3 = new DispatchStrategyType("WRR_DISPATCH_STRATEGY", 2);
            WRR_DISPATCH_STRATEGY = r3;
            DispatchStrategyType r5 = new DispatchStrategyType("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            CONSERVATIVE_DISPATCH_STRATEGY = r5;
            DispatchStrategyType r7 = new DispatchStrategyType("OPTIMIZED_DISPATCH_STRATEGY", 4);
            OPTIMIZED_DISPATCH_STRATEGY = r7;
            DispatchStrategyType r9 = new DispatchStrategyType("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            ROUTE_SELECTION_DISPATCH_STRATEGY = r9;
            DispatchStrategyType r11 = new DispatchStrategyType("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            REQUEST_HEADER_DISPATCH_STRATEGY = r11;
            DispatchStrategyType r13 = new DispatchStrategyType("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            DISPATCH_STRATEGY_SUPPORTED_LAST = r13;
            $VALUES = new DispatchStrategyType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private DispatchStrategyType(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchStrategyType valueOf(String r2) {
            return (DispatchStrategyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DispatchStrategyType.class, r2), DispatchStrategyType.class, "com.obric.memorydata.plugin");
        }

        public static DispatchStrategyType[] values() {
            return (DispatchStrategyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DispatchStrategyType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public DispatchStrategy(DispatchStrategyType r1) {
        this.f2509b = r1;
    }

    public static DispatchStrategy a(DispatchStrategyType r0, JSONObject r1, String r2, long r3, int r5) {
        int r4 = AnonymousClass1.f2510a[r0.ordinal()];
        if (r4 == 1) goto L14;
        if (r4 == 2) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(f2508a, "dispatch strategy " + r0 + " is not supported, fallback to default strategy");
    L10:
        return new a();
    L12:
        return new f(r1);
    L14:
        return new g(r1);
    }

    public abstract String a(Uri r1);

    public abstract void a(k r1);

    public abstract boolean a();

    public DispatchStrategyType b() {
        return this.f2509b;
    }
}
