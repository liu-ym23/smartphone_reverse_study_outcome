package ja;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9791a = null;

    static {
        f9791a = new a();
    }

    private a() {
    }

    private final void c(Path r10, Path r11) {
        if (r11.startsWith(r10) == false) goto L16;
        Iterator<Path> r12 = r10.relativize(r11).iterator();
    L6:
        if (r12.hasNext() == false) goto L14;
        r10 = r10.resolve(r12.next().toString());
        Intrinsics.checkNotNullExpressionValue(r10, "currentPath.resolve(segment.toString())");
        if (Files.exists(r10, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L6;
        if (Files.isSymbolicLink(r10) == false) goto L6;
        throw new IOException("Target path contains symlink: " + r10);
    L14:
        return;
    L16:
        throw new IOException("Target path escapes root: " + r11);
    }

    public final boolean a(File r10, File r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "versionFile");
        Intrinsics.checkNotNullParameter(r12, "checkHash");
        Path r13 = null;
        String r14 = FilesKt.readText$default(r10, null, 1, null);     // Catch: Throwable -> L5
    L7:
        if (Intrinsics.areEqual(r14, r12) == true) goto L9;
        return true;
    L9:
        if (r11 == null) goto L12;
        r13 = r11.toPath();
    L12:
        if (r13 != null) goto L14;
        return false;
    L14:
        FileTime r15 = Files.getLastModifiedTime(r13, new LinkOption[0]);
        if (Files.getLastModifiedTime(r10.toPath(), new LinkOption[0]).compareTo(r15) >= 0) goto L18;
        return true;
    L18:
        return false;
    L5:
        r14 = "";
        goto L7
    }

    public final boolean b(File r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        if (r10.exists() == false) goto L14;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L14;
        int r12 = 0;
        int r13 = r11.length;
    L7:
        if (r12 >= r13) goto L14;
        File r14 = r11[r12];
        if (r14.isDirectory() == false) goto L11;
        a r15 = f9791a;
        Intrinsics.checkNotNullExpressionValue(r14, "file");
        r15.b(r14);
    L12:
        r12 = r12 + 1;
        goto L7
    L11:
        r14.delete();
    L14:
        return r10.delete();
    }

    public final Path d(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dst");
        Intrinsics.checkNotNullParameter(r11, "entryName");
        String r12 = StringsKt.trim(StringsKt.replace$default(r11, '\\', '/', false, 4, null)).toString();
        if (r12.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L35;
        if (StringsKt.startsWith$default(r12, "/", false, 2, null) == true) goto L33;
        if (r12.length() >= 2) goto L12;
    L16:
        Path r14 = r10.toPath().toAbsolutePath().normalize();
        Path r15 = r14.resolve(r12).normalize();
        if (r15.startsWith(r14) == false) goto L31;
        Intrinsics.checkNotNullExpressionValue(r14, "rootPath");
        Path r16 = r15.getParent();
        if (r16 != null) goto L21;
        r16 = r14;
    L21:
        c(r14, r16);
        if (Files.exists(r15, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == true) goto L24;
    L28:
        Intrinsics.checkNotNullExpressionValue(r15, "targetPath");
        return r15;
    L24:
        if (Files.isSymbolicLink(r15) == false) goto L28;
        throw new IOException("Archive entry resolves to symlink: " + r11);
    L31:
        throw new IOException("Archive entry escapes target dir: " + r11);
    L12:
        if (r12.charAt(1) != ':') goto L16;
        throw new IOException("Archive entry uses drive path: " + r11);
    L33:
        throw new IOException("Archive entry uses absolute path: " + r11);
    L35:
        throw new IOException("Archive entry name is empty");
    L5:
        r13 = false;
        goto L6
    }

    public final void e(Context r10, String r11, File r12, Function1<? super String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "arch");
        Intrinsics.checkNotNullParameter(r12, "dst");
        Intrinsics.checkNotNullParameter(r13, "filter");
        ZipInputStream r14 = new ZipInputStream(r10.getAssets().open(r11));
    L36:
        ZipEntry r15 = r14.getNextEntry();     // Catch: Throwable -> L27
        if (r15 == null) goto L24;
        String r16 = r15.getName();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r16, "entry.name");     // Catch: Throwable -> L27
        String r17 = r13.invoke(r16);     // Catch: Throwable -> L27
        if (r17 == null) goto L23;
        Path r18 = f9791a.d(r12, r17);     // Catch: Throwable -> L27
        if (r15.isDirectory() == false) goto L10;
        Files.createDirectories(r18, new FileAttribute[0]);     // Catch: Throwable -> L27
        goto L23
    L10:
        Path r19 = r18.getParent();     // Catch: Throwable -> L27
        if (r19 == null) goto L13;
        Intrinsics.checkNotNullExpressionValue(r19, "parent");     // Catch: Throwable -> L27
        Files.createDirectories(r19, new FileAttribute[0]);     // Catch: Throwable -> L27
    L13:
        FileOutputStream r20 = new FileOutputStream(r18.toFile());     // Catch: Throwable -> L27
        ByteStreamsKt.copyTo$default(r14, r20, 0, 2, null);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L27
        goto L23
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L23:
        r14.closeEntry();     // Catch: Throwable -> L27
        goto L36
    L24:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r14, null);
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }
}
