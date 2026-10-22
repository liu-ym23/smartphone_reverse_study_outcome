package com.obric.aikernel.res.b;

import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\"\b\u0002\u0010\n\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bJ:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\"\b\u0002\u0010\n\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/res/storage/Unzip;", "", "()V", "TAG", "", "unzip", "", "inputStream", "Ljava/io/InputStream;", "unzipFileFolderPath", "entryInfoCollector", "Lkotlin/Function1;", "", "", "", "zipFilePath", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6004a = null;

    static {
        f6004a = new b();
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T] */
    public final boolean a(InputStream r13, String r14, Function1<? super Map<String, Long>, Unit> r15) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "inputStream");
        Intrinsics.checkNotNullParameter(r14, "unzipFileFolderPath");
        String r16 = r14 + "_temp";
        ZipInputStream r1 = null;
        if (r12 == null) goto L5;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L6:
        File r3 = new File(r16);
        String r5 = r3.getCanonicalPath();     // Catch: Throwable -> L52 Exception -> L54
        ZipInputStream r6 = new ZipInputStream((InputStream) ZeusTransformUtils.preCheckCast(new BufferedInputStream(r13), InputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L52 Exception -> L54
        Ref.ObjectRef r17 = new Ref.ObjectRef();     // Catch: Throwable -> L48 Exception -> L50
        ?? r7 = r6.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
    L35:
        r17.element = r7;     // Catch: Throwable -> L48 Exception -> L50
        if (r17.element == null) goto L38;
        File r8 = new File(r3, ((ZipEntry) ZeusTransformUtils.preCheckCast(r17.element, ZipEntry.class, "com.obric.memorydata.plugin")).getName());     // Catch: Throwable -> L48 Exception -> L50
        String r9 = r8.getCanonicalPath();     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r9, "canonicalDestPath");     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r5, "canonicalDirPath");     // Catch: Throwable -> L48 Exception -> L50
        if (StringsKt.startsWith$default(r9, r5, false, 2, null) == false) goto L37;
        if (((ZipEntry) ZeusTransformUtils.preCheckCast(r17.element, ZipEntry.class, "com.obric.memorydata.plugin")).isDirectory() == true) goto L15;
        File r10 = r8.getParentFile();     // Catch: Throwable -> L48 Exception -> L50
        if (r10 == null) goto L22;
        if (r10.exists() == true) goto L22;
        r10.mkdirs();     // Catch: Throwable -> L48 Exception -> L50
    L24:
        BufferedOutputStream r11 = new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r8), OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48 Exception -> L50
        byte[] r18 = new byte[8192];     // Catch: Throwable -> L48 Exception -> L50
    L25:
        int r19 = r6.read(r18);     // Catch: Throwable -> L48 Exception -> L50
        if (r19 == (-1)) goto L28;
        r11.write(r18, 0, r19);     // Catch: Throwable -> L48 Exception -> L50
        goto L25
    L28:
        if (r2 == null) goto L34;
        Object r20 = r17.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L48 Exception -> L50
        String r21 = ((ZipEntry) ZeusTransformUtils.preCheckCast(r20, ZipEntry.class, "com.obric.memorydata.plugin")).getName();     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r21, "zipEntry!!.name");     // Catch: Throwable -> L48 Exception -> L50
        Object r22 = r17.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L48 Exception -> L50
        r2.put(r21, Long.valueOf(((ZipEntry) ZeusTransformUtils.preCheckCast(r22, ZipEntry.class, "com.obric.memorydata.plugin")).getSize()));     // Catch: Throwable -> L48 Exception -> L50
        Object r23 = r17.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L48 Exception -> L50
        if (((ZipEntry) ZeusTransformUtils.preCheckCast(r23, ZipEntry.class, "com.obric.memorydata.plugin")).getSize() > 0) goto L34;
        StringBuilder r110 = new StringBuilder().append(r14).append(" entry ");     // Catch: Throwable -> L48 Exception -> L50
        Object r111 = r17.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L48 Exception -> L50
        StringBuilder r112 = r110.append(((ZipEntry) ZeusTransformUtils.preCheckCast(r111, ZipEntry.class, "com.obric.memorydata.plugin")).getName()).append(" size incorrect! ");     // Catch: Throwable -> L48 Exception -> L50
        Object r113 = r17.element;     // Catch: Throwable -> L48 Exception -> L50
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L48 Exception -> L50
        throw new IllegalStateException(r112.append(((ZipEntry) ZeusTransformUtils.preCheckCast(r113, ZipEntry.class, "com.obric.memorydata.plugin")).getSize()).toString());     // Catch: Throwable -> L48 Exception -> L50
    L34:
        r11.flush();     // Catch: Throwable -> L48 Exception -> L50
        r11.close();     // Catch: Throwable -> L48 Exception -> L50
        r6.closeEntry();     // Catch: Throwable -> L48 Exception -> L50
        r7 = r6.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
    L22:
        if (r8.exists() == false) goto L24;
        r8.delete();     // Catch: Throwable -> L48 Exception -> L50
        goto L24
    L15:
        r8.mkdirs();     // Catch: Throwable -> L48 Exception -> L50
        r7 = r6.getNextEntry();     // Catch: Throwable -> L48 Exception -> L50
        goto L35
    L37:
        throw new IOException("Entry is outside of the target dir: " + ((ZipEntry) ZeusTransformUtils.preCheckCast(r17.element, ZipEntry.class, "com.obric.memorydata.plugin")).getName());     // Catch: Throwable -> L48 Exception -> L50
    L38:
        com.obric.aikernel.res.utils.a.f6155a.c(new File(r16), new File(r14));     // Catch: Throwable -> L48 Exception -> L50
        if (r2 == null) goto L74;
        if (r12 == null) goto L74;
        r12.invoke(r2);     // Catch: Throwable -> L48 Exception -> L50
    L74:
        r6.close();     // Catch: Exception -> L45
    L47:
        return true;
    L45:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = e;
        r1 = r6;
    L55:
        d.f6216a.c("Unzip", "unzip " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L52
        if (r1 != null) goto L68;
    L61:
        return false;
    L68:
        r1.close();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L48:
        th = th;
        r1 = r6;
    L62:
        if (r1 != null) goto L72;
    L67:
        throw th;
    L72:
        r1.close();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = th;
    L54:
        e = e;
        goto L55
    L5:
        r2 = null;
        goto L6
    }

    public final boolean a(String r3, String r4, Function1<? super Map<String, Long>, Unit> r5) {
        Function1<? super Map<String, Long>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "zipFilePath");
        Intrinsics.checkNotNullParameter(r4, "unzipFileFolderPath");
        return a((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.memorydata.plugin"), r4, r6);
    }
}
