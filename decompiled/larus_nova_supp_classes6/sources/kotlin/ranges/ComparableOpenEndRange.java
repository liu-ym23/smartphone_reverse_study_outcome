package kotlin.ranges;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "T", "", "Lkotlin/ranges/OpenEndRange;", "start", "endExclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndExclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    private final T endExclusive;
    private final T start;

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }

    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (getStart().hashCode() * 31) + getEndExclusive().hashCode();
    }

    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    public T getEndExclusive() {
        return this.endExclusive;
    }

    public T getStart() {
        return this.start;
    }

    public boolean contains(T r1) {
        return OpenEndRange.DefaultImpls.contains(this, r1);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ComparableOpenEndRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ComparableOpenEndRange r4 = (ComparableOpenEndRange) r3;
        if (Intrinsics.areEqual(getStart(), r4.getStart()) == false) goto L13;
        if (Intrinsics.areEqual(getEndExclusive(), r4.getEndExclusive()) == false) goto L13;
    L12:
        return true;
    L7:
        if (((ComparableOpenEndRange) r3).isEmpty() == true) goto L12;
        goto L8
    }

    public ComparableOpenEndRange(T r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "start");
        Intrinsics.checkNotNullParameter(r3, "endExclusive");
        this.start = r2;
        this.endExclusive = r3;
    }
}
