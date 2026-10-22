package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public FilesKt__FileTreeWalkKt() {
    }

    public static final FileTreeWalk walk(File r10, FileWalkDirection r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "direction");
        return new FileTreeWalk(r10, r11);
    }

    public static /* synthetic */ FileTreeWalk walk$default(File r10, FileWalkDirection r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = FileWalkDirection.TOP_DOWN;
    L6:
        return walk(r10, r11);
    }

    public static final FileTreeWalk walkBottomUp(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return walk(r10, FileWalkDirection.BOTTOM_UP);
    }

    public static FileTreeWalk walkTopDown(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return walk(r10, FileWalkDirection.TOP_DOWN);
    }
}
