package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements g {
    public final Set<String> a;
    public final CompositeDisposable b;
    public final Function1<Integer, Unit> c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "notifyDynamicConfigRefresh");
        this.c = r2;
        this.a = new LinkedHashSet();
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.a.contains(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final void a(List<String> r5, int r6) {
        jy0.b.c("MultiLocalComponentManager", "updateLocalComponent with tag: " + r5, null, 4);
        this.a.clear();
        Set<String> r0 = this.a;
        if (r5 != null) goto L6;
        r5 = CollectionsKt.emptyList();
    L6:
        r0.addAll(r5);
        this.c.invoke(Integer.valueOf(r6));
    }
}
