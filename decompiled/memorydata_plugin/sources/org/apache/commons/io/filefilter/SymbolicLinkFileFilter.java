package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class SymbolicLinkFileFilter extends AbstractFileFilter implements Serializable {
    public static final SymbolicLinkFileFilter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new SymbolicLinkFileFilter();
    }

    public SymbolicLinkFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r2, BasicFileAttributes r3) {
        Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r4 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r3, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(Files.isSymbolicLink(r1), r1);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.isFile();
    }
}
