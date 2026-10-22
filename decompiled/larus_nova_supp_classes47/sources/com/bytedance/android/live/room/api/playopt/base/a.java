package com.bytedance.android.live.room.api.playopt.base;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final Keva a = null;
    public static final PropertyOwner<Boolean> b = null;
    public static final PropertyOwner c = null;
    public static final PropertyOwner<Boolean> d = null;
    public static final PropertyOwner e = null;
    public static final PropertyOwner<Boolean> f = null;
    public static final PropertyOwner g = null;

    static {
        a = Keva.getRepo("play_opt_store");
        long r3 = 86400000;
        PropertyOwner<Boolean> r0 = new PropertyOwner(Boolean.valueOf(a("top_speed_switch", TopSpeedModeUtils.d().e() * r3)));
        b = r0;
        c = r0;
        PropertyOwner<Boolean> r1 = new PropertyOwner(Boolean.valueOf(a("picture_quality_switch", TopSpeedModeUtils.d().e() * r3)));
        d = r1;
        e = r1;
        PropertyOwner<Boolean> r2 = new PropertyOwner(Boolean.valueOf(a("base_function_switch", TopSpeedModeUtils.d().e() * r3)));
        f = r2;
        g = r2;
    }

    public static void b(boolean r4) {
        b.a(Boolean.valueOf(r4));
        Keva r0 = a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r4);
        r1.append(',');
        r1.append(System.currentTimeMillis());
        r0.storeString("top_speed_switch", r1.toString());
        TopSpeedModeManager.l.e();
    }

    public static boolean a(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "switchKey");
        List r10 = StringsKt.split$default(a.getString(r8, ""), new String[]{","}, false, 0, 6, null);
        boolean r0 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.size() < 2) goto L7;
        boolean r1 = true;
    L8:
        Long r2 = null;
        if (r1 == true) goto L12;
        r10 = null;
    L12:
        if (r10 == null) goto L42;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        Object r4 = Result.constructor-impl(Boolean.valueOf(Boolean.parseBoolean((String) ListProtector.get(r10, 0))));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r4) == false) goto L21;
        r4 = null;
    L21:
        if (Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) == false) goto L43;
        Long r12 = StringsKt.toLongOrNull((String) ListProtector.get(r10, 1));
        if (r12 == null) goto L38;
        if (r12.longValue() <= 0) goto L27;
        boolean r5 = true;
    L28:
        if (r5 == false) goto L30;
        r2 = r12;
    L30:
        if (r2 == null) goto L38;
        if (Long.valueOf(System.currentTimeMillis() - r2.longValue()).longValue() < r9) goto L34;
        boolean r13 = true;
    L35:
        if (r13 != true) goto L38;
        r0 = true;
        goto L38
    L34:
        r13 = false;
        goto L35
    L27:
        r5 = false;
    L38:
        return !r0;
    L43:
        return false;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L42:
        return false;
    L7:
        r1 = false;
        goto L8
    }
}
