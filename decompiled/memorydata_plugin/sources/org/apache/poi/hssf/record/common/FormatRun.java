package org.apache.poi.hssf.record.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public class FormatRun implements Comparable<FormatRun>, GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final short _character;
    short _fontIndex;

    static {
    }

    public FormatRun(FormatRun r2) {
        this._character = r2._character;
        this._fontIndex = r2._fontIndex;
    }

    public FormatRun(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this(r4.readShort(), r4.readShort());
    }

    public FormatRun(short r1, short r2) {
        this._character = r1;
        this._fontIndex = r2;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(FormatRun r3) {
        return compareTo2((FormatRun) ZeusTransformUtils.preCheckCast(r3, FormatRun.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FormatRun r5) {
        short r0 = this._character;
        short r1 = r5._character;
        if (r0 == r1) goto L5;
    L8:
        if (r0 != r1) goto L12;
        return this._fontIndex - r5._fontIndex;
    L12:
        return r0 - r1;
    L5:
        if (this._fontIndex != r5._fontIndex) goto L8;
        return 0;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, FormatRun.class) == true) goto L5;
        return false;
    L5:
        FormatRun r5 = (FormatRun) ZeusTransformUtils.preCheckCast(r4, FormatRun.class, "com.obric.memorydata.plugin");
        if (this._character == r5._character) goto L8;
        return false;
    L8:
        if (this._fontIndex != r5._fontIndex) goto L12;
        return true;
    L12:
        return false;
    }

    public short getCharacterPos() {
        return this._character;
    }

    public short getFontIndex() {
        return this._fontIndex;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("characterPos", new $$Lambda$LmNM4K44FfWwEirlysOvsnkTRKA(this), "fontIndex", new $$Lambda$2mFPVzjmIIApG7XpNydt1_OOh8(this));
    }

    public int hashCode() {
        return 42;
    }

    public void serialize(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeShort(this._character);
        r4.writeShort(this._fontIndex);
    }

    public String toString() {
        return "character=" + this._character + ",fontIndex=" + this._fontIndex;
    }
}
