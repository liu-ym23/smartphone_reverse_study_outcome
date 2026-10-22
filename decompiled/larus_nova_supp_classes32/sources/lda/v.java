package lda;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = StringsKt.trim(r2).toString();
        return new Regex("^#+\\s*").replace(r3, NameKeys.UnloadStrategy_No_Strategy);
    }

    public static final String b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = StringsKt.trim(r4).toString();
        if (StringsKt.startsWith$default(r5, "omni_", false, 2, null) == false) goto L6;
        return r5;
    L6:
        return "omni_" + r5;
    }
}
