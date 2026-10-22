package com.obric.aikernel.model_preset.impl.ipc;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_preset.impl.ICallback;
import com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt;
import com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecryptKt;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_preset.impl.ipc.PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1", f = "PresetDecryptIPCProvider.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
final class PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICallback $callback;
    final /* synthetic */ List<String> $modelNames;
    int label;

    PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1(List<String> r10, ICallback r11, Continuation<? super PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1> r12) {
        this.$modelNames = r10;
        this.$callback = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1(this.$modelNames, this.$callback, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PresetDecryptIPCProvider$binder$2$1$decryptPresetModelWithCallback$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        ICallback r13 = this.$callback;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        if (r13 == null) goto L18;
        r13.onComplete();     // Catch: Throwable -> L21
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Object r16 = Result.m32constructorimpl(r15);     // Catch: Throwable -> L21
    L23:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L27;
        AIKLog.INSTANCE.e("PresetDecryptIPCProvider", "decryptPresetModelWithCallback failed: " + r17, r17);
    L27:
        if (Result.m39isSuccessimpl(r16) == false) goto L30;
        Unit r18 = (Unit) r16;
        AIKLog.INSTANCE.d("PresetDecryptIPCProvider", "decryptPresetModelWithCallback: success");
    L30:
        return Unit.INSTANCE;
    L18:
        r15 = null;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IModelPresetDecrypt r20 = IModelPresetDecryptKt.getModelPresetDecrypt();
        List<String> r21 = this.$modelNames;
        if (r21 != null) goto L11;
        r21 = CollectionsKt.emptyList();
    L11:
        this.label = 1;
        if (r20.waitingDecrypting(r21, this) != r11) goto L14;
        return r11;
    }
}
