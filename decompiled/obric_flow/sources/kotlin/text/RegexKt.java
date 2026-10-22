package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,397:1\n1797#2,3:398\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:398,3\n*E\n"})
public final class RegexKt {
    public static final /* synthetic */ MatchResult access$findNext(Matcher r5, int r10, CharSequence r11) {
        return findNext(r5, r10, r11);
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher r5, CharSequence r10) {
        return matchEntire(r5, r10);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r5) {
        return range(r5);
    }

    public static final /* synthetic */ int access$toInt(Iterable r5) {
        return toInt(r5);
    }

    private static final MatchResult findNext(Matcher r5, int r10, CharSequence r11) {
        if (r5.find(r10) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r5, r11);
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(final int r5) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet r10 = EnumSet.allOf(Enum.class);
        Intrinsics.checkNotNull(r10);
        Intrinsics.needClassReification();
        CollectionsKt.C(r10, new RegexKt$fromInt$1$1(r5));
        return Collections.unmodifiableSet(r10);
    }

    private static final MatchResult matchEntire(Matcher r5, CharSequence r10) {
        if (r5.matches() == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r5, r10);
    }

    private static final IntRange range(java.util.regex.MatchResult r5) {
        return RangesKt.until(r5.start(), r5.end());
    }

    private static final int toInt(Iterable<? extends FlagEnum> r5) {
        Iterator<? extends FlagEnum> r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | r10.next().getValue();
        goto L4
    L6:
        return r11;
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r5, int r10) {
        return range(r5, r10);
    }

    private static final IntRange range(java.util.regex.MatchResult r5, int r10) {
        return RangesKt.until(r5.start(r10), r5.end(r10));
    }
}
