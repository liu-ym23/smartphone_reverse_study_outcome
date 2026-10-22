package org.apache.commons.math3.geometry.euclidean.twod;

import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: loaded from: classes6.dex */
public class PolygonsSet extends AbstractRegion<Euclidean2D, Euclidean1D> {
    @Deprecated
    public PolygonsSet() {
        this(1.0E-10d);
    }

    public PolygonsSet(double r1) {
        super(r1);
    }

    public PolygonsSet(BSPTree<Euclidean2D> r1, double r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public PolygonsSet buildNew(BSPTree<Euclidean2D> r4) {
        return new PolygonsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }
}
