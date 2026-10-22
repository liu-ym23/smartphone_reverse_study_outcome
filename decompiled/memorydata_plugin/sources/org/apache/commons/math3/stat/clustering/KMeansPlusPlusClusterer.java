package org.apache.commons.math3.stat.clustering;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.stat.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {

    public static final enum EmptyClusterStrategy extends Enum<EmptyClusterStrategy> {
        private static final /* synthetic */ EmptyClusterStrategy[] $VALUES = null;
        public static final EmptyClusterStrategy ERROR = null;
        public static final EmptyClusterStrategy FARTHEST_POINT = null;
        public static final EmptyClusterStrategy LARGEST_POINTS_NUMBER = null;
        public static final EmptyClusterStrategy LARGEST_VARIANCE = null;

        static {
            EmptyClusterStrategy r0 = new EmptyClusterStrategy("LARGEST_VARIANCE", 0);
            LARGEST_VARIANCE = r0;
            EmptyClusterStrategy r1 = new EmptyClusterStrategy("LARGEST_POINTS_NUMBER", 1);
            LARGEST_POINTS_NUMBER = r1;
            EmptyClusterStrategy r3 = new EmptyClusterStrategy("FARTHEST_POINT", 2);
            FARTHEST_POINT = r3;
            EmptyClusterStrategy r5 = new EmptyClusterStrategy(CipherConst.LEVEL_ERROR, 3);
            ERROR = r5;
            $VALUES = new EmptyClusterStrategy[]{r0, r1, r3, r5};
        }

        private EmptyClusterStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyClusterStrategy valueOf(String r2) {
            return (EmptyClusterStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyClusterStrategy.class, r2), EmptyClusterStrategy.class, "com.obric.memorydata.plugin");
        }

        public static EmptyClusterStrategy[] values() {
            return (EmptyClusterStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyClusterStrategy[].class, "com.obric.memorydata.plugin");
        }
    }
}
