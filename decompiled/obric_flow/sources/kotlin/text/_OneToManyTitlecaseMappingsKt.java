package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char r5) {
        String r10 = String.valueOf(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        Locale r11 = Locale.ROOT;
        String r12 = r10.toUpperCase(r11);
        if (r12.length() <= 1) goto L10;
        if (r5 == 329) goto L11;
        char r13 = r12.charAt(0);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        String r14 = r12.substring(1);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        return r13 + r14.toLowerCase(r11);
    L11:
        return r12;
    L10:
        return String.valueOf(Character.toTitleCase(r5));
    }
}
