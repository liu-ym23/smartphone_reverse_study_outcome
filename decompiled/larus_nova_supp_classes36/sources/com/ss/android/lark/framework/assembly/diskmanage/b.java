package com.ss.android.lark.framework.assembly.diskmanage;

import ebb.g;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class b implements d {
    public final Provider<Set<g>> a;

    @Override // com.ss.android.lark.framework.assembly.diskmanage.d
    public final List<g> a() {
        return CollectionsKt.toList((Iterable) this.a.get());
    }

    @Inject
    public b(Provider<Set<g>> r2) {
        Intrinsics.checkNotNullParameter(r2, "cleanTasks");
        this.a = r2;
    }
}
