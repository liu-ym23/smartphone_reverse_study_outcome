package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class CFRule12Record extends CFRuleBase {
    private ColorGradientFormatting color_gradient;
    private DataBarFormatting data_bar;
    private byte[] ext_formatting_data;
    private int ext_formatting_length;
    private byte ext_opts;
    private byte[] filter_data;
    private Formula formula_scale;
    private FtrHeader futureHeader;
    private IconMultiStateFormatting multistate;
    private int priority;
    private byte template_param_length;
    private byte[] template_params;
    private int template_type;

    public CFRule12Record(RecordInputStream r8) {
        this.futureHeader = new FtrHeader(r8);
        setConditionType(r8.readByte());
        setComparisonOperation(r8.readByte());
        int r0 = r8.readUShort();
        int r1 = r8.readUShort();
        int r2 = r8.readInt();
        this.ext_formatting_length = r2;
        this.ext_formatting_data = new byte[0];
        if (r2 != 0) goto L5;
        r8.readUShort();
    L8:
        setFormula1(Formula.read(r0, r8));
        setFormula2(Formula.read(r1, r8));
        this.formula_scale = Formula.read(r8.readUShort(), r8);
        this.ext_opts = r8.readByte();
        this.priority = r8.readUShort();
        this.template_type = r8.readUShort();
        byte r3 = r8.readByte();
        this.template_param_length = r3;
        if (r3 != 0) goto L11;
    L14:
        byte[] r4 = IOUtils.safelyAllocate(r3, HSSFWorkbook.getMaxRecordLength());
        this.template_params = r4;
        r8.readFully(r4);
    L15:
        byte r5 = getConditionType();
        if (r5 != 3) goto L19;
        this.color_gradient = new ColorGradientFormatting(r8);
        return;
    L19:
        if (r5 != 4) goto L22;
        this.data_bar = new DataBarFormatting(r8);
        return;
    L22:
        if (r5 != 5) goto L25;
        this.filter_data = r8.readRemainder();
        return;
    L25:
        if (r5 != 6) goto L31;
        this.multistate = new IconMultiStateFormatting(r8);
        return;
    L31:
        return;
    L11:
        if (r3 == 16) goto L14;
        LOG.atWarn().a("CF Rule v12 template params length should be 0 or 16, found {}", v.a(this.template_param_length));
        r8.readRemainder();
        goto L15
    L5:
        long r6 = readFormatOptions(r8);
        int r7 = this.ext_formatting_length;
        if (r6 >= r7) goto L8;
        byte[] r9 = IOUtils.safelyAllocate(((long) r7) - r6, HSSFWorkbook.getMaxRecordLength());
        this.ext_formatting_data = r9;
        r8.readFully(r9);
        goto L8
    }

    public ColorGradientFormatting getColorGradientFormatting() {
        return this.color_gradient;
    }

    public DataBarFormatting getDataBarFormatting() {
        return this.data_bar;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = FtrHeader.getDataSize() + 6;
        if (this.ext_formatting_length != 0) goto L5;
        int r1 = r0 + 6;
    L6:
        int r2 = (((r1 + getFormulaSize(getFormula1())) + getFormulaSize(getFormula2())) + (getFormulaSize(this.formula_scale) + 2)) + (this.template_params.length + 6);
        byte r3 = getConditionType();
        if (r3 != 3) goto L10;
        int r5 = this.color_gradient.getDataLength();
    L17:
        return r2 + r5;
    L10:
        if (r3 != 4) goto L13;
        r5 = this.data_bar.getDataLength();
        goto L17
    L13:
        if (r3 != 5) goto L15;
        r5 = this.filter_data.length;
        goto L17
    L15:
        if (r3 != 6) goto L18;
        r5 = this.multistate.getDataLength();
        goto L17
    L18:
        return r2;
    L5:
        r1 = r0 + ((getFormattingBlockSize() + 4) + this.ext_formatting_data.length);
        goto L6
    }

    public FtrHeader getFutureHeader() {
        return this.futureHeader;
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap(super.getGenericProperties());
        r0.put("dxFn12Length", new $$Lambda$CFRule12Record$gRBdfGk9sVA2EAuSn9XjBsqFjlM(this));
        r0.put("futureHeader", new $$Lambda$BQwwmvvBug8A7Bn90npAk8nLqw(this));
        r0.put("dxFn12Ext", new $$Lambda$CFRule12Record$jTXOroMCItcZ30aTIueA8_BxWM(this));
        r0.put("formulaScale", new $$Lambda$qiM1XIceg4KjPRPfPKgx126Oxsc(this));
        r0.put("extOptions", new $$Lambda$CFRule12Record$FOuGd1gUVm2DZSwjzRteeNPl7I(this));
        r0.put("priority", new $$Lambda$5freOBjeNSAgYXBIcxjF5J2kBI(this));
        r0.put("templateType", new $$Lambda$CFRule12Record$ed_1aTTxjC53Ot6fMxyr2TRQ_gc(this));
        r0.put("templateParams", new $$Lambda$CFRule12Record$7H_PI_2ommZOW2U6gIC6WTxsz50(this));
        r0.put("filterData", new $$Lambda$CFRule12Record$60vEvpIH1ySFNazGS_M3YtsqIv0(this));
        r0.put("dataBar", new $$Lambda$HRbK0XlR_OIx7HT3IeN0gseMdQk(this));
        r0.put("multiState", new $$Lambda$7ReA_pWFWn6onGeMgHalNv2Ulk(this));
        r0.put("colorGradient", new $$Lambda$vQaxqidYl0REm8_blokoqw7ErkE(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_RULE_12;
    }

    public IconMultiStateFormatting getMultiStateFormatting() {
        return this.multistate;
    }

    public Ptg[] getParsedExpressionScale() {
        return this.formula_scale.getTokens();
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2170;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CFRule12Record() {
        return Integer.valueOf(this.ext_formatting_length);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$CFRule12Record() {
        return this.ext_formatting_data;
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$CFRule12Record() {
        return Byte.valueOf(this.ext_opts);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$CFRule12Record() {
        return Integer.valueOf(this.template_type);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$CFRule12Record() {
        return this.template_params;
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$CFRule12Record() {
        return this.filter_data;
    }
}
