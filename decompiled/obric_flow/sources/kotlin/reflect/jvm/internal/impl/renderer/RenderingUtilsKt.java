package kotlin.reflect.jvm.internal.impl.renderer;

import ai.j0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRenderingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,75:1\n1083#2,2:76\n*S KotlinDebug\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n*L\n29#1:76,2\n*E\n"})
public final class RenderingUtilsKt {
    public static final String render(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (shouldBeEscaped(r5) == false) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append("`" + r5.asString());
        r10.append('`');
        return r10.toString();
    L6:
        return r5.asString();
    }

    public static final String renderFqName(List<Name> r5) {
        Intrinsics.checkNotNullParameter(r5, "pathSegments");
        StringBuilder r10 = new StringBuilder();
        Iterator<Name> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Name r12 = r11.next();
        if (r10.length() <= 0) goto L8;
        r10.append(".");
    L8:
        r10.append(render(r12));
        goto L4
    L10:
        return r10.toString();
    }

    public static final String replacePrefixesInTypeRepresentations(String r5, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "lowerRendered");
        Intrinsics.checkNotNullParameter(r10, "lowerPrefix");
        Intrinsics.checkNotNullParameter(r11, "upperRendered");
        Intrinsics.checkNotNullParameter(r12, "upperPrefix");
        Intrinsics.checkNotNullParameter(r13, "foldedPrefix");
        if (StringsKt.P(r5, r10) == true) goto L5;
        return null;
    L5:
        if (StringsKt.P(r11, r12) == false) goto L15;
        String r14 = r5.substring(r10.length());
        String r15 = r11.substring(r12.length());
        String r16 = j0.j(r13, r14);
        if (Intrinsics.areEqual(r14, r15) == false) goto L10;
        return r16;
    L10:
        if (typeStringsDifferOnlyInNullability(r14, r15) == true) goto L12;
        return null;
    L12:
        return r16 + '!';
    L15:
        return null;
    }

    private static final boolean shouldBeEscaped(Name r5) {
        String r10 = r5.asString();
        if (KeywordStringsGenerated.KEYWORDS.contains(r10) == true) goto L13;
        int r11 = 0;
    L6:
        if (r11 >= r10.length()) goto L19;
        char r12 = r10.charAt(r11);
        if (Character.isLetterOrDigit(r12) == true) goto L12;
        if (r12 != '_') goto L13;
    L12:
        r11 = r11 + 1;
        goto L6
    L19:
        return false;
    L13:
        return true;
    }

    public static final boolean typeStringsDifferOnlyInNullability(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "lower");
        Intrinsics.checkNotNullParameter(r10, "upper");
        if (Intrinsics.areEqual(r5, StringsKt.F(r10, "?", "")) == false) goto L5;
    L12:
        return true;
    L5:
        if (StringsKt.k(r10, "?") == false) goto L9;
        if (Intrinsics.areEqual(r5 + '?', r10) == true) goto L12;
    L9:
        if (Intrinsics.areEqual("(" + r5 + ")?", r10) == true) goto L12;
        return false;
    }

    public static final String render(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return renderFqName(r5.pathSegments());
    }
}
