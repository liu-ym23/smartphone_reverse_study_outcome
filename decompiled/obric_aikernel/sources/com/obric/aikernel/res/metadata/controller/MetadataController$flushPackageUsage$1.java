package com.obric.aikernel.res.metadata.controller;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.metadata.controller.MetadataController$flushPackageUsage$1", f = "MetadataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MetadataController$flushPackageUsage$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MetadataController this$0;

    MetadataController$flushPackageUsage$1(MetadataController r10, Continuation<? super MetadataController$flushPackageUsage$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    public static /* synthetic */ void e(Function2 r10, Object r11, Object r12) {
        invokeSuspend$lambda$0(r10, r11, r12);
    }

    private static final void invokeSuspend$lambda$0(Function2 r10, Object r11, Object r12) {
        r10.invoke(r11, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MetadataController$flushPackageUsage$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((MetadataController$flushPackageUsage$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r10);
        MetadataController.c r11 = this.this$0.p().a().get("package");
        if (r11 == null) goto L10;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r12 = r11.a();
        if (r12 == null) goto L10;
        final AnonymousClass1 r13 = AnonymousClass1.INSTANCE;
        r12.forEach(new c(r13));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
