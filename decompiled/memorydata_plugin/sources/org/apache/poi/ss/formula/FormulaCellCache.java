package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
final class FormulaCellCache {
    private final Map<Object, FormulaCellCacheEntry> _formulaEntriesByCell;

    public FormulaCellCacheEntry get(EvaluationCell r3) {
        EvaluationCell r4 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationCell.class, "com.obric.memorydata.plugin");
        return (FormulaCellCacheEntry) ZeusTransformUtils.preCheckCast(this._formulaEntriesByCell.get(r4.getIdentityKey()), FormulaCellCacheEntry.class, "com.obric.memorydata.plugin");
    }

    public void put(EvaluationCell r3, FormulaCellCacheEntry r4) {
        EvaluationCell r5 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationCell.class, "com.obric.memorydata.plugin");
        this._formulaEntriesByCell.put(r5.getIdentityKey(), r4);
    }
}
