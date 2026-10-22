package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.io.file.PathFilter;

/* JADX INFO: loaded from: classes6.dex */
public interface IOFileFilter extends FileFilter, FilenameFilter, PathFilter {
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    default FileVisitResult accept(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return AbstractFileFilter.toFileVisitResult(accept(r5.toFile()), r5);
    }

    @Override // java.io.FileFilter
    boolean accept(File r1);

    boolean accept(File r1, String r2);

    default IOFileFilter and(IOFileFilter r3) {
        return new AndFileFilter(this, (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r3, IOFileFilter.class, "com.obric.memorydata.plugin"));
    }

    default IOFileFilter negate() {
        return new NotFileFilter(this);
    }
}
