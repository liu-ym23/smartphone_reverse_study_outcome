package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char r10) {
        String r11 = String.valueOf(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        Locale r12 = Locale.ROOT;
        String r13 = r11.toUpperCase(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (r13.length() <= 1) goto L10;
        if (r10 == 329) goto L11;
        char r14 = r13.charAt(0);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        String r15 = r13.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.String");
        String r16 = r15.toLowerCase(r12);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r14 + r16;
    L11:
        return r13;
    L10:
        return String.valueOf(Character.toTitleCase(r10));
    }
}
