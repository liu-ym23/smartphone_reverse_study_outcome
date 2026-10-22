package org.apache.commons.math3.geometry.enclosing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class EnclosingBall<S extends Space, P extends Point<S>> implements Serializable {
    private static final long serialVersionUID = 20140126;
    private final P center;
    private final double radius;
    private final P[] support;

    public EnclosingBall(P r3, double r4, P... r6) {
        this.center = (P) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin");
        this.radius = r4;
        this.support = (P[]) ((Point[]) ZeusTransformUtils.preCheckCast(r6.clone(), Point[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P r3) {
        if (((Point) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin")).distance(this.center) > this.radius) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P r3, double r4) {
        if (((Point) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin")).distance(this.center) > (this.radius + r4)) goto L5;
        return true;
    L5:
        return false;
    }

    public P getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

    public P[] getSupport() {
        return (P[]) ((Point[]) ZeusTransformUtils.preCheckCast(this.support.clone(), Point[].class, "com.obric.memorydata.plugin"));
    }

    public int getSupportSize() {
        return this.support.length;
    }
}
