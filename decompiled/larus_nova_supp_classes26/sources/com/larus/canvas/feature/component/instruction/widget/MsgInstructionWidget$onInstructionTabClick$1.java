package com.larus.canvas.feature.component.instruction.widget;

import android.content.Context;
import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import t19.s;
import tx9.s3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.widget.MsgInstructionWidget$onInstructionTabClick$1", f = "MsgInstructionWidget.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class MsgInstructionWidget$onInstructionTabClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MsgInstructionWidget this$0;

    public MsgInstructionWidget$onInstructionTabClick$1(MsgInstructionWidget r1, Continuation<? super MsgInstructionWidget$onInstructionTabClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MsgInstructionWidget$onInstructionTabClick$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MsgInstructionWidget r11 = this.this$0;
        int r3 = MsgInstructionWidget.g;
        r11.getClass();
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_bty_dg"), "1") == false) goto L28;
        s r4 = s.a;
        Context r5 = this.this$0.h().getContext();
        z2 r12 = z2.a;
        FlowDowngradeToastConfig r6 = r12.getFlowDowngradeToastConfig();
        String r7 = null;
        if (r6 == null) goto L13;
        String r8 = r6.getTrafficDegradationFeatureDisableCn();
    L14:
        if (r8 != null) goto L16;
    L19:
        if (r2 == false) goto L22;
        String r13 = AppHost.a.getApplication().getString(2131910602);
    L21:
        String r9 = r13;
        Intrinsics.checkNotNull(r9);
        s.j(r4, r5, r9, null, false, 28);
        s3.a("cre_bty_dg");
        return Unit.INSTANCE;
    L22:
        FlowDowngradeToastConfig r14 = r12.getFlowDowngradeToastConfig();
        if (r14 == null) goto L25;
        r7 = r14.getTrafficDegradationFeatureDisableCn();
    L25:
        r13 = String.valueOf(r7);
        goto L21
    L16:
        if (r8.length() == 0) goto L19;
        r2 = false;
        goto L19
    L13:
        r8 = null;
        goto L14
    L28:
        MutableSharedFlow<com.larus.canvas.feature.component.instruction.c> r15 = com.larus.canvas.feature.component.instruction.d.a;
        com.larus.canvas.feature.component.instruction.c r16 = new com.larus.canvas.feature.component.instruction.c(InstructionTabEventType.EVENT_MSG_INSTRUCTION_TAB_CLICK, this.this$0.i(), null, false, 12);
        this.label = 1;
        if (com.larus.canvas.feature.component.instruction.d.a(r16, this) != r0) goto L32;
        return r0;
    }
}
