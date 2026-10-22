package com.obric.assistant.special_input.instruction;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadAppFilterPolicy$2", f = "PanelInstructionLoader.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
final class PanelInstructionLoader$loadAppFilterPolicy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.obric.assistant.settings.d>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PanelInstructionLoader$loadAppFilterPolicy$2(Continuation<? super PanelInstructionLoader$loadAppFilterPolicy$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PanelInstructionLoader$loadAppFilterPolicy$2 r0 = new PanelInstructionLoader$loadAppFilterPolicy$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.obric.assistant.settings.d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L21
    L15:
        com.obric.assistant.settings.d r7 = (com.obric.assistant.settings.d) r6;     // Catch: Throwable -> L21
        if (r7 != null) goto L19;
    L18:
        r7 = new com.obric.assistant.settings.d(0);     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L21
    L23:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L26;
        FLogger.a.e("PanelInstructionLoader", "loadAppFilterPolicy failed: " + r2.getMessage());
    L26:
        com.obric.assistant.settings.d r3 = new com.obric.assistant.settings.d(0);
        if (Result.isFailure-impl(r8) == true) goto L29;
        return r8;
    L29:
        return r3;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        IObricAutoGuiSettingsApi r11 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);     // Catch: Throwable -> L21
        if (r11 == null) goto L18;
        this.label = 1;     // Catch: Throwable -> L21
        r6 = r11.b(this);     // Catch: Throwable -> L21
        if (r6 != r0) goto L15;
        return r0;
    L21:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
