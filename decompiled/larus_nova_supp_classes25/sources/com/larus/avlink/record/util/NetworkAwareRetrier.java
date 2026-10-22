package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.network.NetConnectionTypeProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NetworkAwareRetrier {
    public static final long[] m = null;
    public final CoroutineScope a;
    public final String b;
    public final long[] c;
    public final CoroutineDispatcher d;
    public final Function0<Boolean> e;
    public final Function0<Unit> f;
    public final Function2<s, Continuation<? super RetryDecision>, Object> g;
    public volatile boolean h;
    public volatile boolean i;
    public Job j;
    public p k;
    public final Channel<Unit> l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RetryDecision.values().length];
            r0[RetryDecision.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RetryDecision.TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RetryDecision.RETRY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        m = new long[]{5000, 15000, 45000, 120000, 300000};
    }

    public final void b() {
        if (this.h == false) goto L7;
        n1.d(this.b, "skip execute, already succeeded");
        return;
    L7:
        if (this.i == false) goto L10;
        n1.d(this.b, "skip execute, already terminated");
        return;
    L10:
        Job r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L13;
    L15:
        if (r1 == false) goto L18;
        n1.d(this.b, "skip execute, retry loop already running");
        return;
    L18:
        this.j = BuildersKt.launch$default(this.a, this.d, null, new NetworkAwareRetrier$execute$1(this, null), 2, null);
        return;
    L13:
        if (r0.isActive() != true) goto L15;
        r1 = true;
        goto L15
    }

    public final void c() {
        p r0 = this.k;
        if (r0 == null) goto L5;
        NetConnectionTypeProvider.d.remove(r0);
    L5:
        this.k = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0131 -> B:14:0x0037). Please report as a decompilation issue!!! */
    public static final Object a(NetworkAwareRetrier r11, CoroutineScope r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof NetworkAwareRetrier$runLoop$1) == false) goto L7;
        NetworkAwareRetrier$runLoop$1 r0 = (NetworkAwareRetrier$runLoop$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        long r6 = r0.J$0;
        int r15 = r0.I$0;
        CoroutineScope r4 = (CoroutineScope) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L76
    L14:
        CoroutineScope r10 = r4;
        int r5 = r15;
        r12 = r10;
        if (r14 == null) goto L63;
        boolean r16 = true;
    L64:
        if (r16 == false) goto L66;
        RetryTrigger r17 = RetryTrigger.NETWORK_RECOVERY;     // Catch: Throwable -> L76
    L27:
        int r7 = 0;
    L29:
        if (CoroutineScopeKt.isActive(r12) == true) goto L31;
    L74:
        r11.c();
        return Unit.INSTANCE;
    L31:
        if (r11.h == true) goto L74;
        if (r11.i == true) goto L74;
        if (((Boolean) r11.e.invoke()).booleanValue() == true) goto L37;
        n1.d(r11.b, "shouldRetry false, stop");     // Catch: Throwable -> L76
        goto L74
    L37:
        s r8 = new s(r5, r17, r7);     // Catch: Throwable -> L76
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L45
        Function2<s, Continuation<? super RetryDecision>, Object> r19 = r11.g;     // Catch: Throwable -> L45
        r0.L$0 = r12;     // Catch: Throwable -> L45
        r0.I$0 = r5;     // Catch: Throwable -> L45
        r0.label = 1;     // Catch: Throwable -> L45
        r14 = r19.invoke(r8, r0);     // Catch: Throwable -> L45
        if (r14 == r2) goto L86;
        int r110 = r5;
        r4 = r12;
        int r111 = r110;
    L42:
        Object r112 = Result.constructor-impl((RetryDecision) r14);     // Catch: Throwable -> L20
    L47:
        Throwable r9 = Result.exceptionOrNull-impl(r112);     // Catch: Throwable -> L76
        if (r9 == null) goto L50;
        n1.b(r11.b, "retry action error: " + r9.getMessage());     // Catch: Throwable -> L76
    L50:
        RetryDecision r20 = RetryDecision.RETRY;     // Catch: Throwable -> L76
        if (Result.isFailure-impl(r112) == false) goto L53;
        r112 = r20;
    L53:
        int r113 = b.a[((RetryDecision) r112).ordinal()];     // Catch: Throwable -> L76
        if (r113 == 1) goto L71;
        if (r113 != 2) goto L57;
        r11.i = true;     // Catch: Throwable -> L76
        n1.e(r11.b, "retry action terminal error, stop retrying");     // Catch: Throwable -> L76
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L70:
        Unit r21 = r114;
        r11.c();
        return r21;
    L57:
        if (r113 != 3) goto L68;
        long[] r115 = r11.c;     // Catch: Throwable -> L76
        r6 = r115[RangesKt.coerceAtMost(r111, ArraysKt.getLastIndex(r115))];     // Catch: Throwable -> L76
        r15 = r111 + 1;     // Catch: Throwable -> L76
        n1.d(r11.b, "retry later, delayMs=" + r6);     // Catch: Throwable -> L76
        NetworkAwareRetrier$runLoop$wokenByNetwork$1 r116 = new NetworkAwareRetrier$runLoop$wokenByNetwork$1(r11, null);     // Catch: Throwable -> L76
        r0.L$0 = r4;     // Catch: Throwable -> L76
        r0.I$0 = r15;     // Catch: Throwable -> L76
        r0.J$0 = r6;     // Catch: Throwable -> L76
        r0.label = 2;     // Catch: Throwable -> L76
        r14 = TimeoutKt.c(r6, r116, r0);     // Catch: Throwable -> L76
        if (r14 != r2) goto L14;
        return r2;
    L68:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L76
    L71:
        r11.h = true;     // Catch: Throwable -> L76
        n1.d(r11.b, "retry action success");     // Catch: Throwable -> L76
        r11.f.invoke();     // Catch: Throwable -> L76
        r114 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L20:
        Throwable th = th;
        CoroutineScope r117 = r4;
        r5 = r111;
        r12 = r117;
    L46:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L76
        r112 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L76
        int r118 = r5;
        r4 = r12;
        r111 = r118;
        goto L47
    L86:
        return r2;
    L45:
        th = th;
        goto L46
    L66:
        r17 = RetryTrigger.BACKOFF;     // Catch: Throwable -> L76
        r7 = (int) (r6 / 1000);     // Catch: Throwable -> L76
        goto L29
    L63:
        r16 = false;
    L76:
        th = move-exception;
        r11.c();
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r111 = r0.I$0;
        r4 = (CoroutineScope) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L20
        goto L42
    L22:
        ResultKt.throwOnFailure(r14);
        if (r11.k != null) goto L26;
        p r119 = new p(r11);
        r11.k = r119;
        NetConnectionTypeProvider.d.addIfAbsent(r119);
    L26:
        r17 = RetryTrigger.INITIAL;
        r5 = 0;
    L7:
        r0 = new NetworkAwareRetrier$runLoop$1(r11, r13);
        goto L8
    }

    public NetworkAwareRetrier(CoroutineScope r5, String r6, Function0 r7, d r8, Function2 r9, int r10) {
        if ((r10 & 4) == 0) goto L5;
        long[] r0 = m;
    L7:
        if ((r10 & 8) == 0) goto L9;
        CoroutineDispatcher r2 = Dispatchers.getIO();
    L11:
        if ((r10 & 16) == 0) goto L13;
        r7 = new n();
    L13:
        Function0<Unit> r11 = r8;
        if ((r10 & 32) == 0) goto L16;
        r11 = new o();
    L16:
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "tag");
        Intrinsics.checkNotNullParameter(r0, "backoffDelaysMs");
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        Intrinsics.checkNotNullParameter(r7, "shouldRetry");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r9, "action");
        this.a = r5;
        this.b = r6;
        this.c = r0;
        this.d = r2;
        this.e = r7;
        this.f = r11;
        this.g = r9;
        this.l = ChannelKt.Channel$default(-1, null, null, 6, null);
        return;
    L9:
        r2 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
