package org.apache.commons.io.filefilter;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import org.apache.commons.io.file.PathVisitor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFileFilter implements PathVisitor, IOFileFilter {
    public AbstractFileFilter() {
    }

    static FileVisitResult toFileVisitResult(boolean r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L6;
        return FileVisitResult.CONTINUE;
    L6:
        return FileVisitResult.TERMINATE;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r2) {
        Objects.requireNonNull(r2, "file");
        return accept(r2.getParentFile(), r2.getName());
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r2, String r3) {
        Objects.requireNonNull(r3, ActivityLifecycle.NAME);
        return accept(new File(r2, r3));
    }

    public FileVisitResult handle(Throwable r1) {
        return FileVisitResult.TERMINATE;
    }

    @Override // java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult postVisitDirectory(Object r3, IOException r4) {
        return postVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    public FileVisitResult postVisitDirectory(Path r1, IOException r2) {
        Path r0 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult preVisitDirectory(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return preVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult preVisitDirectory(Path r3, BasicFileAttributes r4) {
        return accept((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"), (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return visitFile((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult visitFile(Path r3, BasicFileAttributes r4) {
        return accept((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"), (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFileFailed(Object r3, IOException r4) {
        return visitFileFailed((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    public FileVisitResult visitFileFailed(Path r1, IOException r2) {
        Path r0 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        return FileVisitResult.CONTINUE;
    }
}
