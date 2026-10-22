package com.ivy.ivykit.plugin.impl.utils;

import com.lynx.tasm.behavior.XElementBehavior;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rc.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {
    public static List d(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        List<com.lynx.tasm.behavior.a> r10 = new XElementBehavior().create();
        r10.addAll(CollectionsKt.toList(com.ivy.ivykit.plugin.impl.render.c.f9523a.values()));
        return r10;
    }

    @Override // rc.c
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
    }
}
