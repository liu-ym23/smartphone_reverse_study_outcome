package com.obric.pap.base.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001d\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0014J4\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/pap/base/util/AssetsUtils;", "", "()V", "checkNeedUpdate", "", "versionFile", "Ljava/io/File;", "dirFile", "checkHash", "", "deleteDirectory", "dir", "ensureNoSymlink", "", "rootPath", "Ljava/nio/file/Path;", "targetPath", "resolveArchiveEntryPath", "dst", "entryName", "resolveArchiveEntryPath$PythonBase_release", "unpack", "ctx", "Landroid/content/Context;", "arch", "filter", "Lkotlin/Function1;", "PythonBase_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14918a = null;

    static {
        f14918a = new a();
    }

    private a() {
    }

    private final void a(Path r4, Path r5) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        if (r6.startsWith(r3) == false) goto L16;
        Iterator<Path> r7 = r3.relativize(r6).iterator();
    L6:
        if (r7.hasNext() == false) goto L14;
        r3 = r3.resolve(((Path) ZeusTransformUtils.preCheckCast(r7.next(), Path.class, "com.obric.memorydata.plugin")).toString());
        Intrinsics.checkNotNullExpressionValue(r3, "currentPath.resolve(segment.toString())");
        if (Files.exists(r3, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L6;
        if (Files.isSymbolicLink(r3) == false) goto L6;
        throw new IOException("Target path contains symlink: " + r3);
    L14:
        return;
    L16:
        throw new IOException("Target path escapes root: " + r6);
    }

    public final Path a(File r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "dst");
        Intrinsics.checkNotNullParameter(r9, "entryName");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r9, '\\', '/', false, 4, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L35;
        if (StringsKt.startsWith$default(r0, "/", false, 2, null) == true) goto L33;
        if (r0.length() >= 2) goto L12;
    L16:
        Path r10 = r8.toPath().toAbsolutePath().normalize();
        Path r2 = r10.resolve(r0).normalize();
        if (r2.startsWith(r10) == false) goto L31;
        Intrinsics.checkNotNullExpressionValue(r10, "rootPath");
        Path r3 = r2.getParent();
        if (r3 != null) goto L21;
        r3 = r10;
    L21:
        a(r10, r3);
        if (Files.exists(r2, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == true) goto L24;
    L28:
        Intrinsics.checkNotNullExpressionValue(r2, "targetPath");
        return r2;
    L24:
        if (Files.isSymbolicLink(r2) == false) goto L28;
        throw new IOException("Archive entry resolves to symlink: " + r9);
    L31:
        throw new IOException("Archive entry escapes target dir: " + r9);
    L12:
        if (r0.charAt(1) != ':') goto L16;
        throw new IOException("Archive entry uses drive path: " + r9);
    L33:
        throw new IOException("Archive entry uses absolute path: " + r9);
    L35:
        throw new IOException("Archive entry name is empty");
    L5:
        r1 = false;
        goto L6
    }

    public final void a(Context r7, String r8, File r9, Function1<? super String, String> r10) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "ctx");
        Intrinsics.checkNotNullParameter(r8, "arch");
        Intrinsics.checkNotNullParameter(r9, "dst");
        Intrinsics.checkNotNullParameter(r11, "filter");
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipInputStream(r6.getAssets().open(r8)), Closeable.class, "com.obric.memorydata.plugin");
        ZipInputStream r13 = (ZipInputStream) ZeusTransformUtils.preCheckCast(r12, ZipInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L4:
        ZipEntry r14 = r13.getNextEntry();     // Catch: Throwable -> L27
        if (r14 == null) goto L24;
        String r2 = r14.getName();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r2, "entry.name");     // Catch: Throwable -> L27
        String r3 = (String) ZeusTransformUtils.preCheckCast(r11.invoke(r2), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r3 == null) goto L23;
        Path r4 = f14918a.a(r9, r3);     // Catch: Throwable -> L27
        if (r14.isDirectory() == false) goto L11;
        Files.createDirectories(r4, new FileAttribute[0]);     // Catch: Throwable -> L27
        goto L23
    L11:
        Path r15 = r4.getParent();     // Catch: Throwable -> L27
        if (r15 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r15, "parent");     // Catch: Throwable -> L27
        Files.createDirectories(r15, new FileAttribute[0]);     // Catch: Throwable -> L27
    L14:
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4.toFile()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        FileOutputStream r5 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r16, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r13, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r5, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L27
        goto L23
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L23:
        r13.closeEntry();     // Catch: Throwable -> L27
        goto L4
    L24:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r12, null);
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public final boolean a(File r6) {
        Intrinsics.checkNotNullParameter(r6, "dir");
        if (r6.exists() == false) goto L14;
        File[] r5 = r6.listFiles();
        if (r5 == null) goto L14;
        int r0 = 0;
        int r1 = r5.length;
    L7:
        if (r0 >= r1) goto L14;
        File r2 = r5[r0];
        if (r2.isDirectory() == false) goto L11;
        a r3 = f14918a;
        Intrinsics.checkNotNullExpressionValue(r2, "file");
        r3.a(r2);
    L12:
        r0 = r0 + 1;
        goto L7
    L11:
        r2.delete();
    L14:
        return r6.delete();
    }

    public final boolean a(File r3, File r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "versionFile");
        Intrinsics.checkNotNullParameter(r5, "checkHash");
        Path r0 = null;
        String r1 = FilesKt.readText$default(r3, null, 1, null);     // Catch: Throwable -> L5
    L7:
        if (Intrinsics.areEqual(r1, r5) == true) goto L9;
        return true;
    L9:
        if (r4 == null) goto L12;
        r0 = r4.toPath();
    L12:
        if (r0 != null) goto L14;
        return false;
    L14:
        FileTime r6 = Files.getLastModifiedTime(r0, new LinkOption[0]);
        if (Files.getLastModifiedTime(r3.toPath(), new LinkOption[0]).compareTo(r6) >= 0) goto L18;
        return true;
    L18:
        return false;
    L5:
        r1 = "";
        goto L7
    }
}
