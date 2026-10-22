package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class RenderingUtilsKt {
    public static final String render(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<Name> r11 = r10.pathSegments();
        Intrinsics.checkNotNullExpressionValue(r11, "pathSegments()");
        return renderFqName(r11);
    }

    public static final String render(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (shouldBeEscaped(r10) == false) goto L5;
        StringBuilder r11 = new StringBuilder();
        String r12 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r12, "asString()");
        r11.append('`' + r12);
        r11.append('`');
        return r11.toString();
    L5:
        String r13 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r13, "asString()");
        return r13;
    }

    public static final String renderFqName(List<Name> r10) {
        Intrinsics.checkNotNullParameter(r10, "pathSegments");
        StringBuilder r11 = new StringBuilder();
        Iterator<Name> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Name r13 = r12.next();
        if (r11.length() <= 0) goto L8;
        r11.append(".");
    L8:
        r11.append(render(r13));
        goto L4
    L9:
        String r14 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "StringBuilder().apply(builderAction).toString()");
        return r14;
    }

    private static final boolean shouldBeEscaped(Name r10) {
        String r11 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r11, "asString()");
        if (KeywordStringsGenerated.KEYWORDS.contains(r11) == true) goto L19;
        int r12 = 0;
    L6:
        if (r12 >= r11.length()) goto L16;
        char r13 = r11.charAt(r12);
        if (Character.isLetterOrDigit(r13) == false) goto L10;
    L12:
        boolean r14 = false;
    L13:
        if (r14 == true) goto L14;
        r12 = r12 + 1;
        goto L6
    L14:
        boolean r15 = true;
    L17:
        if (r15 == true) goto L19;
        return false;
    L10:
        if (r13 == '_') goto L12;
        r14 = true;
        goto L13
    L16:
        r15 = false;
    L19:
        return true;
    }
}
