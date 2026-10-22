package org.apache.commons.math3.geometry.euclidean.oned;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class Euclidean1D implements Serializable, Space {
    private static final long serialVersionUID = -1178039568877797126L;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final Euclidean1D INSTANCE = null;

        static {
            INSTANCE = new Euclidean1D(null);
        }

        static /* synthetic */ Euclidean1D access$000() {
            return INSTANCE;
        }
    }

    public static class NoSubSpaceException extends MathUnsupportedOperationException {
        private static final long serialVersionUID = 20140225;

        public NoSubSpaceException() {
            super(LocalizedFormats.NOT_SUPPORTED_IN_DIMENSION_N, new Object[]{1});
        }
    }

    private Euclidean1D() {
    }

    /* synthetic */ Euclidean1D(AnonymousClass1 r1) {
        this();
    }

    public static Euclidean1D getInstance() {
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
