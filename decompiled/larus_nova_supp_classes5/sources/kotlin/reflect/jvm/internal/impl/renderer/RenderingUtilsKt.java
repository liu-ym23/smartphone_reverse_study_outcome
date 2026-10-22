package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class RenderingUtilsKt {
    public static final String render(Name r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (shouldBeEscaped(r3) == false) goto L6;
        StringBuilder r0 = new StringBuilder();
        r0.append("`" + r3.asString());
        r0.append('`');
        return r0.toString();
    L6:
        return r3.asString();
    }

    public static final String renderFqName(List<Name> r3) {
        Intrinsics.checkNotNullParameter(r3, "pathSegments");
        StringBuilder r0 = new StringBuilder();
        Iterator<Name> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Name r1 = r4.next();
        if (r0.length() <= 0) goto L8;
        r0.append(".");
    L8:
        r0.append(render(r1));
        goto L4
    L10:
        return r0.toString();
    }

    private static final boolean shouldBeEscaped(Name r5) {
        String r6 = r5.asString();
        if (KeywordStringsGenerated.KEYWORDS.contains(r6) == true) goto L30;
        int r2 = 0;
    L6:
        if (r2 >= r6.length()) goto L16;
        char r3 = r6.charAt(r2);
        if (Character.isLetterOrDigit(r3) == false) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        return true;
    L19:
        if (r6.length() != 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
        return true;
    L24:
        if (Character.isJavaIdentifierStart(r6.codePointAt(0)) == false) goto L33;
        return false;
    L33:
        return true;
    L21:
        r8 = false;
        goto L22
    L10:
        if (r3 == '_') goto L12;
        r4 = true;
        goto L13
    L16:
        r7 = false;
        goto L17
    L30:
        return true;
    }

    public static final String render(FqNameUnsafe r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return renderFqName(r1.pathSegments());
    }

    public static final boolean typeStringsDifferOnlyInNullability(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "lower");
        Intrinsics.checkNotNullParameter(r8, "upper");
        if (Intrinsics.areEqual(r7, StringsKt.replace$default(r8, "?", "", false, 4, null)) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r8, "?", false, 2, null) == false) goto L9;
        if (Intrinsics.areEqual(r7 + '?', r8) == true) goto L10;
    L9:
        if (Intrinsics.areEqual("(" + r7 + ")?", r8) == true) goto L10;
        return false;
    }

    public static final String replacePrefixesInTypeRepresentations(String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "lowerRendered");
        Intrinsics.checkNotNullParameter(r5, "lowerPrefix");
        Intrinsics.checkNotNullParameter(r6, "upperRendered");
        Intrinsics.checkNotNullParameter(r7, "upperPrefix");
        Intrinsics.checkNotNullParameter(r8, "foldedPrefix");
        if (StringsKt.startsWith$default(r4, r5, false, 2, null) == true) goto L5;
    L13:
        return null;
    L5:
        if (StringsKt.startsWith$default(r6, r7, false, 2, null) == false) goto L13;
        String r9 = r4.substring(r5.length());
        String r10 = r6.substring(r7.length());
        String r11 = r8 + r9;
        if (Intrinsics.areEqual(r9, r10) == false) goto L10;
        return r11;
    L10:
        if (typeStringsDifferOnlyInNullability(r9, r10) == false) goto L13;
        return r11 + '!';
    }
}
