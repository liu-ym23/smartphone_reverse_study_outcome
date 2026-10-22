package com.obric.capabilitykit;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wia.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class AtomicCapabilitySdk$b implements AtomicCapabilitySdk$a {
    public final /* synthetic */ Function1<n, Unit> a;

    public AtomicCapabilitySdk$b(Function1<? super n, Unit> r1) {
        this.a = r1;
    }

    @Override // com.obric.capabilitykit.AtomicCapabilitySdk$a
    public final void a() {
        this.a.invoke(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE));
    }
}
