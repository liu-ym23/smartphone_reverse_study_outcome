package mqc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import nqc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static String a;

    public static String a(Context r13) {
        if (a != null) goto L66;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r13.getApplicationInfo().sourceDir);
        String r14 = "";
        ByteBuffer r1 = a.b(r0);     // Catch: Exception -> L10
        if (a.d(r1) == false) goto L9;
        String r2 = g.a(r1.array());     // Catch: Exception -> L10
        String r3 = "";
    L11:
        String[] r4 = {r2, a.a, r3};
        if (TextUtils.isEmpty(r2) == false) goto L62;
        ZipFile r5 = null;
        ZipFile r6 = new PolarisZipFileWrapper(r0);     // Catch: Throwable -> L46 Exception -> L68
        goto L51
    L79:
        Enumeration<? extends ZipEntry> r7 = r6.entries();     // Catch: Throwable -> L43 Exception -> L45
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L43 Exception -> L45
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
    L17:
        if (r7.hasMoreElements() == false) goto L30;
        ZipEntry r12 = r7.nextElement();     // Catch: Throwable -> L43 Exception -> L45
        if (r12.getName().startsWith("META-INF/") == false) goto L17;
        if (r12.getName().endsWith("MANIFEST.MF") == false) goto L24;
        r11 = true;
    L29:
        r8.add(Long.valueOf(r12.getCrc()));     // Catch: Throwable -> L43 Exception -> L45
        goto L17
    L24:
        if (r12.getName().endsWith(".SF") == false) goto L27;
        r9 = true;
        goto L29
    L27:
        if (r12.getName().endsWith(".RSA") == false) goto L29;
        r10 = true;
        goto L29
    L30:
        Collections.sort(r8, Collections.reverseOrder());     // Catch: Throwable -> L43 Exception -> L45
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L43 Exception -> L45
        Iterator r16 = r8.iterator();     // Catch: Throwable -> L43 Exception -> L45
    L32:
        if (r16.hasNext() == false) goto L34;
        r15.append((Long) r16.next());     // Catch: Throwable -> L43 Exception -> L45
        goto L32
    L34:
        if (r11 == false) goto L39;
        if (r9 == false) goto L39;
        if (r10 == false) goto L39;
        String r17 = g.a(r15.toString().getBytes());     // Catch: Throwable -> L43 Exception -> L45
        String r18 = "";
    L75:
        r6.close();     // Catch: Throwable -> L42
    L57:
        r4 = new String[3];
        r4[0] = r17;
        if (TextUtils.isEmpty(r17) == true) goto L61;
        r14 = "V1";
    L61:
        r4[1] = r14;
        r4[2] = r18;
        goto L62
    L39:
        r18 = "without v1 signature.";
        r17 = "";
    L45:
        r5 = r6;
    L43:
        th = th;
        r5 = r6;
    L47:
        if (r5 != null) goto L73;
    L50:
        throw th;
    L73:
        r5.close();     // Catch: Throwable -> L67
    L46:
        th = th;
    L51:
        if (r5 != null) goto L69;
    L56:
        r17 = "";
        r18 = r17;
        goto L57
    L69:
        r5.close();     // Catch: Throwable -> L55
    L62:
        String r19 = r4[0];
        a = r19;
        if (TextUtils.isEmpty(r19) == false) goto L66;
        ZeusLogger.w("Zeus/init_zeus", "getHostIdentity failed. Reason: " + r4[2]);
        goto L66
    L9:
        r3 = "without v2 & v3 signature.";
        r2 = "";
    L10:
        r2 = "";
        r3 = r2;
    L66:
        return a;
    }

    public static String b(String r4, String r5) {
        Mac r1 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L13
        r1.init(new SecretKeySpec(r5.getBytes(), "HmacSHA256"));     // Catch: Exception -> L13
        byte[] r6 = r1.doFinal(r4.getBytes());     // Catch: Exception -> L13
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L13
        int r0 = 0;
    L4:
        if (r6 == null) goto L11;
        if (r0 >= r6.length) goto L11;
        String r2 = Integer.toHexString(r6[r0] & UByte.MAX_VALUE);     // Catch: Exception -> L13
        if (r2.length() != 1) goto L10;
        r7.append('0');     // Catch: Exception -> L13
    L10:
        r7.append(r2);     // Catch: Exception -> L13
        r0 = r0 + 1;     // Catch: Exception -> L13
    L11:
        return r7.toString().toLowerCase();
    L13:
        return "";
    }
}
