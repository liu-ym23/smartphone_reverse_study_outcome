package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class PathNode {
    private Iterator<PathNode> contentIterator;
    private final Object key;
    private final PathNode parent;
    private final Path path;

    public PathNode(Path r10, Object r11, PathNode r12) {
        Intrinsics.checkNotNullParameter(r10, "path");
        this.path = r10;
        this.key = r11;
        this.parent = r12;
    }

    public final Iterator<PathNode> getContentIterator() {
        return this.contentIterator;
    }

    public final Object getKey() {
        return this.key;
    }

    public final PathNode getParent() {
        return this.parent;
    }

    public final Path getPath() {
        return this.path;
    }

    public final void setContentIterator(Iterator<PathNode> r10) {
        this.contentIterator = r10;
    }
}
