package com.ss.android.lark.richtextmd;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextBISUUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        a = LazyKt.lazy(r0, RichTextBISUUtils$boldValue$2.INSTANCE);
        b = LazyKt.lazy(r0, RichTextBISUUtils$italicValue$2.INSTANCE);
        c = LazyKt.lazy(r0, RichTextBISUUtils$strikeThroughValue$2.INSTANCE);
        d = LazyKt.lazy(r0, RichTextBISUUtils$underlineValue$2.INSTANCE);
    }

    public static boolean a(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "styles");
        Object r4 = r3.get("fontWeight");
        if ((r4 instanceof String) == false) goto L5;
        String r5 = (String) r4;
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (r5.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(StringsKt.trim(r5).toString(), (String) a.getValue()) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r0 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public static boolean b(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "styles");
        Object r4 = r3.get("fontStyle");
        if ((r4 instanceof String) == false) goto L5;
        String r5 = (String) r4;
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (r5.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(StringsKt.trim(r5).toString(), (String) b.getValue()) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r0 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public static boolean c(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "styles");
        Object r6 = r5.get("-lark-textDecoration");
        if ((r6 instanceof String) == false) goto L5;
        String r7 = (String) r6;
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (r7.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
    L16:
        return false;
    L14:
        if (StringsKt.contains$default(StringsKt.trim(r7).toString(), (String) c.getValue(), false, 2, null) == false) goto L16;
        return true;
    L11:
        r0 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public static boolean d(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "styles");
        Object r6 = r5.get("-lark-textDecoration");
        if ((r6 instanceof String) == false) goto L5;
        String r7 = (String) r6;
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (r7.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
    L16:
        return false;
    L14:
        if (StringsKt.contains$default(StringsKt.trim(r7).toString(), (String) d.getValue(), false, 2, null) == false) goto L16;
        return true;
    L11:
        r0 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public static void e(Map r12, RichTextElement r13) {
        Intrinsics.checkNotNullParameter(r13, "childElement");
        if (r12 != null) goto L5;
        return;
    L5:
        Map r0 = r13.getStyle();
        if (r0 != null) goto L8;
        r0 = new LinkedHashMap();
    L8:
        boolean r1 = a(r12);
        boolean r2 = b(r12);
        boolean r3 = c(r12);
        boolean r14 = d(r12);
        if (r1 == false) goto L11;
        r0.put("fontWeight", (String) a.getValue());
    L11:
        if (r2 == false) goto L13;
        r0.put("fontStyle", (String) b.getValue());
    L13:
        String r4 = (String) r0.get("-lark-textDecoration");
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        Set r5 = CollectionsKt.toMutableSet(StringsKt.split$default(r4, new String[]{" "}, false, 0, 6, null));
        if (r3 == false) goto L19;
        r5.add((String) c.getValue());
    L19:
        if (r14 == false) goto L21;
        r5.add((String) d.getValue());
    L21:
        String r15 = CollectionsKt.joinToString$default(r5, " ", null, null, 0, null, null, 62, null);
        if (r15.length() <= 0) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L27;
        r0.put("-lark-textDecoration", r15);
    L27:
        r13.setStyle(r0);
        return;
    L24:
        r6 = false;
        goto L25
    }
}
