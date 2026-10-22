package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ%\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u0015R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", ExifInterface.LONGITUDE_EAST, "", "()V", "buffer", "", "[Ljava/lang/Object;", "index", "", "currentElement", "()Ljava/lang/Object;", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "hasNextCell", "", "hasNextElement", "hasNextNode", "moveToNextCell", "", "nextElement", "reset", "([Ljava/lang/Object;I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeIterator<E> {
    private Object[] buffer;
    private int index;

    public TrieNodeIterator() {
        this.buffer = TrieNode.Companion.getEMPTY$runtime_release().getBuffer();
    }

    public static /* synthetic */ void reset$default(TrieNodeIterator r5, Object[] r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        r5.reset(r10, r11);
    }

    public final E currentElement() {
        CommonFunctionsKt.m42assert(hasNextElement());
        return (E) this.buffer[this.index];
    }

    public final TrieNode<? extends E> currentNode() {
        CommonFunctionsKt.m42assert(hasNextNode());
        Object r5 = this.buffer[this.index];
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return (TrieNode) r5;
    }

    public final boolean hasNextCell() {
        if (this.index >= this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hasNextElement() {
        if (hasNextCell() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.buffer[this.index] instanceof TrieNode) == true) goto L7;
        return true;
    }

    public final boolean hasNextNode() {
        if (hasNextCell() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.buffer[this.index] instanceof TrieNode) == false) goto L7;
        return true;
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.m42assert(hasNextCell());
        this.index++;
    }

    public final E nextElement() {
        CommonFunctionsKt.m42assert(hasNextElement());
        Object[] r5 = this.buffer;
        int r10 = this.index;
        this.index = r10 + 1;
        return (E) r5[r10];
    }

    public final void reset(Object[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "buffer");
        this.buffer = r5;
        this.index = r10;
    }
}
