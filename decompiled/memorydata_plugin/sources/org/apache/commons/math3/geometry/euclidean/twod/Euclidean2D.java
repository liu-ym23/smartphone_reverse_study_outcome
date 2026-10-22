package org.apache.commons.math3.geometry.euclidean.twod;

import java.io.Serializable;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;

/* JADX INFO: loaded from: classes6.dex */
public class Euclidean2D implements Serializable, Space {
    private static final long serialVersionUID = 4793432849757649566L;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final Euclidean2D INSTANCE = null;

        static {
            INSTANCE = new Euclidean2D(null);
        }

        static /* synthetic */ Euclidean2D access$000() {
            return INSTANCE;
        }
    }

    private Euclidean2D() {
    }

    /* synthetic */ Euclidean2D(AnonymousClass1 r1) {
        this();
    }

    public static Euclidean2D getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public int getDimension() {
        return 2;
    }

    @Override // org.apache.commons.math3.geometry.Space
    public /* bridge */ /* synthetic */ Space getSubSpace() {
        return getSubSpace();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public Euclidean1D getSubSpace() {
        return Euclidean1D.getInstance();
    }
}
