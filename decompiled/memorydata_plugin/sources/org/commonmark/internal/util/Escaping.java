package org.commonmark.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class Escaping {
    private static final Pattern BACKSLASH_OR_AMP = null;
    private static final Pattern ENTITY_OR_ESCAPED_CHAR = null;
    private static final Pattern ESCAPE_IN_URI = null;
    private static final char[] HEX_DIGITS = null;
    private static final Replacer UNESCAPE_REPLACER = null;
    private static final Replacer URI_REPLACER = null;
    private static final Pattern WHITESPACE = null;

    private interface Replacer {
        void replace(String r1, StringBuilder r2);
    }

    static {
        BACKSLASH_OR_AMP = Pattern.compile("[\\\\&]");
        ENTITY_OR_ESCAPED_CHAR = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        ESCAPE_IN_URI = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        WHITESPACE = Pattern.compile("[ \t\r\n]+");
        UNESCAPE_REPLACER = new AnonymousClass1();
        URI_REPLACER = new AnonymousClass2();
    }

    static /* synthetic */ char[] access$000() {
        return HEX_DIGITS;
    }

    public static String normalizeLabelContent(String r1) {
        String r2 = r1.trim().toLowerCase(Locale.ROOT);
        return WHITESPACE.matcher(r2).replaceAll(" ");
    }

    public static String normalizeReference(String r2) {
        return normalizeLabelContent(r2.substring(1, r2.length() - 1));
    }

    private static String replaceAll(Pattern r3, String r4, Replacer r5) {
        Replacer r6 = (Replacer) ZeusTransformUtils.wrapperContextForParams(r5, Replacer.class, "com.obric.memorydata.plugin");
        Matcher r7 = r3.matcher(r4);
        if (r7.find() == true) goto L5;
        return r4;
    L5:
        StringBuilder r0 = new StringBuilder(r4.length() + 16);
        int r1 = 0;
    L6:
        r0.append(r4, r1, r7.start());
        r6.replace(r7.group(), r0);
        r1 = r7.end();
        if (r7.find() == true) goto L6;
        if (r1 == r4.length()) goto L12;
        r0.append(r4, r1, r4.length());
    L12:
        return r0.toString();
    }

    public static String unescapeString(String r2) {
        if (BACKSLASH_OR_AMP.matcher(r2).find() == true) goto L5;
        return r2;
    L5:
        return replaceAll(ENTITY_OR_ESCAPED_CHAR, r2, UNESCAPE_REPLACER);
    }
}
