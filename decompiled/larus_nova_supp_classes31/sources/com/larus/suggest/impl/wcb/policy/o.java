package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements y {
    public static final o b = null;
    public final /* synthetic */ w a;

    static {
        b = new o();
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void a(com.larus.suggest.impl.wcb.request.f r2, NexPulseResponseData r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a.a(r2, r3, r4);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String b(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.b(r2);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long c(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.c(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void d(com.larus.suggest.impl.wcb.request.f r2, NexPulseConf r3) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        this.a.d(r2, r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long e(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.e(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long f(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.f(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long g(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.g(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void h(com.larus.suggest.impl.wcb.request.f r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "snapshot");
        this.a.h(r8, r9, r11);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long i(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return this.a.i(r3);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String j(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.j(r2);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final v k(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return this.a.k(r2);
    }

    public o() {
        this.a = new w(new n());
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final boolean l(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return false;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void m(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "conversationId");
    }
}
