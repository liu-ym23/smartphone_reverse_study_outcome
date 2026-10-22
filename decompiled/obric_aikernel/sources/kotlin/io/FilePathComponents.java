package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FilePathComponents {
    private final File root;
    private final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(File r10, List<? extends File> r11) {
        Intrinsics.checkNotNullParameter(r10, "root");
        Intrinsics.checkNotNullParameter(r11, "segments");
        this.root = r10;
        this.segments = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents r10, File r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.root;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.segments;
    L9:
        return r10.copy(r11, r12);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File r10, List<? extends File> r11) {
        Intrinsics.checkNotNullParameter(r10, "root");
        Intrinsics.checkNotNullParameter(r11, "segments");
        return new FilePathComponents(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FilePathComponents) == true) goto L8;
        return false;
    L8:
        FilePathComponents r11 = (FilePathComponents) r10;
        if (Intrinsics.areEqual(this.root, r11.root) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.segments, r11.segments) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String r10 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "root.path");
        return r10;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        return (this.root.hashCode() * 31) + this.segments.hashCode();
    }

    public final boolean isRooted() {
        String r10 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "root.path");
        if (r10.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final File subPath(int r11, int r12) {
        if (r11 < 0) goto L9;
        if (r11 > r12) goto L9;
        if (r12 > getSize()) goto L9;
        List<File> r10 = this.segments.subList(r11, r12);
        String r13 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r13, "separator");
        return new File(CollectionsKt.joinToString$default(r10, r13, null, null, 0, null, null, 62, null));
    L9:
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
