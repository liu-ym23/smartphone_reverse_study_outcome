package com.larus.basic.experience.downgrade.impl.strategy;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.f;
import com.larus.platform.model.downgrade.ToastDowngradeStrategyConfig;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t19.s;
import tx9.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e<T> implements c<T> {
    public static long d;
    public final ToastDowngradeStrategyConfig a;
    public final int b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final Object e(b<T> r1, Continuation<? super b<T>> r2) {
        return r1;
    }

    public final Map<String, List<String>> a() {
        return this.a.getBodyMatchers();
    }

    public final Map<String, List<String>> b() {
        return this.a.getQueryMatchers();
    }

    public final Map<String, List<String>> f() {
        return this.a.getExtraMatchers();
    }

    public final int d() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public e(ToastDowngradeStrategyConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = -1;
        this.c = -1;
    }

    public final Pair c(b r13, com.larus.network.http.a r14) {
        boolean r0 = true;
        Pair r1 = c.a.a(this, r13, true);
        boolean r2 = ((Boolean) r1.component1()).booleanValue();
        String r3 = (String) r1.component2();
        FLogger r4 = FLogger.a;
        r4.i("ToastDowngradeStrategy", "postProcess, path = " + r13.a + ", matched = " + r2 + ", reason = " + r3);
        if (r2 == false) goto L5;
        String r5 = null;
        if (this.a.getForceIgnoreCache() == true) goto L17;
        Map r6 = r13.d;
        if (r6 == null) goto L11;
        String r7 = (String) r6.get("has_cache");
    L13:
        if (Intrinsics.areEqual(r7, "1") == false) goto L17;
        r4.i("ToastDowngradeStrategy", "postProcess has cache, path = " + r13.a);
        return TuplesKt.to(r13, r14);
    L11:
        r7 = null;
    L17:
        if ((r14 instanceof f) == false) goto L46;
        List r8 = this.a.getEnabledErrorCode();
        if (r8 != null) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == false) goto L26;
    L27:
        Map r9 = r13.d;
        if (r9 == null) goto L31;
        String r10 = (String) r9.get("toast_text");
        if (r10 == null) goto L31;
    L32:
        String r11 = r10;
        Map r12 = r13.d;
        if (r12 == null) goto L35;
        r5 = (String) r12.get("toast_mob_scene");
    L35:
        r4.i("ToastDowngradeStrategy", "postProcess show toast for " + r13.a + ", code = " + ((f) r14).d.getCode() + ", toastText = " + r11);
        if (o0.d(r11) == false) goto L43;
        if (r11 == null) goto L43;
        long r15 = SystemClock.elapsedRealtime();
        if ((r15 - d) >= RangesKt.coerceAtLeast(this.a.getDebounceGapMs(), 0)) goto L42;
        r4.i("ToastDowngradeStrategy", "showToast debounce");
        goto L43
    L42:
        d = r15;
        s.j(s.a, AppHost.a.getApplication(), r11, null, false, 28);
    L43:
        if (r5 == null) goto L46;
        x0.a(r5);
    L31:
        r10 = this.a.getDefaultToastText();
        goto L32
    L26:
        if (((f) r14).d.getCode() != (-99999)) goto L46;
    L21:
        if (r8.contains(Boxing.boxLong(((f) r14).d.getCode())) != true) goto L23;
    L46:
        return TuplesKt.to(r13, r14);
    L5:
        return TuplesKt.to(r13, r14);
    }
}
