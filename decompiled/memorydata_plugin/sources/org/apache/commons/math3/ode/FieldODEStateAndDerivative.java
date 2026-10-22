package org.apache.commons.math3.ode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class FieldODEStateAndDerivative<T extends RealFieldElement<T>> extends FieldODEState<T> {
    private final T[] derivative;
    private final T[][] secondaryDerivative;

    public FieldODEStateAndDerivative(T r9, T[] r10, T[] r11) {
        this((RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r9, RealFieldElement.class, "com.obric.memorydata.plugin"), r10, r11, (RealFieldElement[][]) ZeusTransformUtils.preCheckCast(null, RealFieldElement[][].class, "com.obric.memorydata.plugin"), (RealFieldElement[][]) ZeusTransformUtils.preCheckCast(null, RealFieldElement[][].class, "com.obric.memorydata.plugin"));
    }

    public FieldODEStateAndDerivative(T r3, T[] r4, T[] r5, T[][] r6, T[][] r7) {
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r3, RealFieldElement.class, "com.obric.memorydata.plugin");
        super(r8, r4, r6);
        this.derivative = (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(r5.clone(), RealFieldElement[].class, "com.obric.memorydata.plugin"));
        this.secondaryDerivative = copy(r8.getField(), r7);
    }

    public T[] getDerivative() {
        return (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(this.derivative.clone(), RealFieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public T[] getSecondaryDerivative(int r2) {
        if (r2 != 0) goto L5;
        Object r1 = this.derivative.clone();
    L7:
        return (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(r1, RealFieldElement[].class, "com.obric.memorydata.plugin"));
    L5:
        r1 = this.secondaryDerivative[r2 - 1].clone();
        goto L7
    }
}
