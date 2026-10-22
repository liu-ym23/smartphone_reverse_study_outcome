package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion r3) {
        Intrinsics.checkNotNullParameter(r3, EffectConfiguration.KEY_VERSION);
        if (r3.getMajor() != 1) goto L7;
        if (r3.getMinor() < 4) goto L7;
        return true;
    L7:
        if (r3.getMajor() > 1) goto L12;
        return false;
    L12:
        return true;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion r1) {
        Intrinsics.checkNotNullParameter(r1, EffectConfiguration.KEY_VERSION);
        return isKotlin1Dot4OrLater(r1);
    }
}
