package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public class EventState {

    private static class LocalMaxCountExceededException extends RuntimeException {
        private static final long serialVersionUID = 20120901;
        private final MaxCountExceededException wrapped;

        LocalMaxCountExceededException(MaxCountExceededException r1) {
            this.wrapped = r1;
        }

        public MaxCountExceededException getException() {
            return this.wrapped;
        }
    }
}
