package d8;

import com.obric.aikernel.runtime.utils.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8513a = null;

    static {
        f8513a = new b();
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T] */
    public final boolean a(InputStream r12, String r13, Function1<? super Map<String, Long>, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "inputStream");
        Intrinsics.checkNotNullParameter(r13, "unzipFileFolderPath");
        String r11 = r13 + "_temp";
        ZipInputStream r10 = null;
        if (r14 == null) goto L5;
        LinkedHashMap r15 = new LinkedHashMap();
    L6:
        File r16 = new File(r11);
        String r17 = r16.getCanonicalPath();     // Catch: Throwable -> L52 Exception -> L54
        ZipInputStream r18 = new ZipInputStream(new BufferedInputStream(r12));     // Catch: Throwable -> L52 Exception -> L54
        Ref.ObjectRef r19 = new Ref.ObjectRef();     // Catch: Throwable -> L48 Exception -> L50
        ?? r20 = r18.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
    L35:
        r19.element = r20;     // Catch: Throwable -> L48 Exception -> L50
        Object r21 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        if (r21 == null) goto L38;
        File r22 = new File(r16, ((ZipEntry) r21).getName());     // Catch: Throwable -> L48 Exception -> L50
        String r23 = r22.getCanonicalPath();     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r23, "canonicalDestPath");     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r17, "canonicalDirPath");     // Catch: Throwable -> L48 Exception -> L50
        if (StringsKt.startsWith$default(r23, r17, false, 2, null) == false) goto L37;
        if (((ZipEntry) r19.element).isDirectory() == true) goto L15;
        File r24 = r22.getParentFile();     // Catch: Throwable -> L48 Exception -> L50
        if (r24 == null) goto L22;
        if (r24.exists() == true) goto L22;
        r24.mkdirs();     // Catch: Throwable -> L48 Exception -> L50
    L24:
        BufferedOutputStream r25 = new BufferedOutputStream(new FileOutputStream(r22));     // Catch: Throwable -> L48 Exception -> L50
        byte[] r26 = new byte[8192];     // Catch: Throwable -> L48 Exception -> L50
    L25:
        int r27 = r18.read(r26);     // Catch: Throwable -> L48 Exception -> L50
        if (r27 == (-1)) goto L28;
        r25.write(r26, 0, r27);     // Catch: Throwable -> L48 Exception -> L50
        goto L25
    L28:
        if (r15 == null) goto L34;
        Object r28 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L48 Exception -> L50
        String r29 = ((ZipEntry) r28).getName();     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r29, "zipEntry!!.name");     // Catch: Throwable -> L48 Exception -> L50
        Object r30 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r30);     // Catch: Throwable -> L48 Exception -> L50
        r15.put(r29, Long.valueOf(((ZipEntry) r30).getSize()));     // Catch: Throwable -> L48 Exception -> L50
        Object r31 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L48 Exception -> L50
        if (((ZipEntry) r31).getSize() > 0) goto L34;
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L48 Exception -> L50
        r110.append(r13);     // Catch: Throwable -> L48 Exception -> L50
        r110.append(" entry ");     // Catch: Throwable -> L48 Exception -> L50
        Object r111 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L48 Exception -> L50
        r110.append(((ZipEntry) r111).getName());     // Catch: Throwable -> L48 Exception -> L50
        r110.append(" size incorrect! ");     // Catch: Throwable -> L48 Exception -> L50
        Object r112 = r19.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L48 Exception -> L50
        r110.append(((ZipEntry) r112).getSize());     // Catch: Throwable -> L48 Exception -> L50
        throw new IllegalStateException(r110.toString());     // Catch: Throwable -> L48 Exception -> L50
    L34:
        r25.flush();     // Catch: Throwable -> L48 Exception -> L50
        r25.close();     // Catch: Throwable -> L48 Exception -> L50
        r18.closeEntry();     // Catch: Throwable -> L48 Exception -> L50
        r20 = r18.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
    L22:
        if (r22.exists() == false) goto L24;
        r22.delete();     // Catch: Throwable -> L48 Exception -> L50
        goto L24
    L15:
        r22.mkdirs();     // Catch: Throwable -> L48 Exception -> L50
        r20 = r18.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
        goto L35
    L37:
        throw new IOException("Entry is outside of the target dir: " + ((ZipEntry) r19.element).getName());     // Catch: Throwable -> L48 Exception -> L50
    L38:
        com.obric.aikernel.res.utils.a.f5222a.i(new File(r11), new File(r13));     // Catch: Throwable -> L48 Exception -> L50
        if (r15 == null) goto L72;
        if (r14 == null) goto L72;
        r14.invoke(r15);     // Catch: Throwable -> L48 Exception -> L50
    L72:
        r18.close();     // Catch: Exception -> L45
    L47:
        return true;
    L45:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = e;
        r10 = r18;
    L55:
        d.f5417a.f("Unzip", "unzip " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L52
        if (r10 != null) goto L70;
    L61:
        return false;
    L70:
        r10.close();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L48:
        th = th;
        r10 = r18;
    L62:
        if (r10 != null) goto L75;
    L67:
        throw th;
    L75:
        r10.close();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = th;
    L54:
        e = e;
        goto L55
    L5:
        r15 = null;
        goto L6
    }

    public final boolean b(String r10, String r11, Function1<? super Map<String, Long>, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "zipFilePath");
        Intrinsics.checkNotNullParameter(r11, "unzipFileFolderPath");
        return a(new FileInputStream(r10), r11, r12);
    }
}
