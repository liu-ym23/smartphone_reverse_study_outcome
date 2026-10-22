package com.larus.reach.runtime;

import android.content.Context;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.api.ReachType;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final x a = null;
    public static final ReachBannerRuntime b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachType.values().length];
            r0[ReachType.BANNER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReachType.TOAST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public x() {
    }

    static {
        a = new x();
        b = new ReachBannerRuntime();
    }

    public static void a(String r5) {
        if (r5 == null) goto L37;
        Object r1 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L37;
        FLogger.a.i("ReachRuntime", "reach revoke received, pushId=".concat(r5));
        ReachBannerRuntime r0 = b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "pushId");
        if (StringsKt.isBlank(r5) == true) goto L43;
        monitor-enter(r0);
        Iterator<T> r2 = r0.g.values().iterator();     // Catch: Throwable -> L34
    L15:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(((ReachBannerRuntime.c) r3).a.a.a, r5) == false) goto L15;
        r1 = r3;
    L19:
        ReachBannerRuntime.c r4 = (ReachBannerRuntime.c) r1;     // Catch: Throwable -> L34
        if (r4 != null) goto L23;
        monitor-exit(r0);
        return;
    L23:
        String r6 = r4.a.a.h;     // Catch: Throwable -> L34
        ReachBannerRuntime.EntryState r7 = r4.f;     // Catch: Throwable -> L34
        ReachBannerRuntime.EntryState r8 = ReachBannerRuntime.EntryState.DISMISSING;     // Catch: Throwable -> L34
        if (r7 != r8) goto L28;
        monitor-exit(r0);
        return;
    L28:
        if (r7.isPresented() == false) goto L30;
        r4.a(r8);     // Catch: Throwable -> L34
        ReachBannerRuntime.a r9 = new ReachBannerRuntime.a.b(r4, ReachCloseReason.REVOKED);     // Catch: Throwable -> L34
    L31:
        monitor-exit(r0);
        r0.g(r9);
        r0.r();
        return;
    L30:
        r0.o(r4);     // Catch: Throwable -> L34
        r9 = new ReachBannerRuntime.a.c(r4, ReachRejectReason.REVOKED);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L43:
        return;
    L37:
        FLogger.a.i("ReachRuntime", "reach revoke ignored, reason=push_id_blank");
    }

    public static ns9.u b(ns9.t r11, Function0 r12) {
        ReachRejectReason r0 = null;
        if (r11 != null) goto L7;
        FLogger.a.i("ReachRuntime", "reach submit rejected, reason=request_null");
        return new ns9.u.b(null, ReachRejectReason.INVALID_PROTOCOL);
    L7:
        if (StringsKt.isBlank(r11.a.h) == false) goto L10;
        FLogger.a.i("ReachRuntime", "reach submit rejected, reason=reach_unique_id_blank");
        return new ns9.u.b(r11.a.h, ReachRejectReason.INVALID_PROTOCOL);
    L10:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r1 = y.a;
        Intrinsics.checkNotNullParameter(r11, "request");
        Iterator r2 = y.h(r11.a.c).iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        ReachSceneLifecycleListener r3 = (ReachSceneLifecycleListener) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        r3.b(r11);     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onReceive failed, reachUniqueId=" + r11.a.h + ", scene=" + r11.a.c, r6);
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L21:
        int r8 = a.a[r11.getType().ordinal()];
        boolean r9 = false;
        if (r8 != 1) goto L24;
        ReachBannerRuntime r10 = b;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        ReachRejectReason r13 = ReachBannerRuntime.f(r11, ReachBannerRuntime.ReachGatePhase.SUBMIT);
        if (r13 != null) goto L144;
        monitor-enter(r10);
    L126:
        th = move-exception;
        throw th;
    L97:
        if (r10.g.containsKey(r11.a.h) == false) goto L102;
        ns9.u.a r14 = new ns9.u.a(r11.a.h);     // Catch: Throwable -> L126
        monitor-exit(r10);
        return r14;
    L102:
        if (r11.b.b() != ReachPosition.BOTTOM) goto L119;
        Collection<ReachBannerRuntime.c> r15 = r10.g.values();     // Catch: Throwable -> L126
        if ((r15 instanceof Collection) == true) goto L106;
    L108:
        Iterator<T> r16 = r15.iterator();     // Catch: Throwable -> L126
    L110:
        if (r16.hasNext() == false) goto L117;
        if (((ReachBannerRuntime.c) r16.next()).a.b.b() != ReachPosition.BOTTOM) goto L114;
        boolean r17 = true;
    L115:
        if (r17 == false) goto L110;
        r9 = true;
        goto L117
    L114:
        r17 = false;
    L117:
        if (r9 == false) goto L119;
        r0 = ReachRejectReason.PRIORITY_QUEUE;     // Catch: Throwable -> L126
    L120:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L126
        monitor-exit(r10);
        if (r0 != null) goto L145;
        r10.r();
        return new ns9.u.a(r11.a.h);
    L145:
        return new ns9.u.b(r11.a.h, r0);
    L106:
        if (r15.isEmpty() == false) goto L108;
    L119:
        long r19 = r10.e.incrementAndGet();     // Catch: Throwable -> L126
        long r20 = r10.f.incrementAndGet();     // Catch: Throwable -> L126
        int r21 = p.a;     // Catch: Throwable -> L126
        r10.g.put(r11.a.h, new ReachBannerRuntime.c(r11, r12, r19, r20, p.b(r11.c.a)));     // Catch: Throwable -> L126
        goto L120
    L144:
        return new ns9.u.b(r11.a.h, r13);
    L24:
        if (r8 != 2) goto L91;
        String r110 = r11.d.b;
        if (r110 == null) goto L143;
        if ((!StringsKt.isBlank(r110)) == false) goto L30;
        String r22 = r110;
    L31:
        if (r22 == null) goto L143;
        gd9.i r111 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r111);
        Context r23 = r111.a().e();
        if (r23 != null) goto L36;
        Context r24 = r111.getApplication();
    L37:
        Long r112 = r11.c.b;
        if (r112 == null) goto L49;
        Long r113 = Long.valueOf(r112.longValue());
        long r25 = r113.longValue();
        if (r25 > 0) goto L42;
    L44:
        if (r9 == true) goto L47;
        r113 = null;
    L47:
        if (r113 == null) goto L49;
        Integer r114 = Integer.valueOf((int) r113.longValue());
    L50:
        String r26 = r11.a.e;
        if (r26 != null) goto L53;
    L85:
        if (r114 == null) goto L87;
        t19.s.j(t19.s.a, r24, r22, Integer.valueOf(r114.intValue()), false, 24);
    L88:
        com.larus.reach.impl.b.e(r11);
        y.d(r11);
        return new ns9.u.a(r11.a.h);
    L87:
        t19.s.j(t19.s.a, r24, r22, null, false, 28);
        goto L88
    L53:
        switch(r26.hashCode()) {
            case -1867169789: goto L80;
            case 3387192: goto L74;
            case 96784904: goto L68;
            case 336650556: goto L62;
            case 1124446108: goto L56;
            default: goto L85;
        };
    L56:
        if (r26.equals("warning") == false) goto L85;
        if (r114 == null) goto L60;
        int r115 = r114.intValue();
        t19.s.a.getClass();
        t19.s.u(r24, r22, r115);
        goto L88
    L60:
        t19.s.a.getClass();
        t19.s.t(r24, r22);
        goto L88
    L62:
        if (r26.equals("loading") == false) goto L85;
        if (r114 == null) goto L66;
        int r116 = r114.intValue();
        t19.s r27 = t19.s.a;
        Integer r117 = Integer.valueOf(r116);
        r27.getClass();
        t19.s.d(r24, r22, r117, true);
        goto L88
    L66:
        t19.s.a.getClass();
        Intrinsics.checkNotNullParameter(r22, "text");
        t19.s.d(r24, r22, null, true);
        goto L88
    L68:
        if (r26.equals("error") == false) goto L85;
        if (r114 == null) goto L72;
        int r118 = r114.intValue();
        t19.s.a.getClass();
        Intrinsics.checkNotNullParameter(r22, "text");
        Intrinsics.checkNotNullParameter(r22, "text");
        t19.s.l(r24, 2131243493, r22, Integer.valueOf(r118), null, false);
        goto L88
    L72:
        t19.s.a.getClass();
        t19.s.c(r24, r22);
        goto L88
    L74:
        if (r26.equals("none") == false) goto L85;
        if (r114 == null) goto L78;
        int r119 = r114.intValue();
        t19.s r28 = t19.s.a;
        Integer r120 = Integer.valueOf(r119);
        r28.getClass();
        Intrinsics.checkNotNullParameter(r22, "text");
        Intrinsics.checkNotNullParameter(r22, "text");
        t19.s.i(r24, r22, r120, false, false, null);
        goto L88
    L78:
        t19.s.a.getClass();
        Intrinsics.checkNotNullParameter(r22, "text");
        Intrinsics.checkNotNullParameter(r22, "text");
        t19.s.i(r24, r22, null, false, false, null);
        goto L88
    L80:
        if (r26.equals("success") == false) goto L85;
        if (r114 == null) goto L84;
        int r121 = r114.intValue();
        t19.s.a.getClass();
        t19.s.q(r24, r22, r121);
        goto L88
    L84:
        t19.s.a.getClass();
        t19.s.p(r24, r22);
        goto L88
    L42:
        if (r25 > 2147483647L) goto L44;
        r9 = true;
    L49:
        r114 = null;
        goto L50
    L36:
        r24 = r23;
        goto L37
    L30:
        r22 = null;
    L143:
        return new ns9.u.b(r11.a.h, ReachRejectReason.INVALID_PROTOCOL);
    L91:
        throw new NoWhenBranchMatchedException();
    }
}
