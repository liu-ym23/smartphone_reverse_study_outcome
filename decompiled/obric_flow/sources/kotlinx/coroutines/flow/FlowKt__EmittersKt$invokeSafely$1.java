package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0}, l = {212}, m = "invokeSafely$FlowKt__EmittersKt", n = {"cause"}, s = {"L$0"})
final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__EmittersKt$invokeSafely$1(Continuation<? super FlowKt__EmittersKt$invokeSafely$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r10 = this.label | Integer.MIN_VALUE;
        this.label = r10;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r10 - Integer.MIN_VALUE;
    L6:
        Object r11 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L17;
        if (r12 != 1) goto L16;
        Throwable r13 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L13
        return Unit.INSTANCE;
    L13:
        Throwable th2 = th;
    L22:
        if (r13 == null) goto L25;
        if (r13 == th2) goto L25;
        ExceptionsKt.addSuppressed(th2, r13);
    L25:
        throw th2;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);
        this.L$0 = null;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        throw null;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th2 = th;
        r13 = null;
        goto L22
    L5:
        FlowKt__EmittersKt$invokeSafely$1<T> this = new FlowKt__EmittersKt$invokeSafely$1(this);
        goto L6
    }
}
