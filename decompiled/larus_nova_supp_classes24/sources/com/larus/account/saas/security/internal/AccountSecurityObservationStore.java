package com.larus.account.saas.security.internal;

import com.larus.account.saas.runtime.internal.util.GsonHolder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AccountSecurityObservationStore {
    public final Lazy a;
    public final CopyOnWriteArraySet<String> b;
    public final ConcurrentHashMap<String, e48.e> c;
    public final ConcurrentHashMap<String, Long> d;

    public static final class a {
        public final e48.e a;
        public final long b;
        public final long c;
        public final Long d;

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
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            e48.e r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            long r3 = this.b;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r5 = this.c;
            int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
            Long r7 = this.d;
            if (r7 == null) goto L11;
            r1 = r7.hashCode();
        L11:
            return r6 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "BrowsedChatMessageCountResult(state=" + this.a + ", threshold=" + this.b + ", totalCount=" + this.c + ", reportCount=" + this.d + ')';
        }

        public a(e48.e r1, long r2, long r4, Long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }
    }

    public AccountSecurityObservationStore() {
        this.a = LazyKt.lazy(AccountSecurityObservationStore$sp$2.INSTANCE);
        this.b = new CopyOnWriteArraySet();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public final e48.e a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        Object r1 = null;
        if (StringsKt.isBlank(r5) == false) goto L5;
        return null;
    L5:
        e48.e r0 = this.c.get(r5);
        if (r0 == null) goto L9;
        return r0;
    L9:
        if (this.b.contains(r5) == false) goto L11;
        return null;
    L11:
        String r2 = ((d48.f.b) this.a.getValue()).getString("account_security_observation_" + r5);
        if (StringsKt.isBlank(r2) == false) goto L28;
    L23:
        if (r1 == null) goto L25;
        this.c.put(r5, (e48.e) r1);
    L27:
        return this.c.get(r5);
    L25:
        this.b.add(r5);
        goto L27
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        Lazy r4 = GsonHolder.a;     // Catch: Throwable -> L16
        Object r6 = Result.constructor-impl((e48.e) GsonHolder.a(r2, e48.e.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r6) == true) goto L22;
        r1 = r6;
    L22:
        r1 = (e48.e) r1;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final boolean b(e48.d r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        String r8 = r6.a.getValue() + '_' + r6.b;
        long r0 = System.currentTimeMillis();
        Long r2 = this.d.get(r8);
        if (r2 != null) goto L6;
        r2 = 0L;
    L6:
        if (r2.longValue() <= r0) goto L9;
        return true;
    L9:
        this.d.put(r8, Long.valueOf(r0 + r7));
        return false;
    }
}
