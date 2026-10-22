package com.bytedance.android.live.room.api.playopt.topspeed.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TopSpeedTrace {
    public static final Lazy a = null;
    public static final TopSpeedTrace b = null;

    public TopSpeedTrace() {
    }

    public static StringBuffer b() {
        return (StringBuffer) a.getValue();
    }

    static {
        b = new TopSpeedTrace();
        a = LazyKt.lazy(TopSpeedTrace$traceBuffer$2.INSTANCE);
    }

    @JvmStatic
    public static final void c(com.bytedance.android.live.room.api.base.alog.a r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Throwable r0 = r2.b;
        if (r0 == null) goto L5;
        ALogger.e("LiveTopSpeedLog", r2.a, r0);
        return;
    L5:
        ALogger.i("LiveTopSpeedLog", r2.a);
        Unit r3 = Unit.INSTANCE;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        if (TopSpeedModeUtils.b() == false) goto L6;
        ALogger.w("LiveTopSpeedLog", r3);
        b().append(r3 + "\n");
        return;
    }
}
