package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        if (r5.getMajor() != 1) goto L7;
        if (r5.getMinor() < 4) goto L7;
        return true;
    L7:
        if (r5.getMajor() > 1) goto L12;
        return false;
    L12:
        return true;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        return isKotlin1Dot4OrLater(r5);
    }
}
