package kotlin.io.path;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r3, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r4, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r5, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r6) {
        Function2<Path, BasicFileAttributes, FileVisitResult> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function2<Path, BasicFileAttributes, FileVisitResult> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function2<Path, IOException, FileVisitResult> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Function2<Path, IOException, FileVisitResult> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        this.onPreVisitDirectory = r7;
        this.onVisitFile = r8;
        this.onVisitFileFailed = r9;
        this.onPostVisitDirectory = r10;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult postVisitDirectory(Object r3, IOException r4) {
        return postVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    public FileVisitResult postVisitDirectory(Path r4, IOException r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dir");
        Function2<Path, IOException, FileVisitResult> r0 = this.onPostVisitDirectory;
        if (r0 == null) goto L6;
        FileVisitResult r1 = (FileVisitResult) ZeusTransformUtils.preCheckCast(r0.invoke(r6, r5), FileVisitResult.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r2 = super.postVisitDirectory(r6, r5);
        Intrinsics.checkNotNullExpressionValue(r2, "postVisitDirectory(...)");
        return r2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult preVisitDirectory(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return preVisitDirectory((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult preVisitDirectory(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dir");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r0 = this.onPreVisitDirectory;
        if (r0 == null) goto L6;
        FileVisitResult r1 = (FileVisitResult) ZeusTransformUtils.preCheckCast(r0.invoke(r6, r7), FileVisitResult.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r2 = super.preVisitDirectory(r6, r7);
        Intrinsics.checkNotNullExpressionValue(r2, "preVisitDirectory(...)");
        return r2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
        BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        return visitFile((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r5);
    }

    public FileVisitResult visitFile(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "file");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r0 = this.onVisitFile;
        if (r0 == null) goto L6;
        FileVisitResult r1 = (FileVisitResult) ZeusTransformUtils.preCheckCast(r0.invoke(r6, r7), FileVisitResult.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r2 = super.visitFile(r6, r7);
        Intrinsics.checkNotNullExpressionValue(r2, "visitFile(...)");
        return r2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* synthetic */ FileVisitResult visitFileFailed(Object r3, IOException r4) {
        return visitFileFailed((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.memorydata.plugin"), r4);
    }

    public FileVisitResult visitFileFailed(Path r4, IOException r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "file");
        Intrinsics.checkNotNullParameter(r5, "exc");
        Function2<Path, IOException, FileVisitResult> r0 = this.onVisitFileFailed;
        if (r0 == null) goto L6;
        FileVisitResult r1 = (FileVisitResult) ZeusTransformUtils.preCheckCast(r0.invoke(r6, r5), FileVisitResult.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r2 = super.visitFileFailed(r6, r5);
        Intrinsics.checkNotNullExpressionValue(r2, "visitFileFailed(...)");
        return r2;
    }
}
