package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.file.PathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoffMillis;

    public AgeFileFilter(long r2) {
        this(r2, true);
    }

    public AgeFileFilter(long r1, boolean r3) {
        this.acceptOlder = r3;
        this.cutoffMillis = r1;
    }

    public AgeFileFilter(File r2) {
        this(r2, true);
    }

    public AgeFileFilter(File r3, boolean r4) {
        this(FileUtils.lastModifiedUnchecked(r3), r4);
    }

    public AgeFileFilter(Date r2) {
        this(r2, true);
    }

    public AgeFileFilter(Date r3, boolean r4) {
        this(r3.getTime(), r4);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        boolean r0 = PathUtils.isNewer(r6, this.cutoffMillis, new LinkOption[0]);     // Catch: IOException -> L9
        if (this.acceptOlder == r0) goto L8;
        r8 = true;
    L8:
        return toFileVisitResult(r8, r6);
    L9:
        e = move-exception;
        return handle(e);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r3) {
        boolean r4 = FileUtils.isFileNewer(r3, this.cutoffMillis);
        if (this.acceptOlder == r4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        if (this.acceptOlder == false) goto L5;
        String r0 = "<=";
    L7:
        return super.toString() + "(" + r0 + this.cutoffMillis + ")";
    L5:
        r0 = ">";
        goto L7
    }
}
