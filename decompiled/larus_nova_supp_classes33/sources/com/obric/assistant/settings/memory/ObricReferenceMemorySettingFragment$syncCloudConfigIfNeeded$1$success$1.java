package com.obric.assistant.settings.memory;

import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1", f = "ObricReferenceMemorySettingFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1(Continuation<? super ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricPersonalContextSettingApiDelegate r5 = ObricPersonalContextSettingApiDelegate.b;
        this.label = 1;
        r4 = r5.r(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
