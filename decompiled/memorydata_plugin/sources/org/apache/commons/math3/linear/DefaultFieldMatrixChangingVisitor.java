package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultFieldMatrixChangingVisitor<T extends FieldElement<T>> implements FieldMatrixChangingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixChangingVisitor(T r3) {
        this.zero = (T) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public T end() {
        return this.zero;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public T visit(int r1, int r2, T r3) {
        return (T) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
    }
}
