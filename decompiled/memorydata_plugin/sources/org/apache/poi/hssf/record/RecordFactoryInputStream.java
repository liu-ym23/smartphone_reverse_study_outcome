package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class RecordFactoryInputStream {
    private int _bofDepth;
    private DrawingRecord _lastDrawingRecord;
    private Record _lastRecord;
    private boolean _lastRecordWasEOFLevelZero;
    private final RecordInputStream _recStream;
    private final boolean _shouldIncludeContinueRecords;
    private Record[] _unreadRecordBuffer;
    private int _unreadRecordIndex;

    private static final class StreamEncryptionInfo {
        private final FilePassRecord _filePassRec;
        private final boolean _hasBOFRecord;
        private final int _initialRecordsSize;
        private final Record _lastRecord;

        public StreamEncryptionInfo(RecordInputStream r6, List<Record> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            r6.nextRecord();
            int r0 = r6.remaining() + 4;
            Record r2 = RecordFactory.createSingleRecord(r6);
            r8.add(r2);
            FilePassRecord r4 = null;
            if (ZeusTransformUtils.instanceOf(r2, BOFRecord.class) == false) goto L19;
            this._hasBOFRecord = true;
            if (r6.hasNextRecord() == false) goto L20;
            r6.nextRecord();
            r2 = RecordFactory.createSingleRecord(r6);
            r0 = r0 + r2.getRecordSize();
            r8.add(r2);
            if (ZeusTransformUtils.instanceOf(r2, WriteProtectRecord.class) == false) goto L12;
            if (r6.hasNextRecord() == false) goto L12;
            r6.nextRecord();
            Record r9 = RecordFactory.createSingleRecord(r6);
            r0 = r0 + r9.getRecordSize();
            r8.add(r9);
            r2 = r9;
        L12:
            if (ZeusTransformUtils.instanceOf(r2, FilePassRecord.class) == false) goto L15;
            r4 = (FilePassRecord) ZeusTransformUtils.preCheckCast(r2, FilePassRecord.class, "com.obric.memorydata.plugin");
        L15:
            if (ZeusTransformUtils.instanceOf(r2, EOFRecord.class) == false) goto L20;
            throw new IllegalStateException("Nothing between BOF and EOF");
        L20:
            this._initialRecordsSize = r0;
            this._filePassRec = r4;
            this._lastRecord = r2;
            return;
        L19:
            this._hasBOFRecord = false;
            goto L20
        }

        public RecordInputStream createDecryptingStream(InputStream r5) {
            String r0 = Biff8EncryptionKey.getCurrentUserPassword();
            if (r0 != null) goto L5;
            r0 = "VelvetSweatshop";
        L5:
            EncryptionInfo r2 = this._filePassRec.getEncryptionInfo();
        L16:
            e = move-exception;
            throw new EncryptedDocumentException(e);
        L7:
            if (r2.getDecryptor().verifyPassword(r0) == true) goto L15;
            StringBuilder r6 = new StringBuilder();     // Catch: GeneralSecurityException -> L16
            if ("VelvetSweatshop".equals(r0) == false) goto L11;
            String r1 = "Default";
        L13:
            throw new EncryptedDocumentException(r6.append(r1).append(" password is invalid for salt/verifier/verifierHash").toString());     // Catch: GeneralSecurityException -> L16
        L11:
            r1 = "Supplied";
            goto L13
        L15:
            return new RecordInputStream(r5, r2, this._initialRecordsSize);
        }

        public Record getLastRecord() {
            return this._lastRecord;
        }

        public boolean hasBOFRecord() {
            return this._hasBOFRecord;
        }

        public boolean hasEncryption() {
            if (this._filePassRec == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public RecordFactoryInputStream(InputStream r5, boolean r6) {
        this._unreadRecordIndex = -1;
        this._lastDrawingRecord = new DrawingRecord();
        RecordInputStream r0 = new RecordInputStream(r5);
        ArrayList r1 = new ArrayList();
        StreamEncryptionInfo r2 = new StreamEncryptionInfo(r0, r1);
        if (r2.hasEncryption() == false) goto L6;
        r0 = r2.createDecryptingStream(r5);
    L6:
        if (r1.isEmpty() == true) goto L8;
        Record[] r7 = new Record[r1.size()];
        this._unreadRecordBuffer = r7;
        r1.toArray(r7);
        this._unreadRecordIndex = 0;
    L8:
        this._recStream = r0;
        this._shouldIncludeContinueRecords = r6;
        this._lastRecord = r2.getLastRecord();
        this._bofDepth = r2.hasBOFRecord() ? 1 : 0;
        this._lastRecordWasEOFLevelZero = false;
    }

    private Record getNextUnreadRecord() {
        Record[] r0 = this._unreadRecordBuffer;
        if (r0 == null) goto L9;
        int r2 = this._unreadRecordIndex;
        if (r2 >= r0.length) goto L8;
        Record r1 = r0[r2];
        this._unreadRecordIndex = r2 + 1;
        return r1;
    L8:
        this._unreadRecordIndex = -1;
        this._unreadRecordBuffer = null;
    L9:
        return null;
    }

    private Record readNextRecord() {
        Record r0 = RecordFactory.createSingleRecord(this._recStream);
        this._lastRecordWasEOFLevelZero = false;
        if (ZeusTransformUtils.instanceOf(r0, BOFRecord.class) == false) goto L7;
        this._bofDepth++;
        return r0;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, EOFRecord.class) == false) goto L13;
        int r1 = this._bofDepth - 1;
        this._bofDepth = r1;
        if (r1 >= 1) goto L11;
        this._lastRecordWasEOFLevelZero = true;
    L11:
        return r0;
    L13:
        if (ZeusTransformUtils.instanceOf(r0, DBCellRecord.class) == false) goto L16;
        return null;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, RKRecord.class) == false) goto L20;
        return RecordFactory.convertToNumberRecord((RKRecord) ZeusTransformUtils.preCheckCast(r0, RKRecord.class, "com.obric.memorydata.plugin"));
    L20:
        if (ZeusTransformUtils.instanceOf(r0, MulRKRecord.class) == false) goto L24;
        NumberRecord[] r2 = RecordFactory.convertRKRecords((MulRKRecord) ZeusTransformUtils.preCheckCast(r0, MulRKRecord.class, "com.obric.memorydata.plugin"));
        this._unreadRecordBuffer = r2;
        this._unreadRecordIndex = 1;
        return r2[0];
    L24:
        if (r0.getSid() != 235) goto L30;
        if (ZeusTransformUtils.instanceOf(this._lastRecord, DrawingGroupRecord.class) == false) goto L30;
        ((DrawingGroupRecord) ZeusTransformUtils.preCheckCast(this._lastRecord, DrawingGroupRecord.class, "com.obric.memorydata.plugin")).join((AbstractEscherHolderRecord) ZeusTransformUtils.preCheckCast(r0, AbstractEscherHolderRecord.class, "com.obric.memorydata.plugin"));
        return null;
    L30:
        if (r0.getSid() != 60) goto L55;
        ContinueRecord r3 = (ContinueRecord) ZeusTransformUtils.preCheckCast(r0, ContinueRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this._lastRecord, ObjRecord.class) == false) goto L34;
    L51:
        this._lastDrawingRecord.processContinueRecord(r3.getData());
        if (this._shouldIncludeContinueRecords == false) goto L54;
        return r0;
    L54:
        return null;
    L34:
        if (ZeusTransformUtils.instanceOf(this._lastRecord, TextObjectRecord.class) == true) goto L51;
        if (ZeusTransformUtils.instanceOf(this._lastRecord, DrawingGroupRecord.class) == false) goto L41;
        ((DrawingGroupRecord) ZeusTransformUtils.preCheckCast(this._lastRecord, DrawingGroupRecord.class, "com.obric.memorydata.plugin")).processContinueRecord(r3.getData());
        return null;
    L41:
        if (ZeusTransformUtils.instanceOf(this._lastRecord, DrawingRecord.class) == false) goto L44;
        return r3;
    L44:
        if (ZeusTransformUtils.instanceOf(this._lastRecord, UnknownRecord.class) == false) goto L47;
        return r0;
    L47:
        if (ZeusTransformUtils.instanceOf(this._lastRecord, EOFRecord.class) == false) goto L50;
        return r0;
    L50:
        throw new RecordFormatException("Unhandled Continue Record followining " + this._lastRecord.getClass());
    L55:
        this._lastRecord = r0;
        if (ZeusTransformUtils.instanceOf(r0, DrawingRecord.class) == false) goto L58;
        this._lastDrawingRecord = (DrawingRecord) ZeusTransformUtils.preCheckCast(r0, DrawingRecord.class, "com.obric.memorydata.plugin");
    L58:
        return r0;
    }

    public Record nextRecord() {
        Record r0 = getNextUnreadRecord();
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this._recStream.hasNextRecord() == false) goto L7;
        if (this._lastRecordWasEOFLevelZero == true) goto L11;
    L13:
        this._recStream.nextRecord();
        Record r1 = readNextRecord();
        if (r1 == null) goto L6;
        return r1;
    L11:
        if (this._recStream.getNextSid() == 2057) goto L13;
        return null;
    L7:
        return null;
    }
}
