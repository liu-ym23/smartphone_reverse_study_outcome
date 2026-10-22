package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class UserEditAtom extends PositionDependentRecordAtom {
    private static final long _type = 0;
    private byte[] _header;
    private int docPersistRef;
    private int encryptSessionPersistIdRef;
    private int lastUserEditAtomOffset;
    private short lastViewType;
    private int lastViewedSlideID;
    private int maxPersistWritten;
    private int persistPointersOffset;
    private int pptVersion;
    private short unused;

    static {
        _type = RecordTypes.UserEditAtom.typeID;
    }

    public UserEditAtom(byte[] r3, int r4, int r5) {
        this.encryptSessionPersistIdRef = -1;
        if (r5 >= 34) goto L5;
        r5 = 34;
    L5:
        int r0 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r0);
        this.lastViewedSlideID = LittleEndian.getInt(r3, r0);
        int r1 = r0 + 4;
        this.pptVersion = LittleEndian.getInt(r3, r1);
        int r2 = r1 + 4;
        this.lastUserEditAtomOffset = LittleEndian.getInt(r3, r2);
        int r6 = r2 + 4;
        this.persistPointersOffset = LittleEndian.getInt(r3, r6);
        int r7 = r6 + 4;
        this.docPersistRef = LittleEndian.getInt(r3, r7);
        int r8 = r7 + 4;
        this.maxPersistWritten = LittleEndian.getInt(r3, r8);
        int r9 = r8 + 4;
        this.lastViewType = LittleEndian.getShort(r3, r9);
        int r10 = r9 + 2;
        this.unused = LittleEndian.getShort(r3, r10);
        int r11 = r10 + 2;
        if ((r11 - r4) >= r5) goto L9;
        this.encryptSessionPersistIdRef = LittleEndian.getInt(r3, r11);
        r11 = r11 + 4;
    L9:
        if ((r11 - r4) != r5) goto L12;
        return;
    L12:
        throw new HSLFException("Having invalid data in UserEditAtom: len: " + r5 + ", offset: " + r11 + ", start: " + r4);
    }

    public int getDocPersistRef() {
        return this.docPersistRef;
    }

    public int getEncryptSessionPersistIdRef() {
        return this.encryptSessionPersistIdRef;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("lastViewedSlideID", new $$Lambda$MXV5krqfqnRKsCQEnVcMcjFS9yY(this));
        r0.put("pptVersion", new $$Lambda$UserEditAtom$mZhvpAv7vmzGJQ0Fv1dV0NbI2c(this));
        r0.put("lastUserEditAtomOffset", new $$Lambda$KiyJoeOXcOB6I1zsad_j7xXdw(this));
        r0.put("persistPointersOffset", new $$Lambda$GgboZMOd19a2ioHNLeBpupNCsPY(this));
        r0.put("docPersistRef", new $$Lambda$9QIw786s3l_huOkd30B0opHRJS8(this));
        r0.put("maxPersistWritten", new $$Lambda$MSycDRpcHSQaWaEGjR86nLo4Y(this));
        r0.put("lastViewType", new $$Lambda$pvNA3g76fuTRgd002mELIUP9OjQ(this));
        r0.put("encryptSessionPersistIdRef", new $$Lambda$cUWOBrmZQgCYByZGOiKPIK0TPXw(this));
        return Collections.unmodifiableMap(r0);
    }

    public int getLastUserEditAtomOffset() {
        return this.lastUserEditAtomOffset;
    }

    public short getLastViewType() {
        return this.lastViewType;
    }

    public int getLastViewedSlideID() {
        return this.lastViewedSlideID;
    }

    public int getMaxPersistWritten() {
        return this.maxPersistWritten;
    }

    public int getPersistPointersOffset() {
        return this.persistPointersOffset;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UserEditAtom() {
        return Integer.valueOf(this.pptVersion);
    }

    public void setLastUserEditAtomOffset(int r1) {
        this.lastUserEditAtomOffset = r1;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        writeLittleEndian(this.lastViewedSlideID, r2);
        writeLittleEndian(this.pptVersion, r2);
        writeLittleEndian(this.lastUserEditAtomOffset, r2);
        writeLittleEndian(this.persistPointersOffset, r2);
        writeLittleEndian(this.docPersistRef, r2);
        writeLittleEndian(this.maxPersistWritten, r2);
        writeLittleEndian(this.lastViewType, r2);
        writeLittleEndian(this.unused, r2);
        int r1 = this.encryptSessionPersistIdRef;
        if (r1 == (-1)) goto L6;
        writeLittleEndian(r1, r2);
        return;
    }
}
