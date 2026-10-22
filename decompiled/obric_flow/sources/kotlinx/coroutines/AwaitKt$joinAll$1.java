package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {47}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
final class AwaitKt$joinAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        int r11 = this.label | Integer.MIN_VALUE;
        this.label = r11;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r11 - Integer.MIN_VALUE;
    L6:
        Object r12 = this.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = this.label;
        if (r13 != 0) goto L9;
        ResultKt.throwOnFailure(r12);
        throw null;
    L9:
        if (r13 != 1) goto L19;
        int r14 = this.I$1;
        int r15 = this.I$0;
        Job[] r16 = (Job[]) this.L$0;
        ResultKt.throwOnFailure(r12);
    L11:
        r15 = r15 + 1;
        if (r15 >= r14) goto L17;
        Job r17 = r16[r15];
        this.L$0 = r16;
        this.I$0 = r15;
        this.I$1 = r14;
        this.label = 1;
        if (r17.join(this) != r5) goto L11;
        return r5;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        AwaitKt$joinAll$1 this = new AwaitKt$joinAll$1(this);
        goto L6
    }
}
