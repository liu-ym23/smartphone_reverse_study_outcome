package com.obric.aikernel.model.cloud.fa;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.fa.FaModelRequest$twoStepSlmModelFunctions$3", f = "FaModelRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FaModelRequest$twoStepSlmModelFunctions$3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<File> $uploadFile;
    int label;

    FaModelRequest$twoStepSlmModelFunctions$3(Ref.ObjectRef<File> r10, Continuation<? super FaModelRequest$twoStepSlmModelFunctions$3> r11) {
        this.$uploadFile = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FaModelRequest$twoStepSlmModelFunctions$3(this.$uploadFile, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((FaModelRequest$twoStepSlmModelFunctions$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r10);
        this.$uploadFile.element.delete();     // Catch: Exception -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        AIKLog.INSTANCE.e("FaModelRequest", "delete file failed", e);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
