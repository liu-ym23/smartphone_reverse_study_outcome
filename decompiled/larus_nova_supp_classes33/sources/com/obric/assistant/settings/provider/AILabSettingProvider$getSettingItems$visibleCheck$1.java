package com.obric.assistant.settings.provider;

import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.AILabSettingProvider$getSettingItems$visibleCheck$1", f = "AILabSettingProvider.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class AILabSettingProvider$getSettingItems$visibleCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ IAILabService $aiLabService;
    int label;

    public AILabSettingProvider$getSettingItems$visibleCheck$1(IAILabService r1, Continuation<? super AILabSettingProvider$getSettingItems$visibleCheck$1> r2) {
        this.$aiLabService = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AILabSettingProvider$getSettingItems$visibleCheck$1(this.$aiLabService, r3);
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
    L13:
        Boolean r6 = (Boolean) r5;
    L15:
        FLogger.a.d("AILabSettingProvider", "aiLabService?.isSettingEnabled:" + r6);
        return Boxing.boxBoolean(Intrinsics.areEqual(r6, Boxing.boxBoolean(true)));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IAILabService r7 = this.$aiLabService;
        if (r7 == null) goto L14;
        this.label = 1;
        r5 = r7.a(this);
        if (r5 != r0) goto L13;
        return r0;
    L14:
        r6 = null;
        goto L15
    }
}
