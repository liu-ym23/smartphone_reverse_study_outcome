package ms.bd.c;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class x1 {
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public final int a;
    public final String b;
    public final String c;
    public final Throwable d;

    static {
        e = (String) p2.a(16777217, 0, 0, "7ce50b", new byte[]{50});
        f = (String) p2.a(16777217, 0, 0, "1ea8ad", new byte[]{50});
        g = (String) p2.a(16777217, 0, 0, "927675", new byte[]{59});
        h = (String) p2.a(16777217, 0, 0, "e19cea", new byte[]{114});
        i = (String) p2.a(16777217, 0, 0, "fdf624", new byte[]{116});
    }

    public final String[] a() {
        String r0 = String.valueOf(this.a);
        JSONObject r1 = new JSONObject();
        r1.put(e, System.currentTimeMillis());     // Catch: Throwable -> L16
        r1.put(f, this.a);     // Catch: Throwable -> L16
        if (this.d == null) goto L13;
        String r4 = g;     // Catch: Throwable -> L16
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L16
        r5.append(this.d.getMessage());     // Catch: Throwable -> L16
        StackTraceElement[] r6 = this.d.getStackTrace();     // Catch: Throwable -> L16
        int r7 = r6.length;     // Catch: Throwable -> L16
        int r8 = 0;
        int r9 = 0;
    L6:
        if (r8 >= r7) goto L11;
        StackTraceElement r10 = r6[r8];     // Catch: Throwable -> L16
        int r11 = r9 + 1;     // Catch: Throwable -> L16
        if (r9 >= 3) goto L11;
        r5.append("\n");     // Catch: Throwable -> L16
        r5.append(r10.toString());     // Catch: Throwable -> L16
        r8 = r8 + 1;     // Catch: Throwable -> L16
        r9 = r11;
    L11:
        String r12 = r5.toString();     // Catch: Throwable -> L16
    L12:
        r1.put(r4, r12);     // Catch: Throwable -> L16
        String r2 = Base64.encodeToString(r1.toString().getBytes(StandardCharsets.UTF_8), 2);     // Catch: Throwable -> L16
    L18:
        return new String[]{r0, r2};
    L13:
        r1.put(h, this.b);     // Catch: Throwable -> L16
        r4 = i;     // Catch: Throwable -> L16
        r12 = this.c;     // Catch: Throwable -> L16
    L16:
        r2 = "";
        goto L18
    }

    public x1(int r1, String r2, String r3, Throwable r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
