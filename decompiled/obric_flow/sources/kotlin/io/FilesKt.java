package kotlin.io;

import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/io/FilesKt__FilePathComponentsKt", "kotlin/io/FilesKt__FileReadWriteKt", "kotlin/io/FilesKt__FileTreeWalkKt", "kotlin/io/FilesKt__UtilsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class FilesKt extends FilesKt__UtilsKt {
    private FilesKt() {
    }

    public static /* bridge */ /* synthetic */ String a(File r5) {
        return FilesKt__FileReadWriteKt.readText$default(r5, null, 1, null);
    }
}
