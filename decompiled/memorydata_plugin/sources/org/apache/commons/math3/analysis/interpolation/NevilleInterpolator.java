package org.apache.commons.math3.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

/* JADX INFO: loaded from: classes6.dex */
public class NevilleInterpolator implements Serializable, UnivariateInterpolator {
    static final long serialVersionUID = 3003707660147873733L;

    public NevilleInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialFunctionLagrangeForm interpolate(double[] r1, double[] r2) {
        return new PolynomialFunctionLagrangeForm(r1, r2);
    }
}
