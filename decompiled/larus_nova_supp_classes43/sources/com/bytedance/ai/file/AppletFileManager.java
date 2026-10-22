package com.bytedance.ai.file;

import android.content.Context;
import android.system.ErrnoException;
import android.system.Os;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.bridge.method.net.download.f;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletFileManager {
    public static final char[] j = null;
    public final Context a;
    public final String b;
    public final String c;
    public final PolarisFileWrapper d;
    public final PolarisFileWrapper e;
    public final Lazy f;
    public final d g;
    public final Object h;
    public final Object i;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final long b;
        public final boolean c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r10 = this.b;
            int r11 = (r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
            if (this.c == false) goto L5;
            int r12 = 1231;
        L7:
            return r11 + r12;
        L5:
            r12 = 1237;
            goto L7
        }

        public final String toString() {
            return "FileStat(size=" + this.a + ", mtime=" + this.b + ", isDir=" + this.c + ')';
        }

        public b(long r1, long r10, boolean r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public static final class c {
        public final String a;
        public final long b;
        public final long c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r11 = this.c;
            return r10 + ((int) (r11 ^ (r11 >>> 32)));
        }

        public final String toString() {
            return "SavedFileInfo(filePath=" + this.a + ", size=" + this.b + ", createTime=" + this.c + ')';
        }

        public c(String r10, long r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "filePath");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    static {
        j = "0123456789abcdef".toCharArray();
    }

    public final void b() {
        Object r0 = this.i;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.e.exists() == false) goto L9;
        File r1 = new PolarisFileWrapper((File) this.f.getValue(), String.valueOf(System.nanoTime()));     // Catch: Throwable -> L14
        if (this.e.renameTo(r1) == false) goto L9;
    L10:
        monitor-exit(r0);
        if (r1 == null) goto L19;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AppletFileManager$clearTemp$1(r1, null), 3, null);
        return;
    L19:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final List<c> g() {
        ArrayList r0 = new ArrayList();
        ArrayDeque r1 = new ArrayDeque();
        if (this.d.exists() == false) goto L6;
        r1.addLast(this.d);
    L6:
        if ((!r1.isEmpty()) == false) goto L17;
        File[] r10 = ((File) r1.removeLast()).listFiles();
        if (r10 == null) goto L6;
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L6;
        File r13 = r10[r12];
        if (r13.isDirectory() == false) goto L15;
        Intrinsics.checkNotNull(r13);
        r1.addLast(r13);
    L16:
        r12 = r12 + 1;
        goto L11
    L15:
        Intrinsics.checkNotNull(r13);
        r0.add(new c(e(r13).a(), r13.length(), r13.lastModified()));
        goto L16
    L17:
        return r0;
    }

    public static PolarisFileWrapper d(File r10) {
        return new PolarisFileWrapper(r10.getParentFile(), ".download-staging/" + r10.getName());
    }

    public static long h(File r10) {
        long r1 = 0;
        if (r10.exists() == false) goto L18;
        ArrayDeque r0 = new ArrayDeque();
        r0.addLast(r10);
    L7:
        if ((!r0.isEmpty()) == false) goto L18;
        File[] r11 = ((File) r0.removeLast()).listFiles();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L7;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L16;
        Intrinsics.checkNotNull(r14);
        r0.addLast(r14);
    L17:
        r13 = r13 + 1;
        goto L12
    L16:
        r1 = r1 + r14.length();
    L18:
        return r1;
    }

    public final com.bytedance.ai.file.a e(File r20) {
        Intrinsics.checkNotNullParameter(r20, "file");
        d r10 = this.g;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r20, "file");
        File r0 = r20.getCanonicalFile();
        File r1 = r10.a.getCanonicalFile();
        File r11 = r10.b.getCanonicalFile();
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r1);
        if (d.d(r0, r1) == false) goto L5;
        Pair r12 = TuplesKt.to(AIStateLogRequest.SOURCE_USER, d.b(r0, r1));
    L8:
        String r13 = (String) r12.component1();
        String r14 = (String) r12.component2();
        boolean r15 = true;
        List r16 = StringsKt.split$default(r14, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L10:
        if (r18.hasNext() == false) goto L17;
        Object r19 = r18.next();
        if (((String) r19).length() <= 0) goto L14;
        boolean r21 = true;
    L15:
        if (r21 == false) goto L10;
        r17.add(r19);
        goto L10
    L14:
        r21 = false;
        goto L15
    L17:
        String r22 = CollectionsKt.joinToString$default(r17, "/", null, null, 0, null, new com.bytedance.ai.file.c(), 30, null);
        if (r22.length() == 0) goto L22;
        r15 = false;
    L22:
        if (r15 == false) goto L24;
        String r23 = "appletfile://" + r13;
    L25:
        int r24 = com.bytedance.ai.file.a.b;
        return com.bytedance.ai.file.a.C0040a.a(r23);
    L24:
        r23 = "appletfile://" + r13 + '/' + r22;
        goto L25
    L5:
        Intrinsics.checkNotNull(r11);
        if (d.d(r0, r11) == false) goto L28;
        r12 = TuplesKt.to("temp", d.b(r0, r11));
        goto L8
    L28:
        throw AppletFileError.InvalidUri.INSTANCE;
    }

    public final byte[] i(com.bytedance.ai.file.a r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        File r11 = this.g.a(r10);
        if (r11.exists() == false) goto L22;
        if (r11.isDirectory() == true) goto L20;
        if (r11.length() > 10485760) goto L18;
        return FilesKt.readBytes(r11);
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        throw e;
    L10:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L18:
        throw AppletFileError.QuotaExceeded.INSTANCE;
    L20:
        throw AppletFileError.IsDir.INSTANCE;
    L22:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final Pair<File, Long> l(com.bytedance.ai.file.a r10) {
        if (r10.c() == false) goto L6;
        return TuplesKt.to(this.d, 52428800L);
    L6:
        if (r10.b() == false) goto L10;
        return TuplesKt.to(this.e, 104857600L);
    L10:
        throw AppletFileError.InvalidUri.INSTANCE;
    }

    public final b m(com.bytedance.ai.file.a r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        File r11 = this.g.a(r10);
        if (r11.exists() == false) goto L7;
        return new b(r11.length(), r11.lastModified(), r11.isDirectory());
    L7:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final File n(com.bytedance.ai.file.a r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        return this.g.a(r10);
    }

    public final void a(com.bytedance.ai.file.a r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r11.length > 10485760) goto L47;
        if (r10.c() == false) goto L8;
        Object r0 = this.h;
    L10:
        monitor-enter(r0);
        File r1 = this.g.a(r10);     // Catch: Throwable -> L41
        if (r1.isDirectory() == true) goto L40;
        Pair<File, Long> r12 = l(r10);     // Catch: Throwable -> L41
        File r13 = (File) r12.component1();     // Catch: Throwable -> L41
        long r14 = ((Number) r12.component2()).longValue();     // Catch: Throwable -> L41
        File r15 = r1.getParentFile();     // Catch: Throwable -> L41
        if (r15 == null) goto L26;
        if (r15.exists() == true) goto L26;
        if (r15.mkdirs() == true) goto L26;
        if (r15.exists() == true) goto L26;
        throw new AppletFileError.IoError(null);     // Catch: Throwable -> L41
    L26:
        if ((h(r13) + ((long) r11.length)) > r14) goto L38;
        FilesKt.appendBytes(r1, r11);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        monitor-exit(r0);
        return;
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L33:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L30:
        th = move-exception;
        throw new AppletFileError.IoError(th);     // Catch: Throwable -> L41
    L38:
        throw AppletFileError.QuotaExceeded.INSTANCE;     // Catch: Throwable -> L41
    L40:
        throw AppletFileError.IsDir.INSTANCE;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L8:
        if (r10.b() == false) goto L45;
        r0 = this.i;
        goto L10
    L45:
        throw AppletFileError.InvalidUri.INSTANCE;
    L47:
        throw AppletFileError.QuotaExceeded.INSTANCE;
    }

    public final void c(com.bytedance.ai.file.a r10, com.bytedance.ai.file.a r11) {
        Intrinsics.checkNotNullParameter(r10, "src");
        Intrinsics.checkNotNullParameter(r11, "dest");
        if (r11.c() == false) goto L6;
        Object r0 = this.h;
    L8:
        monitor-enter(r0);
        File r12 = this.g.a(r10);     // Catch: Throwable -> L48
        File r13 = this.g.a(r11);     // Catch: Throwable -> L48
        if (r12.exists() == false) goto L47;
        if (r12.isDirectory() == true) goto L45;
        Pair<File, Long> r14 = l(r11);     // Catch: Throwable -> L48
        File r15 = (File) r14.component1();     // Catch: Throwable -> L48
        long r16 = ((Number) r14.component2()).longValue();     // Catch: Throwable -> L48
        File r17 = r13.getParentFile();     // Catch: Throwable -> L48
        if (r17 == null) goto L25;
        if (r17.exists() == true) goto L25;
        if (r17.mkdirs() == true) goto L25;
        if (r17.exists() == true) goto L25;
        throw new AppletFileError.IoError(null);     // Catch: Throwable -> L48
    L25:
        if (r13.exists() == false) goto L27;
        long r18 = r13.length();     // Catch: Throwable -> L48
    L30:
        if (((h(r15) - r18) + r12.length()) > r16) goto L43;
        FilesKt.copyTo$default(r12, r13, true, 0, 4, null);     // Catch: Throwable -> L35 CancellationException -> L38 AppletFileError -> L40
        monitor-exit(r0);
        return;
    L40:
        e = move-exception;
        throw e;     // Catch: Throwable -> L48
    L38:
        e = move-exception;
        throw e;     // Catch: Throwable -> L48
    L35:
        th = move-exception;
        throw new AppletFileError.IoError(th);     // Catch: Throwable -> L48
    L43:
        throw AppletFileError.QuotaExceeded.INSTANCE;     // Catch: Throwable -> L48
    L27:
        r18 = 0;
        goto L30
    L45:
        throw AppletFileError.IsDir.INSTANCE;     // Catch: Throwable -> L48
    L47:
        throw AppletFileError.NotExist.INSTANCE;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L6:
        if (r11.b() == false) goto L52;
        r0 = this.i;
        goto L8
    L52:
        throw AppletFileError.InvalidUri.INSTANCE;
    }

    public final String f(com.bytedance.ai.file.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "algorithm");
        File r12 = this.g.a(r10);
        if (r12.exists() == false) goto L42;
        if (r12.isDirectory() == true) goto L40;
        String r0 = r11.toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r0, "md5") == false) goto L10;
        String r13 = "MD5";
    L47:
        MessageDigest r14 = MessageDigest.getInstance(r13);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L25
    L15:
        int r16 = r1.read(r15);     // Catch: Throwable -> L25
        int r17 = 0;
        if (r16 == (-1)) goto L18;
        r14.update(r15, 0, r16);     // Catch: Throwable -> L25
        goto L15
    L18:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L20:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        byte[] r19 = r14.digest();     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        StringBuilder r20 = new StringBuilder(r19.length * 2);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        int r21 = r19.length;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
    L21:
        if (r17 >= r21) goto L24;
        int r22 = r19[r17] & 255;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        char[] r23 = j;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        r20.append(r23[r22 >>> 4]);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        r20.append(r23[r22 & 15]);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        r17 = r17 + 1;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        goto L21
    L24:
        return r20.toString();
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
        throw th;     // Catch: Throwable -> L30 CancellationException -> L33 AppletFileError -> L35
    L35:
        e = move-exception;
        throw e;
    L33:
        e = move-exception;
        throw e;
    L30:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L10:
        if (Intrinsics.areEqual(r0, "sha1") == false) goto L38;
        r13 = "SHA-1";
        goto L47
    L38:
        throw new AppletFileError.IoError(new IllegalArgumentException("unsupported algorithm: ".concat(r11)));
    L40:
        throw AppletFileError.IsDir.INSTANCE;
    L42:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final void j(com.bytedance.ai.file.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        File r12 = this.g.a(r10);
        if (r12.exists() == false) goto L31;
        if (r12.isDirectory() == false) goto L26;
        if (r11 == true) goto L21;
        String[] r13 = r12.list();
        boolean r0 = true;
        if (r13 != null) goto L10;
    L16:
        if (r0 == true) goto L21;
        throw AppletFileError.IsDir.INSTANCE;
    L10:
        if (r13.length != 0) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == true) goto L16;
        r0 = false;
        goto L16
    L12:
        r14 = false;
    L21:
        if (FilesKt.deleteRecursively(r12) == false) goto L24;
        return;
    L24:
        throw new AppletFileError.IoError(null);
    L26:
        if (r12.delete() == false) goto L29;
        return;
    L29:
        throw new AppletFileError.IoError(null);
    L31:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final void k(com.bytedance.ai.file.a r10, com.bytedance.ai.file.a r11) {
        Intrinsics.checkNotNullParameter(r10, "src");
        Intrinsics.checkNotNullParameter(r11, "dest");
        File r12 = this.g.a(r10);
        File r13 = this.g.a(r11);
        if (r12.exists() == false) goto L29;
        File r0 = r13.getParentFile();
        if (r0 != null) goto L7;
    L30:
    L26:
        e = move-exception;
        throw e;
    L24:
        e = move-exception;
        throw e;
    L21:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L16:
        if (r12.renameTo(r13) == false) goto L20;
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L21 CancellationException -> L24 AppletFileError -> L26
        return;
    L20:
        throw new AppletFileError.IoError(null);     // Catch: Throwable -> L21 CancellationException -> L24 AppletFileError -> L26
    L7:
        if (r0.exists() == true) goto L30;
        if (r0.mkdirs() == true) goto L30;
        if (r0.exists() == true) goto L30;
        throw new AppletFileError.IoError(null);
    L29:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final void o(com.bytedance.ai.file.a r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        File r12 = this.g.a(r10);
        if (r12.exists() == false) goto L26;
        if (r12.isDirectory() == true) goto L24;
        RandomAccessFile r0 = new RandomAccessFile(r12, "rw");     // Catch: Throwable -> L16 CancellationException -> L19 AppletFileError -> L21
        r0.setLength(r11);     // Catch: Throwable -> L11
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L16 CancellationException -> L19 AppletFileError -> L21
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L16 CancellationException -> L19 AppletFileError -> L21
        throw th;     // Catch: Throwable -> L16 CancellationException -> L19 AppletFileError -> L21
    L21:
        e = move-exception;
        throw e;
    L19:
        e = move-exception;
        throw e;
    L16:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L24:
        throw AppletFileError.IsDir.INSTANCE;
    L26:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final void p(com.bytedance.ai.file.a r10, com.bytedance.ai.file.a r11) {
        Intrinsics.checkNotNullParameter(r10, "zipFile");
        Intrinsics.checkNotNullParameter(r11, "targetDir");
        File r12 = this.g.a(r10);
        File r13 = this.g.a(r11);
        if (r12.exists() == false) goto L61;
        if (r12.isDirectory() == true) goto L59;
        if (r13.exists() == true) goto L14;
        if (r13.mkdirs() == true) goto L14;
        throw new AppletFileError.IoError(null);
    L14:
        if (r13.isDirectory() == false) goto L57;
        ZipInputStream r0 = new ZipInputStream(new PolarisFileInputStreamWrapper(r12));     // Catch: Throwable -> L49 CancellationException -> L52 AppletFileError -> L54
        ZipEntry r14 = r0.getNextEntry();     // Catch: Throwable -> L44
    L17:
        if (r14 == null) goto L41;
        PolarisFileWrapper r15 = new PolarisFileWrapper(r13, r14.getName());     // Catch: Throwable -> L44
        if (StringsKt.startsWith$default(r15.getCanonicalPath(), r13.getCanonicalPath() + File.separator, false, 2, null) == true) goto L26;
        if (Intrinsics.areEqual(r15.getCanonicalPath(), r13.getCanonicalPath()) == true) goto L26;
        throw AppletFileError.PathEscape.INSTANCE;     // Catch: Throwable -> L44
    L26:
        if (r14.isDirectory() == false) goto L28;
        r15.mkdirs();     // Catch: Throwable -> L44
    L34:
        r0.closeEntry();     // Catch: Throwable -> L44
        r14 = r0.getNextEntry();     // Catch: Throwable -> L44
        goto L17
    L28:
        File r16 = r15.getParentFile();     // Catch: Throwable -> L44
        if (r16 == null) goto L31;
        r16.mkdirs();     // Catch: Throwable -> L44
    L31:
        PolarisFileOutputStreamWrapper r17 = new PolarisFileOutputStreamWrapper(r15);     // Catch: Throwable -> L44
        ByteStreamsKt.copyTo$default(r0, r17, 0, 2, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L44
        goto L34
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L41:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L44
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L49 CancellationException -> L52 AppletFileError -> L54
        return;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L49 CancellationException -> L52 AppletFileError -> L54
        throw th;     // Catch: Throwable -> L49 CancellationException -> L52 AppletFileError -> L54
    L54:
        e = move-exception;
        throw e;
    L52:
        e = move-exception;
        throw e;
    L49:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L57:
        throw AppletFileError.NotDir.INSTANCE;
    L59:
        throw AppletFileError.IsDir.INSTANCE;
    L61:
        throw AppletFileError.NotExist.INSTANCE;
    }

    public final void q(com.bytedance.ai.file.a r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r11.length > 10485760) goto L51;
        if (r10.c() == false) goto L8;
        Object r0 = this.h;
    L10:
        monitor-enter(r0);
        File r1 = this.g.a(r10);     // Catch: Throwable -> L45
        if (r1.isDirectory() == true) goto L44;
        Pair<File, Long> r12 = l(r10);     // Catch: Throwable -> L45
        File r13 = (File) r12.component1();     // Catch: Throwable -> L45
        long r14 = ((Number) r12.component2()).longValue();     // Catch: Throwable -> L45
        File r15 = r1.getParentFile();     // Catch: Throwable -> L45
        if (r15 == null) goto L25;
        if (r15.exists() == true) goto L25;
        if (r15.mkdirs() == true) goto L25;
        if (r15.exists() == true) goto L25;
        throw new AppletFileError.IoError(null);     // Catch: Throwable -> L45
    L25:
        if (r1.exists() == false) goto L27;
        long r16 = r1.length();     // Catch: Throwable -> L45
    L30:
        if (((h(r13) - r16) + ((long) r11.length)) > r14) goto L42;
        FilesKt.writeBytes(r1, r11);     // Catch: Throwable -> L34 CancellationException -> L37 AppletFileError -> L39
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L34 CancellationException -> L37 AppletFileError -> L39
        monitor-exit(r0);
        return;
    L39:
        e = move-exception;
        throw e;     // Catch: Throwable -> L45
    L37:
        e = move-exception;
        throw e;     // Catch: Throwable -> L45
    L34:
        th = move-exception;
        throw new AppletFileError.IoError(th);     // Catch: Throwable -> L45
    L42:
        throw AppletFileError.QuotaExceeded.INSTANCE;     // Catch: Throwable -> L45
    L27:
        r16 = 0;
        goto L30
    L44:
        throw AppletFileError.IsDir.INSTANCE;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    L8:
        if (r10.b() == false) goto L49;
        r0 = this.i;
        goto L10
    L49:
        throw AppletFileError.InvalidUri.INSTANCE;
    L51:
        throw AppletFileError.QuotaExceeded.INSTANCE;
    }

    public AppletFileManager(Context r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "appContext");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "userIdSnapshot");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        Intrinsics.checkNotNullParameter(r12, "userId");
        boolean r13 = true;
        if (r12.length() != 0) goto L5;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L9;
        String r15 = "anon";
    L13:
        PolarisFileWrapper r16 = new PolarisFileWrapper(this.a.getFilesDir(), "aisdk/appletfile/" + this.b + '/' + r15 + "/user");
        this.d = r16;
        PolarisFileWrapper r17 = new PolarisFileWrapper(this.a.getCacheDir(), "aisdk/appletfile/" + this.b + '/' + r15 + "/temp");
        this.e = r17;
        this.f = LazyKt.lazy(new com.bytedance.ai.file.b(this));
        this.g = new d(r16, r17);
        this.h = new Object();
        this.i = new Object();
        if (r16.exists() == true) goto L17;
        r16.mkdirs();
    L17:
        if (r17.exists() == true) goto L19;
        r17.mkdirs();
    L19:
        Iterator r18 = CollectionsKt.listOf(new File[]{d(r16), d(r17)}).iterator();
    L21:
        if (r18.hasNext() == false) goto L25;
        File r19 = (File) r18.next();
        FilesKt.deleteRecursively(r19);
        if (r19.exists() == true) goto L21;
        r19.mkdirs();
        goto L21
    L25:
        File r20 = (File) this.f.getValue();
        if (r20.exists() == false) goto L45;
        File[] r21 = r20.listFiles();
        if (r21 != null) goto L32;
        return;
    L32:
        if (r21.length == 0) goto L35;
        r13 = false;
    L35:
        if (r13 == true) goto L47;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AppletFileManager$cleanupTrashIfNeeded$1(r21, null), 3, null);
        return;
    L47:
        return;
    L45:
        return;
    L9:
        byte[] r22 = MessageDigest.getInstance("SHA-256").digest(r12.getBytes(Charsets.UTF_8));
        StringBuilder r110 = new StringBuilder(r22.length * 2);
        int r23 = r22.length;
        int r24 = 0;
    L10:
        if (r24 >= r23) goto L12;
        int r25 = r22[r24] & 255;
        char[] r26 = j;
        r110.append(r26[r25 >>> 4]);
        r110.append(r26[r25 & 15]);
        r24 = r24 + 1;
        goto L10
    L12:
        r15 = r110.substring(0, 16);
        goto L13
    L5:
        r14 = false;
        goto L7
    }

    public final void r(com.bytedance.ai.file.a r21, InputStream r22, long r23, com.bytedance.ai.bridge.method.net.download.d r25, com.bytedance.ai.bridge.method.net.download.e r26, f r27) {
        Intrinsics.checkNotNullParameter(r21, "file");
        Intrinsics.checkNotNullParameter(r22, "input");
        Intrinsics.checkNotNullParameter(r25, "isCancelled");
        Intrinsics.checkNotNullParameter(r26, "acquireCommit");
        Intrinsics.checkNotNullParameter(r27, "onProgress");
        File r10 = this.g.a(r21);
        Pair<File, Long> r11 = l(r21);
        File r12 = (File) r11.component1();
        long r13 = ((Number) r11.component2()).longValue();
        if (r23 > 209715200) goto L109;
        PolarisFileWrapper r14 = d(r12);
        PolarisFileWrapper r15 = new PolarisFileWrapper(r14, UUID.randomUUID() + ".tmp");
    L98:
        e = move-exception;
        r15.delete();
        throw e;
    L100:
        e = move-exception;
        r15.delete();
        throw e;
    L96:
        th = move-exception;
        r15.delete();
        throw new AppletFileError.IoError(th);
    L6:
        if (r14.exists() == true) goto L110;
        r14.mkdirs();     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L110:
        PolarisFileOutputStreamWrapper r16 = new PolarisFileOutputStreamWrapper(r15);     // Catch: Throwable -> L82
        byte[] r17 = new byte[65536];     // Catch: Throwable -> L75
        long r18 = 0;
    L12:
        if (((Boolean) r25.invoke()).booleanValue() == true) goto L74;
        int r19 = r22.read(r17);     // Catch: Throwable -> L75
        if (r19 < 0) goto L20;
        r18 = r18 + ((long) r19);     // Catch: Throwable -> L75
        if (r18 > 209715200) goto L19;
        r16.write(r17, 0, r19);     // Catch: Throwable -> L75
        r27.invoke(Long.valueOf(r18));     // Catch: Throwable -> L75
        goto L12
    L19:
        throw AppletFileError.QuotaExceeded.INSTANCE;     // Catch: Throwable -> L75
    L20:
        r16.flush();     // Catch: Throwable -> L75
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L75
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L82
        CloseableKt.closeFinally(r22, null);     // Catch: Throwable -> L89 CancellationException -> L92 AppletFileError -> L94
        if (r21.c() == false) goto L29;
        Object r0 = this.h;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L27:
        Object r24 = r0;
        monitor-enter(r24);     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L33:
        if (r10.exists() == true) goto L35;
    L39:
        File r1 = r10.getParentFile();     // Catch: Throwable -> L68
        if (r1 == null) goto L51;
        if (r1.exists() == true) goto L51;
        if (r1.mkdirs() == true) goto L51;
        if (r1.exists() == true) goto L51;
        throw new AppletFileError.IoError(null);     // Catch: Throwable -> L68
    L51:
        if (r10.exists() == false) goto L53;
        long r110 = r10.length();     // Catch: Throwable -> L68
    L55:
        if (((h(r12) - r110) + r15.length()) > r13) goto L67;
        if (((Boolean) r26.invoke()).booleanValue() == false) goto L65;
        Os.rename(r15.getAbsolutePath(), r10.getAbsolutePath());     // Catch: ErrnoException -> L61 Throwable -> L68
        monitor-exit(r24);     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
        return;
    L61:
        e = move-exception;
        throw new AppletFileError.IoError(e);     // Catch: Throwable -> L68
    L65:
        throw new CancellationException("download canceled");     // Catch: Throwable -> L68
    L67:
        throw AppletFileError.QuotaExceeded.INSTANCE;     // Catch: Throwable -> L68
    L53:
        r110 = 0;
        goto L55
    L35:
        if (r10.isDirectory() == false) goto L39;
        throw AppletFileError.IsDir.INSTANCE;     // Catch: Throwable -> L68
    L29:
        if (r21.b() == false) goto L72;
        r0 = this.i;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
        goto L27
    L72:
        throw AppletFileError.InvalidUri.INSTANCE;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L74:
        throw new CancellationException("download canceled");     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L82
        throw th;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        throw th;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        CloseableKt.closeFinally(r22, th);     // Catch: Throwable -> L89 CancellationException -> L92 AppletFileError -> L94
        throw th;     // Catch: Throwable -> L89 CancellationException -> L92 AppletFileError -> L94
    L94:
        e = move-exception;
        throw e;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L92:
        e = move-exception;
        throw e;     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L89:
        th = move-exception;
        throw new AppletFileError.IoError(th);     // Catch: Throwable -> L96 AppletFileError -> L98 CancellationException -> L100
    L109:
        throw AppletFileError.QuotaExceeded.INSTANCE;
    }
}
