package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class CanReadFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter CANNOT_READ = null;
    public static final IOFileFilter CAN_READ = null;
    public static final IOFileFilter READ_ONLY = null;
    private static final long serialVersionUID = 3179904805251622989L;

    static {
        CanReadFileFilter r0 = new CanReadFileFilter();
        CAN_READ = r0;
        CANNOT_READ = r0.negate();
        READ_ONLY = r0.and(CanWriteFileFilter.CANNOT_WRITE);
    }

    public CanReadFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r2, BasicFileAttributes r3) {
        Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r4 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r3, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(Files.isReadable(r1), r1);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.canRead();
    }
}
