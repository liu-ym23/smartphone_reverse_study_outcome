package com.obric.aee.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class EngineBridge$_pipeDispatch$1 extends FunctionReferenceImpl implements Function1<byte[], Unit> {
    EngineBridge$_pipeDispatch$1(Object r8) {
        super(1, r8, EngineBridge.class, "onEntryFinish", "onEntryFinish([B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(byte[] r3) {
        invoke2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        EngineBridge.access$onEntryFinish((EngineBridge) ZeusTransformUtils.preCheckCast(this.receiver, EngineBridge.class, "com.obric.memorydata.plugin"), r3);
    }
}
