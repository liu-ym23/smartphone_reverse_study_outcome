package u7b;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Map<String, String> a = null;

    public b() {
    }

    static {
        HashMap r0 = new HashMap();
        InputStream r1 = b.class.getResourceAsStream("/org/org.commonmark/internal/util/entities.properties");
        if (r1 != null) goto L29;
        r0.put("NewLine", "\n");
    L16:
        a = r0;
        return;
    L29:
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r1, StandardCharsets.UTF_8));     // Catch: IOException -> L24
    L30:
        String r2 = r5.readLine();     // Catch: Throwable -> L18
        if (r2 == null) goto L14;
        if (r2.length() == 0) goto L30;
        int r4 = r2.indexOf("=");     // Catch: Throwable -> L18
        r0.put(r2.substring(0, r4), r2.substring(r4 + 1));     // Catch: Throwable -> L18
    L14:
        r5.close();     // Catch: IOException -> L24
        r0.put("NewLine", "\n");
    L18:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L24
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        throw new IllegalStateException("Failed reading data for HTML named character references", e);
    }

    public static String a(String r4) {
        if (r4.startsWith("&") == true) goto L5;
    L25:
        return r4;
    L5:
        if (r4.endsWith(";") == false) goto L25;
        String r1 = r4.substring(1, r4.length() - 1);
        if (r1.startsWith("#") == false) goto L22;
        String r5 = r1.substring(1);
        if (r5.startsWith("x") == false) goto L12;
    L15:
        r5 = r5.substring(1);
        int r2 = 16;
    L26:
        int r6 = CastIntegerProtector.parseInt(r5, r2);     // Catch: IllegalArgumentException -> L21
        if (r6 != 0) goto L19;
        return "�";
    L19:
        return new String(Character.toChars(r6));
    L21:
        return "�";
    L12:
        if (r5.startsWith("X") == true) goto L15;
        r2 = 10;
        goto L26
    L22:
        String r0 = (String) ((HashMap) a).get(r1);
        if (r0 == null) goto L25;
        return r0;
    }
}
