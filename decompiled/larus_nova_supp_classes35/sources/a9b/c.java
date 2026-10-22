package a9b;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final boolean a(a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L5;
    L32:
        return true;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L32;
        String r1 = r3.a().user_name;
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return true;
    L15:
        String r5 = r3.a().name_py;
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L23;
        return true;
    L23:
        String r7 = r3.a().tenant_name;
        if (r7 != null) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L31;
        return true;
    L31:
        return false;
    L26:
        if (StringsKt.contains(r7, r4, false) != true) goto L28;
        r8 = true;
        goto L29
    L18:
        if (StringsKt.contains(r5, r4, false) != true) goto L20;
        r6 = true;
        goto L21
    L10:
        if (StringsKt.contains(r1, r4, false) != true) goto L12;
        r2 = true;
        goto L13
    }
}
