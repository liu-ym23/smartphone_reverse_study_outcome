package kotlin.internal.jdk8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: classes2.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @SourceDebugExtension({"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;

        @JvmField
        public static final Integer sdkVersion = null;

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r10 = null;
            Object r11 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if ((r11 instanceof Integer) == false) goto L7;
            Integer r12 = (Integer) r11;     // Catch: Throwable -> L17
        L8:
            if (r12 != null) goto L10;
        L15:
            sdkVersion = r10;
            return;
        L10:
            if (r12.intValue() <= 0) goto L12;
            boolean r13 = true;
        L13:
            if (r13 == false) goto L15;
            r10 = r12;
            goto L15
        L12:
            r13 = false;
        L7:
            r12 = null;
            goto L8
        }

        private ReflectSdkVersion() {
        }
    }

    public JDK8PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r10) {
        Integer r11 = ReflectSdkVersion.sdkVersion;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.intValue() >= r10) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public Random defaultPlatformRandom() {
        if (sdkIsNullOrAtLeast(34) == false) goto L6;
        return new PlatformThreadLocalRandom();
    L6:
        return super.defaultPlatformRandom();
    }

    @Override // kotlin.internal.PlatformImplementations
    public MatchGroup getMatchResultNamedGroup(MatchResult r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "matchResult");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if ((r10 instanceof Matcher) == false) goto L5;
        Matcher r12 = (Matcher) r10;
    L6:
        if (r12 == null) goto L12;
        IntRange r13 = new IntRange(r12.start(r11), r12.end(r11) - 1);
        if (r13.getStart().intValue() < 0) goto L13;
        String r14 = r12.group(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "matcher.group(name)");
        return new MatchGroup(r14, r13);
    L13:
        return null;
    L12:
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    L5:
        r12 = null;
        goto L6
    }
}
