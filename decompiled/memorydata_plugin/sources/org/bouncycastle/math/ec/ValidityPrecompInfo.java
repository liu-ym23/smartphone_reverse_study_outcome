package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
class ValidityPrecompInfo implements PreCompInfo {
    private boolean curveEquationPassed;
    private boolean failed;
    private boolean orderPassed;

    ValidityPrecompInfo() {
        this.failed = false;
        this.curveEquationPassed = false;
        this.orderPassed = false;
    }

    boolean hasCurveEquationPassed() {
        return this.curveEquationPassed;
    }

    boolean hasFailed() {
        return this.failed;
    }

    boolean hasOrderPassed() {
        return this.orderPassed;
    }

    void reportCurveEquationPassed() {
        this.curveEquationPassed = true;
    }

    void reportFailed() {
        this.failed = true;
    }

    void reportOrderPassed() {
        this.orderPassed = true;
    }
}
