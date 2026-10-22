package org.apache.commons.math3.geometry.spherical.oned;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class Sphere1D implements Serializable, Space {
    private static final long serialVersionUID = 20131218;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.spherical.oned.Sphere1D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final Sphere1D INSTANCE = null;

        static {
            INSTANCE = new Sphere1D(null);
        }

        static /* synthetic */ Sphere1D access$000() {
            return INSTANCE;
        }
    }

    public static class NoSubSpaceException extends MathUnsupportedOperationException {
        private static final long serialVersionUID = 20140225;

        public NoSubSpaceException() {
            super(LocalizedFormats.NOT_SUPPORTED_IN_DIMENSION_N, new Object[]{1});
        }
    }

    private Sphere1D() {
    }

    /* synthetic */ Sphere1D(AnonymousClass1 r1) {
        this();
    }

    public static Sphere1D getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public int getDimension() {
        return 1;
    }

    @Override // org.apache.commons.math3.geometry.Space
    public Space getSubSpace() {
        throw new NoSubSpaceException();
    }
}
