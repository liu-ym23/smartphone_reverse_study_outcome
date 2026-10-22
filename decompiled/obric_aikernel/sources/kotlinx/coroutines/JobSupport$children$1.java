package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {956, 958}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n958#1:1455,6\n*E\n"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super v1>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ c2 this$0;

    JobSupport$children$1(c2 r10, Continuation<? super JobSupport$children$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        JobSupport$children$1 r12 = new JobSupport$children$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super v1> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super v1> r10, Continuation<? super Unit> r11) {
        return ((JobSupport$children$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) this.L$2;
        kotlinx.coroutines.internal.s r14 = (kotlinx.coroutines.internal.s) this.L$1;
        SequenceScope r15 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        r13 = r13.j();
    L21:
        if (Intrinsics.areEqual(r13, r14) == true) goto L29;
        if ((r13 instanceof u) == false) goto L27;
        v r16 = ((u) r13).f10720j;
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.label = 2;
        if (r15.yield(r16, this) != r11) goto L27;
        return r11;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        goto L29
    L10:
        ResultKt.throwOnFailure(r10);
        SequenceScope r17 = (SequenceScope) this.L$0;
        Object r18 = this.this$0.w0();
        if ((r18 instanceof u) == false) goto L16;
        v r19 = ((u) r18).f10720j;
        this.label = 1;
        if (r17.yield(r19, this) != r11) goto L29;
        return r11;
    L16:
        if ((r18 instanceof p1) == false) goto L29;
        h2 r20 = ((p1) r18).a();
        if (r20 == null) goto L29;
        Object r21 = r20.i();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r22 = (LockFreeLinkedListNode) r21;
        r15 = r17;
        r14 = r20;
        r13 = r22;
        goto L21
    }
}
