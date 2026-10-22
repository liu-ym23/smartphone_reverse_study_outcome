package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;

/* JADX INFO: loaded from: classes6.dex */
public class Euclidean3D implements Serializable, Space {
    private static final long serialVersionUID = 6249091865814886817L;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final Euclidean3D INSTANCE = null;

        static {
            INSTANCE = new Euclidean3D(null);
        }

        static /* synthetic */ Euclidean3D access$000() {
            return INSTANCE;
        }
    }

    private Euclidean3D() {
    }

    /* synthetic */ Euclidean3D(AnonymousClass1 r1) {
        this();
    }

    public static Euclidean3D getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public int getDimension() {
        return 3;
    }

    @Override // org.apache.commons.math3.geometry.Space
    public /* bridge */ /* synthetic */ Space getSubSpace() {
        return getSubSpace();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public Euclidean2D getSubSpace() {
        return Euclidean2D.getInstance();
    }
}
