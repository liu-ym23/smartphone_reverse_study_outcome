package org.apache.commons.io.filefilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(String r3) {
        this(r3, 0);
    }

    public MagicNumberFileFilter(String r3, long r4) {
        if (r3 == null) goto L15;
        if (r3.isEmpty() == true) goto L13;
        if (r4 < 0) goto L11;
        this.magicNumbers = r3.getBytes(Charset.defaultCharset());
        this.byteOffset = r4;
        return;
    L11:
        throw new IllegalArgumentException("The offset cannot be negative");
    L13:
        throw new IllegalArgumentException("The magic number must contain at least one byte");
    L15:
        throw new IllegalArgumentException("The magic number cannot be null");
    }

    public MagicNumberFileFilter(byte[] r3) {
        this(r3, 0);
    }

    public MagicNumberFileFilter(byte[] r4, long r5) {
        if (r4 == null) goto L15;
        if (r4.length == 0) goto L13;
        if (r5 < 0) goto L11;
        byte[] r0 = IOUtils.byteArray(r4.length);
        this.magicNumbers = r0;
        System.arraycopy(r4, 0, r0, 0, r4.length);
        this.byteOffset = r5;
        return;
    L11:
        throw new IllegalArgumentException("The offset cannot be negative");
    L13:
        throw new IllegalArgumentException("The magic number must contain at least one byte");
    L15:
        throw new IllegalArgumentException("The magic number cannot be null");
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path r4, BasicFileAttributes r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r7 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r5, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L29;
        if (Files.isRegularFile(r6, new LinkOption[0]) == false) goto L29;
        if (Files.isReadable(r6) == false) goto L29;
        FileChannel r8 = FileChannel.open(r6, new OpenOption[0]);     // Catch: IOException -> L30
        ByteBuffer r0 = ByteBuffer.allocate(this.magicNumbers.length);     // Catch: Throwable -> L19
        int r1 = r8.read(r0);     // Catch: Throwable -> L19
        byte[] r3 = this.magicNumbers;     // Catch: Throwable -> L19
        if (r1 == r3.length) goto L15;
        FileVisitResult r9 = FileVisitResult.TERMINATE;     // Catch: Throwable -> L19
        if (r8 == null) goto L14;
        r8.close();     // Catch: IOException -> L30
    L14:
        return r9;
    L15:
        FileVisitResult r10 = toFileVisitResult(Arrays.equals(r3, r0.array()), r6);     // Catch: Throwable -> L19
        if (r8 == null) goto L18;
        r8.close();     // Catch: IOException -> L30
    L18:
        return r10;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r8 != null) goto L35;
    L27:
        throw th;     // Catch: IOException -> L30
    L35:
        r8.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
    L29:
        return FileVisitResult.TERMINATE;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (r5 != null) goto L5;
    L24:
        return false;
    L5:
        if (r5.isFile() == false) goto L24;
        if (r5.canRead() == false) goto L24;
        RandomAccessFile r1 = new RandomAccessFile(r5, "r");     // Catch: IOException -> L25
        byte[] r6 = IOUtils.byteArray(this.magicNumbers.length);     // Catch: Throwable -> L16
        r1.seek(this.byteOffset);     // Catch: Throwable -> L16
        int r2 = r1.read(r6);     // Catch: Throwable -> L16
        byte[] r4 = this.magicNumbers;     // Catch: Throwable -> L16
        if (r2 == r4.length) goto L13;
        r1.close();     // Catch: IOException -> L25
        return false;
    L13:
        boolean r7 = Arrays.equals(r4, r6);     // Catch: Throwable -> L16
        r1.close();     // Catch: IOException -> L25
        return r7;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L25
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
        goto L23
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + "," + this.byteOffset + ")";
    }
}
