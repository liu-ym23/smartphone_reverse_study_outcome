package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter EMPTY = null;
    public static final IOFileFilter NOT_EMPTY = null;
    private static final long serialVersionUID = 3631422087512832211L;

    static {
        EmptyFileFilter r0 = new EmptyFileFilter();
        EMPTY = r0;
        NOT_EMPTY = r0.negate();
    }

    public EmptyFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r7, BasicFileAttributes r8) {
        Path r9 = (Path) ZeusTransformUtils.wrapperContextForParams(r7, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r10 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r8, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        boolean r11 = false;
    L27:
        e = move-exception;
        return handle(e);
    L4:
        if (Files.isDirectory(r9, new LinkOption[0]) == false) goto L23;
        Stream<Path> r0 = Files.list(r9);     // Catch: IOException -> L27
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r0 != null) goto L35;
    L21:
        throw th;     // Catch: IOException -> L27
    L35:
        r0.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
        goto L21
    L7:
        if (r0.findFirst().isPresent() == true) goto L9;
        r11 = true;
    L9:
        FileVisitResult r12 = toFileVisitResult(r11, r9);     // Catch: Throwable -> L13
        if (r0 == null) goto L12;
        r0.close();     // Catch: IOException -> L27
    L12:
        return r12;
    L23:
        if (Files.size(r9) != 0) goto L26;
        r11 = true;
    L26:
        return toFileVisitResult(r11, r9);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (r5.isDirectory() == false) goto L10;
        if (IOUtils.length(r5.listFiles()) != 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r5.length() != 0) goto L13;
        return true;
    L13:
        return false;
    }
}
