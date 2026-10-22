package org.apache.poi.hssf.record.cf;

import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class BorderFormatting implements GenericRecord {
    private static final BitField bordBlTrtLineOnOff = null;
    private static final BitField bordBottomLineColor = null;
    private static final BitField bordBottomLineStyle = null;
    private static final BitField bordDiagLineColor = null;
    private static final BitField bordDiagLineStyle = null;
    private static final BitField bordLeftLineColor = null;
    private static final BitField bordLeftLineStyle = null;
    private static final BitField bordRightLineColor = null;
    private static final BitField bordRightLineStyle = null;
    private static final BitField bordTlBrLineOnOff = null;
    private static final BitField bordTopLineColor = null;
    private static final BitField bordTopLineStyle = null;
    private int field_13_border_styles1;
    private int field_14_border_styles2;

    static {
        bordLeftLineStyle = BitFieldFactory.getInstance(15);
        bordRightLineStyle = BitFieldFactory.getInstance(240);
        bordTopLineStyle = BitFieldFactory.getInstance(CaeNfcCardInfo.LIFE_CYCLE_INACTIVE);
        bordBottomLineStyle = BitFieldFactory.getInstance(61440);
        bordLeftLineColor = BitFieldFactory.getInstance(8323072);
        bordRightLineColor = BitFieldFactory.getInstance(1065353216);
        bordTlBrLineOnOff = BitFieldFactory.getInstance(1073741824);
        bordBlTrtLineOnOff = BitFieldFactory.getInstance(Integer.MIN_VALUE);
        bordTopLineColor = BitFieldFactory.getInstance(127);
        bordBottomLineColor = BitFieldFactory.getInstance(16256);
        bordDiagLineColor = BitFieldFactory.getInstance(2080768);
        bordDiagLineStyle = BitFieldFactory.getInstance(31457280);
    }

    public BorderFormatting() {
        this.field_13_border_styles1 = 0;
        this.field_14_border_styles2 = 0;
    }

    public BorderFormatting(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_13_border_styles1 = r4.readInt();
        this.field_14_border_styles2 = r4.readInt();
    }

    public int getBorderBottom() {
        return bordBottomLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderLeft() {
        return bordLeftLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderRight() {
        return bordRightLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderTop() {
        return bordTopLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBottomBorderColor() {
        return bordBottomLineColor.getValue(this.field_14_border_styles2);
    }

    public int getDataLength() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("borderLeft", new $$Lambda$i29izTfm7jtp86Bc2BrlSbgA5uM(this));
        r0.put("borderRight", new $$Lambda$fy6UAd0xKhw3pXe6QrUqTZRiARo(this));
        r0.put("borderTop", new $$Lambda$375ShFfe41Fht0fwsJZBM4Eh5I(this));
        r0.put("borderBottom", new $$Lambda$3tCb6WYBozOJiSQiNQ7KsFiV9s(this));
        r0.put("leftBorderColor", new $$Lambda$pmB6SE9jgxL_uTilnys82IEwJ0(this));
        r0.put("rightBorderColor", new $$Lambda$l30DxxHx4HwoTgVOPu3u9_Ln2o(this));
        r0.put("topBorderColor", new $$Lambda$yxVxo9efP1iKBXD66yQ_b7DqeKk(this));
        r0.put("bottomBorderColor", new $$Lambda$9k4qhaomhYzHopaqQ4eXss_JtA(this));
        r0.put("forwardDiagonalOn", new $$Lambda$oUmxLF32ktbdtA2LItd4Q40xSM8(this));
        r0.put("backwardDiagonalOn", new $$Lambda$MP61fdoHxJfdt7qMv7n8RjAbgw(this));
        return Collections.unmodifiableMap(r0);
    }

    public int getLeftBorderColor() {
        return bordLeftLineColor.getValue(this.field_13_border_styles1);
    }

    public int getRightBorderColor() {
        return bordRightLineColor.getValue(this.field_13_border_styles1);
    }

    public int getTopBorderColor() {
        return bordTopLineColor.getValue(this.field_14_border_styles2);
    }

    public boolean isBackwardDiagonalOn() {
        return bordTlBrLineOnOff.isSet(this.field_13_border_styles1);
    }

    public boolean isForwardDiagonalOn() {
        return bordBlTrtLineOnOff.isSet(this.field_13_border_styles1);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
