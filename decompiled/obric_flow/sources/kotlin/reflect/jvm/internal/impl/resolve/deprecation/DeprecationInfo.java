package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public DeprecationInfo() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DeprecationInfo r5) {
        return compareTo2(r5);
    }

    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DeprecationInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r10 = getDeprecationLevel().compareTo(r5.getDeprecationLevel());
        if (r10 == 0) goto L5;
        return r10;
    L5:
        if (getPropagatesToOverrides() == false) goto L7;
        return r10;
    L7:
        if (r5.getPropagatesToOverrides() == false) goto L12;
        return 1;
    L12:
        return r10;
    }
}
