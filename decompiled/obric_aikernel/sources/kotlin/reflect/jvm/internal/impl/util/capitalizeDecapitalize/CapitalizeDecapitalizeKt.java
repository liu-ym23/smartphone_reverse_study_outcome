package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean r11 = false;
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return r10;
    L8:
        char r13 = r10.charAt(0);
        if ('a' <= r13) goto L11;
    L13:
        if (r11 == false) goto L16;
        char r14 = Character.toUpperCase(r13);
        String r15 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        return r14 + r15;
    L16:
        return r10;
    L11:
        if (r13 >= '{') goto L13;
        r11 = true;
        goto L13
    L5:
        r12 = false;
        goto L6
    }

    public static final String decapitalizeAsciiOnly(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean r11 = false;
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return r10;
    L8:
        char r13 = r10.charAt(0);
        if ('A' <= r13) goto L11;
    L13:
        if (r11 == false) goto L16;
        char r14 = Character.toLowerCase(r13);
        String r15 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        return r14 + r15;
    L16:
        return r10;
    L11:
        if (r13 >= '[') goto L13;
        r11 = true;
        goto L13
    L5:
        r12 = false;
        goto L6
    }

    public static final String decapitalizeSmartForCompiler(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return r10;
    L8:
        if (isUpperCaseCharAt(r10, 0, r11) == true) goto L11;
        return r10;
    L11:
        if (r10.length() != 1) goto L13;
    L28:
        if (r11 == false) goto L31;
        return decapitalizeAsciiOnly(r10);
    L31:
        if (r10.length() <= 0) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L42;
        char r14 = Character.toLowerCase(r10.charAt(0));
        String r15 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        return r14 + r15;
    L42:
        return r10;
    L33:
        r13 = false;
        goto L34
    L13:
        if (isUpperCaseCharAt(r10, 1, r11) == false) goto L28;
        Iterator<Integer> r16 = StringsKt.getIndices(r10).iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Integer r17 = r16.next();
        if ((!isUpperCaseCharAt(r10, r17.intValue(), r11)) == false) goto L17;
    L22:
        Integer r18 = r17;
        if (r18 == null) goto L27;
        int r19 = r18.intValue() - 1;
        StringBuilder r20 = new StringBuilder();
        String r21 = r10.substring(0, r19);
        Intrinsics.checkNotNullExpressionValue(r21, "this as java.lang.String…ing(startIndex, endIndex)");
        r20.append(toLowerCase(r21, r11));
        String r22 = r10.substring(r19);
        Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).substring(startIndex)");
        r20.append(r22);
        return r20.toString();
    L27:
        return toLowerCase(r10, r11);
    L21:
        r17 = null;
        goto L22
    L5:
        r12 = false;
        goto L6
    }

    private static final boolean isUpperCaseCharAt(String r10, int r11, boolean r12) {
        char r13 = r10.charAt(r11);
        if (r12 == false) goto L10;
        if ('A' <= r13) goto L7;
        return false;
    L7:
        if (r13 >= '[') goto L12;
        return true;
    L12:
        return false;
    L10:
        return Character.isUpperCase(r13);
    }

    private static final String toLowerCase(String r10, boolean r11) {
        if (r11 == true) goto L6;
        String r12 = r10.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r12;
    L6:
        return toLowerCaseAsciiOnly(r10);
    }

    public static final String toLowerCaseAsciiOnly(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r11 = new StringBuilder(r10.length());
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        char r14 = r10.charAt(r13);
        if ('A' <= r14) goto L7;
    L9:
        boolean r15 = false;
    L10:
        if (r15 == false) goto L12;
        r14 = Character.toLowerCase(r14);
    L12:
        r11.append(r14);
        r13 = r13 + 1;
        goto L3
    L7:
        if (r14 >= '[') goto L9;
        r15 = true;
        goto L10
    L13:
        String r16 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "builder.toString()");
        return r16;
    }
}
