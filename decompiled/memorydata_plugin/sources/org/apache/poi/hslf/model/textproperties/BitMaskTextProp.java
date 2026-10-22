package org.apache.poi.hslf.model.textproperties;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BitMaskTextProp extends TextProp {
    protected static final c LOG = null;
    private final int[] subPropMasks;
    private final boolean[] subPropMatches;
    private final String[] subPropNames;

    static {
        LOG = b.a(BitMaskTextProp.class);
    }

    public BitMaskTextProp(int r1, int r2, String r3, String... r4) {
        super(r1, r2, r3);
        this.subPropNames = r4;
        this.subPropMasks = new int[r4.length];
        this.subPropMatches = new boolean[r4.length];
        int r5 = Integer.lowestOneBit(r2);
        int r6 = 0;
    L3:
        int[] r7 = this.subPropMasks;
        if (r6 >= r7.length) goto L6;
        r7[r6] = r5 << r6;
        r6 = r6 + 1;
        goto L3
    }

    public BitMaskTextProp(BitMaskTextProp r5) {
        super(r5);
        String[] r0 = r5.subPropNames;
        boolean[] r1 = null;
        if (r0 != null) goto L5;
        String[] r2 = null;
    L6:
        this.subPropNames = r2;
        int[] r3 = r5.subPropMasks;
        if (r3 != null) goto L9;
        int[] r4 = null;
    L10:
        this.subPropMasks = r4;
        boolean[] r6 = r5.subPropMatches;
        if (r6 == null) goto L14;
        r1 = (boolean[]) ZeusTransformUtils.preCheckCast(r6.clone(), boolean[].class, "com.obric.memorydata.plugin");
    L14:
        this.subPropMatches = r1;
        return;
    L9:
        r4 = (int[]) ZeusTransformUtils.preCheckCast(r3.clone(), int[].class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r2 = (String[]) ZeusTransformUtils.preCheckCast(r0.clone(), String[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    private int maskValue(int r8) {
        int[] r0 = this.subPropMasks;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r4 = r0[r2];
        int r6 = r3 + 1;
        if (this.subPropMatches[r3] == true) goto L7;
        r8 = r8 & (~r4);
    L7:
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L8:
        return r8;
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public abstract BitMaskTextProp copy();

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$BitMaskTextProp$yrYzpJj8v0rSvlKnDgkxzRRaAjg(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$BBPSdj372bxlWtTp1k6P6qXInv0(this), this.subPropMasks, this.subPropNames));
    }

    public boolean[] getSubPropMatches() {
        return this.subPropMatches;
    }

    public String[] getSubPropNames() {
        return this.subPropNames;
    }

    public boolean getSubValue(int r2) {
        if (this.subPropMatches[r2] == false) goto L7;
        int r0 = super.getValue();
        if ((this.subPropMasks[r2] & r0) == 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public int getValue() {
        return maskValue(super.getValue());
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public int getWriteMask() {
        int[] r0 = this.subPropMasks;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r5 = r0[r2];
        int r7 = r4 + 1;
        if (this.subPropMatches[r4] == false) goto L7;
        r3 = r3 | r5;
    L7:
        r2 = r2 + 1;
        r4 = r7;
        goto L3
    L8:
        return r3;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$BitMaskTextProp() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Message lambda$setValueWithMask$0$BitMaskTextProp(int r8) {
        StringBuilder r0 = new StringBuilder("The following style attributes of the '").append(getName()).append("' property will be ignored:\n");
        int[] r1 = this.subPropMasks;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L11;
        int r5 = r1[r3];
        if (this.subPropMatches[r4] == true) goto L9;
        if ((r5 & r8) == 0) goto L9;
        r0.append(this.subPropNames[r4]).append(",");
    L9:
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L3
    L11:
        return new SimpleMessage(r0);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public void setValue(int r9) {
        super.setValue(r9);
        int[] r0 = this.subPropMasks;
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r5 = r0[r3];
        boolean[] r6 = this.subPropMatches;
        int r7 = r4 + 1;
        if ((r5 & r9) == 0) goto L7;
        boolean r8 = true;
    L8:
        r6[r4] = r8;
        r3 = r3 + 1;
        r4 = r7;
        goto L3
    L7:
        r8 = false;
        goto L8
    }

    public void setValueWithMask(final int r4, int r5) {
        setWriteMask(r5);
        super.setValue(maskValue(r4));
        if (r4 == super.getValue()) goto L6;
        c r6 = LOG;
        r6.atWarn().a("Style properties of '{}' don't match mask - output will be sanitized", getName());
        r6.atDebug().a(new $$Lambda$BitMaskTextProp$RXQDjmC_HAk8jEkqVfGV4tAVh6U(this, r4));
        return;
    }

    public void setWriteMask(int r9) {
        int[] r0 = this.subPropMasks;
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r5 = r0[r3];
        boolean[] r6 = this.subPropMatches;
        int r7 = r4 + 1;
        if ((r5 & r9) == 0) goto L7;
        boolean r8 = true;
    L8:
        r6[r4] = r8;
        r3 = r3 + 1;
        r4 = r7;
        goto L3
    L7:
        r8 = false;
        goto L8
    }
}
