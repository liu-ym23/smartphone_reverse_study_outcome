package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class VBAInfoAtom extends RecordAtom {
    private static final long _type = 0;
    private byte[] _header;
    private boolean hasMacros;
    private long persistIdRef;
    private long version;

    static {
        _type = RecordTypes.VBAInfoAtom.typeID;
    }

    public VBAInfoAtom(byte[] r5, int r6, int r7) {
        int r8 = r6 + 8;
        this._header = Arrays.copyOfRange(r5, r6, r8);
        this.persistIdRef = LittleEndian.getUInt(r5, r8);
        if (LittleEndian.getUInt(r5, r6 + 12) != 1) goto L5;
        boolean r9 = true;
    L6:
        this.hasMacros = r9;
        this.version = LittleEndian.getUInt(r5, r6 + 16);
        return;
    L5:
        r9 = false;
        goto L6
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("persistIdRef", new $$Lambda$V56KREVA9ldUgsNmPRekzxbE1c(this), "hasMacros", new $$Lambda$9HFOwckufYVd_W0y1eOjlLtvhLw(this), "version", new $$Lambda$Jx8toIbTT48TSd77TqEMqdrN7Y(this));
    }

    public long getPersistIdRef() {
        return this.persistIdRef;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean isHasMacros() {
        return this.hasMacros;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        LittleEndian.putUInt(this.persistIdRef, r3);
        if (this.hasMacros == false) goto L5;
        long r0 = 1;
    L6:
        LittleEndian.putUInt(r0, r3);
        LittleEndian.putUInt(this.version, r3);
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
