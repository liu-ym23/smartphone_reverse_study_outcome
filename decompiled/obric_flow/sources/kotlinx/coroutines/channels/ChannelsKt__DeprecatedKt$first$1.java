package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {95}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$first$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$first$1(Continuation<? super ChannelsKt__DeprecatedKt$first$1> r5) {
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
        w r13 = null;
        if (r12 != 0) goto L9;
        ResultKt.throwOnFailure(r11);
        throw null;     // Catch: Throwable -> L25
    L25:
        th = th;
    L32:
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        p.d(r13, th);
        throw th;
    L9:
        if (r12 != 1) goto L22;
        k r14 = (k) this.L$1;
        w r15 = (w) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L19
        if (((Boolean) r11).booleanValue() == false) goto L18;
        Object r16 = ((e) r14).d();     // Catch: Throwable -> L19
        r15.cancel(null);
        return r16;
    L18:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L19
    L19:
        th = th;
        r13 = r15;
        goto L32
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        ChannelsKt__DeprecatedKt$first$1<E> this = new ChannelsKt__DeprecatedKt$first$1(this);
        goto L6
    }
}
