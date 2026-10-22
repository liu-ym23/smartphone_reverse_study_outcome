package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k implements z {
    public final lx9.d a;
    public final int b;
    public final b c;
    public final i d;
    public final j e;
    public final l f;
    public final c g;
    public final MainConversationDisplayFrequencyPolicy h;
    public final d i;
    public final a j;
    public final e k;
    public final f l;

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final c a() {
        return this.g;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final b b() {
        return this.c;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final d0 c() {
        return this.f;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final d d() {
        return this.i;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final a e() {
        return this.j;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final b0 f() {
        return this.e;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final e g() {
        return this.k;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final t getDisplay() {
        return this.h;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final lx9.d getKey() {
        return this.a;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final int getScene() {
        return this.b;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final y h() {
        return this.d;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final f i() {
        return this.l;
    }

    public k(lx9.d r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a = r2;
        this.b = r3;
        this.c = b.a;
        this.d = i.b;
        this.e = j.a;
        this.f = l.a;
        this.g = c.a;
        this.h = MainConversationDisplayFrequencyPolicy.a;
        this.i = d.a;
        this.j = a.a;
        this.k = e.a;
        this.l = f.a;
    }
}
