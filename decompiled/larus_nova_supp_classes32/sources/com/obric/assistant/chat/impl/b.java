package com.obric.assistant.chat.impl;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements Predicate {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ b(a r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return ((Boolean) this.a.invoke(r2)).booleanValue();
    }
}
