package kotlinx.coroutines;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
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
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {PointerIconCompat.TYPE_HELP, WebSocketProtocol.CLOSE_NO_STATUS_CODE}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1583:1\n275#2,6:1584\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n1005#1:1584,6\n*E\n"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ r1 this$0;

    public JobSupport$children$1(r1 r5, Continuation<? super JobSupport$children$1> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        JobSupport$children$1 r11 = new JobSupport$children$1(this.this$0, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super Job> r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0072 -> B:27:0x0088). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0085 -> B:27:0x0088). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        kotlinx.coroutines.internal.j r12 = (kotlinx.coroutines.internal.j) this.L$2;
        kotlinx.coroutines.internal.i r13 = (kotlinx.coroutines.internal.i) this.L$1;
        SequenceScope r14 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        r12 = r12.f();
    L21:
        if (Intrinsics.areEqual(r12, r13) == true) goto L29;
        if ((r12 instanceof p) == false) goto L27;
        q r15 = ((p) r12).e;
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r12;
        this.label = 2;
        if (r14.yield(r15, this) != r5) goto L27;
        return r5;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        goto L29
    L10:
        ResultKt.throwOnFailure(r10);
        SequenceScope r16 = (SequenceScope) this.L$0;
        r1 r17 = this.this$0;
        r17.getClass();
        Object r18 = r1.f18988a.get(r17);
        if ((r18 instanceof p) == false) goto L16;
        q r19 = ((p) r18).e;
        this.label = 1;
        if (r16.yield(r19, this) != r5) goto L29;
        return r5;
    L16:
        if ((r18 instanceof g1) == false) goto L29;
        u1 r20 = ((g1) r18).b();
        if (r20 == null) goto L29;
        Object r21 = kotlinx.coroutines.internal.j.f18937a.get(r20);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        kotlinx.coroutines.internal.j r22 = (kotlinx.coroutines.internal.j) r21;
        r14 = r16;
        r13 = r20;
        r12 = r22;
        goto L21
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super Job> r5, Continuation<? super Unit> r10) {
        return ((JobSupport$children$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
