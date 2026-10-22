package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime$startLocked$1$succeeded$1", f = "G2OtaRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidG2OtaRuntime$startLocked$1$succeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q.l $effect;
    final /* synthetic */ Function1<s, Unit> $emit;
    final /* synthetic */ AndroidG2OtaRuntime$b $session;
    int label;
    final /* synthetic */ AndroidG2OtaRuntime this$0;

    public AndroidG2OtaRuntime$startLocked$1$succeeded$1(AndroidG2OtaRuntime r1, q.l r2, Function1<? super s, Unit> r3, AndroidG2OtaRuntime$b r4, Continuation<? super AndroidG2OtaRuntime$startLocked$1$succeeded$1> r5) {
        this.this$0 = r1;
        this.$effect = r2;
        this.$emit = r3;
        this.$session = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AndroidG2OtaRuntime$startLocked$1$succeeded$1(this.this$0, this.$effect, this.$emit, this.$session, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r15);
        if (AndroidG2OtaRuntime.g(this.this$0).l(this.$effect.d()) == false) goto L7;
        this.$emit.invoke(new s$k(this.$effect.a(), this.$effect.c(), ((Number) AndroidG2OtaRuntime.d(this.this$0).invoke()).longValue()));
    L9:
        return Unit.INSTANCE;
    L7:
        this.this$0.j(this.$effect.a(), this.$effect.c(), FailureReason.DOWNLOAD_MD5_FAILED, this.$emit, Boxing.boxInt(this.$session.a()));
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
