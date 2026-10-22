package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public interface IDStarAlgorithm {
    default boolean allowEmptyMatchField() {
        return false;
    }

    ValueEval getResult();

    boolean processMatch(ValueEval r1);
}
