package com.larus.dora.impl.guide;

import com.larus.dora.impl.network.DoraNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraConnectDeviceGuide$serverConditionCheck$strategy$1", f = "DoraConnectDeviceGuide.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
public final class DoraConnectDeviceGuide$serverConditionCheck$strategy$1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ i59.a $params;
    final /* synthetic */ j59.a $state;
    int label;

    public DoraConnectDeviceGuide$serverConditionCheck$strategy$1(i59.a r1, j59.a r2, Continuation<? super DoraConnectDeviceGuide$serverConditionCheck$strategy$1> r3) {
        this.$params = r1;
        this.$state = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new DoraConnectDeviceGuide$serverConditionCheck$strategy$1(this.$params, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Result<Boolean>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) r12).unbox-impl();
    L19:
        return Result.box-impl(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        DoraNetworkApi r2 = DoraNetworkApi.a;
        i59.a r3 = this.$params;
        String r4 = r3.a;
        String r5 = r3.b;
        Long r6 = Boxing.boxLong(this.$state.a);
        if (r6.longValue() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r6 = null;
    L15:
        Long r8 = r6;
        j59.a r9 = this.$state;
        int r10 = r9.b;
        int r11 = r9.c;
        int r14 = r9.d;
        this.label = 1;
        r13 = r2.f("bind_guide_modal", r4, r5, r8, r10, r11, r14, this);
        if (r13 != r0) goto L19;
        return r0;
    L11:
        r7 = false;
        goto L12
    }
}
