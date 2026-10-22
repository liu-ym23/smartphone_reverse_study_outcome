package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class PlainValueCellCacheEntry extends CellCacheEntry {
    public PlainValueCellCacheEntry(ValueEval r3) {
        updateValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"));
    }
}
