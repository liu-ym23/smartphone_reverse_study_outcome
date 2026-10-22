package com.larus.dora.obric.device_management.setting.earbuds;

import com.larus.dora.impl.core.DoraUserManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1", f = "DoraObricEarbudsSettingsGeneralGroupHolder.kt", i = {0, 1}, l = {282, 283, 285}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
final class DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1(Continuation<? super DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1 r0 = new DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r6);
    L25:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        Pair r7 = (Pair) r6;
        boolean r3 = ((Boolean) r7.component1()).booleanValue();
        boolean r8 = ((Boolean) r7.component2()).booleanValue();
        if (r3 == false) goto L25;
        Boolean r9 = Boxing.boxBoolean(r8);
        this.L$0 = null;
        this.label = 3;
        if (r2.emit(r9, this) != r0) goto L25;
        return r0;
    L11:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r6);
    L16:
        DoraUserManager r10 = DoraUserManager.a;
        this.L$0 = r2;
        this.label = 2;
        r6 = r10.c(this);
        if (r6 != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r6);
        FlowCollector r11 = (FlowCollector) this.L$0;
        DoraUserManager r4 = DoraUserManager.a;
        Boolean r5 = Boxing.boxBoolean(DoraUserManager.b());
        this.L$0 = r11;
        this.label = 1;
        if (r11.emit(r5, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r11;
        goto L16
    }
}
