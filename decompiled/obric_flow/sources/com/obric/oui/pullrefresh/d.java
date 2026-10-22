package com.obric.oui.pullrefresh;

import kotlin.Function;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements f, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f14248a;

    public d(Function3 r5) {
        this.f14248a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof f) == true) goto L5;
        return false;
    L5:
        if ((r5 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f14248a, ((FunctionAdapter) r5).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f14248a;
    }

    public final int hashCode() {
        return this.f14248a.hashCode();
    }
}
