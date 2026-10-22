package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001f\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a-\u0010\f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a-\u0010\f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0014\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u0013H\u0007\u001a\u001d\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u0014\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017H\u0087\b\u001a%\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u0014\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001d\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\nH\u0087\b\u001a%\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a%\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a5\u0010\u001d\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a5\u0010\u001d\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a!\u0010\u001e\u001a\u00020\u001f*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\n\u001a-\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0017H\u0087\b\u001a7\u0010!\u001a\u00020\u001f*\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b¨\u0006$"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", EventBody.KEY_VALUE, "", "", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insert", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public StringsKt__StringBuilderJVMKt() {
    }

    private static final StringBuilder append(StringBuilder r1, byte r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return r3;
    }

    private static final StringBuilder append(StringBuilder r1, short r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return r3;
    }

    private static final StringBuilder appendLine(StringBuilder r1, byte r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, double r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, StringBuffer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r2, StringBuilder r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r4 = r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        StringBuilder r5 = r4.append('\n');
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return r5;
    }

    private static final StringBuilder appendLine(StringBuilder r1, short r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendRange(StringBuilder r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        StringBuilder r7 = r2.append(r6, r4, r5);
        Intrinsics.checkNotNullExpressionValue(r7, "append(...)");
        return r7;
    }

    private static final StringBuilder appendRange(StringBuilder r1, char[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        StringBuilder r5 = r1.append(r2, r3, r4 - r3);
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return r5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Appendable r5 = r4.append((CharSequence) ZeusTransformUtils.preCheckCast(SystemProperties.LINE_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return r5;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r2, char r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Appendable r5 = r4.append(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return StringsKt.appendln(r5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r2, CharSequence r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Appendable r6 = r4.append(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "append(...)");
        return StringsKt.appendln(r6);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r2 = r1.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        return r2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, byte r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, char r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, double r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r5 = r2.append(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return StringsKt.appendln(r5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, StringBuffer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r2, StringBuilder r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r4 = r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return StringsKt.appendln(r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, short r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, char[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    public static final StringBuilder clear(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setLength(0);
        return r1;
    }

    private static final StringBuilder deleteAt(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.deleteCharAt(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "deleteCharAt(...)");
        return r3;
    }

    private static final StringBuilder deleteRange(StringBuilder r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r4 = r1.delete(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "delete(...)");
        return r4;
    }

    private static final StringBuilder insert(StringBuilder r1, int r2, byte r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r4 = r1.insert(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "insert(...)");
        return r4;
    }

    private static final StringBuilder insert(StringBuilder r1, int r2, short r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r4 = r1.insert(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "insert(...)");
        return r4;
    }

    private static final StringBuilder insertRange(StringBuilder r2, int r3, CharSequence r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        StringBuilder r8 = r2.insert(r3, r7, r5, r6);
        Intrinsics.checkNotNullExpressionValue(r8, "insert(...)");
        return r8;
    }

    private static final StringBuilder insertRange(StringBuilder r1, int r2, char[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        StringBuilder r6 = r1.insert(r2, r3, r4, r5 - r4);
        Intrinsics.checkNotNullExpressionValue(r6, "insert(...)");
        return r6;
    }

    private static final void set(StringBuilder r1, int r2, char r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setCharAt(r2, r3);
    }

    private static final StringBuilder setRange(StringBuilder r1, int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        StringBuilder r5 = r1.replace(r2, r3, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "replace(...)");
        return r5;
    }

    private static final void toCharArray(StringBuilder r1, char[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
    }

    static /* synthetic */ void toCharArray$default(StringBuilder r1, char[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = r1.length();
    L11:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
    }
}
