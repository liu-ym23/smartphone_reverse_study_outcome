package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    public StringsKt__StringBuilderKt() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder append(StringBuilder r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "this.append(obj)");
        return r10;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    @InlineOnly
    private static final StringBuilder append(StringBuilder r10, char[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "str");
        throw new NotImplementedError(null, 1, null);
    }

    public static final StringBuilder append(StringBuilder r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.append(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public static StringBuilder append(StringBuilder r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.append(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, char r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder r10, char[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String buildString(int r10, Function1<? super StringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        StringBuilder r12 = new StringBuilder(r10);
        r11.invoke(r12);
        String r13 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder(capacity).…builderAction).toString()");
        return r13;
    }

    @InlineOnly
    private static final String buildString(Function1<? super StringBuilder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        StringBuilder r11 = new StringBuilder();
        r10.invoke(r11);
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }
}
