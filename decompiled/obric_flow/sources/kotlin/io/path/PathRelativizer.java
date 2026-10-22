package kotlin.io.path;

import com.lynx.serval.svg.SVGRenderEngine;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", SVGRenderEngine.PATH, "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = null;
    private static final Path emptyPath = null;
    private static final Path parentPath = null;

    static {
        INSTANCE = new PathRelativizer();
        emptyPath = Paths.get("", new String[0]);
        parentPath = Paths.get("..", new String[0]);
    }

    private PathRelativizer() {
    }

    public final Path tryRelativeTo(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r11, "base");
        Path r5 = r11.normalize();
        Path r12 = r10.normalize();
        Path r13 = r5.relativize(r12);
        int r14 = Math.min(r5.getNameCount(), r12.getNameCount());
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L12;
        Path r16 = r5.getName(r15);
        Path r17 = parentPath;
        if (Intrinsics.areEqual(r16, r17) == false) goto L12;
        if (Intrinsics.areEqual(r12.getName(r15), r17) == false) goto L10;
        r15 = r15 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("Unable to compute relative path");
    L12:
        if (Intrinsics.areEqual(r12, r5) == false) goto L14;
    L16:
        String r18 = r13.toString();
        if (StringsKt.k(r18, r13.getFileSystem().getSeparator()) == false) goto L19;
        r12 = r13.getFileSystem().getPath(StringsKt.dropLast(r18, r13.getFileSystem().getSeparator().length()), new String[0]);
    L20:
        Intrinsics.checkNotNull(r12);
        return r12;
    L19:
        r12 = r13;
        goto L20
    L14:
        if (Intrinsics.areEqual(r5, emptyPath) == false) goto L16;
        goto L16
    }
}
