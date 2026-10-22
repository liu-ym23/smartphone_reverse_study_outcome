package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectEqualityComparator extends AbstractEqualityComparator<Object> {
    public static final ObjectEqualityComparator INSTANCE = null;

    static {
        INSTANCE = new ObjectEqualityComparator();
    }

    public ObjectEqualityComparator() {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
    public boolean equals(Object r5, Object r10) {
        if (r5 != null) goto L8;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r5.equals(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
    public int hashCode(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }
}
