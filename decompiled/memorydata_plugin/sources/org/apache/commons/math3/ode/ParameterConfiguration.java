package org.apache.commons.math3.ode;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
class ParameterConfiguration implements Serializable {
    private static final long serialVersionUID = 2247518849090889379L;
    private double hP;
    private String parameterName;

    ParameterConfiguration(String r1, double r2) {
        this.parameterName = r1;
        this.hP = r2;
    }

    public double getHP() {
        return this.hP;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setHP(double r1) {
        this.hP = r1;
    }
}
