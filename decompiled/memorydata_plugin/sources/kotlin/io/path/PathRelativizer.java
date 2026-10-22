package kotlin.io.path;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final Path tryRelativeTo(Path r6, Path r7) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r7, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r8, "base");
        Path r9 = r8.normalize();
        Path r10 = r5.normalize();
        Path r11 = r9.relativize(r10);
        int r0 = Math.min(r9.getNameCount(), r10.getNameCount());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Path r3 = r9.getName(r2);
        Path r4 = parentPath;
        if (Intrinsics.areEqual(r3, r4) == false) goto L12;
        if (Intrinsics.areEqual(r10.getName(r2), r4) == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("Unable to compute relative path");
    L12:
        if (Intrinsics.areEqual(r10, r9) == false) goto L14;
    L16:
        String r12 = r11.toString();
        String r13 = r11.getFileSystem().getSeparator();
        Intrinsics.checkNotNullExpressionValue(r13, "getSeparator(...)");
        if (StringsKt.endsWith$default(r12, r13, false, 2, null) == false) goto L19;
        r10 = r11.getFileSystem().getPath(StringsKt.dropLast(r12, r11.getFileSystem().getSeparator().length()), new String[0]);
    L20:
        Intrinsics.checkNotNull(r10);
        return r10;
    L19:
        r10 = r11;
        goto L20
    L14:
        if (Intrinsics.areEqual(r9, emptyPath) == false) goto L16;
        goto L16
    }
}
