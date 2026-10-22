package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", CommonConsts.COUNT_TYPE, "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DropSequence<T> implements DropTakeSequence<T>, Sequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.DropSequence$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int left;

        AnonymousClass1(DropSequence<T> r2) {
            this.iterator = DropSequence.access$getSequence$p(r2).iterator();
            this.left = DropSequence.access$getCount$p(r2);
        }

        private final void drop() {
        L3:
            if (this.left <= 0) goto L7;
            if (this.iterator.hasNext() == false) goto L10;
            this.iterator.next();
            this.left--;
            goto L3
        L10:
            return;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getLeft() {
            return this.left;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            drop();
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            drop();
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setLeft(int r1) {
            this.left = r1;
        }
    }

    public DropSequence(Sequence<? extends T> r3, int r4) {
        Sequence<T> r5 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "sequence");
        this.sequence = r5;
        this.count = r4;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r4 + '.').toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ int access$getCount$p(DropSequence r0) {
        return r0.count;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(DropSequence r0) {
        return r0.sequence;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r4) {
        int r0 = this.count + r4;
        if (r0 >= 0) goto L5;
        DropSequence r1 = new DropSequence((Sequence) ZeusTransformUtils.preCheckCast(this, Sequence.class, "com.obric.memorydata.plugin"), r4);
    L7:
        return (Sequence) ZeusTransformUtils.preCheckCast(r1, Sequence.class, "com.obric.memorydata.plugin");
    L5:
        r1 = new DropSequence(this.sequence, r0);
        goto L7
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r4) {
        int r0 = this.count + r4;
        if (r0 >= 0) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast(new TakeSequence((Sequence) ZeusTransformUtils.preCheckCast(this, Sequence.class, "com.obric.memorydata.plugin"), r4), DropTakeSequence.class, "com.obric.memorydata.plugin");
    L7:
        return (Sequence) ZeusTransformUtils.preCheckCast((DropTakeSequence) r3, Sequence.class, "com.obric.memorydata.plugin");
    L5:
        r3 = ZeusTransformUtils.preCheckCast(new SubSequence(this.sequence, this.count, r0), DropTakeSequence.class, "com.obric.memorydata.plugin");
        goto L7
    }
}
