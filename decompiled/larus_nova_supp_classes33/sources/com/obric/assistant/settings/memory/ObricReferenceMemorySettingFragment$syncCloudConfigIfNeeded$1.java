package com.obric.assistant.settings.memory;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1", f = "ObricReferenceMemorySettingFragment.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricReferenceMemorySettingFragment this$0;

    public ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1(ObricReferenceMemorySettingFragment r1, Continuation<? super ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) r5).booleanValue() == false) goto L15;
        ObricReferenceMemorySettingFragment r6 = this.this$0;
        int r2 = ObricReferenceMemorySettingFragment.l;
        r6.V90().refresh();
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1 r3 = new ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1$success$1(null);
        this.label = 1;
        r5 = BuildersKt.withContext(r7, r3, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
