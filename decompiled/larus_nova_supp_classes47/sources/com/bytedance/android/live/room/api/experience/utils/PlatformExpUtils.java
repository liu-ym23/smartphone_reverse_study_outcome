package com.bytedance.android.live.room.api.experience.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.strategy.api.IStrategyService;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PlatformExpUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static boolean c;
    public static boolean d;

    public static fv1.b c() {
        return (fv1.b) a.getValue();
    }

    static {
        a = LazyKt.lazy(PlatformExpUtils$setting$2.INSTANCE);
        b = LazyKt.lazy(PlatformExpUtils$delayConfig$2.INSTANCE);
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L7;
        LiveData r1 = r0.getFactor("live_push_consume_advice", Boolean.FALSE, true, true);
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        d = Intrinsics.areEqual(r2, Boolean.TRUE);
        return;
    L7:
        r2 = null;
        goto L8
    }

    @JvmStatic
    public static final boolean a() {
        if (c().l() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
    L14:
        return true;
    L11:
        if (b() == true) goto L14;
        if (TopSpeedModeUtils.a() == true) goto L14;
        return false;
    L5:
        if (a.a.a() == true) goto L8;
        r0 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean b() {
        if (c().k() == true) goto L5;
    L7:
        return false;
    L5:
        if (TopSpeedModeUtils.a() == true) goto L7;
        return true;
    }

    public static long d() {
        return c().h() * ((long) WebcastRedirectException.UNKNOWN);
    }
}
