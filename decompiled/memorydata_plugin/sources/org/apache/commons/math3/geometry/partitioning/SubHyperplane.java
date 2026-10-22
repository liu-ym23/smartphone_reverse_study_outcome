package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface SubHyperplane<S extends Space> {

    public static class SplitSubHyperplane<U extends Space> {
        private final SubHyperplane<U> minus;
        private final SubHyperplane<U> plus;

        public SplitSubHyperplane(SubHyperplane<U> r3, SubHyperplane<U> r4) {
            SubHyperplane<U> r5 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
            SubHyperplane<U> r6 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r4, SubHyperplane.class, "com.obric.memorydata.plugin");
            this.plus = r5;
            this.minus = r6;
        }

        public SubHyperplane<U> getMinus() {
            return this.minus;
        }

        public SubHyperplane<U> getPlus() {
            return this.plus;
        }

        public Side getSide() {
            SubHyperplane<U> r0 = this.plus;
            if (r0 != null) goto L5;
        L14:
            SubHyperplane<U> r1 = this.minus;
            if (r1 == null) goto L21;
            if (r1.isEmpty() == true) goto L21;
            return Side.MINUS;
        L21:
            return Side.HYPER;
        L5:
            if (r0.isEmpty() == true) goto L14;
            SubHyperplane<U> r2 = this.minus;
            if (r2 == null) goto L13;
            if (r2.isEmpty() == true) goto L13;
            return Side.BOTH;
        L13:
            return Side.PLUS;
        }
    }

    SubHyperplane<S> copySelf();

    Hyperplane<S> getHyperplane();

    boolean isEmpty();

    SubHyperplane<S> reunite(SubHyperplane<S> r1);

    SplitSubHyperplane<S> split(Hyperplane<S> r1);
}
