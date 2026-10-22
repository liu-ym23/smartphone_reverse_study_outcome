package kotlin.io;

import androidx.constraintlayout.motion.widget.a;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FilePathComponents {
    private final File root;
    private final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(File r5, List<? extends File> r10) {
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r10, "segments");
        this.root = r5;
        this.segments = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents r5, File r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.root;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.segments;
    L9:
        return r5.copy(r10, r11);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File r5, List<? extends File> r10) {
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r10, "segments");
        return new FilePathComponents(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FilePathComponents) == true) goto L8;
        return false;
    L8:
        FilePathComponents r10 = (FilePathComponents) r5;
        if (Intrinsics.areEqual(this.root, r10.root) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.segments, r10.segments) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        return this.root.getPath();
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        int r5 = this.root.hashCode() * 31;
        return this.segments.hashCode() + r5;
    }

    public final boolean isRooted() {
        if (this.root.getPath().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final File subPath(int r10, int r11) {
        if (r10 < 0) goto L9;
        if (r10 > r11) goto L9;
        if (r11 > getSize()) goto L9;
        return new File(CollectionsKt.q(this.segments.subList(r10, r11), File.separator, null, null, 0, null, null, 62));
    L9:
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("FilePathComponents(root=");
        r5.append(this.root);
        r5.append(", segments=");
        return a.v(r5, this.segments, ')');
    }
}
