package ms.bd.c;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.util.HashMap;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class v {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public static final u j = null;

    static {
        a = (String) p2.a(16777217, 0, 0, "a7ce96", new byte[]{64, 39, 31, 18, 3, 50, 113, 25, 32});
        b = (String) p2.a(16777217, 0, 0, "12cfb9", new byte[]{8, 49, 2, 22, 74, 47, 32, 22});
        c = (String) p2.a(16777217, 0, 0, "f0b44b", new byte[]{81, 55, 16, 84, 30, 103, 96, 2});
        d = (String) p2.a(16777217, 0, 0, "9cad6a", new byte[]{56, 98});
        e = (String) p2.a(16777217, 0, 0, "fe9478", new byte[]{ByteCompanionObject.MAX_VALUE, 112});
        f = (String) p2.a(16777217, 0, 0, "7109ca", new byte[]{32, 39});
        g = (String) p2.a(16777217, 0, 0, "e1092e", new byte[]{121, 50, 91});
        h = (String) p2.a(16777217, 0, 0, "28da52", new byte[]{46, 51, 25});
        i = (String) p2.a(16777217, 0, 0, "024b3c", new byte[]{34, 63, 85, 19});
        j = new u();
    }

    public static HashMap c() {
        HashMap r0 = new HashMap();
        BufferedReader r1 = null;
        PolarisFileReaderWrapper r2 = new PolarisFileReaderWrapper((String) p2.a(16777217, 0, 0, "0e4185", new byte[]{110, 119, 85, 74, 4, 109, 48, 84, 112, 104, 47, 97, 72}));     // Catch: Throwable -> L21
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L20
    L33:
        String r4 = r3.readLine();     // Catch: Throwable -> L19
        if (r4 != null) goto L11;
        r3.close();     // Catch: Throwable -> L29
    L35:
        r2.close();     // Catch: Throwable -> L30
    L28:
        return r0;
    L11:
        String[] r5 = r4.split((String) p2.a(16777217, 0, 0, "27c013", new byte[]{121}), 2);     // Catch: Throwable -> L19
        if (r5.length < 2) goto L33;
        String r6 = r5[0].trim();     // Catch: Throwable -> L19
        String r7 = r5[1].trim();     // Catch: Throwable -> L19
        if (r0.get(r6) != null) goto L33;
        r0.put(r6, r7);     // Catch: Throwable -> L19
    L19:
        r1 = r3;
    L22:
        if (r1 != null) goto L31;
    L26:
        if (r2 == null) goto L28;
    L31:
        r1.close();     // Catch: Throwable -> L25
    L21:
        r2 = null;
        goto L22
    }

    public static String a(String r10) {
        String r2 = null;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r10);     // Catch: Throwable -> L14
        if (r3.exists() == false) goto L6;
        PolarisFileReaderWrapper r11 = new PolarisFileReaderWrapper(r3);     // Catch: Throwable -> L14
        BufferedReader r4 = new BufferedReader(r11);     // Catch: Throwable -> L13
        r2 = r4.readLine();     // Catch: Throwable -> L12
        r4.close();     // Catch: Throwable -> L27
    L36:
        r11.close();     // Catch: Throwable -> L22
    L23:
        if (r2 != null) goto L26;
        return (String) p2.a(16777217, 0, 0, "d34651", new byte[]{37});
    L26:
        return r2.trim();
    L15:
        if (r4 != null) goto L28;
    L19:
        if (r11 == null) goto L23;
    L28:
        r4.close();     // Catch: Throwable -> L18
    L13:
        r4 = null;
        goto L15
    L6:
        return (String) p2.a(16777217, 0, 0, "0ad581", new byte[]{113});
    L14:
        r11 = null;
        r4 = null;
        goto L15
    }

    public static String b(HashMap r0, String r1) {
        String r2 = (String) r0.get(r1);     // Catch: Throwable -> L4
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.trim();
    L4:
        r2 = null;
        goto L5
    }
}
