package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.EvaluationName;

/* JADX INFO: loaded from: classes7.dex */
public final class ExternalNameEval implements ValueEval {
    private final EvaluationName _name;

    public ExternalNameEval(EvaluationName r3) {
        this._name = (EvaluationName) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationName.class, "com.obric.memorydata.plugin");
    }

    public EvaluationName getName() {
        return this._name;
    }

    public String toString() {
        return getClass().getName() + " [" + this._name.getNameText() + "]";
    }
}
