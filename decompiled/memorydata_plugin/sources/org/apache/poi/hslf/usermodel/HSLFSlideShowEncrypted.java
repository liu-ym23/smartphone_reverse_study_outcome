package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import org.apache.poi.hslf.exceptions.CorruptPowerPointFileException;
import org.apache.poi.hslf.exceptions.EncryptedPowerPointFileException;
import org.apache.poi.hslf.record.DocumentEncryptionAtom;
import org.apache.poi.hslf.record.PersistPtrHolder;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.UserEditAtom;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.BitField;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFSlideShowEncrypted implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] BLIB_STORE_ENTRY_PARTS = null;
    private static final BitField fieldRecInst = null;
    ChunkedCipherOutputStream cyos;
    DocumentEncryptionAtom dea;

    static {
        fieldRecInst = new BitField(65520);
        BLIB_STORE_ENTRY_PARTS = new int[]{1, 1, 16, 2, 4, 4, 4, 1, 1, 1, 1};
    }

    public HSLFSlideShowEncrypted(DocumentEncryptionAtom r1) {
        this.dea = r1;
    }

    public HSLFSlideShowEncrypted(byte[] r7, NavigableMap<Integer, Record> r8) {
        NavigableMap r9 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r8, NavigableMap.class, "com.obric.memorydata.plugin");
        Iterator r0 = r9.descendingMap().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Record r2 = (Record) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, UserEditAtom.class) == false) goto L4;
        UserEditAtom r3 = (UserEditAtom) ZeusTransformUtils.preCheckCast(r2, UserEditAtom.class, "com.obric.memorydata.plugin");
        if (r3.getEncryptSessionPersistIdRef() == (-1)) goto L4;
    L12:
        if (r3 != null) goto L15;
        this.dea = null;
        return;
    L15:
        Record r1 = (Record) ZeusTransformUtils.preCheckCast(r9.get(Integer.valueOf(r3.getPersistPointersOffset())), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, PersistPtrHolder.class) == false) goto L38;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(((PersistPtrHolder) ZeusTransformUtils.preCheckCast(r1, PersistPtrHolder.class, "com.obric.memorydata.plugin")).getSlideLocationsLookup().get(Integer.valueOf(r3.getEncryptSessionPersistIdRef())), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L21;
        this.dea = null;
        return;
    L21:
        Record r5 = (Record) ZeusTransformUtils.preCheckCast(r9.get(r4), Record.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L24;
        r5 = Record.buildRecordAtOffset(r7, r4.intValue());
        r9.put(r4, r5);
    L24:
        this.dea = (DocumentEncryptionAtom) ZeusTransformUtils.preCheckCast(r5, DocumentEncryptionAtom.class, "com.obric.memorydata.plugin");
        String r10 = Biff8EncryptionKey.getCurrentUserPassword();
        Decryptor r6 = getEncryptionInfo().getDecryptor();     // Catch: GeneralSecurityException -> L34
        if (r10 != null) goto L30;
        r10 = "VelvetSweatshop";
    L30:
        if (r6.verifyPassword(r10) == false) goto L33;
        return;
    L33:
        throw new EncryptedPowerPointFileException("PowerPoint file is encrypted. The correct password needs to be set via Biff8EncryptionKey.setCurrentUserPassword()");     // Catch: GeneralSecurityException -> L34
    L34:
        e = move-exception;
        throw new EncryptedPowerPointFileException(e);
    L38:
        throw new RecordFormatException("Encountered an unexpected record-type: " + r1);
    L11:
        r3 = null;
        goto L12
    }

    private void decryptPicBytes(byte[] r4, int r5, int r6) {
        LittleEndianByteArrayInputStream r0 = new LittleEndianByteArrayInputStream(r4, r5);
        ChunkedCipherInputStream r3 = (ChunkedCipherInputStream) ZeusTransformUtils.preCheckCast(getEncryptionInfo().getDecryptor().getDataStream(r0, r6, 0), ChunkedCipherInputStream.class, "com.obric.memorydata.plugin");
        readFully(r3, r4, r5, r6);
        r3.close();
        r0.close();
    }

    private static void readFully(ChunkedCipherInputStream r0, byte[] r1, int r2, int r3) {
        if (IOUtils.readFully(r0, r1, r2, r3) == (-1)) goto L6;
        return;
    L6:
        throw new EncryptedPowerPointFileException("unexpected EOF");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ChunkedCipherOutputStream r0 = this.cyos;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public void decryptPicture(byte[] r8, int r9) {
        if (this.dea != null) goto L50;
        return;
    L50:
        decryptPicBytes(r8, r9, 8);     // Catch: Exception -> L47
        int r1 = fieldRecInst.getValue(LittleEndian.getUShort(r8, r9));     // Catch: Exception -> L47
        int r2 = LittleEndian.getUShort(r8, r9 + 2);     // Catch: Exception -> L47
        int r3 = (int) LittleEndian.getUInt(r8, r9 + 4);     // Catch: Exception -> L47
        int r10 = r9 + 8;     // Catch: Exception -> L47
        int r4 = r3 + r10;     // Catch: Exception -> L47
        int r5 = 0;
        if (r2 != 61447) goto L17;
        int[] r6 = BLIB_STORE_ENTRY_PARTS;     // Catch: Exception -> L47
        int r7 = r6.length;     // Catch: Exception -> L47
        int r11 = 0;
    L9:
        if (r11 >= r7) goto L11;
        decryptPicBytes(r8, r10, r6[r11]);     // Catch: Exception -> L47
        r11 = r11 + 1;     // Catch: Exception -> L47
        goto L9
    L11:
        int r12 = r10 + 36;     // Catch: Exception -> L47
        int r13 = LittleEndian.getUShort(r8, r12 - 3);     // Catch: Exception -> L47
        if (r13 <= 0) goto L14;
        decryptPicBytes(r8, r12, r13);     // Catch: Exception -> L47
        r12 = r12 + r13;     // Catch: Exception -> L47
    L14:
        if (r12 != r4) goto L16;
        return;
    L16:
        decryptPicBytes(r8, r12, 8);     // Catch: Exception -> L47
        r1 = fieldRecInst.getValue(LittleEndian.getUShort(r8, r12));     // Catch: Exception -> L47
        r2 = LittleEndian.getUShort(r8, r12 + 2);     // Catch: Exception -> L47
        r10 = r12 + 8;     // Catch: Exception -> L47
    L17:
        int r14 = 1;
        if (r1 != 535) goto L20;
    L35:
        int r0 = 2;
    L36:
        if (r5 >= r0) goto L39;
        decryptPicBytes(r8, r10, 16);     // Catch: Exception -> L47
        r10 = r10 + 16;     // Catch: Exception -> L47
        r5 = r5 + 1;     // Catch: Exception -> L47
        goto L36
    L39:
        if (r2 != 61466) goto L41;
    L44:
        r14 = 34;
    L45:
        decryptPicBytes(r8, r10, r14);     // Catch: Exception -> L47
        int r15 = r10 + r14;     // Catch: Exception -> L47
        decryptPicBytes(r8, r15, r4 - r15);     // Catch: Exception -> L47
        return;
    L41:
        if (r2 == 61467) goto L44;
        if (r2 != 61468) goto L45;
    L20:
        if (r1 == 981) goto L35;
        if (r1 == 1131) goto L35;
        if (r1 == 1347) goto L35;
        if (r1 == 1761) goto L35;
        if (r1 == 1763) goto L35;
        if (r1 == 1765) goto L35;
        if (r1 == 1961) goto L35;
        r0 = 1;
    L47:
        e = move-exception;
        throw new CorruptPowerPointFileException(e);
    }

    public void decryptRecord(byte[] r4, int r5, int r6) {
        if (this.dea != null) goto L5;
        return;
    L5:
        Decryptor r3 = getEncryptionInfo().getDecryptor();
        r3.setChunkSize(-1);
        LittleEndianByteArrayInputStream r0 = new LittleEndianByteArrayInputStream(r4, r6);     // Catch: Exception -> L30
        ChunkedCipherInputStream r7 = (ChunkedCipherInputStream) ZeusTransformUtils.preCheckCast(r3.getDataStream(r0, r4.length - r6, 0), ChunkedCipherInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r7.initCipherForBlock(r5);     // Catch: Throwable -> L13
        readFully(r7, r4, r6, 8);     // Catch: Throwable -> L13
        int r1 = (int) LittleEndian.getUInt(r4, r6 + 4);     // Catch: Throwable -> L13
        readFully(r7, r4, r6 + 8, r1);     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        r7.close();     // Catch: Throwable -> L22
    L11:
        r0.close();     // Catch: Exception -> L30
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r7 != null) goto L43;
    L21:
        throw th;     // Catch: Throwable -> L22
    L43:
        r7.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L27
    L29:
        throw th;     // Catch: Exception -> L30
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        throw new EncryptedPowerPointFileException(e);
    }

    public EncryptionInfo getEncryptionInfo() {
        DocumentEncryptionAtom r0 = this.dea;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEncryptionInfo();
    }
}
