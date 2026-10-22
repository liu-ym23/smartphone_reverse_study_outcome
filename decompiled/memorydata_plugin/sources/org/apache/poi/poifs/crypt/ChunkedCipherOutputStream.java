package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ChunkedCipherOutputStream extends FilterOutputStream {
    private static final c LOG = null;
    private final byte[] chunk;
    private final int chunkBits;
    private final int chunkSize;
    private Cipher cipher;
    private final DirectoryNode dir;
    private final File fileOut;
    private boolean isClosed;
    private final SparseBitSet plainByteFlags;
    private long pos;
    private long totalPos;
    private long written;

    static {
        LOG = b.a(ChunkedCipherOutputStream.class);
    }

    public static /* synthetic */ void lambda$9nJabrUx8ZrJYoS0xjW_mSb3tz8(ChunkedCipherOutputStream r0, POIFSWriterEvent r1) {
        r0.processPOIFSWriterEvent(r1);
    }

    private void processPOIFSWriterEvent(POIFSWriterEvent r6) {
        DocumentOutputStream r7 = r6.getStream();     // Catch: IOException -> L30
        FileInputStream r0 = new FileInputStream(this.fileOut);     // Catch: Throwable -> L21
        byte[] r1 = new byte[8];     // Catch: Throwable -> L13
        LittleEndian.putLong(r1, 0, this.pos);     // Catch: Throwable -> L13
        r7.write(r1);     // Catch: Throwable -> L13
        IOUtils.copy(r0, r7);     // Catch: Throwable -> L13
        r0.close();     // Catch: Throwable -> L21
        if (r7 == null) goto L10;
        r7.close();     // Catch: IOException -> L30
    L10:
        if (this.fileOut.delete() == true) goto L45;
        LOG.atError().a("Can't delete temporary encryption file: {}", this.fileOut);     // Catch: IOException -> L30
        return;
    L45:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r7 != null) goto L43;
    L29:
        throw th;     // Catch: IOException -> L30
    L43:
        r7.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
    L30:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    }

    public abstract void calculateChecksum(File r1, int r2);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == false) goto L6;
        LOG.atDebug().a("ChunkedCipherOutputStream was already closed - ignoring");
        return;
    L6:
        this.isClosed = true;
        writeChunk(false);     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        super.close();     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        File r0 = this.fileOut;     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        if (r0 == null) goto L10;
        int r1 = (int) (r0.length() + 8);     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        calculateChecksum(this.fileOut, (int) this.pos);     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        this.dir.createDocument("EncryptedPackage", r1, new $$Lambda$ChunkedCipherOutputStream$9nJabrUx8ZrJYoS0xjW_mSb3tz8(this));     // Catch: Throwable -> L14 GeneralSecurityException -> L16
        createEncryptionInfoEntry(this.dir, this.fileOut);     // Catch: Throwable -> L14 GeneralSecurityException -> L16
    L10:
        File r4 = this.fileOut;
        if (r4 == null) goto L26;
        r4.delete();
        return;
    L26:
        return;
    L16:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        File r5 = this.fileOut;
        if (r5 == null) goto L22;
        r5.delete();
    L22:
        throw th;
    }

    public abstract void createEncryptionInfoEntry(DirectoryNode r1, File r2);

    public int getChunkMask() {
        return this.chunk.length - 1;
    }

    public abstract Cipher initCipherForBlock(Cipher r1, int r2, boolean r3);

    public Cipher initCipherForBlockNoFlush(Cipher r1, int r2, boolean r3) {
        return initCipherForBlock(this.cipher, r2, r3);
    }

    public int invokeCipher(int r6, boolean r7) {
        if (this.plainByteFlags.isEmpty() == false) goto L5;
        byte[] r0 = null;
    L6:
        Cipher r2 = this.cipher;
        byte[] r3 = this.chunk;
        if (r7 == false) goto L9;
        int r4 = r2.doFinal(r3, 0, r6, r3);
    L10:
        if (r7 == true) goto L12;
    L20:
        if (r0 == null) goto L25;
        int r8 = this.plainByteFlags.nextSetBit(0);
    L22:
        if (r8 < 0) goto L25;
        if (r8 >= r6) goto L25;
        this.chunk[r8] = r0[r8];
        r8 = this.plainByteFlags.nextSetBit(r8 + 1);
    L25:
        return r4;
    L12:
        if ("IBMJCE".equals(this.cipher.getProvider().getName()) == false) goto L20;
        if ("RC4".equals(this.cipher.getAlgorithm()) == false) goto L20;
        int r9 = (int) (this.pos >> this.chunkBits);
        if (r6 != 0) goto L18;
        r9 = r9 - 1;
        r6 = this.chunk.length;
        boolean r5 = false;
    L19:
        this.cipher = initCipherForBlockNoFlush(this.cipher, r9, r5);
        goto L20
    L18:
        r5 = true;
        goto L19
    L9:
        r4 = r2.update(r3, 0, r6, r3);
        goto L10
    L5:
        r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.chunk.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r3) {
        write(new byte[]{(byte) r3});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) {
        write(r2, r3, r4, false);
    }

    public void write(byte[] r12, int r13, int r14, boolean r15) {
        if (r14 != 0) goto L4;
        return;
    L4:
        if (r14 < 0) goto L20;
        if (r12.length < (r13 + r14)) goto L20;
        int r0 = getChunkMask();
    L8:
        if (r14 <= 0) goto L18;
        long r3 = r0;
        int r1 = (int) (this.pos & r3);
        int r2 = Math.min(this.chunk.length - r1, r14);
        System.arraycopy(r12, r13, this.chunk, r1, r2);
        if (r15 == false) goto L12;
        this.plainByteFlags.set(r1, r1 + r2);
    L12:
        long r7 = r2;
        long r5 = this.pos + r7;
        this.pos = r5;
        this.totalPos += r7;
        r13 = r13 + r2;
        r14 = r14 - r2;
        if ((r5 & r3) != 0) goto L8;
        if (r14 <= 0) goto L16;
        boolean r4 = true;
    L17:
        writeChunk(r4);
        goto L8
    L16:
        r4 = false;
        goto L17
    L18:
        return;
    L20:
        throw new IOException("not enough bytes in your input buffer");
    }

    public void writeChunk(boolean r10) {
        long r0 = this.pos;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.totalPos == this.written) goto L25;
        int r1 = (int) (r0 & ((long) getChunkMask()));
        long r4 = this.pos;
        int r2 = (int) (r4 >> this.chunkBits);
        boolean r6 = true;
        if (r1 != 0) goto L10;
        r2 = r2 - 1;
        r1 = this.chunk.length;
        boolean r8 = false;
    L23:
        this.pos = 0;     // Catch: GeneralSecurityException -> L19
        if (this.chunkSize != (-1)) goto L15;
        if (r10 == false) goto L16;
        r6 = false;
    L16:
        int r11 = invokeCipher(r1, r6);     // Catch: GeneralSecurityException -> L19
        this.out.write(this.chunk, 0, r11);
        this.plainByteFlags.clear();
        this.written += (long) r11;
        return;
    L15:
        this.cipher = initCipherForBlock(this.cipher, r2, r8);     // Catch: GeneralSecurityException -> L19
        this.pos = r4;     // Catch: GeneralSecurityException -> L19
    L19:
        e = move-exception;
        throw new IOException("can't re-/initialize cipher", e);
    L10:
        r8 = true;
        goto L23
    }
}
