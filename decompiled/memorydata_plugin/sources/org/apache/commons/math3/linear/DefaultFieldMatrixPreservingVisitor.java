package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultFieldMatrixPreservingVisitor<T extends FieldElement<T>> implements FieldMatrixPreservingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixPreservingVisitor(T r3) {
        this.zero = (T) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public T end() {
        return this.zero;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public void visit(int r1, int r2, T r3) {
        FieldElement r0 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
    }
}
