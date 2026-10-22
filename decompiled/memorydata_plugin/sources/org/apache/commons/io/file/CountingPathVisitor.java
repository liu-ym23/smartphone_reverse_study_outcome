package org.apache.commons.io.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* JADX INFO: loaded from: classes6.dex */
public class CountingPathVisitor extends SimplePathVisitor {
    static final String[] EMPTY_STRING_ARRAY = null;
    private final PathFilter dirFilter;
    private final PathFilter fileFilter;
    private final Counters.PathCounters pathCounters;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public CountingPathVisitor(Counters.PathCounters r3) {
        this((Counters.PathCounters) ZeusTransformUtils.wrapperContextForParams(r3, Counters.PathCounters.class, "com.obric.memorydata.plugin"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
    }

    public CountingPathVisitor(Counters.PathCounters r3, PathFilter r4, PathFilter r5) {
        Counters.PathCounters r6 = (Counters.PathCounters) ZeusTransformUtils.wrapperContextForParams(r3, Counters.PathCounters.class, "com.obric.memorydata.plugin");
        PathFilter r7 = (PathFilter) ZeusTransformUtils.wrapperContextForParams(r4, PathFilter.class, "com.obric.memorydata.plugin");
        PathFilter r8 = (PathFilter) ZeusTransformUtils.wrapperContextForParams(r5, PathFilter.class, "com.obric.memorydata.plugin");
        this.pathCounters = (Counters.PathCounters) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6, "pathCounter"), Counters.PathCounters.class, "com.obric.memorydata.plugin");
        this.fileFilter = (PathFilter) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7, "fileFilter"), PathFilter.class, "com.obric.memorydata.plugin");
        this.dirFilter = (PathFilter) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8, "dirFilter"), PathFilter.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, CountingPathVisitor.class) == true) goto L10;
        return false;
    L10:
        CountingPathVisitor r4 = (CountingPathVisitor) ZeusTransformUtils.preCheckCast(r3, CountingPathVisitor.class, "com.obric.memorydata.plugin");
        return Objects.equals(this.pathCounters, r4.pathCounters);
    }

    public Counters.PathCounters getPathCounters() {
        return this.pathCounters;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pathCounters});
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult postVisitDirectory(Object r3, IOException r4) {
        return postVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    public FileVisitResult postVisitDirectory(Path r3, IOException r4) {
        updateDirCounter((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"), r4);
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult preVisitDirectory(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return preVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult preVisitDirectory(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        if (this.dirFilter.accept(r5, r6) == FileVisitResult.CONTINUE) goto L6;
        return FileVisitResult.SKIP_SUBTREE;
    L6:
        return FileVisitResult.CONTINUE;
    }

    public String toString() {
        return this.pathCounters.toString();
    }

    public void updateDirCounter(Path r2, IOException r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        this.pathCounters.getDirectoryCounter().increment();
    }

    public void updateFileCounters(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        this.pathCounters.getFileCounter().increment();
        this.pathCounters.getByteCounter().add(r6.size());
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return visitFile((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult visitFile(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        if (Files.exists(r5, new LinkOption[0]) == false) goto L8;
        if (this.fileFilter.accept(r5, r6) != FileVisitResult.CONTINUE) goto L8;
        updateFileCounters(r5, r6);
    L8:
        return FileVisitResult.CONTINUE;
    }
}
