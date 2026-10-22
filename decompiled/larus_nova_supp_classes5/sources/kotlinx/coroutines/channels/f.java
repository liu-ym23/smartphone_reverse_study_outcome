package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class f<E> extends a<Unit> implements Channel<E> {
    public final Channel<E> d;

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r2) {
        return this.d.close(r2);
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceive() {
        return this.d.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<g<E>> getOnReceiveCatching() {
        return this.d.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceiveOrNull() {
        return this.d.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.i<E, SendChannel<E>> getOnSend() {
        return this.d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1<? super Throwable, Unit> r2) {
        this.d.invokeOnClose(r2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return this.d.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return this.d.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r2) {
        return this.d.offer(r2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public final E poll() {
        return this.d.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> r2) {
        return this.d.receive(r2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo528receiveCatchingJP2dKIU(Continuation<? super g<? extends E>> r2) {
        Object r3 = this.d.mo528receiveCatchingJP2dKIU(r2);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r3;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public final Object receiveOrNull(Continuation<? super E> r2) {
        return this.d.receiveOrNull(r2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E r2, Continuation<? super Unit> r3) {
        return this.d.send(r2, r3);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo529tryReceivePtdJZtk() {
        return this.d.mo529tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo530trySendJP2dKIU(E r2) {
        return this.d.mo530trySendJP2dKIU(r2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ void cancel() {
        u(new JobCancellationException(x(), null, this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r3) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = new JobCancellationException(x(), null, this);
    L7:
        u(r3);
    }

    public final void u(Throwable r2) {
        CancellationException r3 = JobSupport.h0(this, r2);
        this.d.cancel(r3);
        s(r3);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable r3) {
        u(new JobCancellationException(x(), null, this));
        return true;
    }

    public f(CoroutineContext r1, Channel<E> r2, boolean r3, boolean r4) {
        super(r1, r3, r4);
        this.d = r2;
    }
}
