package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hslf.exceptions.CorruptPowerPointFileException;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Record implements GenericRecord {
    protected static final c LOG = null;

    static {
        LOG = b.a(Record.class);
    }

    public Record() {
    }

    public static Record buildRecordAtOffset(byte[] r4, int r5) {
        long r0 = LittleEndian.getUShort(r4, r5 + 2);
        int r2 = (int) LittleEndian.getUInt(r4, r5 + 4);
        if (r2 >= 0) goto L6;
        r2 = 0;
    L6:
        return createRecordForType(r0, r4, r5, r2 + 8);
    }

    public static Record createRecordForType(final long r7, byte[] r9, final int r10, int r11) {
        RecordTypes r0 = RecordTypes.forTypeID((short) r7);
        RecordTypes.RecordConstructor<?> r1 = r0.recordConstructor;
        if (r1 != null) goto L6;
        LOG.atDebug().a(new $$Lambda$Record$XdoJMrM5WgcsglADXY_vFuD1WjU(r7, r10));
        r1 = RecordTypes.UnknownRecordPlaceholder.recordConstructor;
    L20:
        Record r8 = r1.apply(r9, r10, r11);     // Catch: RuntimeException -> L13
        if (ZeusTransformUtils.instanceOf(r8, PositionDependentRecord.class) == false) goto L12;
        ((PositionDependentRecord) ZeusTransformUtils.preCheckCast(r8, PositionDependentRecord.class, "com.obric.memorydata.plugin")).setLastOnDiskOffset(r10);
    L12:
        return r8;
    L13:
        e = move-exception;
        if ((r10 + r11) <= r9.length) goto L19;
        LOG.atWarn().a("Warning: Skipping record of type {} at position {} which claims to be longer than the file! ({} vs {})", Long.valueOf(r7), v.a(r10), v.a(r11), v.a(r9.length - r10));
        return null;
    L19:
        throw new HSLFException("Couldn't instantiate the class for type with id " + r7 + " on class " + r1 + " : " + e, e);
    L6:
        if (r0 != RecordTypes.UnknownRecordPlaceholder) goto L20;
        LOG.atDebug().a(new $$Lambda$Record$xs_x4OuroruVpcRa_vLB3J3L8g(r7, r10));
        goto L20
    }

    public static Record[] findChildRecords(byte[] r8, int r9, int r10) {
        ArrayList r0 = new ArrayList(5);
        int r1 = r9;
    L3:
        int r3 = 0;
        if (r1 > ((r9 + r10) - 8)) goto L22;
        long r4 = LittleEndian.getUShort(r8, r1 + 2);
        int r2 = (int) LittleEndian.getUInt(r8, r1 + 4);
        if (r2 < 0) goto L9;
        r3 = r2;
    L9:
        if (r1 == 0) goto L11;
    L17:
        Record r5 = createRecordForType(r4, r8, r1, r3 + 8);
        if (r5 == null) goto L20;
        r0.add(r5);
    L20:
        r1 = (r1 + 8) + r3;
        goto L3
    L11:
        if (r4 != 0) goto L17;
        if (r3 != 65535) goto L17;
        throw new CorruptPowerPointFileException("Corrupt document - starts with record of type 0000 and length 0xFFFF");
    L22:
        return (Record[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Record[0]), Record[].class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Message lambda$createRecordForType$0(long r4, int r6) {
        return new StringFormattedMessage("Known but unhandled record type %d (0x%04x) at offset %d", new Object[]{Long.valueOf(r4), Long.valueOf(r4), Integer.valueOf(r6)});
    }

    static /* synthetic */ Message lambda$createRecordForType$1(long r4, int r6) {
        return new StringFormattedMessage("Unknown placeholder type %d (0x%04x) at offset %d", new Object[]{Long.valueOf(r4), Long.valueOf(r4), Integer.valueOf(r6)});
    }

    public static void writeLittleEndian(int r2, OutputStream r3) {
        byte[] r0 = new byte[4];
        LittleEndian.putInt(r0, 0, r2);
        r3.write(r0);
    }

    public static void writeLittleEndian(short r2, OutputStream r3) {
        byte[] r0 = new byte[2];
        LittleEndian.putShort(r0, 0, r2);
        r3.write(r0);
    }

    public abstract Record[] getChildRecords();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<Record> getGenericChildren() {
        Record[] r0 = getChildRecords();
        if (r0 != null) goto L6;
        return null;
    L6:
        return Arrays.asList(r0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return RecordTypes.forTypeID((int) getRecordType());
    }

    public abstract long getRecordType();

    public abstract void writeOut(OutputStream r1);
}
