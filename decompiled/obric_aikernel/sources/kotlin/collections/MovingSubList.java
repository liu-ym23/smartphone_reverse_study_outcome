package kotlin.collections;

import com.bytedance.apm6.consumer.slardar.Constants;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    private int _size;
    private int fromIndex;
    private final List<E> list;

    /* JADX WARN: Multi-variable type inference failed */
    public MovingSubList(List<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, Constants.KEY_LIST);
        this.list = r10;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this._size);
        return this.list.get(this.fromIndex + r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this._size;
    }

    public final void move(int r10, int r11) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r10, r11, this.list.size());
        this.fromIndex = r10;
        this._size = r11 - r10;
    }
}
