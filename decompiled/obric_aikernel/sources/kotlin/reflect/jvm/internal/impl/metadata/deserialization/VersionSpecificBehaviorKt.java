package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "version");
        if (r10.getMajor() == 1) goto L5;
    L7:
        return false;
    L5:
        if (r10.getMinor() < 4) goto L7;
        return true;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "version");
        return isKotlin1Dot4OrLater(r10);
    }
}
