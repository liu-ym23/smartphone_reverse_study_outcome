package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public DeprecationInfo() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DeprecationInfo r10) {
        return compareTo2(r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DeprecationInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = getDeprecationLevel().compareTo(r10.getDeprecationLevel());
        if (r11 == 0) goto L5;
        return r11;
    L5:
        if (getPropagatesToOverrides() == false) goto L7;
        return r11;
    L7:
        if (r10.getPropagatesToOverrides() == false) goto L12;
        return 1;
    L12:
        return r11;
    }

    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();
}
