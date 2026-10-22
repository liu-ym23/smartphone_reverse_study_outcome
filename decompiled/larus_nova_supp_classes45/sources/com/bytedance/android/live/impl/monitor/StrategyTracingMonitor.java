package com.bytedance.android.live.impl.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.log.j0;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StrategyTracingMonitor {
    public static final Lazy a = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Map a;

        public a(Map r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            j0.l().sendLog("livesdk_live_strategy_init", this.a, new Object[0]);
        }
    }

    static {
        a = LazyKt.lazy(StrategyTracingMonitor$logOnlyInDebug$2.INSTANCE);
    }

    public static void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        LinkedHashMap r0 = (LinkedHashMap) r5;
        String r2 = (String) r0.get("init_result");
        if (r2 == null) goto L8;
        if (r2.equals("0") != true) goto L8;
        String r3 = (String) r0.get("strategy_id");
    L8:
        if (v.a() == false) goto L10;
    L13:
        ALogger.i("strategy_tag", "Strategy init success:" + ((String) r0.get("init_result")) + "; fetch_result " + ((String) r0.get("fetch_result")) + "Current strategy config id :" + ((String) r0.get("strategy_id")) + ";Use cache:" + ((String) r0.get("init_by_cache")));
        StringBuilder r1 = new StringBuilder("config fetch time:");
        r1.append(oa0.a.c);
        r1.append(";jsonUseTime:");
        r1.append(oa0.a.d);
        ALogger.i("strategy_tag", r1.toString());
    L14:
        Observable.timer(300, TimeUnit.SECONDS).subscribe(new a(r5));
        return;
    L10:
        if (v.a() == true) goto L14;
        if (((Boolean) a.getValue()).booleanValue() == true) goto L14;
        goto L13
    }
}
