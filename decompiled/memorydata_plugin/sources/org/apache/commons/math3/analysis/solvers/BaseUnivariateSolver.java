package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
public interface BaseUnivariateSolver<FUNC extends UnivariateFunction> {
    double solve(int r1, FUNC r2, double r3, double r5);
}
