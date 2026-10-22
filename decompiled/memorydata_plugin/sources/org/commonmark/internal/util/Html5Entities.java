package org.commonmark.internal.util;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class Html5Entities {
    private static final Map<String, String> NAMED_CHARACTER_REFERENCES = null;
    private static final Pattern NUMERIC_PATTERN = null;

    static {
        NAMED_CHARACTER_REFERENCES = readEntities();
        NUMERIC_PATTERN = Pattern.compile("^&#[Xx]?");
    }

    public Html5Entities() {
    }

    public static String entityToString(String r5) {
        Matcher r1 = NUMERIC_PATTERN.matcher(r5);
        if (r1.find() == true) goto L5;
        String r0 = r5.substring(1, r5.length() - 1);
        String r2 = (String) ZeusTransformUtils.preCheckCast(NAMED_CHARACTER_REFERENCES.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
        return r2;
    L17:
        return r5;
    L5:
        if (r1.end() != 2) goto L7;
        int r3 = 10;
    L18:
        int r6 = Integer.parseInt(r5.substring(r1.end(), r5.length() - 1), r3);     // Catch: IllegalArgumentException -> L13
        if (r6 != 0) goto L11;
        return "�";
    L11:
        return new String(Character.toChars(r6));
    L13:
        return "�";
    L7:
        r3 = 16;
        goto L18
    }

    private static Map<String, String> readEntities() {
        HashMap r0 = new HashMap();
        BufferedReader r3 = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName(RpcUtils.CHARSET_UTF8)));     // Catch: IOException -> L22
    L28:
        String r1 = r3.readLine();     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        if (r1.length() == 0) goto L28;
        int r2 = r1.indexOf("=");     // Catch: Throwable -> L14
        r0.put(r1.substring(0, r2), r1.substring(r2 + 1));     // Catch: Throwable -> L14
    L11:
        r3.close();     // Catch: IOException -> L22
        r0.put("NewLine", "\n");
        return r0;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        throw new IllegalStateException("Failed reading data for HTML named character references", e);
    }
}
