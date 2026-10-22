package kotlin.internal.jdk8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", ActivityLifecycle.NAME, "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;
        public static final Integer sdkVersion = null;

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r1 = null;
            Object r2 = ZeusTransformUtils.forName("android.os.Build$VERSION", "com.obric.memorydata.plugin").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L7;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        L8:
            if (r3 != null) goto L10;
        L15:
            sdkVersion = r1;
            return;
        L10:
            if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L12;
            boolean r0 = true;
        L13:
            if (r0 == false) goto L15;
            r1 = r3;
            goto L15
        L12:
            r0 = false;
        L7:
            r3 = null;
            goto L8
        }

        private ReflectSdkVersion() {
        }
    }

    public JDK8PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r1) {
        if (ReflectSdkVersion.sdkVersion != null) goto L5;
    L8:
        return true;
    L5:
        if (ReflectSdkVersion.sdkVersion.intValue() >= r1) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public Random defaultPlatformRandom() {
        if (sdkIsNullOrAtLeast(34) == false) goto L6;
        return (Random) ZeusTransformUtils.preCheckCast(new PlatformThreadLocalRandom(), Random.class, "com.obric.memorydata.plugin");
    L6:
        return super.defaultPlatformRandom();
    }

    @Override // kotlin.internal.PlatformImplementations
    public MatchGroup getMatchResultNamedGroup(MatchResult r4, String r5) {
        MatchResult r3 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r4, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "matchResult");
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        if (ZeusTransformUtils.instanceOf(r3, Matcher.class) == false) goto L5;
        Matcher r6 = (Matcher) ZeusTransformUtils.preCheckCast(r3, Matcher.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L12;
        IntRange r7 = new IntRange(r6.start(r5), r6.end(r5) - 1);
        if (r7.getStart().intValue() < 0) goto L13;
        String r8 = r6.group(r5);
        Intrinsics.checkNotNullExpressionValue(r8, "group(...)");
        return new MatchGroup(r8, r7);
    L13:
        return null;
    L12:
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    L5:
        r6 = null;
        goto L6
    }
}
