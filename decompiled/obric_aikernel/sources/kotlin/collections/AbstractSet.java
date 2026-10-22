package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean setEquals$kotlin_stdlib(Set<?> r10, Set<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "c");
            Intrinsics.checkNotNullParameter(r11, "other");
            if (r10.size() == r11.size()) goto L7;
            return false;
        L7:
            return r10.containsAll(r11);
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "c");
            Iterator<?> r11 = r10.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L10;
            Object r13 = r11.next();
            if (r13 == null) goto L8;
            int r14 = r13.hashCode();
        L9:
            r12 = r12 + r14;
            goto L4
        L8:
            r14 = 0;
            goto L9
        L10:
            return r12;
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected AbstractSet() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == true) goto L10;
        return false;
    L10:
        return Companion.setEquals$kotlin_stdlib(this, (Set) r10);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Companion.unorderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
