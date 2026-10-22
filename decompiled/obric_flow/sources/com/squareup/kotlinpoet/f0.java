package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f15148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f15149b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f15150c = null;

    static {
        f15148a = new Regex("((\\p{gc=Lu}+|\\p{gc=Ll}+|\\p{gc=Lt}+|\\p{gc=Lm}+|\\p{gc=Lo}+|\\p{gc=Nl}+)+\\d*\\p{gc=Lu}*\\p{gc=Ll}*\\p{gc=Lt}*\\p{gc=Lm}*\\p{gc=Lo}*\\p{gc=Nl}*)|(`[^\n\r`]+`)");
        f15149b = SetsKt.setOf(new String[]{"as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if", "in", "interface", "is", "null", "object", "package", "return", "super", "this", "throw", "true", "try", "typealias", "typeof", "val", "var", "when", "while", "by", "catch", "constructor", "delegate", "dynamic", "field", "file", "finally", "get", "import", "init", "param", "property", "receiver", "set", "setparam", "where", "actual", "abstract", "annotation", "companion", "const", "crossinline", "data", "enum", "expect", "external", "final", "infix", "inline", "inner", "internal", "lateinit", "noinline", "open", "operator", "out", "override", "private", "protected", "public", "reified", "sealed", "suspend", "tailrec", "value", "vararg", "header", "impl", "yield"});
        f15150c = SetsKt.setOf(new Character[]{'.', ';', '[', ']', '/', Character.valueOf(Typography.less), Character.valueOf(Typography.greater), ':', '\\'});
    }

    public static final boolean a(String r5) {
        if (StringsKt.P(r5, "`") == true) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.k(r5, "`") == false) goto L7;
        return true;
    }

    public static final String b(char r5) {
        if (r5 != '\b') goto L6;
        return "\\b";
    L6:
        if (r5 != '\t') goto L9;
        return "\\t";
    L9:
        if (r5 != '\n') goto L12;
        return "\\n";
    L12:
        if (r5 != '\r') goto L15;
        return "\\r";
    L15:
        if (r5 != '\"') goto L18;
        return "\"";
    L18:
        if (r5 != '\'') goto L21;
        return "\\'";
    L21:
        if (r5 != '\\') goto L23;
        return "\\\\";
    L23:
        if (r5 < 0) goto L28;
        if (r5 >= ' ') goto L28;
    L31:
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        return String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1));
    L28:
        if (127 > r5) goto L33;
        if (r5 < 160) goto L31;
    L33:
        return String.valueOf(r5);
    }

    public static final boolean c(Collection r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "t");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        if (r5.contains(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public static final e d(e r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.f15131a.isEmpty() == true) goto L21;
        d r5 = r10.b();
        String r11 = (String) CollectionsKt.last(r10.c().f15131a);
        Set r12 = e.f15130c;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11.length() != 1) goto L10;
        if (com.bytedance.apm.util.a.o(StringsKt.n(r11)) == false) goto L10;
    L13:
        ArrayList r13 = r5.f15114b;
        if (r13.isEmpty() == true) goto L18;
        Object r14 = CollectionsKt.last(r13);
        if ((r14 instanceof String) == false) goto L20;
        r13.set(r13.size() - 1, StringsKt.trimEnd((String) r14, new char[]{'\n'}) + '\n');
    L20:
        return r5.d();
    L18:
        ArrayList r15 = r5.f15113a;
        r15.set(r15.lastIndexOf(r11), StringsKt.trimEnd(r11, new char[]{'\n'}));
        r15.add("\n");
    L10:
        if (r11.length() != 2) goto L18;
        if (StringsKt.n(r11) != '%') goto L18;
    L21:
        return r10;
    }

    public static final String e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "s");
        StringBuilder r10 = new StringBuilder();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(b(r5.charAt(r12)));
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public static String f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List r11 = StringsKt.J(r10, new char[]{'.'}, 0, 6);
        ArrayList r5 = new ArrayList();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        if (((String) r13).length() <= 0) goto L4;
        r5.add(r13);
        goto L4
    L9:
        return CollectionsKt.q(r5, String.valueOf('.'), null, null, 0, null, UtilKt$escapeSegmentsIfNecessary$2.INSTANCE, 30);
    }

    public static boolean g(Object r5, Object r10, Object r11, Character r12, Character r13, int r14) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        if (Intrinsics.areEqual(r5, r10) == false) goto L11;
    L22:
        return true;
    L11:
        if (Intrinsics.areEqual(r5, r11) == true) goto L22;
        if (Intrinsics.areEqual(r5, r12) == true) goto L22;
        if (Intrinsics.areEqual(r5, r13) == true) goto L22;
        if (Intrinsics.areEqual(r5, null) == true) goto L22;
        if (Intrinsics.areEqual(r5, null) == true) goto L22;
        return false;
    }

    public static final String h(String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "value");
        int r5 = 0;
        if (r12 == false) goto L5;
    L24:
        StringBuilder r13 = new StringBuilder(r10.length() + 32);
        if (r11 == false) goto L27;
        r13.append(Typography.quote);
    L28:
        int r14 = r10.length();
    L29:
        if (r5 >= r14) goto L41;
        char r15 = r10.charAt(r5);
        if (r15 != '\'') goto L33;
        r13.append("'");
    L40:
        r5 = r5 + 1;
        goto L29
    L33:
        if (r15 != '\"') goto L36;
        if (r11 == false) goto L36;
        r13.append("\\\"");
    L36:
        if (r15 != '$') goto L39;
        if (r11 == false) goto L39;
        r13.append("${'$'}");
    L39:
        r13.append(b(r15));
        goto L40
    L41:
        if (r11 == false) goto L43;
        r13.append(Typography.quote);
    L45:
        return r13.toString();
    L43:
        r13.append("\"\"\"");
        goto L45
    L27:
        r13.append("\"\"\"");
        goto L28
    L5:
        if (StringsKt.f(r10, '\n') == false) goto L24;
        StringBuilder r16 = new StringBuilder(r10.length() + 32);
        r16.append("\"\"\"\n|");
    L8:
        if (r5 >= r10.length()) goto L20;
        char r17 = r10.charAt(r5);
        if (StringsKt.z(r5, r10) == false) goto L12;
        r16.append("\"\"${'\"'}");
        r5 = r5 + 2;
    L18:
        r5 = r5 + 1;
        goto L8
    L12:
        if (r17 != '\n') goto L14;
        r16.append("\n|");
        goto L18
    L14:
        if (r17 != '$') goto L17;
        if (r11 == false) goto L17;
        r16.append("${'$'}");
    L17:
        r16.append(r17);
        goto L18
    L20:
        if (StringsKt.k(r10, "\n") == true) goto L22;
        r16.append("\n");
    L22:
        r16.append("\"\"\".trimMargin()");
        return r16.toString();
    }

    public static final List i(Collection r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Collections.unmodifiableList(new ArrayList(r5));
    }

    public static final Set j(Collection r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Collections.unmodifiableSet(new LinkedHashSet(r5));
    }
}
