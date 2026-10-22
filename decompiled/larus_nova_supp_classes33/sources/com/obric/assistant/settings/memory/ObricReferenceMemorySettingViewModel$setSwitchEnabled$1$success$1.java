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
@DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $storageKey;
    int label;
    final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

    public ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1(ObricReferenceMemorySettingViewModel r1, String r2, boolean r3, Continuation<? super ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1> r4) {
        this.this$0 = r1;
        this.$storageKey = r2;
        this.$enabled = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1(this.this$0, this.$storageKey, this.$enabled, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricPersonalContextSettingApiDelegate r6 = ObricReferenceMemorySettingViewModel.access$getPersonalContextSettingsDelegate(this.this$0);
        String r2 = this.$storageKey;
        boolean r3 = this.$enabled;
        this.label = 1;
        r5 = r6.d(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
