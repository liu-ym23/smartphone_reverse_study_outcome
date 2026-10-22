package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import ai.j0;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime_release", "checkPositionIndex", "checkPositionIndex$runtime_release", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime_release", "orderedEquals", "", "c", "", "other", "orderedEquals$runtime_release", "orderedHashCode", "orderedHashCode$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListImplementation {
    public static final ListImplementation INSTANCE = null;

    static {
        INSTANCE = new ListImplementation();
    }

    private ListImplementation() {
    }

    @JvmStatic
    public static final void checkElementIndex$runtime_release(int r5, int r10) {
        if (r5 < 0) goto L6;
        if (r5 >= r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException(j0.f(r5, r10, "index: ", ", size: "));
    }

    @JvmStatic
    public static final void checkPositionIndex$runtime_release(int r5, int r10) {
        if (r5 < 0) goto L6;
        if (r5 > r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException(j0.f(r5, r10, "index: ", ", size: "));
    }

    @JvmStatic
    public static final void checkRangeIndexes$runtime_release(int r5, int r10, int r11) {
        if (r5 < 0) goto L9;
        if (r10 > r11) goto L9;
        if (r5 > r10) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(j0.f(r5, r10, "fromIndex: ", " > toIndex: "));
    L9:
        StringBuilder r12 = j0.v("fromIndex: ", r5, r10, ", toIndex: ", ", size: ");
        r12.append(r11);
        throw new IndexOutOfBoundsException(r12.toString());
    }

    @JvmStatic
    public static final boolean orderedEquals$runtime_release(Collection<?> r5, Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r5.size() == r10.size()) goto L5;
        return false;
    L5:
        Iterator<?> r11 = r10.iterator();
        Iterator<?> r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r12.next(), r11.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @JvmStatic
    public static final int orderedHashCode$runtime_release(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Iterator<?> r10 = r5.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r12 = r10.next();
        int r13 = r11 * 31;
        if (r12 == null) goto L8;
        int r14 = r12.hashCode();
    L9:
        r11 = r13 + r14;
        goto L4
    L8:
        r14 = 0;
        goto L9
    L10:
        return r11;
    }
}
