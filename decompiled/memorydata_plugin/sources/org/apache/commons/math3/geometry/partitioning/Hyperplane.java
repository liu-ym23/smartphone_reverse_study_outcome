package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Hyperplane<S extends Space> {
    Hyperplane<S> copySelf();

    double getOffset(Point<S> r1);

    boolean sameOrientationAs(Hyperplane<S> r1);

    SubHyperplane<S> wholeHyperplane();

    Region<S> wholeSpace();
}
