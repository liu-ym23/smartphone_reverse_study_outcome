package org.apache.commons.math3.ode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldODEState<T extends RealFieldElement<T>> {
    private final T[][] secondaryState;
    private final T[] state;
    private final T time;

    public FieldODEState(T r3, T[] r4, T[][] r5) {
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.time = r6;
        this.state = (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(r4.clone(), RealFieldElement[].class, "com.obric.memorydata.plugin"));
        this.secondaryState = (T[][]) copy(r6.getField(), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] copy(Field<T> r4, T[][] r5) {
        Field r3 = (Field) ZeusTransformUtils.wrapperContextForParams(r4, Field.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        T[][] r6 = (T[][]) ((RealFieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r3, r5.length, -1), RealFieldElement[][].class, "com.obric.memorydata.plugin"));
        int r7 = 0;
    L8:
        if (r7 >= r5.length) goto L10;
        r6[r7] = (RealFieldElement[]) ZeusTransformUtils.preCheckCast(r5[r7].clone(), RealFieldElement[].class, "com.obric.memorydata.plugin");
        r7 = r7 + 1;
        goto L8
    L10:
        return r6;
    L5:
        return (T[][]) ((RealFieldElement[][]) ZeusTransformUtils.preCheckCast(null, RealFieldElement[][].class, "com.obric.memorydata.plugin"));
    }

    public T[] getSecondaryState(int r2) {
        if (r2 != 0) goto L5;
        Object r1 = this.state.clone();
    L7:
        return (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(r1, RealFieldElement[].class, "com.obric.memorydata.plugin"));
    L5:
        r1 = this.secondaryState[r2 - 1].clone();
        goto L7
    }

    public T[] getState() {
        return (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(this.state.clone(), RealFieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public T getTime() {
        return this.time;
    }
}
