package com.larus.suggest.impl.wcb.request;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.common.apphost.AppHost;
import com.larus.suggest.impl.wcb.policy.y;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final b a = null;
    public static final CoroutineScope b = null;
    public static final Map<a, Deferred<e>> c = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "RequestKey(userId=" + this.a + ", scope=" + this.b + ", botId=" + this.c + ", scene=" + this.d + ", requestScene=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r4, "botId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        c = new LinkedHashMap();
    }

    public static a c(f r7) {
        return new a(r7.a, r7.f.a.h().j(r7), r7.c, r7.f.a.getScene(), r7.f.f);
    }

    public static final void b(f r6, e r7) {
        y r0 = r6.f.a.h();
        NexPulseResponseData r1 = r7.getResponse();
        e.c r2 = null;
        if (r1 == null) goto L5;
        NexPulseConf r3 = r1.getConf();
    L6:
        r0.d(r6, r3);
        if ((r7 instanceof e.c) == false) goto L9;
        r2 = (e.c) r7;
    L9:
        if (r2 == null) goto L26;
        NexPulseResponseData r8 = r2.a;
        if (r8 == null) goto L28;
        long r4 = AppHost.a.getAppClock().currentTimeMillis() / 1000;
        if (r8.isValid() == false) goto L27;
        NexPulseConf r5 = r8.getConf();
        if (r5 == null) goto L20;
        Long r9 = r5.getExpireTime();
        if (r9 == null) goto L20;
        long r10 = r9.longValue();
    L22:
        if (r10 <= r4) goto L29;
        r0.a(r6, r8, System.currentTimeMillis());
        FLogger.a.d("WcbLog", "[network] cached scene=" + r6.f.a.getScene() + " exec=" + r6.e);
        return;
    L29:
        return;
    L20:
        r10 = 0;
        goto L22
    L27:
        return;
    L28:
        return;
    L26:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final Object a(b r11, f r12, long r13, Continuation r15) {
        r11.getClass();
        if ((r15 instanceof WcbNetworkRequester$fetch$1) == false) goto L7;
        WcbNetworkRequester$fetch$1 r0 = (WcbNetworkRequester$fetch$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r12 = (f) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        Pair r17 = (Pair) r14;
        NexPulseResponseData r18 = (NexPulseResponseData) r17.component1();
        com.larus.suggest.impl.repo.a.C0035a r19 = (com.larus.suggest.impl.repo.a.C0035a) r17.component2();
        if (r19 == null) goto L20;
        r16 = new e.b(r19, r18);
    L24:
        FLogger.a.d("WcbLog", "[pipeline] network.end chat=" + r12.d + " exec=" + r12.e + " result=" + r16.getClass().getSimpleName());
    L25:
        return r16;
    L20:
        if (r18 == null) goto L22;
        Object r110 = new e.c(r18);
    L23:
        r16 = r110;
        goto L24
    L22:
        r110 = e.a.a;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        z r111 = r12.f.a;
        r111.h().h(r12, r13, System.currentTimeMillis());
        FLogger.a.d("WcbLog", "[pipeline] network.start chat=" + r12.d + " exec=" + r12.e);
        CoroutineDispatcher r112 = Dispatchers.getIO();
        WcbNetworkRequester$fetch$2 r113 = new WcbNetworkRequester$fetch$2(r12, r111, null);
        r0.L$0 = r12;
        r0.label = 1;
        r14 = BuildersKt.withContext(r112, r113, r0);
        if (r14 != r16) goto L17;
    L7:
        r0 = new WcbNetworkRequester$fetch$1(r11, r15);
        goto L8
    }
}
