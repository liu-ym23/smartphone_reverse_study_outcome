package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = null;
    public static final BigInteger ONE_EB_BI = null;
    public static final BigInteger ONE_GB_BI = null;
    public static final BigInteger ONE_KB_BI = null;
    public static final BigInteger ONE_MB_BI = null;
    public static final BigInteger ONE_PB_BI = null;
    public static final BigInteger ONE_TB_BI = null;
    public static final BigInteger ONE_YB = null;
    public static final BigInteger ONE_ZB = null;

    static {
        BigInteger r2 = BigInteger.valueOf(1024);
        ONE_KB_BI = r2;
        BigInteger r3 = r2.multiply(r2);
        ONE_MB_BI = r3;
        BigInteger r4 = r2.multiply(r3);
        ONE_GB_BI = r4;
        BigInteger r5 = r2.multiply(r4);
        ONE_TB_BI = r5;
        BigInteger r6 = r2.multiply(r5);
        ONE_PB_BI = r6;
        ONE_EB_BI = r2.multiply(r6);
        BigInteger r0 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        ONE_ZB = r0;
        ONE_YB = r2.multiply(r0);
        EMPTY_FILE_ARRAY = new File[0];
    }

    public static File delete(File r1) {
        Objects.requireNonNull(r1, "file");
        Files.delete(r1.toPath());
        return r1;
    }

    public static boolean isFileNewer(File r2, long r3) {
        Objects.requireNonNull(r2, "file");
        if (r2.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (lastModifiedUnchecked(r2) <= r3) goto L7;
        return true;
    }

    public static boolean isSymlink(File r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (Files.isSymbolicLink(r0.toPath()) == false) goto L6;
        return true;
    }

    public static long lastModified(File r2) {
        return Files.getLastModifiedTime((Path) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r2.toPath(), "file"), Path.class, "com.obric.memorydata.plugin"), new LinkOption[0]).toMillis();
    }

    public static long lastModifiedUnchecked(File r2) {
        return lastModified(r2);
    L4:
        e = move-exception;
        throw new UncheckedIOException(r2.toString(), e);
    }

    private static File requireDirectory(File r3, String r4) {
        Objects.requireNonNull(r3, r4);
        if (r3.isDirectory() == false) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Parameter '" + r4 + "' is not a directory: '" + r3 + "'");
    }

    private static File requireDirectoryExists(File r0, String r1) {
        requireExists(r0, r1);
        requireDirectory(r0, r1);
        return r0;
    }

    private static File requireExists(File r3, String r4) {
        Objects.requireNonNull(r3, r4);
        if (r3.exists() == false) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("File system element for parameter '" + r4 + "' does not exist: '" + r3 + "'");
    }

    private static long sizeOf0(File r2) {
        Objects.requireNonNull(r2, "file");
        if (r2.isDirectory() == false) goto L7;
        return sizeOfDirectory0(r2);
    L7:
        return r2.length();
    }

    public static long sizeOfDirectory(File r2) {
        return sizeOfDirectory0(requireDirectoryExists(r2, "directory"));
    }

    private static long sizeOfDirectory0(File r8) {
        Objects.requireNonNull(r8, "directory");
        File[] r9 = r8.listFiles();
        if (r9 != null) goto L5;
        return 0;
    L5:
        int r2 = r9.length;
        int r3 = 0;
        long r4 = 0;
    L6:
        if (r3 >= r2) goto L13;
        File r6 = r9[r3];
        if (isSymlink(r6) == true) goto L12;
        r4 = r4 + sizeOf0(r6);
        if (r4 < 0) goto L13;
    L12:
        r3 = r3 + 1;
    L13:
        return r4;
    }
}
