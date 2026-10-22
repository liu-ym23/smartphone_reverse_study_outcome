package com.obric.flow.cardlistpage.mvi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f11530a;

    public b(Function2 r5) {
        this.f11530a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        Object r11 = this.f11530a.mo2invoke(r5, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
