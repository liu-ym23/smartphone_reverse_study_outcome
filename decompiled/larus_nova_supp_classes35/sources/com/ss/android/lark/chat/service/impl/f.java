package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class f implements m6b.a {
    public final List<a> a;
    public final b b;
    public final m6b.b c;

    public interface a {
        void a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.service.impl.b] */
    @Inject
    public f(m6b.b r2) {
        this.a = new CopyOnWriteArrayList();
        this.b = new b();
        this.c = r2;
    }

    @Override // m6b.a
    public final void L7(a r3) {
        if (((CopyOnWriteArrayList) this.a).contains(r3) == false) goto L5;
        return;
    L5:
        com.ss.android.lark.sdk.f.a(this.a, r3, new com.ss.android.lark.chat.service.impl.a(this));
    }

    @Override // m6b.a
    public final void Oe(a r3) {
        com.ss.android.lark.sdk.f.b(this.a, r3, new c(this));
    }
}
