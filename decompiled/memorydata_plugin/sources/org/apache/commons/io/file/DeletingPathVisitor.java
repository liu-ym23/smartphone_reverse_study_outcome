package org.apache.commons.io.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class DeletingPathVisitor extends CountingPathVisitor {
    private final LinkOption[] linkOptions;
    private final boolean overrideReadOnly;
    private final String[] skip;

    public DeletingPathVisitor(Counters.PathCounters r3, LinkOption[] r4, DeleteOption[] r5, String... r6) {
        super((Counters.PathCounters) ZeusTransformUtils.wrapperContextForParams(r3, Counters.PathCounters.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L5;
        String[] r7 = (String[]) ZeusTransformUtils.preCheckCast(r6.clone(), String[].class, "com.obric.memorydata.plugin");
    L6:
        Arrays.sort(r7);
        this.skip = r7;
        this.overrideReadOnly = StandardDeleteOption.overrideReadOnly(r5);
        if (r4 != null) goto L9;
        LinkOption[] r8 = PathUtils.NOFOLLOW_LINK_OPTION_ARRAY;
    L10:
        this.linkOptions = r8;
        return;
    L9:
        r8 = (LinkOption[]) ZeusTransformUtils.preCheckCast(r4.clone(), LinkOption[].class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r7 = EMPTY_STRING_ARRAY;
        goto L6
    }

    private boolean accept(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        if (Arrays.binarySearch(this.skip, Objects.toString(r4.getFileName(), null)) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (super.equals(r5) == true) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        DeletingPathVisitor r6 = (DeletingPathVisitor) ZeusTransformUtils.preCheckCast(r5, DeletingPathVisitor.class, "com.obric.memorydata.plugin");
        if (this.overrideReadOnly != r6.overrideReadOnly) goto L17;
        if (Arrays.equals(this.skip, r6.skip) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.skip)) * 31) + Objects.hash(new Object[]{Boolean.valueOf(this.overrideReadOnly)});
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult postVisitDirectory(Object r3, IOException r4) {
        return postVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public FileVisitResult postVisitDirectory(Path r3, IOException r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        if (PathUtils.isEmptyDirectory(r5) == false) goto L6;
        Files.deleteIfExists(r5);
    L6:
        return super.postVisitDirectory(r5, r4);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult preVisitDirectory(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return preVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public FileVisitResult preVisitDirectory(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        super.preVisitDirectory(r5, (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin"));
        if (accept(r5) == false) goto L6;
        return FileVisitResult.CONTINUE;
    L6:
        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return visitFile((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public FileVisitResult visitFile(Path r3, BasicFileAttributes r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        if (accept(r5) == true) goto L5;
    L13:
        updateFileCounters(r5, r6);
        return FileVisitResult.CONTINUE;
    L5:
        if (Files.exists(r5, this.linkOptions) == false) goto L11;
        if (this.overrideReadOnly == false) goto L9;
        PathUtils.setReadOnly(r5, false, this.linkOptions);
    L9:
        Files.deleteIfExists(r5);
    L11:
        if (Files.isSymbolicLink(r5) == false) goto L13;
        Files.delete(r5);     // Catch: NoSuchFileException -> L15
        goto L13
    }
}
