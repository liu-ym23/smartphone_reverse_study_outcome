package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    private Iterator<? extends T> nextIterator;
    private Continuation<? super Unit> nextStep;
    private T nextValue;
    private int state;

    public SequenceBuilderIterator() {
    }

    private final Throwable exceptionalState() {
        int r10 = this.state;
        if (r10 == 4) goto L9;
        if (r10 == 5) goto L11;
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    L11:
        return new IllegalStateException("Iterator has failed.");
    L9:
        return new NoSuchElementException();
    }

    private final T nextNotReady() {
        if (hasNext() == false) goto L7;
        return next();
    L7:
        throw new NoSuchElementException();
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final Continuation<Unit> getNextStep() {
        return this.nextStep;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        int r10 = this.state;
        if (r10 == 0) goto L21;
        if (r10 != 1) goto L6;
        Iterator<? extends T> r11 = this.nextIterator;
        Intrinsics.checkNotNull(r11);
        if (r11.hasNext() == true) goto L18;
        this.nextIterator = null;
        goto L21
    L18:
        this.state = 2;
        return true;
    L6:
        if (r10 != 2) goto L8;
    L15:
        return true;
    L8:
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L14;
        return false;
    L14:
        throw exceptionalState();
    L21:
        this.state = 5;
        Continuation<? super Unit> r12 = this.nextStep;
        Intrinsics.checkNotNull(r12);
        this.nextStep = null;
        Result.Companion r13 = Result.Companion;
        r12.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
        goto L2
    }

    @Override // java.util.Iterator
    public T next() {
        int r10 = this.state;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L17;
        if (r10 != 2) goto L9;
        this.state = 1;
        Iterator<? extends T> r11 = this.nextIterator;
        Intrinsics.checkNotNull(r11);
        return r11.next();
    L9:
        if (r10 != 3) goto L13;
        this.state = 0;
        T r12 = this.nextValue;
        this.nextValue = null;
        return r12;
    L13:
        throw exceptionalState();
    L17:
        return nextNotReady();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        ResultKt.throwOnFailure(r10);
        this.state = 4;
    }

    public final void setNextStep(Continuation<? super Unit> r10) {
        this.nextStep = r10;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object yield(T r10, Continuation<? super Unit> r11) {
        this.nextValue = r10;
        this.state = 3;
        this.nextStep = r11;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L6:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r12;
    L9:
        return Unit.INSTANCE;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object yieldAll(Iterator<? extends T> r10, Continuation<? super Unit> r11) {
        if (r10.hasNext() == false) goto L5;
        this.nextIterator = r10;
        this.state = 2;
        this.nextStep = r11;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L10:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r12;
    L13:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
