package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    /* JADX WARN: Multi-variable type inference failed */
    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r10, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r11, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r12, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r13) {
        this.onPreVisitDirectory = r10;
        this.onVisitFile = r11;
        this.onVisitFileFailed = r12;
        this.onPostVisitDirectory = r13;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object r10, IOException r11) {
        return postVisitDirectory((Path) r10, r11);
    }

    public FileVisitResult postVisitDirectory(Path r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        Function2<Path, IOException, FileVisitResult> r12 = this.onPostVisitDirectory;
        if (r12 == null) goto L6;
        FileVisitResult r13 = r12.invoke(r10, r11);
        if (r13 == null) goto L6;
        return r13;
    L6:
        FileVisitResult r14 = super.postVisitDirectory(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "super.postVisitDirectory(dir, exc)");
        return r14;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object r10, BasicFileAttributes r11) {
        return preVisitDirectory((Path) r10, r11);
    }

    public FileVisitResult preVisitDirectory(Path r10, BasicFileAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r12 = this.onPreVisitDirectory;
        if (r12 == null) goto L6;
        FileVisitResult r13 = r12.invoke(r10, r11);
        if (r13 == null) goto L6;
        return r13;
    L6:
        FileVisitResult r14 = super.preVisitDirectory(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "super.preVisitDirectory(dir, attrs)");
        return r14;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object r10, BasicFileAttributes r11) {
        return visitFile((Path) r10, r11);
    }

    public FileVisitResult visitFile(Path r10, BasicFileAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r12 = this.onVisitFile;
        if (r12 == null) goto L6;
        FileVisitResult r13 = r12.invoke(r10, r11);
        if (r13 == null) goto L6;
        return r13;
    L6:
        FileVisitResult r14 = super.visitFile(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "super.visitFile(file, attrs)");
        return r14;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object r10, IOException r11) {
        return visitFileFailed((Path) r10, r11);
    }

    public FileVisitResult visitFileFailed(Path r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "exc");
        Function2<Path, IOException, FileVisitResult> r12 = this.onVisitFileFailed;
        if (r12 == null) goto L6;
        FileVisitResult r13 = r12.invoke(r10, r11);
        if (r13 == null) goto L6;
        return r13;
    L6:
        FileVisitResult r14 = super.visitFileFailed(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "super.visitFileFailed(file, exc)");
        return r14;
    }
}
