package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"isKotlin1Dot4OrLater", "", "version", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "isVersionRequirementTableWrittenCorrectly", "metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        if (r5.getMajor() == 1) goto L5;
    L7:
        return false;
    L5:
        if (r5.getMinor() < 4) goto L7;
        return true;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        return isKotlin1Dot4OrLater(r5);
    }
}
