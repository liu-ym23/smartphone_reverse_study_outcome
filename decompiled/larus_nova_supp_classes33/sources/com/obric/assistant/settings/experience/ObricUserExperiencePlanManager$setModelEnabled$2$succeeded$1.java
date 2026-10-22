package com.obric.assistant.settings.experience;

import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1", f = "ObricUserExperiencePlanManager.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $enabled;
    private /* synthetic */ Object L$0;
    int label;

    public ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1(boolean r1, Continuation<? super ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1> r2) {
        this.$enabled = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1 r0 = new ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1(this.$enabled, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L24
    L19:
        if (((Boolean) r6).booleanValue() == true) goto L22;
    L21:
        r3 = false;
    L22:
        Object r7 = Result.constructor-impl(Boxing.boxBoolean(r3));     // Catch: Throwable -> L24
    L26:
        Boolean r2 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r7) == true) goto L29;
        return r7;
    L29:
        return r2;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        boolean r9 = this.$enabled;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        IObricNetworkService r5 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L24
        if (r5 == null) goto L21;
        if (r9 == false) goto L14;
        boolean r10 = true;
    L15:
        this.label = 1;     // Catch: Throwable -> L24
        r6 = r5.r(r10, this);     // Catch: Throwable -> L24
        if (r6 != r0) goto L19;
        return r0;
    L14:
        r10 = false;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
