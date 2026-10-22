package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRegion<S extends Space, T extends Space> implements Region<S> {
    private final double tolerance;
    private BSPTree<S> tree;

    public AbstractRegion(double r3) {
        this.tree = new BSPTree(Boolean.TRUE);
        this.tolerance = r3;
    }

    public AbstractRegion(BSPTree<S> r1, double r2) {
        this.tree = r1;
        this.tolerance = r2;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public abstract AbstractRegion<S, T> buildNew(BSPTree<S> r1);

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public double getTolerance() {
        return this.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public BSPTree<S> getTree(boolean r2) {
        if (r2 == false) goto L9;
        if (this.tree.getCut() == null) goto L9;
        if (this.tree.getAttribute() != null) goto L9;
        this.tree.visit(new BoundaryBuilder());
    L9:
        return this.tree;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty() {
        return isEmpty(this.tree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty(BSPTree<S> r3) {
        if (r3.getCut() != null) goto L7;
        return !((Boolean) ZeusTransformUtils.preCheckCast(r3.getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L7:
        if (isEmpty(r3.getMinus()) == true) goto L9;
    L11:
        return false;
    L9:
        if (isEmpty(r3.getPlus()) == false) goto L11;
        return true;
    }
}
