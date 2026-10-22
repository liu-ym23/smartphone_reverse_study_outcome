package androidx.room.compiler.processing.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000fB\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/room/compiler/processing/util/MemoizedSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "buildSequence", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "cache", "", "delegateIterator", "", "getDelegateIterator", "()Ljava/util/Iterator;", "delegateIterator$delegate", "Lkotlin/Lazy;", "iterator", "CachedIterator", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoizedSequence<T> implements Sequence<T> {
    private final Function0<Sequence<T>> buildSequence;
    private final List<T> cache;
    private final Lazy delegateIterator$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/util/MemoizedSequence$CachedIterator;", "", "(Landroidx/room/compiler/processing/util/MemoizedSequence;)V", "yieldedCount", "", "hasNext", "", "next", "()Ljava/lang/Object;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class CachedIterator implements Iterator<T>, KMappedMarker {
        final /* synthetic */ MemoizedSequence<T> this$0;
        private int yieldedCount;

        public CachedIterator(MemoizedSequence r5) {
            this.this$0 = r5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.yieldedCount >= MemoizedSequence.access$getCache$p(this.this$0).size()) goto L5;
        L8:
            return true;
        L5:
            if (MemoizedSequence.access$getDelegateIterator(this.this$0).hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (MemoizedSequence.access$getCache$p(this.this$0).size() != this.yieldedCount) goto L5;
            MemoizedSequence.access$getCache$p(this.this$0).add(MemoizedSequence.access$getDelegateIterator(this.this$0).next());
        L5:
            T r5 = (T) MemoizedSequence.access$getCache$p(this.this$0).get(this.yieldedCount);
            this.yieldedCount++;
            return r5;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemoizedSequence(Function0<? extends Sequence<? extends T>> r5) {
        Intrinsics.checkNotNullParameter(r5, "buildSequence");
        this.buildSequence = r5;
        this.cache = new ArrayList();
        this.delegateIterator$delegate = LazyKt.lazy(new MemoizedSequence$delegateIterator$2(this));
    }

    public static final /* synthetic */ Function0 access$getBuildSequence$p(MemoizedSequence r5) {
        return r5.buildSequence;
    }

    public static final /* synthetic */ List access$getCache$p(MemoizedSequence r5) {
        return r5.cache;
    }

    public static final /* synthetic */ Iterator access$getDelegateIterator(MemoizedSequence r5) {
        return r5.getDelegateIterator();
    }

    private final Iterator<T> getDelegateIterator() {
        return (Iterator) this.delegateIterator$delegate.getValue();
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new CachedIterator(this);
    }
}
