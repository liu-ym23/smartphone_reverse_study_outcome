package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes8.dex */
final class Ser implements Externalizable {
    static final byte CHRONO_LOCALDATETIME_TYPE = 12;
    static final byte CHRONO_TYPE = 11;
    static final byte CHRONO_ZONEDDATETIME_TYPE = 13;
    static final byte HIJRAH_DATE_TYPE = 3;
    static final byte HIJRAH_ERA_TYPE = 4;
    static final byte JAPANESE_DATE_TYPE = 1;
    static final byte JAPANESE_ERA_TYPE = 2;
    static final byte MINGUO_DATE_TYPE = 5;
    static final byte MINGUO_ERA_TYPE = 6;
    static final byte THAIBUDDHIST_DATE_TYPE = 7;
    static final byte THAIBUDDHIST_ERA_TYPE = 8;
    private static final long serialVersionUID = 7857518227608961174L;
    private Object object;
    private byte type;

    public Ser() {
    }

    Ser(byte r1, Object r2) {
        this.type = r1;
        this.object = r2;
    }

    static Object read(ObjectInput r2) {
        ObjectInput r3 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r2, ObjectInput.class, "com.obric.memorydata.plugin");
        return readInternal(r3.readByte(), r3);
    }

    private static Object readInternal(byte r2, ObjectInput r3) {
        ObjectInput r4 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectInput.class, "com.obric.memorydata.plugin");
        switch(r2) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            default: goto L5;
        };
    L5:
        throw new StreamCorruptedException("Unknown serialized type");
    L7:
        return ChronoZonedDateTimeImpl.readExternal(r4);
    L9:
        return ChronoLocalDateTimeImpl.readExternal(r4);
    L11:
        return Chronology.readExternal(r4);
    L13:
        return ThaiBuddhistEra.readExternal(r4);
    L15:
        return ThaiBuddhistDate.readExternal(r4);
    L17:
        return MinguoEra.readExternal(r4);
    L19:
        return MinguoDate.readExternal(r4);
    L21:
        return HijrahEra.readExternal(r4);
    L23:
        return HijrahDate.readExternal(r4);
    L25:
        return JapaneseEra.readExternal(r4);
    L27:
        return JapaneseDate.readExternal(r4);
    }

    private Object readResolve() {
        return this.object;
    }

    private static void writeInternal(byte r2, Object r3, ObjectOutput r4) {
        ObjectOutput r5 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r4, ObjectOutput.class, "com.obric.memorydata.plugin");
        r5.writeByte(r2);
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        ((ChronoZonedDateTimeImpl) ZeusTransformUtils.preCheckCast(r3, ChronoZonedDateTimeImpl.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L7:
        ((ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDateTimeImpl.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L8:
        ((Chronology) ZeusTransformUtils.preCheckCast(r3, Chronology.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L9:
        ((ThaiBuddhistEra) ZeusTransformUtils.preCheckCast(r3, ThaiBuddhistEra.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L10:
        ((ThaiBuddhistDate) ZeusTransformUtils.preCheckCast(r3, ThaiBuddhistDate.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L11:
        ((MinguoEra) ZeusTransformUtils.preCheckCast(r3, MinguoEra.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L12:
        ((MinguoDate) ZeusTransformUtils.preCheckCast(r3, MinguoDate.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L13:
        ((HijrahEra) ZeusTransformUtils.preCheckCast(r3, HijrahEra.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L14:
        ((HijrahDate) ZeusTransformUtils.preCheckCast(r3, HijrahDate.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L15:
        ((JapaneseEra) ZeusTransformUtils.preCheckCast(r3, JapaneseEra.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L16:
        ((JapaneseDate) ZeusTransformUtils.preCheckCast(r3, JapaneseDate.class, "com.obric.memorydata.plugin")).writeExternal(r5);
        return;
    L5:
        throw new InvalidClassException("Unknown serialized type");
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
