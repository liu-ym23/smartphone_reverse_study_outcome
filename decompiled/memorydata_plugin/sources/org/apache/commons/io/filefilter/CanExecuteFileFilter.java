package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class CanExecuteFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter CANNOT_EXECUTE = null;
    public static final IOFileFilter CAN_EXECUTE = null;
    private static final long serialVersionUID = 3179904805251622989L;

    static {
        CanExecuteFileFilter r0 = new CanExecuteFileFilter();
        CAN_EXECUTE = r0;
        CANNOT_EXECUTE = r0.negate();
    }

    public CanExecuteFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r2, BasicFileAttributes r3) {
        Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r4 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r3, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return toFileVisitResult(Files.isExecutable(r1), r1);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.canExecute();
    }
}
