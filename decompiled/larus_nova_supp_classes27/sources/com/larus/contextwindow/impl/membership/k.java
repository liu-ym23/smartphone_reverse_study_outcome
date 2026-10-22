package com.larus.contextwindow.impl.membership;

import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final AtomicBoolean a = null;
    public static final a b = null;
    public static final b c = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Lazy<MembershipQuotaRepository> r3 = MembershipQuotaRepository.k;
            MembershipQuotaRepository.b.a().b();
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Lazy<MembershipQuotaRepository> r3 = MembershipQuotaRepository.k;
            MembershipQuotaRepository.b.a().b();
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        public final void S1() {
            Lazy<MembershipQuotaRepository> r0 = MembershipQuotaRepository.k;
            MembershipQuotaRepository.b.a().b();
        }

        public final void b1() {
            Lazy<MembershipQuotaRepository> r0 = MembershipQuotaRepository.k;
            MembershipQuotaRepository.b.a().b();
        }
    }

    static {
        a = new AtomicBoolean(false);
        b = new a();
        c = new b();
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        AccountService r0 = AccountService.a;
        r0.E(b);
        r0.H(c);
    }
}
