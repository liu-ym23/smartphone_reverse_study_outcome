package com.obric.aee.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class EngineBridge$_pipeDispatch$1 extends FunctionReferenceImpl implements Function1<byte[], Unit> {
    EngineBridge$_pipeDispatch$1(Object r10) {
        super(1, r10, EngineBridge.class, "onEntryFinish", "onEntryFinish([B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        EngineBridge.access$onEntryFinish((EngineBridge) this.receiver, r10);
    }
}
