package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    /* JADX WARN: Multi-variable type inference failed */
    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r5, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r10, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r11, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r12) {
        this.onPreVisitDirectory = r5;
        this.onVisitFile = r10;
        this.onVisitFileFailed = r11;
        this.onPostVisitDirectory = r12;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object r5, IOException r10) {
        return postVisitDirectory((Path) r5, r10);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object r5, BasicFileAttributes r10) {
        return preVisitDirectory((Path) r5, r10);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object r5, BasicFileAttributes r10) {
        return visitFile((Path) r5, r10);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object r5, IOException r10) {
        return visitFileFailed((Path) r5, r10);
    }

    public FileVisitResult postVisitDirectory(Path r5, IOException r10) {
        Intrinsics.checkNotNullParameter(r5, "dir");
        Function2<Path, IOException, FileVisitResult> r11 = this.onPostVisitDirectory;
        if (r11 == null) goto L7;
        FileVisitResult r12 = r11.mo2invoke(r5, r10);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return super.postVisitDirectory(r5, r10);
    }

    public FileVisitResult preVisitDirectory(Path r5, BasicFileAttributes r10) {
        Intrinsics.checkNotNullParameter(r5, "dir");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r11 = this.onPreVisitDirectory;
        if (r11 == null) goto L7;
        FileVisitResult r12 = r11.mo2invoke(r5, r10);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return super.preVisitDirectory(r5, r10);
    }

    public FileVisitResult visitFile(Path r5, BasicFileAttributes r10) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r11 = this.onVisitFile;
        if (r11 == null) goto L7;
        FileVisitResult r12 = r11.mo2invoke(r5, r10);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return super.visitFile(r5, r10);
    }

    public FileVisitResult visitFileFailed(Path r5, IOException r10) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r10, "exc");
        Function2<Path, IOException, FileVisitResult> r11 = this.onVisitFileFailed;
        if (r11 == null) goto L7;
        FileVisitResult r12 = r11.mo2invoke(r5, r10);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return super.visitFileFailed(r5, r10);
    }
}
