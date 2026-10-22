package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
final class DirectoryEntriesReader extends SimpleFileVisitor<Path> {
    private PathNode directoryNode;
    private ArrayDeque<PathNode> entries;
    private final boolean followLinks;

    public DirectoryEntriesReader(boolean r10) {
        this.followLinks = r10;
        this.entries = new ArrayDeque();
    }

    public final boolean getFollowLinks() {
        return this.followLinks;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object r10, BasicFileAttributes r11) {
        return preVisitDirectory((Path) r10, r11);
    }

    public FileVisitResult preVisitDirectory(Path r10, BasicFileAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        PathNode r12 = new PathNode(r10, r11.fileKey(), this.directoryNode);
        this.entries.add(r12);
        FileVisitResult r13 = super.preVisitDirectory(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "super.preVisitDirectory(dir, attrs)");
        return r13;
    }

    public final List<PathNode> readEntries(PathNode r10) {
        Intrinsics.checkNotNullParameter(r10, "directoryNode");
        this.directoryNode = r10;
        Files.walkFileTree(r10.getPath(), LinkFollowing.INSTANCE.toVisitOptions(this.followLinks), 1, this);
        this.entries.removeFirst();
        ArrayDeque<PathNode> r11 = this.entries;
        this.entries = new ArrayDeque();
        return r11;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object r10, BasicFileAttributes r11) {
        return visitFile((Path) r10, r11);
    }

    public FileVisitResult visitFile(Path r10, BasicFileAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        PathNode r12 = new PathNode(r10, null, this.directoryNode);
        this.entries.add(r12);
        FileVisitResult r13 = super.visitFile(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "super.visitFile(file, attrs)");
        return r13;
    }
}
