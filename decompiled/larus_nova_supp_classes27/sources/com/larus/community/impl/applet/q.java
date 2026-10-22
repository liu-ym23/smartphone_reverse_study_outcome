package com.larus.community.impl.applet;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements Predicate {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ q(p r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return ((Boolean) this.a.invoke(r2)).booleanValue();
    }
}
