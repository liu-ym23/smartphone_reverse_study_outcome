package org.apache.commons.io.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import org.apache.commons.io.IOExceptionList;

/* JADX INFO: loaded from: classes6.dex */
public final class PathUtils {
    public static final CopyOption[] EMPTY_COPY_OPTIONS = null;
    public static final DeleteOption[] EMPTY_DELETE_OPTION_ARRAY = null;
    public static final FileVisitOption[] EMPTY_FILE_VISIT_OPTION_ARRAY = null;
    public static final LinkOption[] EMPTY_LINK_OPTION_ARRAY = null;
    public static final OpenOption[] EMPTY_OPEN_OPTION_ARRAY = null;
    public static final Path[] EMPTY_PATH_ARRAY = null;
    public static final LinkOption[] NOFOLLOW_LINK_OPTION_ARRAY = null;

    static {
        EMPTY_COPY_OPTIONS = new CopyOption[0];
        EMPTY_DELETE_OPTION_ARRAY = new DeleteOption[0];
        EMPTY_FILE_VISIT_OPTION_ARRAY = new FileVisitOption[0];
        EMPTY_LINK_OPTION_ARRAY = new LinkOption[0];
        NOFOLLOW_LINK_OPTION_ARRAY = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        EMPTY_OPEN_OPTION_ARRAY = new OpenOption[0];
        EMPTY_PATH_ARRAY = new Path[0];
    }

    public static Counters.PathCounters delete(Path r2) {
        return delete((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters delete(Path r2, LinkOption[] r3, DeleteOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r5, r3) == false) goto L6;
        return deleteDirectory(r5, r3, r4);
    L6:
        return deleteFile(r5, r3, r4);
    }

    public static Counters.PathCounters delete(Path r3, DeleteOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r5, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L6;
        return deleteDirectory(r5, r4);
    L6:
        return deleteFile(r5, r4);
    }

    public static Counters.PathCounters deleteDirectory(Path r4, LinkOption[] r5, DeleteOption... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        return ((DeletingPathVisitor) ZeusTransformUtils.preCheckCast(visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), r5, r6, new String[0]), r7), DeletingPathVisitor.class, "com.obric.memorydata.plugin")).getPathCounters();
    }

    public static Counters.PathCounters deleteDirectory(Path r5, DeleteOption... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        return ((DeletingPathVisitor) ZeusTransformUtils.preCheckCast(visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), NOFOLLOW_LINK_OPTION_ARRAY, r6, new String[0]), r7), DeletingPathVisitor.class, "com.obric.memorydata.plugin")).getPathCounters();
    }

    public static Counters.PathCounters deleteFile(Path r4, LinkOption[] r5, DeleteOption... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r7, r5) == true) goto L19;
        Counters.PathCounters r0 = Counters.longPathCounters();
        boolean r1 = Files.exists(r7, r5);
        if (r1 == true) goto L7;
    L9:
        long r2 = 0;
    L11:
        if (overrideReadOnly(r6) == false) goto L15;
        if (r1 == false) goto L15;
        setReadOnly(r7, false, r5);
    L15:
        if (Files.deleteIfExists(r7) == false) goto L17;
        r0.getFileCounter().increment();
        r0.getByteCounter().add(r2);
    L17:
        return r0;
    L7:
        if (Files.isSymbolicLink(r7) == true) goto L9;
        r2 = Files.size(r7);
        goto L11
    L19:
        throw new NoSuchFileException(r7.toString());
    }

    public static Counters.PathCounters deleteFile(Path r2, DeleteOption... r3) {
        return deleteFile((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), NOFOLLOW_LINK_OPTION_ARRAY, r3);
    }

    public static boolean isEmptyDirectory(Path r2) {
        DirectoryStream<Path> r3 = Files.newDirectoryStream((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"));
        boolean r0 = !r3.iterator().hasNext();
        if (r3 == null) goto L7;
        r3.close();
    L7:
        return r0;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r3 != null) goto L19;
    L16:
        throw th;
    L19:
        r3.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    public static boolean isNewer(Path r3, long r4, LinkOption... r6) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "file");
        if (Files.notExists(r5, new LinkOption[0]) == false) goto L6;
        return false;
    L6:
        if (Files.getLastModifiedTime(r5, r6).toMillis() <= r4) goto L9;
        return true;
    L9:
        return false;
    }

    static /* synthetic */ boolean lambda$overrideReadOnly$1(DeleteOption r2) {
        if (((DeleteOption) ZeusTransformUtils.wrapperContextForParams(r2, DeleteOption.class, "com.obric.memorydata.plugin")) != StandardDeleteOption.OVERRIDE_READ_ONLY) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean overrideReadOnly(DeleteOption... r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return Stream.of(r1).anyMatch($$Lambda$PathUtils$NTKc9sC3yuS_38r3dDrYudExOZQ.INSTANCE);
    }

    public static Path setReadOnly(Path r5, boolean r6, LinkOption... r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(2);
        DosFileAttributeView r3 = (DosFileAttributeView) ZeusTransformUtils.preCheckCast(Files.getFileAttributeView(r8, DosFileAttributeView.class, r7), DosFileAttributeView.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L23;
    L8:
        PosixFileAttributeView r9 = (PosixFileAttributeView) ZeusTransformUtils.preCheckCast(Files.getFileAttributeView(r8, PosixFileAttributeView.class, r7), PosixFileAttributeView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L16;
        Set<PosixFilePermission> r10 = r9.readAttributes().permissions();
        r10.remove(PosixFilePermission.OWNER_WRITE);
        r10.remove(PosixFilePermission.GROUP_WRITE);
        r10.remove(PosixFilePermission.OTHERS_WRITE);
        return Files.setPosixFilePermissions(r8, r10);
    L13:
        e = move-exception;
        r0.add(e);
    L16:
        if (r0.isEmpty() == true) goto L20;
        throw new IOExceptionList(r8.toString(), r0);
    L20:
        throw new IOException(String.format("No DosFileAttributeView or PosixFileAttributeView for '%s' (linkOptions=%s)", new Object[]{r8, Arrays.toString(r7)}));
    L23:
        r3.setReadOnly(r6);     // Catch: IOException -> L6
        return r8;
    L6:
        e = move-exception;
        r0.add(e);
        goto L8
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T r2, Path r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, FileVisitor.class, "com.obric.memorydata.plugin");
        Files.walkFileTree((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"), r4);
        return r4;
    }
}
