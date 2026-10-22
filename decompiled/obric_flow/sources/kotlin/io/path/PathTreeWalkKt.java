package kotlin.io.path;

import com.lynx.serval.svg.SVGRenderEngine;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"keyOf", "", SVGRenderEngine.PATH, "Ljava/nio/file/Path;", "linkOptions", "", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", "", "Lkotlin/io/path/PathNode;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PathTreeWalkKt {
    public static final /* synthetic */ boolean access$createsCycle(PathNode r5) {
        return createsCycle(r5);
    }

    public static final /* synthetic */ Object access$keyOf(Path r5, LinkOption[] r10) {
        return keyOf(r5, r10);
    }

    private static final boolean createsCycle(PathNode r5) {
        PathNode r10 = r5.getParent();
    L3:
        if (r10 == null) goto L15;
        if (r10.getKey() != null) goto L7;
    L18:
        if (Files.isSameFile(r10.getPath(), r5.getPath()) == false) goto L14;
        return true;
    L14:
        r10 = r10.getParent();
        goto L3
    L7:
        if (r5.getKey() == null) goto L18;
        if (Intrinsics.areEqual(r10.getKey(), r5.getKey()) == false) goto L14;
        return true;
    L15:
        return false;
    }

    private static final Object keyOf(Path r5, LinkOption[] r10) {
        LinkOption[] r11 = (LinkOption[]) Arrays.copyOf(r10, r10.length);     // Catch: Throwable -> L4
        return Files.readAttributes(r5, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r11, r11.length)).fileKey();
    L4:
        return null;
    }
}
