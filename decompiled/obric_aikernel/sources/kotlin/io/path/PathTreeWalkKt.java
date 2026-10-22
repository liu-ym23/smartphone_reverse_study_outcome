package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PathTreeWalkKt {
    public static final /* synthetic */ boolean access$createsCycle(PathNode r10) {
        return createsCycle(r10);
    }

    public static final /* synthetic */ Object access$keyOf(Path r10, LinkOption[] r11) {
        return keyOf(r10, r11);
    }

    private static final boolean createsCycle(PathNode r10) {
        PathNode r11 = r10.getParent();
    L3:
        if (r11 == null) goto L15;
        if (r11.getKey() != null) goto L7;
    L18:
        if (Files.isSameFile(r11.getPath(), r10.getPath()) == false) goto L14;
        return true;
    L14:
        r11 = r11.getParent();
        goto L3
    L7:
        if (r10.getKey() == null) goto L18;
        if (Intrinsics.areEqual(r11.getKey(), r10.getKey()) == false) goto L14;
        return true;
    L15:
        return false;
    }

    private static final Object keyOf(Path r10, LinkOption[] r11) {
        LinkOption[] r12 = (LinkOption[]) Arrays.copyOf(r11, r11.length);     // Catch: Throwable -> L4
        BasicFileAttributes r13 = Files.readAttributes(r10, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r12, r12.length));     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r13, "readAttributes(this, A::class.java, *options)");     // Catch: Throwable -> L4
        return r13.fileKey();
    L4:
        return null;
    }
}
