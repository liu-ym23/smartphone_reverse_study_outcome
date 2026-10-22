package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class g3 {
    public static void a(Context r14, String r15) {
        Os.setenv("28d7fdd567361198183fa7b8e", "a7", true);     // Catch: Exception -> L5
    L6:
        i3 r1 = new i3();
        if (r14 == null) goto L138;
        if (r15 == null) goto L136;
        if (r15.length() == 0) goto L136;
        Locale r2 = Locale.US;
        if (r1.a.contains(r15) == true) goto L175;
        r1.b.getClass();     // Catch: UnsatisfiedLinkError -> L16
        i3.a(r15);     // Catch: UnsatisfiedLinkError -> L16
        r1.a.add(r15);     // Catch: UnsatisfiedLinkError -> L16
        return;
    L16:
        e = move-exception;
        Log.getStackTraceString(e);
        Locale r3 = Locale.US;
        r1.b.getClass();
        if (r15.startsWith("lib") == true) goto L20;
    L22:
        String r4 = System.mapLibraryName(r15);
    L23:
        PolarisFileWrapper r5 = new PolarisFileWrapper(r14.getDir("lib", 0), r4);
        if (r5.exists() == true) goto L118;
        File r6 = r14.getDir("lib", 0);
        r1.b.getClass();
        if (r15.startsWith("lib") == true) goto L29;
    L31:
        String r7 = System.mapLibraryName(r15);
    L32:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r14.getDir("lib", 0), r7);
        r1.b.getClass();
        if (r15.startsWith("lib") == true) goto L35;
    L37:
        String r9 = System.mapLibraryName(r15);
    L38:
        File[] r10 = r6.listFiles(new h3(r9));
        if (r10 == null) goto L47;
        int r11 = r10.length;
        int r12 = 0;
    L42:
        if (r12 >= r11) goto L47;
        File r13 = r10[r12];
        if (r13.getAbsolutePath().equals(r8.getAbsolutePath()) == true) goto L46;
        r13.delete();
    L46:
        r12 = r12 + 1;
    L47:
        h r16 = r1.c;
        r1.b.getClass();
        String[] r17 = Build.SUPPORTED_ABIS;
        if (r17.length > 0) goto L57;
        String r18 = Build.CPU_ABI2;
        if (r18 != null) goto L53;
    L56:
        r17 = new String[]{Build.CPU_ABI};
        goto L57
    L53:
        if (r18.length() == 0) goto L56;
        r17 = new String[]{Build.CPU_ABI, r18};
    L57:
        r1.b.getClass();
        if (r15.startsWith("lib") == true) goto L60;
    L62:
        String r19 = System.mapLibraryName(r15);
    L63:
        r16.getClass();
        g r20 = null;
        g r21 = h.a(r14, r17, r19, r1);     // Catch: Throwable -> L129
        if (r21 == null) goto L151;
        int r110 = 0;
    L67:
        int r22 = r110 + 1;
        if (r110 >= 5) goto L115;
        Locale r111 = Locale.US;     // Catch: Throwable -> L122
        if (r5.exists() == true) goto L163;
        if (r5.createNewFile() == false) goto L114;
    L163:
        g r112 = r21.a.getInputStream(r21.b);     // Catch: Throwable -> L104 Throwable -> L108
        g r23 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L102 Throwable -> L140
    L100:
        Throwable th = th;
        r20 = r23;
    L103:
        g r113 = r20;
        r20 = r112;
        g r114 = r113;
    L106:
        h.b(r20);     // Catch: Throwable -> L122
        h.b(r114);     // Catch: Throwable -> L122
        throw th;     // Catch: Throwable -> L122
    L78:
        if (r5.getPath().contains("../") == false) goto L86;
        System.currentTimeMillis();     // Catch: Throwable -> L100 Throwable -> L139
        goto L110
    L80:
        h.b(r112);     // Catch: Throwable -> L122
        h.b(r23);     // Catch: Throwable -> L122
        ZipFile r115 = r21.a;     // Catch: IOException -> L142
        if (r115 == null) goto L158;
        r115.close();     // Catch: IOException -> L142
    L158:
        goto L118
    L86:
        byte[] r24 = new byte[4096];     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        long r25 = 0;
    L87:
        int r116 = r112.read(r24);     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        if (r116 == (-1)) goto L89;
        r23.write(r24, 0, r116);     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        r25 = r25 + ((long) r116);
        goto L87
    L89:
        r23.flush();     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        r23.getFD().sync();     // Catch: Throwable -> L100 Throwable -> L139 Throwable -> L139
        if (r25 == r5.length()) goto L93;
        h.b(r112);     // Catch: Throwable -> L122
    L111:
        h.b(r23);     // Catch: Throwable -> L122
        goto L114
    L93:
        h.b(r112);     // Catch: Throwable -> L122
        h.b(r23);     // Catch: Throwable -> L122
        r5.setReadable(true, false);     // Catch: Throwable -> L122
        r5.setExecutable(true, false);     // Catch: Throwable -> L122
        r5.setWritable(true);     // Catch: Throwable -> L122
        ZipFile r117 = r21.a;     // Catch: IOException -> L142
        if (r117 == null) goto L158;
        r117.close();     // Catch: IOException -> L142
    L110:
        h.b(r112);     // Catch: Throwable -> L122
        goto L111
    L102:
        th = th;
    L109:
        r23 = null;
        goto L110
    L108:
        r112 = null;
    L104:
        th = move-exception;
        th = th;
        r114 = null;
    L114:
        r110 = r22;
        goto L67
    L115:
        ZipFile r118 = r21.a;     // Catch: IOException -> L142
        if (r118 == null) goto L158;
        r118.close();     // Catch: IOException -> L142
        goto L158
    L151:
        String[] r119 = h.c(r14, r19);     // Catch: Throwable -> L122 Exception -> L124
    L127:
        throw new r2(r19, r17, r119);     // Catch: Throwable -> L122
    L124:
        e = move-exception;
        r119 = new String[]{e.toString()};     // Catch: Throwable -> L122
    L122:
        th = th;
        r20 = r21;
    L130:
        if (r20 != null) goto L149;
    L134:
        throw th;
    L149:
        ZipFile r120 = r20.a;     // Catch: IOException -> L141
        if (r120 == null) goto L134;
        r120.close();     // Catch: IOException -> L141
    L129:
        th = th;
        goto L130
    L60:
        if (r15.endsWith(".so") == false) goto L62;
        r19 = r15;
        goto L63
    L35:
        if (r15.endsWith(".so") == false) goto L37;
        r9 = r15;
        goto L38
    L29:
        if (r15.endsWith(".so") == false) goto L31;
        r7 = r15;
    L118:
        c4 r121 = r1.b;
        String r0 = r5.getAbsolutePath();
        r121.getClass();
        System.load(r0);
        r1.a.add(r15);
        Locale r122 = Locale.US;
        return;
    L20:
        if (r15.endsWith(".so") == false) goto L22;
        r4 = r15;
        goto L23
    L175:
        return;
    L136:
        throw new IllegalArgumentException("Given library is either null or empty");
    L138:
        throw new IllegalArgumentException("Given context is null");
    }
}
