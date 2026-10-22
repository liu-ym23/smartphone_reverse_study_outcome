package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ncapitalizeDecapitalize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n1#2:145\n288#3,2:146\n288#3,2:148\n766#3:150\n857#3,2:151\n1864#3,3:153\n*S KotlinDebug\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n*L\n34#1:146,2\n57#1:148,2\n72#1:150\n72#1:151,2\n78#1:153,3\n*E\n"})
public final class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() != 0) goto L5;
        return r5;
    L5:
        char r10 = r5.charAt(0);
        if ('a' <= r10) goto L8;
        return r5;
    L8:
        if (r10 < '{') goto L10;
        return r5;
    L10:
        return Character.toUpperCase(r10) + r5.substring(1);
    }

    public static final String decapitalizeAsciiOnly(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() != 0) goto L5;
        return r5;
    L5:
        char r10 = r5.charAt(0);
        if ('A' <= r10) goto L8;
        return r5;
    L8:
        if (r10 < '[') goto L10;
        return r5;
    L10:
        return Character.toLowerCase(r10) + r5.substring(1);
    }

    public static final String decapitalizeSmartForCompiler(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() != 0) goto L6;
    L7:
        return r5;
    L6:
        if (isUpperCaseCharAt(r5, 0, r10) == false) goto L7;
        if (r5.length() != 1) goto L11;
    L26:
        if (r10 == false) goto L29;
        return decapitalizeAsciiOnly(r5);
    L29:
        if (r5.length() > 0) goto L31;
        return r5;
    L31:
        return Character.toLowerCase(r5.charAt(0)) + r5.substring(1);
    L11:
        if (isUpperCaseCharAt(r5, 1, r10) == false) goto L26;
        Iterator<Integer> r11 = StringsKt.p(r5).iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Integer r12 = r11.next();
        if (isUpperCaseCharAt(r5, r12.intValue(), r10) == true) goto L15;
    L20:
        Integer r13 = r12;
        if (r13 == null) goto L25;
        int r14 = r13.intValue() - 1;
        return toLowerCase(r5.substring(0, r14), r10) + r5.substring(r14);
    L25:
        return toLowerCase(r5, r10);
    L19:
        r12 = null;
        goto L20
    }

    private static final boolean isUpperCaseCharAt(String r5, int r10, boolean r11) {
        char r12 = r5.charAt(r10);
        if (r11 == false) goto L10;
        if ('A' <= r12) goto L7;
        return false;
    L7:
        if (r12 >= '[') goto L12;
        return true;
    L12:
        return false;
    L10:
        return Character.isUpperCase(r12);
    }

    private static final String toLowerCase(String r5, boolean r10) {
        if (r10 == false) goto L5;
        return toLowerCaseAsciiOnly(r5);
    L5:
        return r5.toLowerCase(Locale.ROOT);
    }

    public static final String toLowerCaseAsciiOnly(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r10 = new StringBuilder(r5.length());
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        char r13 = r5.charAt(r12);
        if ('A' > r13) goto L9;
        if (r13 >= '[') goto L9;
        r13 = Character.toLowerCase(r13);
    L9:
        r10.append(r13);
        r12 = r12 + 1;
        goto L3
    L11:
        return r10.toString();
    }
}
