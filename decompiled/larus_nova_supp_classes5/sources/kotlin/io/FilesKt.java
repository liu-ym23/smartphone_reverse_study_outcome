package kotlin.io;

import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"kotlin/io/FilesKt__FilePathComponentsKt", "kotlin/io/FilesKt__FileReadWriteKt", "kotlin/io/FilesKt__FileTreeWalkKt", "kotlin/io/FilesKt__UtilsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class FilesKt extends FilesKt__UtilsKt {
    public static /* bridge */ /* synthetic */ void appendBytes(File r0, byte[] r1) {
        FilesKt__FileReadWriteKt.appendBytes(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void appendText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        FilesKt__FileReadWriteKt.appendText$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ ByteBuffer byteBufferForEncoding(int r0, CharsetEncoder r1) {
        return FilesKt__FileReadWriteKt.byteBufferForEncoding(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean copyRecursively$default(File r0, File r1, boolean r2, Function2 r3, int r4, Object r5) {
        return FilesKt__UtilsKt.copyRecursively$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ File copyTo$default(File r0, File r1, boolean r2, int r3, int r4, Object r5) {
        return FilesKt__UtilsKt.copyTo$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean deleteRecursively(File r0) {
        return FilesKt__UtilsKt.deleteRecursively(r0);
    }

    public static /* bridge */ /* synthetic */ void forEachLine$default(File r0, Charset r1, Function1 r2, int r3, Object r4) {
        FilesKt__FileReadWriteKt.forEachLine$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String getExtension(File r0) {
        return FilesKt__UtilsKt.getExtension(r0);
    }

    public static /* bridge */ /* synthetic */ String getInvariantSeparatorsPath(File r0) {
        return FilesKt__UtilsKt.getInvariantSeparatorsPath(r0);
    }

    public static /* bridge */ /* synthetic */ String getNameWithoutExtension(File r0) {
        return FilesKt__UtilsKt.getNameWithoutExtension(r0);
    }

    public static /* bridge */ /* synthetic */ CharsetEncoder newReplaceEncoder(Charset r0) {
        return FilesKt__FileReadWriteKt.newReplaceEncoder(r0);
    }

    public static /* bridge */ /* synthetic */ byte[] readBytes(File r0) {
        return FilesKt__FileReadWriteKt.readBytes(r0);
    }

    public static /* bridge */ /* synthetic */ List readLines$default(File r0, Charset r1, int r2, Object r3) {
        return FilesKt__FileReadWriteKt.readLines$default(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ String readText(File r0, Charset r1) {
        return FilesKt__FileReadWriteKt.readText(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String readText$default(File r0, Charset r1, int r2, Object r3) {
        return FilesKt__FileReadWriteKt.readText$default(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ File relativeTo(File r0, File r1) {
        return FilesKt__UtilsKt.relativeTo(r0, r1);
    }

    public static /* bridge */ /* synthetic */ File resolve(File r0, String r1) {
        return FilesKt__UtilsKt.resolve(r0, r1);
    }

    public static /* bridge */ /* synthetic */ File resolveSibling(File r0, String r1) {
        return FilesKt__UtilsKt.resolveSibling(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(File r0, File r1) {
        return FilesKt__UtilsKt.startsWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String toRelativeString(File r0, File r1) {
        return FilesKt__UtilsKt.toRelativeString(r0, r1);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walk$default(File r0, FileWalkDirection r1, int r2, Object r3) {
        return FilesKt__FileTreeWalkKt.walk$default(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walkBottomUp(File r0) {
        return FilesKt__FileTreeWalkKt.walkBottomUp(r0);
    }

    public static /* bridge */ /* synthetic */ FileTreeWalk walkTopDown(File r0) {
        return FilesKt__FileTreeWalkKt.walkTopDown(r0);
    }

    public static /* bridge */ /* synthetic */ void writeBytes(File r0, byte[] r1) {
        FilesKt__FileReadWriteKt.writeBytes(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void writeText(File r0, String r1, Charset r2) {
        FilesKt__FileReadWriteKt.writeText(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void writeText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        FilesKt__FileReadWriteKt.writeText$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ void writeTextImpl(OutputStream r0, String r1, Charset r2) {
        FilesKt__FileReadWriteKt.writeTextImpl(r0, r1, r2);
    }

    private FilesKt() {
    }
}
