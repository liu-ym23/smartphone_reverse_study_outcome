package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class IntegerSequence {

    public static class Incrementor implements Iterator<Integer> {
        private static final MaxCountExceededCallback CALLBACK = null;
        private int count;
        private final int increment;
        private final int init;
        private final MaxCountExceededCallback maxCountCallback;
        private final int maximalCount;

        public interface MaxCountExceededCallback {
            void trigger(int r1);
        }

        static {
            CALLBACK = new AnonymousClass1();
        }

        private Incrementor(int r3, int r4, int r5, MaxCountExceededCallback r6) {
            MaxCountExceededCallback r7 = (MaxCountExceededCallback) ZeusTransformUtils.wrapperContextForParams(r6, MaxCountExceededCallback.class, "com.obric.memorydata.plugin");
            this.count = 0;
            if (r7 == null) goto L7;
            this.init = r3;
            this.maximalCount = r4;
            this.increment = r5;
            this.maxCountCallback = r7;
            this.count = r3;
            return;
        L7:
            throw new NullArgumentException();
        }

        public static Incrementor create() {
            return new Incrementor(0, 0, 1, CALLBACK);
        }

        public boolean canIncrement(int r4) {
            int r0 = this.count;
            int r1 = this.increment;
            int r2 = r0 + (r4 * r1);
            int r3 = this.maximalCount;
            if (r1 >= 0) goto L6;
            if (r2 <= r3) goto L9;
            return true;
        L9:
            return false;
        L6:
            if (r2 >= r3) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return canIncrement(0);
        }

        public void increment() {
            increment(1);
        }

        public void increment(int r3) {
            if (r3 <= 0) goto L9;
            if (canIncrement(0) == true) goto L6;
            this.maxCountCallback.trigger(this.maximalCount);
        L6:
            this.count += r3 * this.increment;
            return;
        L9:
            throw new NotStrictlyPositiveException(Integer.valueOf(r3));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int r0 = this.count;
            increment();
            return Integer.valueOf(r0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Integer next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException();
        }

        public Incrementor withMaximalCount(int r4) {
            return new Incrementor(this.init, r4, this.increment, this.maxCountCallback);
        }

        public Incrementor withStart(int r4) {
            return new Incrementor(r4, this.maximalCount, this.increment, this.maxCountCallback);
        }
    }
}
