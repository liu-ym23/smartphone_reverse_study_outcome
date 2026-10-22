package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
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
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "base");
        Path r12 = r11.normalize();
        Path r13 = r10.normalize();
        Path r14 = r12.relativize(r13);
        int r15 = Math.min(r12.getNameCount(), r13.getNameCount());
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L12;
        Path r17 = r12.getName(r16);
        Path r18 = parentPath;
        if (Intrinsics.areEqual(r17, r18) == false) goto L12;
        if (Intrinsics.areEqual(r13.getName(r16), r18) == false) goto L10;
        r16 = r16 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("Unable to compute relative path");
    L12:
        if (Intrinsics.areEqual(r13, r12) == false) goto L14;
    L16:
        String r19 = r14.toString();
        String r20 = r14.getFileSystem().getSeparator();
        Intrinsics.checkNotNullExpressionValue(r20, "rn.fileSystem.separator");
        if (StringsKt.endsWith$default(r19, r20, false, 2, null) == false) goto L19;
        r13 = r14.getFileSystem().getPath(StringsKt.dropLast(r19, r14.getFileSystem().getSeparator().length()), new String[0]);
    L20:
        Intrinsics.checkNotNullExpressionValue(r13, "r");
        return r13;
    L19:
        r13 = r14;
        goto L20
    L14:
        if (Intrinsics.areEqual(r12, emptyPath) == false) goto L16;
        goto L16
    }
}
