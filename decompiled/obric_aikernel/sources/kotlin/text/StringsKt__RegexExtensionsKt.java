package kotlin.text;

import java.util.Set;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    public StringsKt__RegexExtensionsKt() {
    }

    @InlineOnly
    private static final Regex toRegex(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Regex(r10);
    }

    @InlineOnly
    private static final Regex toRegex(String r10, Set<? extends RegexOption> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new Regex(r10, r11);
    }

    @InlineOnly
    private static final Regex toRegex(String r10, RegexOption r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "option");
        return new Regex(r10, r11);
    }
}
