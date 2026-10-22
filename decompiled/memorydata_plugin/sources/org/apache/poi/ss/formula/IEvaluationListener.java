package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
interface IEvaluationListener {

    public interface ICacheEntry {
    }

    void onCacheHit(int r1, int r2, int r3, ValueEval r4);

    void onEndEvaluate(ICacheEntry r1, ValueEval r2);

    void onReadPlainValue(int r1, int r2, int r3, ICacheEntry r4);

    void onStartEvaluate(EvaluationCell r1, ICacheEntry r2);
}
