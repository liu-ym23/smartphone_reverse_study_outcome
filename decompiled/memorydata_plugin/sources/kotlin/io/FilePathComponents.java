package kotlin.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FilePathComponents {
    private final File root;
    private final List<File> segments;

    public FilePathComponents(File r3, List<? extends File> r4) {
        List<File> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r5, "segments");
        this.root = r3;
        this.segments = r5;
    }

    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents r1, File r2, List r3, int r4, Object r5) {
        List<File> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.root;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.segments;
    L9:
        return r1.copy(r2, r6);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File r2, List<? extends File> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r1, "segments");
        return new FilePathComponents(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FilePathComponents.class) == true) goto L8;
        return false;
    L8:
        FilePathComponents r6 = (FilePathComponents) ZeusTransformUtils.preCheckCast(r5, FilePathComponents.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.root, r6.root) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.segments, r6.segments) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String r1 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(r1, "getPath(...)");
        return r1;
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
        String r2 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(r2, "getPath(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final File subPath(int r11, int r12) {
        if (r11 < 0) goto L9;
        if (r11 > r12) goto L9;
        if (r12 > getSize()) goto L9;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.segments.subList(r11, r12), Iterable.class, "com.obric.memorydata.plugin");
        String r10 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r10, "separator");
        return new File(CollectionsKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L9:
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
