package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,396:1\n1789#2,3:397\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:397,3\n*E\n"})
public final class RegexKt {
    public static final /* synthetic */ MatchResult access$findNext(Matcher r10, int r11, CharSequence r12) {
        return findNext(r10, r11, r12);
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher r10, CharSequence r11) {
        return matchEntire(r10, r11);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r10) {
        return range(r10);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r10, int r11) {
        return range(r10, r11);
    }

    public static final /* synthetic */ int access$toInt(Iterable r10) {
        return toInt(r10);
    }

    private static final MatchResult findNext(Matcher r10, int r11, CharSequence r12) {
        if (r10.find(r11) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r10, r12);
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(final int r10) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet r11 = EnumSet.allOf(Enum.class);
        Intrinsics.checkNotNullExpressionValue(r11, "fromInt$lambda$1");
        Intrinsics.needClassReification();
        CollectionsKt.retainAll(r11, new RegexKt$fromInt$1$1(r10));
        Set<T> r12 = Collections.unmodifiableSet(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        return r12;
    }

    private static final MatchResult matchEntire(Matcher r10, CharSequence r11) {
        if (r10.matches() == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r10, r11);
    }

    private static final IntRange range(java.util.regex.MatchResult r10) {
        return RangesKt.until(r10.start(), r10.end());
    }

    private static final IntRange range(java.util.regex.MatchResult r10, int r11) {
        return RangesKt.until(r10.start(r11), r10.end(r11));
    }

    private static final int toInt(Iterable<? extends FlagEnum> r10) {
        Iterator<? extends FlagEnum> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | r11.next().getValue();
        goto L4
    L6:
        return r12;
    }
}
