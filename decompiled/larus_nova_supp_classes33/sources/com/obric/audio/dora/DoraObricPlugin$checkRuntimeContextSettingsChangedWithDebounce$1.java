package com.obric.audio.dora;

import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.dora.DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1", f = "DoraObricPlugin.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ DoraObricPlugin this$0;

    public DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1(DoraObricPlugin r1, String r2, Continuation<? super DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1> r3) {
        this.this$0 = r1;
        this.$key = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1(this.this$0, this.$key, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        DoraObricPlugin.b r8 = this.this$0.l;
        DoraObricPlugin.b r2 = DoraObricPlugin.k3();
        if (Intrinsics.areEqual(r8, r2) == false) goto L15;
        FLogger.a.i(this.this$0.f, "skip checkRuntimeContextSettingsChangedWithDebounce, settings unchanged, key=" + this.$key + ", snapshot=" + r2);
        return Unit.INSTANCE;
    L15:
        DoraObricPlugin r3 = this.this$0;
        r3.l = r2;
        FLogger r4 = FLogger.a;
        r4.i(r3.f, "checkRuntimeContextSettingsChangedWithDebounce, key=" + this.$key + ", previousSnapshot=" + r8 + ", currentSnapshot=" + r2);
        DoraObricPlugin r9 = this.this$0;
        String r5 = this.$key;
        r9.getClass();
        r4.i(r9.f, "handleRuntimeContextSettingsChanged, key=" + r5 + ", currentRoundId=" + r9.h + ", hasQueryStarted=" + r9.i);
        r9.n3(r9.h);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L11;
        return r0;
    }
}
