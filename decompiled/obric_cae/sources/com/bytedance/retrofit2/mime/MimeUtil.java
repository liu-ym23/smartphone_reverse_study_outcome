package com.bytedance.retrofit2.mime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class MimeUtil {
    private static final Pattern CHARSET = null;

    static {
        CHARSET = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    private MimeUtil() {
    }

    @Deprecated
    public static String parseCharset(String r8) {
        return parseCharset(r8, "UTF-8");
    }

    public static String parseCharset(String r8, String r10) {
        Matcher r11 = CHARSET.matcher(r8);
        if (r11.find() == true) goto L5;
        return r10;
    L5:
        return r11.group(1).replaceAll("[\"\\\\]", "");
    }
}
