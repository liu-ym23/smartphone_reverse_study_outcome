package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import com.larus.dora.api.IDoraService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$2$onStop$1", f = "DoraGOnboardingViewModelV2.kt", i = {0}, l = {542, 568}, m = "invokeSuspend", n = {"event"}, s = {"L$0"})
public final class DoraGOnboardingViewModelV2$2$onStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $code;
    Object L$0;
    int label;
    final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

    public DoraGOnboardingViewModelV2$2$onStop$1(DoraGOnboardingViewModelV2 r1, Integer r2, Continuation<? super DoraGOnboardingViewModelV2$2$onStop$1> r3) {
        this.this$0 = r1;
        this.$code = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGOnboardingViewModelV2$2$onStop$1(this.this$0, this.$code, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L64:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LLMCallEvent r2 = (LLMCallEvent) this.L$0;
        ResultKt.throwOnFailure(r11);
    L34:
        LLMCallEvent r12 = r2;
    L60:
        Channel<z> r3 = this.this$0.get_llmCallEventSharedFlow();
        z.a r4 = new z.a(r12, this.$code, System.currentTimeMillis());
        this.L$0 = null;
        this.label = 2;
        if (r3.send(r4, this) != r0) goto L64;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        IDoraService.h r13 = DoraGOnboardingViewModelV2.access$getSession(this.this$0);
        if (r13 != null) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == true) goto L18;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "plugin onStop, code: " + this.$code);
        List r6 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(10), Boxing.boxInt(103), Boxing.boxInt(130), Boxing.boxInt(162), Boxing.boxInt(163)});
        LLMCallEvent r7 = LLMCallEvent.UNKNOWN;
        if (CollectionsKt.contains(r6, this.$code) == false) goto L22;
        r12 = LLMCallEvent.INVALID;
        goto L60
    L22:
        Integer r8 = this.$code;
        if (r8 != null) goto L26;
    L35:
        Integer r5 = this.$code;
        if (r5 != null) goto L39;
    L41:
        Integer r9 = this.$code;
        if (r9 != null) goto L45;
    L47:
        Integer r10 = this.$code;
        if (r10 != null) goto L51;
    L53:
        Integer r15 = this.$code;
        if (r15 != null) goto L57;
    L59:
        CollectionsKt.listOf(new Integer[]{Boxing.boxInt(111), Boxing.boxInt(112), Boxing.boxInt(113), Boxing.boxInt(114), Boxing.boxInt(115), Boxing.boxInt(6), Boxing.boxInt(32)});
        r12 = LLMCallEvent.FINISH;
        goto L60
    L57:
        if (r15.intValue() != 200) goto L59;
        r12 = LLMCallEvent.NEXT;
        goto L60
    L51:
        if (r10.intValue() != 100) goto L53;
        r12 = LLMCallEvent.LINK;
        goto L60
    L45:
        if (r9.intValue() != 101) goto L47;
        r12 = LLMCallEvent.WEAR;
        goto L60
    L39:
        if (r5.intValue() != 33) goto L41;
        r12 = LLMCallEvent.NET;
        goto L60
    L26:
        if (r8.intValue() != 9) goto L35;
        r2 = LLMCallEvent.INVALID;
        StringBuilder r16 = new StringBuilder("plugin onStop hit RTOS_HFP_CALLING, emit toast action, currentCallState=");
        r16.append(((Boolean) DoraGOnboardingViewModelV2.access$get_deviceCallStateFlow$p(this.this$0).getValue()).booleanValue());
        r16.append(", onboardingVuiMode=");
        r16.append(DoraGOnboardingViewModelV2.access$getMVuiMode$p(this.this$0));
        r16.append(", sessionVuiMode=");
        IDoraService.h r17 = DoraGOnboardingViewModelV2.access$getSession(this.this$0);
        if (r17 == null) goto L30;
        Integer r18 = Boxing.boxInt(r17.a());
    L31:
        r16.append(r18);
        g49.d.d(DoraGOnboardingViewModelV2.TAG, r16.toString());
        MutableSharedFlow r110 = DoraGOnboardingViewModelV2.access$get_actionSharedFlow$p(this.this$0);
        a.C0088a r20 = new a.C0088a(ActionEvent.TOAST, DoraGOnboardingViewModelV2.access$getMVuiMode$p(this.this$0));
        this.L$0 = r2;
        this.label = 1;
        if (r110.emit(r20, this) != r0) goto L34;
        return r0;
    L30:
        r18 = null;
        goto L31
    L18:
        return Unit.INSTANCE;
    L13:
        if (r13.a() != 11) goto L15;
        r14 = true;
        goto L16
    }
}
