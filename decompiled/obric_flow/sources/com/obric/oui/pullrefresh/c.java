package com.obric.oui.pullrefresh;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements e, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f14247a;

    public c(Function1 r5) {
        this.f14247a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e) == true) goto L5;
        return false;
    L5:
        if ((r5 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f14247a, ((FunctionAdapter) r5).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f14247a;
    }

    public final int hashCode() {
        return this.f14247a.hashCode();
    }
}
