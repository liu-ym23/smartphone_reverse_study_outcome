package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class StringsKt__AppendableKt {
    public StringsKt__AppendableKt() {
    }

    public static final <T extends Appendable> T append(T r10, CharSequence... r11) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void appendElement(Appendable r10, T r11, Function1<? super T, ? extends CharSequence> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r12 == null) goto L7;
        r11 = (T) r12.invoke(r11);
    L5:
        CharSequence r13 = (CharSequence) r11;
    L6:
        r10.append(r13);
        return;
    L7:
        if (r11 != 0) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == true) goto L5;
        if ((r11 instanceof Character) == false) goto L15;
        r10.append(((Character) r11).charValue());
        return;
    L15:
        r13 = String.valueOf(r11);
        goto L6
    L9:
        r14 = r11 instanceof CharSequence;
        goto L10
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r11 = r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r11, "append('\\n')");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable r10, char r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r12 = r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        Appendable r13 = r12.append('\n');
        Intrinsics.checkNotNullExpressionValue(r13, "append('\\n')");
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(Appendable r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Appendable r12 = r10.append(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        Appendable r13 = r12.append('\n');
        Intrinsics.checkNotNullExpressionValue(r13, "append('\\n')");
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Appendable> T appendRange(T r10, CharSequence r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        T r14 = (T) r10.append(r11, r12, r13);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return r14;
    }
}
