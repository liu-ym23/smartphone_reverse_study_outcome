package com.obric.memorydata.datatransport.utils;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ@\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\f\u001a\u00020\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ4\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0019H\u0002J<\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00052\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/ZipUtils;", "", "<init>", "()V", "TAG", "", "BUFFER_SIZE", "", "zipDirectoryContent", "", "srcDir", "Ljava/io/File;", "destZipFile", "progressCallback", "Lkotlin/Function2;", "", "zipMultiSources", "sources", "", "zipFileOrDirectory", "file", "entryName", "zos", "Ljava/util/zip/ZipOutputStream;", "onBytesWritten", "Lkotlin/Function1;", "encryptFile", "srcFile", "destFile", "password", "calculateTotalSize", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9845a = null;

    static {
        f9845a = new j();
    }

    private j() {
    }

    private final long a(File r6) {
        long r0 = 0;
        if (r6.isDirectory() == false) goto L10;
        File[] r5 = r6.listFiles();
        if (r5 == null) goto L12;
        int r7 = 0;
        int r2 = r5.length;
    L7:
        if (r7 >= r2) goto L13;
        File r3 = r5[r7];
        j r4 = f9845a;
        Intrinsics.checkNotNull(r3);
        r0 = r0 + r4.a(r3);
        r7 = r7 + 1;
        goto L7
    L13:
        return r0;
    L12:
        return 0;
    L10:
        return 0 + r6.length();
    }

    private static final Unit a(Ref.LongRef r2, Function2 r3, long r4, long r6) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        r2.element += r6;
        if (r5 == null) goto L6;
        r5.invoke(Long.valueOf(r2.element), Long.valueOf(r4));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.LongRef r2, Function2 r3, Ref.LongRef r4, long r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        r2.element += r5;
        if (r6 == null) goto L6;
        r6.invoke(Long.valueOf(r2.element), Long.valueOf(r4.element));
    L6:
        return Unit.INSTANCE;
    }

    private final void a(File r11, String r12, ZipOutputStream r13, Function1<? super Long, Unit> r14) {
        Function1<? super Long, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r11.isDirectory() == false) goto L10;
        File[] r16 = r11.listFiles();
        if (r16 != null) goto L7;
        return;
    L7:
        r13.putNextEntry(new ZipEntry(r12 + '/'));
        r13.closeEntry();
        int r0 = r16.length;
    L8:
        if (r2 >= r0) goto L32;
        File r1 = r16[r2];
        Intrinsics.checkNotNull(r1);
        a(r1, r12 + '/' + r1.getName(), r13, r15);
        r2 = r2 + 1;
        goto L8
    L32:
        return;
    L10:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r11), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        BufferedInputStream r3 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r10, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r4 = h.f9842a.a(r12, r3);     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r4, r12) == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ZipUtils", "Normalize image extension in zip: " + r12 + " -> " + r4, false, 4, null);     // Catch: Throwable -> L21
    L14:
        r13.putNextEntry(new ZipEntry(r4));     // Catch: Throwable -> L21
        byte[] r17 = new byte[8192];     // Catch: Throwable -> L21
    L15:
        int r5 = r3.read(r17);     // Catch: Throwable -> L21
        if (r5 == (-1)) goto L18;
        r13.write(r17, 0, r5);     // Catch: Throwable -> L21
        r15.invoke(Long.valueOf(r5));     // Catch: Throwable -> L21
        goto L15
    L18:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r10, null);
        r13.closeEntry();
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private static final Unit b(Ref.LongRef r2, Function2 r3, Ref.LongRef r4, long r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        r2.element += r5;
        if (r6 == null) goto L6;
        r6.invoke(Long.valueOf(r2.element), Long.valueOf(r4.element));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit c(Ref.LongRef r2, Function2 r3, Ref.LongRef r4, long r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        r2.element += r5;
        if (r6 == null) goto L6;
        r6.invoke(Long.valueOf(r2.element), Long.valueOf(r4.element));
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$2O_ISP9_79XmxAOJD0Edh4LtAeo(Ref.LongRef r0, Function2 r1, Ref.LongRef r2, long r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$VGJAkFWxB2CkOvaLPAIgjJnK_oA(Ref.LongRef r0, Function2 r1, long r2, long r4) {
        return a(r0, r1, r2, r4);
    }

    public static /* synthetic */ Unit lambda$_PU9khos8bH4Bw10SQumEgh9h4E(Ref.LongRef r0, Function2 r1, Ref.LongRef r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$ibMj_vypqNovHBBy_k29Qm2Nvsc(Ref.LongRef r0, Function2 r1, Ref.LongRef r2, long r3) {
        return c(r0, r1, r2, r3);
    }

    public final void a(File r20, File r21, String r22, Function2<? super Long, ? super Long, Unit> r23) {
        String r4 = "com.obric.memorydata.plugin";
        Function2 r3 = (Function2) ZeusTransformUtils.wrapperContextForParams(r23, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "srcFile");
        Intrinsics.checkNotNullParameter(r21, "destFile");
        Intrinsics.checkNotNullParameter(r22, "password");
        if (r20.exists() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ZipUtils", "Source file for encryption does not exist: " + r20.getAbsolutePath(), null, 4, null);
        return;
    L6:
        byte[] r2 = r22.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");
        if (r2.length != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L72;
        FilesKt.copyTo$default(r20, r21, true, 0, 4, null);
        return;
    L72:
        long r7 = r20.length();     // Catch: Exception -> L67
        long r9 = 0;
        if (Intrinsics.areEqual(r20.getCanonicalPath(), r21.getCanonicalPath()) == false) goto L16;
        File r6 = new File(r21.getParent(), r21.getName() + ".tmp");     // Catch: Exception -> L67
    L75:
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r20), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        BufferedInputStream r12 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r11, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        BufferedOutputStream r14 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r13, BufferedOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L47
        int r16 = 0;
    L20:
        int r8 = r12.read(r15);     // Catch: Throwable -> L47
        if (r8 == (-1)) goto L35;
        int r1 = 0;
    L23:
        if (r1 >= r8) goto L31;
        BufferedInputStream r24 = r12;
        r15[r1] = (byte) (r15[r1] ^ r2[r16]);     // Catch: Throwable -> L47
        int r17 = r16 + 1;
        String r18 = r4;
    L45:
        th = th;
    L49:
        Throwable r10 = th;
        throw r10;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r13, r10);     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L27:
        if (r17 < r2.length) goto L29;
        r16 = 0;
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L45
        r12 = r24;
        r4 = r18;
        goto L23
    L29:
        r16 = r17;
        goto L30
    L31:
        String r19 = r4;
        BufferedInputStream r25 = r12;
        r14.write(r15, 0, r8);     // Catch: Throwable -> L45
        byte[] r110 = r2;
        r9 = r9 + ((long) r8);     // Catch: Throwable -> L45
        if (r3 == null) goto L34;
        r3.invoke(Long.valueOf(r9), Long.valueOf(r7));     // Catch: Throwable -> L45
    L34:
        r2 = r110;
        r12 = r25;
        r4 = r19;
        goto L20
    L35:
        r18 = r4;
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L55
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L65
        if (Intrinsics.areEqual(r20.getCanonicalPath(), r21.getCanonicalPath()) == true) goto L41;
        return;
    L41:
        if (r21.exists() == false) goto L43;
        r21.delete();     // Catch: Exception -> L65
    L43:
        r6.renameTo(r21);     // Catch: Exception -> L65
        return;
    L47:
        th = th;
        r18 = r4;
    L55:
        th = th;
    L59:
        Throwable r28 = th;
        throw r28;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        CloseableKt.closeFinally(r11, r28);     // Catch: Exception -> L65
        throw th;     // Catch: Exception -> L65
    L57:
        th = th;
        r18 = "com.obric.memorydata.plugin";
    L65:
        e = e;
    L69:
        RunLog.INSTANCE.error("ZipUtils", "Failed to encrypt file: " + r20.getAbsolutePath(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r18));
        throw e;
    L16:
        r6 = r21;
    L67:
        e = e;
        r18 = "com.obric.memorydata.plugin";
        goto L69
    L9:
        r5 = false;
        goto L10
    }

    public final void a(File r17, File r18, Function2<? super Long, ? super Long, Unit> r19) {
        final Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "srcDir");
        Intrinsics.checkNotNullParameter(r18, "destZipFile");
        if (r17.exists() == true) goto L5;
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ZipUtils", "Source directory does not exist or is not a directory: " + r17.getAbsolutePath(), null, 4, null);
        return;
    L5:
        if (r17.isDirectory() == false) goto L35;
        if (r18.exists() == false) goto L37;
        r18.delete();
    L37:
        final long r5 = a(r17);     // Catch: Exception -> L30
        final Ref.LongRef r3 = new Ref.LongRef();     // Catch: Exception -> L30
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r18), OutputStream.class, "com.obric.memorydata.plugin")), OutputStream.class, "com.obric.memorydata.plugin"), StandardCharsets.UTF_8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        ZipOutputStream r9 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r7, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        File[] r10 = r17.listFiles();     // Catch: Throwable -> L23
        if (r10 == null) goto L17;
        int r11 = 0;
        int r12 = r10.length;     // Catch: Throwable -> L23
    L15:
        if (r11 >= r12) goto L17;
        File r13 = r10[r11];     // Catch: Throwable -> L23
        j r14 = f9845a;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L23
        String r15 = r13.getName();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");     // Catch: Throwable -> L23
        r14.a(r13, r15, r9, new $$Lambda$j$VGJAkFWxB2CkOvaLPAIgjJnK_oA(r3, r0, r5));     // Catch: Throwable -> L23
        r11 = r11 + 1;     // Catch: Throwable -> L23
    L17:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L19:
        CloseableKt.closeFinally(r7, null);     // Catch: Exception -> L30
        if (r0 == null) goto L43;
        r0.invoke(Long.valueOf(r5), Long.valueOf(r5));     // Catch: Exception -> L30
        return;
    L43:
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        RunLog.INSTANCE.error("ZipUtils", "Failed to zip directory: " + r17.getAbsolutePath(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        if (r18.exists() == false) goto L34;
        r18.delete();
    L34:
        throw e;
    }

    public final void a(Map<String, ? extends File> r18, File r19, Function2<? super Long, ? super Long, Unit> r20) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        final Function2 r3 = (Function2) ZeusTransformUtils.wrapperContextForParams(r20, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "sources");
        Intrinsics.checkNotNullParameter(r19, "destZipFile");
        if (r19.exists() == false) goto L52;
        r19.delete();
    L52:
        final Ref.LongRef r4 = new Ref.LongRef();     // Catch: Exception -> L45
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L45
    L7:
        if (r5.hasNext() == false) goto L9;
        r4.element += f9845a.a((File) ZeusTransformUtils.preCheckCast(r5.next(), File.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L45
        goto L7
    L9:
        final Ref.LongRef r6 = new Ref.LongRef();     // Catch: Exception -> L45
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r19), OutputStream.class, "com.obric.memorydata.plugin")), OutputStream.class, "com.obric.memorydata.plugin"), StandardCharsets.UTF_8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        ZipOutputStream r8 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r7, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Iterator r1 = r0.entrySet().iterator();     // Catch: Throwable -> L38
    L13:
        if (r1.hasNext() == false) goto L33;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        File r11 = (File) ZeusTransformUtils.preCheckCast(r9.getValue(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r11.exists() == false) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L24;
        f9845a.a(r11, r10, r8, new $$Lambda$j$ibMj_vypqNovHBBy_k29Qm2Nvsc(r6, r3, r4));     // Catch: Throwable -> L38
        goto L13
    L24:
        if (r11.isDirectory() == true) goto L25;
        j r13 = f9845a;     // Catch: Throwable -> L38
        String r14 = r11.getName();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r14, "getName(...)");     // Catch: Throwable -> L38
        r13.a(r11, r14, r8, new $$Lambda$j$2O_ISP9_79XmxAOJD0Edh4LtAeo(r6, r3, r4));     // Catch: Throwable -> L38
        goto L13
    L25:
        File[] r15 = r11.listFiles();     // Catch: Throwable -> L38
        if (r15 == null) goto L13;
        Iterator r16 = ArrayIteratorKt.iterator(r15);     // Catch: Throwable -> L38
    L29:
        if (r16.hasNext() == false) goto L13;
        File r17 = (File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        j r110 = f9845a;     // Catch: Throwable -> L38
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L38
        String r111 = r17.getName();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r111, "getName(...)");     // Catch: Throwable -> L38
        r110.a(r17, r111, r8, new $$Lambda$j$_PU9khos8bH4Bw10SQumEgh9h4E(r6, r3, r4));     // Catch: Throwable -> L38
        goto L29
    L20:
        r12 = false;
        goto L21
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ZipUtils", "Source path does not exist: " + r11.getAbsolutePath(), null, 4, null);     // Catch: Throwable -> L38
        goto L13
    L33:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r7, null);     // Catch: Exception -> L45
        if (r3 == null) goto L70;
        r3.invoke(Long.valueOf(r4.element), Long.valueOf(r4.element));     // Catch: Exception -> L45
        return;
    L70:
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        RunLog.INSTANCE.error("ZipUtils", "Failed to zip multi sources", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        if (r19.exists() == false) goto L49;
        r19.delete();
    L49:
        throw e;
    }
}
