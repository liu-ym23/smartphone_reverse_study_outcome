package com.obric.assistant.util;

import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledSuspend$2", f = "ObricPersonalContextSettingServiceImpl.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
final class ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ObricPersonalContextSettingServiceImpl this$0;

    public ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledSuspend$2(ObricPersonalContextSettingServiceImpl r1, Continuation<? super ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledSuspend$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledSuspend$2(this.this$0, r3);
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
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        if (((Boolean) r5).booleanValue() != true) goto L17;
        r2 = true;
    L17:
        return Boxing.boxBoolean(r2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IAILabService r6 = (IAILabService) this.this$0.b.getValue();
        if (r6 == null) goto L17;
        AILabSettingItem r3 = AILabSettingItem.ScreenMemory;
        this.label = 1;
        r5 = r6.b(r3, this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
