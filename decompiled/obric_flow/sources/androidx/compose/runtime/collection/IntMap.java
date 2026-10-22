package androidx.compose.runtime.collection;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\b\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0018R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/collection/IntMap;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "(I)V", "sparseArray", "Landroid/util/SparseArray;", "(Landroid/util/SparseArray;)V", "size", "getSize", "()I", "clear", "", "contains", "", STGroup.DICT_KEY, "get", "(I)Ljava/lang/Object;", "valueIfAbsent", "(ILjava/lang/Object;)Ljava/lang/Object;", "remove", "set", "value", "(ILjava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntMap<E> {
    private final SparseArray<E> sparseArray;

    private IntMap(SparseArray<E> r5) {
        this.sparseArray = r5;
    }

    public final void clear() {
        this.sparseArray.clear();
    }

    public final boolean contains(int r5) {
        if (this.sparseArray.indexOfKey(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final E get(int r5) {
        return this.sparseArray.get(r5);
    }

    public final int getSize() {
        return this.sparseArray.size();
    }

    public final void remove(int r5) {
        this.sparseArray.remove(r5);
    }

    public final void set(int r5, E r10) {
        this.sparseArray.put(r5, r10);
    }

    public final E get(int r5, E r10) {
        return this.sparseArray.get(r5, r10);
    }

    public IntMap(int r5) {
        this(new SparseArray(r5));
    }

    public /* synthetic */ IntMap(int r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 10;
    L5:
        this(r5);
    }
}
