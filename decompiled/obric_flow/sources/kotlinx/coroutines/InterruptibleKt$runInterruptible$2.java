package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function0<Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    public InterruptibleKt$runInterruptible$2(Function0<Object> r5, Continuation<? super InterruptibleKt$runInterruptible$2> r10) {
        this.$block = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        InterruptibleKt$runInterruptible$2 r11 = new InterruptibleKt$runInterruptible$2(this.$block, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<Object> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r5);
        CoroutineContext r10 = ((CoroutineScope) this.L$0).getCoroutineContext();
        Function0<Object> r11 = this.$block;
        c2 r12 = new c2();     // Catch: InterruptedException -> L20
        r12.f = j0.i(j0.g(r10), r12);     // Catch: InterruptedException -> L20
    L6:
        AtomicIntegerFieldUpdater r13 = c2.g;     // Catch: InterruptedException -> L20
        int r14 = r13.get(r12);     // Catch: InterruptedException -> L20
        if (r14 != 0) goto L9;
        if (r13.compareAndSet(r12, r14, 0) == false) goto L6;
    L30:
        Object r15 = r11.invoke();     // Catch: Throwable -> L22
        r12.k();     // Catch: InterruptedException -> L20
        return r15;
    L22:
        th = move-exception;
        r12.k();     // Catch: InterruptedException -> L20
        throw th;     // Catch: InterruptedException -> L20
    L9:
        if (r14 == 2) goto L30;
        if (r14 == 3) goto L30;
        c2.l(r14);     // Catch: InterruptedException -> L20
        throw null;     // Catch: InterruptedException -> L20
    L20:
        e = move-exception;
        throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<Object> r10) {
        return ((InterruptibleKt$runInterruptible$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
