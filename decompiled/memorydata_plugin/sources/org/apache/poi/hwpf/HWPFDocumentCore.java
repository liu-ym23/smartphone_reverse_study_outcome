package org.apache.poi.hwpf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIDocument;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hwpf.model.CHPBinTable;
import org.apache.poi.hwpf.model.FibBase;
import org.apache.poi.hwpf.model.FileInformationBlock;
import org.apache.poi.hwpf.model.FontTable;
import org.apache.poi.hwpf.model.ListTables;
import org.apache.poi.hwpf.model.PAPBinTable;
import org.apache.poi.hwpf.model.SectionTable;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.ObjectPoolImpl;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HWPFDocumentCore extends POIDocument {
    private static int MAX_RECORD_LENGTH = 500000000;
    protected CHPBinTable _cbt;
    private EncryptionInfo _encryptionInfo;
    protected FileInformationBlock _fib;
    protected FontTable _ft;
    protected ListTables _lt;
    protected byte[] _mainStream;
    protected ObjectPoolImpl _objectPool;
    protected PAPBinTable _pbt;
    protected StyleSheet _ss;
    protected SectionTable _st;

    static {
    }

    public HWPFDocumentCore(DirectoryNode r4) {
        super(r4);
        this._mainStream = getDocumentEntryBytes("WordDocument", 68, Integer.MAX_VALUE);
        this._fib = new FileInformationBlock(this._mainStream);
        if (r4.hasEntry("ObjectPool") == false) goto L5;
        DirectoryEntry r5 = (DirectoryEntry) ZeusTransformUtils.preCheckCast(r4.getEntry("ObjectPool"), DirectoryEntry.class, "com.obric.memorydata.plugin");
    L6:
        this._objectPool = new ObjectPoolImpl(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    private InputStream getDecryptedStream(DocumentInputStream r3, int r4, int r5) {
        ChunkedCipherInputStream r2 = (ChunkedCipherInputStream) ZeusTransformUtils.preCheckCast(getEncryptionInfo().getDecryptor().getDataStream(r3, r4, 0), ChunkedCipherInputStream.class, "com.obric.memorydata.plugin");
        byte[] r6 = new byte[0];
        if (r5 <= 0) goto L6;
        r6 = IOUtils.safelyAllocate(r5, MAX_RECORD_LENGTH);
        r2.readPlain(r6, 0, r5);
    L6:
        return new SequenceInputStream(new ByteArrayInputStream(r6), r2);
    }

    public static POIFSFileSystem verifyAndBuildPOIFS(InputStream r3) {
        InputStream r4 = FileMagic.prepareToCheckMagic(r3);
        FileMagic r0 = FileMagic.valueOf(r4);
        if (r0 != FileMagic.OLE2) goto L7;
        return new POIFSFileSystem(r4);
    L7:
        throw new IllegalArgumentException("The document is really a " + r0 + " file");
    }

    public CHPBinTable getCharacterTable() {
        return this._cbt;
    }

    public byte[] getDocumentEntryBytes(String r5, int r6, int r7) {
        DirectoryNode r0 = getDirectory();
        DocumentEntry r1 = (DocumentEntry) ZeusTransformUtils.preCheckCast(r0.getEntry(r5), DocumentEntry.class, "com.obric.memorydata.plugin");
        int r2 = r1.getSize();
        if (r6 > (-1)) goto L5;
    L7:
        boolean r3 = false;
    L45:
        DocumentInputStream r4 = r0.createDocumentInputStream(r1);     // Catch: GeneralSecurityException -> L38
        if (r3 == true) goto L50;
        InputStream r8 = r4;
    L43:
        byte[] r9 = IOUtils.toByteArray(r8, Math.min(r2, r7), MAX_RECORD_LENGTH);     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        r8.close();     // Catch: Throwable -> L12
    L18:
        if (r4 == null) goto L20;
        r4.close();     // Catch: GeneralSecurityException -> L38
    L20:
        return r9;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r8 != null) goto L51;
    L29:
        throw th;     // Catch: Throwable -> L12
    L51:
        r8.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r4 != null) goto L48;
    L37:
        throw th;     // Catch: GeneralSecurityException -> L38
    L48:
        r4.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: GeneralSecurityException -> L38
        goto L37
    L50:
        r8 = getDecryptedStream(r4, r2, r6);     // Catch: Throwable -> L12
    L38:
        e = move-exception;
        throw new IOException("Unable to decrypt data for entry: " + r5, e);
    L5:
        if (getEncryptionInfo() == null) goto L7;
        r3 = true;
        goto L45
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        EncryptionInfo r0 = this._encryptionInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FileInformationBlock r1 = this._fib;
        if (r1 != null) goto L8;
    L10:
        byte[] r2 = this._mainStream;
        if (r2 != null) goto L14;
        r2 = getDocumentEntryBytes("WordDocument", -1, 68);
    L14:
        FibBase r3 = new FibBase(r2, 0);
    L15:
        EncryptionMode r4 = null;
        if (r3.isFEncrypted() == true) goto L19;
        return null;
    L19:
        if (r3.isFWhichTblStm() == false) goto L21;
        String r5 = "1Table";
    L22:
        LittleEndianByteArrayInputStream r6 = new LittleEndianByteArrayInputStream(getDocumentEntryBytes(r5, -1, r3.getLKey()));
        if (r3.isFObfuscated() == false) goto L25;
        r4 = EncryptionMode.xor;
    L25:
        EncryptionInfo r7 = new EncryptionInfo(r6, r4);
        Decryptor r8 = r7.getDecryptor();
        r8.setChunkSize(512);
        String r9 = Biff8EncryptionKey.getCurrentUserPassword();     // Catch: GeneralSecurityException -> L35
        if (r9 != null) goto L30;
        r9 = "VelvetSweatshop";
    L30:
        if (r8.verifyPassword(r9) == false) goto L34;
        this._encryptionInfo = r7;
        return r7;
    L34:
        throw new EncryptedDocumentException("document is encrypted, password is invalid - use Biff8EncryptionKey.setCurrentUserPasswort() to set password before opening");     // Catch: GeneralSecurityException -> L35
    L35:
        e = move-exception;
        throw new IOException(e.getMessage(), e);
    L21:
        r5 = "0Table";
        goto L22
    L8:
        if (r1.getFibBase() == null) goto L10;
        r3 = this._fib.getFibBase();
        goto L15
    }

    public FileInformationBlock getFileInformationBlock() {
        return this._fib;
    }

    public ListTables getListTables() {
        return this._lt;
    }

    public PAPBinTable getParagraphTable() {
        return this._pbt;
    }

    public SectionTable getSectionTable() {
        return this._st;
    }

    public StyleSheet getStyleSheet() {
        return this._ss;
    }

    public abstract StringBuilder getText();
}
