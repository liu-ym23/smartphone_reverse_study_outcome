package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aj;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFConditionalFormatting implements ConditionalFormatting {
    private final aj _cf;
    private final XSSFSheet _sh;

    XSSFConditionalFormatting(XSSFSheet r3, aj r4) {
        this._cf = (aj) ZeusTransformUtils.wrapperContextForParams(r4, aj.class, "com.obric.memorydata.plugin");
        this._sh = r3;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        ArrayList r0 = new ArrayList();
        Iterator r5 = this._cf.getSqref().iterator();
    L3:
        int r2 = 0;
        if (r5.hasNext() == false) goto L9;
        String[] r1 = r5.next().toString().split(" ");
        int r3 = r1.length;
    L6:
        if (r2 >= r3) goto L3;
        r0.add(CellRangeAddress.valueOf(r1[r2]));
        r2 = r2 + 1;
        goto L6
    L9:
        return (CellRangeAddress[]) ZeusTransformUtils.preCheckCast(r0.toArray(new CellRangeAddress[0]), CellRangeAddress[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this._cf.sizeOfCfRuleArray();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public /* bridge */ /* synthetic */ ConditionalFormattingRule getRule(int r1) {
        return getRule(r1);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public XSSFConditionalFormattingRule getRule(int r3) {
        return new XSSFConditionalFormattingRule(this._sh, this._cf.getCfRuleArray(r3));
    }

    public String toString() {
        return this._cf.toString();
    }
}
