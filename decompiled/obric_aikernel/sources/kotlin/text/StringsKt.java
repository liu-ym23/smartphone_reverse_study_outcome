package kotlin.text;

import java.util.Comparator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class StringsKt extends StringsKt___StringsKt {
    private StringsKt() {
    }

    public static /* bridge */ /* synthetic */ StringBuilder append(StringBuilder r10, String... r11) {
        return StringsKt__StringBuilderKt.append(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> void appendElement(Appendable r10, T r11, Function1<? super T, ? extends CharSequence> r12) {
        StringsKt__AppendableKt.appendElement(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ String concatToString(char[] r10) {
        return StringsKt__StringsJVMKt.concatToString(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ String concatToString(char[] r10, int r11, int r12) {
        return StringsKt__StringsJVMKt.concatToString(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean contains(CharSequence r10, CharSequence r11, boolean r12) {
        return StringsKt__StringsKt.contains(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsKt.contains$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsKt.contains$default(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ String decodeToString(byte[] r10) {
        return StringsKt__StringsJVMKt.decodeToString(r10);
    }

    public static /* bridge */ /* synthetic */ String drop(String r10, int r11) {
        return StringsKt___StringsKt.drop(r10, r11);
    }

    public static /* bridge */ /* synthetic */ String dropLast(String r10, int r11) {
        return StringsKt___StringsKt.dropLast(r10, r11);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith(String r10, String r11, boolean r12) {
        return StringsKt__StringsJVMKt.endsWith(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsKt.endsWith$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(String r10, String r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsJVMKt.endsWith$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ boolean equals(String r10, String r11, boolean r12) {
        return StringsKt__StringsJVMKt.equals(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(String r10, String r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsJVMKt.equals$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ Character firstOrNull(CharSequence r10) {
        return StringsKt___StringsKt.firstOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject r10) {
        return StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(CharSequence r10) {
        return StringsKt__StringsKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(CharSequence r10) {
        return StringsKt__StringsKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsKt.indexOf$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsKt.indexOf$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ boolean isBlank(CharSequence r10) {
        return StringsKt__StringsJVMKt.isBlank(r10);
    }

    public static /* bridge */ /* synthetic */ char last(CharSequence r10) {
        return StringsKt___StringsKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsKt.lastIndexOf$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsKt.lastIndexOf$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ String padStart(String r10, int r11, char r12) {
        return StringsKt__StringsKt.padStart(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches(String r10, int r11, String r12, int r13, int r14, boolean r15) {
        return StringsKt__StringsJVMKt.regionMatches(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches$default(String r10, int r11, String r12, int r13, int r14, boolean r15, int r16, Object r17) {
        return StringsKt__StringsJVMKt.regionMatches$default(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* bridge */ /* synthetic */ String removePrefix(String r10, CharSequence r11) {
        return StringsKt__StringsKt.removePrefix(r10, r11);
    }

    public static /* bridge */ /* synthetic */ String removeSuffix(String r10, CharSequence r11) {
        return StringsKt__StringsKt.removeSuffix(r10, r11);
    }

    public static /* bridge */ /* synthetic */ String repeat(CharSequence r10, int r11) {
        return StringsKt__StringsJVMKt.repeat(r10, r11);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r10, char r11, char r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsJVMKt.replace$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsJVMKt.replace$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r10, char[] r11, boolean r12, int r13, int r14, Object r15) {
        return StringsKt__StringsKt.split$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r10, String[] r11, boolean r12, int r13, int r14, Object r15) {
        return StringsKt__StringsKt.split$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r10, String r11, int r12, boolean r13) {
        return StringsKt__StringsJVMKt.startsWith(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r10, String r11, boolean r12) {
        return StringsKt__StringsJVMKt.startsWith(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r10, char r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsKt.startsWith$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String r10, String r11, int r12, boolean r13, int r14, Object r15) {
        return StringsKt__StringsJVMKt.startsWith$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String r10, String r11, boolean r12, int r13, Object r14) {
        return StringsKt__StringsJVMKt.startsWith$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringAfter(String r10, String r11, String r12) {
        return StringsKt__StringsKt.substringAfter(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r10, char r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringAfter$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r10, String r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringAfter$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast(String r10, char r11, String r12) {
        return StringsKt__StringsKt.substringAfterLast(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String r10, char r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringAfterLast$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r10, char r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringBefore$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r10, String r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringBefore$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast(String r10, String r11, String r12) {
        return StringsKt__StringsKt.substringBeforeLast(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String r10, String r11, String r12, int r13, Object r14) {
        return StringsKt__StringsKt.substringBeforeLast$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ String take(String r10, int r11) {
        return StringsKt___StringsKt.take(r10, r11);
    }

    @SinceKotlin(version = "1.5")
    public static /* bridge */ /* synthetic */ boolean toBooleanStrict(String r10) {
        return StringsKt__StringsKt.toBooleanStrict(r10);
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ Integer toIntOrNull(String r10) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(r10);
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ Long toLongOrNull(String r10) {
        return StringsKt__StringNumberConversionsKt.toLongOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ CharSequence trim(CharSequence r10) {
        return StringsKt__StringsKt.trim(r10);
    }

    public static /* bridge */ /* synthetic */ String trim(String r10, char... r11) {
        return StringsKt__StringsKt.trim(r10, r11);
    }

    @IntrinsicConstEvaluation
    public static /* bridge */ /* synthetic */ String trimIndent(String r10) {
        return StringsKt__IndentKt.trimIndent(r10);
    }

    public static /* bridge */ /* synthetic */ String trimMargin$default(String r10, String r11, int r12, Object r13) {
        return StringsKt__IndentKt.trimMargin$default(r10, r11, r12, r13);
    }
}
