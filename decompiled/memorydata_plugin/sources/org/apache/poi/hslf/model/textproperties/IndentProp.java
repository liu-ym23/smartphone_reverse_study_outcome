package org.apache.poi.hslf.model.textproperties;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class IndentProp implements GenericRecord {
    private int charactersCovered;
    private short indentLevel;

    public IndentProp(int r1, short r2) {
        this.charactersCovered = r1;
        this.indentLevel = r2;
    }

    public int getCharactersCovered() {
        return this.charactersCovered;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("charactersCovered", new $$Lambda$YUESYLGLnnnjFsm4cWj6pSKosM(this), "indentLevel", new $$Lambda$Pu8mPuQ_L2Z_DqO7VcWp6MMQMCY(this));
    }

    public int getIndentLevel() {
        return this.indentLevel;
    }
}
