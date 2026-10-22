package com.larus.setting.impl;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.disk.api.IAppDiskService;
import com.larus.disk.api.ManualCacheCleanError;
import com.larus.disk.api.ManualCacheCleanStatus;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import tx9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ManualCacheCleanUiController {
    public static final ManualCacheCleanUiController a = null;
    public static final CoroutineScope b = null;

    public static final class a {
        public final com.larus.disk.api.j a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            com.larus.disk.api.j r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ManualCleanOutcome(result=" + this.a + ", failedRemainingBytes=" + this.b + ')';
        }

        public a(com.larus.disk.api.j r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ManualCacheCleanStatus.values().length];
            r0[ManualCacheCleanStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ManualCacheCleanStatus.PARTIAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ManualCacheCleanStatus.TASK_RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ManualCacheCleanStatus.DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ManualCacheCleanStatus.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public ManualCacheCleanUiController() {
    }

    static {
        a = new ManualCacheCleanUiController();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static long d() {
        e10 r0 = e10.a;
        Long r1 = Long.valueOf(e10.u().C());
        if (r1.longValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        long r3 = r1.longValue();
    L12:
        long r4 = r3;
        return TimeUnit.SECONDS.toMillis(RangesKt.coerceIn(r4, 1, 600));
    L11:
        r3 = 120;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final Object e(Continuation<? super Long> r10) {
        if ((r10 instanceof ManualCacheCleanUiController$queryCacheSize$1) == false) goto L7;
        ManualCacheCleanUiController$queryCacheSize$1 r1 = (ManualCacheCleanUiController$queryCacheSize$1) r10;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        long r5 = r1.J$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L26 CancellationException -> L29
    L22:
        if (((Long) r11) != null) goto L24;
        FLogger.a.w("ManualCacheCleanUi", "manual cache size query timeout timeoutMs=" + r5);     // Catch: Exception -> L26 CancellationException -> L29
    L24:
    L33:
        return (Long) r11;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
        long r7 = d();     // Catch: Exception -> L26 CancellationException -> L29
        ManualCacheCleanUiController$queryCacheSize$2 r12 = new ManualCacheCleanUiController$queryCacheSize$2(null);     // Catch: Exception -> L26 CancellationException -> L29
        r1.J$0 = r7;     // Catch: Exception -> L26 CancellationException -> L29
        r1.label = 1;     // Catch: Exception -> L26 CancellationException -> L29
        r11 = TimeoutKt.c(r7, r12, r1);     // Catch: Exception -> L26 CancellationException -> L29
        if (r11 != r3) goto L20;
        return r3;
    L20:
        r5 = r7;
    L29:
        e = move-exception;
        throw e;
    L26:
        e = move-exception;
        FLogger.a.e("ManualCacheCleanUi", "query manual cache size failed", e);
        return null;
    L7:
        r1 = new ManualCacheCleanUiController$queryCacheSize$1(this, r10);
        goto L8
    }

    public static void f(ItemTextArrow r4, long r5, Function1 r7) {
        if (r5 <= 0) goto L5;
        boolean r0 = true;
    L6:
        r4.setEnabled(true);
        r4.setClickable(true);
        r4.setStyle(1);
        if (r0 == false) goto L9;
        String r6 = (String) r7.invoke(Long.valueOf(r5));
    L10:
        r4.Z5(r6, null);
        return;
    L9:
        r6 = "";
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final Object b(ManualCacheCleanUiController r25, long r26, String r28, String r29, long r30, Continuation r32) {
        String r2 = r28;
        r25.getClass();
        if ((r32 instanceof ManualCacheCleanUiController$executeAndReportClean$1) == false) goto L7;
        ManualCacheCleanUiController$executeAndReportClean$1 r3 = (ManualCacheCleanUiController$executeAndReportClean$1) r32;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        Long r8 = null;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        long r1 = r3.J$1;
        long r9 = r3.J$0;
        com.larus.disk.api.j r10 = (com.larus.disk.api.j) r3.L$2;
        String r11 = (String) r3.L$1;
        String r12 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);
    L46:
        Long r13 = (Long) r0;
        if (r13 == null) goto L49;
        String r18 = r11;
        long r14 = r13.longValue();
    L126:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L116
        if (r10 == null) goto L62;
        Long r16 = Boxing.boxLong(r10.b);     // Catch: Throwable -> L116
        if (r16.longValue() < 0) goto L56;
        boolean r17 = true;
    L57:
        if (r17 == true) goto L60;
        r16 = null;
    L60:
        if (r16 == null) goto L62;
        r9 = r16.longValue();     // Catch: Throwable -> L116
        goto L62
    L56:
        r17 = false;
    L62:
        if (r10 == null) goto L71;
        Long r19 = Boxing.boxLong(r10.c);     // Catch: Throwable -> L116
        if (r19.longValue() < 0) goto L66;
        boolean r110 = true;
    L67:
        if (r110 == true) goto L70;
        r19 = null;
    L70:
        if (r19 == null) goto L71;
    L76:
        Long r20 = r19;
    L78:
        if (r10 == null) goto L81;
        ManualCacheCleanError r21 = r10.e;     // Catch: Throwable -> L116
        if (r21 == null) goto L81;
    L82:
        if (r10 == null) goto L89;
        ManualCacheCleanStatus r22 = r10.a;     // Catch: Throwable -> L116
        if (r22 == null) goto L89;
        String r23 = r22.name();     // Catch: Throwable -> L116
        if (r23 == null) goto L89;
        String r24 = r23.toLowerCase(Locale.US);     // Catch: Throwable -> L116
        if (r24 == null) goto L89;
    L91:
        if (r9 < 0) goto L94;
        if (r20 == null) goto L94;
        r8 = Boxing.boxLong(RangesKt.coerceAtLeast(r9 - r20.longValue(), 0));     // Catch: Throwable -> L116
    L94:
        Long r27 = r8;
        long r111 = SystemClock.elapsedRealtime() - r1;     // Catch: Throwable -> L116
        if (r10 == null) goto L104;
        String r31 = r10.d;     // Catch: Throwable -> L116
        if (r31 == null) goto L104;
        if (StringsKt.isBlank(r31) == false) goto L101;
        r31 = r12;
    L101:
        if (r31 == null) goto L104;
        String r112 = r31;
    L105:
        String r33 = r21.getCode();     // Catch: Throwable -> L116
        String r34 = r21.getReason();     // Catch: Throwable -> L116
        String r113 = r21.getStage();     // Catch: Throwable -> L116
        if (r10 == null) goto L109;
        String r35 = r10.f;     // Catch: Throwable -> L116
        if (r35 == null) goto L109;
    L110:
        long r36 = r14;
        r.a(r24, r111, r112, r33, r34, r113, r35, r18, Boxing.boxLong(r9), r20, r27);     // Catch: Throwable -> L114
        Object r37 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L119:
        Throwable r38 = Result.exceptionOrNull-impl(r37);
        if (r38 == null) goto L123;
        FLogger.a.e("ManualCacheCleanUi", "report manual cache clean result failed", r38);
    L123:
        return new a(r10, r36);
    L114:
        th = th;
    L118:
        Result.Companion r39 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L109:
        r35 = "execution";
    L104:
        r112 = r12;
    L89:
        r24 = "failed";
    L81:
        r21 = ManualCacheCleanError.EXECUTION_FAILED;     // Catch: Throwable -> L116
        goto L82
    L66:
        r110 = false;
    L71:
        r19 = Boxing.boxLong(r14);     // Catch: Throwable -> L116
        if (r19.longValue() >= 0) goto L75;
        r7 = false;
    L75:
        if (r7 == true) goto L76;
        r20 = null;
    L116:
        th = th;
        r36 = r14;
        goto L118
    L49:
        long r114 = r1;
        r2 = r12;
        com.larus.disk.api.j r40 = r10;
        String r41 = r11;
        long r115 = r9;
    L50:
        r10 = r40;
        r14 = -1;
        r18 = r41;
        r9 = r115;
        r12 = r2;
        r1 = r114;
        goto L126
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r116 = r3.J$1;
        long r117 = r3.J$0;
        String r42 = (String) r3.L$1;
        String r43 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18
        r41 = r42;
        r2 = r43;
        r115 = r117;
        r114 = r116;
    L30:
        r40 = (com.larus.disk.api.j) r0;     // Catch: Exception -> L32
    L41:
        if (r40 != null) goto L50;
        r3.L$0 = r2;
        r3.L$1 = r41;
        r3.L$2 = r40;
        r3.J$0 = r115;
        r3.J$1 = r114;
        r3.label = 2;
        Object r44 = r25.e(r3);
        if (r44 == r5) goto L139;
        r10 = r40;
        r0 = r44;
        r12 = r2;
        r1 = r114;
        long r210 = r115;
        r11 = r41;
        r9 = r210;
        goto L46
    L139:
        return r5;
    L32:
        e = e;
    L40:
        FLogger.a.e("ManualCacheCleanUi", "manual cache clean failed", e);
        r40 = null;
    L18:
        e = e;
        r41 = r42;
        r2 = r43;
        r115 = r117;
        r114 = r116;
        goto L40
    L20:
        ResultKt.throwOnFailure(r0);
        IAppDiskService.Companion r45 = IAppDiskService.a;     // Catch: Exception -> L38
        r3.L$0 = r2;     // Catch: Exception -> L38
        r41 = r29;
        r3.L$1 = r41;     // Catch: Exception -> L36
        r115 = r26;
        r3.J$0 = r115;     // Catch: Exception -> L34
        r114 = r30;
        r3.J$1 = r114;     // Catch: Exception -> L32
        r3.label = 1;     // Catch: Exception -> L32
        r0 = r45.b(r2, r3);     // Catch: Exception -> L32
        if (r0 != r5) goto L30;
        return r5;
    L34:
        e = e;
    L35:
        r114 = r30;
    L36:
        e = e;
        r115 = r26;
    L38:
        e = e;
        r115 = r26;
        r41 = r29;
    L7:
        r3 = new ManualCacheCleanUiController$executeAndReportClean$1(r25, r32);
        goto L8
    }

    public static final void c(Ref.ObjectRef<Job> r13, Fragment r14, ItemTextArrow r15, Function1<? super Long, String> r16, String r17, by7.e r18, boolean r19) {
        r13.element = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14.getViewLifecycleOwner()), null, null, new ManualCacheCleanUiController$bind$launchCacheSizeQuery$1(r15, r19, r14, r16, r13, r17, r18, null), 3, null);
    }

    public static final Object a(ManualCacheCleanUiController r21, Fragment r22, ItemTextArrow r23, long r24, String r26, String r27, Function1 r28, Continuation r29) {
        r21.getClass();
        if ((r29 instanceof ManualCacheCleanUiController$clean$1) == false) goto L7;
        ManualCacheCleanUiController$clean$1 r1 = (ManualCacheCleanUiController$clean$1) r29;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r1.J$0;
        Function1 r6 = (Function1) r1.L$3;
        String r7 = (String) r1.L$2;
        ItemTextArrow r8 = (ItemTextArrow) r1.L$1;
        Fragment r9 = (Fragment) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        Function1 r10 = r6;
        Object r11 = r0;
        String r12 = r7;
        long r13 = r5;
        ItemTextArrow r14 = r8;
        Fragment r15 = r9;
    L26:
        a r16 = (a) r11;     // Catch: Throwable -> L93
        if (JobKt.isActive(r1.getContext()) == false) goto L33;
        if (r15.isAdded() == false) goto L33;
        r14.V5();
    L33:
        if (r16 != null) goto L41;
        FLogger.a.w("ManualCacheCleanUi", "manual cache clean UI wait timeout operationId=" + r12 + " timeoutMs=" + r13);
        if (JobKt.isActive(r1.getContext()) == false) goto L114;
        if (r15.isAdded() == false) goto L114;
        t19.s r17 = t19.s.a;
        Context r18 = r15.getContext();
        r17.getClass();
        t19.s.b(r18, 2131906594, false);
    L114:
        return Unit.INSTANCE;
    L41:
        if (JobKt.isActive(r1.getContext()) == false) goto L92;
        if (r15.isAdded() == false) goto L92;
        com.larus.disk.api.j r19 = r16.a;
        if (r19 != null) goto L51;
        long r20 = r16.b;
        if (r20 < 0) goto L50;
        f(r14, r20, r10);
    L50:
        t19.s r25 = t19.s.a;
        Context r30 = r15.getContext();
        r25.getClass();
        t19.s.b(r30, 2131906594, false);
        return Unit.INSTANCE;
    L51:
        long r110 = r19.b;
        if (r110 < 0) goto L58;
        long r111 = r19.c;
        if (r111 < 0) goto L58;
        if (r111 >= r110) goto L58;
        boolean r31 = true;
    L60:
        if (r19.a != ManualCacheCleanStatus.PARTIAL) goto L63;
        if (r31 == false) goto L63;
        long r112 = 0;
    L65:
        if (r112 < 0) goto L67;
        f(r14, r112, r10);
    L67:
        int r32 = b.a[r19.a.ordinal()];
        if (r32 == 1) goto L85;
        if (r32 != 2) goto L72;
        if (r31 == false) goto L83;
        t19.s r33 = t19.s.a;
        Context r34 = r15.getContext();
        r33.getClass();
        t19.s.o(r34, 2131906595, false);
    L116:
        return Unit.INSTANCE;
    L83:
        t19.s r35 = t19.s.a;
        Context r36 = r15.getContext();
        r35.getClass();
        t19.s.b(r36, 2131906594, false);
        goto L116
    L72:
        if (r32 != 3) goto L74;
    L80:
        t19.s r37 = t19.s.a;
        Context r38 = r15.getContext();
        r37.getClass();
        t19.s.b(r38, 2131906594, false);
        goto L116
    L74:
        if (r32 == 4) goto L80;
        if (r32 == 5) goto L80;
        throw new NoWhenBranchMatchedException();
    L85:
        if (r19.b <= 0) goto L87;
    L89:
        t19.s r39 = t19.s.a;
        Context r40 = r15.getContext();
        r39.getClass();
        t19.s.o(r40, 2131906595, false);
        goto L116
    L87:
        if (r19.c > 0) goto L89;
        t19.s.a.g(r15.getContext(), 2131906596, false);
    L63:
        r112 = r19.c;
    L58:
        r31 = false;
    L92:
        return Unit.INSTANCE;
    L93:
        th = th;
    L100:
        if (JobKt.isActive(r1.getContext()) == true) goto L102;
    L104:
        throw th;
    L102:
        if (r15.isAdded() == false) goto L104;
        r14.V5();
    L14:
        th = th;
        r14 = r8;
        r15 = r9;
        goto L100
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        long r113 = SystemClock.elapsedRealtime();
        r23.c6();
        Deferred r41 = BuildersKt.async$default(b, null, null, new ManualCacheCleanUiController$clean$terminalTask$1(r24, r26, r27, r113, null), 3, null);
        r13 = d();
        ManualCacheCleanUiController$clean$outcome$1 r42 = new ManualCacheCleanUiController$clean$outcome$1(r41, null);     // Catch: Throwable -> L97
        r15 = r22;
        r1.L$0 = r15;     // Catch: Throwable -> L95
        r14 = r23;
        r1.L$1 = r14;     // Catch: Throwable -> L93
        r12 = r26;
        r1.L$2 = r12;     // Catch: Throwable -> L93
        r10 = r28;
        r1.L$3 = r10;     // Catch: Throwable -> L93
        r1.J$0 = r13;     // Catch: Throwable -> L93
        r1.label = 1;     // Catch: Throwable -> L93
        r11 = TimeoutKt.c(r13, r42, r1);     // Catch: Throwable -> L93
        if (r11 != r3) goto L26;
        return r3;
    L95:
        th = th;
    L96:
        r14 = r23;
    L97:
        th = th;
        r15 = r22;
    L7:
        r1 = new ManualCacheCleanUiController$clean$1(r21, r29);
        goto L8
    }
}
