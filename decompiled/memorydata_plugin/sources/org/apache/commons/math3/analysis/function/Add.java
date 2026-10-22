package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.BivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
public class Add implements BivariateFunction {
    public Add() {
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r1, double r3) {
        return r1 + r3;
    }
}
