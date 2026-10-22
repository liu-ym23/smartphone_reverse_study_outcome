package com.obric.aee;

import android.os.Bundle;
import com.obric.aee.impl.EngineBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/os/Bundle;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aee.ExecutionEngine$runPackageStreamingAsFlow$1", f = "ExecutionEngine.kt", i = {0}, l = {179, 188}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
final class ExecutionEngine$runPackageStreamingAsFlow$1 extends SuspendLambda implements Function2<w<? super Bundle>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ Bundle $context;
    final /* synthetic */ String $event;
    final /* synthetic */ com.obric.aee.res.b $pack;
    private /* synthetic */ Object L$0;
    int label;

    ExecutionEngine$runPackageStreamingAsFlow$1(String r3, com.obric.aee.res.b r4, Bundle r5, Bundle r6, Continuation<? super ExecutionEngine$runPackageStreamingAsFlow$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$event = r3;
        this.$pack = r4;
        this.$args = r5;
        this.$context = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        ExecutionEngine$runPackageStreamingAsFlow$1 r11 = new ExecutionEngine$runPackageStreamingAsFlow$1(this.$event, this.$pack, this.$args, this.$context, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super Bundle> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super Bundle> r3, Continuation<? super Unit> r4) {
        return ((ExecutionEngine$runPackageStreamingAsFlow$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExecutionEngine$runPackageStreamingAsFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        w r2 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
        r1 = r2;
    L26:
    L21:
        Function0 r15 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 2;
        if (u.a(r1, r15, r3) != r0) goto L25;
        return r0;
    L12:
        ResultKt.throwOnFailure(r14);
        final w r4 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(this.$event, CharSequence.class, "com.obric.memorydata.plugin"), '_', false, 2, null) == false) goto L16;
        r4.close((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("event start with _ is reserved."), Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L16:
        EngineBridge r6 = EngineBridge.INSTANCE;     // Catch: Throwable -> L19
        com.obric.aee.res.b r7 = this.$pack;     // Catch: Throwable -> L19
        Bundle r8 = this.$args;     // Catch: Throwable -> L19
        String r9 = this.$event;     // Catch: Throwable -> L19
        Bundle r10 = this.$context;     // Catch: Throwable -> L19
        Function2<? super Bundle, ? super Boolean, Unit> r11 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.L$0 = r4;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r1 = r4;
        if (r6.runPackageSteaming(r7, r8, r9, r10, r11, r12) != r0) goto L26;
        return r0;
    L19:
        th = move-exception;
        r1.close(th);
        goto L21
    }
}
