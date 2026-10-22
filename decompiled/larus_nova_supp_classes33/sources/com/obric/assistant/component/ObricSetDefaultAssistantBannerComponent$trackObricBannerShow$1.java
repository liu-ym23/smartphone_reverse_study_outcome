package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricSystemReporter;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1", f = "ObricSetDefaultAssistantBannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1(Continuation<? super ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1 r0 = new ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        JSONObject r7 = new JSONObject();
        r7.put("banner_type", "obric_perodic_default_guide_banner");
        FLogger.a.i("ObricSetDefaultAssistantBannerComponent", "report obric_banner_show: " + r7);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        IObricSystemReporter.a.getClass();     // Catch: Throwable -> L11
        IObricSystemReporter r1 = IObricSystemReporter.a.a();     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.b("obric_banner_show", r7);     // Catch: Throwable -> L11
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        FLogger.a.w("ObricSetDefaultAssistantBannerComponent", "report obric_banner_show failed. " + r10.getMessage(), r10);
    L17:
        return Unit.INSTANCE;
    L8:
        r8 = null;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
