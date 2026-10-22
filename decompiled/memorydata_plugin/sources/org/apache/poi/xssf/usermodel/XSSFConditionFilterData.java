package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.x;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFConditionFilterData implements ConditionFilterData {
    private final x _cfRule;

    XSSFConditionFilterData(x r3) {
        this._cfRule = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getAboveAverage() {
        return this._cfRule.getAboveAverage();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getBottom() {
        return this._cfRule.getBottom();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getEqualAverage() {
        return this._cfRule.getEqualAverage();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getPercent() {
        return this._cfRule.getPercent();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public long getRank() {
        return this._cfRule.getRank();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public int getStdDev() {
        return this._cfRule.getStdDev();
    }
}
