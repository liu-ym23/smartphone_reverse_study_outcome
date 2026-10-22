package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1502:1\n70#2:1503\n1#3:1504\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2\n*L\n800#1:1503\n*E\n"})
public final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ControlledComposition $composition;
    int label;
    final /* synthetic */ Recomposer this$0;

    public Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(Recomposer r5, ControlledComposition r10, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2> r11) {
        this.this$0 = r5;
        this.$composition = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(this.this$0, this.$composition, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        ControlledComposition r10 = Recomposer.access$performRecompose(this.this$0, this.$composition, null);
        Object r11 = Recomposer.access$getStateLock$p(this.this$0);
        Recomposer r12 = this.this$0;
        monitor-enter(r11);
        if (r10 != null) goto L20;
    L10:
        Recomposer.access$setConcurrentCompositionsOutstanding$p(r12, Recomposer.access$getConcurrentCompositionsOutstanding$p(r12) - 1);     // Catch: Throwable -> L8
        j r13 = Recomposer.access$deriveStateLocked(r12);     // Catch: Throwable -> L8
        monitor-exit(r11);
        if (r13 == null) goto L15;
        Result.Companion r14 = Result.Companion;
        r13.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L15:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    L20:
        Recomposer.access$getCompositionsAwaitingApply$p(r12).add(r10);     // Catch: Throwable -> L8
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
