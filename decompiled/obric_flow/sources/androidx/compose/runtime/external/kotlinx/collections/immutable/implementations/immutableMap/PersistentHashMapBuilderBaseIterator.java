package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J5\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", SVGRenderEngine.PATH, "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "expectedModCount", "", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "next", "()Ljava/lang/Object;", "remove", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", STGroup.DICT_KEY, "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "setValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMutableIterator {
    private final PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;
    private K lastIteratedKey;
    private boolean nextWasInvoked;

    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder<K, V> r5, TrieNodeBaseIterator<K, V, T>[] r10) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.PATH);
        super(r5.getNode$runtime_release(), r10);
        this.builder = r5;
        this.expectedModCount = r5.getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime_release() != this.expectedModCount) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    private final void checkNextWasInvoked() {
        if (this.nextWasInvoked == false) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    private final void resetPath(int r10, TrieNode<?, ?> r11, K r12, int r13) {
        int r5 = r13 * 5;
        if (r5 <= 30) goto L10;
        getPath()[r13].reset(r11.getBuffer$runtime_release(), r11.getBuffer$runtime_release().length, 0);
    L6:
        if (Intrinsics.areEqual(getPath()[r13].currentKey(), r12) == true) goto L8;
        getPath()[r13].moveToNextKey();
        goto L6
    L8:
        setPathLastIndex(r13);
        return;
    L10:
        int r14 = 1 << TrieNodeKt.indexSegment(r10, r5);
        if (r11.hasEntryAt$runtime_release(r14) == false) goto L14;
        int r15 = r11.entryKeyIndex$runtime_release(r14);
        getPath()[r13].reset(r11.getBuffer$runtime_release(), r11.entryCount$runtime_release() * 2, r15);
        setPathLastIndex(r13);
        return;
    L14:
        int r16 = r11.nodeIndex$runtime_release(r14);
        TrieNode<?, ?> r17 = r11.nodeAtIndex$runtime_release(r16);
        getPath()[r13].reset(r11.getBuffer$runtime_release(), r11.entryCount$runtime_release() * 2, r16);
        resetPath(r10, r17, r12, r13 + 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public T next() {
        checkForComodification();
        this.lastIteratedKey = currentKey();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext() == false) goto L9;
        K r5 = currentKey();
        PersistentHashMapBuilder<K, V> r10 = this.builder;
        TypeIntrinsics.asMutableMap(r10).remove(this.lastIteratedKey);
        if (r5 == null) goto L7;
        int r11 = r5.hashCode();
    L8:
        resetPath(r11, this.builder.getNode$runtime_release(), r5, 0);
    L10:
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime_release();
        return;
    L7:
        r11 = 0;
        goto L8
    L9:
        PersistentHashMapBuilder<K, V> r12 = this.builder;
        TypeIntrinsics.asMutableMap(r12).remove(this.lastIteratedKey);
        goto L10
    }

    public final void setValue(K r5, V r10) {
        if (this.builder.containsKey(r5) == true) goto L6;
        return;
    L6:
        if (hasNext() == false) goto L12;
        K r11 = currentKey();
        this.builder.put(r5, r10);
        if (r11 == null) goto L10;
        int r12 = r11.hashCode();
    L11:
        resetPath(r12, this.builder.getNode$runtime_release(), r11, 0);
    L13:
        this.expectedModCount = this.builder.getModCount$runtime_release();
        return;
    L10:
        r12 = 0;
        goto L11
    L12:
        this.builder.put(r5, r10);
        goto L13
    }
}
