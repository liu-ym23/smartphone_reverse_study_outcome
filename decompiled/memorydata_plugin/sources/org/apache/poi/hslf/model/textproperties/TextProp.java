package org.apache.poi.hslf.model.textproperties;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class TextProp implements GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int dataValue;
    private int maskInHeader;
    private String propName;
    private int sizeOfDataBlock;

    static {
    }

    public TextProp(int r1, int r2, String r3) {
        this.sizeOfDataBlock = r1;
        this.maskInHeader = r2;
        this.propName = r3;
        this.dataValue = 0;
    }

    public TextProp(TextProp r2) {
        this.sizeOfDataBlock = r2.sizeOfDataBlock;
        this.maskInHeader = r2.maskInHeader;
        this.propName = r2.propName;
        this.dataValue = r2.dataValue;
    }

    public TextProp copy() {
        return new TextProp(this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        TextProp r6 = (TextProp) ZeusTransformUtils.preCheckCast(r5, TextProp.class, "com.obric.memorydata.plugin");
        if (this.dataValue == r6.dataValue) goto L15;
        return false;
    L15:
        if (this.maskInHeader == r6.maskInHeader) goto L17;
        return false;
    L17:
        String r2 = this.propName;
        if (r2 != null) goto L23;
        if (r6.propName == null) goto L26;
        return false;
    L26:
        if (this.sizeOfDataBlock == r6.sizeOfDataBlock) goto L28;
        return false;
    L28:
        return true;
    L23:
        if (r2.equals(r6.propName) == true) goto L26;
        return false;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("sizeOfDataBlock", new $$Lambda$eqByyslZaHDWCNL7zIVp3Hskhrg(this), "propName", new $$Lambda$KuroqFl_d3EdDIH1tjYiH83E8t4(this), "dataValue", new $$Lambda$O0Ui8YdlSo8vehk4Qg9DevUOyHI(this), "maskInHeader", new $$Lambda$OVID1HgFadKLzGlS67EXmOH_CQ(this));
    }

    public int getMask() {
        return this.maskInHeader;
    }

    public String getName() {
        return this.propName;
    }

    public int getSize() {
        return this.sizeOfDataBlock;
    }

    public int getValue() {
        return this.dataValue;
    }

    public int getWriteMask() {
        return getMask();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.dataValue), Integer.valueOf(this.maskInHeader), this.propName, Integer.valueOf(this.sizeOfDataBlock)});
    }

    public void setValue(int r1) {
        this.dataValue = r1;
    }

    public String toString() {
        int r0 = getSize();
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L6;
        int r1 = 10;
    L9:
        return String.format(Locale.ROOT, "%s = %d (%0#" + r1 + "X mask / %d bytes)", new Object[]{getName(), Integer.valueOf(getValue()), Integer.valueOf(getMask()), Integer.valueOf(getSize())});
    L6:
        r1 = 6;
        goto L9
    L7:
        r1 = 4;
        goto L9
    }
}
