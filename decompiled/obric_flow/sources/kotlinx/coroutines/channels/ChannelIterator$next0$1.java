package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {602}, m = "next", n = {"$this"}, s = {"L$0"})
final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelIterator$next0$1(Continuation<? super ChannelIterator$next0$1> r5) {
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
        k r13 = (k) this.L$0;
        ResultKt.throwOnFailure(r11);
        if (((Boolean) r11).booleanValue() == false) goto L14;
        return ((e) r13).d();
    L14:
        throw new ClosedReceiveChannelException("Channel was closed");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);
        this.L$0 = null;
        this.label = 1;
        throw null;
    L5:
        ChannelIterator$next0$1<E> this = new ChannelIterator$next0$1(this);
        goto L6
    }
}
