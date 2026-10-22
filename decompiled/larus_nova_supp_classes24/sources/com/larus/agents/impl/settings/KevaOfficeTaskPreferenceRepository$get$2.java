package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/settings/OfficeTaskPreference;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.settings.KevaOfficeTaskPreferenceRepository$get$2", f = "OfficeTaskPreferenceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KevaOfficeTaskPreferenceRepository$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KevaOfficeTaskPreferenceRepository this$0;

    public KevaOfficeTaskPreferenceRepository$get$2(KevaOfficeTaskPreferenceRepository r1, Continuation<? super KevaOfficeTaskPreferenceRepository$get$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        KevaOfficeTaskPreferenceRepository$get$2 r0 = new KevaOfficeTaskPreferenceRepository$get$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        KevaOfficeTaskPreferenceRepository r10 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Keva r11 = KevaOfficeTaskPreferenceRepository.c(r10);     // Catch: Throwable -> L10
        String r4 = r11.getString("instruction", "");     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        Object r12 = Result.constructor-impl(new b(r4, r11.getLong("revision", 0)));     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r12);
        if (r5 == null) goto L21;
        FLogger.a.e("OfficeTaskPreferenceRepo", "get preference failed: ".concat(r5.getClass().getSimpleName()));
        return new b("", 0);
    L21:
        return r12;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
