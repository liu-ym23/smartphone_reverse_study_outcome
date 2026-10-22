package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2486:1\n126#1,2:2487\n214#1,5:2489\n502#1,5:2495\n502#1,5:2500\n462#1:2505\n1183#1,2:2506\n463#1,2:2508\n1185#1:2510\n465#1:2511\n462#1:2512\n1183#1,2:2513\n463#1,2:2515\n1185#1:2517\n465#1:2518\n1183#1,3:2519\n492#1,2:2522\n492#1,2:2524\n750#1,4:2526\n719#1,4:2530\n735#1,4:2534\n782#1,4:2538\n882#1,5:2542\n923#1,3:2547\n926#1,3:2557\n941#1,3:2560\n944#1,3:2570\n1041#1,3:2587\n1011#1,4:2590\n1000#1:2594\n1183#1,2:2595\n1185#1:2598\n1001#1:2599\n1183#1,3:2600\n1032#1:2603\n1174#1:2604\n1175#1:2606\n1033#1:2607\n1174#1,2:2608\n1183#1,3:2610\n1982#1,2:2613\n1984#1,6:2616\n2006#1,2:2622\n2008#1,6:2625\n2431#1,6:2631\n2461#1,7:2637\n1#2:2494\n1#2:2597\n1#2:2605\n1#2:2615\n1#2:2624\n372#3,7:2550\n372#3,7:2563\n372#3,7:2573\n372#3,7:2580\n*S KotlinDebug\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n52#1:2487,2\n62#1:2489,5\n420#1:2495,5\n429#1:2500,5\n440#1:2505\n440#1:2506,2\n440#1:2508,2\n440#1:2510\n440#1:2511\n451#1:2512\n451#1:2513,2\n451#1:2515,2\n451#1:2517\n451#1:2518\n462#1:2519,3\n474#1:2522,2\n483#1:2524,2\n677#1:2526,4\n692#1:2530,4\n706#1:2534,4\n769#1:2538,4\n842#1:2542,5\n898#1:2547,3\n898#1:2557,3\n911#1:2560,3\n911#1:2570,3\n970#1:2587,3\n980#1:2590,4\n990#1:2594\n990#1:2595,2\n990#1:2598\n990#1:2599\n1000#1:2600,3\n1024#1:2603\n1024#1:2604\n1024#1:2606\n1024#1:2607\n1032#1:2608,2\n1786#1:2610,3\n2077#1:2613,2\n2077#1:2616,6\n2095#1:2622,2\n2095#1:2625,6\n2420#1:2631,6\n2448#1:2637,7\n990#1:2597\n1024#1:2605\n2077#1:2615\n2095#1:2624\n898#1:2550,7\n911#1:2563,7\n925#1:2573,7\n943#1:2580,7\n*E\n"})
class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public StringsKt___StringsKt() {
    }

    public static final boolean all(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static final boolean any(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L7:
        return !r11;
    L5:
        r11 = false;
        goto L7
    }

    public static final boolean any(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L10;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static final Iterable<Character> asIterable(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof String) == false) goto L12;
        if (r10.length() != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L12;
        return CollectionsKt.emptyList();
    L7:
        r11 = false;
    L12:
        return new StringsKt___StringsKt$asIterable$$inlined$Iterable$1(r10);
    }

    public static final Sequence<Character> asSequence(final CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof String) == false) goto L12;
        if (r10.length() != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L12;
        return SequencesKt.emptySequence();
    L7:
        r11 = false;
    L12:
        return new StringsKt___StringsKt$asSequence$$inlined$Sequence$1(r10);
    }

    public static final <K, V> Map<K, V> associate(CharSequence r10, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r10.length()), 16));
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        Pair<? extends K, ? extends V> r14 = r11.invoke(Character.valueOf(r10.charAt(r13)));
        r12.put(r14.getFirst(), r14.getSecond());
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final <K> Map<K, Character> associateBy(CharSequence r10, Function1<? super Character, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r10.length()), 16));
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        char r14 = r10.charAt(r13);
        r12.put(r11.invoke(Character.valueOf(r14)), Character.valueOf(r14));
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final <K, V> Map<K, V> associateBy(CharSequence r10, Function1<? super Character, ? extends K> r11, Function1<? super Character, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r10.length()), 16));
        int r14 = 0;
    L4:
        if (r14 >= r10.length()) goto L6;
        char r15 = r10.charAt(r14);
        r13.put(r11.invoke(Character.valueOf(r15)), r12.invoke(Character.valueOf(r15)));
        r14 = r14 + 1;
        goto L4
    L6:
        return r13;
    }

    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(CharSequence r10, M r11, Function1<? super Character, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        char r14 = r10.charAt(r13);
        r11.put(r12.invoke(Character.valueOf(r14)), Character.valueOf(r14));
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(CharSequence r10, M r11, Function1<? super Character, ? extends K> r12, Function1<? super Character, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = 0;
    L4:
        if (r14 >= r10.length()) goto L6;
        char r15 = r10.charAt(r14);
        r11.put(r12.invoke(Character.valueOf(r15)), r13.invoke(Character.valueOf(r15)));
        r14 = r14 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(CharSequence r10, M r11, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        Pair<? extends K, ? extends V> r14 = r12.invoke(Character.valueOf(r10.charAt(r13)));
        r11.put(r14.getFirst(), r14.getSecond());
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final <V> Map<Character, V> associateWith(CharSequence r10, Function1<? super Character, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(RangesKt.coerceAtMost(r10.length(), 128)), 16));
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        char r14 = r10.charAt(r13);
        r12.put(Character.valueOf(r14), r11.invoke(Character.valueOf(r14)));
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(CharSequence r10, M r11, Function1<? super Character, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        char r14 = r10.charAt(r13);
        r11.put(Character.valueOf(r14), r12.invoke(Character.valueOf(r14)));
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.2")
    public static final List<String> chunked(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return windowed(r10, r11, r11, true);
    }

    @SinceKotlin(version = "1.2")
    public static final <R> List<R> chunked(CharSequence r10, int r11, Function1<? super CharSequence, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return windowed(r10, r11, r11, true, r12);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<String> chunkedSequence(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return chunkedSequence(r10, r11, AnonymousClass1.INSTANCE);
    }

    @SinceKotlin(version = "1.2")
    public static final <R> Sequence<R> chunkedSequence(CharSequence r10, int r11, Function1<? super CharSequence, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return windowedSequence(r10, r11, r11, true, r12);
    }

    @InlineOnly
    private static final int count(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.length();
    }

    public static final int count(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length()) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L8;
        r13 = r13 + 1;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r13;
    }

    public static final CharSequence drop(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return r10.subSequence(RangesKt.coerceAtMost(r11, r10.length()), r10.length());
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static String drop(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        String r13 = r10.substring(RangesKt.coerceAtMost(r11, r10.length()));
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
        return r13;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final CharSequence dropLast(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return take(r10, RangesKt.coerceAtLeast(r10.length() - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static String dropLast(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return StringsKt.take(r10, RangesKt.coerceAtLeast(r10.length() - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final CharSequence dropLastWhile(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = StringsKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L10;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return r10.subSequence(0, r12 + 1);
    L10:
        return "";
    }

    public static final String dropLastWhile(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = StringsKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L10;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L7;
        r12 = r12 - 1;
        goto L4
    L7:
        String r13 = r10.substring(0, r12 + 1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    L10:
        return "";
    }

    public static final CharSequence dropWhile(CharSequence r10, Function1<? super Character, Boolean> r11) {
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

    public static final String dropWhile(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        String r14 = r10.substring(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return r14;
    L9:
        return "";
    }

    @InlineOnly
    private static final char elementAtOrElse(CharSequence r10, int r11, Function1<? super Integer, Character> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > StringsKt.getLastIndex(r10)) goto L8;
        return r10.charAt(r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).charValue();
    }

    @InlineOnly
    private static final Character elementAtOrNull(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return getOrNull(r10, r11);
    }

    public static final CharSequence filter(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        char r15 = r10.charAt(r14);
        if (r11.invoke(Character.valueOf(r15)).booleanValue() == false) goto L7;
        r12.append(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    public static final String filter(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        char r15 = r10.charAt(r14);
        if (r11.invoke(Character.valueOf(r15)).booleanValue() == false) goto L7;
        r12.append(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        String r16 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "filterTo(StringBuilder(), predicate).toString()");
        return r16;
    }

    public static final CharSequence filterIndexed(CharSequence r10, Function2<? super Integer, ? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r15 = r10.charAt(r13);
        int r16 = r14 + 1;
        if (r11.invoke(Integer.valueOf(r14), Character.valueOf(r15)).booleanValue() == false) goto L8;
        r12.append(r15);
    L8:
        r13 = r13 + 1;
        r14 = r16;
        goto L4
    L9:
        return r12;
    }

    public static final String filterIndexed(String r10, Function2<? super Integer, ? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r15 = r10.charAt(r13);
        int r16 = r14 + 1;
        if (r11.invoke(Integer.valueOf(r14), Character.valueOf(r15)).booleanValue() == false) goto L8;
        r12.append(r15);
    L8:
        r13 = r13 + 1;
        r14 = r16;
        goto L4
    L9:
        String r17 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "filterIndexedTo(StringBu…(), predicate).toString()");
        return r17;
    }

    public static final <C extends Appendable> C filterIndexedTo(CharSequence r10, C r11, Function2<? super Integer, ? super Character, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r15 = r10.charAt(r13);
        int r16 = r14 + 1;
        if (r12.invoke(Integer.valueOf(r14), Character.valueOf(r15)).booleanValue() == false) goto L8;
        r11.append(r15);
    L8:
        r13 = r13 + 1;
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    public static final CharSequence filterNot(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r14 = r10.charAt(r13);
        if (r11.invoke(Character.valueOf(r14)).booleanValue() == true) goto L8;
        r12.append(r14);
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    public static final String filterNot(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r14 = r10.charAt(r13);
        if (r11.invoke(Character.valueOf(r14)).booleanValue() == true) goto L8;
        r12.append(r14);
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        String r15 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "filterNotTo(StringBuilder(), predicate).toString()");
        return r15;
    }

    public static final <C extends Appendable> C filterNotTo(CharSequence r10, C r11, Function1<? super Character, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r14 = r10.charAt(r13);
        if (r12.invoke(Character.valueOf(r14)).booleanValue() == true) goto L8;
        r11.append(r14);
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r11;
    }

    public static final <C extends Appendable> C filterTo(CharSequence r10, C r11, Function1<? super Character, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = r10.length();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        char r15 = r10.charAt(r14);
        if (r12.invoke(Character.valueOf(r15)).booleanValue() == false) goto L7;
        r11.append(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @InlineOnly
    private static final Character find(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L9;
        char r13 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r13)).booleanValue() == true) goto L13;
        r12 = r12 + 1;
        goto L4
    L13:
        return Character.valueOf(r13);
    L9:
        return null;
    }

    @InlineOnly
    private static final Character findLast(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r14)).booleanValue() == true) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return Character.valueOf(r14);
    L10:
        return null;
    }

    public static final char first(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        return r10.charAt(0);
    L10:
        throw new NoSuchElementException("Char sequence is empty.");
    L5:
        r11 = false;
        goto L6
    }

    public static final char first(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L10;
        char r13 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r13)).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r13;
    L10:
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <R> R firstNotNullOf(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L8;
        R r13 = r11.invoke(Character.valueOf(r10.charAt(r12)));
        if (r13 != null) goto L9;
        r12 = r12 + 1;
    L9:
        if (r13 == null) goto L12;
        return r13;
    L12:
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    L8:
        r13 = null;
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <R> R firstNotNullOfOrNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L9;
        R r13 = r11.invoke(Character.valueOf(r10.charAt(r12)));
        if (r13 != null) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r13;
    L9:
        return null;
    }

    public static Character firstOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return null;
    L9:
        return Character.valueOf(r10.charAt(0));
    L5:
        r11 = false;
        goto L6
    }

    public static final Character firstOrNull(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L10;
        char r13 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r13)).booleanValue() == true) goto L8;
        r12 = r12 + 1;
        goto L4
    L8:
        return Character.valueOf(r13);
    L10:
        return null;
    }

    public static final <R> List<R> flatMap(CharSequence r10, Function1<? super Character, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        CollectionsKt.addAll(r12, r11.invoke(Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> flatMapIndexedIterable(CharSequence r10, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(CharSequence r10, C r11, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(CharSequence r10, C r11, Function1<? super Character, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <R> R fold(CharSequence r10, R r11, Function2<? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        R r14 = r11;
        r11 = r12.invoke(r14, Character.valueOf(r10.charAt(r13)));
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <R> R foldIndexed(CharSequence r10, R r11, Function3<? super Integer, ? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        R r15 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r15, Character.valueOf(r10.charAt(r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <R> R foldRight(CharSequence r10, R r11, Function2<? super Character, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = StringsKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Character.valueOf(r10.charAt(r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    public static final <R> R foldRightIndexed(CharSequence r10, R r11, Function3<? super Integer, ? super Character, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = StringsKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Integer.valueOf(r13), Character.valueOf(r10.charAt(r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    public static final void forEach(CharSequence r10, Function1<? super Character, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.invoke(Character.valueOf(r10.charAt(r12)));
        r12 = r12 + 1;
        goto L4
    }

    public static final void forEachIndexed(CharSequence r10, Function2<? super Integer, ? super Character, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.invoke(Integer.valueOf(r13), Character.valueOf(r10.charAt(r12)));
        r12 = r12 + 1;
        r13 = r13 + 1;
        goto L4
    }

    @InlineOnly
    private static final char getOrElse(CharSequence r10, int r11, Function1<? super Integer, Character> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > StringsKt.getLastIndex(r10)) goto L8;
        return r10.charAt(r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).charValue();
    }

    public static final Character getOrNull(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > StringsKt.getLastIndex(r10)) goto L7;
        return Character.valueOf(r10.charAt(r11));
    }

    public static final <K> Map<K, List<Character>> groupBy(CharSequence r10, Function1<? super Character, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r14 = r10.charAt(r13);
        K r15 = r11.invoke(Character.valueOf(r14));
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(Character.valueOf(r14));
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    public static final <K, V> Map<K, List<V>> groupBy(CharSequence r10, Function1<? super Character, ? extends K> r11, Function1<? super Character, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        int r14 = 0;
    L4:
        if (r14 >= r10.length()) goto L9;
        char r15 = r10.charAt(r14);
        K r16 = r11.invoke(Character.valueOf(r15));
        List<V> r17 = r13.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r13.put(r16, r17);
    L8:
        r17.add(r12.invoke(Character.valueOf(r15)));
        r14 = r14 + 1;
        goto L4
    L9:
        return r13;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(CharSequence r10, M r11, Function1<? super Character, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        char r14 = r10.charAt(r13);
        K r15 = r12.invoke(Character.valueOf(r14));
        Object r16 = r11.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r11.put(r15, r16);
    L8:
        ((List) r16).add(Character.valueOf(r14));
        r13 = r13 + 1;
        goto L4
    L9:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(CharSequence r10, M r11, Function1<? super Character, ? extends K> r12, Function1<? super Character, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = 0;
    L4:
        if (r14 >= r10.length()) goto L9;
        char r15 = r10.charAt(r14);
        K r16 = r12.invoke(Character.valueOf(r15));
        Object r17 = r11.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L8:
        ((List) r17).add(r13.invoke(Character.valueOf(r15)));
        r14 = r14 + 1;
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <K> Grouping<Character, K> groupingBy(final CharSequence r10, final Function1<? super Character, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        return new C04651(r10, r11);
    }

    public static final int indexOfFirst(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return -1;
    }

    public static final int indexOfLast(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r12;
    L10:
        return -1;
    }

    public static char last(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        return r10.charAt(StringsKt.getLastIndex(r10));
    L10:
        throw new NoSuchElementException("Char sequence is empty.");
    L5:
        r11 = false;
        goto L6
    }

    public static final char last(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r14)).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r14;
    L10:
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final Character lastOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return null;
    L9:
        return Character.valueOf(r10.charAt(r10.length() - 1));
    L5:
        r11 = false;
        goto L6
    }

    public static final Character lastOrNull(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length() - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r14)).booleanValue() == true) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return null;
    L7:
        return Character.valueOf(r14);
    L11:
        return null;
    }

    public static final <R> List<R> map(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(r10.length());
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12.add(r11.invoke(Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final <R> List<R> mapIndexed(CharSequence r10, Function2<? super Integer, ? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(r10.length());
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12.add(r11.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final <R> List<R> mapIndexedNotNull(CharSequence r10, Function2<? super Integer, ? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        int r15 = r14 + 1;
        R r16 = r11.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13)));
        if (r16 == null) goto L8;
        r12.add(r16);
    L8:
        r13 = r13 + 1;
        r14 = r15;
        goto L4
    L9:
        return r12;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(CharSequence r10, C r11, Function2<? super Integer, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        int r15 = r14 + 1;
        R r16 = r12.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13)));
        if (r16 == null) goto L8;
        r11.add(r16);
    L8:
        r13 = r13 + 1;
        r14 = r15;
        goto L4
    L9:
        return r11;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(CharSequence r10, C r11, Function2<? super Integer, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r11.add(r12.invoke(Integer.valueOf(r14), Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <R> List<R> mapNotNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        R r14 = r11.invoke(Character.valueOf(r10.charAt(r13)));
        if (r14 == null) goto L8;
        r12.add(r14);
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    public static final <R, C extends Collection<? super R>> C mapNotNullTo(CharSequence r10, C r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        R r14 = r12.invoke(Character.valueOf(r10.charAt(r13)));
        if (r14 == null) goto L8;
        r11.add(r14);
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r11;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(CharSequence r10, C r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r11.add(r12.invoke(Character.valueOf(r10.charAt(r13))));
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final <R extends Comparable<? super R>> Character maxByOrNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 == 0) goto L12;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L15:
        if (r16.hasNext() == false) goto L20;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L15;
        r13 = r17;
        r15 = r18;
        goto L15
    L20:
        return Character.valueOf(r13);
    L12:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char maxByOrThrow(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L18;
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 != 0) goto L10;
        return r13;
    L10:
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L12:
        if (r16.hasNext() == false) goto L16;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L12;
        r13 = r17;
        r15 = r18;
        goto L12
    L16:
        return r13;
    L18:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double maxOf(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        double r13 = r11.invoke(Character.valueOf(r10.charAt(0))).doubleValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).doubleValue());
        goto L9
    L11:
        return r13;
    L13:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1350maxOf(CharSequence r10, Function1<? super Character, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        float r13 = r11.invoke(Character.valueOf(r10.charAt(0))).floatValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).floatValue());
        goto L9
    L11:
        return r13;
    L13:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1351maxOf(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L15;
        R r13 = r11.invoke(Character.valueOf(r10.charAt(0)));
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L13;
        R r15 = r11.invoke(Character.valueOf(r10.charAt(r14.nextInt())));
        if (r13.compareTo(r15) >= 0) goto L9;
        r13 = r15;
        goto L9
    L13:
        return r13;
    L15:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R maxOfOrNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        R r13 = r11.invoke(Character.valueOf(r10.charAt(0)));
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L15;
        R r15 = r11.invoke(Character.valueOf(r10.charAt(r14.nextInt())));
        if (r13.compareTo(r15) >= 0) goto L11;
        r13 = r15;
        goto L11
    L15:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1352maxOfOrNull(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        double r13 = r11.invoke(Character.valueOf(r10.charAt(0))).doubleValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13 = Math.max(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).doubleValue());
        goto L11
    L14:
        return Double.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1353maxOfOrNull(CharSequence r10, Function1<? super Character, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        float r13 = r11.invoke(Character.valueOf(r10.charAt(0))).floatValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13 = Math.max(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).floatValue());
        goto L11
    L14:
        return Float.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R maxOfWith(CharSequence r10, Comparator<? super R> r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L15;
        R r14 = r12.invoke(Character.valueOf(r10.charAt(0)));
        ?? r15 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        R r16 = r12.invoke(Character.valueOf(r10.charAt(r15.nextInt())));
        if (r11.compare(r14, r16) >= 0) goto L9;
        r14 = r16;
        goto L9
    L13:
        return r14;
    L15:
        throw new NoSuchElementException();
    L5:
        r13 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R maxOfWithOrNull(CharSequence r10, Comparator<? super R> r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L9;
        return null;
    L9:
        R r14 = r12.invoke(Character.valueOf(r10.charAt(0)));
        ?? r15 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r15.hasNext() == false) goto L15;
        R r16 = r12.invoke(Character.valueOf(r10.charAt(r15.nextInt())));
        if (r11.compare(r14, r16) >= 0) goto L11;
        r14 = r16;
        goto L11
    L15:
        return r14;
    L5:
        r13 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final Character maxOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return null;
    L9:
        char r12 = r10.charAt(0);
        ?? r13 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r13.hasNext() == false) goto L16;
        char r14 = r10.charAt(r13.nextInt());
        if (Intrinsics.compare(r12, r14) >= 0) goto L11;
        r12 = r14;
        goto L11
    L16:
        return Character.valueOf(r12);
    L5:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final char maxOrThrow(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L15;
        char r12 = r10.charAt(0);
        ?? r13 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r13.hasNext() == false) goto L13;
        char r14 = r10.charAt(r13.nextInt());
        if (Intrinsics.compare(r12, r14) >= 0) goto L9;
        r12 = r14;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    L5:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final Character maxWithOrNull(CharSequence r10, Comparator<? super Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L16;
        char r15 = r10.charAt(r14.nextInt());
        if (r11.compare(Character.valueOf(r13), Character.valueOf(r15)) >= 0) goto L11;
        r13 = r15;
        goto L11
    L16:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final char maxWithOrThrow(CharSequence r10, Comparator<? super Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L15;
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L13;
        char r15 = r10.charAt(r14.nextInt());
        if (r11.compare(Character.valueOf(r13), Character.valueOf(r15)) >= 0) goto L9;
        r13 = r15;
        goto L9
    L13:
        return r13;
    L15:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final <R extends Comparable<? super R>> Character minByOrNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 == 0) goto L12;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L15:
        if (r16.hasNext() == false) goto L20;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L15;
        r13 = r17;
        r15 = r18;
        goto L15
    L20:
        return Character.valueOf(r13);
    L12:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char minByOrThrow(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L18;
        char r13 = r10.charAt(0);
        int r14 = StringsKt.getLastIndex(r10);
        if (r14 != 0) goto L10;
        return r13;
    L10:
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L12:
        if (r16.hasNext() == false) goto L16;
        char r17 = r10.charAt(r16.nextInt());
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L12;
        r13 = r17;
        r15 = r18;
        goto L12
    L16:
        return r13;
    L18:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double minOf(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        double r13 = r11.invoke(Character.valueOf(r10.charAt(0))).doubleValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).doubleValue());
        goto L9
    L11:
        return r13;
    L13:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1354minOf(CharSequence r10, Function1<? super Character, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        float r13 = r11.invoke(Character.valueOf(r10.charAt(0))).floatValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).floatValue());
        goto L9
    L11:
        return r13;
    L13:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1355minOf(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L15;
        R r13 = r11.invoke(Character.valueOf(r10.charAt(0)));
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L13;
        R r15 = r11.invoke(Character.valueOf(r10.charAt(r14.nextInt())));
        if (r13.compareTo(r15) <= 0) goto L9;
        r13 = r15;
        goto L9
    L13:
        return r13;
    L15:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R minOfOrNull(CharSequence r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        R r13 = r11.invoke(Character.valueOf(r10.charAt(0)));
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L15;
        R r15 = r11.invoke(Character.valueOf(r10.charAt(r14.nextInt())));
        if (r13.compareTo(r15) <= 0) goto L11;
        r13 = r15;
        goto L11
    L15:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1356minOfOrNull(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        double r13 = r11.invoke(Character.valueOf(r10.charAt(0))).doubleValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13 = Math.min(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).doubleValue());
        goto L11
    L14:
        return Double.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1357minOfOrNull(CharSequence r10, Function1<? super Character, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        float r13 = r11.invoke(Character.valueOf(r10.charAt(0))).floatValue();
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13 = Math.min(r13, r11.invoke(Character.valueOf(r10.charAt(r14.nextInt()))).floatValue());
        goto L11
    L14:
        return Float.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R minOfWith(CharSequence r10, Comparator<? super R> r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L15;
        R r14 = r12.invoke(Character.valueOf(r10.charAt(0)));
        ?? r15 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        R r16 = r12.invoke(Character.valueOf(r10.charAt(r15.nextInt())));
        if (r11.compare(r14, r16) <= 0) goto L9;
        r14 = r16;
        goto L9
    L13:
        return r14;
    L15:
        throw new NoSuchElementException();
    L5:
        r13 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R minOfWithOrNull(CharSequence r10, Comparator<? super R> r11, Function1<? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L9;
        return null;
    L9:
        R r14 = r12.invoke(Character.valueOf(r10.charAt(0)));
        ?? r15 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r15.hasNext() == false) goto L15;
        R r16 = r12.invoke(Character.valueOf(r10.charAt(r15.nextInt())));
        if (r11.compare(r14, r16) <= 0) goto L11;
        r14 = r16;
        goto L11
    L15:
        return r14;
    L5:
        r13 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final Character minOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return null;
    L9:
        char r12 = r10.charAt(0);
        ?? r13 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r13.hasNext() == false) goto L16;
        char r14 = r10.charAt(r13.nextInt());
        if (Intrinsics.compare(r12, r14) <= 0) goto L11;
        r12 = r14;
        goto L11
    L16:
        return Character.valueOf(r12);
    L5:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final char minOrThrow(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L15;
        char r12 = r10.charAt(0);
        ?? r13 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r13.hasNext() == false) goto L13;
        char r14 = r10.charAt(r13.nextInt());
        if (Intrinsics.compare(r12, r14) <= 0) goto L9;
        r12 = r14;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    L5:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final Character minWithOrNull(CharSequence r10, Comparator<? super Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L16;
        char r15 = r10.charAt(r14.nextInt());
        if (r11.compare(Character.valueOf(r13), Character.valueOf(r15)) <= 0) goto L11;
        r13 = r15;
        goto L11
    L16:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final char minWithOrThrow(CharSequence r10, Comparator<? super Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L15;
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L13;
        char r15 = r10.charAt(r14.nextInt());
        if (r11.compare(Character.valueOf(r13), Character.valueOf(r15)) <= 0) goto L9;
        r13 = r15;
        goto L9
    L13:
        return r13;
    L15:
        throw new NoSuchElementException();
    L5:
        r12 = false;
        goto L6
    }

    public static final boolean none(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean none(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final <S extends CharSequence> S onEach(S r10, Function1<? super Character, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.invoke(Character.valueOf(r10.charAt(r12)));
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    public static final <S extends CharSequence> S onEachIndexed(S r10, Function2<? super Integer, ? super Character, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.invoke(Integer.valueOf(r13), Character.valueOf(r10.charAt(r12)));
        r12 = r12 + 1;
        r13 = r13 + 1;
        goto L4
    L6:
        return r10;
    }

    public static final Pair<CharSequence, CharSequence> partition(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        StringBuilder r13 = new StringBuilder();
        int r14 = 0;
    L4:
        if (r14 >= r10.length()) goto L11;
        char r15 = r10.charAt(r14);
        if (r11.invoke(Character.valueOf(r15)).booleanValue() == false) goto L8;
        r12.append(r15);
    L9:
        r14 = r14 + 1;
        goto L4
    L8:
        r13.append(r15);
        goto L9
    L11:
        return new Pair(r12, r13);
    }

    public static final Pair<String, String> partition(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        StringBuilder r12 = new StringBuilder();
        StringBuilder r13 = new StringBuilder();
        int r14 = r10.length();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L9;
        char r16 = r10.charAt(r15);
        if (r11.invoke(Character.valueOf(r16)).booleanValue() == false) goto L7;
        r12.append(r16);
    L8:
        r15 = r15 + 1;
        goto L3
    L7:
        r13.append(r16);
        goto L8
    L9:
        String r17 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "first.toString()");
        String r18 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "second.toString()");
        return new Pair(r17, r18);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    public static final char random(CharSequence r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L10;
        return r10.charAt(r11.nextInt(r10.length()));
    L10:
        throw new NoSuchElementException("Char sequence is empty.");
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Character randomOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character randomOrNull(CharSequence r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return null;
    L10:
        return Character.valueOf(r10.charAt(r11.nextInt(r10.length())));
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final char reduce(CharSequence r10, Function2<? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13 = r11.invoke(Character.valueOf(r13), Character.valueOf(r10.charAt(r14.nextInt()))).charValue();
        goto L9
    L11:
        return r13;
    L13:
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final char reduceIndexed(CharSequence r10, Function3<? super Integer, ? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L13;
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L9:
        if (r14.hasNext() == false) goto L11;
        int r15 = r14.nextInt();
        r13 = r11.invoke(Integer.valueOf(r15), Character.valueOf(r13), Character.valueOf(r10.charAt(r15))).charValue();
        goto L9
    L11:
        return r13;
    L13:
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    public static final Character reduceIndexedOrNull(CharSequence r10, Function3<? super Integer, ? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        int r15 = r14.nextInt();
        r13 = r11.invoke(Integer.valueOf(r15), Character.valueOf(r13), Character.valueOf(r10.charAt(r15))).charValue();
        goto L11
    L14:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceOrNull(CharSequence r10, Function2<? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return null;
    L9:
        char r13 = r10.charAt(0);
        ?? r14 = new IntRange(1, StringsKt.getLastIndex(r10)).iterator2();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13 = r11.invoke(Character.valueOf(r13), Character.valueOf(r10.charAt(r14.nextInt()))).charValue();
        goto L11
    L14:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    public static final char reduceRight(CharSequence r10, Function2<? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = StringsKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Character.valueOf(r10.charAt(r13)), Character.valueOf(r14)).charValue();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceRightIndexed(CharSequence r10, Function3<? super Integer, ? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = StringsKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Integer.valueOf(r13), Character.valueOf(r10.charAt(r13)), Character.valueOf(r14)).charValue();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final Character reduceRightIndexedOrNull(CharSequence r10, Function3<? super Integer, ? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = StringsKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Integer.valueOf(r13), Character.valueOf(r10.charAt(r13)), Character.valueOf(r14)).charValue();
        r13 = r13 - 1;
        goto L7
    L10:
        return Character.valueOf(r14);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceRightOrNull(CharSequence r10, Function2<? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = StringsKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        char r14 = r10.charAt(r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Character.valueOf(r10.charAt(r13)), Character.valueOf(r14)).charValue();
        r13 = r13 - 1;
        goto L7
    L10:
        return Character.valueOf(r14);
    }

    public static final CharSequence reversed(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r11 = new StringBuilder(r10).reverse();
        Intrinsics.checkNotNullExpressionValue(r11, "StringBuilder(this).reverse()");
        return r11;
    }

    @InlineOnly
    private static final String reversed(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return reversed(r10).toString();
    }

    @SinceKotlin(version = "1.4")
    public static final <R> List<R> runningFold(CharSequence r10, R r11, Function2<? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
        if (r10.length() != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L8;
        ArrayList r15 = new ArrayList(r10.length() + 1);
        r15.add(r11);
    L11:
        if (r13 >= r10.length()) goto L13;
        r11 = r12.invoke(r11, Character.valueOf(r10.charAt(r13)));
        r15.add(r11);
        r13 = r13 + 1;
        goto L11
    L13:
        return r15;
    L8:
        return CollectionsKt.listOf(r11);
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    public static final <R> List<R> runningFoldIndexed(CharSequence r10, R r11, Function3<? super Integer, ? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
        if (r10.length() != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L8;
        ArrayList r15 = new ArrayList(r10.length() + 1);
        r15.add(r11);
        int r16 = r10.length();
    L10:
        if (r13 >= r16) goto L12;
        r11 = r12.invoke(Integer.valueOf(r13), r11, Character.valueOf(r10.charAt(r13)));
        r15.add(r11);
        r13 = r13 + 1;
        goto L10
    L12:
        return r15;
    L8:
        return CollectionsKt.listOf(r11);
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    public static final List<Character> runningReduce(CharSequence r10, Function2<? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = 1;
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L8;
        char r14 = r10.charAt(0);
        ArrayList r15 = new ArrayList(r10.length());
        r15.add(Character.valueOf(r14));
        int r16 = r10.length();
    L10:
        if (r12 >= r16) goto L12;
        r14 = r11.invoke(Character.valueOf(r14), Character.valueOf(r10.charAt(r12))).charValue();
        r15.add(Character.valueOf(r14));
        r12 = r12 + 1;
        goto L10
    L12:
        return r15;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    public static final List<Character> runningReduceIndexed(CharSequence r10, Function3<? super Integer, ? super Character, ? super Character, Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = 1;
        if (r10.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L8;
        char r14 = r10.charAt(0);
        ArrayList r15 = new ArrayList(r10.length());
        r15.add(Character.valueOf(r14));
        int r16 = r10.length();
    L10:
        if (r12 >= r16) goto L12;
        r14 = r11.invoke(Integer.valueOf(r12), Character.valueOf(r14), Character.valueOf(r10.charAt(r12))).charValue();
        r15.add(Character.valueOf(r14));
        r12 = r12 + 1;
        goto L10
    L12:
        return r15;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <R> List<R> scan(CharSequence r10, R r11, Function2<? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
        if (r10.length() != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L15;
        ArrayList r15 = new ArrayList(r10.length() + 1);
        r15.add(r11);
    L10:
        if (r13 >= r10.length()) goto L13;
        r11 = r12.invoke(r11, Character.valueOf(r10.charAt(r13)));
        r15.add(r11);
        r13 = r13 + 1;
        goto L10
    L13:
        return r15;
    L15:
        return CollectionsKt.listOf(r11);
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <R> List<R> scanIndexed(CharSequence r10, R r11, Function3<? super Integer, ? super R, ? super Character, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = 0;
        if (r10.length() != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L14;
        ArrayList r15 = new ArrayList(r10.length() + 1);
        r15.add(r11);
        int r16 = r10.length();
    L9:
        if (r13 >= r16) goto L12;
        r11 = r12.invoke(Integer.valueOf(r13), r11, Character.valueOf(r10.charAt(r13)));
        r15.add(r11);
        r13 = r13 + 1;
        goto L9
    L12:
        return r15;
    L14:
        return CollectionsKt.listOf(r11);
    L5:
        r14 = false;
        goto L6
    }

    public static final char single(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length();
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L9;
        return r10.charAt(0);
    L9:
        throw new IllegalArgumentException("Char sequence has more than one element.");
    L11:
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final char single(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
        Character r13 = null;
        boolean r14 = false;
    L4:
        if (r12 >= r10.length()) goto L12;
        char r15 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r15)).booleanValue() == false) goto L11;
        if (r14 == true) goto L10;
        r13 = Character.valueOf(r15);
        r14 = true;
        goto L11
    L10:
        throw new IllegalArgumentException("Char sequence contains more than one matching element.");
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        if (r14 == false) goto L16;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Char");
        return r13.charValue();
    L16:
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final Character singleOrNull(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() == 1) goto L7;
        return null;
    L7:
        return Character.valueOf(r10.charAt(0));
    }

    public static final Character singleOrNull(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
        boolean r13 = false;
        Character r14 = null;
    L4:
        if (r12 >= r10.length()) goto L11;
        char r15 = r10.charAt(r12);
        if (r11.invoke(Character.valueOf(r15)).booleanValue() == false) goto L10;
        if (r13 == true) goto L8;
        r14 = Character.valueOf(r15);
        r13 = true;
        goto L10
    L8:
        return null;
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        if (r13 == true) goto L13;
        return null;
    L13:
        return r14;
    }

    public static final CharSequence slice(CharSequence r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 != 0) goto L6;
        return "";
    L6:
        StringBuilder r13 = new StringBuilder(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.append(r10.charAt(r14.next().intValue()));
        goto L8
    L10:
        return r13;
    }

    public static final CharSequence slice(CharSequence r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return "";
    L7:
        return StringsKt__StringsKt.subSequence(r10, r11);
    }

    @InlineOnly
    private static final String slice(String r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return slice(r10, r11).toString();
    }

    public static final String slice(String r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return "";
    L7:
        return StringsKt__StringsKt.substring(r10, r11);
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(CharSequence r10, Function1<? super Character, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r13 = r13 + r11.invoke(Character.valueOf(r10.charAt(r12))).intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r13;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = r12 + r11.invoke(Character.valueOf(r10.charAt(r13))).doubleValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double sumOfDouble(CharSequence r10, Function1<? super Character, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = r12 + r11.invoke(Character.valueOf(r10.charAt(r13))).doubleValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final int sumOfInt(CharSequence r10, Function1<? super Character, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r13 = r13 + r11.invoke(Character.valueOf(r10.charAt(r12))).intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long sumOfLong(CharSequence r10, Function1<? super Character, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = r12 + r11.invoke(Character.valueOf(r10.charAt(r13))).longValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int sumOfUInt(CharSequence r10, Function1<? super Character, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = UInt.m127constructorimpl(0);
    L4:
        if (r12 >= r10.length()) goto L6;
        r13 = UInt.m127constructorimpl(r13 + r11.invoke(Character.valueOf(r10.charAt(r12))).m179unboximpl());
        r12 = r12 + 1;
        goto L4
    L6:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long sumOfULong(CharSequence r10, Function1<? super Character, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L6;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(Character.valueOf(r10.charAt(r13))).m258unboximpl());
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final CharSequence take(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return r10.subSequence(0, RangesKt.coerceAtMost(r11, r10.length()));
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static String take(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        String r13 = r10.substring(0, RangesKt.coerceAtMost(r11, r10.length()));
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final CharSequence takeLast(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        int r13 = r10.length();
        return r10.subSequence(r13 - RangesKt.coerceAtMost(r11, r13), r13);
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final String takeLast(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        int r13 = r10.length();
        String r14 = r10.substring(r13 - RangesKt.coerceAtMost(r11, r13));
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return r14;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final CharSequence takeLastWhile(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = StringsKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return r10.subSequence(r12 + 1, r10.length());
    L11:
        return r10.subSequence(0, r10.length());
    }

    public static final String takeLastWhile(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = StringsKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L10;
        if (r11.invoke(Character.valueOf(r10.charAt(r12))).booleanValue() == false) goto L7;
        r12 = r12 - 1;
        goto L4
    L7:
        String r13 = r10.substring(r12 + 1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
        return r13;
    L10:
        return r10;
    }

    public static final CharSequence takeWhile(CharSequence r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return r10.subSequence(0, r13);
    L10:
        return r10.subSequence(0, r10.length());
    }

    public static final String takeWhile(String r10, Function1<? super Character, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(Character.valueOf(r10.charAt(r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        String r14 = r10.substring(0, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    L9:
        return r10;
    }

    public static final <C extends Collection<? super Character>> C toCollection(CharSequence r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.add(Character.valueOf(r10.charAt(r12)));
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final HashSet<Character> toHashSet(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (HashSet) toCollection(r10, new HashSet(MapsKt.mapCapacity(RangesKt.coerceAtMost(r10.length(), 128))));
    }

    public static final List<Character> toList(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return toMutableList(r10);
    L11:
        return CollectionsKt.listOf(Character.valueOf(r10.charAt(0)));
    L9:
        return CollectionsKt.emptyList();
    }

    public static final List<Character> toMutableList(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (List) toCollection(r10, new ArrayList(r10.length()));
    }

    public static final Set<Character> toSet(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return (Set) toCollection(r10, new LinkedHashSet(MapsKt.mapCapacity(RangesKt.coerceAtMost(r10.length(), 128))));
    L11:
        return SetsKt.setOf(Character.valueOf(r10.charAt(0)));
    L9:
        return SetsKt.emptySet();
    }

    @SinceKotlin(version = "1.2")
    public static final List<String> windowed(CharSequence r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return windowed(r10, r11, r12, r13, C04661.INSTANCE);
    }

    @SinceKotlin(version = "1.2")
    public static final <R> List<R> windowed(CharSequence r10, int r11, int r12, boolean r13, Function1<? super CharSequence, ? extends R> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "transform");
        SlidingWindowKt.checkWindowSizeStep(r11, r12);
        int r15 = r10.length();
        int r16 = r15 / r12;
        if ((r15 % r12) != 0) goto L5;
        int r17 = 0;
    L6:
        ArrayList r18 = new ArrayList(r16 + r17);
        int r19 = 0;
    L7:
        if (r19 < 0) goto L10;
        if (r19 >= r15) goto L10;
        boolean r20 = true;
    L11:
        if (r20 == false) goto L18;
        int r21 = r19 + r11;
        if (r21 < 0) goto L15;
        if (r21 > r15) goto L15;
    L17:
        r18.add(r14.invoke(r10.subSequence(r19, r21)));
        r19 = r19 + r12;
    L15:
        if (r13 == false) goto L18;
        r21 = r15;
    L18:
        return r18;
    L10:
        r20 = false;
        goto L11
    L5:
        r17 = 1;
        goto L6
    }

    public static /* synthetic */ List windowed$default(CharSequence r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13);
    }

    public static /* synthetic */ List windowed$default(CharSequence r10, int r11, int r12, boolean r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<String> windowedSequence(CharSequence r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return windowedSequence(r10, r11, r12, r13, C04671.INSTANCE);
    }

    @SinceKotlin(version = "1.2")
    public static final <R> Sequence<R> windowedSequence(final CharSequence r10, final int r11, int r12, boolean r13, final Function1<? super CharSequence, ? extends R> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "transform");
        SlidingWindowKt.checkWindowSizeStep(r11, r12);
        if (r13 == false) goto L5;
        IntRange r15 = StringsKt.getIndices(r10);
    L7:
        return SequencesKt.map(CollectionsKt.asSequence(RangesKt.step(r15, r12)), new AnonymousClass2(r11, r10, r14));
    L5:
        r15 = RangesKt.until(0, (r10.length() - r11) + 1);
        goto L7
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowedSequence(r10, r11, r12, r13);
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence r10, int r11, int r12, boolean r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowedSequence(r10, r11, r12, r13, r14);
    }

    public static final Iterable<IndexedValue<Character>> withIndex(final CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IndexingIterable(new C04681(r10));
    }

    public static final List<Pair<Character, Character>> zip(CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(r10.length(), r11.length());
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        char r15 = r10.charAt(r14);
        char r16 = r11.charAt(r14);
        r13.add(TuplesKt.to(Character.valueOf(r15), Character.valueOf(r16)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    public static final <V> List<V> zip(CharSequence r10, CharSequence r11, Function2<? super Character, ? super Character, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(r10.length(), r11.length());
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(Character.valueOf(r10.charAt(r15)), Character.valueOf(r11.charAt(r15))));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.2")
    public static final List<Pair<Character, Character>> zipWithNext(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length() - 1;
        if (r11 < 1) goto L11;
        ArrayList r12 = new ArrayList(r11);
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L9;
        char r14 = r10.charAt(r13);
        r13 = r13 + 1;
        char r15 = r10.charAt(r13);
        r12.add(TuplesKt.to(Character.valueOf(r14), Character.valueOf(r15)));
        goto L6
    L9:
        return r12;
    L11:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.2")
    public static final <R> List<R> zipWithNext(CharSequence r10, Function2<? super Character, ? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        int r12 = r10.length() - 1;
        if (r12 < 1) goto L5;
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        Character r15 = Character.valueOf(r10.charAt(r14));
        r14 = r14 + 1;
        r13.add(r11.invoke(r15, Character.valueOf(r10.charAt(r14))));
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }
}
