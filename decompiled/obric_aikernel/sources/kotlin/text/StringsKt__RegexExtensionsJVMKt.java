package kotlin.text;

import java.util.regex.Pattern;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt {
    public StringsKt__RegexExtensionsJVMKt() {
    }

    @InlineOnly
    private static final Regex toRegex(Pattern r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Regex(r10);
    }
}
