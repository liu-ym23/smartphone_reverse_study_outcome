package org.apache.commons.math3.ode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ExpandableStatefulODE {
    private List<SecondaryComponent> components;
    private final FirstOrderDifferentialEquations primary;
    private final EquationsMapper primaryMapper;
    private final double[] primaryState;
    private final double[] primaryStateDot;

    private static class SecondaryComponent {
        private final SecondaryEquations equation;
        private final EquationsMapper mapper;
        private final double[] state;
        private final double[] stateDot;

        static /* synthetic */ EquationsMapper access$000(SecondaryComponent r0) {
            return r0.mapper;
        }

        static /* synthetic */ double[] access$100(SecondaryComponent r0) {
            return r0.state;
        }

        static /* synthetic */ double[] access$200(SecondaryComponent r0) {
            return r0.stateDot;
        }

        static /* synthetic */ SecondaryEquations access$300(SecondaryComponent r0) {
            return r0.equation;
        }
    }

    public void computeDerivatives(double r12, double[] r14, double[] r15) {
        this.primaryMapper.extractEquationData(r14, this.primaryState);
        this.primary.computeDerivatives(r12, this.primaryState, this.primaryStateDot);
        Iterator<SecondaryComponent> r0 = this.components.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SecondaryComponent r1 = (SecondaryComponent) ZeusTransformUtils.preCheckCast(r0.next(), SecondaryComponent.class, "com.obric.memorydata.plugin");
        SecondaryComponent.access$000(r1).extractEquationData(r14, SecondaryComponent.access$100(r1));
        SecondaryComponent.access$300(r1).computeDerivatives(r12, this.primaryState, this.primaryStateDot, SecondaryComponent.access$100(r1), SecondaryComponent.access$200(r1));
        SecondaryComponent.access$000(r1).insertEquationData(SecondaryComponent.access$200(r1), r15);
        goto L4
    L6:
        this.primaryMapper.insertEquationData(this.primaryStateDot, r15);
    }
}
