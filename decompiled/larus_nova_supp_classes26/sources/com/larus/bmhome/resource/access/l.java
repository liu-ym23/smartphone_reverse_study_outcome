package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements l0 {
    public final ResourcePhase a;
    public final List<String> b;
    public final boolean c;

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "remote_direct";
    }

    public l() {
        this.a = ResourcePhase.REMOTE_DIRECT;
        this.b = CollectionsKt.listOf("remote_policy");
        this.c = true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.c;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r2.h == null) goto L5;
    L7:
        return false;
    L5:
        if (s.a(r2.c.getType()) == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r9, Continuation<? super g> r10) {
        j0 r2 = r9.c;
        if ((r2 instanceof j0.d) == false) goto L6;
        f0 r11 = new f0(r9.a.c, r2, ((j0.d) r2).b, null, null, null, 56);
    L15:
        if (r11 == null) goto L18;
        return new g.d(r11);
    L18:
        return g.e.a;
    L6:
        if ((r2 instanceof j0.c) == false) goto L8;
    L14:
        r11 = null;
        goto L15
    L8:
        if ((r2 instanceof j0.b) == true) goto L14;
        if ((r2 instanceof j0.a) == true) goto L14;
        throw new NoWhenBranchMatchedException();
    }
}
