package com.ss.android.lark.officesdk;

import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements e0c.b {
    public com.ss.android.lark.passportc.internal.f0 a;
    public String b;
    public UserSession c;
    public w0 d;

    @Override // e0c.b
    public final e0c.a build() {
        Preconditions.checkBuilderRequirement(this.a, com.ss.android.lark.passportc.internal.f0.class);
        Preconditions.checkBuilderRequirement(this.b, String.class);
        Preconditions.checkBuilderRequirement(this.c, UserSession.class);
        Preconditions.checkBuilderRequirement(this.d, w0.class);
        return new b(this.d, this.a, this.b, this.c);
    }

    public c() {
    }

    @Override // e0c.b
    public final e0c.b a(com.ss.android.lark.passportc.internal.f0 r1) {
        this.a = (com.ss.android.lark.passportc.internal.f0) Preconditions.checkNotNull(r1);
        return this;
    }

    @Override // e0c.b
    public final e0c.b b(String r1) {
        this.b = (String) Preconditions.checkNotNull(r1);
        return this;
    }

    @Override // e0c.b
    public final e0c.b userSession(UserSession r1) {
        this.c = (UserSession) Preconditions.checkNotNull(r1);
        return this;
    }
}
