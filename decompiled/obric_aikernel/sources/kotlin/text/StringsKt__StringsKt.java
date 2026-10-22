package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n79#1,22:1487\n113#1,5:1509\n130#1,5:1514\n79#1,22:1519\n107#1:1541\n79#1,22:1542\n113#1,5:1564\n124#1:1569\n113#1,5:1570\n130#1,5:1575\n141#1:1580\n130#1,5:1581\n79#1,22:1586\n113#1,5:1608\n130#1,5:1613\n12554#2,2:1618\n12554#2,2:1620\n288#3,2:1622\n288#3,2:1624\n1549#3:1627\n1620#3,3:1628\n1549#3:1631\n1620#3,3:1632\n1#4:1626\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n107#1:1487,22\n124#1:1509,5\n141#1:1514,5\n146#1:1519,22\n151#1:1541\n151#1:1542,22\n156#1:1564,5\n161#1:1569\n161#1:1570,5\n166#1:1575,5\n171#1:1580\n171#1:1581,5\n176#1:1586,22\n187#1:1608,5\n198#1:1613,5\n940#1:1618,2\n964#1:1620,2\n1003#1:1622,2\n1009#1:1624,2\n1309#1:1627\n1309#1:1628,3\n1334#1:1631\n1334#1:1632,3\n*E\n"})
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public StringsKt__StringsKt() {
    }

    public static final /* synthetic */ Pair access$findAnyOf(CharSequence r10, Collection r11, int r12, boolean r13, boolean r14) {
        return findAnyOf$StringsKt__StringsKt(r10, r11, r12, r13, r14);
    }

    public static final String commonPrefixWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r13 = Math.min(r10.length(), r11.length());
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L7;
        if (CharsKt__CharKt.equals(r10.charAt(r14), r11.charAt(r14), r12) == false) goto L7;
        r14 = r14 + 1;
    L7:
        int r15 = r14 - 1;
        if (hasSurrogatePairAt(r10, r15) == false) goto L10;
    L11:
        r14 = r14 - 1;
    L13:
        return r10.subSequence(0, r14).toString();
    L10:
        if (hasSurrogatePairAt(r11, r15) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return commonPrefixWith(r10, r11, r12);
    }

    public static final String commonSuffixWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r13 = r10.length();
        int r14 = r11.length();
        int r15 = Math.min(r13, r14);
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L8;
        if (CharsKt__CharKt.equals(r10.charAt((r13 - r16) - 1), r11.charAt((r14 - r16) - 1), r12) == false) goto L8;
        r16 = r16 + 1;
    L8:
        if (hasSurrogatePairAt(r10, (r13 - r16) - 1) == false) goto L10;
    L11:
        r16 = r16 - 1;
    L13:
        return r10.subSequence(r13 - r16, r13).toString();
    L10:
        if (hasSurrogatePairAt(r11, (r14 - r16) - 1) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return commonSuffixWith(r10, r11, r12);
    }

    public static final boolean contains(CharSequence r10, char r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (StringsKt.indexOf$default(r10, r11, 0, r12, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean contains(CharSequence r11, CharSequence r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if ((r12 instanceof String) == false) goto L8;
        if (StringsKt.indexOf$default(r11, (String) r12, 0, r13, 2, null) < 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (indexOf$StringsKt__StringsKt$default(r11, r12, 0, r11.length(), r13, false, 16, null) < 0) goto L11;
        return true;
    }

    @InlineOnly
    private static final boolean contains(CharSequence r10, Regex r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.containsMatchIn(r10);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return contains(r10, r11, r12);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return StringsKt.contains(r10, r11, r12);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == true) goto L5;
    L8:
        if (r10 != r11) goto L11;
        return true;
    L11:
        if (r10 == null) goto L23;
        if (r11 == null) goto L23;
        if (r10.length() != r11.length()) goto L23;
        int r12 = r10.length();
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L22;
        if (CharsKt__CharKt.equals(r10.charAt(r13), r11.charAt(r13), true) == false) goto L20;
        r13 = r13 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        return false;
    L5:
        if ((r11 instanceof String) == false) goto L8;
        return StringsKt.equals((String) r10, (String) r11, true);
    }

    public static final boolean contentEqualsImpl(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == false) goto L9;
        if ((r11 instanceof String) == false) goto L9;
        return Intrinsics.areEqual(r10, r11);
    L9:
        if (r10 != r11) goto L12;
        return true;
    L12:
        if (r10 == null) goto L24;
        if (r11 == null) goto L24;
        if (r10.length() != r11.length()) goto L24;
        int r12 = r10.length();
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L23;
        if (r10.charAt(r13) != r11.charAt(r13)) goto L21;
        r13 = r13 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean endsWith(CharSequence r10, char r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt__CharKt.equals(r10.charAt(StringsKt.getLastIndex(r10)), r11, r12) == false) goto L7;
        return true;
    }

    public static final boolean endsWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt.endsWith$default((String) r10, (String) r11, false, 2, null);
    L11:
        return regionMatchesImpl(r10, r10.length() - r11.length(), r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return endsWith(r10, r11, r12);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return endsWith(r10, r11, r12);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence r10, Collection<String> r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "strings");
        return findAnyOf$StringsKt__StringsKt(r10, r11, r12, r13, false);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence r10, Collection<String> r11, int r12, boolean r13, boolean r14) {
        if (r13 == true) goto L15;
        if (r11.size() != 1) goto L15;
        String r15 = (String) CollectionsKt.single(r11);
        if (r14 == true) goto L9;
        int r16 = StringsKt.indexOf$default(r10, r15, r12, false, 4, null);
    L10:
        if (r16 >= 0) goto L13;
        return null;
    L13:
        return TuplesKt.to(Integer.valueOf(r16), r15);
    L9:
        r16 = StringsKt.lastIndexOf$default(r10, r15, r12, false, 4, null);
    L15:
        if (r14 == true) goto L17;
        IntProgression r17 = new IntRange(RangesKt.coerceAtLeast(r12, 0), r10.length());
    L19:
        if ((r10 instanceof String) == false) goto L38;
        int r18 = r17.getFirst();
        int r19 = r17.getLast();
        int r110 = r17.getStep();
        if (r110 <= 0) goto L23;
        if (r18 > r19) goto L23;
    L25:
        Iterator<T> r20 = r11.iterator();
    L27:
        if (r20.hasNext() == false) goto L31;
        Object r21 = r20.next();
        String r22 = (String) r21;
        if (StringsKt.regionMatches(r22, 0, (String) r10, r18, r22.length(), r13) == false) goto L27;
    L32:
        String r23 = (String) r21;
        if (r23 != null) goto L35;
        if (r18 == r19) goto L55;
        r18 = r18 + r110;
    L55:
        return null;
    L35:
        return TuplesKt.to(Integer.valueOf(r18), r23);
    L31:
        r21 = null;
    L23:
        if (r110 >= 0) goto L55;
        if (r19 > r18) goto L55;
    L38:
        r18 = r17.getFirst();
        int r24 = r17.getLast();
        int r111 = r17.getStep();
        if (r111 <= 0) goto L41;
        if (r18 > r24) goto L41;
    L43:
        Iterator<T> r25 = r11.iterator();
    L45:
        if (r25.hasNext() == false) goto L49;
        Object r26 = r25.next();
        String r27 = (String) r26;
        if (regionMatchesImpl(r27, 0, r10, r18, r27.length(), r13) == false) goto L45;
    L50:
        r23 = (String) r26;
        if (r23 != null) goto L35;
        if (r18 == r24) goto L55;
        r18 = r18 + r111;
        goto L43
    L49:
        r26 = null;
    L41:
        if (r111 >= 0) goto L55;
        if (r24 > r18) goto L55;
    L17:
        r17 = RangesKt.downTo(RangesKt.coerceAtMost(r12, StringsKt.getLastIndex(r10)), 0);
        goto L19
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence r10, Collection r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return findAnyOf(r10, r11, r12, r13);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence r10, Collection<String> r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "strings");
        return findAnyOf$StringsKt__StringsKt(r10, r11, r12, r13, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence r10, Collection r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = StringsKt.getLastIndex(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return findLastAnyOf(r10, r11, r12, r13);
    }

    public static IntRange getIndices(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IntRange(0, r10.length() - 1);
    }

    public static int getLastIndex(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (new IntRange(0, r10.length() - 2).contains(r11) == true) goto L5;
        return false;
    L5:
        if (Character.isHighSurrogate(r10.charAt(r11)) == true) goto L7;
        return false;
    L7:
        if (Character.isLowSurrogate(r10.charAt(r11 + 1)) == true) goto L9;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C r10, Function0<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (StringsKt.isBlank(r10) == true) goto L5;
        return r10;
    L5:
        return r11.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C r10, Function0<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        return r10;
    L8:
        return r11.invoke();
    L5:
        r12 = false;
        goto L6
    }

    public static final int indexOf(CharSequence r10, char r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r12);
    L9:
        return indexOfAny(r10, new char[]{r11}, r12, r13);
    }

    public static final int indexOf(CharSequence r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.Custom.S_STRING);
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r12);
    L9:
        return indexOf$StringsKt__StringsKt$default(r10, r11, r12, r10.length(), r13, false, 16, null);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15) {
        if (r15 == true) goto L5;
        IntProgression r16 = new IntRange(RangesKt.coerceAtLeast(r12, 0), RangesKt.coerceAtMost(r13, r10.length()));
    L7:
        if ((r10 instanceof String) == true) goto L9;
    L20:
        int r17 = r16.getFirst();
        int r18 = r16.getLast();
        int r19 = r16.getStep();
        if (r19 <= 0) goto L23;
        if (r17 > r18) goto L23;
    L25:
        int r20 = r17;
        if (regionMatchesImpl(r11, 0, r10, r20, r11.length(), r14) == true) goto L27;
        if (r17 == r18) goto L42;
        r17 = r17 + r19;
        goto L25
    L42:
        return -1;
    L27:
        return r17;
    L23:
        if (r19 >= 0) goto L39;
        if (r18 <= r17) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if ((r11 instanceof String) == false) goto L20;
        int r21 = r16.getFirst();
        int r22 = r16.getLast();
        int r110 = r16.getStep();
        if (r110 <= 0) goto L13;
        if (r21 > r22) goto L13;
    L15:
        int r23 = r21;
        if (StringsKt.regionMatches((String) r11, 0, (String) r10, r23, r11.length(), r14) == true) goto L17;
        if (r21 == r22) goto L41;
        r21 = r21 + r110;
        goto L15
    L41:
        return -1;
    L17:
        return r21;
    L13:
        if (r110 >= 0) goto L30;
        if (r22 <= r21) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r16 = RangesKt.downTo(RangesKt.coerceAtMost(r12, StringsKt.getLastIndex(r10)), RangesKt.coerceAtLeast(r13, 0));
        goto L7
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return indexOf$StringsKt__StringsKt(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return indexOf(r10, r11, r12, r13);
    }

    public static final int indexOfAny(CharSequence r10, Collection<String> r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "strings");
        Pair<Integer, String> r14 = findAnyOf$StringsKt__StringsKt(r10, r11, r12, r13, false);
        if (r14 != null) goto L7;
        return -1;
    L7:
        return r14.getFirst().intValue();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final int indexOfAny(CharSequence r10, char[] r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        if (r13 == false) goto L5;
    L10:
        ?? r14 = new IntRange(RangesKt.coerceAtLeast(r12, 0), StringsKt.getLastIndex(r10)).iterator2();
    L12:
        if (r14.hasNext() == false) goto L22;
        int r15 = r14.nextInt();
        char r16 = r10.charAt(r15);
        int r17 = r11.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L19;
        if (CharsKt__CharKt.equals(r11[r18], r16, r13) == true) goto L17;
        r18 = r18 + 1;
        goto L14
    L17:
        boolean r19 = true;
    L20:
        if (r19 == false) goto L12;
        return r15;
    L19:
        r19 = false;
        goto L20
    L22:
        return -1;
    L5:
        if (r11.length != 1) goto L10;
        if ((r10 instanceof String) == false) goto L10;
        return ((String) r10).indexOf(ArraysKt.single(r11), r12);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r10, Collection r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return indexOfAny(r10, r11, r12, r13);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r10, char[] r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return indexOfAny(r10, r11, r12, r13);
    }

    @InlineOnly
    private static final boolean isEmpty(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return !StringsKt.isBlank(r10);
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (StringsKt.isBlank(r10) == true) goto L7;
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static final CharIterator iterator(final CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final int lastIndexOf(CharSequence r10, char r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).lastIndexOf(r11, r12);
    L9:
        return lastIndexOfAny(r10, new char[]{r11}, r12, r13);
    }

    public static final int lastIndexOf(CharSequence r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.Custom.S_STRING);
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).lastIndexOf(r11, r12);
    L9:
        return indexOf$StringsKt__StringsKt(r10, r11, r12, 0, r13, true);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = StringsKt.getLastIndex(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = StringsKt.getLastIndex(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static final int lastIndexOfAny(CharSequence r10, Collection<String> r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "strings");
        Pair<Integer, String> r14 = findAnyOf$StringsKt__StringsKt(r10, r11, r12, r13, true);
        if (r14 != null) goto L7;
        return -1;
    L7:
        return r14.getFirst().intValue();
    }

    public static final int lastIndexOfAny(CharSequence r10, char[] r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        if (r13 == false) goto L5;
    L10:
        int r14 = RangesKt.coerceAtMost(r12, StringsKt.getLastIndex(r10));
    L12:
        if ((-1) >= r14) goto L22;
        char r15 = r10.charAt(r14);
        int r16 = r11.length;
        boolean r17 = false;
        int r18 = 0;
    L14:
        if (r18 >= r16) goto L19;
        if (CharsKt__CharKt.equals(r11[r18], r15, r13) == true) goto L17;
        r18 = r18 + 1;
        goto L14
    L17:
        r17 = true;
    L19:
        if (r17 == true) goto L20;
        r14 = r14 - 1;
        goto L12
    L20:
        return r14;
    L22:
        return -1;
    L5:
        if (r11.length != 1) goto L10;
        if ((r10 instanceof String) == false) goto L10;
        return ((String) r10).lastIndexOf(ArraysKt.single(r11), r12);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r10, Collection r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = StringsKt.getLastIndex(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return lastIndexOfAny(r10, r11, r12, r13);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r10, char[] r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = StringsKt.getLastIndex(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return lastIndexOfAny(r10, r11, r12, r13);
    }

    public static final Sequence<String> lineSequence(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return splitToSequence$default(r10, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.toList(lineSequence(r10));
    }

    @InlineOnly
    private static final boolean matches(CharSequence r10, Regex r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.matches(r10);
    }

    @InlineOnly
    private static final String orEmpty(String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final CharSequence padEnd(CharSequence r10, int r11, char r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L14;
        if (r11 <= r10.length()) goto L7;
        StringBuilder r13 = new StringBuilder(r11);
        r13.append(r10);
        ?? r14 = new IntRange(1, r11 - r10.length()).iterator2();
    L10:
        if (r14.hasNext() == false) goto L12;
        r14.nextInt();
        r13.append(r12);
        goto L10
    L12:
        return r13;
    L7:
        return r10.subSequence(0, r10.length());
    L14:
        throw new IllegalArgumentException("Desired length " + r11 + " is less than zero.");
    }

    public static final String padEnd(String r10, int r11, char r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return padEnd(r10, r11, r12).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence r10, int r11, char r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = ' ';
    L6:
        return padEnd(r10, r11, r12);
    }

    public static /* synthetic */ String padEnd$default(String r10, int r11, char r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = ' ';
    L6:
        return padEnd(r10, r11, r12);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final CharSequence padStart(CharSequence r10, int r11, char r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L15;
        if (r11 <= r10.length()) goto L7;
        StringBuilder r13 = new StringBuilder(r11);
        ?? r14 = new IntRange(1, r11 - r10.length()).iterator2();
    L10:
        if (r14.hasNext() == false) goto L12;
        r14.nextInt();
        r13.append(r12);
        goto L10
    L12:
        r13.append(r10);
        return r13;
    L7:
        return r10.subSequence(0, r10.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r11 + " is less than zero.");
    }

    public static String padStart(String r10, int r11, char r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return padStart(r10, r11, r12).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence r10, int r11, char r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = ' ';
    L6:
        return padStart(r10, r11, r12);
    }

    public static /* synthetic */ String padStart$default(String r10, int r11, char r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = ' ';
    L6:
        return StringsKt.padStart(r10, r11, r12);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r10, final char[] r11, int r12, final boolean r13, int r14) {
        requireNonNegativeLimit(r14);
        return new DelimitedRangesSequence(r10, r12, r14, new StringsKt__StringsKt$rangesDelimitedBy$1(r11, r13));
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r10, String[] r11, int r12, final boolean r13, int r14) {
        requireNonNegativeLimit(r14);
        final List r15 = ArraysKt.asList(r11);
        return new DelimitedRangesSequence(r10, r12, r14, new StringsKt__StringsKt$rangesDelimitedBy$2(r15, r13));
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r10, char[] r11, int r12, boolean r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r10, r11, r12, r13, r14);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r10, String[] r11, int r12, boolean r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r10, r11, r12, r13, r14);
    }

    public static final boolean regionMatchesImpl(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if (r13 < 0) goto L18;
        if (r11 < 0) goto L18;
        if (r11 > (r10.length() - r14)) goto L18;
        if (r13 > (r12.length() - r14)) goto L18;
        int r16 = 0;
    L11:
        if (r16 >= r14) goto L16;
        if (CharsKt__CharKt.equals(r10.charAt(r11 + r16), r12.charAt(r13 + r16), r15) == false) goto L14;
        r16 = r16 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static final CharSequence removePrefix(CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (startsWith$default(r10, r11, false, 2, null) == false) goto L7;
        return r10.subSequence(r11.length(), r10.length());
    L7:
        return r10.subSequence(0, r10.length());
    }

    public static String removePrefix(String r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (startsWith$default(r10, r11, false, 2, null) == false) goto L6;
        String r12 = r10.substring(r11.length());
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
        return r12;
    L6:
        return r10;
    }

    public static final CharSequence removeRange(CharSequence r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r12 < r11) goto L11;
        if (r12 == r11) goto L7;
        StringBuilder r13 = new StringBuilder(r10.length() - (r12 - r11));
        r13.append(r10, 0, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "this.append(value, startIndex, endIndex)");
        r13.append(r10, r12, r10.length());
        Intrinsics.checkNotNullExpressionValue(r13, "this.append(value, startIndex, endIndex)");
        return r13;
    L7:
        return r10.subSequence(0, r10.length());
    L11:
        throw new IndexOutOfBoundsException("End index (" + r12 + ") is less than start index (" + r11 + ").");
    }

    public static final CharSequence removeRange(CharSequence r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        return removeRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1);
    }

    @InlineOnly
    private static final String removeRange(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return removeRange(r10, r11, r12).toString();
    }

    @InlineOnly
    private static final String removeRange(String r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        return removeRange(r10, r11).toString();
    }

    public static final CharSequence removeSuffix(CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (endsWith$default(r10, r11, false, 2, null) == false) goto L7;
        return r10.subSequence(0, r10.length() - r11.length());
    L7:
        return r10.subSequence(0, r10.length());
    }

    public static String removeSuffix(String r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (endsWith$default(r10, r11, false, 2, null) == false) goto L6;
        String r12 = r10.substring(0, r10.length() - r11.length());
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
        return r12;
    L6:
        return r10;
    }

    public static final CharSequence removeSurrounding(CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        return removeSurrounding(r10, r11, r11);
    }

    public static final CharSequence removeSurrounding(CharSequence r10, CharSequence r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        Intrinsics.checkNotNullParameter(r12, "suffix");
        if (r10.length() < (r11.length() + r12.length())) goto L11;
        if (startsWith$default(r10, r11, false, 2, null) == false) goto L11;
        if (endsWith$default(r10, r12, false, 2, null) == false) goto L11;
        return r10.subSequence(r11.length(), r10.length() - r12.length());
    L11:
        return r10.subSequence(0, r10.length());
    }

    public static final String removeSurrounding(String r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        return removeSurrounding(r10, r11, r11);
    }

    public static final String removeSurrounding(String r10, CharSequence r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        Intrinsics.checkNotNullParameter(r12, "suffix");
        if (r10.length() >= (r11.length() + r12.length())) goto L5;
        return r10;
    L5:
        if (startsWith$default(r10, r11, false, 2, null) == true) goto L7;
        return r10;
    L7:
        if (endsWith$default(r10, r12, false, 2, null) == false) goto L12;
        String r13 = r10.substring(r11.length(), r10.length() - r12.length());
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    L12:
        return r10;
    }

    @InlineOnly
    private static final String replace(CharSequence r10, Regex r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        return r11.replace(r10, r12);
    }

    @InlineOnly
    private static final String replace(CharSequence r10, Regex r11, Function1<? super MatchResult, ? extends CharSequence> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return r11.replace(r10, r12);
    }

    public static final String replaceAfter(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + 1, r10.length(), r12).toString();
    }

    public static final String replaceAfter(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + r11.length(), r10.length(), r12).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String r10, char r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceAfter(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replaceAfter$default(String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceAfter(r10, r11, r12, r13);
    }

    public static final String replaceAfterLast(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + 1, r10.length(), r12).toString();
    }

    public static final String replaceAfterLast(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + r11.length(), r10.length(), r12).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String r10, char r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceAfterLast(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replaceAfterLast$default(String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceAfterLast(r10, r11, r12, r13);
    }

    public static final String replaceBefore(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static final String replaceBefore(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String r10, char r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceBefore(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replaceBefore$default(String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceBefore(r10, r11, r12, r13);
    }

    public static final String replaceBeforeLast(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static final String replaceBeforeLast(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r10, char r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceBeforeLast(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r10;
    L6:
        return replaceBeforeLast(r10, r11, r12, r13);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence r10, Regex r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        return r11.replaceFirst(r10, r12);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithChar(String r10, Function1<? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        char r13 = r11.invoke(Character.valueOf(r10.charAt(0))).charValue();
        String r14 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return r13 + r14;
    L9:
        return r10;
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithCharSequence(String r10, Function1<? super Character, ? extends CharSequence> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11.invoke(Character.valueOf(r10.charAt(0))));
        String r14 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        r13.append(r14);
        return r13.toString();
    L9:
        return r10;
    L5:
        r12 = false;
        goto L6
    }

    public static final CharSequence replaceRange(CharSequence r10, int r11, int r12, CharSequence r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "replacement");
        if (r12 < r11) goto L7;
        StringBuilder r14 = new StringBuilder();
        r14.append(r10, 0, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "this.append(value, startIndex, endIndex)");
        r14.append(r13);
        r14.append(r10, r12, r10.length());
        Intrinsics.checkNotNullExpressionValue(r14, "this.append(value, startIndex, endIndex)");
        return r14;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r12 + ") is less than start index (" + r11 + ").");
    }

    public static final CharSequence replaceRange(CharSequence r10, IntRange r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        return replaceRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1, r12);
    }

    @InlineOnly
    private static final String replaceRange(String r10, int r11, int r12, CharSequence r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "replacement");
        return replaceRange(r10, r11, r12, r13).toString();
    }

    @InlineOnly
    private static final String replaceRange(String r10, IntRange r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        return replaceRange(r10, r11, r12).toString();
    }

    public static final void requireNonNegativeLimit(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r10).toString());
    L4:
        r11 = false;
        goto L5
    }

    @InlineOnly
    private static final List<String> split(CharSequence r10, Regex r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.split(r10, r12);
    }

    public static final List<String> split(CharSequence r10, char[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        if (r11.length == 1) goto L5;
        Iterable r14 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null));
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.add(substring(r10, (IntRange) r16.next()));
        goto L8
    L10:
        return r15;
    L5:
        return split$StringsKt__StringsKt(r10, String.valueOf(r11[0]), r12, r13);
    }

    public static final List<String> split(CharSequence r10, String[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        boolean r14 = true;
        if (r11.length != 1) goto L11;
        String r15 = r11[0];
        if (r15.length() == 0) goto L8;
        r14 = false;
    L8:
        if (r14 == true) goto L11;
        return split$StringsKt__StringsKt(r10, r15, r12, r13);
    L11:
        Iterable r16 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null));
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        r17.add(substring(r10, (IntRange) r18.next()));
        goto L13
    L15:
        return r17;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence r10, String r11, boolean r12, int r13) {
        requireNonNegativeLimit(r13);
        int r14 = 0;
        int r15 = indexOf(r10, r11, 0, r12);
        if (r15 == (-1)) goto L23;
        if (r13 == 1) goto L23;
        if (r13 <= 0) goto L9;
        boolean r16 = true;
    L10:
        int r17 = 10;
        if (r16 == false) goto L13;
        r17 = RangesKt.coerceAtMost(r13, 10);
    L13:
        ArrayList r18 = new ArrayList(r17);
    L14:
        r18.add(r10.subSequence(r14, r15).toString());
        r14 = r11.length() + r15;
        if (r16 == true) goto L17;
    L18:
        r15 = indexOf(r10, r11, r14, r12);
        if (r15 != (-1)) goto L14;
    L20:
        r18.add(r10.subSequence(r14, r10.length()).toString());
        return r18;
    L17:
        if (r18.size() == (r13 - 1)) goto L20;
    L9:
        r16 = false;
    L23:
        return CollectionsKt.listOf(r10.toString());
    }

    static /* synthetic */ List split$default(CharSequence r10, Regex r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.split(r10, r12);
    }

    public static /* synthetic */ List split$default(CharSequence r10, char[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return split(r10, r11, r12, r13);
    }

    public static /* synthetic */ List split$default(CharSequence r10, String[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return split(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Sequence<String> splitToSequence(CharSequence r10, Regex r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.splitToSequence(r10, r12);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r10, char[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null), new AnonymousClass2(r10));
    }

    public static final Sequence<String> splitToSequence(final CharSequence r10, String[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null), new C04641(r10));
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence r10, Regex r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        return r11.splitToSequence(r10, r12);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r10, char[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return splitToSequence(r10, r11, r12, r13);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r10, String[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return splitToSequence(r10, r11, r12, r13);
    }

    public static final boolean startsWith(CharSequence r10, char r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() > 0) goto L5;
        return false;
    L5:
        if (CharsKt__CharKt.equals(r10.charAt(0), r11, r12) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean startsWith(CharSequence r10, CharSequence r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r13 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt.startsWith$default((String) r10, (String) r11, r12, false, 4, null);
    L11:
        return regionMatchesImpl(r10, r12, r11, 0, r11.length(), r13);
    }

    public static final boolean startsWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt.startsWith$default((String) r10, (String) r11, false, 2, null);
    L11:
        return regionMatchesImpl(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return startsWith(r10, r11, r12);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r10, CharSequence r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return startsWith(r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return startsWith(r10, r11, r12);
    }

    public static final CharSequence subSequence(CharSequence r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        return r10.subSequence(r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.subSequence(r11, r12);
    }

    @InlineOnly
    private static final String substring(CharSequence r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.subSequence(r11, r12).toString();
    }

    public static final String substring(CharSequence r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        return r10.subSequence(r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substring(String r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        String r12 = r10.substring(r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
        return r12;
    }

    static /* synthetic */ String substring$default(CharSequence r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = r10.length();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.subSequence(r11, r12).toString();
    }

    public static final String substringAfter(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + 1, r10.length());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static String substringAfter(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + r11.length(), r10.length());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String substringAfter$default(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return substringAfter(r10, r11, r12);
    }

    public static /* synthetic */ String substringAfter$default(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return StringsKt.substringAfter(r10, r11, r12);
    }

    public static String substringAfterLast(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + 1, r10.length());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static final String substringAfterLast(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + r11.length(), r10.length());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String substringAfterLast$default(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return StringsKt.substringAfterLast(r10, r11, r12);
    }

    public static /* synthetic */ String substringAfterLast$default(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return substringAfterLast(r10, r11, r12);
    }

    public static final String substringBefore(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(0, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static final String substringBefore(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(0, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String substringBefore$default(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return substringBefore(r10, r11, r12);
    }

    public static /* synthetic */ String substringBefore$default(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return substringBefore(r10, r11, r12);
    }

    public static final String substringBeforeLast(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(0, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static String substringBeforeLast(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(0, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String substringBeforeLast$default(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return substringBeforeLast(r10, r11, r12);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return StringsKt.substringBeforeLast(r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    public static boolean toBooleanStrict(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10, "true") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r10, "false") == false) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + r10);
    }

    @SinceKotlin(version = "1.5")
    public static final Boolean toBooleanStrictOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10, "true") == false) goto L6;
        return Boolean.TRUE;
    L6:
        if (Intrinsics.areEqual(r10, "false") == true) goto L11;
        return null;
    L11:
        return Boolean.FALSE;
    }

    public static CharSequence trim(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = CharsKt.isWhitespace(r10.charAt(r14));
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r10.subSequence(r12, r11 + 1);
    }

    public static final CharSequence trim(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 > r12) goto L16;
        if (r14 == true) goto L6;
        int r15 = r13;
    L7:
        boolean r16 = r11.invoke(Character.valueOf(r10.charAt(r15))).booleanValue();
        if (r14 == false) goto L9;
        if (r16 == false) goto L16;
        r12 = r12 - 1;
        goto L3
    L9:
        if (r16 == false) goto L10;
        r13 = r13 + 1;
        goto L3
    L10:
        r14 = true;
        goto L3
    L6:
        r15 = r12;
    L16:
        return r10.subSequence(r13, r12 + 1);
    }

    public static final CharSequence trim(CharSequence r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length() - 1;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 > r12) goto L16;
        if (r14 == true) goto L6;
        int r15 = r13;
    L7:
        boolean r16 = ArraysKt.contains(r11, r10.charAt(r15));
        if (r14 == false) goto L9;
        if (r16 == false) goto L16;
        r12 = r12 - 1;
        goto L3
    L9:
        if (r16 == false) goto L10;
        r13 = r13 + 1;
        goto L3
    L10:
        r14 = true;
        goto L3
    L6:
        r15 = r12;
    L16:
        return r10.subSequence(r13, r12 + 1);
    }

    @InlineOnly
    private static final String trim(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return StringsKt.trim(r10).toString();
    }

    public static final String trim(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 > r12) goto L16;
        if (r14 == true) goto L6;
        int r15 = r13;
    L7:
        boolean r16 = r11.invoke(Character.valueOf(r10.charAt(r15))).booleanValue();
        if (r14 == false) goto L9;
        if (r16 == false) goto L16;
        r12 = r12 - 1;
        goto L3
    L9:
        if (r16 == false) goto L10;
        r13 = r13 + 1;
        goto L3
    L10:
        r14 = true;
        goto L3
    L6:
        r15 = r12;
    L16:
        return r10.subSequence(r13, r12 + 1).toString();
    }

    public static String trim(String r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length() - 1;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 > r12) goto L16;
        if (r14 == true) goto L6;
        int r15 = r13;
    L7:
        boolean r16 = ArraysKt.contains(r11, r10.charAt(r15));
        if (r14 == false) goto L9;
        if (r16 == false) goto L16;
        r12 = r12 - 1;
        goto L3
    L9:
        if (r16 == false) goto L10;
        r13 = r13 + 1;
        goto L3
    L10:
        r14 = true;
        goto L3
    L6:
        r15 = r12;
    L16:
        return r10.subSequence(r13, r12 + 1).toString();
    }

    public static final CharSequence trimEnd(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length() - 1;
        if (r11 < 0) goto L10;
    L4:
        int r12 = r11 - 1;
        if (CharsKt.isWhitespace(r10.charAt(r11)) == false) goto L14;
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L14:
        return r10.subSequence(0, r11 + 1);
    L10:
        return "";
    }

    public static final CharSequence trimEnd(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return "";
    L7:
        return r10.subSequence(0, r12 + 1);
    L11:
        return "";
    }

    public static final CharSequence trimEnd(CharSequence r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (ArraysKt.contains(r11, r10.charAt(r12)) == false) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return r10.subSequence(0, r12 + 1);
    L10:
        return "";
    }

    @InlineOnly
    private static final String trimEnd(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return trimEnd(r10).toString();
    }

    public static final String trimEnd(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        CharSequence r14 = r10.subSequence(0, r12 + 1);
    L12:
        return r14.toString();
    L10:
        r14 = "";
        goto L12
    }

    public static final String trimEnd(String r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (ArraysKt.contains(r11, r10.charAt(r12)) == false) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        CharSequence r14 = r10.subSequence(0, r12 + 1);
    L12:
        return r14.toString();
    L10:
        r14 = "";
        goto L12
    }

    public static final CharSequence trimStart(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (CharsKt.isWhitespace(r10.charAt(r12)) == false) goto L12;
        r12 = r12 + 1;
        goto L3
    L12:
        return r10.subSequence(r12, r10.length());
    L8:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return r10.subSequence(r13, r10.length());
    L9:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (ArraysKt.contains(r11, r10.charAt(r13)) == false) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r10.subSequence(r13, r10.length());
    L8:
        return "";
    }

    @InlineOnly
    private static final String trimStart(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return trimStart(r10).toString();
    }

    public static final String trimStart(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        CharSequence r14 = r10.subSequence(r13, r10.length());
    L10:
        return r14.toString();
    L8:
        r14 = "";
        goto L10
    }

    public static final String trimStart(String r10, char... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (ArraysKt.contains(r11, r10.charAt(r13)) == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        CharSequence r14 = r10.subSequence(r13, r10.length());
    L10:
        return r14.toString();
    L8:
        r14 = "";
        goto L10
    }
}
