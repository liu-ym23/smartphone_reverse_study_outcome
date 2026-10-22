package org.threeten.bp.zone;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import kotlin.UByte;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Serializable a(byte r5, DataInput r10) {
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L11;
        return ZoneOffsetTransitionRule.readExternal(r10);
    L11:
        throw new StreamCorruptedException("Unknown serialized type");
    L13:
        return ZoneOffsetTransition.readExternal(r10);
    L15:
        return StandardZoneRules.readExternal(r10);
    }

    public static void b(byte r5, Object r10, DataOutput r11) {
        r11.writeByte(r5);
        if (r5 != 1) goto L5;
        ((StandardZoneRules) r10).writeExternal(r11);
        return;
    L5:
        if (r5 != 2) goto L7;
        ((ZoneOffsetTransition) r10).writeExternal(r11);
        return;
    L7:
        if (r5 != 3) goto L10;
        ((ZoneOffsetTransitionRule) r10).writeExternal(r11);
        return;
    L10:
        throw new InvalidClassException("Unknown serialized type");
    }

    public static Object read(DataInput r5) throws IOException, ClassNotFoundException {
        return a(r5.readByte(), r5);
    }

    public static long readEpochSec(DataInput r5) throws IOException {
        int r10 = r5.readByte() & UByte.MAX_VALUE;
        if (r10 == 255) goto L5;
        int r11 = r5.readByte() & UByte.MAX_VALUE;
        int r12 = (r10 << 16) + (r11 << 8);
        return (((long) (r12 + (r5.readByte() & UByte.MAX_VALUE))) * 900) - 4575744000L;
    L5:
        return r5.readLong();
    }

    public static ZoneOffset readOffset(DataInput r5) throws IOException {
        byte r10 = r5.readByte();
        if (r10 != 127) goto L6;
        return ZoneOffset.ofTotalSeconds(r5.readInt());
    L6:
        return ZoneOffset.ofTotalSeconds(r10 * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    public static void write(Object r5, DataOutput r10) throws IOException {
        b(SZR, r5, r10);
    }

    public static void writeEpochSec(long r10, DataOutput r11) throws IOException {
        if (r10 >= (-4575744000L)) goto L5;
    L9:
        r11.writeByte(255);
        r11.writeLong(r10);
        return;
    L5:
        if (r10 >= 10413792000L) goto L9;
        if ((r10 % 900) != 0) goto L9;
        int r12 = (int) ((r10 + 4575744000L) / 900);
        r11.writeByte((r12 >>> 16) & 255);
        r11.writeByte((r12 >>> 8) & 255);
        r11.writeByte(r12 & 255);
    }

    public static void writeOffset(ZoneOffset r5, DataOutput r10) throws IOException {
        int r11 = r5.getTotalSeconds();
        if ((r11 % LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST) != 0) goto L5;
        int r12 = r11 / LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST;
    L6:
        r10.writeByte(r12);
        if (r12 != 127) goto L10;
        r10.writeInt(r11);
        return;
    L10:
        return;
    L5:
        r12 = 127;
        goto L6
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r5) throws IOException, ClassNotFoundException {
        byte r10 = r5.readByte();
        this.type = r10;
        this.object = a(r10, r5);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) throws IOException {
        b(this.type, this.object, r5);
    }

    public Ser(byte r5, Object r10) {
        this.type = r5;
        this.object = r10;
    }
}
