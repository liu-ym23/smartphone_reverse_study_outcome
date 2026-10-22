package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class NotFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 6131563330944994230L;
    private final IOFileFilter filter;

    public NotFileFilter(IOFileFilter r3) {
        IOFileFilter r4 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.filter = r4;
        return;
    L7:
        throw new IllegalArgumentException("The filter must not be null");
    }

    private FileVisitResult not(FileVisitResult r1) {
        if (r1 != FileVisitResult.CONTINUE) goto L6;
        return FileVisitResult.TERMINATE;
    L6:
        return FileVisitResult.CONTINUE;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return not(this.filter.accept(r5, r6));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return !this.filter.accept(r1);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return !this.filter.accept(r1, r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return "NOT (" + this.filter.toString() + ")";
    }
}
