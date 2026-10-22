package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", EventBody.KEY_VALUE, "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RegexKt {
    public static final /* synthetic */ MatchResult access$findNext(Matcher r2, int r3, CharSequence r4) {
        return findNext(r2, r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher r2, CharSequence r3) {
        return matchEntire(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r2) {
        return range((java.util.regex.MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, java.util.regex.MatchResult.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r2, int r3) {
        return range((java.util.regex.MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, java.util.regex.MatchResult.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ int access$toInt(Iterable r2) {
        return toInt((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final MatchResult findNext(Matcher r2, int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2.find(r3) == true) goto L6;
        return null;
    L6:
        return (MatchResult) ZeusTransformUtils.preCheckCast(new MatcherMatchResult(r2, r5), MatchResult.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(final int r4) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet r0 = EnumSet.allOf((Class) ZeusTransformUtils.preCheckCast(Enum.class, Class.class, "com.obric.memorydata.plugin"));
        EnumSet r1 = (EnumSet) ZeusTransformUtils.preCheckCast(r0, EnumSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.needClassReification();
        CollectionsKt.retainAll(r2, (Function1) ZeusTransformUtils.preCheckCast(new RegexKt$fromInt$1$1(r4), Function1.class, "com.obric.memorydata.plugin"));
        Set r5 = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "unmodifiableSet(...)");
        return (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
    }

    private static final MatchResult matchEntire(Matcher r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2.matches() == true) goto L6;
        return null;
    L6:
        return (MatchResult) ZeusTransformUtils.preCheckCast(new MatcherMatchResult(r2, r4), MatchResult.class, "com.obric.memorydata.plugin");
    }

    private static final IntRange range(java.util.regex.MatchResult r2) {
        java.util.regex.MatchResult r3 = (java.util.regex.MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, java.util.regex.MatchResult.class, "com.obric.memorydata.plugin");
        return RangesKt.until(r3.start(), r3.end());
    }

    private static final IntRange range(java.util.regex.MatchResult r2, int r3) {
        java.util.regex.MatchResult r4 = (java.util.regex.MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, java.util.regex.MatchResult.class, "com.obric.memorydata.plugin");
        return RangesKt.until(r4.start(r3), r4.end(r3));
    }

    private static final int toInt(Iterable<? extends FlagEnum> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | ((FlagEnum) ZeusTransformUtils.preCheckCast(r5.next(), FlagEnum.class, "com.obric.memorydata.plugin")).getValue();
        goto L4
    L6:
        return r0;
    }
}
