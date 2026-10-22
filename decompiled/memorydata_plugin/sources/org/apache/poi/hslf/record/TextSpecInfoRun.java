package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class TextSpecInfoRun implements GenericRecord {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private static final BitField altLangFld = null;
    private static final BitField bidiFld = null;
    private static final BitField grammarErrorFld = null;
    private static final BitField langFld = null;
    private static final BitField pp10extFld = null;
    private static final BitField pp10runidFld = null;
    private static final BitField smartTagFld = null;
    private static final BitField spellFld = null;
    private short altLangId;
    private short bidi;
    private short langId;
    private int length;
    private int mask;
    private int pp10extMask;
    private byte[] smartTagsBytes;
    private short spellInfo;

    public static final enum SpellInfoEnum extends Enum<SpellInfoEnum> {
        private static final /* synthetic */ SpellInfoEnum[] $VALUES = null;
        public static final SpellInfoEnum clean = null;
        public static final SpellInfoEnum correct = null;
        public static final SpellInfoEnum error = null;
        public static final SpellInfoEnum grammar = null;
        final BitField bitField;

        static {
            SpellInfoEnum r0 = new SpellInfoEnum("error", 0, new BitField(1));
            error = r0;
            SpellInfoEnum r1 = new SpellInfoEnum("clean", 1, new BitField(2));
            clean = r1;
            SpellInfoEnum r3 = new SpellInfoEnum("grammar", 2, new BitField(4));
            grammar = r3;
            SpellInfoEnum r6 = new SpellInfoEnum("correct", 3, new BitField(0));
            correct = r6;
            $VALUES = new SpellInfoEnum[]{r0, r1, r3, r6};
        }

        private SpellInfoEnum(String r1, int r2, BitField r3) {
            super(r1, r2);
            this.bitField = r3;
        }

        public static SpellInfoEnum valueOf(String r2) {
            return (SpellInfoEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpellInfoEnum.class, r2), SpellInfoEnum.class, "com.obric.memorydata.plugin");
        }

        public static SpellInfoEnum[] values() {
            return (SpellInfoEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpellInfoEnum[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        spellFld = BitFieldFactory.getInstance(1);
        langFld = BitFieldFactory.getInstance(2);
        altLangFld = BitFieldFactory.getInstance(4);
        pp10extFld = BitFieldFactory.getInstance(32);
        bidiFld = BitFieldFactory.getInstance(64);
        smartTagFld = BitFieldFactory.getInstance(512);
        pp10runidFld = BitFieldFactory.getInstance(15);
        grammarErrorFld = BitFieldFactory.getInstance(Integer.MIN_VALUE);
        FLAGS_MASKS = new int[]{1, 2, 4, 32, 64, 512};
        FLAGS_NAMES = new String[]{"SPELL", "LANG", "ALT_LANG", "PP10_EXT", "BIDI", "SMART_TAG"};
    }

    public TextSpecInfoRun(int r2) {
        this.spellInfo = -1;
        this.langId = -1;
        this.altLangId = -1;
        this.bidi = -1;
        this.pp10extMask = -1;
        setLength(r2);
        setLangId(0);
    }

    public TextSpecInfoRun(LittleEndianByteArrayInputStream r6) {
        this.spellInfo = -1;
        this.langId = -1;
        this.altLangId = -1;
        this.bidi = -1;
        this.pp10extMask = -1;
        this.length = r6.readInt();
        int r0 = r6.readInt();
        this.mask = r0;
        if (spellFld.isSet(r0) == false) goto L6;
        this.spellInfo = r6.readShort();
    L6:
        if (langFld.isSet(this.mask) == false) goto L9;
        this.langId = r6.readShort();
    L9:
        if (altLangFld.isSet(this.mask) == false) goto L12;
        this.altLangId = r6.readShort();
    L12:
        if (bidiFld.isSet(this.mask) == false) goto L15;
        this.bidi = r6.readShort();
    L15:
        if (pp10extFld.isSet(this.mask) == false) goto L18;
        this.pp10extMask = r6.readInt();
    L18:
        if (smartTagFld.isSet(this.mask) == false) goto L21;
        int r1 = r6.readInt();
        byte[] r2 = IOUtils.safelyAllocate((((long) r1) * 4) + 4, RecordAtom.getMaxRecordLength());
        this.smartTagsBytes = r2;
        LittleEndian.putInt(r2, 0, r1);
        r6.readFully(this.smartTagsBytes, 4, r1 * 4);
        return;
    }

    public short getAltLangId() {
        return this.altLangId;
    }

    public Boolean getBidi() {
        short r1 = this.bidi;
        if (r1 != (-1)) goto L5;
        return null;
    L5:
        if (r1 == 0) goto L7;
        boolean r2 = true;
    L9:
        return Boolean.valueOf(r2);
    L7:
        r2 = false;
        goto L9
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$TextSpecInfoRun$yvM8lYd3lF8lEkz7Ak7OSFjEbg(this), FLAGS_MASKS, FLAGS_NAMES));
        r0.put("spellInfo", new $$Lambda$fuEW2XUF3qPOiUlZijPuc_YGw(this));
        r0.put("langId", new $$Lambda$0zD_iun86HperwL0nvGIYakWw(this));
        r0.put("altLangId", new $$Lambda$O4UHNAGKKnPFTUurXslUAWvNl0(this));
        r0.put("bidi", new $$Lambda$r4_qGIiKG90X_ZcvqLnPQBsVEtg(this));
        r0.put("pp10RunId", new $$Lambda$vXyjI5q68U1sHVdtWoekV6ZN2So(this));
        r0.put("grammarError", new $$Lambda$1woiiwppIElEgrnRAGgstOqKErE(this));
        r0.put("smartTags", new $$Lambda$Nb1McfzwQKTXCS0m4J_1uz59z_Y(this));
        return Collections.unmodifiableMap(r0);
    }

    public Boolean getGrammarError() {
        if (this.pp10extMask != (-1)) goto L5;
    L8:
        return null;
    L5:
        if (pp10extFld.isSet(this.mask) == false) goto L8;
        return Boolean.valueOf(grammarErrorFld.isSet(this.pp10extMask));
    }

    public short getLangId() {
        return this.langId;
    }

    public int getLength() {
        return this.length;
    }

    public int getPP10RunId() {
        if (this.pp10extMask != (-1)) goto L5;
        return -1;
    L5:
        if (pp10extFld.isSet(this.mask) == true) goto L8;
        return -1;
    L8:
        return pp10runidFld.getValue(this.pp10extMask);
    }

    public byte[] getSmartTagsBytes() {
        return this.smartTagsBytes;
    }

    public SpellInfoEnum getSpellInfo() {
        if (this.spellInfo != (-1)) goto L6;
        return null;
    L6:
        int r3 = 0;
        SpellInfoEnum[] r1 = {SpellInfoEnum.clean, SpellInfoEnum.error, SpellInfoEnum.grammar};
    L7:
        if (r3 >= 3) goto L13;
        SpellInfoEnum r2 = r1[r3];
        if (r2.bitField.isSet(this.spellInfo) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return r2;
    L13:
        return SpellInfoEnum.correct;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$TextSpecInfoRun() {
        return Integer.valueOf(this.mask);
    }

    public void setLangId(short r4) {
        this.langId = r4;
        BitField r0 = langFld;
        int r1 = this.mask;
        if (r4 == (-1)) goto L5;
        boolean r5 = true;
    L6:
        this.mask = r0.setBoolean(r1, r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public void setLength(int r1) {
        this.length = r1;
    }

    public void writeOut(OutputStream r14) {
        byte[] r2 = new byte[4];
        LittleEndian.putInt(r2, 0, this.length);
        r14.write(r2);
        LittleEndian.putInt(r2, 0, this.mask);
        r14.write(r2);
        Object[] r5 = {spellFld, Short.valueOf(this.spellInfo), "spell info", langFld, Short.valueOf(this.langId), "lang id", altLangFld, Short.valueOf(this.altLangId), "alt lang id", bidiFld, Short.valueOf(this.bidi), "bidi", pp10extFld, Integer.valueOf(this.pp10extMask), "pp10 extension field", smartTagFld, this.smartTagsBytes, "smart tags"};
        int r1 = 0;
    L3:
        if (r1 >= 17) goto L37;
        BitField r9 = (BitField) ZeusTransformUtils.preCheckCast(r5[r1 + 0], BitField.class, "com.obric.memorydata.plugin");
        Object r10 = r5[r1 + 1];
        if (r9.isSet(this.mask) == false) goto L36;
        if ((r10 instanceof byte[]) == false) goto L15;
        byte[] r11 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        if (r11.length <= 0) goto L12;
        boolean r12 = true;
    L13:
        r14.write(r11);
    L29:
        if (r12 == true) goto L36;
        int r3 = r1 + 2;
        if (r3 >= 18) goto L33;
        Object r13 = r5[r3];
    L35:
        throw new IOException(r13 + " is activated, but its value is invalid");
    L33:
        r13 = null;
        goto L35
    L12:
        r12 = false;
        goto L13
    L15:
        if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L22;
        int r15 = ((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r15 == (-1)) goto L19;
        r12 = true;
    L20:
        LittleEndian.putInt(r2, 0, r15);
        r14.write(r2);
        goto L29
    L19:
        r12 = false;
        goto L20
    L22:
        if (ZeusTransformUtils.instanceOf(r10, Short.class) == false) goto L28;
        short r16 = ((Short) ZeusTransformUtils.preCheckCast(r10, Short.class, "com.obric.memorydata.plugin")).shortValue();
        if (r16 == (-1)) goto L26;
        r12 = true;
    L27:
        LittleEndian.putShort(r2, 0, r16);
        r14.write(r2, 0, 2);
        goto L29
    L26:
        r12 = false;
        goto L27
    L28:
        r12 = false;
    L36:
        r1 = r1 + 3;
        goto L3
    }
}
