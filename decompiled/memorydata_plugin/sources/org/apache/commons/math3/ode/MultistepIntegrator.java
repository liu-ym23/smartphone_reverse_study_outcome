package org.apache.commons.math3.ode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MultistepIntegrator extends AdaptiveStepsizeIntegrator {

    private static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        InitializationCompletedMarkerException() {
            super((Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
        }
    }
}
