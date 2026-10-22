package oe8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(String r7) {
        if (StringsKt.startsWith$default(r7, "~~~", false, 2, null) == false) goto L5;
    L6:
        r7 = r7.substring(3);
    L8:
        if (StringsKt.endsWith$default(r7, "~~~", false, 2, null) == true) goto L12;
        if (StringsKt.endsWith$default(r7, "```", false, 2, null) == true) goto L12;
        return r7;
    L12:
        return r7.substring(0, r7.length() - 3);
    L5:
        if (StringsKt.startsWith$default(r7, "```", false, 2, null) == false) goto L8;
        goto L6
    }

    public static b a(String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "code");
        String r16 = StringsKt.trim(r14, new char[]{'\n', ' '});
        List r1 = StringsKt.lines(r16);
        if (r1.isEmpty() == true) goto L5;
        boolean r2 = false;
        String r4 = (String) ListProtector.get(r1, 0);
        if (StringsKt.startsWith$default(r4, "```", false, 2, null) == false) goto L28;
        String r5 = StringsKt.trim(r4.substring(3)).toString();
        if (r15 == false) goto L16;
        if (r5.length() <= 0) goto L13;
        r2 = true;
    L13:
        if (r2 == true) goto L26;
    L25:
        r5 = null;
    L26:
        Pair r17 = TuplesKt.to('`', r5);
    L49:
        if (r17 == null) goto L51;
        ((Character) r17.component1()).charValue();
        String r18 = (String) r17.component2();
        if (r1.size() < 2) goto L55;
        List r19 = r1.subList(1, r1.size());
    L57:
        return new b(r18, b(CollectionsKt.joinToString$default(r19, "\n", null, null, 0, null, null, 62, null)));
    L55:
        r19 = CollectionsKt.emptyList();
        goto L57
    L51:
        return new b(null, b(r16));
    L16:
        if (r5.length() <= 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L20;
        String r8 = r5;
    L21:
        if (r8 == null) goto L25;
        List r110 = StringsKt.split$default(r8, new String[]{" "}, false, 0, 6, null);
        if (r110 == null) goto L25;
        r5 = (String) CollectionsKt.firstOrNull(r110);
        goto L26
    L20:
        r8 = null;
        goto L21
    L28:
        if (StringsKt.startsWith$default(r4, "~~~", false, 2, null) == false) goto L48;
        String r6 = StringsKt.trim(r4.substring(3)).toString();
        if (r15 == false) goto L37;
        if (r6.length() <= 0) goto L34;
        r2 = true;
    L34:
        if (r2 == true) goto L47;
    L46:
        r6 = null;
    L47:
        r17 = TuplesKt.to('~', r6);
        goto L49
    L37:
        if (r6.length() <= 0) goto L39;
        r2 = true;
    L39:
        if (r2 == false) goto L41;
        String r9 = r6;
    L42:
        if (r9 == null) goto L46;
        List r111 = StringsKt.split$default(r9, new String[]{" "}, false, 0, 6, null);
        if (r111 == null) goto L46;
        r6 = (String) CollectionsKt.firstOrNull(r111);
        goto L47
    L41:
        r9 = null;
        goto L42
    L48:
        r17 = null;
        goto L49
    L5:
        return new b(null, "");
    }
}
