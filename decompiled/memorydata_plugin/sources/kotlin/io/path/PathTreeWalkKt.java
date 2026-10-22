package kotlin.io.path;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"keyOf", "", "path", "Ljava/nio/file/Path;", "linkOptions", "", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", "", "Lkotlin/io/path/PathNode;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PathTreeWalkKt {
    public static final /* synthetic */ boolean access$createsCycle(PathNode r0) {
        return createsCycle(r0);
    }

    public static final /* synthetic */ Object access$keyOf(Path r2, LinkOption[] r3) {
        return keyOf((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean createsCycle(PathNode r4) {
        PathNode r0 = r4.getParent();
    L3:
        if (r0 == null) goto L15;
        if (r0.getKey() != null) goto L7;
    L18:
        if (Files.isSameFile(r0.getPath(), r4.getPath()) == false) goto L14;
        return true;
    L14:
        r0 = r0.getParent();
        goto L3
    L7:
        if (r4.getKey() == null) goto L18;
        if (Intrinsics.areEqual(r0.getKey(), r4.getKey()) == false) goto L14;
        return true;
    L15:
        return false;
    }

    private static final Object keyOf(Path r3, LinkOption[] r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        LinkOption[] r6 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), LinkOption[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        BasicFileAttributes r7 = Files.readAttributes(r5, BasicFileAttributes.class, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), LinkOption[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "readAttributes(...)");     // Catch: Throwable -> L5
        return r7.fileKey();
    L5:
        return null;
    }
}
