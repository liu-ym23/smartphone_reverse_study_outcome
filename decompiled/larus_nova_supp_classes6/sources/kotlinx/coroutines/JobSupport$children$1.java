package kotlinx.coroutines;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {963, 965}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    public JobSupport$children$1(JobSupport r1, Continuation<? super JobSupport$children$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        JobSupport$children$1 r0 = new JobSupport$children$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super Job> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:27:0x0083). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        LockFreeLinkedListNode r2 = (LockFreeLinkedListNode) this.L$2;
        n r3 = (n) this.L$1;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r8);
        JobSupport$children$1 r9 = this;
    L27:
        r2 = r2.f();
    L21:
        if (Intrinsics.areEqual(r2, r3) == true) goto L29;
        if ((r2 instanceof p) == false) goto L27;
        q r5 = ((p) r2).e;
        r9.L$0 = r4;
        r9.L$1 = r3;
        r9.L$2 = r2;
        r9.label = 2;
        if (r4.yield(r5, r9) != r0) goto L27;
        return r0;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        goto L29
    L10:
        ResultKt.throwOnFailure(r8);
        SequenceScope r10 = (SequenceScope) this.L$0;
        Object r6 = this.this$0.M();
        if ((r6 instanceof p) == false) goto L16;
        q r7 = ((p) r6).e;
        this.label = 1;
        if (r10.yield(r7, this) != r0) goto L29;
        return r0;
    L16:
        if ((r6 instanceof x0) == false) goto L29;
        n r11 = ((x0) r6).getList();
        if (r11 == null) goto L29;
        Object r12 = r11.e();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        r4 = r10;
        r9 = this;
        r3 = r11;
        r2 = r13;
        goto L21
    }
}
