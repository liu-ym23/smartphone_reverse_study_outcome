package kotlin.text;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.room.writer.DaoWriter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class StringsKt extends StringsKt___StringsKt {
    private StringsKt() {
    }

    public static /* bridge */ /* synthetic */ String A(String r5, String r10) {
        return StringsKt__StringsKt.removePrefix(r5, r10);
    }

    public static /* bridge */ /* synthetic */ String B(String r5, String r10) {
        return StringsKt__StringsKt.removeSuffix(r5, r10);
    }

    public static /* bridge */ /* synthetic */ String C(String r5) {
        return StringsKt__StringsKt.removeSurrounding(r5, "\"");
    }

    public static /* bridge */ /* synthetic */ String D(int r5, String r10) {
        return StringsKt__StringsJVMKt.repeat(r10, r5);
    }

    public static /* bridge */ /* synthetic */ String E(String r10, char r11, char r12) {
        return StringsKt__StringsJVMKt.replace$default(r10, r11, r12, false, 4, null);
    }

    public static /* bridge */ /* synthetic */ String F(String r10, String r11, String r12) {
        return StringsKt__StringsJVMKt.replace$default(r10, r11, r12, false, 4, null);
    }

    public static /* bridge */ /* synthetic */ String G(String r10, String r11) {
        return StringsKt__StringsKt.replaceAfterLast$default(r10, '.', r11, null, 4, null);
    }

    public static /* bridge */ /* synthetic */ String H(String r10, String r11, String r12) {
        return StringsKt__StringsJVMKt.replaceFirst$default(r10, r11, r12, false, 4, null);
    }

    public static /* bridge */ /* synthetic */ char I(String r5) {
        return StringsKt___StringsKt.single(r5);
    }

    public static /* bridge */ /* synthetic */ List J(CharSequence r10, char[] r11, int r12, int r13) {
        return StringsKt__StringsKt.split$default(r10, r11, false, r12, r13, null);
    }

    public static /* bridge */ /* synthetic */ List K(CharSequence r10, String[] r11, int r12, int r13) {
        return StringsKt__StringsKt.split$default(r10, r11, false, r12, r13, null);
    }

    public static /* bridge */ /* synthetic */ boolean L(int r5, String r10, String r11) {
        return StringsKt__StringsJVMKt.startsWith(r10, r11, r5, true);
    }

    public static /* bridge */ /* synthetic */ boolean M(String r5, String r10) {
        return StringsKt__StringsJVMKt.startsWith(r5, r10, true);
    }

    public static /* bridge */ /* synthetic */ boolean N(int r10, String r11, String r12) {
        return StringsKt__StringsJVMKt.startsWith$default(r11, r12, r10, false, 4, null);
    }

    public static /* bridge */ /* synthetic */ boolean O(String r5, char r10) {
        return StringsKt__StringsKt.startsWith$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ boolean P(String r5, String r10) {
        return StringsKt__StringsJVMKt.startsWith$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ String Q(String r5, String r10) {
        return StringsKt__StringsKt.substringAfter(r5, r10, "");
    }

    public static /* bridge */ /* synthetic */ String R(String r5) {
        return StringsKt__StringsKt.substringAfter$default(r5, Typography.dollar, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ String S(String r5, String r10) {
        return StringsKt__StringsKt.substringAfter$default(r5, r10, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ String T(String r5) {
        return StringsKt__StringsKt.substringAfterLast(r5, '.', "");
    }

    public static /* bridge */ /* synthetic */ String U(String r5, char r10) {
        return StringsKt__StringsKt.substringAfterLast$default(r5, r10, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ String V(String r5) {
        return StringsKt__StringsKt.substringBefore(r5, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "");
    }

    public static /* bridge */ /* synthetic */ String W(String r5, char r10) {
        return StringsKt__StringsKt.substringBefore$default(r5, r10, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ String X(String r5, String r10) {
        return StringsKt__StringsKt.substringBefore$default(r5, r10, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ String Y(String r5) {
        return StringsKt__StringsKt.substringBeforeLast(r5, ".", "");
    }

    public static /* bridge */ /* synthetic */ String Z(String r5, char r10) {
        return StringsKt__StringsKt.substringBeforeLast(r5, r10, "");
    }

    public static /* bridge */ /* synthetic */ void a(StringBuilder r5, String... r10) {
        StringsKt__StringBuilderKt.append(r5, r10);
    }

    public static /* bridge */ /* synthetic */ String a0(String r5, String r10) {
        return StringsKt__StringsKt.substringBeforeLast$default(r5, r10, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ void b(StringBuilder r5) {
        StringsKt__StringBuilderJVMKt.appendln(r5);
    }

    public static /* bridge */ /* synthetic */ String b0(String r5) {
        return StringsKt___StringsKt.take(r5, 23);
    }

    public static /* bridge */ /* synthetic */ List c(String r5) {
        return StringsKt___StringsKt.chunked(r5, 4096);
    }

    public static /* bridge */ /* synthetic */ String c0(String r5) {
        return StringsKt___StringsKt.takeLast(r5, 2);
    }

    public static /* bridge */ /* synthetic */ void d(StringBuilder r5) {
        StringsKt__StringBuilderJVMKt.clear(r5);
    }

    public static /* bridge */ /* synthetic */ void d0(CharSequence r5, PersistentCollection.Builder r10) {
        StringsKt___StringsKt.toCollection(r5, r10);
    }

    public static /* bridge */ /* synthetic */ boolean e(String r5, String r10, boolean r11) {
        return StringsKt__StringsKt.contains(r5, r10, r11);
    }

    public static /* bridge */ /* synthetic */ Set e0(String r5) {
        return StringsKt___StringsKt.toSet(r5);
    }

    public static /* bridge */ /* synthetic */ boolean f(CharSequence r5, char r10) {
        return StringsKt__StringsKt.contains$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ String f0(String r5) {
        return StringsKt__IndentKt.trimMargin$default(r5, null, 1, null);
    }

    public static /* bridge */ /* synthetic */ boolean g(CharSequence r5, String r10) {
        return StringsKt__StringsKt.contains$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ Iterable g0() {
        return StringsKt___StringsKt.withIndex("cligbnpt");
    }

    public static /* bridge */ /* synthetic */ boolean h(CharSequence r5, String r10) {
        return StringsKt__StringsJVMKt.contentEquals(r5, r10);
    }

    public static /* bridge */ /* synthetic */ boolean i(String r5, String r10) {
        return StringsKt__StringsJVMKt.endsWith(r5, r10, true);
    }

    public static /* bridge */ /* synthetic */ boolean j(String r5, char r10) {
        return StringsKt__StringsKt.endsWith$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ boolean k(String r5, String r10) {
        return StringsKt__StringsJVMKt.endsWith$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ boolean l(String r5, String r10) {
        return StringsKt__StringsJVMKt.equals(r5, r10, true);
    }

    public static /* bridge */ /* synthetic */ boolean m(String r5, String r10) {
        return StringsKt__StringsJVMKt.equals$default(r5, r10, false, 2, null);
    }

    public static /* bridge */ /* synthetic */ char n(String r5) {
        return StringsKt___StringsKt.first(r5);
    }

    public static /* bridge */ /* synthetic */ Character o(String r5) {
        return StringsKt___StringsKt.firstOrNull(r5);
    }

    public static /* bridge */ /* synthetic */ IntRange p(String r5) {
        return StringsKt__StringsKt.getIndices(r5);
    }

    public static /* bridge */ /* synthetic */ int q(CharSequence r10, char r11, int r12, int r13) {
        return StringsKt__StringsKt.indexOf$default(r10, r11, r12, false, r13, null);
    }

    public static /* bridge */ /* synthetic */ int r(String r10, int r11, int r12, CharSequence r13) {
        return StringsKt__StringsKt.indexOf$default(r13, r10, r11, false, r12, null);
    }

    public static /* bridge */ /* synthetic */ int s(String r10, char[] r11, int r12) {
        return StringsKt__StringsKt.indexOfAny$default(r10, r11, r12, false, 4, null);
    }

    public static /* bridge */ /* synthetic */ int t(String r10, char r11, int r12, int r13) {
        return StringsKt__StringsKt.lastIndexOf$default(r10, r11, r12, false, r13, null);
    }

    public static /* bridge */ /* synthetic */ int u(String r10, String r11) {
        return StringsKt__StringsKt.lastIndexOf$default(r10, r11, 0, false, 6, null);
    }

    public static /* bridge */ /* synthetic */ List v(String r5) {
        return StringsKt__StringsKt.lines(r5);
    }

    public static /* bridge */ /* synthetic */ String w(int r5, String r10) {
        return StringsKt__StringsKt.padStart(r10, r5, '0');
    }

    public static /* bridge */ /* synthetic */ String x(String r5) {
        return StringsKt__IndentKt.prependIndent(r5, "    ");
    }

    public static /* bridge */ /* synthetic */ boolean y(int r10, int r11, String r12) {
        return StringsKt__StringsJVMKt.regionMatches(r12, r10, "Infinity", 0, r11, true);
    }

    public static /* bridge */ /* synthetic */ boolean z(int r10, String r11) {
        return StringsKt__StringsJVMKt.regionMatches$default(r11, r10, "\"\"\"", 0, 3, false, 16, null);
    }
}
