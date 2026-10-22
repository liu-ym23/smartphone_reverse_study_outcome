package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long r2) {
        this(r2, true);
    }

    public SizeFileFilter(long r3, boolean r5) {
        if (r3 < 0) goto L7;
        this.size = r3;
        this.acceptLarger = r5;
        return;
    L7:
        throw new IllegalArgumentException("The size must be non-negative");
    }

    private boolean accept(long r4) {
        boolean r0 = this.acceptLarger;
        if (r4 >= this.size) goto L5;
        boolean r3 = true;
    L6:
        if (r0 == r3) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(accept(Files.size(r5)), r5);
    L5:
        e = move-exception;
        return handle(e);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r3) {
        return accept(r3.length());
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        if (this.acceptLarger == false) goto L5;
        String r0 = ">=";
    L7:
        return super.toString() + "(" + r0 + this.size + ")";
    L5:
        r0 = "<";
        goto L7
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return visitFile((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public FileVisitResult visitFile(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(accept(Files.size(r5)), r5);
    }
}
