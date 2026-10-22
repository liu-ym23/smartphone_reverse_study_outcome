package org.apache.commons.math3.analysis.solvers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAbstractUnivariateSolver<FUNC extends UnivariateFunction> implements BaseUnivariateSolver<FUNC> {
    private final double absoluteAccuracy;
    private IntegerSequence.Incrementor evaluations;
    private FUNC function;
    private final double functionValueAccuracy;
    private final double relativeAccuracy;
    private double searchMax;
    private double searchMin;
    private double searchStart;

    public BaseAbstractUnivariateSolver(double r8) {
        this(1.0E-14d, r8, 1.0E-15d);
    }

    public BaseAbstractUnivariateSolver(double r1, double r3, double r5) {
        this.absoluteAccuracy = r3;
        this.relativeAccuracy = r1;
        this.functionValueAccuracy = r5;
        this.evaluations = IntegerSequence.Incrementor.create();
    }

    public double computeObjectiveValue(double r1) {
        incrementEvaluationCount();
        return this.function.value(r1);
    }

    public abstract double doSolve();

    public double getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    public double getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    public double getMax() {
        return this.searchMax;
    }

    public double getMin() {
        return this.searchMin;
    }

    public double getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    public double getStartValue() {
        return this.searchStart;
    }

    public void incrementEvaluationCount() {
        this.evaluations.increment();     // Catch: MaxCountExceededException -> L4
        return;
    L4:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }

    public void setup(int r3, FUNC r4, double r5, double r7, double r9) {
        FUNC r6 = (FUNC) ZeusTransformUtils.wrapperContextForParams(r4, UnivariateFunction.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r6);
        this.searchMin = r5;
        this.searchMax = r7;
        this.searchStart = r9;
        this.function = r6;
        this.evaluations = this.evaluations.withMaximalCount(r3).withStart(0);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int r10, FUNC r11, double r12, double r14) {
        return solve(r10, (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r11, UnivariateFunction.class, "com.obric.memorydata.plugin"), r12, r14, r12 + ((r14 - r12) * 0.5d));
    }

    public double solve(int r11, FUNC r12, double r13, double r15, double r17) {
        setup(r11, (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r12, UnivariateFunction.class, "com.obric.memorydata.plugin"), r13, r15, r17);
        return doSolve();
    }

    public void verifyBracketing(double r1, double r3) {
        UnivariateSolverUtils.verifyBracketing(this.function, r1, r3);
    }

    public void verifySequence(double r1, double r3, double r5) {
        UnivariateSolverUtils.verifySequence(r1, r3, r5);
    }
}
