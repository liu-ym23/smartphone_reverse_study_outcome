package bq9;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static boolean b(String r10) {
        if (r10 == null) goto L77;
        List r3 = 0;
        r3 = 0;
        if ((!StringsKt.isBlank(r10)) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L78;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(new URI(r10));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r11) == false) goto L16;
        r11 = null;
    L16:
        URI r12 = (URI) r11;
        if (r12 == null) goto L79;
        String r4 = r12.getRawQuery();
        if (r4 == null) goto L41;
        List r2 = StringsKt.split$default(r4, new char[]{'&'}, false, 0, 6, null);
        if (r2 == null) goto L41;
        List r5 = r2;
        if ((r5 instanceof Collection) == true) goto L25;
    L27:
        Iterator r6 = r5.iterator();
    L29:
        if (r6.hasNext() == false) goto L38;
        String r7 = (String) r6.next();
        if (Intrinsics.areEqual(StringsKt.substringBefore$default(r7, '=', null, 2, null), "isbaseapp") == true) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == false) goto L29;
        boolean r9 = true;
    L39:
        if (r9 != true) goto L41;
        boolean r13 = true;
    L42:
        if (r13 == false) goto L44;
        return true;
    L44:
        String r14 = r12.getPath();
        if (r14 == null) goto L57;
        List r15 = StringsKt.split$default(r14, new char[]{'/'}, false, 0, 6, null);
        if (r15 == null) goto L57;
        r3 = new ArrayList();
        Iterator r16 = r15.iterator();
    L50:
        if (r16.hasNext() == false) goto L57;
        Object r17 = r16.next();
        if (((String) r17).length() <= 0) goto L54;
        boolean r18 = true;
    L55:
        if (r18 == false) goto L50;
        r3.add(r17);
        goto L50
    L54:
        r18 = false;
    L57:
        if (r3 != 0) goto L59;
        r3 = CollectionsKt.emptyList();
    L59:
        int r19 = r3.indexOf("app");
        if (r19 >= 0) goto L62;
        return false;
    L62:
        if (r19 >= CollectionsKt.getLastIndex(r3)) goto L81;
        return true;
    L81:
        return false;
    L33:
        if (Intrinsics.areEqual(StringsKt.substringAfter(r7, '=', ""), "1") == false) goto L35;
        r8 = true;
    L38:
        r9 = false;
        goto L39
    L25:
        if (r5.isEmpty() == false) goto L27;
    L41:
        r13 = false;
        goto L42
    L79:
        return false;
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L78:
        return false;
    L77:
        return false;
    }

    public static boolean a(Integer r0, String r1) {
        if (r0 == null) goto L8;
        if (r0.intValue() == 1) goto L10;
        return false;
    L10:
        return true;
    L8:
        return b(r1);
    }
}
