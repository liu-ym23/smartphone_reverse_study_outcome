package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.r $result;
    final /* synthetic */ g $upstream;
    private /* synthetic */ Object L$0;
    int label;

    public FlowKt__ShareKt$launchSharingDeferred$1(g r5, kotlinx.coroutines.r r10, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> r11) {
        this.$upstream = r5;
        this.$result = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__ShareKt$launchSharingDeferred$1 r11 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, kotlin.Unit] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
    L15:
        FlowKt__ShareKt$launchSharingDeferred$1 this = Unit.INSTANCE;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        Ref.ObjectRef r13 = new Ref.ObjectRef();     // Catch: Throwable -> L7
        g r14 = this.$upstream;     // Catch: Throwable -> L7
        d1 r15 = new d1(r13, r12, this.$result);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r14.collect(r15, this) != r5) goto L15;
        return r5;
    L7:
        th = move-exception;
        kotlinx.coroutines.s r16 = (kotlinx.coroutines.s) this.$result;
        r16.getClass();
        r16.N(new kotlinx.coroutines.v(false, th));
        throw th;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
