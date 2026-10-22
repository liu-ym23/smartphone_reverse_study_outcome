package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.settings.KevaOfficeTaskPreferenceRepository$save$2", f = "OfficeTaskPreferenceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KevaOfficeTaskPreferenceRepository$save$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfficeTaskPreferenceSaveResult>, Object> {
    final /* synthetic */ String $instruction;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KevaOfficeTaskPreferenceRepository this$0;

    public KevaOfficeTaskPreferenceRepository$save$2(String r1, KevaOfficeTaskPreferenceRepository r2, Continuation<? super KevaOfficeTaskPreferenceRepository$save$2> r3) {
        this.$instruction = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        KevaOfficeTaskPreferenceRepository$save$2 r0 = new KevaOfficeTaskPreferenceRepository$save$2(this.$instruction, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OfficeTaskPreferenceSaveResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        int r8 = c.a;
        if (c.a(this.$instruction) == false) goto L7;
        KevaOfficeTaskPreferenceRepository r9 = this.this$0;
        String r1 = this.$instruction;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Keva r10 = KevaOfficeTaskPreferenceRepository.c(r9);     // Catch: Throwable -> L11
        r10.storeString("instruction", r1);     // Catch: Throwable -> L11
        r10.storeLong("revision", Math.max(r10.getLong("revision", 0) + 1, System.currentTimeMillis()));     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(OfficeTaskPreferenceSaveResult.SUCCESS);     // Catch: Throwable -> L11
    L13:
        Throwable r0 = Result.exceptionOrNull-impl(r11);
        if (r0 == null) goto L22;
        FLogger.a.e("OfficeTaskPreferenceRepo", "save preference failed: ".concat(r0.getClass().getSimpleName()));
        return OfficeTaskPreferenceSaveResult.FAILURE;
    L22:
        return r11;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L7:
        return OfficeTaskPreferenceSaveResult.MAX_CHARACTER_LIMIT_EXCEEDED;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
