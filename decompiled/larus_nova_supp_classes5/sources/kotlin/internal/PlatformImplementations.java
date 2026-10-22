package kotlin.internal;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", DBDefinition.NAME, "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class PlatformImplementations {
    public PlatformImplementations() {
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public List<Throwable> getSuppressed(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        Method r0 = ReflectThrowable.getSuppressed;
        if (r0 == null) goto L9;
        Object r4 = r0.invoke(r3, new Object[0]);
        if (r4 == null) goto L9;
        List<Throwable> r5 = ArraysKt.asList((Throwable[]) r4);
        if (r5 == null) goto L9;
        return r5;
    L9:
        return CollectionsKt.emptyList();
    }

    public void addSuppressed(Throwable r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "cause");
        Intrinsics.checkNotNullParameter(r5, "exception");
        Method r0 = ReflectThrowable.addSuppressed;
        if (r0 == null) goto L6;
        r0.invoke(r4, new Object[]{r5});
        return;
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "matchResult");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
