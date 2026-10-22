package e9;

import android.os.Build;
import com.bytedance.android.anniex.base.service.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16794a = 0;

    static {
        new ArrayList();
    }

    public static String a(String r10, String r11, File r12) {
        ZipFile r5 = null;
        ZipFile r13 = new ZipFile(new File(r10), 1);     // Catch: Throwable -> L35
        StringBuilder r14 = new StringBuilder("lib/");     // Catch: Throwable -> L15
        String r15 = Build.CPU_ABI;     // Catch: Throwable -> L15
        r14.append(r15);     // Catch: Throwable -> L15
        r14.append("/");     // Catch: Throwable -> L15
        r14.append(System.mapLibraryName(r11));     // Catch: Throwable -> L15
        ZipEntry r16 = r13.getEntry(r14.toString());     // Catch: Throwable -> L15
        if (r16 != null) goto L18;
        int r17 = r15.indexOf(45);     // Catch: Throwable -> L15
        StringBuilder r18 = new StringBuilder("lib/");     // Catch: Throwable -> L15
        if (r17 > 0) goto L10;
        r17 = r15.length();     // Catch: Throwable -> L15
    L10:
        r18.append(r15.substring(0, r17));     // Catch: Throwable -> L15
        r18.append("/");     // Catch: Throwable -> L15
        r18.append(System.mapLibraryName(r11));     // Catch: Throwable -> L15
        String r19 = r18.toString();     // Catch: Throwable -> L15
        ZipEntry r110 = r13.getEntry(r19);     // Catch: Throwable -> L15
        if (r110 != null) goto L17;
        String r20 = "Library entry not found:" + r19;     // Catch: Throwable -> L15
        r13.close();     // Catch: IOException -> L49
    L14:
        return r20;
    L17:
        r16 = r110;
    L18:
        r12.createNewFile();     // Catch: Throwable -> L15
        InputStream r21 = r13.getInputStream(r16);     // Catch: Throwable -> L15
        FileOutputStream r111 = new FileOutputStream(r12);     // Catch: Throwable -> L32
        byte[] r22 = new byte[4096];     // Catch: Throwable -> L25
    L22:
        int r23 = r21.read(r22);     // Catch: Throwable -> L25
        if (r23 <= 0) goto L27;
        r111.write(r22, 0, r23);     // Catch: Throwable -> L25
        goto L22
    L27:
        f.j(r12.getAbsolutePath());     // Catch: Throwable -> L25
        f.h(r111);
        f.h(r21);
        r13.close();     // Catch: IOException -> L50
    L30:
        return null;
    L25:
        th = th;
    L31:
        r5 = r13;
    L63:
        String r112 = th.getMessage();     // Catch: Throwable -> L43
        f.h(r111);
        f.h(r21);
        if (r5 != null) goto L68;
    L42:
        return r112;
    L68:
        r5.close();     // Catch: IOException -> L51
    L43:
        th = move-exception;
        f.h(r111);
        f.h(r21);
        if (r5 != null) goto L53;
    L48:
        throw th;
    L53:
        r5.close();     // Catch: IOException -> L52
    L32:
        th = move-exception;
        InputStream r113 = r21;
        th = th;
    L34:
        th = th;
        r21 = r113;
        r111 = null;
    L15:
        th = th;
        r113 = null;
    L35:
        th = th;
        r21 = null;
        r111 = null;
        goto L63
    }
}
