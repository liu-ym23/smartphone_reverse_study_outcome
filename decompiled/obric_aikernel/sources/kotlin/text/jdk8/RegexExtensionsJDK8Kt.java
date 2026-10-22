package kotlin.text.jdk8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "RegexExtensionsJDK8Kt")
public final class RegexExtensionsJDK8Kt {
    @SinceKotlin(version = "1.2")
    public static final MatchGroup get(MatchGroupCollection r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if ((r10 instanceof MatchNamedGroupCollection) == false) goto L5;
        MatchNamedGroupCollection r12 = (MatchNamedGroupCollection) r10;
    L6:
        if (r12 == null) goto L10;
        return r12.get(r11);
    L10:
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    L5:
        r12 = null;
        goto L6
    }
}
