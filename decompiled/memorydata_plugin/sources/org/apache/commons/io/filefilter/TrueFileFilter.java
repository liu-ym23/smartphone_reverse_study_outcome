package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes6.dex */
public class TrueFileFilter implements Serializable, IOFileFilter {
    public static final IOFileFilter INSTANCE = null;
    private static final String TO_STRING = null;
    public static final IOFileFilter TRUE = null;
    private static final long serialVersionUID = 8782512160909720199L;

    static {
        TO_STRING = Boolean.TRUE.toString();
        TrueFileFilter r0 = new TrueFileFilter();
        TRUE = r0;
        INSTANCE = r0;
    }

    public TrueFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r2, BasicFileAttributes r3) {
        Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r4 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r3, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return FileVisitResult.CONTINUE;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return true;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return true;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter
    public IOFileFilter and(IOFileFilter r2) {
        return (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r2, IOFileFilter.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter
    public IOFileFilter negate() {
        return FalseFileFilter.INSTANCE;
    }

    public IOFileFilter or(IOFileFilter r2) {
        IOFileFilter r1 = (IOFileFilter) ZeusTransformUtils.wrapperContextForParams(r2, IOFileFilter.class, "com.obric.memorydata.plugin");
        return INSTANCE;
    }

    public String toString() {
        return TO_STRING;
    }
}
