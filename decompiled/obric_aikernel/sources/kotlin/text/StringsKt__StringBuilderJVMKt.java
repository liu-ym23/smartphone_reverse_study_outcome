package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public StringsKt__StringBuilderJVMKt() {
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value.toInt())");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, StringBuffer r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value.toInt())");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder r10, CharSequence r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        r10.append(r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r10, "this.append(value, startIndex, endIndex)");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder appendRange(StringBuilder r10, char[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        r10.append(r11, r12, r13 - r12);
        Intrinsics.checkNotNullExpressionValue(r10, "this.append(value, start…x, endIndex - startIndex)");
        return r10;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r11 = r10.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(r11, "append(SystemProperties.LINE_SEPARATOR)");
        return r11;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable appendln(Appendable r10, char r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r12 = r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        return appendln(r12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable appendln(Appendable r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r12 = r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        return appendln(r12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(r10, "append(SystemProperties.LINE_SEPARATOR)");
        return r10;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value.toInt())");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, char r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, StringBuffer r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value.toInt())");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder appendln(StringBuilder r10, char[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        return appendln(r10);
    }

    @SinceKotlin(version = "1.3")
    public static final StringBuilder clear(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setLength(0);
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder deleteAt(StringBuilder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r12 = r10.deleteCharAt(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.deleteCharAt(index)");
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder deleteRange(StringBuilder r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r13 = r10.delete(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this.delete(startIndex, endIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder r10, int r11, CharSequence r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
        StringBuilder r15 = r10.insert(r11, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this.insert(index, value, startIndex, endIndex)");
        return r15;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder insertRange(StringBuilder r10, int r11, char[] r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
        StringBuilder r15 = r10.insert(r11, r12, r13, r14 - r13);
        Intrinsics.checkNotNullExpressionValue(r15, "this.insert(index, value…x, endIndex - startIndex)");
        return r15;
    }

    @InlineOnly
    private static final void set(StringBuilder r10, int r11, char r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setCharAt(r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder setRange(StringBuilder r10, int r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, EventBody.KEY_VALUE);
        StringBuilder r14 = r10.replace(r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this.replace(startIndex, endIndex, value)");
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final void toCharArray(StringBuilder r10, char[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r10.getChars(r13, r14, r11, r12);
    }

    static /* synthetic */ void toCharArray$default(StringBuilder r10, char[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = r10.length();
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r10.getChars(r13, r14, r11, r12);
    }
}
