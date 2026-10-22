package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes8.dex */
final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    Ser(byte r1, Object r2) {
        this.type = r1;
        this.object = r2;
    }

    static Object read(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin");
        return readInternal(r3.readByte(), r3);
    }

    static long readEpochSec(DataInput r4) {
        DataInput r5 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r4, DataInput.class, "com.obric.memorydata.plugin");
        int r0 = r5.readByte() & 255;
        if (r0 == 255) goto L5;
        int r2 = r5.readByte() & 255;
        int r1 = (r0 << 16) + (r2 << 8);
        return (((long) (r1 + (r5.readByte() & 255))) * 900) - 4575744000L;
    L5:
        return r5.readLong();
    }

    private static Object readInternal(byte r2, DataInput r3) {
        DataInput r4 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r3, DataInput.class, "com.obric.memorydata.plugin");
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 != 3) goto L11;
        return ZoneOffsetTransitionRule.readExternal(r4);
    L11:
        throw new StreamCorruptedException("Unknown serialized type");
    L13:
        return ZoneOffsetTransition.readExternal(r4);
    L15:
        return StandardZoneRules.readExternal(r4);
    }

    static ZoneOffset readOffset(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin");
        byte r0 = r3.readByte();
        if (r0 != 127) goto L6;
        return ZoneOffset.ofTotalSeconds(r3.readInt());
    L6:
        return ZoneOffset.ofTotalSeconds(r0 * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    static void write(Object r2, DataOutput r3) {
        writeInternal((byte) 1, r2, (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin"));
    }

    static void writeEpochSec(long r8, DataOutput r10) {
        DataOutput r11 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r10, DataOutput.class, "com.obric.memorydata.plugin");
        if (r8 >= (-4575744000L)) goto L5;
    L9:
        r11.writeByte(255);
        r11.writeLong(r8);
        return;
    L5:
        if (r8 >= 10413792000L) goto L9;
        if ((r8 % 900) != 0) goto L9;
        int r9 = (int) ((r8 + 4575744000L) / 900);
        r11.writeByte((r9 >>> 16) & 255);
        r11.writeByte((r9 >>> 8) & 255);
        r11.writeByte(r9 & 255);
    }

    private static void writeInternal(byte r2, Object r3, DataOutput r4) {
        DataOutput r5 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r4, DataOutput.class, "com.obric.memorydata.plugin");
        r5.writeByte(r2);
        if (r2 != 1) goto L5;
        ((StandardZoneRules) ZeusTransformUtils.preCheckCast(r3, StandardZoneRules.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L5:
        if (r2 != 2) goto L7;
        ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r3, ZoneOffsetTransition.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L7:
        if (r2 != 3) goto L10;
        ((ZoneOffsetTransitionRule) ZeusTransformUtils.preCheckCast(r3, ZoneOffsetTransitionRule.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L10:
        throw new InvalidClassException("Unknown serialized type");
    }

    static void writeOffset(ZoneOffset r2, DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        int r5 = r2.getTotalSeconds();
        if ((r5 % 900) != 0) goto L5;
        int r0 = r5 / 900;
    L6:
        r4.writeByte(r0);
        if (r0 != 127) goto L10;
        r4.writeInt(r5);
        return;
    L10:
        return;
    L5:
        r0 = 127;
        goto L6
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r3) {
        ObjectInput r4 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectInput.class, "com.obric.memorydata.plugin");
        byte r0 = r4.readByte();
        this.type = r0;
        this.object = readInternal(r0, r4);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r3) {
        ObjectOutput r4 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectOutput.class, "com.obric.memorydata.plugin");
        writeInternal(this.type, this.object, r4);
    }
}
