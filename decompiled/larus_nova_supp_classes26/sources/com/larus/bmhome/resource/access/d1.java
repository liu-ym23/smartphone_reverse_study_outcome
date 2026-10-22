package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d1 implements l0 {
    public final ResourcePhase a;

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "validate";
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return false;
    }

    public d1() {
        this.a = ResourcePhase.VALIDATE;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r5, Continuation<? super g> r6) {
        j0 r7 = r5.c;
        if ((r7 instanceof j0.b) == false) goto L8;
        if (StringsKt.isBlank(((j0.b) r7).b) == false) goto L21;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L26;
        return new g.a(0);
    L26:
        return new g.b(new r("validate", "invalid_resource_input", "resource input is invalid", null));
    L21:
        r8 = true;
        goto L23
    L8:
        if ((r7 instanceof j0.a) == false) goto L13;
        if (StringsKt.isBlank(((j0.a) r7).b) == true) goto L22;
    L13:
        if ((r7 instanceof j0.c) == false) goto L18;
        if (StringsKt.isBlank(((j0.c) r7).b) == true) goto L22;
    L18:
        if ((r7 instanceof j0.d) == false) goto L28;
        if (StringsKt.isBlank(((j0.d) r7).b) == true) goto L22;
    L28:
        throw new NoWhenBranchMatchedException();
    }
}
