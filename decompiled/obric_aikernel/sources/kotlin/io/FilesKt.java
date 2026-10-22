package kotlin.io;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class FilesKt extends FilesKt__UtilsKt {
    private FilesKt() {
    }

    public static /* bridge */ /* synthetic */ void appendText$default(File r10, String r11, Charset r12, int r13, Object r14) {
        FilesKt__FileReadWriteKt.appendText$default(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ boolean deleteRecursively(File r10) {
        return FilesKt__UtilsKt.deleteRecursively(r10);
    }

    public static /* bridge */ /* synthetic */ byte[] readBytes(File r10) {
        return FilesKt__FileReadWriteKt.readBytes(r10);
    }

    public static /* bridge */ /* synthetic */ List readLines$default(File r10, Charset r11, int r12, Object r13) {
        return FilesKt__FileReadWriteKt.readLines$default(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ String readText$default(File r10, Charset r11, int r12, Object r13) {
        return FilesKt__FileReadWriteKt.readText$default(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ File relativeTo(File r10, File r11) {
        return FilesKt__UtilsKt.relativeTo(r10, r11);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walkTopDown(File r10) {
        return FilesKt__FileTreeWalkKt.walkTopDown(r10);
    }

    public static /* bridge */ /* synthetic */ void writeBytes(File r10, byte[] r11) {
        FilesKt__FileReadWriteKt.writeBytes(r10, r11);
    }

    public static /* bridge */ /* synthetic */ void writeText(File r10, String r11, Charset r12) {
        FilesKt__FileReadWriteKt.writeText(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ void writeText$default(File r10, String r11, Charset r12, int r13, Object r14) {
        FilesKt__FileReadWriteKt.writeText$default(r10, r11, r12, r13, r14);
    }
}
